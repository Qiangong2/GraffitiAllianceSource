package com.igexin.push.core.p029b;

import android.database.sqlite.SQLiteDatabase;
import com.igexin.push.core.C0618g;
import com.igexin.push.p025b.AbstractC0485d;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.core.b.y */
public class C0586y extends AbstractC0485d {

    /* renamed from: a */
    final /* synthetic */ C0568g f1439a;

    C0586y(C0568g gVar) {
        this.f1439a = gVar;
    }

    @Override // com.igexin.push.p025b.AbstractC0485d
    /* renamed from: a */
    public void mo4261a() {
        C0568g a = C0568g.m2192a();
        a.m2193a((C0568g) this.f1193c, (SQLiteDatabase) 2, (int) C0618g.f1653x);
        a.m2194a((C0568g) this.f1193c, (SQLiteDatabase) 1, (int) this.f1439a.m2207g(String.valueOf(C0618g.f1646q)));
        a.m2194a((C0568g) this.f1193c, (SQLiteDatabase) 20, (int) this.f1439a.m2207g(C0618g.f1647r));
        this.f1439a.m2203f();
    }
}
