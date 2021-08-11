package com.igexin.push.core.p029b;

import android.database.sqlite.SQLiteDatabase;
import com.igexin.push.core.C0618g;
import com.igexin.push.p025b.AbstractC0485d;
import com.igexin.push.util.EncryptUtils;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.core.b.z */
public class C0587z extends AbstractC0485d {

    /* renamed from: a */
    final /* synthetic */ C0568g f1440a;

    C0587z(C0568g gVar) {
        this.f1440a = gVar;
    }

    @Override // com.igexin.push.p025b.AbstractC0485d
    /* renamed from: a */
    public void mo4261a() {
        C0568g.m2192a().m2194a((C0568g) this.f1193c, (SQLiteDatabase) 19, (int) EncryptUtils.getBytesEncrypted(C0618g.f1652w.getBytes()));
    }
}
