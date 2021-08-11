package com.amap.loc;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.CoordinateConverter;
import com.amap.api.location.DPoint;
import com.amap.loc.C0215a;

/* renamed from: com.amap.loc.e */
/* compiled from: GPSLocation */
public class C0334e {

    /* renamed from: a */
    Handler f797a;

    /* renamed from: b */
    Context f798b;

    /* renamed from: c */
    LocationManager f799c;

    /* renamed from: d */
    AMapLocationClientOption f800d;

    /* renamed from: e */
    C0326cn f801e = null;

    /* renamed from: f */
    CoordinateConverter f802f = null;

    /* renamed from: g */
    long f803g = 1000;

    /* renamed from: h */
    boolean f804h = false;

    /* renamed from: i */
    long f805i = 0;

    /* renamed from: j */
    LocationListener f806j = new LocationListener() {
        /* class com.amap.loc.C0334e.C03351 */

        public void onLocationChanged(Location location) {
            AMapLocation aMapLocation;
            if (location != null) {
                try {
                    Bundle extras = location.getExtras();
                    int i = extras != null ? extras.getInt("satellites") : 0;
                    if (i > 0 || C0334e.this.f800d.isMockEnable()) {
                        C0334e.this.f801e.mo3909b(C0331cr.m1170b());
                        if (!C0310c.m957a(location.getLatitude(), location.getLongitude()) || !C0334e.this.f800d.isOffset()) {
                            aMapLocation = new AMapLocation(location);
                            aMapLocation.setLatitude(location.getLatitude());
                            aMapLocation.setLongitude(location.getLongitude());
                            aMapLocation.setLocationType(1);
                        } else {
                            aMapLocation = new AMapLocation(location);
                            aMapLocation.setLocationType(1);
                            DPoint convert = C0334e.this.f802f.coord(new DPoint(location.getLatitude(), location.getLongitude())).from(CoordinateConverter.CoordType.GPS).convert();
                            aMapLocation.setLatitude(convert.getLatitude());
                            aMapLocation.setLongitude(convert.getLongitude());
                        }
                        aMapLocation.setSatellites(i);
                        long b = C0331cr.m1170b();
                        if (b - C0334e.this.f805i >= C0334e.this.f803g - 200) {
                            C0334e.this.f805i = C0331cr.m1170b();
                            if (C0334e.this.f797a != null) {
                                Message obtain = Message.obtain();
                                obtain.obj = aMapLocation;
                                obtain.what = 2;
                                C0334e.this.f797a.sendMessage(obtain);
                            }
                        } else if (C0334e.this.f797a != null) {
                            Message obtain2 = Message.obtain();
                            if (C0334e.this.f803g > 8000 && b - C0334e.this.f805i > C0334e.this.f803g - 8000) {
                                obtain2.obj = aMapLocation;
                            } else if (C0334e.this.f803g <= 8000) {
                                obtain2.obj = aMapLocation;
                            }
                            obtain2.what = 5;
                            C0334e.this.f797a.sendMessage(obtain2);
                        }
                        if (!C0310c.f639o && !C0329cq.m1147b(C0334e.this.f798b, "pref", "colde", false)) {
                            C0310c.f639o = true;
                            C0329cq.m1141a(C0334e.this.f798b, "pref", "colde", true);
                            C0327co.m1123a(C0334e.this.f798b, "Collertor");
                        }
                        if (C0334e.this.f807k != 0 && !C0334e.this.f804h) {
                            C0327co.m1129b(C0334e.this.f798b, C0334e.this.f801e);
                            C0334e.this.f804h = true;
                        }
                    }
                } catch (Throwable th) {
                    C0310c.m956a(th, "GPSLocation", "onLocationChanged");
                }
            }
        }

        public void onProviderDisabled(String str) {
            try {
                if ("gps".equals(str) && C0334e.this.f797a != null) {
                    C0334e.this.f797a.sendEmptyMessage(3);
                }
            } catch (Throwable th) {
                C0310c.m956a(th, "GPSLocation", "onProviderDisabled");
            }
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
            if (i == 0 || i == 1) {
                try {
                    if (C0334e.this.f797a != null) {
                        C0334e.this.f797a.sendEmptyMessage(3);
                    }
                } catch (Throwable th) {
                    C0310c.m956a(th, "GPSLocation", "onStatusChanged");
                }
            }
        }
    };

    /* renamed from: k */
    private long f807k = 0;

    public C0334e(Context context, C0215a.HandlerC0223c cVar) {
        this.f798b = context;
        this.f802f = new CoordinateConverter(this.f798b.getApplicationContext());
        this.f797a = cVar;
        this.f799c = (LocationManager) this.f798b.getSystemService("location");
        this.f801e = new C0326cn();
    }

    /* renamed from: a */
    public void mo3918a() {
        if (this.f799c != null) {
            if (this.f806j != null) {
                this.f799c.removeUpdates(this.f806j);
            }
            this.f807k = 0;
            this.f804h = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3919a(long j, float f) {
        try {
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                myLooper = this.f798b.getMainLooper();
            }
            this.f803g = j;
            this.f807k = C0331cr.m1170b();
            this.f801e.mo3906a(this.f807k);
            this.f799c.requestLocationUpdates("gps", 1000, f, this.f806j, myLooper);
        } catch (SecurityException e) {
            if (AMapLocationClientOption.AMapLocationMode.Device_Sensors.equals(this.f800d.getLocationMode())) {
                Message obtain = Message.obtain();
                AMapLocation aMapLocation = new AMapLocation("");
                aMapLocation.setProvider("gps");
                aMapLocation.setErrorCode(12);
                aMapLocation.setLocationType(1);
                obtain.what = 2;
                obtain.obj = aMapLocation;
                if (this.f797a != null) {
                    this.f797a.sendMessage(obtain);
                }
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "GPSLocation", "requestLocationUpdates part2");
        }
    }

    /* renamed from: a */
    public void mo3920a(AMapLocationClientOption aMapLocationClientOption) {
        this.f800d = aMapLocationClientOption;
        mo3919a(this.f800d.getInterval(), 0.0f);
    }
}
