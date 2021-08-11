package com.igexin.push.extension.distribution.gbd.p069e;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;

/* renamed from: com.igexin.push.extension.distribution.gbd.e.a */
public class C1078a extends SQLiteOpenHelper {

    /* renamed from: a */
    private SQLiteDatabase f2863a = null;

    public C1078a(Context context) {
        super(context, "pushg.db", (SQLiteDatabase.CursorFactory) null, 6);
    }

    /* renamed from: a */
    private String m4377a(String[] strArr, String[] strArr2, int i) {
        StringBuilder sb = new StringBuilder(" ");
        if (strArr.length == 1) {
            for (int i2 = 0; i2 < i; i2++) {
                sb.append(strArr[0]).append(" = '").append(strArr2[i2]).append("'");
                if (i2 < i - 1) {
                    sb.append(" or ");
                }
            }
        } else {
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(strArr[i3]).append(" = '").append(strArr2[i3]).append("'");
                if (i3 < i - 1) {
                    sb.append(" and ");
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: b */
    private String m4378b(String str, String str2) {
        return "delete from " + str + " where " + str2;
    }

    /* renamed from: a */
    public long mo5799a(String str, ContentValues contentValues) {
        this.f2863a = getWritableDatabase();
        long j = -1;
        this.f2863a.beginTransaction();
        try {
            j = this.f2863a.insert(str, null, contentValues);
            this.f2863a.setTransactionSuccessful();
        } catch (Exception e) {
        } finally {
            this.f2863a.endTransaction();
        }
        return j;
    }

    /* renamed from: a */
    public Cursor mo5800a(String str, String[] strArr) {
        this.f2863a = getReadableDatabase();
        try {
            return this.f2863a.rawQuery(str, strArr);
        } catch (Exception e) {
            C1115d.m4558a(e);
            return null;
        }
    }

    /* renamed from: a */
    public void mo5801a(String str, String str2) {
        this.f2863a = getWritableDatabase();
        this.f2863a.delete(str, str2, null);
    }

    /* renamed from: a */
    public void mo5802a(String str, String str2, ContentValues contentValues) {
        this.f2863a = getWritableDatabase();
        try {
            this.f2863a.replace(str, str2, contentValues);
        } catch (Exception e) {
            C1115d.m4558a(e);
        }
    }

    /* renamed from: a */
    public void mo5803a(String str, String[] strArr, String[] strArr2) {
        this.f2863a = getWritableDatabase();
        this.f2863a.beginTransaction();
        if (strArr == null) {
            try {
                this.f2863a.delete(str, null, null);
            } catch (Exception e) {
                this.f2863a.endTransaction();
                return;
            } catch (Throwable th) {
                this.f2863a.endTransaction();
                throw th;
            }
        } else if (strArr.length != 1) {
            this.f2863a.execSQL(m4378b(str, m4377a(strArr, strArr2, strArr.length)));
        } else if (strArr2.length == 1) {
            this.f2863a.delete(str, strArr[0] + " = ?", strArr2);
        } else {
            this.f2863a.execSQL(m4378b(str, m4377a(strArr, strArr2, strArr2.length)));
        }
        this.f2863a.setTransactionSuccessful();
        this.f2863a.endTransaction();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        try {
            this.f2863a.close();
        } catch (Exception e) {
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL("create table if not exists runtime(key integer primary key, value text)");
            sQLiteDatabase.execSQL("create table if not exists ral (id integer primary key  , key integer, value blob,  t integer)");
            sQLiteDatabase.execSQL("create table if not exists config (key integer primary key, value text)");
            sQLiteDatabase.execSQL("create table if not exists look (id integer primary key  , value text,  t datetime,type integer,status integer, stage integer)");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e) {
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i2, i);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            sQLiteDatabase.execSQL("drop table if exists runtime");
        } catch (Exception e) {
            C1115d.m4558a(e);
        }
        try {
            sQLiteDatabase.execSQL("drop table if exists ral");
        } catch (Exception e2) {
            C1115d.m4558a(e2);
        }
        try {
            sQLiteDatabase.execSQL("drop table if exists config");
        } catch (Exception e3) {
            C1115d.m4558a(e3);
        }
        try {
            sQLiteDatabase.execSQL("drop table if exists look");
        } catch (Exception e4) {
            C1115d.m4558a(e4);
        }
        onCreate(sQLiteDatabase);
    }
}
