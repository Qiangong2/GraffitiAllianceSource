package com.igexin.push.extension.distribution.basic.p054i.p058d;

import com.igexin.push.extension.distribution.basic.p054i.p056b.C0813i;

/* renamed from: com.igexin.push.extension.distribution.basic.i.d.s */
public final class C0967s extends AbstractC0955g {

    /* renamed from: a */
    private String f2499a;

    public C0967s(String str) {
        this.f2499a = str.toLowerCase();
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p058d.AbstractC0955g
    /* renamed from: a */
    public boolean mo5558a(C0813i iVar, C0813i iVar2) {
        return iVar2.mo5345r().toLowerCase().contains(this.f2499a);
    }

    public String toString() {
        return String.format(":containsOwn(%s", this.f2499a);
    }
}
