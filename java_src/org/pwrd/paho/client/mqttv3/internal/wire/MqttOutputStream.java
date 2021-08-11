package org.pwrd.paho.client.mqttv3.internal.wire;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.pwrd.paho.client.mqttv3.MqttException;
import org.pwrd.paho.client.mqttv3.internal.ClientState;
import org.pwrd.paho.client.mqttv3.logging.Logger;
import org.pwrd.paho.client.mqttv3.logging.LoggerFactory;

public class MqttOutputStream extends OutputStream {
    private static final String CLASS_NAME = MqttOutputStream.class.getName();
    private static final Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private ClientState clientState = null;
    private BufferedOutputStream out;

    public MqttOutputStream(ClientState clientState2, OutputStream out2) {
        this.clientState = clientState2;
        this.out = new BufferedOutputStream(out2);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] b) throws IOException {
        this.out.write(b);
        this.clientState.notifySentBytes(b.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] b, int off, int len) throws IOException {
        this.out.write(b, off, len);
        this.clientState.notifySentBytes(len);
    }

    @Override // java.io.OutputStream
    public void write(int b) throws IOException {
        this.out.write(b);
    }

    public void write(MqttWireMessage message) throws IOException, MqttException {
        byte[] bytes = message.getHeader();
        byte[] pl = message.getPayload();
        this.out.write(bytes, 0, bytes.length);
        this.clientState.notifySentBytes(bytes.length);
        int offset = 0;
        while (offset < pl.length) {
            int length = Math.min(1024, pl.length - offset);
            this.out.write(pl, offset, length);
            offset += 1024;
            this.clientState.notifySentBytes(length);
        }
        log.fine(CLASS_NAME, "write", "500", new Object[]{message});
    }
}
