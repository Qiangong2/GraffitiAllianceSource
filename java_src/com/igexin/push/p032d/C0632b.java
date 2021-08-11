package com.igexin.push.p032d;

import android.content.Intent;
import android.os.Bundle;
import android.support.p007v4.content.LocalBroadcastManager;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.config.C0514k;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.p029b.C0568g;
import com.igexin.push.p079f.p081b.C1147e;
import com.igexin.push.util.C1151a;

/* renamed from: com.igexin.push.d.b */
public class C0632b {

    /* renamed from: a */
    private int f1683a;

    /* renamed from: b */
    private int f1684b;

    /* renamed from: c */
    private boolean f1685c;

    /* renamed from: d */
    private int f1686d;

    /* renamed from: e */
    private long f1687e;

    /* renamed from: f */
    private int f1688f;

    /* renamed from: g */
    private long f1689g;

    /* renamed from: h */
    private EnumC0655d f1690h;

    /* renamed from: i */
    private AbstractC0660i f1691i;

    private C0632b() {
        this.f1683a = C0514k.f1300F;
        this.f1684b = C0514k.f1302H;
        this.f1691i = new C0657f();
        this.f1690h = C1151a.m4751d() ? EnumC0655d.WIFI : EnumC0655d.MOBILE;
    }

    /* renamed from: a */
    public static C0632b m2464a() {
        return C0656e.m2535a();
    }

    /* renamed from: a */
    private void m2465a(int i) {
        if (C0618g.f1635f != null) {
            try {
                Intent intent = new Intent();
                intent.setAction("com.igexin.sdk.action.polling");
                Bundle bundle = new Bundle();
                bundle.putInt("code", i);
                intent.putExtras(bundle);
                if (C1151a.m4752e()) {
                    LocalBroadcastManager.getInstance(C0618g.f1635f.getApplicationContext()).sendBroadcast(intent);
                } else {
                    C0618g.f1635f.sendBroadcast(intent);
                }
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: h */
    private void m2466h() {
        ActivityC0460a.m1698b("ConnectModelCoordinator|reset current model = normal");
        if (this.f1691i != null && !(this.f1691i instanceof C0657f)) {
            this.f1691i = new C0657f();
        }
        C1147e.m4721g().mo5902i();
        this.f1688f = 0;
        this.f1686d = 0;
        this.f1685c = false;
        C0568g.m2192a().mo4450b(this.f1685c);
    }

    /* renamed from: i */
    private void m2467i() {
        m2465a(0);
    }

    /* renamed from: j */
    private void m2468j() {
        m2465a(1);
    }

    /* renamed from: a */
    public void mo4671a(boolean z) {
        this.f1685c = z;
        ActivityC0460a.m1698b("ConnectModelCoordinator|init, current is polling model = " + z);
        if (z) {
            C1147e.m4721g().mo5901h();
        }
    }

    /* renamed from: b */
    public synchronized void mo4672b() {
        EnumC0655d dVar = C1151a.m4751d() ? EnumC0655d.WIFI : EnumC0655d.MOBILE;
        if (dVar != this.f1690h) {
            ActivityC0460a.m1698b("ConnectModelCoordinator|net type changed " + this.f1690h + "->" + dVar);
            m2466h();
            this.f1690h = dVar;
        }
    }

    /* renamed from: c */
    public AbstractC0660i mo4673c() {
        return this.f1691i;
    }

    /* renamed from: d */
    public synchronized void mo4674d() {
        if (!this.f1685c) {
            long currentTimeMillis = System.currentTimeMillis() - this.f1687e;
            if (currentTimeMillis > 20000 && currentTimeMillis < 200000) {
                this.f1686d++;
                ActivityC0460a.m1698b("ConnectModelCoordinator|read len = -1, interval = " + currentTimeMillis + ", disconnect =" + this.f1686d);
                if (this.f1686d >= this.f1683a) {
                    ActivityC0460a.m1698b("ConnectModelCoordinator|enter polling mode ####");
                    m2467i();
                    this.f1685c = true;
                    this.f1691i = new C0658g();
                    C1147e.m4721g().mo5901h();
                    C0568g.m2192a().mo4450b(this.f1685c);
                }
            }
        }
    }

    /* renamed from: e */
    public synchronized void mo4675e() {
        if (this.f1685c) {
            if (System.currentTimeMillis() - this.f1689g >= 120000) {
                this.f1688f++;
                ActivityC0460a.m1698b("ConnectModelCoordinator|polling mode, cur hearbeat =" + this.f1688f);
                if (this.f1688f >= this.f1684b) {
                    ActivityC0460a.m1698b("ConnectModelCoordinator|enter normal mode ####");
                    m2468j();
                    C0618g.f1579D = 0;
                    m2466h();
                }
            }
            this.f1689g = System.currentTimeMillis();
        }
    }

    /* renamed from: f */
    public void mo4676f() {
        this.f1687e = System.currentTimeMillis();
        if (this.f1685c) {
            this.f1691i = new C0658g();
            C1147e.m4721g().mo5901h();
            this.f1688f = 0;
        }
    }

    /* renamed from: g */
    public void mo4677g() {
        if (this.f1685c && this.f1691i != null && !(this.f1691i instanceof C0657f)) {
            this.f1691i = new C0657f();
        }
    }
}
