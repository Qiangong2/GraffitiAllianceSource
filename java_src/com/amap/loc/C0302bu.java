package com.amap.loc;

import android.text.TextUtils;
import com.autonavi.aps.amapapi.model.AMapLocationServer;

/* renamed from: com.amap.loc.bu */
/* compiled from: LocFilter */
public class C0302bu {

    /* renamed from: b */
    private static C0302bu f580b = null;

    /* renamed from: a */
    int f581a = 0;

    /* renamed from: c */
    private AMapLocationServer f582c = null;

    /* renamed from: d */
    private long f583d = 0;

    /* renamed from: e */
    private long f584e = 0;

    /* renamed from: f */
    private boolean f585f = true;

    private C0302bu() {
    }

    /* renamed from: a */
    public static synchronized C0302bu m875a() {
        C0302bu buVar;
        synchronized (C0302bu.class) {
            if (f580b == null) {
                f580b = new C0302bu();
            }
            buVar = f580b;
        }
        return buVar;
    }

    /* renamed from: c */
    private AMapLocationServer m876c(AMapLocationServer aMapLocationServer) {
        if (C0331cr.m1164a(aMapLocationServer)) {
            if (!this.f585f || !C0322ck.m1052b(aMapLocationServer.getTime())) {
                aMapLocationServer.setLocationType(this.f581a);
            } else if (aMapLocationServer.getLocationType() == 5 || aMapLocationServer.getLocationType() == 6) {
                aMapLocationServer.setLocationType(2);
            }
        }
        return aMapLocationServer;
    }

    /* renamed from: a */
    public synchronized AMapLocationServer mo3815a(AMapLocationServer aMapLocationServer) {
        if (!C0331cr.m1164a(this.f582c) || !C0331cr.m1164a(aMapLocationServer)) {
            this.f583d = C0331cr.m1170b();
            this.f582c = aMapLocationServer;
            aMapLocationServer = this.f582c;
        } else if (aMapLocationServer.getTime() != this.f582c.getTime() || aMapLocationServer.getAccuracy() >= 300.0f) {
            if (aMapLocationServer.getProvider().equals("gps")) {
                this.f583d = C0331cr.m1170b();
                this.f582c = aMapLocationServer;
                aMapLocationServer = this.f582c;
            } else if (aMapLocationServer.mo3960b() != this.f582c.mo3960b()) {
                this.f583d = C0331cr.m1170b();
                this.f582c = aMapLocationServer;
                aMapLocationServer = this.f582c;
            } else if (aMapLocationServer.mo3965d().equals(this.f582c.mo3965d()) || TextUtils.isEmpty(aMapLocationServer.mo3965d())) {
                this.f581a = aMapLocationServer.getLocationType();
                float a = C0331cr.m1150a(aMapLocationServer, this.f582c);
                float accuracy = this.f582c.getAccuracy();
                float accuracy2 = aMapLocationServer.getAccuracy();
                float f = accuracy2 - accuracy;
                long b = C0331cr.m1170b();
                long j = b - this.f583d;
                if ((accuracy < 101.0f && accuracy2 > 299.0f) || (accuracy > 299.0f && accuracy2 > 299.0f)) {
                    if (this.f584e == 0) {
                        this.f584e = b;
                    } else if (b - this.f584e > 30000) {
                        this.f583d = b;
                        this.f582c = aMapLocationServer;
                        this.f584e = 0;
                        aMapLocationServer = this.f582c;
                    }
                    this.f582c = m876c(this.f582c);
                    aMapLocationServer = this.f582c;
                } else if (accuracy2 >= 100.0f || accuracy <= 299.0f) {
                    if (accuracy2 <= 299.0f) {
                        this.f584e = 0;
                    }
                    if (a >= 10.0f || ((double) a) <= 0.1d) {
                        if (f < 300.0f) {
                            this.f583d = C0331cr.m1170b();
                            this.f582c = aMapLocationServer;
                            aMapLocationServer = this.f582c;
                        } else if (j >= 30000) {
                            this.f583d = C0331cr.m1170b();
                            this.f582c = aMapLocationServer;
                            aMapLocationServer = this.f582c;
                        } else {
                            this.f582c = m876c(this.f582c);
                            aMapLocationServer = this.f582c;
                        }
                    } else if (f >= -300.0f) {
                        this.f582c = m876c(this.f582c);
                        aMapLocationServer = this.f582c;
                    } else if (accuracy / accuracy2 >= 2.0f) {
                        this.f583d = b;
                        this.f582c = aMapLocationServer;
                        aMapLocationServer = this.f582c;
                    } else {
                        this.f582c = m876c(this.f582c);
                        aMapLocationServer = this.f582c;
                    }
                } else {
                    this.f583d = b;
                    this.f582c = aMapLocationServer;
                    this.f584e = 0;
                    aMapLocationServer = this.f582c;
                }
            } else {
                this.f583d = C0331cr.m1170b();
                this.f582c = aMapLocationServer;
                aMapLocationServer = this.f582c;
            }
        }
        return aMapLocationServer;
    }

    /* renamed from: a */
    public void mo3816a(boolean z) {
        this.f585f = z;
    }

    /* renamed from: b */
    public AMapLocationServer mo3817b(AMapLocationServer aMapLocationServer) {
        return aMapLocationServer;
    }

    /* renamed from: b */
    public synchronized void mo3818b() {
        this.f582c = null;
        this.f583d = 0;
        this.f584e = 0;
    }
}
