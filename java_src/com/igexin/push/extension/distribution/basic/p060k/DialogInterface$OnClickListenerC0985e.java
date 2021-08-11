package com.igexin.push.extension.distribution.basic.p060k;

import android.content.DialogInterface;
import com.igexin.push.core.p027a.C0535e;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.k.e */
public class DialogInterface$OnClickListenerC0985e implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0982b f2523a;

    DialogInterface$OnClickListenerC0985e(C0982b bVar) {
        this.f2523a = bVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        C0535e.m2034a().mo4379a(this.f2523a.f2516g, this.f2523a.f2517h, this.f2523a.f2514e.mo4958c().get(2).mo4833b());
        this.f2523a.f2518i = false;
        this.f2523a.f1556b.finish();
    }
}
