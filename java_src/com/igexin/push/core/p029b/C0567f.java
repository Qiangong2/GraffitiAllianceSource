package com.igexin.push.core.p029b;

import android.content.ContentValues;
import com.igexin.push.p025b.AbstractC0485d;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.core.b.f */
public class C0567f extends AbstractC0485d {

    /* renamed from: a */
    final /* synthetic */ long f1410a;

    /* renamed from: b */
    final /* synthetic */ C0565d f1411b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0567f(C0565d dVar, ContentValues contentValues, long j) {
        super(contentValues);
        this.f1411b = dVar;
        this.f1410a = j;
    }

    @Override // com.igexin.push.p025b.AbstractC0485d
    /* renamed from: a */
    public void mo4261a() {
        this.f1193c.delete("ral", "id=?", new String[]{String.valueOf(this.f1410a)});
    }
}
