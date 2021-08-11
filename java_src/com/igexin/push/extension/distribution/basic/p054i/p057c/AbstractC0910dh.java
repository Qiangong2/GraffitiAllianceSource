package com.igexin.push.extension.distribution.basic.p054i.p057c;

import com.igexin.push.extension.distribution.basic.p054i.p055a.C0794b;
import com.igexin.push.extension.distribution.basic.p054i.p055a.C0803k;
import com.igexin.push.extension.distribution.basic.p054i.p056b.C0809e;
import com.igexin.push.extension.distribution.basic.p054i.p056b.C0813i;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.i.c.dh */
public abstract class AbstractC0910dh {

    /* renamed from: b */
    C0821a f2466b;

    /* renamed from: c */
    C0838aq f2467c;

    /* renamed from: d */
    protected C0809e f2468d;

    /* renamed from: e */
    protected C0794b<C0813i> f2469e;

    /* renamed from: f */
    protected String f2470f;

    /* renamed from: g */
    protected AbstractC0827af f2471g;

    /* renamed from: h */
    protected C0824ac f2472h;

    AbstractC0910dh() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0809e mo5490a(String str, String str2, C0824ac acVar) {
        mo5554b(str, str2, acVar);
        mo5555w();
        return this.f2468d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo5502a(AbstractC0827af afVar);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5554b(String str, String str2, C0824ac acVar) {
        C0803k.m3394a((Object) str, "String input must not be null");
        C0803k.m3394a((Object) str2, "BaseURI must not be null");
        this.f2468d = new C0809e(str2);
        this.f2466b = new C0821a(str);
        this.f2472h = acVar;
        this.f2467c = new C0838aq(this.f2466b, acVar);
        this.f2469e = new C0794b<>();
        this.f2470f = str2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public void mo5555w() {
        AbstractC0827af a;
        do {
            a = this.f2467c.mo5470a();
            mo5502a(a);
        } while (a.f2327a != EnumC0836ao.EOF);
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public C0813i mo5556x() {
        return this.f2469e.getLast();
    }
}
