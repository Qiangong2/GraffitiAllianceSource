package com.igexin.push.core.p029b;

import android.database.sqlite.SQLiteDatabase;
import com.igexin.push.p025b.AbstractC0485d;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.core.b.x */
public class C0585x extends AbstractC0485d {

    /* renamed from: a */
    final /* synthetic */ boolean f1437a;

    /* renamed from: b */
    final /* synthetic */ C0568g f1438b;

    C0585x(C0568g gVar, boolean z) {
        this.f1438b = gVar;
        this.f1437a = z;
    }

    @Override // com.igexin.push.p025b.AbstractC0485d
    /* renamed from: a */
    public void mo4261a() {
        C0568g.m2192a().m2193a((C0568g) this.f1193c, (SQLiteDatabase) 40, (int) String.valueOf(this.f1437a));
    }
}
