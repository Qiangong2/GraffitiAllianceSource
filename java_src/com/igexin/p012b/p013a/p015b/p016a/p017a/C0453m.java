package com.igexin.p012b.p013a.p015b.p016a.p017a;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.igexin.b.a.b.a.a.m */
public class C0453m {

    /* renamed from: a */
    BufferedInputStream f1072a;

    public C0453m(InputStream inputStream) {
        this.f1072a = new BufferedInputStream(inputStream);
    }

    /* renamed from: a */
    public int mo4154a(byte[] bArr) {
        int i = 0;
        int length = bArr.length;
        int i2 = 0;
        while (i < length) {
            i2 = this.f1072a.read(bArr, i, length - i);
            if (i2 > 0) {
                i += i2;
            } else {
                throw new IOException("read = -1, end of stream !");
            }
        }
        return i2;
    }

    /* renamed from: a */
    public void mo4155a() {
        this.f1072a.close();
    }
}
