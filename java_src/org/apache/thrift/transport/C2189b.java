package org.apache.thrift.transport;

import org.apache.thrift.C2162d;

/* renamed from: org.apache.thrift.transport.b */
public class C2189b extends AbstractC2191d {

    /* renamed from: a */
    private C2162d f6230a;

    /* renamed from: b */
    private int f6231b;

    public C2189b(int i) {
        this.f6230a = new C2162d(i);
    }

    @Override // org.apache.thrift.transport.AbstractC2191d
    /* renamed from: a */
    public int mo12168a(byte[] bArr, int i, int i2) {
        byte[] a = this.f6230a.mo12120a();
        if (i2 > this.f6230a.mo12121b() - this.f6231b) {
            i2 = this.f6230a.mo12121b() - this.f6231b;
        }
        if (i2 > 0) {
            System.arraycopy(a, this.f6231b, bArr, i, i2);
            this.f6231b += i2;
        }
        return i2;
    }

    /* renamed from: a_ */
    public int mo12170a_() {
        return this.f6230a.size();
    }

    @Override // org.apache.thrift.transport.AbstractC2191d
    /* renamed from: b */
    public void mo12169b(byte[] bArr, int i, int i2) {
        this.f6230a.write(bArr, i, i2);
    }
}
