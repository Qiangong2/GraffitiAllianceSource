package com.igexin.push.extension.distribution.basic.p060k;

import android.content.DialogInterface;
import com.igexin.push.core.p027a.C0535e;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.k.c */
public class DialogInterface$OnClickListenerC0983c implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0982b f2521a;

    DialogInterface$OnClickListenerC0983c(C0982b bVar) {
        this.f2521a = bVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        C0535e.m2034a().mo4379a(this.f2521a.f2516g, this.f2521a.f2517h, this.f2521a.f2514e.mo4958c().get(0).mo4833b());
        this.f2521a.f2518i = false;
        this.f2521a.f1556b.finish();
    }
}
