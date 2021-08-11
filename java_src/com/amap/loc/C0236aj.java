package com.amap.loc;

import android.database.sqlite.SQLiteDatabase;

/* renamed from: com.amap.loc.aj */
/* compiled from: LogDBCreator */
public class C0236aj implements AbstractC0227ab {
    @Override // com.amap.loc.AbstractC0227ab
    /* renamed from: a */
    public String mo3639a() {
        return "logdb.db";
    }

    @Override // com.amap.loc.AbstractC0227ab
    /* renamed from: a */
    public void mo3640a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS a (_id integer primary key autoincrement, a1  varchar(20), a2 varchar(10),a3 varchar(50),a4 varchar(100),a5 varchar(20),a6 integer);");
            sQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id integer primary key autoincrement,b1 varchar(40), b2 integer,b3  integer,a1  varchar(20));", "b"));
            sQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id integer primary key autoincrement,b1 varchar(40), b2 integer,b3  integer,a1  varchar(20));", "c"));
            sQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id integer primary key autoincrement,b1 varchar(40), b2 integer,b3  integer,a1  varchar(20));", "d"));
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS e (_id integer primary key autoincrement,c1 integer,c2 integer,c3 integer);");
        } catch (Throwable th) {
            C0365t.m1372a(th, "DB", "onCreate");
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
