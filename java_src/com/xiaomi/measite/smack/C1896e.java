package com.xiaomi.measite.smack;

import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.smack.AbstractC2002a;
import com.xiaomi.smack.AbstractC2006d;
import java.util.Date;

/* access modifiers changed from: package-private */
/* renamed from: com.xiaomi.measite.smack.e */
public class C1896e implements AbstractC2006d {

    /* renamed from: a */
    final /* synthetic */ C1892a f4846a;

    C1896e(C1892a aVar) {
        this.f4846a = aVar;
    }

    @Override // com.xiaomi.smack.AbstractC2006d
    /* renamed from: a */
    public void mo10106a(AbstractC2002a aVar) {
        AbstractC1855b.m6722c("SMACK " + this.f4846a.f4835b.format(new Date()) + " Connection reconnected (" + this.f4846a.f4836c.hashCode() + ")");
    }

    @Override // com.xiaomi.smack.AbstractC2006d
    /* renamed from: a */
    public void mo10107a(AbstractC2002a aVar, int i, Exception exc) {
        AbstractC1855b.m6722c("SMACK " + this.f4846a.f4835b.format(new Date()) + " Connection closed (" + this.f4846a.f4836c.hashCode() + ")");
    }

    @Override // com.xiaomi.smack.AbstractC2006d
    /* renamed from: a */
    public void mo10108a(AbstractC2002a aVar, Exception exc) {
        AbstractC1855b.m6722c("SMACK " + this.f4846a.f4835b.format(new Date()) + " Reconnection failed due to an exception (" + this.f4846a.f4836c.hashCode() + ")");
        exc.printStackTrace();
    }

    @Override // com.xiaomi.smack.AbstractC2006d
    /* renamed from: b */
    public void mo10109b(AbstractC2002a aVar) {
        AbstractC1855b.m6722c("SMACK " + this.f4846a.f4835b.format(new Date()) + " Connection started (" + this.f4846a.f4836c.hashCode() + ")");
    }
}
