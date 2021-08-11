package com.igexin.push.p032d.p035c;

import com.igexin.p012b.p013a.p015b.C0459f;
import com.igexin.push.util.EncryptUtils;

/* renamed from: com.igexin.push.d.c.b */
public class C0639b {

    /* renamed from: a */
    public int f1701a;

    /* renamed from: b */
    public byte f1702b;

    /* renamed from: c */
    public byte f1703c;

    /* renamed from: d */
    public byte f1704d;

    /* renamed from: e */
    public byte[] f1705e;

    /* renamed from: f */
    public int f1706f;

    /* renamed from: g */
    public byte f1707g;

    /* renamed from: a */
    public void mo4686a(byte[] bArr) {
        if (bArr == null) {
            this.f1701a = 0;
            return;
        }
        this.f1705e = bArr;
        this.f1701a = bArr.length;
    }

    /* renamed from: a */
    public byte[] mo4687a() {
        if (this.f1705e == null) {
            return null;
        }
        byte[] bArr = new byte[(this.f1701a + 11)];
        int a = C0459f.m1675a(EncryptUtils.getPacketId(), bArr, 0);
        int a2 = a + C0459f.m1675a((int) (System.currentTimeMillis() / 1000), bArr, a);
        int b = a2 + C0459f.m1685b(this.f1701a, bArr, a2);
        C0459f.m1678a(this.f1705e, 0, bArr, b + C0459f.m1689c(this.f1702b, bArr, b), this.f1705e.length);
        return bArr;
    }
}
