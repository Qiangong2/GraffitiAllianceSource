package com.amap.loc;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.amap.loc.r */
/* compiled from: Utils */
public class C0363r {

    /* renamed from: a */
    static String f916a;

    static {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 80; i++) {
            sb.append(SimpleComparison.EQUAL_TO_OPERATION);
        }
        f916a = sb.toString();
    }

    /* renamed from: a */
    public static String m1348a(long j) {
        try {
            return new SimpleDateFormat("yyyyMMdd HH:mm:ss:SSS", Locale.CHINA).format(new Date(j));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0033 A[SYNTHETIC, Splitter:B:22:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0038 A[SYNTHETIC, Splitter:B:25:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0047 A[SYNTHETIC, Splitter:B:32:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x004c A[SYNTHETIC, Splitter:B:35:0x004c] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m1349a(java.lang.Throwable r4) {
        /*
        // Method dump skipped, instructions count: 113
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0363r.m1349a(java.lang.Throwable):java.lang.String");
    }

    /* renamed from: a */
    static String m1350a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey());
            sb.append(SimpleComparison.EQUAL_TO_OPERATION);
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m1351a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return new String(bArr);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0049 A[SYNTHETIC, Splitter:B:23:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0054 A[SYNTHETIC, Splitter:B:29:0x0054] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.security.PublicKey m1352a(android.content.Context r5) throws java.security.cert.CertificateException, java.security.spec.InvalidKeySpecException, java.security.NoSuchAlgorithmException, java.lang.NullPointerException, java.io.IOException {
        /*
            r0 = 0
            java.lang.String r1 = "MIICnjCCAgegAwIBAgIJAJ0Pdzos7ZfYMA0GCSqGSIb3DQEBBQUAMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjAeFw0xMzA4MTUwNzU2NTVaFw0yMzA4MTMwNzU2NTVaMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA8eWAyHbFPoFPfdx5AD+D4nYFq4dbJ1p7SIKt19Oz1oivF/6H43v5Fo7s50pD1UF8+Qu4JoUQxlAgOt8OCyQ8DYdkaeB74XKb1wxkIYg/foUwN1CMHPZ9O9ehgna6K4EJXZxR7Y7XVZnbjHZIVn3VpPU/Rdr2v37LjTw+qrABJxMCAwEAAaNQME4wHQYDVR0OBBYEFOM/MLGP8xpVFuVd+3qZkw7uBvOTMB8GA1UdIwQYMBaAFOM/MLGP8xpVFuVd+3qZkw7uBvOTMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEA4LY3g8aAD8JkxAOqUXDDyLuCCGOc2pTIhn0TwMNaVdH4hZlpTeC/wuRD5LJ0z3j+IQ0vLvuQA5uDjVyEOlBrvVIGwSem/1XGUo13DfzgAJ5k1161S5l+sFUo5TxpHOXr8Z5nqJMjieXmhnE/I99GFyHpQmw4cC6rhYUhdhtg+Zk="
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ Throwable -> 0x0042, all -> 0x004f }
            byte[] r1 = com.amap.loc.C0355m.m1299b(r1)     // Catch:{ Throwable -> 0x0042, all -> 0x004f }
            r2.<init>(r1)     // Catch:{ Throwable -> 0x0042, all -> 0x004f }
            java.lang.String r1 = "X.509"
            java.security.cert.CertificateFactory r1 = java.security.cert.CertificateFactory.getInstance(r1)     // Catch:{ Throwable -> 0x0061 }
            java.lang.String r3 = "RSA"
            java.security.KeyFactory r3 = java.security.KeyFactory.getInstance(r3)     // Catch:{ Throwable -> 0x0061 }
            java.security.cert.Certificate r1 = r1.generateCertificate(r2)     // Catch:{ Throwable -> 0x0061 }
            if (r1 == 0) goto L_0x0020
            if (r3 != 0) goto L_0x0026
        L_0x0020:
            if (r2 == 0) goto L_0x0025
            r2.close()     // Catch:{ Throwable -> 0x005d }
        L_0x0025:
            return r0
        L_0x0026:
            java.security.spec.X509EncodedKeySpec r4 = new java.security.spec.X509EncodedKeySpec
            java.security.PublicKey r1 = r1.getPublicKey()
            byte[] r1 = r1.getEncoded()
            r4.<init>(r1)
            java.security.PublicKey r0 = r3.generatePublic(r4)
            if (r2 == 0) goto L_0x0025
            r2.close()     // Catch:{ Throwable -> 0x003d }
            goto L_0x0025
        L_0x003d:
            r1 = move-exception
        L_0x003e:
            r1.printStackTrace()
            goto L_0x0025
        L_0x0042:
            r1 = move-exception
            r2 = r0
        L_0x0044:
            r1.printStackTrace()     // Catch:{ all -> 0x005f }
            if (r2 == 0) goto L_0x0025
            r2.close()     // Catch:{ Throwable -> 0x004d }
            goto L_0x0025
        L_0x004d:
            r1 = move-exception
            goto L_0x003e
        L_0x004f:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x0052:
            if (r2 == 0) goto L_0x0057
            r2.close()     // Catch:{ Throwable -> 0x0058 }
        L_0x0057:
            throw r0
        L_0x0058:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x0057
        L_0x005d:
            r1 = move-exception
            goto L_0x003e
        L_0x005f:
            r0 = move-exception
            goto L_0x0052
        L_0x0061:
            r1 = move-exception
            goto L_0x0044
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0363r.m1352a(android.content.Context):java.security.PublicKey");
    }

    /* renamed from: a */
    public static void m1353a(Context context, String str, String str2, String str3) {
        m1370f(f916a);
        m1370f("                                   鉴权错误信息                                  ");
        m1370f(f916a);
        m1368e("SHA1Package:" + C0342i.m1234e(context));
        m1368e("key:" + C0342i.m1235f(context));
        m1368e("csid:" + str);
        m1368e("gsid:" + str2);
        m1368e("json:" + str3);
        m1370f("                                                                               ");
        m1370f("请仔细检查 SHA1Package与Key申请信息是否对应，Key是否删除，平台是否匹配                ");
        m1370f("如若确认无误，仍存在问题，请将全部log信息提交到工单系统，多谢合作                       ");
        m1370f(f916a);
    }

    /* renamed from: a */
    public static void m1354a(ByteArrayOutputStream byteArrayOutputStream, byte b, byte[] bArr) {
        try {
            byteArrayOutputStream.write(new byte[]{b});
            int i = b & 255;
            if (i < 255 && i > 0) {
                byteArrayOutputStream.write(bArr);
            } else if (i == 255) {
                byteArrayOutputStream.write(bArr, 0, 255);
            }
        } catch (IOException e) {
            C0365t.m1372a(e, "Utils", "writeField");
        }
    }

    /* renamed from: a */
    public static void m1355a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        int i = 255;
        if (TextUtils.isEmpty(str)) {
            try {
                byteArrayOutputStream.write(new byte[]{0});
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            int length = str.length();
            if (length <= 255) {
                i = length;
            }
            m1354a(byteArrayOutputStream, (byte) i, m1358a(str));
        }
    }

    /* renamed from: a */
    public static boolean m1356a(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.has(str);
    }

    /* renamed from: a */
    public static byte[] m1357a() {
        try {
            String[] split = new StringBuffer("16,16,18,77,15,911,121,77,121,911,38,77,911,99,86,67,611,96,48,77,84,911,38,67,021,301,86,67,611,98,48,77,511,77,48,97,511,58,48,97,511,84,501,87,511,96,48,77,221,911,38,77,121,37,86,67,25,301,86,67,021,96,86,67,021,701,86,67,35,56,86,67,611,37,221,87").reverse().toString().split(MiPushClient.ACCEPT_TIME_SEPARATOR);
            byte[] bArr = new byte[split.length];
            for (int i = 0; i < split.length; i++) {
                bArr[i] = Byte.parseByte(split[i]);
            }
            String[] split2 = new StringBuffer(new String(C0355m.m1299b(new String(bArr)))).reverse().toString().split(MiPushClient.ACCEPT_TIME_SEPARATOR);
            byte[] bArr2 = new byte[split2.length];
            for (int i2 = 0; i2 < split2.length; i2++) {
                bArr2[i2] = Byte.parseByte(split2[i2]);
            }
            return bArr2;
        } catch (Throwable th) {
            C0365t.m1372a(th, "Utils", "getIV");
            return new byte[16];
        }
    }

    /* renamed from: a */
    public static byte[] m1358a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            return str.getBytes();
        }
    }

    /* renamed from: b */
    public static String m1359b(String str) {
        if (str == null) {
            return null;
        }
        String b = C0355m.m1298b(m1358a(str));
        return ((char) ((b.length() % 26) + 65)) + b;
    }

    /* renamed from: b */
    public static String m1360b(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = true;
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (z) {
                    z = false;
                    stringBuffer.append(entry.getKey()).append(SimpleComparison.EQUAL_TO_OPERATION).append(entry.getValue());
                } else {
                    stringBuffer.append("&").append(entry.getKey()).append(SimpleComparison.EQUAL_TO_OPERATION).append(entry.getValue());
                }
                z = z;
            }
        } catch (Throwable th) {
            C0365t.m1372a(th, "Utils", "assembleParams");
        }
        return stringBuffer.toString();
    }

    /* renamed from: b */
    public static byte[] m1361b(byte[] bArr) {
        try {
            return m1371g(bArr);
        } catch (Throwable th) {
            C0365t.m1372a(th, "Utils", "gZip");
            return new byte[0];
        }
    }

    /* renamed from: c */
    public static String m1362c(String str) {
        return str.length() < 2 ? "" : C0355m.m1294a(str.substring(1));
    }

    /* renamed from: c */
    public static String m1363c(Map<String, String> map) {
        return m1365d(m1350a(map));
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0048 A[SYNTHETIC, Splitter:B:26:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004d A[SYNTHETIC, Splitter:B:29:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005d A[SYNTHETIC, Splitter:B:36:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0062 A[SYNTHETIC, Splitter:B:39:0x0062] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] m1364c(byte[] r6) {
        /*
        // Method dump skipped, instructions count: 149
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0363r.m1364c(byte[]):byte[]");
    }

    /* renamed from: d */
    public static String m1365d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String[] split = str.split("&");
            Arrays.sort(split);
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : split) {
                stringBuffer.append(str2);
                stringBuffer.append("&");
            }
            String stringBuffer2 = stringBuffer.toString();
            if (stringBuffer2.length() > 1) {
                return (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1);
            }
            return str;
        } catch (Throwable th) {
            C0365t.m1372a(th, "Utils", "sortParams");
        }
    }

    /* renamed from: d */
    static String m1366d(byte[] bArr) {
        try {
            return m1369f(bArr);
        } catch (Throwable th) {
            C0365t.m1372a(th, "Utils", "HexString");
            return null;
        }
    }

    /* renamed from: e */
    static String m1367e(byte[] bArr) {
        try {
            return m1369f(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: e */
    static void m1368e(String str) {
        if (str.length() < 78) {
            StringBuilder sb = new StringBuilder();
            sb.append("|").append(str);
            for (int i = 0; i < 78 - str.length(); i++) {
                sb.append(" ");
            }
            sb.append("|");
            m1370f(sb.toString());
            return;
        }
        m1370f("|" + str.substring(0, 78) + "|");
        m1368e(str.substring(78));
    }

    /* renamed from: f */
    public static String m1369f(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* renamed from: f */
    private static void m1370f(String str) {
        Log.i("authErrLog", str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x002e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0033 A[SYNTHETIC] */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] m1371g(byte[] r4) throws java.io.IOException, java.lang.Throwable {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
        L_0x0003:
            return r0
        L_0x0004:
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ Throwable -> 0x0025, all -> 0x003d }
            r2.<init>()     // Catch:{ Throwable -> 0x0025, all -> 0x003d }
            java.util.zip.GZIPOutputStream r1 = new java.util.zip.GZIPOutputStream     // Catch:{ Throwable -> 0x0048, all -> 0x0043 }
            r1.<init>(r2)     // Catch:{ Throwable -> 0x0048, all -> 0x0043 }
            r1.write(r4)     // Catch:{ Throwable -> 0x004d }
            r1.finish()     // Catch:{ Throwable -> 0x004d }
            byte[] r0 = r2.toByteArray()     // Catch:{ Throwable -> 0x004d }
            if (r1 == 0) goto L_0x001d
            r1.close()     // Catch:{ Throwable -> 0x003b }
        L_0x001d:
            if (r2 == 0) goto L_0x0003
            r2.close()     // Catch:{ Throwable -> 0x0023 }
            goto L_0x0003
        L_0x0023:
            r0 = move-exception
            throw r0
        L_0x0025:
            r1 = move-exception
            r2 = r0
            r3 = r0
            r0 = r1
            r1 = r3
        L_0x002a:
            throw r0     // Catch:{ all -> 0x002b }
        L_0x002b:
            r0 = move-exception
        L_0x002c:
            if (r1 == 0) goto L_0x0031
            r1.close()     // Catch:{ Throwable -> 0x0037 }
        L_0x0031:
            if (r2 == 0) goto L_0x0036
            r2.close()     // Catch:{ Throwable -> 0x0039 }
        L_0x0036:
            throw r0
        L_0x0037:
            r0 = move-exception
            throw r0
        L_0x0039:
            r0 = move-exception
            throw r0
        L_0x003b:
            r0 = move-exception
            throw r0
        L_0x003d:
            r1 = move-exception
            r2 = r0
            r3 = r0
            r0 = r1
            r1 = r3
            goto L_0x002c
        L_0x0043:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
            goto L_0x002c
        L_0x0048:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
            goto L_0x002a
        L_0x004d:
            r0 = move-exception
            goto L_0x002a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0363r.m1371g(byte[]):byte[]");
    }
}
