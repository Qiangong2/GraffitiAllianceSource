package com.igexin.push.extension.distribution.basic.p054i.p058d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.i.d.c */
public abstract class AbstractC0951c extends AbstractC0955g {

    /* renamed from: a */
    final List<AbstractC0955g> f2490a;

    AbstractC0951c() {
        this.f2490a = new ArrayList();
    }

    AbstractC0951c(Collection<AbstractC0955g> collection) {
        this();
        this.f2490a.addAll(collection);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public AbstractC0955g mo5569a() {
        if (this.f2490a.size() > 0) {
            return this.f2490a.get(this.f2490a.size() - 1);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5570a(AbstractC0955g gVar) {
        this.f2490a.set(this.f2490a.size() - 1, gVar);
    }
}
