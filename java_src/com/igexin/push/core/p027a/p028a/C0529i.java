package com.igexin.push.core.p027a.p028a;

import android.content.Intent;
import android.content.pm.PackageManager;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.config.C0513j;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.C0598k;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.util.C1151a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.a.i */
public class C0529i implements AbstractC0521a {

    /* renamed from: a */
    private static final String f1356a = C0513j.f1294a;

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public EnumC0554b mo4352a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return EnumC0554b.success;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public BaseAction mo4353a(JSONObject jSONObject) {
        try {
            C0598k kVar = new C0598k();
            kVar.setType("startapp");
            kVar.setActionId(jSONObject.getString("actionid"));
            kVar.setDoActionId(jSONObject.getString("do"));
            if (jSONObject.has("appstartupid")) {
                kVar.mo4555a(jSONObject.getJSONObject("appstartupid").getString("android"));
            }
            if (jSONObject.has("is_autostart")) {
                kVar.mo4561d(jSONObject.getString("is_autostart"));
            }
            if (jSONObject.has("appid")) {
                kVar.mo4557b(jSONObject.getString("appid"));
            }
            if (!jSONObject.has("noinstall_action")) {
                return kVar;
            }
            kVar.mo4559c(jSONObject.getString("noinstall_action"));
            return kVar;
        } catch (JSONException e) {
            return null;
        }
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        boolean z;
        boolean z2 = false;
        if (!(pushTaskBean == null || baseAction == null)) {
            C0598k kVar = (C0598k) baseAction;
            PackageManager packageManager = C0618g.f1635f.getPackageManager();
            String b = kVar.mo4556b();
            if (b.equals("")) {
                b = C0618g.f1602a;
                z = true;
            } else {
                z = C0618g.f1602a.equals(kVar.mo4556b());
            }
            ActivityC0460a.m1698b("doStartApp|" + z + "|" + b);
            if (z) {
                try {
                    C0535e.m2034a().mo4373a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), b, (String) null);
                    if (((C0598k) baseAction).mo4560d().equals("true")) {
                        Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(C0618g.f1634e);
                        if (launchIntentForPackage == null) {
                            return false;
                        }
                        C0618g.f1635f.startActivity(launchIntentForPackage);
                    }
                    if (kVar.getDoActionId() != null) {
                        C0535e.m2034a().mo4379a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), kVar.getDoActionId());
                    }
                } catch (Exception e) {
                }
            } else {
                C0535e.m2034a().mo4373a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), b, (String) null);
                if (!kVar.mo4560d().equals("true")) {
                    z2 = true;
                } else if (C1151a.m4743a(kVar.mo4554a())) {
                    Intent launchIntentForPackage2 = packageManager.getLaunchIntentForPackage(((C0598k) baseAction).mo4554a());
                    if (launchIntentForPackage2 == null) {
                        return false;
                    }
                    C0618g.f1635f.startActivity(launchIntentForPackage2);
                    z2 = true;
                }
                if (z2) {
                    if (kVar.getDoActionId() != null) {
                        C0535e.m2034a().mo4379a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), kVar.getDoActionId());
                    }
                } else if (kVar.mo4558c() != null) {
                    C0535e.m2034a().mo4379a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), kVar.mo4558c());
                }
            }
        }
        return true;
    }
}
