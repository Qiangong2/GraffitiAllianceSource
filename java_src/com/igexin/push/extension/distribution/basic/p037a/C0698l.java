package com.igexin.push.extension.distribution.basic.p037a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.core.p027a.p028a.AbstractC0521a;
import com.igexin.push.extension.distribution.basic.p041b.C0723k;
import com.umeng.analytics.C1370a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.basic.a.l */
public class C0698l implements AbstractC0521a {

    /* renamed from: a */
    private static final String f1866a = ("EXT-" + C0698l.class.getName());

    @TargetApi(9)
    /* renamed from: a */
    public static long m2713a(Context context, C0723k kVar) {
        try {
            if (Build.VERSION.SDK_INT < 9) {
                ActivityC0460a.m1698b(f1866a + "userGetPhoneTime exception Build.VERSION.SDK_INT < Build.VERSION_CODES.GINGERBREAD");
                return System.currentTimeMillis() + C1370a.f3217i;
            }
            ArrayList arrayList = new ArrayList();
            PackageManager packageManager = context.getPackageManager();
            for (PackageInfo packageInfo : packageManager.getInstalledPackages(0)) {
                if ((packageManager.getApplicationInfo(packageInfo.packageName, 0).flags & 1) == 0) {
                    arrayList.add(packageInfo);
                }
            }
            Collections.sort(arrayList, new C0699m());
            Iterator it = arrayList.iterator();
            long j = 0;
            while (it.hasNext()) {
                PackageInfo packageInfo2 = (PackageInfo) it.next();
                if (j == 0) {
                    j = packageInfo2.firstInstallTime;
                }
                if ((packageInfo2.firstInstallTime - j) / ((long) 60000) < ((long) kVar.mo4872b())) {
                    it.remove();
                }
            }
            if (arrayList.size() >= 3) {
                return ((PackageInfo) arrayList.get(2)).firstInstallTime;
            }
            return System.currentTimeMillis() + C1370a.f3217i;
        } catch (Throwable th) {
            ActivityC0460a.m1698b(f1866a + "userGetPhoneTime exception:" + th.toString());
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
            if (jSONObject.has("type") && jSONObject.has("actionid") && jSONObject.has("do_over") && jSONObject.has("do_inner")) {
                C0723k kVar = new C0723k();
                kVar.setActionId(jSONObject.getString("actionid"));
                kVar.mo4874b(jSONObject.getString("do_inner"));
                kVar.mo4871a(jSONObject.getString("do_over"));
                kVar.setType(jSONObject.getString("type"));
                if (jSONObject.has("limittime")) {
                    kVar.mo4870a(jSONObject.getInt("limittime"));
                } else {
                    kVar.mo4870a(15);
                }
                if (jSONObject.has("removetime")) {
                    kVar.mo4873b(jSONObject.getInt("removetime"));
                    return kVar;
                }
                kVar.mo4873b(5);
                return kVar;
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        try {
            C0723k kVar = (C0723k) baseAction;
            String taskId = pushTaskBean.getTaskId();
            String messageId = pushTaskBean.getMessageId();
            if ((System.currentTimeMillis() - m2713a(C0618g.f1635f, kVar)) / C1370a.f3217i < ((long) kVar.mo4869a())) {
                C0535e.m2034a().mo4379a(taskId, messageId, kVar.mo4876d());
                return true;
            }
            C0535e.m2034a().mo4379a(taskId, messageId, kVar.mo4875c());
            return true;
        } catch (Throwable th) {
            return true;
        }
    }
}
