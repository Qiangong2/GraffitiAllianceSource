package com.wanmei.push.p102e;

import android.content.Context;
import android.text.TextUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.pwrd.google.gson.reflect.TypeToken;
import com.umeng.analytics.p091b.C1447g;
import com.wanmei.push.C1638a;
import com.wanmei.push.bean.AppState;
import com.wanmei.push.bean.Notice;
import com.wanmei.push.bean.StandardBaseResult;
import com.wanmei.push.bean.SyncAppInfo;
import com.wanmei.push.p100d.C1679c;
import com.wanmei.push.p102e.C1702d;
import com.wanmei.push.p104g.C1714f;
import com.wanmei.push.p104g.C1715g;
import com.wanmei.push.p104g.C1717i;
import com.wanmei.push.p104g.C1719k;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/* renamed from: com.wanmei.push.e.b */
public final class C1688b {

    /* renamed from: c */
    private static C1688b f4300c;

    /* renamed from: a */
    protected Context f4301a;

    /* renamed from: b */
    protected C1698c f4302b;

    private C1688b(Context context) {
        if (context != null) {
            this.f4301a = context.getApplicationContext();
            this.f4302b = new C1698c();
        }
    }

    /* renamed from: a */
    private <T> StandardBaseResult<T> m6321a(String str, HashMap<String, String> hashMap, Map<String, String> map, TypeToken<StandardBaseResult<T>> typeToken) {
        StandardBaseResult<T> standardBaseResult;
        C1714f.m6381b(this.f4301a, "PERFECT_PUSH", "Http Request : url -  [" + str + "] requestParams - [" + map.toString() + "] isUseHttps - [false]");
        StandardBaseResult<T> standardBaseResult2 = new StandardBaseResult<>();
        C1702d dVar = new C1702d(this.f4301a, str, map);
        if (hashMap != null && !hashMap.isEmpty()) {
            dVar.mo9356a(hashMap);
        }
        dVar.mo9354a(new C1702d.AbstractC1704a("UTF-8") {
            /* class com.wanmei.push.p102e.C1688b.C16979 */

            @Override // com.wanmei.push.p102e.C1702d.AbstractC1704a
            /* renamed from: a */
            public final String mo9346a(Map<String, String> map) {
                try {
                    C1688b bVar = C1688b.this;
                    String str = "UTF-8";
                    if (map == null) {
                        return null;
                    }
                    StringBuilder sb = new StringBuilder();
                    String str2 = C1719k.m6394a(str) ? "UTF-8" : str;
                    for (String str3 : map.keySet()) {
                        String str4 = map.get(str3);
                        if (!C1719k.m6394a(str4)) {
                            sb.append(str3).append(SimpleComparison.EQUAL_TO_OPERATION).append(URLEncoder.encode(str4, str2)).append("&");
                        }
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    return "";
                }
            }
        });
        String a = this.f4302b.mo9347a(dVar);
        C1714f.m6381b(this.f4301a, "PERFECT_PUSH", "Http Response Json : Json - [" + a + "] url -  [" + str + "] requestParams - [" + map.toString() + "] isUseHttps - [false]");
        if (TextUtils.isEmpty(a)) {
            return standardBaseResult2;
        }
        try {
            standardBaseResult = (StandardBaseResult) C1705e.m6357a(a, typeToken);
        } catch (Exception e) {
            C1714f.m6376a(this.f4301a, "PERFECT_PUSH", "sendStandardPostRequest " + e.getMessage());
            standardBaseResult = standardBaseResult2;
        }
        return standardBaseResult;
    }

    /* renamed from: a */
    public static C1688b m6322a(Context context) {
        if (f4300c == null) {
            f4300c = new C1688b(context);
        }
        return f4300c;
    }

    /* renamed from: a */
    private final String m6323a(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            C1679c.m6277a();
            str = C1679c.m6283b(this.f4301a).getAppClientSecret();
        }
        C1714f.m6379a("PERFECT_PUSH", "key  =" + str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str.substring(2, 5)).append(str.substring(10, 16)).append(str.substring(18, 20)).append(str.substring(14, 19));
        sb.append(sb2.toString());
        for (String str2 : new TreeSet(map.keySet())) {
            sb.append(str2).append(SimpleComparison.EQUAL_TO_OPERATION).append(TextUtils.isEmpty(map.get(str2)) ? "" : map.get(str2)).append("&");
        }
        return C1715g.m6384a(sb.deleteCharAt(sb.length() - 1).toString());
    }

    /* renamed from: d */
    private final String m6324d(Map<String, String> map) {
        return m6323a(map, (String) null);
    }

    /* renamed from: a */
    public final StandardBaseResult<?> mo9338a() {
        HashMap<String, String> hashMap = new HashMap<>();
        HashMap hashMap2 = new HashMap();
        C1679c.m6277a();
        String appClientId = C1679c.m6283b(this.f4301a).getAppClientId();
        C1679c.m6277a();
        String deviceId = C1679c.m6276a(this.f4301a).getDeviceId();
        C1679c.m6277a();
        String packageName = C1679c.m6283b(this.f4301a).getPackageName();
        hashMap2.put(AppState.APP_ID, appClientId);
        hashMap2.put("deviceId", deviceId);
        hashMap2.put("platform", "1");
        hashMap2.put("bundleId", packageName);
        hashMap2.put("v", "1.0");
        hashMap2.put("t", Long.toString(System.currentTimeMillis()));
        int i = 0;
        if (C1717i.m6392b()) {
            i = 1;
        }
        hashMap2.put("systemType", String.valueOf(i));
        hashMap2.put("sign", m6324d(hashMap2));
        return m6321a(C1687a.f4293c, hashMap, hashMap2, new TypeToken<StandardBaseResult<Object>>() {
            /* class com.wanmei.push.p102e.C1688b.C16902 */
        });
    }

    /* renamed from: a */
    public final StandardBaseResult<String> mo9339a(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        HashMap hashMap2 = new HashMap();
        C1679c.m6277a();
        String appClientId = C1679c.m6283b(this.f4301a).getAppClientId();
        C1679c.m6277a();
        String deviceId = C1679c.m6276a(this.f4301a).getDeviceId();
        C1679c.m6277a();
        String packageName = C1679c.m6283b(this.f4301a).getPackageName();
        hashMap2.put(AppState.APP_ID, appClientId);
        hashMap2.put("deviceId", deviceId);
        hashMap2.put("bundleId", packageName);
        hashMap2.put("certType", str);
        hashMap2.put("v", "1.0");
        hashMap2.put("t", Long.toString(System.currentTimeMillis()));
        hashMap2.put("sign", m6324d(hashMap2));
        return m6321a(C1687a.f4294d, hashMap, hashMap2, new TypeToken<StandardBaseResult<String>>() {
            /* class com.wanmei.push.p102e.C1688b.C16924 */
        });
    }

    /* renamed from: a */
    public final StandardBaseResult<String> mo9340a(String str, String str2) {
        HashMap<String, String> hashMap = new HashMap<>();
        HashMap hashMap2 = new HashMap();
        C1679c.m6277a();
        String deviceId = C1679c.m6276a(this.f4301a).getDeviceId();
        hashMap2.put("sdkType", String.valueOf(C1638a.f4213b));
        hashMap2.put("sdkAppId", str);
        hashMap2.put("platform", String.valueOf(C1638a.f4214c));
        hashMap2.put("deviceId", deviceId);
        hashMap2.put("bundleId", this.f4301a.getPackageName());
        hashMap2.put("v", "1.0");
        hashMap2.put("t", Long.toString(System.currentTimeMillis()));
        hashMap2.put("sign", m6323a(hashMap2, str2));
        return m6321a(C1687a.f4292b, hashMap, hashMap2, new TypeToken<StandardBaseResult<String>>() {
            /* class com.wanmei.push.p102e.C1688b.C16891 */
        });
    }

    /* renamed from: a */
    public final StandardBaseResult<?> mo9341a(Map<String, String> map) {
        HashMap<String, String> hashMap = new HashMap<>();
        String str = "";
        HashMap hashMap2 = new HashMap();
        C1679c.m6277a();
        String appClientId = C1679c.m6283b(this.f4301a).getAppClientId();
        C1679c.m6277a();
        String deviceId = C1679c.m6276a(this.f4301a).getDeviceId();
        String str2 = map.containsKey(AppState.STATE) ? map.get(AppState.STATE) : "";
        if (map.containsKey(AppState.APP_ID)) {
            str = map.get(AppState.APP_ID);
        }
        String str3 = map.containsKey(AppState.PACKAGE_NAME) ? map.get(AppState.PACKAGE_NAME) : "";
        hashMap2.put(AppState.APP_ID, appClientId);
        hashMap2.put("uAppId", str);
        hashMap2.put("deviceId", deviceId);
        hashMap2.put("platform", "1");
        hashMap2.put("uBundleId", str3);
        hashMap2.put(AppState.STATE, str2);
        hashMap2.put("v", "1.0");
        hashMap2.put("t", Long.toString(System.currentTimeMillis()));
        hashMap2.put("sign", m6324d(hashMap2));
        return m6321a(C1687a.f4297g, hashMap, hashMap2, new TypeToken<StandardBaseResult<Object>>() {
            /* class com.wanmei.push.p102e.C1688b.C16946 */
        });
    }

    /* renamed from: b */
    public final StandardBaseResult<?> mo9342b() {
        HashMap<String, String> hashMap = new HashMap<>();
        HashMap hashMap2 = new HashMap();
        C1679c.m6277a();
        String appClientId = C1679c.m6283b(this.f4301a).getAppClientId();
        C1679c.m6277a();
        String deviceId = C1679c.m6276a(this.f4301a).getDeviceId();
        C1679c.m6277a();
        String deviceName = C1679c.m6276a(this.f4301a).getDeviceName();
        C1679c.m6277a();
        String sysVersion = C1679c.m6276a(this.f4301a).getSysVersion();
        C1679c.m6277a();
        String resolution = C1679c.m6276a(this.f4301a).getResolution();
        hashMap2.put(AppState.APP_ID, appClientId);
        hashMap2.put("deviceId", deviceId);
        hashMap2.put("platform", "1");
        hashMap2.put("deviceName", deviceName);
        hashMap2.put("sysVersion", sysVersion);
        hashMap2.put(C1447g.f3523r, resolution);
        hashMap2.put("isBreak", "0");
        hashMap2.put("v", "1.0");
        hashMap2.put("t", Long.toString(System.currentTimeMillis()));
        hashMap2.put("sign", m6324d(hashMap2));
        return m6321a(C1687a.f4295e, hashMap, hashMap2, new TypeToken<StandardBaseResult<Object>>() {
            /* class com.wanmei.push.p102e.C1688b.C16913 */
        });
    }

    /* renamed from: b */
    public final StandardBaseResult<?> mo9343b(Map<String, String> map) {
        HashMap<String, String> hashMap = new HashMap<>();
        String str = "";
        String str2 = "";
        HashMap hashMap2 = new HashMap();
        C1679c.m6277a();
        String appClientId = C1679c.m6283b(this.f4301a).getAppClientId();
        C1679c.m6277a();
        String deviceId = C1679c.m6276a(this.f4301a).getDeviceId();
        if (map.containsKey(Notice.MSG_ID) && map.containsKey(Notice.IS_OFFLINE)) {
            str = map.get(Notice.MSG_ID);
            str2 = map.get(Notice.IS_OFFLINE);
        }
        hashMap2.put(AppState.APP_ID, appClientId);
        hashMap2.put("deviceId", deviceId);
        hashMap2.put("platform", "1");
        hashMap2.put(Notice.MSG_ID, str);
        hashMap2.put(Notice.IS_OFFLINE, str2);
        hashMap2.put("v", "1.0");
        hashMap2.put("t", Long.toString(System.currentTimeMillis()));
        hashMap2.put("sign", m6324d(hashMap2));
        return m6321a(C1687a.f4298h, hashMap, hashMap2, new TypeToken<StandardBaseResult<Object>>() {
            /* class com.wanmei.push.p102e.C1688b.C16957 */
        });
    }

    /* renamed from: c */
    public final StandardBaseResult<SyncAppInfo> mo9344c() {
        HashMap<String, String> hashMap = new HashMap<>();
        HashMap hashMap2 = new HashMap();
        C1679c.m6277a();
        String appClientId = C1679c.m6283b(this.f4301a).getAppClientId();
        C1679c.m6277a();
        String deviceId = C1679c.m6276a(this.f4301a).getDeviceId();
        hashMap2.put(AppState.APP_ID, appClientId);
        hashMap2.put("deviceId", deviceId);
        hashMap2.put("v", "1.0");
        hashMap2.put("t", Long.toString(System.currentTimeMillis()));
        hashMap2.put("sign", m6324d(hashMap2));
        return m6321a(C1687a.f4296f, hashMap, hashMap2, new TypeToken<StandardBaseResult<SyncAppInfo>>() {
            /* class com.wanmei.push.p102e.C1688b.C16935 */
        });
    }

    /* renamed from: c */
    public final StandardBaseResult<?> mo9345c(Map<String, String> map) {
        HashMap<String, String> hashMap = new HashMap<>();
        String str = "";
        HashMap hashMap2 = new HashMap();
        C1679c.m6277a();
        String appClientId = C1679c.m6283b(this.f4301a).getAppClientId();
        C1679c.m6277a();
        String deviceId = C1679c.m6276a(this.f4301a).getDeviceId();
        if (map.containsKey(Notice.MSG_ID)) {
            str = map.get(Notice.MSG_ID);
        }
        hashMap2.put(AppState.APP_ID, appClientId);
        hashMap2.put("deviceId", deviceId);
        hashMap2.put("platform", "1");
        hashMap2.put(Notice.MSG_ID, str);
        hashMap2.put("v", "1.0");
        hashMap2.put("t", Long.toString(System.currentTimeMillis()));
        hashMap2.put("sign", m6324d(hashMap2));
        return m6321a(C1687a.f4299i, hashMap, hashMap2, new TypeToken<StandardBaseResult<Object>>() {
            /* class com.wanmei.push.p102e.C1688b.C16968 */
        });
    }
}
