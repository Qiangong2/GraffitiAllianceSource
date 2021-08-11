package com.umeng.analytics.p093d;

import com.umeng.analytics.AnalyticsConfig;
import java.lang.Thread;

/* renamed from: com.umeng.analytics.d.e */
/* compiled from: CrashHandler */
public class C1478e implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private Thread.UncaughtExceptionHandler f3657a;

    /* renamed from: b */
    private AbstractC1486k f3658b;

    public C1478e() {
        if (Thread.getDefaultUncaughtExceptionHandler() != this) {
            this.f3657a = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    /* renamed from: a */
    public void mo8630a(AbstractC1486k kVar) {
        this.f3658b = kVar;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        m5482a(th);
        if (this.f3657a != null && this.f3657a != Thread.getDefaultUncaughtExceptionHandler()) {
            this.f3657a.uncaughtException(thread, th);
        }
    }

    /* renamed from: a */
    private void m5482a(Throwable th) {
        if (AnalyticsConfig.CATCH_EXCEPTION) {
            this.f3658b.mo8514a(th);
        } else {
            this.f3658b.mo8514a(null);
        }
    }
}
