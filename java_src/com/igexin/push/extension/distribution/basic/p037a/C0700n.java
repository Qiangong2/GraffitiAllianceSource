package com.igexin.push.extension.distribution.basic.p037a;

import android.text.TextUtils;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.p028a.AbstractC0521a;
import com.igexin.push.extension.distribution.basic.p041b.C0724l;
import com.igexin.push.extension.distribution.basic.p053h.C0768a;
import com.igexin.push.extension.distribution.basic.p053h.C0775h;
import com.igexin.push.extension.distribution.basic.util.C1008n;
import com.umeng.analytics.p091b.C1447g;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.igexin.push.extension.distribution.basic.a.n */
public class C0700n implements AbstractC0521a {

    /* renamed from: a */
    private static final String f1867a = ("EXT-" + C0700n.class.getName());

    /* renamed from: a */
    private List<String> m2718a(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(MqttTopic.MULTI_LEVEL_WILDCARD)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m2719a(C1008n nVar, String str, List<String> list, int i, StringBuilder sb) {
        String a = nVar.mo5650a(C0618g.f1635f, str, list, i);
        if (!TextUtils.isEmpty(a) && sb.length() > 0) {
            sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
        }
        sb.append(a);
    }

    /* renamed from: a */
    private boolean m2720a(StringBuilder sb) {
        try {
            return C0456c.m1661b().mo4216a(new C0768a(new C0775h(sb.toString().getBytes("UTF-8"), 20)), false, true);
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
        String string;
        try {
            if (jSONObject.has("do") && jSONObject.has("actionid") && jSONObject.has("type") && (string = jSONObject.getString("do")) != null && !string.equals("0")) {
                C0724l lVar = new C0724l();
                lVar.setType("manifest");
                lVar.setActionId(jSONObject.getString("actionid"));
                lVar.setDoActionId(jSONObject.getString("do"));
                lVar.mo4878a(jSONObject.optString("name"));
                lVar.mo4880b(jSONObject.optString("activity"));
                lVar.mo4882c(jSONObject.optString("service"));
                lVar.mo4884d(jSONObject.optString("receiver"));
                lVar.mo4886e(jSONObject.optString(C1447g.f3499as));
                return lVar;
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        try {
            C1008n nVar = new C1008n();
            StringBuilder sb = new StringBuilder();
            C0724l lVar = (C0724l) baseAction;
            List<String> a = m2718a(lVar.mo4877a());
            List<String> a2 = m2718a(lVar.mo4879b());
            List<String> a3 = m2718a(lVar.mo4881c());
            List<String> a4 = m2718a(lVar.mo4883d());
            List<String> a5 = m2718a(lVar.mo4885e());
            sb.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()));
            sb.append("|");
            sb.append(C0618g.f1647r);
            sb.append("|");
            sb.append(C0618g.f1602a);
            sb.append("|");
            List<String> a6 = nVar.mo5651a(C0618g.f1635f);
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = new StringBuilder();
            StringBuilder sb5 = new StringBuilder();
            StringBuilder sb6 = new StringBuilder();
            for (String str : a6) {
                if (sb2.length() <= 0) {
                    sb2.append(nVar.mo5649a(C0618g.f1635f, str, a) == null ? "" : nVar.mo5649a(C0618g.f1635f, str, a));
                } else {
                    sb2.append(nVar.mo5649a(C0618g.f1635f, str, a) == null ? "" : MiPushClient.ACCEPT_TIME_SEPARATOR + nVar.mo5649a(C0618g.f1635f, str, a));
                }
                if (a2.size() > 0) {
                    m2719a(nVar, str, a2, 1, sb3);
                }
                if (a3.size() > 0) {
                    m2719a(nVar, str, a3, 4, sb4);
                }
                if (a4.size() > 0) {
                    m2719a(nVar, str, a4, 2, sb5);
                }
                if (a5.size() > 0) {
                    m2719a(nVar, str, a5, 8, sb6);
                }
            }
            sb.append(sb2.toString());
            sb.append("|");
            if (sb2.length() <= 0) {
                sb.append("0");
            } else {
                sb.append("1");
            }
            sb.append("|");
            sb.append(sb3.toString());
            sb.append("|");
            sb.append(sb4.toString());
            sb.append("|");
            sb.append(sb5.toString());
            sb.append("|");
            sb.append(sb6.toString());
            m2720a(sb);
            return true;
        } catch (Throwable th) {
            return true;
        }
    }
}
