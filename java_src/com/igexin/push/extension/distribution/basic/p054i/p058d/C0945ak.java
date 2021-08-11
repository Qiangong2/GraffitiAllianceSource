package com.igexin.push.extension.distribution.basic.p054i.p058d;

import com.igexin.push.extension.distribution.basic.p054i.p056b.C0813i;

/* renamed from: com.igexin.push.extension.distribution.basic.i.d.ak */
class C0945ak extends AbstractC0942ah {
    public C0945ak(AbstractC0955g gVar) {
        this.f2486a = gVar;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p058d.AbstractC0955g
    /* renamed from: a */
    public boolean mo5558a(C0813i iVar, C0813i iVar2) {
        C0813i n;
        return (iVar == iVar2 || (n = iVar2.mo5341n()) == null || !this.f2486a.mo5558a(iVar, n)) ? false : true;
    }

    public String toString() {
        return String.format(":prev%s", this.f2486a);
    }
}
