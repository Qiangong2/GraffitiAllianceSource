package com.umeng.analytics.p092c;

import android.support.p007v4.p009os.EnvironmentCompat;
import com.umeng.analytics.p095f.C1500b;
import com.umeng.analytics.p095f.C1507c;
import com.umeng.analytics.p095f.C1514d;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.umeng.analytics.c.a */
/* compiled from: AbstractIdTracker */
public abstract class AbstractC1449a {

    /* renamed from: a */
    private final int f3533a = 10;

    /* renamed from: b */
    private final int f3534b = 20;

    /* renamed from: c */
    private final String f3535c;

    /* renamed from: d */
    private List<C1500b> f3536d;

    /* renamed from: e */
    private C1507c f3537e;

    /* renamed from: f */
    public abstract String mo8554f();

    public AbstractC1449a(String str) {
        this.f3535c = str;
    }

    /* renamed from: a */
    public boolean mo8549a() {
        return mo8601g();
    }

    /* renamed from: b */
    public String mo8550b() {
        return this.f3535c;
    }

    /* renamed from: c */
    public boolean mo8551c() {
        if (this.f3537e == null || this.f3537e.mo8731i() <= 20) {
            return true;
        }
        return false;
    }

    /* renamed from: g */
    private boolean mo8601g() {
        C1507c cVar = this.f3537e;
        String c = cVar == null ? null : cVar.mo8724c();
        int i = cVar == null ? 0 : cVar.mo8731i();
        String a = mo8545a(mo8554f());
        if (a == null || a.equals(c)) {
            return false;
        }
        if (cVar == null) {
            cVar = new C1507c();
        }
        cVar.mo8720a(a);
        cVar.mo8719a(System.currentTimeMillis());
        cVar.mo8718a(i + 1);
        C1500b bVar = new C1500b();
        bVar.mo8690a(this.f3535c);
        bVar.mo8694c(a);
        bVar.mo8692b(c);
        bVar.mo8689a(cVar.mo8728f());
        if (this.f3536d == null) {
            this.f3536d = new ArrayList(2);
        }
        this.f3536d.add(bVar);
        if (this.f3536d.size() > 10) {
            this.f3536d.remove(0);
        }
        this.f3537e = cVar;
        return true;
    }

    /* renamed from: d */
    public C1507c mo8552d() {
        return this.f3537e;
    }

    /* renamed from: a */
    public void mo8546a(C1507c cVar) {
        this.f3537e = cVar;
    }

    /* renamed from: e */
    public List<C1500b> mo8553e() {
        return this.f3536d;
    }

    /* renamed from: a */
    public void mo8548a(List<C1500b> list) {
        this.f3536d = list;
    }

    /* renamed from: a */
    public String mo8545a(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0 || "0".equals(trim) || EnvironmentCompat.MEDIA_UNKNOWN.equals(trim.toLowerCase(Locale.US))) {
            return null;
        }
        return trim;
    }

    /* renamed from: a */
    public void mo8547a(C1514d dVar) {
        this.f3537e = dVar.mo8753d().get(this.f3535c);
        List<C1500b> i = dVar.mo8758i();
        if (i != null && i.size() > 0) {
            if (this.f3536d == null) {
                this.f3536d = new ArrayList();
            }
            for (C1500b bVar : i) {
                if (this.f3535c.equals(bVar.f3760a)) {
                    this.f3536d.add(bVar);
                }
            }
        }
    }
}
