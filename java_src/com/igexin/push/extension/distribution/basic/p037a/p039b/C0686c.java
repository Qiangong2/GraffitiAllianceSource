package com.igexin.push.extension.distribution.basic.p037a.p039b;

import android.os.Bundle;
import android.os.Environment;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p022b.C0476a;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.extension.distribution.basic.p042c.C0744j;
import com.igexin.push.extension.distribution.basic.p044e.C0749b;
import com.igexin.push.extension.distribution.basic.util.C1003i;
import com.igexin.sdk.PushConsts;
import java.net.ServerSocket;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.basic.a.b.c */
public class C0686c {

    /* renamed from: a */
    private static final String f1849a = ("EXT-" + C0686c.class.getName());

    /* renamed from: d */
    private static C0686c f1850d;

    /* renamed from: b */
    private Long f1851b;

    /* renamed from: c */
    private ServerSocket f1852c;

    private C0686c() {
    }

    /* renamed from: a */
    public static C0686c m2673a() {
        if (f1850d == null) {
            f1850d = new C0686c();
        }
        return f1850d;
    }

    /* renamed from: a */
    public void mo4767a(boolean z) {
        int i;
        JSONArray jSONArray;
        if (z) {
            try {
                if (C0618g.f1638i && C0618g.f1639j) {
                    try {
                        if (this.f1852c == null) {
                            this.f1852c = new ServerSocket(51688);
                        }
                    } catch (Exception e) {
                        ActivityC0460a.m1698b(f1849a + "|port 51688 has occupy by others");
                    }
                    if (this.f1852c != null) {
                        if (C0744j.f2053l < 180000) {
                            C0744j.f2053l = 180000;
                        }
                        if (C0744j.f2052k < 180000) {
                            C0744j.f2052k = 180000;
                        }
                        if (this.f1851b == null) {
                            long currentTimeMillis = System.currentTimeMillis() - C0744j.f2054m;
                            if (currentTimeMillis < C0744j.f2053l) {
                                ActivityC0460a.m1698b(f1849a + "|lastReportInterval < reportCidRestartThreshold not report");
                                return;
                            }
                            i = currentTimeMillis < C0744j.f2052k ? 2 : 0;
                        } else if (System.currentTimeMillis() - this.f1851b.longValue() >= C0744j.f2052k) {
                            i = 1;
                        } else {
                            ActivityC0460a.m1698b(f1849a + "|offline time < reportCidOfflineThreshold not report");
                            return;
                        }
                        List<JSONObject> a = C1003i.m4037a(Environment.getExternalStorageDirectory() + "/libs");
                        List<JSONObject> a2 = C1003i.m4037a(Environment.getExternalStorageDirectory() + "/libs/yl");
                        if (a == null && a2 != null) {
                            a = a2;
                        } else if (!(a == null || a2 == null)) {
                            a.addAll(a2);
                        }
                        if (a == null) {
                            jSONArray = new JSONArray();
                        } else if (a.size() > 0) {
                            jSONArray = new JSONArray((Collection) a);
                        } else {
                            return;
                        }
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("appinfo", jSONArray);
                        jSONObject.put("deviceid", "ANDROID-" + C0618g.f1653x);
                        jSONObject.put("type", i);
                        jSONObject.put("pkg", C0618g.f1635f.getPackageName());
                        jSONObject.toString();
                        Bundle bundle = new Bundle();
                        bundle.putString(PushConsts.CMD_ACTION, "sendMessage");
                        bundle.putString("taskid", "6T5@S_" + C0476a.m1773a(C0618g.f1647r + System.currentTimeMillis()));
                        bundle.putByteArray("extraData", jSONObject.toString().getBytes());
                        C0535e.m2034a().mo4366a(bundle);
                        C0749b.m3038a().mo5039b(System.currentTimeMillis());
                    }
                }
            } catch (Throwable th) {
                ActivityC0460a.m1698b(f1849a + "|do report exception:" + th.toString());
                return;
            }
        }
        if (!z) {
            this.f1851b = Long.valueOf(System.currentTimeMillis());
        }
    }
}
