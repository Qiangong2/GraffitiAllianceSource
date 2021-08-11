package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.C2023p;
import com.xiaomi.xmpush.thrift.C2077h;

/* access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.m */
public final class C1975m extends XMPushService.AbstractC1937e {

    /* renamed from: a */
    final /* synthetic */ XMPushService f5090a;

    /* renamed from: b */
    final /* synthetic */ C2077h f5091b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1975m(int i, XMPushService xMPushService, C2077h hVar) {
        super(i);
        this.f5090a = xMPushService;
        this.f5091b = hVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: a */
    public void mo10376a() {
        try {
            this.f5090a.mo10362b(this.f5090a.mo10346a(this.f5091b.mo10847j(), this.f5091b.mo10844h()));
        } catch (C2023p e) {
            AbstractC1855b.m6720a(e);
            this.f5090a.mo10349a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: b */
    public String mo10377b() {
        return "send app absent message.";
    }
}
