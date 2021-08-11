package com.igexin.push.p032d;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0618g;
import com.igexin.push.util.C1151a;
import com.umeng.analytics.C1370a;

/* renamed from: com.igexin.push.d.f */
public class C0657f implements AbstractC0660i {
    /* renamed from: a */
    private long m2536a(long j) {
        long j2 = j / 10;
        return ((long) (((Math.random() * ((double) j2)) * 2.0d) - ((double) j2))) + j;
    }

    @Override // com.igexin.push.p032d.AbstractC0660i
    /* renamed from: a */
    public long mo4701a(boolean z) {
        ActivityC0460a.m1698b("NormalModel|resetDelay = " + z);
        if (z) {
            C0618g.f1579D = 0;
            ActivityC0460a.m1698b("NormalModel|isResetDelay = true, reconnect delayTime = 0");
        }
        boolean a = C1151a.m4739a(System.currentTimeMillis());
        boolean b = C1151a.m4747b();
        ActivityC0460a.m1698b("NormalModel|isSdkOn = " + C0618g.f1638i + " isPushOn = " + C0618g.f1639j + " checkIsSilentTime = " + a + " isBlockEndTime = " + b + " isNetworkAvailable = " + C0618g.f1637h);
        if (!C0618g.f1637h || !C0618g.f1638i || !C0618g.f1639j || a || !b) {
            ActivityC0460a.m1698b("NormalModel|reconnect stop, interval= 1h ++++");
            return C1370a.f3218j;
        }
        if (C0618g.f1579D <= 0) {
            C0618g.f1579D = 200;
        } else if (C0618g.f1579D <= 10000) {
            C0618g.f1579D += 500;
        } else if (C0618g.f1579D <= 30000) {
            C0618g.f1579D += 1500;
        } else {
            C0618g.f1579D += 120000;
        }
        if (C0618g.f1579D > C1370a.f3218j) {
            C0618g.f1579D = C1370a.f3218j;
        }
        long a2 = m2536a(C0618g.f1579D);
        ActivityC0460a.m1698b("NormalModel|after add auto reconnect delay time = " + a2);
        return a2;
    }
}
