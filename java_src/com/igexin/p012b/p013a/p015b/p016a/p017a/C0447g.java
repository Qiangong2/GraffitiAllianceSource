package com.igexin.p012b.p013a.p015b.p016a.p017a;

import com.igexin.p012b.p013a.p015b.AbstractC0458e;
import com.igexin.p012b.p013a.p015b.p016a.p017a.p018a.AbstractC0440c;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.b.a.b.a.a.g */
public class C0447g implements AbstractC0440c {

    /* renamed from: a */
    final /* synthetic */ C0444d f1058a;

    C0447g(C0444d dVar) {
        this.f1058a = dVar;
    }

    @Override // com.igexin.p012b.p013a.p015b.p016a.p017a.p018a.AbstractC0440c
    /* renamed from: a */
    public void mo4131a(C0451k kVar) {
        this.f1058a.m1601b((C0444d) kVar);
    }

    @Override // com.igexin.p012b.p013a.p015b.p016a.p017a.p018a.AbstractC0438a
    /* renamed from: a */
    public void mo4129a(AbstractC0458e eVar) {
        this.f1058a.f1053o.sendEmptyMessage(3);
    }

    @Override // com.igexin.p012b.p013a.p015b.p016a.p017a.p018a.AbstractC0440c
    /* renamed from: a */
    public void mo4132a(Exception exc) {
        ActivityC0460a.m1698b(C0444d.f1039e + "|w ex = " + exc.toString());
        this.f1058a.mo4144b();
    }
}
