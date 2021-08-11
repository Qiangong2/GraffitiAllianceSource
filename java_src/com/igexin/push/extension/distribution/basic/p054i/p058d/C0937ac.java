package com.igexin.push.extension.distribution.basic.p054i.p058d;

import com.igexin.push.extension.distribution.basic.p054i.p056b.AbstractC0816l;

/* renamed from: com.igexin.push.extension.distribution.basic.i.d.ac */
public class C0937ac {

    /* renamed from: a */
    private AbstractC0938ad f2479a;

    public C0937ac(AbstractC0938ad adVar) {
        this.f2479a = adVar;
    }

    /* renamed from: a */
    public void mo5561a(AbstractC0816l lVar) {
        int i = 0;
        AbstractC0816l lVar2 = lVar;
        while (lVar2 != null) {
            this.f2479a.mo5372a(lVar2, i);
            if (lVar2.mo5370y().size() > 0) {
                lVar2 = lVar2.mo5355a(0);
                i++;
            } else {
                while (lVar2.mo5353B() == null && i > 0) {
                    this.f2479a.mo5373b(lVar2, i);
                    lVar2 = lVar2.mo5350w();
                    i--;
                }
                this.f2479a.mo5373b(lVar2, i);
                if (lVar2 != lVar) {
                    lVar2 = lVar2.mo5353B();
                } else {
                    return;
                }
            }
        }
    }
}
