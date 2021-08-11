package com.igexin.push.extension.distribution.basic.p037a;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.core.p027a.p028a.AbstractC0521a;
import com.igexin.push.extension.distribution.basic.p041b.C0719g;
import java.util.ArrayList;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.basic.a.h */
public class C0694h implements AbstractC0521a {

    /* renamed from: a */
    private static final String f1862a = C0694h.class.getName();

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public EnumC0554b mo4352a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return EnumC0554b.success;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public BaseAction mo4353a(JSONObject jSONObject) {
        try {
            if (jSONObject.has("type") && jSONObject.has("actionid") && jSONObject.has("apptype") && jSONObject.has("appmaxthrehold") && jSONObject.has("appminthrehold") && jSONObject.has("do_unusual") && jSONObject.has("do_usual")) {
                C0719g gVar = new C0719g();
                gVar.setActionId(jSONObject.getString("actionid"));
                gVar.setType(jSONObject.getString("type"));
                if (jSONObject.getString("apptype").equals("user") || jSONObject.getString("apptype").equals("getui")) {
                    gVar.mo4837a(jSONObject.getString("apptype"));
                    gVar.mo4836a(jSONObject.getInt("appmaxthrehold"));
                    gVar.mo4839b(jSONObject.getInt("appminthrehold"));
                    gVar.mo4840b(jSONObject.getString("do_unusual"));
                    gVar.mo4842c(jSONObject.getString("do_usual"));
                    return gVar;
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    /* renamed from: a */
    public boolean mo4772a(C0719g gVar) {
        ServiceInfo[] serviceInfoArr;
        ArrayList arrayList = new ArrayList();
        if (gVar.mo4835a().equals("user")) {
            PackageManager packageManager = C0618g.f1635f.getPackageManager();
            for (PackageInfo packageInfo : packageManager.getInstalledPackages(0)) {
                if ((packageManager.getApplicationInfo(packageInfo.packageName, 0).flags & 1) == 0) {
                    arrayList.add(packageInfo);
                }
            }
        } else if (gVar.mo4835a().equals("getui")) {
            for (PackageInfo packageInfo2 : C0618g.f1635f.getPackageManager().getInstalledPackages(4)) {
                if (((packageInfo2.applicationInfo.flags & 1) == 0 || (packageInfo2.applicationInfo.flags & 128) == 1) && (serviceInfoArr = packageInfo2.services) != null && serviceInfoArr.length != 0) {
                    int length = serviceInfoArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        ServiceInfo serviceInfo = serviceInfoArr[i];
                        if ("com.igexin.sdk.coordinator.SdkMsgService".equals(serviceInfo.name) || "com.igexin.sdk.PushService".equals(serviceInfo.name) || "com.igexin.sdk.coordinator.GexinMsgService".equals(serviceInfo.name)) {
                            arrayList.add(packageInfo2);
                        } else {
                            i++;
                        }
                    }
                    arrayList.add(packageInfo2);
                }
            }
        }
        int size = arrayList.size();
        ActivityC0460a.m1698b(f1862a + ": ac:" + size);
        return size >= gVar.mo4841c() && size <= gVar.mo4838b();
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        try {
            C0719g gVar = (C0719g) baseAction;
            String taskId = pushTaskBean.getTaskId();
            String messageId = pushTaskBean.getMessageId();
            String e = mo4772a(gVar) ? gVar.mo4844e() : gVar.mo4843d();
            if (e == null) {
                ActivityC0460a.m1698b(f1862a + "|not write next actionid");
            } else {
                C0535e.m2034a().mo4379a(taskId, messageId, e);
            }
        } catch (Throwable th) {
        }
        return true;
    }
}
