package com.igexin.push.extension.distribution.basic.p045f;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.igexin.push.extension.distribution.basic.f.a */
public class C0750a extends SQLiteOpenHelper {

    /* renamed from: a */
    SQLiteDatabase f2079a = null;

    public C0750a(Context context) {
        super(context, "pushext.db", (SQLiteDatabase.CursorFactory) null, 4);
    }

    /* renamed from: a */
    private String m3046a(String str, String str2) {
        return "delete from " + str + " where " + str2;
    }

    /* renamed from: a */
    private String m3047a(String[] strArr, String[] strArr2, int i) {
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

    /* renamed from: a */
    public Cursor mo5042a(String str, String[] strArr) {
        this.f2079a = getReadableDatabase();
        try {
            return this.f2079a.rawQuery(str, strArr);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    public Cursor mo5043a(String str, String[] strArr, String str2) {
        this.f2079a = getReadableDatabase();
        return this.f2079a.query(str, strArr, str2, null, null, null, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007d, code lost:
        r9.f2079a.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0082, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x007c A[ExcHandler: all (r0v2 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:2:0x000f] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.database.Cursor mo5044a(java.lang.String r10, java.lang.String[] r11, java.lang.String[] r12, java.lang.String[] r13, java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 133
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.p045f.C0750a.mo5044a(java.lang.String, java.lang.String[], java.lang.String[], java.lang.String[], java.lang.String):android.database.Cursor");
    }

    /* renamed from: a */
    public void mo5045a(String str, ContentValues contentValues) {
        this.f2079a = getWritableDatabase();
        this.f2079a.beginTransaction();
        try {
            this.f2079a.insert(str, null, contentValues);
            this.f2079a.setTransactionSuccessful();
        } catch (Exception e) {
        } finally {
            this.f2079a.endTransaction();
        }
    }

    /* renamed from: a */
    public void mo5046a(String str, String str2, ContentValues contentValues) {
        this.f2079a = getWritableDatabase();
        try {
            this.f2079a.replace(str, str2, contentValues);
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public void mo5047a(String str, String[] strArr, String[] strArr2) {
        this.f2079a = getWritableDatabase();
        this.f2079a.beginTransaction();
        if (strArr == null) {
            try {
                this.f2079a.delete(str, null, null);
            } catch (Exception e) {
                this.f2079a.endTransaction();
                return;
            } catch (Throwable th) {
                this.f2079a.endTransaction();
                throw th;
            }
        } else if (strArr.length != 1) {
            this.f2079a.execSQL(m3046a(str, m3047a(strArr, strArr2, strArr.length)));
        } else if (strArr2.length == 1) {
            this.f2079a.delete(str, strArr[0] + " = ?", strArr2);
        } else {
            this.f2079a.execSQL(m3046a(str, m3047a(strArr, strArr2, strArr2.length)));
        }
        this.f2079a.setTransactionSuccessful();
        this.f2079a.endTransaction();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        try {
            this.f2079a.close();
        } catch (Exception e) {
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("create table if not exists image(id integer primary key autoincrement, imageurl text, imagesrc text, taskid text, createtime bigint)");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e) {
        } finally {
            sQLiteDatabase.endTransaction();
        }
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("create table if not exists message(id integer primary key autoincrement,messageid text,taskid text,appid text,info text,msgextra blob,key text,createtime integer)");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e2) {
        } finally {
            sQLiteDatabase.endTransaction();
        }
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("create table if not exists sc(id integer primary key autoincrement, title text, value text)");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e3) {
        } finally {
            sQLiteDatabase.endTransaction();
        }
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("create table if not exists extconfig (key integer primary key, value text)");
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e4) {
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i2, i);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            sQLiteDatabase.execSQL("drop table if exists image");
        } catch (Exception e) {
        }
        try {
            sQLiteDatabase.execSQL("drop table if exists message");
        } catch (Exception e2) {
        }
        try {
            sQLiteDatabase.execSQL("drop table if existssc");
        } catch (Exception e3) {
        }
        try {
            sQLiteDatabase.execSQL("drop table if existsextconfig");
        } catch (Exception e4) {
        }
        onCreate(sQLiteDatabase);
    }
}
