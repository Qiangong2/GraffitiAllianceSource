package com.igexin.push.extension.distribution.basic.p054i.p058d;

import com.igexin.push.extension.distribution.basic.p054i.p056b.C0813i;

/* renamed from: com.igexin.push.extension.distribution.basic.i.d.t */
public final class C0968t extends AbstractC0955g {

    /* renamed from: a */
    private String f2500a;

    public C0968t(String str) {
        this.f2500a = str.toLowerCase();
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p058d.AbstractC0955g
    /* renamed from: a */
    public boolean mo5558a(C0813i iVar, C0813i iVar2) {
        return iVar2.mo5344q().toLowerCase().contains(this.f2500a);
    }

    public String toString() {
        return String.format(":contains(%s", this.f2500a);
    }
}
