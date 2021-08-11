package com.igexin.push.core.p027a;

import android.text.TextUtils;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p013a.p020d.AbstractC0470d;
import com.igexin.push.config.C0513j;
import com.igexin.push.core.C0617f;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.p029b.C0568g;
import com.igexin.push.p032d.p035c.AbstractC0642e;
import com.igexin.push.p032d.p035c.C0648k;
import com.igexin.push.p032d.p035c.C0654q;

/* renamed from: com.igexin.push.core.a.t */
public class C0550t extends AbstractC0520a {

    /* renamed from: a */
    private static final String f1383a = (C0513j.f1294a + "_RegisterResultAction");

    @Override // com.igexin.push.core.p027a.AbstractC0520a
    /* renamed from: a */
    public boolean mo4350a(AbstractC0470d dVar) {
        return false;
    }

    @Override // com.igexin.push.core.p027a.AbstractC0520a
    /* renamed from: a */
    public boolean mo4351a(Object obj) {
        boolean z = false;
        if (obj instanceof C0654q) {
            C0654q qVar = (C0654q) obj;
            C0618g.f1579D = 0;
            ActivityC0460a.m1698b("register resp |" + qVar.f1780a + "|" + C0618g.f1646q);
            ActivityC0460a.m1698b("register resp cid = " + qVar.f1782c + " device id = " + qVar.f1783d);
            if (qVar.f1780a != C0618g.f1646q) {
                C0618g.f1642m = false;
                ActivityC0460a.m1698b(f1383a + " change session : from [" + C0618g.f1646q + "] to [" + qVar.f1780a + "]");
                ActivityC0460a.m1698b(f1383a + " change cid : from [" + C0618g.f1647r + "] to [" + qVar.f1782c + "]");
                if (TextUtils.isEmpty(qVar.f1782c) || TextUtils.isEmpty(qVar.f1783d)) {
                    C0568g.m2192a().mo4447b(qVar.f1780a);
                } else {
                    C0568g.m2192a().mo4442a(qVar.f1782c, qVar.f1783d, qVar.f1780a);
                }
                C0618g.f1581F = 0;
                z = true;
            }
            ActivityC0460a.m1698b("loginReqAfterRegister|new session:" + C0618g.f1646q + ", cid :" + C0618g.f1647r + ", devId :" + C0618g.f1653x);
            C0648k c = C0535e.m2034a().mo4392c();
            C0617f.m2395a().mo4628g().mo4737a("S-" + c.f1753a, (AbstractC0642e) c, true);
            if (z) {
            }
        }
        return true;
    }
}
