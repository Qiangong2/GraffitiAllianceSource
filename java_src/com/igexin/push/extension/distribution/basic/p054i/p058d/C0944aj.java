package com.igexin.push.extension.distribution.basic.p054i.p058d;

import com.igexin.push.extension.distribution.basic.p054i.p056b.C0813i;

/* renamed from: com.igexin.push.extension.distribution.basic.i.d.aj */
class C0944aj extends AbstractC0942ah {
    public C0944aj(AbstractC0955g gVar) {
        this.f2486a = gVar;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p058d.AbstractC0955g
    /* renamed from: a */
    public boolean mo5558a(C0813i iVar, C0813i iVar2) {
        C0813i l;
        return (iVar == iVar2 || (l = iVar2.mo5350w()) == null || !this.f2486a.mo5558a(iVar, l)) ? false : true;
    }

    public String toString() {
        return String.format(":ImmediateParent%s", this.f2486a);
    }
}
