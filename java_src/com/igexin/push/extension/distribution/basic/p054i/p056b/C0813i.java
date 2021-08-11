package com.igexin.push.extension.distribution.basic.p054i.p056b;

import com.igexin.push.extension.distribution.basic.p054i.p055a.C0803k;
import com.igexin.push.extension.distribution.basic.p054i.p057c.C0826ae;
import com.igexin.push.extension.distribution.basic.p054i.p058d.C0934a;
import com.igexin.push.extension.distribution.basic.p054i.p058d.C0936ab;
import com.igexin.push.extension.distribution.basic.p054i.p058d.C0940af;
import com.igexin.push.extension.distribution.basic.p054i.p058d.C0954f;
import com.igexin.push.extension.distribution.basic.p054i.p058d.C0956h;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.igexin.push.extension.distribution.basic.i.b.i */
public class C0813i extends AbstractC0816l {

    /* renamed from: f */
    private C0826ae f2279f;

    /* renamed from: g */
    private Set<String> f2280g;

    public C0813i(C0826ae aeVar, String str) {
        this(aeVar, str, new C0806b());
    }

    public C0813i(C0826ae aeVar, String str, C0806b bVar) {
        super(str, bVar);
        C0803k.m3393a(aeVar);
        this.f2279f = aeVar;
    }

    /* renamed from: a */
    private static <E extends C0813i> Integer m3454a(C0813i iVar, List<E> list) {
        C0803k.m3393a(iVar);
        C0803k.m3393a(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(iVar)) {
                return Integer.valueOf(i);
            }
        }
        return null;
    }

    /* renamed from: a */
    private static void m3455a(C0813i iVar, StringBuilder sb) {
        if (iVar.f2279f.mo5408a().equals("br") && !C0819o.m3537b(sb)) {
            sb.append(" ");
        }
    }

    /* renamed from: a */
    private void m3456a(StringBuilder sb, C0819o oVar) {
        String c = oVar.mo5309c();
        if (!mo5346s()) {
            c = C0819o.m3535a(c);
            if (C0819o.m3537b(sb)) {
                c = C0819o.m3536b(c);
            }
        }
        sb.append(c);
    }

    /* renamed from: b */
    private void m3457b(StringBuilder sb) {
        m3455a(this, sb);
        for (AbstractC0816l lVar : this.f2294b) {
            if (lVar instanceof C0819o) {
                m3456a(sb, (C0819o) lVar);
            } else if (lVar instanceof C0813i) {
                C0813i iVar = (C0813i) lVar;
                if (sb.length() > 0 && iVar.mo5337j() && !C0819o.m3537b(sb)) {
                    sb.append(" ");
                }
                iVar.m3457b(sb);
            }
        }
    }

    /* renamed from: c */
    private void m3458c(StringBuilder sb) {
        for (AbstractC0816l lVar : this.f2294b) {
            if (lVar instanceof C0819o) {
                m3456a(sb, (C0819o) lVar);
            } else if (lVar instanceof C0813i) {
                m3455a((C0813i) lVar, sb);
            }
        }
    }

    /* renamed from: d */
    private void m3459d(StringBuilder sb) {
        for (AbstractC0816l lVar : this.f2294b) {
            lVar.mo5358a(sb);
        }
    }

    /* renamed from: a */
    public C0813i mo5325a(AbstractC0816l lVar) {
        C0803k.m3393a(lVar);
        mo5359a(lVar);
        return this;
    }

    /* renamed from: a */
    public C0813i mo5329b(String str, String str2) {
        super.mo5329b(str, str2);
        return this;
    }

    /* renamed from: a */
    public C0954f mo5327a(String str) {
        return C0940af.m3881a(str, this);
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p056b.AbstractC0816l
    /* renamed from: a */
    public String mo5302a() {
        return this.f2279f.mo5408a();
    }

    /* access modifiers changed from: package-private */
    @Override // com.igexin.push.extension.distribution.basic.p054i.p056b.AbstractC0816l
    /* renamed from: a */
    public void mo5303a(StringBuilder sb, int i, C0810f fVar) {
        if (sb.length() > 0 && fVar.mo5322d() && (this.f2279f.mo5410c() || (mo5350w() != null && mo5350w().mo5336i().mo5410c()))) {
            mo5361c(sb, i, fVar);
        }
        sb.append(SimpleComparison.LESS_THAN_OPERATION).append(mo5334h());
        this.f2295c.mo5292a(sb, fVar);
        if (!this.f2294b.isEmpty() || !this.f2279f.mo5411d()) {
            sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        } else {
            sb.append(" />");
        }
    }

    /* renamed from: b */
    public C0813i mo5331c(AbstractC0816l lVar) {
        return (C0813i) super.mo5331c(lVar);
    }

    /* renamed from: b */
    public C0954f mo5330b(String str) {
        C0803k.m3395a(str);
        return C0934a.m3856a(new C0936ab(str.toLowerCase().trim()), this);
    }

    /* access modifiers changed from: package-private */
    @Override // com.igexin.push.extension.distribution.basic.p054i.p056b.AbstractC0816l
    /* renamed from: b */
    public void mo5305b(StringBuilder sb, int i, C0810f fVar) {
        if (!this.f2294b.isEmpty() || !this.f2279f.mo5411d()) {
            if (fVar.mo5322d() && !this.f2294b.isEmpty() && this.f2279f.mo5410c()) {
                mo5361c(sb, i, fVar);
            }
            sb.append("</").append(mo5334h()).append(SimpleComparison.GREATER_THAN_OPERATION);
        }
    }

    /* renamed from: c */
    public boolean mo5332c(String str) {
        for (String str2 : mo5348u()) {
            if (str.equalsIgnoreCase(str2)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p056b.AbstractC0816l
    public boolean equals(Object obj) {
        return this == obj;
    }

    /* renamed from: f */
    public C0813i mo5315g() {
        C0813i iVar = (C0813i) super.clone();
        iVar.mo5348u();
        return iVar;
    }

    /* renamed from: h */
    public String mo5334h() {
        return this.f2279f.mo5408a();
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p056b.AbstractC0816l
    public int hashCode() {
        return (this.f2279f != null ? this.f2279f.hashCode() : 0) + (super.hashCode() * 31);
    }

    /* renamed from: i */
    public C0826ae mo5336i() {
        return this.f2279f;
    }

    /* renamed from: j */
    public boolean mo5337j() {
        return this.f2279f.mo5409b();
    }

    /* renamed from: k */
    public String mo5338k() {
        String d = mo5362d("id");
        return d == null ? "" : d;
    }

    /* renamed from: l */
    public final C0813i mo5350w() {
        return (C0813i) this.f2293a;
    }

    /* renamed from: m */
    public C0954f mo5340m() {
        ArrayList arrayList = new ArrayList();
        for (AbstractC0816l lVar : this.f2294b) {
            if (lVar instanceof C0813i) {
                arrayList.add((C0813i) lVar);
            }
        }
        return new C0954f(arrayList);
    }

    /* renamed from: n */
    public C0813i mo5341n() {
        if (this.f2293a == null) {
            return null;
        }
        C0954f m = mo5350w().mo5340m();
        Integer a = m3454a(this, m);
        C0803k.m3393a(a);
        if (a.intValue() > 0) {
            return (C0813i) m.get(a.intValue() - 1);
        }
        return null;
    }

    /* renamed from: o */
    public Integer mo5342o() {
        if (mo5350w() == null) {
            return 0;
        }
        return m3454a(this, mo5350w().mo5340m());
    }

    /* renamed from: p */
    public C0954f mo5343p() {
        return C0934a.m3856a(new C0956h(), this);
    }

    /* renamed from: q */
    public String mo5344q() {
        StringBuilder sb = new StringBuilder();
        m3457b(sb);
        return sb.toString().trim();
    }

    /* renamed from: r */
    public String mo5345r() {
        StringBuilder sb = new StringBuilder();
        m3458c(sb);
        return sb.toString().trim();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public boolean mo5346s() {
        return this.f2279f.mo5414f() || (mo5350w() != null && mo5350w().mo5346s());
    }

    /* renamed from: t */
    public String mo5347t() {
        return mo5362d("class");
    }

    @Override // com.igexin.push.extension.distribution.basic.p054i.p056b.AbstractC0816l
    public String toString() {
        return mo5313e_();
    }

    /* renamed from: u */
    public Set<String> mo5348u() {
        if (this.f2280g == null) {
            this.f2280g = new LinkedHashSet(Arrays.asList(mo5347t().split("\\s+")));
        }
        return this.f2280g;
    }

    /* renamed from: v */
    public String mo5349v() {
        StringBuilder sb = new StringBuilder();
        m3459d(sb);
        return sb.toString().trim();
    }
}
