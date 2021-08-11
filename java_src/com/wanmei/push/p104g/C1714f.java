package com.wanmei.push.p104g;

import android.content.Context;
import android.util.Log;
import com.wanmei.push.p100d.C1679c;

/* renamed from: com.wanmei.push.g.f */
public final class C1714f {

    /* renamed from: a */
    private static boolean f4353a = false;

    /* renamed from: a */
    public static void m6376a(Context context, String str, String str2) {
        C1679c.m6277a();
        if (C1679c.m6290f(context)) {
            Log.d(str, str2);
        }
    }

    /* renamed from: a */
    public static void m6377a(Context context, String str, String str2, Throwable th) {
        C1679c.m6277a();
        if (C1679c.m6290f(context)) {
            Log.e(str, str2, th);
        }
    }

    /* renamed from: a */
    public static void m6378a(Context context, boolean z) {
        f4353a = z;
        C1679c.m6277a();
        C1679c.m6282a(context, z);
    }

    /* renamed from: a */
    public static void m6379a(String str, String str2) {
        if (f4353a) {
            Log.d(str, str2);
        }
    }

    /* renamed from: a */
    public static void m6380a(String str, String str2, Throwable th) {
        if (f4353a) {
            Log.e(str, str2, th);
        }
    }

    /* renamed from: b */
    public static void m6381b(Context context, String str, String str2) {
        C1679c.m6277a();
        if (C1679c.m6290f(context)) {
            Log.i(str, str2);
        }
    }

    /* renamed from: b */
    public static void m6382b(String str, String str2) {
        if (f4353a) {
            Log.e(str, str2);
        }
    }

    /* renamed from: c */
    public static void m6383c(Context context, String str, String str2) {
        C1679c.m6277a();
        if (C1679c.m6290f(context)) {
            Log.e(str, str2);
        }
    }
}
