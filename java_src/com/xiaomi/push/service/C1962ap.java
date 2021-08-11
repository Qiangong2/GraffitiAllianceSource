package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.packet.C2030f;

/* renamed from: com.xiaomi.push.service.ap */
class C1962ap extends XMPushService.AbstractC1937e {

    /* renamed from: a */
    final /* synthetic */ XMPushService f5061a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1962ap(XMPushService xMPushService, int i) {
        super(i);
        this.f5061a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: a */
    public void mo10376a() {
        if (this.f5061a.f4997f != null) {
            this.f5061a.f4997f.mo10500a(new C2030f(C2030f.EnumC2032b.unavailable), 15, (Exception) null);
            this.f5061a.f4997f = null;
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: b */
    public String mo10377b() {
        return "disconnect for service destroy.";
    }
}
