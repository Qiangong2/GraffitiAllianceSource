package com.igexin.push.extension.distribution.basic.p037a;

import android.annotation.TargetApi;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.core.p027a.p028a.AbstractC0521a;
import com.igexin.push.extension.distribution.basic.p041b.C0722j;
import com.igexin.push.extension.distribution.basic.p042c.C0744j;
import com.igexin.push.extension.distribution.basic.util.C0997c;
import com.igexin.push.extension.distribution.basic.util.C1012r;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.basic.a.k */
public class C0697k implements AbstractC0521a {

    /* renamed from: a */
    public static final String f1865a = ("EXT-" + C0697k.class.getName());

    @TargetApi(9)
    /* renamed from: a */
    private int m2709a(String str) {
        long j = 0;
        try {
            j = C0744j.f2042a.getPackageManager().getPackageInfo(str, 0).firstInstallTime;
        } catch (Exception e) {
            ActivityC0460a.m1698b(f1865a + e.toString());
        }
        return ((int) (System.currentTimeMillis() - j)) / 3600000;
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
            if (!jSONObject.has("do") || !jSONObject.has("actionid") || !jSONObject.has("pkgname")) {
                return null;
            }
            if ((!jSONObject.has("sign") && !jSONObject.has("isactive") && !jSONObject.has("starthour") && !jSONObject.has("endhour")) || !C0997c.m4002a(jSONObject.getString("pkgname"))) {
                return null;
            }
            C0722j jVar = new C0722j();
            jVar.setType(jSONObject.getString("type"));
            jVar.setActionId(jSONObject.getString("actionid"));
            jVar.setDoActionId(jSONObject.getString("do"));
            jVar.mo4859a(jSONObject.getString("pkgname"));
            if (jSONObject.has("sign")) {
                jVar.mo4862b(jSONObject.getString("sign"));
            }
            if (jSONObject.has("isactive")) {
                jVar.mo4864c(String.valueOf(jSONObject.getBoolean("isactive")));
            }
            if (jSONObject.has("starthour")) {
                jVar.mo4858a(jSONObject.getInt("starthour"));
            }
            if (jSONObject.has("endhour")) {
                jVar.mo4861b(jSONObject.getInt("endhour"));
            }
            if (jSONObject.has("do_failed")) {
                jVar.mo4866d(jSONObject.getString("do_failed"));
            }
            return jVar;
        } catch (Exception e) {
            ActivityC0460a.m1698b(f1865a + "parseAction exception:" + e.toString());
            return null;
        }
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        boolean z;
        boolean z2 = false;
        try {
            C0722j jVar = (C0722j) baseAction;
            if (jVar.mo4860b() == null || jVar.mo4860b().equals(C1012r.m4066a(C0744j.f2042a, jVar.mo4857a()))) {
                z = true;
            } else {
                ActivityC0460a.m1698b(f1865a + "signature not match");
                z = false;
            }
            int a = m2709a(jVar.mo4857a());
            if (z && (!(jVar.mo4865d() == 0 && jVar.mo4868f() == 24) && (a < jVar.mo4865d() || a >= jVar.mo4868f()))) {
                ActivityC0460a.m1698b(f1865a + "installed not match");
                z = false;
            }
            if (!z || jVar.mo4863c() == null || jVar.mo4863c().equals(String.valueOf(C0997c.m4006c(jVar.mo4857a())))) {
                z2 = z;
            } else {
                ActivityC0460a.m1698b(f1865a + "process active not match");
            }
            if (z2) {
                ActivityC0460a.m1698b(f1865a + "do action");
                C0535e.m2034a().mo4379a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), jVar.getDoActionId());
            } else if (jVar.mo4867e() != null) {
                ActivityC0460a.m1698b(f1865a + "do fail action");
                C0535e.m2034a().mo4379a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), jVar.mo4867e());
            }
        } catch (Exception e) {
            ActivityC0460a.m1698b(f1865a + e.toString());
        }
        return true;
    }
}
