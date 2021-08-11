package com.igexin.push.extension.distribution.basic.p053h;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0618g;
import com.igexin.push.extension.distribution.basic.p044e.C0749b;
import com.igexin.sdk.PushConsts;
import com.umeng.analytics.p091b.C1447g;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.basic.h.e */
public class C0772e extends AbstractC0773f {
    public C0772e() {
        super(C0770c.m3178c());
        ActivityC0460a.m1698b("EXT-_ConfigHttp|post url = " + C0770c.m3178c());
        mo5109a();
    }

    /* renamed from: a */
    public void mo5109a() {
        this.f2143e = true;
        this.f2142d = true;
        this.f2144f = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PushConsts.CMD_ACTION, "sdkconfig");
            jSONObject.put("cid", C0618g.f1647r);
            jSONObject.put("appid", C0618g.f1602a);
            jSONObject.put(C1447g.f3517l, "EXT-2.7.0");
            ActivityC0460a.m1698b("EXT-_ConfigHttp|post src data = " + jSONObject.toString());
            mo5110b(jSONObject.toString().getBytes());
        } catch (Exception e) {
            ActivityC0460a.m1698b("EXT-_ConfigHttp|" + e.getMessage());
        }
    }

    @Override // com.igexin.push.extension.distribution.basic.p053h.AbstractC0773f
    /* renamed from: a */
    public void mo5108a(Exception exc) {
        super.mo5108a(exc);
        C0749b.m3038a().mo5036a(System.currentTimeMillis());
    }

    @Override // com.igexin.push.extension.distribution.basic.p053h.AbstractC0773f
    /* renamed from: a */
    public void mo4764a(byte[] bArr) {
        C0749b.m3038a().mo5037a(bArr);
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public int mo4136b() {
        return 0;
    }
}
