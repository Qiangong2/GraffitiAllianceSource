package com.wanmei.push.p101db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.wanmei.push.p100d.C1678b;
import java.sql.SQLException;

/* renamed from: com.wanmei.push.db.NoticeDBHelper */
public class NoticeDBHelper extends OrmLiteSqliteOpenHelper {
    public NoticeDBHelper(Context context) {
        super(context, C1678b.m6275a(context) + "notice_1.db", null, 1);
    }

    @Override // com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource) {
        try {
            for (Class<?> cls : C1685c.f4284a) {
                TableUtils.createTable(connectionSource, cls);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource, int i, int i2) {
    }
}
