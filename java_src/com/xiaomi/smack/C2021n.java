package com.xiaomi.smack;

import com.xiaomi.push.service.XMPushService;

/* access modifiers changed from: package-private */
/* renamed from: com.xiaomi.smack.n */
public class C2021n extends XMPushService.AbstractC1937e {

    /* renamed from: a */
    final /* synthetic */ int f5350a;

    /* renamed from: b */
    final /* synthetic */ Exception f5351b;

    /* renamed from: c */
    final /* synthetic */ C2019l f5352c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2021n(C2019l lVar, int i, int i2, Exception exc) {
        super(i);
        this.f5352c = lVar;
        this.f5350a = i2;
        this.f5351b = exc;
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: a */
    public void mo10376a() {
        this.f5352c.f5343v.mo10349a(this.f5350a, this.f5351b);
    }

    @Override // com.xiaomi.push.service.XMPushService.AbstractC1937e
    /* renamed from: b */
    public String mo10377b() {
        return "shutdown the connection. " + this.f5350a + ", " + this.f5351b;
    }
}
