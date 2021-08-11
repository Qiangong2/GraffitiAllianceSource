package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.C2023p;
import com.xiaomi.xmpush.thrift.C2077h;

/* access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.p */
public final class C1978p extends XMPushService.AbstractC1937e {

    /* renamed from: a */
    final /* synthetic */ XMPushService f5096a;

    /* renamed from: b */
    final /* synthetic */ C2077h f5097b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1978p(int i, XMPushService xMPushService, C2077h hVar) {
        super(i);
        this.f5096a = xMPushService;
        this.f5097b = hVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: a */
    public void mo10376a() {
        try {
            C2077h hVar = C1974l.m7359e(this.f5096a, this.f5097b);
            hVar.mo10850m().mo10698a("miui_message_unrecognized", "1");
            this.f5096a.mo10362b(hVar);
        } catch (C2023p e) {
            AbstractC1855b.m6720a(e);
            this.f5096a.mo10349a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: b */
    public String mo10377b() {
        return "send ack message for unrecognized new miui message.";
    }
}
