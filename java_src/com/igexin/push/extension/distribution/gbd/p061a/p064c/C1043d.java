package com.igexin.push.extension.distribution.gbd.p061a.p064c;

import android.content.Context;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationManager;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.igexin.push.extension.distribution.gbd.p066b.C1060c;
import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p068d.C1071b;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1083e;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.extension.distribution.gbd.p076i.C1116e;
import java.util.List;

/* renamed from: com.igexin.push.extension.distribution.gbd.a.c.d */
public class C1043d {

    /* renamed from: a */
    protected Location f2659a;

    /* renamed from: b */
    private Context f2660b;

    /* renamed from: c */
    private C1045f f2661c;

    /* renamed from: d */
    private LocationManager f2662d;

    /* renamed from: e */
    private long f2663e = 0;

    /* renamed from: f */
    private long f2664f = 0;

    /* renamed from: g */
    private int f2665g = 0;

    /* renamed from: h */
    private GpsStatus.Listener f2666h = new C1044e(this);

    public C1043d(Context context) {
        try {
            this.f2660b = context;
            this.f2662d = (LocationManager) C1069c.f2824a.getSystemService("location");
            boolean e = C1071b.m4348a().mo5797e();
            C1115d.m4559b("GBD_LA", "LocationAction init checkSafeStatus = " + e);
            if (e && this.f2662d != null && m4222b()) {
                this.f2662d.addGpsStatusListener(this.f2666h);
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }

    /* renamed from: a */
    private boolean m4219a(Location location) {
        return location != null && location.getLatitude() == 0.0d && location.getLongitude() == 0.0d && location.getTime() == 0 && !location.hasAccuracy();
    }

    /* renamed from: b */
    private boolean m4222b() {
        if (!m4224c()) {
            return false;
        }
        if (!C1116e.m4587c("com.huawei.android.hwouc", this.f2660b)) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - C1069c.f2834k;
        long j = (long) (C1067a.f2758I * 24 * 60 * 60 * 1000);
        if (!C1067a.f2757H || currentTimeMillis <= j) {
            return false;
        }
        if (!m4219a(this.f2662d.getLastKnownLocation("network"))) {
            return true;
        }
        C1083e.m4408a().mo5835i(System.currentTimeMillis());
        return false;
    }

    /* renamed from: c */
    private boolean m4224c() {
        return C1116e.m4570a(this.f2660b, "android.permission.ACCESS_FINE_LOCATION") && C1116e.m4570a(this.f2660b, "android.permission.ACCESS_COARSE_LOCATION");
    }

    /* renamed from: d */
    static /* synthetic */ int m4225d(C1043d dVar) {
        int i = dVar.f2665g;
        dVar.f2665g = i + 1;
        return i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Location mo5699a(boolean z) {
        try {
            if (this.f2662d == null || !m4222b()) {
                return null;
            }
            return z ? this.f2662d.getLastKnownLocation("gps") : this.f2662d.getLastKnownLocation("network");
        } catch (Throwable th) {
            C1115d.m4558a(th);
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: com.igexin.push.extension.distribution.gbd.b.c */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1060c mo5700a() {
        List list;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Exception e;
        int i7;
        int i8;
        int i9;
        int i10 = 0;
        try {
            if (m4222b()) {
                TelephonyManager telephonyManager = (TelephonyManager) this.f2660b.getSystemService("phone");
                if (telephonyManager.getSimState() == 5) {
                    String networkOperator = telephonyManager.getNetworkOperator();
                    if (networkOperator == null || networkOperator.length() < 3) {
                        i4 = 0;
                        i5 = 0;
                    } else {
                        i5 = Integer.parseInt(networkOperator.substring(0, 3));
                        i4 = Integer.parseInt(networkOperator.substring(3));
                    }
                    try {
                        CellLocation cellLocation = telephonyManager.getCellLocation();
                        if (cellLocation instanceof GsmCellLocation) {
                            i6 = ((GsmCellLocation) cellLocation).getLac();
                            try {
                                i9 = ((GsmCellLocation) cellLocation).getCid();
                                i10 = i6;
                                i8 = i4;
                            } catch (Exception e2) {
                                e = e2;
                                C1115d.m4558a(e);
                                i7 = i6;
                                i8 = i4;
                                i2 = i8;
                                i3 = i5;
                                i = i7;
                                list = telephonyManager.getNeighboringCellInfo();
                                C1060c cVar = new C1060c();
                                cVar.mo5736a(i3);
                                cVar.mo5739b(i2);
                                cVar.mo5741c(i);
                                cVar.mo5743d(i10);
                                cVar.mo5737a(list);
                                return cVar;
                            }
                        } else if (cellLocation instanceof CdmaCellLocation) {
                            int networkId = ((CdmaCellLocation) cellLocation).getNetworkId();
                            int systemId = ((CdmaCellLocation) cellLocation).getSystemId();
                            i9 = ((CdmaCellLocation) cellLocation).getBaseStationId();
                            i10 = networkId;
                            i8 = systemId;
                        } else {
                            i9 = 0;
                            i8 = i4;
                        }
                        i7 = i10;
                        i10 = i9;
                    } catch (Exception e3) {
                        e = e3;
                        i6 = 0;
                        C1115d.m4558a(e);
                        i7 = i6;
                        i8 = i4;
                        i2 = i8;
                        i3 = i5;
                        i = i7;
                        list = telephonyManager.getNeighboringCellInfo();
                        C1060c cVar2 = new C1060c();
                        cVar2.mo5736a(i3);
                        cVar2.mo5739b(i2);
                        cVar2.mo5741c(i);
                        cVar2.mo5743d(i10);
                        cVar2.mo5737a(list);
                        return cVar2;
                    }
                    i2 = i8;
                    i3 = i5;
                    i = i7;
                    list = telephonyManager.getNeighboringCellInfo();
                } else {
                    list = null;
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                }
                C1060c cVar22 = new C1060c();
                cVar22.mo5736a(i3);
                cVar22.mo5739b(i2);
                cVar22.mo5741c(i);
                cVar22.mo5743d(i10);
                cVar22.mo5737a(list);
                return cVar22;
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
        return null;
    }

    /* renamed from: a */
    public void mo5701a(C1045f fVar) {
        this.f2661c = fVar;
    }
}
