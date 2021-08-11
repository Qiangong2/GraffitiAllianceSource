package com.igexin.push.extension.distribution.basic.p054i.p058d;

import com.igexin.push.extension.distribution.basic.p054i.p056b.C0813i;

/* renamed from: com.igexin.push.extension.distribution.basic.i.d.am */
class C0947am extends AbstractC0942ah {
    public C0947am(AbstractC0955g gVar) {
        this.f2486a = gVar;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p058d.AbstractC0955g
    /* renamed from: a */
    public boolean mo5558a(C0813i iVar, C0813i iVar2) {
        if (iVar == iVar2) {
            return false;
        }
        for (C0813i l = iVar2.mo5350w(); l != iVar; l = l.mo5350w()) {
            if (this.f2486a.mo5558a(iVar, l)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return String.format(":parent%s", this.f2486a);
    }
}
