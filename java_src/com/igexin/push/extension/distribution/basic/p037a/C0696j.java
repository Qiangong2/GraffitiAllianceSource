package com.igexin.push.extension.distribution.basic.p037a;

import android.content.IntentFilter;
import android.provider.Settings;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.core.p027a.p028a.AbstractC0521a;
import com.igexin.push.extension.distribution.basic.p041b.C0721i;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.basic.a.j */
public class C0696j implements AbstractC0521a {

    /* renamed from: a */
    private static final String f1864a = ("EXT-" + C0696j.class.getName());

    /* renamed from: a */
    private boolean m2705a() {
        try {
            return (Settings.Secure.getInt(C0618g.f1635f.getContentResolver(), "adb_enabled", 0) > 0) && (C0618g.f1635f.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getExtras().getInt("plugged") == 2);
        } catch (Throwable th) {
            return true;
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
            if (jSONObject.has("type") && jSONObject.has("actionid") && jSONObject.has("do_debug") && jSONObject.has("do_undebug")) {
                C0721i iVar = new C0721i();
                iVar.setActionId(jSONObject.getString("actionid"));
                iVar.mo4854a(jSONObject.getString("do_debug"));
                iVar.mo4856b(jSONObject.getString("do_undebug"));
                iVar.setType(jSONObject.getString("type"));
                return iVar;
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        try {
            C0721i iVar = (C0721i) baseAction;
            String taskId = pushTaskBean.getTaskId();
            String messageId = pushTaskBean.getMessageId();
            if (m2705a()) {
                C0535e.m2034a().mo4379a(taskId, messageId, iVar.mo4853a());
                return true;
            }
            C0535e.m2034a().mo4379a(taskId, messageId, iVar.mo4855b());
            return true;
        } catch (Throwable th) {
            return true;
        }
    }
}
