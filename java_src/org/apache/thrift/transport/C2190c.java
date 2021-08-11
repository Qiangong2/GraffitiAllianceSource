package org.apache.thrift.transport;

/* renamed from: org.apache.thrift.transport.c */
public final class C2190c extends AbstractC2191d {

    /* renamed from: a */
    private byte[] f6232a;

    /* renamed from: b */
    private int f6233b;

    /* renamed from: c */
    private int f6234c;

    @Override // org.apache.thrift.transport.AbstractC2191d
    /* renamed from: a */
    public int mo12168a(byte[] bArr, int i, int i2) {
        int c = mo12175c();
        if (i2 > c) {
            i2 = c;
        }
        if (i2 > 0) {
            System.arraycopy(this.f6232a, this.f6233b, bArr, i, i2);
            mo12171a(i2);
        }
        return i2;
    }

    @Override // org.apache.thrift.transport.AbstractC2191d
    /* renamed from: a */
    public void mo12171a(int i) {
        this.f6233b += i;
    }

    /* renamed from: a */
    public void mo12172a(byte[] bArr) {
        mo12176c(bArr, 0, bArr.length);
    }

    @Override // org.apache.thrift.transport.AbstractC2191d
    /* renamed from: a */
    public byte[] mo12173a() {
        return this.f6232a;
    }

    @Override // org.apache.thrift.transport.AbstractC2191d
    /* renamed from: b */
    public int mo12174b() {
        return this.f6233b;
    }

    @Override // org.apache.thrift.transport.AbstractC2191d
    /* renamed from: b */
    public void mo12169b(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // org.apache.thrift.transport.AbstractC2191d
    /* renamed from: c */
    public int mo12175c() {
        return this.f6234c - this.f6233b;
    }

    /* renamed from: c */
    public void mo12176c(byte[] bArr, int i, int i2) {
        this.f6232a = bArr;
        this.f6233b = i;
        this.f6234c = i + i2;
    }
}
