package com.igexin.push.p032d.p035c;

import com.igexin.p012b.p013a.p015b.C0459f;

/* renamed from: com.igexin.push.d.c.f */
public class C0643f extends AbstractC0642e {

    /* renamed from: a */
    String f1726a;

    /* renamed from: b */
    String f1727b;

    /* renamed from: c */
    String f1728c;

    /* renamed from: d */
    String f1729d;

    public C0643f() {
        this.f1723i = 6;
        this.f1724j = 20;
        this.f1726a = "";
        this.f1727b = "";
        this.f1728c = "";
        this.f1729d = "";
    }

    public C0643f(String str, String str2, String str3, String str4) {
        this.f1723i = 6;
        this.f1724j = 20;
        this.f1726a = str == null ? "" : str;
        this.f1727b = str2 == null ? "" : str2;
        this.f1728c = str3 == null ? "" : str3;
        this.f1729d = str4 == null ? "" : str4;
    }

    /* renamed from: a */
    public String mo4696a() {
        return this.f1728c;
    }

    @Override // com.igexin.push.p032d.p035c.AbstractC0642e
    /* renamed from: a */
    public void mo4682a(byte[] bArr) {
        try {
            int a = C0459f.m1677a(bArr, 0);
            this.f1726a = new String(bArr, 1, a, "utf-8");
            int i = a + 1;
            int a2 = C0459f.m1677a(bArr, i);
            int i2 = i + 1;
            this.f1727b = new String(bArr, i2, a2, "utf-8");
            int i3 = i2 + a2;
            int a3 = C0459f.m1677a(bArr, i3);
            int i4 = i3 + 1;
            this.f1728c = new String(bArr, i4, a3, "utf-8");
            int i5 = i4 + a3;
            int a4 = C0459f.m1677a(bArr, i5);
            int i6 = i5 + 1;
            this.f1729d = new String(bArr, i6, a4, "utf-8");
            int i7 = i6 + a4;
        } catch (Exception e) {
        }
    }

    @Override // com.igexin.push.p032d.p035c.AbstractC0642e
    /* renamed from: d */
    public byte[] mo4685d() {
        byte[] bytes = this.f1727b.getBytes();
        byte[] bytes2 = this.f1726a.getBytes();
        byte[] bytes3 = this.f1728c.getBytes();
        byte[] bytes4 = this.f1729d.getBytes();
        byte[] bArr = new byte[(bytes.length + bytes2.length + bytes3.length + bytes4.length + 4)];
        C0459f.m1689c(bytes.length, bArr, 0);
        System.arraycopy(bytes, 0, bArr, 1, bytes.length);
        int length = bytes.length + 1;
        int i = length + 1;
        C0459f.m1689c(bytes2.length, bArr, length);
        System.arraycopy(bytes2, 0, bArr, i, bytes2.length);
        int length2 = bytes2.length + i;
        int i2 = length2 + 1;
        C0459f.m1689c(bytes3.length, bArr, length2);
        System.arraycopy(bytes3, 0, bArr, i2, bytes3.length);
        int length3 = bytes3.length + i2;
        int i3 = length3 + 1;
        C0459f.m1689c(bytes4.length, bArr, length3);
        System.arraycopy(bytes4, 0, bArr, i3, bytes4.length);
        int length4 = bytes4.length + i3;
        return bArr;
    }
}
