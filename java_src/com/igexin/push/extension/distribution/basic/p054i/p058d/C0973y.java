package com.igexin.push.extension.distribution.basic.p054i.p058d;

import com.igexin.push.extension.distribution.basic.p054i.p056b.C0813i;

/* renamed from: com.igexin.push.extension.distribution.basic.i.d.y */
public final class C0973y extends AbstractC0971w {
    public C0973y(int i) {
        super(i);
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p058d.AbstractC0955g
    /* renamed from: a */
    public boolean mo5558a(C0813i iVar, C0813i iVar2) {
        return iVar2.mo5342o().intValue() < this.f2502a;
    }

    public String toString() {
        return String.format(":lt(%d)", Integer.valueOf(this.f2502a));
    }
}
