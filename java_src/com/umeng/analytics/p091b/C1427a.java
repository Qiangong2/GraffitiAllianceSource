package com.umeng.analytics.p091b;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;

/* renamed from: com.umeng.analytics.b.a */
/* compiled from: UMDBCreater */
class C1427a extends ContextWrapper {

    /* renamed from: a */
    private String f3374a;

    public C1427a(Context context, String str) {
        super(context);
        this.f3374a = str;
    }

    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        return SQLiteDatabase.openDatabase(getDatabasePath(str).getAbsolutePath(), cursorFactory, 268435472);
    }

    public File getDatabasePath(String str) {
        File file = new File(this.f3374a + str);
        if (!file.getParentFile().exists() && !file.getParentFile().isDirectory()) {
            file.getParentFile().mkdirs();
        }
        return file;
    }
}
