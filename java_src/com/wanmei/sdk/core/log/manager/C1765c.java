package com.wanmei.sdk.core.log.manager;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.wanmei.sdk.core.log.manager.c */
public final class C1765c {

    /* renamed from: a */
    private static C1765c f4455a = new C1765c();

    private C1765c() {
    }

    /* renamed from: a */
    public static C1765c m6499a() {
        return f4455a;
    }

    /* renamed from: a */
    public static void m6500a(Context context, boolean z) {
        SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences("log_preference_settings", 0).edit();
        edit.putBoolean("log_preference_show_debug_log", z);
        edit.commit();
    }

    /* renamed from: a */
    public static boolean m6501a(Context context) {
        return context.getApplicationContext().getSharedPreferences("log_preference_settings", 0).getBoolean("log_preference_show_debug_log", false);
    }
}
