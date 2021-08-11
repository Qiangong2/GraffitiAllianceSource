package com.amap.loc;

import android.content.Context;
import android.text.TextUtils;
import java.util.Hashtable;
import org.json.JSONObject;

/* renamed from: com.amap.loc.cd */
/* compiled from: HeatMap */
public class C0315cd {

    /* renamed from: a */
    private static C0315cd f656a = null;

    /* renamed from: b */
    private Hashtable<String, JSONObject> f657b = new Hashtable<>();

    /* renamed from: c */
    private boolean f658c = false;

    private C0315cd() {
    }

    /* renamed from: a */
    public static synchronized C0315cd m990a() {
        C0315cd cdVar;
        synchronized (C0315cd.class) {
            if (f656a == null) {
                f656a = new C0315cd();
            }
            cdVar = f656a;
        }
        return cdVar;
    }

    /* renamed from: c */
    private void m991c() {
        if (!this.f657b.isEmpty()) {
            this.f657b.clear();
        }
    }

    /* renamed from: a */
    public void mo3870a(Context context) {
        if (C0301bt.f576a && !this.f658c) {
            C0331cr.m1170b();
            try {
                C0314cc.m983a().mo3869b(context);
            } catch (Throwable th) {
                C0310c.m956a(th, "HeatMap", "loadDB");
            }
            this.f658c = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        if (r9.f657b.containsKey(r3) != false) goto L_0x002e;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo3871a(android.content.Context r10, java.lang.String r11, com.autonavi.aps.amapapi.model.AMapLocationServer r12) {
        /*
        // Method dump skipped, instructions count: 116
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0315cd.mo3871a(android.content.Context, java.lang.String, com.autonavi.aps.amapapi.model.AMapLocationServer):void");
    }

    /* renamed from: a */
    public synchronized void mo3872a(Context context, String str, String str2, int i, long j, boolean z) {
        if (context != null) {
            if (!TextUtils.isEmpty(str) && C0301bt.f576a) {
                JSONObject jSONObject = this.f657b.get(str);
                JSONObject jSONObject2 = jSONObject == null ? new JSONObject() : jSONObject;
                try {
                    jSONObject2.put("x", str2);
                    jSONObject2.put("time", j);
                    if (this.f657b.containsKey(str)) {
                        jSONObject2.put("num", jSONObject2.getInt("num") + i);
                    } else {
                        jSONObject2.put("num", i);
                    }
                } catch (Throwable th) {
                    C0310c.m956a(th, "HeatMap", "update1");
                }
                this.f657b.put(str, jSONObject2);
                if (!C0310c.f638n && !C0329cq.m1147b(context, "pref", "ddex", false) && i >= 120) {
                    C0310c.f638n = true;
                    C0329cq.m1141a(context, "pref", "ddex", true);
                    C0327co.m1123a(context, "OffLocation");
                }
                if (z) {
                    try {
                        C0314cc.m983a().mo3867a(context, str, str2, j);
                    } catch (Throwable th2) {
                        C0310c.m956a(th2, "HeatMap", "update");
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public void mo3873b() {
        m990a().m991c();
        this.f658c = false;
    }
}
