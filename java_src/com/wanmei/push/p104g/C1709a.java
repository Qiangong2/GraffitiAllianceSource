package com.wanmei.push.p104g;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.wanmei.push.g.a */
public final class C1709a extends OutputStream {

    /* renamed from: a */
    private static final byte[] f4345a = new byte[0];

    /* renamed from: b */
    private final List<byte[]> f4346b;

    /* renamed from: c */
    private int f4347c;

    /* renamed from: d */
    private int f4348d;

    /* renamed from: e */
    private byte[] f4349e;

    /* renamed from: f */
    private int f4350f;

    public C1709a() {
        this((byte) 0);
    }

    private C1709a(byte b) {
        this.f4346b = new ArrayList();
        synchronized (this) {
            m6367a(1024);
        }
    }

    /* renamed from: a */
    private void m6367a(int i) {
        if (this.f4347c < this.f4346b.size() - 1) {
            this.f4348d += this.f4349e.length;
            this.f4347c++;
            this.f4349e = this.f4346b.get(this.f4347c);
            return;
        }
        if (this.f4349e == null) {
            this.f4348d = 0;
        } else {
            i = Math.max(this.f4349e.length << 1, i - this.f4348d);
            this.f4348d += this.f4349e.length;
        }
        this.f4347c++;
        this.f4349e = new byte[i];
        this.f4346b.add(this.f4349e);
    }

    /* renamed from: a */
    public final synchronized byte[] mo9374a() {
        byte[] bArr;
        int i = 0;
        synchronized (this) {
            int i2 = this.f4350f;
            if (i2 == 0) {
                bArr = f4345a;
            } else {
                byte[] bArr2 = new byte[i2];
                for (byte[] bArr3 : this.f4346b) {
                    int min = Math.min(bArr3.length, i2);
                    System.arraycopy(bArr3, 0, bArr2, i, min);
                    i += min;
                    i2 -= min;
                    if (i2 == 0) {
                        break;
                    }
                }
                bArr = bArr2;
            }
        }
        return bArr;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    public final String toString() {
        return new String(mo9374a());
    }

    @Override // java.io.OutputStream
    public final synchronized void write(int b) {
        int i = this.f4350f - this.f4348d;
        if (i == this.f4349e.length) {
            m6367a(this.f4350f + 1);
            i = 0;
        }
        this.f4349e[i] = (byte) b;
        this.f4350f++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] b, int off, int len) {
        if (off < 0 || off > b.length || len < 0 || off + len > b.length || off + len < 0) {
            throw new IndexOutOfBoundsException();
        } else if (len != 0) {
            synchronized (this) {
                int i = this.f4350f + len;
                int i2 = this.f4350f - this.f4348d;
                int i3 = len;
                while (i3 > 0) {
                    int min = Math.min(i3, this.f4349e.length - i2);
                    System.arraycopy(b, (off + len) - i3, this.f4349e, i2, min);
                    i3 -= min;
                    if (i3 > 0) {
                        m6367a(i);
                        i2 = 0;
                    }
                }
                this.f4350f = i;
            }
        }
    }
}
