package com.igexin.push.p032d.p035c;

import com.igexin.p012b.p013a.p015b.C0459f;

/* renamed from: com.igexin.push.d.c.a */
public class C0638a extends AbstractC0642e {

    /* renamed from: a */
    public int f1694a;

    /* renamed from: b */
    public int f1695b;

    /* renamed from: c */
    public Object f1696c;

    /* renamed from: d */
    public String f1697d;

    /* renamed from: e */
    public String f1698e = "UTF-8";

    /* renamed from: f */
    private int f1699f = 0;

    /* renamed from: g */
    private int f1700g = 0;

    public C0638a() {
        this.f1723i = 28;
    }

    /* renamed from: a */
    public int mo4680a() {
        return this.f1699f;
    }

    /* renamed from: a */
    public void mo4681a(int i) {
        this.f1699f = i;
    }

    @Override // com.igexin.push.p032d.p035c.AbstractC0642e
    /* renamed from: a */
    public void mo4682a(byte[] bArr) {
        int i;
        this.f1694a = C0459f.m1690c(bArr, 0);
        this.f1695b = bArr[2] & 192;
        this.f1698e = mo4695a(bArr[2]);
        int i2 = 3;
        int i3 = 0;
        while (true) {
            i = i3 | (bArr[i2] & Byte.MAX_VALUE);
            if ((bArr[i2] & 128) == 0) {
                break;
            }
            i3 = i << 7;
            i2++;
        }
        int i4 = i2 + 1;
        if (i > 0) {
            if (this.f1695b == 192) {
                this.f1696c = new byte[i];
                System.arraycopy(bArr, i4, this.f1696c, 0, i);
            } else {
                try {
                    this.f1696c = new String(bArr, i4, i, this.f1698e);
                } catch (Exception e) {
                }
            }
        }
        int i5 = i + i4;
        int i6 = bArr[i5] & 255;
        int i7 = i5 + 1;
        if (bArr.length > i7) {
            try {
                this.f1697d = new String(bArr, i7, i6, this.f1698e);
            } catch (Exception e2) {
            }
            int i8 = i7 + i6;
        }
    }

    /* renamed from: b */
    public void mo4683b(int i) {
        this.f1700g = i;
    }

    /* renamed from: c */
    public int mo4684c() {
        return this.f1700g;
    }

    @Override // com.igexin.push.p032d.p035c.AbstractC0642e
    /* renamed from: d */
    public byte[] mo4685d() {
        int i = 0;
        try {
            byte[] bytes = this.f1697d.getBytes(this.f1698e);
            byte[] bytes2 = !"".equals(this.f1696c) ? this.f1695b == 192 ? (byte[]) this.f1696c : ((String) this.f1696c).getBytes(this.f1698e) : null;
            if (bytes2 != null) {
                i = bytes2.length;
            }
            byte[] a = C0459f.m1682a(i);
            byte[] bArr = new byte[(a.length + 4 + i + bytes.length)];
            try {
                int b = C0459f.m1685b(this.f1694a, bArr, 0);
                int c = b + C0459f.m1689c(this.f1695b | mo4694a(this.f1698e), bArr, b);
                int a2 = c + C0459f.m1678a(a, 0, bArr, c, a.length);
                if (i > 0) {
                    a2 += C0459f.m1678a(bytes2, 0, bArr, a2, i);
                }
                int c2 = a2 + C0459f.m1689c(bytes.length, bArr, a2);
                int a3 = c2 + C0459f.m1678a(bytes, 0, bArr, c2, bytes.length);
                return bArr;
            } catch (Exception e) {
                return bArr;
            }
        } catch (Exception e2) {
            return null;
        }
    }
}
