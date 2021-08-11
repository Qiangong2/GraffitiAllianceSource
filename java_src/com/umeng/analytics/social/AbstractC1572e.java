package com.umeng.analytics.social;

import android.content.Context;
import android.text.TextUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.social.UMPlatformData;
import com.umeng.p085a.C1346h;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.umeng.analytics.social.e */
/* compiled from: UMUtils */
public abstract class AbstractC1572e {

    /* renamed from: a */
    private static Map<String, String> f4004a;

    /* renamed from: a */
    protected static String[] m6027a(Context context, String str, UMPlatformData... uMPlatformDataArr) throws C1568a {
        if (uMPlatformDataArr == null || uMPlatformDataArr.length == 0) {
            throw new C1568a("platform data is null");
        }
        String appkey = AnalyticsConfig.getAppkey(context);
        if (TextUtils.isEmpty(appkey)) {
            throw new C1568a("can`t get appkey.");
        }
        ArrayList arrayList = new ArrayList();
        String str2 = "http://log.umsns.com/share/api/" + appkey + MqttTopic.TOPIC_LEVEL_SEPARATOR;
        if (f4004a == null || f4004a.isEmpty()) {
            f4004a = m6029b(context);
        }
        if (f4004a != null && !f4004a.isEmpty()) {
            for (Map.Entry<String, String> entry : f4004a.entrySet()) {
                arrayList.add(entry.getKey() + SimpleComparison.EQUAL_TO_OPERATION + entry.getValue());
            }
        }
        arrayList.add("date=" + String.valueOf(System.currentTimeMillis()));
        arrayList.add("channel=" + AbstractC1571d.f3986d);
        if (!TextUtils.isEmpty(str)) {
            arrayList.add("topic=" + str);
        }
        arrayList.addAll(m6025a(uMPlatformDataArr));
        String b = m6028b(uMPlatformDataArr);
        if (b == null) {
            b = "null";
        }
        String str3 = str2 + "?" + m6024a(arrayList);
        while (str3.contains("%2C+")) {
            str3 = str3.replace("%2C+", "&");
        }
        while (str3.contains("%3D")) {
            str3 = str3.replace("%3D", SimpleComparison.EQUAL_TO_OPERATION);
        }
        while (str3.contains("%5B")) {
            str3 = str3.replace("%5B", "");
        }
        while (str3.contains("%5D")) {
            str3 = str3.replace("%5D", "");
        }
        C1346h.m4991b("url:" + str3 + "\nBody:" + b);
        return new String[]{str3, b};
    }

    /* renamed from: a */
    private static String m6024a(List<String> list) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(URLEncoder.encode(list.toString()).getBytes());
            return byteArrayOutputStream.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static List<String> m6025a(UMPlatformData... uMPlatformDataArr) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        for (UMPlatformData uMPlatformData : uMPlatformDataArr) {
            sb.append(uMPlatformData.getMeida().toString());
            sb.append(',');
            sb2.append(uMPlatformData.getUsid());
            sb2.append(',');
            sb3.append(uMPlatformData.getWeiboId());
            sb3.append(',');
        }
        if (uMPlatformDataArr.length > 0) {
            sb.deleteCharAt(sb.length() - 1);
            sb2.deleteCharAt(sb2.length() - 1);
            sb3.deleteCharAt(sb3.length() - 1);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("platform=" + sb.toString());
        arrayList.add("usid=" + sb2.toString());
        if (sb3.length() > 0) {
            arrayList.add("weiboid=" + sb3.toString());
        }
        return arrayList;
    }

    /* renamed from: b */
    private static String m6028b(UMPlatformData... uMPlatformDataArr) {
        String valueOf;
        JSONObject jSONObject = new JSONObject();
        for (UMPlatformData uMPlatformData : uMPlatformDataArr) {
            UMPlatformData.GENDER gender = uMPlatformData.getGender();
            String name = uMPlatformData.getName();
            if (gender == null) {
                try {
                    if (TextUtils.isEmpty(name)) {
                    }
                } catch (Exception e) {
                    throw new C1568a("build body exception", e);
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            if (gender == null) {
                valueOf = "";
            } else {
                valueOf = String.valueOf(gender.value);
            }
            jSONObject2.put("gender", valueOf);
            jSONObject2.put("name", name == null ? "" : String.valueOf(name));
            jSONObject.put(uMPlatformData.getMeida().toString(), jSONObject2);
        }
        if (jSONObject.length() == 0) {
            return null;
        }
        return jSONObject.toString();
    }

    /* renamed from: b */
    private static Map<String, String> m6029b(Context context) throws C1568a {
        HashMap hashMap = new HashMap();
        Map<String, String> a = m6026a(context);
        if (a == null || a.isEmpty()) {
            throw new C1568a("can`t get device id.");
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry : a.entrySet()) {
            if (!TextUtils.isEmpty(entry.getValue())) {
                sb2.append(entry.getKey()).append(MiPushClient.ACCEPT_TIME_SEPARATOR);
                sb.append(entry.getValue()).append(MiPushClient.ACCEPT_TIME_SEPARATOR);
            }
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            hashMap.put("deviceid", sb.toString());
        }
        if (sb2.length() > 0) {
            sb2.deleteCharAt(sb2.length() - 1);
            hashMap.put("idtype", sb2.toString());
        }
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004b  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.String> m6026a(android.content.Context r5) {
        /*
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            java.lang.String r0 = "phone"
            java.lang.Object r0 = r5.getSystemService(r0)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            if (r0 != 0) goto L_0x0014
            java.lang.String r1 = "No IMEI."
            com.umeng.p085a.C1346h.m4991b(r1)
        L_0x0014:
            r1 = 0
            java.lang.String r3 = "android.permission.READ_PHONE_STATE"
            boolean r3 = com.umeng.p085a.C1343e.m4938a(r5, r3)     // Catch:{ Exception -> 0x0051 }
            if (r3 == 0) goto L_0x0055
            java.lang.String r0 = r0.getDeviceId()     // Catch:{ Exception -> 0x0051 }
        L_0x0021:
            java.lang.String r1 = com.umeng.p085a.C1343e.m4961q(r5)
            android.content.ContentResolver r3 = r5.getContentResolver()
            java.lang.String r4 = "android_id"
            java.lang.String r3 = android.provider.Settings.Secure.getString(r3, r4)
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 != 0) goto L_0x003a
            java.lang.String r4 = "mac"
            r2.put(r4, r1)
        L_0x003a:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0045
            java.lang.String r1 = "imei"
            r2.put(r1, r0)
        L_0x0045:
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L_0x0050
            java.lang.String r0 = "android_id"
            r2.put(r0, r3)
        L_0x0050:
            return r2
        L_0x0051:
            r0 = move-exception
            com.umeng.p085a.C1346h.m5013e(r0)
        L_0x0055:
            r0 = r1
            goto L_0x0021
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.social.AbstractC1572e.m6026a(android.content.Context):java.util.Map");
    }
}
