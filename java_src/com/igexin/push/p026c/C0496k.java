package com.igexin.push.p026c;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0618g;
import com.igexin.push.p079f.p081b.AbstractC1150h;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.igexin.push.c.k */
public class C0496k extends AbstractC1150h {

    /* renamed from: a */
    public static final AtomicBoolean f1245a = new AtomicBoolean(false);

    /* renamed from: b */
    private static final String f1246b = C0496k.class.getName();

    /* renamed from: c */
    private static C0496k f1247c;

    /* renamed from: e */
    private boolean f1248e;

    private C0496k() {
        super(150);
        this.f1126o = true;
    }

    /* renamed from: c_ */
    public static synchronized C0496k m1863c_() {
        C0496k kVar;
        synchronized (C0496k.class) {
            if (f1247c == null) {
                f1247c = new C0496k();
            }
            kVar = f1247c;
        }
        return kVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.push.p079f.p081b.AbstractC1150h
    /* renamed from: a */
    public void mo4304a() {
        mo4193a(C0491f.f1222a, TimeUnit.MILLISECONDS);
        if (this.f1248e) {
            ActivityC0460a.m1698b(f1246b + "|detect task already stop");
            return;
        }
        ActivityC0460a.m1698b(f1246b + "|" + (C0491f.f1222a / 1000) + "s passed, do task method, start redect ~~~~");
        if (C0618g.f1637h) {
            C0494i.m1834a().mo4280d();
        } else {
            ActivityC0460a.m1698b(f1246b + "|" + (C0491f.f1222a / 1000) + "s passed, network is unavailable, stop ###");
        }
    }

    /* renamed from: a */
    public void mo4305a(long j) {
        mo4193a(j, TimeUnit.MILLISECONDS);
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public int mo4136b() {
        return 20150607;
    }

    /* renamed from: g */
    public void mo4306g() {
        this.f1126o = false;
        this.f1248e = true;
        mo4202p();
    }
}
