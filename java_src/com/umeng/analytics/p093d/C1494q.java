package com.umeng.analytics.p093d;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.p085a.C1360l;

/* renamed from: com.umeng.analytics.d.q */
/* compiled from: StatTracer */
public class C1494q implements AbstractC1483h {

    /* renamed from: h */
    private static final String f3699h = "successful_request";

    /* renamed from: i */
    private static final String f3700i = "failed_requests ";

    /* renamed from: j */
    private static final String f3701j = "last_request_spent_ms";

    /* renamed from: k */
    private static final String f3702k = "last_request_time";

    /* renamed from: l */
    private static final String f3703l = "first_activate_time";

    /* renamed from: m */
    private static final String f3704m = "last_req";

    /* renamed from: a */
    public int f3705a;

    /* renamed from: b */
    public int f3706b;

    /* renamed from: c */
    public long f3707c;

    /* renamed from: d */
    private final int f3708d = 3600000;

    /* renamed from: e */
    private int f3709e;

    /* renamed from: f */
    private long f3710f = 0;

    /* renamed from: g */
    private long f3711g = 0;

    /* renamed from: n */
    private Context f3712n;

    public C1494q(Context context) {
        m5550a(context);
    }

    /* renamed from: a */
    private void m5550a(Context context) {
        this.f3712n = context.getApplicationContext();
        SharedPreferences a = C1488m.m5522a(context);
        this.f3705a = a.getInt(f3699h, 0);
        this.f3706b = a.getInt(f3700i, 0);
        this.f3709e = a.getInt(f3701j, 0);
        this.f3707c = a.getLong(f3702k, 0);
        this.f3710f = a.getLong(f3704m, 0);
    }

    /* renamed from: e */
    public int mo8658e() {
        if (this.f3709e > 3600000) {
            return 3600000;
        }
        return this.f3709e;
    }

    /* renamed from: f */
    public boolean mo8659f() {
        boolean z;
        boolean z2;
        if (this.f3707c == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!C1360l.m5038a(this.f3712n).mo8389h()) {
            z2 = true;
        } else {
            z2 = false;
        }
        return z && z2;
    }

    /* renamed from: g */
    public void mo8660g() {
        this.f3705a++;
        this.f3707c = this.f3710f;
    }

    /* renamed from: h */
    public void mo8661h() {
        this.f3706b++;
    }

    /* renamed from: i */
    public void mo8662i() {
        this.f3710f = System.currentTimeMillis();
    }

    /* renamed from: j */
    public void mo8663j() {
        this.f3709e = (int) (System.currentTimeMillis() - this.f3710f);
    }

    /* renamed from: k */
    public void mo8664k() {
        C1488m.m5522a(this.f3712n).edit().putInt(f3699h, this.f3705a).putInt(f3700i, this.f3706b).putInt(f3701j, this.f3709e).putLong(f3702k, this.f3707c).putLong(f3704m, this.f3710f).commit();
    }

    /* renamed from: l */
    public long mo8665l() {
        SharedPreferences a = C1488m.m5522a(this.f3712n);
        this.f3711g = C1488m.m5522a(this.f3712n).getLong(f3703l, 0);
        if (this.f3711g == 0) {
            this.f3711g = System.currentTimeMillis();
            a.edit().putLong(f3703l, this.f3711g).commit();
        }
        return this.f3711g;
    }

    /* renamed from: m */
    public long mo8666m() {
        return this.f3710f;
    }

    @Override // com.umeng.analytics.p093d.AbstractC1483h
    /* renamed from: a */
    public void mo8638a() {
        mo8662i();
    }

    @Override // com.umeng.analytics.p093d.AbstractC1483h
    /* renamed from: b */
    public void mo8639b() {
        mo8663j();
    }

    @Override // com.umeng.analytics.p093d.AbstractC1483h
    /* renamed from: c */
    public void mo8640c() {
        mo8660g();
    }

    @Override // com.umeng.analytics.p093d.AbstractC1483h
    /* renamed from: d */
    public void mo8641d() {
        mo8661h();
    }
}
