package com.igexin.push.p026c;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.igexin.push.c.j */
public class C0495j {

    /* renamed from: a */
    private static final String f1235a = C0495j.class.getName();

    /* renamed from: b */
    private String f1236b;

    /* renamed from: c */
    private String f1237c;

    /* renamed from: d */
    private int f1238d;

    /* renamed from: e */
    private long f1239e = 2147483647L;

    /* renamed from: f */
    private long f1240f = -1;

    /* renamed from: g */
    private boolean f1241g = true;

    /* renamed from: h */
    private int f1242h;

    /* renamed from: i */
    private int f1243i;

    /* renamed from: j */
    private int f1244j = 3;

    public C0495j() {
    }

    public C0495j(String str, int i) {
        this.f1236b = str;
        this.f1238d = i;
    }

    /* renamed from: j */
    private void m1843j() {
        this.f1237c = null;
        this.f1242h = 0;
        this.f1241g = true;
    }

    /* renamed from: k */
    private boolean m1844k() {
        return this.f1237c != null && System.currentTimeMillis() - this.f1240f <= C0491f.f1223b && this.f1242h < this.f1244j;
    }

    /* renamed from: a */
    public synchronized String mo4286a() {
        return this.f1236b;
    }

    /* renamed from: a */
    public void mo4287a(int i) {
        this.f1238d = i;
    }

    /* renamed from: a */
    public void mo4288a(long j) {
        this.f1239e = j;
    }

    /* renamed from: a */
    public synchronized void mo4289a(String str) {
        this.f1236b = str;
    }

    /* renamed from: a */
    public synchronized void mo4290a(String str, long j, long j2) {
        this.f1237c = str;
        this.f1239e = j;
        this.f1240f = j2;
        this.f1242h = 0;
        this.f1243i = 0;
        this.f1241g = false;
    }

    /* renamed from: a */
    public void mo4291a(boolean z) {
        this.f1241g = z;
    }

    /* renamed from: b */
    public synchronized String mo4292b(boolean z) {
        String str;
        if (m1844k()) {
            if (z) {
                this.f1242h++;
                ActivityC0460a.m1698b(f1235a + "|disc network, ipFailedCnt++  = " + this.f1242h);
            } else {
                ActivityC0460a.m1698b(f1235a + "|disc user, ipFailedCnt =  " + this.f1242h);
            }
            ActivityC0460a.m1698b(f1235a + "|disc, ip is valid, use ip = " + this.f1237c);
            this.f1241g = false;
            str = this.f1237c;
        } else {
            m1843j();
            ActivityC0460a.m1698b(f1235a + "|disc, ip is invalid, use domain = " + this.f1236b);
            if (z) {
                this.f1243i++;
                ActivityC0460a.m1698b(f1235a + "|disc network, domainFailedCnt++ = " + this.f1243i);
            } else {
                ActivityC0460a.m1698b(f1235a + "|disc user, domainFailedCnt =  " + this.f1243i);
            }
            str = this.f1236b;
        }
        return str;
    }

    /* renamed from: b */
    public synchronized void mo4293b() {
        this.f1237c = null;
        this.f1239e = 2147483647L;
        this.f1240f = -1;
        this.f1241g = true;
        this.f1242h = 0;
    }

    /* renamed from: b */
    public synchronized void mo4294b(int i) {
        if (i < 1) {
            i = 1;
        }
        this.f1244j = i;
    }

    /* renamed from: b */
    public void mo4295b(long j) {
        this.f1240f = j;
    }

    /* renamed from: b */
    public void mo4296b(String str) {
        this.f1237c = str;
    }

    /* renamed from: c */
    public String mo4297c() {
        return this.f1237c;
    }

    /* renamed from: d */
    public int mo4298d() {
        return this.f1238d;
    }

    /* renamed from: e */
    public synchronized long mo4299e() {
        return this.f1239e;
    }

    /* renamed from: f */
    public synchronized boolean mo4300f() {
        boolean z = true;
        synchronized (this) {
            if (!m1844k() && this.f1243i >= this.f1244j) {
                this.f1243i = 0;
                z = false;
            }
        }
        return z;
    }

    /* renamed from: g */
    public synchronized String mo4301g() {
        String str;
        if (m1844k()) {
            this.f1241g = false;
            str = this.f1237c;
        } else {
            m1843j();
            str = this.f1236b;
        }
        return str;
    }

    /* renamed from: h */
    public synchronized void mo4302h() {
        ActivityC0460a.m1698b(f1235a + "|register or login success, reset ipFailedCnt + domainFailedCnt");
        this.f1242h = 0;
        this.f1243i = 0;
    }

    /* renamed from: i */
    public JSONObject mo4303i() {
        if (this.f1236b == null || this.f1237c == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("domain", this.f1236b);
            jSONObject.put("ip", this.f1237c);
            if (this.f1239e != 2147483647L) {
                jSONObject.put("consumeTime", this.f1239e);
            }
            jSONObject.put("port", this.f1238d);
            if (this.f1240f != -1) {
                jSONObject.put("detectSuccessTime", this.f1240f);
            }
            jSONObject.put("isDomain", this.f1241g);
            jSONObject.put("connectTryCnt", this.f1244j);
            return jSONObject;
        } catch (JSONException e) {
            ActivityC0460a.m1698b(f1235a + e.toString());
            return null;
        }
    }
}
