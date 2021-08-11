package com.wanmei.push.p103f;

import com.wanmei.push.p103f.C1707b;
import com.wanmei.push.p104g.C1714f;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.wanmei.push.f.a */
public final class C1706a {

    /* renamed from: a */
    private Map<Integer, C1707b> f4337a = new HashMap();

    /* renamed from: b */
    private int f4338b = 0;

    /* renamed from: c */
    private int f4339c = 0;

    /* renamed from: d */
    private long f4340d = 0;

    private C1706a() {
        this.f4337a.put(0, new C1707b.C1708a().mo9371a(10).mo9372a(60000L).mo9373a());
        this.f4337a.put(1, new C1707b.C1708a().mo9371a(60).mo9372a(600000L).mo9373a());
        this.f4337a.put(2, new C1707b.C1708a().mo9371a(30).mo9372a(600000L).mo9373a());
    }

    /* renamed from: a */
    public static C1706a m6358a() {
        return new C1706a();
    }

    /* renamed from: b */
    public final long mo9368b() {
        C1707b bVar = this.f4337a.get(Integer.valueOf(this.f4339c));
        if (bVar != null) {
            int i = this.f4338b;
            this.f4338b = i + 1;
            if (i < bVar.mo9369a()) {
                this.f4340d = bVar.mo9370b();
            } else {
                this.f4339c++;
                this.f4338b = 0;
                mo9368b();
            }
        }
        C1714f.m6379a(getClass().getName(), "重试开始, 延迟时间" + (this.f4340d / 1000) + "秒");
        return this.f4340d;
    }
}
