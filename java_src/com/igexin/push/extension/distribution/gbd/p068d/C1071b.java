package com.igexin.push.extension.distribution.gbd.p068d;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.net.wifi.WifiManager;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.push.core.C0617f;
import com.igexin.push.extension.distribution.gbd.p061a.p062a.C1024c;
import com.igexin.push.extension.distribution.gbd.p061a.p062a.C1025d;
import com.igexin.push.extension.distribution.gbd.p061a.p062a.C1027f;
import com.igexin.push.extension.distribution.gbd.p061a.p064c.C1045f;
import com.igexin.push.extension.distribution.gbd.p066b.C1058a;
import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p069e.C1078a;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1079a;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1080b;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1083e;
import com.igexin.push.extension.distribution.gbd.p071f.C1085a;
import com.igexin.push.extension.distribution.gbd.p071f.p072a.C1087b;
import com.igexin.push.extension.distribution.gbd.p073g.C1094a;
import com.igexin.push.extension.distribution.gbd.p073g.C1095b;
import com.igexin.push.extension.distribution.gbd.p073g.C1096c;
import com.igexin.push.extension.distribution.gbd.p073g.C1097d;
import com.igexin.push.extension.distribution.gbd.p074h.C1098a;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.extension.distribution.gbd.p076i.C1116e;
import com.igexin.sdk.PushBuildConfig;
import com.igexin.sdk.PushConsts;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.List;
import java.util.Random;

/* renamed from: com.igexin.push.extension.distribution.gbd.d.b */
public class C1071b {

    /* renamed from: a */
    private static C1071b f2850a;

    /* renamed from: b */
    private Context f2851b;

    /* renamed from: c */
    private C1077h f2852c = new C1077h();

    /* renamed from: d */
    private C1094a f2853d;

    /* renamed from: e */
    private C1097d f2854e;

    /* renamed from: f */
    private C1095b f2855f;

    /* renamed from: g */
    private C1096c f2856g;

    /* renamed from: h */
    private C1098a f2857h;

    private C1071b() {
    }

    /* renamed from: a */
    public static C1071b m4348a() {
        if (f2850a == null) {
            f2850a = new C1071b();
        }
        return f2850a;
    }

    /* renamed from: f */
    private void m4353f() {
        C1115d.m4559b("GBD_Logic", "add data TimerTask result = " + C0617f.m2395a().mo4619a(new C1072c(this, (long) ((new Random().nextInt(25) + 35) * 1000))));
    }

    /* renamed from: g */
    private void m4354g() {
        try {
            if (!C1116e.m4603h(this.f2851b)) {
                C1087b bVar = new C1087b(new C1073d(this));
                bVar.mo5846a("http://sdk.open.phone.igexin.com/api/addr.htm");
                C0456c.m1661b().mo4216a(new C1085a(bVar), false, true);
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }

    /* renamed from: h */
    private void m4355h() {
        long nextInt = (long) ((C1067a.f2761L + new Random().nextInt(C1067a.f2762M)) * 1000);
        C1115d.m4559b("GBD_Logic", "add guard TimerTask result = " + C0617f.m2395a().mo4619a(new C1074e(this, nextInt)) + "|guardTime = " + nextInt);
    }

    /* renamed from: i */
    private void m4356i() {
        C1115d.m4559b("GBD_Logic", "add gbd config TimerTask result = " + C0617f.m2395a().mo4619a(new C1075f(this, 7000)));
    }

    /* renamed from: j */
    private void m4357j() {
        C1115d.m4559b("GBD_Logic", "add crontable TimerTask result = " + C0617f.m2395a().mo4619a(new C1076g(this, 5000)));
    }

    /* renamed from: k */
    private void m4358k() {
        C1069c.f2825b = new C1078a(this.f2851b);
        C1079a.m4384a().mo5810b();
        C1083e.m4408a().mo5821b();
        C1080b.m4391a().mo5813b();
    }

    /* renamed from: l */
    private void m4359l() {
        try {
            C1069c.f2827d = (WifiManager) this.f2851b.getSystemService("wifi");
            int checkPermission = this.f2851b.getPackageManager().checkPermission("android.permission.CHANGE_WIFI_STATE", this.f2851b.getPackageName());
            int checkPermission2 = this.f2851b.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", this.f2851b.getPackageName());
            if (checkPermission == 0 && checkPermission2 == 0) {
                C1069c.f2829f = true;
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m4360m() {
        this.f2855f = new C1095b();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_USER_PRESENT);
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        this.f2851b.registerReceiver(this.f2855f, intentFilter);
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m4361n() {
        this.f2853d = new C1094a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme("package");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        this.f2851b.registerReceiver(this.f2853d, intentFilter);
        this.f2854e = new C1097d();
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("com.igexin.sdk.action.5902a3e4e18b4784feccf24908d4769d");
        this.f2851b.registerReceiver(this.f2854e, intentFilter2);
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m4362o() {
        this.f2856g = new C1096c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_SHUTDOWN");
        this.f2851b.registerReceiver(this.f2856g, intentFilter);
    }

    /* renamed from: a */
    public void mo5793a(Context context) {
        this.f2851b = context;
        this.f2852c.start();
    }

    /* renamed from: b */
    public void mo5794b() {
        C1115d.m4559b("GBD_Logic", "gbd logic init");
        C1069c.f2824a = this.f2851b;
        m4358k();
        m4356i();
        if (C1067a.f2791b) {
            m4359l();
            C1045f.m4230a();
            C1027f.m4131a();
            C1025d.m4127a();
            C1024c.m4113a();
            this.f2857h = new C1098a();
            m4355h();
            m4353f();
            m4357j();
            m4354g();
        }
    }

    /* renamed from: c */
    public void mo5795c() {
        PackageManager packageManager = this.f2851b.getPackageManager();
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
        for (int i = 0; i < installedPackages.size(); i++) {
            try {
                PackageInfo packageInfo = installedPackages.get(i);
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if ((applicationInfo.flags & 1) <= 0) {
                    C1058a aVar = new C1058a();
                    aVar.mo5729b(applicationInfo.loadLabel(packageManager).toString());
                    aVar.mo5728a(applicationInfo.packageName);
                    aVar.mo5730c(packageInfo.versionName);
                    C1069c.f2835l.put(applicationInfo.packageName, aVar);
                }
            } catch (Exception e) {
                C1115d.m4558a(e);
            }
        }
    }

    /* renamed from: d */
    public void mo5796d() {
        if (this.f2851b != null) {
            C1115d.m4557a("GBD_Logic", "onDestroy");
            if (this.f2853d != null) {
                this.f2851b.unregisterReceiver(this.f2853d);
                this.f2853d = null;
            }
            if (this.f2854e != null) {
                this.f2851b.unregisterReceiver(this.f2854e);
                this.f2854e = null;
            }
            if (this.f2855f != null) {
                this.f2851b.unregisterReceiver(this.f2855f);
                this.f2855f = null;
            }
            if (this.f2856g != null) {
                this.f2851b.unregisterReceiver(this.f2856g);
                this.f2856g = null;
            }
        }
    }

    /* renamed from: e */
    public boolean mo5797e() {
        try {
            if (PushBuildConfig.sdk_conf_debug_level.equals(C1067a.f2792c)) {
                return false;
            }
            String[] split = C1067a.f2792c.split(MiPushClient.ACCEPT_TIME_SEPARATOR);
            for (String str : split) {
                if (C1116e.m4587c(str, this.f2851b)) {
                    C1115d.m4557a("GBD_Logic", "checkSafeStatus pkgName = " + str);
                    return false;
                }
            }
            if (PushBuildConfig.sdk_conf_debug_level.equals(C1067a.f2793d) || !C1116e.m4569a(this.f2851b)) {
                return false;
            }
            String[] split2 = C1067a.f2793d.split(MiPushClient.ACCEPT_TIME_SEPARATOR);
            for (PackageInfo packageInfo : C1069c.f2824a.getPackageManager().getInstalledPackages(4)) {
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                if (serviceInfoArr != null && serviceInfoArr.length > 0) {
                    for (ServiceInfo serviceInfo : serviceInfoArr) {
                        for (String str2 : split2) {
                            if (str2.equals(serviceInfo.name)) {
                                return false;
                            }
                        }
                    }
                    continue;
                }
            }
            return true;
        } catch (Throwable th) {
            C1115d.m4558a(th);
            return false;
        }
    }
}
