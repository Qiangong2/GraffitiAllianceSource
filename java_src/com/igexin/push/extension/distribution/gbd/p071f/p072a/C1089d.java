package com.igexin.push.extension.distribution.gbd.p071f.p072a;

import com.igexin.push.core.C0618g;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1084f;
import com.igexin.push.extension.distribution.gbd.p071f.AbstractC1093d;
import com.igexin.push.extension.distribution.gbd.p071f.C1091b;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.extension.distribution.gbd.p076i.C1116e;
import com.igexin.sdk.PushConsts;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.gbd.f.a.d */
public class C1089d extends AbstractC1093d {
    public C1089d() {
        super(C1091b.m4467b());
        if (C1116e.m4579b()) {
            mo5853c(true);
        } else {
            mo5848a(true);
            mo5851b(false);
        }
        mo5844n();
    }

    @Override // com.igexin.push.extension.distribution.gbd.p071f.AbstractC1093d
    /* renamed from: a */
    public void mo5842a(Map<String, List<String>> map, byte[] bArr) {
        if (bArr != null) {
            try {
                C1084f.m4433a().mo5838a(bArr);
            } catch (Throwable th) {
                C1115d.m4558a(th);
            }
        }
    }

    /* renamed from: n */
    public void mo5844n() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PushConsts.CMD_ACTION, "fetchus");
            jSONObject.put("cid", C0618g.f1647r);
            jSONObject.put("appid", C0618g.f1602a);
            jSONObject.put("pkgs", C1116e.m4565a(C1069c.f2824a, 0));
            mo5849a(jSONObject.toString().getBytes());
            C1115d.m4559b("GBD_GSSHP", "init jsonObject = " + jSONObject);
        } catch (Exception e) {
            C1115d.m4558a(e);
        }
    }
}
