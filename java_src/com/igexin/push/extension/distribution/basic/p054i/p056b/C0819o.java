package com.igexin.push.extension.distribution.basic.p054i.p056b;

import com.igexin.push.extension.distribution.basic.p054i.p055a.C0802j;

/* renamed from: com.igexin.push.extension.distribution.basic.i.b.o */
public class C0819o extends AbstractC0816l {

    /* renamed from: f */
    String f2302f;

    public C0819o(String str, String str2) {
        this.f2296d = str2;
        this.f2302f = str;
    }

    /* renamed from: a */
    static String m3535a(String str) {
        return C0802j.m3392c(str);
    }

    /* renamed from: b */
    static String m3536b(String str) {
        return str.replaceFirst("^\\s+", "");
    }

    /* renamed from: b */
    static boolean m3537b(StringBuilder sb) {
        return sb.length() != 0 && sb.charAt(sb.length() + -1) == ' ';
    }

    /* renamed from: e */
    private void m3538e() {
        if (this.f2295c == null) {
            this.f2295c = new C0806b();
            this.f2295c.mo5291a("text", this.f2302f);
        }
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p056b.AbstractC0816l
    /* renamed from: a */
    public String mo5302a() {
        return "#text";
    }

    /* access modifiers changed from: package-private */
    @Override // com.igexin.push.extension.distribution.basic.p054i.p056b.AbstractC0816l
    /* renamed from: a */
    public void mo5303a(StringBuilder sb, int i, C0810f fVar) {
        String a = C0814j.m3489a(mo5309c(), fVar);
        if (fVar.mo5322d() && (mo5350w() instanceof C0813i) && !((C0813i) mo5350w()).mo5346s()) {
            a = m3535a(a);
        }
        if (fVar.mo5322d() && mo5354C() == 0 && (this.f2293a instanceof C0813i) && ((C0813i) this.f2293a).mo5336i().mo5410c() && !mo5311d()) {
            mo5361c(sb, i, fVar);
        }
        sb.append(a);
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p056b.AbstractC0816l
    /* renamed from: b */
    public AbstractC0816l mo5329b(String str, String str2) {
        m3538e();
        return super.mo5329b(str, str2);
    }

    /* access modifiers changed from: package-private */
    @Override // com.igexin.push.extension.distribution.basic.p054i.p056b.AbstractC0816l
    /* renamed from: b */
    public void mo5305b(StringBuilder sb, int i, C0810f fVar) {
    }

    /* renamed from: c */
    public String mo5309c() {
        return this.f2295c == null ? this.f2302f : this.f2295c.mo5288a("text");
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p056b.AbstractC0816l
    /* renamed from: d */
    public String mo5362d(String str) {
        m3538e();
        return super.mo5362d(str);
    }

    /* renamed from: d */
    public boolean mo5311d() {
        return C0802j.m3388a(mo5309c());
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p056b.AbstractC0816l
    /* renamed from: e */
    public boolean mo5365e(String str) {
        m3538e();
        return super.mo5365e(str);
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p056b.AbstractC0816l
    /* renamed from: g */
    public String mo5368g(String str) {
        m3538e();
        return super.mo5368g(str);
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p056b.AbstractC0816l
    public String toString() {
        return mo5313e_();
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p056b.AbstractC0816l
    /* renamed from: x */
    public C0806b mo5369x() {
        m3538e();
        return super.mo5369x();
    }
}
