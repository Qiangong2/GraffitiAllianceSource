package com.igexin.push.p026c;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.config.C0514k;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.p027a.C0535e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.igexin.push.c.a */
public class C0486a {

    /* renamed from: f */
    private static final String f1197f = C0486a.class.getName();

    /* renamed from: a */
    public volatile EnumC0489d f1198a = EnumC0489d.NORMAL;

    /* renamed from: b */
    public AtomicBoolean f1199b = new AtomicBoolean(false);

    /* renamed from: c */
    protected int f1200c;

    /* renamed from: d */
    protected volatile long f1201d;

    /* renamed from: e */
    protected volatile long f1202e;

    /* renamed from: g */
    private int f1203g;

    /* renamed from: h */
    private int f1204h;

    /* renamed from: i */
    private int f1205i;

    /* renamed from: j */
    private C0495j f1206j;

    /* renamed from: k */
    private final List<C0490e> f1207k = new ArrayList();

    /* renamed from: l */
    private final List<C0495j> f1208l = new ArrayList();

    /* renamed from: m */
    private final Object f1209m = new Object();

    /* renamed from: n */
    private final Object f1210n = new Object();

    /* renamed from: o */
    private int f1211o = 0;

    /* renamed from: p */
    private final Comparator<C0495j> f1212p = new C0487b(this);

    /* renamed from: a */
    private String m1814a(boolean z) {
        String b;
        synchronized (this.f1209m) {
            this.f1203g = this.f1203g >= this.f1208l.size() ? 0 : this.f1203g;
            this.f1206j = this.f1208l.get(this.f1203g);
            b = this.f1206j.mo4292b(z);
        }
        return b;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0059  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m1815a(com.igexin.push.p026c.EnumC0489d r3) {
        /*
        // Method dump skipped, instructions count: 200
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.p026c.C0486a.m1815a(com.igexin.push.c.d):void");
    }

    /* renamed from: b */
    private String m1816b(boolean z) {
        try {
            synchronized (this.f1210n) {
                if (this.f1207k.isEmpty()) {
                    ActivityC0460a.m1698b(f1197f + "cm list size = 0");
                    this.f1205i = 0;
                    this.f1204h = 0;
                    return null;
                }
                ActivityC0460a.m1698b(f1197f + "cm try = " + this.f1205i + " times");
                if (this.f1205i >= this.f1207k.size() * 3) {
                    ActivityC0460a.m1698b(f1197f + "cm invalid");
                    this.f1205i = 0;
                    this.f1204h = 0;
                    this.f1207k.clear();
                    return null;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Iterator<C0490e> it = this.f1207k.iterator();
                while (it.hasNext()) {
                    C0490e next = it.next();
                    if (next.f1221b < currentTimeMillis) {
                        ActivityC0460a.m1698b(f1197f + "|add[" + next.f1220a + "] outDate");
                        it.remove();
                    }
                }
                if (this.f1207k.isEmpty()) {
                    return null;
                }
                this.f1204h = this.f1204h >= this.f1207k.size() ? 0 : this.f1204h;
                String str = this.f1207k.get(this.f1204h).f1220a;
                this.f1204h++;
                if (z) {
                    this.f1205i++;
                }
                return str;
            }
        } catch (Exception e) {
            ActivityC0460a.m1698b(f1197f + "|" + e.toString());
            return null;
        }
    }

    /* renamed from: k */
    private void m1817k() {
        ActivityC0460a.m1698b(f1197f + "|before disconnect, type = " + this.f1198a);
        switch (C0488c.f1214a[this.f1198a.ordinal()]) {
            case 1:
                if (System.currentTimeMillis() - this.f1202e > 172800000 && this.f1200c > C0514k.f1334z) {
                    m1815a(EnumC0489d.BACKUP);
                    return;
                }
                return;
            case 2:
                if (System.currentTimeMillis() - this.f1201d > C0514k.f1332x) {
                    m1815a(EnumC0489d.TRY_NORMAL);
                    return;
                }
                return;
            case 3:
            default:
                return;
        }
    }

    /* renamed from: a */
    public void mo4262a() {
        try {
            boolean z = !C0535e.m2034a().mo4359B();
            String b = m1816b(z);
            ActivityC0460a.m1698b(f1197f + "|get from cm = " + b);
            if (b == null) {
                if (!C0514k.f1314f || this.f1198a != EnumC0489d.BACKUP) {
                    if (this.f1206j != null && !this.f1206j.mo4300f()) {
                        this.f1203g++;
                    }
                    b = m1814a(z);
                } else {
                    this.f1203g = this.f1203g >= SDKUrlConfig.XFR_ADDRESS_BAK.length ? 0 : this.f1203g;
                    b = SDKUrlConfig.XFR_ADDRESS_BAK[this.f1203g];
                    this.f1203g++;
                }
            }
            if (!SDKUrlConfig.getCmAddress().equals(b)) {
                ActivityC0460a.m1698b(f1197f + "|address changed : form [" + SDKUrlConfig.getCmAddress() + "] to [" + b + "]");
            }
            SDKUrlConfig.setCmAddress(b);
        } catch (Exception e) {
            e.printStackTrace();
            ActivityC0460a.m1698b(f1197f + "|switch address|" + e.toString());
        }
    }

    /* renamed from: a */
    public void mo4263a(List<C0490e> list) {
        synchronized (this.f1210n) {
            this.f1204h = 0;
            this.f1205i = 0;
            this.f1207k.clear();
            if (list != null) {
                this.f1207k.addAll(list);
                ActivityC0460a.m1698b(f1197f + "|set cm list: " + list.toString());
            }
        }
    }

    /* renamed from: b */
    public synchronized void mo4264b() {
        ActivityC0460a.m1698b(f1197f + "|login or register success, cmConncetTryCnt = 0");
        this.f1205i = 0;
        if (this.f1206j != null) {
            this.f1206j.mo4302h();
        }
    }

    /* renamed from: b */
    public void mo4265b(List<C0495j> list) {
        synchronized (this.f1209m) {
            this.f1208l.clear();
            this.f1208l.addAll(list);
            Collections.sort(this.f1208l, this.f1212p);
        }
    }

    /* renamed from: c */
    public synchronized void mo4266c() {
        this.f1200c++;
        ActivityC0460a.m1698b(f1197f + "|before login success, loginFailedlCnt = " + this.f1200c);
    }

    /* renamed from: d */
    public void mo4267d() {
        synchronized (this.f1209m) {
            this.f1203g = 0;
            Collections.sort(this.f1208l, this.f1212p);
            try {
                int length = SDKUrlConfig.getXfrAddress().length;
                if (length >= 3) {
                    for (int i = 0; i < this.f1208l.size(); i++) {
                        this.f1208l.get(i).mo4294b(length - i);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                ActivityC0460a.m1698b(f1197f + "|" + e.toString());
            }
        }
    }

    /* renamed from: e */
    public void mo4268e() {
        ActivityC0460a.m1698b(f1197f + "|detect success, current type = " + this.f1198a);
        if (this.f1198a == EnumC0489d.BACKUP) {
            m1815a(EnumC0489d.TRY_NORMAL);
            C0535e.m2034a().mo4396c(true);
        }
    }

    /* renamed from: f */
    public void mo4269f() {
        ActivityC0460a.m1698b(f1197f + "|detect max cnt ,set type = backup");
        m1815a(EnumC0489d.BACKUP);
        C0535e.m2034a().mo4396c(true);
    }

    /* renamed from: g */
    public void mo4270g() {
        switch (C0488c.f1214a[this.f1198a.ordinal()]) {
            case 2:
                if (System.currentTimeMillis() - this.f1201d > C0514k.f1332x) {
                    m1815a(EnumC0489d.TRY_NORMAL);
                    return;
                }
                return;
            case 3:
            default:
                return;
        }
    }

    /* renamed from: h */
    public void mo4271h() {
        if (this.f1198a != EnumC0489d.BACKUP) {
            this.f1200c = 0;
        }
        switch (C0488c.f1214a[this.f1198a.ordinal()]) {
            case 1:
                this.f1202e = System.currentTimeMillis();
                C0494i.m1834a().mo4285i().mo4326p();
                this.f1199b.set(false);
                return;
            case 2:
            default:
                return;
            case 3:
                m1815a(EnumC0489d.NORMAL);
                this.f1199b.set(false);
                return;
        }
    }

    /* renamed from: i */
    public void mo4272i() {
        m1817k();
        if (C0618g.f1641l && this.f1198a != EnumC0489d.BACKUP) {
            this.f1202e = System.currentTimeMillis();
            C0494i.m1834a().mo4285i().mo4326p();
        }
        switch (C0488c.f1214a[this.f1198a.ordinal()]) {
            case 1:
            case 2:
            default:
                return;
            case 3:
                int i = this.f1211o + 1;
                this.f1211o = i;
                if (i >= 10) {
                    this.f1200c = 0;
                    this.f1201d = System.currentTimeMillis();
                    m1815a(EnumC0489d.BACKUP);
                    return;
                }
                return;
        }
    }

    /* renamed from: j */
    public boolean mo4273j() {
        return this.f1198a == EnumC0489d.NORMAL;
    }
}
