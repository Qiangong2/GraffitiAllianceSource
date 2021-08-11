package com.igexin.push.core.p027a;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p022b.C0476a;
import com.igexin.push.core.C0617f;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.bean.C0588a;
import com.igexin.push.core.bean.C0596i;
import com.igexin.push.core.p029b.C0565d;
import com.igexin.push.core.p029b.C0568g;
import com.igexin.push.p032d.p035c.C0641d;
import com.igexin.push.p079f.AbstractC1137a;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.core.a.g */
public class C0537g extends AbstractC1137a {

    /* renamed from: a */
    final /* synthetic */ C0535e f1370a;

    C0537g(C0535e eVar) {
        this.f1370a = eVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.push.p079f.AbstractC1137a
    /* renamed from: a */
    public void mo4251a() {
        try {
            C0588a aVar = new C0588a();
            long j = aVar.f1475n;
            String a = C0588a.m2259a(aVar);
            if (a != null) {
                ActivityC0460a.m1698b("addphoneinfo");
                C0565d a2 = C0565d.m2181a();
                if (a2 != null) {
                    a2.mo4436a(new C0596i(j, a, (byte) 5, j));
                }
                C0641d dVar = new C0641d();
                dVar.mo4693a();
                dVar.f1715a = (int) j;
                dVar.f1718d = "17258000";
                dVar.f1719e = a;
                dVar.f1721g = C0618g.f1647r;
                C0617f.m2395a().mo4628g().mo4736a("C-" + C0618g.f1647r, dVar);
                if (!C0476a.m1774a(C0618g.f1655z, C0618g.f1654y)) {
                    C0568g.m2192a().mo4457d(C0618g.f1654y);
                }
            }
        } catch (Throwable th) {
        }
    }
}
