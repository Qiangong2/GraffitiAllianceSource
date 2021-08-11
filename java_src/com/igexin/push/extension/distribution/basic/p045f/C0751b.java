package com.igexin.push.extension.distribution.basic.p045f;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.igexin.push.extension.distribution.basic.f.b */
public class C0751b extends SQLiteOpenHelper {

    /* renamed from: a */
    SQLiteDatabase f2080a = null;

    /* renamed from: b */
    private boolean f2081b = true;

    public C0751b(Context context) {
        super(context, "pushsdk.db", (SQLiteDatabase.CursorFactory) null, 3);
    }

    /* renamed from: a */
    public void mo5052a(String str, String str2, ContentValues contentValues) {
        this.f2080a = getWritableDatabase();
        try {
            this.f2080a.replace(str, str2, contentValues);
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public boolean mo5053a() {
        return this.f2081b;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.f2081b = false;
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.f2081b = false;
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.f2081b = false;
    }
}
