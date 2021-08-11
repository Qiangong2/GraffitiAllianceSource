package com.amap.loc;

import android.database.sqlite.SQLiteDatabase;

/* renamed from: com.amap.loc.ay */
/* compiled from: DynamicFileDBCreator */
public class C0255ay implements AbstractC0227ab {

    /* renamed from: a */
    private static C0255ay f339a;

    private C0255ay() {
    }

    /* renamed from: c */
    public static synchronized C0255ay m585c() {
        C0255ay ayVar;
        synchronized (C0255ay.class) {
            if (f339a == null) {
                f339a = new C0255ay();
            }
            ayVar = f339a;
        }
        return ayVar;
    }

    @Override // com.amap.loc.AbstractC0227ab
    /* renamed from: a */
    public String mo3639a() {
        return "dafile.db";
    }

    @Override // com.amap.loc.AbstractC0227ab
    /* renamed from: a */
    public void mo3640a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS file (_id integer primary key autoincrement, sname  varchar(20), fname varchar(100),md varchar(20),version varchar(20),dversion varchar(20),status varchar(20),reservedfield varchar(20));");
        } catch (Throwable th) {
            C0263ba.m657a(th, "DynamicFileDBCreator", "onCreate");
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
