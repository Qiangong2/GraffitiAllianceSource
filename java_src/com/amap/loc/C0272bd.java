package com.amap.loc;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* renamed from: com.amap.loc.bd */
/* compiled from: StrictLineReader */
public class C0272bd implements Closeable {

    /* renamed from: a */
    private final InputStream f439a;

    /* renamed from: b */
    private final Charset f440b;

    /* renamed from: c */
    private byte[] f441c;

    /* renamed from: d */
    private int f442d;

    /* renamed from: e */
    private int f443e;

    public C0272bd(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (!charset.equals(C0274be.f445a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        } else {
            this.f439a = inputStream;
            this.f440b = charset;
            this.f441c = new byte[i];
        }
    }

    public C0272bd(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    /* renamed from: b */
    private void m715b() throws IOException {
        int read = this.f439a.read(this.f441c, 0, this.f441c.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f442d = 0;
        this.f443e = read;
    }

    /* renamed from: a */
    public String mo3744a() throws IOException {
        int i;
        String byteArrayOutputStream;
        synchronized (this.f439a) {
            if (this.f441c == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.f442d >= this.f443e) {
                m715b();
            }
            int i2 = this.f442d;
            while (true) {
                if (i2 == this.f443e) {
                    C02731 r1 = new ByteArrayOutputStream((this.f443e - this.f442d) + 80) {
                        /* class com.amap.loc.C0272bd.C02731 */

                        public String toString() {
                            try {
                                return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + -1] != 13) ? this.count : this.count - 1, C0272bd.this.f440b.name());
                            } catch (UnsupportedEncodingException e) {
                                throw new AssertionError(e);
                            }
                        }
                    };
                    loop1:
                    while (true) {
                        r1.write(this.f441c, this.f442d, this.f443e - this.f442d);
                        this.f443e = -1;
                        m715b();
                        i = this.f442d;
                        while (true) {
                            if (i != this.f443e) {
                                if (this.f441c[i] == 10) {
                                    break loop1;
                                }
                                i++;
                            }
                        }
                    }
                    if (i != this.f442d) {
                        r1.write(this.f441c, this.f442d, i - this.f442d);
                    }
                    this.f442d = i + 1;
                    byteArrayOutputStream = r1.toString();
                } else if (this.f441c[i2] == 10) {
                    byteArrayOutputStream = new String(this.f441c, this.f442d, ((i2 == this.f442d || this.f441c[i2 + -1] != 13) ? i2 : i2 - 1) - this.f442d, this.f440b.name());
                    this.f442d = i2 + 1;
                } else {
                    i2++;
                }
            }
        }
        return byteArrayOutputStream;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f439a) {
            if (this.f441c != null) {
                this.f441c = null;
                this.f439a.close();
            }
        }
    }
}
