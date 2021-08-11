package com.igexin.push.extension.distribution.basic.p037a;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.PowerManager;
import android.text.TextUtils;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.core.p027a.p028a.AbstractC0521a;
import com.igexin.push.extension.distribution.basic.p041b.C0729q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import org.pwrd.paho.client.mqttv3.internal.ClientDefaults;

/* renamed from: com.igexin.push.extension.distribution.basic.a.x */
public class C0710x implements AbstractC0521a {

    /* renamed from: a */
    private static final String f1891a = ("EXT-" + C0710x.class.getName());

    /* renamed from: a */
    private ActivityInfo m2762a(String str, C0729q qVar) {
        ActivityInfo activityInfo;
        Exception e;
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
            intent.setData(Uri.parse(str));
            List<ResolveInfo> queryIntentActivities = C0618g.f1635f.getPackageManager().queryIntentActivities(intent, 0);
            ArrayList arrayList = new ArrayList();
            if (!(qVar == null || qVar.mo4987d() == null || qVar.mo4987d().size() <= 0)) {
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    for (String str2 : qVar.mo4987d()) {
                        if (resolveInfo.activityInfo.packageName.equals(str2)) {
                            arrayList.add(resolveInfo);
                        }
                    }
                }
                queryIntentActivities.removeAll(arrayList);
            }
            if (!(qVar == null || qVar.mo4985c() == null || qVar.mo4985c().size() <= 0)) {
                for (String str3 : qVar.mo4985c()) {
                    Iterator<ResolveInfo> it = queryIntentActivities.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            ResolveInfo next = it.next();
                            if (next.activityInfo.packageName.equals(str3)) {
                                return next.activityInfo;
                            }
                        }
                    }
                }
            }
            activityInfo = null;
            for (ResolveInfo resolveInfo2 : queryIntentActivities) {
                try {
                    ActivityC0460a.m1698b(f1891a + "-> browser pkg = " + resolveInfo2.activityInfo.packageName);
                    ActivityC0460a.m1698b(f1891a + "-> browser activity = " + resolveInfo2.activityInfo.name);
                    activityInfo = activityInfo == null ? resolveInfo2.activityInfo : activityInfo;
                } catch (Exception e2) {
                    e = e2;
                    ActivityC0460a.m1698b(f1891a + e.toString());
                    return activityInfo;
                }
            }
            return activityInfo;
        } catch (Exception e3) {
            e = e3;
            activityInfo = null;
            ActivityC0460a.m1698b(f1891a + e.toString());
            return activityInfo;
        }
    }

    /* renamed from: a */
    private void m2763a() {
        try {
            PowerManager.WakeLock newWakeLock = ((PowerManager) C0618g.f1635f.getSystemService("power")).newWakeLock(805306394, "");
            newWakeLock.acquire(10000);
            newWakeLock.release();
        } catch (Throwable th) {
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
            if (!jSONObject.has("do") || !jSONObject.has("actionid") || !jSONObject.has("type") || !jSONObject.has("url")) {
                return null;
            }
            String string = jSONObject.getString("url");
            if (TextUtils.isEmpty(string) || string.equals("")) {
                return null;
            }
            C0729q qVar = new C0729q();
            qVar.setType("startanyweb");
            qVar.setActionId(jSONObject.getString("actionid"));
            qVar.setDoActionId(jSONObject.getString("do"));
            if (jSONObject.has("blacklist")) {
                qVar.mo4986c(jSONObject.getString("blacklist"));
            }
            if (jSONObject.has("whitelist")) {
                qVar.mo4983b(jSONObject.getString("whitelist"));
            }
            if (jSONObject.has("forcescreenon")) {
                qVar.mo4984b(jSONObject.getString("forcescreenon").equals("true"));
            }
            if (jSONObject.has("is_withcid") && jSONObject.getString("is_withcid").equals("true")) {
                qVar.mo4980a(true);
            }
            qVar.mo4979a(string);
            return qVar;
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    public String mo4782a(C0729q qVar) {
        String trim = qVar.mo4982b().trim();
        try {
            return qVar.mo4981a() ? trim.indexOf("?") > 0 ? trim + "&cid=" + C0618g.f1647r : trim + "?cid=" + C0618g.f1647r : trim;
        } catch (Exception e) {
            return trim;
        }
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        try {
            C0729q qVar = (C0729q) baseAction;
            String a = mo4782a(qVar);
            ActivityInfo a2 = m2762a(a, qVar);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(a));
            intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
            intent.setClassName(a2.packageName, a2.name);
            C0535e.m2034a().mo4419u();
            if (qVar.mo4988e() && C0618g.f1645p == 0 && (a2.packageName.equals("com.android.browser") || a2.packageName.equals("com.sec.android.app.sbrowser") || a2.packageName.equals("com.vivo.browser") || a2.packageName.equals("com.android.chrome") || a2.packageName.equals("com.htc.browser.providerproxy") || a2.packageName.equals("com.htc.sense.browser"))) {
                m2763a();
            }
            C0618g.f1635f.startActivity(intent);
            C0535e.m2034a().mo4369a(pushTaskBean, "32000", "adPkg:" + a2.packageName);
            if (baseAction.getDoActionId().equals("")) {
                return true;
            }
            C0535e.m2034a().mo4379a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseAction.getDoActionId());
            return true;
        } catch (Exception e) {
            return true;
        }
    }
}
