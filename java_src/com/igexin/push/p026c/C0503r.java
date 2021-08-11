package com.igexin.push.p026c;

import android.text.TextUtils;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0618g;

/* renamed from: com.igexin.push.c.r */
public class C0503r extends AbstractC0498m implements AbstractC0500o {

    /* renamed from: e */
    private static final String f1275e = C0503r.class.getName();

    /* renamed from: f */
    private static C0503r f1276f;

    private C0503r() {
        super(C0618g.f1626av, C0618g.f1628ax);
    }

    /* renamed from: a */
    public static synchronized C0503r m1935a() {
        C0503r rVar;
        synchronized (C0503r.class) {
            if (f1276f == null) {
                f1276f = new C0503r();
            }
            rVar = f1276f;
        }
        return rVar;
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
                ActivityC0460a.m1698b(f1275e + "|detect" + mo4313c(jVar) + "failed --------------");
                if (mo4327q()) {
                    a.mo4334g();
                } else {
                    a.mo4332a(false);
                }
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
        return EnumC0493h.WIFI;
    }

    @Override // com.igexin.push.p026c.AbstractC0498m
    /* renamed from: c */
    public AbstractC0500o mo4310c() {
        return this;
    }
}
