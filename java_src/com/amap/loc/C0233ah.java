package com.amap.loc;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import java.io.IOException;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.amap.loc.ah */
/* compiled from: DB */
public class C0233ah extends SQLiteOpenHelper {

    /* renamed from: a */
    private AbstractC0227ab f286a;

    /* renamed from: com.amap.loc.ah$a */
    /* compiled from: DB */
    public static class C0234a extends ContextWrapper {

        /* renamed from: a */
        private String f287a;

        /* renamed from: b */
        private Context f288b;

        public C0234a(Context context, String str) {
            super(context);
            this.f287a = str;
            this.f288b = context;
        }

        public File getDatabasePath(String str) {
            try {
                String str2 = this.f287a + MqttTopic.TOPIC_LEVEL_SEPARATOR + str;
                File file = new File(this.f287a);
                if (!file.exists()) {
                    file.mkdirs();
                }
                boolean z = false;
                File file2 = new File(str2);
                if (!file2.exists()) {
                    try {
                        z = file2.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    z = true;
                }
                if (z) {
                    return file2;
                }
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
            SQLiteDatabase sQLiteDatabase;
            if (getDatabasePath(str) != null) {
                try {
                    sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), (SQLiteDatabase.CursorFactory) null);
                } catch (Throwable th) {
                    th.printStackTrace();
                    sQLiteDatabase = null;
                }
                if (sQLiteDatabase != null) {
                    return sQLiteDatabase;
                }
            }
            return SQLiteDatabase.openOrCreateDatabase(this.f288b.getDatabasePath(str), (SQLiteDatabase.CursorFactory) null);
        }

        public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
            SQLiteDatabase sQLiteDatabase;
            if (getDatabasePath(str) != null) {
                try {
                    sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), (SQLiteDatabase.CursorFactory) null);
                } catch (Throwable th) {
                    th.printStackTrace();
                    sQLiteDatabase = null;
                }
                if (sQLiteDatabase != null) {
                    return sQLiteDatabase;
                }
            }
            return SQLiteDatabase.openOrCreateDatabase(this.f288b.getDatabasePath(str), (SQLiteDatabase.CursorFactory) null);
        }
    }

    public C0233ah(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, AbstractC0227ab abVar) {
        super(context, str, cursorFactory, i);
        this.f286a = abVar;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.f286a.mo3640a(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.f286a.mo3641a(sQLiteDatabase, i, i2);
    }
}
