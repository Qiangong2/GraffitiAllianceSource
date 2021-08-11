package com.igexin.push.p079f.p081b;

import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0617f;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.p026c.C0494i;
import com.igexin.push.p032d.p034b.C0633a;
import com.igexin.push.util.C1151a;
import com.umeng.analytics.C1370a;
import java.util.concurrent.TimeUnit;

/* renamed from: com.igexin.push.f.b.g */
public class C1149g extends AbstractC1150h {

    /* renamed from: a */
    private static C1149g f3011a;

    private C1149g() {
        super(C1370a.f3218j);
        this.f1126o = true;
    }

    /* renamed from: g */
    public static synchronized C1149g m4727g() {
        C1149g gVar;
        synchronized (C1149g.class) {
            if (f3011a == null) {
                f3011a = new C1149g();
            }
            gVar = f3011a;
        }
        return gVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.push.p079f.p081b.AbstractC1150h
    /* renamed from: a */
    public void mo4304a() {
        C0535e.m2034a().mo4358A();
        boolean a = C1151a.m4739a(System.currentTimeMillis());
        boolean b = C1151a.m4747b();
        ActivityC0460a.m1698b("ReconnectTimerTask|networkAvailable = " + C0618g.f1637h + "|,sdkOnline = " + C0618g.f1641l + ", " + "sdkOn= " + C0618g.f1638i + ", pushOn =" + C0618g.f1639j + ", isSilentTime= " + a + ", blockEndTime= " + b);
        if (!C0618g.f1637h || !C0618g.f1638i || !C0618g.f1639j || C0618g.f1641l || a || !b) {
            ActivityC0460a.m1698b("ReconnectTimerTask reconnect timer task stop, connect interval= 1h #######");
            mo4193a(C1370a.f3218j, TimeUnit.MILLISECONDS);
            return;
        }
        ActivityC0460a.m1698b("ReconnectTimerTask reconnect timer task isOnline = false, try login...");
        int d = C0617f.m2395a().mo4630i().mo4397d();
        if (d != 1 && d == 0) {
            C0456c.m1661b().mo4218a(new C0633a());
            C0456c.m1661b().mo4171c();
        }
        mo4193a(1800000, TimeUnit.MILLISECONDS);
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public final int mo4136b() {
        return -2147483641;
    }

    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: c */
    public void mo4199c() {
        super.mo4199c();
    }

    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: d */
    public void mo4126d() {
    }

    /* renamed from: h */
    public void mo5903h() {
        long j = C0618g.f1579D;
        ActivityC0460a.m1698b("ReconnectTimerTask|refreshDelayTime, delay = " + j);
        if (!C0494i.m1834a().mo4281e().mo4273j()) {
            ActivityC0460a.m1698b("ReconnectTimerTask|refreshDelayTime, already enter backup or trynormal #####");
            mo4193a(j, TimeUnit.MILLISECONDS);
        } else if (C0494i.m1834a().mo4283g() != null) {
            mo4193a(j, TimeUnit.MILLISECONDS);
        } else {
            ActivityC0460a.m1698b("ReconnectTimerTask|detect ip = null and not enter backup,  wait for detect, delay = 3600000");
            mo4193a(C1370a.f3218j, TimeUnit.MILLISECONDS);
        }
    }
}
