package com.umeng.analytics.p091b;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.analytics.p091b.C1428b;

/* access modifiers changed from: package-private */
/* renamed from: com.umeng.analytics.b.c */
/* compiled from: UMDBCreater */
public class C1438c extends SQLiteOpenHelper {

    /* renamed from: b */
    private static Context f3414b = null;

    /* renamed from: a */
    private String f3415a;

    /* renamed from: com.umeng.analytics.b.c$a */
    /* compiled from: UMDBCreater */
    private static class C1440a {

        /* renamed from: a */
        private static final C1438c f3416a = new C1438c(C1438c.f3414b, C1442e.m5313a(C1438c.f3414b), C1428b.f3377c, null, 1);

        private C1440a() {
        }
    }

    /* renamed from: a */
    public static synchronized C1438c m5303a(Context context) {
        C1438c cVar;
        synchronized (C1438c.class) {
            f3414b = context;
            cVar = C1440a.f3416a;
        }
        return cVar;
    }

    private C1438c(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        this(new C1427a(context, str), str2, cursorFactory, i);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private C1438c(android.content.Context r2, java.lang.String r3, android.database.sqlite.SQLiteDatabase.CursorFactory r4, int r5) {
        /*
            r1 = this;
            if (r3 == 0) goto L_0x000a
            java.lang.String r0 = ""
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x000c
        L_0x000a:
            java.lang.String r3 = "ua.db"
        L_0x000c:
            r1.<init>(r2, r3, r4, r5)
            r0 = 0
            r1.f3415a = r0
            r1.m5305b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.p091b.C1438c.<init>(android.content.Context, java.lang.String, android.database.sqlite.SQLiteDatabase$CursorFactory, int):void");
    }

    /* renamed from: b */
    private void m5305b() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!C1442e.m5316a(C1428b.C1435c.f3397a, writableDatabase)) {
                m5307c(writableDatabase);
            }
            if (!C1442e.m5316a(C1428b.C1432b.f3388a, writableDatabase)) {
                m5306b(writableDatabase);
            }
            if (!C1442e.m5316a(C1428b.C1429a.f3381a, writableDatabase)) {
                m5304a(writableDatabase);
            }
        } catch (Exception e) {
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.beginTransaction();
            m5307c(sQLiteDatabase);
            m5306b(sQLiteDatabase);
            m5304a(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* renamed from: a */
    private void m5304a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f3415a = "create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER)";
            sQLiteDatabase.execSQL(this.f3415a);
        } catch (SQLException e) {
        }
    }

    /* renamed from: b */
    private void m5306b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f3415a = "create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER)";
            sQLiteDatabase.execSQL(this.f3415a);
        } catch (SQLException e) {
        }
    }

    /* renamed from: c */
    private void m5307c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f3415a = "create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT)";
            sQLiteDatabase.execSQL(this.f3415a);
        } catch (SQLException e) {
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
