package org.pwrd.paho.client.mqttv3.internal;

import java.io.IOException;
import java.io.InputStream;
import org.pwrd.paho.client.mqttv3.MqttException;
import org.pwrd.paho.client.mqttv3.MqttToken;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttAck;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttInputStream;
import org.pwrd.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.pwrd.paho.client.mqttv3.logging.Logger;
import org.pwrd.paho.client.mqttv3.logging.LoggerFactory;

public class CommsReceiver implements Runnable {
    private static final String CLASS_NAME = CommsReceiver.class.getName();
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private ClientComms clientComms = null;
    private ClientState clientState = null;

    /* renamed from: in */
    private MqttInputStream f6256in;
    private Object lifecycle = new Object();
    private Thread recThread = null;
    private volatile boolean receiving;
    private boolean running = false;
    private CommsTokenStore tokenStore = null;

    public CommsReceiver(ClientComms clientComms2, ClientState clientState2, CommsTokenStore tokenStore2, InputStream in) {
        this.f6256in = new MqttInputStream(clientState2, in);
        this.clientComms = clientComms2;
        this.clientState = clientState2;
        this.tokenStore = tokenStore2;
        log.setResourceName(clientComms2.getClient().getClientId());
    }

    public void start(String threadName) {
        log.fine(CLASS_NAME, "start", "855");
        synchronized (this.lifecycle) {
            if (!this.running) {
                this.running = true;
                this.recThread = new Thread(this, threadName);
                this.recThread.start();
            }
        }
    }

    public void stop() {
        synchronized (this.lifecycle) {
            log.fine(CLASS_NAME, "stop", "850");
            if (this.running) {
                this.running = false;
                this.receiving = false;
                if (!Thread.currentThread().equals(this.recThread)) {
                    try {
                        this.recThread.join();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
        this.recThread = null;
        log.fine(CLASS_NAME, "stop", "851");
    }

    public void run() {
        MqttToken token = null;
        while (this.running && this.f6256in != null) {
            try {
                log.fine(CLASS_NAME, "run", "852");
                this.receiving = this.f6256in.available() > 0;
                MqttWireMessage message = this.f6256in.readMqttWireMessage();
                this.receiving = false;
                if (message instanceof MqttAck) {
                    token = this.tokenStore.getToken(message);
                    if (token != null) {
                        synchronized (token) {
                            this.clientState.notifyReceivedAck((MqttAck) message);
                        }
                    } else {
                        throw new MqttException(6);
                    }
                } else {
                    this.clientState.notifyReceivedMsg(message);
                }
            } catch (MqttException ex) {
                log.fine(CLASS_NAME, "run", "856", null, ex);
                this.running = false;
                this.clientComms.shutdownConnection(token, ex);
            } catch (IOException ioe) {
                log.fine(CLASS_NAME, "run", "853");
                this.running = false;
                if (!this.clientComms.isDisconnecting()) {
                    this.clientComms.shutdownConnection(token, new MqttException(32109, ioe));
                }
            } finally {
                this.receiving = false;
            }
        }
        log.fine(CLASS_NAME, "run", "854");
    }

    public boolean isRunning() {
        return this.running;
    }

    public boolean isReceiving() {
        return this.receiving;
    }
}
