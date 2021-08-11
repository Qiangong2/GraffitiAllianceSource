package com.amap.loc;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.amap.loc.by */
/* compiled from: WifiManagerWrapper */
public class C0308by {

    /* renamed from: a */
    long f617a = 0;

    /* renamed from: b */
    private WifiManager f618b;

    /* renamed from: c */
    private JSONObject f619c;

    /* renamed from: d */
    private Context f620d;

    /* renamed from: e */
    private String f621e = null;

    public C0308by(Context context, WifiManager wifiManager, JSONObject jSONObject) {
        this.f618b = wifiManager;
        this.f619c = jSONObject;
        this.f620d = context;
    }

    /* renamed from: a */
    private boolean m927a(WifiInfo wifiInfo) {
        return wifiInfo != null && !TextUtils.isEmpty(wifiInfo.getBSSID()) && wifiInfo.getSSID() != null && !wifiInfo.getBSSID().equals("00:00:00:00:00:00") && !wifiInfo.getBSSID().contains(" :") && !TextUtils.isEmpty(wifiInfo.getSSID());
    }

    /* renamed from: a */
    public List<ScanResult> mo3842a() {
        if (this.f618b != null) {
            try {
                List<ScanResult> scanResults = this.f618b.getScanResults();
                this.f621e = null;
                return scanResults;
            } catch (SecurityException e) {
                this.f621e = e.getMessage();
            } catch (Throwable th) {
                this.f621e = null;
                C0310c.m956a(th, "WifiManagerWrapper", "getScanResults");
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo3843a(JSONObject jSONObject) {
        this.f619c = jSONObject;
    }

    /* renamed from: a */
    public void mo3844a(boolean z) {
        Context context = this.f620d;
        if (this.f618b != null && context != null && z && C0331cr.m1178c() > 17) {
            if (C0331cr.m1166a(this.f619c, "autoenablewifialwaysscan")) {
                try {
                    if ("0".equals(this.f619c.getString("autoenablewifialwaysscan"))) {
                        return;
                    }
                } catch (Throwable th) {
                    C0310c.m956a(th, "WifiManagerWrapper", "enableWifiAlwaysScan1");
                }
            }
            ContentResolver contentResolver = context.getContentResolver();
            try {
                if (((Integer) C0325cm.m1112a("android.provider.Settings$Global", "getInt", new Object[]{contentResolver, "wifi_scan_always_enabled"}, new Class[]{ContentResolver.class, String.class})).intValue() == 0) {
                    C0325cm.m1112a("android.provider.Settings$Global", "putInt", new Object[]{contentResolver, "wifi_scan_always_enabled", 1}, new Class[]{ContentResolver.class, String.class, Integer.TYPE});
                }
            } catch (Throwable th2) {
                C0310c.m956a(th2, "WifiManagerWrapper", "enableWifiAlwaysScan");
            }
        }
    }

    /* renamed from: a */
    public boolean mo3845a(ConnectivityManager connectivityManager) {
        boolean z = true;
        WifiManager wifiManager = this.f618b;
        if (wifiManager == null || !mo3850f()) {
            return false;
        }
        try {
            if (C0318cg.m1003a(connectivityManager.getActiveNetworkInfo()) != 1 || !m927a(wifiManager.getConnectionInfo())) {
                z = false;
            }
            return z;
        } catch (Throwable th) {
            C0310c.m956a(th, "WifiManagerWrapper", "wifiAccess");
            return false;
        }
    }

    /* renamed from: b */
    public WifiInfo mo3846b() {
        if (this.f618b != null) {
            return this.f618b.getConnectionInfo();
        }
        return null;
    }

    /* renamed from: c */
    public int mo3847c() {
        if (this.f618b != null) {
            return this.f618b.getWifiState();
        }
        return 4;
    }

    /* renamed from: d */
    public boolean mo3848d() {
        if (C0331cr.m1170b() - this.f617a < 3000 || this.f618b == null) {
            return false;
        }
        this.f617a = C0331cr.m1170b();
        return this.f618b.startScan();
    }

    /* renamed from: e */
    public boolean mo3849e() {
        try {
            return String.valueOf(C0325cm.m1110a(this.f618b, "startScanActive", new Object[0])).equals("true");
        } catch (Throwable th) {
            C0310c.m956a(th, "WifiManagerWrapper", "startScanActive");
            return false;
        }
    }

    /* renamed from: f */
    public boolean mo3850f() {
        boolean z = false;
        WifiManager wifiManager = this.f618b;
        if (wifiManager == null) {
            return false;
        }
        try {
            z = wifiManager.isWifiEnabled();
        } catch (Throwable th) {
            C0310c.m956a(th, "WifiManagerWrapper", "wifiEnabled1");
        }
        if (z || C0331cr.m1178c() <= 17) {
            return z;
        }
        try {
            return String.valueOf(C0325cm.m1110a(wifiManager, "isScanAlwaysAvailable", new Object[0])).equals("true");
        } catch (Throwable th2) {
            C0310c.m956a(th2, "WifiManagerWrapper", "wifiEnabled");
            return z;
        }
    }

    /* renamed from: g */
    public String mo3851g() {
        return this.f621e;
    }
}
