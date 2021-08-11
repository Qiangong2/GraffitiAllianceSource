package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.push.protobuf.C1930b;
import com.xiaomi.smack.AbstractC2008e;
import com.xiaomi.smack.C2004b;
import java.util.Map;

/* renamed from: com.xiaomi.push.service.aj */
class C1956aj extends C2004b {

    /* renamed from: a */
    final /* synthetic */ XMPushService f5050a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1956aj(XMPushService xMPushService, Map map, int i, String str, AbstractC2008e eVar) {
        super(map, i, str, eVar);
        this.f5050a = xMPushService;
    }

    @Override // com.xiaomi.smack.C2004b
    /* renamed from: a */
    public byte[] mo10394a() {
        try {
            C1930b.C1931a aVar = new C1930b.C1931a();
            aVar.mo10327a(C1951af.m7272a().mo10390c());
            return aVar.mo4061b();
        } catch (Exception e) {
            AbstractC1855b.m6718a("getOBBString err: " + e.toString());
            return null;
        }
    }
}
