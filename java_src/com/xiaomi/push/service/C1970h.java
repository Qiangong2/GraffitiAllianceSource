package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.igexin.assist.sdk.AssistPushConsts;
import com.umeng.analytics.p091b.C1447g;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.channel.commonutils.misc.C1856a;
import com.xiaomi.channel.commonutils.network.C1863b;
import com.xiaomi.channel.commonutils.network.C1865d;
import com.xiaomi.channel.commonutils.string.C1873d;
import java.util.TreeMap;
import org.json.JSONObject;

/* renamed from: com.xiaomi.push.service.h */
public class C1970h {

    /* renamed from: a */
    private static C1969g f5079a;

    /* renamed from: a */
    public static synchronized C1969g m7328a(Context context) {
        C1969g gVar = null;
        synchronized (C1970h.class) {
            if (f5079a != null) {
                gVar = f5079a;
            } else {
                SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_account", 0);
                String string = sharedPreferences.getString("uuid", null);
                String string2 = sharedPreferences.getString(AssistPushConsts.MSG_TYPE_TOKEN, null);
                String string3 = sharedPreferences.getString("security", null);
                String string4 = sharedPreferences.getString("app_id", null);
                String string5 = sharedPreferences.getString("app_token", null);
                String string6 = sharedPreferences.getString(C1447g.f3510e, null);
                String string7 = sharedPreferences.getString(C1447g.f3526u, null);
                int i = sharedPreferences.getInt("env_type", 1);
                if (!TextUtils.isEmpty(string7) && string7.startsWith("a-")) {
                    string7 = C1968f.m7324c(context);
                    sharedPreferences.edit().putString(C1447g.f3526u, string7).commit();
                }
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                    String c = C1968f.m7324c(context);
                    if ("com.xiaomi.xmsf".equals(context.getPackageName()) || TextUtils.isEmpty(c) || TextUtils.isEmpty(string7) || string7.equals(c)) {
                        f5079a = new C1969g(string, string2, string3, string4, string5, string6, i);
                        gVar = f5079a;
                    } else {
                        AbstractC1855b.m6723d("erase the old account.");
                        m7332b(context);
                    }
                }
            }
        }
        return gVar;
    }

    /* renamed from: a */
    public static synchronized C1969g m7329a(Context context, String str, String str2, String str3) {
        PackageInfo packageInfo;
        C1969g gVar = null;
        synchronized (C1970h.class) {
            TreeMap treeMap = new TreeMap();
            treeMap.put("devid", C1968f.m7322a(context));
            String str4 = m7333c(context) ? "1000271" : str2;
            String str5 = m7333c(context) ? "420100086271" : str3;
            String str6 = m7333c(context) ? "com.xiaomi.xmsf" : str;
            treeMap.put("appid", str4);
            treeMap.put("apptoken", str5);
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str6, 16384);
            } catch (Exception e) {
                AbstractC1855b.m6720a(e);
                packageInfo = null;
            }
            treeMap.put("appversion", packageInfo != null ? String.valueOf(packageInfo.versionCode) : "0");
            treeMap.put("'sdkversion", Integer.toString(8));
            treeMap.put("packagename", str6);
            treeMap.put("model", Build.MODEL);
            treeMap.put("imei_md5", C1873d.m6782a(C1968f.m7323b(context)));
            treeMap.put(C1447g.f3521p, Build.VERSION.RELEASE + "-" + Build.VERSION.INCREMENTAL);
            C1863b a = C1865d.m6749a(context, m7330a(), treeMap);
            String str7 = "";
            if (a != null) {
                str7 = a.mo9938a();
            }
            if (!TextUtils.isEmpty(str7)) {
                JSONObject jSONObject = new JSONObject(str7);
                if (jSONObject.getInt("code") == 0) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    gVar = new C1969g(jSONObject2.getString("userId") + "@xiaomi.com/an" + C1873d.m6781a(6), jSONObject2.getString(AssistPushConsts.MSG_TYPE_TOKEN), jSONObject2.getString("ssecurity"), str4, str5, str6, C1856a.m6728c());
                    m7331a(context, gVar);
                    f5079a = gVar;
                } else {
                    C1973k.m7340a(context, jSONObject.getInt("code"), jSONObject.optString("description"));
                    AbstractC1855b.m6718a(str7);
                }
            }
        }
        return gVar;
    }

    /* renamed from: a */
    public static String m7330a() {
        if (C1856a.m6727b()) {
            return "http://10.237.12.17:9085/pass/register";
        }
        return "https://" + (C1856a.m6726a() ? "sandbox.xmpush.xiaomi.com" : "register.xmpush.xiaomi.com") + "/pass/register";
    }

    /* renamed from: a */
    private static void m7331a(Context context, C1969g gVar) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putString("uuid", gVar.f5072a);
        edit.putString("security", gVar.f5074c);
        edit.putString(AssistPushConsts.MSG_TYPE_TOKEN, gVar.f5073b);
        edit.putString("app_id", gVar.f5075d);
        edit.putString(C1447g.f3510e, gVar.f5077f);
        edit.putString("app_token", gVar.f5076e);
        edit.putString(C1447g.f3526u, C1968f.m7324c(context));
        edit.putInt("env_type", gVar.f5078g);
        edit.commit();
    }

    /* renamed from: b */
    public static void m7332b(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        f5079a = null;
    }

    /* renamed from: c */
    private static boolean m7333c(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }
}
