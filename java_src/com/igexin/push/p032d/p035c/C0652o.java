package com.igexin.push.p032d.p035c;

import com.igexin.p012b.p013a.p015b.C0459f;

/* renamed from: com.igexin.push.d.c.o */
public class C0652o extends AbstractC0642e {

    /* renamed from: a */
    public boolean f1766a;

    /* renamed from: b */
    public boolean f1767b;

    /* renamed from: c */
    public String f1768c;

    /* renamed from: d */
    public String f1769d;

    /* renamed from: e */
    public long f1770e;

    public C0652o() {
        this.f1723i = 37;
    }

    @Override // com.igexin.push.p032d.p035c.AbstractC0642e
    /* renamed from: a */
    public void mo4682a(byte[] bArr) {
        int i = 1;
        boolean z = false;
        byte b = bArr[0];
        this.f1766a = (b & 64) != 0;
        if ((b & 128) != 0) {
            z = true;
        }
        this.f1767b = z;
        if (this.f1767b) {
            this.f1768c = mo4695a(b);
            int c = C0459f.m1690c(bArr, 1);
            i = c + 2 + 1;
            try {
                this.f1769d = new String(bArr, 3, c, this.f1768c);
            } catch (Exception e) {
            }
        }
        if (bArr.length > i) {
            this.f1770e = C0459f.m1694e(bArr, i);
            int i2 = i + 8;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034  */
    @Override // com.igexin.push.p032d.p035c.AbstractC0642e
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] mo4685d() {
        /*
            r7 = this;
            r1 = 0
            r2 = 1
            r3 = 0
            boolean r0 = r7.f1766a
            if (r0 == 0) goto L_0x0056
            r0 = 64
            byte r0 = (byte) r0
        L_0x000a:
            boolean r4 = r7.f1767b
            if (r4 == 0) goto L_0x0050
            r0 = r0 | 128(0x80, float:1.794E-43)
            byte r4 = (byte) r0
            r2 = 3
            java.lang.String r0 = r7.f1769d     // Catch:{ Exception -> 0x0047 }
            java.lang.String r5 = r7.f1768c     // Catch:{ Exception -> 0x0047 }
            byte[] r0 = r0.getBytes(r5)     // Catch:{ Exception -> 0x0047 }
            int r2 = r0.length     // Catch:{ Exception -> 0x004c }
            int r3 = r2 + 3
        L_0x001d:
            java.lang.String r5 = r7.f1768c
            int r5 = r7.mo4694a(r5)
            r4 = r4 | r5
            byte r4 = (byte) r4
            r6 = r4
            r4 = r3
            r3 = r6
        L_0x0028:
            int r4 = r4 + 8
            byte[] r4 = new byte[r4]
            int r3 = com.igexin.p012b.p013a.p015b.C0459f.m1689c(r3, r4, r1)
            boolean r5 = r7.f1767b
            if (r5 == 0) goto L_0x004e
            int r3 = com.igexin.p012b.p013a.p015b.C0459f.m1685b(r2, r4, r3)
            if (r0 == 0) goto L_0x004e
            int r0 = com.igexin.p012b.p013a.p015b.C0459f.m1678a(r0, r1, r4, r3, r2)
            int r0 = r0 + r3
        L_0x003f:
            long r2 = r7.f1770e
            int r1 = com.igexin.p012b.p013a.p015b.C0459f.m1676a(r2, r4, r0)
            int r0 = r0 + r1
            return r4
        L_0x0047:
            r0 = move-exception
            r0 = r3
        L_0x0049:
            r3 = r2
            r2 = r1
            goto L_0x001d
        L_0x004c:
            r3 = move-exception
            goto L_0x0049
        L_0x004e:
            r0 = r3
            goto L_0x003f
        L_0x0050:
            r4 = r2
            r2 = r1
            r6 = r0
            r0 = r3
            r3 = r6
            goto L_0x0028
        L_0x0056:
            r0 = r1
            goto L_0x000a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.p032d.p035c.C0652o.mo4685d():byte[]");
    }
}
