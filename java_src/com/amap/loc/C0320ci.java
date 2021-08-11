package com.amap.loc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.umeng.analytics.p091b.C1447g;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.amap.loc.ci */
/* compiled from: Parser */
public class C0320ci {

    /* renamed from: a */
    private StringBuilder f680a = new StringBuilder();

    /* renamed from: b */
    private String m1028b(String str) {
        return "[]".equals(str) ? "" : str;
    }

    /* renamed from: a */
    public AMapLocationServer mo3887a(String str) {
        String str2;
        String str3;
        try {
            AMapLocationServer aMapLocationServer = new AMapLocationServer("");
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("regeocode");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("addressComponent");
            aMapLocationServer.setCountry(m1028b(optJSONObject2.optString(C1447g.f3443G)));
            String b = m1028b(optJSONObject2.optString("province"));
            aMapLocationServer.setProvince(b);
            String b2 = m1028b(optJSONObject2.optString("citycode"));
            aMapLocationServer.setCityCode(b2);
            String optString = optJSONObject2.optString("city");
            if (b2.endsWith("010") || b2.endsWith("021") || b2.endsWith("022") || b2.endsWith("023")) {
                if (b != 0 && b.length() > 0) {
                    aMapLocationServer.setCity(b);
                    str2 = b;
                }
                str2 = optString;
            } else {
                optString = m1028b(optString);
                aMapLocationServer.setCity(optString);
                str2 = optString;
            }
            String b3 = m1028b(optJSONObject2.optString("district"));
            aMapLocationServer.setDistrict(b3);
            String b4 = m1028b(optJSONObject2.optString("adcode"));
            aMapLocationServer.setAdCode(b4);
            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("streetNumber");
            String b5 = m1028b(optJSONObject3.optString("street"));
            aMapLocationServer.setStreet(b5);
            aMapLocationServer.setRoad(b5);
            aMapLocationServer.setNumber(m1028b(optJSONObject3.optString("number")));
            JSONArray optJSONArray = optJSONObject.optJSONArray("pois");
            if (optJSONArray.length() > 0) {
                str3 = m1028b(optJSONArray.getJSONObject(0).optString("name"));
                aMapLocationServer.setPoiName(str3);
            } else {
                str3 = null;
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("aois");
            if (optJSONArray2.length() > 0) {
                aMapLocationServer.setAoiName(m1028b(optJSONArray2.getJSONObject(0).optString("name")));
            }
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(b)) {
                sb.append(b).append(" ");
            }
            if (!TextUtils.isEmpty(str2) && (!b.contains("市") || !b.equals(str2))) {
                sb.append(str2).append(" ");
            }
            if (!TextUtils.isEmpty(b3)) {
                sb.append(b3).append(" ");
            }
            if (!TextUtils.isEmpty(b5)) {
                sb.append(b5).append(" ");
            }
            if (!TextUtils.isEmpty(str3)) {
                if (!TextUtils.isEmpty(b4)) {
                    sb.append("靠近");
                }
                sb.append(str3).append(" ");
            }
            Bundle bundle = new Bundle();
            bundle.putString("citycode", aMapLocationServer.getCityCode());
            bundle.putString("desc", sb.toString());
            bundle.putString("adcode", aMapLocationServer.getAdCode());
            aMapLocationServer.setExtras(bundle);
            aMapLocationServer.mo3975i(sb.toString());
            if (b4 == null || b4.trim().length() <= 0) {
                aMapLocationServer.setAddress(sb.toString());
                return aMapLocationServer;
            }
            aMapLocationServer.setAddress(sb.toString().replace(" ", ""));
            return aMapLocationServer;
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: a */
    public AMapLocationServer mo3888a(String str, Context context, C0284bl blVar) {
        AMapLocationServer aMapLocationServer = new AMapLocationServer("");
        aMapLocationServer.setErrorCode(7);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status") || !jSONObject.has("info")) {
                this.f680a.append("json is error " + str);
            }
            String string = jSONObject.getString("status");
            String string2 = jSONObject.getString("info");
            if (string.equals("0")) {
                this.f680a.append("auth fail:" + string2);
            }
        } catch (Throwable th) {
            this.f680a.append("json exception error:" + th.getMessage());
            C0310c.m956a(th, "parser", "paseAuthFailurJson");
        }
        try {
            this.f680a.append("#SHA1AndPackage#").append(C0342i.m1234e(context));
            String str2 = blVar.f469b.get("gsid").get(0);
            if (!TextUtils.isEmpty(str2)) {
                this.f680a.append(" #gsid#").append(str2);
            }
            String str3 = blVar.f470c;
            if (!TextUtils.isEmpty(str3)) {
                this.f680a.append(" #csid#" + str3);
            }
        } catch (Throwable th2) {
        }
        aMapLocationServer.setLocationDetail(this.f680a.toString());
        if (this.f680a.length() > 0) {
            this.f680a.delete(0, this.f680a.length());
        }
        return aMapLocationServer;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:114:0x02ac, code lost:
        r1 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x02b1, code lost:
        r1 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x02b2, code lost:
        r9 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x02b6, code lost:
        r1 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x02b7, code lost:
        r4 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02bb, code lost:
        r1 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02bc, code lost:
        r3 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02c0, code lost:
        r1 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02c1, code lost:
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02cd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02ce, code lost:
        r1 = r0;
        r2 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0302, code lost:
        r2.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x030a, code lost:
        r8.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x030e, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0321, code lost:
        r1 = "";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x028a  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0293  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x029e  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0302  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x030a  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x030e A[ExcHandler: all (th java.lang.Throwable), Splitter:B:9:0x003b] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x024b  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.autonavi.aps.amapapi.model.AMapLocationServer mo3889a(byte[] r14) {
        /*
        // Method dump skipped, instructions count: 828
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0320ci.mo3889a(byte[]):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }
}
