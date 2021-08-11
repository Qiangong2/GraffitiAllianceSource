package com.igexin.push.core.p029b;

import android.database.sqlite.SQLiteDatabase;
import com.igexin.push.core.C0618g;
import com.igexin.push.p025b.AbstractC0485d;
import com.igexin.push.util.C1155e;
import com.igexin.push.util.EncryptUtils;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.core.b.aa */
public class C0556aa extends AbstractC0485d {

    /* renamed from: a */
    final /* synthetic */ C0568g f1390a;

    C0556aa(C0568g gVar) {
        this.f1390a = gVar;
    }

    @Override // com.igexin.push.p025b.AbstractC0485d
    /* renamed from: a */
    public void mo4261a() {
        C0568g.m2192a().m2194a((C0568g) this.f1193c, (SQLiteDatabase) 1, (int) EncryptUtils.getBytesEncrypted(String.valueOf(C0618g.f1646q).getBytes()));
        C0568g.m2192a().m2194a((C0568g) this.f1193c, (SQLiteDatabase) 20, (int) this.f1390a.m2207g(C0618g.f1647r));
        C1155e.m4760a();
    }
}
