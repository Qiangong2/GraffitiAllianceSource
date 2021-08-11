package com.igexin.push.extension.distribution.basic.p054i.p058d;

import com.igexin.push.extension.distribution.basic.p054i.p056b.C0813i;

/* renamed from: com.igexin.push.extension.distribution.basic.i.d.al */
class C0946al extends AbstractC0942ah {
    public C0946al(AbstractC0955g gVar) {
        this.f2486a = gVar;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p058d.AbstractC0955g
    /* renamed from: a */
    public boolean mo5558a(C0813i iVar, C0813i iVar2) {
        return !this.f2486a.mo5558a(iVar, iVar2);
    }

    public String toString() {
        return String.format(":not%s", this.f2486a);
    }
}
