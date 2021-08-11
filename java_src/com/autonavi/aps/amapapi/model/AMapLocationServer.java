package com.autonavi.aps.amapapi.model;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.loc.C0310c;
import com.amap.loc.C0331cr;
import com.igexin.sdk.PushConsts;
import com.xiaomi.mipush.sdk.MiPushClient;
import org.json.JSONObject;

public class AMapLocationServer extends AMapLocation {

    /* renamed from: b */
    boolean f954b = true;

    /* renamed from: c */
    private String f955c = "";

    /* renamed from: d */
    private int f956d;

    /* renamed from: e */
    private String f957e = "";

    /* renamed from: f */
    private String f958f = "";

    /* renamed from: g */
    private String f959g = "";

    /* renamed from: h */
    private String f960h = "new";

    /* renamed from: i */
    private JSONObject f961i = null;

    /* renamed from: j */
    private String f962j = "";

    /* renamed from: k */
    private String f963k = "";

    /* renamed from: l */
    private long f964l = 0;

    public AMapLocationServer(String str) {
        super(str);
    }

    /* renamed from: a */
    public String mo3955a() {
        return this.f955c;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.amap.api.location.AMapLocation
    /* renamed from: a */
    public JSONObject mo3490a(int i) {
        try {
            JSONObject a = super.mo3490a(i);
            switch (i) {
                case 1:
                    a.put("retype", this.f957e);
                    a.put("cens", this.f963k);
                    a.put("poiid", this.f958f);
                    a.put("floor", this.f959g);
                    a.put("coord", this.f956d);
                    a.put("mcell", this.f962j);
                    a.put("desc", this.f166a);
                    a.put("address", getAddress());
                    if (this.f961i != null && C0331cr.m1166a(a, "offpct")) {
                        a.put("offpct", this.f961i.getString("offpct"));
                        break;
                    }
                case 2:
                case 3:
                    break;
                default:
                    return a;
            }
            a.put("type", this.f960h);
            a.put("isReversegeo", this.f954b);
            return a;
        } catch (Throwable th) {
            C0310c.m956a(th, "AmapLoc", "toStr");
            return null;
        }
    }

    /* renamed from: a */
    public void mo3956a(long j) {
        this.f964l = j;
    }

    /* renamed from: a */
    public void mo3957a(String str) {
        this.f955c = str;
    }

    /* renamed from: a */
    public void mo3958a(JSONObject jSONObject) {
        this.f961i = jSONObject;
    }

    /* renamed from: a */
    public void mo3959a(boolean z) {
        this.f954b = z;
    }

    /* renamed from: b */
    public int mo3960b() {
        return this.f956d;
    }

    /* renamed from: b */
    public void mo3961b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f956d = -1;
        } else if (getProvider().equals("gps")) {
            this.f956d = 0;
        } else if (str.equals("0")) {
            this.f956d = 0;
        } else if (str.equals("1")) {
            this.f956d = 1;
        } else {
            this.f956d = -1;
        }
    }

    /* renamed from: b */
    public void mo3962b(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                C0310c.m954a(this, jSONObject);
                if (C0331cr.m1166a(jSONObject, "type")) {
                    mo3970f(jSONObject.getString("type"));
                }
                if (C0331cr.m1166a(jSONObject, "retype")) {
                    mo3964c(jSONObject.getString("retype"));
                }
                if (C0331cr.m1166a(jSONObject, "cens")) {
                    mo3974h(jSONObject.getString("cens"));
                }
                if (C0331cr.m1166a(jSONObject, "desc")) {
                    mo3975i(jSONObject.getString("desc"));
                }
                if (C0331cr.m1166a(jSONObject, "poiid")) {
                    mo3966d(jSONObject.getString("poiid"));
                }
                if (C0331cr.m1166a(jSONObject, PushConsts.KEY_SERVICE_PIT)) {
                    mo3966d(jSONObject.getString(PushConsts.KEY_SERVICE_PIT));
                }
                if (C0331cr.m1166a(jSONObject, "floor")) {
                    mo3968e(jSONObject.getString("floor"));
                }
                if (C0331cr.m1166a(jSONObject, "flr")) {
                    mo3968e(jSONObject.getString("flr"));
                }
                if (C0331cr.m1166a(jSONObject, "coord")) {
                    mo3961b(jSONObject.getString("coord"));
                }
                if (C0331cr.m1166a(jSONObject, "mcell")) {
                    mo3972g(jSONObject.getString("mcell"));
                }
                if (C0331cr.m1166a(jSONObject, "isReversegeo")) {
                    mo3959a(jSONObject.getBoolean("isReversegeo"));
                }
            } catch (Throwable th) {
                C0310c.m956a(th, "AmapLoc", "AmapLoc");
            }
        }
    }

    /* renamed from: c */
    public String mo3963c() {
        return this.f957e;
    }

    /* renamed from: c */
    public void mo3964c(String str) {
        this.f957e = str;
    }

    /* renamed from: d */
    public String mo3965d() {
        return this.f958f;
    }

    /* renamed from: d */
    public void mo3966d(String str) {
        this.f958f = str;
    }

    /* renamed from: e */
    public String mo3967e() {
        return this.f960h;
    }

    /* renamed from: e */
    public void mo3968e(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.replace("F", "");
            try {
                Integer.parseInt(str);
            } catch (Throwable th) {
                str = null;
                C0310c.m956a(th, "AmapLoc", "setFloor");
            }
        }
        this.f959g = str;
    }

    /* renamed from: f */
    public JSONObject mo3969f() {
        return this.f961i;
    }

    /* renamed from: f */
    public void mo3970f(String str) {
        this.f960h = str;
    }

    /* renamed from: g */
    public String mo3971g() {
        return this.f962j;
    }

    /* renamed from: g */
    public void mo3972g(String str) {
        this.f962j = str;
    }

    /* renamed from: h */
    public AMapLocationServer mo3973h() {
        String g = mo3971g();
        if (TextUtils.isEmpty(g)) {
            return null;
        }
        String[] split = g.split(MiPushClient.ACCEPT_TIME_SEPARATOR);
        if (split.length != 3) {
            return null;
        }
        AMapLocationServer aMapLocationServer = new AMapLocationServer("");
        aMapLocationServer.setProvider(getProvider());
        aMapLocationServer.setLongitude(Double.parseDouble(split[0]));
        aMapLocationServer.setLatitude(Double.parseDouble(split[1]));
        aMapLocationServer.setAccuracy(Float.parseFloat(split[2]));
        aMapLocationServer.setCityCode(getCityCode());
        aMapLocationServer.setAdCode(getAdCode());
        aMapLocationServer.setCountry(getCountry());
        aMapLocationServer.setProvince(getProvince());
        aMapLocationServer.setCity(getCity());
        aMapLocationServer.setTime(getTime());
        aMapLocationServer.mo3970f(mo3967e());
        aMapLocationServer.mo3961b(String.valueOf(mo3960b()));
        if (C0331cr.m1164a(aMapLocationServer)) {
            return aMapLocationServer;
        }
        return null;
    }

    /* renamed from: h */
    public void mo3974h(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("\\*");
            int length = split.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                String str2 = split[i];
                if (!TextUtils.isEmpty(str2)) {
                    String[] split2 = str2.split(MiPushClient.ACCEPT_TIME_SEPARATOR);
                    setLongitude(Double.parseDouble(split2[0]));
                    setLatitude(Double.parseDouble(split2[1]));
                    setAccuracy((float) Integer.parseInt(split2[2]));
                    break;
                }
                i++;
            }
            this.f963k = str;
        }
    }

    /* renamed from: i */
    public void mo3975i(String str) {
        this.f166a = str;
    }

    /* renamed from: i */
    public boolean mo3976i() {
        return this.f954b;
    }

    /* renamed from: j */
    public long mo3977j() {
        return this.f964l;
    }
}
