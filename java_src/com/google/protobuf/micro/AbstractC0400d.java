package com.google.protobuf.micro;

import java.io.IOException;

/* renamed from: com.google.protobuf.micro.d */
public abstract class AbstractC0400d {
    /* renamed from: a */
    public abstract int mo4054a();

    /* renamed from: a */
    public abstract AbstractC0400d mo4055a(C0396a aVar);

    /* renamed from: a */
    public AbstractC0400d mo4056a(byte[] bArr) {
        return mo4060b(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public abstract void mo4057a(C0397b bVar);

    /* renamed from: a */
    public void mo4058a(byte[] bArr, int i, int i2) {
        try {
            C0397b a = C0397b.m1455a(bArr, i, i2);
            mo4057a(a);
            a.mo4050c();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo4059a(C0396a aVar, int i) {
        return aVar.mo4024b(i);
    }

    /* renamed from: b */
    public AbstractC0400d mo4060b(byte[] bArr, int i, int i2) {
        try {
            C0396a a = C0396a.m1435a(bArr, i, i2);
            mo4055a(a);
            a.mo4022a(0);
            return this;
        } catch (C0399c e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    /* renamed from: b */
    public byte[] mo4061b() {
        byte[] bArr = new byte[mo4054a()];
        mo4058a(bArr, 0, bArr.length);
        return bArr;
    }
}
