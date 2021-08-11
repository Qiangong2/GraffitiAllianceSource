package org.pwrd.paho.client.mqttv3.internal;

import org.pwrd.paho.client.mqttv3.MqttTopic;

public interface DestinationProvider {
    MqttTopic getTopic(String str);
}
