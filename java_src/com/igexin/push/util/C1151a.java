package com.igexin.push.util;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.config.C0514k;
import com.igexin.push.core.C0519a;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.bean.C0590c;
import com.igexin.sdk.PushBuildConfig;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.igexin.push.util.a */
public class C1151a {

    /* renamed from: a */
    private static final String f3018a = C1151a.class.getName();

    /* renamed from: a */
    public static String m4736a(Context context) {
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        } catch (Throwable th) {
        }
        return null;
    }

    /* renamed from: a */
    private static void m4737a(Map<String, C0590c> map, String str) {
        map.remove(str);
        for (String str2 : map.get(str).mo4516b()) {
            C0590c cVar = map.get(str2);
            if (cVar != null) {
                cVar.mo4519e();
                if (cVar.mo4517c() == 0) {
                    m4737a(map, str2);
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m4738a() {
        try {
            if (PushBuildConfig.sdk_conf_debug_level.equals(C0514k.f1326r)) {
                return false;
            }
            for (String str : C0514k.f1326r.split(MiPushClient.ACCEPT_TIME_SEPARATOR)) {
                if (m4749b(str)) {
                    return false;
                }
            }
            if (PushBuildConfig.sdk_conf_debug_level.equals(C0514k.f1327s)) {
                return false;
            }
            String[] split = C0514k.f1327s.split(MiPushClient.ACCEPT_TIME_SEPARATOR);
            Class<?> cls = Class.forName("android.os.ServiceManager");
            Method method = cls.getMethod("getService", String.class);
            method.setAccessible(true);
            for (String str2 : split) {
                if (m4742a(cls, method, str2)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m4739a(long j) {
        Date date = new Date(j);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int i = instance.get(11);
        int i2 = C0514k.f1309a + C0514k.f1310b;
        if (i2 >= 24) {
            i2 -= 24;
        }
        if (C0514k.f1310b == 0) {
            return false;
        }
        if (C0514k.f1309a < i2) {
            if (i >= C0514k.f1309a && i < i2) {
                return true;
            }
        } else if (C0514k.f1309a > i2) {
            if (i >= 0 && i < i2) {
                return true;
            }
            if (i >= C0514k.f1309a && i < 24) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m4740a(Intent intent, Context context) {
        if (intent == null || context == null) {
            return false;
        }
        try {
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            return queryIntentServices != null && queryIntentServices.size() > 0;
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m4741a(ServiceInfo serviceInfo, PackageInfo packageInfo) {
        return C0519a.f1351o.equals(serviceInfo.name) || C0519a.f1350n.equals(serviceInfo.name) || C0519a.f1352p.equals(serviceInfo.name);
    }

    /* renamed from: a */
    private static boolean m4742a(Class<?> cls, Method method, String str) {
        try {
            return method.invoke(cls, new Object[]{str}) != null;
        } catch (Exception e) {
            return true;
        }
    }

    /* renamed from: a */
    public static boolean m4743a(String str) {
        try {
            return C0618g.f1635f.getPackageManager().getLaunchIntentForPackage(str) != null;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a */
    public static <T extends Service> boolean m4744a(String str, Context context, Class<T> cls) {
        if (cls == null) {
            try {
                if (!m4748b(new Intent(context, Class.forName(C0519a.f1350n)), context)) {
                    Log.e(str, "call - > initialize, parameter [userServiceName] is null use default PushService, but didn't find class \"com.igexin.sdk.PushService\", please check your AndroidManifest");
                    return false;
                }
            } catch (Throwable th) {
                ActivityC0460a.m1698b(f3018a + "|" + th.toString());
                return false;
            }
        }
        if (cls != null && C0519a.f1350n.equals(cls.getName()) && !m4748b(new Intent(context, (Class<?>) cls), context)) {
            Log.e(str, "call - > initialize, parameter [userServiceName] is default PushService, but didn't find class \"com.igexin.sdk.PushService\", please check your AndroidManifest");
            return false;
        } else if (cls == null || m4748b(new Intent(context, (Class<?>) cls), context)) {
            if (cls != null) {
                Class.forName(cls.getName());
            }
            return true;
        } else {
            Log.e(str, "call - > initialize, parameter [userServiceName] is set, but didn't find class \"" + cls.getName() + "\", please check your AndroidManifest");
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m4745a(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return false;
            }
            Intent intent = new Intent();
            intent.setClassName(str, str2);
            return C0618g.f1635f.getPackageManager().resolveActivity(intent, 0) != null;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m4746a(JSONObject jSONObject) {
        try {
            HashMap hashMap = new HashMap();
            JSONArray jSONArray = jSONObject.getJSONArray("action_chains");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                C0590c cVar = new C0590c();
                if (jSONObject2.has("actionid")) {
                    cVar.mo4514a(jSONObject2.getString("actionid"));
                    ArrayList arrayList = new ArrayList();
                    if (jSONObject2.has("type")) {
                        String string = jSONObject2.getString("type");
                        if ("popup".equals(string)) {
                            if (jSONObject2.has("buttons")) {
                                JSONArray jSONArray2 = jSONObject2.getJSONArray("buttons");
                                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                                    if (((JSONObject) jSONArray2.get(i2)).has("do")) {
                                        arrayList.add(((JSONObject) jSONArray2.get(i2)).getString("do"));
                                    }
                                }
                            }
                            if (jSONObject2.has("do")) {
                                arrayList.add(jSONObject2.getString("do"));
                            }
                        } else if ("startapp".equals(string)) {
                            if (jSONObject2.has("noinstall_action")) {
                                arrayList.add(jSONObject2.getString("noinstall_action"));
                            }
                            if (jSONObject2.has("do")) {
                                arrayList.add(jSONObject2.getString("do"));
                            }
                        } else if ("checkapp".equals(string)) {
                            if (jSONObject2.has("do_installed")) {
                                arrayList.add(jSONObject2.getString("do_installed"));
                            }
                            if (jSONObject2.has("do_uninstalled")) {
                                arrayList.add(jSONObject2.getString("do_uninstalled"));
                            }
                        } else if ("checkversions".equals(string)) {
                            if (jSONObject2.has("do_match")) {
                                arrayList.add(jSONObject2.getString("do_match"));
                            }
                            if (jSONObject2.has("do_dismatch")) {
                                arrayList.add(jSONObject2.getString("do_dismatch"));
                            }
                            if (jSONObject2.has("do")) {
                                arrayList.add(jSONObject2.getString("do"));
                            }
                        } else if ("startintent".equals(string)) {
                            if (jSONObject2.has("do_failed")) {
                                arrayList.add(jSONObject2.getString("do_failed"));
                            }
                            if (jSONObject2.has("do")) {
                                arrayList.add(jSONObject2.getString("do"));
                            }
                        } else if (!"null".equals(string) && jSONObject2.has("do")) {
                            arrayList.add(jSONObject2.getString("do"));
                        }
                        cVar.mo4515a(arrayList);
                        hashMap.put(cVar.mo4513a(), cVar);
                    }
                }
            }
            ArrayList<C0590c> arrayList2 = new ArrayList(hashMap.values());
            for (Map.Entry entry : hashMap.entrySet()) {
                List<String> b = ((C0590c) entry.getValue()).mo4516b();
                if (b != null) {
                    for (String str : b) {
                        C0590c cVar2 = (C0590c) hashMap.get(str);
                        if (cVar2 != null) {
                            cVar2.mo4518d();
                            if (arrayList2.contains(cVar2)) {
                                arrayList2.remove(cVar2);
                            }
                        }
                    }
                }
            }
            for (C0590c cVar3 : arrayList2) {
                m4737a(hashMap, cVar3.mo4513a());
            }
            if (hashMap.size() > 0) {
                ActivityC0460a.m1698b(f3018a + "|action_chains have loop nodeMap not empty");
                return true;
            }
        } catch (Throwable th) {
            ActivityC0460a.m1698b(f3018a + "|isHaveLoop exception :" + th.toString());
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m4747b() {
        return System.currentTimeMillis() > C0514k.f1311c;
    }

    /* renamed from: b */
    public static boolean m4748b(Intent intent, Context context) {
        if (intent == null || context == null) {
            return false;
        }
        try {
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            return queryIntentServices != null && queryIntentServices.size() > 0;
        } catch (Throwable th) {
            ActivityC0460a.m1698b(f3018a + "|" + th.toString());
            return false;
        }
    }

    /* renamed from: b */
    private static boolean m4749b(String str) {
        try {
            C0618g.f1635f.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m4750c() {
        try {
            PackageManager packageManager = C0618g.f1635f.getPackageManager();
            String packageName = C0618g.f1635f.getPackageName();
            return packageManager.checkPermission("android.permission.ACCESS_WIFI_STATE", packageName) == 0 && packageManager.checkPermission("android.permission.CHANGE_WIFI_STATE", packageName) == 0;
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: d */
    public static boolean m4751d() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) C0618g.f1635f.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    /* renamed from: e */
    public static boolean m4752e() {
        try {
            Class.forName("android.support.v4.content.LocalBroadcastManager");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: f */
    public static boolean m4753f() {
        try {
            for (String str : C0514k.f1304J.split(MiPushClient.ACCEPT_TIME_SEPARATOR)) {
                if (Build.MODEL.toLowerCase().contains(str.toLowerCase())) {
                    return false;
                }
            }
        } catch (Throwable th) {
        }
        return true;
    }
}
