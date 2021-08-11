package com.igexin.push.util;

import java.io.UnsupportedEncodingException;

/* renamed from: com.igexin.push.util.i */
public class C1159i {

    /* renamed from: a */
    static final /* synthetic */ boolean f3024a = (!C1159i.class.desiredAssertionStatus());

    private C1159i() {
    }

    /* renamed from: a */
    public static byte[] m4777a(String str, int i) {
        return m4778a(str.getBytes(), i);
    }

    /* renamed from: a */
    public static byte[] m4778a(byte[] bArr, int i) {
        return m4779a(bArr, 0, bArr.length, i);
    }

    /* renamed from: a */
    public static byte[] m4779a(byte[] bArr, int i, int i2, int i3) {
        C1161k kVar = new C1161k(i3, new byte[((i2 * 3) / 4)]);
        if (!kVar.mo5907a(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (kVar.f3026b == kVar.f3025a.length) {
            return kVar.f3025a;
        } else {
            byte[] bArr2 = new byte[kVar.f3026b];
            System.arraycopy(kVar.f3025a, 0, bArr2, 0, kVar.f3026b);
            return bArr2;
        }
    }

    /* renamed from: b */
    public static String m4780b(byte[] bArr, int i) {
        try {
            return new String(m4782c(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: b */
    public static byte[] m4781b(byte[] bArr, int i, int i2, int i3) {
        C1162l lVar = new C1162l(i3, null);
        int i4 = (i2 / 3) * 4;
        if (!lVar.f3036d) {
            switch (i2 % 3) {
                case 1:
                    i4 += 2;
                    break;
                case 2:
                    i4 += 3;
                    break;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (lVar.f3037e && i2 > 0) {
            i4 += (lVar.f3038f ? 2 : 1) * (((i2 - 1) / 57) + 1);
        }
        lVar.f3025a = new byte[i4];
        lVar.mo5908a(bArr, i, i2, true);
        if (f3024a || lVar.f3026b == i4) {
            return lVar.f3025a;
        }
        throw new AssertionError();
    }

    /* renamed from: c */
    public static byte[] m4782c(byte[] bArr, int i) {
        return m4781b(bArr, 0, bArr.length, i);
    }
}
