package com.amap.loc;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.qcloud.core.http.HttpConstants;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.amap.loc.cg */
/* compiled from: LocNetManager */
public class C0318cg {

    /* renamed from: h */
    private static C0318cg f661h = null;

    /* renamed from: a */
    C0275bf f662a = null;

    /* renamed from: b */
    C0278bh f663b = null;

    /* renamed from: c */
    boolean f664c = false;

    /* renamed from: d */
    long f665d = 0;

    /* renamed from: e */
    boolean f666e = true;

    /* renamed from: f */
    public String f667f = "com.autonavi.httpdns.HttpDnsManager";

    /* renamed from: g */
    boolean f668g = false;

    /* renamed from: i */
    private Object f669i = null;

    /* renamed from: j */
    private String f670j = "apilocatesrc.amap.com";

    /* renamed from: k */
    private int f671k = 0;

    /* renamed from: l */
    private int f672l = C0310c.f629e;

    private C0318cg(Context context) {
        m1008c(context);
        this.f662a = C0275bf.m719a();
    }

    /* renamed from: a */
    public static int m1003a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return networkInfo.getType();
        }
        return -1;
    }

    /* renamed from: a */
    public static synchronized C0318cg m1004a(Context context, boolean z) {
        C0318cg cgVar;
        synchronized (C0318cg.class) {
            if (f661h == null) {
                f661h = new C0318cg(context);
            }
            cgVar = f661h;
        }
        return cgVar;
    }

    /* renamed from: a */
    private String m1005a(Context context, String str) {
        if (m1009d(context)) {
            try {
                return (String) C0325cm.m1110a(this.f669i, "getIpByHostAsync", str);
            } catch (Throwable th) {
                C0327co.m1130b(context, "HttpDns", 0);
            }
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m1006a(Context context) {
        int i;
        String str = null;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                str = System.getProperty("http.proxyHost");
                String property = System.getProperty("http.proxyPort");
                if (property == null) {
                    property = "-1";
                }
                i = Integer.parseInt(property);
            } else {
                str = Proxy.getHost(context);
                i = Proxy.getPort(context);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            i = -1;
        }
        return (str == null || i == -1) ? false : true;
    }

    /* renamed from: b */
    private boolean m1007b(Context context) {
        return !C0331cr.m1174b(C0329cq.m1144b(context, "pref", "dns_faile_time", 0), System.currentTimeMillis()) || C0329cq.m1144b(context, "pref", "dns_faile_count", 0) < 3;
    }

    /* renamed from: c */
    private void m1008c(Context context) {
        try {
            if (this.f669i == null && !this.f668g) {
                C0360q a = C0310c.m950a("HttpDNS", "1.0.0");
                this.f668g = C0327co.m1128a(context, a);
                if (this.f668g) {
                    this.f669i = C0244ar.m536a(context, a, this.f667f, null, new Class[]{Context.class}, new Object[]{context});
                    C0327co.m1124a(context, "HttpDns", this.f669i == null ? 0 : 1);
                    return;
                }
                this.f668g = true;
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "APS", "initHttpDns");
        }
    }

    /* renamed from: d */
    private boolean m1009d(Context context) {
        return this.f669i != null && !m1006a(context);
    }

    /* renamed from: a */
    public int mo3877a() {
        return this.f671k;
    }

    /* renamed from: a */
    public C0284bl mo3878a(Context context, JSONObject jSONObject, C0321cj cjVar, String str, boolean z) throws Throwable {
        if (C0331cr.m1166a(jSONObject, "httptimeout")) {
            try {
                this.f672l = jSONObject.getInt("httptimeout");
            } catch (Throwable th) {
                C0310c.m956a(th, "LocNetManager", "req");
            }
        }
        if (m1003a(C0331cr.m1179c(context)) == -1) {
            return null;
        }
        HashMap hashMap = new HashMap();
        C0319ch chVar = new C0319ch(context, C0310c.m950a("loc", "3.0.0"));
        hashMap.clear();
        hashMap.put(HttpConstants.Header.CONTENT_TYPE, COSRequestHeaderKey.APPLICATION_OCTET_STREAM);
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("gzipped", "1");
        hashMap.put(HttpConstants.Header.CONNECTION, "Keep-Alive");
        hashMap.put(HttpConstants.Header.USER_AGENT, "AMAP_Location_SDK_Android 3.0.0");
        hashMap.put("KEY", C0342i.m1235f(context));
        hashMap.put("enginever", "4.2");
        String a = C0350k.m1250a();
        String a2 = C0350k.m1251a(context, a, "key=" + C0342i.m1235f(context));
        hashMap.put("ts", a);
        hashMap.put("scode", a2);
        String str2 = "loc";
        if (!z) {
            str2 = "locf";
        }
        hashMap.put("encr", "1");
        chVar.mo3882a(z);
        chVar.mo3880a(String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "3.0.0", str2, 3));
        chVar.mo3884b(hashMap);
        chVar.mo3883b(str);
        chVar.mo3886c(C0331cr.m1168a(cjVar.mo3891a()));
        chVar.mo3768a(C0357o.m1313a(context));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("output", "bin");
        hashMap2.put("policy", "2103");
        chVar.mo3881a(hashMap2);
        chVar.mo3767a(this.f672l);
        chVar.mo3769b(this.f672l);
        this.f664c = false;
        boolean optBoolean = jSONObject.optBoolean("locationProtocol", false);
        if (optBoolean) {
            chVar.mo3883b(chVar.mo3697b().replace("http", HttpConstants.Scheme.HTTPS));
        } else if (m1007b(context) && m1009d(context)) {
            String a3 = m1005a(context, this.f670j);
            if (!z && TextUtils.isEmpty(a3)) {
                a3 = C0329cq.m1145b(context, "ip", "last_ip", "");
            }
            if (!TextUtils.isEmpty(a3)) {
                this.f664c = true;
                C0329cq.m1140a(context, "ip", "last_ip", a3);
                chVar.mo3883b(C0310c.m958b().replace("apilocatesrc.amap.com", a3));
                chVar.mo3696a().put("host", "apilocatesrc.amap.com");
            }
        }
        long b = C0331cr.m1170b();
        try {
            C0284bl a4 = this.f662a.mo3747a(chVar, optBoolean);
            this.f671k = Long.valueOf(C0331cr.m1170b() - b).intValue();
            if (!this.f664c) {
                return a4;
            }
            C0329cq.m1139a(context, "pref", "dns_faile_time", 0L);
            C0329cq.m1139a(context, "pref", "dns_faile_count", 0L);
            this.f666e = true;
            this.f665d = 0;
            return a4;
        } catch (Throwable th2) {
            if (this.f664c) {
                this.f665d = C0329cq.m1144b(context, "pref", "dns_faile_count", 0L);
                long b2 = C0329cq.m1144b(context, "pref", "dns_faile_time", 0L);
                long currentTimeMillis = System.currentTimeMillis();
                if (b2 == 0) {
                    C0329cq.m1139a(context, "pref", "dns_faile_time", currentTimeMillis);
                }
                if (!C0331cr.m1174b(b2, currentTimeMillis)) {
                    if (this.f665d >= 3) {
                        this.f666e = false;
                    } else {
                        this.f666e = true;
                    }
                    C0329cq.m1141a(context, "pref", "dns_last_success", this.f666e);
                    this.f665d = 0;
                } else {
                    this.f666e = C0329cq.m1147b(context, "pref", "dns_last_success", true);
                }
                this.f665d++;
                C0329cq.m1139a(context, "pref", "dns_faile_count", this.f665d);
                C0329cq.m1139a(context, "pref", "dns_faile_time", currentTimeMillis);
                if (this.f665d >= 3 && !this.f666e) {
                    C0328cp.m1134a(context, "HttpDNS", "dns faile too much");
                }
            }
            throw th2;
        }
    }

    /* renamed from: a */
    public String mo3879a(byte[] bArr, Context context, String str, boolean z) {
        String str2;
        if (m1003a(C0331cr.m1179c(context)) == -1) {
            return null;
        }
        HashMap hashMap = new HashMap();
        C0319ch chVar = new C0319ch(context, C0310c.m950a("loc", "3.0.0"));
        hashMap.clear();
        hashMap.put(HttpConstants.Header.CONTENT_TYPE, HttpConstants.ContentType.X_WWW_FORM_URLENCODED);
        hashMap.put(HttpConstants.Header.CONNECTION, "Keep-Alive");
        if (z) {
            hashMap.put(HttpConstants.Header.USER_AGENT, "AMAP_Location_SDK_Android 3.0.0");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("custom", "26260A1F00020002");
            hashMap2.put("key", C0342i.m1235f(context));
            String a = C0350k.m1250a();
            String a2 = C0350k.m1251a(context, a, C0363r.m1363c(hashMap2));
            hashMap2.put("ts", a);
            hashMap2.put("scode", a2);
            chVar.mo3885b(bArr);
            chVar.mo3882a(true);
            chVar.mo3880a(String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s&loc_channel=%s", "3.0.0", "loc", 3));
            chVar.mo3881a(hashMap2);
        }
        chVar.mo3884b(hashMap);
        chVar.mo3883b(str);
        if (!z) {
            chVar.mo3886c(bArr);
        }
        chVar.mo3768a(C0357o.m1313a(context));
        chVar.mo3767a(C0310c.f629e);
        chVar.mo3769b(C0310c.f629e);
        try {
            str2 = new String(this.f662a.mo3748a(chVar), "utf-8");
        } catch (Throwable th) {
            C0310c.m956a(th, "LocNetManager", "post");
            str2 = null;
        }
        return str2;
    }
}
