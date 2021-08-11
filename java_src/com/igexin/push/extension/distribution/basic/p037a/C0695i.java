package com.igexin.push.extension.distribution.basic.p037a;

import android.content.pm.ApplicationInfo;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.core.p027a.p028a.AbstractC0521a;
import com.igexin.push.extension.distribution.basic.p041b.C0720h;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.basic.a.i */
public class C0695i implements AbstractC0521a {

    /* renamed from: a */
    private static final String f1863a = C0695i.class.getName();

    /* renamed from: a */
    public ApplicationInfo mo4773a(String str) {
        try {
            return C0618g.f1635f.getPackageManager().getApplicationInfo(str, 0);
        } catch (Throwable th) {
            return null;
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
            if (jSONObject.has("actionid")) {
                C0720h hVar = new C0720h();
                hVar.setType(jSONObject.getString("type"));
                hVar.setActionId(jSONObject.getString("actionid"));
                if (jSONObject.has("appstartupid")) {
                    JSONObject jSONObject2 = new JSONObject(jSONObject.getString("appstartupid"));
                    if (jSONObject2.has("android")) {
                        hVar.mo4846a(jSONObject2.getString("android"));
                        if (jSONObject.has("do_normalinstalled") || jSONObject.has("do_preinstalled") || jSONObject.has("do_uninstalled")) {
                            if (jSONObject.has("do_normalinstalled")) {
                                hVar.mo4848b(jSONObject.getString("do_normalinstalled"));
                            }
                            if (jSONObject.has("do_preinstalled")) {
                                hVar.mo4850c(jSONObject.getString("do_preinstalled"));
                            }
                            if (!jSONObject.has("do_uninstalled")) {
                                return hVar;
                            }
                            hVar.mo4852d(jSONObject.getString("do_uninstalled"));
                            return hVar;
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        try {
            C0720h hVar = (C0720h) baseAction;
            String taskId = pushTaskBean.getTaskId();
            String messageId = pushTaskBean.getMessageId();
            ApplicationInfo a = mo4773a(hVar.mo4845a());
            String b = a != null ? (a.flags & 1) <= 0 ? hVar.mo4847b() : hVar.mo4849c() : hVar.mo4851d();
            if (b == null) {
                ActivityC0460a.m1698b(f1863a + "|not write next actionid");
            } else {
                C0535e.m2034a().mo4379a(taskId, messageId, b);
            }
        } catch (Throwable th) {
        }
        return true;
    }
}
