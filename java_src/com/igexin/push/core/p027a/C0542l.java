package com.igexin.push.core.p027a;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p013a.p020d.AbstractC0470d;
import com.igexin.push.core.C0617f;
import com.igexin.push.p032d.p035c.C0647j;

/* renamed from: com.igexin.push.core.a.l */
public class C0542l extends AbstractC0520a {

    /* renamed from: a */
    private static final String f1378a = C0542l.class.getName();

    @Override // com.igexin.push.core.p027a.AbstractC0520a
    /* renamed from: a */
    public boolean mo4350a(AbstractC0470d dVar) {
        return false;
    }

    @Override // com.igexin.push.core.p027a.AbstractC0520a
    /* renamed from: a */
    public boolean mo4351a(Object obj) {
        if (obj instanceof C0647j) {
            C0647j jVar = (C0647j) obj;
            boolean z = jVar.f1751a == 0;
            ActivityC0460a.m1698b(f1378a + "|KeyNego result = " + ((int) jVar.f1751a));
            if (z) {
                ActivityC0460a.m1698b(f1378a + "|KeyNego success and login");
                C0617f.m2395a().mo4630i().mo4402e();
            }
        }
        return true;
    }
}
