package com.igexin.push.extension.distribution.gbd.p074h.p075a;

import android.os.Message;
import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;

/* renamed from: com.igexin.push.extension.distribution.gbd.h.a.h */
public class C1106h extends AbstractC1111b {

    /* renamed from: c */
    private static C1106h f2967c;

    private C1106h() {
        this.f2973b = C1067a.f2795f * 1000;
    }

    /* renamed from: d */
    public static C1106h m4527d() {
        if (f2967c == null) {
            f2967c = new C1106h();
        }
        return f2967c;
    }

    @Override // com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b
    /* renamed from: a */
    public void mo5870a() {
        C1115d.m4559b("GBD_RT", "doTask");
        if (C1069c.f2826c != null) {
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.arg1 = 21;
            C1069c.f2826c.sendMessage(obtain);
        }
    }

    @Override // com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b
    /* renamed from: c */
    public boolean mo5872c() {
        return true;
    }

    /* renamed from: e */
    public void mo5874e() {
        this.f2973b = C1067a.f2795f * 1000;
    }
}
