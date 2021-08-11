package com.igexin.push.core.p029b;

import android.database.sqlite.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.igexin.push.core.b.b */
public class C0563b implements AbstractC0555a {

    /* renamed from: b */
    private static C0563b f1403b;

    /* renamed from: a */
    private Map<String, byte[]> f1404a = new HashMap();

    private C0563b() {
    }

    /* renamed from: a */
    public static C0563b m2172a() {
        if (f1403b == null) {
            f1403b = new C0563b();
        }
        return f1403b;
    }

    @Override // com.igexin.push.core.p029b.AbstractC0555a
    /* renamed from: a */
    public void mo4339a(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // com.igexin.push.core.p029b.AbstractC0555a
    /* renamed from: b */
    public void mo4342b(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // com.igexin.push.core.p029b.AbstractC0555a
    /* renamed from: c */
    public void mo4345c(SQLiteDatabase sQLiteDatabase) {
    }
}
