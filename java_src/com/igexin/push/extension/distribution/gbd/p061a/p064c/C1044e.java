package com.igexin.push.extension.distribution.gbd.p061a.p064c;

import android.location.GpsStatus;
import android.location.Location;
import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p068d.C1071b;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;

/* renamed from: com.igexin.push.extension.distribution.gbd.a.c.e */
class C1044e implements GpsStatus.Listener {

    /* renamed from: a */
    final /* synthetic */ C1043d f2667a;

    C1044e(C1043d dVar) {
        this.f2667a = dVar;
    }

    public void onGpsStatusChanged(int i) {
        Location a;
        switch (i) {
            case 1:
                this.f2667a.f2663e = System.currentTimeMillis();
                return;
            case 2:
            case 3:
            default:
                return;
            case 4:
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.f2667a.f2663e > C1067a.f2801l * 1000) {
                        this.f2667a.f2663e = currentTimeMillis;
                        this.f2667a.f2665g = 0;
                    }
                    if (this.f2667a.f2665g < 3 && currentTimeMillis - this.f2667a.f2664f >= C1067a.f2803n * 1000) {
                        C1043d.m4225d(this.f2667a);
                        this.f2667a.f2664f = currentTimeMillis;
                        if (C1071b.m4348a().mo5797e() && (a = this.f2667a.mo5699a(true)) != null && "gps".equals(a.getProvider())) {
                            if (this.f2667a.f2659a == null || a.distanceTo(this.f2667a.f2659a) >= ((float) C1067a.f2802m)) {
                                this.f2667a.f2661c.mo5704a(a);
                                this.f2667a.f2659a = new Location(a);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    C1115d.m4558a(th);
                    return;
                }
        }
    }
}
