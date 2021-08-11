package com.xiaomi.stats;

import com.xiaomi.channel.commonutils.network.C1865d;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.thrift.EnumC1997a;
import com.xiaomi.smack.AbstractC2002a;
import com.xiaomi.smack.AbstractC2006d;

/* renamed from: com.xiaomi.stats.d */
public class C2058d implements AbstractC2006d {

    /* renamed from: a */
    XMPushService f5492a;

    /* renamed from: b */
    AbstractC2002a f5493b;

    /* renamed from: c */
    private int f5494c;

    /* renamed from: d */
    private Exception f5495d;

    C2058d(XMPushService xMPushService) {
        this.f5492a = xMPushService;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Exception mo10663a() {
        return this.f5495d;
    }

    @Override // com.xiaomi.smack.AbstractC2006d
    /* renamed from: a */
    public void mo10106a(AbstractC2002a aVar) {
        C2062g.m7763a(0, EnumC1997a.CONN_SUCCESS.mo10447a(), aVar.mo10509c(), aVar.mo10515i());
    }

    @Override // com.xiaomi.smack.AbstractC2006d
    /* renamed from: a */
    public void mo10107a(AbstractC2002a aVar, int i, Exception exc) {
        if (this.f5494c == 0 && this.f5495d == null) {
            this.f5494c = i;
            this.f5495d = exc;
            C2062g.m7768b(aVar.mo10509c(), exc);
        }
    }

    @Override // com.xiaomi.smack.AbstractC2006d
    /* renamed from: a */
    public void mo10108a(AbstractC2002a aVar, Exception exc) {
        C2062g.m7762a(0, EnumC1997a.CHANNEL_CON_FAIL.mo10447a(), 1, aVar.mo10509c(), C1865d.m6762d(this.f5492a) ? 1 : 0);
    }

    @Override // com.xiaomi.smack.AbstractC2006d
    /* renamed from: b */
    public void mo10109b(AbstractC2002a aVar) {
        this.f5494c = 0;
        this.f5495d = null;
        this.f5493b = aVar;
        C2062g.m7761a(0, EnumC1997a.CONN_SUCCESS.mo10447a());
    }
}
