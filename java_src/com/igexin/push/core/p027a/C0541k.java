package com.igexin.push.core.p027a;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p013a.p020d.AbstractC0470d;
import com.igexin.push.config.C0513j;
import com.igexin.push.core.C0620i;
import com.igexin.push.core.EnumC0622k;
import com.igexin.push.p032d.C0632b;
import com.igexin.push.p032d.p035c.C0645h;

/* renamed from: com.igexin.push.core.a.k */
public class C0541k extends AbstractC0520a {

    /* renamed from: a */
    private static final String f1377a = C0513j.f1294a;

    @Override // com.igexin.push.core.p027a.AbstractC0520a
    /* renamed from: a */
    public boolean mo4350a(AbstractC0470d dVar) {
        return false;
    }

    @Override // com.igexin.push.core.p027a.AbstractC0520a
    /* renamed from: a */
    public boolean mo4351a(Object obj) {
        if (!(obj instanceof C0645h)) {
            return true;
        }
        C0632b.m2464a().mo4675e();
        ActivityC0460a.m1698b("heartbeatRsp");
        C0620i.m2432a().mo4638a(EnumC0622k.HEARTBEAT_OK);
        return true;
    }
}
