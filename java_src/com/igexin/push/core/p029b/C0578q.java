package com.igexin.push.core.p029b;

import android.database.sqlite.SQLiteDatabase;
import com.igexin.push.p025b.AbstractC0485d;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.core.b.q */
public class C0578q extends AbstractC0485d {

    /* renamed from: a */
    final /* synthetic */ String f1427a;

    /* renamed from: b */
    final /* synthetic */ C0568g f1428b;

    C0578q(C0568g gVar, String str) {
        this.f1428b = gVar;
        this.f1427a = str;
    }

    @Override // com.igexin.push.p025b.AbstractC0485d
    /* renamed from: a */
    public void mo4261a() {
        C0568g.m2192a().m2194a((C0568g) this.f1193c, (SQLiteDatabase) 30, (int) this.f1428b.m2207g(this.f1427a));
    }
}
