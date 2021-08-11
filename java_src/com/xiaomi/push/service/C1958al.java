package com.xiaomi.push.service;

import com.xiaomi.push.service.C1987w;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.service.al */
class C1958al implements C1987w.AbstractC1988a {

    /* renamed from: a */
    final /* synthetic */ XMPushService f5052a;

    C1958al(XMPushService xMPushService) {
        this.f5052a = xMPushService;
    }

    @Override // com.xiaomi.push.service.C1987w.AbstractC1988a
    /* renamed from: a */
    public void mo10395a() {
        this.f5052a.m7191j();
        if (C1987w.m7406a().mo10438c() <= 0) {
            this.f5052a.mo10350a(new XMPushService.C1936d(12, null));
        }
    }
}
