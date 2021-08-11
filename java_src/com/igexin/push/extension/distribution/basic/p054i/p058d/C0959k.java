package com.igexin.push.extension.distribution.basic.p054i.p058d;

import com.igexin.push.extension.distribution.basic.p054i.p056b.C0805a;
import com.igexin.push.extension.distribution.basic.p054i.p056b.C0813i;

/* renamed from: com.igexin.push.extension.distribution.basic.i.d.k */
public final class C0959k extends AbstractC0955g {

    /* renamed from: a */
    private String f2495a;

    public C0959k(String str) {
        this.f2495a = str;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p058d.AbstractC0955g
    /* renamed from: a */
    public boolean mo5558a(C0813i iVar, C0813i iVar2) {
        for (C0805a aVar : iVar2.mo5369x().mo5293b()) {
            if (aVar.getKey().startsWith(this.f2495a)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return String.format("[^%s]", this.f2495a);
    }
}
