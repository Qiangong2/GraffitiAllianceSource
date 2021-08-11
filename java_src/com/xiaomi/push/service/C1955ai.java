package com.xiaomi.push.service;

import com.xiaomi.push.service.XMPushService;

/* access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.ai */
public class C1955ai extends XMPushService.AbstractC1937e {

    /* renamed from: a */
    final /* synthetic */ XMPushService f5049a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1955ai(XMPushService xMPushService, int i) {
        super(i);
        this.f5049a = xMPushService;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: a */
    public void mo10376a() {
        this.f5049a.mo10349a(18, (Exception) null);
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: b */
    public String mo10377b() {
        return "disconnect because of connecting timeout";
    }
}
