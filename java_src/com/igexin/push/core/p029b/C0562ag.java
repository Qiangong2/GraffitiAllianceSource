package com.igexin.push.core.p029b;

import android.content.ContentValues;
import com.igexin.push.core.C0617f;
import com.igexin.push.p025b.AbstractC0485d;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.core.b.ag */
public class C0562ag extends AbstractC0485d {

    /* renamed from: a */
    final /* synthetic */ ContentValues f1401a;

    /* renamed from: b */
    final /* synthetic */ C0561af f1402b;

    C0562ag(C0561af afVar, ContentValues contentValues) {
        this.f1402b = afVar;
        this.f1401a = contentValues;
    }

    @Override // com.igexin.push.p025b.AbstractC0485d
    /* renamed from: a */
    public void mo4261a() {
        C0617f.m2395a().mo4632k().mo4254a("st", this.f1401a);
        C0561af.m2161a(this.f1402b);
    }
}
