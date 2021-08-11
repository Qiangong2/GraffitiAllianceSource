package com.igexin.push.p023a.p024a;

import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.p079f.p081b.AbstractC1146d;
import com.umeng.analytics.C1370a;

/* renamed from: com.igexin.push.a.a.b */
public class C0478b implements AbstractC1146d {

    /* renamed from: a */
    public static final String f1175a = C0478b.class.getName();

    /* renamed from: b */
    private long f1176b = 0;

    @Override // com.igexin.push.p079f.p081b.AbstractC1146d
    /* renamed from: a */
    public void mo4247a() {
        C0535e.m2034a().mo4423y();
        C0535e.m2034a().mo4415q();
        C0535e.m2034a().mo4416r();
        C0535e.m2034a().mo4424z();
    }

    @Override // com.igexin.push.p079f.p081b.AbstractC1146d
    /* renamed from: a */
    public void mo4248a(long j) {
        this.f1176b = j;
    }

    @Override // com.igexin.push.p079f.p081b.AbstractC1146d
    /* renamed from: b */
    public boolean mo4249b() {
        return System.currentTimeMillis() - this.f1176b > C1370a.f3218j;
    }
}
