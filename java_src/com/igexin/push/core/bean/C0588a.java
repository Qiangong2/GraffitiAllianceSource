package com.igexin.push.core.bean;

import android.os.Build;
import com.igexin.push.core.C0519a;
import com.igexin.push.core.C0618g;
import com.igexin.push.util.C1163m;
import com.igexin.sdk.GTServiceManager;
import com.igexin.sdk.PushBuildConfig;
import com.igexin.sdk.PushConsts;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.bean.a */
public class C0588a {

    /* renamed from: a */
    public String f1462a;

    /* renamed from: b */
    public String f1463b;

    /* renamed from: c */
    public String f1464c;

    /* renamed from: d */
    public String f1465d;

    /* renamed from: e */
    public String f1466e;

    /* renamed from: f */
    public String f1467f = "open";

    /* renamed from: g */
    public String f1468g;

    /* renamed from: h */
    public String f1469h;

    /* renamed from: i */
    public String f1470i;

    /* renamed from: j */
    public String f1471j;

    /* renamed from: k */
    public String f1472k;

    /* renamed from: l */
    public String f1473l;

    /* renamed from: m */
    public String f1474m;

    /* renamed from: n */
    public long f1475n;

    public C0588a() {
        if (C0618g.f1634e != null) {
            this.f1467f += ":" + C0618g.f1634e;
        }
        this.f1466e = PushBuildConfig.sdk_conf_version;
        this.f1463b = C0618g.f1650u;
        this.f1464c = C0618g.f1649t;
        this.f1465d = C0618g.f1652w;
        this.f1470i = null;
        this.f1462a = C0618g.f1651v;
        this.f1469h = "ANDROID";
        this.f1471j = "android" + Build.VERSION.RELEASE;
        this.f1472k = "MDP";
        this.f1468g = C0618g.f1653x;
        this.f1475n = System.currentTimeMillis();
        this.f1473l = C0618g.f1654y;
        this.f1474m = Build.BRAND;
    }

    /* renamed from: a */
    public static String m2259a(C0588a aVar) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("model", aVar.f1462a == null ? "" : aVar.f1462a);
        jSONObject.put("sim", aVar.f1463b == null ? "" : aVar.f1463b);
        jSONObject.put("imei", aVar.f1464c == null ? "" : aVar.f1464c);
        jSONObject.put("mac", aVar.f1465d == null ? "" : aVar.f1465d);
        jSONObject.put("version", aVar.f1466e == null ? "" : aVar.f1466e);
        jSONObject.put("channelid", aVar.f1467f == null ? "" : aVar.f1467f);
        jSONObject.put("type", "ANDROID");
        jSONObject.put("app", aVar.f1472k == null ? "" : aVar.f1472k);
        jSONObject.put("deviceid", "ANDROID-" + (aVar.f1468g == null ? "" : aVar.f1468g));
        jSONObject.put("device_token", aVar.f1473l == null ? "" : aVar.f1473l);
        jSONObject.put("brand", aVar.f1474m == null ? "" : aVar.f1474m);
        jSONObject.put("system_version", aVar.f1471j == null ? "" : aVar.f1471j);
        jSONObject.put("cell", aVar.f1470i == null ? "" : aVar.f1470i);
        jSONObject.put("aid", C1163m.m4788b());
        jSONObject.put("adid", C1163m.m4789c());
        String name = GTServiceManager.getInstance().getUserPushService(C0618g.f1635f).getName();
        if (!C0519a.f1350n.equals(name)) {
            jSONObject.put("us", name);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(PushConsts.CMD_ACTION, "addphoneinfo");
        jSONObject2.put("id", String.valueOf(aVar.f1475n));
        jSONObject2.put("info", jSONObject);
        return jSONObject2.toString();
    }
}
