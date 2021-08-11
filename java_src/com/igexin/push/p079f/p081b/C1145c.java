package com.igexin.push.p079f.p081b;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0617f;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.C0620i;
import com.igexin.push.core.p027a.C0535e;
import java.util.concurrent.TimeUnit;

/* renamed from: com.igexin.push.f.b.c */
public class C1145c extends AbstractC1150h {

    /* renamed from: a */
    private static C1145c f3007a;

    public C1145c() {
        super(C0620i.m2432a().mo4640b());
        this.f1126o = true;
    }

    /* renamed from: g */
    public static C1145c m4710g() {
        if (f3007a == null) {
            f3007a = new C1145c();
        }
        return f3007a;
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.push.p079f.p081b.AbstractC1150h
    /* renamed from: a */
    public void mo4304a() {
        C0535e.m2034a().mo4358A();
        C0618g.f1580E = System.currentTimeMillis();
        if (C0618g.f1641l) {
            ActivityC0460a.m1698b("heartbeatReq");
            C0617f.m2395a().mo4630i().mo4405g();
            return;
        }
        ActivityC0460a.m1698b("HeartBeatTimerTask doTaskMethod isOnline = false, refresh wait time !!!!!!");
        mo5899h();
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public final int mo4136b() {
        return -2147483642;
    }

    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: c */
    public void mo4199c() {
        super.mo4199c();
        if (!this.f1123k) {
            mo5899h();
        }
    }

    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: d */
    public void mo4126d() {
    }

    /* renamed from: h */
    public void mo5899h() {
        mo4193a(C0620i.m2432a().mo4640b(), TimeUnit.MILLISECONDS);
    }

    /* renamed from: i */
    public void mo5900i() {
    }
}
