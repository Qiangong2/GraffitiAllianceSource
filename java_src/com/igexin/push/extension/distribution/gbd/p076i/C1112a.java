package com.igexin.push.extension.distribution.gbd.p076i;

import com.tencent.qcloud.core.util.IOUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* renamed from: com.igexin.push.extension.distribution.gbd.i.a */
public final class C1112a {
    /* renamed from: a */
    public static String m4552a(byte[] bArr, int i, int i2) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        while (i < bArr.length) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < 3 && i < bArr.length) {
                int i6 = i5 | ((bArr[i] & 255) << (16 - (i4 << 3)));
                i++;
                i4++;
                i5 = i6;
            }
            if (i2 > 0 && i3 == i2) {
                sb.append(IOUtils.LINE_SEPARATOR_WINDOWS);
                i3 = 0;
            }
            char charAt = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((i5 << 8) >>> 26);
            sb.append(charAt).append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((i5 << 14) >>> 26)).append(i4 < 2 ? '=' : "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((i5 << 20) >>> 26)).append(i4 < 3 ? '=' : "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((i5 << 26) >>> 26));
            i3 += 4;
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static byte[] m4553a(char[] cArr, int i) {
        int i2;
        if (cArr == null || cArr.length == 0) {
            return null;
        }
        char[] cArr2 = new char[4];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(cArr.length >> 1);
        while (i < cArr.length) {
            int i3 = 0;
            while (i < cArr.length) {
                i++;
                char c = cArr[i];
                if ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(c) != -1 || c == '=') {
                    cArr2[i3] = c;
                    i3++;
                } else if (!(c == '\r' || c == '\n')) {
                    throw new IOException("bad BASE 64 In->");
                }
                if (i3 >= 4) {
                    boolean z = false;
                    for (int i4 = 0; i4 < 4; i4++) {
                        if (cArr2[i4] == '=' || !z) {
                            if (!z && cArr2[i4] == '=') {
                                z = true;
                            }
                        } else {
                            throw new IOException("bad BASE 64 In->");
                        }
                    }
                    if (cArr2[3] != '=') {
                        i2 = 3;
                    } else if (i < cArr.length) {
                        throw new IOException("bad BASE 64 In->");
                    } else {
                        i2 = cArr2[2] == '=' ? 1 : 2;
                    }
                    int i5 = 0;
                    for (int i6 = 0; i6 < 4; i6++) {
                        if (cArr2[i6] != '=') {
                            i5 |= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".indexOf(cArr2[i6]) << ((3 - i6) * 6);
                        }
                    }
                    for (int i7 = 0; i7 < i2; i7++) {
                        byteArrayOutputStream.write((i5 >>> ((2 - i7) * 8)) & 255);
                    }
                }
            }
            if (i3 <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            throw new IOException("bad BASE 64 In->");
        }
        byteArrayOutputStream.flush();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return byteArray;
    }
}
