package com.umeng.analytics.p086a.p087a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.umeng.analytics.a.a.b */
/* compiled from: DatabaseManager */
public class C1372b {

    /* renamed from: c */
    private static C1372b f3235c;

    /* renamed from: d */
    private static SQLiteOpenHelper f3236d;

    /* renamed from: a */
    private AtomicInteger f3237a = new AtomicInteger();

    /* renamed from: b */
    private AtomicInteger f3238b = new AtomicInteger();

    /* renamed from: e */
    private SQLiteDatabase f3239e;

    /* renamed from: b */
    private static synchronized void m5090b(Context context) {
        synchronized (C1372b.class) {
            if (f3235c == null) {
                f3235c = new C1372b();
                f3236d = C1373c.m5095a(context);
            }
        }
    }

    /* renamed from: a */
    public static synchronized C1372b m5089a(Context context) {
        C1372b bVar;
        synchronized (C1372b.class) {
            if (f3235c == null) {
                m5090b(context);
            }
            bVar = f3235c;
        }
        return bVar;
    }

    /* renamed from: a */
    public synchronized SQLiteDatabase mo8407a() {
        if (this.f3237a.incrementAndGet() == 1) {
            this.f3239e = f3236d.getReadableDatabase();
        }
        return this.f3239e;
    }

    /* renamed from: b */
    public synchronized SQLiteDatabase mo8408b() {
        if (this.f3237a.incrementAndGet() == 1) {
            this.f3239e = f3236d.getWritableDatabase();
        }
        return this.f3239e;
    }

    /* renamed from: c */
    public synchronized void mo8409c() {
        if (this.f3237a.decrementAndGet() == 0) {
            this.f3239e.close();
        }
        if (this.f3238b.decrementAndGet() == 0) {
            this.f3239e.close();
        }
    }
}
