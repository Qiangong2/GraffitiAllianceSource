package com.igexin.push.util;

import android.text.TextUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.igexin.push.util.s */
public class C1169s {

    /* renamed from: a */
    public static final String f3046a = C1169s.class.getName();

    /* renamed from: a */
    private static String m4796a(InputStream inputStream, String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str));
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[256];
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read <= 0) {
                    break;
                }
                stringWriter.write(cArr, 0, read);
            }
            return stringWriter.toString();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    /* renamed from: a */
    private static String m4797a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "utf-8";
        }
        for (String str2 : str.split(";")) {
            String trim = str2.trim();
            if (trim.startsWith("charset")) {
                String[] split = trim.split(SimpleComparison.EQUAL_TO_OPERATION, 2);
                return (split.length != 2 || TextUtils.isEmpty(split[1])) ? "utf-8" : split[1].trim();
            }
        }
        return "utf-8";
    }

    /* renamed from: a */
    private static HttpURLConnection m4798a(URL url, String str, String str2) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod(str);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setRequestProperty(HttpConstants.Header.USER_AGENT, "GETUI");
        httpURLConnection.setRequestProperty(HttpConstants.Header.CONTENT_TYPE, str2);
        httpURLConnection.setRequestProperty("HOST", url.getHost() + ":" + url.getPort());
        return httpURLConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0020 A[SYNTHETIC, Splitter:B:10:0x0020] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0036 A[SYNTHETIC, Splitter:B:21:0x0036] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] m4799a(java.io.InputStream r7) {
        /*
            r0 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0040, all -> 0x0030 }
            r1.<init>(r7)     // Catch:{ Exception -> 0x0040, all -> 0x0030 }
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x001d, all -> 0x003e }
            r3 = 1024(0x400, float:1.435E-42)
            r2.<init>(r3)     // Catch:{ Exception -> 0x001d, all -> 0x003e }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x001d, all -> 0x003e }
        L_0x0011:
            int r4 = r1.read(r3)     // Catch:{ Exception -> 0x001d, all -> 0x003e }
            r5 = -1
            if (r4 == r5) goto L_0x0024
            r5 = 0
            r2.write(r3, r5, r4)     // Catch:{ Exception -> 0x001d, all -> 0x003e }
            goto L_0x0011
        L_0x001d:
            r2 = move-exception
        L_0x001e:
            if (r1 == 0) goto L_0x0023
            r1.close()     // Catch:{ IOException -> 0x003a }
        L_0x0023:
            return r0
        L_0x0024:
            byte[] r0 = r2.toByteArray()
            if (r1 == 0) goto L_0x0023
            r1.close()     // Catch:{ IOException -> 0x002e }
            goto L_0x0023
        L_0x002e:
            r1 = move-exception
            goto L_0x0023
        L_0x0030:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
        L_0x0034:
            if (r1 == 0) goto L_0x0039
            r1.close()     // Catch:{ IOException -> 0x003c }
        L_0x0039:
            throw r0
        L_0x003a:
            r1 = move-exception
            goto L_0x0023
        L_0x003c:
            r1 = move-exception
            goto L_0x0039
        L_0x003e:
            r0 = move-exception
            goto L_0x0034
        L_0x0040:
            r1 = move-exception
            r1 = r0
            goto L_0x001e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.C1169s.m4799a(java.io.InputStream):byte[]");
    }

    /* renamed from: a */
    public static byte[] m4800a(String str, String str2, byte[] bArr, int i, int i2) {
        HttpURLConnection httpURLConnection;
        IOException e;
        OutputStream outputStream = null;
        try {
            httpURLConnection = m4798a(new URL(str), "POST", str2);
            try {
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i2);
                try {
                    OutputStream outputStream2 = httpURLConnection.getOutputStream();
                    outputStream2.write(bArr);
                    byte[] a = m4802a(httpURLConnection);
                    if (outputStream2 != null) {
                        outputStream2.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return a;
                } catch (Exception e2) {
                    throw e2;
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                }
            }
        } catch (IOException e4) {
            e = e4;
            httpURLConnection = null;
            throw e;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
            if (0 != 0) {
                outputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static byte[] m4801a(String str, byte[] bArr, int i, int i2) {
        return m4800a(str, COSRequestHeaderKey.APPLICATION_OCTET_STREAM, bArr, i, i2);
    }

    /* renamed from: a */
    private static byte[] m4802a(HttpURLConnection httpURLConnection) {
        return httpURLConnection.getErrorStream() == null ? m4799a(httpURLConnection.getInputStream()) : m4803b(httpURLConnection).getBytes();
    }

    /* renamed from: b */
    private static String m4803b(HttpURLConnection httpURLConnection) {
        String a = m4796a(httpURLConnection.getErrorStream(), m4797a(httpURLConnection.getContentType()));
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        throw new IOException(httpURLConnection.getResponseCode() + ":" + httpURLConnection.getResponseMessage());
    }
}
