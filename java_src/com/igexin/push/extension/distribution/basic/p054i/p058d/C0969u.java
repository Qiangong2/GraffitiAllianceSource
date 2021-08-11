package com.igexin.push.extension.distribution.basic.p054i.p058d;

import com.igexin.push.extension.distribution.basic.p054i.p056b.C0813i;

/* renamed from: com.igexin.push.extension.distribution.basic.i.d.u */
public final class C0969u extends AbstractC0955g {

    /* renamed from: a */
    private String f2501a;

    public C0969u(String str) {
        this.f2501a = str;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p058d.AbstractC0955g
    /* renamed from: a */
    public boolean mo5558a(C0813i iVar, C0813i iVar2) {
        return this.f2501a.equals(iVar2.mo5338k());
    }

    public String toString() {
        return String.format("#%s", this.f2501a);
    }
}
