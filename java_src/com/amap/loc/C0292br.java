package com.amap.loc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.loc.C0296bs;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.igexin.sdk.PushConsts;
import com.umeng.analytics.p091b.C1447g;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import org.json.JSONObject;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.amap.loc.br */
/* compiled from: APS */
public class C0292br {

    /* renamed from: l */
    static boolean f484l = false;

    /* renamed from: n */
    static int f485n = -1;

    /* renamed from: o */
    static long f486o = 0;

    /* renamed from: p */
    static int f487p = -1;

    /* renamed from: A */
    private JSONObject f488A = null;

    /* renamed from: B */
    private volatile AMapLocationServer f489B = null;

    /* renamed from: C */
    private volatile long f490C = 0;

    /* renamed from: D */
    private long f491D = 0;

    /* renamed from: E */
    private long f492E = 0;

    /* renamed from: F */
    private volatile boolean f493F = false;

    /* renamed from: G */
    private boolean f494G = false;

    /* renamed from: H */
    private long f495H = 0;

    /* renamed from: I */
    private volatile long f496I = 0;

    /* renamed from: J */
    private int f497J = 0;

    /* renamed from: K */
    private volatile String f498K = "00:00:00:00:00:00";

    /* renamed from: L */
    private String f499L = null;

    /* renamed from: M */
    private C0321cj f500M = null;

    /* renamed from: N */
    private volatile Timer f501N = null;

    /* renamed from: O */
    private volatile TimerTask f502O = null;

    /* renamed from: P */
    private int f503P = 0;

    /* renamed from: Q */
    private Object f504Q = null;

    /* renamed from: R */
    private volatile Object f505R = null;

    /* renamed from: S */
    private boolean f506S = false;

    /* renamed from: T */
    private String f507T = null;

    /* renamed from: U */
    private String f508U = null;

    /* renamed from: V */
    private long f509V = 0;

    /* renamed from: W */
    private volatile long f510W = 0;

    /* renamed from: X */
    private volatile String f511X = null;

    /* renamed from: Y */
    private C0304bw f512Y = null;

    /* renamed from: Z */
    private C0318cg f513Z = null;

    /* renamed from: a */
    C0296bs f514a;

    /* renamed from: aa */
    private StringBuilder f515aa = new StringBuilder();

    /* renamed from: ab */
    private boolean f516ab = true;

    /* renamed from: ac */
    private boolean f517ac = true;

    /* renamed from: ad */
    private volatile boolean f518ad = true;

    /* renamed from: ae */
    private boolean f519ae = false;

    /* renamed from: af */
    private boolean f520af = false;

    /* renamed from: ag */
    private boolean f521ag = false;

    /* renamed from: ah */
    private boolean f522ah = false;

    /* renamed from: ai */
    private volatile boolean f523ai = false;

    /* renamed from: aj */
    private boolean f524aj = false;

    /* renamed from: ak */
    private String f525ak = null;

    /* renamed from: al */
    private String f526al = null;

    /* renamed from: am */
    private boolean f527am = false;

    /* renamed from: b */
    volatile int f528b = -1;

    /* renamed from: c */
    boolean f529c = false;

    /* renamed from: d */
    Object f530d = new Object();

    /* renamed from: e */
    public boolean f531e = false;

    /* renamed from: f */
    public String f532f = "com.data.carrier_v4.CollectorManager";

    /* renamed from: g */
    public String f533g = "com.autonavi.aps.amapapi.offline.Off";

    /* renamed from: h */
    volatile boolean f534h = false;

    /* renamed from: i */
    int f535i = 12;

    /* renamed from: j */
    TreeMap<Integer, ScanResult> f536j = null;

    /* renamed from: k */
    boolean f537k = true;

    /* renamed from: m */
    C0294a f538m = new C0294a();

    /* renamed from: q */
    StringBuilder f539q = null;

    /* renamed from: r */
    private volatile Context f540r = null;

    /* renamed from: s */
    private ConnectivityManager f541s = null;

    /* renamed from: t */
    private volatile C0308by f542t = null;

    /* renamed from: u */
    private volatile C0305bx f543u = null;

    /* renamed from: v */
    private ArrayList<ScanResult> f544v = new ArrayList<>();

    /* renamed from: w */
    private volatile ArrayList<ScanResult> f545w = new ArrayList<>();

    /* renamed from: x */
    private HashMap<String, ArrayList<ScanResult>> f546x = new HashMap<>();

    /* renamed from: y */
    private C0295b f547y = null;

    /* renamed from: z */
    private volatile WifiInfo f548z = null;

    /* access modifiers changed from: package-private */
    /* renamed from: com.amap.loc.br$a */
    /* compiled from: APS */
    public class C0294a implements C0296bs.AbstractC0300a {
        C0294a() {
        }

        @Override // com.amap.loc.C0296bs.AbstractC0300a
        /* renamed from: a */
        public void mo3801a(int i) {
            C0292br.this.f528b = i;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.amap.loc.br$b */
    /* compiled from: APS */
    public class C0295b extends BroadcastReceiver {
        private C0295b() {
        }

        public void onReceive(Context context, Intent intent) {
            if (context != null && intent != null) {
                try {
                    String action = intent.getAction();
                    if (!TextUtils.isEmpty(action)) {
                        C0308by byVar = C0292br.this.f542t;
                        if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                            if (byVar != null) {
                                List<ScanResult> list = null;
                                try {
                                    list = byVar.mo3842a();
                                } catch (Throwable th) {
                                    C0310c.m956a(th, "APS", "onReceive part1");
                                }
                                if (list != null) {
                                    synchronized (C0292br.this.f530d) {
                                        C0292br.this.f545w.clear();
                                        C0292br.this.f545w.addAll(list);
                                    }
                                }
                                C0292br.this.f496I = C0331cr.m1170b();
                            }
                        } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                            if (C0292br.this.f542t != null) {
                                int i = 4;
                                try {
                                    i = byVar.mo3847c();
                                } catch (Throwable th2) {
                                    C0310c.m956a(th2, "APS", "onReceive part");
                                }
                                if (C0292br.this.f545w == null) {
                                    C0292br.this.f545w = new ArrayList();
                                }
                                switch (i) {
                                    case 0:
                                        C0292br.this.m835r();
                                        return;
                                    case 1:
                                        C0292br.this.m835r();
                                        return;
                                    case 2:
                                    case 3:
                                    default:
                                        return;
                                    case 4:
                                        C0292br.this.m835r();
                                        return;
                                }
                            }
                        } else if (action.equals("android.intent.action.SCREEN_ON")) {
                            C0292br.this.f537k = true;
                        } else if (action.equals("android.intent.action.SCREEN_OFF")) {
                            C0292br.this.f537k = false;
                            if (C0292br.this.f504Q != null) {
                                C0292br.this.m842y();
                            }
                        } else if (!action.equals("android.intent.action.AIRPLANE_MODE") && !action.equals("android.location.GPS_FIX_CHANGE") && action.equals(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE) && C0292br.this.m791C()) {
                            C0292br.this.m809a((C0292br) true, true);
                        }
                    }
                } catch (Throwable th3) {
                    C0310c.m956a(th3, "APS", "onReceive");
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: A */
    private int m789A() {
        try {
            return ((Integer) C0325cm.m1110a(this.f504Q, "getLeftUploadNum", new Object[0])).intValue();
        } catch (Throwable th) {
            return 0;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: B */
    private synchronized void m790B() {
        if (this.f502O != null) {
            this.f502O.cancel();
            this.f502O = null;
        }
        if (this.f501N != null) {
            this.f501N.cancel();
            this.f501N.purge();
            this.f501N = null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: C */
    private boolean m791C() {
        if (this.f542t == null || this.f541s == null) {
            return false;
        }
        return this.f542t.mo3845a(this.f541s);
    }

    /* renamed from: D */
    private void m792D() {
        if (C0331cr.m1166a(this.f488A, "poiid")) {
            try {
                String string = this.f488A.getString("poiid");
                if (TextUtils.isEmpty(string)) {
                    this.f499L = null;
                } else if (string.length() > 32) {
                    this.f499L = null;
                } else {
                    this.f499L = string;
                }
            } catch (Throwable th) {
                C0310c.m956a(th, "APS", "setPoiid");
            }
        } else {
            this.f499L = null;
        }
    }

    /* renamed from: E */
    private String m793E() {
        try {
            if (this.f504Q != null) {
                return (String) C0325cm.m1110a(this.f504Q, "getInnerString", "version");
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "APS", "getCollVer");
        }
        return null;
    }

    /* renamed from: F */
    private void m794F() {
        if (this.f542t != null && this.f540r != null && this.f506S) {
            this.f542t.mo3844a(this.f506S);
        }
    }

    /* renamed from: G */
    private boolean m795G() {
        try {
            if (this.f540r == null || C0331cr.m1170b() - f486o < 1800000) {
                return false;
            }
            f486o = C0331cr.m1170b();
            return C0331cr.m1188e(this.f540r) > f487p;
        } catch (Throwable th) {
            C0310c.m956a(th, "APS", "isConfigNeedUpdate");
            return false;
        }
    }

    /* renamed from: H */
    private synchronized void m796H() {
        if (this.f525ak != null) {
            this.f525ak = null;
            this.f526al = null;
            this.f539q = null;
        }
        try {
            if (!this.f493F) {
                this.f543u.mo3821a(this.f493F, true);
            }
            this.f520af = this.f488A.optBoolean("isOnceLocationLatest", false);
            if (this.f520af) {
                if (!this.f519ae) {
                    m829l();
                    this.f519ae = true;
                }
                m832o();
            }
            mo3795e();
            if (this.f544v != null && this.f544v.isEmpty()) {
                this.f496I = C0331cr.m1170b();
                List<ScanResult> a = this.f542t.mo3842a();
                if (a != null) {
                    this.f544v.addAll(a);
                    synchronized (this.f530d) {
                        if (this.f545w != null && this.f545w.isEmpty()) {
                            this.f545w.addAll(a);
                        }
                    }
                }
            }
            mo3796f();
        } catch (Throwable th) {
            C0310c.m956a(th, "APS", "initFirstLocateParam");
        }
        this.f525ak = mo3782a(false);
        if (!TextUtils.isEmpty(this.f525ak)) {
            this.f526al = this.f525ak + "&" + this.f517ac + "&" + this.f516ab;
            this.f539q = mo3788b(true);
        }
        this.f527am = true;
    }

    /* renamed from: I */
    private void m797I() {
        try {
            this.f511X = null;
            this.f489B = null;
            m815b((JSONObject) null);
            this.f510W = 0;
            this.f490C = 0;
            C0302bu.m875a().mo3818b();
        } catch (Throwable th) {
            C0310c.m956a(th, "APS", "cleanCache");
        }
    }

    /* renamed from: J */
    private boolean m798J() {
        return C0322ck.m1068f() && this.f505R != null && C0322ck.m1093u();
    }

    /* renamed from: a */
    private AMapLocationServer m801a(String str, String str2, JSONObject jSONObject, Context context, String str3) {
        Object obj;
        int i = 0;
        try {
            if (m798J()) {
                try {
                    obj = C0325cm.m1110a(this.f505R, "getPureOfflineLocation", str, str2, jSONObject, str3);
                    i = 1;
                } catch (Throwable th) {
                    obj = null;
                }
                if (!this.f524aj) {
                    this.f524aj = true;
                    C0327co.m1130b(context, "OffLocation", i);
                }
                AMapLocationServer aMapLocationServer = new AMapLocationServer("");
                aMapLocationServer.mo3962b(new JSONObject((String) obj));
                return aMapLocationServer;
            }
        } catch (Throwable th2) {
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00cd  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.autonavi.aps.amapapi.model.AMapLocationServer m802a(boolean r11, boolean r12, boolean r13) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 716
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0292br.m802a(boolean, boolean, boolean):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    /* renamed from: a */
    private String m803a(int i, int i2, int i3) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("e", i);
        jSONObject.put("d", i2);
        jSONObject.put("u", i3);
        return jSONObject.toString();
    }

    /* renamed from: a */
    private void m805a(SharedPreferences sharedPreferences) {
        String str;
        if (this.f540r != null && sharedPreferences != null) {
            if (sharedPreferences.contains("smac")) {
                try {
                    str = new String(C0355m.m1299b(sharedPreferences.getString("smac", null)), "UTF-8");
                } catch (Throwable th) {
                    C0310c.m956a(th, "APS", "getSmac");
                    sharedPreferences.edit().remove("smac").commit();
                    str = null;
                }
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str) && !str.equals("00:00:00:00:00:00")) {
                this.f498K = str;
            }
        }
    }

    /* renamed from: a */
    private void m808a(String str) {
        try {
            if (m798J()) {
                try {
                    C0325cm.m1110a(this.f505R, str, new Object[0]);
                } catch (Throwable th) {
                }
                if (this.f540r == null) {
                }
            } else if (this.f505R != null) {
                C0325cm.m1110a(this.f505R, "stopOff", new Object[0]);
                this.f534h = false;
            }
        } catch (Throwable th2) {
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private void m809a(boolean z, int i) {
        if (m837t()) {
            if (!z) {
                m790B();
            } else {
                m816c(i);
            }
        }
    }

    /* renamed from: a */
    private boolean m810a(int i) {
        int i2 = 20;
        try {
            i2 = WifiManager.calculateSignalLevel(i, 20);
        } catch (ArithmeticException e) {
            C0310c.m956a(e, "APS", "wifiSigFine");
        }
        return i2 >= 1;
    }

    /* renamed from: a */
    private boolean m811a(long j) {
        if (C0331cr.m1170b() - j >= 800) {
            return false;
        }
        long j2 = 0;
        if (C0331cr.m1164a(this.f489B)) {
            j2 = C0331cr.m1156a() - this.f489B.getTime();
        }
        return j2 <= 10000;
    }

    /* renamed from: a */
    private boolean m812a(WifiInfo wifiInfo) {
        return wifiInfo != null && !TextUtils.isEmpty(wifiInfo.getBSSID()) && !TextUtils.isEmpty(wifiInfo.getSSID()) && !wifiInfo.getBSSID().equals("00:00:00:00:00:00") && !wifiInfo.getBSSID().contains(" :");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: b */
    private void m814b(int i) {
        Object obj;
        int i2 = 674234367;
        if (m837t() && C0322ck.m1092t()) {
            switch (i) {
                case 0:
                    i2 = 70254591;
                    break;
                case 1:
                    break;
                case 2:
                    if (m791C()) {
                        i2 = 2083520511;
                        break;
                    }
                    break;
                default:
                    i2 = 70254591;
                    break;
            }
            try {
                C0325cm.m1110a(this.f504Q, "callBackWrapData", m803a(1, i2, 1));
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                obj = C0325cm.m1110a(this.f504Q, "getReportDate", new Object[0]);
            } catch (Throwable th2) {
                obj = null;
            }
            if (obj != null) {
                try {
                    String a = this.f513Z.mo3879a((byte[]) obj, this.f540r, "http://cgicol.amap.com/collection/writedata?ver=v1.0_ali&", false);
                    if (m837t()) {
                        try {
                            this.f503P = ((Integer) C0325cm.m1110a(this.f504Q, "setUploadResult", a, Integer.valueOf(i2))).intValue();
                        } catch (Throwable th3) {
                            this.f503P = 3;
                        }
                    }
                } catch (Throwable th4) {
                    C0310c.m956a(th4, "APS", "up");
                    return;
                }
            }
            m841x();
            if (m837t() && m789A() == 0) {
                m790B();
            } else if (this.f503P >= 3) {
                m790B();
            }
        }
    }

    /* renamed from: b */
    private void m815b(JSONObject jSONObject) {
        try {
            if (m798J()) {
                C0325cm.m1110a(this.f505R, "setLastLoc", jSONObject);
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: c */
    private void m816c(final int i) {
        if (!C0322ck.m1092t()) {
            m790B();
            return;
        }
        if (this.f502O == null) {
            this.f502O = new TimerTask() {
                /* class com.amap.loc.C0292br.C02931 */

                public void run() {
                    try {
                        Thread.currentThread().setPriority(1);
                        long b = C0331cr.m1170b() - C0292br.this.f492E;
                        if (C0292br.this.m837t() && C0292br.this.m789A() == 0) {
                            C0292br.this.m790B();
                        }
                        if (b >= 10000) {
                            if (C0292br.this.m791C()) {
                                C0292br.this.m814b((C0292br) i);
                            } else {
                                C0292br.this.m790B();
                            }
                        }
                    } catch (Throwable th) {
                        C0310c.m956a(th, "APS", "timerTaskU run");
                    }
                }
            };
        }
        if (this.f501N == null) {
            this.f501N = new Timer("T-U", false);
            this.f501N.schedule(this.f502O, 2000, 2000);
        }
    }

    /* renamed from: d */
    private void m819d(Context context) {
        try {
            if (this.f504Q == null && !this.f521ag) {
                C0360q a = C0310c.m950a("Collection", "1.0.0");
                this.f521ag = C0327co.m1128a(context, a);
                if (this.f521ag) {
                    this.f504Q = C0244ar.m536a(context, a, this.f532f, null, new Class[]{Context.class}, new Object[]{context});
                    C0327co.m1124a(context, "Collertor", this.f504Q == null ? 0 : 1);
                    return;
                }
                this.f521ag = true;
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "APS", "initCollection");
        }
    }

    /* renamed from: e */
    private void m820e(Context context) {
        try {
            if (this.f505R == null && !this.f522ah) {
                C0360q a = C0310c.m950a("OfflineLocation", "1.0.0");
                this.f522ah = C0327co.m1128a(context, a);
                if (this.f522ah) {
                    this.f505R = C0244ar.m536a(context, a, this.f533g, null, new Class[]{Context.class}, new Object[]{context});
                    C0327co.m1124a(context, "OffLocation", this.f505R == null ? 0 : 1);
                    return;
                }
                this.f522ah = true;
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "APS", "initOffLocation");
        }
    }

    /* renamed from: j */
    private void m826j() {
        boolean z;
        boolean z2;
        boolean z3;
        try {
            z2 = C0331cr.m1166a(this.f488A, "reversegeo") ? this.f488A.getBoolean("reversegeo") : true;
            try {
                z3 = C0331cr.m1166a(this.f488A, "isOffset") ? this.f488A.getBoolean("isOffset") : true;
                try {
                    z = C0331cr.m1166a(this.f488A, "isLocationCacheEnable") ? this.f488A.getBoolean("isLocationCacheEnable") : true;
                    try {
                        if (!(z3 == this.f517ac && z2 == this.f516ab && z == this.f518ad)) {
                            m797I();
                        }
                    } catch (Throwable th) {
                    }
                } catch (Throwable th2) {
                    z = true;
                }
            } catch (Throwable th3) {
                z = true;
                z3 = true;
            }
        } catch (Throwable th4) {
            z = true;
            z2 = true;
            z3 = true;
        }
        this.f517ac = z3;
        this.f516ab = z2;
        this.f518ad = z;
        this.f493F = C0331cr.m1161a(this.f540r);
        this.f523ai = true;
    }

    /* renamed from: k */
    private void m828k() {
        try {
            if (m798J()) {
                C0325cm.m1110a(this.f505R, "resetPureOfflineCache", new Object[0]);
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: l */
    private void m829l() {
        try {
            if (this.f547y == null) {
                this.f547y = new C0295b();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            intentFilter.addAction("android.location.GPS_FIX_CHANGE");
            intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            this.f540r.registerReceiver(this.f547y, intentFilter);
            mo3797g();
        } catch (Throwable th) {
            C0310c.m956a(th, "APS", "initBroadcastListener");
        }
    }

    /* renamed from: m */
    private void m830m() {
        this.f543u.mo3822a();
        this.f543u.mo3832h();
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x03c1  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x03d4  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0444  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0530  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0543  */
    /* renamed from: n */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m831n() throws java.lang.Throwable {
        /*
        // Method dump skipped, instructions count: 1370
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0292br.m831n():void");
    }

    /* renamed from: o */
    private void m832o() {
        long b = C0331cr.m1170b();
        if (m833p() || C0331cr.m1170b() - this.f496I > 3000) {
            if (b - this.f491D >= 10000) {
                synchronized (this.f530d) {
                    this.f545w.clear();
                }
            }
            mo3797g();
            if (b - this.f491D >= 10000) {
                for (int i = 20; i > 0 && this.f545w.isEmpty(); i--) {
                    try {
                        Thread.sleep(3000 / ((long) 20));
                    } catch (Throwable th) {
                    }
                }
            }
            synchronized (this.f530d) {
            }
        }
        if (this.f545w.isEmpty() && this.f542t != null) {
            this.f496I = C0331cr.m1170b();
            List<ScanResult> a = this.f542t.mo3842a();
            if (a != null) {
                synchronized (this.f530d) {
                    this.f545w.addAll(a);
                }
            }
        }
    }

    /* renamed from: p */
    private boolean m833p() {
        boolean z = false;
        if (!TextUtils.isEmpty(this.f499L)) {
            return true;
        }
        if (m836s()) {
            if (this.f495H == 0) {
                z = true;
            } else if (C0331cr.m1170b() - this.f495H >= 3000 && C0331cr.m1170b() - this.f496I >= 1500) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: q */
    private boolean m834q() {
        return this.f490C == 0 || C0331cr.m1170b() - this.f490C > 20000;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: r */
    private void m835r() {
        this.f496I = 0;
        this.f548z = null;
        synchronized (this.f530d) {
            this.f545w.clear();
            this.f546x.clear();
        }
    }

    /* renamed from: s */
    private boolean m836s() {
        if (this.f542t != null) {
            return this.f542t.mo3850f();
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: t */
    private boolean m837t() {
        return this.f504Q != null;
    }

    /* renamed from: u */
    private boolean m838u() {
        try {
            if (!m837t()) {
                return false;
            }
            return m839v();
        } catch (Throwable th) {
            C0310c.m956a(th, "APS", "collStarted");
            return false;
        }
    }

    /* renamed from: v */
    private boolean m839v() {
        try {
            return ((Boolean) C0325cm.m1110a(this.f504Q, "isStarted", new Object[0])).booleanValue();
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003e  */
    /* renamed from: w */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m840w() {
        /*
        // Method dump skipped, instructions count: 112
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0292br.m840w():void");
    }

    /* renamed from: x */
    private void m841x() {
        if (m837t() && m837t() && m789A() > 0) {
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: y */
    private void m842y() {
        if (m837t() && m838u()) {
            C0310c.f632h = 20;
            try {
                C0325cm.m1110a(this.f504Q, "destroy", new Object[0]);
            } catch (Throwable th) {
                C0310c.m956a(th, "APS", "stop3rdCM");
            }
        }
    }

    /* renamed from: z */
    private void m843z() {
        if (this.f540r != null && !TextUtils.isEmpty(this.f498K)) {
            SharedPreferences sharedPreferences = this.f540r.getSharedPreferences("pref", 0);
            String str = null;
            try {
                str = C0355m.m1295a(this.f498K.getBytes("UTF-8"));
            } catch (Throwable th) {
                C0310c.m956a(th, "APS", "setSmac");
            }
            if (!TextUtils.isEmpty(str)) {
                sharedPreferences.edit().putString("smac", str).commit();
            }
        }
    }

    /* renamed from: a */
    public synchronized AMapLocationServer mo3779a() throws Throwable {
        AMapLocationServer aMapLocationServer;
        boolean z;
        boolean z2 = true;
        boolean z3 = false;
        synchronized (this) {
            if (this.f515aa.length() > 0) {
                this.f515aa.delete(0, this.f515aa.length());
            }
            if (this.f540r == null) {
                this.f515aa.append("context is null");
                aMapLocationServer = new AMapLocationServer("");
                aMapLocationServer.setErrorCode(1);
                aMapLocationServer.setLocationDetail(this.f515aa.toString());
            } else {
                m826j();
                this.f497J++;
                m841x();
                m794F();
                if (this.f540r != null) {
                    if (m837t()) {
                        try {
                            C0325cm.m1110a(this.f504Q, "getColUpHist", new Object[0]);
                        } catch (Throwable th) {
                        }
                    }
                    try {
                        if (m798J()) {
                            C0325cm.m1110a(this.f505R, "getOffDlHist", new Object[0]);
                        } else if (this.f505R != null) {
                            C0325cm.m1110a(this.f505R, "stopOff", new Object[0]);
                            this.f534h = false;
                        }
                    } catch (Throwable th2) {
                    }
                    m805a(this.f540r.getSharedPreferences("pref", 0));
                }
                if (!m811a(this.f490C) || !C0331cr.m1164a(this.f489B)) {
                    this.f543u.mo3821a(this.f493F, false);
                    try {
                        m832o();
                        this.f491D = C0331cr.m1170b();
                        mo3795e();
                        mo3796f();
                    } catch (Throwable th3) {
                        C0310c.m956a(th3, "APS", "getLocation");
                    }
                    this.f525ak = mo3782a(false);
                    if (!TextUtils.isEmpty(this.f525ak)) {
                        try {
                            if (m798J() && !this.f534h) {
                                C0325cm.m1110a(this.f505R, "startOff", this.f488A, this.f525ak);
                                this.f534h = true;
                            }
                        } catch (Throwable th4) {
                            C0310c.m956a(th4, "APS", "getLocation:isOffLineLoc");
                        }
                        this.f539q = mo3788b(false);
                        C0304bw c = !this.f493F ? this.f543u.mo3827c() : null;
                        boolean z4 = !(c == null && this.f512Y == null) && (this.f512Y == null || !this.f512Y.mo3819a(c));
                        boolean q = m834q();
                        if (this.f489B != null) {
                            int size = this.f544v.size();
                            if (this.f489B.getAccuracy() <= 299.0f || size <= 5) {
                                z2 = false;
                            }
                            z = z2;
                        } else {
                            z = false;
                        }
                        if (this.f489B != null && this.f511X != null && !z && !z4 && this.f518ad && C0322ck.m1052b(this.f489B.getTime()) && ((z3 = C0311ca.m966a().mo3856a(this.f511X, this.f539q)) || (this.f510W != 0 && C0331cr.m1170b() - this.f510W < 3000))) {
                            if (this.f543u.mo3825a(this.f493F)) {
                                this.f543u.mo3832h();
                            }
                            if (C0331cr.m1164a(this.f489B)) {
                                this.f489B.mo3970f("mem");
                                this.f489B.setLocationType(2);
                                aMapLocationServer = this.f489B;
                            }
                        }
                        if (!z3) {
                            this.f510W = C0331cr.m1170b();
                        } else {
                            this.f510W = 0;
                        }
                        if (this.f508U == null || this.f525ak.equals(this.f508U)) {
                            if (this.f508U == null) {
                                this.f509V = C0331cr.m1156a();
                                this.f508U = this.f525ak;
                            } else {
                                this.f509V = C0331cr.m1156a();
                            }
                        } else if (C0331cr.m1156a() - this.f509V < 3000) {
                            this.f525ak = this.f508U;
                        } else {
                            this.f509V = C0331cr.m1156a();
                            this.f508U = this.f525ak;
                        }
                        this.f526al = this.f525ak + "&" + this.f517ac + "&" + this.f516ab;
                        AMapLocationServer a = (!this.f518ad || z || q) ? null : C0311ca.m966a().mo3852a(this.f526al, this.f539q, this.f518ad);
                        if (!(q || C0331cr.m1164a(a)) || z) {
                            this.f489B = m802a(false, false, true);
                            if (C0331cr.m1164a(this.f489B)) {
                                this.f489B.mo3970f("new");
                                this.f511X = this.f539q.toString();
                                this.f512Y = c;
                                m828k();
                            }
                        } else if (q) {
                            this.f489B = m802a(false, false, true);
                            if (C0331cr.m1164a(this.f489B)) {
                                this.f511X = this.f539q.toString();
                                this.f512Y = c;
                                m828k();
                            }
                        } else {
                            this.f510W = 0;
                            a.setLocationType(4);
                            this.f489B = a;
                            m815b(a.mo3490a(1));
                            m828k();
                        }
                        C0311ca.m966a().mo3854a(this.f526al, this.f539q, this.f489B, this.f540r, true);
                        C0315cd.m990a().mo3871a(this.f540r, this.f525ak, this.f489B);
                        if (!C0331cr.m1164a(this.f489B)) {
                            AMapLocationServer a2 = m801a(this.f525ak, this.f539q.toString(), this.f488A, this.f540r, mo3782a(false));
                            if (C0331cr.m1164a(a2)) {
                                this.f511X = this.f539q.toString();
                                AMapLocationServer aMapLocationServer2 = this.f489B;
                                this.f489B = a2;
                                this.f489B.setLocationType(8);
                                this.f489B.setLocationDetail("离线定位，在线定位失败原因:" + aMapLocationServer2.getErrorInfo());
                            }
                        }
                        this.f539q.delete(0, this.f539q.length());
                        this.f539q = null;
                        aMapLocationServer = this.f489B;
                    } else {
                        if (!this.f529c) {
                            mo3785a(false, this.f540r);
                        }
                        for (int i = 4; i > 0 && this.f528b != 0; i--) {
                            SystemClock.sleep(500);
                        }
                        if (this.f528b == 0) {
                            this.f489B = this.f514a.mo3808e();
                            if (this.f489B != null) {
                                aMapLocationServer = this.f489B;
                            }
                        }
                        aMapLocationServer = new AMapLocationServer("");
                        aMapLocationServer.setErrorCode(this.f535i);
                        aMapLocationServer.setLocationDetail(this.f515aa.toString());
                    }
                } else {
                    if (this.f518ad && C0322ck.m1052b(this.f489B.getTime())) {
                        this.f489B.setLocationType(2);
                    }
                    aMapLocationServer = this.f489B;
                }
            }
        }
        return aMapLocationServer;
    }

    /* renamed from: a */
    public AMapLocationServer mo3780a(double d, double d2) {
        try {
            String a = this.f513Z.mo3879a(("output=json&radius=1000&extensions=all&location=" + d2 + MiPushClient.ACCEPT_TIME_SEPARATOR + d).getBytes("UTF-8"), this.f540r, "http://restapi.amap.com/v3/geocode/regeo", true);
            C0320ci ciVar = new C0320ci();
            if (a.contains("\"status\":\"1\"")) {
                AMapLocationServer a2 = ciVar.mo3887a(a);
                a2.setLatitude(d);
                a2.setLongitude(d2);
                return a2;
            }
        } catch (Throwable th) {
        }
        return null;
    }

    /* renamed from: a */
    public AMapLocationServer mo3781a(AMapLocationServer aMapLocationServer, String... strArr) {
        C0302bu.m875a().mo3816a(this.f518ad);
        return (strArr == null || strArr.length == 0) ? C0302bu.m875a().mo3815a(aMapLocationServer) : strArr[0].equals("shake") ? C0302bu.m875a().mo3815a(aMapLocationServer) : strArr[0].equals("fusion") ? C0302bu.m875a().mo3817b(aMapLocationServer) : aMapLocationServer;
    }

    /* JADX WARNING: Removed duplicated region for block: B:76:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0236  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String mo3782a(boolean r8) {
        /*
        // Method dump skipped, instructions count: 608
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0292br.mo3782a(boolean):java.lang.String");
    }

    /* renamed from: a */
    public synchronized void mo3783a(AMapLocationServer aMapLocationServer) {
        if (C0331cr.m1164a(aMapLocationServer)) {
            C0311ca.m966a().mo3854a(this.f526al, this.f539q, aMapLocationServer, this.f540r, true);
        }
    }

    /* renamed from: a */
    public void mo3784a(JSONObject jSONObject) {
        this.f488A = jSONObject;
        if (C0331cr.m1166a(jSONObject, "collwifiscan")) {
            try {
                String string = jSONObject.getString("collwifiscan");
                if (TextUtils.isEmpty(string)) {
                    C0310c.f632h = 20;
                } else {
                    C0310c.f632h = Integer.parseInt(string) / 1000;
                }
            } catch (Throwable th) {
                C0310c.m956a(th, "APS", "setExtra");
            }
        }
        if (this.f543u != null) {
            this.f543u.mo3823a(jSONObject);
        }
        if (this.f542t != null) {
            this.f542t.mo3843a(jSONObject);
        }
    }

    /* renamed from: a */
    public synchronized void mo3785a(boolean z, Context context) {
        if ((this.f497J >= 1 && !this.f529c) || (z && !this.f529c)) {
            if (this.f514a == null) {
                this.f514a = new C0296bs(context.getApplicationContext());
                this.f514a.mo3804a(this.f538m);
            }
            try {
                if (this.f514a != null) {
                    if (z) {
                        this.f514a.mo3807d();
                    } else {
                        this.f514a.mo3805b();
                    }
                }
                this.f529c = true;
            } catch (Throwable th) {
                C0310c.m956a(th, "APS", "bindService");
                this.f529c = true;
            }
        }
    }

    /* renamed from: a */
    public synchronized boolean mo3786a(Context context) {
        boolean z;
        if (this.f540r != null) {
            z = true;
        } else if (context == null) {
            z = false;
        } else {
            this.f540r = context.getApplicationContext();
            C0322ck.m1062e(this.f540r);
            C0331cr.m1171b(this.f540r);
            if (this.f542t == null) {
                this.f542t = new C0308by(this.f540r, (WifiManager) C0331cr.m1157a(this.f540r, "wifi"), this.f488A);
            }
            if (this.f543u == null) {
                this.f543u = new C0305bx(this.f540r, this.f488A);
            }
            C0311ca.m966a().mo3853a(this.f540r);
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public synchronized boolean mo3787a(Context context, boolean z) {
        boolean z2;
        if (!mo3786a(context)) {
            z2 = false;
        } else {
            this.f513Z = C0318cg.m1004a(this.f540r, z);
            if (this.f541s == null) {
                this.f541s = (ConnectivityManager) C0331cr.m1157a(this.f540r, "connectivity");
            }
            this.f500M = new C0321cj();
            z2 = true;
        }
        return z2;
    }

    /* renamed from: b */
    public synchronized StringBuilder mo3788b(boolean z) {
        StringBuilder sb;
        boolean z2 = false;
        synchronized (this) {
            C0305bx bxVar = this.f543u;
            if (this.f493F) {
                bxVar.mo3831g();
            }
            sb = new StringBuilder(700);
            int d = bxVar.mo3828d();
            ArrayList<C0304bw> b = bxVar.mo3826b();
            switch (d) {
                case 1:
                    for (int i = 1; i < b.size(); i++) {
                        sb.append(MqttTopic.MULTI_LEVEL_WILDCARD).append(b.get(i).f589b);
                        sb.append("|").append(b.get(i).f590c);
                        sb.append("|").append(b.get(i).f591d);
                    }
                    break;
            }
            if (((!z && TextUtils.isEmpty(this.f498K)) || this.f498K.equals("00:00:00:00:00:00")) && this.f548z != null) {
                this.f498K = this.f548z.getMacAddress();
                m843z();
                if (TextUtils.isEmpty(this.f498K)) {
                    this.f498K = "00:00:00:00:00:00";
                }
            }
            if (m836s()) {
                String bssid = m812a(this.f548z) ? this.f548z.getBSSID() : "";
                int size = this.f544v.size();
                for (int i2 = 0; i2 < size; i2++) {
                    String str = this.f544v.get(i2).BSSID;
                    String str2 = "nb";
                    if (bssid.equals(str)) {
                        str2 = C1447g.f3445I;
                        z2 = true;
                    }
                    sb.append(String.format(Locale.US, "#%s,%s", str, str2));
                }
                if (!z2 && !TextUtils.isEmpty(bssid)) {
                    sb.append(MqttTopic.MULTI_LEVEL_WILDCARD).append(bssid);
                    sb.append(",access");
                }
            } else {
                m835r();
                if (this.f544v != null) {
                    this.f544v.clear();
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(0);
            }
        }
        return sb;
    }

    /* renamed from: b */
    public void mo3789b() {
        try {
            m826j();
            m796H();
            mo3783a(m802a(true, true, true));
        } catch (Throwable th) {
            C0310c.m956a(th, "APS", "doFusionLocation");
        }
    }

    /* renamed from: b */
    public synchronized void mo3790b(Context context) {
        if (mo3787a(context, true)) {
            C0310c.f633i = true;
            m820e(this.f540r);
            this.f492E = C0331cr.m1170b();
            if (!this.f519ae) {
                m829l();
                this.f519ae = true;
            }
            m830m();
            this.f543u.mo3829e();
            C0315cd.m990a().mo3870a(this.f540r);
            this.f531e = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0046  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.autonavi.aps.amapapi.model.AMapLocationServer mo3791c(boolean r8) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 207
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0292br.mo3791c(boolean):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    /* renamed from: c */
    public synchronized void mo3792c() {
        this.f523ai = false;
        this.f527am = false;
        this.f531e = false;
        C0310c.f633i = false;
        m842y();
        this.f504Q = null;
        this.f511X = null;
        m828k();
        if (this.f514a != null) {
            this.f514a.mo3803a();
            this.f514a = null;
            this.f529c = false;
            this.f528b = -1;
        }
        m790B();
        try {
            C0314cc.m983a().mo3866a(this.f540r, 1);
        } catch (Throwable th) {
            C0310c.m956a(th, "APS", "destroy part");
        }
        C0302bu.m875a().mo3818b();
        C0331cr.m1194h();
        try {
            if (!(this.f540r == null || this.f547y == null)) {
                this.f540r.unregisterReceiver(this.f547y);
            }
        } catch (Throwable th2) {
            C0310c.m956a(th2, "APS", "destroy");
        } finally {
            this.f547y = null;
        }
        this.f519ae = false;
        if (this.f543u != null) {
            this.f543u.mo3833i();
        }
        C0315cd.m990a().mo3873b();
        m808a("stopOff");
        m808a("destroy");
        this.f534h = false;
        this.f509V = 0;
        m835r();
        if (this.f544v != null) {
            this.f544v.clear();
        }
        this.f489B = null;
        this.f540r = null;
        if (this.f536j != null) {
            this.f536j.clear();
            this.f536j = null;
        }
        this.f504Q = null;
        this.f505R = null;
    }

    /* renamed from: c */
    public synchronized void mo3793c(Context context) {
        try {
            if (f485n == -1 || m795G()) {
                f485n = 1;
                C0322ck.m1045a(context);
                f487p = C0322ck.m1091s();
                C0331cr.m1159a(context, f487p);
                f486o = C0331cr.m1170b();
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "APS", "initAuth");
        }
        return;
    }

    /* renamed from: d */
    public String mo3794d() {
        return "3.0.0";
    }

    /* renamed from: e */
    public synchronized void mo3795e() {
        ArrayList<ScanResult> arrayList = this.f544v;
        ArrayList<ScanResult> arrayList2 = this.f545w;
        arrayList.clear();
        synchronized (this.f530d) {
            if (arrayList2 != null) {
                if (arrayList2.size() > 0) {
                    arrayList.addAll(arrayList2);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0103 A[LOOP:1: B:54:0x00fd->B:56:0x0103, LOOP_END] */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo3796f() {
        /*
        // Method dump skipped, instructions count: 278
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0292br.mo3796f():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031 A[SYNTHETIC, Splitter:B:12:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0041 A[SYNTHETIC, Splitter:B:17:0x0041] */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo3797g() {
        /*
        // Method dump skipped, instructions count: 108
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0292br.mo3797g():void");
    }

    /* renamed from: h */
    public synchronized AMapLocationServer mo3798h() {
        AMapLocationServer aMapLocationServer;
        if (this.f515aa.length() > 0) {
            this.f515aa.delete(0, this.f515aa.length());
        }
        if (!this.f523ai) {
            m826j();
        }
        m796H();
        aMapLocationServer = null;
        if (TextUtils.isEmpty(this.f525ak)) {
            if (0 == 0) {
                aMapLocationServer = new AMapLocationServer("");
            }
            aMapLocationServer.setErrorCode(this.f535i);
            aMapLocationServer.setLocationDetail(this.f515aa.toString());
        } else {
            aMapLocationServer = C0311ca.m966a().mo3852a(this.f526al, this.f539q, this.f518ad);
            if (C0331cr.m1164a(aMapLocationServer)) {
                this.f510W = 0;
                aMapLocationServer.setLocationType(4);
                this.f489B = aMapLocationServer;
                m815b(aMapLocationServer.mo3490a(1));
                m828k();
            }
        }
        return aMapLocationServer;
    }

    /* renamed from: i */
    public void mo3799i() {
        if (C0322ck.m1092t()) {
            m819d(this.f540r);
        }
        if (this.f537k && C0322ck.m1092t() && !m838u()) {
            m840w();
        }
    }
}
