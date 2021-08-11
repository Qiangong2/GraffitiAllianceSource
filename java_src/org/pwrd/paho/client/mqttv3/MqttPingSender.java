package org.pwrd.paho.client.mqttv3;

import org.pwrd.paho.client.mqttv3.internal.ClientComms;

public interface MqttPingSender {
    void init(ClientComms clientComms);

    void schedule(long j);

    void start();

    void stop();
}
