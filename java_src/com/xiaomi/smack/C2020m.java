package com.xiaomi.smack;

import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.smack.m */
class C2020m extends XMPushService.AbstractC1937e {

    /* renamed from: a */
    final /* synthetic */ long f5348a;

    /* renamed from: b */
    final /* synthetic */ C2019l f5349b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2020m(C2019l lVar, int i, long j) {
        super(i);
        this.f5349b = lVar;
        this.f5348a = j;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: a */
    public void mo10376a() {
        if (this.f5349b.mo10514h() && !this.f5349b.mo10504a(this.f5348a)) {
            this.f5349b.f5343v.mo10349a(22, (Exception) null);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: b */
    public String mo10377b() {
        return "check the ping-pong.";
    }
}
