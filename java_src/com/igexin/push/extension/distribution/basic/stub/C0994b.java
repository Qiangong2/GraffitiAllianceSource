package com.igexin.push.extension.distribution.basic.stub;

import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p013a.p020d.p021a.AbstractC0463b;
import com.igexin.push.extension.distribution.basic.p042c.C0739e;
import com.igexin.push.extension.distribution.basic.p042c.C0741g;
import com.igexin.push.extension.distribution.basic.p059j.C0978a;
import com.igexin.push.extension.distribution.basic.p059j.C0979b;
import com.igexin.push.p079f.p081b.AbstractC1150h;

/* renamed from: com.igexin.push.extension.distribution.basic.stub.b */
class C0994b extends AbstractC1150h {

    /* renamed from: a */
    final /* synthetic */ PushExtension f2540a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0994b(PushExtension pushExtension, long j) {
        super(j);
        this.f2540a = pushExtension;
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.push.p079f.p081b.AbstractC1150h
    /* renamed from: a */
    public void mo4304a() {
        try {
            ActivityC0460a.m1698b(this.f1093l + "|start extensionThread");
            C0741g.m3010a().mo5019b();
            C0739e eVar = new C0739e();
            eVar.mo5013a(new C0979b());
            eVar.mo5013a(new C0978a());
            C0456c.m1661b().mo4213a((AbstractC0463b) eVar);
        } catch (Exception e) {
        }
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public int mo4136b() {
        return 0;
    }
}
