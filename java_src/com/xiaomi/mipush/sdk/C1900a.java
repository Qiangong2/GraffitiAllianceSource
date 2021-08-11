package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.wanmei.push.bean.AppState;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.push.service.C1968f;

/* renamed from: com.xiaomi.mipush.sdk.a */
public class C1900a {

    /* renamed from: a */
    private static C1900a f4852a;

    /* renamed from: b */
    private Context f4853b;

    /* renamed from: c */
    private C1902a f4854c;

    /* access modifiers changed from: private */
    /* renamed from: com.xiaomi.mipush.sdk.a$a */
    public class C1902a {

        /* renamed from: a */
        public String f4855a;

        /* renamed from: b */
        public String f4856b;

        /* renamed from: c */
        public String f4857c;

        /* renamed from: d */
        public String f4858d;

        /* renamed from: e */
        public String f4859e;

        /* renamed from: f */
        public String f4860f;

        /* renamed from: g */
        public String f4861g;

        /* renamed from: h */
        public boolean f4862h;

        /* renamed from: i */
        public boolean f4863i;

        /* renamed from: j */
        public int f4864j;

        private C1902a() {
            this.f4862h = true;
            this.f4863i = false;
            this.f4864j = 1;
        }

        /* renamed from: d */
        private String m6972d() {
            return C1900a.m6950a(C1900a.this.f4853b, C1900a.this.f4853b.getPackageName());
        }

        /* renamed from: a */
        public void mo10188a(int i) {
            this.f4864j = i;
        }

        /* renamed from: a */
        public void mo10189a(String str, String str2) {
            this.f4857c = str;
            this.f4858d = str2;
            this.f4860f = C1968f.m7324c(C1900a.this.f4853b);
            this.f4859e = m6972d();
            this.f4862h = true;
            SharedPreferences.Editor edit = C1900a.this.mo10183j().edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f4860f);
            edit.putString("vName", m6972d());
            edit.putBoolean("valid", true);
            edit.commit();
        }

        /* renamed from: a */
        public void mo10190a(String str, String str2, String str3) {
            this.f4855a = str;
            this.f4856b = str2;
            this.f4861g = str3;
            SharedPreferences.Editor edit = C1900a.this.mo10183j().edit();
            edit.putString(AppState.APP_ID, this.f4855a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        /* renamed from: a */
        public void mo10191a(boolean z) {
            this.f4863i = z;
        }

        /* renamed from: a */
        public boolean mo10192a() {
            return mo10194b(this.f4855a, this.f4856b);
        }

        /* renamed from: b */
        public void mo10193b() {
            C1900a.this.mo10183j().edit().clear().commit();
            this.f4855a = null;
            this.f4856b = null;
            this.f4857c = null;
            this.f4858d = null;
            this.f4860f = null;
            this.f4859e = null;
            this.f4862h = false;
            this.f4863i = false;
            this.f4864j = 1;
        }

        /* renamed from: b */
        public boolean mo10194b(String str, String str2) {
            return TextUtils.equals(this.f4855a, str) && TextUtils.equals(this.f4856b, str2) && !TextUtils.isEmpty(this.f4857c) && !TextUtils.isEmpty(this.f4858d) && TextUtils.equals(this.f4860f, C1968f.m7324c(C1900a.this.f4853b));
        }

        /* renamed from: c */
        public void mo10195c() {
            this.f4862h = false;
            C1900a.this.mo10183j().edit().putBoolean("valid", this.f4862h).commit();
        }
    }

    private C1900a(Context context) {
        this.f4853b = context;
        m6951o();
    }

    /* renamed from: a */
    public static C1900a m6949a(Context context) {
        if (f4852a == null) {
            f4852a = new C1900a(context);
        }
        return f4852a;
    }

    /* renamed from: a */
    public static String m6950a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception e) {
            AbstractC1855b.m6720a(e);
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.versionName : "1.0";
    }

    /* renamed from: o */
    private void m6951o() {
        this.f4854c = new C1902a();
        SharedPreferences j = mo10183j();
        this.f4854c.f4855a = j.getString(AppState.APP_ID, null);
        this.f4854c.f4856b = j.getString("appToken", null);
        this.f4854c.f4857c = j.getString("regId", null);
        this.f4854c.f4858d = j.getString("regSec", null);
        this.f4854c.f4860f = j.getString("devId", null);
        if (!TextUtils.isEmpty(this.f4854c.f4860f) && this.f4854c.f4860f.startsWith("a-")) {
            this.f4854c.f4860f = C1968f.m7324c(this.f4853b);
            j.edit().putString("devId", this.f4854c.f4860f).commit();
        }
        this.f4854c.f4859e = j.getString("vName", null);
        this.f4854c.f4862h = j.getBoolean("valid", true);
        this.f4854c.f4863i = j.getBoolean("paused", false);
        this.f4854c.f4864j = j.getInt("envType", 1);
        this.f4854c.f4861g = j.getString("regResource", null);
    }

    /* renamed from: a */
    public void mo10168a(int i) {
        this.f4854c.mo10188a(i);
        mo10183j().edit().putInt("envType", i).commit();
    }

    /* renamed from: a */
    public void mo10169a(String str) {
        SharedPreferences.Editor edit = mo10183j().edit();
        edit.putString("vName", str);
        edit.commit();
        this.f4854c.f4859e = str;
    }

    /* renamed from: a */
    public void mo10170a(String str, String str2, String str3) {
        this.f4854c.mo10190a(str, str2, str3);
    }

    /* renamed from: a */
    public void mo10171a(boolean z) {
        this.f4854c.mo10191a(z);
        mo10183j().edit().putBoolean("paused", z).commit();
    }

    /* renamed from: a */
    public boolean mo10172a() {
        return !TextUtils.equals(m6950a(this.f4853b, this.f4853b.getPackageName()), this.f4854c.f4859e);
    }

    /* renamed from: a */
    public boolean mo10173a(String str, String str2) {
        return this.f4854c.mo10194b(str, str2);
    }

    /* renamed from: b */
    public void mo10174b(String str, String str2) {
        this.f4854c.mo10189a(str, str2);
    }

    /* renamed from: b */
    public boolean mo10175b() {
        if (this.f4854c.mo10192a()) {
            return true;
        }
        AbstractC1855b.m6718a("Don't send message before initialization succeeded!");
        return false;
    }

    /* renamed from: c */
    public String mo10176c() {
        return this.f4854c.f4855a;
    }

    /* renamed from: d */
    public String mo10177d() {
        return this.f4854c.f4856b;
    }

    /* renamed from: e */
    public String mo10178e() {
        return this.f4854c.f4857c;
    }

    /* renamed from: f */
    public String mo10179f() {
        return this.f4854c.f4858d;
    }

    /* renamed from: g */
    public String mo10180g() {
        return this.f4854c.f4861g;
    }

    /* renamed from: h */
    public void mo10181h() {
        this.f4854c.mo10193b();
    }

    /* renamed from: i */
    public boolean mo10182i() {
        return this.f4854c.mo10192a();
    }

    /* renamed from: j */
    public SharedPreferences mo10183j() {
        return this.f4853b.getSharedPreferences("mipush", 0);
    }

    /* renamed from: k */
    public void mo10184k() {
        this.f4854c.mo10195c();
    }

    /* renamed from: l */
    public boolean mo10185l() {
        return this.f4854c.f4863i;
    }

    /* renamed from: m */
    public int mo10186m() {
        return this.f4854c.f4864j;
    }

    /* renamed from: n */
    public boolean mo10187n() {
        return !this.f4854c.f4862h;
    }
}
