package org.pwrd.paho.client.mqttv3.internal;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.EOFException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;
import org.pwrd.paho.client.mqttv3.MqttClientPersistence;
import org.pwrd.paho.client.mqttv3.MqttDeliveryToken;
import org.pwrd.paho.client.mqttv3.MqttException;
import org.pwrd.paho.client.mqttv3.MqttMessage;
import org.pwrd.paho.client.mqttv3.MqttPersistable;
import org.pwrd.paho.client.mqttv3.MqttPersistenceException;
import org.pwrd.paho.client.mqttv3.MqttPingSender;
import org.pwrd.paho.client.mqttv3.MqttToken;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttAck;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttConnack;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttConnect;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttPingReq;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttPingResp;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttPubAck;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttPubComp;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttPubRec;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttPubRel;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttPublish;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.pwrd.paho.client.mqttv3.logging.Logger;
import org.pwrd.paho.client.mqttv3.logging.LoggerFactory;

public class ClientState {
    private static final String CLASS_NAME = ClientState.class.getName();
    private static final int DEFAULT_MAX_INFLIGHT = 10;
    private static final int MAX_MSG_ID = 65535;
    private static final int MIN_MSG_ID = 1;
    private static final String PERSISTENCE_CONFIRMED_PREFIX = "sc-";
    private static final String PERSISTENCE_RECEIVED_PREFIX = "r-";
    private static final String PERSISTENCE_SENT_PREFIX = "s-";
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private int actualInFlight = 0;
    private CommsCallback callback = null;
    private boolean cleanSession;
    private ClientComms clientComms = null;
    private boolean connected = false;
    private int inFlightPubRels = 0;
    private Hashtable inUseMsgIds;
    private Hashtable inboundQoS2 = null;
    private long keepAlive;
    private long lastInboundActivity = 0;
    private long lastOutboundActivity = 0;
    private long lastPing = 0;
    private int maxInflight = 10;
    private int nextMsgId = 0;
    private Hashtable outboundQoS1 = null;
    private Hashtable outboundQoS2 = null;
    private volatile Vector pendingFlows;
    private volatile Vector pendingMessages;
    private MqttClientPersistence persistence;
    private MqttWireMessage pingCommand;
    private int pingOutstanding = 0;
    private Object pingOutstandingLock = new Object();
    private MqttPingSender pingSender = null;
    private Object queueLock = new Object();
    private Object quiesceLock = new Object();
    private boolean quiescing = false;
    private CommsTokenStore tokenStore;

    protected ClientState(MqttClientPersistence persistence2, CommsTokenStore tokenStore2, CommsCallback callback2, ClientComms clientComms2, MqttPingSender pingSender2) throws MqttException {
        log.setResourceName(clientComms2.getClient().getClientId());
        log.finer(CLASS_NAME, "<Init>", "");
        this.inUseMsgIds = new Hashtable();
        this.pendingMessages = new Vector(this.maxInflight);
        this.pendingFlows = new Vector();
        this.outboundQoS2 = new Hashtable();
        this.outboundQoS1 = new Hashtable();
        this.inboundQoS2 = new Hashtable();
        this.pingCommand = new MqttPingReq();
        this.inFlightPubRels = 0;
        this.actualInFlight = 0;
        this.persistence = persistence2;
        this.callback = callback2;
        this.tokenStore = tokenStore2;
        this.clientComms = clientComms2;
        this.pingSender = pingSender2;
        restoreState();
    }

    /* access modifiers changed from: protected */
    public void setKeepAliveSecs(long keepAliveSecs) {
        this.keepAlive = 1000 * keepAliveSecs;
    }

    /* access modifiers changed from: protected */
    public long getKeepAlive() {
        return this.keepAlive;
    }

    /* access modifiers changed from: protected */
    public void setCleanSession(boolean cleanSession2) {
        this.cleanSession = cleanSession2;
    }

    private String getSendPersistenceKey(MqttWireMessage message) {
        return PERSISTENCE_SENT_PREFIX + message.getMessageId();
    }

    private String getSendConfirmPersistenceKey(MqttWireMessage message) {
        return PERSISTENCE_CONFIRMED_PREFIX + message.getMessageId();
    }

    private String getReceivedPersistenceKey(MqttWireMessage message) {
        return PERSISTENCE_RECEIVED_PREFIX + message.getMessageId();
    }

    /* access modifiers changed from: protected */
    public void clearState() throws MqttException {
        log.fine(CLASS_NAME, "clearState", SimpleComparison.GREATER_THAN_OPERATION);
        this.persistence.clear();
        this.inUseMsgIds.clear();
        this.pendingMessages.clear();
        this.pendingFlows.clear();
        this.outboundQoS2.clear();
        this.outboundQoS1.clear();
        this.inboundQoS2.clear();
        this.tokenStore.clear();
    }

    private MqttWireMessage restoreMessage(String key, MqttPersistable persistable) throws MqttException {
        MqttWireMessage message = null;
        try {
            message = MqttWireMessage.createWireMessage(persistable);
        } catch (MqttException ex) {
            log.fine(CLASS_NAME, "restoreMessage", "602", new Object[]{key}, ex);
            if (!(ex.getCause() instanceof EOFException)) {
                throw ex;
            } else if (key != null) {
                this.persistence.remove(key);
            }
        }
        log.fine(CLASS_NAME, "restoreMessage", "601", new Object[]{key, message});
        return message;
    }

    private void insertInOrder(Vector list, MqttWireMessage newMsg) {
        int newMsgId = newMsg.getMessageId();
        for (int i = 0; i < list.size(); i++) {
            if (((MqttWireMessage) list.elementAt(i)).getMessageId() > newMsgId) {
                list.insertElementAt(newMsg, i);
                return;
            }
        }
        list.addElement(newMsg);
    }

    private Vector reOrder(Vector list) {
        Vector newList = new Vector();
        if (list.size() != 0) {
            int previousMsgId = 0;
            int largestGap = 0;
            int largestGapMsgIdPosInList = 0;
            for (int i = 0; i < list.size(); i++) {
                int currentMsgId = ((MqttWireMessage) list.elementAt(i)).getMessageId();
                if (currentMsgId - previousMsgId > largestGap) {
                    largestGap = currentMsgId - previousMsgId;
                    largestGapMsgIdPosInList = i;
                }
                previousMsgId = currentMsgId;
            }
            if ((65535 - previousMsgId) + ((MqttWireMessage) list.elementAt(0)).getMessageId() > largestGap) {
                largestGapMsgIdPosInList = 0;
            }
            for (int i2 = largestGapMsgIdPosInList; i2 < list.size(); i2++) {
                newList.addElement(list.elementAt(i2));
            }
            for (int i3 = 0; i3 < largestGapMsgIdPosInList; i3++) {
                newList.addElement(list.elementAt(i3));
            }
        }
        return newList;
    }

    /* access modifiers changed from: protected */
    public void restoreState() throws MqttException {
        Enumeration messageKeys = this.persistence.keys();
        int highestMsgId = this.nextMsgId;
        Vector orphanedPubRels = new Vector();
        log.fine(CLASS_NAME, "restoreState", "600");
        while (messageKeys.hasMoreElements()) {
            String key = (String) messageKeys.nextElement();
            MqttWireMessage message = restoreMessage(key, this.persistence.get(key));
            if (message != null) {
                if (key.startsWith(PERSISTENCE_RECEIVED_PREFIX)) {
                    log.fine(CLASS_NAME, "restoreState", "604", new Object[]{key, message});
                    this.inboundQoS2.put(new Integer(message.getMessageId()), message);
                } else if (key.startsWith(PERSISTENCE_SENT_PREFIX)) {
                    MqttPublish sendMessage = (MqttPublish) message;
                    highestMsgId = Math.max(sendMessage.getMessageId(), highestMsgId);
                    if (this.persistence.containsKey(getSendConfirmPersistenceKey(sendMessage))) {
                        MqttPubRel confirmMessage = (MqttPubRel) restoreMessage(key, this.persistence.get(getSendConfirmPersistenceKey(sendMessage)));
                        if (confirmMessage != null) {
                            log.fine(CLASS_NAME, "restoreState", "605", new Object[]{key, message});
                            this.outboundQoS2.put(new Integer(confirmMessage.getMessageId()), confirmMessage);
                        } else {
                            log.fine(CLASS_NAME, "restoreState", "606", new Object[]{key, message});
                        }
                    } else {
                        sendMessage.setDuplicate(true);
                        if (sendMessage.getMessage().getQos() == 2) {
                            log.fine(CLASS_NAME, "restoreState", "607", new Object[]{key, message});
                            this.outboundQoS2.put(new Integer(sendMessage.getMessageId()), sendMessage);
                        } else {
                            log.fine(CLASS_NAME, "restoreState", "608", new Object[]{key, message});
                            this.outboundQoS1.put(new Integer(sendMessage.getMessageId()), sendMessage);
                        }
                    }
                    this.tokenStore.restoreToken(sendMessage).internalTok.setClient(this.clientComms.getClient());
                    this.inUseMsgIds.put(new Integer(sendMessage.getMessageId()), new Integer(sendMessage.getMessageId()));
                } else if (key.startsWith(PERSISTENCE_CONFIRMED_PREFIX) && !this.persistence.containsKey(getSendPersistenceKey((MqttPubRel) message))) {
                    orphanedPubRels.addElement(key);
                }
            }
        }
        Enumeration messageKeys2 = orphanedPubRels.elements();
        while (messageKeys2.hasMoreElements()) {
            String key2 = (String) messageKeys2.nextElement();
            log.fine(CLASS_NAME, "restoreState", "609", new Object[]{key2});
            this.persistence.remove(key2);
        }
        this.nextMsgId = highestMsgId;
    }

    private void restoreInflightMessages() {
        this.pendingMessages = new Vector(this.maxInflight);
        this.pendingFlows = new Vector();
        Enumeration keys = this.outboundQoS2.keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            MqttWireMessage msg = (MqttWireMessage) this.outboundQoS2.get(key);
            if (msg instanceof MqttPublish) {
                log.fine(CLASS_NAME, "restoreInflightMessages", "610", new Object[]{key});
                msg.setDuplicate(true);
                insertInOrder(this.pendingMessages, (MqttPublish) msg);
            } else if (msg instanceof MqttPubRel) {
                log.fine(CLASS_NAME, "restoreInflightMessages", "611", new Object[]{key});
                insertInOrder(this.pendingFlows, (MqttPubRel) msg);
            }
        }
        Enumeration keys2 = this.outboundQoS1.keys();
        while (keys2.hasMoreElements()) {
            Object key2 = keys2.nextElement();
            MqttPublish msg2 = (MqttPublish) this.outboundQoS1.get(key2);
            msg2.setDuplicate(true);
            log.fine(CLASS_NAME, "restoreInflightMessages", "612", new Object[]{key2});
            insertInOrder(this.pendingMessages, msg2);
        }
        this.pendingFlows = reOrder(this.pendingFlows);
        this.pendingMessages = reOrder(this.pendingMessages);
    }

    public void send(MqttWireMessage message, MqttToken token) throws MqttException {
        if (message.isMessageIdRequired() && message.getMessageId() == 0) {
            message.setMessageId(getNextMessageId());
        }
        if (token != null) {
            try {
                token.internalTok.setMessageID(message.getMessageId());
            } catch (Exception e) {
            }
        }
        if (message instanceof MqttPublish) {
            synchronized (this.queueLock) {
                if (this.actualInFlight >= this.maxInflight) {
                    log.fine(CLASS_NAME, "send", "613", new Object[]{new Integer(this.actualInFlight)});
                    throw new MqttException(32202);
                }
                MqttMessage innerMessage = ((MqttPublish) message).getMessage();
                log.fine(CLASS_NAME, "send", "628", new Object[]{new Integer(message.getMessageId()), new Integer(innerMessage.getQos()), message});
                switch (innerMessage.getQos()) {
                    case 1:
                        this.outboundQoS1.put(new Integer(message.getMessageId()), message);
                        this.persistence.put(getSendPersistenceKey(message), (MqttPublish) message);
                        break;
                    case 2:
                        this.outboundQoS2.put(new Integer(message.getMessageId()), message);
                        this.persistence.put(getSendPersistenceKey(message), (MqttPublish) message);
                        break;
                }
                this.tokenStore.saveToken(token, message);
                this.pendingMessages.addElement(message);
                this.queueLock.notifyAll();
            }
            return;
        }
        log.fine(CLASS_NAME, "send", "615", new Object[]{new Integer(message.getMessageId()), message});
        if (message instanceof MqttConnect) {
            synchronized (this.queueLock) {
                this.tokenStore.saveToken(token, message);
                this.pendingFlows.insertElementAt(message, 0);
                this.queueLock.notifyAll();
            }
            return;
        }
        if (message instanceof MqttPingReq) {
            this.pingCommand = message;
        } else if (message instanceof MqttPubRel) {
            this.outboundQoS2.put(new Integer(message.getMessageId()), message);
            this.persistence.put(getSendConfirmPersistenceKey(message), (MqttPubRel) message);
        } else if (message instanceof MqttPubComp) {
            this.persistence.remove(getReceivedPersistenceKey(message));
        }
        synchronized (this.queueLock) {
            if (!(message instanceof MqttAck)) {
                this.tokenStore.saveToken(token, message);
            }
            this.pendingFlows.addElement(message);
            this.queueLock.notifyAll();
        }
    }

    /* access modifiers changed from: protected */
    public void undo(MqttPublish message) throws MqttPersistenceException {
        synchronized (this.queueLock) {
            log.fine(CLASS_NAME, "undo", "618", new Object[]{new Integer(message.getMessageId()), new Integer(message.getMessage().getQos())});
            if (message.getMessage().getQos() == 1) {
                this.outboundQoS1.remove(new Integer(message.getMessageId()));
            } else {
                this.outboundQoS2.remove(new Integer(message.getMessageId()));
            }
            this.pendingMessages.removeElement(message);
            this.persistence.remove(getSendPersistenceKey(message));
            this.tokenStore.removeToken(message);
            checkQuiesceLock();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        if (r20.connected == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0032, code lost:
        if (r20.keepAlive <= 0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        r6 = java.lang.System.currentTimeMillis();
        r11 = r20.pingOutstandingLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
        monitor-enter(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
        if (r20.pingOutstanding <= 0) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0056, code lost:
        if ((r6 - r20.lastInboundActivity) < (r20.keepAlive + ((long) 100))) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0058, code lost:
        org.pwrd.paho.client.mqttv3.internal.ClientState.log.severe(org.pwrd.paho.client.mqttv3.internal.ClientState.CLASS_NAME, "checkForActivity", "619", new java.lang.Object[]{new java.lang.Long(r20.keepAlive), new java.lang.Long(r20.lastOutboundActivity), new java.lang.Long(r20.lastInboundActivity), new java.lang.Long(r6), new java.lang.Long(r20.lastPing)});
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00b3, code lost:
        throw org.pwrd.paho.client.mqttv3.internal.ExceptionHelper.createMqttException(32000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b4, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b5, code lost:
        monitor-exit(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b6, code lost:
        throw r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00be, code lost:
        if (r20.pingOutstanding != 0) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d2, code lost:
        if ((r6 - r20.lastOutboundActivity) < (2 * r20.keepAlive)) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d4, code lost:
        org.pwrd.paho.client.mqttv3.internal.ClientState.log.severe(org.pwrd.paho.client.mqttv3.internal.ClientState.CLASS_NAME, "checkForActivity", "642", new java.lang.Object[]{new java.lang.Long(r20.keepAlive), new java.lang.Long(r20.lastOutboundActivity), new java.lang.Long(r20.lastInboundActivity), new java.lang.Long(r6), new java.lang.Long(r20.lastPing)});
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x012f, code lost:
        throw org.pwrd.paho.client.mqttv3.internal.ExceptionHelper.createMqttException(32002);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0134, code lost:
        if (r20.pingOutstanding != 0) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0147, code lost:
        if ((r6 - r20.lastInboundActivity) >= (r20.keepAlive - ((long) 100))) goto L_0x015c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x015a, code lost:
        if ((r6 - r20.lastOutboundActivity) < (r20.keepAlive - ((long) 100))) goto L_0x01e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x015c, code lost:
        org.pwrd.paho.client.mqttv3.internal.ClientState.log.fine(org.pwrd.paho.client.mqttv3.internal.ClientState.CLASS_NAME, "checkForActivity", "620", new java.lang.Object[]{new java.lang.Long(r20.keepAlive), new java.lang.Long(r20.lastOutboundActivity), new java.lang.Long(r20.lastInboundActivity)});
        r9 = new org.pwrd.paho.client.mqttv3.MqttToken(r20.clientComms.getClient().getClientId());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r20.tokenStore.saveToken(r9, r20.pingCommand);
        r20.pendingFlows.insertElementAt(r20.pingCommand, 0);
        r4 = getKeepAlive();
        notifyQueueLock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01c6, code lost:
        r8 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x01c7, code lost:
        monitor-exit(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x01c8, code lost:
        org.pwrd.paho.client.mqttv3.internal.ClientState.log.fine(org.pwrd.paho.client.mqttv3.internal.ClientState.CLASS_NAME, "checkForActivity", "624", new java.lang.Object[]{new java.lang.Long(r4)});
        r20.pingSender.schedule(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01e9, code lost:
        org.pwrd.paho.client.mqttv3.internal.ClientState.log.fine(org.pwrd.paho.client.mqttv3.internal.ClientState.CLASS_NAME, "checkForActivity", "634", null);
        r4 = java.lang.Math.max(1L, getKeepAlive() - (r6 - r20.lastOutboundActivity));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x020a, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        r8 = null;
        r4 = getKeepAlive();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.pwrd.paho.client.mqttv3.MqttToken checkForActivity() throws org.pwrd.paho.client.mqttv3.MqttException {
        /*
        // Method dump skipped, instructions count: 526
        */
        throw new UnsupportedOperationException("Method not decompiled: org.pwrd.paho.client.mqttv3.internal.ClientState.checkForActivity():org.pwrd.paho.client.mqttv3.MqttToken");
    }

    /* access modifiers changed from: protected */
    public MqttWireMessage get() throws MqttException {
        MqttWireMessage result = null;
        synchronized (this.queueLock) {
            while (result == null) {
                if ((this.pendingMessages.isEmpty() && this.pendingFlows.isEmpty()) || (this.pendingFlows.isEmpty() && this.actualInFlight >= this.maxInflight)) {
                    try {
                        log.fine(CLASS_NAME, "get", "644");
                        this.queueLock.wait();
                        log.fine(CLASS_NAME, "get", "647");
                    } catch (InterruptedException e) {
                    }
                }
                if (!this.connected && (this.pendingFlows.isEmpty() || !(((MqttWireMessage) this.pendingFlows.elementAt(0)) instanceof MqttConnect))) {
                    log.fine(CLASS_NAME, "get", "621");
                    return null;
                } else if (!this.pendingFlows.isEmpty()) {
                    result = (MqttWireMessage) this.pendingFlows.remove(0);
                    if (result instanceof MqttPubRel) {
                        this.inFlightPubRels++;
                        log.fine(CLASS_NAME, "get", "617", new Object[]{new Integer(this.inFlightPubRels)});
                    }
                    checkQuiesceLock();
                } else if (!this.pendingMessages.isEmpty()) {
                    if (this.actualInFlight < this.maxInflight) {
                        result = (MqttWireMessage) this.pendingMessages.elementAt(0);
                        this.pendingMessages.removeElementAt(0);
                        this.actualInFlight++;
                        log.fine(CLASS_NAME, "get", "623", new Object[]{new Integer(this.actualInFlight)});
                    } else {
                        log.fine(CLASS_NAME, "get", "622");
                    }
                }
            }
            return result;
        }
    }

    public void setKeepAliveInterval(long interval) {
        this.keepAlive = interval;
    }

    public void notifySentBytes(int sentBytesCount) {
        if (sentBytesCount > 0) {
            this.lastOutboundActivity = System.currentTimeMillis();
        }
        log.fine(CLASS_NAME, "notifySentBytes", "631", new Object[]{new Integer(sentBytesCount)});
    }

    /* access modifiers changed from: protected */
    public void notifySent(MqttWireMessage message) {
        this.lastOutboundActivity = System.currentTimeMillis();
        log.fine(CLASS_NAME, "notifySent", "625", new Object[]{message.getKey()});
        MqttToken token = this.tokenStore.getToken(message);
        token.internalTok.notifySent();
        if (message instanceof MqttPingReq) {
            synchronized (this.pingOutstandingLock) {
                long time = System.currentTimeMillis();
                synchronized (this.pingOutstandingLock) {
                    this.lastPing = time;
                    this.pingOutstanding++;
                }
                log.fine(CLASS_NAME, "notifySent", "635", new Object[]{new Integer(this.pingOutstanding)});
            }
        } else if ((message instanceof MqttPublish) && ((MqttPublish) message).getMessage().getQos() == 0) {
            token.internalTok.markComplete(null, null);
            this.callback.asyncOperationComplete(token);
            decrementInFlight();
            releaseMessageId(message.getMessageId());
            this.tokenStore.removeToken(message);
            checkQuiesceLock();
        }
    }

    private void decrementInFlight() {
        synchronized (this.queueLock) {
            this.actualInFlight--;
            log.fine(CLASS_NAME, "decrementInFlight", "646", new Object[]{new Integer(this.actualInFlight)});
            if (!checkQuiesceLock()) {
                this.queueLock.notifyAll();
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkQuiesceLock() {
        int tokC = this.tokenStore.count();
        if (!this.quiescing || tokC != 0 || this.pendingFlows.size() != 0 || !this.callback.isQuiesced()) {
            return false;
        }
        log.fine(CLASS_NAME, "checkQuiesceLock", "626", new Object[]{new Boolean(this.quiescing), new Integer(this.actualInFlight), new Integer(this.pendingFlows.size()), new Integer(this.inFlightPubRels), Boolean.valueOf(this.callback.isQuiesced()), new Integer(tokC)});
        synchronized (this.quiesceLock) {
            this.quiesceLock.notifyAll();
        }
        return true;
    }

    public void notifyReceivedBytes(int receivedBytesCount) {
        if (receivedBytesCount > 0) {
            this.lastInboundActivity = System.currentTimeMillis();
        }
        log.fine(CLASS_NAME, "notifyReceivedBytes", "630", new Object[]{new Integer(receivedBytesCount)});
    }

    /* access modifiers changed from: protected */
    public void notifyReceivedAck(MqttAck ack) throws MqttException {
        this.lastInboundActivity = System.currentTimeMillis();
        log.fine(CLASS_NAME, "notifyReceivedAck", "627", new Object[]{new Integer(ack.getMessageId()), ack});
        MqttToken token = this.tokenStore.getToken(ack);
        if (ack instanceof MqttPubRec) {
            send(new MqttPubRel((MqttPubRec) ack), token);
        } else if ((ack instanceof MqttPubAck) || (ack instanceof MqttPubComp)) {
            notifyResult(ack, token, null);
        } else if (ack instanceof MqttPingResp) {
            synchronized (this.pingOutstandingLock) {
                this.pingOutstanding = Math.max(0, this.pingOutstanding - 1);
                notifyResult(ack, token, null);
                if (this.pingOutstanding == 0) {
                    this.tokenStore.removeToken(ack);
                }
            }
            log.fine(CLASS_NAME, "notifyReceivedAck", "636", new Object[]{new Integer(this.pingOutstanding)});
        } else if (ack instanceof MqttConnack) {
            int rc = ((MqttConnack) ack).getReturnCode();
            if (rc == 0) {
                synchronized (this.queueLock) {
                    if (this.cleanSession) {
                        clearState();
                        this.tokenStore.saveToken(token, ack);
                    }
                    this.inFlightPubRels = 0;
                    this.actualInFlight = 0;
                    restoreInflightMessages();
                    connected();
                }
                this.clientComms.connectComplete((MqttConnack) ack, null);
                notifyResult(ack, token, null);
                this.tokenStore.removeToken(ack);
                synchronized (this.queueLock) {
                    this.queueLock.notifyAll();
                }
            } else {
                throw ExceptionHelper.createMqttException(rc);
            }
        } else {
            notifyResult(ack, token, null);
            releaseMessageId(ack.getMessageId());
            this.tokenStore.removeToken(ack);
        }
        checkQuiesceLock();
    }

    /* access modifiers changed from: protected */
    public void notifyReceivedMsg(MqttWireMessage message) throws MqttException {
        this.lastInboundActivity = System.currentTimeMillis();
        log.fine(CLASS_NAME, "notifyReceivedMsg", "651", new Object[]{new Integer(message.getMessageId()), message});
        if (this.quiescing) {
            return;
        }
        if (message instanceof MqttPublish) {
            MqttPublish send = (MqttPublish) message;
            switch (send.getMessage().getQos()) {
                case 0:
                case 1:
                    if (this.callback != null) {
                        this.callback.messageArrived(send);
                        return;
                    }
                    return;
                case 2:
                    this.persistence.put(getReceivedPersistenceKey(message), (MqttPublish) message);
                    this.inboundQoS2.put(new Integer(send.getMessageId()), send);
                    send(new MqttPubRec(send), null);
                    return;
                default:
                    return;
            }
        } else if (message instanceof MqttPubRel) {
            MqttPublish sendMsg = (MqttPublish) this.inboundQoS2.get(new Integer(message.getMessageId()));
            if (sendMsg == null) {
                send(new MqttPubComp(message.getMessageId()), null);
            } else if (this.callback != null) {
                this.callback.messageArrived(sendMsg);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void notifyComplete(MqttToken token) throws MqttException {
        MqttWireMessage message = token.internalTok.getWireMessage();
        if (message != null && (message instanceof MqttAck)) {
            log.fine(CLASS_NAME, "notifyComplete", "629", new Object[]{new Integer(message.getMessageId()), token, message});
            MqttAck ack = (MqttAck) message;
            if (ack instanceof MqttPubAck) {
                this.persistence.remove(getSendPersistenceKey(message));
                this.outboundQoS1.remove(new Integer(ack.getMessageId()));
                decrementInFlight();
                releaseMessageId(message.getMessageId());
                this.tokenStore.removeToken(message);
                log.fine(CLASS_NAME, "notifyComplete", "650", new Object[]{new Integer(ack.getMessageId())});
            } else if (ack instanceof MqttPubComp) {
                this.persistence.remove(getSendPersistenceKey(message));
                this.persistence.remove(getSendConfirmPersistenceKey(message));
                this.outboundQoS2.remove(new Integer(ack.getMessageId()));
                this.inFlightPubRels--;
                decrementInFlight();
                releaseMessageId(message.getMessageId());
                this.tokenStore.removeToken(message);
                log.fine(CLASS_NAME, "notifyComplete", "645", new Object[]{new Integer(ack.getMessageId()), new Integer(this.inFlightPubRels)});
            }
            checkQuiesceLock();
        }
    }

    /* access modifiers changed from: protected */
    public void notifyResult(MqttWireMessage ack, MqttToken token, MqttException ex) {
        token.internalTok.markComplete(ack, ex);
        if (ack != null && (ack instanceof MqttAck) && !(ack instanceof MqttPubRec)) {
            log.fine(CLASS_NAME, "notifyResult", "648", new Object[]{token.internalTok.getKey(), ack, ex});
            this.callback.asyncOperationComplete(token);
        }
        if (ack == null) {
            log.fine(CLASS_NAME, "notifyResult", "649", new Object[]{token.internalTok.getKey(), ex});
            this.callback.asyncOperationComplete(token);
        }
    }

    public void connected() {
        log.fine(CLASS_NAME, "connected", "631");
        this.connected = true;
        this.pingSender.start();
    }

    public Vector resolveOldTokens(MqttException reason) {
        log.fine(CLASS_NAME, "resolveOldTokens", "632", new Object[]{reason});
        MqttException shutReason = reason;
        if (reason == null) {
            shutReason = new MqttException(32102);
        }
        Vector outT = this.tokenStore.getOutstandingTokens();
        Enumeration outTE = outT.elements();
        while (outTE.hasMoreElements()) {
            MqttToken tok = (MqttToken) outTE.nextElement();
            synchronized (tok) {
                if (!tok.isComplete() && !tok.internalTok.isCompletePending() && tok.getException() == null) {
                    tok.internalTok.setException(shutReason);
                }
            }
            if (!(tok instanceof MqttDeliveryToken)) {
                this.tokenStore.removeToken(tok.internalTok.getKey());
            }
        }
        return outT;
    }

    public void disconnected(MqttException reason) {
        log.fine(CLASS_NAME, "disconnected", "633", new Object[]{reason});
        this.connected = false;
        try {
            if (this.cleanSession) {
                clearState();
            }
            this.pendingMessages.clear();
            this.pendingFlows.clear();
            synchronized (this.pingOutstandingLock) {
                this.pingOutstanding = 0;
            }
        } catch (MqttException e) {
        }
    }

    private synchronized void releaseMessageId(int msgId) {
        this.inUseMsgIds.remove(new Integer(msgId));
    }

    private synchronized int getNextMessageId() throws MqttException {
        int startingMessageId = this.nextMsgId;
        int loopCount = 0;
        do {
            this.nextMsgId++;
            if (this.nextMsgId > 65535) {
                this.nextMsgId = 1;
            }
            if (this.nextMsgId == startingMessageId && (loopCount = loopCount + 1) == 2) {
                throw ExceptionHelper.createMqttException(32001);
            }
        } while (this.inUseMsgIds.containsKey(new Integer(this.nextMsgId)));
        Integer id = new Integer(this.nextMsgId);
        this.inUseMsgIds.put(id, id);
        return this.nextMsgId;
    }

    public void quiesce(long timeout) {
        if (timeout > 0) {
            log.fine(CLASS_NAME, "quiesce", "637", new Object[]{new Long(timeout)});
            synchronized (this.queueLock) {
                this.quiescing = true;
            }
            this.callback.quiesce();
            notifyQueueLock();
            synchronized (this.quiesceLock) {
                try {
                    int tokc = this.tokenStore.count();
                    if (tokc > 0 || this.pendingFlows.size() > 0 || !this.callback.isQuiesced()) {
                        log.fine(CLASS_NAME, "quiesce", "639", new Object[]{new Integer(this.actualInFlight), new Integer(this.pendingFlows.size()), new Integer(this.inFlightPubRels), new Integer(tokc)});
                        this.quiesceLock.wait(timeout);
                    }
                } catch (InterruptedException e) {
                }
            }
            synchronized (this.queueLock) {
                this.pendingMessages.clear();
                this.pendingFlows.clear();
                this.quiescing = false;
                this.actualInFlight = 0;
            }
            log.fine(CLASS_NAME, "quiesce", "640");
        }
    }

    public void notifyQueueLock() {
        synchronized (this.queueLock) {
            log.fine(CLASS_NAME, "notifyQueueLock", "638");
            this.queueLock.notifyAll();
        }
    }

    /* access modifiers changed from: protected */
    public void deliveryComplete(MqttPublish message) throws MqttPersistenceException {
        log.fine(CLASS_NAME, "deliveryComplete", "641", new Object[]{new Integer(message.getMessageId())});
        this.persistence.remove(getReceivedPersistenceKey(message));
        this.inboundQoS2.remove(new Integer(message.getMessageId()));
    }

    /* access modifiers changed from: protected */
    public void close() {
        this.inUseMsgIds.clear();
        this.pendingMessages.clear();
        this.pendingFlows.clear();
        this.outboundQoS2.clear();
        this.outboundQoS1.clear();
        this.inboundQoS2.clear();
        this.tokenStore.clear();
        this.inUseMsgIds = null;
        this.pendingMessages = null;
        this.pendingFlows = null;
        this.outboundQoS2 = null;
        this.outboundQoS1 = null;
        this.inboundQoS2 = null;
        this.tokenStore = null;
        this.callback = null;
        this.clientComms = null;
        this.persistence = null;
        this.pingCommand = null;
    }

    public Properties getDebug() {
        Properties props = new Properties();
        props.put("In use msgids", this.inUseMsgIds);
        props.put("pendingMessages", this.pendingMessages);
        props.put("pendingFlows", this.pendingFlows);
        props.put("maxInflight", new Integer(this.maxInflight));
        props.put("nextMsgID", new Integer(this.nextMsgId));
        props.put("actualInFlight", new Integer(this.actualInFlight));
        props.put("inFlightPubRels", new Integer(this.inFlightPubRels));
        props.put("quiescing", Boolean.valueOf(this.quiescing));
        props.put("pingoutstanding", new Integer(this.pingOutstanding));
        props.put("lastOutboundActivity", new Long(this.lastOutboundActivity));
        props.put("lastInboundActivity", new Long(this.lastInboundActivity));
        props.put("outboundQoS2", this.outboundQoS2);
        props.put("outboundQoS1", this.outboundQoS1);
        props.put("inboundQoS2", this.inboundQoS2);
        props.put("tokens", this.tokenStore);
        return props;
    }
}
