package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.misc.C1856a;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.C2004b;

/* renamed from: com.xiaomi.push.service.am */
class C1959am extends XMPushService.AbstractC1937e {

    /* renamed from: a */
    final /* synthetic */ int f5053a;

    /* renamed from: b */
    final /* synthetic */ byte[] f5054b;

    /* renamed from: c */
    final /* synthetic */ String f5055c;

    /* renamed from: d */
    final /* synthetic */ XMPushService f5056d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1959am(XMPushService xMPushService, int i, int i2, byte[] bArr, String str) {
        super(i);
        this.f5056d = xMPushService;
        this.f5053a = i2;
        this.f5054b = bArr;
        this.f5055c = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: a */
    public void mo10376a() {
        C1970h.m7332b(this.f5056d);
        C1987w.m7406a().mo10433a("5");
        C1856a.m6725a(this.f5053a);
        this.f5056d.f4993b.mo10529c(C2004b.m7515b());
        this.f5056d.mo10357a(this.f5054b, this.f5055c);
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: b */
    public String mo10377b() {
        return "clear account cache.";
    }
}
