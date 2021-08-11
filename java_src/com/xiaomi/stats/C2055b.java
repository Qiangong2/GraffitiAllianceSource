package com.xiaomi.stats;

import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.stats.b */
class C2055b extends XMPushService.AbstractC1937e {

    /* renamed from: a */
    final /* synthetic */ C2053a f5489a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2055b(C2053a aVar, int i) {
        super(i);
        this.f5489a = aVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: a */
    public void mo10376a() {
        this.f5489a.m7730c();
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: b */
    public String mo10377b() {
        return "Handling bind stats";
    }
}
