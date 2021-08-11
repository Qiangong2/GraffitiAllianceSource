package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.C2023p;
import com.xiaomi.xmpush.thrift.C2077h;

/* access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.q */
public final class C1979q extends XMPushService.AbstractC1937e {

    /* renamed from: a */
    final /* synthetic */ XMPushService f5098a;

    /* renamed from: b */
    final /* synthetic */ C2077h f5099b;

    /* renamed from: c */
    final /* synthetic */ String f5100c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1979q(int i, XMPushService xMPushService, C2077h hVar, String str) {
        super(i);
        this.f5098a = xMPushService;
        this.f5099b = hVar;
        this.f5100c = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: a */
    public void mo10376a() {
        try {
            C2077h hVar = C1974l.m7359e(this.f5098a, this.f5099b);
            hVar.mo10850m().mo10698a("absent_target_package", this.f5100c);
            this.f5098a.mo10362b(hVar);
        } catch (C2023p e) {
            AbstractC1855b.m6720a(e);
            this.f5098a.mo10349a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: b */
    public String mo10377b() {
        return "send app absent ack message for message.";
    }
}
