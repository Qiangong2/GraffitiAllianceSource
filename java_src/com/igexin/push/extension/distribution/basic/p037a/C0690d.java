package com.igexin.push.extension.distribution.basic.p037a;

import com.igexin.push.core.C0618g;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.extension.distribution.basic.p041b.C0714b;
import com.igexin.push.extension.distribution.basic.p053h.AbstractC0774g;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.a.d */
public class C0690d implements AbstractC0774g {

    /* renamed from: a */
    final /* synthetic */ BaseAction f1854a;

    /* renamed from: b */
    final /* synthetic */ String f1855b;

    /* renamed from: c */
    final /* synthetic */ String f1856c;

    /* renamed from: d */
    final /* synthetic */ String f1857d;

    /* renamed from: e */
    final /* synthetic */ int f1858e;

    /* renamed from: f */
    final /* synthetic */ C0687c f1859f;

    C0690d(C0687c cVar, BaseAction baseAction, String str, String str2, String str3, int i) {
        this.f1859f = cVar;
        this.f1854a = baseAction;
        this.f1855b = str;
        this.f1856c = str2;
        this.f1857d = str3;
        this.f1858e = i;
    }

    @Override // com.igexin.push.extension.distribution.basic.p053h.AbstractC0774g
    /* renamed from: a */
    public void mo4769a(BaseAction baseAction) {
        if (C0618g.m2422a(this.f1856c, true) == 0) {
            C0535e.m2034a().mo4379a(this.f1856c, this.f1857d, "1");
        }
    }

    @Override // com.igexin.push.extension.distribution.basic.p053h.AbstractC0774g
    /* renamed from: a */
    public void mo4770a(Exception exc) {
        if (((C0714b) this.f1854a).mo4813l() < 3) {
            this.f1859f.mo4768a(this.f1855b, this.f1856c, this.f1857d, this.f1854a, this.f1858e);
        } else if (C0618g.m2422a(this.f1856c, true) == 0) {
            C0535e.m2034a().mo4379a(this.f1856c, this.f1857d, "1");
        }
    }
}
