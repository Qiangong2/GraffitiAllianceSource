package com.amap.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.amap.loc.C0249av;
import com.amap.loc.C0256az;
import com.amap.loc.C0278bh;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.List;

/* renamed from: com.amap.loc.ap */
/* compiled from: DexDownLoad */
public class C0242ap extends Thread implements C0278bh.AbstractC0279a {

    /* renamed from: a */
    private C0243aq f301a;

    /* renamed from: b */
    private C0278bh f302b;

    /* renamed from: c */
    private C0360q f303c;

    /* renamed from: d */
    private String f304d;

    /* renamed from: e */
    private RandomAccessFile f305e;

    /* renamed from: f */
    private Context f306f;

    public C0242ap(Context context, C0243aq aqVar, C0360q qVar) {
        try {
            this.f306f = context.getApplicationContext();
            this.f303c = qVar;
            if (aqVar != null) {
                this.f301a = aqVar;
                this.f302b = new C0278bh(new C0248au(this.f301a));
                this.f304d = C0249av.m554a(context, this.f301a.f307a);
            }
        } catch (Throwable th) {
            C0263ba.m657a(th, "dDownLoad", "DexDownLoad()");
        }
    }

    /* renamed from: a */
    private void m518a(Context context, String str) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.clear();
            edit.commit();
        } catch (Throwable th) {
            C0263ba.m657a(th, "dDownLoad", "clearMarker()");
        }
    }

    /* renamed from: a */
    private void m519a(String str) {
        String c = this.f301a.mo3691c();
        C0228ac acVar = new C0228ac(this.f306f, C0255ay.m585c());
        C0249av.C0251a.m570a(acVar, new C0256az.C0257a(this.f301a.f307a, str, this.f301a.f308b, c, this.f301a.f310d).mo3712a("copy").mo3713a(), C0256az.m592a(this.f301a.f307a, this.f301a.f308b, c, this.f301a.f310d));
        m518a(this.f306f, this.f301a.f308b);
        try {
            C0249av.m557a(this.f306f, acVar, this.f303c, this.f304d, this.f301a.f310d);
            C0249av.m559a(this.f306f, this.f303c);
        } catch (Throwable th) {
            C0263ba.m657a(th, "dDownLoad", "onFinish1");
        }
    }

    /* renamed from: a */
    private boolean m520a(Context context) {
        return C0353l.m1280m(context) == 1;
    }

    /* renamed from: a */
    private boolean m521a(C0228ac acVar) {
        try {
            List<C0256az> a = C0249av.C0251a.m569a(acVar, this.f301a.f308b, "used");
            if (a != null && a.size() > 0 && C0263ba.m654a(a.get(0).mo3710d(), this.f301a.f310d) > 0) {
                return true;
            }
        } catch (Throwable th) {
            C0263ba.m657a(th, "dDownLoad", "isUsed()");
        }
        return false;
    }

    /* renamed from: a */
    private boolean m522a(C0228ac acVar, C0256az azVar, C0243aq aqVar) {
        String str = aqVar.f308b;
        String str2 = aqVar.f309c;
        String str3 = aqVar.f310d;
        String str4 = aqVar.f311e;
        if ("errorstatus".equals(azVar.mo3711e())) {
            m523b(acVar);
            return true;
        } else if (!new File(this.f304d).exists()) {
            return false;
        } else {
            List b = acVar.mo3650b(C0256az.m592a(C0249av.m555a(this.f306f, str, str2), str, str2, str3), C0256az.class);
            if (b != null && b.size() > 0) {
                return true;
            }
            try {
                C0249av.m555a(this.f306f, str, this.f303c.mo3941b());
                C0249av.m557a(this.f306f, acVar, this.f303c, this.f304d, str3);
                C0249av.m559a(this.f306f, this.f303c);
                return true;
            } catch (Throwable th) {
                C0263ba.m657a(th, "dDownLoad", "processDownloadedFile()");
                return true;
            }
        }
    }

    /* renamed from: b */
    private void m523b(C0228ac acVar) {
        if (!new File(C0249av.m563b(this.f306f, this.f303c.mo3939a(), this.f303c.mo3941b())).exists() && !TextUtils.isEmpty(C0249av.m553a(this.f306f, acVar, this.f303c))) {
            try {
                C0249av.m559a(this.f306f, this.f303c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: e */
    private boolean m524e() {
        C0228ac acVar = new C0228ac(this.f306f, C0255ay.m585c());
        if (m521a(acVar)) {
            return true;
        }
        C0256az a = C0249av.C0251a.m568a(acVar, this.f301a.f307a);
        if (a != null) {
            return m522a(acVar, a, this.f301a);
        }
        return false;
    }

    /* renamed from: f */
    private boolean m525f() {
        return this.f303c != null && this.f303c.mo3939a().equals(this.f301a.f308b) && this.f303c.mo3941b().equals(this.f301a.f309c);
    }

    /* renamed from: g */
    private boolean m526g() {
        return Build.VERSION.SDK_INT >= this.f301a.f313g && Build.VERSION.SDK_INT <= this.f301a.f312f;
    }

    /* renamed from: a */
    public void mo3682a() {
        try {
            start();
        } catch (Throwable th) {
            C0263ba.m657a(th, "dDownLoad", "startDownload()");
        }
    }

    @Override // com.amap.loc.C0278bh.AbstractC0279a
    /* renamed from: a */
    public void mo3683a(Throwable th) {
        C0263ba.m656a(this.f305e);
    }

    @Override // com.amap.loc.C0278bh.AbstractC0279a
    /* renamed from: a */
    public void mo3684a(byte[] bArr, long j) {
        try {
            if (this.f305e == null) {
                File file = new File(this.f304d);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.f305e = new RandomAccessFile(file, "rw");
            }
            this.f305e.seek(j);
            this.f305e.write(bArr);
        } catch (Throwable th) {
            C0263ba.m657a(th, "dDownLoad", "onDownload()");
        }
    }

    @Override // com.amap.loc.C0278bh.AbstractC0279a
    /* renamed from: b */
    public void mo3685b() {
    }

    @Override // com.amap.loc.C0278bh.AbstractC0279a
    /* renamed from: c */
    public void mo3686c() {
        try {
            if (this.f305e != null) {
                C0263ba.m656a(this.f305e);
                String b = this.f301a.mo3690b();
                if (C0263ba.m661b(this.f304d, b)) {
                    m519a(b);
                    C0288bo boVar = new C0288bo(this.f306f, this.f303c.mo3939a(), this.f303c.mo3941b(), "O008");
                    boVar.mo3774a("{\"param_int_first\":1}");
                    C0289bp.m780a(boVar, this.f306f);
                    return;
                }
                new File(this.f304d).delete();
            }
        } catch (Throwable th) {
            C0263ba.m657a(th, "dDownLoad", "onFinish()");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo3687d() {
        try {
            if (!m525f() || !m526g() || !m520a(this.f306f) || m524e()) {
                return false;
            }
            C0249av.m565b(this.f306f, this.f303c.mo3939a());
            return true;
        } catch (Throwable th) {
            C0263ba.m657a(th, "dDownLoad", "isNeedDownload()");
            return false;
        }
    }

    public void run() {
        try {
            if (mo3687d()) {
                C0288bo boVar = new C0288bo(this.f306f, this.f303c.mo3939a(), this.f303c.mo3941b(), "O008");
                boVar.mo3774a("{\"param_int_first\":0}");
                C0289bp.m780a(boVar, this.f306f);
                this.f302b.mo3759a(this);
            }
        } catch (Throwable th) {
            C0263ba.m657a(th, "dDownLoad", "run()");
        }
    }
}
