package com.amap.loc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.APSServiceBase;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.umeng.analytics.p091b.C1447g;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONObject;

/* renamed from: com.amap.loc.b */
/* compiled from: APSServiceCore */
public class C0258b implements APSServiceBase {

    /* renamed from: A */
    boolean f352A = false;

    /* renamed from: B */
    volatile Socket f353B = null;

    /* renamed from: C */
    boolean f354C = false;

    /* renamed from: D */
    C0262d f355D;

    /* renamed from: E */
    private volatile boolean f356E = false;

    /* renamed from: F */
    private int f357F = 0;

    /* renamed from: G */
    private boolean f358G = false;

    /* renamed from: H */
    private boolean f359H = false;

    /* renamed from: I */
    private boolean f360I = false;

    /* renamed from: J */
    private boolean f361J = false;

    /* renamed from: K */
    private boolean f362K = false;

    /* renamed from: L */
    private boolean f363L = false;

    /* renamed from: M */
    private boolean f364M = false;

    /* renamed from: N */
    private long f365N = 0;

    /* renamed from: O */
    private long f366O = 0;

    /* renamed from: P */
    private C0292br f367P = null;

    /* renamed from: Q */
    private boolean f368Q = true;

    /* renamed from: R */
    private String f369R = "";

    /* renamed from: a */
    Context f370a;

    /* renamed from: b */
    boolean f371b = false;

    /* renamed from: c */
    boolean f372c = false;

    /* renamed from: d */
    Messenger f373d = null;

    /* renamed from: e */
    String f374e = null;

    /* renamed from: f */
    Messenger f375f;

    /* renamed from: g */
    HandlerC0261c f376g = new HandlerC0261c(this);

    /* renamed from: h */
    C0260b f377h = null;

    /* renamed from: i */
    Vector<Messenger> f378i = new Vector<>();

    /* renamed from: j */
    Vector<Messenger> f379j = new Vector<>();

    /* renamed from: k */
    Vector<Messenger> f380k = new Vector<>();

    /* renamed from: l */
    ExecutorService f381l = Executors.newCachedThreadPool();

    /* renamed from: m */
    Future<?> f382m = null;

    /* renamed from: n */
    AMapLocation f383n = null;

    /* renamed from: o */
    RunnableC0259a f384o = new RunnableC0259a();

    /* renamed from: p */
    boolean f385p = false;

    /* renamed from: q */
    volatile boolean f386q = false;

    /* renamed from: r */
    boolean f387r = false;

    /* renamed from: s */
    Object f388s = new Object();

    /* renamed from: t */
    AMapLocationServer f389t;

    /* renamed from: u */
    long f390u = C0331cr.m1170b();

    /* renamed from: v */
    long f391v = 0;

    /* renamed from: w */
    volatile int f392w = 0;

    /* renamed from: x */
    JSONObject f393x = null;

    /* renamed from: y */
    AMapLocation f394y;

    /* renamed from: z */
    volatile ServerSocket f395z = null;

    /* renamed from: com.amap.loc.b$a */
    /* compiled from: APSServiceCore */
    class RunnableC0259a implements Runnable {

        /* renamed from: a */
        double f396a = 0.0d;

        /* renamed from: b */
        double f397b = 0.0d;

        RunnableC0259a() {
        }

        public void run() {
            try {
                C0258b.this.m640h();
                C0258b.this.m614a((C0258b) this.f396a, this.f397b);
            } catch (Throwable th) {
                C0310c.m956a(th, "APSServiceCore", "GeoTask run");
            }
        }
    }

    /* renamed from: com.amap.loc.b$b */
    /* compiled from: APSServiceCore */
    class C0260b extends Thread {
        C0260b() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0115, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0116, code lost:
            r7.f399a.f389t = r7.f399a.m612a((com.amap.loc.C0258b) 8, (int) r0.getMessage());
            com.amap.loc.C0310c.m956a(r0, "APSServiceCore", "run part2");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x013d, code lost:
            if (r7.f399a.m635e() == false) goto L_0x013f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x013f, code lost:
            r7.f399a.m644j();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0172, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0179, code lost:
            if (r7.f399a.m635e() == false) goto L_0x017b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x017b, code lost:
            r7.f399a.m644j();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0180, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x012f A[ExcHandler: InterruptedException (e java.lang.InterruptedException), Splitter:B:0:0x0000] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            // Method dump skipped, instructions count: 433
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0258b.C0260b.run():void");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.amap.loc.b$c */
    /* compiled from: APSServiceCore */
    public class HandlerC0261c extends Handler {

        /* renamed from: a */
        C0258b f400a = null;

        /* renamed from: c */
        private String f402c = "";

        public HandlerC0261c(C0258b bVar) {
            this.f400a = bVar;
        }

        public void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        synchronized (C0258b.this.f388s) {
                            this.f400a.f388s.notify();
                        }
                        break;
                    case 1:
                        try {
                            synchronized (C0258b.this.f388s) {
                                C0258b.this.f385p = false;
                                Bundle data = message.getData();
                                Messenger messenger = message.replyTo;
                                long b = C0331cr.m1170b();
                                String string = data.getString("extraJson");
                                if (!this.f402c.equals(string)) {
                                    this.f400a.f390u = 0;
                                }
                                this.f402c = string;
                                if (C0258b.this.f389t == null || C0258b.this.f389t.getErrorCode() != 0 || b - this.f400a.f390u >= 600) {
                                    if (!C0258b.this.f378i.contains(messenger)) {
                                        C0258b.this.f378i.add(messenger);
                                    }
                                    C0258b.this.f387r = true;
                                    this.f400a.f388s.notify();
                                } else {
                                    Message obtain = Message.obtain();
                                    Bundle bundle = new Bundle();
                                    bundle.putString("locationJson", C0258b.this.f389t.toStr(1));
                                    obtain.setData(bundle);
                                    obtain.what = 1;
                                    messenger.send(obtain);
                                }
                                C0258b.this.f393x = new JSONObject(string);
                                this.f400a.m624a((C0258b) C0258b.this.f393x);
                            }
                            break;
                        } catch (Throwable th) {
                            C0310c.m956a(th, "APSServiceCore", "handleMessage LOCATION");
                            break;
                        }
                        break;
                    case 2:
                        C0258b.this.mo3715b();
                        break;
                    case 3:
                        C0258b.this.mo3716c();
                        break;
                    case 4:
                        synchronized (C0258b.this.f388s) {
                            if (C0258b.this.f357F < C0322ck.m1048b()) {
                                C0258b.this.f362K = true;
                                C0258b.m627b(C0258b.this);
                            } else {
                                C0258b.this.f362K = false;
                            }
                            this.f400a.f388s.notify();
                            C0258b.this.f376g.sendEmptyMessageDelayed(4, 2000);
                        }
                        break;
                    case 5:
                        synchronized (C0258b.this.f388s) {
                            if (C0322ck.m1065e()) {
                                C0258b.this.f363L = true;
                            } else if (!C0331cr.m1186d(C0258b.this.f370a)) {
                                C0258b.this.f363L = true;
                            }
                            this.f400a.f388s.notify();
                            C0258b.this.f376g.sendEmptyMessageDelayed(5, (long) (C0322ck.m1058d() * 1000));
                        }
                        break;
                    case 7:
                        synchronized (C0258b.this.f388s) {
                            if (!C0258b.this.f380k.contains(message.replyTo)) {
                                C0258b.this.f380k.add(message.replyTo);
                            }
                            C0258b.this.f364M = true;
                            this.f400a.f388s.notify();
                        }
                        break;
                    case 9:
                        synchronized (C0258b.this.f388s) {
                            this.f400a.f388s.notify();
                        }
                        break;
                    case 10:
                        if (C0322ck.m1095w()) {
                            Messenger messenger2 = message.replyTo;
                            if (!C0258b.this.f379j.contains(messenger2)) {
                                C0258b.this.f379j.add(messenger2);
                            }
                            Bundle data2 = message.getData();
                            double d = data2.getDouble(C1447g.f3485ae);
                            double d2 = data2.getDouble("lon");
                            C0258b.this.f384o.f396a = d;
                            C0258b.this.f384o.f397b = d2;
                            if (C0258b.this.f382m == null || C0258b.this.f382m.isDone()) {
                                if (C0258b.this.f383n == null) {
                                    C0258b.this.f382m = C0258b.this.f381l.submit(C0258b.this.f384o);
                                    break;
                                } else {
                                    float a = C0331cr.m1151a(new double[]{d, d2, C0258b.this.f383n.getLatitude(), C0258b.this.f383n.getLongitude()});
                                    if (a < ((float) (C0322ck.m1096x() * 3))) {
                                        Bundle bundle2 = new Bundle();
                                        bundle2.putString("locationJson", C0258b.this.f383n.toStr(1));
                                        bundle2.putInt("lMaxGeoDis", C0322ck.m1096x() * 3);
                                        bundle2.putInt("lMinGeoDis", C0322ck.m1096x());
                                        this.f400a.m616a((C0258b) messenger2, (Messenger) 6, (int) bundle2);
                                    }
                                    if (a > ((float) C0322ck.m1096x())) {
                                        C0258b.this.f382m = C0258b.this.f381l.submit(C0258b.this.f384o);
                                        break;
                                    }
                                }
                            }
                        } else {
                            return;
                        }
                        break;
                }
                super.handleMessage(message);
            } catch (Throwable th2) {
                C0310c.m956a(th2, "APSServiceCore", "handleMessage STARTCOLL");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.amap.loc.b$d */
    /* compiled from: APSServiceCore */
    public class C0262d extends Thread {
        C0262d() {
        }

        public void run() {
            try {
                if (!C0258b.this.f356E) {
                    C0258b.this.m642i();
                }
                if (!C0258b.this.f352A) {
                    C0258b.this.f352A = true;
                    C0258b.this.f395z = new ServerSocket(43689);
                }
                while (C0258b.this.f352A) {
                    C0258b.this.f353B = C0258b.this.f395z.accept();
                    C0258b.this.m623a((C0258b) C0258b.this.f353B);
                }
            } catch (Throwable th) {
                C0310c.m956a(th, "APSServiceCore", "run");
            }
            super.run();
        }
    }

    public C0258b(Context context) {
        this.f370a = context.getApplicationContext();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private Messenger m611a(Vector<Messenger> vector, Bundle bundle, int i) {
        Throwable th;
        Messenger messenger = null;
        if (vector == null) {
            return null;
        }
        try {
            if (vector.size() <= 0) {
                return null;
            }
            int size = vector.size();
            Messenger messenger2 = null;
            while (0 < size) {
                try {
                    Messenger messenger3 = vector.get(0);
                    m616a(messenger3, i, bundle);
                    vector.remove(0);
                    size--;
                    messenger2 = messenger3;
                } catch (Throwable th2) {
                    messenger = messenger2;
                    th = th2;
                    C0310c.m956a(th, "APSServiceCore", "reciveLoc");
                    return messenger;
                }
            }
            return messenger2;
        } catch (Throwable th3) {
            th = th3;
            C0310c.m956a(th, "APSServiceCore", "reciveLoc");
            return messenger;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private AMapLocationServer m612a(int i, String str) {
        try {
            AMapLocationServer aMapLocationServer = new AMapLocationServer("");
            aMapLocationServer.setErrorCode(i);
            aMapLocationServer.setLocationDetail(str);
            return aMapLocationServer;
        } catch (Throwable th) {
            C0310c.m956a(th, "APSServiceCore", "newInstanceAMapLoc");
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private void m614a(double d, double d2) {
        if (this.f367P != null) {
            this.f383n = this.f367P.mo3780a(d, d2);
            Bundle bundle = new Bundle();
            bundle.putString("locationJson", this.f383n.toStr(1));
            bundle.putInt("lMaxGeoDis", C0322ck.m1096x() * 3);
            bundle.putInt("lMinGeoDis", C0322ck.m1096x());
            m611a(this.f379j, bundle, 6);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private void m615a(Messenger messenger) {
        try {
            if (C0322ck.m1061d(this.f370a)) {
                if (messenger == null && !this.f378i.isEmpty()) {
                    messenger = this.f378i.get(0);
                }
                if (messenger != null) {
                    Message obtain = Message.obtain();
                    obtain.what = 100;
                    messenger.send(obtain);
                }
            }
            if (C0322ck.m1044a(this.f366O) && !this.f360I && this.f389t != null && (this.f392w == 2 || this.f392w == 4)) {
                this.f361J = true;
                this.f360I = true;
            }
            if (C0322ck.m1043a() && !this.f358G) {
                this.f358G = true;
                this.f376g.sendEmptyMessage(4);
            }
            if (C0322ck.m1056c() && C0322ck.m1058d() > 2 && !this.f359H) {
                this.f359H = true;
                this.f376g.sendEmptyMessage(5);
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "APSServiceCore", "checkConfig");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private void m616a(Messenger messenger, int i, Bundle bundle) {
        Message obtain = Message.obtain();
        obtain.setData(bundle);
        obtain.what = i;
        try {
            messenger.send(obtain);
        } catch (Throwable th) {
            C0310c.m956a(th, "APSServiceCore", "sendMessage");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private void m623a(Socket socket) {
        BufferedReader bufferedReader;
        String[] split;
        String[] split2;
        String[] split3;
        String str = null;
        if (socket != null) {
            int i = 30000;
            String str2 = "jsonp1";
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null && readLine.length() > 0 && (split = readLine.split(" ")) != null && split.length > 1 && (split2 = split[1].split("\\?")) != null && split2.length > 1 && (split3 = split2[1].split("&")) != null && split3.length > 0) {
                        int i2 = 30000;
                        String str3 = str2;
                        for (String str4 : split3) {
                            try {
                                String[] split4 = str4.split(SimpleComparison.EQUAL_TO_OPERATION);
                                if (split4 != null && split4.length > 1) {
                                    if ("to".equals(split4[0])) {
                                        i2 = Integer.parseInt(split4[1]);
                                    }
                                    if ("callback".equals(split4[0])) {
                                        str3 = split4[1];
                                    }
                                }
                            } catch (Throwable th) {
                                str2 = str3;
                                th = th;
                                try {
                                    str = str2 + "&&" + str2 + "({'package':'" + this.f374e + "','error_code':1,'error':'params error'})";
                                    C0310c.m956a(th, "APSServiceCore", "invoke part2");
                                    try {
                                        PrintStream printStream = new PrintStream(socket.getOutputStream(), true, "UTF-8");
                                        printStream.println("HTTP/1.0 200 OK");
                                        printStream.println("Content-Length:" + str.getBytes("UTF-8").length);
                                        printStream.println();
                                        printStream.println(str);
                                        printStream.close();
                                        try {
                                            bufferedReader.close();
                                            socket.close();
                                        } catch (Throwable th2) {
                                            C0310c.m956a(th2, "APSServiceCore", "invoke part4");
                                            return;
                                        }
                                    } catch (Throwable th3) {
                                        C0310c.m956a(th3, "APSServiceCore", "invoke part4");
                                        return;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    try {
                                        PrintStream printStream2 = new PrintStream(socket.getOutputStream(), true, "UTF-8");
                                        printStream2.println("HTTP/1.0 200 OK");
                                        printStream2.println("Content-Length:" + str.getBytes("UTF-8").length);
                                        printStream2.println();
                                        printStream2.println(str);
                                        printStream2.close();
                                        try {
                                            bufferedReader.close();
                                            socket.close();
                                        } catch (Throwable th5) {
                                            C0310c.m956a(th5, "APSServiceCore", "invoke part4");
                                        }
                                    } catch (Throwable th6) {
                                        C0310c.m956a(th6, "APSServiceCore", "invoke part4");
                                    }
                                    throw th;
                                }
                            }
                        }
                        i = i2;
                        str2 = str3;
                    }
                    int i3 = C0310c.f629e;
                    C0310c.f629e = i;
                    long currentTimeMillis = System.currentTimeMillis();
                    if ((this.f394y == null || currentTimeMillis - this.f394y.getTime() > 5000) && !C0331cr.m1186d(this.f370a)) {
                        try {
                            this.f394y = this.f367P.mo3779a();
                            if (this.f394y.getErrorCode() != 0) {
                                str = str2 + "&&" + str2 + "({'package':'" + this.f374e + "','error_code':" + this.f394y.getErrorCode() + ",'error':'" + this.f394y.getErrorInfo() + "'})";
                            }
                        } catch (Throwable th7) {
                            C0310c.m956a(th7, "APSServiceCore", "invoke part1");
                        } finally {
                            C0310c.f629e = i3;
                        }
                    }
                    if (str == null) {
                        if (this.f394y == null) {
                            str = str2 + "&&" + str2 + "({'package':'" + this.f374e + "','error_code':8,'error':'unknown error'})";
                        } else {
                            AMapLocation aMapLocation = this.f394y;
                            str = str2 + "&&" + str2 + "({'package':'" + this.f374e + "','error_code':0,'error':'','location':{'y':" + aMapLocation.getLatitude() + ",'precision':" + aMapLocation.getAccuracy() + ",'x':" + aMapLocation.getLongitude() + "},'version_code':'" + "3.0.0" + "','version':'" + "3.0.0" + "'})";
                        }
                        if (C0331cr.m1186d(this.f370a)) {
                            str = str2 + "&&" + str2 + "({'package':'" + this.f374e + "','error_code':36,'error':'app is background'})";
                        }
                    }
                    try {
                        PrintStream printStream3 = new PrintStream(socket.getOutputStream(), true, "UTF-8");
                        printStream3.println("HTTP/1.0 200 OK");
                        printStream3.println("Content-Length:" + str.getBytes("UTF-8").length);
                        printStream3.println();
                        printStream3.println(str);
                        printStream3.close();
                        try {
                            bufferedReader.close();
                            socket.close();
                        } catch (Throwable th8) {
                            C0310c.m956a(th8, "APSServiceCore", "invoke part4");
                        }
                    } catch (Throwable th9) {
                        C0310c.m956a(th9, "APSServiceCore", "invoke part4");
                    }
                } catch (Throwable th10) {
                    th = th10;
                    str = str2 + "&&" + str2 + "({'package':'" + this.f374e + "','error_code':1,'error':'params error'})";
                    C0310c.m956a(th, "APSServiceCore", "invoke part2");
                    PrintStream printStream4 = new PrintStream(socket.getOutputStream(), true, "UTF-8");
                    printStream4.println("HTTP/1.0 200 OK");
                    printStream4.println("Content-Length:" + str.getBytes("UTF-8").length);
                    printStream4.println();
                    printStream4.println(str);
                    printStream4.close();
                    bufferedReader.close();
                    socket.close();
                }
            } catch (Throwable th11) {
                th = th11;
                bufferedReader = null;
                PrintStream printStream22 = new PrintStream(socket.getOutputStream(), true, "UTF-8");
                printStream22.println("HTTP/1.0 200 OK");
                printStream22.println("Content-Length:" + str.getBytes("UTF-8").length);
                printStream22.println();
                printStream22.println(str);
                printStream22.close();
                bufferedReader.close();
                socket.close();
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private void m624a(JSONObject jSONObject) {
        try {
            if (this.f367P != null) {
                this.f367P.mo3784a(jSONObject);
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "APSServiceCore", "setExtra");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private void m625a(boolean z, Context context) {
        try {
            this.f367P.mo3785a(z, context);
        } catch (Throwable th) {
        }
    }

    /* renamed from: b */
    static /* synthetic */ int m627b(C0258b bVar) {
        int i = bVar.f357F;
        bVar.f357F = i + 1;
        return i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: d */
    private void m631d() {
        if (this.f361J) {
            this.f366O = C0331cr.m1170b();
            this.f361J = false;
            this.f367P.mo3789b();
        }
        if (this.f362K) {
            this.f362K = false;
            this.f367P.mo3789b();
        }
        if (this.f363L) {
            this.f363L = false;
            this.f367P.mo3789b();
        }
        if (this.f364M && C0322ck.m1046a(this.f370a, this.f365N)) {
            this.f365N = C0331cr.m1156a();
            this.f364M = false;
            this.f367P.mo3789b();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: e */
    private boolean m635e() {
        boolean z;
        synchronized (this.f388s) {
            z = this.f386q;
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: f */
    private AMapLocationServer m637f() throws Throwable {
        return this.f367P.mo3779a();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: g */
    private void m639g() {
        try {
            this.f367P.mo3793c(this.f370a);
            if (C0322ck.m1088p()) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("ngpsAble", C0322ck.m1089q());
                m611a(this.f380k, bundle, 7);
                C0322ck.m1042a(false);
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "APSServiceCore", "initAuth");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: h */
    private void m640h() {
        try {
            if (!this.f356E) {
                m642i();
            }
        } catch (Throwable th) {
            this.f368Q = false;
            this.f369R = th.getMessage();
            C0310c.m956a(th, "APSServiceCore", "init");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: i */
    private void m642i() {
        try {
            C0310c.m953a(this.f370a);
            if (this.f393x == null) {
                this.f393x = C0310c.m952a((AMapLocationClientOption) null, this.f370a);
            }
            this.f356E = true;
            this.f367P.mo3784a(this.f393x);
            this.f367P.mo3790b(this.f370a);
        } catch (Throwable th) {
            this.f369R = th.getMessage();
            this.f368Q = false;
            C0310c.m956a(th, "APSServiceCore", "doInit");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: j */
    private void m644j() {
        try {
            mo3716c();
            if (this.f382m != null) {
                this.f382m.cancel(true);
            }
            this.f356E = false;
            this.f358G = false;
            this.f359H = false;
            this.f357F = 0;
            this.f367P.mo3792c();
            this.f378i.clear();
            this.f379j.clear();
            this.f380k.clear();
            C0371w.m1392a();
            if (this.f371b) {
                Process.killProcess(Process.myPid());
            }
            if (this.f376g != null) {
                this.f376g.removeCallbacksAndMessages(null);
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "APSServiceCore", "threadDestroy");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: k */
    private void m646k() {
        try {
            if (this.f367P != null) {
                this.f367P.mo3799i();
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "APSServiceCore", "startColl");
        }
    }

    /* renamed from: a */
    public Handler mo3714a() {
        return this.f376g;
    }

    /* renamed from: b */
    public synchronized void mo3715b() {
        try {
            if (!this.f354C) {
                this.f355D = new C0262d();
                this.f355D.start();
                this.f354C = true;
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "APSServiceCore", "startSocket");
        }
        return;
    }

    /* renamed from: c */
    public synchronized void mo3716c() {
        try {
            if (this.f395z != null) {
                this.f395z.close();
            }
            if (this.f353B != null) {
                this.f353B.close();
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "APSServiceCore", "stopScocket");
        }
        this.f395z = null;
        this.f355D = null;
        this.f354C = false;
        this.f352A = false;
    }

    @Override // com.amap.api.location.APSServiceBase
    public IBinder onBind(Intent intent) {
        String stringExtra = intent.getStringExtra("a");
        if (!TextUtils.isEmpty(stringExtra)) {
            C0343j.m1239a(stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("b");
        this.f385p = "true".equals(intent.getStringExtra("as"));
        if (this.f385p && this.f376g != null) {
            this.f376g.sendEmptyMessageDelayed(9, 100);
        }
        C0342i.m1229a(stringExtra2);
        this.f375f = new Messenger(mo3714a());
        return this.f375f.getBinder();
    }

    @Override // com.amap.api.location.APSServiceBase
    public void onCreate() {
        try {
            this.f367P = new C0292br();
            this.f374e = this.f370a.getApplicationContext().getPackageName();
            this.f386q = true;
            this.f377h = new C0260b();
            this.f377h.setName("serviceThread");
            this.f377h.start();
        } catch (Throwable th) {
            C0310c.m956a(th, "APSServiceCore", "onCreate");
        }
    }

    @Override // com.amap.api.location.APSServiceBase
    public void onDestroy() {
        try {
            synchronized (this.f388s) {
                this.f386q = false;
                this.f388s.notify();
            }
        } catch (Throwable th) {
            C0310c.m956a(th, "APSServiceCore", "onDestroy");
        }
    }

    @Override // com.amap.api.location.APSServiceBase
    public int onStartCommand(Intent intent, int i, int i2) {
        return 0;
    }
}
