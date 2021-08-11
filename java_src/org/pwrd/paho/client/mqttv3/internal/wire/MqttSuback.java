package org.pwrd.paho.client.mqttv3.internal.wire;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.pwrd.paho.client.mqttv3.MqttException;

public class MqttSuback extends MqttAck {
    private int[] grantedQos;

    public MqttSuback(byte info, byte[] data) throws IOException {
        super((byte) 9);
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
        this.msgId = dis.readUnsignedShort();
        int index = 0;
        this.grantedQos = new int[(data.length - 2)];
        for (int qos = dis.read(); qos != -1; qos = dis.read()) {
            this.grantedQos[index] = qos;
            index++;
        }
        dis.close();
    }

    /* access modifiers changed from: protected */
    @Override // org.pwrd.paho.client.mqttv3.internal.wire.MqttWireMessage
    public byte[] getVariableHeader() throws MqttException {
        return new byte[0];
    }

    @Override // org.pwrd.paho.client.mqttv3.internal.wire.MqttAck, org.pwrd.paho.client.mqttv3.internal.wire.MqttWireMessage
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(super.toString()).append(" granted Qos");
        for (int i = 0; i < this.grantedQos.length; i++) {
            sb.append(" ").append(this.grantedQos[i]);
        }
        return sb.toString();
    }

    public int[] getGrantedQos() {
        return this.grantedQos;
    }
}
