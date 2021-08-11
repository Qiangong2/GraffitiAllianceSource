package com.igexin.push.extension.distribution.gbd.p074h.p075a;

import android.os.Message;
import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;

/* renamed from: com.igexin.push.extension.distribution.gbd.h.a.f */
public class C1104f extends AbstractC1111b {

    /* renamed from: c */
    private static C1104f f2965c;

    private C1104f() {
        this.f2973b = C1067a.f2813x * 1000;
        this.f2972a = System.currentTimeMillis();
    }

    /* renamed from: d */
    public static C1104f m4520d() {
        if (f2965c == null) {
            f2965c = new C1104f();
        }
        return f2965c;
    }

    @Override // com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b
    /* renamed from: a */
    public void mo5870a() {
        try {
            C1115d.m4559b("GBD_RNALT", "dotask ...");
            if (C1069c.f2826c != null) {
                Message obtain = Message.obtain();
                obtain.what = 4;
                obtain.arg1 = 41;
                C1069c.f2826c.sendMessage(obtain);
            }
        } catch (Exception e) {
            C1115d.m4558a(e);
        }
    }

    @Override // com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b
    /* renamed from: c */
    public boolean mo5872c() {
        return C1067a.f2755F;
    }
}
