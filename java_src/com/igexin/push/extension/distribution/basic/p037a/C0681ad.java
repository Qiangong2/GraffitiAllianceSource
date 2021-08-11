package com.igexin.push.extension.distribution.basic.p037a;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.config.C0514k;
import com.igexin.push.core.C0617f;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.core.p027a.p028a.AbstractC0521a;
import com.igexin.push.extension.distribution.basic.p041b.C0734v;
import com.igexin.push.extension.distribution.basic.p042c.C0744j;
import com.igexin.push.extension.distribution.basic.p044e.C0748a;
import com.igexin.push.extension.distribution.basic.util.C0997c;
import com.igexin.push.extension.distribution.basic.util.C1003i;
import com.igexin.push.extension.distribution.basic.util.C1013s;
import com.igexin.sdk.PushConsts;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import org.pwrd.paho.client.mqttv3.MqttTopic;
import org.pwrd.paho.client.mqttv3.internal.ClientDefaults;

/* renamed from: com.igexin.push.extension.distribution.basic.a.ad */
public class C0681ad implements AbstractC0521a {

    /* renamed from: a */
    private static final String f1838a = ("EXT-" + C0681ad.class.getName());

    /* renamed from: b */
    private String f1839b = "30020";

    /* renamed from: c */
    private String f1840c = "30021";

    /* renamed from: d */
    private PackageManager f1841d = null;

    /* renamed from: a */
    private String m2650a(String str) {
        try {
            String str2 = "/sdcard/libs//" + str + ".bin";
            if (C0997c.m4010e(str)) {
                str2 = "/sdcard/libs//yl/" + str + ".bin";
            }
            byte[] b = C1003i.m4038b(str2);
            String str3 = b != null ? new String(C1013s.m4070b(b)) : C0748a.m3034a().mo5033a(str);
            if (str3 != null) {
                ActivityC0460a.m1698b(f1838a + "|guardService name = " + str3);
                return str3;
            }
            List<PackageInfo> installedPackages = C0618g.f1635f.getPackageManager().getInstalledPackages(4);
            if (installedPackages != null) {
                for (PackageInfo packageInfo : installedPackages) {
                    if (str.equals(packageInfo.packageName)) {
                        ServiceInfo[] serviceInfoArr = packageInfo.services;
                        for (ServiceInfo serviceInfo : serviceInfoArr) {
                            if ("com.igexin.sdk.PushService".equals(serviceInfo.name) || "com.igexin.sdk.coordinator.SdkMsgService".equals(serviceInfo.name) || "com.igexin.sdk.coordinator.GexinMsgService".equals(serviceInfo.name)) {
                                return serviceInfo.name;
                            }
                        }
                        continue;
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            ActivityC0460a.m1698b(f1838a + "|" + th.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:0x017a, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0182, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0183, code lost:
        r0 = r2;
        r2 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x012a A[SYNTHETIC, Splitter:B:57:0x012a] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x017a A[ExcHandler: all (th java.lang.Throwable), PHI: r2 
      PHI: (r2v36 java.util.ArrayList) = (r2v40 java.util.ArrayList), (r2v40 java.util.ArrayList), (r2v44 java.util.ArrayList), (r2v44 java.util.ArrayList) binds: [B:69:0x0168, B:70:?, B:46:0x0109, B:47:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:46:0x0109] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x012d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x00b3 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<java.lang.String> m2651a(int r12, java.lang.String r13, java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 404
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.p037a.C0681ad.m2651a(int, java.lang.String, java.lang.String):java.util.List");
    }

    /* renamed from: a */
    private void m2653a(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        sb.append(C0618g.f1635f.getPackageName());
        sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
        sb.append(str4);
        sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
        sb.append(str5);
        sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
        sb.append("-1");
        m2660b(this.f1839b, sb.toString(), str, str2, str3);
        ActivityC0460a.m1698b(f1838a + "|feedback actionId=" + this.f1839b + " result=" + sb.toString());
    }

    /* renamed from: a */
    private void m2654a(String str, boolean z, PushTaskBean pushTaskBean, BaseAction baseAction) {
        try {
            String a = m2650a(str);
            String messageId = pushTaskBean.getMessageId();
            String taskId = pushTaskBean.getTaskId();
            String a2 = ((C0734v) baseAction).mo5003a();
            m2659b(C1013s.m4072d(str));
            if (a != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("messageId", messageId);
                hashMap.put("taskId", taskId);
                hashMap.put("id", a2);
                hashMap.put("pkgName", str);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(C0618g.f1635f.getPackageName());
                stringBuffer.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                stringBuffer.append(m2665d(str));
                stringBuffer.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                stringBuffer.append(str);
                stringBuffer.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                if (a.equals("com.igexin.sdk.PushService")) {
                    stringBuffer.append("com.igexin.sdk.PushService");
                    stringBuffer.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                    if (m2657a(str, "com.igexin.sdk.PushService")) {
                        stringBuffer.append("0");
                    } else if (!m2658a(str, a, z)) {
                        m2655a(stringBuffer, messageId, taskId, a2);
                        return;
                    } else {
                        hashMap.put("serviceName", "com.igexin.sdk.PushService");
                        m2656a(hashMap);
                        stringBuffer.append("1");
                    }
                } else if (a.equals("com.igexin.sdk.coordinator.SdkMsgService")) {
                    stringBuffer.append("com.igexin.sdk.coordinator.SdkMsgService");
                    stringBuffer.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                    if (m2657a(str, "com.igexin.sdk.coordinator.SdkMsgService")) {
                        stringBuffer.append("0");
                    } else if (!m2658a(str, a, false)) {
                        m2655a(stringBuffer, messageId, taskId, a2);
                        return;
                    } else {
                        hashMap.put("serviceName", "com.igexin.sdk.coordinator.SdkMsgService");
                        m2656a(hashMap);
                        stringBuffer.append("1");
                    }
                } else if (a.equals("com.igexin.sdk.coordinator.GexinMsgService")) {
                    stringBuffer.append("com.igexin.sdk.coordinator.GexinMsgService");
                    stringBuffer.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                    if (m2657a(str, "com.igexin.sdk.coordinator.GexinMsgService")) {
                        stringBuffer.append("0");
                    } else if (!m2658a(str, a, false)) {
                        m2655a(stringBuffer, messageId, taskId, a2);
                        return;
                    } else {
                        hashMap.put("serviceName", "com.igexin.sdk.coordinator.GexinMsgService");
                        m2656a(hashMap);
                        stringBuffer.append("1");
                    }
                } else {
                    stringBuffer.append(a);
                    stringBuffer.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                    if (m2657a(str, a)) {
                        stringBuffer.append("0");
                    } else if (!m2658a(str, a, z)) {
                        m2655a(stringBuffer, messageId, taskId, a2);
                        return;
                    } else {
                        hashMap.put("serviceName", a);
                        m2656a(hashMap);
                        stringBuffer.append("1");
                    }
                }
                m2660b(this.f1839b, stringBuffer.toString(), messageId, taskId, a2);
                ActivityC0460a.m1698b("feedback actionId=" + this.f1839b + " result=" + stringBuffer.toString());
                return;
            }
            m2653a(messageId, taskId, a2, ((C0734v) baseAction).mo5010d() != null ? ((C0734v) baseAction).mo5010d() : "", ((C0734v) baseAction).mo5008c() != null ? ((C0734v) baseAction).mo5008c() : "");
        } catch (Throwable th) {
            ActivityC0460a.m1698b(f1838a + "|" + th.toString());
        }
    }

    /* renamed from: a */
    private void m2655a(StringBuffer stringBuffer, String str, String str2, String str3) {
        stringBuffer.append("-1");
        m2660b(this.f1839b, stringBuffer.toString(), str, str2, str3);
        ActivityC0460a.m1698b("feedback actionId=" + this.f1839b + " result=" + stringBuffer.toString());
    }

    /* renamed from: a */
    private void m2656a(Map<String, String> map) {
        C0617f.m2395a().mo4619a(new C0682ae(this, 180000, map));
    }

    /* renamed from: a */
    public static boolean m2657a(String str, String str2) {
        boolean z;
        try {
            List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) C0618g.f1635f.getSystemService("activity")).getRunningServices(2000);
            if (runningServices.isEmpty()) {
                return false;
            }
            int i = 0;
            while (true) {
                if (i < runningServices.size()) {
                    if (runningServices.get(i).service.getClassName().equals(str2) && runningServices.get(i).service.getPackageName().equals(C1013s.m4072d(str))) {
                        z = true;
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
            z = false;
            return z;
        } catch (Throwable th) {
            ActivityC0460a.m1698b(f1838a + "|" + th.toString());
        }
    }

    /* renamed from: a */
    private boolean m2658a(String str, String str2, boolean z) {
        if (!C0744j.f2051j || !m2661b(str, "com.igexin.sdk.GActivity") || C0997c.m4011f()) {
            try {
                C0535e.m2034a().mo4419u();
                return ((C0618g.f1645p != 0 || !m2661b(str, "com.igexin.sdk.GActivity") || C0997c.m4011f()) ? false : m2662b(str, "com.igexin.sdk.GActivity", z)) || m2664c(str, str2, z);
            } catch (Throwable th) {
                ActivityC0460a.m1698b(f1838a + "|" + th.toString());
                return false;
            }
        } else {
            boolean b = m2662b(str, "com.igexin.sdk.GActivity", z);
            return !b ? m2664c(str, str2, z) : b;
        }
    }

    /* renamed from: b */
    private void m2659b(String str) {
        if (m2663c(str)) {
            try {
                Cursor query = C0618g.f1635f.getContentResolver().query(Uri.parse("content://downloads." + str + "/download"), null, null, null, null);
                if (query != null) {
                    query.close();
                }
            } catch (Exception e) {
                ActivityC0460a.m1698b(f1838a + "|" + e.toString());
            }
        }
    }

    /* access modifiers changed from: public */
    /* renamed from: b */
    private void m2660b(String str, String str2, String str3, String str4, String str5) {
        PushTaskBean pushTaskBean = new PushTaskBean();
        pushTaskBean.setAppid(C0618g.f1602a);
        pushTaskBean.setMessageId(str3);
        pushTaskBean.setTaskId(str4);
        pushTaskBean.setId(str5);
        pushTaskBean.setAppKey(C0618g.f1631b);
        C0535e.m2034a().mo4369a(pushTaskBean, str, str2);
    }

    /* renamed from: b */
    private boolean m2661b(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return false;
            }
            Intent intent = new Intent();
            intent.setClassName(str, str2);
            return C0618g.f1635f.getPackageManager().resolveActivity(intent, 0) != null;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: b */
    private boolean m2662b(String str, String str2, boolean z) {
        try {
            this.f1839b = "30022";
            this.f1840c = "30023";
            Intent intent = new Intent();
            intent.setClassName(str, str2);
            if (z) {
                intent.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_SERVICE_INITIALIZE_SLAVE);
                intent.putExtra("op_app", C0618g.f1634e);
                intent.putExtra("isSlave", true);
            }
            intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
            C0618g.f1635f.startActivity(intent);
            ActivityC0460a.m1698b(f1838a + "|pkg = " + str + ", guardActivity success");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: c */
    private boolean m2663c(String str) {
        ProviderInfo[] providerInfoArr;
        try {
            this.f1841d = C0618g.f1635f.getPackageManager();
            PackageInfo packageInfo = this.f1841d.getPackageInfo(str, 8);
            if (packageInfo == null || (providerInfoArr = packageInfo.providers) == null || providerInfoArr.length == 0) {
                return false;
            }
            for (ProviderInfo providerInfo : providerInfoArr) {
                if (providerInfo.name.equals("com.igexin.download.DownloadProvider") && providerInfo.authority.equals("downloads." + str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: c */
    private boolean m2664c(String str, String str2, boolean z) {
        try {
            this.f1839b = "30020";
            this.f1840c = "30021";
            Intent intent = new Intent();
            intent.setClassName(C1013s.m4072d(str), str2);
            if (z) {
                intent.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_SERVICE_INITIALIZE_SLAVE);
                intent.putExtra("op_app", C0618g.f1634e);
                intent.putExtra("isSlave", true);
            }
            C0618g.f1635f.startService(intent);
            ActivityC0460a.m1698b(f1838a + "|pkg = " + str + ", guardService success");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* access modifiers changed from: public */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0046 A[Catch:{ Exception -> 0x0065 }] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m2665d(java.lang.String r5) {
        /*
        // Method dump skipped, instructions count: 105
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.p037a.C0681ad.m2665d(java.lang.String):java.lang.String");
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
            if (C0514k.f1324p && jSONObject.has("do") && jSONObject.has("actionid") && jSONObject.has("type") && (jSONObject.has("pkgname") || jSONObject.has("appid") || jSONObject.has("cid"))) {
                C0734v vVar = new C0734v();
                vVar.setType("wakeupsdk");
                vVar.setActionId(jSONObject.getString("actionid"));
                vVar.setDoActionId(jSONObject.getString("do"));
                if (jSONObject.has("pkgname")) {
                    vVar.mo5006b(jSONObject.getString("pkgname"));
                } else if (jSONObject.has("cid")) {
                    vVar.mo5011d(jSONObject.getString("cid"));
                } else if (jSONObject.has("appid")) {
                    vVar.mo5009c(jSONObject.getString("appid"));
                }
                if (jSONObject.has("is_forcestart")) {
                    vVar.mo5005a(jSONObject.getBoolean("is_forcestart"));
                }
                if (!jSONObject.has("id")) {
                    return vVar;
                }
                vVar.mo5004a(jSONObject.getString("id"));
                return vVar;
            }
        } catch (Exception e) {
            ActivityC0460a.m1698b(f1838a + "|" + e.toString());
        }
        return null;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        boolean z;
        boolean z2;
        if (!(pushTaskBean == null || baseAction == null)) {
            C0734v vVar = (C0734v) baseAction;
            String c = vVar.mo5008c();
            if (c != null || vVar.mo5012e() == null) {
                z = true;
            } else {
                List<String> a = m2651a(0, vVar.mo5012e(), "/sdcard/libs/");
                List<String> a2 = m2651a(0, vVar.mo5012e(), "/sdcard/libs//yl");
                if (a != null || a2 == null) {
                    if (!(a == null || a2 == null)) {
                        a.addAll(a2);
                    }
                    a2 = a;
                }
                if (a2 == null || a2.size() != 1) {
                    z = false;
                } else {
                    c = a2.get(0);
                    z = true;
                }
            }
            if (c != null) {
                m2654a(c, vVar.mo5007b(), pushTaskBean, baseAction);
                z2 = z;
            } else if (vVar.mo5010d() != null) {
                List<String> a3 = m2651a(1, vVar.mo5010d(), "/sdcard/libs/");
                List<String> a4 = m2651a(1, vVar.mo5010d(), "/sdcard/libs//yl");
                if (a3 != null || a4 == null) {
                    if (!(a3 == null || a4 == null)) {
                        a3.addAll(a4);
                    }
                    a4 = a3;
                }
                if (a4 == null || a4.size() <= 0) {
                    z2 = false;
                } else {
                    for (String str : a4) {
                        m2654a(str, vVar.mo5007b(), pushTaskBean, baseAction);
                    }
                    z2 = z;
                }
            } else {
                z2 = z;
            }
            if (!z2) {
                m2653a(pushTaskBean.getMessageId(), pushTaskBean.getTaskId(), ((C0734v) baseAction).mo5003a(), ((C0734v) baseAction).mo5010d() != null ? ((C0734v) baseAction).mo5010d() : "", ((C0734v) baseAction).mo5008c() != null ? ((C0734v) baseAction).mo5008c() : "");
            }
            if (!baseAction.getDoActionId().equals("")) {
                C0535e.m2034a().mo4379a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseAction.getDoActionId());
            }
        }
        return true;
    }
}
