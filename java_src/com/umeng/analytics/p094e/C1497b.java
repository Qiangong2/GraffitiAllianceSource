package com.umeng.analytics.p094e;

import android.content.Context;
import com.umeng.analytics.p086a.p088b.C1387a;
import com.umeng.analytics.p086a.p090d.C1395a;
import com.umeng.analytics.p091b.C1443f;
import com.umeng.analytics.p091b.C1447g;
import com.umeng.analytics.p092c.C1457h;
import com.umeng.analytics.p093d.AbstractC1487l;
import com.umeng.analytics.p093d.C1493p;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.e.b */
/* compiled from: Defcon */
public class C1497b implements AbstractC1487l {

    /* renamed from: a */
    private static final int f3724a = 0;

    /* renamed from: b */
    private static final int f3725b = 1;

    /* renamed from: c */
    private static final int f3726c = 2;

    /* renamed from: d */
    private static final int f3727d = 3;

    /* renamed from: e */
    private static final long f3728e = 14400000;

    /* renamed from: f */
    private static final long f3729f = 28800000;

    /* renamed from: g */
    private static final long f3730g = 86400000;

    /* renamed from: j */
    private static C1497b f3731j = null;

    /* renamed from: h */
    private int f3732h = 0;

    /* renamed from: i */
    private final long f3733i = 60000;

    /* renamed from: a */
    public static synchronized C1497b m5581a(Context context) {
        C1497b bVar;
        synchronized (C1497b.class) {
            if (f3731j == null) {
                f3731j = new C1497b();
                f3731j.mo8679a(C1457h.m5380a(context).mo8580b().mo8585a(0));
            }
            bVar = f3731j;
        }
        return bVar;
    }

    private C1497b() {
    }

    /* renamed from: a */
    public void mo8680a(JSONObject jSONObject, Context context) {
        if (this.f3732h == 1) {
            jSONObject.remove(C1447g.f3469aF);
            jSONObject.remove(C1447g.f3473aJ);
            jSONObject.remove(C1447g.f3474aK);
            jSONObject.remove(C1447g.f3501au);
            C1443f.m5318a(context).mo8541a(false, true);
            C1395a.m5162a(context).mo8465b(new C1387a());
        } else if (this.f3732h == 2) {
            jSONObject.remove(C1447g.f3457U);
            try {
                jSONObject.put(C1447g.f3457U, mo8678a());
            } catch (Exception e) {
            }
            jSONObject.remove(C1447g.f3469aF);
            jSONObject.remove(C1447g.f3473aJ);
            jSONObject.remove(C1447g.f3474aK);
            jSONObject.remove(C1447g.f3501au);
            C1443f.m5318a(context).mo8541a(false, true);
            C1395a.m5162a(context).mo8465b(new C1387a());
        } else if (this.f3732h == 3) {
            jSONObject.remove(C1447g.f3457U);
            jSONObject.remove(C1447g.f3469aF);
            jSONObject.remove(C1447g.f3473aJ);
            jSONObject.remove(C1447g.f3474aK);
            jSONObject.remove(C1447g.f3501au);
            C1443f.m5318a(context).mo8541a(false, true);
            C1395a.m5162a(context).mo8465b(new C1387a());
        }
    }

    /* renamed from: a */
    public JSONObject mo8678a() {
        JSONObject jSONObject = new JSONObject();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            jSONObject.put("id", C1493p.m5539a());
            jSONObject.put(C1447g.f3459W, currentTimeMillis);
            jSONObject.put(C1447g.f3460X, currentTimeMillis + 60000);
            jSONObject.put("duration", 60000L);
        } catch (Throwable th) {
        }
        return jSONObject;
    }

    /* renamed from: b */
    public long mo8681b() {
        switch (this.f3732h) {
            case 1:
                return f3728e;
            case 2:
                return f3729f;
            case 3:
                return 86400000;
            default:
                return 0;
        }
    }

    /* renamed from: c */
    public long mo8682c() {
        return this.f3732h == 0 ? 0 : 300000;
    }

    /* renamed from: a */
    public void mo8679a(int i) {
        if (i >= 0 && i <= 3) {
            this.f3732h = i;
        }
    }

    /* renamed from: d */
    public boolean mo8683d() {
        return this.f3732h != 0;
    }

    @Override // com.umeng.analytics.p093d.AbstractC1487l
    /* renamed from: a */
    public void mo8620a(C1457h.C1458a aVar) {
        mo8679a(aVar.mo8585a(0));
    }
}
