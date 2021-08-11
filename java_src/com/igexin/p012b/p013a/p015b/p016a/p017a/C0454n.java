package com.igexin.p012b.p013a.p015b.p016a.p017a;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

/* renamed from: com.igexin.b.a.b.a.a.n */
public class C0454n {

    /* renamed from: a */
    private BufferedOutputStream f1073a;

    public C0454n(OutputStream outputStream) {
        this.f1073a = new BufferedOutputStream(outputStream);
    }

    /* renamed from: a */
    public void mo4156a() {
        this.f1073a.close();
    }

    /* renamed from: a */
    public void mo4157a(byte[] bArr) {
        this.f1073a.write(bArr, 0, bArr.length);
        this.f1073a.flush();
    }
}
