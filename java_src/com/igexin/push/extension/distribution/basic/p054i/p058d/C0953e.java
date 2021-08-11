package com.igexin.push.extension.distribution.basic.p054i.p058d;

import com.igexin.push.extension.distribution.basic.p054i.p056b.C0813i;

/* renamed from: com.igexin.push.extension.distribution.basic.i.d.e */
final class C0953e extends AbstractC0951c {
    C0953e() {
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p058d.AbstractC0955g
    /* renamed from: a */
    public boolean mo5558a(C0813i iVar, C0813i iVar2) {
        for (AbstractC0955g gVar : this.f2490a) {
            if (gVar.mo5558a(iVar, iVar2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public void mo5572b(AbstractC0955g gVar) {
        this.f2490a.add(gVar);
    }

    public String toString() {
        return String.format(":or%s", this.f2490a);
    }
}
