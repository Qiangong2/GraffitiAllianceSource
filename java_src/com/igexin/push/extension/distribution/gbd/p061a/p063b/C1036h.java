package com.igexin.push.extension.distribution.gbd.p061a.p063b;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.igexin.push.core.C0618g;
import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1083e;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.extension.distribution.gbd.p076i.C1116e;
import com.igexin.push.extension.distribution.gbd.p076i.C1124m;
import com.igexin.sdk.PushBuildConfig;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.pwrd.paho.client.mqttv3.MqttTopic;
import org.pwrd.paho.client.mqttv3.internal.ClientDefaults;

/* renamed from: com.igexin.push.extension.distribution.gbd.a.b.h */
public class C1036h {

    /* renamed from: d */
    private static C1036h f2639d;

    /* renamed from: a */
    private Context f2640a;

    /* renamed from: b */
    private long f2641b = 0;

    /* renamed from: c */
    private SimpleDateFormat f2642c;

    private C1036h(Context context) {
        this.f2640a = context;
        this.f2642c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    }

    /* renamed from: a */
    public static C1036h m4187a() {
        if (f2639d == null) {
            f2639d = new C1036h(C1069c.f2824a);
        }
        return f2639d;
    }

    /* renamed from: a */
    private boolean m4188a(String str, Intent intent) {
        if (str.equals("0")) {
            if (C1116e.m4571a(intent, this.f2640a)) {
                C1115d.m4557a("GBD_GOSA", "intent start service");
                this.f2640a.startService(intent);
                return true;
            }
        } else if (str.equals("1")) {
            if (C1116e.m4581b(intent, this.f2640a)) {
                C1115d.m4557a("GBD_GOSA", "intent start broadcast");
                this.f2640a.sendBroadcast(intent);
                return true;
            }
        } else if (str.equals("2") && C1116e.m4585c(intent, this.f2640a)) {
            intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
            C1115d.m4557a("GBD_GOSA", "intent start activity");
            this.f2640a.startActivity(intent);
            return true;
        }
        return false;
    }

    /* renamed from: d */
    private boolean m4189d() {
        C1115d.m4559b("GBD_GOSA", "look enable = " + C1067a.f2805p);
        C1115d.m4559b("GBD_GOSA", "look service = " + C1067a.f2807r);
        if (C1067a.f2805p && System.currentTimeMillis() - this.f2641b > 360000) {
            return C1083e.m4408a().mo5831e();
        }
        C1115d.m4559b("GBD_GOSA", "gurad other service time not meet");
        return false;
    }

    /* renamed from: e */
    private void m4190e() {
        C1037i.m4196a(PushBuildConfig.sdk_conf_debug_level, 0, this.f2642c.format(new Date()), 3);
        this.f2641b = System.currentTimeMillis();
        m4191f();
        m4192g();
    }

    /* renamed from: f */
    private void m4191f() {
        if (!TextUtils.isEmpty(C1067a.f2807r)) {
            try {
                String[] split = C1067a.f2807r.split(MiPushClient.ACCEPT_TIME_SEPARATOR);
                if (split.length > 0) {
                    String format = this.f2642c.format(new Date());
                    String packageName = this.f2640a.getPackageName();
                    List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) this.f2640a.getSystemService("activity")).getRunningServices(2000);
                    for (String str : split) {
                        String[] split2 = str.split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                        if (split2.length > 2 && !packageName.equals(split2[0])) {
                            try {
                                String str2 = split2[0];
                                String str3 = split2[1];
                                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                                    C1115d.m4559b("GBD_GOSA", "other service check pkgname srvname pass");
                                    Intent intent = new Intent();
                                    intent.setClassName(str2, str3);
                                    if (C1116e.m4571a(intent, this.f2640a)) {
                                        C1115d.m4559b("GBD_GOSA", "other service exist..");
                                        ArrayList arrayList = new ArrayList();
                                        HashMap hashMap = new HashMap();
                                        for (int i = 2; i < split2.length; i++) {
                                            hashMap.put(split2[i], Boolean.valueOf(C1116e.m4573a(split2[i], str2, runningServices)));
                                            arrayList.add(split2[i]);
                                        }
                                        String str4 = str2 + MiPushClient.ACCEPT_TIME_SEPARATOR + str3;
                                        C1037i.m4195a(str4);
                                        if (!hashMap.toString().contains("true")) {
                                            C1115d.m4559b("GBD_GOSA", "guard other service start..");
                                            try {
                                                HashMap hashMap2 = new HashMap();
                                                hashMap2.put("pkgName", str2);
                                                hashMap2.put("srvName", str3);
                                                hashMap2.put("datetime", format);
                                                hashMap2.put("checkList", arrayList);
                                                C1037i.m4196a(str4, 0, format, 0);
                                                intent.putExtra("intent_come_from", "getui");
                                                if (str2.contains("com.sina.weibo")) {
                                                    C1115d.m4557a("GBD_GOSA", "start weibo service, add deviceid");
                                                    intent.putExtra("clientId", C0618g.f1653x + "|" + C1124m.m4616a().mo5887b());
                                                }
                                                this.f2640a.startService(intent);
                                                C1115d.m4559b("GBD_GOSA", "look---startService pkgName = " + str2 + " srvName = " + str3);
                                                C1037i.m4197a(hashMap2, 0, 0);
                                            } catch (Exception e) {
                                                C1115d.m4558a(e);
                                                C1037i.m4196a(str4, 0, format, 2);
                                            }
                                        } else {
                                            C1115d.m4559b("GBD_GOSA", "other service already run..");
                                            C1037i.m4196a(str4, 0, format, -1);
                                        }
                                    }
                                }
                            } catch (Exception e2) {
                                C1115d.m4558a(e2);
                                C1115d.m4559b("GBD_GOSA", "Looker error:" + e2.toString());
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                C1115d.m4559b("GBD_GOSA", th.toString());
            }
        }
    }

    /* renamed from: g */
    private void m4192g() {
        if (!TextUtils.isEmpty(C1067a.f2808s)) {
            try {
                String[] split = C1067a.f2808s.split(MiPushClient.ACCEPT_TIME_SEPARATOR);
                List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) this.f2640a.getSystemService("activity")).getRunningServices(2000);
                for (String str : split) {
                    try {
                        String[] split2 = str.split("\\|");
                        if (split2.length >= 4) {
                            String str2 = split2[0];
                            Intent parseUri = Intent.parseUri(split2[1], 0);
                            String str3 = split2[2];
                            String[] split3 = split2[3].split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                            String format = this.f2642c.format(new Date());
                            if (!TextUtils.isEmpty(str3) || !TextUtils.isEmpty(split3[0])) {
                                C1115d.m4559b("GBD_GOSA", "other service check pkgname srvname pass");
                                if (str2.equals("0") || str2.equals("2") || str2.equals("1")) {
                                    String str4 = str3 + MiPushClient.ACCEPT_TIME_SEPARATOR + split3[0];
                                    C1037i.m4195a(str4);
                                    Intent intent = new Intent();
                                    intent.setClassName(str3, split3[0]);
                                    if (C1116e.m4571a(intent, this.f2640a)) {
                                        C1115d.m4559b("GBD_GOSA", "guard other service start..");
                                        ArrayList arrayList = new ArrayList();
                                        HashMap hashMap = new HashMap();
                                        for (int i = 0; i < split3.length; i++) {
                                            hashMap.put(split3[i], Boolean.valueOf(C1116e.m4573a(split3[i], str3, runningServices)));
                                            arrayList.add(split3[i]);
                                        }
                                        if (!hashMap.toString().contains("true")) {
                                            try {
                                                boolean a = m4188a(str2, parseUri);
                                                C1115d.m4559b("GBD_GOSA", "intent guard-- type = " + str2 + "pkgName = " + str3 + " srvName = " + split3[0]);
                                                if (a) {
                                                    C1115d.m4559b("GBD_GOSA", "guard intentExist = " + a);
                                                    C1037i.m4196a(str4, 0, format, 0);
                                                    HashMap hashMap2 = new HashMap();
                                                    hashMap2.put("pkgName", str3);
                                                    hashMap2.put("srvName", split3[0]);
                                                    hashMap2.put("datetime", format);
                                                    hashMap2.put("checkList", arrayList);
                                                    C1037i.m4197a(hashMap2, 0, 0);
                                                }
                                            } catch (Exception e) {
                                                C1115d.m4558a(e);
                                                C1037i.m4196a(str4, 0, format, 2);
                                            }
                                        } else {
                                            C1037i.m4196a(str4, 0, format, -1);
                                        }
                                    } else if (m4188a(str2, parseUri)) {
                                        C1115d.m4559b("GBD_GOSA", "guard service not Exist type = " + str2 + "pkgName = " + str3 + " srvName = " + split3[0]);
                                        C1037i.m4196a(str4, 0, format, 0);
                                    }
                                }
                            }
                        }
                    } catch (Exception e2) {
                        C1115d.m4558a(e2);
                    }
                }
            } catch (Throwable th) {
                C1115d.m4558a(th);
            }
        }
    }

    /* renamed from: b */
    public void mo5691b() {
        try {
            String packageName = this.f2640a.getPackageName();
            String[] split = C1067a.f2807r.split(MiPushClient.ACCEPT_TIME_SEPARATOR);
            if (split.length > 0) {
                for (String str : split) {
                    String[] split2 = str.split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                    if (split2.length > 2 && !packageName.equals(split2[0])) {
                        try {
                            C1037i.m4195a(split2[0] + MiPushClient.ACCEPT_TIME_SEPARATOR + split2[1]);
                        } catch (Exception e) {
                            C1115d.m4558a(e);
                        }
                    }
                }
            }
            String[] split3 = C1067a.f2808s.split(MiPushClient.ACCEPT_TIME_SEPARATOR);
            if (split3.length > 0) {
                for (String str2 : split3) {
                    String[] split4 = str2.split("\\|");
                    if (split4.length >= 4) {
                        try {
                            C1037i.m4195a(split4[2] + MiPushClient.ACCEPT_TIME_SEPARATOR + split4[3].split(MqttTopic.TOPIC_LEVEL_SEPARATOR)[0]);
                        } catch (Exception e2) {
                            C1115d.m4558a(e2);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }

    /* renamed from: c */
    public void mo5692c() {
        try {
            boolean d = m4189d();
            C1115d.m4559b("GBD_GOSA", "isGuardService = " + d);
            if (d) {
                m4190e();
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }
}
