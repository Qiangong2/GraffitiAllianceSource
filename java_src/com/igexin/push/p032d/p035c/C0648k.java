package com.igexin.push.p032d.p035c;

import com.igexin.p012b.p013a.p015b.C0459f;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.igexin.push.d.c.k */
public class C0648k extends AbstractC0642e {

    /* renamed from: a */
    public long f1753a;

    /* renamed from: b */
    public byte f1754b;

    /* renamed from: c */
    public int f1755c;

    /* renamed from: d */
    public String f1756d;

    /* renamed from: e */
    public List<C0649l> f1757e;

    public C0648k() {
        this.f1723i = 4;
        this.f1724j = 20;
    }

    /* renamed from: a */
    private String m2518a(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, i, i2, "UTF-8");
        } catch (Exception e) {
            return "";
        }
    }

    @Override // com.igexin.push.p032d.p035c.AbstractC0642e
    /* renamed from: a */
    public void mo4682a(byte[] bArr) {
        int i;
        this.f1753a = C0459f.m1694e(bArr, 0);
        this.f1754b = bArr[8];
        this.f1755c = C0459f.m1692d(bArr, 9) & -1;
        if (bArr.length > 13) {
            i = 14;
            int i2 = bArr[13] & 255;
            if (i2 > 0) {
                this.f1757e = new ArrayList();
                int i3 = i2 + 14;
                while (i < i3) {
                    C0649l lVar = new C0649l();
                    this.f1757e.add(lVar);
                    int i4 = i + 1;
                    int a = C0459f.m1677a(bArr, i) & 255;
                    int i5 = i4 + 1;
                    int a2 = C0459f.m1677a(bArr, i4) & 255;
                    lVar.f1758a = (byte) a;
                    if ((a == 1 || a == 4) && a2 > 0) {
                        try {
                            lVar.f1759b = new String(bArr, i5, a2, "UTF-8");
                        } catch (Exception e) {
                        }
                    }
                    i = i5 + a2;
                }
            }
        } else {
            i = 13;
        }
        if (bArr.length > i) {
            this.f1756d = m2518a(bArr, i + 1, bArr[i] & 255);
        }
    }

    @Override // com.igexin.push.p032d.p035c.AbstractC0642e
    /* renamed from: d */
    public byte[] mo4685d() {
        byte[] bArr;
        int i;
        int i2;
        byte[] bArr2;
        byte[] bArr3 = null;
        if (this.f1757e == null || this.f1757e.size() <= 0) {
            bArr = null;
        } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (C0649l lVar : this.f1757e) {
                try {
                    byteArrayOutputStream.write(lVar.mo4685d());
                    bArr2 = byteArrayOutputStream.toByteArray();
                } catch (IOException e) {
                    bArr2 = bArr3;
                }
                bArr3 = bArr2;
            }
            try {
                byteArrayOutputStream.close();
                bArr = bArr3;
            } catch (IOException e2) {
                bArr = bArr3;
            }
        }
        if (bArr != null) {
            i2 = bArr.length;
            i = i2 + 1;
        } else {
            i = 1;
            i2 = 0;
        }
        byte[] bArr4 = new byte[(i + 12 + this.f1756d.getBytes().length + 1)];
        int a = C0459f.m1676a(this.f1753a, bArr4, 0);
        int a2 = a + C0459f.m1675a(((this.f1754b & 255) << 24) | this.f1755c, bArr4, a);
        int c = a2 + C0459f.m1689c(i2, bArr4, a2);
        int a3 = i2 > 0 ? C0459f.m1678a(bArr, 0, bArr4, c, i2) + c : c;
        byte[] bytes = this.f1756d.getBytes();
        int i3 = a3 + 1;
        C0459f.m1689c(bytes.length, bArr4, a3);
        System.arraycopy(bytes, 0, bArr4, i3, bytes.length);
        int length = bytes.length + i3;
        return bArr4;
    }
}
