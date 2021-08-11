package com.igexin.push.extension.distribution.basic.util.webview;

import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.extension.distribution.basic.p041b.C0714b;
import com.igexin.push.extension.distribution.basic.p053h.AbstractC0774g;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.util.webview.d */
public class C1017d implements AbstractC0774g {

    /* renamed from: a */
    final /* synthetic */ BaseAction f2583a;

    /* renamed from: b */
    final /* synthetic */ String f2584b;

    /* renamed from: c */
    final /* synthetic */ String f2585c;

    /* renamed from: d */
    final /* synthetic */ String f2586d;

    /* renamed from: e */
    final /* synthetic */ int f2587e;

    /* renamed from: f */
    final /* synthetic */ PushWebExtension f2588f;

    C1017d(PushWebExtension pushWebExtension, BaseAction baseAction, String str, String str2, String str3, int i) {
        this.f2588f = pushWebExtension;
        this.f2583a = baseAction;
        this.f2584b = str;
        this.f2585c = str2;
        this.f2586d = str3;
        this.f2587e = i;
    }

    @Override // com.igexin.push.extension.distribution.basic.p053h.AbstractC0774g
    /* renamed from: a */
    public void mo4769a(BaseAction baseAction) {
        this.f2588f.m4073a((C0714b) this.f2583a);
    }

    @Override // com.igexin.push.extension.distribution.basic.p053h.AbstractC0774g
    /* renamed from: a */
    public void mo4770a(Exception exc) {
        if (((C0714b) this.f2583a).mo4813l() < 3) {
            this.f2588f.prepareExecuteAction(this.f2584b, this.f2585c, this.f2586d, this.f2583a, this.f2587e);
        } else {
            this.f2588f.m4073a((C0714b) this.f2583a);
        }
    }
}
