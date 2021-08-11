package com.igexin.push.extension.distribution.basic.p060k;

import android.view.KeyEvent;
import android.view.View;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.k.k */
public class View$OnKeyListenerC0991k implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ C0989i f2531a;

    View$OnKeyListenerC0991k(C0989i iVar) {
        this.f2531a = iVar;
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i != 4 || !this.f2531a.f2527d.canGoBack()) {
            return false;
        }
        this.f2531a.f2527d.goBack();
        return true;
    }
}
