package com.igexin.push.core.p030c;

import com.igexin.push.core.p027a.C0535e;
import java.util.TimerTask;

/* renamed from: com.igexin.push.core.c.d */
class C0606d extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ C0605c f1538a;

    C0606d(C0605c cVar) {
        this.f1538a = cVar;
    }

    public void run() {
        C0535e.m2034a().mo4371a(this.f1538a.f1535g, this.f1538a.f1536h, this.f1538a.f1537i);
        this.f1538a.f1536h.mo4681a(this.f1538a.f1536h.mo4680a() + 1);
    }
}
