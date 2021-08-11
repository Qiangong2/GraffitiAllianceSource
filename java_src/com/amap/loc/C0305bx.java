package com.amap.loc;

import android.content.Context;
import android.os.HandlerThread;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.amap.loc.bx */
/* compiled from: CgiManager */
public class C0305bx {

    /* renamed from: a */
    HandlerThread f599a = null;

    /* renamed from: b */
    volatile boolean f600b = false;

    /* renamed from: c */
    private Context f601c;

    /* renamed from: d */
    private int f602d = 9;

    /* renamed from: e */
    private ArrayList<C0304bw> f603e = new ArrayList<>();

    /* renamed from: f */
    private int f604f = -113;

    /* renamed from: g */
    private TelephonyManager f605g = null;

    /* renamed from: h */
    private Object f606h;

    /* renamed from: i */
    private long f607i = 0;

    /* renamed from: j */
    private JSONObject f608j;

    /* renamed from: k */
    private PhoneStateListener f609k;

    /* renamed from: l */
    private volatile CellLocation f610l;

    /* renamed from: m */
    private boolean f611m = false;

    /* renamed from: n */
    private Object f612n = new Object();

    /* renamed from: o */
    private PhoneStateListener f613o = null;

    /* renamed from: p */
    private String f614p = null;

    /* access modifiers changed from: package-private */
    /* renamed from: com.amap.loc.bx$a */
    /* compiled from: CgiManager */
    public class HandlerThreadC0307a extends HandlerThread {
        public HandlerThreadC0307a(String str) {
            super(str);
        }

        /* access modifiers changed from: protected */
        public void onLooperPrepared() {
            try {
                super.onLooperPrepared();
                synchronized (C0305bx.this.f612n) {
                    if (!C0305bx.this.f611m) {
                        C0305bx.this.m910q();
                    }
                }
            } catch (Throwable th) {
            }
        }

        public void run() {
            try {
                super.run();
            } catch (Throwable th) {
            }
        }
    }

    public C0305bx(Context context, JSONObject jSONObject) {
        if (context == null) {
        }
        this.f608j = jSONObject;
        this.f601c = context;
        if (this.f605g == null) {
            this.f605g = (TelephonyManager) C0331cr.m1157a(this.f601c, "phone");
        }
    }

    /* renamed from: a */
    private CellLocation m885a(List<?> list) {
        char c;
        CdmaCellLocation cdmaCellLocation;
        GsmCellLocation gsmCellLocation;
        Object obj;
        if (list == null || list.isEmpty()) {
            return null;
        }
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        GsmCellLocation gsmCellLocation2 = null;
        int i = 0;
        char c2 = 0;
        CdmaCellLocation cdmaCellLocation2 = null;
        while (true) {
            if (i >= list.size()) {
                c = c2;
                cdmaCellLocation = cdmaCellLocation2;
                gsmCellLocation = gsmCellLocation2;
                break;
            }
            Object obj2 = list.get(i);
            if (obj2 != null) {
                try {
                    Class<?> loadClass = systemClassLoader.loadClass("android.telephony.CellInfoGsm");
                    Class<?> loadClass2 = systemClassLoader.loadClass("android.telephony.CellInfoWcdma");
                    Class<?> loadClass3 = systemClassLoader.loadClass("android.telephony.CellInfoLte");
                    Class<?> loadClass4 = systemClassLoader.loadClass("android.telephony.CellInfoCdma");
                    if (loadClass.isInstance(obj2)) {
                        c = 1;
                        try {
                            obj = loadClass.cast(obj2);
                        } catch (Throwable th) {
                            c2 = 1;
                        }
                    } else if (loadClass2.isInstance(obj2)) {
                        c = 2;
                        obj = loadClass2.cast(obj2);
                    } else if (loadClass3.isInstance(obj2)) {
                        c = 3;
                        obj = loadClass3.cast(obj2);
                    } else if (loadClass4.isInstance(obj2)) {
                        c = 4;
                        obj = loadClass4.cast(obj2);
                    } else {
                        c = 0;
                        obj = null;
                    }
                    if (c > 0) {
                        Object a = C0325cm.m1110a(obj, "getCellIdentity", new Object[0]);
                        if (a == null) {
                            c2 = c;
                        } else if (c == 4) {
                            cdmaCellLocation = new CdmaCellLocation();
                            try {
                                cdmaCellLocation.setCellLocationData(C0325cm.m1113b(a, "getBasestationId", new Object[0]), C0325cm.m1113b(a, "getLatitude", new Object[0]), C0325cm.m1113b(a, "getLongitude", new Object[0]), C0325cm.m1113b(a, "getSystemId", new Object[0]), C0325cm.m1113b(a, "getNetworkId", new Object[0]));
                                gsmCellLocation = gsmCellLocation2;
                                break;
                            } catch (Throwable th2) {
                                cdmaCellLocation2 = cdmaCellLocation;
                                c2 = c;
                            }
                        } else if (c == 3) {
                            int b = C0325cm.m1113b(a, "getTac", new Object[0]);
                            int b2 = C0325cm.m1113b(a, "getCi", new Object[0]);
                            GsmCellLocation gsmCellLocation3 = new GsmCellLocation();
                            try {
                                gsmCellLocation3.setLacAndCid(b, b2);
                                gsmCellLocation = gsmCellLocation3;
                                cdmaCellLocation = cdmaCellLocation2;
                                break;
                            } catch (Throwable th3) {
                                gsmCellLocation2 = gsmCellLocation3;
                                c2 = c;
                            }
                        } else {
                            int b3 = C0325cm.m1113b(a, "getLac", new Object[0]);
                            int b4 = C0325cm.m1113b(a, "getCid", new Object[0]);
                            GsmCellLocation gsmCellLocation4 = new GsmCellLocation();
                            try {
                                gsmCellLocation4.setLacAndCid(b3, b4);
                                gsmCellLocation = gsmCellLocation4;
                                cdmaCellLocation = cdmaCellLocation2;
                                break;
                            } catch (Throwable th4) {
                                gsmCellLocation2 = gsmCellLocation4;
                                c2 = c;
                            }
                        }
                    } else {
                        c2 = c;
                    }
                } catch (Throwable th5) {
                }
            }
            i++;
        }
        return c != 4 ? gsmCellLocation : cdmaCellLocation;
    }

    /* renamed from: a */
    private CellLocation m886a(boolean z, Object obj, String str, Object... objArr) {
        CellLocation cellLocation;
        if (obj == null) {
            return null;
        }
        try {
            if (str.equals("getAllCellInfo")) {
                cellLocation = m885a((List) C0325cm.m1110a(obj, "getAllCellInfo", new Object[0]));
            } else {
                Object a = C0325cm.m1110a(obj, str, objArr);
                cellLocation = a != null ? (CellLocation) a : null;
            }
            if (mo3824a(cellLocation)) {
                return cellLocation;
            }
        } catch (Throwable th) {
        }
        return null;
    }

    /* renamed from: a */
    private C0304bw m888a(NeighboringCellInfo neighboringCellInfo) {
        if (C0331cr.m1178c() < 5) {
            return null;
        }
        try {
            C0304bw bwVar = new C0304bw(1);
            String[] a = C0331cr.m1169a(this.f605g);
            bwVar.f588a = a[0];
            bwVar.f589b = a[1];
            bwVar.f590c = C0325cm.m1113b(neighboringCellInfo, "getLac", new Object[0]);
            bwVar.f591d = neighboringCellInfo.getCid();
            bwVar.f597j = C0331cr.m1152a(neighboringCellInfo.getRssi());
            return bwVar;
        } catch (Throwable th) {
            C0310c.m956a(th, "CgiManager", "getGsm");
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private void m890a(int i) {
        if (i == -113) {
            this.f604f = -113;
            return;
        }
        this.f604f = i;
        switch (this.f602d) {
            case 1:
            case 2:
                if (!this.f603e.isEmpty()) {
                    try {
                        this.f603e.get(0).f597j = this.f604f;
                        return;
                    } catch (Throwable th) {
                        C0310c.m956a(th, "CgiManager", "hdlCgiSigStrenChange");
                        return;
                    }
                } else {
                    return;
                }
            default:
                return;
        }
    }

    /* renamed from: a */
    private void m891a(CellLocation cellLocation, boolean z) {
        List<NeighboringCellInfo> neighboringCellInfo;
        C0304bw a;
        if (!(cellLocation == null || this.f605g == null)) {
            this.f603e.clear();
            if (mo3824a(cellLocation)) {
                this.f602d = 1;
                this.f603e.add(m895b(cellLocation));
                if (!(z || (neighboringCellInfo = this.f605g.getNeighboringCellInfo()) == null || neighboringCellInfo.isEmpty())) {
                    for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                        if (neighboringCellInfo2 != null && m893a(neighboringCellInfo2.getLac(), neighboringCellInfo2.getCid()) && (a = m888a(neighboringCellInfo2)) != null && !this.f603e.contains(a)) {
                            this.f603e.add(a);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m893a(int i, int i2) {
        return (i == -1 || i == 0 || i > 65535 || i2 == -1 || i2 == 0 || i2 == 65535 || i2 >= 268435455) ? false : true;
    }

    /* renamed from: b */
    private synchronized CellLocation m894b(boolean z, boolean z2) {
        CellLocation cellLocation;
        this.f600b = z;
        if (!this.f600b && this.f605g != null) {
            CellLocation m = m906m();
            if (!mo3824a(m)) {
                m = m907n();
            }
            if (mo3824a(m)) {
                this.f610l = m;
            }
        }
        if (!mo3824a(this.f610l)) {
            cellLocation = null;
        } else {
            switch (C0331cr.m1155a(this.f600b, this.f610l, this.f601c)) {
                case 1:
                    m891a(this.f610l, z2);
                    break;
                case 2:
                    m896b(this.f610l, z2);
                    break;
            }
            cellLocation = this.f610l;
        }
        return cellLocation;
    }

    /* renamed from: b */
    private C0304bw m895b(CellLocation cellLocation) {
        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
        C0304bw bwVar = new C0304bw(1);
        String[] a = C0331cr.m1169a(this.f605g);
        bwVar.f588a = a[0];
        bwVar.f589b = a[1];
        bwVar.f590c = gsmCellLocation.getLac();
        bwVar.f591d = gsmCellLocation.getCid();
        bwVar.f597j = this.f604f;
        return bwVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m896b(android.telephony.CellLocation r7, boolean r8) {
        /*
        // Method dump skipped, instructions count: 221
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0305bx.m896b(android.telephony.CellLocation, boolean):void");
    }

    /* renamed from: k */
    public static int m905k() {
        int i = 0;
        try {
            Class.forName("android.telephony.MSimTelephonyManager");
            i = 1;
        } catch (Throwable th) {
        }
        if (i != 0) {
            return i;
        }
        try {
            Class.forName("android.telephony.TelephonyManager2");
            return 2;
        } catch (Throwable th2) {
            return i;
        }
    }

    /* renamed from: m */
    private CellLocation m906m() {
        TelephonyManager telephonyManager = this.f605g;
        if (telephonyManager == null) {
            return null;
        }
        CellLocation e = mo3829e();
        if (mo3824a(e)) {
            return e;
        }
        CellLocation a = m886a(true, telephonyManager, "getAllCellInfo", new Object[0]);
        if (a != null) {
            return a;
        }
        CellLocation a2 = m886a(true, telephonyManager, "getCellLocationExt", 1);
        if (a2 != null) {
            return a2;
        }
        CellLocation a3 = m886a(true, telephonyManager, "getCellLocationGemini", 1);
        if (a3 != null) {
        }
        return a3;
    }

    /* renamed from: n */
    private CellLocation m907n() {
        Object cast;
        CellLocation cellLocation = null;
        Object obj = this.f606h;
        if (obj != null) {
            try {
                Class<?> o = m908o();
                if (!(o.isInstance(obj) && (cellLocation = m886a(false, (cast = o.cast(obj)), "getCellLocation", new Object[0])) == null && (cellLocation = m886a(false, cast, "getCellLocation", 1)) == null && (cellLocation = m886a(false, cast, "getCellLocationGemini", 1)) == null && (cellLocation = m886a(false, cast, "getAllCellInfo", 1)) == null)) {
                }
            } catch (Throwable th) {
                C0310c.m956a(th, "CgiManager", "getSim2Cgi");
            }
        }
        return cellLocation;
    }

    /* renamed from: o */
    private Class<?> m908o() {
        String str;
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        switch (m905k()) {
            case 0:
                str = "android.telephony.TelephonyManager";
                break;
            case 1:
                str = "android.telephony.MSimTelephonyManager";
                break;
            case 2:
                str = "android.telephony.TelephonyManager2";
                break;
            default:
                str = null;
                break;
        }
        try {
            return systemClassLoader.loadClass(str);
        } catch (Throwable th) {
            C0310c.m956a(th, "CgiManager", "getSim2TmClass");
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: p */
    private void m909p() {
        boolean z = true;
        JSONObject jSONObject = this.f608j;
        if (jSONObject != null) {
            try {
                if (jSONObject.has("cellupdate") && jSONObject.getString("cellupdate").equals("0")) {
                    z = false;
                }
            } catch (Throwable th) {
                C0310c.m956a(th, "CgiManager", "updateCgi1");
            }
        }
        if (z) {
            try {
                CellLocation.requestLocationUpdate();
            } catch (Throwable th2) {
                C0310c.m956a(th2, "CgiManager", "updateCgi");
            }
            this.f607i = C0331cr.m1170b();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: q */
    private void m910q() {
        this.f609k = new PhoneStateListener() {
            /* class com.amap.loc.C0305bx.C03061 */

            public void onCellLocationChanged(CellLocation cellLocation) {
                try {
                    if (C0305bx.this.mo3824a(cellLocation)) {
                        C0305bx.this.f610l = cellLocation;
                        if (C0305bx.this.f613o != null) {
                            C0305bx.this.f613o.onCellLocationChanged(cellLocation);
                        }
                    }
                } catch (Throwable th) {
                    C0310c.m956a(th, "CgiManager", "initPhoneStateListener7");
                }
            }

            public void onServiceStateChanged(ServiceState serviceState) {
                try {
                    switch (serviceState.getState()) {
                        case 0:
                            C0305bx.this.m909p();
                            break;
                        case 1:
                            C0305bx.this.m911r();
                            break;
                    }
                    if (C0305bx.this.f613o != null) {
                        C0305bx.this.f613o.onServiceStateChanged(serviceState);
                    }
                } catch (Throwable th) {
                    C0310c.m956a(th, "CgiManager", "initPhoneStateListener4");
                }
            }

            public void onSignalStrengthChanged(int i) {
                int i2 = -113;
                try {
                    switch (C0305bx.this.f602d) {
                        case 1:
                            i2 = C0331cr.m1152a(i);
                            break;
                        case 2:
                            i2 = C0331cr.m1152a(i);
                            break;
                    }
                    C0305bx.this.m890a((C0305bx) i2);
                    if (C0305bx.this.f613o != null) {
                        C0305bx.this.f613o.onSignalStrengthChanged(i);
                    }
                } catch (Throwable th) {
                    C0310c.m956a(th, "CgiManager", "initPhoneStateListener6");
                }
            }

            public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                if (signalStrength != null) {
                    int i = -113;
                    try {
                        switch (C0305bx.this.f602d) {
                            case 1:
                                i = C0331cr.m1152a(signalStrength.getGsmSignalStrength());
                                break;
                            case 2:
                                i = signalStrength.getCdmaDbm();
                                break;
                        }
                        C0305bx.this.m890a((C0305bx) i);
                        if (C0305bx.this.f613o != null) {
                            C0305bx.this.f613o.onSignalStrengthsChanged(signalStrength);
                        }
                    } catch (Throwable th) {
                        C0310c.m956a(th, "CgiManager", "initPhoneStateListener5");
                    }
                }
            }
        };
        int i = 0;
        try {
            i = C0331cr.m1178c() < 7 ? C0325cm.m1114b("android.telephony.PhoneStateListener", "LISTEN_SIGNAL_STRENGTH") : C0325cm.m1114b("android.telephony.PhoneStateListener", "LISTEN_SIGNAL_STRENGTHS");
        } catch (Throwable th) {
        }
        if (i == 0) {
            this.f605g.listen(this.f609k, 16);
        } else {
            try {
                this.f605g.listen(this.f609k, i | 16);
            } catch (Throwable th2) {
                C0310c.m956a(th2, "CgiManager", "initPhoneStateListener1");
            }
        }
        try {
            switch (m905k()) {
                case 0:
                    this.f606h = C0331cr.m1157a(this.f601c, "phone2");
                    return;
                case 1:
                    this.f606h = C0331cr.m1157a(this.f601c, "phone_msim");
                    return;
                case 2:
                    this.f606h = C0331cr.m1157a(this.f601c, "phone2");
                    return;
                default:
                    return;
            }
        } catch (Throwable th3) {
            C0310c.m956a(th3, "CgiManager", "initPhoneStateListener");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: r */
    private void m911r() {
        this.f614p = null;
        this.f610l = null;
        this.f602d = 9;
        this.f603e.clear();
    }

    /* renamed from: a */
    public CellLocation mo3821a(boolean z, boolean z2) {
        return m894b(z, z2);
    }

    /* renamed from: a */
    public void mo3822a() {
        m909p();
        if (!this.f611m && this.f605g != null) {
            try {
                this.f602d = C0331cr.m1155a(this.f600b, this.f605g.getCellLocation(), this.f601c);
                this.f614p = null;
            } catch (SecurityException e) {
                this.f614p = e.getMessage();
            } catch (Throwable th) {
                this.f614p = null;
                C0310c.m956a(th, "CgiManager", "CgiManager");
                this.f602d = 9;
            }
            if (this.f599a != null) {
                this.f599a.quit();
                this.f599a = null;
            }
            if (this.f599a == null) {
                this.f599a = new HandlerThreadC0307a("listenerPhoneStateThread");
                this.f599a.start();
            }
        }
    }

    /* renamed from: a */
    public void mo3823a(JSONObject jSONObject) {
        this.f608j = jSONObject;
    }

    /* renamed from: a */
    public boolean mo3824a(CellLocation cellLocation) {
        boolean z = false;
        if (cellLocation != null) {
            boolean z2 = true;
            switch (C0331cr.m1155a(this.f600b, cellLocation, this.f601c)) {
                case 1:
                    try {
                        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                        z = m893a(gsmCellLocation.getLac(), gsmCellLocation.getCid());
                        break;
                    } catch (Throwable th) {
                        C0310c.m956a(th, "CgiManager", "cgiUseful Cgi.iGsmT");
                        z = true;
                        break;
                    }
                case 2:
                    try {
                        if (C0325cm.m1113b(cellLocation, "getSystemId", new Object[0]) <= 0 || C0325cm.m1113b(cellLocation, "getNetworkId", new Object[0]) < 0 || C0325cm.m1113b(cellLocation, "getBaseStationId", new Object[0]) < 0) {
                            z2 = false;
                        }
                        z = z2;
                        break;
                    } catch (Throwable th2) {
                        C0310c.m956a(th2, "CgiManager", "cgiUseful Cgi.iCdmaT");
                        z = true;
                        break;
                    }
                default:
                    z = true;
                    break;
            }
            if (!z) {
                this.f602d = 9;
            }
        }
        return z;
    }

    /* renamed from: a */
    public boolean mo3825a(boolean z) {
        return !z && this.f607i != 0 && C0331cr.m1170b() - this.f607i >= 30000;
    }

    /* renamed from: b */
    public ArrayList<C0304bw> mo3826b() {
        return this.f603e;
    }

    /* renamed from: c */
    public C0304bw mo3827c() {
        ArrayList<C0304bw> arrayList = this.f603e;
        if (arrayList.size() >= 1) {
            return arrayList.get(0);
        }
        return null;
    }

    /* renamed from: d */
    public int mo3828d() {
        return this.f602d;
    }

    /* renamed from: e */
    public CellLocation mo3829e() {
        if (this.f605g != null) {
            try {
                CellLocation cellLocation = this.f605g.getCellLocation();
                this.f614p = null;
                if (mo3824a(cellLocation)) {
                    this.f610l = cellLocation;
                    return cellLocation;
                }
            } catch (SecurityException e) {
                this.f614p = e.getMessage();
            } catch (Throwable th) {
                this.f614p = null;
                C0310c.m956a(th, "CgiManager", "getCellLocation");
            }
        }
        return null;
    }

    /* renamed from: f */
    public TelephonyManager mo3830f() {
        return this.f605g;
    }

    /* renamed from: g */
    public void mo3831g() {
        m911r();
    }

    /* renamed from: h */
    public void mo3832h() {
        m909p();
    }

    /* renamed from: i */
    public void mo3833i() {
        if (!(this.f605g == null || this.f609k == null)) {
            try {
                this.f605g.listen(this.f609k, 0);
            } catch (Throwable th) {
                C0310c.m956a(th, "CgiManager", "destroy");
            }
        }
        this.f609k = null;
        synchronized (this.f612n) {
            this.f611m = true;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        if (this.f599a != null) {
            this.f599a.quit();
            this.f599a = null;
        }
        this.f603e.clear();
        this.f604f = -113;
        this.f605g = null;
        this.f606h = null;
    }

    /* renamed from: j */
    public void mo3834j() {
        switch (this.f602d) {
            case 1:
                if (this.f603e.isEmpty()) {
                    this.f602d = 9;
                    return;
                }
                return;
            case 2:
                if (this.f603e.isEmpty()) {
                    this.f602d = 9;
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: l */
    public String mo3835l() {
        return this.f614p;
    }
}
