package com.igexin.push.extension.distribution.basic.p046g.p048b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.igexin.push.extension.distribution.basic.g.b.a */
public class C0758a extends SQLiteOpenHelper {

    /* renamed from: a */
    public static String f2116a = "download.db";

    public C0758a(Context context) {
        super(context, f2116a, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS download (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR( 128 ) NOT NULL, size INTEGER, downloaded INTEGER, state INT( 3 ), url TEXT, failed_time INT( 3 ), save_address VARCHAR( 256 ),etag VARCHAR( 32 ),listener TEXT ); ");
        } catch (Throwable th) {
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
