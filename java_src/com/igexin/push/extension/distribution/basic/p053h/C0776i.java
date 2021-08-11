package com.igexin.push.extension.distribution.basic.p053h;

import com.igexin.push.core.C0618g;
import com.igexin.sdk.PushConsts;
import com.wanmei.sdk.core.param.BaseOrderParams;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.basic.h.i */
public class C0776i extends AbstractC0773f {

    /* renamed from: a */
    private static String f2146a = C0770c.m3175a();

    public C0776i(byte[] bArr, long j, int i, int i2) {
        super(f2146a);
        m3200a(bArr, j, i, i2);
    }

    /* renamed from: a */
    private void m3200a(byte[] bArr, long j, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PushConsts.CMD_ACTION, "upload_log");
            jSONObject.put("cid", C0618g.f1647r);
            jSONObject.put("imei", C0618g.f1649t);
            jSONObject.put("source", BaseOrderParams.EXT);
            jSONObject.put("blockCnt", i);
            jSONObject.put("blockSeq", i2);
            jSONObject.put("createtime", j);
            jSONObject.put("logData", new String(bArr));
            mo5110b(jSONObject.toString().getBytes());
        } catch (Exception e) {
        }
    }

    @Override // com.igexin.push.extension.distribution.basic.p053h.AbstractC0773f
    /* renamed from: a */
    public void mo4764a(byte[] bArr) {
        super.mo4764a(bArr);
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public int mo4136b() {
        return 0;
    }
}
