package com.igexin.push.extension.distribution.gbd.p061a.p064c;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.NeighboringCellInfo;
import com.igexin.push.core.C0618g;
import com.igexin.push.extension.distribution.gbd.p066b.C1060c;
import com.igexin.push.extension.distribution.gbd.p066b.C1062e;
import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p068d.C1071b;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1080b;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.extension.distribution.gbd.p076i.C1116e;
import com.igexin.sdk.PushBuildConfig;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.igexin.push.extension.distribution.gbd.a.c.f */
public class C1045f {

    /* renamed from: a */
    protected static int f2668a = 0;

    /* renamed from: b */
    protected static int f2669b = -1;

    /* renamed from: c */
    protected static int f2670c = -2;

    /* renamed from: d */
    protected static int f2671d = -3;

    /* renamed from: e */
    protected static int f2672e = -4;

    /* renamed from: f */
    protected static int f2673f = -5;

    /* renamed from: g */
    protected static int f2674g = -6;

    /* renamed from: h */
    protected static int f2675h = -7;

    /* renamed from: i */
    protected static int f2676i = -8;

    /* renamed from: j */
    protected static int f2677j = -9;

    /* renamed from: k */
    private static C1045f f2678k;

    /* renamed from: l */
    private Context f2679l;

    /* renamed from: m */
    private final Object f2680m = new Object();

    /* renamed from: n */
    private C1043d f2681n;

    /* renamed from: o */
    private C1040a f2682o;

    /* renamed from: p */
    private C1054o f2683p;

    /* renamed from: q */
    private long f2684q;

    /* renamed from: r */
    private float f2685r;

    private C1045f(Context context) {
        try {
            this.f2679l = context;
            this.f2681n = new C1043d(context);
            this.f2681n.mo5701a(this);
            this.f2683p = new C1054o(context);
            this.f2683p.mo5719a(this);
            try {
                if (C1067a.f2763N) {
                    Class.forName("android.bluetooth.BluetoothManager");
                    Class.forName("android.bluetooth.BluetoothAdapter");
                    this.f2682o = new C1040a(context);
                    this.f2682o.mo5695a(this);
                }
            } catch (ClassNotFoundException e) {
                C1115d.m4558a(e);
            }
        } catch (Exception e2) {
            C1115d.m4558a(e2);
        }
    }

    /* renamed from: a */
    public static C1045f m4230a() {
        if (f2678k == null) {
            f2678k = new C1045f(C1069c.f2824a);
        }
        return f2678k;
    }

    /* renamed from: a */
    private String m4232a(ScanResult scanResult) {
        if (scanResult == null) {
            return "";
        }
        String replace = scanResult.SSID.replace("|", "").replace(MqttTopic.MULTI_LEVEL_WILDCARD, "").replace(MiPushClient.ACCEPT_TIME_SEPARATOR, "");
        long j = 0;
        if (Build.VERSION.SDK_INT >= 17) {
            j = C1116e.m4607k() - (((SystemClock.elapsedRealtimeNanos() / 1000) / 1000) - (scanResult.timestamp / 1000));
        }
        return replace + MqttTopic.MULTI_LEVEL_WILDCARD + scanResult.BSSID + MqttTopic.MULTI_LEVEL_WILDCARD + scanResult.level + MqttTopic.MULTI_LEVEL_WILDCARD + scanResult.capabilities + MqttTopic.MULTI_LEVEL_WILDCARD + j;
    }

    /* renamed from: a */
    private String m4233a(C1060c cVar) {
        StringBuilder sb = new StringBuilder();
        if (cVar == null) {
            sb.append(0);
            sb.append("|");
            sb.append(0);
            sb.append("|");
            sb.append(0);
            sb.append("|");
            sb.append(0);
            sb.append("|");
        } else {
            sb.append(cVar.mo5735a());
            sb.append("|");
            sb.append(cVar.mo5738b());
            sb.append("|");
            sb.append(cVar.mo5740c());
            sb.append("|");
            sb.append(cVar.mo5742d());
            sb.append("|");
            List<NeighboringCellInfo> e = cVar.mo5744e();
            int i = 0;
            while (e != null && i < e.size()) {
                sb.append(e.get(i).getCid());
                if (i < e.size() - 1) {
                    sb.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
                }
                i++;
            }
        }
        sb.append("|");
        return sb.toString();
    }

    /* renamed from: a */
    private void m4234a(String str) {
        C1080b.m4391a().mo5812a(str, mo5708b());
        C1115d.m4559b("GBD_RLA", "saveRALData: type = " + mo5708b());
    }

    /* renamed from: b */
    private String m4236b(Location location) {
        StringBuilder sb = new StringBuilder();
        if (location == null) {
            sb.append(PushBuildConfig.sdk_conf_debug_level);
            sb.append("|");
            sb.append("0");
            sb.append("|");
            sb.append("0");
            sb.append("|");
            sb.append("0");
            sb.append("|");
            this.f2684q = 0;
            this.f2685r = 0.0f;
        } else {
            sb.append(location.getProvider());
            sb.append("|");
            sb.append(location.getLongitude());
            sb.append("|");
            sb.append(location.getLatitude());
            sb.append("|");
            sb.append(location.getAltitude());
            sb.append("|");
            if (Build.VERSION.SDK_INT >= 17) {
                this.f2684q = (((location.getElapsedRealtimeNanos() - SystemClock.elapsedRealtimeNanos()) / 1000) / 1000) + C1116e.m4607k();
            } else {
                this.f2684q = location.getTime() + C1069c.f2823E;
            }
            this.f2685r = location.getAccuracy();
        }
        return sb.toString();
    }

    /* renamed from: b */
    private String m4237b(List<C1062e> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                C1062e eVar = list.get(i);
                sb.append(eVar.mo5751a()).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(eVar.mo5754b()).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(eVar.mo5756c()).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(eVar.mo5760e()).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(eVar.mo5758d());
                if (i < list.size() - 1) {
                    sb.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
                }
            }
        }
        sb.append("|");
        return sb.toString();
    }

    /* renamed from: b */
    private String m4238b(List<ScanResult> list, Location location, C1060c cVar, List<C1062e> list2, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(C1116e.m4607k())));
        sb.append("|");
        sb.append(C0618g.f1647r);
        sb.append("|");
        sb.append(C0618g.f1602a);
        sb.append("|");
        String b = m4236b(location);
        String a = m4233a(cVar);
        String c = m4240c(list);
        String b2 = m4237b(list2);
        sb.append(b);
        sb.append(a);
        sb.append(c);
        sb.append(b2);
        sb.append(i);
        sb.append("|");
        sb.append(m4241d());
        sb.append("|");
        sb.append(m4242e());
        sb.append("|");
        sb.append(this.f2684q);
        sb.append("|");
        sb.append(this.f2685r);
        sb.append("|");
        sb.append("|");
        sb.append("ANDROID");
        return sb.toString();
    }

    /* renamed from: c */
    private String m4240c(List<ScanResult> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                sb.append(m4232a(list.get(i)));
                if (i < list.size() - 1) {
                    sb.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
                }
            }
        }
        sb.append("|");
        return sb.toString();
    }

    /* renamed from: d */
    private int m4241d() {
        try {
            Intent registerReceiver = this.f2679l.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver == null || registerReceiver.getExtras() == null) {
                return 0;
            }
            switch (registerReceiver.getExtras().getInt("status")) {
                case 1:
                default:
                    return 0;
                case 2:
                    return 2;
                case 3:
                case 4:
                    return 1;
                case 5:
                    return 3;
            }
        } catch (Exception e) {
            C1115d.m4558a(e);
            return 0;
        }
    }

    /* renamed from: e */
    private int m4242e() {
        try {
            Intent registerReceiver = this.f2679l.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver == null || registerReceiver.getExtras() == null) {
                return 0;
            }
            switch (registerReceiver.getExtras().getInt("plugged")) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                default:
                    return 0;
                case 4:
                    return 3;
            }
        } catch (Exception e) {
            C1115d.m4558a(e);
            return 0;
        }
    }

    /* renamed from: a */
    public void mo5703a(int i) {
        try {
            boolean e = C1071b.m4348a().mo5797e();
            C1115d.m4559b("GBD_RLA", "doSample checkSafeStatus = " + e);
            if (e) {
                new C1046g(this, i).start();
                return;
            }
            this.f2683p.f2707a = EnumC1047h.SCAN_END;
            if (this.f2682o != null) {
                this.f2682o.f2648a = EnumC1047h.SCAN_END;
            }
            if (i == 12) {
                mo5707a(null, null, null, null, f2671d);
            } else {
                mo5707a(null, null, null, null, f2670c);
            }
        } catch (Exception e2) {
            C1115d.m4558a(e2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5704a(Location location) {
        String b = m4238b(C1069c.f2829f ? C1069c.f2827d.getScanResults() : null, location, this.f2681n.mo5700a(), this.f2682o != null ? this.f2682o.mo5697c() : null, f2668a);
        if (b != null) {
            m4234a(b);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5705a(List<C1062e> list) {
        if (C0618g.f1647r != null && this.f2683p.f2707a == EnumC1047h.SCAN_END) {
            Location a = this.f2681n.mo5699a(false);
            C1060c a2 = this.f2681n.mo5700a();
            List<ScanResult> a3 = this.f2683p.mo5717a();
            if (a != null || (!(a2 == null || a2.mo5742d() == 0) || ((a3 != null && !a3.isEmpty()) || (list != null && !list.isEmpty())))) {
                String b = m4238b(a3, a, a2, list, this.f2683p.mo5720b());
                if (b != null) {
                    m4234a(b);
                    return;
                }
                return;
            }
            mo5707a(null, null, null, null, f2669b);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5706a(List<ScanResult> list, int i) {
        if (C0618g.f1647r != null) {
            if (this.f2682o == null || this.f2682o.f2648a == EnumC1047h.SCAN_END) {
                Location a = this.f2681n.mo5699a(false);
                C1060c a2 = this.f2681n.mo5700a();
                ArrayList<C1062e> c = this.f2682o != null ? this.f2682o.mo5697c() : null;
                if (a != null || (!(a2 == null || a2.mo5742d() == 0) || (list != null && !list.isEmpty()))) {
                    String b = m4238b(list, a, a2, c, i);
                    if (b != null) {
                        m4234a(b);
                        return;
                    }
                    return;
                }
                mo5707a(null, null, null, null, f2669b);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5707a(List<ScanResult> list, Location location, C1060c cVar, List<C1062e> list2, int i) {
        String b;
        if (C0618g.f1647r != null && (b = m4238b(list, location, cVar, list2, i)) != null) {
            m4234a(b);
        }
    }

    /* renamed from: b */
    public int mo5708b() {
        return 11;
    }

    /* renamed from: c */
    public String mo5709c() {
        return "* * * * *";
    }
}
