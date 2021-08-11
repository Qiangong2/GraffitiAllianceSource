package com.amap.loc;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* renamed from: com.amap.loc.l */
/* compiled from: DeviceInfo */
public class C0353l {

    /* renamed from: a */
    private static String f881a = "";

    /* renamed from: b */
    private static boolean f882b = false;

    /* renamed from: c */
    private static String f883c = "";

    /* renamed from: d */
    private static String f884d = "";

    /* renamed from: e */
    private static String f885e = "";

    /* renamed from: f */
    private static String f886f = "";

    /* access modifiers changed from: package-private */
    /* renamed from: com.amap.loc.l$a */
    /* compiled from: DeviceInfo */
    public static class C0354a extends DefaultHandler {
        C0354a() {
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) throws SAXException {
            if (C0353l.f882b) {
                String unused = C0353l.f881a = new String(cArr, i, i2);
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            boolean unused = C0353l.f882b = false;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            if (str2.equals("string") && "UTDID".equals(attributes.getValue("name"))) {
                boolean unused = C0353l.f882b = true;
            }
        }
    }

    /* renamed from: a */
    public static String m1262a(Context context) {
        try {
            return m1288u(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    private static List<ScanResult> m1264a(List<ScanResult> list) {
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            for (int i2 = 1; i2 < size - i; i2++) {
                if (list.get(i2 - 1).level > list.get(i2).level) {
                    list.set(i2 - 1, list.get(i2));
                    list.set(i2, list.get(i2 - 1));
                }
            }
        }
        return list;
    }

    /* renamed from: a */
    public static void m1265a() {
        try {
            if (Build.VERSION.SDK_INT > 14) {
                TrafficStats.class.getDeclaredMethod("setThreadStatsTag", Integer.TYPE).invoke(null, 40964);
            }
        } catch (Throwable th) {
            C0365t.m1372a(th, "DeviceInfo", "setTraficTag");
        }
    }

    /* renamed from: a */
    private static boolean m1266a(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    /* renamed from: b */
    public static String m1268b(Context context) {
        try {
            return m1291x(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* renamed from: c */
    public static int m1270c(Context context) {
        try {
            return m1292y(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    /* renamed from: d */
    public static int m1271d(Context context) {
        try {
            return m1289v(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    /* renamed from: e */
    public static String m1272e(Context context) {
        try {
            return m1287t(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* renamed from: f */
    public static String m1273f(Context context) {
        try {
            if (f881a != null && !"".equals(f881a)) {
                return f881a;
            }
            if (m1266a(context, "android.permission.WRITE_SETTINGS")) {
                f881a = Settings.System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
            }
            if (f881a != null && !"".equals(f881a)) {
                return f881a;
            }
            try {
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/.UTSystemConfig/Global/Alvin2.xml");
                    if (file.exists()) {
                        SAXParserFactory.newInstance().newSAXParser().parse(file, new C0354a());
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Throwable th) {
                C0365t.m1372a(th, "DeviceInfo", "getUTDID");
            }
            return f881a == null ? "" : f881a;
        } catch (Throwable th2) {
            C0365t.m1372a(th2, "DeviceInfo", "getUTDID");
        }
    }

    /* renamed from: g */
    static String m1274g(Context context) {
        String str;
        WifiManager wifiManager;
        if (context == null) {
            return "";
        }
        try {
            if (!m1266a(context, "android.permission.ACCESS_WIFI_STATE") || (wifiManager = (WifiManager) context.getSystemService("wifi")) == null) {
                return "";
            }
            if (wifiManager.isWifiEnabled()) {
                str = wifiManager.getConnectionInfo().getBSSID();
                return str;
            }
            str = "";
            return str;
        } catch (Throwable th) {
            C0365t.m1372a(th, "DeviceInfo", "getWifiMacs");
        }
    }

    /* renamed from: h */
    static String m1275h(Context context) {
        StringBuilder sb = new StringBuilder();
        if (context != null) {
            try {
                if (m1266a(context, "android.permission.ACCESS_WIFI_STATE")) {
                    WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                    if (wifiManager == null) {
                        return "";
                    }
                    if (wifiManager.isWifiEnabled()) {
                        List<ScanResult> scanResults = wifiManager.getScanResults();
                        if (scanResults == null || scanResults.size() == 0) {
                            return sb.toString();
                        }
                        List<ScanResult> a = m1264a(scanResults);
                        boolean z = true;
                        int i = 0;
                        while (i < a.size() && i < 7) {
                            ScanResult scanResult = a.get(i);
                            if (z) {
                                z = false;
                            } else {
                                sb.append(";");
                            }
                            sb.append(scanResult.BSSID);
                            i++;
                        }
                    }
                    return sb.toString();
                }
            } catch (Throwable th) {
                C0365t.m1372a(th, "DeviceInfo", "getWifiMacs");
            }
        }
        return sb.toString();
    }

    /* renamed from: i */
    public static String m1276i(Context context) {
        try {
            if (f883c != null && !"".equals(f883c)) {
                return f883c;
            }
            if (!m1266a(context, "android.permission.ACCESS_WIFI_STATE")) {
                return f883c;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            f883c = wifiManager.getConnectionInfo().getMacAddress();
            return f883c;
        } catch (Throwable th) {
            C0365t.m1372a(th, "DeviceInfo", "getDeviceMac");
        }
    }

    /* renamed from: j */
    static String[] m1277j(Context context) {
        try {
            if (!m1266a(context, "android.permission.READ_PHONE_STATE") || !m1266a(context, "android.permission.ACCESS_COARSE_LOCATION")) {
                return new String[]{"", ""};
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return new String[]{"", ""};
            }
            CellLocation cellLocation = telephonyManager.getCellLocation();
            if (cellLocation instanceof GsmCellLocation) {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                return new String[]{gsmCellLocation.getLac() + "||" + gsmCellLocation.getCid(), "gsm"};
            }
            if (cellLocation instanceof CdmaCellLocation) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                int systemId = cdmaCellLocation.getSystemId();
                int networkId = cdmaCellLocation.getNetworkId();
                int baseStationId = cdmaCellLocation.getBaseStationId();
                if (systemId < 0 || networkId < 0 || baseStationId < 0) {
                }
                return new String[]{systemId + "||" + networkId + "||" + baseStationId, "cdma"};
            }
            return new String[]{"", ""};
        } catch (Throwable th) {
            C0365t.m1372a(th, "DeviceInfo", "cellInfo");
        }
    }

    /* renamed from: k */
    static String m1278k(Context context) {
        try {
            if (!m1266a(context, "android.permission.READ_PHONE_STATE")) {
                return "";
            }
            TelephonyManager z = m1293z(context);
            if (z == null) {
                return "";
            }
            String networkOperator = z.getNetworkOperator();
            return (TextUtils.isEmpty(networkOperator) || networkOperator.length() < 3) ? "" : networkOperator.substring(3);
        } catch (Throwable th) {
            C0365t.m1372a(th, "DeviceInfo", "getMNC");
            return "";
        }
    }

    /* renamed from: l */
    public static int m1279l(Context context) {
        try {
            return m1292y(context);
        } catch (Throwable th) {
            C0365t.m1372a(th, "DeviceInfo", "getNetWorkType");
            return -1;
        }
    }

    /* renamed from: m */
    public static int m1280m(Context context) {
        try {
            return m1289v(context);
        } catch (Throwable th) {
            C0365t.m1372a(th, "DeviceInfo", "getActiveNetWorkType");
            return -1;
        }
    }

    /* renamed from: n */
    public static NetworkInfo m1281n(Context context) {
        ConnectivityManager w;
        if (m1266a(context, "android.permission.ACCESS_NETWORK_STATE") && (w = m1290w(context)) != null) {
            return w.getActiveNetworkInfo();
        }
        return null;
    }

    /* renamed from: o */
    static String m1282o(Context context) {
        try {
            NetworkInfo n = m1281n(context);
            if (n == null) {
                return null;
            }
            return n.getExtraInfo();
        } catch (Throwable th) {
            C0365t.m1372a(th, "DeviceInfo", "getNetworkExtraInfo");
            return null;
        }
    }

    /* renamed from: p */
    static String m1283p(Context context) {
        try {
            if (f884d != null && !"".equals(f884d)) {
                return f884d;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return "";
            }
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            f884d = i2 > i ? i + "*" + i2 : i2 + "*" + i;
            return f884d;
        } catch (Throwable th) {
            C0365t.m1372a(th, "DeviceInfo", "getReslution");
        }
    }

    /* renamed from: q */
    public static String m1284q(Context context) {
        try {
            if (f885e != null && !"".equals(f885e)) {
                return f885e;
            }
            if (!m1266a(context, "android.permission.READ_PHONE_STATE")) {
                return f885e;
            }
            TelephonyManager z = m1293z(context);
            if (z == null) {
                return "";
            }
            f885e = z.getDeviceId();
            if (f885e == null) {
                f885e = "";
            }
            return f885e;
        } catch (Throwable th) {
            C0365t.m1372a(th, "DeviceInfo", "getDeviceID");
        }
    }

    /* renamed from: r */
    public static String m1285r(Context context) {
        try {
            return m1287t(context);
        } catch (Throwable th) {
            C0365t.m1372a(th, "DeviceInfo", "getSubscriberId");
            return "";
        }
    }

    /* renamed from: s */
    static String m1286s(Context context) {
        try {
            return m1288u(context);
        } catch (Throwable th) {
            C0365t.m1372a(th, "DeviceInfo", "getNetworkOperatorName");
            return "";
        }
    }

    /* renamed from: t */
    private static String m1287t(Context context) {
        if (f886f != null && !"".equals(f886f)) {
            return f886f;
        }
        if (!m1266a(context, "android.permission.READ_PHONE_STATE")) {
            return f886f;
        }
        TelephonyManager z = m1293z(context);
        if (z == null) {
            return "";
        }
        f886f = z.getSubscriberId();
        if (f886f == null) {
            f886f = "";
        }
        return f886f;
    }

    /* renamed from: u */
    private static String m1288u(Context context) {
        if (!m1266a(context, "android.permission.READ_PHONE_STATE")) {
            return null;
        }
        TelephonyManager z = m1293z(context);
        if (z == null) {
            return "";
        }
        String simOperatorName = z.getSimOperatorName();
        return TextUtils.isEmpty(simOperatorName) ? z.getNetworkOperatorName() : simOperatorName;
    }

    /* renamed from: v */
    private static int m1289v(Context context) {
        ConnectivityManager w;
        NetworkInfo activeNetworkInfo;
        if (context == null || !m1266a(context, "android.permission.ACCESS_NETWORK_STATE") || (w = m1290w(context)) == null || (activeNetworkInfo = w.getActiveNetworkInfo()) == null) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    /* renamed from: w */
    private static ConnectivityManager m1290w(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    /* renamed from: x */
    private static String m1291x(Context context) {
        String r = m1285r(context);
        return (r == null || r.length() < 5) ? "" : r.substring(3, 5);
    }

    /* renamed from: y */
    private static int m1292y(Context context) {
        TelephonyManager z;
        if (m1266a(context, "android.permission.READ_PHONE_STATE") && (z = m1293z(context)) != null) {
            return z.getNetworkType();
        }
        return -1;
    }

    /* renamed from: z */
    private static TelephonyManager m1293z(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }
}
