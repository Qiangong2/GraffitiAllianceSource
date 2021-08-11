package com.igexin.push.extension.distribution.basic.p054i.p058d;

import com.igexin.push.extension.distribution.basic.p054i.p056b.C0813i;
import java.util.Iterator;

/* renamed from: com.igexin.push.extension.distribution.basic.i.d.ai */
class C0943ai extends AbstractC0942ah {
    public C0943ai(AbstractC0955g gVar) {
        this.f2486a = gVar;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p058d.AbstractC0955g
    /* renamed from: a */
    public boolean mo5558a(C0813i iVar, C0813i iVar2) {
        Iterator<C0813i> it = iVar2.mo5343p().iterator();
        while (it.hasNext()) {
            C0813i next = it.next();
            if (next != iVar2 && this.f2486a.mo5558a(iVar, next)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return String.format(":has(%s)", this.f2486a);
    }
}
