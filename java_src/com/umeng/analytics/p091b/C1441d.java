package com.umeng.analytics.p091b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* access modifiers changed from: package-private */
/* renamed from: com.umeng.analytics.b.d */
/* compiled from: UMDBManager */
public class C1441d {

    /* renamed from: c */
    private static C1441d f3417c;

    /* renamed from: d */
    private static SQLiteOpenHelper f3418d;

    /* renamed from: a */
    private AtomicInteger f3419a = new AtomicInteger();

    /* renamed from: b */
    private AtomicInteger f3420b = new AtomicInteger();

    /* renamed from: e */
    private SQLiteDatabase f3421e;

    C1441d() {
    }

    /* renamed from: b */
    private static synchronized void m5310b(Context context) {
        synchronized (C1441d.class) {
            if (f3417c == null) {
                f3417c = new C1441d();
                f3418d = C1438c.m5303a(context);
            }
        }
    }

    /* renamed from: a */
    public static synchronized C1441d m5309a(Context context) {
        C1441d dVar;
        synchronized (C1441d.class) {
            if (f3417c == null) {
                m5310b(context);
            }
            dVar = f3417c;
        }
        return dVar;
    }

    /* renamed from: a */
    public synchronized SQLiteDatabase mo8536a() {
        if (this.f3419a.incrementAndGet() == 1) {
            this.f3421e = f3418d.getWritableDatabase();
        }
        return this.f3421e;
    }

    /* renamed from: b */
    public synchronized void mo8537b() {
        if (this.f3419a.decrementAndGet() == 0) {
            this.f3421e.close();
        }
        if (this.f3420b.decrementAndGet() == 0) {
            this.f3421e.close();
        }
    }
}
