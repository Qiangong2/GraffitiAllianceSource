package com.wanmei.push.service;

import android.os.Environment;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.wanmei.push.service.c */
public final class C1745c {

    /* renamed from: a */
    private static final SimpleDateFormat f4421a = new SimpleDateFormat("[HH:mm:ss] ");

    /* renamed from: b */
    private String f4422b;

    /* renamed from: c */
    private Writer f4423c;

    public C1745c() throws IOException {
        File file = new File(Environment.getExternalStorageDirectory(), "perfectPush/push/log/");
        if (!file.exists()) {
            file.mkdirs();
            new File(file, ".nomedia").createNewFile();
        }
        this.f4422b = new File((file.getAbsolutePath() + "/push.log") + "-" + new SimpleDateFormat("yyyyMMdd-hhmmss").format(new Date(new Date().getTime()))).getAbsolutePath();
        this.f4423c = new BufferedWriter(new FileWriter(this.f4422b), 2048);
        mo9440a("Opened log.");
    }

    /* renamed from: a */
    public static boolean m6464a() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    /* renamed from: a */
    public final void mo9440a(String str) throws IOException {
        if (this.f4423c != null) {
            this.f4423c.write(f4421a.format(new Date()));
            this.f4423c.write(str);
            this.f4423c.write(10);
            this.f4423c.flush();
        }
    }

    /* renamed from: b */
    public final String mo9441b() {
        return this.f4422b;
    }

    /* renamed from: c */
    public final void mo9442c() throws IOException {
        this.f4423c.close();
        this.f4423c = null;
    }
}
