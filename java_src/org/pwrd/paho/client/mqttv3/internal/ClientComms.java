package org.pwrd.paho.client.mqttv3.internal;

import java.util.Enumeration;
import java.util.Properties;
import org.pwrd.paho.client.mqttv3.IMqttAsyncClient;
import org.pwrd.paho.client.mqttv3.MqttCallback;
import org.pwrd.paho.client.mqttv3.MqttClientPersistence;
import org.pwrd.paho.client.mqttv3.MqttConnectOptions;
import org.pwrd.paho.client.mqttv3.MqttDeliveryToken;
import org.pwrd.paho.client.mqttv3.MqttException;
import org.pwrd.paho.client.mqttv3.MqttPersistenceException;
import org.pwrd.paho.client.mqttv3.MqttPingSender;
import org.pwrd.paho.client.mqttv3.MqttToken;
import org.pwrd.paho.client.mqttv3.MqttTopic;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttConnack;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttConnect;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttDisconnect;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttPublish;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.pwrd.paho.client.mqttv3.logging.Logger;
import org.pwrd.paho.client.mqttv3.logging.LoggerFactory;

public class ClientComms {
    public static String BUILD_LEVEL = "L${build.level}";
    private static final String CLASS_NAME = ClientComms.class.getName();
    private static final byte CLOSED = 4;
    private static final byte CONNECTED = 0;
    private static final byte CONNECTING = 1;
    private static final byte DISCONNECTED = 3;
    private static final byte DISCONNECTING = 2;
    public static String VERSION = "${project.version}";
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private CommsCallback callback;
    private IMqttAsyncClient client;
    private ClientState clientState;
    private boolean closePending;
    private Object conLock;
    private MqttConnectOptions conOptions;
    private byte conState;
    private int networkModuleIndex;
    private NetworkModule[] networkModules;
    private MqttClientPersistence persistence;
    private MqttPingSender pingSender;
    private CommsReceiver receiver;
    private CommsSender sender;
    private boolean stoppingComms;
    private CommsTokenStore tokenStore;

    public ClientComms(IMqttAsyncClient client2, MqttClientPersistence persistence2, MqttPingSender pingSender2) throws MqttException {
        this.stoppingComms = false;
        this.conState = 3;
        this.conLock = new Object();
        this.closePending = false;
        this.conState = 3;
        this.client = client2;
        this.persistence = persistence2;
        this.pingSender = pingSender2;
        this.pingSender.init(this);
        this.tokenStore = new CommsTokenStore(getClient().getClientId());
        this.callback = new CommsCallback(this);
        this.clientState = new ClientState(persistence2, this.tokenStore, this.callback, this, pingSender2);
        this.callback.setClientState(this.clientState);
        log.setResourceName(getClient().getClientId());
    }

    /* access modifiers changed from: package-private */
    public CommsReceiver getReceiver() {
        return this.receiver;
    }

    /* access modifiers changed from: package-private */
    public void internalSend(MqttWireMessage message, MqttToken token) throws MqttException {
        log.fine(CLASS_NAME, "internalSend", "200", new Object[]{message.getKey(), message, token});
        if (token.getClient() == null) {
            token.internalTok.setClient(getClient());
            try {
                this.clientState.send(message, token);
            } catch (MqttException e) {
                if (message instanceof MqttPublish) {
                    this.clientState.undo((MqttPublish) message);
                }
                throw e;
            }
        } else {
            log.fine(CLASS_NAME, "internalSend", "213", new Object[]{message.getKey(), message, token});
            throw new MqttException(32201);
        }
    }

    public void sendNoWait(MqttWireMessage message, MqttToken token) throws MqttException {
        if (isConnected() || ((!isConnected() && (message instanceof MqttConnect)) || (isDisconnecting() && (message instanceof MqttDisconnect)))) {
            internalSend(message, token);
        } else {
            log.fine(CLASS_NAME, "sendNoWait", "208");
            throw ExceptionHelper.createMqttException(32104);
        }
    }

    public void close() throws MqttException {
        synchronized (this.conLock) {
            if (!isClosed()) {
                if (!isDisconnected()) {
                    log.fine(CLASS_NAME, "close", "224");
                    if (isConnecting()) {
                        throw new MqttException(32110);
                    } else if (isConnected()) {
                        throw ExceptionHelper.createMqttException(32100);
                    } else if (isDisconnecting()) {
                        this.closePending = true;
                        return;
                    }
                }
                this.conState = 4;
                this.clientState.close();
                this.clientState = null;
                this.callback = null;
                this.persistence = null;
                this.sender = null;
                this.pingSender = null;
                this.receiver = null;
                this.networkModules = null;
                this.conOptions = null;
                this.tokenStore = null;
            }
        }
    }

    public void connect(MqttConnectOptions options, MqttToken token) throws MqttException {
        synchronized (this.conLock) {
            if (!isDisconnected() || this.closePending) {
                log.fine(CLASS_NAME, "connect", "207", new Object[]{new Byte(this.conState)});
                if (isClosed() || this.closePending) {
                    throw new MqttException(32111);
                } else if (isConnecting()) {
                    throw new MqttException(32110);
                } else if (isDisconnecting()) {
                    throw new MqttException(32102);
                } else {
                    throw ExceptionHelper.createMqttException(32100);
                }
            } else {
                log.fine(CLASS_NAME, "connect", "214");
                this.conState = 1;
                this.conOptions = options;
                MqttConnect connect = new MqttConnect(this.client.getClientId(), options.getMqttVersion(), options.isCleanSession(), options.getKeepAliveInterval(), options.getUserName(), options.getPassword(), options.getWillMessage(), options.getWillDestination());
                this.clientState.setKeepAliveSecs((long) options.getKeepAliveInterval());
                this.clientState.setCleanSession(options.isCleanSession());
                this.tokenStore.open();
                new ConnectBG(this, token, connect).start();
            }
        }
    }

    public void connectComplete(MqttConnack cack, MqttException mex) throws MqttException {
        int rc = cack.getReturnCode();
        synchronized (this.conLock) {
            if (rc == 0) {
                log.fine(CLASS_NAME, "connectComplete", "215");
                this.conState = 0;
                return;
            }
            log.fine(CLASS_NAME, "connectComplete", "204", new Object[]{new Integer(rc)});
            throw mex;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r12 == null) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
        if (r12.isComplete() != false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
        r12.internalTok.setException(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0040, code lost:
        if (r11.callback == null) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0042, code lost:
        r11.callback.stop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0049, code lost:
        if (r11.networkModules == null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004b, code lost:
        r2 = r11.networkModules[r11.networkModuleIndex];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0051, code lost:
        if (r2 == null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0053, code lost:
        r2.stop();
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008a A[Catch:{ Exception -> 0x00dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0092 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void shutdownConnection(org.pwrd.paho.client.mqttv3.MqttToken r12, org.pwrd.paho.client.mqttv3.MqttException r13) {
        /*
        // Method dump skipped, instructions count: 228
        */
        throw new UnsupportedOperationException("Method not decompiled: org.pwrd.paho.client.mqttv3.internal.ClientComms.shutdownConnection(org.pwrd.paho.client.mqttv3.MqttToken, org.pwrd.paho.client.mqttv3.MqttException):void");
    }

    private MqttToken handleOldTokens(MqttToken token, MqttException reason) {
        log.fine(CLASS_NAME, "handleOldTokens", "222");
        MqttToken tokToNotifyLater = null;
        if (token != null) {
            try {
                if (this.tokenStore.getToken(token.internalTok.getKey()) == null) {
                    this.tokenStore.saveToken(token, token.internalTok.getKey());
                }
            } catch (Exception e) {
            }
        }
        Enumeration toksToNotE = this.clientState.resolveOldTokens(reason).elements();
        while (toksToNotE.hasMoreElements()) {
            MqttToken tok = (MqttToken) toksToNotE.nextElement();
            if (tok.internalTok.getKey().equals(MqttDisconnect.KEY) || tok.internalTok.getKey().equals("Con")) {
                tokToNotifyLater = tok;
            } else {
                this.callback.asyncOperationComplete(tok);
            }
        }
        return tokToNotifyLater;
    }

    public void disconnect(MqttDisconnect disconnect, long quiesceTimeout, MqttToken token) throws MqttException {
        synchronized (this.conLock) {
            if (isClosed()) {
                log.fine(CLASS_NAME, "disconnect", "223");
                throw ExceptionHelper.createMqttException(32111);
            } else if (isDisconnected()) {
                log.fine(CLASS_NAME, "disconnect", "211");
                throw ExceptionHelper.createMqttException(32101);
            } else if (isDisconnecting()) {
                log.fine(CLASS_NAME, "disconnect", "219");
                throw ExceptionHelper.createMqttException(32102);
            } else if (Thread.currentThread() == this.callback.getThread()) {
                log.fine(CLASS_NAME, "disconnect", "210");
                throw ExceptionHelper.createMqttException(32107);
            } else {
                log.fine(CLASS_NAME, "disconnect", "218");
                this.conState = 2;
                new DisconnectBG(disconnect, quiesceTimeout, token).start();
            }
        }
    }

    public void disconnectForcibly(long quiesceTimeout, long disconnectTimeout) throws MqttException {
        this.clientState.quiesce(quiesceTimeout);
        MqttToken token = new MqttToken(this.client.getClientId());
        try {
            internalSend(new MqttDisconnect(), token);
            token.waitForCompletion(disconnectTimeout);
        } catch (Exception e) {
        } finally {
            token.internalTok.markComplete(null, null);
            shutdownConnection(token, null);
        }
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.conLock) {
            z = this.conState == 0;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z = true;
        synchronized (this.conLock) {
            if (this.conState != 1) {
                z = false;
            }
        }
        return z;
    }

    public boolean isDisconnected() {
        boolean z;
        synchronized (this.conLock) {
            z = this.conState == 3;
        }
        return z;
    }

    public boolean isDisconnecting() {
        boolean z;
        synchronized (this.conLock) {
            z = this.conState == 2;
        }
        return z;
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this.conLock) {
            z = this.conState == 4;
        }
        return z;
    }

    public void setCallback(MqttCallback mqttCallback) {
        this.callback.setCallback(mqttCallback);
    }

    /* access modifiers changed from: protected */
    public MqttTopic getTopic(String topic) {
        return new MqttTopic(topic, this);
    }

    public void setNetworkModuleIndex(int index) {
        this.networkModuleIndex = index;
    }

    public int getNetworkModuleIndex() {
        return this.networkModuleIndex;
    }

    public NetworkModule[] getNetworkModules() {
        return this.networkModules;
    }

    public void setNetworkModules(NetworkModule[] networkModules2) {
        this.networkModules = networkModules2;
    }

    public MqttDeliveryToken[] getPendingDeliveryTokens() {
        return this.tokenStore.getOutstandingDelTokens();
    }

    /* access modifiers changed from: protected */
    public void deliveryComplete(MqttPublish msg) throws MqttPersistenceException {
        this.clientState.deliveryComplete(msg);
    }

    public IMqttAsyncClient getClient() {
        return this.client;
    }

    public long getKeepAlive() {
        return this.clientState.getKeepAlive();
    }

    public ClientState getClientState() {
        return this.clientState;
    }

    public MqttConnectOptions getConOptions() {
        return this.conOptions;
    }

    public Properties getDebug() {
        Properties props = new Properties();
        props.put("conState", new Integer(this.conState));
        props.put("serverURI", getClient().getServerURI());
        props.put("callback", this.callback);
        props.put("stoppingComms", new Boolean(this.stoppingComms));
        return props;
    }

    private class ConnectBG implements Runnable {
        Thread cBg = null;
        ClientComms clientComms = null;
        MqttConnect conPacket;
        MqttToken conToken;

        ConnectBG(ClientComms cc, MqttToken cToken, MqttConnect cPacket) {
            this.clientComms = cc;
            this.conToken = cToken;
            this.conPacket = cPacket;
            this.cBg = new Thread(this, "MQTT Con: " + ClientComms.this.getClient().getClientId());
        }

        /* access modifiers changed from: package-private */
        public void start() {
            this.cBg.start();
        }

        public void run() {
            MqttDeliveryToken[] toks;
            MqttException mqttEx = null;
            ClientComms.log.fine(ClientComms.CLASS_NAME, "connectBG:run", "220");
            try {
                for (MqttDeliveryToken mqttDeliveryToken : ClientComms.this.tokenStore.getOutstandingDelTokens()) {
                    mqttDeliveryToken.internalTok.setException(null);
                }
                ClientComms.this.tokenStore.saveToken(this.conToken, this.conPacket);
                NetworkModule networkModule = ClientComms.this.networkModules[ClientComms.this.networkModuleIndex];
                networkModule.start();
                ClientComms.this.receiver = new CommsReceiver(this.clientComms, ClientComms.this.clientState, ClientComms.this.tokenStore, networkModule.getInputStream());
                ClientComms.this.receiver.start("MQTT Rec: " + ClientComms.this.getClient().getClientId());
                ClientComms.this.sender = new CommsSender(this.clientComms, ClientComms.this.clientState, ClientComms.this.tokenStore, networkModule.getOutputStream());
                ClientComms.this.sender.start("MQTT Snd: " + ClientComms.this.getClient().getClientId());
                ClientComms.this.callback.start("MQTT Call: " + ClientComms.this.getClient().getClientId());
                ClientComms.this.internalSend(this.conPacket, this.conToken);
            } catch (MqttException ex) {
                ClientComms.log.fine(ClientComms.CLASS_NAME, "connectBG:run", "212", null, ex);
                mqttEx = ex;
            } catch (Exception ex2) {
                ClientComms.log.fine(ClientComms.CLASS_NAME, "connectBG:run", "209", null, ex2);
                mqttEx = ExceptionHelper.createMqttException(ex2);
            }
            if (mqttEx != null) {
                ClientComms.this.shutdownConnection(this.conToken, mqttEx);
            }
        }
    }

    /* access modifiers changed from: private */
    public class DisconnectBG implements Runnable {
        Thread dBg = null;
        MqttDisconnect disconnect;
        long quiesceTimeout;
        MqttToken token;

        DisconnectBG(MqttDisconnect disconnect2, long quiesceTimeout2, MqttToken token2) {
            this.disconnect = disconnect2;
            this.quiesceTimeout = quiesceTimeout2;
            this.token = token2;
        }

        /* access modifiers changed from: package-private */
        public void start() {
            this.dBg = new Thread(this, "MQTT Disc: " + ClientComms.this.getClient().getClientId());
            this.dBg.start();
        }

        public void run() {
            ClientComms.log.fine(ClientComms.CLASS_NAME, "disconnectBG:run", "221");
            ClientComms.this.clientState.quiesce(this.quiesceTimeout);
            try {
                ClientComms.this.internalSend(this.disconnect, this.token);
                this.token.internalTok.waitUntilSent();
            } catch (MqttException e) {
            } finally {
                this.token.internalTok.markComplete(null, null);
                ClientComms.this.shutdownConnection(this.token, null);
            }
        }
    }

    public MqttToken checkForActivity() {
        try {
            return this.clientState.checkForActivity();
        } catch (MqttException e) {
            handleRunException(e);
            return null;
        } catch (Exception e2) {
            handleRunException(e2);
            return null;
        }
    }

    private void handleRunException(Exception ex) {
        MqttException mex;
        log.fine(CLASS_NAME, "handleRunException", "804", null, ex);
        if (!(ex instanceof MqttException)) {
            mex = new MqttException(32109, ex);
        } else {
            mex = (MqttException) ex;
        }
        shutdownConnection(null, mex);
    }
}
