package com.amap.loc;

import android.content.Context;
import com.amap.loc.C0249av;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.List;

/* renamed from: com.amap.loc.ba */
/* compiled from: Utils */
public class C0263ba {
    /* renamed from: a */
    public static int m654a(String str, String str2) {
        int i = 0;
        try {
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            int min = Math.min(split.length, split2.length);
            for (int i2 = 0; i2 < min; i2++) {
                i = split[i2].length() - split2[i2].length();
                if (!(i == 0 && (i = split[i2].compareTo(split2[i2])) == 0)) {
                    break;
                }
            }
            return i != 0 ? i : split.length - split2.length;
        } catch (Exception e) {
            C0365t.m1372a(e, "Utils", "compareVersion");
            return -1;
        }
    }

    /* renamed from: a */
    static PublicKey m655a() {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        Throwable th2;
        try {
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            byteArrayInputStream = new ByteArrayInputStream(C0355m.m1299b("MIIDRzCCAi+gAwIBAgIEeuDbsDANBgkqhkiG9w0BAQsFADBTMQswCQYDVQQGEwJjbjELMAkGA1UECBMCYmoxCzAJBgNVBAcTAmJqMQ0wCwYDVQQKEwRvcGVuMQ4wDAYDVQQLEwVnYW9kZTELMAkGA1UEAxMCUWkwIBcNMTYwODAxMDE0ODMwWhgPMjA3MTA1MDUwMTQ4MzBaMFMxCzAJBgNVBAYTAmNuMQswCQYDVQQIEwJiajELMAkGA1UEBxMCYmoxDTALBgNVBAoTBG9wZW4xDjAMBgNVBAsTBWdhb2RlMQswCQYDVQQDEwJRaTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAKpL13mZm4q6AFP5csQE7130Lwq8m+HICy3rBARd9vbw5Cb1wFF96KdhC5P/aASlrPb+6MSyP1nE97p3ygKJWsgxExyvVuOvh1KUqOFuK15oY7JKTk6L4eLCbkBJZV2DLffpW0HGiRpmFG8LJR0sjNOoubSd5R/6XoBwyRglsyVHprjrK2qDRvT3Edgtfvxp4HnUzMsDD3CJRtgsaDw6ECyF7fhYKEz9I6OEEVsPlpbgzRmhSeFDL77/k1mhPve1ZyKGlPcxvSSdLSAlV0hzr5NKlujHll7BbouwDnr6l/0O44AzZ0V/ieft1iBkSLirnlm56uI/8jdh8ANrD1fW4ZUCAwEAAaMhMB8wHQYDVR0OBBYEFBzudtI5UKRvHGDV+VQRzItIj3PqMA0GCSqGSIb3DQEBCwUAA4IBAQBS2EGndgvIBnf7Ce4IhDbm7F5h4L+6TYGmT9acnQbEFY8oUoFblMDgg+cETT44jU/elwbJJVmKhj/WRQl+AdSALBAgDvxq1AcjlGg+c8H3pa2BWlrxNJP9MFLIEI5bA8m5og/Epjut50uemZ9ggoNmJeW0N/a6D8euhYJKOYngUQqDu6cwLj1Ec0ptwrNRbvRXXgzjfJMPE/ii4K/b8JZ+QN2d/bl7QEvKWBSzVueZifV659qAbMh6C9TCVstWWfV53Z3Vyt+duDNU5ed7aWao42Ppw4VHslrJW0V6BXDUhhzgXx28UWY78W7LmYGCtC8PfDId2+k4tPoTNPM6HHP5"));
            try {
                PublicKey publicKey = ((X509Certificate) instance.generateCertificate(byteArrayInputStream)).getPublicKey();
                m656a(byteArrayInputStream);
                return publicKey;
            } catch (Throwable th3) {
                th2 = th3;
                try {
                    m657a(th2, "DyLoader", "init");
                    m656a(byteArrayInputStream);
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    m656a(byteArrayInputStream);
                    throw th;
                }
            }
        } catch (Throwable th5) {
            th = th5;
            byteArrayInputStream = null;
            m656a(byteArrayInputStream);
            throw th;
        }
    }

    /* renamed from: a */
    static void m656a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    static void m657a(Throwable th, String str, String str2) {
        C0365t.m1372a(th, str, str2);
    }

    /* renamed from: a */
    static void m658a(List<C0256az> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int i2 = i + 1; i2 < list.size(); i2++) {
                C0256az azVar = list.get(i);
                C0256az azVar2 = list.get(i2);
                if (m654a(azVar2.mo3710d(), azVar.mo3710d()) > 0) {
                    list.set(i, azVar2);
                    list.set(i2, azVar);
                }
            }
        }
    }

    /* renamed from: a */
    static boolean m659a(Context context, C0228ac acVar, String str, C0360q qVar) {
        return m660a(acVar, str, C0249av.m554a(context, str), qVar);
    }

    /* renamed from: a */
    static boolean m660a(C0228ac acVar, String str, String str2, C0360q qVar) {
        C0256az a = C0249av.C0251a.m568a(acVar, str);
        return a != null && qVar.mo3941b().equals(a.mo3708c()) && m661b(str2, a.mo3707b());
    }

    /* renamed from: b */
    static boolean m661b(String str, String str2) {
        String a = C0356n.m1302a(str);
        return a != null && a.equalsIgnoreCase(str2);
    }
}
