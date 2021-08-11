package org.pwrd.paho.client.mqttv3.internal.wire;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.pwrd.paho.client.mqttv3.MqttException;
import org.pwrd.paho.client.mqttv3.internal.ClientState;
import org.pwrd.paho.client.mqttv3.internal.ExceptionHelper;
import org.pwrd.paho.client.mqttv3.logging.Logger;
import org.pwrd.paho.client.mqttv3.logging.LoggerFactory;

public class MqttInputStream extends InputStream {
    private static final String CLASS_NAME = MqttInputStream.class.getName();
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private ClientState clientState = null;

    /* renamed from: in */
    private DataInputStream f6258in;

    public MqttInputStream(ClientState clientState2, InputStream in) {
        this.clientState = clientState2;
        this.f6258in = new DataInputStream(in);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.f6258in.read();
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f6258in.available();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public void close() throws IOException {
        this.f6258in.close();
    }

    public MqttWireMessage readMqttWireMessage() throws IOException, MqttException {
        ByteArrayOutputStream bais = new ByteArrayOutputStream();
        byte first = this.f6258in.readByte();
        this.clientState.notifyReceivedBytes(1);
        byte type = (byte) ((first >>> 4) & 15);
        if (type < 1 || type > 14) {
            throw ExceptionHelper.createMqttException(32108);
        }
        long remLen = MqttWireMessage.readMBI(this.f6258in).getValue();
        bais.write(first);
        bais.write(MqttWireMessage.encodeMBI(remLen));
        byte[] packet = new byte[((int) (((long) bais.size()) + remLen))];
        readFully(packet, bais.size(), packet.length - bais.size());
        byte[] header = bais.toByteArray();
        System.arraycopy(header, 0, packet, 0, header.length);
        MqttWireMessage message = MqttWireMessage.createWireMessage(packet);
        log.fine(CLASS_NAME, "readMqttWireMessage", "501", new Object[]{message});
        return message;
    }

    private void readFully(byte[] b, int off, int len) throws IOException {
        if (len < 0) {
            throw new IndexOutOfBoundsException();
        }
        int n = 0;
        while (n < len) {
            int count = this.f6258in.read(b, off + n, len - n);
            this.clientState.notifyReceivedBytes(count);
            if (count < 0) {
                throw new EOFException();
            }
            n += count;
        }
    }
}
