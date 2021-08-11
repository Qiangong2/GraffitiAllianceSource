package com.igexin.push.extension.distribution.basic.p037a;

import android.text.TextUtils;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.core.p027a.p028a.AbstractC0521a;
import com.igexin.push.extension.distribution.basic.p041b.C0713a;
import com.igexin.push.extension.distribution.basic.p053h.C0768a;
import com.igexin.push.extension.distribution.basic.util.C1002h;
import java.net.URL;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.basic.a.a */
public class C0673a implements AbstractC0521a {

    /* renamed from: a */
    private static final String f1826a = ("EXT-" + C0673a.class.getName());

    /* renamed from: a */
    private void m2612a(String str) {
        try {
            C0456c.m1661b().mo4216a(new C0768a(new C0683b(this, str)), false, true);
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
            if (jSONObject.has("type") && jSONObject.has("url") && jSONObject.has("monitorprovider")) {
                int i = jSONObject.getInt("monitorprovider");
                String string = jSONObject.getString("url");
                C0713a aVar = new C0713a();
                aVar.setType("adsmonitor");
                aVar.mo4785a(string);
                aVar.setActionId(jSONObject.getString("actionid"));
                aVar.setDoActionId(jSONObject.getString("do"));
                aVar.mo4784a(i);
                return aVar;
            }
        } catch (Exception e) {
        }
        return null;
    }

    /* renamed from: a */
    public String mo4748a(C0713a aVar) {
        String a = aVar.mo4783a();
        try {
            String host = new URL(a).getHost();
            String d = C1002h.m4034d(C0618g.f1635f);
            return host.contains("admaster.com") ? a.replace("__OS__", "0").replace("__IMEI__", d) : host.contains("miaozhen.com") ? a.replace("__OS__", "0").replace("__IMEI__", d) : host.contains("track.data.getui.com") ? a.replace("__OS__", "0").replace("__MAC1__", C1002h.m4033c(C0618g.f1635f)).replace("__IMEI__", d).replace("__TS__", String.valueOf(System.currentTimeMillis())) : host.contains("doubleclick.net") ? a.replace("[timestamp]", System.currentTimeMillis() + "") : a.replace("__OS__", "0").replace("__IMEI__", d);
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        String a;
        C0713a aVar = (C0713a) baseAction;
        if (baseAction != null) {
            try {
                if (!TextUtils.isEmpty(aVar.mo4783a()) && (a = mo4748a(aVar)) != null) {
                    m2612a(a);
                }
            } catch (Exception e) {
            }
        }
        C0535e.m2034a().mo4379a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), aVar.getDoActionId());
        return true;
    }
}
