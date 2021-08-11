package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.AbstractC2009f;
import com.xiaomi.smack.packet.AbstractC2028d;

/* renamed from: com.xiaomi.push.service.ah */
class C1954ah implements AbstractC2009f {

    /* renamed from: a */
    final /* synthetic */ XMPushService f5048a;

    C1954ah(XMPushService xMPushService) {
        this.f5048a = xMPushService;
    }

    @Override // com.xiaomi.smack.AbstractC2009f
    /* renamed from: a */
    public void mo10105a(AbstractC2028d dVar) {
        this.f5048a.mo10350a(new XMPushService.C1940h(dVar));
    }
}
