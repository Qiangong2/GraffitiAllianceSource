package org.pwrd.paho.client.mqttv3.internal.wire;

import java.io.IOException;
import org.pwrd.paho.client.mqttv3.MqttException;

public class MqttDisconnect extends MqttWireMessage {
    public static final String KEY = "Disc";

    public MqttDisconnect() {
        super((byte) 14);
    }

    public MqttDisconnect(byte info, byte[] variableHeader) throws IOException {
        super((byte) 14);
    }

    /* access modifiers changed from: protected */
    @Override // org.pwrd.paho.client.mqttv3.internal.wire.MqttWireMessage
    public byte getMessageInfo() {
        return 0;
    }

    /* access modifiers changed from: protected */
    @Override // org.pwrd.paho.client.mqttv3.internal.wire.MqttWireMessage
    public byte[] getVariableHeader() throws MqttException {
        return new byte[0];
    }

    @Override // org.pwrd.paho.client.mqttv3.internal.wire.MqttWireMessage
    public boolean isMessageIdRequired() {
        return false;
    }

    @Override // org.pwrd.paho.client.mqttv3.internal.wire.MqttWireMessage
    public String getKey() {
        return KEY;
    }
}
