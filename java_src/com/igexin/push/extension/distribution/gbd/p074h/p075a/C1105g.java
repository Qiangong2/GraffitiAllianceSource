package com.igexin.push.extension.distribution.gbd.p074h.p075a;

import android.os.Message;
import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;

/* renamed from: com.igexin.push.extension.distribution.gbd.h.a.g */
public class C1105g extends AbstractC1111b {

    /* renamed from: c */
    private static C1105g f2966c;

    private C1105g() {
        this.f2973b = C1067a.f2812w * 1000;
    }

    /* renamed from: d */
    public static C1105g m4523d() {
        if (f2966c == null) {
            f2966c = new C1105g();
        }
        return f2966c;
    }

    @Override // com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b
    /* renamed from: a */
    public void mo5870a() {
        C1115d.m4559b("GBD_RGLT", "doTask...");
        if (C1069c.f2826c != null) {
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.arg1 = 22;
            C1069c.f2826c.sendMessage(obtain);
        }
    }

    @Override // com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b
    /* renamed from: a */
    public void mo5871a(long j) {
        super.mo5871a(j);
        this.f2973b = C1067a.f2812w * 1000;
    }

    @Override // com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b
    /* renamed from: c */
    public boolean mo5872c() {
        return true;
    }
}
