package com.igexin.push.p032d.p035c;

import com.igexin.p012b.p013a.p015b.C0459f;

/* renamed from: com.igexin.push.d.c.n */
public class C0651n extends AbstractC0642e {

    /* renamed from: a */
    public long f1765a;

    public C0651n() {
        this.f1723i = 36;
        this.f1724j = 20;
    }

    @Override // com.igexin.push.p032d.p035c.AbstractC0642e
    /* renamed from: a */
    public void mo4682a(byte[] bArr) {
        this.f1765a = C0459f.m1694e(bArr, 0);
    }

    @Override // com.igexin.push.p032d.p035c.AbstractC0642e
    /* renamed from: d */
    public byte[] mo4685d() {
        byte[] bArr = new byte[8];
        C0459f.m1676a(this.f1765a, bArr, 0);
        return bArr;
    }
}
