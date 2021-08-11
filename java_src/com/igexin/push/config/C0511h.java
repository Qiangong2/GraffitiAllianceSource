package com.igexin.push.config;

import android.database.sqlite.SQLiteDatabase;
import com.igexin.p012b.p013a.p014a.C0435a;
import com.igexin.push.core.C0618g;
import com.igexin.push.p025b.AbstractC0485d;

/* renamed from: com.igexin.push.config.h */
class C0511h extends AbstractC0485d {

    /* renamed from: a */
    final /* synthetic */ String f1291a;

    /* renamed from: b */
    final /* synthetic */ C0504a f1292b;

    C0511h(C0504a aVar, String str) {
        this.f1292b = aVar;
        this.f1291a = str;
    }

    @Override // com.igexin.push.p025b.AbstractC0485d
    /* renamed from: a */
    public void mo4261a() {
        this.f1292b.m1942a((C0504a) this.f1193c, (SQLiteDatabase) 24, (int) C0435a.m1578d(this.f1291a.getBytes(), C0618g.f1577B));
    }
}
