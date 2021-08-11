package org.pwrd.paho.client.mqttv3.internal.wire;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.pwrd.paho.client.mqttv3.MqttException;
import org.pwrd.paho.client.mqttv3.MqttMessage;

public class MqttConnect extends MqttWireMessage {
    public static final String KEY = "Con";
    private int MqttVersion;
    private boolean cleanSession;
    private String clientId;
    private int keepAliveInterval;
    private char[] password;
    private String userName;
    private String willDestination;
    private MqttMessage willMessage;

    public MqttConnect(byte info, byte[] data) throws IOException, MqttException {
        super((byte) 1);
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
        decodeUTF8(dis);
        dis.readByte();
        dis.readByte();
        this.keepAliveInterval = dis.readUnsignedShort();
        this.clientId = decodeUTF8(dis);
        dis.close();
    }

    public MqttConnect(String clientId2, int MqttVersion2, boolean cleanSession2, int keepAliveInterval2, String userName2, char[] password2, MqttMessage willMessage2, String willDestination2) {
        super((byte) 1);
        this.clientId = clientId2;
        this.cleanSession = cleanSession2;
        this.keepAliveInterval = keepAliveInterval2;
        this.userName = userName2;
        this.password = password2;
        this.willMessage = willMessage2;
        this.willDestination = willDestination2;
        this.MqttVersion = MqttVersion2;
    }

    @Override // org.pwrd.paho.client.mqttv3.internal.wire.MqttWireMessage
    public String toString() {
        return String.valueOf(super.toString()) + " clientId " + this.clientId + " keepAliveInterval " + this.keepAliveInterval;
    }

    /* access modifiers changed from: protected */
    @Override // org.pwrd.paho.client.mqttv3.internal.wire.MqttWireMessage
    public byte getMessageInfo() {
        return 0;
    }

    public boolean isCleanSession() {
        return this.cleanSession;
    }

    /* access modifiers changed from: protected */
    @Override // org.pwrd.paho.client.mqttv3.internal.wire.MqttWireMessage
    public byte[] getVariableHeader() throws MqttException {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            if (this.MqttVersion == 3) {
                encodeUTF8(dos, "MQIsdp");
            } else if (this.MqttVersion == 4) {
                encodeUTF8(dos, "MQTT");
            }
            dos.write(this.MqttVersion);
            byte connectFlags = 0;
            if (this.cleanSession) {
                connectFlags = (byte) 2;
            }
            if (this.willMessage != null) {
                connectFlags = (byte) ((this.willMessage.getQos() << 3) | ((byte) (connectFlags | 4)));
                if (this.willMessage.isRetained()) {
                    connectFlags = (byte) (connectFlags | 32);
                }
            }
            if (this.userName != null) {
                connectFlags = (byte) (connectFlags | 128);
                if (this.password != null) {
                    connectFlags = (byte) (connectFlags | 64);
                }
            }
            dos.write(connectFlags);
            dos.writeShort(this.keepAliveInterval);
            dos.flush();
            return baos.toByteArray();
        } catch (IOException ioe) {
            throw new MqttException(ioe);
        }
    }

    @Override // org.pwrd.paho.client.mqttv3.internal.wire.MqttWireMessage
    public byte[] getPayload() throws MqttException {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            encodeUTF8(dos, this.clientId);
            if (this.willMessage != null) {
                encodeUTF8(dos, this.willDestination);
                dos.writeShort(this.willMessage.getPayload().length);
                dos.write(this.willMessage.getPayload());
            }
            if (this.userName != null) {
                encodeUTF8(dos, this.userName);
                if (this.password != null) {
                    encodeUTF8(dos, new String(this.password));
                }
            }
            dos.flush();
            return baos.toByteArray();
        } catch (IOException ex) {
            throw new MqttException(ex);
        }
    }

    @Override // org.pwrd.paho.client.mqttv3.internal.wire.MqttWireMessage
    public boolean isMessageIdRequired() {
        return false;
    }

    @Override // org.pwrd.paho.client.mqttv3.internal.wire.MqttWireMessage
    public String getKey() {
        return "Con";
    }
}
