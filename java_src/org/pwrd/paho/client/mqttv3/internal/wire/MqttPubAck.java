package org.pwrd.paho.client.mqttv3.internal.wire;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.pwrd.paho.client.mqttv3.MqttException;

public class MqttPubAck extends MqttAck {
    public MqttPubAck(byte info, byte[] data) throws IOException {
        super((byte) 4);
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
        this.msgId = dis.readUnsignedShort();
        dis.close();
    }

    public MqttPubAck(MqttPublish publish) {
        super((byte) 4);
        this.msgId = publish.getMessageId();
    }

    /* access modifiers changed from: protected */
    @Override // org.pwrd.paho.client.mqttv3.internal.wire.MqttWireMessage
    public byte[] getVariableHeader() throws MqttException {
        return encodeMessageId();
    }
}
