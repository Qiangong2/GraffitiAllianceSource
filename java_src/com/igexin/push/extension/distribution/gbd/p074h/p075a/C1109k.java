package com.igexin.push.extension.distribution.gbd.p074h.p075a;

import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1083e;
import com.igexin.push.extension.distribution.gbd.p071f.C1085a;
import com.igexin.push.extension.distribution.gbd.p071f.p072a.C1089d;
import com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;

/* renamed from: com.igexin.push.extension.distribution.gbd.h.a.k */
public class C1109k extends AbstractC1111b {

    /* renamed from: c */
    private static C1109k f2970c;

    private C1109k() {
        this.f2973b = C1067a.f2781ae * 1000;
        this.f2972a = C1069c.f2848y;
    }

    /* renamed from: d */
    public static C1109k m4539d() {
        if (f2970c == null) {
            f2970c = new C1109k();
        }
        return f2970c;
    }

    @Override // com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b
    /* renamed from: a */
    public void mo5870a() {
        try {
            C1115d.m4559b("GBD_UST", "dotask ...");
            C0456c.m1661b().mo4216a(new C1085a(new C1089d()), false, true);
        } catch (Exception e) {
            C1115d.m4558a(e);
        }
    }

    @Override // com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b
    /* renamed from: a */
    public void mo5871a(long j) {
        this.f2972a = j;
        C1083e.m4408a().mo5832f(j);
    }

    @Override // com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b
    /* renamed from: c */
    public boolean mo5872c() {
        return true;
    }
}
