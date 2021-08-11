package com.wanmei.push.p104g;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.PowerManager;
import java.net.InetSocketAddress;

/* renamed from: com.wanmei.push.g.h */
public final class C1716h {

    /* renamed from: a */
    private static C1716h f4354a;

    /* renamed from: b */
    private static Context f4355b;

    /* renamed from: c */
    private ConnectivityManager f4356c;

    /* renamed from: d */
    private volatile WifiManager.WifiLock f4357d;

    /* renamed from: e */
    private volatile PowerManager.WakeLock f4358e;

    /* renamed from: f */
    private volatile boolean f4359f;

    private C1716h() {
    }

    /* renamed from: a */
    public static synchronized C1716h m6385a(Context context) {
        C1716h hVar;
        synchronized (C1716h.class) {
            if (context == null) {
                throw new NullPointerException();
            }
            f4355b = context.getApplicationContext();
            if (f4354a == null) {
                f4354a = new C1716h();
            }
            hVar = f4354a;
        }
        return hVar;
    }

    /* renamed from: e */
    private void m6386e() {
        if (this.f4356c == null) {
            this.f4356c = (ConnectivityManager) f4355b.getSystemService("connectivity");
        }
    }

    /* renamed from: a */
    public final int mo9379a() {
        m6386e();
        NetworkInfo activeNetworkInfo = this.f4356c.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    /* renamed from: b */
    public final boolean mo9380b() {
        m6386e();
        return (this.f4356c == null || this.f4356c.getActiveNetworkInfo() == null || !this.f4356c.getActiveNetworkInfo().isAvailable()) ? false : true;
    }

    /* renamed from: c */
    public final InetSocketAddress mo9381c() {
        if (mo9379a() != 0) {
            return null;
        }
        Cursor query = f4355b.getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
        if (query != null && query.moveToFirst()) {
            String string = query.getString(query.getColumnIndex("proxy"));
            String string2 = query.getString(query.getColumnIndex("port"));
            if (string != null && string.trim().length() > 0) {
                return new InetSocketAddress(string, Integer.getInteger(string2, 80).intValue());
            }
        }
        if (query == null) {
            return null;
        }
        query.close();
        return null;
    }

    /* renamed from: d */
    public final synchronized void mo9382d() {
        if (this.f4359f) {
            if (this.f4357d == null) {
                this.f4357d = ((WifiManager) f4355b.getSystemService("wifi")).createWifiLock("WIFILOCK");
                this.f4357d.setReferenceCounted(false);
            }
            this.f4357d.acquire();
            if (this.f4358e == null) {
                this.f4358e = ((PowerManager) f4355b.getSystemService("power")).newWakeLock(1, "WAKELOCK");
                this.f4358e.setReferenceCounted(false);
            }
            this.f4358e.acquire();
        }
    }
}
