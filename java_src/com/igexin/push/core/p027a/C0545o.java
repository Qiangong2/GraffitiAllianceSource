package com.igexin.push.core.p027a;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p022b.C0476a;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.p029b.C0568g;
import com.igexin.push.p079f.AbstractC1137a;

/* renamed from: com.igexin.push.core.a.o */
class C0545o extends AbstractC1137a {

    /* renamed from: a */
    final /* synthetic */ C0543m f1380a;

    C0545o(C0543m mVar) {
        this.f1380a = mVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.push.p079f.AbstractC1137a
    /* renamed from: a */
    public void mo4251a() {
        try {
            String m = C0535e.m2034a().mo4411m();
            if (C0618g.f1582G == 0 || !C0476a.m1773a(C0535e.m2034a().mo4413o()).equals(m)) {
                ActivityC0460a.m1698b("LoginResultAction|upload app list");
                C0568g.m2192a().mo4440a(System.currentTimeMillis());
                C0535e.m2034a().mo4412n();
            }
        } catch (Throwable th) {
        }
    }
}
