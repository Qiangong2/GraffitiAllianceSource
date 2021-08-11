package com.igexin.push.extension.distribution.basic.p054i.p056b;

/* renamed from: com.igexin.push.extension.distribution.basic.i.b.c */
public class C0807c extends AbstractC0816l {
    public C0807c(String str, String str2) {
        super(str2);
        this.f2295c.mo5291a("comment", str);
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p056b.AbstractC0816l
    /* renamed from: a */
    public String mo5302a() {
        return "#comment";
    }

    /* access modifiers changed from: package-private */
    @Override // com.igexin.push.extension.distribution.basic.p054i.p056b.AbstractC0816l
    /* renamed from: a */
    public void mo5303a(StringBuilder sb, int i, C0810f fVar) {
        if (fVar.mo5322d()) {
            mo5361c(sb, i, fVar);
        }
        sb.append("<!--").append(mo5304b()).append("-->");
    }

    /* renamed from: b */
    public String mo5304b() {
        return this.f2295c.mo5288a("comment");
    }

    /* access modifiers changed from: package-private */
    @Override // com.igexin.push.extension.distribution.basic.p054i.p056b.AbstractC0816l
    /* renamed from: b */
    public void mo5305b(StringBuilder sb, int i, C0810f fVar) {
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p056b.AbstractC0816l
    public String toString() {
        return mo5313e_();
    }
}
