package com.igexin.push.extension.distribution.basic.stub;

import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.extension.distribution.basic.p053h.C0768a;
import com.igexin.push.extension.distribution.basic.p053h.C0772e;
import com.igexin.push.p079f.p081b.AbstractC1150h;

/* renamed from: com.igexin.push.extension.distribution.basic.stub.a */
class C0993a extends AbstractC1150h {

    /* renamed from: a */
    final /* synthetic */ PushExtension f2539a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0993a(PushExtension pushExtension, long j) {
        super(j);
        this.f2539a = pushExtension;
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.push.p079f.p081b.AbstractC1150h
    /* renamed from: a */
    public void mo4304a() {
        try {
            ActivityC0460a.m1698b(this.f1093l + "|current time - lastGetSdkConfigTime > 24h, request config");
            C0456c.m1661b().mo4216a(new C0768a(new C0772e()), false, true);
        } catch (Exception e) {
        }
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public int mo4136b() {
        return 0;
    }
}
