package com.amap.loc;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.amap.api.fence.Fence;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.APSService;
import com.amap.api.location.LocationManagerBase;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.umeng.analytics.p091b.C1447g;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
import org.pwrd.paho.client.mqttv3.MqttTopic;
import org.pwrd.paho.client.mqttv3.internal.ClientDefaults;

/* renamed from: com.amap.loc.a */
/* compiled from: AMapLocationManager */
public class C0215a implements LocationManagerBase {

    /* renamed from: r */
    public static boolean f217r = false;

    /* renamed from: A */
    Callable<Messenger> f218A = new Callable<Messenger>() {
        /* class com.amap.loc.C0215a.CallableC02161 */

        /* renamed from: a */
        public Messenger call() {
            while (C0215a.this.f243i == null) {
                try {
                    Thread.sleep(50);
                } catch (Throwable th) {
                }
            }
            return C0215a.this.f243i;
        }
    };

    /* renamed from: B */
    boolean f219B = false;

    /* renamed from: C */
    boolean f220C = false;

    /* renamed from: D */
    JSONObject f221D = null;

    /* renamed from: E */
    private int f222E = 0;

    /* renamed from: F */
    private boolean f223F = false;

    /* renamed from: G */
    private Context f224G;

    /* renamed from: H */
    private boolean f225H = false;

    /* renamed from: I */
    private boolean f226I = true;

    /* renamed from: J */
    private JSONArray f227J = null;

    /* renamed from: K */
    private int f228K = 0;

    /* renamed from: L */
    private boolean f229L = true;

    /* renamed from: M */
    private ServiceConnection f230M = new ServiceConnection() {
        /* class com.amap.loc.C0215a.ServiceConnectionC02172 */

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C0215a.this.f243i = new Messenger(iBinder);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            C0215a.this.f243i = null;
        }
    };

    /* renamed from: N */
    private LinkedList<C0221a> f231N = new LinkedList<>();

    /* renamed from: O */
    private LinkedList<C0221a> f232O = new LinkedList<>();

    /* renamed from: P */
    private int f233P = 0;

    /* renamed from: Q */
    private AMapLocation f234Q = null;

    /* renamed from: a */
    AMapLocationClientOption f235a;

    /* renamed from: b */
    public HandlerC0223c f236b;

    /* renamed from: c */
    C0334e f237c = null;

    /* renamed from: d */
    ArrayList<AMapLocationListener> f238d = new ArrayList<>();

    /* renamed from: e */
    C0333d f239e;

    /* renamed from: f */
    boolean f240f = false;

    /* renamed from: g */
    public boolean f241g = true;

    /* renamed from: h */
    C0336f f242h;

    /* renamed from: i */
    Messenger f243i = null;

    /* renamed from: j */
    Messenger f244j = null;

    /* renamed from: k */
    Intent f245k = null;

    /* renamed from: l */
    int f246l = 0;

    /* renamed from: m */
    boolean f247m = false;

    /* renamed from: n */
    long f248n = 0;

    /* renamed from: o */
    AMapLocation f249o = null;

    /* renamed from: p */
    long f250p = 0;

    /* renamed from: q */
    long f251q = 0;

    /* renamed from: s */
    ScheduledExecutorService f252s = Executors.newScheduledThreadPool(3);

    /* renamed from: t */
    RunnableC0224d f253t = null;

    /* renamed from: u */
    RunnableC0222b f254u = null;

    /* renamed from: v */
    ScheduledFuture<Messenger> f255v = null;

    /* renamed from: w */
    ScheduledFuture<?> f256w = null;

    /* renamed from: x */
    Future<?> f257x = null;

    /* renamed from: y */
    int f258y = 240;

    /* renamed from: z */
    int f259z = 80;

    /* access modifiers changed from: package-private */
    /* renamed from: com.amap.loc.a$a */
    /* compiled from: AMapLocationManager */
    public static class C0221a {

        /* renamed from: a */
        double f265a;

        /* renamed from: b */
        double f266b;

        /* renamed from: c */
        long f267c;

        /* renamed from: d */
        float f268d;

        /* renamed from: e */
        float f269e;

        /* renamed from: f */
        int f270f;

        /* renamed from: g */
        String f271g;

        C0221a(AMapLocation aMapLocation, int i) {
            this.f265a = aMapLocation.getLatitude();
            this.f266b = aMapLocation.getLongitude();
            this.f267c = aMapLocation.getTime();
            this.f268d = aMapLocation.getAccuracy();
            this.f269e = aMapLocation.getSpeed();
            this.f270f = i;
            this.f271g = aMapLocation.getProvider();
        }

        public boolean equals(Object obj) {
            try {
                C0221a aVar = (C0221a) obj;
                return aVar != null && this.f265a == aVar.f265a && this.f266b == aVar.f266b;
            } catch (Throwable th) {
                return false;
            }
        }

        public int hashCode() {
            return super.hashCode();
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.f265a);
            stringBuffer.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
            stringBuffer.append(this.f266b);
            stringBuffer.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
            stringBuffer.append(this.f268d);
            stringBuffer.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
            stringBuffer.append(this.f267c);
            stringBuffer.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
            stringBuffer.append(this.f269e);
            stringBuffer.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
            stringBuffer.append(this.f270f);
            stringBuffer.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
            stringBuffer.append(this.f271g);
            return stringBuffer.toString();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.amap.loc.a$b */
    /* compiled from: AMapLocationManager */
    public class RunnableC0222b implements Runnable {
        RunnableC0222b() {
        }

        public void run() {
            try {
                C0215a.this.f237c.mo3920a(C0215a.this.f235a);
            } catch (Throwable th) {
                C0310c.m956a(th, "AMapLocationManager$GPSTask", "run");
            }
        }
    }

    /* renamed from: com.amap.loc.a$c */
    /* compiled from: AMapLocationManager */
    public static class HandlerC0223c extends Handler {

        /* renamed from: a */
        C0215a f273a = null;

        /* renamed from: b */
        AMapLocation f274b = null;

        public HandlerC0223c(C0215a aVar) {
            this.f273a = aVar;
        }

        public HandlerC0223c(C0215a aVar, Looper looper) {
            super(looper);
            this.f273a = aVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0093  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r8) {
            /*
            // Method dump skipped, instructions count: 660
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0215a.HandlerC0223c.handleMessage(android.os.Message):void");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.amap.loc.a$d */
    /* compiled from: AMapLocationManager */
    public class RunnableC0224d implements Runnable {
        RunnableC0224d() {
        }

        public void run() {
            try {
                if (C0215a.this.m413j() || !C0215a.this.f247m) {
                    if (C0215a.this.f241g) {
                        C0215a.this.m418n();
                    }
                    if (C0215a.this.m383a()) {
                        C0215a.this.f225H = true;
                        Bundle bundle = new Bundle();
                        bundle.putString("extraJson", C0310c.m952a(C0215a.this.f235a, C0215a.this.f224G).toString());
                        if (C0215a.this.f241g) {
                            C0215a.this.m365a((C0215a) 0, (int) bundle);
                        } else {
                            C0215a.this.m365a((C0215a) 1, (int) bundle);
                        }
                    }
                    C0215a.this.f241g = false;
                    return;
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
            } catch (Throwable th) {
                C0310c.m956a(th, "AMapLocationManager$NetWorkTask", "run");
            }
        }
    }

    public C0215a(Context context, Intent intent) {
        this.f224G = context;
        this.f245k = intent;
        if (C0310c.m963d()) {
            try {
                C0328cp.m1133a(this.f224G, C0310c.m950a("loc", "3.0.0"));
            } catch (Throwable th) {
            }
        }
        m396c();
        this.f253t = new RunnableC0224d();
        this.f254u = new RunnableC0222b();
    }

    /* renamed from: a */
    private C0221a m364a(AMapLocation aMapLocation, int i) {
        return new C0221a(aMapLocation, i);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private void m365a(int i, Bundle bundle) {
        try {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.setData(bundle);
            obtain.replyTo = this.f244j;
            if (this.f243i != null) {
                this.f243i.send(obtain);
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationManager", "sendLocMessage");
        }
    }

    /* renamed from: a */
    private void m366a(long j) {
        try {
            if (this.f256w == null || this.f256w.isCancelled()) {
                this.f256w = this.f252s.scheduleAtFixedRate(this.f253t, j, this.f235a.getInterval(), TimeUnit.MILLISECONDS);
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationManager", "startNetLocationTask");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private void m367a(PendingIntent pendingIntent) {
        if (pendingIntent != null && this.f239e != null) {
            this.f239e.mo3914a(pendingIntent);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private void m368a(Intent intent) {
        String str;
        if (intent == null) {
            try {
                intent = new Intent(this.f224G, APSService.class);
            } catch (Throwable th) {
                C0310c.m956a(th, "AMapLocationManager", "startServiceImpl");
                return;
            }
        }
        try {
            str = !TextUtils.isEmpty(AMapLocationClientOption.getAPIKEY()) ? AMapLocationClientOption.getAPIKEY() : C0342i.m1235f(this.f224G);
        } catch (Throwable th2) {
            C0310c.m956a(th2, "AMapLocationManager", "startServiceImpl p2");
            str = "";
        }
        intent.putExtra("a", str);
        intent.putExtra("b", this.f224G.getPackageName());
        this.f224G.bindService(intent, this.f230M, 1);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private void m369a(Fence fence) {
        if (fence != null && this.f239e != null) {
            this.f239e.mo3917a(fence, fence.f156a);
        }
    }

    /* renamed from: a */
    private void m370a(AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() == 0) {
            try {
                m401d(m387b(this.f249o, aMapLocation));
            } catch (Throwable th) {
                C0310c.m956a(th, "AMapLocationManager", "handleMessage");
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private void m371a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        Bundle bundle = null;
        if (aMapLocation != null) {
            bundle = new Bundle();
            bundle.putDouble(C1447g.f3485ae, aMapLocation.getLatitude());
            bundle.putDouble("lon", aMapLocation.getLongitude());
        }
        if (this.f235a.isNeedAddress() && aMapLocation2 == null) {
            m365a(10, bundle);
        } else if (aMapLocation2 != null && this.f235a.isNeedAddress()) {
            float a = C0331cr.m1151a(new double[]{aMapLocation2.getLatitude(), aMapLocation2.getLongitude(), aMapLocation.getLatitude(), aMapLocation.getLongitude()});
            if (a < ((float) this.f258y)) {
                C0310c.m949a(aMapLocation, aMapLocation2);
            }
            if (a > ((float) this.f259z)) {
                m365a(10, bundle);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private void m372a(AMapLocation aMapLocation, Throwable th) {
        try {
            if (!C0310c.m963d() || aMapLocation != null) {
                if (aMapLocation == null) {
                    aMapLocation = new AMapLocation("");
                    aMapLocation.setErrorCode(8);
                }
                if (!"gps".equals(aMapLocation.getProvider())) {
                    aMapLocation.setProvider("lbs");
                }
                try {
                    if (this.f239e != null) {
                        this.f239e.mo3915a(aMapLocation);
                    }
                } catch (Throwable th2) {
                    C0310c.m956a(th2, "AMapLocationManager", "handlerLocation part1");
                }
                try {
                    if (!this.f226I) {
                        long time = aMapLocation.getTime();
                        m370a(aMapLocation);
                        this.f250p = C0331cr.m1170b();
                        this.f249o = aMapLocation;
                        aMapLocation.setTime(time);
                        m390b(aMapLocation);
                        this.f242h.mo3926a(aMapLocation);
                        m397c(aMapLocation);
                        C0327co.m1121a(this.f224G, this.f228K, aMapLocation);
                    }
                } catch (Throwable th3) {
                    C0310c.m956a(th3, "AMapLocationManager", "handlerLocation part2");
                }
                C0328cp.m1135b(this.f224G);
                if (this.f235a.isOnceLocation()) {
                    stopLocation();
                }
            } else if (th != null) {
                C0328cp.m1134a(this.f224G, "loc", th.getMessage());
            } else {
                C0328cp.m1134a(this.f224G, "loc", "amaplocation is null");
            }
        } catch (Throwable th4) {
            C0310c.m956a(th4, "AMapLocationManager", "handlerLocation part3");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private void m373a(AMapLocationListener aMapLocationListener) {
        if (aMapLocationListener == null) {
            throw new IllegalArgumentException("listener参数不能为null");
        }
        if (this.f238d == null) {
            this.f238d = new ArrayList<>();
        }
        if (!this.f238d.contains(aMapLocationListener)) {
            this.f238d.add(aMapLocationListener);
        }
    }

    /* renamed from: a */
    private void m381a(C0292br brVar) {
        try {
            String apikey = AMapLocationClientOption.getAPIKEY();
            if (!TextUtils.isEmpty(apikey)) {
                C0343j.m1239a(apikey);
            }
            this.f220C = true;
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationManager", "initAPSBase 2");
        }
    }

    /* renamed from: a */
    private void m382a(C0292br brVar, boolean z, boolean z2) {
        try {
            if (!this.f220C) {
                m381a(brVar);
                this.f221D = C0310c.m952a(this.f235a, this.f224G);
            }
            brVar.mo3784a(this.f221D);
            if (z) {
                brVar.mo3786a(this.f224G);
            } else {
                brVar.mo3787a(this.f224G, z2);
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationManager", "initAPS part3");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private boolean m383a() {
        boolean z;
        try {
            if (this.f255v != null && !this.f255v.isDone() && !this.f255v.isCancelled()) {
                this.f243i = this.f255v.get(5000, TimeUnit.MILLISECONDS);
            }
            if (this.f255v != null) {
                this.f255v.cancel(true);
                this.f255v = null;
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationManager", "checkAPSManager");
            return false;
        }
        if (this.f243i == null) {
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.setErrorCode(10);
            aMapLocation.setLocationDetail("请检查配置文件是否配置服务");
            bundle.putString("locationJson", aMapLocation.toStr(1));
            obtain.setData(bundle);
            obtain.what = 1;
            if (this.f236b != null) {
                this.f236b.sendMessage(obtain);
            }
            z = false;
        } else {
            z = true;
        }
        return z;
    }

    /* renamed from: b */
    private AMapLocation m387b(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        this.f234Q = aMapLocation2;
        long b = C0331cr.m1170b();
        boolean z = false;
        this.f251q = 0;
        this.f233P = 0;
        if (aMapLocation == null || aMapLocation2 == null || aMapLocation.getLocationType() != 1 || this.f222E <= 3 || aMapLocation2.getAccuracy() < 0.0f || aMapLocation2.getSpeed() < 0.0f) {
            if (aMapLocation2.getAccuracy() < 0.0f) {
                aMapLocation2.setAccuracy(0.0f);
            }
            if (aMapLocation2.getSpeed() >= 0.0f) {
                return aMapLocation2;
            }
            aMapLocation2.setSpeed(0.0f);
            return aMapLocation2;
        }
        long time = aMapLocation2.getTime() - aMapLocation.getTime();
        if (time < 0) {
            return aMapLocation2;
        }
        if (aMapLocation2.getLocationType() == 1) {
            if (b - this.f250p < 5000) {
                if (C0331cr.m1151a(new double[]{aMapLocation.getLatitude(), aMapLocation.getLongitude(), aMapLocation2.getLatitude(), aMapLocation2.getLongitude()}) > (((aMapLocation.getSpeed() + aMapLocation2.getSpeed()) * ((float) time)) / 2000.0f) + (2.0f * (aMapLocation.getAccuracy() + aMapLocation2.getAccuracy())) + 3000.0f) {
                    z = true;
                }
            } else {
                this.f222E = 0;
            }
        }
        if (!z) {
            return aMapLocation2;
        }
        if (this.f251q == 0) {
            this.f251q = C0331cr.m1170b();
        }
        if (b - this.f251q >= 30000) {
            return aMapLocation2;
        }
        this.f223F = true;
        this.f233P = 1;
        return aMapLocation;
    }

    /* renamed from: b */
    private void m388b() {
        try {
            if (this.f255v == null || this.f255v.isCancelled()) {
                this.f255v = this.f252s.schedule(this.f218A, 0, TimeUnit.MILLISECONDS);
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationManager", "doGetServiceMessengerFuture");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: b */
    private void m389b(Fence fence) {
        if (fence != null && this.f239e != null) {
            this.f239e.mo3916a(fence.f156a, fence.f157b);
        }
    }

    /* renamed from: b */
    private void m390b(AMapLocation aMapLocation) {
        try {
            if ("gps".equals(aMapLocation.getProvider()) || m413j()) {
                Iterator<AMapLocationListener> it = this.f238d.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onLocationChanged(aMapLocation);
                    } catch (Throwable th) {
                    }
                }
            }
        } catch (Throwable th2) {
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: b */
    private void m391b(AMapLocationListener aMapLocationListener) {
        if (!this.f238d.isEmpty() && this.f238d.contains(aMapLocationListener)) {
            this.f238d.remove(aMapLocationListener);
        }
        if (this.f238d.isEmpty()) {
            stopLocation();
        }
    }

    /* renamed from: c */
    private void m396c() {
        if (Looper.myLooper() == null) {
            this.f236b = new HandlerC0223c(this, this.f224G.getMainLooper());
        } else {
            this.f236b = new HandlerC0223c(this);
        }
        m400d();
        m388b();
        this.f242h = new C0336f(this.f224G);
        this.f244j = new Messenger(this.f236b);
        this.f237c = new C0334e(this.f224G, this.f236b);
        try {
            this.f239e = new C0333d(this.f224G);
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationManager", "init");
        }
    }

    /* renamed from: c */
    private void m397c(AMapLocation aMapLocation) {
        boolean z = true;
        int i = 0;
        try {
            if (C0322ck.m1087o()) {
                switch (this.f228K) {
                    case 1:
                        break;
                    case 2:
                    case 4:
                    case 8:
                        i = 1;
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 7:
                    default:
                        z = false;
                        break;
                }
                if (z) {
                    if (this.f227J == null) {
                        this.f227J = new JSONArray();
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("lon", aMapLocation.getLongitude());
                    jSONObject.put(C1447g.f3485ae, aMapLocation.getLatitude());
                    jSONObject.put("type", i);
                    jSONObject.put("timestamp", C0331cr.m1156a());
                    this.f227J = this.f227J.put(jSONObject);
                    if (this.f227J.length() >= 10) {
                        m414k();
                    }
                }
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationManager", "handlerOfflineLog");
        }
    }

    /* renamed from: d */
    private void m400d() {
        Message obtain = Message.obtain();
        obtain.what = 103;
        obtain.obj = this.f245k;
        this.f236b.sendMessage(obtain);
    }

    /* renamed from: d */
    private void m401d(AMapLocation aMapLocation) {
        C0221a a = m364a(aMapLocation, this.f233P);
        C0221a a2 = m364a(this.f234Q, this.f233P);
        if (!this.f223F) {
            if (!this.f231N.contains(a)) {
                if (this.f231N.size() >= 5) {
                    this.f231N.removeFirst();
                }
                this.f231N.add(a);
            }
        } else if (this.f233P == 0) {
            if (!this.f231N.contains(a) && !this.f232O.contains(a)) {
                this.f232O.add(a);
            }
        } else if (!this.f232O.contains(a2)) {
            this.f232O.add(a2);
        }
        if (this.f231N.size() + this.f232O.size() >= 10) {
            this.f231N.addAll(this.f232O);
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<C0221a> it = this.f231N.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next().toString());
                stringBuffer.append(MqttTopic.MULTI_LEVEL_WILDCARD);
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            C0327co.m1127a("gpsstatistics", stringBuffer.toString());
            this.f231N.clear();
            this.f232O.clear();
            this.f223F = false;
        }
    }

    /* renamed from: e */
    static /* synthetic */ int m402e(C0215a aVar) {
        int i = aVar.f222E;
        aVar.f222E = i + 1;
        return i;
    }

    /* renamed from: e */
    private void m403e() {
        try {
            m408h();
            m366a(0);
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationManager", "batterySavingLocaiton");
        }
    }

    /* renamed from: f */
    private void m404f() {
        long j = 0;
        try {
            m406g();
            if (this.f235a.isGpsFirst()) {
                j = 30000;
            }
            m366a(j);
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationManager", "hightAccuracyLocation");
        }
    }

    /* renamed from: g */
    private void m406g() {
        try {
            if (!this.f235a.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy)) {
                m410i();
            }
            if (this.f257x == null || this.f257x.isCancelled()) {
                this.f257x = this.f252s.submit(this.f254u);
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationManager", "deviceSensorsLocation");
        }
    }

    /* renamed from: h */
    private void m408h() {
        try {
            if (this.f257x != null) {
                this.f257x.cancel(false);
                this.f257x = null;
            }
            this.f237c.mo3918a();
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationManager", "stopGPSLocationTask");
        }
    }

    /* renamed from: i */
    private void m410i() {
        try {
            if (this.f256w != null) {
                this.f256w.cancel(false);
                this.f256w = null;
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationManager", "stopNetLocationTask");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: j */
    private boolean m413j() {
        return C0331cr.m1170b() - this.f248n > 10000;
    }

    /* renamed from: k */
    private synchronized void m414k() {
        try {
            if (C0322ck.m1087o() && this.f227J != null && this.f227J.length() > 0) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("detail", this.f227J);
                C0286bn.m767a(new C0285bm(this.f224G, C0310c.m950a("loc", "3.0.0"), jSONObject.toString()), this.f224G);
                this.f227J = null;
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationManager", "writeOfflineLog");
        }
        return;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: l */
    private void m416l() {
        boolean z = true;
        boolean z2 = false;
        try {
            if (this.f224G.checkCallingOrSelfPermission("android.permission.SYSTEM_ALERT_WINDOW") == 0) {
                z2 = true;
            } else if (this.f224G instanceof Activity) {
                z2 = true;
                z = false;
            } else {
                z = false;
            }
            if (z2) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this.f224G);
                builder.setMessage(C0322ck.m1070g());
                if (!"".equals(C0322ck.m1074h()) && C0322ck.m1074h() != null) {
                    builder.setPositiveButton(C0322ck.m1074h(), new DialogInterface.OnClickListener() {
                        /* class com.amap.loc.C0215a.DialogInterface$OnClickListenerC02183 */

                        public void onClick(DialogInterface dialogInterface, int i) {
                            C0215a.this.m417m();
                            dialogInterface.cancel();
                        }
                    });
                }
                builder.setNegativeButton(C0322ck.m1077i(), new DialogInterface.OnClickListener() {
                    /* class com.amap.loc.C0215a.DialogInterface$OnClickListenerC02194 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog create = builder.create();
                if (z) {
                    create.getWindow().setType(2003);
                }
                create.setCanceledOnTouchOutside(false);
                create.show();
                return;
            }
            m417m();
        } catch (Throwable th) {
            m417m();
            C0310c.m956a(th, "AMapLocationManager", "showDialog");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: m */
    private void m417m() {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.autonavi.minimap", C0322ck.m1084l()));
            intent.setFlags(ClientDefaults.MAX_MSG_SIZE);
            intent.setData(Uri.parse(C0322ck.m1080j()));
            this.f224G.startActivity(intent);
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationManager", "callAMap part2");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: n */
    private void m418n() {
        AMapLocationServer aMapLocationServer;
        boolean z = false;
        try {
            C0326cn cnVar = new C0326cn();
            AMapLocationServer aMapLocationServer2 = null;
            cnVar.mo3906a(C0331cr.m1170b());
            C0292br brVar = new C0292br();
            if (this.f235a.isLocationCacheEnable()) {
                m382a(brVar, true, false);
                try {
                    aMapLocationServer2 = brVar.mo3798h();
                } catch (Throwable th) {
                    C0310c.m956a(th, "AMapLocationManager", "doAPSLocation:doFirstCacheLocate");
                }
            }
            if (aMapLocationServer2 == null || !C0331cr.m1164a(aMapLocationServer2)) {
                m382a(brVar, false, false);
                try {
                    aMapLocationServer2 = brVar.mo3791c(false);
                    z = true;
                } catch (Throwable th2) {
                    C0310c.m956a(th2, "AMapLocationManager", "doAPSLocation:doFirstNetLocate");
                }
            }
            cnVar.mo3909b(C0331cr.m1170b());
            cnVar.mo3907a(aMapLocationServer2);
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            if (aMapLocationServer2 != null) {
                bundle.putInt("originalLocType", aMapLocationServer2.getLocationType());
                bundle.putString("locationJson", aMapLocationServer2.toStr(1));
            } else {
                bundle.putInt("originalLocType", 0);
            }
            obtain.setData(bundle);
            obtain.what = 1;
            if (this.f236b != null) {
                this.f236b.sendMessage(obtain);
            }
            try {
                C0327co.m1122a(this.f224G, cnVar);
            } catch (Throwable th3) {
            }
            if (z) {
                try {
                    m382a(brVar, false, true);
                    aMapLocationServer = brVar.mo3791c(true);
                } catch (Throwable th4) {
                    C0310c.m956a(th4, "AMapLocationManager", "doAPSLocation:doFirstNetLocate 2");
                    aMapLocationServer = aMapLocationServer2;
                }
                if (aMapLocationServer.getErrorCode() == 0) {
                    try {
                        brVar.mo3783a(aMapLocationServer);
                    } catch (Throwable th5) {
                        C0310c.m956a(th5, "AMapLocationManager", "doAPSLocation:doFirstAddCache");
                    }
                }
            }
            brVar.mo3792c();
        } catch (Throwable th6) {
            C0310c.m956a(th6, "AMapLocationManager", "doAPSLocation");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: o */
    private void m419o() {
        if (this.f235a == null) {
            this.f235a = new AMapLocationClientOption();
        }
        this.f226I = false;
        switch (this.f235a.getLocationMode()) {
            case Battery_Saving:
                m403e();
                return;
            case Device_Sensors:
                m406g();
                return;
            case Hight_Accuracy:
                m404f();
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: p */
    private void m420p() {
        try {
            m408h();
            m410i();
            this.f231N.clear();
            this.f232O.clear();
            m414k();
            this.f247m = false;
            this.f226I = true;
            this.f248n = 0;
            this.f246l = 0;
            this.f249o = null;
            this.f250p = 0;
            this.f223F = false;
            this.f233P = 0;
            this.f222E = 0;
            this.f234Q = null;
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationManager", "stopLocation");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: q */
    private void m421q() {
        this.f241g = true;
        this.f225H = false;
        m420p();
        this.f242h.mo3927b();
        this.f242h = null;
        if (this.f239e != null) {
            this.f239e.mo3913a();
        }
        if (this.f230M != null) {
            this.f224G.unbindService(this.f230M);
        }
        if (this.f238d != null) {
            this.f238d.clear();
            this.f238d = null;
        }
        if (this.f255v != null) {
            this.f255v.cancel(true);
            this.f255v = null;
        }
        this.f252s.shutdownNow();
        this.f230M = null;
        if (this.f236b != null) {
            this.f236b.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void addGeoFenceAlert(String str, double d, double d2, float f, long j, PendingIntent pendingIntent) {
        try {
            Message obtain = Message.obtain();
            Fence fence = new Fence();
            fence.f157b = str;
            fence.f159d = d;
            fence.f158c = d2;
            fence.f160e = f;
            fence.f156a = pendingIntent;
            fence.mo3481a(j);
            obtain.obj = fence;
            obtain.what = 1006;
            this.f236b.sendMessage(obtain);
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationManager", "addGeoFenceAlert");
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public AMapLocation getLastKnownLocation() {
        try {
            return this.f242h.mo3925a();
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationManager", "getLastKnownLocation");
            return null;
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public boolean isStarted() {
        return this.f225H;
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void onDestroy() {
        try {
            Message obtain = Message.obtain();
            obtain.what = 1011;
            this.f236b.sendMessage(obtain);
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationManager", "onDestroy");
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void removeGeoFenceAlert(PendingIntent pendingIntent) {
        try {
            Message obtain = Message.obtain();
            obtain.obj = pendingIntent;
            obtain.what = 1007;
            this.f236b.sendMessage(obtain);
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationManager", "removeGeoFenceAlert 2");
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void removeGeoFenceAlert(PendingIntent pendingIntent, String str) {
        try {
            Message obtain = Message.obtain();
            Fence fence = new Fence();
            fence.f157b = str;
            fence.f156a = pendingIntent;
            obtain.obj = fence;
            obtain.what = 1010;
            this.f236b.sendMessage(obtain);
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationManager", "removeGeoFenceAlert 1");
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void setLocationListener(AMapLocationListener aMapLocationListener) {
        if (aMapLocationListener == null) {
            try {
                throw new IllegalArgumentException("listener参数不能为null");
            } catch (Throwable th) {
                C0310c.m956a(th, "AMapLocationManager", "setLocationListener");
            }
        } else {
            Message obtain = Message.obtain();
            obtain.what = 1002;
            obtain.obj = aMapLocationListener;
            this.f236b.sendMessage(obtain);
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void setLocationOption(AMapLocationClientOption aMapLocationClientOption) {
        try {
            if (!(this.f226I || this.f235a == null || this.f235a.getInterval() == aMapLocationClientOption.getInterval())) {
                this.f235a = aMapLocationClientOption.clone();
                m410i();
                m408h();
                m366a(0);
                if (!this.f235a.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Battery_Saving)) {
                    m406g();
                }
            }
            this.f235a = aMapLocationClientOption.clone();
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationManager", "setLocationOption");
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void startAssistantLocation() {
        try {
            Message obtain = Message.obtain();
            obtain.what = 1008;
            this.f236b.sendMessage(obtain);
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationManager", "startAssistantLocation");
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void startLocation() {
        try {
            Message obtain = Message.obtain();
            obtain.what = 1003;
            this.f236b.sendMessage(obtain);
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationManager", "startLocation");
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void stopAssistantLocation() {
        try {
            Message obtain = Message.obtain();
            obtain.what = 1009;
            this.f236b.sendMessage(obtain);
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationManager", "stopAssistantLocation");
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void stopLocation() {
        try {
            Message obtain = Message.obtain();
            obtain.what = 1004;
            this.f236b.sendMessage(obtain);
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationManager", "stopLocation");
        }
    }

    @Override // com.amap.api.location.LocationManagerBase
    public void unRegisterLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            Message obtain = Message.obtain();
            obtain.what = 1005;
            obtain.obj = aMapLocationListener;
            this.f236b.sendMessage(obtain);
        } catch (Throwable th) {
            C0310c.m956a(th, "AMapLocationManager", "unRegisterLocationListener");
        }
    }
}
