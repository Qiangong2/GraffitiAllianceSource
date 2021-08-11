package com.igexin.push.extension.distribution.basic.p046g.p047a;

import android.content.Context;
import com.igexin.push.extension.distribution.basic.p046g.p052f.C0767a;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.igexin.push.extension.distribution.basic.g.a.b */
public class C0754b {

    /* renamed from: a */
    private static C0754b f2097a;

    /* renamed from: b */
    private ThreadPoolExecutor f2098b = new ThreadPoolExecutor(3, 3, 5, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0755c());

    private C0754b() {
        this.f2098b.allowCoreThreadTimeOut(true);
    }

    /* renamed from: a */
    public static C0754b m3084a() {
        if (f2097a == null) {
            f2097a = new C0754b();
        }
        return f2097a;
    }

    /* renamed from: a */
    public void mo5082a(Context context, Runnable runnable) {
        if (C0767a.m3156b(context)) {
            this.f2098b.execute(runnable);
        }
    }
}
