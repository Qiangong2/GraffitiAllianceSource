package com.igexin.push.extension.distribution.basic.p054i.p058d;

import com.igexin.push.extension.distribution.basic.p054i.p056b.C0813i;

/* renamed from: com.igexin.push.extension.distribution.basic.i.d.n */
public final class C0962n extends AbstractC0958j {
    public C0962n(String str, String str2) {
        super(str, str2);
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p058d.AbstractC0955g
    /* renamed from: a */
    public boolean mo5558a(C0813i iVar, C0813i iVar2) {
        return iVar2.mo5365e(this.f2493a) && iVar2.mo5362d(this.f2493a).toLowerCase().endsWith(this.f2494b);
    }

    public String toString() {
        return String.format("[%s$=%s]", this.f2493a, this.f2494b);
    }
}