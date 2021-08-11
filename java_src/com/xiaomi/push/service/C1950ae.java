package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.C2023p;
import com.xiaomi.smack.packet.AbstractC2028d;

/* renamed from: com.xiaomi.push.service.ae */
public class C1950ae extends XMPushService.AbstractC1937e {

    /* renamed from: a */
    private XMPushService f5040a = null;

    /* renamed from: b */
    private AbstractC2028d f5041b;

    public C1950ae(XMPushService xMPushService, AbstractC2028d dVar) {
        super(4);
        this.f5040a = xMPushService;
        this.f5041b = dVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: a */
    public void mo10376a() {
        try {
            this.f5040a.mo10353a(this.f5041b);
        } catch (C2023p e) {
            AbstractC1855b.m6720a(e);
            this.f5040a.mo10349a(10, e);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: b */
    public String mo10377b() {
        return "send a message.";
    }
}
