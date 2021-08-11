package com.umeng.analytics.p094e;

import android.content.Context;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.p092c.C1451c;
import com.umeng.analytics.p092c.C1457h;
import com.umeng.analytics.p093d.AbstractC1487l;
import com.umeng.analytics.p093d.C1494q;
import com.umeng.p085a.C1341c;
import com.umeng.p085a.C1360l;

/* renamed from: com.umeng.analytics.e.c */
/* compiled from: ImLatent */
public class C1498c implements AbstractC1487l {

    /* renamed from: l */
    private static C1498c f3734l = null;

    /* renamed from: a */
    private final long f3735a = 1296000000;

    /* renamed from: b */
    private final long f3736b = 129600000;

    /* renamed from: c */
    private final int f3737c = 1800000;

    /* renamed from: d */
    private final int f3738d = 10000;

    /* renamed from: e */
    private C1360l f3739e;

    /* renamed from: f */
    private C1494q f3740f;

    /* renamed from: g */
    private long f3741g = 1296000000;

    /* renamed from: h */
    private int f3742h = 10000;

    /* renamed from: i */
    private long f3743i = 0;

    /* renamed from: j */
    private long f3744j = 0;

    /* renamed from: k */
    private Context f3745k;

    /* renamed from: a */
    public static synchronized C1498c m5589a(Context context, C1494q qVar) {
        C1498c cVar;
        synchronized (C1498c.class) {
            if (f3734l == null) {
                f3734l = new C1498c(context, qVar);
                f3734l.mo8620a(C1457h.m5380a(context).mo8580b());
            }
            cVar = f3734l;
        }
        return cVar;
    }

    private C1498c(Context context, C1494q qVar) {
        this.f3745k = context;
        this.f3739e = C1360l.m5038a(context);
        this.f3740f = qVar;
    }

    /* renamed from: a */
    public boolean mo8684a() {
        if (this.f3739e.mo8389h() || this.f3740f.mo8659f()) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f3740f.mo8666m();
        if (currentTimeMillis > this.f3741g) {
            this.f3743i = (long) C1341c.m4911a(this.f3742h, C1451c.m5348a(this.f3745k));
            this.f3744j = currentTimeMillis;
            return true;
        } else if (currentTimeMillis <= 129600000) {
            return false;
        } else {
            this.f3743i = 0;
            this.f3744j = currentTimeMillis;
            return true;
        }
    }

    /* renamed from: b */
    public long mo8685b() {
        return this.f3743i;
    }

    /* renamed from: c */
    public long mo8686c() {
        return this.f3744j;
    }

    @Override // com.umeng.analytics.p093d.AbstractC1487l
    /* renamed from: a */
    public void mo8620a(C1457h.C1458a aVar) {
        this.f3741g = aVar.mo8586a(1296000000L);
        int b = aVar.mo8591b(0);
        if (b != 0) {
            this.f3742h = b;
        } else if (AnalyticsConfig.sLatentWindow <= 0 || AnalyticsConfig.sLatentWindow > 1800000) {
            this.f3742h = 10000;
        } else {
            this.f3742h = AnalyticsConfig.sLatentWindow;
        }
    }
}
