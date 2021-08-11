package com.igexin.push.p032d.p035c;

import com.igexin.p012b.p013a.p015b.C0459f;
import com.igexin.push.p079f.p081b.C1144b;

/* renamed from: com.igexin.push.d.c.c */
public class C0640c extends AbstractC0642e {

    /* renamed from: a */
    public int f1708a;

    /* renamed from: b */
    public int f1709b;

    /* renamed from: c */
    public Object f1710c;

    /* renamed from: d */
    public String f1711d;

    /* renamed from: e */
    public String f1712e = "UTF-8";

    /* renamed from: f */
    public int f1713f = 1;

    /* renamed from: g */
    public C1144b f1714g;

    public C0640c() {
        this.f1723i = 27;
        this.f1724j = 20;
    }

    /* renamed from: a */
    public final void mo4688a() {
        this.f1709b = 64;
    }

    /* renamed from: a */
    public void mo4689a(int i) {
        this.f1713f = i;
    }

    /* renamed from: a */
    public void mo4690a(C1144b bVar) {
        this.f1714g = bVar;
    }

    @Override // com.igexin.push.p032d.p035c.AbstractC0642e
    /* renamed from: a */
    public void mo4682a(byte[] bArr) {
        int i;
        this.f1708a = C0459f.m1690c(bArr, 0);
        this.f1709b = bArr[2] & 192;
        this.f1712e = mo4695a(bArr[2]);
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
            if (this.f1709b == 192) {
                this.f1710c = new byte[i];
                System.arraycopy(bArr, i4, this.f1710c, 0, i);
            } else {
                try {
                    this.f1710c = new String(bArr, i4, i, this.f1712e);
                } catch (Exception e) {
                }
            }
        }
        int i5 = i + i4;
        int i6 = bArr[i5] & 255;
        int i7 = i5 + 1;
        if (bArr.length > i7) {
            try {
                this.f1711d = new String(bArr, i7, i6, this.f1712e);
            } catch (Exception e2) {
            }
            int i8 = i7 + i6;
        }
    }

    /* renamed from: c */
    public int mo4691c() {
        return this.f1713f;
    }

    @Override // com.igexin.push.p032d.p035c.AbstractC0642e
    /* renamed from: d */
    public byte[] mo4685d() {
        byte[] bArr;
        int i = 0;
        try {
            byte[] bytes = this.f1711d.getBytes(this.f1712e);
            byte[] bytes2 = !"".equals(this.f1710c) ? this.f1709b == 192 ? (byte[]) this.f1710c : ((String) this.f1710c).getBytes(this.f1712e) : null;
            if (bytes2 != null) {
                i = bytes2.length;
            }
            byte[] a = C0459f.m1682a(i);
            bArr = new byte[(a.length + 4 + i + bytes.length)];
            try {
                int b = C0459f.m1685b(this.f1708a, bArr, 0);
                int c = b + C0459f.m1689c(this.f1709b | mo4694a(this.f1712e), bArr, b);
                int a2 = c + C0459f.m1678a(a, 0, bArr, c, a.length);
                if (i > 0) {
                    a2 += C0459f.m1678a(bytes2, 0, bArr, a2, i);
                }
                int c2 = a2 + C0459f.m1689c(bytes.length, bArr, a2);
                int a3 = c2 + C0459f.m1678a(bytes, 0, bArr, c2, bytes.length);
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

    /* renamed from: e */
    public C1144b mo4692e() {
        return this.f1714g;
    }
}
