package com.igexin.push.core.p027a.p028a;

import android.app.ActivityManager;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.config.C0514k;
import com.igexin.push.core.C0519a;
import com.igexin.push.core.C0617f;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.C0601n;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.sdk.PushConsts;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.igexin.push.core.a.a.j */
public class C0530j implements AbstractC0521a {

    /* renamed from: b */
    private static final String f1357b = C0519a.f1350n;

    /* renamed from: c */
    private static final String f1358c = C0519a.f1352p;

    /* renamed from: d */
    private static final String f1359d = C0519a.f1351o;

    /* renamed from: a */
    private PackageManager f1360a;

    /* renamed from: a */
    private String m2007a(String str) {
        try {
            List<PackageInfo> installedPackages = C0618g.f1635f.getPackageManager().getInstalledPackages(4);
            if (installedPackages != null) {
                for (PackageInfo packageInfo : installedPackages) {
                    if (str.equals(packageInfo.packageName)) {
                        ServiceInfo[] serviceInfoArr = packageInfo.services;
                        for (ServiceInfo serviceInfo : serviceInfoArr) {
                            if (f1357b.equals(serviceInfo.name) || f1359d.equals(serviceInfo.name) || f1358c.equals(serviceInfo.name)) {
                                return serviceInfo.name;
                            }
                        }
                        continue;
                    }
                }
            }
        } catch (Exception e) {
            ActivityC0460a.m1698b(e.toString());
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008f, code lost:
        r4 = r5;
        r0 = r1;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x018a, code lost:
        r0 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x00b7 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00af A[SYNTHETIC, Splitter:B:31:0x00af] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b4 A[SYNTHETIC, Splitter:B:34:0x00b4] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x018a A[ExcHandler: all (th java.lang.Throwable), Splitter:B:22:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x018d A[SYNTHETIC, Splitter:B:72:0x018d] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0192 A[SYNTHETIC, Splitter:B:75:0x0192] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<java.lang.String> m2008a(int r14, java.lang.String r15) {
        /*
        // Method dump skipped, instructions count: 590
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.p027a.p028a.C0530j.m2008a(int, java.lang.String):java.util.List");
    }

    /* renamed from: a */
    private void m2010a(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        sb.append(C0618g.f1635f.getPackageName());
        sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
        sb.append(str4);
        sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
        sb.append(str5);
        sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
        sb.append("-1");
        m2016b("30025", sb.toString(), str, str2, str3);
        ActivityC0460a.m1698b("feedback actionId=30025 result=" + sb.toString());
    }

    /* renamed from: a */
    private void m2011a(String str, boolean z, PushTaskBean pushTaskBean, BaseAction baseAction) {
        try {
            String a = m2007a(str);
            String messageId = pushTaskBean.getMessageId();
            String taskId = pushTaskBean.getTaskId();
            String a2 = ((C0601n) baseAction).mo4577a();
            m2015b(str);
            if (a != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("messageId", messageId);
                hashMap.put("taskId", taskId);
                hashMap.put("id", a2);
                hashMap.put("pkgName", str);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(C0618g.f1635f.getPackageName());
                stringBuffer.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                stringBuffer.append(m2019d(str));
                stringBuffer.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                stringBuffer.append(str);
                stringBuffer.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                if (a.equals(f1357b)) {
                    stringBuffer.append(f1357b);
                    stringBuffer.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                    if (m2014a(str, f1357b)) {
                        stringBuffer.append("0");
                    } else {
                        if (z) {
                            try {
                                Intent intent = new Intent();
                                intent.setClassName(str, a);
                                intent.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_SERVICE_INITIALIZE_SLAVE);
                                intent.putExtra("op_app", C0618g.f1634e);
                                intent.putExtra("isSlave", true);
                                C0618g.f1635f.startService(intent);
                            } catch (Exception e) {
                                ActivityC0460a.m1698b(e.toString());
                                m2012a(stringBuffer, messageId, taskId, a2);
                                return;
                            }
                        } else if (!m2017b(str, a)) {
                            m2012a(stringBuffer, messageId, taskId, a2);
                            return;
                        }
                        hashMap.put("serviceName", f1357b);
                        m2013a(hashMap);
                        stringBuffer.append("1");
                    }
                } else if (a.equals(f1359d)) {
                    stringBuffer.append(f1359d);
                    stringBuffer.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                    if (m2014a(str, f1359d)) {
                        stringBuffer.append("0");
                    } else if (!m2017b(str, a)) {
                        m2012a(stringBuffer, messageId, taskId, a2);
                        return;
                    } else {
                        hashMap.put("serviceName", f1359d);
                        m2013a(hashMap);
                        stringBuffer.append("1");
                    }
                } else if (a.equals(f1358c)) {
                    stringBuffer.append(f1358c);
                    stringBuffer.append(MqttTopic.MULTI_LEVEL_WILDCARD);
                    if (m2014a(str, f1358c)) {
                        stringBuffer.append("0");
                    } else if (!m2017b(str, a)) {
                        m2012a(stringBuffer, messageId, taskId, a2);
                        return;
                    } else {
                        hashMap.put("serviceName", f1358c);
                        m2013a(hashMap);
                        stringBuffer.append("1");
                    }
                }
                m2016b("30025", stringBuffer.toString(), messageId, taskId, a2);
                ActivityC0460a.m1698b("feedback actionId=30025 result=" + stringBuffer.toString());
                return;
            }
            m2010a(messageId, taskId, a2, ((C0601n) baseAction).mo4584d() != null ? ((C0601n) baseAction).mo4584d() : "", ((C0601n) baseAction).mo4582c() != null ? ((C0601n) baseAction).mo4582c() : "");
        } catch (Throwable th) {
            ActivityC0460a.m1698b("WakeupAction|" + th.toString());
        }
    }

    /* renamed from: a */
    private void m2012a(StringBuffer stringBuffer, String str, String str2, String str3) {
        stringBuffer.append("-1");
        m2016b("30025", stringBuffer.toString(), str, str2, str3);
        ActivityC0460a.m1698b("feedback actionId=30025 result=" + stringBuffer.toString());
    }

    /* renamed from: a */
    private void m2013a(Map<String, String> map) {
        C0617f.m2395a().mo4619a(new C0531k(this, 180000, map));
    }

    /* renamed from: a */
    public static boolean m2014a(String str, String str2) {
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) C0618g.f1635f.getSystemService("activity")).getRunningServices(2000);
        if (runningServices.size() <= 0) {
            return false;
        }
        for (int i = 0; i < runningServices.size(); i++) {
            if (runningServices.get(i).service.getClassName().equals(str2) && runningServices.get(i).service.getPackageName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m2015b(String str) {
        if (m2018c(str)) {
            try {
                Cursor query = C0618g.f1635f.getContentResolver().query(Uri.parse("content://downloads." + str + "/download"), null, null, null, null);
                if (query != null) {
                    query.close();
                }
            } catch (Exception e) {
                ActivityC0460a.m1698b(e.toString());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2016b(String str, String str2, String str3, String str4, String str5) {
        PushTaskBean pushTaskBean = new PushTaskBean();
        pushTaskBean.setAppid(C0618g.f1602a);
        pushTaskBean.setMessageId(str3);
        pushTaskBean.setTaskId(str4);
        pushTaskBean.setId(str5);
        pushTaskBean.setAppKey(C0618g.f1631b);
        C0535e.m2034a().mo4369a(pushTaskBean, str, str2);
    }

    /* renamed from: b */
    private boolean m2017b(String str, String str2) {
        try {
            Intent intent = new Intent();
            intent.setClassName(str, str2);
            C0618g.f1635f.startService(intent);
            return true;
        } catch (Exception e) {
            ActivityC0460a.m1698b("WakeupAction|" + e.toString());
            return false;
        }
    }

    /* renamed from: c */
    private boolean m2018c(String str) {
        ProviderInfo[] providerInfoArr;
        try {
            this.f1360a = C0618g.f1635f.getPackageManager();
            PackageInfo packageInfo = this.f1360a.getPackageInfo(str, 8);
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

    /* access modifiers changed from: private */
    /* renamed from: d */
    public String m2019d(String str) {
        try {
            this.f1360a = C0618g.f1635f.getPackageManager();
            Bundle bundle = this.f1360a.getApplicationInfo(str, 128).metaData;
            if (bundle != null) {
                for (String str2 : bundle.keySet()) {
                    if (str2.equals(AssistPushConsts.GETUI_APPID)) {
                        return bundle.get(str2).toString();
                    }
                }
            }
        } catch (Exception e) {
        }
        return "";
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
                C0601n nVar = new C0601n();
                nVar.setType("wakeupsdk");
                nVar.setActionId(jSONObject.getString("actionid"));
                nVar.setDoActionId(jSONObject.getString("do"));
                if (jSONObject.has("pkgname")) {
                    nVar.mo4580b(jSONObject.getString("pkgname"));
                } else if (jSONObject.has("cid")) {
                    nVar.mo4585d(jSONObject.getString("cid"));
                } else if (jSONObject.has("appid")) {
                    nVar.mo4583c(jSONObject.getString("appid"));
                }
                if (jSONObject.has("is_forcestart")) {
                    nVar.mo4579a(jSONObject.getBoolean("is_forcestart"));
                }
                if (!jSONObject.has("id")) {
                    return nVar;
                }
                nVar.mo4578a(jSONObject.getString("id"));
                return nVar;
            }
        } catch (JSONException e) {
            ActivityC0460a.m1698b(e.toString());
        }
        return null;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        boolean z;
        boolean z2;
        if (!(pushTaskBean == null || baseAction == null)) {
            C0601n nVar = (C0601n) baseAction;
            String c = nVar.mo4582c();
            if (c != null || nVar.mo4586e() == null) {
                z = true;
            } else {
                List<String> a = m2008a(0, nVar.mo4586e());
                if (a == null || a.size() != 1) {
                    z = false;
                } else {
                    c = a.get(0);
                    z = true;
                }
            }
            if (c != null) {
                m2011a(c, nVar.mo4581b(), pushTaskBean, baseAction);
                z2 = z;
            } else if (nVar.mo4584d() != null) {
                List<String> a2 = m2008a(1, nVar.mo4584d());
                if (a2 == null || a2.size() <= 0) {
                    z2 = false;
                } else {
                    for (String str : a2) {
                        m2011a(str, nVar.mo4581b(), pushTaskBean, baseAction);
                    }
                    z2 = z;
                }
            } else {
                z2 = z;
            }
            if (!z2) {
                m2010a(pushTaskBean.getMessageId(), pushTaskBean.getTaskId(), ((C0601n) baseAction).mo4577a(), ((C0601n) baseAction).mo4584d() != null ? ((C0601n) baseAction).mo4584d() : "", ((C0601n) baseAction).mo4582c() != null ? ((C0601n) baseAction).mo4582c() : "");
            }
            if (!baseAction.getDoActionId().equals("")) {
                C0535e.m2034a().mo4379a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseAction.getDoActionId());
            }
        }
        return true;
    }
}
