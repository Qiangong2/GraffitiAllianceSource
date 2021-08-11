package org.pwrd.paho.client.mqttv3.internal;

import java.util.Vector;
import org.pwrd.paho.client.mqttv3.IMqttActionListener;
import org.pwrd.paho.client.mqttv3.MqttCallback;
import org.pwrd.paho.client.mqttv3.MqttDeliveryToken;
import org.pwrd.paho.client.mqttv3.MqttException;
import org.pwrd.paho.client.mqttv3.MqttToken;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttPubAck;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttPubComp;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttPublish;
import org.pwrd.paho.client.mqttv3.logging.Logger;
import org.pwrd.paho.client.mqttv3.logging.LoggerFactory;

public class CommsCallback implements Runnable {
    private static final String CLASS_NAME = CommsCallback.class.getName();
    private static final int INBOUND_QUEUE_SIZE = 10;
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private Thread callbackThread;
    private ClientComms clientComms;
    private ClientState clientState;
    private Vector completeQueue;
    private Object lifecycle = new Object();
    private Vector messageQueue;
    private MqttCallback mqttCallback;
    private boolean quiescing = false;
    public boolean running = false;
    private Object spaceAvailable = new Object();
    private Object workAvailable = new Object();

    CommsCallback(ClientComms clientComms2) {
        this.clientComms = clientComms2;
        this.messageQueue = new Vector(10);
        this.completeQueue = new Vector(10);
        log.setResourceName(clientComms2.getClient().getClientId());
    }

    public void setClientState(ClientState clientState2) {
        this.clientState = clientState2;
    }

    public void start(String threadName) {
        synchronized (this.lifecycle) {
            if (!this.running) {
                this.messageQueue.clear();
                this.completeQueue.clear();
                this.running = true;
                this.quiescing = false;
                this.callbackThread = new Thread(this, threadName);
                this.callbackThread.start();
            }
        }
    }

    public void stop() {
        synchronized (this.lifecycle) {
            if (this.running) {
                log.fine(CLASS_NAME, "stop", "700");
                this.running = false;
                if (!Thread.currentThread().equals(this.callbackThread)) {
                    try {
                        synchronized (this.workAvailable) {
                            log.fine(CLASS_NAME, "stop", "701");
                            this.workAvailable.notifyAll();
                        }
                        this.callbackThread.join();
                    } catch (InterruptedException e) {
                    }
                }
            }
            this.callbackThread = null;
            log.fine(CLASS_NAME, "stop", "703");
        }
    }

    public void setCallback(MqttCallback mqttCallback2) {
        this.mqttCallback = mqttCallback2;
    }

    public void run() {
        while (this.running) {
            try {
                synchronized (this.workAvailable) {
                    if (this.running && this.messageQueue.isEmpty() && this.completeQueue.isEmpty()) {
                        log.fine(CLASS_NAME, "run", "704");
                        this.workAvailable.wait();
                    }
                }
            } catch (InterruptedException e) {
            }
            try {
                if (this.running) {
                    MqttToken token = null;
                    synchronized (this.completeQueue) {
                        if (!this.completeQueue.isEmpty()) {
                            token = (MqttToken) this.completeQueue.elementAt(0);
                            this.completeQueue.removeElementAt(0);
                        }
                    }
                    if (token != null) {
                        handleActionComplete(token);
                    }
                    MqttPublish message = null;
                    synchronized (this.messageQueue) {
                        if (!this.messageQueue.isEmpty()) {
                            message = (MqttPublish) this.messageQueue.elementAt(0);
                            this.messageQueue.removeElementAt(0);
                        }
                    }
                    if (message != null) {
                        handleMessage(message);
                    }
                }
                if (this.quiescing) {
                    this.clientState.checkQuiesceLock();
                }
                synchronized (this.spaceAvailable) {
                    log.fine(CLASS_NAME, "run", "706");
                    this.spaceAvailable.notifyAll();
                }
            } catch (Throwable th) {
                synchronized (this.spaceAvailable) {
                    log.fine(CLASS_NAME, "run", "706");
                    this.spaceAvailable.notifyAll();
                    throw th;
                }
            }
        }
    }

    private void handleActionComplete(MqttToken token) throws MqttException {
        synchronized (token) {
            log.fine(CLASS_NAME, "handleActionComplete", "705", new Object[]{token.internalTok.getKey()});
            token.internalTok.notifyComplete();
            if (!token.internalTok.isNotified()) {
                if (this.mqttCallback != null && (token instanceof MqttDeliveryToken) && token.isComplete()) {
                    this.mqttCallback.deliveryComplete((MqttDeliveryToken) token);
                }
                fireActionEvent(token);
            }
            if (token.isComplete() && ((token instanceof MqttDeliveryToken) || (token.getActionCallback() instanceof IMqttActionListener))) {
                token.internalTok.setNotified(true);
            }
            if (token.isComplete()) {
                this.clientState.notifyComplete(token);
            }
        }
    }

    public void connectionLost(MqttException cause) {
        try {
            if (this.mqttCallback != null && cause != null) {
                log.fine(CLASS_NAME, "connectionLost", "708", new Object[]{cause});
                this.mqttCallback.connectionLost(cause);
            }
        } catch (Throwable t) {
            log.fine(CLASS_NAME, "connectionLost", "720", new Object[]{t});
        }
    }

    public void fireActionEvent(MqttToken token) {
        IMqttActionListener asyncCB;
        if (token != null && (asyncCB = token.getActionCallback()) != null) {
            if (token.getException() == null) {
                log.fine(CLASS_NAME, "fireActionEvent", "716", new Object[]{token.internalTok.getKey()});
                asyncCB.onSuccess(token);
                return;
            }
            log.fine(CLASS_NAME, "fireActionEvent", "716", new Object[]{token.internalTok.getKey()});
            asyncCB.onFailure(token, token.getException());
        }
    }

    public void messageArrived(MqttPublish sendMessage) {
        if (this.mqttCallback != null) {
            synchronized (this.spaceAvailable) {
                while (this.running && !this.quiescing && this.messageQueue.size() >= 10) {
                    try {
                        log.fine(CLASS_NAME, "messageArrived", "709");
                        this.spaceAvailable.wait(200);
                    } catch (InterruptedException e) {
                    }
                }
            }
            if (!this.quiescing) {
                this.messageQueue.addElement(sendMessage);
                synchronized (this.workAvailable) {
                    log.fine(CLASS_NAME, "messageArrived", "710");
                    this.workAvailable.notifyAll();
                }
            }
        }
    }

    public void quiesce() {
        this.quiescing = true;
        synchronized (this.spaceAvailable) {
            log.fine(CLASS_NAME, "quiesce", "711");
            this.spaceAvailable.notifyAll();
        }
    }

    public boolean isQuiesced() {
        if (this.quiescing && this.completeQueue.size() == 0 && this.messageQueue.size() == 0) {
            return true;
        }
        return false;
    }

    private void handleMessage(MqttPublish publishMessage) throws MqttException, Exception {
        if (this.mqttCallback != null) {
            String destName = publishMessage.getTopicName();
            log.fine(CLASS_NAME, "handleMessage", "713", new Object[]{new Integer(publishMessage.getMessageId()), destName});
            this.mqttCallback.messageArrived(destName, publishMessage.getMessage());
            if (publishMessage.getMessage().getQos() == 1) {
                this.clientComms.internalSend(new MqttPubAck(publishMessage), new MqttToken(this.clientComms.getClient().getClientId()));
            } else if (publishMessage.getMessage().getQos() == 2) {
                this.clientComms.deliveryComplete(publishMessage);
                this.clientComms.internalSend(new MqttPubComp(publishMessage), new MqttToken(this.clientComms.getClient().getClientId()));
            }
        }
    }

    public void asyncOperationComplete(MqttToken token) {
        if (this.running) {
            this.completeQueue.addElement(token);
            synchronized (this.workAvailable) {
                log.fine(CLASS_NAME, "asyncOperationComplete", "715", new Object[]{token.internalTok.getKey()});
                this.workAvailable.notifyAll();
            }
            return;
        }
        try {
            handleActionComplete(token);
        } catch (Throwable ex) {
            log.fine(CLASS_NAME, "asyncOperationComplete", "719", null, ex);
            this.clientComms.shutdownConnection(null, new MqttException(ex));
        }
    }

    /* access modifiers changed from: protected */
    public Thread getThread() {
        return this.callbackThread;
    }
}
