package com.igexin.push.extension.distribution.gbd.p071f.p072a;

import com.igexin.push.core.C0618g;
import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1079a;
import com.igexin.push.extension.distribution.gbd.p071f.AbstractC1093d;
import com.igexin.push.extension.distribution.gbd.p071f.C1091b;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.extension.distribution.gbd.p076i.C1116e;
import com.igexin.sdk.PushConsts;
import com.umeng.analytics.p091b.C1447g;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.gbd.f.a.c */
public class C1088c extends AbstractC1093d {
    public C1088c() {
        super(C1091b.m4467b());
        if (C1116e.m4579b()) {
            mo5853c(true);
        } else {
            mo5848a(true);
            mo5851b(true);
        }
        mo5843n();
    }

    @Override // com.igexin.push.extension.distribution.gbd.p071f.AbstractC1093d
    /* renamed from: a */
    public void mo5840a(int i) {
    }

    @Override // com.igexin.push.extension.distribution.gbd.p071f.AbstractC1093d
    /* renamed from: a */
    public void mo5841a(Throwable th) {
        C1115d.m4558a(th);
    }

    @Override // com.igexin.push.extension.distribution.gbd.p071f.AbstractC1093d
    /* renamed from: a */
    public void mo5842a(Map<String, List<String>> map, byte[] bArr) {
        try {
            C1079a.m4384a().mo5809a(bArr);
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }

    /* renamed from: n */
    public void mo5843n() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PushConsts.CMD_ACTION, "sdkconfig");
            jSONObject.put("tag", C1067a.f2759J);
            jSONObject.put("cid", C0618g.f1647r);
            jSONObject.put("appid", C0618g.f1602a);
            jSONObject.put(C1447g.f3517l, "GBD-1.8.5");
            mo5849a(jSONObject.toString().getBytes());
            C1115d.m4559b("GBD_ConfigHttp", "init jsonObject = " + jSONObject);
        } catch (Exception e) {
            C1115d.m4558a(e);
        }
    }
}
