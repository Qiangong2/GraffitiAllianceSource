package com.umeng.analytics.p086a.p089c;

import com.umeng.analytics.p086a.p087a.C1376d;
import com.umeng.analytics.p086a.p088b.C1387a;
import com.umeng.analytics.p086a.p090d.C1412b;
import com.umeng.analytics.p086a.p090d.C1419e;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.umeng.analytics.a.c.b */
/* compiled from: UMCCAggregatedObject */
public class C1391b implements Serializable {

    /* renamed from: a */
    private static final long f3282a = 1;

    /* renamed from: b */
    private List<String> f3283b = new ArrayList();

    /* renamed from: c */
    private List<String> f3284c = new ArrayList();

    /* renamed from: d */
    private long f3285d = 0;

    /* renamed from: e */
    private long f3286e = 0;

    /* renamed from: f */
    private long f3287f = 0;

    /* renamed from: g */
    private String f3288g = null;

    public C1391b() {
    }

    public C1391b(List<String> list, long j, long j2, long j3, List<String> list2, String str) {
        this.f3283b = list;
        this.f3284c = list2;
        this.f3285d = j;
        this.f3286e = j2;
        this.f3287f = j3;
        this.f3288g = str;
    }

    /* renamed from: a */
    public void mo8433a(String str) {
        try {
            if (this.f3284c.size() < C1412b.m5211a().mo8474b()) {
                this.f3284c.add(str);
            } else {
                this.f3284c.remove(this.f3284c.get(0));
                this.f3284c.add(str);
            }
            if (this.f3284c.size() > C1412b.m5211a().mo8474b()) {
                for (int i = 0; i < this.f3284c.size() - C1412b.m5211a().mo8474b(); i++) {
                    this.f3284c.remove(this.f3284c.get(0));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo8431a(C1387a aVar, C1394e eVar) {
        mo8433a(eVar.mo8456b());
        this.f3287f++;
        this.f3286e += eVar.mo8457c();
        this.f3285d += eVar.mo8458d();
        aVar.mo8391a(this, false);
    }

    /* renamed from: a */
    public void mo8432a(C1394e eVar) {
        this.f3287f = 1;
        this.f3283b = eVar.mo8455a();
        mo8433a(eVar.mo8456b());
        this.f3286e = eVar.mo8457c();
        this.f3285d = System.currentTimeMillis();
        this.f3288g = C1419e.m5243a(System.currentTimeMillis());
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[key: ").append(this.f3283b).append("] [label: ").append(this.f3284c).append("][ totalTimeStamp").append(this.f3288g).append("][ value").append(this.f3286e).append("][ count").append(this.f3287f).append("][ timeWindowNum").append(this.f3288g).append("]");
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public String mo8429a() {
        return C1376d.m5103a(this.f3283b);
    }

    /* renamed from: b */
    public List<String> mo8435b() {
        return this.f3283b;
    }

    /* renamed from: c */
    public String mo8439c() {
        return C1376d.m5103a(this.f3284c);
    }

    /* renamed from: d */
    public List<String> mo8441d() {
        return this.f3284c;
    }

    /* renamed from: e */
    public long mo8442e() {
        return this.f3285d;
    }

    /* renamed from: f */
    public long mo8443f() {
        return this.f3286e;
    }

    /* renamed from: g */
    public long mo8444g() {
        return this.f3287f;
    }

    /* renamed from: h */
    public String mo8445h() {
        return this.f3288g;
    }

    /* renamed from: a */
    public void mo8434a(List<String> list) {
        this.f3283b = list;
    }

    /* renamed from: b */
    public void mo8438b(List<String> list) {
        this.f3284c = list;
    }

    /* renamed from: a */
    public void mo8430a(long j) {
        this.f3285d = j;
    }

    /* renamed from: b */
    public void mo8436b(long j) {
        this.f3286e = j;
    }

    /* renamed from: c */
    public void mo8440c(long j) {
        this.f3287f = j;
    }

    /* renamed from: b */
    public void mo8437b(String str) {
        this.f3288g = str;
    }
}
