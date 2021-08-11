package com.igexin.push.extension.distribution.basic.util;

import com.igexin.p012b.p013a.p015b.C0459f;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import p000a.p001a.p002a.p004b.C0027o;

/* renamed from: com.igexin.push.extension.distribution.basic.util.s */
public class C1013s {

    /* renamed from: a */
    private static final char[] f2567a = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* renamed from: a */
    public static String m4067a(String str) {
        MessageDigest messageDigest;
        int i = 0;
        byte[] bytes = str.getBytes();
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            messageDigest = null;
        }
        if (messageDigest == null) {
            return null;
        }
        messageDigest.update(bytes);
        byte[] digest = messageDigest.digest();
        char[] cArr2 = new char[32];
        for (int i2 = 0; i2 < 16; i2++) {
            byte b = digest[i2];
            int i3 = i + 1;
            cArr2[i] = cArr[(b >>> 4) & 15];
            i = i3 + 1;
            cArr2[i3] = cArr[b & C0027o.f104m];
        }
        return new String(cArr2);
    }

    /* renamed from: a */
    public static byte[] m4068a(byte[] bArr) {
        byte[] a;
        if (bArr == null || (a = C0459f.m1683a(bArr)) == null) {
            return null;
        }
        String a2 = m4067a(String.valueOf(System.currentTimeMillis()));
        int length = a.length;
        byte[] bArr2 = new byte[(length + 16)];
        byte[] bytes = a2.substring(0, 8).getBytes();
        byte[] bytes2 = a2.substring(24, 32).getBytes();
        System.arraycopy(bytes, 0, bArr2, 0, 8);
        System.arraycopy(a, 0, bArr2, 8, length);
        System.arraycopy(bytes2, 0, bArr2, length + 8, 8);
        return bArr2;
    }

    /* renamed from: b */
    public static boolean m4069b(String str) {
        return str != null && !str.equals("") && !str.equals("null");
    }

    /* renamed from: b */
    public static byte[] m4070b(byte[] bArr) {
        if (bArr == null || bArr.length < 16) {
            return null;
        }
        byte[] bArr2 = new byte[(bArr.length - 16)];
        System.arraycopy(bArr, 8, bArr2, 0, bArr.length - 16);
        return C0459f.m1688b(bArr2);
    }

    /* renamed from: c */
    public static boolean m4071c(String str) {
        return !m4069b(str);
    }

    /* renamed from: d */
    public static String m4072d(String str) {
        if (str == null) {
            return str;
        }
        try {
            return str.indexOf(".gtyl") > 0 ? str.substring(0, str.length() - ".gtyl".length()) : str;
        } catch (Throwable th) {
            return "";
        }
    }
}
