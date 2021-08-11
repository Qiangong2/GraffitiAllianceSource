package com.igexin.push.extension.distribution.basic.p054i.p057c;

import java.util.ArrayList;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.i.c.ac */
public class C0824ac extends ArrayList<C0823ab> {

    /* renamed from: a */
    private final int f2309a;

    C0824ac(int i, int i2) {
        super(i);
        this.f2309a = i2;
    }

    /* renamed from: a */
    static C0824ac m3578a(int i) {
        return new C0824ac(16, i);
    }

    /* renamed from: b */
    static C0824ac m3579b() {
        return new C0824ac(0, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5405a() {
        return size() < this.f2309a;
    }
}
