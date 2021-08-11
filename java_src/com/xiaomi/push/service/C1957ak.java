package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.stats.C2059e;

/* renamed from: com.xiaomi.push.service.ak */
class C1957ak extends XMPushService.AbstractC1937e {

    /* renamed from: a */
    final /* synthetic */ XMPushService f5051a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1957ak(XMPushService xMPushService, int i) {
        super(i);
        this.f5051a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: a */
    public void mo10376a() {
        C2059e.m7746a().mo10665a(this.f5051a, this.f5051a.f4996e);
        this.f5051a.m7190i();
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: b */
    public String mo10377b() {
        return "prepare the mi push account.";
    }
}
