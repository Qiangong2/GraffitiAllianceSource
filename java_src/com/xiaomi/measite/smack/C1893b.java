package com.xiaomi.measite.smack;

import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.smack.util.AbstractC2044f;
import java.util.Date;

/* renamed from: com.xiaomi.measite.smack.b */
class C1893b implements AbstractC2044f {

    /* renamed from: a */
    final /* synthetic */ C1892a f4843a;

    C1893b(C1892a aVar) {
        this.f4843a = aVar;
    }

    @Override // com.xiaomi.smack.util.AbstractC2044f
    /* renamed from: a */
    public void mo10103a(String str) {
        AbstractC1855b.m6722c("SMACK " + C1892a.m6919a(this.f4843a).format(new Date()) + " RCV  (" + C1892a.m6920b(this.f4843a).hashCode() + "): " + str);
    }
}
