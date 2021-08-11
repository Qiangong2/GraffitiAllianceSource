package com.igexin.push.extension.distribution.basic.p037a;

import android.content.Context;
import android.os.Build;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.core.p027a.p028a.AbstractC0521a;
import com.igexin.push.extension.distribution.basic.p041b.C0717e;
import com.igexin.push.extension.distribution.basic.p042c.EnumC0738d;
import com.igexin.push.extension.distribution.basic.util.C0995a;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.basic.a.f */
public class C0692f implements AbstractC0521a {
    /* renamed from: a */
    public static boolean m2689a(Context context, String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (Exception e) {
            return false;
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
            if (jSONObject.has("do") && jSONObject.has("actionid") && jSONObject.has("type") && jSONObject.has("num")) {
                String string = jSONObject.getString("do");
                String string2 = jSONObject.getString("num");
                String str = (string2 == null || !string2.equals("")) ? string2 : "1";
                if (!(str == null || string == null || string.equals("0"))) {
                    C0717e eVar = new C0717e();
                    eVar.setType("badge");
                    eVar.setActionId(jSONObject.getString("actionid"));
                    eVar.setDoActionId(jSONObject.getString("do"));
                    if (!mo4771a(str)) {
                        return null;
                    }
                    eVar.mo4829a(Integer.parseInt(str));
                    if (m2689a(C0618g.f1635f, "com.miui.gallery")) {
                        eVar.mo4830a(EnumC0738d.XIAOMI_ROM);
                        return eVar;
                    } else if (Build.MANUFACTURER.equalsIgnoreCase("Samsung")) {
                        eVar.mo4830a(EnumC0738d.SAMSUNG_ROM);
                        return eVar;
                    } else {
                        eVar.mo4830a(EnumC0738d.NONE);
                        return eVar;
                    }
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    /* renamed from: a */
    public boolean mo4771a(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        C0717e eVar = (C0717e) baseAction;
        try {
            C0995a.m3993a(C0618g.f1635f, true, eVar.mo4828a() + "", false);
        } catch (Exception e) {
        }
        C0535e.m2034a().mo4379a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), eVar.getDoActionId());
        return true;
    }
}
