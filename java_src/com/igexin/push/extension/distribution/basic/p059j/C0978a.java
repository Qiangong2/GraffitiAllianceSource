package com.igexin.push.extension.distribution.basic.p059j;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.extension.distribution.basic.p037a.C0691e;
import com.igexin.push.extension.distribution.basic.p041b.C0715c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.igexin.push.extension.distribution.basic.j.a */
public class C0978a extends AbstractC0980c {

    /* renamed from: a */
    public static Map<String, PushTaskBean> f2504a = new ConcurrentHashMap();

    /* renamed from: b */
    public static Map<String, Long> f2505b = new ConcurrentHashMap();

    /* renamed from: e */
    private C0691e f2506e = new C0691e();

    public C0978a() {
        m3932c();
    }

    /* renamed from: a */
    private boolean m3931a(int i, long j) {
        return System.currentTimeMillis() - j > ((long) ((i * 60) * 1000));
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3932c() {
        /*
        // Method dump skipped, instructions count: 297
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.p059j.C0978a.m3932c():void");
    }

    @Override // com.igexin.push.extension.distribution.basic.p059j.AbstractC0980c
    /* renamed from: a */
    public void mo5626a() {
        try {
            if (!f2504a.isEmpty()) {
                for (Map.Entry<String, PushTaskBean> entry : f2504a.entrySet()) {
                    C0715c cVar = (C0715c) entry.getValue().getBaseAction("1");
                    if (m3931a(cVar.mo4821b(), f2505b.get(entry.getKey()).longValue())) {
                        f2505b.put(entry.getKey(), Long.valueOf(System.currentTimeMillis()));
                        this.f2506e.mo4354b(entry.getValue(), cVar);
                    }
                }
            }
        } catch (Exception e) {
            ActivityC0460a.m1698b("EXT-AppFrontCronTaskdo task exeception");
        }
    }
}
