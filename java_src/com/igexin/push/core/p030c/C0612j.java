package com.igexin.push.core.p030c;

import com.igexin.p012b.p013a.p015b.C0459f;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.bean.C0597j;
import com.igexin.push.core.p029b.C0561af;
import com.igexin.push.p079f.p080a.AbstractC1139b;
import com.igexin.sdk.PushConsts;
import java.util.ArrayList;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.c.j */
public class C0612j extends AbstractC1139b {

    /* renamed from: a */
    public static final String f1547a = C0612j.class.getName();

    /* renamed from: g */
    private String f1548g;

    /* renamed from: h */
    private ArrayList<C0597j> f1549h;

    public C0612j(byte[] bArr, String str, ArrayList<C0597j> arrayList) {
        super(SDKUrlConfig.getBiUploadServiceUrl());
        m2367a(bArr, str, arrayList);
    }

    /* renamed from: a */
    private void m2367a(byte[] bArr, String str, ArrayList<C0597j> arrayList) {
        this.f1548g = str;
        this.f1549h = arrayList;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PushConsts.CMD_ACTION, "upload_BI");
            jSONObject.put("BIType", str);
            jSONObject.put("cid", C0618g.f1647r);
            jSONObject.put("BIData", new String(C0459f.m1695f(bArr, 0), "UTF-8"));
            mo5893b(jSONObject.toString().getBytes());
        } catch (Exception e) {
        }
    }

    @Override // com.igexin.push.p079f.p080a.AbstractC1139b
    /* renamed from: a */
    public void mo4588a(byte[] bArr) {
        JSONObject jSONObject = new JSONObject(new String(bArr));
        if (jSONObject.has("result") && "ok".equals(jSONObject.getString("result"))) {
            C0561af.m2162a().mo4430a(this.f1548g, this.f1549h);
        }
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public int mo4136b() {
        return 0;
    }
}
