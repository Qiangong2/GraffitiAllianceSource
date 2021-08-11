package com.igexin.push.core.p027a;

import com.igexin.p012b.p013a.p020d.AbstractC0470d;
import com.igexin.push.config.C0513j;
import com.igexin.push.p032d.p035c.C0653p;
import com.igexin.sdk.PushConsts;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.j */
public class C0540j extends AbstractC0520a {

    /* renamed from: a */
    private static final String f1375a = C0513j.f1294a;

    /* renamed from: b */
    private static Map<String, AbstractC0532b> f1376b;

    public C0540j() {
        f1376b = new HashMap();
        f1376b.put("redirect_server", new C0549s());
        f1376b.put("response_deviceid", new C0551u());
        f1376b.put("pushmessage", new C0547q());
        f1376b.put("received", new C0548r());
        f1376b.put("sendmessage_feedback", new C0552v());
        f1376b.put("block_client", new C0533c());
        f1376b.put("settag_result", new C0553w());
    }

    @Override // com.igexin.push.core.p027a.AbstractC0520a
    /* renamed from: a */
    public boolean mo4350a(AbstractC0470d dVar) {
        return false;
    }

    @Override // com.igexin.push.core.p027a.AbstractC0520a
    /* renamed from: a */
    public boolean mo4351a(Object obj) {
        AbstractC0532b bVar;
        if (obj instanceof C0653p) {
            C0653p pVar = (C0653p) obj;
            if (pVar.mo4700a() && pVar.f1776e != null) {
                try {
                    JSONObject jSONObject = new JSONObject((String) pVar.f1776e);
                    if (jSONObject.has(PushConsts.CMD_ACTION) && !jSONObject.getString(PushConsts.CMD_ACTION).equals("received") && jSONObject.has("id")) {
                        C0535e.m2034a().mo4370a(jSONObject.getString("id"));
                    }
                    if (jSONObject.has(PushConsts.CMD_ACTION) && (bVar = f1376b.get(jSONObject.getString(PushConsts.CMD_ACTION))) != null) {
                        return bVar.mo4357a(obj, jSONObject);
                    }
                } catch (Exception e) {
                }
            }
        }
        return false;
    }
}
