package com.igexin.push.extension.distribution.basic.p054i.p058d;

import com.igexin.push.extension.distribution.basic.p054i.p055a.C0803k;
import com.igexin.push.extension.distribution.basic.p054i.p056b.C0813i;

/* renamed from: com.igexin.push.extension.distribution.basic.i.d.af */
public class C0940af {

    /* renamed from: a */
    private final AbstractC0955g f2484a;

    /* renamed from: b */
    private final C0813i f2485b;

    private C0940af(String str, C0813i iVar) {
        C0803k.m3393a((Object) str);
        String trim = str.trim();
        C0803k.m3395a(trim);
        C0803k.m3393a(iVar);
        this.f2484a = C0939ae.m3862a(trim);
        this.f2485b = iVar;
    }

    /* renamed from: a */
    private C0954f m3880a() {
        return C0934a.m3856a(this.f2484a, this.f2485b);
    }

    /* renamed from: a */
    public static C0954f m3881a(String str, C0813i iVar) {
        return new C0940af(str, iVar).m3880a();
    }
}
