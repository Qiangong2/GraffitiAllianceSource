package com.amap.loc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.amap.loc.C0278bh;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;

/* renamed from: com.amap.loc.p */
/* compiled from: SDKCoordinatorDownload */
public class C0358p extends Thread implements C0278bh.AbstractC0279a {

    /* renamed from: h */
    private static String f889h = "sodownload";

    /* renamed from: i */
    private static String f890i = "sofail";

    /* renamed from: a */
    private C0278bh f891a = new C0278bh(this.f892b);

    /* renamed from: b */
    private C0359a f892b;

    /* renamed from: c */
    private RandomAccessFile f893c;

    /* renamed from: d */
    private String f894d;

    /* renamed from: e */
    private String f895e;

    /* renamed from: f */
    private String f896f;

    /* renamed from: g */
    private Context f897g;

    /* renamed from: com.amap.loc.p$a */
    /* compiled from: SDKCoordinatorDownload */
    private static class C0359a extends AbstractC0283bk {

        /* renamed from: a */
        private String f898a;

        C0359a(String str) {
            this.f898a = str;
        }

        @Override // com.amap.loc.AbstractC0283bk
        /* renamed from: a */
        public Map<String, String> mo3696a() {
            return null;
        }

        @Override // com.amap.loc.AbstractC0283bk
        /* renamed from: b */
        public String mo3697b() {
            return this.f898a;
        }

        @Override // com.amap.loc.AbstractC0283bk
        /* renamed from: c */
        public Map<String, String> mo3698c() {
            return null;
        }
    }

    public C0358p(Context context, String str, String str2, String str3) {
        this.f897g = context;
        this.f896f = str3;
        this.f894d = m1319a(context, str + "temp.so");
        this.f895e = m1319a(context, "libwgs2gcj.so");
        this.f892b = new C0359a(str2);
    }

    /* renamed from: a */
    public static String m1319a(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + File.separator + "libso" + File.separator + str;
    }

    /* renamed from: b */
    private static String m1320b(Context context, String str) {
        return m1319a(context, str);
    }

    /* renamed from: d */
    private void m1321d() {
        File file = new File(this.f894d);
        if (file.exists()) {
            file.delete();
        }
    }

    /* renamed from: a */
    public void mo3937a() {
        if (this.f892b != null && !TextUtils.isEmpty(this.f892b.mo3697b()) && this.f892b.mo3697b().contains("libJni_wgs2gcj.so") && this.f892b.mo3697b().contains(Build.CPU_ABI) && !new File(this.f895e).exists()) {
            start();
        }
    }

    @Override // com.amap.loc.C0278bh.AbstractC0279a
    /* renamed from: a */
    public void mo3683a(Throwable th) {
        try {
            if (this.f893c != null) {
                this.f893c.close();
            }
            m1321d();
            File file = new File(m1320b(this.f897g, "tempfile"));
            if (!file.exists()) {
                try {
                    File parentFile = file.getParentFile();
                    if (!parentFile.exists()) {
                        parentFile.mkdir();
                    }
                    file.createNewFile();
                } catch (Throwable th2) {
                    C0365t.m1372a(th2, "SDKCoordinatorDownload", "onException");
                }
            }
        } catch (Throwable th3) {
            C0365t.m1372a(th3, "SDKCoordinatorDownload", "onException");
        }
    }

    @Override // com.amap.loc.C0278bh.AbstractC0279a
    /* renamed from: a */
    public void mo3684a(byte[] bArr, long j) {
        try {
            if (this.f893c == null) {
                File file = new File(this.f894d);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                try {
                    this.f893c = new RandomAccessFile(file, "rw");
                } catch (FileNotFoundException e) {
                    C0365t.m1372a(e, "SDKCoordinatorDownload", "onDownload");
                    m1321d();
                }
            }
            if (this.f893c != null) {
                try {
                    this.f893c.seek(j);
                    this.f893c.write(bArr);
                } catch (IOException e2) {
                    m1321d();
                    C0365t.m1372a(e2, "SDKCoordinatorDownload", "onDownload");
                }
            }
        } catch (Throwable th) {
            m1321d();
            C0365t.m1372a(th, "SDKCoordinatorDownload", "onDownload");
        }
    }

    @Override // com.amap.loc.C0278bh.AbstractC0279a
    /* renamed from: b */
    public void mo3685b() {
        m1321d();
    }

    @Override // com.amap.loc.C0278bh.AbstractC0279a
    /* renamed from: c */
    public void mo3686c() {
        try {
            if (this.f893c != null) {
                this.f893c.close();
            }
            String a = C0356n.m1302a(this.f894d);
            if (a == null || !a.equalsIgnoreCase(this.f896f)) {
                m1321d();
            } else if (new File(this.f895e).exists()) {
                m1321d();
            } else {
                new File(this.f894d).renameTo(new File(this.f895e));
            }
        } catch (Throwable th) {
            m1321d();
            File file = new File(this.f895e);
            if (file.exists()) {
                file.delete();
            }
            C0365t.m1372a(th, "SDKCoordinatorDownload", "onFinish");
        }
    }

    public void run() {
        try {
            File file = new File(m1320b(this.f897g, "tempfile"));
            if (file.exists()) {
                file.delete();
            }
            this.f891a.mo3759a(this);
        } catch (Throwable th) {
            C0365t.m1372a(th, "SDKCoordinatorDownload", "run");
            m1321d();
        }
    }
}
