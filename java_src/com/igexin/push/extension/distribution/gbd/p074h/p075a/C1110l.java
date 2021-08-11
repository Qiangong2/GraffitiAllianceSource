package com.igexin.push.extension.distribution.gbd.p074h.p075a;

import android.os.Message;
import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1083e;
import com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;

/* renamed from: com.igexin.push.extension.distribution.gbd.h.a.l */
public class C1110l extends AbstractC1111b {

    /* renamed from: c */
    private static C1110l f2971c;

    private C1110l() {
        this.f2973b = C1067a.f2796g * 1000;
        this.f2972a = C1069c.f2847x;
    }

    /* renamed from: d */
    public static C1110l m4543d() {
        if (f2971c == null) {
            f2971c = new C1110l();
        }
        return f2971c;
    }

    @Override // com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b
    /* renamed from: a */
    public void mo5870a() {
        C1115d.m4559b("GBD_WST", "doTask");
        if (C1069c.f2826c != null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.arg1 = 11;
            C1069c.f2826c.sendMessage(obtain);
        }
    }

    @Override // com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b
    /* renamed from: a */
    public void mo5871a(long j) {
        this.f2972a = j;
        C1083e.m4408a().mo5830e(j);
    }

    @Override // com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b
    /* renamed from: c */
    public boolean mo5872c() {
        return true;
    }

    /* renamed from: e */
    public void mo5875e() {
        this.f2973b = C1067a.f2796g * 1000;
    }
}
