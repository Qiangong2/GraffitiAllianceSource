package com.igexin.push.core.p029b;

import android.database.sqlite.SQLiteDatabase;
import com.igexin.push.p025b.AbstractC0485d;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.core.b.i */
public class C0570i extends AbstractC0485d {

    /* renamed from: a */
    final /* synthetic */ long f1417a;

    /* renamed from: b */
    final /* synthetic */ C0568g f1418b;

    C0570i(C0568g gVar, long j) {
        this.f1418b = gVar;
        this.f1417a = j;
    }

    @Override // com.igexin.push.p025b.AbstractC0485d
    /* renamed from: a */
    public void mo4261a() {
        C0568g.m2192a().m2193a((C0568g) this.f1193c, (SQLiteDatabase) 21, (int) String.valueOf(this.f1417a));
    }
}
