package com.wanmei.sdk.core.p106ui.floatview.p107a;

import com.wanmei.sdk.core.p106ui.floatview.C1827b;
import com.wanmei.sdk.core.util.C1849j;

/* renamed from: com.wanmei.sdk.core.ui.floatview.a.e */
public class C1826e extends AbstractC1825d {
    public C1826e(C1827b bVar) {
        super(bVar);
    }

    @Override // com.wanmei.sdk.core.p106ui.floatview.p107a.AbstractC1822a
    /* renamed from: a */
    public void mo9876a() {
        this.f4549a.mo9886a(C1849j.m6697a(this.f4549a.mo9893f(), "comm_floatview_logo_normal", "drawable"));
        this.f4549a.mo9888a(true);
    }

    @Override // com.wanmei.sdk.core.p106ui.floatview.p107a.AbstractC1822a
    /* renamed from: b */
    public void mo9877b() {
        if (this.f4550b) {
            this.f4549a.mo9886a(C1849j.m6697a(this.f4549a.mo9893f(), "comm_floatview_logo_normal", "drawable"));
            this.f4549a.mo9894g().obtainMessage(0).sendToTarget();
            this.f4549a.mo9895h().mo9878a(new C1826e(this.f4549a));
            return;
        }
        this.f4549a.mo9895h().mo9878a(new C1824c(this.f4549a));
    }
}
