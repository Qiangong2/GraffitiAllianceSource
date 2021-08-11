package com.xiaomi.channel.commonutils.file;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;

/* renamed from: com.xiaomi.channel.commonutils.file.c */
public class C1853c {
    /* renamed from: a */
    public static boolean m6708a() {
        return Environment.getExternalStorageState().equals("removed");
    }

    /* renamed from: b */
    public static boolean m6709b() {
        return !Environment.getExternalStorageState().equals("mounted");
    }

    /* renamed from: c */
    public static boolean m6710c() {
        return m6712e() <= 102400;
    }

    /* renamed from: d */
    public static boolean m6711d() {
        return !m6709b() && !m6710c() && !m6708a();
    }

    /* renamed from: e */
    public static long m6712e() {
        File externalStorageDirectory;
        if (m6709b() || (externalStorageDirectory = Environment.getExternalStorageDirectory()) == null || TextUtils.isEmpty(externalStorageDirectory.getPath())) {
            return 0;
        }
        StatFs statFs = new StatFs(externalStorageDirectory.getPath());
        return (((long) statFs.getAvailableBlocks()) - 4) * ((long) statFs.getBlockSize());
    }
}
