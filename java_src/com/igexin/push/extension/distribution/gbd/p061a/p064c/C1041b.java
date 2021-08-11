package com.igexin.push.extension.distribution.gbd.p061a.p064c;

import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.p079f.p081b.AbstractC1150h;

/* renamed from: com.igexin.push.extension.distribution.gbd.a.c.b */
class C1041b extends AbstractC1150h {

    /* renamed from: a */
    final /* synthetic */ C1040a f2657a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1041b(C1040a aVar, long j) {
        super(j);
        this.f2657a = aVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.push.p079f.p081b.AbstractC1150h
    /* renamed from: a */
    public void mo4304a() {
        try {
            C1115d.m4557a(C1040a.m4207d(), "stop scan ibeacon");
            if (C1040a.m4202a(this.f2657a)) {
                C1040a.m4205c(this.f2657a).stopLeScan(C1040a.m4204b(this.f2657a));
                C1040a.m4203a(this.f2657a, false);
            }
            if (C1040a.m4206d(this.f2657a) != null) {
                this.f2657a.f2648a = EnumC1047h.SCAN_END;
                C1040a.m4206d(this.f2657a).mo5705a(C1040a.m4208e(this.f2657a));
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
