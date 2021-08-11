package com.igexin.p012b.p022b;

import com.igexin.p012b.p013a.p015b.C0459f;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import p000a.p001a.p002a.p004b.C0027o;

/* renamed from: com.igexin.b.b.a */
public class C0476a {

    /* renamed from: a */
    private static final char[] f1173a = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* renamed from: a */
    public static String m1772a(int i) {
        int i2 = i < 0 ? 100 : i;
        if (i2 > 100) {
            i2 = 10;
        }
        Random random = new Random();
        char[] cArr = new char[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            cArr[i3] = f1173a[random.nextInt(f1173a.length)];
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public static String m1773a(String str) {
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
    public static boolean m1774a(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    /* renamed from: a */
    public static byte[] m1775a(byte[] bArr) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            messageDigest = null;
        }
        if (messageDigest == null) {
            return null;
        }
        messageDigest.update(bArr);
        return messageDigest.digest();
    }

    /* renamed from: b */
    public static byte[] m1776b(byte[] bArr) {
        byte[] c;
        if (bArr == null || (c = C0459f.m1691c(bArr)) == null) {
            return null;
        }
        String a = m1773a(String.valueOf(System.currentTimeMillis()));
        int length = c.length;
        byte[] bArr2 = new byte[(length + 16)];
        byte[] bytes = a.substring(0, 8).getBytes();
        byte[] bytes2 = a.substring(24, 32).getBytes();
        System.arraycopy(bytes, 0, bArr2, 0, 8);
        System.arraycopy(c, 0, bArr2, 8, length);
        System.arraycopy(bytes2, 0, bArr2, length + 8, 8);
        return bArr2;
    }

    /* renamed from: c */
    public static byte[] m1777c(byte[] bArr) {
        if (bArr == null || bArr.length < 16) {
            return null;
        }
        byte[] bArr2 = new byte[(bArr.length - 16)];
        System.arraycopy(bArr, 8, bArr2, 0, bArr.length - 16);
        return C0459f.m1693d(bArr2);
    }
}
