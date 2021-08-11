package com.igexin.push.extension.distribution.basic.p037a;

import com.igexin.push.core.C0618g;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.extension.distribution.basic.p041b.C0725m;
import com.igexin.push.extension.distribution.basic.p053h.AbstractC0774g;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.a.p */
public class C0702p implements AbstractC0774g {

    /* renamed from: a */
    final /* synthetic */ BaseAction f1869a;

    /* renamed from: b */
    final /* synthetic */ String f1870b;

    /* renamed from: c */
    final /* synthetic */ String f1871c;

    /* renamed from: d */
    final /* synthetic */ String f1872d;

    /* renamed from: e */
    final /* synthetic */ int f1873e;

    /* renamed from: f */
    final /* synthetic */ C0701o f1874f;

    C0702p(C0701o oVar, BaseAction baseAction, String str, String str2, String str3, int i) {
        this.f1874f = oVar;
        this.f1869a = baseAction;
        this.f1870b = str;
        this.f1871c = str2;
        this.f1872d = str3;
        this.f1873e = i;
    }

    @Override // com.igexin.push.extension.distribution.basic.p053h.AbstractC0774g
    /* renamed from: a */
    public void mo4769a(BaseAction baseAction) {
        if (this.f1873e == 2) {
            ((C0725m) this.f1869a).mo4920g(true);
        } else if (this.f1873e == 3) {
            ((C0725m) this.f1869a).mo4922h(true);
        } else if (this.f1873e == 6) {
            ((C0725m) this.f1869a).mo4926i(true);
        } else if (this.f1873e == 8) {
            ((C0725m) this.f1869a).mo4904c(true);
        }
        if (((C0725m) baseAction).mo4943u() && ((C0725m) baseAction).mo4944v() && ((C0725m) baseAction).mo4887A() && ((C0725m) baseAction).mo4923h() && C0618g.m2422a(this.f1870b, true) == 0) {
            C0535e.m2034a().mo4379a(this.f1870b, this.f1871c, "1");
        }
    }

    @Override // com.igexin.push.extension.distribution.basic.p053h.AbstractC0774g
    /* renamed from: a */
    public void mo4770a(Exception exc) {
        if (((C0725m) this.f1869a).mo4945w() >= 3) {
            ((C0725m) this.f1869a).mo4920g(true);
        }
        if (((C0725m) this.f1869a).mo4946x() >= 3) {
            ((C0725m) this.f1869a).mo4922h(true);
        }
        if (((C0725m) this.f1869a).mo4888B() >= 3) {
            ((C0725m) this.f1869a).mo4926i(true);
        }
        if (((C0725m) this.f1869a).mo4924i() >= 3) {
            ((C0725m) this.f1869a).mo4904c(true);
        }
        if (!((C0725m) this.f1869a).mo4943u() || !((C0725m) this.f1869a).mo4944v() || !((C0725m) this.f1869a).mo4887A() || !((C0725m) this.f1869a).mo4923h()) {
            this.f1874f.mo4777a(this.f1872d, this.f1870b, this.f1871c, this.f1869a, this.f1873e);
        } else if (C0618g.m2422a(this.f1870b, true) == 0) {
            C0535e.m2034a().mo4379a(this.f1870b, this.f1871c, "1");
        }
    }
}
