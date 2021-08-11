package com.xiaomi.measite.smack;

import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.smack.util.AbstractC2052m;
import java.util.Date;

/* renamed from: com.xiaomi.measite.smack.c */
class C1894c implements AbstractC2052m {

    /* renamed from: a */
    final /* synthetic */ C1892a f4844a;

    C1894c(C1892a aVar) {
        this.f4844a = aVar;
    }

    @Override // com.xiaomi.smack.util.AbstractC2052m
    /* renamed from: a */
    public void mo10104a(String str) {
        AbstractC1855b.m6722c("SMACK " + C1892a.m6919a(this.f4844a).format(new Date()) + " SENT (" + C1892a.m6920b(this.f4844a).hashCode() + "): " + str);
    }
}
