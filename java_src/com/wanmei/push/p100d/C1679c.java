package com.wanmei.push.p100d;

import android.content.Context;
import android.content.SharedPreferences;
import com.wanmei.push.bean.AppInfo;
import com.wanmei.push.bean.DeviceInfo;
import com.wanmei.push.p104g.C1714f;

/* renamed from: com.wanmei.push.d.c */
public final class C1679c {

    /* renamed from: a */
    private static C1679c f4267a = new C1679c();

    private C1679c() {
    }

    /* renamed from: a */
    public static DeviceInfo m6276a(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("onepush_preference_device_info", 0);
        if (!sharedPreferences.contains("push_preference_device_id")) {
            return null;
        }
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setDeviceId(sharedPreferences.getString("push_preference_device_id", null));
        deviceInfo.setDeviceName(sharedPreferences.getString("push_preference_device_name", null));
        deviceInfo.setSysVersion(sharedPreferences.getString("push_preference_sys_version", null));
        deviceInfo.setResolution(sharedPreferences.getString("push_preference_resolution", null));
        return deviceInfo;
    }

    /* renamed from: a */
    public static C1679c m6277a() {
        return f4267a;
    }

    /* renamed from: a */
    public static void m6278a(Context context, int i) {
        SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences("onepush_preference_settings", 0).edit();
        edit.putInt("push_preference_notify_icon", i);
        edit.commit();
    }

    /* renamed from: a */
    public static void m6279a(Context context, AppInfo appInfo) {
        if (appInfo != null) {
            C1714f.m6379a("PERFECT_PUSH", "setAppInfo = " + appInfo.toString());
        }
        if (context == null) {
            C1714f.m6379a("PERFECT_PUSH", "context = NULL");
            return;
        }
        SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences("onepush_preference_app_info", 0).edit();
        edit.putString("push_preference_app_id", appInfo.getAppClientId());
        edit.putString("push_preference_app_key", appInfo.getAppClientSecret());
        edit.putString("push_preference_package_name", appInfo.getPackageName());
        edit.commit();
    }

    /* renamed from: a */
    public static void m6280a(Context context, DeviceInfo deviceInfo) {
        SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences("onepush_preference_device_info", 0).edit();
        edit.putString("push_preference_device_id", deviceInfo.getDeviceId());
        edit.putString("push_preference_device_name", deviceInfo.getDeviceName());
        edit.putString("push_preference_sys_version", deviceInfo.getSysVersion());
        edit.putString("push_preference_resolution", deviceInfo.getResolution());
        edit.commit();
    }

    /* renamed from: a */
    public static void m6281a(Context context, String str) {
        SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences("onepush_preference_device_info", 0).edit();
        edit.putString("push_preference_device_android_id", str);
        edit.commit();
    }

    /* renamed from: a */
    public static void m6282a(Context context, boolean z) {
        SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences("onepush_preference_settings", 0).edit();
        edit.putBoolean("push_preference_show_debug_log", z);
        edit.commit();
    }

    /* renamed from: b */
    public static AppInfo m6283b(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("onepush_preference_app_info", 0);
        if (!sharedPreferences.contains("push_preference_app_id")) {
            return null;
        }
        AppInfo appInfo = new AppInfo();
        appInfo.setAppClientId(sharedPreferences.getString("push_preference_app_id", ""));
        appInfo.setAppClientSecret(sharedPreferences.getString("push_preference_app_key", ""));
        appInfo.setPackageName(sharedPreferences.getString("push_preference_package_name", ""));
        return appInfo;
    }

    /* renamed from: b */
    public static void m6284b(Context context, String str) {
        SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences("onepush_preference_device_info", 0).edit();
        edit.putString("push_preference_device_mac", str);
        edit.commit();
    }

    /* renamed from: c */
    public static int m6285c(Context context) {
        return context.getApplicationContext().getSharedPreferences("onepush_preference_settings", 0).getInt("push_preference_notify_icon", context.getApplicationInfo().icon);
    }

    /* renamed from: c */
    public static void m6286c(Context context, String str) {
        SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences("push_preference_data", 0).edit();
        edit.putString("push_preference_host_package_name", str);
        edit.commit();
    }

    /* renamed from: d */
    public static String m6287d(Context context) {
        return context.getApplicationContext().getSharedPreferences("onepush_preference_device_info", 0).getString("push_preference_device_android_id", "");
    }

    /* renamed from: d */
    public static void m6288d(Context context, String str) {
        SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences("push_preference_data", 0).edit();
        edit.putString("push_preference_successor_package_name", str);
        edit.commit();
    }

    /* renamed from: e */
    public static String m6289e(Context context) {
        return context.getApplicationContext().getSharedPreferences("onepush_preference_device_info", 0).getString("push_preference_device_mac", "");
    }

    /* renamed from: f */
    public static boolean m6290f(Context context) {
        return context.getApplicationContext().getSharedPreferences("onepush_preference_settings", 0).getBoolean("push_preference_show_debug_log", false);
    }

    /* renamed from: g */
    public static String m6291g(Context context) {
        return context.getApplicationContext().getSharedPreferences("push_preference_data", 0).getString("push_preference_host_package_name", "");
    }

    /* renamed from: h */
    public static String m6292h(Context context) {
        return context.getApplicationContext().getSharedPreferences("push_preference_data", 0).getString("push_preference_successor_package_name", "");
    }
}
