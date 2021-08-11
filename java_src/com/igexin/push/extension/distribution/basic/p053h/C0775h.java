package com.igexin.push.extension.distribution.basic.p053h;

import com.igexin.p012b.p013a.p015b.C0459f;
import com.igexin.push.core.C0618g;
import com.igexin.sdk.PushConsts;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.basic.h.h */
public class C0775h extends AbstractC0773f {
    public C0775h(byte[] bArr, int i) {
        super(C0770c.m3177b());
        m3197a(bArr, i);
    }

    /* renamed from: a */
    private void m3197a(byte[] bArr, int i) {
        this.f2144f = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PushConsts.CMD_ACTION, "upload_BI");
            jSONObject.put("BIType", String.valueOf(i));
            jSONObject.put("cid", C0618g.f1647r);
            jSONObject.put("BIData", new String(C0459f.m1695f(bArr, 0), "UTF-8"));
            mo5110b(jSONObject.toString().getBytes());
        } catch (Exception e) {
        }
    }

    @Override // com.igexin.push.extension.distribution.basic.p053h.AbstractC0773f
    /* renamed from: a */
    public void mo4764a(byte[] bArr) {
        new String(bArr);
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public int mo4136b() {
        return 0;
    }
}
