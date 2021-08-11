package com.igexin.push.extension.distribution.basic.p037a;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.core.p027a.p028a.AbstractC0521a;
import com.igexin.push.extension.distribution.basic.p041b.C0730r;
import java.util.List;
import org.json.JSONObject;
import org.pwrd.paho.client.mqttv3.internal.ClientDefaults;

/* renamed from: com.igexin.push.extension.distribution.basic.a.y */
public class C0711y implements AbstractC0521a {

    /* renamed from: a */
    private static final String f1892a = ("EXT-" + C0711y.class.getName());

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public EnumC0554b mo4352a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return EnumC0554b.success;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public BaseAction mo4353a(JSONObject jSONObject) {
        try {
            if (!jSONObject.has("do") || !jSONObject.has("actionid") || !jSONObject.has("type") || !jSONObject.has("intent") || !jSONObject.has("do_failed") || !jSONObject.has("t")) {
                return null;
            }
            String string = jSONObject.getString("intent");
            String string2 = jSONObject.getString("t");
            String string3 = jSONObject.getString("do");
            String string4 = jSONObject.getString("do_failed");
            if ((!string2.equals("0") && !string2.equals("1")) || string4.equals("") || string3.equals("0")) {
                return null;
            }
            C0730r rVar = new C0730r();
            rVar.setType("startintent");
            rVar.setActionId(jSONObject.getString("actionid"));
            rVar.setDoActionId(jSONObject.getString("do"));
            rVar.mo4992b(string);
            rVar.mo4990a(string2);
            rVar.mo4994c(jSONObject.getString("do_failed"));
            return rVar;
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        C0730r rVar = (C0730r) baseAction;
        try {
            Intent parseUri = Intent.parseUri(rVar.mo4991b(), 0);
            try {
                if (rVar.mo4989a().equals("0")) {
                    parseUri.setFlags(ClientDefaults.MAX_MSG_SIZE);
                    C0618g.f1635f.startActivity(parseUri);
                    C0535e.m2034a().mo4379a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), rVar.getDoActionId());
                    return true;
                } else if (!rVar.mo4989a().equals("1")) {
                    return true;
                } else {
                    List<ResolveInfo> queryIntentServices = C0618g.f1635f.getPackageManager().queryIntentServices(parseUri, 0);
                    if (queryIntentServices == null || queryIntentServices.size() <= 0) {
                        ActivityC0460a.m1698b("StartIntentAction err intent=" + rVar.mo4991b() + " t=" + rVar.mo4989a());
                        C0535e.m2034a().mo4379a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), rVar.mo4993c());
                        return true;
                    }
                    C0618g.f1635f.startService(parseUri);
                    C0535e.m2034a().mo4379a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), rVar.getDoActionId());
                    return true;
                }
            } catch (Exception e) {
                ActivityC0460a.m1698b(f1892a + "|executeAction err intent=" + rVar.mo4991b() + " t=" + rVar.mo4989a());
                C0535e.m2034a().mo4379a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), rVar.mo4993c());
                return true;
            }
        } catch (Exception e2) {
            return true;
        }
    }
}
