package com.igexin.push.extension.distribution.basic.p060k;

import android.view.View;
import com.igexin.push.core.p027a.C0535e;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.k.g */
public class View$OnClickListenerC0987g implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0982b f2525a;

    View$OnClickListenerC0987g(C0982b bVar) {
        this.f2525a = bVar;
    }

    public void onClick(View view) {
        if (this.f2525a.f2514e.mo4958c() != null && this.f2525a.f2514e.mo4958c().size() >= 2) {
            this.f2525a.f2518i = false;
            C0535e.m2034a().mo4379a(this.f2525a.f2516g, this.f2525a.f2517h, this.f2525a.f2514e.mo4958c().get(1).mo4833b());
        }
        this.f2525a.f1556b.finish();
    }
}
