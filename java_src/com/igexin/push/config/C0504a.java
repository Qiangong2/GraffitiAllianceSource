package com.igexin.push.config;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.push.core.p029b.AbstractC0555a;

/* renamed from: com.igexin.push.config.a */
public class C0504a implements AbstractC0555a {

    /* renamed from: a */
    public static final String f1282a = C0504a.class.getName();

    /* renamed from: b */
    private static C0504a f1283b;

    /* renamed from: a */
    public static C0504a m1940a() {
        if (f1283b == null) {
            f1283b = new C0504a();
        }
        return f1283b;
    }

    /* renamed from: a */
    private void m1941a(SQLiteDatabase sQLiteDatabase, int i, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(i));
        contentValues.put("value", str);
        sQLiteDatabase.replace("config", null, contentValues);
    }

    /* renamed from: a */
    private void m1942a(SQLiteDatabase sQLiteDatabase, int i, byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(i));
        contentValues.put("value", bArr);
        sQLiteDatabase.replace("config", null, contentValues);
    }

    @Override // com.igexin.push.core.p029b.AbstractC0555a
    /* renamed from: a */
    public void mo4339a(SQLiteDatabase sQLiteDatabase) {
    }

    /* renamed from: a */
    public void mo4340a(String str) {
        C0456c.m1661b().mo4216a(new C0510g(this, str), true, false);
    }

    /* renamed from: b */
    public void mo4341b() {
        C0456c.m1661b().mo4216a(new C0505b(this), false, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004d, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b2, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b3, code lost:
        r1 = r0;
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b8, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:215:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b2 A[ExcHandler: all (r1v9 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:4:0x000a] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b8  */
    @Override // com.igexin.push.core.p029b.AbstractC0555a
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo4342b(android.database.sqlite.SQLiteDatabase r7) {
        /*
        // Method dump skipped, instructions count: 968
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.config.C0504a.mo4342b(android.database.sqlite.SQLiteDatabase):void");
    }

    /* renamed from: b */
    public void mo4343b(String str) {
        C0456c.m1661b().mo4216a(new C0511h(this, str), true, false);
    }

    /* renamed from: c */
    public void mo4344c() {
        C0456c.m1661b().mo4216a(new C0506c(this), false, true);
    }

    @Override // com.igexin.push.core.p029b.AbstractC0555a
    /* renamed from: c */
    public void mo4345c(SQLiteDatabase sQLiteDatabase) {
        m1941a(sQLiteDatabase, 1, String.valueOf(C0514k.f1309a));
        m1941a(sQLiteDatabase, 2, String.valueOf(C0514k.f1310b));
        m1941a(sQLiteDatabase, 3, String.valueOf(C0514k.f1311c));
        m1941a(sQLiteDatabase, 4, String.valueOf(C0514k.f1314f));
        m1941a(sQLiteDatabase, 6, String.valueOf(C0514k.f1315g));
        m1941a(sQLiteDatabase, 7, String.valueOf(C0514k.f1316h));
        m1941a(sQLiteDatabase, 8, String.valueOf(C0514k.f1317i));
        m1941a(sQLiteDatabase, 9, String.valueOf(C0514k.f1318j));
        m1941a(sQLiteDatabase, 11, String.valueOf(C0514k.f1321m));
        m1941a(sQLiteDatabase, 12, String.valueOf(C0514k.f1322n));
        m1941a(sQLiteDatabase, 13, String.valueOf(C0514k.f1319k));
        m1941a(sQLiteDatabase, 14, String.valueOf(C0514k.f1320l));
        m1941a(sQLiteDatabase, 15, String.valueOf(C0514k.f1312d));
        m1941a(sQLiteDatabase, 3, String.valueOf(C0514k.f1311c));
        m1941a(sQLiteDatabase, 17, String.valueOf(C0514k.f1323o));
        m1941a(sQLiteDatabase, 18, String.valueOf(C0514k.f1324p));
        m1941a(sQLiteDatabase, 19, String.valueOf(C0514k.f1325q));
        m1941a(sQLiteDatabase, 25, String.valueOf(C0514k.f1330v));
    }

    /* renamed from: d */
    public void mo4346d() {
        C0456c.m1661b().mo4216a(new C0507d(this), false, true);
    }

    /* renamed from: e */
    public void mo4347e() {
        C0456c.m1661b().mo4216a(new C0508e(this), false, true);
    }

    /* renamed from: f */
    public void mo4348f() {
        C0456c.m1661b().mo4216a(new C0509f(this), false, true);
    }
}
