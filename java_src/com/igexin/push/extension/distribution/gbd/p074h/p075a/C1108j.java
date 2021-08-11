package com.igexin.push.extension.distribution.gbd.p074h.p075a;

import android.os.Message;
import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1083e;
import com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;

/* renamed from: com.igexin.push.extension.distribution.gbd.h.a.j */
public class C1108j extends AbstractC1111b {

    /* renamed from: c */
    private static C1108j f2969c;

    private C1108j() {
        this.f2973b = C1067a.f2778ab * 1000;
        this.f2972a = C1069c.f2820B;
    }

    /* renamed from: d */
    public static C1108j m4535d() {
        if (f2969c == null) {
            f2969c = new C1108j();
        }
        return f2969c;
    }

    @Override // com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b
    /* renamed from: a */
    public void mo5870a() {
        try {
            C1115d.m4559b("GBD_TALT", "dotask ...");
            if (C1069c.f2826c != null) {
                Message obtain = Message.obtain();
                obtain.what = 16;
                C1069c.f2826c.sendMessage(obtain);
            }
        } catch (Exception e) {
            C1115d.m4558a(e);
        }
    }

    @Override // com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b
    /* renamed from: a */
    public void mo5871a(long j) {
        this.f2972a = j;
        C1083e.m4408a().mo5833g(j);
    }

    @Override // com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b
    /* renamed from: c */
    public boolean mo5872c() {
        return C1067a.f2779ac;
    }
}
