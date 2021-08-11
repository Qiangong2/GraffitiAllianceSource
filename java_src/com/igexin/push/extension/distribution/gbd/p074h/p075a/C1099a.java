package com.igexin.push.extension.distribution.gbd.p074h.p075a;

import android.os.Message;
import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1083e;
import com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;

/* renamed from: com.igexin.push.extension.distribution.gbd.h.a.a */
public class C1099a extends AbstractC1111b {

    /* renamed from: c */
    private static C1099a f2960c;

    private C1099a() {
        this.f2973b = C1067a.f2773X * 1000;
        this.f2972a = C1069c.f2844u;
    }

    /* renamed from: d */
    public static C1099a m4497d() {
        if (f2960c == null) {
            f2960c = new C1099a();
        }
        return f2960c;
    }

    @Override // com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b
    /* renamed from: a */
    public void mo5870a() {
        try {
            C1115d.m4559b("GBD_ALT", "dotask ...");
            if (C1069c.f2826c != null) {
                Message message = new Message();
                message.what = 10;
                C1069c.f2826c.sendMessage(message);
            }
        } catch (Exception e) {
            C1115d.m4558a(e);
        }
    }

    @Override // com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b
    /* renamed from: a */
    public void mo5871a(long j) {
        this.f2972a = j;
        C1083e.m4408a().mo5822b(j);
    }

    @Override // com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b
    /* renamed from: c */
    public boolean mo5872c() {
        return C1067a.f2775Z;
    }
}
