package com.igexin.push.p079f.p081b;

import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.push.core.p027a.C0535e;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.igexin.push.f.b.a */
public class C1143a extends AbstractC1150h {

    /* renamed from: b */
    private static C1143a f3003b;

    /* renamed from: a */
    private List<AbstractC1146d> f3004a = new ArrayList();

    private C1143a() {
        super(360000);
        this.f1126o = true;
    }

    /* renamed from: g */
    public static C1143a m4702g() {
        if (f3003b == null) {
            f3003b = new C1143a();
        }
        return f3003b;
    }

    /* renamed from: h */
    private void m4703h() {
        mo4193a(360000, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: protected */
    @Override // com.igexin.push.p079f.p081b.AbstractC1150h
    /* renamed from: a */
    public void mo4304a() {
        C0535e.m2034a().mo4358A();
        for (AbstractC1146d dVar : this.f3004a) {
            if (dVar.mo4249b()) {
                dVar.mo4247a();
                dVar.mo4248a(System.currentTimeMillis());
            }
        }
        m4703h();
        C0456c.m1661b().mo4218a(this);
    }

    /* renamed from: a */
    public boolean mo5898a(AbstractC1146d dVar) {
        return this.f3004a != null && !this.f3004a.contains(dVar) && this.f3004a.add(dVar);
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public int mo4136b() {
        return 0;
    }
}
