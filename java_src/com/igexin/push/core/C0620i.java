package com.igexin.push.core;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.config.C0514k;

/* renamed from: com.igexin.push.core.i */
public class C0620i {

    /* renamed from: e */
    private static C0620i f1656e;

    /* renamed from: a */
    public long f1657a = 240000;

    /* renamed from: b */
    private EnumC0623l f1658b = EnumC0623l.DETECT;

    /* renamed from: c */
    private long f1659c = 0;

    /* renamed from: d */
    private ConnectivityManager f1660d = C0617f.m2395a().mo4631j();

    private C0620i() {
    }

    /* renamed from: a */
    public static C0620i m2432a() {
        if (f1656e == null) {
            f1656e = new C0620i();
        }
        return f1656e;
    }

    /* renamed from: b */
    private void m2433b(EnumC0622k kVar) {
        switch (C0621j.f1662b[kVar.ordinal()]) {
            case 1:
                mo4637a(Math.min(this.f1657a + 60000, 420000L));
                mo4639a(EnumC0623l.DETECT);
                return;
            case 2:
            case 3:
                this.f1659c++;
                if (this.f1659c >= 2) {
                    mo4637a(Math.max(this.f1657a - 60000, 240000L));
                    mo4639a(EnumC0623l.STABLE);
                    return;
                }
                return;
            case 4:
                mo4637a(240000);
                mo4639a(EnumC0623l.DETECT);
                return;
            default:
                return;
        }
    }

    /* renamed from: c */
    private void m2434c(EnumC0622k kVar) {
        switch (C0621j.f1662b[kVar.ordinal()]) {
            case 1:
                mo4639a(EnumC0623l.STABLE);
                return;
            case 2:
            case 3:
                mo4637a(Math.max(this.f1657a - 60000, 240000L));
                this.f1659c++;
                if (this.f1659c >= 2) {
                    mo4637a(240000);
                    mo4639a(EnumC0623l.PENDING);
                    return;
                }
                return;
            case 4:
                mo4637a(240000);
                mo4639a(EnumC0623l.DETECT);
                return;
            default:
                return;
        }
    }

    /* renamed from: d */
    private void m2435d(EnumC0622k kVar) {
        switch (C0621j.f1662b[kVar.ordinal()]) {
            case 1:
                mo4637a(240000);
                mo4639a(EnumC0623l.DETECT);
                return;
            case 2:
            case 3:
                mo4639a(EnumC0623l.PENDING);
                return;
            case 4:
                mo4637a(240000);
                mo4639a(EnumC0623l.DETECT);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void mo4637a(long j) {
        this.f1657a = j;
    }

    /* renamed from: a */
    public void mo4638a(EnumC0622k kVar) {
        switch (C0621j.f1661a[this.f1658b.ordinal()]) {
            case 1:
                m2433b(kVar);
                return;
            case 2:
                m2434c(kVar);
                return;
            case 3:
                m2435d(kVar);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void mo4639a(EnumC0623l lVar) {
        this.f1658b = lVar;
        this.f1659c = 0;
    }

    /* renamed from: b */
    public long mo4640b() {
        long j = this.f1657a;
        if (C0514k.f1312d > 0) {
            j = (long) (C0514k.f1312d * 1000);
        }
        NetworkInfo activeNetworkInfo = this.f1660d.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            j = 3600000;
        } else if (!C0618g.f1641l) {
            j = 3600000;
        } else if (!C0617f.m2395a().mo4628g().mo4741a()) {
            j = 3600000;
        }
        ActivityC0460a.m1698b("HeartBeatIntervalGenerator|getHeartbeatInterval final interval = " + j);
        return j;
    }
}
