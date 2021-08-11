package com.amap.loc;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.amap.loc.n */
/* compiled from: MD5 */
public class C0356n {
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005c A[SYNTHETIC, Splitter:B:29:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0085 A[SYNTHETIC, Splitter:B:42:0x0085] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m1302a(java.lang.String r6) {
        /*
        // Method dump skipped, instructions count: 151
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0356n.m1302a(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static String m1303a(byte[] bArr) {
        return C0363r.m1366d(m1306b(bArr));
    }

    /* renamed from: a */
    public static byte[] m1304a(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return instance.digest();
        } catch (Throwable th) {
            C0365t.m1372a(th, "MD5", "getMd5Bytes1");
            return null;
        }
    }

    /* renamed from: b */
    public static String m1305b(String str) {
        if (str == null) {
            return null;
        }
        return C0363r.m1366d(m1308d(str));
    }

    /* renamed from: b */
    private static byte[] m1306b(byte[] bArr) {
        return m1304a(bArr, "MD5");
    }

    /* renamed from: c */
    public static String m1307c(String str) {
        return C0363r.m1367e(m1309e(str));
    }

    /* renamed from: d */
    public static byte[] m1308d(String str) {
        try {
            return m1310f(str);
        } catch (Throwable th) {
            C0365t.m1372a(th, "MD5", "getMd5Bytes");
            return new byte[0];
        }
    }

    /* renamed from: e */
    private static byte[] m1309e(String str) {
        try {
            return m1310f(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    /* renamed from: f */
    private static byte[] m1310f(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(C0363r.m1358a(str));
        return instance.digest();
    }
}
