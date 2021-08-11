package com.igexin.push.p023a.p024a;

import com.igexin.push.config.C0514k;
import com.igexin.push.core.C0617f;
import com.igexin.push.core.EnumC0602c;
import com.igexin.push.p036e.C0661a;
import com.igexin.push.p079f.p081b.AbstractC1146d;
import com.igexin.push.util.C1151a;
import com.umeng.analytics.C1370a;
import java.util.Calendar;

/* renamed from: com.igexin.push.a.a.c */
public class C0479c implements AbstractC1146d {

    /* renamed from: c */
    private static C0479c f1177c;

    /* renamed from: a */
    private long f1178a = 0;

    /* renamed from: b */
    private long f1179b = 0;

    /* renamed from: d */
    private boolean f1180d = false;

    private C0479c() {
    }

    /* renamed from: c */
    public static C0479c m1784c() {
        if (f1177c == null) {
            f1177c = new C0479c();
        }
        return f1177c;
    }

    @Override // com.igexin.push.p079f.p081b.AbstractC1146d
    /* renamed from: a */
    public void mo4247a() {
        mo4250d();
    }

    @Override // com.igexin.push.p079f.p081b.AbstractC1146d
    /* renamed from: a */
    public void mo4248a(long j) {
        this.f1178a = j;
    }

    @Override // com.igexin.push.p079f.p081b.AbstractC1146d
    /* renamed from: b */
    public boolean mo4249b() {
        return System.currentTimeMillis() - this.f1178a > this.f1179b;
    }

    /* renamed from: d */
    public void mo4250d() {
        this.f1179b = C1370a.f3218j;
        long currentTimeMillis = System.currentTimeMillis();
        if (C0514k.f1310b != 0) {
            Calendar instance = Calendar.getInstance();
            if (C1151a.m4739a(currentTimeMillis)) {
                if (!this.f1180d) {
                    this.f1180d = true;
                    C0661a aVar = new C0661a();
                    aVar.mo4702a(EnumC0602c.stop);
                    C0617f.m2395a().mo4629h().mo4719a(aVar);
                }
                if (C0514k.f1309a + C0514k.f1310b > 24) {
                    instance.set(11, (C0514k.f1309a + C0514k.f1310b) - 24);
                } else {
                    instance.set(11, C0514k.f1309a + C0514k.f1310b);
                }
                instance.set(12, 0);
                instance.set(13, 0);
                if (instance.getTimeInMillis() < currentTimeMillis) {
                    instance.add(5, 1);
                }
            } else {
                if (this.f1180d) {
                    this.f1180d = false;
                    C0661a aVar2 = new C0661a();
                    aVar2.mo4702a(EnumC0602c.start);
                    C0617f.m2395a().mo4629h().mo4719a(aVar2);
                }
                instance.set(11, C0514k.f1309a);
                instance.set(12, 0);
                instance.set(13, 0);
                if (instance.getTimeInMillis() < currentTimeMillis) {
                    instance.add(5, 1);
                }
            }
            this.f1179b = instance.getTimeInMillis() - currentTimeMillis;
        } else if (this.f1180d) {
            this.f1180d = false;
            C0661a aVar3 = new C0661a();
            aVar3.mo4702a(EnumC0602c.start);
            C0617f.m2395a().mo4629h().mo4719a(aVar3);
        }
        if (C0514k.f1311c > this.f1179b + currentTimeMillis) {
            this.f1179b = C0514k.f1311c - currentTimeMillis;
            if (!this.f1180d) {
                this.f1180d = true;
                C0661a aVar4 = new C0661a();
                aVar4.mo4702a(EnumC0602c.stop);
                C0617f.m2395a().mo4629h().mo4719a(aVar4);
            }
        }
    }
}
