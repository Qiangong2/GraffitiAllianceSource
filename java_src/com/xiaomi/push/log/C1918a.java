package com.xiaomi.push.log;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import com.tencent.qcloud.core.util.IOUtils;
import com.xiaomi.channel.commonutils.file.C1851a;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.smack.util.C2046h;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.xiaomi.push.log.a */
class C1918a {

    /* renamed from: b */
    private static String f4929b = "/MiPushLog";
    @SuppressLint({"SimpleDateFormat"})

    /* renamed from: a */
    private final SimpleDateFormat f4930a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: c */
    private String f4931c;

    /* renamed from: d */
    private String f4932d;

    /* renamed from: e */
    private boolean f4933e;

    /* renamed from: f */
    private int f4934f;

    /* renamed from: g */
    private int f4935g = 2097152;

    /* renamed from: h */
    private ArrayList<File> f4936h = new ArrayList<>();

    C1918a() {
    }

    /* renamed from: a */
    private void m7099a(BufferedReader bufferedReader, BufferedWriter bufferedWriter, Pattern pattern) {
        int i;
        boolean z;
        char[] cArr = new char[4096];
        int read = bufferedReader.read(cArr);
        boolean z2 = false;
        while (read != -1 && !z2) {
            String str = new String(cArr, 0, read);
            Matcher matcher = pattern.matcher(str);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i2 >= read || !matcher.find(i2)) {
                    i = read;
                    z = z2;
                } else {
                    i = matcher.start();
                    String substring = str.substring(i, this.f4931c.length() + i);
                    if (this.f4933e) {
                        if (substring.compareTo(this.f4932d) > 0) {
                            z = true;
                            break;
                        }
                    } else if (substring.compareTo(this.f4931c) >= 0) {
                        this.f4933e = true;
                        i3 = i;
                    }
                    int indexOf = str.indexOf(10, i);
                    i2 = indexOf != -1 ? i + indexOf : i + this.f4931c.length();
                }
            }
            i = read;
            z = z2;
            if (this.f4933e) {
                int i4 = i - i3;
                this.f4934f += i4;
                if (z) {
                    bufferedWriter.write(cArr, i3, i4);
                    return;
                }
                bufferedWriter.write(cArr, i3, i4);
                if (this.f4934f > this.f4935g) {
                    return;
                }
            }
            z2 = z;
            read = bufferedReader.read(cArr);
        }
    }

    /* renamed from: b */
    private void m7100b(File file) {
        BufferedWriter bufferedWriter;
        Throwable th;
        IOException e;
        FileNotFoundException e2;
        BufferedReader bufferedReader = null;
        Pattern compile = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("model :").append(Build.MODEL);
                sb.append("; os :").append(Build.VERSION.INCREMENTAL);
                sb.append("; uid :").append(C2046h.m7708b());
                sb.append("; lng :").append(Locale.getDefault().toString());
                sb.append("; sdk :").append(8);
                sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                bufferedWriter.write(sb.toString());
                this.f4934f = 0;
                Iterator<File> it = this.f4936h.iterator();
                while (it.hasNext()) {
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(it.next())));
                        m7099a(bufferedReader, bufferedWriter, compile);
                        bufferedReader.close();
                    } catch (FileNotFoundException e3) {
                        e2 = e3;
                        bufferedReader = bufferedReader;
                        try {
                            AbstractC1855b.m6722c("LOG: filter error = " + e2.getMessage());
                            C1851a.m6706a(bufferedWriter);
                            C1851a.m6705a(bufferedReader);
                        } catch (Throwable th2) {
                            th = th2;
                            C1851a.m6706a(bufferedWriter);
                            C1851a.m6705a(bufferedReader);
                            throw th;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        bufferedReader = bufferedReader;
                        AbstractC1855b.m6722c("LOG: filter error = " + e.getMessage());
                        C1851a.m6706a(bufferedWriter);
                        C1851a.m6705a(bufferedReader);
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = bufferedReader;
                        C1851a.m6706a(bufferedWriter);
                        C1851a.m6705a(bufferedReader);
                        throw th;
                    }
                }
                C1851a.m6706a(bufferedWriter);
                C1851a.m6705a(bufferedReader);
            } catch (FileNotFoundException e5) {
                e2 = e5;
            } catch (IOException e6) {
                e = e6;
                AbstractC1855b.m6722c("LOG: filter error = " + e.getMessage());
                C1851a.m6706a(bufferedWriter);
                C1851a.m6705a(bufferedReader);
            }
        } catch (FileNotFoundException e7) {
            e2 = e7;
            bufferedWriter = null;
            AbstractC1855b.m6722c("LOG: filter error = " + e2.getMessage());
            C1851a.m6706a(bufferedWriter);
            C1851a.m6705a(bufferedReader);
        } catch (IOException e8) {
            e = e8;
            bufferedWriter = null;
            AbstractC1855b.m6722c("LOG: filter error = " + e.getMessage());
            C1851a.m6706a(bufferedWriter);
            C1851a.m6705a(bufferedReader);
        } catch (Throwable th4) {
            th = th4;
            bufferedWriter = null;
            C1851a.m6706a(bufferedWriter);
            C1851a.m6705a(bufferedReader);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1918a mo10303a(File file) {
        if (file.exists()) {
            this.f4936h.add(file);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1918a mo10304a(Date date, Date date2) {
        if (date.after(date2)) {
            this.f4931c = this.f4930a.format(date2);
            this.f4932d = this.f4930a.format(date);
        } else {
            this.f4931c = this.f4930a.format(date);
            this.f4932d = this.f4930a.format(date2);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public File mo10305a(Context context, Date date, Date date2, File file) {
        File file2;
        if ("com.xiaomi.xmsf".equalsIgnoreCase(context.getPackageName())) {
            file2 = context.getFilesDir();
            mo10303a(new File(file2, "xmsf.log.1"));
            mo10303a(new File(file2, "xmsf.log"));
        } else {
            file2 = new File(context.getExternalFilesDir(null) + f4929b);
            mo10303a(new File(file2, "log0.txt"));
            mo10303a(new File(file2, "log1.txt"));
        }
        if (!file2.isDirectory()) {
            return null;
        }
        File file3 = new File(file, date.getTime() + "-" + date2.getTime() + ".zip");
        if (file3.exists()) {
            return null;
        }
        mo10304a(date, date2);
        long currentTimeMillis = System.currentTimeMillis();
        File file4 = new File(file, "log.txt");
        m7100b(file4);
        AbstractC1855b.m6722c("LOG: filter cost = " + (System.currentTimeMillis() - currentTimeMillis));
        if (file4.exists()) {
            long currentTimeMillis2 = System.currentTimeMillis();
            C1851a.m6702a(file3, file4);
            AbstractC1855b.m6722c("LOG: zip cost = " + (System.currentTimeMillis() - currentTimeMillis2));
            file4.delete();
            if (file3.exists()) {
                return file3;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10306a(int i) {
        if (i != 0) {
            this.f4935g = i;
        }
    }
}
