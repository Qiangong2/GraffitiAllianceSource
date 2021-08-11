package com.igexin.push.extension.distribution.gbd.p061a.p062a;

import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p013a.p015b.C0459f;
import com.igexin.push.core.C0618g;
import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1080b;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1083e;
import com.igexin.push.extension.distribution.gbd.p071f.C1085a;
import com.igexin.push.extension.distribution.gbd.p071f.p072a.C1086a;
import com.igexin.push.extension.distribution.gbd.p076i.C1114c;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.extension.distribution.gbd.p076i.C1116e;
import com.igexin.push.extension.distribution.gbd.p076i.C1125n;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.igexin.push.extension.distribution.gbd.a.a.a */
public class C1022a {

    /* renamed from: b */
    private static C1022a f2611b;

    /* renamed from: a */
    List<PackageInfo> f2612a;

    private C1022a() {
        this.f2612a = null;
        this.f2612a = new ArrayList();
    }

    /* renamed from: a */
    public static C1022a m4100a() {
        if (f2611b == null) {
            f2611b = new C1022a();
        }
        return f2611b;
    }

    /* renamed from: a */
    private String m4101a(List<PackageInfo> list, int i) {
        ServiceInfo[] serviceInfoArr;
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(C1116e.m4607k()));
        StringBuilder sb = new StringBuilder();
        sb.append(format);
        sb.append("|");
        sb.append(C0618g.f1647r);
        sb.append("|");
        sb.append(C0618g.f1602a);
        sb.append("|");
        for (PackageInfo packageInfo : list) {
            try {
                sb.append(packageInfo.packageName);
                sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                sb.append(C1116e.m4598f(packageInfo.packageName, C1069c.f2824a));
                sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                sb.append(packageInfo.versionName);
                sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                sb.append(packageInfo.versionCode);
                sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                sb.append(packageInfo.firstInstallTime);
                sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                sb.append(C1116e.m4566a(packageInfo));
                if (C1067a.f2777aa) {
                    sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                    PackageInfo e = C1116e.m4593e(packageInfo.packageName, C1069c.f2824a);
                    if (!(e == null || (serviceInfoArr = e.services) == null || serviceInfoArr.length <= 0)) {
                        for (int i2 = 0; i2 < serviceInfoArr.length; i2++) {
                            sb.append(serviceInfoArr[i2].name);
                            if (i2 < serviceInfoArr.length - 1) {
                                sb.append("&");
                            }
                        }
                    }
                    sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                    String b = C1116e.m4577b(packageInfo.packageName, C1069c.f2824a);
                    if (!TextUtils.isEmpty(b)) {
                        sb.append(b);
                    }
                }
                sb.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
            } catch (Throwable th) {
                C1115d.m4558a(th);
            }
        }
        StringBuilder deleteCharAt = sb.toString().endsWith(MiPushClient.ACCEPT_TIME_SEPARATOR) ? sb.deleteCharAt(sb.length() - 1) : sb;
        deleteCharAt.append("|");
        deleteCharAt.append(i);
        deleteCharAt.append("|");
        deleteCharAt.append("ANDROID");
        return deleteCharAt.toString();
    }

    /* access modifiers changed from: public */
    /* renamed from: a */
    private void m4103a(byte[] bArr) {
        PackageInfo d;
        int i = 0;
        if ((bArr != null && bArr.length > 0) || (bArr = C1114c.m4556a(m4109f())) != null) {
            String[] split = new String(C0459f.m1688b(C1125n.m4620a(bArr, "d69998bb013e45f2"))).split("\\r");
            boolean z = true;
            for (String str : split) {
                if (!TextUtils.isEmpty(str) && (d = C1116e.m4588d(str, C1069c.f2824a)) != null && (d.applicationInfo.flags & 1) == 0 && !m4105a(this.f2612a, d.packageName)) {
                    this.f2612a.add(d);
                    z = false;
                }
            }
            if (this.f2612a.isEmpty()) {
                C1115d.m4559b("GBD_RALA", "get from server size = 0");
                return;
            }
            List<PackageInfo> list = this.f2612a;
            if (!z) {
                i = 1;
            }
            String a = m4101a(list, i);
            C1115d.m4557a("GBD_RALA", "final data = " + a);
            long j = 0;
            try {
                if (!TextUtils.isEmpty(C1069c.f2845v)) {
                    j = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(C1069c.f2845v.split("\\|")[0]).getTime();
                }
            } catch (Exception e) {
                C1115d.m4558a(e);
                C1115d.m4559b("GBD_RALA", e.getMessage());
            }
            if (System.currentTimeMillis() - j > C1067a.f2774Y * 1000 || !m4104a(a)) {
                m4106b(a);
            }
        }
    }

    /* renamed from: a */
    private boolean m4104a(String str) {
        try {
            if (TextUtils.isEmpty(C1069c.f2845v)) {
                return false;
            }
            String[] split = C1069c.f2845v.split("\\|")[3].split(MiPushClient.ACCEPT_TIME_SEPARATOR);
            String[] split2 = str.split("\\|")[3].split(MiPushClient.ACCEPT_TIME_SEPARATOR);
            C1115d.m4557a("GBD_RALA", "last : " + C1069c.f2845v);
            C1115d.m4557a("GBD_RALA", "now : " + str);
            if (split.length != split2.length) {
                return false;
            }
            for (int i = 0; i < split.length; i++) {
                if (!split[i].substring(0, split[i].lastIndexOf(MqttTopic.MULTI_LEVEL_WILDCARD)).equals(split2[i].substring(0, split2[i].lastIndexOf(MqttTopic.MULTI_LEVEL_WILDCARD)))) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            C1115d.m4558a(th);
            C1115d.m4559b("GBD_RALA", th.getMessage());
        }
    }

    /* renamed from: a */
    private boolean m4105a(List<PackageInfo> list, String str) {
        for (PackageInfo packageInfo : list) {
            if (packageInfo.packageName.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m4106b(String str) {
        if (this.f2612a != null) {
            this.f2612a.clear();
        }
        C1115d.m4557a("GBD_RALA", "save " + str + " 2ral ~~~~~~");
        C1083e.m4408a().mo5819a(str);
        C1080b.m4391a().mo5812a(str, mo5671c());
        C1115d.m4557a("GBD_RALA", "applist data: type = " + mo5671c() + " content = " + str);
    }

    /* renamed from: d */
    private void m4107d() {
        try {
            if (!new File(m4109f()).exists() || C1067a.f2785ai) {
                m4108e();
            } else {
                m4103a((byte[]) null);
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
            C1115d.m4559b("GBD_RALA", th.getMessage());
        }
    }

    /* renamed from: e */
    private void m4108e() {
        if (!TextUtils.isEmpty(C1067a.f2783ag)) {
            C1086a aVar = new C1086a(new C1023b(this));
            aVar.mo5846a(C1067a.f2783ag);
            C0456c.m1661b().mo4216a(new C1085a(aVar), false, true);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0035  */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m4109f() {
        /*
            r4 = this;
            java.lang.String r1 = "d69998bb013e45f2"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0059 }
            r0.<init>()     // Catch:{ Exception -> 0x0059 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x0059 }
            android.content.Context r2 = com.igexin.push.extension.distribution.gbd.p067c.C1069c.f2824a     // Catch:{ Exception -> 0x0059 }
            java.lang.String r2 = r2.getPackageName()     // Catch:{ Exception -> 0x0059 }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ Exception -> 0x0059 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0059 }
            java.lang.String r0 = com.igexin.p012b.p022b.C0476a.m1773a(r0)     // Catch:{ Exception -> 0x0059 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0061 }
            if (r1 != 0) goto L_0x002f
            r1 = 10
            int r2 = r0.length()     // Catch:{ Exception -> 0x0061 }
            int r2 = r2 + -10
            java.lang.String r0 = r0.substring(r1, r2)     // Catch:{ Exception -> 0x0061 }
        L_0x002f:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0037
            java.lang.String r0 = "d69998bb013e45f2"
        L_0x0037:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            android.content.Context r2 = com.igexin.push.extension.distribution.gbd.p067c.C1069c.f2824a
            java.io.File r2 = r2.getFilesDir()
            java.lang.String r2 = r2.getPath()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = "/"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            return r0
        L_0x0059:
            r0 = move-exception
            r3 = r0
            r0 = r1
            r1 = r3
        L_0x005d:
            com.igexin.push.extension.distribution.gbd.p076i.C1115d.m4558a(r1)
            goto L_0x002f
        L_0x0061:
            r1 = move-exception
            goto L_0x005d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.gbd.p061a.p062a.C1022a.m4109f():java.lang.String");
    }

    /* renamed from: b */
    public void mo5670b() {
        try {
            C1115d.m4559b("GBD_RALA", "doSample");
            if (this.f2612a != null) {
                this.f2612a.clear();
            }
            try {
                for (PackageInfo packageInfo : C0618g.f1635f.getPackageManager().getInstalledPackages(0)) {
                    if ((packageInfo.applicationInfo.flags & 1) == 0) {
                        this.f2612a.add(packageInfo);
                    }
                }
            } catch (Throwable th) {
                C1115d.m4558a(th);
            }
            if (this.f2612a.size() > 5) {
                String a = m4101a(this.f2612a, 0);
                long j = 0;
                try {
                    if (!TextUtils.isEmpty(C1069c.f2845v)) {
                        j = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(C1069c.f2845v.split("\\|")[0]).getTime();
                    }
                } catch (Exception e) {
                    C1115d.m4558a(e);
                    C1115d.m4559b("GBD_RALA", e.getMessage());
                }
                if (System.currentTimeMillis() - j > C1067a.f2774Y * 1000 || !m4104a(a)) {
                    m4106b(a);
                    return;
                }
                return;
            }
            m4107d();
        } catch (Throwable th2) {
            C1115d.m4558a(th2);
            C1115d.m4559b("GBD_RALA", th2.getMessage());
        }
    }

    /* renamed from: c */
    public int mo5671c() {
        return 28;
    }
}
