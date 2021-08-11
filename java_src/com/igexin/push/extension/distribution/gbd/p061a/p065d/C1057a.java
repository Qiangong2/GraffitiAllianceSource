package com.igexin.push.extension.distribution.gbd.p061a.p065d;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.igexin.push.core.C0618g;
import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1080b;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1083e;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.extension.distribution.gbd.p076i.C1116e;
import com.igexin.push.extension.distribution.gbd.p076i.C1129r;
import com.igexin.sdk.PushBuildConfig;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.igexin.push.extension.distribution.gbd.a.d.a */
public class C1057a {

    /* renamed from: a */
    private static C1057a f2717a;

    /* renamed from: a */
    public static synchronized C1057a m4275a() {
        C1057a aVar;
        synchronized (C1057a.class) {
            if (f2717a == null) {
                f2717a = new C1057a();
            }
            aVar = f2717a;
        }
        return aVar;
    }

    /* renamed from: a */
    private void m4276a(String str) {
        C1083e.m4408a().mo5829d(str);
        C1080b.m4391a().mo5812a(str, mo5726c());
    }

    /* renamed from: a */
    private void m4277a(StringBuilder sb) {
        String a = C1129r.m4637a(C1069c.f2824a);
        if (!TextUtils.isEmpty(a)) {
            sb.append(a);
        }
        String a2 = C1129r.m4636a(0, C1069c.f2824a);
        if (!TextUtils.isEmpty(a2)) {
            sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
            sb.append(a2);
        }
        String a3 = C1129r.m4636a(1, C1069c.f2824a);
        if (!TextUtils.isEmpty(a3)) {
            if (TextUtils.isEmpty(a2)) {
                sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
            }
            sb.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
            sb.append(a3);
        }
    }

    /* renamed from: a */
    private void m4278a(StringBuilder sb, int i, int i2) {
        String b = C1129r.m4640b(C1069c.f2824a);
        if (!TextUtils.isEmpty(b)) {
            sb.append(b);
        }
        String b2 = C1129r.m4639b(i, C1069c.f2824a);
        if (!TextUtils.isEmpty(b2)) {
            sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
            sb.append(b2);
        }
        String b3 = C1129r.m4639b(i2, C1069c.f2824a);
        if (!TextUtils.isEmpty(b3)) {
            if (TextUtils.isEmpty(b2)) {
                sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
            }
            sb.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
            sb.append(b3);
        }
    }

    /* renamed from: b */
    private void m4279b(StringBuilder sb, int i, int i2) {
        String c = C1129r.m4642c(C1069c.f2824a);
        if (!TextUtils.isEmpty(c)) {
            sb.append(c);
        }
        String c2 = C1129r.m4641c(i, C1069c.f2824a);
        if (!TextUtils.isEmpty(c2)) {
            sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
            sb.append(c2);
        }
        String c3 = C1129r.m4641c(i2, C1069c.f2824a);
        if (!TextUtils.isEmpty(c3)) {
            if (TextUtils.isEmpty(c2)) {
                sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
            }
            sb.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
            sb.append(c3);
        }
    }

    /* renamed from: d */
    private String m4280d() {
        int i = 1;
        try {
            if (C0618g.f1647r != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(C1116e.m4607k())));
                sb.append("|");
                sb.append(C0618g.f1647r);
                sb.append("|");
                if (C0618g.f1602a != null) {
                    sb.append(C0618g.f1602a);
                }
                sb.append("|");
                sb.append("ANDROID");
                sb.append("|");
                m4277a(sb);
                sb.append("|");
                int d = C1129r.m4643d(0, C1069c.f2824a);
                int d2 = C1129r.m4643d(1, C1069c.f2824a);
                m4278a(sb, d, d2);
                sb.append("|");
                if (C0618g.f1653x != null) {
                    sb.append(C0618g.f1653x);
                }
                sb.append("|");
                if (C1069c.f2839p != null) {
                    sb.append(C1069c.f2839p);
                }
                sb.append("|");
                if (C1069c.f2840q != null) {
                    sb.append(C1069c.f2840q);
                }
                sb.append("||");
                String a = C1116e.m4562a();
                if (!TextUtils.isEmpty(a)) {
                    sb.append(a);
                }
                sb.append("|");
                sb.append("|");
                if (C0618g.f1634e != null) {
                    sb.append(C0618g.f1634e);
                }
                sb.append("|");
                if (Build.BRAND != null) {
                    sb.append(Build.BRAND);
                }
                sb.append("|");
                sb.append(C1116e.m4606j());
                sb.append("|");
                if (Build.MODEL != null) {
                    sb.append(Build.MODEL);
                }
                sb.append("|");
                sb.append("|||");
                if (!C1116e.m4602h()) {
                    i = 0;
                }
                sb.append(i);
                sb.append("|");
                sb.append("|");
                String f = m4282f();
                if (!TextUtils.isEmpty(f)) {
                    sb.append(f);
                }
                sb.append("|");
                sb.append(C1116e.m4604i(C1069c.f2824a));
                sb.append("|");
                String i2 = m4285i();
                if (TextUtils.isEmpty(i2)) {
                    i2 = "";
                }
                sb.append(i2);
                sb.append("|");
                m4279b(sb, d, d2);
                sb.append("|");
                sb.append(m4283g());
                sb.append("|");
                sb.append(m4284h());
                sb.append("|");
                String n = C1116e.m4610n();
                if (!TextUtils.isEmpty(n)) {
                    sb.append(n);
                }
                sb.append("|");
                try {
                    LinkedHashMap<Long, Long> m = C1116e.m4609m();
                    if (m != null && m.size() > 0) {
                        for (Map.Entry<Long, Long> entry : m.entrySet()) {
                            sb.append(entry.getKey());
                            sb.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
                            sb.append(entry.getValue());
                            sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                        }
                        if (sb.toString().endsWith(MqttTopic.MULTI_LEVEL_WILDCARD)) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                    }
                } catch (Throwable th) {
                    C1115d.m4558a(th);
                }
                sb.append("|");
                String e = m4281e();
                if (!TextUtils.isEmpty(e)) {
                    sb.append(e);
                }
                sb.append("|");
                String b = C1116e.m4576b(C1069c.f2824a).mo5779b();
                if (!TextUtils.isEmpty(b)) {
                    sb.append(b);
                }
                return sb.toString();
            }
        } catch (Throwable th2) {
            C1115d.m4558a(th2);
        }
        return null;
    }

    /* renamed from: e */
    private String m4281e() {
        if (TextUtils.isEmpty(C1069c.f2819A)) {
            return null;
        }
        String str = C1069c.f2819A;
        C1069c.f2849z = 0;
        C1069c.f2819A = "";
        C1083e.m4408a().mo5817a(C1069c.f2849z);
        C1083e.m4408a().mo5823b(C1069c.f2819A);
        C1115d.m4559b("GBD_LFAction", "read shutdown data : " + str);
        return str;
    }

    /* renamed from: f */
    private String m4282f() {
        boolean z;
        boolean z2;
        boolean z3;
        int i = 0;
        try {
            ArrayList arrayList = new ArrayList();
            List<PackageInfo> installedPackages = C1069c.f2824a.getPackageManager().getInstalledPackages(0);
            String[] split = C1067a.f2754E.split("\\|");
            if (split.length != 4) {
                return "";
            }
            String[] split2 = split[0].split(MiPushClient.ACCEPT_TIME_SEPARATOR);
            String[] split3 = split[1].split(MiPushClient.ACCEPT_TIME_SEPARATOR);
            String[] split4 = split[2].split(MiPushClient.ACCEPT_TIME_SEPARATOR);
            String[] split5 = split[3].split(MiPushClient.ACCEPT_TIME_SEPARATOR);
            for (PackageInfo packageInfo : installedPackages) {
                if ((packageInfo.applicationInfo.flags & 1) > 0) {
                    if (split3.length > 1 && !split3[0].equals(PushBuildConfig.sdk_conf_debug_level)) {
                        boolean z4 = true;
                        for (String str : split3) {
                            if (packageInfo.packageName.contains(str)) {
                                z4 = false;
                            }
                        }
                        if (!z4) {
                        }
                    }
                    if (split4.length >= 1 && !split4[0].equals(PushBuildConfig.sdk_conf_debug_level)) {
                        int length = split4.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                z3 = true;
                                break;
                            }
                            if (!packageInfo.packageName.contains(split4[i2])) {
                                z3 = false;
                                break;
                            }
                            i2++;
                        }
                        if (!z3) {
                        }
                    }
                    if (split2.length >= 1 && !split2[0].equals(PushBuildConfig.sdk_conf_debug_level)) {
                        int length2 = split2.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length2) {
                                z2 = true;
                                break;
                            }
                            if (packageInfo.packageName.startsWith(split2[i3])) {
                                z2 = false;
                                break;
                            }
                            i3++;
                        }
                        if (!z2) {
                        }
                    }
                    if (split5.length >= 1 && !split5[0].equals(PushBuildConfig.sdk_conf_debug_level)) {
                        int length3 = split5.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= length3) {
                                z = true;
                                break;
                            }
                            if (packageInfo.packageName.endsWith(split5[i4])) {
                                z = false;
                                break;
                            }
                            i4++;
                        }
                        if (!z) {
                        }
                    }
                    arrayList.add(packageInfo);
                }
            }
            if (!arrayList.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    PackageInfo packageInfo2 = (PackageInfo) it.next();
                    if (i == 0) {
                        sb.append(packageInfo2.packageName);
                        sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                        sb.append(packageInfo2.versionName);
                        sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                        sb.append(packageInfo2.versionCode);
                    } else {
                        sb.append(MiPushClient.ACCEPT_TIME_SEPARATOR).append(packageInfo2.packageName);
                        sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                        sb.append(packageInfo2.versionName);
                        sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                        sb.append(packageInfo2.versionCode);
                    }
                    i++;
                }
                arrayList.clear();
                return sb.toString();
            }
            return "";
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }

    /* renamed from: g */
    private String m4283g() {
        if (TextUtils.isEmpty(C1067a.f2790an)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            String[] split = C1067a.f2790an.split(MiPushClient.ACCEPT_TIME_SEPARATOR);
            for (String str : split) {
                sb.append(str);
                sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                String str2 = "android.permission." + str;
                sb.append(C1116e.m4580b(C1069c.f2824a, str2) ? 1 : 0);
                sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                sb.append(C1116e.m4570a(C1069c.f2824a, str2) ? 1 : 0);
                sb.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
            }
            if (sb.length() > 0 && sb.toString().endsWith(MiPushClient.ACCEPT_TIME_SEPARATOR)) {
                sb = sb.deleteCharAt(sb.length() - 1);
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
        return sb.toString();
    }

    /* renamed from: h */
    private String m4284h() {
        int i = 1;
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(C1116e.m4601g(C1069c.f2824a) ? 1 : 0);
            sb.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
            if (C1116e.m4570a(C1069c.f2824a, "android.permission.BLUETOOTH")) {
                if (!C1116e.m4599f()) {
                    i = 0;
                }
                sb.append(i);
            } else {
                sb.append("-1");
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
        return sb.toString();
    }

    /* renamed from: i */
    private String m4285i() {
        try {
            return Locale.getDefault().getLanguage();
        } catch (Throwable th) {
            C1115d.m4558a(th);
            return null;
        }
    }

    /* renamed from: b */
    public void mo5725b() {
        String str;
        String str2 = null;
        C1115d.m4559b("GBD_LFAction", "doSample");
        try {
            str = C1116e.m4594e(C1069c.f2824a);
        } catch (Throwable th) {
            C1115d.m4558a(th);
            str = null;
        }
        try {
            str2 = C1116e.m4596f(C1069c.f2824a);
        } catch (Exception e) {
            C1115d.m4558a(e);
        }
        if (C1069c.f2839p == null) {
            if (str != null) {
                C1069c.f2839p = str;
                C1083e.m4408a().mo5824c();
            }
        } else if (!C1069c.f2839p.equals(str)) {
            C1069c.f2839p = str;
            C1083e.m4408a().mo5824c();
        }
        if (C1069c.f2840q == null) {
            if (str2 != null) {
                C1069c.f2840q = str2;
                C1083e.m4408a().mo5827d();
            }
        } else if (!C1069c.f2840q.equals(str2)) {
            C1069c.f2840q = str2;
            C1083e.m4408a().mo5827d();
        }
        String d = m4280d();
        if (!TextUtils.isEmpty(d)) {
            m4276a(d);
        }
    }

    /* renamed from: c */
    public int mo5726c() {
        return 31;
    }
}
