package com.igexin.push.core.p030c;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p022b.C0476a;
import com.igexin.push.config.C0504a;
import com.igexin.push.config.C0516m;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.p027a.C0549s;
import com.igexin.push.core.p029b.C0568g;
import com.igexin.push.p079f.p080a.AbstractC1139b;
import com.igexin.push.util.C1159i;
import org.json.JSONArray;

/* renamed from: com.igexin.push.core.c.f */
public class C0608f extends AbstractC1139b {

    /* renamed from: a */
    public static JSONArray f1542a;

    public C0608f(String str, JSONArray jSONArray) {
        super(str);
        mo4593a(jSONArray);
    }

    @Override // com.igexin.push.p079f.p080a.AbstractC1139b
    /* renamed from: a */
    public void mo4590a(Exception exc) {
        C0568g.m2192a().mo4456d(System.currentTimeMillis());
        ActivityC0460a.m1698b("-> get idc config " + exc.toString());
    }

    /* renamed from: a */
    public void mo4593a(JSONArray jSONArray) {
        f1542a = jSONArray;
    }

    @Override // com.igexin.push.p079f.p080a.AbstractC1139b
    /* renamed from: a */
    public void mo4588a(byte[] bArr) {
        if (bArr != null) {
            try {
                String str = new String(C0476a.m1777c(C1159i.m4778a(bArr, 0)));
                ActivityC0460a.m1698b("->get idc config server resp data : " + str);
                C0504a.m1940a().mo4343b(str);
                C0516m.m1968a(str, true);
                C0568g.m2192a().mo4456d(0);
                C0504a.m1940a().mo4340a(f1542a.toString());
                SDKUrlConfig.setIdcConfigUrl(C0549s.m2146a(f1542a));
            } catch (Exception e) {
                C0568g.m2192a().mo4456d(System.currentTimeMillis());
                throw e;
            }
        }
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public int mo4136b() {
        return 0;
    }
}
