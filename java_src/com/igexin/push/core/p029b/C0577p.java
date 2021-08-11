package com.igexin.push.core.p029b;

import android.database.sqlite.SQLiteDatabase;
import com.igexin.push.p025b.AbstractC0485d;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.core.b.p */
public class C0577p extends AbstractC0485d {

    /* renamed from: a */
    final /* synthetic */ String f1425a;

    /* renamed from: b */
    final /* synthetic */ C0568g f1426b;

    C0577p(C0568g gVar, String str) {
        this.f1426b = gVar;
        this.f1425a = str;
    }

    @Override // com.igexin.push.p025b.AbstractC0485d
    /* renamed from: a */
    public void mo4261a() {
        C0568g.m2192a().m2194a((C0568g) this.f1193c, (SQLiteDatabase) 31, (int) this.f1426b.m2207g(this.f1425a));
    }
}
