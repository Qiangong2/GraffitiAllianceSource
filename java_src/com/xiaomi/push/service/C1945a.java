package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.C2023p;
import com.xiaomi.smack.packet.C2027c;

/* renamed from: com.xiaomi.push.service.a */
public class C1945a extends XMPushService.AbstractC1937e {

    /* renamed from: a */
    private XMPushService f5024a = null;

    /* renamed from: b */
    private C2027c[] f5025b;

    public C1945a(XMPushService xMPushService, C2027c[] cVarArr) {
        super(4);
        this.f5024a = xMPushService;
        this.f5025b = cVarArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: a */
    public void mo10376a() {
        try {
            this.f5024a.mo10358a(this.f5025b);
        } catch (C2023p e) {
            AbstractC1855b.m6720a(e);
            this.f5024a.mo10349a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: b */
    public String mo10377b() {
        return "batch send message.";
    }
}
