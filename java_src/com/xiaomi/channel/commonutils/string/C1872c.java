package com.xiaomi.channel.commonutils.string;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.xiaomi.channel.commonutils.string.c */
public class C1872c {
    /* renamed from: a */
    private static String m6778a(byte b) {
        int i = (b & Byte.MAX_VALUE) + (b < 0 ? 128 : 0);
        return (i < 16 ? "0" : "") + Integer.toHexString(i).toLowerCase();
    }

    /* renamed from: a */
    public static String m6779a(String str) {
        byte[] digest;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            StringBuffer stringBuffer = new StringBuffer();
            instance.update(str.getBytes(), 0, str.length());
            for (byte b : instance.digest()) {
                stringBuffer.append(m6778a(b));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /* renamed from: b */
    public static String m6780b(String str) {
        return m6779a(str).subSequence(8, 24).toString();
    }
}
