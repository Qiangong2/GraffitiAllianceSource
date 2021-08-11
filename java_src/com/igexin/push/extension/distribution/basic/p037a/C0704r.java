package com.igexin.push.extension.distribution.basic.p037a;

import com.igexin.push.core.C0618g;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.extension.distribution.basic.p041b.C0726n;
import com.igexin.push.extension.distribution.basic.p053h.AbstractC0774g;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.a.r */
public class C0704r implements AbstractC0774g {

    /* renamed from: a */
    C0726n f1875a = ((C0726n) this.f1876b);

    /* renamed from: b */
    final /* synthetic */ BaseAction f1876b;

    /* renamed from: c */
    final /* synthetic */ String f1877c;

    /* renamed from: d */
    final /* synthetic */ String f1878d;

    /* renamed from: e */
    final /* synthetic */ String f1879e;

    /* renamed from: f */
    final /* synthetic */ int f1880f;

    /* renamed from: g */
    final /* synthetic */ C0703q f1881g;

    C0704r(C0703q qVar, BaseAction baseAction, String str, String str2, String str3, int i) {
        this.f1881g = qVar;
        this.f1876b = baseAction;
        this.f1877c = str;
        this.f1878d = str2;
        this.f1879e = str3;
        this.f1880f = i;
    }

    @Override // com.igexin.push.extension.distribution.basic.p053h.AbstractC0774g
    /* renamed from: a */
    public void mo4769a(BaseAction baseAction) {
        if (this.f1880f == 1) {
            this.f1875a.mo4953a(true);
        } else if (this.f1880f == 7) {
            this.f1875a.mo4957b(true);
        }
        if (this.f1875a.mo4969j() && this.f1875a.mo4970k() && C0618g.m2422a(this.f1877c, true) == 0) {
            C0535e.m2034a().mo4379a(this.f1877c, this.f1878d, "1");
        }
    }

    @Override // com.igexin.push.extension.distribution.basic.p053h.AbstractC0774g
    /* renamed from: a */
    public void mo4770a(Exception exc) {
        if (this.f1875a.mo4967h() >= 3) {
            this.f1875a.mo4953a(true);
        }
        if (this.f1875a.mo4968i() >= 3) {
            this.f1875a.mo4957b(true);
        }
        if (!this.f1875a.mo4969j() || !this.f1875a.mo4970k()) {
            this.f1881g.mo4778a(this.f1879e, this.f1877c, this.f1878d, this.f1876b, this.f1880f);
        } else if (C0618g.m2422a(this.f1877c, true) == 0) {
            C0535e.m2034a().mo4379a(this.f1877c, this.f1878d, "1");
        }
    }
}
