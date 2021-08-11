package com.igexin.push.extension.distribution.gbd.p061a.p063b;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p067c.C1068b;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.extension.distribution.gbd.p076i.C1116e;
import com.igexin.push.extension.distribution.gbd.p076i.C1126o;
import com.igexin.sdk.PushBuildConfig;
import com.igexin.sdk.PushConsts;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.pwrd.paho.client.mqttv3.internal.ClientDefaults;

/* renamed from: com.igexin.push.extension.distribution.gbd.a.b.d */
public class C1032d {

    /* renamed from: c */
    private static C1032d f2627c;

    /* renamed from: a */
    private Context f2628a;

    /* renamed from: b */
    private SimpleDateFormat f2629b;

    /* renamed from: d */
    private Map<String, EnumC1035g> f2630d = new HashMap();

    private C1032d(Context context) {
        this.f2628a = context;
        this.f2629b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    }

    /* renamed from: a */
    public static C1032d m4159a() {
        if (f2627c == null) {
            f2627c = new C1032d(C1069c.f2824a);
        }
        return f2627c;
    }

    /* renamed from: a */
    private C1034f m4160a(int i, String str, List<String> list, boolean z, String str2, String str3) {
        String c = m4175c(list);
        try {
            EnumC1035g gVar = this.f2630d.get(str);
            if (i == 1) {
                C1115d.m4559b("GBD_GGTSA", "start aGuard pkg = " + str);
                if (!(gVar == null || gVar == EnumC1035g.GACTIVITY)) {
                    C1115d.m4559b("GBD_GGTSA", "start aGuard, pkg = " + str + "|not support act");
                }
                if (gVar == null || gVar == EnumC1035g.GACTIVITY) {
                    boolean c2 = m4176c(str);
                    Intent intent = new Intent();
                    intent.setClassName(str, "com.igexin.sdk.MActivity");
                    if (c2) {
                        intent.putExtra(PushConsts.CMD_ACTION, C1068b.f2817b);
                        intent.putExtra("isSlave", false);
                    }
                    if (!C1116e.m4585c(intent, this.f2628a) || !m4171a(str, intent)) {
                        intent.setClassName(str, "com.igexin.sdk.GActivity");
                        if (C1116e.m4585c(intent, this.f2628a) && m4171a(str, intent)) {
                            C1115d.m4559b("GBD_GGTSA", "GA guard success, force = " + c2);
                            return new C1034f(i, true, c);
                        }
                    } else {
                        C1115d.m4559b("GBD_GGTSA", "MA guard success, force = " + c2);
                        return new C1034f(i, true, c);
                    }
                }
                C1115d.m4559b("GBD_GGTSA", "aGuard failed, useServiceGuard = " + z);
                if (!z) {
                    return new C1034f(i, false, c);
                }
                i = 2;
            }
            if (i == 2) {
                C1115d.m4559b("GBD_GGTSA", "start sGuard = " + str);
                if (!(gVar == null || gVar == EnumC1035g.SERVICE)) {
                    C1115d.m4559b("GBD_GGTSA", "start sGuard = " + str + "|not support service, return");
                }
                if (gVar == null || gVar == EnumC1035g.SERVICE) {
                    m4166a(str, c);
                }
            }
            return new C1034f(i, true, c);
        } catch (Throwable th) {
            C1115d.m4558a(th);
            C1115d.m4559b("GBD_GGTSA", "startGuard exception = " + th.getMessage());
            C1037i.m4196a(str2, i, str3, 2);
            return new C1034f(i, false, c);
        }
    }

    /* renamed from: a */
    private List<String> m4161a(int i, boolean z) {
        if (TextUtils.isEmpty(C1067a.f2771V)) {
            C1115d.m4559b("GBD_GGTSA", "pMBlacklist is empty or null");
            return null;
        }
        String[] split = C1067a.f2771V.split(MiPushClient.ACCEPT_TIME_SEPARATOR);
        if (split.length == 0) {
            C1115d.m4559b("GBD_GGTSA", "pMBlacklist is empty or null");
            return null;
        }
        String i2 = C1116e.m4605i();
        if (TextUtils.isEmpty(i2)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        this.f2630d.clear();
        for (String str : split) {
            if (!TextUtils.isEmpty(str)) {
                String[] split2 = str.split(":");
                String str2 = split2[1];
                if (split2.length == 4 && i2.equalsIgnoreCase(split2[0]) && !TextUtils.isEmpty(str2) && !arrayList.contains(str2)) {
                    if (!C1116e.m4587c(str2, C1069c.f2824a)) {
                        C1115d.m4559b("GBD_GGTSA", "pkg = " + str2 + " not install");
                    } else {
                        boolean parseBoolean = Boolean.parseBoolean(split2[2]);
                        boolean parseBoolean2 = Boolean.parseBoolean(split2[3]);
                        C1115d.m4559b("GBD_GGTSA", "brand = " + i2 + "|pkg = " + str2 + "|aEnable = " + parseBoolean + "|sEnable = " + parseBoolean2);
                        if (!parseBoolean || !parseBoolean2) {
                            if (!parseBoolean && !parseBoolean2) {
                                arrayList.add(str2);
                            } else if (i == 2 && !parseBoolean2) {
                                C1115d.m4559b("GBD_GGTSA", "guard type = " + i + "|pkg = " + str2 + " matched, in pm black list ###");
                                arrayList.add(str2);
                            } else if (i == 1) {
                                if (parseBoolean) {
                                    Intent intent = new Intent();
                                    intent.setClassName(str2, "com.igexin.sdk.MActivity");
                                    boolean c = C1116e.m4585c(intent, this.f2628a);
                                    intent.setClassName(str2, "com.igexin.sdk.GActivity");
                                    if (!(c || C1116e.m4585c(intent, this.f2628a))) {
                                        arrayList.add(str2);
                                        C1115d.m4559b("GBD_GGTSA", "getPMGuardBlackList-> " + str2 + " activitySet = false, add to pMGuardBlackList");
                                    } else {
                                        this.f2630d.put(str2, EnumC1035g.GACTIVITY);
                                    }
                                } else if (!z) {
                                    arrayList.add(str2);
                                } else {
                                    this.f2630d.put(str2, EnumC1035g.SERVICE);
                                }
                            }
                        }
                    }
                }
            }
        }
        C1115d.m4559b("GBD_GGTSA", "PMGuardBlack-> = " + arrayList.toString());
        return arrayList;
    }

    /* renamed from: a */
    private List<String> m4162a(Map<String, List<String>> map, List<String> list, int i, boolean z) {
        ArrayList<String> arrayList = new ArrayList();
        if (map == null || map.isEmpty()) {
            return arrayList;
        }
        if (list != null && !list.isEmpty()) {
            C1115d.m4559b("GBD_GGTSA", "remove all running, running =  " + list.toString());
            Iterator<Map.Entry<String, List<String>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                if (list.contains(it.next().getKey())) {
                    it.remove();
                }
            }
        }
        C1115d.m4559b("GBD_GGTSA", "after remove running, guardList =  " + map.toString());
        if (!C1067a.f2810u.equals(PushBuildConfig.sdk_conf_debug_level)) {
            List asList = Arrays.asList(C1067a.f2810u.split(MiPushClient.ACCEPT_TIME_SEPARATOR));
            Iterator<Map.Entry<String, List<String>>> it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                if (asList.contains(it2.next().getKey())) {
                    it2.remove();
                }
            }
        }
        C1115d.m4559b("GBD_GGTSA", "after remove blacklist, guardList =  " + map.toString());
        List<String> a = m4161a(i, z);
        if (a != null && !a.isEmpty()) {
            Iterator<Map.Entry<String, List<String>>> it3 = map.entrySet().iterator();
            while (it3.hasNext()) {
                if (a.contains(it3.next().getKey())) {
                    it3.remove();
                }
            }
        }
        C1115d.m4559b("GBD_GGTSA", "after remove pm blacklist pkgs, guardList =  " + map.toString());
        if (!C1067a.f2811v.equals(PushBuildConfig.sdk_conf_debug_level)) {
            List asList2 = Arrays.asList(C1067a.f2811v.split(MiPushClient.ACCEPT_TIME_SEPARATOR));
            C1115d.m4559b("GBD_GGTSA", "white list = " + asList2.toString());
            if (!asList2.isEmpty()) {
                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (asList2.contains(key)) {
                        arrayList.add(key);
                    }
                }
            }
        }
        if (!map.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(map.keySet());
            for (String str : arrayList) {
                if (arrayList2.contains(str)) {
                    arrayList2.remove(str);
                }
            }
            Collections.shuffle(arrayList2);
            arrayList.addAll(arrayList2);
        }
        C1115d.m4559b("GBD_GGTSA", "after add all whitelist, guardList =  " + arrayList.toString());
        return arrayList;
    }

    /* renamed from: a */
    private Map<String, List<String>> m4163a(List<String> list) {
        Map<String, List<String>> b = C1029a.m4145a().mo5685b();
        if (b.isEmpty()) {
            return b;
        }
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) this.f2628a.getSystemService("activity")).getRunningServices(2000);
        for (Map.Entry<String, List<String>> entry : b.entrySet()) {
            String key = entry.getKey();
            Iterator<String> it = entry.getValue().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (C1116e.m4573a(it.next(), key, runningServices) && !list.contains(key)) {
                    list.add(key);
                    break;
                }
            }
        }
        return b;
    }

    /* renamed from: a */
    private void m4164a(int i) {
        try {
            ArrayList arrayList = new ArrayList();
            Map<String, List<String>> a = m4163a(arrayList);
            if (a.size() <= 1) {
                C1115d.m4559b("GBD_GGTSA", "hasServiceAppList size <= 1");
                return;
            }
            if (i == 2) {
                C1037i.m4196a(PushBuildConfig.sdk_conf_debug_level, i, this.f2629b.format(new Date()), 3);
            }
            m4167a((List<String>) arrayList, a, i, false);
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }

    /* renamed from: a */
    private void m4165a(String str, int i, String str2, String str3) {
        try {
            C1037i.m4196a(str, i, str3, 0);
            String str4 = str.split(MiPushClient.ACCEPT_TIME_SEPARATOR)[0];
            String str5 = str.split(MiPushClient.ACCEPT_TIME_SEPARATOR)[1];
            C1115d.m4559b("GBD_GGTSA_guard", "success start " + str4);
            C1115d.m4559b("GBD_GGTSA_guard", "success start service " + str4);
            ArrayList arrayList = new ArrayList();
            arrayList.add(str2);
            HashMap hashMap = new HashMap();
            hashMap.put("pkgName", str4);
            hashMap.put("srvName", str5);
            hashMap.put("datetime", str3);
            hashMap.put("checkList", arrayList);
            C1037i.m4197a(hashMap, 0, i);
        } catch (Throwable th) {
            C1115d.m4558a(th);
            C1115d.m4559b("GBD_GGTSA", "saveResultAndCheck exception = " + th.getMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0067 A[Catch:{ Throwable -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0099 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[ADDED_TO_REGION, ORIG_RETURN, RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4166a(java.lang.String r9, java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 241
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.gbd.p061a.p063b.C1032d.m4166a(java.lang.String, java.lang.String):void");
    }

    /* renamed from: a */
    private void m4167a(List<String> list, Map<String, List<String>> map, int i, boolean z) {
        try {
            C1115d.m4559b("GBD_GGTSA", "guard cnt = " + C1067a.f2809t + ", running cnt = " + list.size() + ", has cnt = " + map.size() + ", type = " + i + ", useService = " + z);
            if (m4168a(list.size(), map.size())) {
                List<String> a = m4162a(map, list, i, z);
                if (!a.isEmpty()) {
                    int min = Math.min(C1067a.f2809t - (list.size() - 1), a.size());
                    C1115d.m4559b("GBD_GGTSA", "need guard cnt = " + min + " #######");
                    if (min > 0) {
                        String format = this.f2629b.format(new Date());
                        int i2 = 0;
                        for (String str : a) {
                            List<String> list2 = map.get(str);
                            String packageName = this.f2628a.getPackageName();
                            if (list2 == null || list2.isEmpty() || TextUtils.isEmpty(str) || str.equals(packageName)) {
                                C1115d.m4559b("GBD_GGTSA", "pkg =  " + str + " service is empty");
                            } else {
                                String b = m4172b(str);
                                if (TextUtils.isEmpty(b)) {
                                    C1115d.m4559b("GBD_GGTSA", "guard pkg = " + str + ", appid is empty, ignore this ###");
                                } else {
                                    String str2 = str + MiPushClient.ACCEPT_TIME_SEPARATOR + b;
                                    C1037i.m4195a(str2);
                                    C1034f a2 = m4160a(i, str, list2, z, str2, format);
                                    if (C1034f.m4184a(a2)) {
                                        m4165a(str2, C1034f.m4185b(a2), C1034f.m4186c(a2), format);
                                        int i3 = i2 + 1;
                                        C1115d.m4559b("GBD_GGTSA", "has guard cnt = " + i3);
                                        if (i3 < min) {
                                            i2 = i3;
                                        } else {
                                            return;
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
            C1115d.m4559b("GBD_GGTSA", " startSDK " + th.getMessage());
        }
    }

    /* renamed from: a */
    private boolean m4168a(int i, int i2) {
        if (i == i2) {
            C1115d.m4559b("GBD_GGTSA", "running s count = all list, need't guard ~~~");
            return false;
        } else if (i - 1 < C1067a.f2809t) {
            return true;
        } else {
            C1115d.m4559b("GBD_GGTSA", "running cnt > " + C1067a.f2809t + ", need't guard ~~~");
            return false;
        }
    }

    /* renamed from: a */
    private boolean m4169a(EnumC1035g gVar) {
        if (!C1067a.f2806q) {
            C1115d.m4559b("GBD_GGTSA", "isGEnable = false");
            return false;
        } else if (!C1116e.m4569a(this.f2628a)) {
            C1115d.m4559b("GBD_GGTSA", "|canScan = false");
            return false;
        } else if (m4179h()) {
            C1115d.m4559b("GBD_GGTSA", "|romOrASdkInBlack = true");
            return false;
        } else if ((gVar == EnumC1035g.GACTIVITY && !C1067a.f2786aj) || ((gVar == EnumC1035g.SERVICE && !C1067a.f2787ak) || (gVar == EnumC1035g.ONEOF && !C1067a.f2786aj && !C1067a.f2787ak))) {
            C1115d.m4559b("GBD_GGTSA", gVar + "|aGuardEnable = " + C1067a.f2786aj + "|sGuardEnable = " + C1067a.f2787ak);
            return false;
        } else if (gVar != EnumC1035g.GACTIVITY) {
            return m4173b(gVar);
        } else {
            if (!m4173b(EnumC1035g.GACTIVITY)) {
                C1115d.m4559b("GBD_GGTSA", "pMGuardEnable = false");
                return false;
            } else if (C1116e.m4584c(this.f2628a)) {
                return m4177f();
            } else {
                C1115d.m4559b("GBD_GGTSA", "isScreenOn = false, gEnable = true");
                return true;
            }
        }
    }

    /* renamed from: a */
    private boolean m4170a(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(C1067a.f2769T)) {
            return false;
        }
        for (String str2 : C1067a.f2769T.split(MiPushClient.ACCEPT_TIME_SEPARATOR)) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m4171a(String str, Intent intent) {
        try {
            intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
            this.f2628a.startActivity(intent);
            C1115d.m4559b("GBD_GGTSA", "type = start by activity, pkg = " + str);
            return true;
        } catch (Exception e) {
            C1115d.m4559b("GBD_GGTSA", e.getMessage());
            C1115d.m4558a(e);
            return false;
        }
    }

    /* renamed from: b */
    private String m4172b(String str) {
        Throwable th;
        String str2;
        try {
            String a = C1116e.m4567a(str, this.f2628a);
            try {
                str2 = TextUtils.isEmpty(a) ? C1116e.m4597f(str) : a;
                try {
                    C1115d.m4559b("GBD_GGTSA", "guard appid = " + str2 + "|pkg = " + str);
                } catch (Throwable th2) {
                    th = th2;
                    C1115d.m4558a(th);
                    return str2;
                }
            } catch (Throwable th3) {
                str2 = a;
                th = th3;
                C1115d.m4558a(th);
                return str2;
            }
        } catch (Throwable th4) {
            str2 = null;
            th = th4;
            C1115d.m4558a(th);
            return str2;
        }
        return str2;
    }

    /* renamed from: b */
    private boolean m4173b(EnumC1035g gVar) {
        boolean z = false;
        if (TextUtils.isEmpty(C1067a.f2771V)) {
            C1115d.m4559b("GBD_GGTSA", "pMBlacklist is empty or null");
            return true;
        }
        try {
            String[] split = C1067a.f2771V.split(MiPushClient.ACCEPT_TIME_SEPARATOR);
            if (split.length == 0) {
                C1115d.m4559b("GBD_GGTSA", "pMBlacklist is empty or null");
                return true;
            }
            String i = C1116e.m4605i();
            if (TextUtils.isEmpty(i)) {
                return true;
            }
            C1115d.m4559b("GBD_GGTSA", "brand = " + i);
            for (String str : split) {
                if (!TextUtils.isEmpty(str)) {
                    String[] split2 = str.split(":");
                    if (split2.length == 3 && i.equalsIgnoreCase(split2[0])) {
                        boolean parseBoolean = Boolean.parseBoolean(split2[1]);
                        boolean parseBoolean2 = Boolean.parseBoolean(split2[2]);
                        C1115d.m4559b("GBD_GGTSA", "brand = " + i + "|aEnable = " + parseBoolean + "|sEnable = " + parseBoolean2);
                        if (gVar == EnumC1035g.GACTIVITY) {
                            return parseBoolean;
                        }
                        if (gVar == EnumC1035g.SERVICE) {
                            return parseBoolean2;
                        }
                        if (gVar == EnumC1035g.ALL) {
                            return parseBoolean && parseBoolean2;
                        }
                        if (gVar == EnumC1035g.ONEOF) {
                            if (parseBoolean || parseBoolean2) {
                                z = true;
                            }
                            return z;
                        }
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            C1115d.m4558a(th);
            return true;
        }
    }

    /* renamed from: b */
    private boolean m4174b(List<String> list) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(C1067a.f2769T)) {
            List asList = Arrays.asList(C1067a.f2769T.split(MiPushClient.ACCEPT_TIME_SEPARATOR));
            for (String str : list) {
                if (asList.contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    private String m4175c(List<String> list) {
        if (list == null || list.isEmpty()) {
            return "com.igexin.sdk.PushService";
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        for (String str : list) {
            if (!(str.equals("com.igexin.sdk.PushService") || str.equals("com.igexin.sdk.coordinator.GexinMsgService") || str.equals("com.igexin.sdk.coordinator.SdkMsgService"))) {
                return str;
            }
        }
        return "com.igexin.sdk.PushService";
    }

    /* renamed from: c */
    private boolean m4176c(String str) {
        try {
            if (!C1067a.f2788al || TextUtils.isEmpty(C1067a.f2789am) || PushBuildConfig.sdk_conf_debug_level.equals(C1067a.f2789am) || TextUtils.isEmpty(str)) {
                return false;
            }
            String[] split = C1067a.f2789am.split(MiPushClient.ACCEPT_TIME_SEPARATOR);
            if (split.length == 0) {
                return false;
            }
            for (String str2 : split) {
                if (str.equals(str2)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            C1115d.m4558a(e);
            return false;
        }
    }

    /* renamed from: f */
    private boolean m4177f() {
        C1115d.m4559b("GBD_GGTSA", "Build.VERSION = " + Build.VERSION.SDK_INT);
        if (!m4178g()) {
            C1115d.m4559b("GBD_GGTSA", "checkBlackListInstall = false, gEnable = true");
            return true;
        }
        if (Build.VERSION.SDK_INT < 21) {
            try {
                List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) C1069c.f2824a.getSystemService("activity")).getRunningTasks(1);
                if (runningTasks == null || runningTasks.isEmpty()) {
                    return true;
                }
                ComponentName componentName = runningTasks.get(0).topActivity;
                if (componentName != null) {
                    boolean a = m4170a(componentName.getPackageName());
                    C1115d.m4559b("GBD_GGTSA", "Build.VERSION < 21, top app = " + componentName.getPackageName() + ",  isInBlackList = " + a);
                    return !a;
                }
            } catch (Throwable th) {
                C1115d.m4559b("GBD_GGTSA", th.getMessage());
                C1115d.m4558a(th);
            }
        } else {
            try {
                List<String> a2 = C1126o.m4630a(false);
                if (a2 == null || a2.isEmpty() || (a2.size() == 1 && a2.get(0).equals(this.f2628a.getPackageName()))) {
                    C1115d.m4559b("GBD_GGTSA", "Build.VERSION >= 21, recentList = null, guard = false");
                    return false;
                }
                boolean b = m4174b(a2);
                C1115d.m4559b("GBD_GGTSA", "Build.VERSION >= 21, isInBlackList = " + b);
                return !b;
            } catch (Throwable th2) {
                C1115d.m4559b("GBD_GGTSA", th2.getMessage());
                C1115d.m4558a(th2);
            }
        }
        return false;
    }

    /* renamed from: g */
    private boolean m4178g() {
        if (TextUtils.isEmpty(C1067a.f2769T)) {
            return false;
        }
        String[] split = C1067a.f2769T.split(MiPushClient.ACCEPT_TIME_SEPARATOR);
        for (String str : split) {
            if (C1116e.m4587c(str, this.f2628a)) {
                C1115d.m4559b("GBD_GGTSA", str + " install, in blacklist");
                return true;
            }
        }
        return false;
    }

    /* renamed from: h */
    private boolean m4179h() {
        if (TextUtils.isEmpty(C1067a.f2770U)) {
            C1115d.m4559b("GBD_GGTSA", "romSdkIntBlack is empty or null ");
            return false;
        }
        try {
            String[] split = C1067a.f2770U.split(MiPushClient.ACCEPT_TIME_SEPARATOR);
            for (String str : split) {
                if (!TextUtils.isEmpty(str)) {
                    String[] split2 = str.split(":");
                    if (split2.length == 2) {
                        String str2 = split2[0];
                        if (C1116e.m4606j().equals(str2) && Build.VERSION.SDK_INT == Integer.valueOf(split2[1]).intValue()) {
                            C1115d.m4559b("GBD_GGTSA", "SDK_INT = " + Build.VERSION.SDK_INT + "|blacklist version int = " + Integer.valueOf(split2[1]) + "|rominfo = " + str2 + "|inblacklist");
                            return true;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            C1115d.m4558a(th);
            return false;
        }
    }

    /* renamed from: b */
    public synchronized void mo5687b() {
        int i = 2;
        synchronized (this) {
            try {
                C1115d.m4559b("GBD_GGTSA", "first start");
                if (!C1116e.m4569a(this.f2628a)) {
                    C1115d.m4559b("GBD_GGTSA", "first, scan apps = false");
                } else {
                    ArrayList arrayList = new ArrayList();
                    Map<String, List<String>> a = m4163a(arrayList);
                    for (Map.Entry<String, List<String>> entry : a.entrySet()) {
                        String key = entry.getKey();
                        try {
                            String a2 = C1116e.m4567a(key, this.f2628a);
                            if (!TextUtils.isEmpty(a2)) {
                                C1037i.m4195a(key + MiPushClient.ACCEPT_TIME_SEPARATOR + a2);
                            }
                        } catch (Throwable th) {
                            C1115d.m4558a(th);
                        }
                    }
                    if (a.size() <= 1 || !m4169a(EnumC1035g.ONEOF)) {
                        C1115d.m4559b("GBD_GGTSA", "first, available = false");
                    } else {
                        String format = this.f2629b.format(new Date());
                        boolean a3 = m4169a(EnumC1035g.SERVICE);
                        boolean a4 = m4169a(EnumC1035g.GACTIVITY);
                        C1115d.m4559b("GBD_GGTSA", "first, sEnable = " + a3 + "|aEnable = " + a4);
                        if (C1067a.f2760K && a4) {
                            i = 1;
                        } else if (!C1116e.m4584c(this.f2628a)) {
                            C1115d.m4559b("GBD_GGTSA", "first, screenOn = false|aEnable = " + a4);
                            if (a4) {
                                i = 1;
                            } else if (a3) {
                            }
                        } else if (!a3) {
                            C1115d.m4559b("GBD_GGTSA", "first, sEnable = false|screenOn = true");
                        }
                        m4167a(arrayList, a, i, i == 1 && a3);
                        C1037i.m4196a(PushBuildConfig.sdk_conf_debug_level, i, format, 4);
                    }
                }
            } catch (Throwable th2) {
                C1115d.m4558a(th2);
                C1115d.m4559b("GBD_GGTSA", th2.toString());
            }
        }
        return;
    }

    /* renamed from: c */
    public synchronized void mo5688c() {
        C1115d.m4559b("GBD_GGTSA", "pkg changed, fresh");
        if (!m4169a(EnumC1035g.ONEOF)) {
            C1115d.m4559b("GBD_GGTSA", "freshMap, available = false");
        } else {
            C1029a.m4145a().mo5686c();
        }
    }

    /* renamed from: d */
    public synchronized void mo5689d() {
        C1115d.m4559b("GBD_GGTSA", "start aGuard ~~~");
        if (!m4169a(EnumC1035g.GACTIVITY)) {
            C1115d.m4559b("GBD_GGTSA", "start aGuard, available = false");
        } else {
            m4164a(1);
        }
    }

    /* renamed from: e */
    public synchronized void mo5690e() {
        C1115d.m4559b("GBD_GGTSA", "start sGuard ~~~");
        if (!m4169a(EnumC1035g.SERVICE)) {
            C1115d.m4559b("GBD_GGTSA", "start sGuard, available = false");
        } else {
            m4164a(2);
        }
    }
}
