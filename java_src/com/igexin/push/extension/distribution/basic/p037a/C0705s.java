package com.igexin.push.extension.distribution.basic.p037a;

import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.push.core.C0519a;
import com.igexin.push.core.C0617f;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.core.p027a.p028a.AbstractC0521a;
import com.igexin.push.core.p031d.C0615b;
import com.igexin.push.extension.distribution.basic.p041b.C0727o;
import com.igexin.push.extension.distribution.basic.p042c.C0741g;
import com.igexin.push.extension.distribution.basic.p060k.C0989i;
import com.igexin.push.extension.distribution.basic.util.webview.C1021h;
import java.io.File;
import org.json.JSONObject;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.igexin.push.extension.distribution.basic.a.s */
public class C0705s implements AbstractC0521a {

    /* renamed from: a */
    private static final String f1882a = ("EXT-" + C0705s.class.getName());

    /* renamed from: b */
    private C0727o f1883b;

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public EnumC0554b mo4352a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        this.f1883b = (C0727o) baseAction;
        File file = new File(C0519a.f1338b);
        if (file.exists()) {
            File file2 = new File(file, pushTaskBean.getTaskId());
            if (file2.exists()) {
                File file3 = new File(file2, this.f1883b.getActionId());
                if (file3.exists()) {
                    this.f1883b.mo4974b("file://" + file3.getPath() + "/1.htm");
                }
            }
        }
        if (!this.f1883b.mo4975b()) {
            return EnumC0554b.success;
        }
        String taskId = pushTaskBean.getTaskId();
        C1021h.m4094a(C0456c.m1661b()).mo5669a(taskId, pushTaskBean.getMessageId(), taskId + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.f1883b.getActionId(), this.f1883b.mo4971a(), 100, new C0706t(this));
        return EnumC0554b.wait;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public BaseAction mo4353a(JSONObject jSONObject) {
        String m;
        if (C0741g.m3010a().mo5023e() && jSONObject.has("url") && jSONObject.has("do") && jSONObject.has("actionid")) {
            try {
                String string = jSONObject.getString("url");
                if (!string.equals("")) {
                    C0727o oVar = new C0727o();
                    oVar.setType("popupweb");
                    oVar.setActionId(jSONObject.getString("actionid"));
                    oVar.setDoActionId(jSONObject.getString("do"));
                    if (jSONObject.has("is_preload")) {
                        oVar.mo4973a(jSONObject.getBoolean("is_preload"));
                    }
                    if (jSONObject.has("is_withcid") && jSONObject.getString("is_withcid").equals("true")) {
                        string = string.indexOf("?") > 0 ? string + "&cid=" + C0618g.f1647r : string + "?cid=" + C0618g.f1647r;
                    }
                    if (jSONObject.has("is_withnettype") && jSONObject.getString("is_withnettype").equals("true") && (m = C0617f.m2395a().mo4634m()) != null) {
                        string = string.indexOf("?") > 0 ? string + "&nettype=" + m : string + "?nettype=" + m;
                    }
                    oVar.mo4972a(string);
                    return oVar;
                }
            } catch (Exception e) {
            }
        }
        return null;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        C0615b.m2387a().mo4612a(new C0989i(pushTaskBean, (C0727o) baseAction));
        if (baseAction.getDoActionId().equals("")) {
            return true;
        }
        C0535e.m2034a().mo4379a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseAction.getDoActionId());
        return true;
    }
}
