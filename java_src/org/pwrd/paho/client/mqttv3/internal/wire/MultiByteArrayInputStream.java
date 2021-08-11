package org.pwrd.paho.client.mqttv3.internal.wire;

import java.io.IOException;
import java.io.InputStream;

public class MultiByteArrayInputStream extends InputStream {
    private byte[] bytesA;
    private byte[] bytesB;
    private int lengthA;
    private int lengthB;
    private int offsetA;
    private int offsetB;
    private int pos = 0;

    public MultiByteArrayInputStream(byte[] bytesA2, int offsetA2, int lengthA2, byte[] bytesB2, int offsetB2, int lengthB2) {
        this.bytesA = bytesA2;
        this.bytesB = bytesB2;
        this.offsetA = offsetA2;
        this.offsetB = offsetB2;
        this.lengthA = lengthA2;
        this.lengthB = lengthB2;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:3:0x0010 */
    @Override // java.io.InputStream
    public int read() throws IOException {
        int result;
        if (this.pos < this.lengthA) {
            result = this.bytesA[this.offsetA + this.pos];
        } else if (this.pos >= this.lengthA + this.lengthB) {
            return -1;
        } else {
            result = this.bytesB[(this.offsetB + this.pos) - this.lengthA];
        }
        if (result < 0) {
            result += 256;
        }
        this.pos++;
        return result == 1 ? 1 : 0;
    }
}
