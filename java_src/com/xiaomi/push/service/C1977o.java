package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.C2023p;
import com.xiaomi.xmpush.thrift.C2077h;

/* access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.o */
public final class C1977o extends XMPushService.AbstractC1937e {

    /* renamed from: a */
    final /* synthetic */ XMPushService f5094a;

    /* renamed from: b */
    final /* synthetic */ C2077h f5095b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1977o(int i, XMPushService xMPushService, C2077h hVar) {
        super(i);
        this.f5094a = xMPushService;
        this.f5095b = hVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: a */
    public void mo10376a() {
        try {
            C2077h hVar = C1974l.m7359e(this.f5094a, this.f5095b);
            hVar.mo10850m().mo10698a("message_obsleted", "1");
            this.f5094a.mo10362b(hVar);
        } catch (C2023p e) {
            AbstractC1855b.m6720a(e);
            this.f5094a.mo10349a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: b */
    public String mo10377b() {
        return "send ack message for obsleted message.";
    }
}
