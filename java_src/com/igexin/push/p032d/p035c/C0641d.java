package com.igexin.push.p032d.p035c;

import com.igexin.p012b.p013a.p015b.C0459f;

/* renamed from: com.igexin.push.d.c.d */
public class C0641d extends AbstractC0642e {

    /* renamed from: a */
    public int f1715a;

    /* renamed from: b */
    public int f1716b;

    /* renamed from: c */
    public long f1717c;

    /* renamed from: d */
    public String f1718d;

    /* renamed from: e */
    public Object f1719e;

    /* renamed from: f */
    public Object f1720f;

    /* renamed from: g */
    public String f1721g = "";

    /* renamed from: h */
    public String f1722h = "UTF-8";

    public C0641d() {
        this.f1723i = 25;
        this.f1724j = 20;
    }

    /* renamed from: a */
    public final void mo4693a() {
        this.f1716b = 128;
    }

    @Override // com.igexin.push.p032d.p035c.AbstractC0642e
    /* renamed from: a */
    public void mo4682a(byte[] bArr) {
        int i;
        int i2;
        this.f1715a = C0459f.m1690c(bArr, 0);
        this.f1716b = bArr[2] & 192;
        this.f1722h = mo4695a(bArr[2]);
        this.f1717c = C0459f.m1694e(bArr, 3);
        int i3 = bArr[11] & 255;
        try {
            this.f1718d = new String(bArr, 12, i3, this.f1722h);
        } catch (Exception e) {
        }
        int i4 = i3 + 12;
        int i5 = 0;
        while (true) {
            i = i5 | (bArr[i4] & Byte.MAX_VALUE);
            if ((bArr[i4] & 128) == 0) {
                break;
            }
            i5 = i << 7;
            i4++;
        }
        int i6 = i4 + 1;
        if (i > 0) {
            if (this.f1716b == 192) {
                this.f1719e = new byte[i];
                System.arraycopy(bArr, i6, this.f1719e, 0, i);
            } else {
                try {
                    this.f1719e = new String(bArr, i6, i, this.f1722h);
                } catch (Exception e2) {
                }
            }
        }
        int i7 = i + i6;
        int i8 = 0;
        while (true) {
            i2 = i8 | (bArr[i7] & Byte.MAX_VALUE);
            if ((bArr[i7] & 128) == 0) {
                break;
            }
            i8 = i2 << 7;
            i7++;
        }
        int i9 = i7 + 1;
        if (i2 > 0) {
            this.f1720f = new byte[i2];
            System.arraycopy(bArr, i9, this.f1720f, 0, i2);
        }
        int i10 = i2 + i9;
        if (bArr.length > i10) {
            int i11 = i10 + 1;
            int i12 = bArr[i10] & 255;
            try {
                this.f1721g = new String(bArr, i11, i12, this.f1722h);
            } catch (Exception e3) {
            }
            int i13 = i12 + i11;
        }
    }

    @Override // com.igexin.push.p032d.p035c.AbstractC0642e
    /* renamed from: d */
    public byte[] mo4685d() {
        byte[] bArr;
        int i = 0;
        try {
            byte[] bytes = this.f1718d.getBytes(this.f1722h);
            byte[] bytes2 = !"".equals(this.f1719e) ? this.f1716b == 192 ? (byte[]) this.f1719e : ((String) this.f1719e).getBytes(this.f1722h) : null;
            byte[] bArr2 = this.f1720f != null ? (byte[]) this.f1720f : null;
            byte[] bytes3 = this.f1721g.getBytes(this.f1722h);
            int length = bytes2 == null ? 0 : bytes2.length;
            if (bArr2 != null) {
                i = bArr2.length;
            }
            byte[] a = C0459f.m1682a(length);
            byte[] a2 = C0459f.m1682a(i);
            bArr = new byte[(bytes.length + 13 + a.length + length + a2.length + i + bytes3.length)];
            try {
                int b = C0459f.m1685b(this.f1715a, bArr, 0);
                int c = b + C0459f.m1689c(this.f1716b | mo4694a(this.f1722h), bArr, b);
                int a3 = c + C0459f.m1676a(this.f1717c, bArr, c);
                int c2 = a3 + C0459f.m1689c(bytes.length, bArr, a3);
                int a4 = c2 + C0459f.m1678a(bytes, 0, bArr, c2, bytes.length);
                int a5 = a4 + C0459f.m1678a(a, 0, bArr, a4, a.length);
                if (length > 0) {
                    a5 += C0459f.m1678a(bytes2, 0, bArr, a5, length);
                }
                int a6 = a5 + C0459f.m1678a(a2, 0, bArr, a5, a2.length);
                if (i > 0) {
                    a6 += C0459f.m1678a(bArr2, 0, bArr, a6, i);
                }
                int c3 = a6 + C0459f.m1689c(bytes3.length, bArr, a6);
                int a7 = c3 + C0459f.m1678a(bytes3, 0, bArr, c3, bytes3.length);
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            bArr = null;
        }
        if (bArr != null && bArr.length >= 512) {
            this.f1724j = (byte) (this.f1724j | 128);
        }
        return bArr;
    }
}
