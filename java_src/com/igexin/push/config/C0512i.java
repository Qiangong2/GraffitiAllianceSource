package com.igexin.push.config;

import com.igexin.push.core.C0618g;

/* renamed from: com.igexin.push.config.i */
public class C0512i {

    /* renamed from: a */
    private static C0512i f1293a;

    private C0512i() {
    }

    /* renamed from: a */
    public static synchronized C0512i m1962a() {
        C0512i iVar;
        synchronized (C0512i.class) {
            if (f1293a == null) {
                f1293a = new C0512i();
            }
            iVar = f1293a;
        }
        return iVar;
    }

    /* renamed from: b */
    public boolean mo4349b() {
        C0517n.m1970a();
        C0515l.m1964a();
        C0515l.m1967b(C0618g.f1635f);
        C0515l.m1965a(C0618g.f1635f);
        return true;
    }
}
