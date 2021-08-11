package com.igexin.push.extension.distribution.gbd.p074h.p075a;

import android.os.Message;
import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1083e;
import com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;

/* renamed from: com.igexin.push.extension.distribution.gbd.h.a.i */
public class C1107i extends AbstractC1111b {

    /* renamed from: c */
    private static C1107i f2968c;

    private C1107i() {
        this.f2973b = C1067a.f2766Q * 1000;
        this.f2972a = C1069c.f2843t;
    }

    /* renamed from: d */
    public static C1107i m4531d() {
        if (f2968c == null) {
            f2968c = new C1107i();
        }
        return f2968c;
    }

    @Override // com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b
    /* renamed from: a */
    public void mo5870a() {
        C1115d.m4559b("GBD_SLMT", "do Task");
        try {
            if (C1069c.f2826c != null) {
                Message obtain = Message.obtain();
                obtain.what = 7;
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
        C1083e.m4408a().mo5825c(j);
    }

    @Override // com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b
    /* renamed from: c */
    public boolean mo5872c() {
        return C1067a.f2765P;
    }
}
