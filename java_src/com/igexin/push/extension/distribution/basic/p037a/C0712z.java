package com.igexin.push.extension.distribution.basic.p037a;

import android.content.Intent;
import android.text.TextUtils;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.core.p027a.p028a.AbstractC0521a;
import com.igexin.push.extension.distribution.basic.p041b.C0731s;
import com.igexin.push.extension.distribution.basic.util.C0997c;
import org.json.JSONObject;
import org.pwrd.paho.client.mqttv3.internal.ClientDefaults;

/* renamed from: com.igexin.push.extension.distribution.basic.a.z */
public class C0712z implements AbstractC0521a {
    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public EnumC0554b mo4352a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        C0731s sVar = (C0731s) baseAction;
        try {
            Intent parseUri = Intent.parseUri(sVar.mo4995a(), 0);
            parseUri.setPackage(C0618g.f1635f.getPackageName());
            parseUri.addFlags(ClientDefaults.MAX_MSG_SIZE);
            if (C0997c.m4000a(parseUri, C0618g.f1635f)) {
                return EnumC0554b.success;
            }
            ActivityC0460a.m1698b("EXT-StartMyActivity|execute failed, activity not exist");
            C0535e.m2034a().mo4379a(pushTaskBean.getId(), pushTaskBean.getMessageId(), sVar.mo4997b());
            return EnumC0554b.stop;
        } catch (Throwable th) {
            ActivityC0460a.m1698b("EXT-StartMyActivity|execute exception = " + th.toString());
            C0535e.m2034a().mo4379a(pushTaskBean.getId(), pushTaskBean.getMessageId(), sVar.mo4997b());
            return EnumC0554b.stop;
        }
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public BaseAction mo4353a(JSONObject jSONObject) {
        try {
            if (jSONObject.has("do") && jSONObject.has("actionid") && jSONObject.has("type") && jSONObject.has("uri") && jSONObject.has("do_failed")) {
                String string = jSONObject.getString("uri");
                if (!TextUtils.isEmpty(string)) {
                    C0731s sVar = new C0731s();
                    sVar.setType("startmyactivity");
                    sVar.setActionId(jSONObject.getString("actionid"));
                    sVar.setDoActionId(jSONObject.getString("do"));
                    sVar.mo4996a(string);
                    sVar.mo4998b(jSONObject.getString("do_failed"));
                    return sVar;
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        C0731s sVar = (C0731s) baseAction;
        try {
            Intent parseUri = Intent.parseUri(sVar.mo4995a(), 0);
            parseUri.setPackage(C0618g.f1635f.getPackageName());
            parseUri.addFlags(ClientDefaults.MAX_MSG_SIZE);
            if (C0997c.m4000a(parseUri, C0618g.f1635f)) {
                C0618g.f1635f.startActivity(parseUri);
                C0535e.m2034a().mo4379a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), sVar.getDoActionId());
                return true;
            }
            ActivityC0460a.m1698b("EXT-StartMyActivity|execute failed, activity not exist");
            C0535e.m2034a().mo4379a(pushTaskBean.getId(), pushTaskBean.getMessageId(), sVar.mo4997b());
            return true;
        } catch (Throwable th) {
            ActivityC0460a.m1698b("EXT-StartMyActivity|execute exception = " + th.getMessage());
            C0535e.m2034a().mo4379a(pushTaskBean.getId(), pushTaskBean.getMessageId(), sVar.mo4997b());
            return true;
        }
    }
}
