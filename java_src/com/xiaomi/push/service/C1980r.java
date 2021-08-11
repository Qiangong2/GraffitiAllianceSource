package com.xiaomi.push.service;

import com.umeng.analytics.p091b.C1447g;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.C2023p;
import com.xiaomi.xmpush.thrift.C2077h;

/* access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.r */
public final class C1980r extends XMPushService.AbstractC1937e {

    /* renamed from: a */
    final /* synthetic */ XMPushService f5101a;

    /* renamed from: b */
    final /* synthetic */ C2077h f5102b;

    /* renamed from: c */
    final /* synthetic */ String f5103c;

    /* renamed from: d */
    final /* synthetic */ String f5104d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1980r(int i, XMPushService xMPushService, C2077h hVar, String str, String str2) {
        super(i);
        this.f5101a = xMPushService;
        this.f5102b = hVar;
        this.f5103c = str;
        this.f5104d = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: a */
    public void mo10376a() {
        try {
            C2077h hVar = C1974l.m7359e(this.f5101a, this.f5102b);
            hVar.f5741h.mo10698a(C1447g.f3469aF, this.f5103c);
            hVar.f5741h.mo10698a("reason", this.f5104d);
            this.f5101a.mo10362b(hVar);
        } catch (C2023p e) {
            AbstractC1855b.m6720a(e);
            this.f5101a.mo10349a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: b */
    public String mo10377b() {
        return "send wrong message ack for message.";
    }
}
