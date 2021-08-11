package com.igexin.push.p025b;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.igexin.push.core.p029b.C0568g;

/* renamed from: com.igexin.push.b.b */
public class C0483b extends SQLiteOpenHelper {

    /* renamed from: a */
    private SQLiteDatabase f1190a = null;

    public C0483b(Context context) {
        super(context, "pushsdk.db", (SQLiteDatabase.CursorFactory) null, 3);
    }

    /* renamed from: a */
    private String m1800a(String[] strArr, String[] strArr2, int i) {
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
    private String m1801b(String str, String str2) {
        return "delete from " + str + " where " + str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007d, code lost:
        r9.f1190a.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0082, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x007c A[ExcHandler: all (r0v2 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:2:0x000f] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.database.Cursor mo4253a(java.lang.String r10, java.lang.String[] r11, java.lang.String[] r12, java.lang.String[] r13, java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 133
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.p025b.C0483b.mo4253a(java.lang.String, java.lang.String[], java.lang.String[], java.lang.String[], java.lang.String):android.database.Cursor");
    }

    /* renamed from: a */
    public void mo4254a(String str, ContentValues contentValues) {
        this.f1190a = getWritableDatabase();
        this.f1190a.beginTransaction();
        try {
            this.f1190a.insert(str, null, contentValues);
            this.f1190a.setTransactionSuccessful();
        } catch (Exception e) {
        } finally {
            this.f1190a.endTransaction();
        }
    }

    /* renamed from: a */
    public void mo4255a(String str, ContentValues contentValues, String[] strArr, String[] strArr2) {
        this.f1190a = getWritableDatabase();
        this.f1190a.beginTransaction();
        if (strArr == null) {
            try {
                this.f1190a.update(str, contentValues, null, null);
            } catch (Exception e) {
                this.f1190a.endTransaction();
                return;
            } catch (Throwable th) {
                this.f1190a.endTransaction();
                throw th;
            }
        } else if (strArr.length != 1) {
            this.f1190a.update(str, contentValues, m1800a(strArr, strArr2, strArr.length), null);
        } else if (strArr2.length == 1) {
            this.f1190a.update(str, contentValues, strArr[0] + "='" + strArr2[0] + "'", null);
        } else {
            this.f1190a.update(str, contentValues, m1800a(strArr, strArr2, strArr2.length), null);
        }
        this.f1190a.setTransactionSuccessful();
        this.f1190a.endTransaction();
    }

    /* renamed from: a */
    public void mo4256a(String str, String str2) {
        this.f1190a = getWritableDatabase();
        this.f1190a.beginTransaction();
        try {
            this.f1190a.delete(str, str2, null);
            this.f1190a.setTransactionSuccessful();
        } catch (Exception e) {
        } finally {
            this.f1190a.endTransaction();
        }
    }

    /* renamed from: a */
    public void mo4257a(String str, String[] strArr, String[] strArr2) {
        this.f1190a = getWritableDatabase();
        this.f1190a.beginTransaction();
        if (strArr == null) {
            try {
                this.f1190a.delete(str, null, null);
            } catch (Exception e) {
                this.f1190a.endTransaction();
                return;
            } catch (Throwable th) {
                this.f1190a.endTransaction();
                throw th;
            }
        } else if (strArr.length != 1) {
            this.f1190a.execSQL(m1801b(str, m1800a(strArr, strArr2, strArr.length)));
        } else if (strArr2.length == 1) {
            this.f1190a.delete(str, strArr[0] + " = ?", strArr2);
        } else {
            this.f1190a.execSQL(m1801b(str, m1800a(strArr, strArr2, strArr2.length)));
        }
        this.f1190a.setTransactionSuccessful();
        this.f1190a.endTransaction();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        try {
            sQLiteDatabase.execSQL("create table if not exists config (id integer primary key,value text)");
            sQLiteDatabase.execSQL("create table if not exists runtime (id integer primary key,value text)");
            sQLiteDatabase.execSQL("create table if not exists message (id integer primary key autoincrement,messageid text,taskid text,appid text,info text,msgextra blob,key text,status integer,createtime integer)");
            sQLiteDatabase.execSQL("create table if not exists ral (id integer primary key,data text,type integer,time integer)");
            sQLiteDatabase.execSQL("create table if not exists ca (pkgname text primary key,signature text,permissions text, accesstoken blob, expire integer)");
            sQLiteDatabase.execSQL("create table if not exists bi(id integer primary key autoincrement, start_service_count integer, login_count integer, loginerror_nonetwork_count integer, loginerror_timeout_count integer, loginerror_connecterror_count integer, loginerror_other_count integer, online_time long, network_time long, running_time long, create_time text, type integer)");
            sQLiteDatabase.execSQL("create table if not exists st(id integer primary key autoincrement,type integer,value blob,time integer)");
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
        C0568g.m2192a().mo4455d(sQLiteDatabase);
        try {
            sQLiteDatabase.execSQL("drop table if exists config");
        } catch (Exception e) {
        }
        try {
            sQLiteDatabase.execSQL("drop table if exists runtime");
        } catch (Exception e2) {
        }
        try {
            sQLiteDatabase.execSQL("drop table if exists message");
        } catch (Exception e3) {
        }
        try {
            sQLiteDatabase.execSQL("drop table if exists ral");
        } catch (Exception e4) {
        }
        try {
            sQLiteDatabase.execSQL("drop table if exists ca");
        } catch (Exception e5) {
        }
        try {
            sQLiteDatabase.execSQL("drop table if exists bi");
        } catch (Exception e6) {
        }
        try {
            sQLiteDatabase.execSQL("drop table if exists st");
        } catch (Exception e7) {
        }
        onCreate(sQLiteDatabase);
    }
}
