package com.igexin.push.extension.distribution.basic.p054i.p058d;

import com.igexin.push.extension.distribution.basic.p054i.p056b.AbstractC0816l;
import com.igexin.push.extension.distribution.basic.p054i.p056b.C0813i;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.i.d.b */
public class C0950b implements AbstractC0938ad {

    /* renamed from: a */
    private final C0813i f2487a;

    /* renamed from: b */
    private final C0954f f2488b;

    /* renamed from: c */
    private final AbstractC0955g f2489c;

    C0950b(C0813i iVar, C0954f fVar, AbstractC0955g gVar) {
        this.f2487a = iVar;
        this.f2488b = fVar;
        this.f2489c = gVar;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p058d.AbstractC0938ad
    /* renamed from: a */
    public void mo5372a(AbstractC0816l lVar, int i) {
        if (lVar instanceof C0813i) {
            C0813i iVar = (C0813i) lVar;
            if (this.f2489c.mo5558a(this.f2487a, iVar)) {
                this.f2488b.add(iVar);
            }
        }
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p058d.AbstractC0938ad
    /* renamed from: b */
    public void mo5373b(AbstractC0816l lVar, int i) {
    }
}
