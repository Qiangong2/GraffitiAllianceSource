package org.pwrd.paho.client.mqttv3.internal.wire;

import java.io.IOException;
import java.io.InputStream;

public class CountingInputStream extends InputStream {
    private int counter = 0;

    /* renamed from: in */
    private InputStream f6257in;

    public CountingInputStream(InputStream in) {
        this.f6257in = in;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i = this.f6257in.read();
        if (i != -1) {
            this.counter++;
        }
        return i;
    }

    public int getCounter() {
        return this.counter;
    }

    public void resetCounter() {
        this.counter = 0;
    }
}
