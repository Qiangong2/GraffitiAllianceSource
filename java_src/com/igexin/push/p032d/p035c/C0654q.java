package com.igexin.push.p032d.p035c;

import android.text.TextUtils;
import com.igexin.p012b.p013a.p015b.C0459f;

/* renamed from: com.igexin.push.d.c.q */
public class C0654q extends AbstractC0642e {

    /* renamed from: a */
    public long f1780a;

    /* renamed from: b */
    public String f1781b = "";

    /* renamed from: c */
    public String f1782c = "";

    /* renamed from: d */
    public String f1783d = "";

    public C0654q() {
        this.f1723i = 9;
    }

    /* renamed from: a */
    private String m2532a(byte[] bArr, int i, int i2) {
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
        this.f1780a = C0459f.m1694e(bArr, 0);
        if (bArr.length > 8) {
            i = 9;
            int i2 = bArr[8] & 255;
            if (i2 > 0) {
                this.f1781b = m2532a(bArr, 9, i2);
                i = i2 + 9;
            }
        } else {
            i = 8;
        }
        if (bArr.length > i) {
            int i3 = i + 1;
            int i4 = bArr[i] & 255;
            if (i4 > 0) {
                this.f1782c = m2532a(bArr, i3, i4);
                i = i4 + i3;
            } else {
                i = i3;
            }
        }
        if (bArr.length > i) {
            int i5 = i + 1;
            int i6 = bArr[i] & 255;
            if (i6 > 0) {
                this.f1783d = m2532a(bArr, i5, i6);
                int i7 = i6 + i5;
            }
        }
    }

    @Override // com.igexin.push.p032d.p035c.AbstractC0642e
    /* renamed from: d */
    public byte[] mo4685d() {
        if (TextUtils.isEmpty(this.f1782c) || TextUtils.isEmpty(this.f1783d)) {
            byte[] bytes = this.f1781b.getBytes();
            byte[] bArr = new byte[(bytes.length + 8 + 1)];
            C0459f.m1676a(this.f1780a, bArr, 0);
            C0459f.m1689c(bytes.length, bArr, 8);
            System.arraycopy(bytes, 0, bArr, 9, bytes.length);
            return bArr;
        }
        byte[] bytes2 = this.f1781b.getBytes();
        byte[] bytes3 = this.f1782c.getBytes();
        byte[] bytes4 = this.f1783d.getBytes();
        byte[] bArr2 = new byte[(bytes2.length + 8 + bytes3.length + bytes4.length + 3)];
        C0459f.m1676a(this.f1780a, bArr2, 0);
        C0459f.m1689c(bytes2.length, bArr2, 8);
        System.arraycopy(bytes2, 0, bArr2, 9, bytes2.length);
        int length = bytes2.length + 9;
        int i = length + 1;
        C0459f.m1689c(bytes3.length, bArr2, length);
        System.arraycopy(bytes3, 0, bArr2, i, bytes3.length);
        int length2 = bytes3.length + i;
        C0459f.m1689c(bytes4.length, bArr2, length2);
        System.arraycopy(bytes4, 0, bArr2, length2 + 1, bytes4.length);
        return bArr2;
    }
}
