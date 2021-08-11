package com.igexin.push.extension.distribution.basic.p054i.p058d;

import com.igexin.push.extension.distribution.basic.p054i.p056b.C0813i;

/* renamed from: com.igexin.push.extension.distribution.basic.i.d.an */
class C0948an extends AbstractC0942ah {
    public C0948an(AbstractC0955g gVar) {
        this.f2486a = gVar;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p058d.AbstractC0955g
    /* renamed from: a */
    public boolean mo5558a(C0813i iVar, C0813i iVar2) {
        if (iVar == iVar2) {
            return false;
        }
        for (C0813i n = iVar2.mo5341n(); n != null; n = n.mo5341n()) {
            if (this.f2486a.mo5558a(iVar, n)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return String.format(":prev*%s", this.f2486a);
    }
}
