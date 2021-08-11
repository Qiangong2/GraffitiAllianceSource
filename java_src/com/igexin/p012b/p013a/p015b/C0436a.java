package com.igexin.p012b.p013a.p015b;

import com.tencent.qcloud.core.util.IOUtils;
import java.io.OutputStream;

/* renamed from: com.igexin.b.a.b.a */
public class C0436a extends OutputStream {

    /* renamed from: a */
    private OutputStream f1023a = null;

    /* renamed from: b */
    private int f1024b = 0;

    /* renamed from: c */
    private int f1025c = 0;

    /* renamed from: d */
    private int f1026d = 0;

    /* renamed from: e */
    private int f1027e = 0;

    public C0436a(OutputStream outputStream, int i) {
        this.f1023a = outputStream;
        this.f1027e = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4123a() {
        char c = '=';
        if (this.f1025c > 0) {
            if (this.f1027e > 0 && this.f1026d == this.f1027e) {
                this.f1023a.write(IOUtils.LINE_SEPARATOR_WINDOWS.getBytes());
                this.f1026d = 0;
            }
            char charAt = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.f1024b << 8) >>> 26);
            char charAt2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.f1024b << 14) >>> 26);
            char charAt3 = this.f1025c < 2 ? '=' : "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.f1024b << 20) >>> 26);
            if (this.f1025c >= 3) {
                c = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((this.f1024b << 26) >>> 26);
            }
            this.f1023a.write(charAt);
            this.f1023a.write(charAt2);
            this.f1023a.write(charAt3);
            this.f1023a.write(c);
            this.f1026d += 4;
            this.f1025c = 0;
            this.f1024b = 0;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        mo4123a();
        this.f1023a.close();
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.f1024b = ((i & 255) << (16 - (this.f1025c * 8))) | this.f1024b;
        this.f1025c++;
        if (this.f1025c == 3) {
            mo4123a();
        }
    }
}
