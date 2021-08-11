package com.igexin.p012b.p013a.p015b.p016a.p017a;

import com.igexin.p012b.p013a.p015b.AbstractC0458e;
import com.igexin.p012b.p013a.p015b.p016a.p017a.p018a.AbstractC0439b;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.p032d.C0632b;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.b.a.b.a.a.f */
public class C0446f implements AbstractC0439b {

    /* renamed from: a */
    final /* synthetic */ C0444d f1057a;

    C0446f(C0444d dVar) {
        this.f1057a = dVar;
    }

    @Override // com.igexin.p012b.p013a.p015b.p016a.p017a.p018a.AbstractC0438a
    /* renamed from: a */
    public void mo4129a(AbstractC0458e eVar) {
        this.f1057a.f1053o.sendEmptyMessage(3);
    }

    @Override // com.igexin.p012b.p013a.p015b.p016a.p017a.p018a.AbstractC0439b
    /* renamed from: a */
    public void mo4130a(Exception exc) {
        ActivityC0460a.m1698b(C0444d.f1039e + "|r ex = " + exc.toString());
        if (exc.getMessage() != null && exc.getMessage().equals("end of stream")) {
            C0632b.m2464a().mo4674d();
        }
        this.f1057a.mo4144b();
    }
}
