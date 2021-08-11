package com.igexin.push.core.p027a;

import com.igexin.push.config.C0504a;
import com.igexin.push.config.C0514k;
import com.igexin.push.p023a.p024a.C0479c;
import com.igexin.sdk.PushConsts;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.c */
public class C0533c extends AbstractC0532b {
    @Override // com.igexin.push.core.p027a.AbstractC0532b
    /* renamed from: a */
    public boolean mo4357a(Object obj, JSONObject jSONObject) {
        try {
            if (!jSONObject.has(PushConsts.CMD_ACTION) || !jSONObject.getString(PushConsts.CMD_ACTION).equals("block_client") || !jSONObject.has("duration")) {
                return true;
            }
            long j = jSONObject.getLong("duration") * 1000;
            long currentTimeMillis = System.currentTimeMillis();
            if (j == 0) {
                return true;
            }
            C0514k.f1311c = j + currentTimeMillis;
            C0504a.m1940a().mo4347e();
            C0479c.m1784c().mo4250d();
            return true;
        } catch (Exception e) {
            return true;
        }
    }
}
