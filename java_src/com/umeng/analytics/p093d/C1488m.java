package com.umeng.analytics.p093d;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.umeng.analytics.d.m */
/* compiled from: PreferenceWrapper */
public class C1488m {

    /* renamed from: a */
    private static final String f3676a = "umeng_general_config";

    private C1488m() {
    }

    /* renamed from: a */
    public static SharedPreferences m5523a(Context context, String str) {
        return context.getSharedPreferences(str, 0);
    }

    /* renamed from: a */
    public static SharedPreferences m5522a(Context context) {
        return context.getSharedPreferences(f3676a, 0);
    }
}
