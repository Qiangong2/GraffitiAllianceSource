package com.igexin.push.extension.distribution.basic.p037a;

import android.app.ActivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.core.p027a.p028a.AbstractC0521a;
import com.igexin.push.extension.distribution.basic.p042c.C0744j;
import com.igexin.push.extension.distribution.basic.p053h.C0768a;
import com.igexin.push.extension.distribution.basic.p053h.C0775h;
import com.igexin.push.extension.distribution.basic.util.C0997c;
import com.igexin.sdk.PushBuildConfig;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.igexin.push.extension.distribution.basic.a.v */
public class C0708v implements AbstractC0521a {

    /* renamed from: a */
    private static final String f1885a = ("EXT-" + C0708v.class.getName());

    /* renamed from: b */
    private int f1886b = -90;

    /* renamed from: c */
    private int f1887c = 30;

    /* renamed from: d */
    private int f1888d = 30;

    /* renamed from: e */
    private int f1889e = 15;

    /* renamed from: a */
    private String m2754a(ScanResult scanResult) {
        if (scanResult == null) {
            return "";
        }
        return scanResult.SSID.replace("|", "").replace(MqttTopic.MULTI_LEVEL_WILDCARD, "").replace(MiPushClient.ACCEPT_TIME_SEPARATOR, "") + MqttTopic.MULTI_LEVEL_WILDCARD + scanResult.BSSID + MqttTopic.MULTI_LEVEL_WILDCARD + scanResult.level;
    }

    /* renamed from: a */
    private void m2755a() {
        String b = m2756b();
        String c = m2757c();
        if (!"".equals(b) || !"".equals(c)) {
            if ("".equals(b)) {
                b = PushBuildConfig.sdk_conf_debug_level;
            }
            if ("".equals(c)) {
                c = PushBuildConfig.sdk_conf_debug_level;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date())).append("|").append(C0618g.f1647r).append("|").append(C0618g.f1602a).append("|");
            sb.append(b).append("|").append(c);
            try {
                if (!C0456c.m1661b().mo4216a(new C0768a(new C0775h(sb.toString().getBytes("UTF-8"), this.f1889e)), false, true)) {
                }
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: b */
    private String m2756b() {
        int i;
        try {
            if (C0997c.m3998a()) {
                C0709w wVar = new C0709w(this);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                List<ScanResult> scanResults = ((WifiManager) C0744j.f2042a.getSystemService("wifi")).getScanResults();
                if (scanResults.size() > 0) {
                    Collections.sort(scanResults, wVar);
                    int i2 = 0;
                    int i3 = 0;
                    while (i2 < scanResults.size()) {
                        ScanResult scanResult = scanResults.get(i2);
                        long parseLong = Long.parseLong(scanResult.BSSID.replaceAll(":", ""), 16);
                        if (parseLong == 0 || scanResult.level <= this.f1886b || arrayList2.contains(Long.valueOf(parseLong))) {
                            i = i3;
                        } else {
                            if (i3 >= this.f1887c) {
                                break;
                            }
                            arrayList2.add(Long.valueOf(parseLong));
                            arrayList.add(scanResult);
                            i = i3 + 1;
                        }
                        i2++;
                        i3 = i;
                    }
                    if (arrayList.size() > 0) {
                        StringBuilder sb = new StringBuilder();
                        for (int i4 = 0; i4 < arrayList.size(); i4++) {
                            sb.append(m2754a((ScanResult) arrayList.get(i4)));
                            if (i4 < arrayList.size() - 1) {
                                sb.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
                            }
                        }
                        return sb.toString();
                    }
                }
            }
        } catch (Exception e) {
        }
        return "";
    }

    /* renamed from: c */
    private String m2757c() {
        try {
            List<ActivityManager.RecentTaskInfo> recentTasks = ((ActivityManager) C0744j.f2042a.getSystemService("activity")).getRecentTasks(this.f1888d, 1);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < recentTasks.size(); i++) {
                sb.append(recentTasks.get(i).baseIntent.getComponent().getPackageName());
                if (i < recentTasks.size() - 1) {
                    sb.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
                }
            }
            return sb.toString();
        } catch (Throwable th) {
            return "";
        }
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public EnumC0554b mo4352a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return EnumC0554b.success;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public BaseAction mo4353a(JSONObject jSONObject) {
        try {
            if (jSONObject.has("do") && jSONObject.has("actionid")) {
                BaseAction baseAction = new BaseAction();
                baseAction.setType(jSONObject.getString("type"));
                baseAction.setActionId(jSONObject.getString("actionid"));
                baseAction.setDoActionId(jSONObject.getString("do"));
                return baseAction;
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        m2755a();
        if (baseAction.getDoActionId().equals("")) {
            return true;
        }
        C0535e.m2034a().mo4379a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseAction.getDoActionId());
        return true;
    }
}
