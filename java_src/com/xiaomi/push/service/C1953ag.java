package com.xiaomi.push.service;

import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.channel.commonutils.misc.C1857b;
import com.xiaomi.channel.commonutils.network.AbstractC1864c;
import com.xiaomi.network.HttpUtils;
import com.xiaomi.push.protobuf.C1928a;
import com.xiaomi.push.service.C1951af;
import com.xiaomi.smack.util.C2046h;
import java.util.List;

/* access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.ag */
public class C1953ag extends C1857b.AbstractC1859b {

    /* renamed from: a */
    boolean f5046a = false;

    /* renamed from: b */
    final /* synthetic */ C1951af f5047b;

    C1953ag(C1951af afVar) {
        this.f5047b = afVar;
    }

    @Override // com.xiaomi.channel.commonutils.misc.C1857b.AbstractC1859b
    /* renamed from: b */
    public void mo9932b() {
        try {
            C1928a.C1929a b = C1928a.C1929a.m7133b(Base64.decode(HttpUtils.m7071a(C2046h.m7706a(), "http://resolver.msg.xiaomi.net/psc/?t=a", (List<AbstractC1864c>) null), 10));
            if (b != null) {
                this.f5047b.f5044b = b;
                this.f5046a = true;
                this.f5047b.m7278g();
            }
        } catch (Exception e) {
            AbstractC1855b.m6718a("fetch config failure: " + e.getMessage());
        }
    }

    @Override // com.xiaomi.channel.commonutils.misc.C1857b.AbstractC1859b
    /* renamed from: c */
    public void mo9933c() {
        C1951af.AbstractC1952a[] aVarArr;
        this.f5047b.f5045c = null;
        if (this.f5046a) {
            synchronized (this.f5047b) {
                aVarArr = (C1951af.AbstractC1952a[]) this.f5047b.f5043a.toArray(new C1951af.AbstractC1952a[this.f5047b.f5043a.size()]);
            }
            for (C1951af.AbstractC1952a aVar : aVarArr) {
                aVar.mo10392a(this.f5047b.f5044b);
            }
        }
    }
}
