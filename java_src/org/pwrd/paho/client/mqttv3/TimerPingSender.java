package org.pwrd.paho.client.mqttv3;

import java.util.Timer;
import java.util.TimerTask;
import org.pwrd.paho.client.mqttv3.internal.ClientComms;
import org.pwrd.paho.client.mqttv3.logging.Logger;
import org.pwrd.paho.client.mqttv3.logging.LoggerFactory;

public class TimerPingSender implements MqttPingSender {
    private static final String CLASS_NAME = TimerPingSender.class.getName();
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private ClientComms comms;
    private Timer timer;

    @Override // org.pwrd.paho.client.mqttv3.MqttPingSender
    public void init(ClientComms comms2) {
        if (comms2 == null) {
            throw new IllegalArgumentException("ClientComms cannot be null.");
        }
        this.comms = comms2;
    }

    @Override // org.pwrd.paho.client.mqttv3.MqttPingSender
    public void start() {
        String clientid = this.comms.getClient().getClientId();
        log.fine(CLASS_NAME, "start", "659", new Object[]{clientid});
        this.timer = new Timer("MQTT Ping: " + clientid);
        this.timer.schedule(new PingTask(this, null), this.comms.getKeepAlive());
    }

    @Override // org.pwrd.paho.client.mqttv3.MqttPingSender
    public void stop() {
        log.fine(CLASS_NAME, "stop", "661", null);
        if (this.timer != null) {
            this.timer.cancel();
        }
    }

    @Override // org.pwrd.paho.client.mqttv3.MqttPingSender
    public void schedule(long delayInMilliseconds) {
        this.timer.schedule(new PingTask(this, null), delayInMilliseconds);
    }

    private class PingTask extends TimerTask {
        private static final String methodName = "PingTask.run";

        private PingTask() {
        }

        /* synthetic */ PingTask(TimerPingSender timerPingSender, PingTask pingTask) {
            this();
        }

        public void run() {
            TimerPingSender.log.fine(TimerPingSender.CLASS_NAME, methodName, "660", new Object[]{new Long(System.currentTimeMillis())});
            TimerPingSender.this.comms.checkForActivity();
        }
    }
}
