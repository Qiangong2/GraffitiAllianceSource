package com.igexin.p012b.p013a.p019c;

import android.app.Activity;
import android.util.Log;
import com.igexin.push.config.C0518o;
import java.lang.Thread;

/* renamed from: com.igexin.b.a.c.a */
public class ActivityC0460a extends Activity implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    public static boolean f1090a = C0518o.f1336a.equals("debug");

    /* renamed from: a */
    public static synchronized void m1696a(String str) {
        synchronized (ActivityC0460a.class) {
            m1698b(str);
        }
    }

    /* renamed from: a */
    public static void m1697a(String str, String str2) {
        if (f1090a) {
            Log.d(str, str2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e5 A[SYNTHETIC, Splitter:B:39:0x00e5] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f3 A[SYNTHETIC, Splitter:B:45:0x00f3] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void m1698b(java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 257
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.p012b.p013a.p019c.ActivityC0460a.m1698b(java.lang.String):void");
    }

    /* renamed from: b */
    public static void m1699b(String str, String str2) {
        if (f1090a) {
            Log.i(str, str2);
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
    }
}
