package com.xiaomi.smack.util;

import com.xiaomi.channel.commonutils.misc.C1857b;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
/* renamed from: com.xiaomi.smack.util.l */
public final class C2051l extends C1857b.AbstractC1859b {

    /* renamed from: a */
    final /* synthetic */ XMPushService f5481a;

    C2051l(XMPushService xMPushService) {
        this.f5481a = xMPushService;
    }

    @Override // com.xiaomi.channel.commonutils.misc.C1857b.AbstractC1859b
    /* renamed from: b */
    public void mo9932b() {
        ArrayList arrayList;
        synchronized (C2049k.f5471c) {
            arrayList = new ArrayList(C2049k.f5472d);
            C2049k.f5472d.clear();
        }
        C2049k.m7722b(this.f5481a, arrayList);
    }
}
