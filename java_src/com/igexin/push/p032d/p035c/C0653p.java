package com.igexin.push.p032d.p035c;

import com.igexin.p012b.p013a.p015b.C0459f;

/* renamed from: com.igexin.push.d.c.p */
public class C0653p extends AbstractC0642e {

    /* renamed from: m */
    private static final String f1771m = C0653p.class.getName();

    /* renamed from: a */
    public int f1772a;

    /* renamed from: b */
    public int f1773b;

    /* renamed from: c */
    public long f1774c;

    /* renamed from: d */
    public String f1775d;

    /* renamed from: e */
    public Object f1776e;

    /* renamed from: f */
    public Object f1777f;

    /* renamed from: g */
    public String f1778g;

    /* renamed from: h */
    public String f1779h = "UTF-8";

    public C0653p() {
        this.f1723i = 26;
    }

    @Override // com.igexin.push.p032d.p035c.AbstractC0642e
    /* renamed from: a */
    public void mo4682a(byte[] bArr) {
        int i;
        int i2;
        this.f1772a = C0459f.m1690c(bArr, 0);
        this.f1773b = bArr[2] & 192;
        this.f1779h = mo4695a(bArr[2]);
        this.f1774c = C0459f.m1694e(bArr, 3);
        int i3 = bArr[11] & 255;
        try {
            this.f1775d = new String(bArr, 12, i3, this.f1779h);
        } catch (Exception e) {
            this.f1775d = "";
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
            if (this.f1773b == 192) {
                this.f1776e = new byte[i];
                System.arraycopy(bArr, i6, this.f1776e, 0, i);
            } else {
                try {
                    this.f1776e = new String(bArr, i6, i, this.f1779h);
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
            this.f1777f = new byte[i2];
            System.arraycopy(bArr, i9, this.f1777f, 0, i2);
        }
        int i10 = i2 + i9;
        if (bArr.length > i10) {
            int i11 = i10 + 1;
            int i12 = bArr[i10] & 255;
            try {
                this.f1778g = new String(bArr, i11, i12, this.f1779h);
            } catch (Exception e3) {
            }
            int i13 = i12 + i11;
        }
    }

    /* renamed from: a */
    public final boolean mo4700a() {
        return this.f1773b == 128;
    }

    @Override // com.igexin.push.p032d.p035c.AbstractC0642e
    /* renamed from: d */
    public byte[] mo4685d() {
        int i = 0;
        try {
            byte[] bytes = this.f1775d.getBytes(this.f1779h);
            byte[] bytes2 = this.f1778g.getBytes(this.f1779h);
            byte[] bytes3 = !"".equals(this.f1776e) ? this.f1773b == 192 ? (byte[]) this.f1776e : ((String) this.f1776e).getBytes(this.f1779h) : null;
            byte[] bArr = this.f1777f != null ? (byte[]) this.f1777f : null;
            int length = bytes3 == null ? 0 : bytes3.length;
            if (bArr != null) {
                i = bArr.length;
            }
            byte[] a = C0459f.m1682a(length);
            byte[] a2 = C0459f.m1682a(i);
            byte[] bArr2 = new byte[(bytes.length + 13 + a.length + length + a2.length + i + bytes2.length)];
            try {
                int b = C0459f.m1685b(this.f1772a, bArr2, 0);
                int c = b + C0459f.m1689c(this.f1773b | mo4694a(this.f1779h), bArr2, b);
                int a3 = c + C0459f.m1676a(this.f1774c, bArr2, c);
                int c2 = a3 + C0459f.m1689c(bytes.length, bArr2, a3);
                int a4 = c2 + C0459f.m1678a(bytes, 0, bArr2, c2, bytes.length);
                int a5 = a4 + C0459f.m1678a(a, 0, bArr2, a4, a.length);
                if (length > 0) {
                    a5 += C0459f.m1678a(bytes3, 0, bArr2, a5, length);
                }
                int a6 = a5 + C0459f.m1678a(a2, 0, bArr2, a5, a2.length);
                if (i > 0) {
                    a6 += C0459f.m1678a(bArr, 0, bArr2, a6, i);
                }
                int c3 = a6 + C0459f.m1689c(bytes2.length, bArr2, a6);
                int a7 = c3 + C0459f.m1678a(bytes2, 0, bArr2, c3, bytes2.length);
                return bArr2;
            } catch (Exception e) {
                return bArr2;
            }
        } catch (Exception e2) {
            return null;
        }
    }
}
