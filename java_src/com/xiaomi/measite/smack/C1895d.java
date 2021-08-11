package com.xiaomi.measite.smack;

import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.smack.AbstractC2009f;
import com.xiaomi.smack.packet.AbstractC2028d;
import java.util.Date;

/* renamed from: com.xiaomi.measite.smack.d */
class C1895d implements AbstractC2009f {

    /* renamed from: a */
    final /* synthetic */ C1892a f4845a;

    C1895d(C1892a aVar) {
        this.f4845a = aVar;
    }

    @Override // com.xiaomi.smack.AbstractC2009f
    /* renamed from: a */
    public void mo10105a(AbstractC2028d dVar) {
        if (C1892a.f4834a) {
            AbstractC1855b.m6722c("SMACK " + this.f4845a.f4835b.format(new Date()) + " RCV PKT (" + this.f4845a.f4836c.hashCode() + "): " + dVar.mo10546a());
        }
    }
}
