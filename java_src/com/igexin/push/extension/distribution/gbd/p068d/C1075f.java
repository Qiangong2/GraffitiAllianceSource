package com.igexin.push.extension.distribution.gbd.p068d;

import com.igexin.push.extension.distribution.gbd.p074h.p075a.C1102d;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.p079f.p081b.AbstractC1150h;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.gbd.d.f */
public class C1075f extends AbstractC1150h {

    /* renamed from: a */
    final /* synthetic */ C1071b f2861a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1075f(C1071b bVar, long j) {
        super(j);
        this.f2861a = bVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.push.p079f.p081b.AbstractC1150h
    /* renamed from: a */
    public void mo4304a() {
        try {
            C1115d.m4559b(this.f1093l, "gbd config task init");
            C1102d d = C1102d.m4513d();
            if (d.mo5872c() && d.mo5876b()) {
                d.mo5871a(System.currentTimeMillis());
                d.mo5870a();
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public int mo4136b() {
        return 0;
    }
}
