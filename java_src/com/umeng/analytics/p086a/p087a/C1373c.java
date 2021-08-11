package com.umeng.analytics.p086a.p087a;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.p085a.C1346h;

/* access modifiers changed from: package-private */
/* renamed from: com.umeng.analytics.a.a.c */
/* compiled from: UMCCDBHelper */
public class C1373c extends SQLiteOpenHelper {

    /* renamed from: b */
    private static Context f3240b;

    /* renamed from: a */
    private String f3241a;

    /* renamed from: com.umeng.analytics.a.a.c$a */
    /* compiled from: UMCCDBHelper */
    private static class C1375a {

        /* renamed from: a */
        private static final C1373c f3242a = new C1373c(C1373c.f3240b, C1376d.m5102a(C1373c.f3240b), C1376d.f3245c, null, 1);

        private C1375a() {
        }
    }

    /* renamed from: a */
    public static synchronized C1373c m5095a(Context context) {
        C1373c cVar;
        synchronized (C1373c.class) {
            f3240b = context;
            cVar = C1375a.f3242a;
        }
        return cVar;
    }

    private C1373c(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        this(new C1386e(context, str), str2, cursorFactory, i);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private C1373c(android.content.Context r2, java.lang.String r3, android.database.sqlite.SQLiteDatabase.CursorFactory r4, int r5) {
        /*
            r1 = this;
            if (r3 == 0) goto L_0x000a
            java.lang.String r0 = ""
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x000c
        L_0x000a:
            java.lang.String r3 = "cc.db"
        L_0x000c:
            r1.<init>(r2, r3, r4, r5)
            r1.m5097b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.p086a.p087a.C1373c.<init>(android.content.Context, java.lang.String, android.database.sqlite.SQLiteDatabase$CursorFactory, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5097b() {
        /*
            r2 = this;
            android.database.sqlite.SQLiteDatabase r0 = r2.getWritableDatabase()     // Catch:{ Exception -> 0x0030, all -> 0x002e }
            java.lang.String r1 = "aggregated"
            boolean r1 = r2.mo8410a(r1, r0)     // Catch:{ Exception -> 0x0030, all -> 0x002e }
            if (r1 == 0) goto L_0x0014
            java.lang.String r1 = "aggregated_cache"
            boolean r1 = r2.mo8410a(r1, r0)     // Catch:{ Exception -> 0x0030, all -> 0x002e }
            if (r1 != 0) goto L_0x0017
        L_0x0014:
            r2.m5099c(r0)     // Catch:{ Exception -> 0x0030, all -> 0x002e }
        L_0x0017:
            java.lang.String r1 = "system"
            boolean r1 = r2.mo8410a(r1, r0)     // Catch:{ Exception -> 0x0030, all -> 0x002e }
            if (r1 != 0) goto L_0x0022
            r2.m5098b(r0)     // Catch:{ Exception -> 0x0030, all -> 0x002e }
        L_0x0022:
            java.lang.String r1 = "limitedck"
            boolean r1 = r2.mo8410a(r1, r0)     // Catch:{ Exception -> 0x0030, all -> 0x002e }
            if (r1 != 0) goto L_0x002d
            r2.m5096a(r0)     // Catch:{ Exception -> 0x0030, all -> 0x002e }
        L_0x002d:
            return
        L_0x002e:
            r0 = move-exception
            throw r0
        L_0x0030:
            r0 = move-exception
            goto L_0x002d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.p086a.p087a.C1373c.m5097b():void");
    }

    /* renamed from: a */
    public boolean mo8410a(String str, SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        boolean z = false;
        if (str != null) {
            try {
                Cursor rawQuery = sQLiteDatabase.rawQuery("select count(*) as c from sqlite_master where type ='table' and name ='" + str.trim() + "' ", null);
                if (rawQuery.moveToNext() && rawQuery.getInt(0) > 0) {
                    z = true;
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (Exception e) {
                if (0 != 0) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }
        return z;
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            m5099c(sQLiteDatabase);
            m5098b(sQLiteDatabase);
            m5096a(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* renamed from: a */
    private boolean m5096a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f3241a = "create table if not exists limitedck(Id INTEGER primary key autoincrement, ck TEXT unique)";
            sQLiteDatabase.execSQL(this.f3241a);
            return true;
        } catch (SQLException e) {
            C1346h.m5009e("create reference table error!");
            return false;
        }
    }

    /* renamed from: b */
    private boolean m5098b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f3241a = "create table if not exists system(Id INTEGER primary key autoincrement, key TEXT, timeStamp INTEGER, count INTEGER)";
            sQLiteDatabase.execSQL(this.f3241a);
            return true;
        } catch (SQLException e) {
            C1346h.m5009e("create system table error!");
            return false;
        }
    }

    /* renamed from: c */
    private boolean m5099c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f3241a = "create table if not exists aggregated_cache(Id INTEGER primary key autoincrement, key TEXT, totalTimestamp TEXT, value INTEGER, count INTEGER, label TEXT, timeWindowNum TEXT)";
            sQLiteDatabase.execSQL(this.f3241a);
            this.f3241a = "create table if not exists aggregated(Id INTEGER primary key autoincrement, key TEXT, totalTimestamp TEXT, value INTEGER, count INTEGER, label TEXT, timeWindowNum TEXT)";
            sQLiteDatabase.execSQL(this.f3241a);
            return true;
        } catch (SQLException e) {
            C1346h.m5009e("create aggregated table error!");
            return false;
        }
    }
}
