package com.amap.loc;

import android.content.Context;
import java.lang.Thread;

/* renamed from: com.amap.loc.t */
/* compiled from: BasicLogHandler */
public class C0365t {

    /* renamed from: a */
    protected static C0365t f919a;

    /* renamed from: b */
    protected Thread.UncaughtExceptionHandler f920b;

    /* renamed from: c */
    protected boolean f921c = true;

    /* renamed from: a */
    public static void m1372a(Throwable th, String str, String str2) {
        th.printStackTrace();
        if (f919a != null) {
            f919a.mo3949a(th, 1, str, str2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3947a(Context context, C0360q qVar, boolean z) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3948a(C0360q qVar, String str, String str2) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3949a(Throwable th, int i, String str, String str2) {
    }
}
