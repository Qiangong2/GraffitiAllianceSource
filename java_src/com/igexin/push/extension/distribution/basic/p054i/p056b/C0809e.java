package com.igexin.push.extension.distribution.basic.p054i.p056b;

import com.igexin.push.extension.distribution.basic.p054i.p057c.C0826ae;

/* renamed from: com.igexin.push.extension.distribution.basic.i.b.e */
public class C0809e extends C0813i {

    /* renamed from: f */
    private C0810f f2268f = new C0810f();

    /* renamed from: g */
    private EnumC0811g f2269g = EnumC0811g.noQuirks;

    public C0809e(String str) {
        super(C0826ae.m3585a("#root"), str);
    }

    /* renamed from: a */
    public C0809e mo5308a(EnumC0811g gVar) {
        this.f2269g = gVar;
        return this;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p056b.C0813i, com.igexin.push.extension.distribution.basic.p054i.p056b.AbstractC0816l
    /* renamed from: a */
    public String mo5302a() {
        return "#document";
    }

    /* renamed from: c */
    public C0809e mo5315g() {
        C0809e eVar = (C0809e) super.mo5315g();
        eVar.f2268f = this.f2268f.clone();
        return eVar;
    }

    /* renamed from: d */
    public C0810f mo5311d() {
        return this.f2268f;
    }

    /* renamed from: e */
    public EnumC0811g mo5312e() {
        return this.f2269g;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p056b.AbstractC0816l
    /* renamed from: e_ */
    public String mo5313e_() {
        return super.mo5349v();
    }
}
