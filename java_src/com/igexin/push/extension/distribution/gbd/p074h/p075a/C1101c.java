package com.igexin.push.extension.distribution.gbd.p074h.p075a;

import android.os.Message;
import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1083e;
import com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;

/* renamed from: com.igexin.push.extension.distribution.gbd.h.a.c */
public class C1101c extends AbstractC1111b {

    /* renamed from: c */
    private static C1101c f2962c;

    private C1101c() {
        this.f2973b = C1067a.f2814y * 1000;
        this.f2972a = C1069c.f2838o;
    }

    /* renamed from: d */
    public static C1101c m4508d() {
        if (f2962c == null) {
            f2962c = new C1101c();
        }
        return f2962c;
    }

    @Override // com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b
    /* renamed from: a */
    public void mo5870a() {
        C1115d.m4559b("GBD_DGLT", "do Task");
        try {
            if (C1069c.f2826c != null) {
                Message obtain = Message.obtain();
                obtain.what = 6;
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
        C1083e.m4408a().mo5836j(j);
    }

    @Override // com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b
    /* renamed from: c */
    public boolean mo5872c() {
        return true;
    }

    /* renamed from: e */
    public void mo5873e() {
        this.f2973b = C1067a.f2814y * 1000;
    }
}
