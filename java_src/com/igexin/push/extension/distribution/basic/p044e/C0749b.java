package com.igexin.push.extension.distribution.basic.p044e;

import android.content.ContentValues;
import android.os.Process;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0618g;
import com.igexin.push.extension.distribution.basic.p042c.C0744j;
import com.igexin.push.extension.distribution.basic.p045f.C0750a;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.basic.e.b */
public class C0749b {

    /* renamed from: a */
    public static C0749b f2068a;

    /* renamed from: b */
    private static final String f2069b = ("EXT-" + C0749b.class.getName());

    /* renamed from: c */
    private static int f2070c = 0;

    /* renamed from: d */
    private static boolean f2071d = C0744j.f2047f;

    /* renamed from: e */
    private static String f2072e = C0744j.f2055n;

    /* renamed from: f */
    private static boolean f2073f = C0744j.f2051j;

    /* renamed from: g */
    private static long f2074g = C0744j.f2052k;

    /* renamed from: h */
    private static long f2075h = C0744j.f2053l;

    /* renamed from: i */
    private static int f2076i = C0744j.f2056o;

    /* renamed from: j */
    private static String f2077j = C0744j.f2057p;

    /* renamed from: k */
    private static C0750a f2078k = null;

    /* renamed from: a */
    public static C0749b m3038a() {
        if (f2068a == null) {
            f2068a = new C0749b();
            f2078k = new C0750a(C0744j.f2042a);
        }
        return f2068a;
    }

    /* renamed from: a */
    public void mo5035a(int i, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", Integer.valueOf(i));
        contentValues.put("value", str);
        f2078k.mo5046a("extconfig", (String) null, contentValues);
    }

    /* renamed from: a */
    public void mo5036a(long j) {
        C0744j.f2049h = j;
        mo5035a(3, String.valueOf(j));
    }

    /* renamed from: a */
    public void mo5037a(byte[] bArr) {
        try {
            ActivityC0460a.m1698b(f2069b + "|parseSdkConfig resp data len = " + bArr.length);
            mo5036a(System.currentTimeMillis());
            JSONObject jSONObject = new JSONObject(new String(bArr));
            ActivityC0460a.m1698b(f2069b + "|parseSdkConfig : " + jSONObject);
            if (jSONObject.has("result") && "ok".equals(jSONObject.getString("result"))) {
                f2071d = C0744j.f2047f;
                f2070c = C0744j.f2046e;
                if (jSONObject.has("config")) {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.getString("config"));
                    if (jSONObject2.has("sdk.ext.daemon.enable")) {
                        String string = jSONObject2.getString("sdk.ext.daemon.enable");
                        if (string.equals("true") || string.equals("false")) {
                            f2071d = Boolean.valueOf(string).booleanValue();
                            if (C0744j.f2050i && !f2071d) {
                                C0744j.f2050i = false;
                                mo5041d();
                            }
                        }
                    }
                    if (jSONObject2.has("sdk.ext.deviceid.sync.interval")) {
                        f2070c = Integer.parseInt(jSONObject2.getString("sdk.ext.deviceid.sync.interval"));
                    }
                    if (jSONObject2.has("sdk.ext.guardactivity.first")) {
                        String string2 = jSONObject2.getString("sdk.ext.guardactivity.first");
                        if (string2.equals("true") || string2.equals("false")) {
                            f2073f = Boolean.valueOf(string2).booleanValue();
                        }
                    }
                    if (jSONObject2.has("sdk.ext.reportcid.offline.interval")) {
                        try {
                            f2074g = (long) (Integer.valueOf(jSONObject2.getString("sdk.ext.reportcid.offline.interval")).intValue() * 1000);
                        } catch (Exception e) {
                        }
                    }
                    if (jSONObject2.has("sdk.ext.reportcid.restart.interval")) {
                        try {
                            f2075h = (long) (Integer.valueOf(jSONObject2.getString("sdk.ext.reportcid.restart.interval")).intValue() * 1000);
                        } catch (Exception e2) {
                        }
                    }
                    if (jSONObject2.has("sdk.ext.foreground.phonelist")) {
                        f2072e = jSONObject2.getString("sdk.ext.foreground.phonelist");
                    }
                    if (jSONObject2.has("sdk.ext.httpdata.maxsize")) {
                        try {
                            f2076i = Integer.valueOf(jSONObject2.getString("sdk.ext.httpdata.maxsize")).intValue();
                        } catch (Exception e3) {
                        }
                    }
                    if (jSONObject2.has("sdk.ext.guardgactivity.blacklist")) {
                        f2077j = jSONObject2.getString("sdk.ext.guardgactivity.blacklist");
                    }
                    mo5040c();
                }
            }
        } catch (Exception e4) {
            ActivityC0460a.m1698b(f2069b + "|parseSdkConfig error|" + e4.getMessage());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
        if (0 != 0) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0041, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009a, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009b, code lost:
        r1 = null;
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:1:0x0001] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0052  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo5038b() {
        /*
        // Method dump skipped, instructions count: 186
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.p044e.C0749b.mo5038b():void");
    }

    /* renamed from: b */
    public void mo5039b(long j) {
        C0744j.f2054m = j;
        mo5035a(6, String.valueOf(j));
    }

    /* renamed from: c */
    public void mo5040c() {
        if (C0744j.f2047f != f2071d) {
            C0744j.f2047f = f2071d;
            mo5035a(1, String.valueOf(f2071d));
        }
        if (C0744j.f2046e != f2070c) {
            C0744j.f2046e = f2070c;
            mo5035a(2, String.valueOf(f2070c));
        }
        if (C0744j.f2051j != f2073f) {
            C0744j.f2051j = f2073f;
            mo5035a(5, String.valueOf(f2073f));
        }
        if (C0744j.f2052k != f2074g) {
            C0744j.f2052k = f2074g;
            mo5035a(7, String.valueOf(f2074g));
        }
        if (C0744j.f2053l != f2075h) {
            C0744j.f2053l = f2075h;
            mo5035a(8, String.valueOf(f2075h));
        }
        if (!C0744j.f2055n.equals(f2072e)) {
            C0744j.f2055n = f2072e;
            mo5035a(9, f2072e);
        }
        if (C0744j.f2056o != f2076i) {
            C0744j.f2056o = f2076i;
            mo5035a(10, String.valueOf(f2076i));
        }
        if (!C0744j.f2057p.equals(f2077j)) {
            C0744j.f2057p = f2077j;
            mo5035a(11, f2077j);
        }
    }

    /* renamed from: d */
    public void mo5041d() {
        try {
            InputStream inputStream = Runtime.getRuntime().exec("ps").getInputStream();
            if (inputStream != null) {
                String packageName = C0618g.f1635f.getPackageName();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.split("\\s+");
                    if (readLine.contains(packageName + "/files/gdaemon") && split.length > 0) {
                        Process.killProcess(Integer.valueOf(split[1]).intValue());
                        break;
                    }
                }
                bufferedReader.close();
                inputStream.close();
            }
        } catch (Exception e) {
        }
    }
}
