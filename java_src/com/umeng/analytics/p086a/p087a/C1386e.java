package com.umeng.analytics.p086a.p087a;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;

/* renamed from: com.umeng.analytics.a.a.e */
/* compiled from: UMCCPathDatabaseContext */
public class C1386e extends ContextWrapper {

    /* renamed from: a */
    private String f3275a;

    public C1386e(Context context, String str) {
        super(context);
        this.f3275a = str;
    }

    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        return SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str).getAbsolutePath(), cursorFactory);
    }

    public File getDatabasePath(String str) {
        File file = new File(this.f3275a + str);
        if (!file.getParentFile().exists() && !file.getParentFile().isDirectory()) {
            file.getParentFile().mkdirs();
        }
        return file;
    }
}
