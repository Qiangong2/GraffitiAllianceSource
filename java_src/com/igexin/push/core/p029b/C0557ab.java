package com.igexin.push.core.p029b;

import android.database.sqlite.SQLiteDatabase;
import com.igexin.push.core.C0618g;
import com.igexin.push.p025b.AbstractC0485d;
import com.igexin.push.util.C1155e;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.core.b.ab */
public class C0557ab extends AbstractC0485d {

    /* renamed from: a */
    final /* synthetic */ C0568g f1391a;

    C0557ab(C0568g gVar) {
        this.f1391a = gVar;
    }

    @Override // com.igexin.push.p025b.AbstractC0485d
    /* renamed from: a */
    public void mo4261a() {
        C0568g.m2192a().m2193a((C0568g) this.f1193c, (SQLiteDatabase) 2, (int) C0618g.f1653x);
        String c = C1155e.m4769c();
        if (c == null || c.length() <= 5) {
            C1155e.m4771e();
        }
    }
}
