package com.igexin.push.core.p029b;

import android.database.sqlite.SQLiteDatabase;
import com.igexin.push.p025b.AbstractC0485d;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.core.b.r */
public class C0579r extends AbstractC0485d {

    /* renamed from: a */
    final /* synthetic */ String f1429a;

    /* renamed from: b */
    final /* synthetic */ C0568g f1430b;

    C0579r(C0568g gVar, String str) {
        this.f1430b = gVar;
        this.f1429a = str;
    }

    @Override // com.igexin.push.p025b.AbstractC0485d
    /* renamed from: a */
    public void mo4261a() {
        C0568g.m2192a().m2194a((C0568g) this.f1193c, (SQLiteDatabase) 23, (int) this.f1430b.m2207g(this.f1429a));
    }
}
