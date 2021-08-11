package com.igexin.push.extension.distribution.basic.p037a;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.p028a.AbstractC0521a;
import com.igexin.push.extension.distribution.basic.p041b.C0716d;
import com.igexin.push.extension.distribution.basic.p053h.C0768a;
import com.igexin.push.extension.distribution.basic.p053h.C0775h;
import com.tencent.qcloud.core.util.IOUtils;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.basic.a.ab */
public class C0679ab implements AbstractC0521a {

    /* renamed from: a */
    private static final String f1837a = ("EXT-" + C0679ab.class.getName());

    /* renamed from: a */
    private void m2638a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                C0456c.m1661b().mo4216a(new C0768a(new C0775h(str.getBytes("UTF-8"), 5)), false, true);
            }
        } catch (Exception e) {
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
            if (jSONObject.has("type") && jSONObject.has("actionid")) {
                String string = jSONObject.getString("type");
                String string2 = jSONObject.getString("actionid");
                BaseAction baseAction = new BaseAction();
                baseAction.setActionId(string2);
                baseAction.setType(string);
                return baseAction;
            }
        } catch (Exception e) {
        }
        return null;
    }

    /* renamed from: a */
    public List<ActivityManager.RunningServiceInfo> mo4761a() {
        try {
            return ((ActivityManager) C0618g.f1635f.getSystemService("activity")).getRunningServices(2000);
        } catch (Throwable th) {
            return new ArrayList();
        }
    }

    /* renamed from: a */
    public boolean mo4762a(Context context, String str, String str2, List<ActivityManager.RunningServiceInfo> list) {
        boolean z;
        try {
            if (list.size() <= 0) {
                return false;
            }
            int i = 0;
            while (true) {
                if (i < list.size()) {
                    if (list.get(i).service.getClassName().equals(str) && list.get(i).service.getPackageName().equals(str2)) {
                        z = true;
                        break;
                    }
                    i++;
                } else {
                    z = false;
                    break;
                }
            }
            return z;
        } catch (Exception e) {
            z = false;
        }
    }

    /* renamed from: b */
    public HashMap<String, C0716d> mo4763b() {
        ServiceInfo[] serviceInfoArr;
        C0716d dVar;
        HashMap<String, C0716d> hashMap = new HashMap<>();
        List<PackageInfo> installedPackages = C0618g.f1635f.getPackageManager().getInstalledPackages(4);
        if (installedPackages != null) {
            List<ActivityManager.RunningServiceInfo> a = mo4761a();
            for (PackageInfo packageInfo : installedPackages) {
                try {
                    if (((packageInfo.applicationInfo.flags & 1) == 0 || (packageInfo.applicationInfo.flags & 128) == 1) && (serviceInfoArr = packageInfo.services) != null) {
                        for (ServiceInfo serviceInfo : serviceInfoArr) {
                            try {
                                String str = packageInfo.packageName;
                                String str2 = serviceInfo.name;
                                if (hashMap.containsKey(str)) {
                                    dVar = hashMap.get(str);
                                    if (mo4762a(C0618g.f1635f, str2, str, a)) {
                                        dVar.mo4827b(dVar.mo4825a() + MiPushClient.ACCEPT_TIME_SEPARATOR + str2 + "#1");
                                    } else {
                                        dVar.mo4827b(dVar.mo4825a() + MiPushClient.ACCEPT_TIME_SEPARATOR + str2 + "#0");
                                    }
                                } else {
                                    dVar = new C0716d();
                                    dVar.mo4826a(str);
                                    if (mo4762a(C0618g.f1635f, str2, str, a)) {
                                        dVar.mo4827b(str2 + "#1");
                                    } else {
                                        dVar.mo4827b(str2 + "#0");
                                    }
                                }
                                hashMap.put(str, dVar);
                            } catch (Exception e) {
                            }
                        }
                    }
                } catch (Exception e2) {
                }
            }
        }
        return hashMap;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        if (baseAction == null) {
            return true;
        }
        try {
            HashMap<String, C0716d> b = mo4763b();
            if (b.size() <= 0) {
                return true;
            }
            StringBuilder sb = new StringBuilder();
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
            for (String str : b.keySet()) {
                try {
                    sb.append(format);
                    sb.append("|");
                    sb.append(C0618g.f1647r);
                    sb.append("|");
                    sb.append(C0618g.f1602a);
                    sb.append("|");
                    sb.append(pushTaskBean.getTaskId());
                    sb.append("|");
                    sb.append(C0618g.f1635f.getPackageName());
                    sb.append("|");
                    sb.append(str);
                    sb.append("|");
                    sb.append(b.get(str).mo4825a());
                    sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                } catch (Exception e) {
                }
            }
            m2638a(sb.toString());
            return true;
        } catch (Exception e2) {
            return true;
        }
    }
}
