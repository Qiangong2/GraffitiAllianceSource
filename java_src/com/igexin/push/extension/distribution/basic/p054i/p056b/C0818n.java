package com.igexin.push.extension.distribution.basic.p054i.p056b;

import com.igexin.push.extension.distribution.basic.p054i.p058d.AbstractC0938ad;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.i.b.n */
public class C0818n implements AbstractC0938ad {

    /* renamed from: a */
    private StringBuilder f2300a;

    /* renamed from: b */
    private C0810f f2301b;

    C0818n(StringBuilder sb, C0810f fVar) {
        this.f2300a = sb;
        this.f2301b = fVar;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p058d.AbstractC0938ad
    /* renamed from: a */
    public void mo5372a(AbstractC0816l lVar, int i) {
        lVar.mo5303a(this.f2300a, i, this.f2301b);
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p058d.AbstractC0938ad
    /* renamed from: b */
    public void mo5373b(AbstractC0816l lVar, int i) {
        if (!lVar.mo5302a().equals("#text")) {
            lVar.mo5305b(this.f2300a, i, this.f2301b);
        }
    }
}
