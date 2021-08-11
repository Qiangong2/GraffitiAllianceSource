package com.igexin.p012b.p013a.p014a;

/* renamed from: com.igexin.b.a.a.a */
public class C0435a {
    /* renamed from: a */
    public static void m1572a(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }

    /* renamed from: a */
    public static boolean m1573a(byte[] bArr) {
        int length = bArr.length;
        if (length <= 0 || length > 256) {
            return false;
        }
        int i = 0;
        for (byte b : bArr) {
            if ((b & 255) == 14 && (i = i + 1) > 3) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static byte[] m1574a(byte[] bArr, String str) {
        return m1577c(bArr, str);
    }

    /* renamed from: a */
    public static byte[] m1575a(byte[] bArr, byte[] bArr2) {
        if (!m1573a(bArr2)) {
            throw new IllegalArgumentException("key is fail!");
        } else if (bArr.length < 1) {
            throw new IllegalArgumentException("data is fail!");
        } else {
            int[] iArr = new int[256];
            for (int i = 0; i < iArr.length; i++) {
                iArr[i] = i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < iArr.length; i3++) {
                i2 = ((i2 + iArr[i3]) + (bArr2[i3 % bArr2.length] & 255)) % 256;
                m1572a(iArr, i3, i2);
            }
            byte[] bArr3 = new byte[bArr.length];
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < bArr3.length; i6++) {
                i4 = (i4 + 1) % 256;
                i5 = (i5 + iArr[i4]) % 256;
                m1572a(iArr, i4, i5);
                bArr3[i6] = (byte) (iArr[(iArr[i4] + iArr[i5]) % 256] ^ bArr[i6]);
            }
            return bArr3;
        }
    }

    /* renamed from: b */
    public static byte[] m1576b(byte[] bArr, String str) {
        return m1578d(bArr, str);
    }

    /* renamed from: c */
    public static byte[] m1577c(byte[] bArr, String str) {
        return m1575a(bArr, str.getBytes());
    }

    /* renamed from: d */
    public static byte[] m1578d(byte[] bArr, String str) {
        return m1575a(bArr, str.getBytes());
    }
}
