package com.igexin.push.extension.distribution.gbd.p071f.p072a;

import com.igexin.push.extension.distribution.gbd.p071f.AbstractC1092c;
import com.igexin.push.extension.distribution.gbd.p071f.AbstractC1093d;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.umeng.analytics.C1370a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.igexin.push.extension.distribution.gbd.f.a.b */
public class C1087b extends AbstractC1093d {
    public C1087b(AbstractC1092c cVar) {
        this.f2949d = cVar;
    }

    @Override // com.igexin.push.extension.distribution.gbd.p071f.AbstractC1093d
    /* renamed from: a */
    public void mo5840a(int i) {
        if (this.f2949d != null) {
            try {
                this.f2949d.mo5672a(null);
            } catch (Throwable th) {
                C1115d.m4558a(th);
            }
        }
    }

    @Override // com.igexin.push.extension.distribution.gbd.p071f.AbstractC1093d
    /* renamed from: a */
    public void mo5841a(Throwable th) {
        if (this.f2949d != null) {
            try {
                this.f2949d.mo5672a(null);
            } catch (Throwable th2) {
                C1115d.m4558a(th2);
            }
        }
    }

    @Override // com.igexin.push.extension.distribution.gbd.p071f.AbstractC1093d
    /* renamed from: a */
    public void mo5842a(Map<String, List<String>> map, byte[] bArr) {
        try {
            if (this.f2949d != null) {
                HashMap hashMap = new HashMap();
                hashMap.put(C1370a.f3205A, map);
                hashMap.put("data", new String(bArr, "utf-8"));
                this.f2949d.mo5672a(hashMap);
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }
}
