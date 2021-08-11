package com.xiaomi.channel.commonutils.android;

import android.content.Context;
import android.preference.PreferenceManager;

/* renamed from: com.xiaomi.channel.commonutils.android.a */
public abstract class AbstractC1850a {
    /* renamed from: a */
    public static void m6699a(Context context) {
    }

    /* renamed from: a */
    public static boolean m6700a(Context context, String str, boolean z) {
        m6699a(context);
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z);
    }

    /* renamed from: b */
    public static void m6701b(Context context, String str, boolean z) {
        m6699a(context);
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(str, z).commit();
    }
}
