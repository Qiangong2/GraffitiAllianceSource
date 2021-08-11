package org.pwrd.paho.client.mqttv3.internal.wire;

public abstract class MqttAck extends MqttWireMessage {
    public MqttAck(byte type) {
        super(type);
    }

    /* access modifiers changed from: protected */
    @Override // org.pwrd.paho.client.mqttv3.internal.wire.MqttWireMessage
    public byte getMessageInfo() {
        return 0;
    }

    @Override // org.pwrd.paho.client.mqttv3.internal.wire.MqttWireMessage
    public String toString() {
        return String.valueOf(super.toString()) + " msgId " + this.msgId;
    }
}
