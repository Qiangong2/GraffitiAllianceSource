package com.igexin.push.core.p029b;

import android.database.sqlite.SQLiteDatabase;
import com.igexin.push.p025b.AbstractC0485d;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.core.b.t */
public class C0581t extends AbstractC0485d {

    /* renamed from: a */
    final /* synthetic */ String f1432a;

    /* renamed from: b */
    final /* synthetic */ C0568g f1433b;

    C0581t(C0568g gVar, String str) {
        this.f1433b = gVar;
        this.f1432a = str;
    }

    @Override // com.igexin.push.p025b.AbstractC0485d
    /* renamed from: a */
    public void mo4261a() {
        C0568g.m2192a().m2194a((C0568g) this.f1193c, (SQLiteDatabase) 22, (int) this.f1433b.m2207g(this.f1432a));
    }
}
