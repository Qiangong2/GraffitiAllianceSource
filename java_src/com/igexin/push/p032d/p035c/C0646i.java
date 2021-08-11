package com.igexin.push.p032d.p035c;

import com.igexin.p012b.p013a.p015b.C0459f;
import com.igexin.push.util.EncryptUtils;
import p000a.p001a.p002a.p004b.C0027o;

/* renamed from: com.igexin.push.d.c.i */
public class C0646i extends AbstractC0642e {

    /* renamed from: a */
    public String f1747a;

    /* renamed from: b */
    public byte[] f1748b;

    /* renamed from: c */
    public byte f1749c;

    /* renamed from: d */
    public String f1750d;

    public C0646i() {
        this.f1723i = 96;
        this.f1724j = 4;
        this.f1725k = (byte) (this.f1725k | C0027o.f105n);
    }

    /* renamed from: a */
    private String m2513a(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, i, i2, "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    @Override // com.igexin.push.p032d.p035c.AbstractC0642e
    /* renamed from: a */
    public void mo4682a(byte[] bArr) {
        try {
            this.f1749c = bArr[0];
            int i = bArr[1] & 255;
            this.f1747a = m2513a(bArr, 2, i);
            int i2 = i + 2;
            int i3 = i2 + 1;
            int i4 = bArr[i2] & 255;
            this.f1748b = new byte[i4];
            System.arraycopy(bArr, i3, this.f1748b, 0, i4);
            int i5 = i4 + i3;
            this.f1750d = m2513a(bArr, i5 + 1, bArr[i5] & 255);
        } catch (Exception e) {
        }
    }

    @Override // com.igexin.push.p032d.p035c.AbstractC0642e
    /* renamed from: d */
    public byte[] mo4685d() {
        byte[] bytes = this.f1747a.getBytes();
        byte[] iv = EncryptUtils.getIV(C0459f.m1687b((int) (System.currentTimeMillis() / 1000)));
        byte[] socketAESKey = EncryptUtils.getSocketAESKey();
        byte[] bArr = new byte[(bytes.length + 2 + 2 + socketAESKey.length + 1 + iv.length)];
        int c = C0459f.m1689c(0, bArr, 0);
        int c2 = c + C0459f.m1689c((byte) bytes.length, bArr, c);
        int a = C0459f.m1678a(bytes, 0, bArr, c2, bytes.length) + c2;
        int b = a + C0459f.m1685b((short) socketAESKey.length, bArr, a);
        int a2 = b + C0459f.m1678a(socketAESKey, 0, bArr, b, socketAESKey.length);
        int c3 = a2 + C0459f.m1689c((byte) iv.length, bArr, a2);
        int a3 = c3 + C0459f.m1678a(iv, 0, bArr, c3, iv.length);
        return bArr;
    }
}
