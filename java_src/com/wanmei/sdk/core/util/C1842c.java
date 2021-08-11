package com.wanmei.sdk.core.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.wanmei.sdk.core.util.c */
public class C1842c extends OutputStream {

    /* renamed from: a */
    private static final byte[] f4588a = new byte[0];

    /* renamed from: b */
    private final List<byte[]> f4589b;

    /* renamed from: c */
    private int f4590c;

    /* renamed from: d */
    private int f4591d;

    /* renamed from: e */
    private byte[] f4592e;

    /* renamed from: f */
    private int f4593f;

    public C1842c() {
        this((byte) 0);
    }

    private C1842c(byte b) {
        this.f4589b = new ArrayList();
        synchronized (this) {
            m6686a(1024);
        }
    }

    /* renamed from: a */
    private void m6686a(int i) {
        if (this.f4590c < this.f4589b.size() - 1) {
            this.f4591d += this.f4592e.length;
            this.f4590c++;
            this.f4592e = this.f4589b.get(this.f4590c);
            return;
        }
        if (this.f4592e == null) {
            this.f4591d = 0;
        } else {
            i = Math.max(this.f4592e.length << 1, i - this.f4591d);
            this.f4591d += this.f4592e.length;
        }
        this.f4590c++;
        this.f4592e = new byte[i];
        this.f4589b.add(this.f4592e);
    }

    /* renamed from: a */
    public synchronized byte[] mo9913a() {
        byte[] bArr;
        int i = 0;
        synchronized (this) {
            int i2 = this.f4593f;
            if (i2 == 0) {
                bArr = f4588a;
            } else {
                byte[] bArr2 = new byte[i2];
                for (byte[] bArr3 : this.f4589b) {
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
    public void close() throws IOException {
    }

    public String toString() {
        return new String(mo9913a());
    }

    @Override // java.io.OutputStream
    public synchronized void write(int b) {
        int i = this.f4593f - this.f4591d;
        if (i == this.f4592e.length) {
            m6686a(this.f4593f + 1);
            i = 0;
        }
        this.f4592e[i] = (byte) b;
        this.f4593f++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] b, int off, int len) {
        if (off < 0 || off > b.length || len < 0 || off + len > b.length || off + len < 0) {
            throw new IndexOutOfBoundsException();
        } else if (len != 0) {
            synchronized (this) {
                int i = this.f4593f + len;
                int i2 = this.f4593f - this.f4591d;
                int i3 = len;
                while (i3 > 0) {
                    int min = Math.min(i3, this.f4592e.length - i2);
                    System.arraycopy(b, (off + len) - i3, this.f4592e, i2, min);
                    i3 -= min;
                    if (i3 > 0) {
                        m6686a(i);
                        i2 = 0;
                    }
                }
                this.f4593f = i;
            }
        }
    }
}
