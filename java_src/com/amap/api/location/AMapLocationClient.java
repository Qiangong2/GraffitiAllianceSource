package com.amap.api.location;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.amap.loc.C0215a;
import com.amap.loc.C0244ar;
import com.amap.loc.C0310c;
import com.amap.loc.C0328cp;
import com.amap.loc.C0360q;

public class AMapLocationClient {

    /* renamed from: a */
    Context f187a;

    /* renamed from: b */
    LocationManagerBase f188b;

    public AMapLocationClient(Context context) {
        if (context == null) {
            try {
                throw new IllegalArgumentException("Context参数不能为null");
            } catch (Throwable th) {
                C0310c.m956a(th, "AMapLocationClient", "AMapLocationClient 1");
            }
        } else {
            this.f187a = context.getApplicationContext();
            this.f188b = m347a(this.f187a, null);
        }
    }

    public AMapLocationClient(Context context, Intent intent) {
        if (context == null) {
            try {
                throw new IllegalArgumentException("Context参数不能为null");
            } catch (Throwable th) {
                C0310c.m956a(th, "AMapLocationClient", "AMapLocationClient 2");
            }
        } else {
            this.f187a = context.getApplicationContext();
            this.f188b = m347a(this.f187a, intent);
        }
    }

    /* renamed from: a */
    private LocationManagerBase m347a(Context context, Intent intent) {
        LocationManagerBase aVar;
        try {
            C0360q a = C0310c.m950a("loc", "3.0.0");
            C0328cp.m1133a(context, a);
            boolean c = C0328cp.m1136c(context);
            C0328cp.m1131a(context);
            aVar = c ? (LocationManagerBase) C0244ar.m536a(context, a, "com.amap.api.location.LocationManagerWrapper", C0215a.class, new Class[]{Context.class, Intent.class}, new Object[]{context, intent}) : new C0215a(context, intent);
        } catch (Throwable th) {
            aVar = new C0215a(context, intent);
        }
        return aVar == null ? new C0215a(context, intent) : aVar;
    }

    public static void setApiKey(String str) {
        try {
            AMapLocationClientOption.f189a = str;
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationClient", "setApiKey");
        }
    }

    public void addGeoFenceAlert(String str, double d, double d2, float f, long j, PendingIntent pendingIntent) {
        try {
            this.f188b.addGeoFenceAlert(str, d, d2, f, j, pendingIntent);
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationClient", "addGeoFenceAlert");
        }
    }

    public AMapLocation getLastKnownLocation() {
        try {
            if (this.f188b != null) {
                return this.f188b.getLastKnownLocation();
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationClient", "getLastKnownLocation");
        }
        return null;
    }

    public String getVersion() {
        return "3.0.0";
    }

    public boolean isStarted() {
        try {
            if (this.f188b != null) {
                return this.f188b.isStarted();
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationClient", "isStarted");
        }
        return false;
    }

    public void onDestroy() {
        try {
            this.f188b.onDestroy();
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationClient", "onDestroy");
        }
    }

    public void removeGeoFenceAlert(PendingIntent pendingIntent) {
        try {
            this.f188b.removeGeoFenceAlert(pendingIntent);
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationClient", "removeGeoFenceAlert 2");
        }
    }

    public void removeGeoFenceAlert(PendingIntent pendingIntent, String str) {
        try {
            this.f188b.removeGeoFenceAlert(pendingIntent, str);
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationClient", "removeGeoFenceAlert 1");
        }
    }

    public void setLocationListener(AMapLocationListener aMapLocationListener) {
        if (aMapLocationListener == null) {
            try {
                throw new IllegalArgumentException("listener参数不能为null");
            } catch (Throwable th) {
                C0310c.m956a(th, "AMapLocationClient", "setLocationListener");
            }
        } else {
            this.f188b.setLocationListener(aMapLocationListener);
        }
    }

    public void setLocationOption(AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption == null) {
            try {
                throw new IllegalArgumentException("LocationManagerOption参数不能为null");
            } catch (Throwable th) {
                C0310c.m956a(th, "AMapLocationClient", "setLocationOption");
            }
        } else {
            this.f188b.setLocationOption(aMapLocationClientOption);
        }
    }

    public void startAssistantLocation() {
        try {
            this.f188b.startAssistantLocation();
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationClient", "startAssistantLocation");
        }
    }

    public void startLocation() {
        try {
            this.f188b.startLocation();
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationClient", "startLocation");
        }
    }

    public void stopAssistantLocation() {
        try {
            this.f188b.startAssistantLocation();
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationClient", "stopAssistantLocation");
        }
    }

    public void stopLocation() {
        try {
            this.f188b.stopLocation();
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationClient", "stopLocation");
        }
    }

    public void unRegisterLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            this.f188b.unRegisterLocationListener(aMapLocationListener);
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationClient", "unRegisterLocationListener");
        }
    }
}
