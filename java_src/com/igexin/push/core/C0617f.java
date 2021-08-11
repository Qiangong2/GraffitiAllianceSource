package com.igexin.push.core;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.support.p007v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.igexin.assist.sdk.AssistPushManager;
import com.igexin.p012b.p013a.p015b.AbstractC0455b;
import com.igexin.p012b.p013a.p015b.AbstractC0458e;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p013a.p020d.AbstractC0470d;
import com.igexin.p012b.p013a.p020d.C0471e;
import com.igexin.p012b.p013a.p020d.p021a.AbstractC0462a;
import com.igexin.p012b.p013a.p020d.p021a.AbstractC0463b;
import com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e;
import com.igexin.p012b.p022b.C0476a;
import com.igexin.push.config.C0504a;
import com.igexin.push.config.C0512i;
import com.igexin.push.config.C0514k;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.core.p029b.C0561af;
import com.igexin.push.core.p029b.C0563b;
import com.igexin.push.core.p029b.C0565d;
import com.igexin.push.core.p029b.C0568g;
import com.igexin.push.extension.C0672a;
import com.igexin.push.p023a.p024a.C0477a;
import com.igexin.push.p023a.p024a.C0478b;
import com.igexin.push.p023a.p024a.C0479c;
import com.igexin.push.p023a.p024a.C0480d;
import com.igexin.push.p025b.C0482a;
import com.igexin.push.p025b.C0483b;
import com.igexin.push.p026c.C0494i;
import com.igexin.push.p032d.C0629a;
import com.igexin.push.p032d.p033a.C0631b;
import com.igexin.push.p036e.C0661a;
import com.igexin.push.p036e.C0663c;
import com.igexin.push.p036e.C0670j;
import com.igexin.push.p079f.p081b.AbstractC1150h;
import com.igexin.push.p079f.p081b.C1143a;
import com.igexin.push.p079f.p081b.C1145c;
import com.igexin.push.p079f.p081b.C1149g;
import com.igexin.push.util.C1151a;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.p082a.C1172b;
import com.igexin.sdk.p082a.C1173c;
import com.igexin.sdk.p082a.C1174d;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.igexin.push.core.f */
public class C0617f implements AbstractC0463b {

    /* renamed from: l */
    private static C0617f f1561l;

    /* renamed from: a */
    private Context f1562a;

    /* renamed from: b */
    private C0619h f1563b = new C0619h();

    /* renamed from: c */
    private Handler f1564c;

    /* renamed from: d */
    private ConcurrentLinkedQueue<Message> f1565d = new ConcurrentLinkedQueue<>();

    /* renamed from: e */
    private C0535e f1566e;

    /* renamed from: f */
    private ConnectivityManager f1567f;

    /* renamed from: g */
    private C0456c f1568g;

    /* renamed from: h */
    private AbstractC0455b f1569h;

    /* renamed from: i */
    private C0670j f1570i;

    /* renamed from: j */
    private C0663c f1571j;

    /* renamed from: k */
    private C0483b f1572k;

    /* renamed from: m */
    private final int f1573m = 100;

    /* renamed from: n */
    private final int f1574n = 30;

    /* renamed from: o */
    private final AtomicBoolean f1575o = new AtomicBoolean(false);

    private C0617f() {
    }

    /* renamed from: a */
    public static C0617f m2395a() {
        if (f1561l == null) {
            f1561l = new C0617f();
        }
        return f1561l;
    }

    /* renamed from: q */
    private void m2396q() {
        ServiceInfo[] serviceInfoArr;
        try {
            if (C0514k.f1323o && mo4635p()) {
                String packageName = this.f1562a.getPackageName();
                List<PackageInfo> installedPackages = this.f1562a.getPackageManager().getInstalledPackages(4);
                if (!(installedPackages == null || installedPackages.isEmpty())) {
                    for (PackageInfo packageInfo : installedPackages) {
                        if (((packageInfo.applicationInfo.flags & 1) == 0 || (packageInfo.applicationInfo.flags & 128) != 0) && (serviceInfoArr = packageInfo.services) != null && serviceInfoArr.length != 0) {
                            int length = serviceInfoArr.length;
                            int i = 0;
                            while (true) {
                                if (i >= length) {
                                    break;
                                }
                                ServiceInfo serviceInfo = serviceInfoArr[i];
                                if (!C1151a.m4741a(serviceInfo, packageInfo)) {
                                    i++;
                                } else if (!packageName.equals(packageInfo.packageName)) {
                                    C0568g.m2192a().mo4454d().put(packageInfo.packageName, serviceInfo.name);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: r */
    private boolean m2397r() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        intentFilter.addAction("com.igexin.sdk.action.snlrefresh");
        intentFilter.addAction("com.igexin.sdk.action.snlretire");
        intentFilter.addAction(C0618g.f1596U);
        intentFilter.addAction("com.igexin.sdk.action.execute");
        intentFilter.addAction("com.igexin.sdk.action.doaction");
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        if (C1151a.m4750c()) {
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        }
        if (this.f1562a.registerReceiver(C0625n.m2443a(), intentFilter) == null) {
            ActivityC0460a.m1698b("CoreLogic|InternalPublicReceiver|Failed");
        }
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addDataScheme("package");
        intentFilter2.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter2.addAction("android.intent.action.PACKAGE_REMOVED");
        if (this.f1562a.registerReceiver(C0624m.m2442a(), intentFilter2) != null) {
            return true;
        }
        ActivityC0460a.m1698b("CoreLogic|InternalPackageReceiver|Failed");
        return true;
    }

    /* renamed from: a */
    public void mo4616a(HandlerC0616e eVar) {
        this.f1564c = eVar;
    }

    /* renamed from: a */
    public boolean mo4617a(Context context) {
        this.f1562a = context;
        if (this.f1563b != null && this.f1563b.isAlive()) {
            ActivityC0460a.m1698b("CoreLogic|coreThread is alive +++++");
        } else if (!this.f1575o.getAndSet(true)) {
            ActivityC0460a.m1698b("CoreLogic|start coreThread +++++");
            this.f1563b.start();
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo4618a(Message message) {
        if (C0618g.f1636g.get()) {
            this.f1564c.sendMessage(message);
            return true;
        }
        this.f1565d.add(message);
        return true;
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0463b
    /* renamed from: a */
    public boolean mo4177a(AbstractC0466e eVar, C0471e eVar2) {
        return this.f1566e != null && this.f1566e.mo4351a(eVar);
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0463b
    /* renamed from: a */
    public boolean mo4178a(AbstractC0470d dVar, C0471e eVar) {
        return this.f1566e != null && this.f1566e.mo4350a(dVar);
    }

    /* renamed from: a */
    public boolean mo4619a(AbstractC1150h hVar) {
        return hVar != null && C0456c.m1661b().mo4216a(hVar, false, true);
    }

    /* renamed from: a */
    public boolean mo4620a(String str) {
        String d = C0535e.m2034a().mo4399d("ss");
        if (!(C0618g.f1635f == null || this.f1571j == null)) {
            new C1174d(C0618g.f1635f).mo5971b();
            C0618g.f1638i = false;
            C0618g.f1642m = false;
            C0661a aVar = new C0661a();
            aVar.mo4702a(EnumC0602c.stop);
            this.f1571j.mo4719a(aVar);
            if (d != null && "1".equals(d)) {
                try {
                    InputStream inputStream = Runtime.getRuntime().exec("ps").getInputStream();
                    if (inputStream != null) {
                        String packageName = C0618g.f1635f.getPackageName();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            String[] split = readLine.split("\\s+");
                            if (readLine.contains(packageName + "/files/gdaemon") && split.length > 0) {
                                Process.killProcess(Integer.valueOf(split[1]).intValue());
                                break;
                            }
                        }
                        bufferedReader.close();
                        inputStream.close();
                    }
                } catch (Exception e) {
                }
                mo4626e();
            }
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo4621a(boolean z) {
        ActivityC0460a.m1698b("CoreLogic|start sdkSwitch isSlave = " + z);
        if (!(C0618g.f1635f == null || this.f1571j == null)) {
            new C1174d(C0618g.f1635f).mo5970a();
            C0618g.f1638i = true;
            if (!new C1172b(C0618g.f1635f).mo5966b()) {
                new C1173c(C0618g.f1635f).mo5967a();
                C0618g.f1639j = true;
                new C1172b(C0618g.f1635f).mo5965a();
            }
            if (z) {
                new C1173c(C0618g.f1635f).mo5967a();
                C0618g.f1639j = true;
            }
            ActivityC0460a.m1698b("CoreLogic|snlCoordinator.doEvent start ++++");
            C0661a aVar = new C0661a();
            aVar.mo4702a(EnumC0602c.start);
            this.f1571j.mo4719a(aVar);
        }
        return true;
    }

    /* renamed from: b */
    public void mo4622b() {
        try {
            this.f1567f = (ConnectivityManager) this.f1562a.getSystemService("connectivity");
            C0618g.m2425a(this.f1562a);
            this.f1572k = new C0483b(this.f1562a);
            C0512i.m1962a().mo4349b();
            m2397r();
            this.f1568g = C0456c.m1661b();
            this.f1568g.mo4167a((AbstractC0462a<String, Integer, AbstractC0455b, AbstractC0458e>) new C0629a(this.f1562a, mo4631j()));
            this.f1568g.mo4213a((AbstractC0463b) this);
            this.f1568g.mo4212a(this.f1562a);
            C0482a aVar = new C0482a();
            aVar.mo4252a(C0568g.m2192a());
            aVar.mo4252a(C0565d.m2181a());
            aVar.mo4252a(C0563b.m2172a());
            aVar.mo4252a(C0504a.m1940a());
            aVar.mo4252a(C0561af.m2162a());
            this.f1568g.mo4216a(aVar, true, false);
            C0456c.m1661b().mo4168a(C0476a.m1775a(C0618g.f1576A.getBytes()));
            C0618g.f1609ae = this.f1568g.mo4216a(C1145c.m4710g(), false, true);
            C0618g.f1610af = this.f1568g.mo4216a(C1149g.m4727g(), true, true);
            C0494i.m1834a().mo4279c();
            mo4624c();
            this.f1566e = C0535e.m2034a();
            mo4625d();
            this.f1570i = new C0670j();
            this.f1570i.mo4738a(this.f1562a, this.f1568g, this.f1566e);
            this.f1571j = new C0663c();
            this.f1571j.mo4717a(this.f1562a);
            C0661a aVar2 = new C0661a();
            aVar2.mo4702a(EnumC0602c.start);
            this.f1571j.mo4719a(aVar2);
            C0479c.m1784c().mo4250d();
            C0618g.f1636g.set(true);
            this.f1566e.mo4362a(Process.myPid());
            m2396q();
            C0672a.m2607a().mo4745b();
            Iterator<Message> it = this.f1565d.iterator();
            while (it.hasNext()) {
                Message next = it.next();
                if (this.f1564c != null) {
                    this.f1564c.sendMessage(next);
                }
            }
            C0535e.m2034a().mo4417s();
            try {
                AssistPushManager.getInstance().initialize(C0618g.f1635f);
                AssistPushManager.getInstance().register(C0618g.f1635f);
            } catch (Throwable th) {
            }
        } catch (Throwable th2) {
            ActivityC0460a.m1698b("CoreLogic|init|failed|" + th2.toString());
        }
    }

    /* renamed from: b */
    public boolean mo4623b(String str) {
        if (C0618g.f1635f == null || this.f1571j == null) {
            return true;
        }
        new C1173c(C0618g.f1635f).mo5968b();
        C0618g.f1639j = false;
        C0618g.f1642m = false;
        C0661a aVar = new C0661a();
        aVar.mo4702a(EnumC0602c.stop);
        this.f1571j.mo4719a(aVar);
        return true;
    }

    /* renamed from: c */
    public C1143a mo4624c() {
        C1143a g = C1143a.m4702g();
        g.mo5898a(new C0477a());
        g.mo5898a(new C0478b());
        g.mo5898a(new C0480d());
        g.mo5898a(C0479c.m1784c());
        C0618g.f1611ag = this.f1568g.mo4216a(g, false, true);
        try {
            this.f1562a.sendBroadcast(new Intent());
        } catch (Throwable th) {
        }
        return g;
    }

    /* renamed from: d */
    public void mo4625d() {
        if (TextUtils.isEmpty(C0618g.f1652w)) {
            try {
                if (C1151a.m4738a()) {
                    WifiInfo connectionInfo = ((WifiManager) this.f1562a.getSystemService("wifi")).getConnectionInfo();
                    if (connectionInfo != null) {
                        C0568g.m2192a().mo4441a(connectionInfo.getMacAddress());
                    }
                    ActivityC0460a.m1698b("CoreLogic mac:" + C0618g.f1652w);
                }
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: e */
    public void mo4626e() {
        this.f1562a.stopService(new Intent(this.f1562a, C0535e.m2034a().mo4360a(C0618g.f1635f)));
    }

    /* renamed from: f */
    public AbstractC0455b mo4627f() {
        if (this.f1569h == null) {
            this.f1569h = C0631b.m2455a();
        }
        return this.f1569h;
    }

    /* renamed from: g */
    public C0670j mo4628g() {
        return this.f1570i;
    }

    /* renamed from: h */
    public C0663c mo4629h() {
        return this.f1571j;
    }

    /* renamed from: i */
    public C0535e mo4630i() {
        return this.f1566e;
    }

    /* renamed from: j */
    public ConnectivityManager mo4631j() {
        return this.f1567f;
    }

    /* renamed from: k */
    public C0483b mo4632k() {
        return this.f1572k;
    }

    /* renamed from: l */
    public void mo4633l() {
        try {
            this.f1562a.unregisterReceiver(C0456c.m1661b());
        } catch (Exception e) {
        }
        try {
            this.f1562a.unregisterReceiver(C0624m.m2442a());
        } catch (Exception e2) {
        }
        try {
            this.f1562a.unregisterReceiver(C0625n.m2443a());
        } catch (Exception e3) {
        }
        try {
            C0672a.m2607a().mo4746c();
        } catch (Throwable th) {
        }
    }

    /* renamed from: m */
    public String mo4634m() {
        NetworkInfo activeNetworkInfo;
        if (this.f1567f == null || (activeNetworkInfo = this.f1567f.getActiveNetworkInfo()) == null) {
            return null;
        }
        if (activeNetworkInfo.getType() == 1) {
            return "wifi";
        }
        if (activeNetworkInfo.getType() == 0) {
            return "mobile";
        }
        return null;
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0463b
    /* renamed from: n */
    public boolean mo4179n() {
        return true;
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0463b
    /* renamed from: o */
    public long mo4180o() {
        return 94808;
    }

    /* renamed from: p */
    public boolean mo4635p() {
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) C0618g.f1635f.getSystemService("activity")).getMemoryInfo(memoryInfo);
            long j = (memoryInfo.availMem / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            if (memoryInfo.lowMemory) {
                ActivityC0460a.m1699b("CoreLogic", "system in lowMemory, available menmory = " + j + "M");
                return false;
            } else if (j < 100) {
                return false;
            } else {
                return (((Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory()) + Runtime.getRuntime().freeMemory()) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID > 30;
            }
        } catch (Throwable th) {
            return false;
        }
    }
}
