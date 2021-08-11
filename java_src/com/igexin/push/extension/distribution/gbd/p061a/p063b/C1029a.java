package com.igexin.push.extension.distribution.gbd.p061a.p063b;

import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.igexin.p012b.p022b.C0476a;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1084f;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.extension.distribution.gbd.p076i.C1116e;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.igexin.push.extension.distribution.gbd.a.b.a */
public class C1029a {

    /* renamed from: a */
    private Map<String, List<String>> f2625a;

    private C1029a() {
    }

    /* renamed from: a */
    public static C1029a m4145a() {
        return C1031c.f2626a;
    }

    /* renamed from: a */
    private void m4146a(String str) {
        String[] list;
        File file = new File(str);
        if (file.exists() && (list = file.list()) != null) {
            try {
                for (String str2 : list) {
                    if ((str2.endsWith(".db") || str2.endsWith(".bin")) && !str2.equals("app.db") && !str2.equals("imsi.db") && !str2.equals("com.igexin.sdk.deviceId.db") && !str2.equals("com.getui.sdk.deviceId.db")) {
                        String substring = str2.substring(0, str2.lastIndexOf("."));
                        if (!this.f2625a.containsKey(substring)) {
                            this.f2625a.put(substring, new ArrayList());
                        }
                        if (str2.endsWith(".db")) {
                            if (!this.f2625a.get(substring).contains("com.igexin.sdk.PushService")) {
                                this.f2625a.get(substring).add("com.igexin.sdk.PushService");
                            }
                        } else if (str2.endsWith(".bin")) {
                            m4147a(substring, str + MqttTopic.TOPIC_LEVEL_SEPARATOR + str2);
                        }
                    }
                }
            } catch (Throwable th) {
                C1115d.m4558a(th);
                C1115d.m4559b("GBD_GGTH", th.getMessage());
            }
        }
    }

    /* renamed from: a */
    private void m4147a(String str, String str2) {
        try {
            byte[] e = C1116e.m4595e(str2);
            if (e != null) {
                String str3 = new String(C0476a.m1777c(e));
                if (!this.f2625a.get(str).contains(str3)) {
                    this.f2625a.get(str).add(str3);
                }
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
            C1115d.m4559b("GBD_GGTH", th.getMessage());
        }
    }

    /* renamed from: a */
    private void m4148a(List<PackageInfo> list) {
        ServiceInfo[] serviceInfoArr;
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    for (PackageInfo packageInfo : list) {
                        if (((packageInfo.applicationInfo.flags & 1) == 0 || (packageInfo.applicationInfo.flags & 128) != 0) && (serviceInfoArr = packageInfo.services) != null && serviceInfoArr.length != 0 && this.f2625a.containsKey(packageInfo.packageName)) {
                            ArrayList arrayList = new ArrayList();
                            for (ServiceInfo serviceInfo : serviceInfoArr) {
                                arrayList.add(serviceInfo.name);
                            }
                            if (this.f2625a.get(packageInfo.packageName) != null) {
                                this.f2625a.get(packageInfo.packageName).retainAll(arrayList);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                C1115d.m4558a(th);
                C1115d.m4559b("GBD_GGTH", th.getMessage());
            }
        }
    }

    /* renamed from: b */
    private void m4149b(String str) {
        String[] list;
        File file = new File(str);
        if (file.exists() && (list = file.list()) != null) {
            try {
                for (String str2 : list) {
                    if (str2.endsWith(".bin")) {
                        String replace = str2.replace(".gtyl", "");
                        String substring = replace.substring(0, replace.lastIndexOf("."));
                        if (!this.f2625a.containsKey(substring)) {
                            this.f2625a.put(substring, new ArrayList());
                        }
                        m4147a(substring, str + MqttTopic.TOPIC_LEVEL_SEPARATOR + str2);
                    }
                }
            } catch (Throwable th) {
                C1115d.m4558a(th);
                C1115d.m4559b("GBD_GGTH", th.getMessage());
            }
        }
    }

    /* renamed from: c */
    private static boolean m4150c(String str) {
        try {
            return C1069c.f2824a.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Exception e) {
            C1115d.m4558a(e);
            return false;
        }
    }

    /* renamed from: d */
    private List<PackageInfo> m4151d() {
        Throwable th;
        List<PackageInfo> list;
        ServiceInfo[] serviceInfoArr;
        try {
            List<PackageInfo> installedPackages = C1069c.f2824a.getPackageManager().getInstalledPackages(4);
            if (installedPackages == null) {
                return installedPackages;
            }
            try {
                if (installedPackages.isEmpty()) {
                    return installedPackages;
                }
                for (PackageInfo packageInfo : installedPackages) {
                    if (((packageInfo.applicationInfo.flags & 1) == 0 || (packageInfo.applicationInfo.flags & 128) != 0) && (serviceInfoArr = packageInfo.services) != null && serviceInfoArr.length != 0) {
                        int length = serviceInfoArr.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                break;
                            }
                            ServiceInfo serviceInfo = serviceInfoArr[i];
                            if (m4152d(serviceInfo.name)) {
                                if (!this.f2625a.containsKey(packageInfo.packageName)) {
                                    this.f2625a.put(packageInfo.packageName, new ArrayList());
                                }
                                if (!this.f2625a.get(packageInfo.packageName).contains(serviceInfo.name)) {
                                    this.f2625a.get(packageInfo.packageName).add(serviceInfo.name);
                                }
                            } else {
                                i++;
                            }
                        }
                    }
                }
                list = installedPackages;
                return list;
            } catch (Throwable th2) {
                th = th2;
                list = installedPackages;
                C1115d.m4558a(th);
                C1115d.m4559b("GBD_GGTH", th.getMessage());
                return list;
            }
        } catch (Throwable th3) {
            th = th3;
            list = null;
            C1115d.m4558a(th);
            C1115d.m4559b("GBD_GGTH", th.getMessage());
            return list;
        }
    }

    /* renamed from: d */
    private static boolean m4152d(String str) {
        return "com.igexin.sdk.PushService".equals(str) || "com.igexin.sdk.coordinator.GexinMsgService".equals(str) || "com.igexin.sdk.coordinator.SdkMsgService".equals(str);
    }

    /* renamed from: e */
    private void m4153e() {
        try {
            m4149b("/sdcard/libs//yl");
            m4146a("/sdcard/libs/");
        } catch (Throwable th) {
            C1115d.m4558a(th);
            C1115d.m4559b("GBD_GGTH", th.getMessage());
        }
    }

    /* renamed from: f */
    private void m4154f() {
        try {
            String b = C1084f.m4433a().mo5839b();
            if (!TextUtils.isEmpty(b)) {
                JSONObject jSONObject = new JSONObject(b);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = jSONObject.getString(next);
                    if (next.contains(".gtyl")) {
                        next = next.replaceAll(".gtyl", "");
                    }
                    if (!this.f2625a.containsKey(next)) {
                        this.f2625a.put(next, new ArrayList());
                    }
                    this.f2625a.get(next).addAll(Arrays.asList(string.split("\\|")));
                }
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
            C1115d.m4559b("GBD_GGTH", th.getMessage());
        }
    }

    /* renamed from: g */
    private void m4155g() {
        Iterator<Map.Entry<String, List<String>>> it = this.f2625a.entrySet().iterator();
        while (it.hasNext()) {
            if (!m4150c(it.next().getKey())) {
                it.remove();
            }
        }
    }

    /* renamed from: b */
    public Map<String, List<String>> mo5685b() {
        TreeMap treeMap;
        synchronized (C1029a.class) {
            treeMap = new TreeMap(this.f2625a == null ? mo5686c() : this.f2625a);
        }
        return treeMap;
    }

    /* renamed from: c */
    public Map<String, List<String>> mo5686c() {
        Map<String, List<String>> map;
        synchronized (C1029a.class) {
            if (this.f2625a == null) {
                this.f2625a = new TreeMap();
            }
            this.f2625a.clear();
            m4154f();
            C1115d.m4559b("GBD_GGTH", "1-> sp, l =  " + this.f2625a.toString());
            m4153e();
            C1115d.m4559b("GBD_GGTH", "2-> sdcard, l =  " + this.f2625a.toString());
            List<PackageInfo> d = m4151d();
            C1115d.m4559b("GBD_GGTH", "3-> service, l =  " + this.f2625a.toString());
            m4155g();
            C1115d.m4559b("GBD_GGTH", "4-> remove invalid pkg, l =  " + this.f2625a.toString());
            m4148a(d);
            C1115d.m4559b("GBD_GGTH", "5-> remove invalid service, l =  " + this.f2625a.toString());
            map = this.f2625a;
        }
        return map;
    }
}
