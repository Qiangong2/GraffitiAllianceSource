package com.wanmei.sdk.core.p106ui.floatview.p107a;

import com.wanmei.sdk.core.p106ui.floatview.C1827b;

/* renamed from: com.wanmei.sdk.core.ui.floatview.a.b */
public class C1823b {

    /* renamed from: a */
    private static volatile C1823b f4546a;

    /* renamed from: b */
    private C1827b f4547b;

    /* renamed from: c */
    private AbstractC1825d f4548c = new C1826e(this.f4547b);

    private C1823b(C1827b bVar) {
        this.f4547b = bVar;
    }

    /* renamed from: a */
    public static C1823b m6619a() {
        return f4546a;
    }

    /* renamed from: a */
    public static C1823b m6620a(C1827b bVar) {
        if (f4546a == null) {
            synchronized (C1823b.class) {
                if (f4546a == null) {
                    f4546a = new C1823b(bVar);
                }
            }
        }
        return f4546a;
    }

    /* renamed from: a */
    public void mo9878a(AbstractC1825d dVar) {
        this.f4548c = dVar;
        this.f4548c.mo9882c();
    }

    /* renamed from: b */
    public C1827b mo9879b() {
        return this.f4547b;
    }

    /* renamed from: c */
    public void mo9880c() {
        this.f4548c.mo9883d();
    }

    /* renamed from: d */
    public void mo9881d() {
        this.f4548c.mo9884e();
    }
}
