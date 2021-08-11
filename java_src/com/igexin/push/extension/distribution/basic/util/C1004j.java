package com.igexin.push.extension.distribution.basic.util;

/* renamed from: com.igexin.push.extension.distribution.basic.util.j */
public class C1004j {

    /* renamed from: a */
    static final /* synthetic */ boolean f2545a = (!C1004j.class.desiredAssertionStatus());

    private C1004j() {
    }

    /* renamed from: a */
    public static byte[] m4040a(byte[] bArr, int i) {
        return m4041a(bArr, 0, bArr.length, i);
    }

    /* renamed from: a */
    public static byte[] m4041a(byte[] bArr, int i, int i2, int i3) {
        C1006l lVar = new C1006l(i3, new byte[((i2 * 3) / 4)]);
        if (!lVar.mo5648a(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (lVar.f2547b == lVar.f2546a.length) {
            return lVar.f2546a;
        } else {
            byte[] bArr2 = new byte[lVar.f2547b];
            System.arraycopy(lVar.f2546a, 0, bArr2, 0, lVar.f2547b);
            return bArr2;
        }
    }
}
