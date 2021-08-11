package com.igexin.push.extension.distribution.gbd.p074h.p075a;

import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p071f.C1085a;
import com.igexin.push.extension.distribution.gbd.p071f.p072a.C1088c;
import com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.umeng.analytics.C1370a;

/* renamed from: com.igexin.push.extension.distribution.gbd.h.a.d */
public class C1102d extends AbstractC1111b {

    /* renamed from: c */
    private static C1102d f2963c;

    private C1102d() {
        this.f2973b = C1370a.f3217i;
        this.f2972a = C1069c.f2833j;
    }

    /* renamed from: d */
    public static C1102d m4513d() {
        if (f2963c == null) {
            f2963c = new C1102d();
        }
        return f2963c;
    }

    @Override // com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b
    /* renamed from: a */
    public void mo5870a() {
        C1115d.m4559b("GBD_GCT", "doTask GBD_CONFIG");
        C0456c.m1661b().mo4216a(new C1085a(new C1088c()), false, true);
    }

    @Override // com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b
    /* renamed from: c */
    public boolean mo5872c() {
        return true;
    }
}
