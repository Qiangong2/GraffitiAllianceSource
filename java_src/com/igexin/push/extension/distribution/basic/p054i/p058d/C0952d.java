package com.igexin.push.extension.distribution.basic.p054i.p058d;

import com.igexin.push.extension.distribution.basic.p054i.p055a.C0802j;
import com.igexin.push.extension.distribution.basic.p054i.p056b.C0813i;
import java.util.Arrays;
import java.util.Collection;

/* renamed from: com.igexin.push.extension.distribution.basic.i.d.d */
final class C0952d extends AbstractC0951c {
    C0952d(Collection<AbstractC0955g> collection) {
        super(collection);
    }

    C0952d(AbstractC0955g... gVarArr) {
        this(Arrays.asList(gVarArr));
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p058d.AbstractC0955g
    /* renamed from: a */
    public boolean mo5558a(C0813i iVar, C0813i iVar2) {
        for (AbstractC0955g gVar : this.f2490a) {
            if (!gVar.mo5558a(iVar, iVar2)) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return C0802j.m3386a(this.f2490a, " ");
    }
}
