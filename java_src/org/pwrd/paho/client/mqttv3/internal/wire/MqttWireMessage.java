package org.pwrd.paho.client.mqttv3.internal.wire;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.pwrd.paho.client.mqttv3.MqttException;
import org.pwrd.paho.client.mqttv3.MqttPersistable;
import org.pwrd.paho.client.mqttv3.internal.ExceptionHelper;
import p000a.p001a.p002a.p004b.C0027o;

public abstract class MqttWireMessage {
    public static final byte MESSAGE_TYPE_CONNACK = 2;
    public static final byte MESSAGE_TYPE_CONNECT = 1;
    public static final byte MESSAGE_TYPE_DISCONNECT = 14;
    public static final byte MESSAGE_TYPE_PINGREQ = 12;
    public static final byte MESSAGE_TYPE_PINGRESP = 13;
    public static final byte MESSAGE_TYPE_PUBACK = 4;
    public static final byte MESSAGE_TYPE_PUBCOMP = 7;
    public static final byte MESSAGE_TYPE_PUBLISH = 3;
    public static final byte MESSAGE_TYPE_PUBREC = 5;
    public static final byte MESSAGE_TYPE_PUBREL = 6;
    public static final byte MESSAGE_TYPE_SUBACK = 9;
    public static final byte MESSAGE_TYPE_SUBSCRIBE = 8;
    public static final byte MESSAGE_TYPE_UNSUBACK = 11;
    public static final byte MESSAGE_TYPE_UNSUBSCRIBE = 10;
    private static final String[] PACKET_NAMES = {"reserved", "CONNECT", "CONNACK", "PUBLISH", "PUBACK", "PUBREC", "PUBREL", "PUBCOMP", "SUBSCRIBE", "SUBACK", "UNSUBSCRIBE", "UNSUBACK", "PINGREQ", "PINGRESP", "DISCONNECT"};
    protected static final String STRING_ENCODING = "UTF-8";
    protected boolean duplicate = false;
    protected int msgId;
    private byte type;

    /* access modifiers changed from: protected */
    public abstract byte getMessageInfo();

    /* access modifiers changed from: protected */
    public abstract byte[] getVariableHeader() throws MqttException;

    public MqttWireMessage(byte type2) {
        this.type = type2;
        this.msgId = 0;
    }

    public byte[] getPayload() throws MqttException {
        return new byte[0];
    }

    public byte getType() {
        return this.type;
    }

    public int getMessageId() {
        return this.msgId;
    }

    public void setMessageId(int msgId2) {
        this.msgId = msgId2;
    }

    public String getKey() {
        return new Integer(getMessageId()).toString();
    }

    public byte[] getHeader() throws MqttException {
        try {
            int first = ((getType() & C0027o.f104m) << 4) ^ (getMessageInfo() & C0027o.f104m);
            byte[] varHeader = getVariableHeader();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            dos.writeByte(first);
            dos.write(encodeMBI((long) (varHeader.length + getPayload().length)));
            dos.write(varHeader);
            dos.flush();
            return baos.toByteArray();
        } catch (IOException ioe) {
            throw new MqttException(ioe);
        }
    }

    public boolean isMessageIdRequired() {
        return true;
    }

    public static MqttWireMessage createWireMessage(MqttPersistable data) throws MqttException {
        byte[] payload = data.getPayloadBytes();
        if (payload == null) {
            payload = new byte[0];
        }
        return createWireMessage(new MultiByteArrayInputStream(data.getHeaderBytes(), data.getHeaderOffset(), data.getHeaderLength(), payload, data.getPayloadOffset(), data.getPayloadLength()));
    }

    public static MqttWireMessage createWireMessage(byte[] bytes) throws MqttException {
        return createWireMessage(new ByteArrayInputStream(bytes));
    }

    private static MqttWireMessage createWireMessage(InputStream inputStream) throws MqttException {
        try {
            CountingInputStream counter = new CountingInputStream(inputStream);
            DataInputStream in = new DataInputStream(counter);
            int first = in.readUnsignedByte();
            byte type2 = (byte) (first >> 4);
            byte info = (byte) (first & 15);
            long remainder = (((long) counter.getCounter()) + readMBI(in).getValue()) - ((long) counter.getCounter());
            byte[] data = new byte[0];
            if (remainder > 0) {
                data = new byte[((int) remainder)];
                in.readFully(data, 0, data.length);
            }
            if (type2 == 1) {
                return new MqttConnect(info, data);
            }
            if (type2 == 3) {
                return new MqttPublish(info, data);
            }
            if (type2 == 4) {
                return new MqttPubAck(info, data);
            }
            if (type2 == 7) {
                return new MqttPubComp(info, data);
            }
            if (type2 == 2) {
                return new MqttConnack(info, data);
            }
            if (type2 == 12) {
                return new MqttPingReq(info, data);
            }
            if (type2 == 13) {
                return new MqttPingResp(info, data);
            }
            if (type2 == 8) {
                return new MqttSubscribe(info, data);
            }
            if (type2 == 9) {
                return new MqttSuback(info, data);
            }
            if (type2 == 10) {
                return new MqttUnsubscribe(info, data);
            }
            if (type2 == 11) {
                return new MqttUnsubAck(info, data);
            }
            if (type2 == 6) {
                return new MqttPubRel(info, data);
            }
            if (type2 == 5) {
                return new MqttPubRec(info, data);
            }
            if (type2 == 14) {
                return new MqttDisconnect(info, data);
            }
            throw ExceptionHelper.createMqttException(6);
        } catch (IOException io) {
            throw new MqttException(io);
        }
    }

    protected static byte[] encodeMBI(long number) {
        int numBytes = 0;
        long no = number;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        do {
            byte digit = (byte) ((int) (no % 128));
            no /= 128;
            if (no > 0) {
                digit = (byte) (digit | 128);
            }
            bos.write(digit);
            numBytes++;
            if (no <= 0) {
                break;
            }
        } while (numBytes < 4);
        return bos.toByteArray();
    }

    protected static MultiByteInteger readMBI(DataInputStream in) throws IOException {
        byte digit;
        long msgLength = 0;
        int multiplier = 1;
        int count = 0;
        do {
            digit = in.readByte();
            count++;
            msgLength += (long) ((digit & Byte.MAX_VALUE) * multiplier);
            multiplier *= 128;
        } while ((digit & 128) != 0);
        return new MultiByteInteger(msgLength, count);
    }

    /* access modifiers changed from: protected */
    public byte[] encodeMessageId() throws MqttException {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            dos.writeShort(this.msgId);
            dos.flush();
            return baos.toByteArray();
        } catch (IOException ex) {
            throw new MqttException(ex);
        }
    }

    public boolean isRetryable() {
        return false;
    }

    public void setDuplicate(boolean duplicate2) {
        this.duplicate = duplicate2;
    }

    /* access modifiers changed from: protected */
    public void encodeUTF8(DataOutputStream dos, String stringToEncode) throws MqttException {
        try {
            byte[] encodedString = stringToEncode.getBytes(STRING_ENCODING);
            dos.write((byte) ((encodedString.length >>> 8) & 255));
            dos.write((byte) ((encodedString.length >>> 0) & 255));
            dos.write(encodedString);
        } catch (UnsupportedEncodingException ex) {
            throw new MqttException(ex);
        } catch (IOException ex2) {
            throw new MqttException(ex2);
        }
    }

    /* access modifiers changed from: protected */
    public String decodeUTF8(DataInputStream input) throws MqttException {
        try {
            byte[] encodedString = new byte[input.readUnsignedShort()];
            input.readFully(encodedString);
            return new String(encodedString, STRING_ENCODING);
        } catch (IOException ex) {
            throw new MqttException(ex);
        }
    }

    public String toString() {
        return PACKET_NAMES[this.type];
    }
}
