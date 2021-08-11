package com.igexin.push.extension.distribution.basic.p059j;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.extension.distribution.basic.p042c.C0741g;
import com.igexin.push.extension.distribution.basic.p042c.C0744j;

/* renamed from: com.igexin.push.extension.distribution.basic.j.b */
public class C0979b extends AbstractC0980c {
    public C0979b() {
        mo5627a(System.currentTimeMillis());
    }

    @Override // com.igexin.push.extension.distribution.basic.p059j.AbstractC0980c
    /* renamed from: a */
    public void mo5626a() {
        ActivityC0460a.m1698b("doTask updateDeviceId");
        C0741g.m3010a().mo5027i();
    }

    @Override // com.igexin.push.extension.distribution.basic.p059j.AbstractC0980c
    /* renamed from: a */
    public void mo5627a(long j) {
        this.f2507c = j;
        ActivityC0460a.m1698b("updateRefreshTime:" + j);
    }

    @Override // com.igexin.push.extension.distribution.basic.p059j.AbstractC0980c
    /* renamed from: b */
    public boolean mo5628b() {
        if (System.currentTimeMillis() - this.f2507c <= ((long) (C0744j.f2046e * 1000))) {
            return false;
        }
        ActivityC0460a.m1698b("start doTask");
        return true;
    }
}
