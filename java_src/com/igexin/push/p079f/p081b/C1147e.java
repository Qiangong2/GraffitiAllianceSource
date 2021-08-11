package com.igexin.push.p079f.p081b;

import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.config.C0514k;
import com.igexin.push.core.C0618g;
import com.igexin.push.p032d.C0632b;
import com.igexin.push.util.C1151a;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.igexin.push.f.b.e */
public class C1147e extends AbstractC1150h {

    /* renamed from: a */
    private long f3008a = C0514k.f1301G;

    /* renamed from: b */
    private AtomicBoolean f3009b = new AtomicBoolean(false);

    public C1147e() {
        super(604800000);
        this.f1126o = true;
    }

    /* renamed from: a */
    private void m4720a(long j) {
        mo4193a(j, TimeUnit.MILLISECONDS);
    }

    /* renamed from: g */
    public static C1147e m4721g() {
        return C1148f.m4726a();
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.push.p079f.p081b.AbstractC1150h
    /* renamed from: a */
    public void mo4304a() {
        mo4193a(this.f3008a, TimeUnit.MILLISECONDS);
        boolean a = C1151a.m4739a(System.currentTimeMillis());
        if (!C0618g.f1641l && C0618g.f1637h && C0618g.f1638i && C0618g.f1639j && !C0618g.f1641l && !a && C1151a.m4747b()) {
            ActivityC0460a.m1698b("PollingTimerTask|run = true");
            C0632b.m2464a().mo4677g();
            C0618g.f1579D = 100;
            C1149g.m4727g().mo5903h();
        }
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public int mo4136b() {
        return 20160629;
    }

    /* renamed from: h */
    public void mo5901h() {
        if (!this.f3009b.get()) {
            C0456c.m1661b().mo4216a(this, false, true);
            this.f3009b.set(true);
        }
        m4720a(this.f3008a);
    }

    /* renamed from: i */
    public void mo5902i() {
        mo4193a(604800000, TimeUnit.MILLISECONDS);
    }
}
