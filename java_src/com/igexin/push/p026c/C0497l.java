package com.igexin.push.p026c;

import android.text.TextUtils;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0618g;

/* renamed from: com.igexin.push.c.l */
public class C0497l extends AbstractC0498m implements AbstractC0500o {

    /* renamed from: e */
    private static final String f1249e = C0497l.class.getName();

    /* renamed from: f */
    private static C0497l f1250f;

    private C0497l() {
        super(C0618g.f1625au, C0618g.f1627aw);
    }

    /* renamed from: a */
    public static synchronized C0497l m1868a() {
        C0497l lVar;
        synchronized (C0497l.class) {
            if (f1250f == null) {
                f1250f = new C0497l();
            }
            lVar = f1250f;
        }
        return lVar;
    }

    @Override // com.igexin.push.p026c.AbstractC0500o
    /* renamed from: a */
    public void mo4307a(EnumC0492g gVar, C0495j jVar) {
        C0501p a;
        if (jVar != null && !TextUtils.isEmpty(jVar.mo4286a()) && (a = mo4311a(jVar.mo4286a())) != null) {
            mo4312b(jVar);
            if (gVar == EnumC0492g.SUCCESS) {
                a.mo4334g();
                a.mo4337j();
                mo4321k();
                mo4324n();
            } else if (gVar == EnumC0492g.EXCEPTION || gVar == EnumC0492g.FAILED) {
                mo4325o();
                ActivityC0460a.m1698b(f1249e + "|detect" + mo4313c(jVar) + "failed --------");
                if (mo4327q()) {
                    ActivityC0460a.m1698b(f1249e + "|pool is not empty, detect task " + mo4313c(jVar) + "stop");
                    a.mo4334g();
                    return;
                }
                a.mo4332a(false);
            }
        }
    }

    @Override // com.igexin.push.p026c.AbstractC0500o
    /* renamed from: a */
    public void mo4308a(C0495j jVar) {
    }

    @Override // com.igexin.push.p026c.AbstractC0498m
    /* renamed from: b */
    public EnumC0493h mo4309b() {
        return EnumC0493h.MOBILE;
    }

    @Override // com.igexin.push.p026c.AbstractC0498m
    /* renamed from: c */
    public AbstractC0500o mo4310c() {
        return this;
    }
}
