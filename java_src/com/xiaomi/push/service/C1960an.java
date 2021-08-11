package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.C2023p;

/* renamed from: com.xiaomi.push.service.an */
class C1960an extends XMPushService.AbstractC1937e {

    /* renamed from: a */
    final /* synthetic */ String f5057a;

    /* renamed from: b */
    final /* synthetic */ byte[] f5058b;

    /* renamed from: c */
    final /* synthetic */ XMPushService f5059c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1960an(XMPushService xMPushService, int i, String str, byte[] bArr) {
        super(i);
        this.f5059c = xMPushService;
        this.f5057a = str;
        this.f5058b = bArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: a */
    public void mo10376a() {
        try {
            this.f5059c.mo10355a(this.f5057a, this.f5058b);
        } catch (C2023p e) {
            AbstractC1855b.m6720a(e);
            this.f5059c.mo10349a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: b */
    public String mo10377b() {
        return "send mi push message";
    }
}
