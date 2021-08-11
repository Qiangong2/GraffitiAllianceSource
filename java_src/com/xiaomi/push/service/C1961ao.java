package com.xiaomi.push.service;

import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.service.C1987w;

/* renamed from: com.xiaomi.push.service.ao */
class C1961ao implements C1987w.C1989b.AbstractC1990a {

    /* renamed from: a */
    final /* synthetic */ XMPushService f5060a;

    C1961ao(XMPushService xMPushService) {
        this.f5060a = xMPushService;
    }

    @Override // com.xiaomi.push.service.C1987w.C1989b.AbstractC1990a
    /* renamed from: a */
    public void mo10396a(C1987w.EnumC1991c cVar, C1987w.EnumC1991c cVar2, int i) {
        if (cVar2 == C1987w.EnumC1991c.binded) {
            C1973k.m7342a(this.f5060a);
            C1973k.m7344b(this.f5060a);
        } else if (cVar2 == C1987w.EnumC1991c.unbind) {
            C1973k.m7340a(this.f5060a, ErrorCode.ERROR_SERVICE_UNAVAILABLE, " the push is not connected.");
        }
    }
}
