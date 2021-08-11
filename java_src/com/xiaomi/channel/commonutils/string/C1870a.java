package com.xiaomi.channel.commonutils.string;

import com.tencent.qcloud.core.util.IOUtils;
import p000a.p001a.p002a.p004b.C0027o;

/* renamed from: com.xiaomi.channel.commonutils.string.a */
public class C1870a {

    /* renamed from: a */
    private static final String f4642a = System.getProperty("line.separator");

    /* renamed from: b */
    private static char[] f4643b = new char[64];

    /* renamed from: c */
    private static byte[] f4644c = new byte[128];

    static {
        char c = 'A';
        int i = 0;
        while (c <= 'Z') {
            f4643b[i] = c;
            c = (char) (c + 1);
            i++;
        }
        char c2 = 'a';
        while (c2 <= 'z') {
            f4643b[i] = c2;
            c2 = (char) (c2 + 1);
            i++;
        }
        char c3 = '0';
        while (c3 <= '9') {
            f4643b[i] = c3;
            c3 = (char) (c3 + 1);
            i++;
        }
        int i2 = i + 1;
        f4643b[i] = '+';
        int i3 = i2 + 1;
        f4643b[i2] = IOUtils.DIR_SEPARATOR_UNIX;
        for (int i4 = 0; i4 < f4644c.length; i4++) {
            f4644c[i4] = -1;
        }
        for (int i5 = 0; i5 < 64; i5++) {
            f4644c[f4643b[i5]] = (byte) i5;
        }
    }

    /* renamed from: a */
    public static byte[] m6771a(String str) {
        return m6772a(str.toCharArray());
    }

    /* renamed from: a */
    public static byte[] m6772a(char[] cArr) {
        return m6773a(cArr, 0, cArr.length);
    }

    /* renamed from: a */
    public static byte[] m6773a(char[] cArr, int i, int i2) {
        char c;
        int i3;
        char c2;
        int i4;
        int i5;
        if (i2 % 4 != 0) {
            throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
        }
        while (i2 > 0 && cArr[(i + i2) - 1] == '=') {
            i2--;
        }
        int i6 = (i2 * 3) / 4;
        byte[] bArr = new byte[i6];
        int i7 = i + i2;
        int i8 = 0;
        while (i < i7) {
            int i9 = i + 1;
            char c3 = cArr[i];
            int i10 = i9 + 1;
            char c4 = cArr[i9];
            if (i10 < i7) {
                c = cArr[i10];
                i10++;
            } else {
                c = 'A';
            }
            if (i10 < i7) {
                int i11 = i10 + 1;
                c2 = cArr[i10];
                i3 = i11;
            } else {
                i3 = i10;
                c2 = 'A';
            }
            if (c3 > 127 || c4 > 127 || c > 127 || c2 > 127) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            byte b = f4644c[c3];
            byte b2 = f4644c[c4];
            byte b3 = f4644c[c];
            byte b4 = f4644c[c2];
            if (b < 0 || b2 < 0 || b3 < 0 || b4 < 0) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            int i12 = (b << 2) | (b2 >>> 4);
            int i13 = ((b2 & C0027o.f104m) << 4) | (b3 >>> 2);
            int i14 = ((b3 & 3) << 6) | b4;
            int i15 = i8 + 1;
            bArr[i8] = (byte) i12;
            if (i15 < i6) {
                i4 = i15 + 1;
                bArr[i15] = (byte) i13;
            } else {
                i4 = i15;
            }
            if (i4 < i6) {
                i5 = i4 + 1;
                bArr[i4] = (byte) i14;
            } else {
                i5 = i4;
            }
            i8 = i5;
            i = i3;
        }
        return bArr;
    }

    /* renamed from: a */
    public static char[] m6774a(byte[] bArr) {
        return m6775a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static char[] m6775a(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6 = ((i2 * 4) + 2) / 3;
        char[] cArr = new char[(((i2 + 2) / 3) * 4)];
        int i7 = i + i2;
        int i8 = 0;
        while (i < i7) {
            int i9 = i + 1;
            int i10 = bArr[i] & 255;
            if (i9 < i7) {
                i3 = bArr[i9] & 255;
                i9++;
            } else {
                i3 = 0;
            }
            if (i9 < i7) {
                i4 = i9 + 1;
                i5 = bArr[i9] & 255;
            } else {
                i4 = i9;
                i5 = 0;
            }
            int i11 = i10 >>> 2;
            int i12 = ((i10 & 3) << 4) | (i3 >>> 4);
            int i13 = ((i3 & 15) << 2) | (i5 >>> 6);
            int i14 = i5 & 63;
            int i15 = i8 + 1;
            cArr[i8] = f4643b[i11];
            int i16 = i15 + 1;
            cArr[i15] = f4643b[i12];
            cArr[i16] = i16 < i6 ? f4643b[i13] : '=';
            int i17 = i16 + 1;
            cArr[i17] = i17 < i6 ? f4643b[i14] : '=';
            i8 = i17 + 1;
            i = i4;
        }
        return cArr;
    }
}
