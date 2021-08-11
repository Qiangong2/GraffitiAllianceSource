package org.pwrd.paho.client.mqttv3.internal.wire;

import org.pwrd.paho.client.mqttv3.MqttException;
import org.pwrd.paho.client.mqttv3.MqttPersistable;
import org.pwrd.paho.client.mqttv3.MqttPersistenceException;

public abstract class MqttPersistableWireMessage extends MqttWireMessage implements MqttPersistable {
    public MqttPersistableWireMessage(byte type) {
        super(type);
    }

    @Override // org.pwrd.paho.client.mqttv3.MqttPersistable
    public byte[] getHeaderBytes() throws MqttPersistenceException {
        try {
            return getHeader();
        } catch (MqttException ex) {
            throw new MqttPersistenceException(ex.getCause());
        }
    }

    @Override // org.pwrd.paho.client.mqttv3.MqttPersistable
    public int getHeaderLength() throws MqttPersistenceException {
        return getHeaderBytes().length;
    }

    @Override // org.pwrd.paho.client.mqttv3.MqttPersistable
    public int getHeaderOffset() throws MqttPersistenceException {
        return 0;
    }

    @Override // org.pwrd.paho.client.mqttv3.MqttPersistable
    public byte[] getPayloadBytes() throws MqttPersistenceException {
        try {
            return getPayload();
        } catch (MqttException ex) {
            throw new MqttPersistenceException(ex.getCause());
        }
    }

    @Override // org.pwrd.paho.client.mqttv3.MqttPersistable
    public int getPayloadLength() throws MqttPersistenceException {
        return 0;
    }

    @Override // org.pwrd.paho.client.mqttv3.MqttPersistable
    public int getPayloadOffset() throws MqttPersistenceException {
        return 0;
    }
}
