package org.apache.thrift.transport;

/* renamed from: org.apache.thrift.transport.d */
public abstract class AbstractC2191d {
    /* renamed from: a */
    public abstract int mo12168a(byte[] bArr, int i, int i2);

    /* renamed from: a */
    public void mo12171a(int i) {
    }

    /* renamed from: a */
    public byte[] mo12173a() {
        return null;
    }

    /* renamed from: b */
    public int mo12174b() {
        return 0;
    }

    /* renamed from: b */
    public void mo12177b(byte[] bArr) {
        mo12169b(bArr, 0, bArr.length);
    }

    /* renamed from: b */
    public abstract void mo12169b(byte[] bArr, int i, int i2);

    /* renamed from: c */
    public int mo12175c() {
        return -1;
    }

    /* renamed from: d */
    public int mo12178d(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int a = mo12168a(bArr, i + i3, i2 - i3);
            if (a <= 0) {
                throw new C2192e("Cannot read. Remote side has closed. Tried to read " + i2 + " bytes, but only got " + i3 + " bytes.");
            }
            i3 += a;
        }
        return i3;
    }
}
