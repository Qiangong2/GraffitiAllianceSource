package com.wanmei.sdk.core.log.p105a;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.wanmei.sdk.core.log.a.b */
public class C1761b {

    /* renamed from: a */
    private static String f4447a = null;

    /* renamed from: b */
    private static String f4448b = null;

    /* renamed from: a */
    public static File m6489a(Context context) {
        return C1760a.m6480a(context, "log");
    }

    /* renamed from: b */
    public static String m6490b(Context context) {
        if (TextUtils.isEmpty(f4447a)) {
            f4447a = new File(C1760a.m6480a(context, "log"), "log_" + new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()) + ".txt").getAbsolutePath();
        }
        return f4447a;
    }

    /* renamed from: c */
    public static String m6491c(Context context) {
        if (TextUtils.isEmpty(f4448b)) {
            f4448b = new File(C1760a.m6480a(context, "crash"), "crash_" + new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()) + ".txt").getAbsolutePath();
        }
        return f4448b;
    }
}
