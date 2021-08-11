package com.xiaomi.push.providers;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.analytics.p091b.C1447g;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.mipush.sdk.MiPushClient;

/* renamed from: com.xiaomi.push.providers.a */
public class C1932a extends SQLiteOpenHelper {

    /* renamed from: a */
    public static final Object f4988a = new Object();

    /* renamed from: b */
    private static int f4989b = 1;

    /* renamed from: c */
    private static final String[] f4990c = {C1447g.f3510e, "TEXT", "message_ts", " LONG DEFAULT 0 ", "bytes", " LONG DEFAULT 0 ", "network_type", " INT DEFAULT -1 ", "rcv", " INT DEFAULT -1 ", "imsi", "TEXT"};

    public C1932a(Context context) {
        super(context, "traffic.db", (SQLiteDatabase.CursorFactory) null, f4989b);
    }

    /* renamed from: a */
    private void m7171a(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder("CREATE TABLE traffic(_id INTEGER  PRIMARY KEY ,");
        for (int i = 0; i < f4990c.length - 1; i += 2) {
            if (i != 0) {
                sb.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
            }
            sb.append(f4990c[i]).append(" ").append(f4990c[i + 1]);
        }
        sb.append(");");
        sQLiteDatabase.execSQL(sb.toString());
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        synchronized (f4988a) {
            try {
                m7171a(sQLiteDatabase);
            } catch (SQLException e) {
                AbstractC1855b.m6720a(e);
            }
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
