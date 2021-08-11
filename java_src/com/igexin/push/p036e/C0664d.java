package com.igexin.push.p036e;

import com.igexin.push.core.EnumC0602c;
import com.igexin.push.p079f.p081b.AbstractC1150h;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.e.d */
public class C0664d extends AbstractC1150h {

    /* renamed from: a */
    final /* synthetic */ C0663c f1803a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0664d(C0663c cVar, long j) {
        super(j);
        this.f1803a = cVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.push.p079f.p081b.AbstractC1150h
    /* renamed from: a */
    public void mo4304a() {
        C0661a aVar = new C0661a();
        aVar.mo4702a(EnumC0602c.analyze);
        this.f1803a.mo4719a(aVar);
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public int mo4136b() {
        return 32611;
    }
}
