package com.amap.loc;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import java.util.List;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* renamed from: com.amap.loc.f */
/* compiled from: LastLocationManager */
public class C0336f {

    /* renamed from: a */
    Runnable f809a = new Runnable() {
        /* class com.amap.loc.C0336f.RunnableC03371 */

        public void run() {
            try {
                if (C0331cr.m1163a(C0336f.this.f812d)) {
                    String str = C0336f.this.f812d.toStr();
                    String str2 = null;
                    if (!TextUtils.isEmpty(str)) {
                        str2 = C0355m.m1295a(C0309bz.m947c(str.getBytes("UTF-8"), C0336f.this.f811c));
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        C0316ce ceVar = new C0316ce();
                        ceVar.mo3876a(str2);
                        ceVar.mo3875a(C0331cr.m1156a());
                        C0336f.this.f813e.mo3645a(ceVar, "_id=1");
                        C0336f.this.f815g = C0331cr.m1170b();
                    }
                }
            } catch (Throwable th) {
                C0310c.m956a(th, "LastLocationManager", "saveLastFix");
            }
        }
    };

    /* renamed from: b */
    private Context f810b;

    /* renamed from: c */
    private String f811c = null;

    /* renamed from: d */
    private AMapLocation f812d = null;

    /* renamed from: e */
    private C0228ac f813e;

    /* renamed from: f */
    private ExecutorService f814f = null;

    /* renamed from: g */
    private long f815g = 0;

    public C0336f(Context context) {
        this.f810b = context.getApplicationContext();
        try {
            this.f811c = C0309bz.m939a("MD5", C0353l.m1276i(this.f810b));
            this.f813e = new C0228ac(context, C0228ac.m465a((Class<? extends AbstractC0227ab>) C0317cf.class), C0331cr.m1197k());
        } catch (Throwable th) {
            C0310c.m956a(th, "LastLocationManager", "<init>:DBOperation");
        }
    }

    /* renamed from: c */
    private synchronized void m1217c() {
        if (this.f814f == null || this.f814f.isShutdown()) {
            this.f814f = C0371w.m1393b();
        }
        this.f814f.submit(this.f809a);
    }

    /* renamed from: d */
    private synchronized AMapLocation m1218d() {
        Throwable th;
        AMapLocation aMapLocation;
        AMapLocation aMapLocation2 = null;
        synchronized (this) {
            if (this.f810b != null) {
                try {
                    this.f813e = new C0228ac(this.f810b, C0228ac.m465a((Class<? extends AbstractC0227ab>) C0317cf.class), C0331cr.m1197k());
                    List b = this.f813e.mo3650b("_id=1", C0316ce.class);
                    String str = (b == null || b.size() <= 0) ? null : new String(C0309bz.m948d(C0355m.m1299b(((C0316ce) b.get(0)).mo3874a()), this.f811c), "UTF-8");
                    if (!TextUtils.isEmpty(str)) {
                        aMapLocation = new AMapLocation("");
                        try {
                            C0310c.m954a(aMapLocation, new JSONObject(str));
                        } catch (Throwable th2) {
                            th = th2;
                            C0310c.m956a(th, "LastLocationManager", "readLastFix");
                            aMapLocation2 = aMapLocation;
                            return aMapLocation2;
                        }
                    } else {
                        aMapLocation = null;
                    }
                } catch (Throwable th3) {
                    aMapLocation = null;
                    th = th3;
                    C0310c.m956a(th, "LastLocationManager", "readLastFix");
                    aMapLocation2 = aMapLocation;
                    return aMapLocation2;
                }
                aMapLocation2 = aMapLocation;
            }
        }
        return aMapLocation2;
    }

    /* renamed from: a */
    public synchronized AMapLocation mo3925a() {
        return this.f812d == null ? m1218d() : this.f812d;
    }

    /* renamed from: a */
    public synchronized void mo3926a(AMapLocation aMapLocation) {
        if (!(this.f810b == null || !C0331cr.m1163a(aMapLocation) || aMapLocation.getLocationType() == 2)) {
            try {
                this.f812d = aMapLocation;
                if (C0331cr.m1170b() - this.f815g > 30000) {
                    m1217c();
                }
            } catch (Throwable th) {
                C0310c.m956a(th, "LastLocationManager", "setLastFix");
            }
        }
    }

    /* renamed from: b */
    public synchronized void mo3927b() {
        try {
            m1217c();
            if (this.f814f != null) {
                this.f814f.shutdown();
                this.f814f = null;
            }
            this.f815g = 0;
        } catch (Throwable th) {
            C0310c.m956a(th, "LastLocationManager", "destroy");
        }
        return;
    }
}
