package com.igexin.push.extension.distribution.gbd.p061a.p062a;

import android.content.Intent;
import android.content.pm.PackageManager;
import com.igexin.push.core.C0618g;
import com.igexin.push.extension.distribution.gbd.p066b.C1058a;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1080b;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.extension.distribution.gbd.p076i.C1116e;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.igexin.push.extension.distribution.gbd.a.a.d */
public class C1025d {

    /* renamed from: a */
    private static C1025d f2618a;

    /* renamed from: b */
    private PackageManager f2619b = C1069c.f2824a.getPackageManager();

    private C1025d() {
    }

    /* renamed from: a */
    public static C1025d m4127a() {
        if (f2618a == null) {
            f2618a = new C1025d();
        }
        return f2618a;
    }

    /* renamed from: a */
    public void mo5677a(Intent intent) {
        String str;
        String str2;
        try {
            new Thread(new RunnableC1026e(this)).start();
        } catch (Throwable th) {
            C1115d.m4558a(th);
            C1115d.m4559b("GBD_RPRA", th.getMessage());
        }
        try {
            String action = intent.getAction();
            if ("android.intent.action.PACKAGE_ADDED".equals(action) || "android.intent.action.PACKAGE_REMOVED".equals(action)) {
                String dataString = intent.getDataString();
                C1115d.m4559b("GBD_RPRA", "doSample pkgName = " + dataString);
                int indexOf = dataString.indexOf(":");
                if (indexOf != -1) {
                    String substring = dataString.substring(indexOf + 1);
                    if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                        str2 = "install";
                        str = this.f2619b.getPackageInfo(substring, 0).versionName;
                        C1058a aVar = new C1058a();
                        aVar.mo5729b("");
                        aVar.mo5728a(substring);
                        aVar.mo5730c(str);
                        C1069c.f2835l.put(substring, aVar);
                    } else {
                        C1058a aVar2 = C1069c.f2835l.get(substring);
                        if (aVar2 != null) {
                            String a = aVar2.mo5727a();
                            C1069c.f2835l.remove(substring);
                            str = a;
                            str2 = "uninstall";
                        } else {
                            return;
                        }
                    }
                    if (C0618g.f1647r != null) {
                        String str3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(C1116e.m4607k())) + "|" + C0618g.f1647r + "|" + C0618g.f1602a + "|" + "" + "|" + substring + "|" + str2 + "|" + str + "|" + "ANDROID";
                        C1080b.m4391a().mo5812a(str3, mo5678b());
                        C1115d.m4559b("GBD_RPRA", "save type = " + mo5678b() + ", content = " + str3);
                    }
                }
            }
        } catch (Exception e) {
            C1115d.m4558a(e);
        }
    }

    /* renamed from: b */
    public int mo5678b() {
        return 14;
    }
}
