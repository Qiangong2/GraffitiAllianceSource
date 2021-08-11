package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.p085a.C1360l;

/* renamed from: com.umeng.analytics.c */
/* compiled from: InternalConfig */
public class C1448c {

    /* renamed from: a */
    private static String[] f3532a = new String[2];

    /* renamed from: a */
    public static void m5332a(Context context, String str, String str2) {
        f3532a[0] = str;
        f3532a[1] = str2;
        if (context != null) {
            C1360l.m5038a(context).mo8378a(str, str2);
        }
    }

    /* renamed from: a */
    public static String[] m5333a(Context context) {
        String[] a;
        if (!TextUtils.isEmpty(f3532a[0]) && !TextUtils.isEmpty(f3532a[1])) {
            return f3532a;
        }
        if (context == null || (a = C1360l.m5038a(context).mo8380a()) == null) {
            return null;
        }
        f3532a[0] = a[0];
        f3532a[1] = a[1];
        return f3532a;
    }

    /* renamed from: b */
    public static void m5334b(Context context) {
        f3532a[0] = null;
        f3532a[1] = null;
        if (context != null) {
            C1360l.m5038a(context).mo8381b();
        }
    }
}
