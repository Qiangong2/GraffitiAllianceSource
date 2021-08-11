package com.igexin.push.extension.distribution.basic.p054i.p055a;

import com.igexin.push.extension.distribution.basic.p054i.AbstractC0792a;
import com.igexin.push.extension.distribution.basic.p054i.AbstractC0975e;
import com.igexin.push.extension.distribution.basic.p054i.AbstractC0976f;
import com.igexin.push.extension.distribution.basic.p054i.EnumC0933d;
import com.igexin.push.extension.distribution.basic.p054i.p056b.C0809e;
import java.net.URL;

/* renamed from: com.igexin.push.extension.distribution.basic.i.a.e */
public class C0797e implements AbstractC0792a {

    /* renamed from: a */
    private AbstractC0975e f2244a = new C0800h();

    /* renamed from: b */
    private AbstractC0976f f2245b = new C0801i();

    private C0797e() {
    }

    /* renamed from: b */
    public static AbstractC0792a m3335b(URL url) {
        C0797e eVar = new C0797e();
        eVar.mo5242a(url);
        return eVar;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.AbstractC0792a
    /* renamed from: a */
    public AbstractC0792a mo5241a(int i) {
        this.f2244a.mo5264a(i);
        return this;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.AbstractC0792a
    /* renamed from: a */
    public AbstractC0792a mo5242a(URL url) {
        this.f2244a.mo5254a(url);
        return this;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.AbstractC0792a
    /* renamed from: a */
    public C0809e mo5243a() {
        this.f2244a.mo5252a(EnumC0933d.GET);
        mo5251b();
        return this.f2245b.mo5273e();
    }

    /* renamed from: b */
    public AbstractC0976f mo5251b() {
        this.f2245b = C0801i.m3369a(this.f2244a);
        return this.f2245b;
    }
}
