package com.amap.loc;

import android.database.sqlite.SQLiteDatabase;

/* renamed from: com.amap.loc.cf */
/* compiled from: SdCardDBCreator */
public class C0317cf implements AbstractC0227ab {
    @Override // com.amap.loc.AbstractC0227ab
    /* renamed from: a */
    public String mo3639a() {
        return "als.db";
    }

    @Override // com.amap.loc.AbstractC0227ab
    /* renamed from: a */
    public void mo3640a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS a (_id integer primary key autoincrement, a2 varchar(100), a3 LONG );");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS b (_id integer primary key autoincrement, b1 integer );");
        } catch (Throwable th) {
            C0310c.m956a(th, "SdCardDBCreator", "onCreate");
        }
    }

    @Override // com.amap.loc.AbstractC0227ab
    /* renamed from: a */
    public void mo3641a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // com.amap.loc.AbstractC0227ab
    /* renamed from: b */
    public int mo3642b() {
        return 1;
    }
}
