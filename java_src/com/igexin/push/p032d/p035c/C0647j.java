package com.igexin.push.p032d.p035c;

/* renamed from: com.igexin.push.d.c.j */
public class C0647j extends AbstractC0642e {

    /* renamed from: a */
    public byte f1751a;

    /* renamed from: b */
    public byte f1752b;

    public C0647j() {
        this.f1723i = 97;
    }

    @Override // com.igexin.push.p032d.p035c.AbstractC0642e
    /* renamed from: a */
    public void mo4682a(byte[] bArr) {
        this.f1751a = bArr[0];
        this.f1752b = bArr[1];
    }

    @Override // com.igexin.push.p032d.p035c.AbstractC0642e
    /* renamed from: d */
    public byte[] mo4685d() {
        return new byte[]{this.f1751a, this.f1752b};
    }
}
