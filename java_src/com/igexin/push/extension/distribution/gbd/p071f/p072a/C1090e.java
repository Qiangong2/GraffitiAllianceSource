package com.igexin.push.extension.distribution.gbd.p071f.p072a;

import com.igexin.p012b.p013a.p015b.C0459f;
import com.igexin.push.core.C0618g;
import com.igexin.push.extension.distribution.gbd.p066b.C1059b;
import com.igexin.push.extension.distribution.gbd.p066b.C1064g;
import com.igexin.push.extension.distribution.gbd.p071f.AbstractC1093d;
import com.igexin.push.extension.distribution.gbd.p071f.C1091b;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.extension.distribution.gbd.p076i.C1116e;
import com.igexin.sdk.PushConsts;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.gbd.f.a.e */
public class C1090e extends AbstractC1093d {

    /* renamed from: n */
    int f2944n;

    /* renamed from: o */
    List<C1064g> f2945o;

    public C1090e(byte[] bArr, int i, List<C1064g> list) {
        super(C1091b.m4465a());
        if (C1116e.m4579b()) {
            mo5853c(true);
        } else {
            mo5848a(true);
        }
        this.f2945o = list;
        this.f2944n = i;
        m4461a(bArr, i);
    }

    /* renamed from: a */
    private void m4461a(byte[] bArr, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PushConsts.CMD_ACTION, "upload_BI");
            jSONObject.put("BIType", String.valueOf(i));
            jSONObject.put("cid", C0618g.f1647r);
            jSONObject.put("BIData", new String(C0459f.m1695f(bArr, 0), "UTF-8"));
            mo5849a(jSONObject.toString().getBytes());
        } catch (Exception e) {
            C1115d.m4558a(e);
        }
        C1115d.m4559b("GBD_UBLP", "gbdreportReq|" + i);
    }

    @Override // com.igexin.push.extension.distribution.gbd.p071f.AbstractC1093d
    /* renamed from: a */
    public void mo5840a(int i) {
        try {
            C1059b bVar = new C1059b();
            bVar.mo5732a(false);
            bVar.mo5731a(this.f2945o);
            this.f2949d.mo5672a(bVar);
            C1115d.m4559b("GBD_UBLP", "type = " + this.f2944n + " requestFailed doReport failed...");
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }

    @Override // com.igexin.push.extension.distribution.gbd.p071f.AbstractC1093d
    /* renamed from: a */
    public void mo5841a(Throwable th) {
        try {
            if (this.f2949d != null) {
                C1059b bVar = new C1059b();
                bVar.mo5732a(false);
                bVar.mo5731a(this.f2945o);
                this.f2949d.mo5672a(bVar);
            }
            C1115d.m4559b("GBD_UBLP", "type = " + this.f2944n + " exceptionHandler doReport error..." + th.toString());
        } catch (Throwable th2) {
            C1115d.m4558a(th2);
        }
    }

    @Override // com.igexin.push.extension.distribution.gbd.p071f.AbstractC1093d
    /* renamed from: a */
    public void mo5842a(Map<String, List<String>> map, byte[] bArr) {
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            if (jSONObject.has("result")) {
                String string = jSONObject.getString("result");
                if (this.f2945o == null || this.f2949d == null) {
                    C1115d.m4559b("GBD_UBLP", "send list = null type = " + this.f2944n);
                    return;
                }
                C1059b bVar = new C1059b();
                bVar.mo5731a(this.f2945o);
                if (string.equals("ok")) {
                    bVar.mo5732a(true);
                    this.f2949d.mo5672a(bVar);
                    C1115d.m4559b("GBD_UBLP", "gbdreportRsp|" + this.f2944n);
                    return;
                }
                bVar.mo5732a(false);
                this.f2949d.mo5672a(bVar);
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }
}
