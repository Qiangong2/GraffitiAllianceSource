package com.amap.loc;

import android.content.Context;
import android.text.TextUtils;
import java.lang.Thread;

/* renamed from: com.amap.loc.ax */
/* compiled from: DynamicExceptionHandler */
public class C0254ax implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private static C0254ax f335a;

    /* renamed from: b */
    private Thread.UncaughtExceptionHandler f336b = Thread.getDefaultUncaughtExceptionHandler();

    /* renamed from: c */
    private Context f337c;

    /* renamed from: d */
    private C0360q f338d;

    private C0254ax(Context context, C0360q qVar) {
        this.f337c = context.getApplicationContext();
        this.f338d = qVar;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /* renamed from: a */
    static synchronized C0254ax m583a(Context context, C0360q qVar) {
        C0254ax axVar;
        synchronized (C0254ax.class) {
            if (f335a == null) {
                f335a = new C0254ax(context, qVar);
            }
            axVar = f335a;
        }
        return axVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3704a(Throwable th) {
        String a = C0363r.m1349a(th);
        try {
            if (TextUtils.isEmpty(a)) {
                return;
            }
            if ((a.contains("amapdynamic") || a.contains("admic")) && a.contains("com.amap.api")) {
                C0228ac acVar = new C0228ac(this.f337c, C0255ay.m585c());
                if (a.contains("loc")) {
                    C0249av.m562a(acVar, this.f337c, "loc");
                }
                if (a.contains("navi")) {
                    C0249av.m562a(acVar, this.f337c, "navi");
                }
                if (a.contains("sea")) {
                    C0249av.m562a(acVar, this.f337c, "sea");
                }
                if (a.contains("2dmap")) {
                    C0249av.m562a(acVar, this.f337c, "2dmap");
                }
                if (a.contains("3dmap")) {
                    C0249av.m562a(acVar, this.f337c, "3dmap");
                }
            } else if (a.contains("com.autonavi.aps.amapapi.offline")) {
                C0249av.m562a(new C0228ac(this.f337c, C0255ay.m585c()), this.f337c, "OfflineLocation");
            } else if (a.contains("com.data.carrier_v4")) {
                C0249av.m562a(new C0228ac(this.f337c, C0255ay.m585c()), this.f337c, "Collection");
            }
        } catch (Throwable th2) {
            C0365t.m1372a(th2, "DynamicExceptionHandler", "uncaughtException");
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        mo3704a(th);
        if (this.f336b != null) {
            this.f336b.uncaughtException(thread, th);
        }
    }
}
