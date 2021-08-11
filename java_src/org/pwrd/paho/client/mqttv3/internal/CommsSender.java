package org.pwrd.paho.client.mqttv3.internal;

import java.io.IOException;
import java.io.OutputStream;
import org.pwrd.paho.client.mqttv3.MqttException;
import org.pwrd.paho.client.mqttv3.MqttToken;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttAck;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttDisconnect;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttOutputStream;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.pwrd.paho.client.mqttv3.logging.Logger;
import org.pwrd.paho.client.mqttv3.logging.LoggerFactory;

public class CommsSender implements Runnable {
    private static final String CLASS_NAME = CommsSender.class.getName();
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private ClientComms clientComms = null;
    private ClientState clientState = null;
    private Object lifecycle = new Object();
    private MqttOutputStream out;
    private boolean running = false;
    private Thread sendThread = null;
    private CommsTokenStore tokenStore = null;

    public CommsSender(ClientComms clientComms2, ClientState clientState2, CommsTokenStore tokenStore2, OutputStream out2) {
        this.out = new MqttOutputStream(clientState2, out2);
        this.clientComms = clientComms2;
        this.clientState = clientState2;
        this.tokenStore = tokenStore2;
        log.setResourceName(clientComms2.getClient().getClientId());
    }

    public void start(String threadName) {
        synchronized (this.lifecycle) {
            if (!this.running) {
                this.running = true;
                this.sendThread = new Thread(this, threadName);
                this.sendThread.start();
            }
        }
    }

    public void stop() {
        synchronized (this.lifecycle) {
            log.fine(CLASS_NAME, "stop", "800");
            if (this.running) {
                this.running = false;
                if (!Thread.currentThread().equals(this.sendThread)) {
                    try {
                        this.clientState.notifyQueueLock();
                        this.sendThread.join();
                    } catch (InterruptedException e) {
                    }
                }
            }
            this.sendThread = null;
            log.fine(CLASS_NAME, "stop", "801");
        }
    }

    public void run() {
        MqttWireMessage message = null;
        while (this.running && this.out != null) {
            try {
                message = this.clientState.get();
                if (message != null) {
                    log.fine(CLASS_NAME, "run", "802", new Object[]{message.getKey(), message});
                    if (message instanceof MqttAck) {
                        this.out.write(message);
                        this.out.flush();
                    } else {
                        MqttToken token = this.tokenStore.getToken(message);
                        if (token != null) {
                            synchronized (token) {
                                this.out.write(message);
                                try {
                                    this.out.flush();
                                } catch (IOException ex) {
                                    if (!(message instanceof MqttDisconnect)) {
                                        throw ex;
                                    }
                                }
                                this.clientState.notifySent(message);
                            }
                        } else {
                            continue;
                        }
                    }
                } else {
                    log.fine(CLASS_NAME, "run", "803");
                    this.running = false;
                }
            } catch (MqttException me) {
                handleRunException(message, me);
            } catch (Exception ex2) {
                handleRunException(message, ex2);
            }
        }
        log.fine(CLASS_NAME, "run", "805");
    }

    private void handleRunException(MqttWireMessage message, Exception ex) {
        MqttException mex;
        log.fine(CLASS_NAME, "handleRunException", "804", null, ex);
        if (!(ex instanceof MqttException)) {
            mex = new MqttException(32109, ex);
        } else {
            mex = (MqttException) ex;
        }
        this.running = false;
        this.clientComms.shutdownConnection(null, mex);
    }
}
