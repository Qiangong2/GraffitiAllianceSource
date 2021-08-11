package com.igexin.push.core.p030c;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p022b.C0476a;
import com.igexin.push.core.C0618g;
import com.igexin.push.p079f.p080a.AbstractC1139b;
import com.igexin.sdk.PushConsts;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.c.b */
public class C0604b extends AbstractC1139b {
    public C0604b(String str, String str2) {
        super(str);
        mo4587a(str2);
    }

    /* renamed from: a */
    public void mo4587a(String str) {
        if (str != null && C0618g.f1602a != null && C0618g.f1647r != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PushConsts.CMD_ACTION, "alias_bind");
                jSONObject.put("alias", str);
                jSONObject.put("appid", C0618g.f1602a);
                jSONObject.put("cid", C0618g.f1647r);
                mo5893b(C0476a.m1776b(jSONObject.toString().getBytes()));
            } catch (Exception e) {
            }
        }
    }

    @Override // com.igexin.push.p079f.p080a.AbstractC1139b
    /* renamed from: a */
    public void mo4588a(byte[] bArr) {
        if (bArr != null) {
            ActivityC0460a.m1698b("-> BindAlias result::" + new String(C0476a.m1777c(bArr)));
            JSONObject jSONObject = new JSONObject();
            if (!jSONObject.has("result") || "ok".equals(jSONObject.getString("result"))) {
            }
        }
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public int mo4136b() {
        return 0;
    }
}
