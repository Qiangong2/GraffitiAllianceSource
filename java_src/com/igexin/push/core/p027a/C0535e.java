package com.igexin.push.core.p027a;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.assist.sdk.AssistPushManager;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p013a.p015b.p016a.p017a.C0444d;
import com.igexin.p012b.p013a.p015b.p016a.p017a.C0451k;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p013a.p020d.AbstractC0470d;
import com.igexin.push.config.C0504a;
import com.igexin.push.config.C0514k;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.C0519a;
import com.igexin.push.core.C0617f;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.C0620i;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.EnumC0622k;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.C0596i;
import com.igexin.push.core.bean.C0600m;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.p028a.AbstractC0521a;
import com.igexin.push.core.p027a.p028a.C0522b;
import com.igexin.push.core.p027a.p028a.C0523c;
import com.igexin.push.core.p027a.p028a.C0524d;
import com.igexin.push.core.p027a.p028a.C0525e;
import com.igexin.push.core.p027a.p028a.C0526f;
import com.igexin.push.core.p027a.p028a.C0527g;
import com.igexin.push.core.p027a.p028a.C0528h;
import com.igexin.push.core.p027a.p028a.C0529i;
import com.igexin.push.core.p027a.p028a.C0530j;
import com.igexin.push.core.p029b.C0561af;
import com.igexin.push.core.p029b.C0565d;
import com.igexin.push.core.p029b.C0568g;
import com.igexin.push.core.p030c.C0603a;
import com.igexin.push.core.p030c.C0604b;
import com.igexin.push.core.p030c.C0605c;
import com.igexin.push.core.p030c.C0610h;
import com.igexin.push.core.p030c.C0611i;
import com.igexin.push.extension.C0672a;
import com.igexin.push.extension.stub.IPushExtension;
import com.igexin.push.p023a.p024a.C0479c;
import com.igexin.push.p026c.C0486a;
import com.igexin.push.p026c.C0494i;
import com.igexin.push.p032d.C0632b;
import com.igexin.push.p032d.p033a.C0631b;
import com.igexin.push.p032d.p034b.C0633a;
import com.igexin.push.p032d.p034b.C0634b;
import com.igexin.push.p032d.p034b.C0635c;
import com.igexin.push.p032d.p034b.C0636d;
import com.igexin.push.p032d.p035c.AbstractC0642e;
import com.igexin.push.p032d.p035c.C0638a;
import com.igexin.push.p032d.p035c.C0640c;
import com.igexin.push.p032d.p035c.C0641d;
import com.igexin.push.p032d.p035c.C0643f;
import com.igexin.push.p032d.p035c.C0645h;
import com.igexin.push.p032d.p035c.C0646i;
import com.igexin.push.p032d.p035c.C0647j;
import com.igexin.push.p032d.p035c.C0648k;
import com.igexin.push.p032d.p035c.C0650m;
import com.igexin.push.p032d.p035c.C0652o;
import com.igexin.push.p032d.p035c.C0654q;
import com.igexin.push.p036e.AbstractC0671k;
import com.igexin.push.p036e.C0670j;
import com.igexin.push.p079f.p080a.C1138a;
import com.igexin.push.p079f.p080a.C1140c;
import com.igexin.push.p079f.p080a.C1142e;
import com.igexin.push.p079f.p081b.C1144b;
import com.igexin.push.p079f.p081b.C1145c;
import com.igexin.push.p079f.p081b.C1149g;
import com.igexin.push.util.C1151a;
import com.igexin.push.util.C1159i;
import com.igexin.push.util.C1168r;
import com.igexin.push.util.EncryptUtils;
import com.igexin.sdk.GTServiceManager;
import com.igexin.sdk.PushBuildConfig;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.message.FeedbackCmdMessage;
import com.igexin.sdk.message.GTTransmitMessage;
import com.igexin.sdk.message.SetTagCmdMessage;
import com.umeng.analytics.C1370a;
import com.umeng.analytics.p091b.C1447g;
import java.io.File;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.e */
public class C0535e extends AbstractC0520a implements AbstractC0671k {

    /* renamed from: a */
    private static Map<Integer, AbstractC0520a> f1363a;

    /* renamed from: b */
    private static Map<String, AbstractC0521a> f1364b;

    /* renamed from: c */
    private static C0535e f1365c;

    /* renamed from: d */
    private boolean f1366d;

    /* renamed from: e */
    private AtomicBoolean f1367e = new AtomicBoolean(false);

    /* renamed from: f */
    private long f1368f;

    private C0535e() {
        f1363a = new HashMap();
        f1363a.put(0, new C0541k());
        f1363a.put(5, new C0543m());
        f1363a.put(37, new C0546p());
        f1363a.put(9, new C0550t());
        f1363a.put(26, new C0540j());
        f1363a.put(28, new C0534d());
        f1363a.put(97, new C0542l());
        f1364b = new HashMap();
        f1364b.put("goto", new C0526f());
        f1364b.put("notification", new C0527g());
        f1364b.put("startapp", new C0529i());
        f1364b.put("null", new C0525e());
        f1364b.put("wakeupsdk", new C0530j());
        f1364b.put("startweb", new C0528h());
        f1364b.put("checkapp", new C0522b());
        f1364b.put("enablelog", new C0524d());
        f1364b.put("disablelog", new C0523c());
    }

    /* renamed from: C */
    private void m2030C() {
        if (C0618g.f1641l) {
            C0618g.f1641l = false;
            ActivityC0460a.m1698b("CoreAction|broadcast online state = offline");
            mo4410l();
        }
        C0486a e = C0494i.m1834a().mo4281e();
        C0620i.m2432a().mo4638a(EnumC0622k.NETWORK_ERROR);
        e.mo4272i();
        if (mo4359B()) {
            ActivityC0460a.m1698b("CoreAction|sdkOn = false or pushOn = false, disconect|user");
        } else {
            ActivityC0460a.m1698b("CoreAction|disconnect|network");
        }
        C0456c.m1661b().mo4217a(C0451k.class);
    }

    /* renamed from: D */
    private void m2031D() {
        boolean z = false;
        C0620i.m2432a().mo4638a(EnumC0622k.NETWORK_SWITCH);
        ConnectivityManager j = C0617f.m2395a().mo4631j();
        if (j != null) {
            NetworkInfo activeNetworkInfo = j.getActiveNetworkInfo();
            C0618g.f1637h = activeNetworkInfo != null && activeNetworkInfo.isAvailable();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                ActivityC0460a.m1698b("CoreAction|type = " + (type == 0 ? "mobile" : type == 1 ? "wifi" : PushBuildConfig.sdk_conf_debug_level));
            }
        } else {
            C0618g.f1637h = false;
        }
        ActivityC0460a.m1698b("CoreAction|network changed, available = " + C0618g.f1637h);
        if (!C0618g.f1641l || !C0618g.f1637h) {
            C0632b.m2464a().mo4672b();
            ActivityC0460a.m1698b("CoreAction|network changed, disconnect +++");
            C0617f.m2395a().mo4630i().mo4404f();
            if (C0618g.f1637h) {
                if (!C0494i.m1834a().mo4281e().mo4273j()) {
                    ActivityC0460a.m1698b("CoreAction|network changed, domain = backup or trynormal");
                } else {
                    z = C0494i.m1834a().mo4282f();
                }
            }
            if (z) {
                ActivityC0460a.m1698b("CoreAction|detect result  = true, reconnect will run after detect");
            } else {
                C0444d.m1594a().mo4143a(true);
            }
        } else {
            ActivityC0460a.m1698b("CoreAction|network changed, online = true, networkAvailable = true");
            if (System.currentTimeMillis() - C0618g.f1591P > 5000) {
                ActivityC0460a.m1698b("CoreAction|network changed, online = true, networkAvailable = true, send heart beat ....");
                C0618g.f1591P = System.currentTimeMillis();
                if (mo4405g() == -2) {
                    C0618g.f1641l = false;
                    mo4410l();
                }
            }
        }
        if (mo4418t()) {
            ActivityC0460a.m1698b("CoreAction|network changed check condition status");
            mo4417s();
        }
    }

    @TargetApi(12)
    /* renamed from: E */
    private Intent m2032E() {
        Intent intent = new Intent();
        if (Build.VERSION.SDK_INT >= 12) {
            intent.addFlags(32);
        }
        intent.setAction("com.igexin.sdk.action." + C0618g.f1602a);
        return intent;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0134  */
    /* renamed from: F */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m2033F() {
        /*
        // Method dump skipped, instructions count: 316
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.p027a.C0535e.m2033F():boolean");
    }

    /* renamed from: a */
    public static C0535e m2034a() {
        if (f1365c == null) {
            f1365c = new C0535e();
        }
        return f1365c;
    }

    /* renamed from: a */
    private void m2035a(int i, String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(i));
        C0617f.m2395a().mo4632k().mo4255a("message", contentValues, new String[]{"taskid"}, new String[]{str});
    }

    /* renamed from: a */
    private void m2037a(C0640c cVar, PushTaskBean pushTaskBean, String str, String str2) {
        cVar.mo4690a(new C1144b(pushTaskBean, str, C1168r.m4794a()));
        C0618g.f1615ak.put(str2, cVar);
    }

    /* renamed from: a */
    private void m2038a(String str, String str2, String str3, byte[] bArr) {
        Intent intent = new Intent();
        if (Build.VERSION.SDK_INT >= 12) {
            intent.addFlags(32);
        }
        intent.setAction("com.igexin.sdk.action." + str3);
        Bundle bundle = new Bundle();
        bundle.putInt(PushConsts.CMD_ACTION, PushConsts.GET_MSG_DATA);
        bundle.putString("taskid", str);
        bundle.putString("messageid", str2);
        bundle.putString("appid", str3);
        bundle.putString("payloadid", str2 + ":" + str);
        bundle.putString("packagename", C0618g.f1634e);
        bundle.putByteArray(AssistPushConsts.MSG_TYPE_PAYLOAD, bArr);
        intent.putExtras(bundle);
        C0618g.f1635f.sendBroadcast(intent);
    }

    /* renamed from: a */
    private void m2039a(List<C0600m> list) {
        C0538h hVar = new C0538h(this);
        PackageManager packageManager = C0618g.f1635f.getPackageManager();
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
        for (int i = 0; i < installedPackages.size(); i++) {
            try {
                PackageInfo packageInfo = installedPackages.get(i);
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if ((applicationInfo.flags & 1) <= 0) {
                    C0600m mVar = new C0600m();
                    mVar.mo4572b(applicationInfo.loadLabel(packageManager).toString());
                    mVar.mo4576d(applicationInfo.packageName);
                    mVar.mo4574c(String.valueOf(packageInfo.versionCode));
                    mVar.mo4570a(packageInfo.versionName);
                    list.add(mVar);
                }
            } catch (Exception e) {
            }
        }
        Collections.sort(list, hVar);
    }

    /* renamed from: a */
    public static boolean m2040a(long j) {
        Date date = new Date(j);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int i = instance.get(11);
        int i2 = C0514k.f1309a + C0514k.f1310b;
        if (i2 >= 24) {
            i2 -= 24;
        }
        if (C0514k.f1310b == 0) {
            return false;
        }
        if (C0514k.f1309a < i2) {
            if (i >= C0514k.f1309a && i < i2) {
                return true;
            }
        } else if (C0514k.f1309a > i2) {
            if (i >= 0 && i < i2) {
                return true;
            }
            if (i >= C0514k.f1309a && i < 24) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m2041b(JSONObject jSONObject, PushTaskBean pushTaskBean) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("condition");
            HashMap hashMap = new HashMap();
            if (jSONObject2.has("wifi")) {
                hashMap.put("wifi", jSONObject2.getString("wifi"));
            }
            if (jSONObject2.has("screenOn")) {
                hashMap.put("screenOn", jSONObject2.getString("screenOn"));
            }
            if (jSONObject2.has("ssid")) {
                hashMap.put("ssid", jSONObject2.getString("ssid"));
                if (jSONObject2.has("bssid")) {
                    hashMap.put("bssid", jSONObject2.getString("bssid"));
                }
            }
            if (jSONObject2.has("duration")) {
                String string = jSONObject2.getString("duration");
                if (string.contains("-")) {
                    int indexOf = string.indexOf("-");
                    String substring = string.substring(0, indexOf);
                    String substring2 = string.substring(indexOf + 1, string.length());
                    hashMap.put("startTime", substring);
                    hashMap.put("endTime", substring2);
                }
            }
            pushTaskBean.setConditionMap(hashMap);
        } catch (Exception e) {
        }
    }

    /* renamed from: e */
    private void m2042e(Intent intent) {
        String stringExtra = intent.getStringExtra("taskid");
        String stringExtra2 = intent.getStringExtra("messageid");
        String stringExtra3 = intent.getStringExtra("actionid");
        String stringExtra4 = intent.getStringExtra("accesstoken");
        int intExtra = intent.getIntExtra("notifID", 0);
        NotificationManager notificationManager = (NotificationManager) C0618g.f1635f.getSystemService("notification");
        if (intExtra != 0) {
            notificationManager.cancel(intExtra);
        } else if (C0618g.f1613ai.get(stringExtra) != null) {
            notificationManager.cancel(C0618g.f1613ai.get(stringExtra).intValue());
        }
        if (stringExtra4.equals(C0618g.f1622ar)) {
            mo4391b(stringExtra, stringExtra2, stringExtra3);
        }
    }

    /* renamed from: e */
    private void m2043e(String str) {
        if (str != null && str.startsWith("package:")) {
            String substring = str.substring(8);
            if (C0568g.m2192a().mo4454d().containsKey(substring)) {
                C0568g.m2192a().mo4454d().remove(substring);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m2044e(String str, String str2) {
        try {
            Intent intent = new Intent();
            intent.setPackage(str);
            intent.setAction("com.igexin.sdk.action.service.message");
            if (C1151a.m4740a(intent, C0618g.f1635f)) {
                C0618g.f1635f.startService(intent);
                ActivityC0460a.m1698b("CoreAction|startService by action");
                return;
            }
            Intent intent2 = new Intent();
            intent2.setClassName(str, str2);
            C0618g.f1635f.startService(intent2);
            ActivityC0460a.m1698b("CoreAction|startService by service name");
        } catch (Throwable th) {
            ActivityC0460a.m1698b("CoreAction|startService pkgName = " + str + " srvName = " + str2 + ", exception : " + th.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2045f(android.content.Intent r12) {
        /*
        // Method dump skipped, instructions count: 222
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.p027a.C0535e.m2045f(android.content.Intent):void");
    }

    /* renamed from: f */
    private void m2046f(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("package:")) {
            try {
                String substring = str.substring(8);
                PackageInfo packageInfo = C0618g.f1635f.getPackageManager().getPackageInfo(substring, 4);
                if (!(packageInfo == null || packageInfo.services == null)) {
                    ServiceInfo[] serviceInfoArr = packageInfo.services;
                    for (ServiceInfo serviceInfo : serviceInfoArr) {
                        if (C1151a.m4741a(serviceInfo, packageInfo)) {
                            C0568g.m2192a().mo4454d().put(substring, serviceInfo.name);
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: f */
    private void m2047f(boolean z) {
        C0631b.f1681b = -1;
        if (!EncryptUtils.isLoadSuccess()) {
            ActivityC0460a.m1698b("CoreAction|so error ++++++++");
        } else if (C0618g.f1629ay) {
            C0617f.m2395a().mo4628g().mo4744c(z);
        } else {
            ActivityC0460a.m1698b("CoreAction|autoReconnect CoreRuntimeInfo.initSuccess = false");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0057 A[SYNTHETIC, Splitter:B:19:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0063 A[SYNTHETIC, Splitter:B:25:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2048g(java.lang.String r6) {
        /*
        // Method dump skipped, instructions count: 112
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.p027a.C0535e.m2048g(java.lang.String):void");
    }

    /* renamed from: A */
    public void mo4358A() {
        if (!C0618g.f1609ae) {
            C0618g.f1609ae = C0456c.m1661b().mo4216a(C1145c.m4710g(), false, true);
        }
        if (!C0618g.f1610af) {
            C0618g.f1610af = C0456c.m1661b().mo4216a(C1149g.m4727g(), true, true);
        }
        if (!C0618g.f1611ag) {
            C0617f.m2395a().mo4624c();
        }
    }

    /* renamed from: B */
    public boolean mo4359B() {
        return !C0618g.f1638i || !C0618g.f1639j;
    }

    /* renamed from: a */
    public Class mo4360a(Context context) {
        return GTServiceManager.getInstance().getUserPushService(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0460  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0469  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String mo4361a(boolean r13, int r14) {
        /*
        // Method dump skipped, instructions count: 1141
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.p027a.C0535e.mo4361a(boolean, int):java.lang.String");
    }

    /* renamed from: a */
    public void mo4362a(int i) {
        if (C0618g.f1635f != null) {
            try {
                Class b = mo4382b(C0618g.f1635f);
                if (b != null) {
                    Intent intent = new Intent(C0618g.f1635f, b);
                    Bundle bundle = new Bundle();
                    bundle.putInt(PushConsts.CMD_ACTION, PushConsts.GET_SDKSERVICEPID);
                    bundle.putInt(PushConsts.KEY_SERVICE_PIT, i);
                    intent.putExtras(bundle);
                    C0618g.f1635f.startService(intent);
                }
            } catch (Throwable th) {
                ActivityC0460a.m1698b("CoreAction|" + th.toString());
            }
            Intent E = m2032E();
            Bundle bundle2 = new Bundle();
            bundle2.putInt(PushConsts.CMD_ACTION, PushConsts.GET_SDKSERVICEPID);
            bundle2.putInt(PushConsts.KEY_SERVICE_PIT, i);
            E.putExtras(bundle2);
            C0618g.f1635f.sendBroadcast(E);
        }
    }

    /* renamed from: a */
    public void mo4363a(int i, int i2, String str) {
        C0514k.f1309a = i;
        C0514k.f1310b = i2;
        C0504a.m1940a().mo4341b();
        C0479c.m1784c().mo4250d();
    }

    /* renamed from: a */
    public void mo4364a(int i, String str) {
        C0514k.f1312d = i;
        C0504a.m1940a().mo4344c();
        if (C0618g.f1641l) {
            ActivityC0460a.m1698b("setHeartbeatInterval heartbeatReq");
            if (System.currentTimeMillis() - C0618g.f1591P > 5000) {
                C0618g.f1591P = System.currentTimeMillis();
                mo4405g();
            }
        }
    }

    /* renamed from: a */
    public void mo4365a(Intent intent) {
        ActivityC0460a.m1698b("CoreAction|onServiceInitialize ##");
        if (intent != null) {
            C0617f.m2395a().mo4621a(false);
            if (intent.hasExtra("op_app")) {
                C0618g.f1578C = intent.getStringExtra("op_app");
            } else {
                C0618g.f1578C = "";
            }
            C0618g.f1642m = false;
            if (C0618g.f1641l) {
                mo4409k();
                C0618g.f1642m = true;
            }
            if (GTServiceManager.getInstance().isUserPushServiceSet(C0618g.f1635f) && C0618g.f1607ac != null) {
                C0456c.m1661b().mo4216a(new C0536f(this), false, true);
            }
        }
    }

    /* renamed from: a */
    public void mo4366a(Bundle bundle) {
        String string = bundle.getString(PushConsts.CMD_ACTION);
        if (!TextUtils.isEmpty(string)) {
            if (string.equals("setTag")) {
                if (C0514k.f1317i) {
                    mo4372a(bundle.getString("tags"), bundle.getString("sn"));
                }
            } else if (string.equals("setSilentTime")) {
                if (C0514k.f1318j) {
                    int i = bundle.getInt("beginHour", 0);
                    int i2 = bundle.getInt("duration", 0);
                    mo4363a(i, i2, C0618g.f1635f.getPackageName());
                    AssistPushManager.getInstance().setSilentTime(C0618g.f1635f, i, i2);
                }
            } else if (string.equals("sendMessage")) {
                ActivityC0460a.m1698b("CoreAction onPushManagerMessage recevie action : sendMessage");
                if (C0514k.f1316h) {
                    String string2 = bundle.getString("taskid");
                    byte[] byteArray = bundle.getByteArray("extraData");
                    ActivityC0460a.m1698b("CoreAction receive broadcast msg data , task id : " + string2 + " ######@##@@@#");
                    mo4376a(string2, byteArray);
                }
            } else if (string.equals("stopService")) {
                C0617f.m2395a().mo4620a(C0618g.f1635f.getPackageName());
            } else if (string.equals("setHeartbeatInterval")) {
                if (C0514k.f1319k) {
                    mo4364a(bundle.getInt(C1447g.f3496ap, 0), C0618g.f1635f.getPackageName());
                }
            } else if (string.equals("setSocketTimeout")) {
                if (C0514k.f1320l) {
                    mo4384b(bundle.getInt("timeout", 0), C0618g.f1635f.getPackageName());
                }
            } else if (string.equals("sendFeedbackMessage")) {
                if (C0514k.f1325q && C0618g.f1617am <= 200) {
                    String string3 = bundle.getString("taskid");
                    String string4 = bundle.getString("messageid");
                    String string5 = bundle.getString("actionid");
                    String str = string3 + ":" + string4 + ":" + string5;
                    if (C0618g.f1616al.get(str) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        PushTaskBean pushTaskBean = new PushTaskBean();
                        pushTaskBean.setTaskId(string3);
                        pushTaskBean.setMessageId(string4);
                        pushTaskBean.setAppid(C0618g.f1602a);
                        pushTaskBean.setAppKey(C0618g.f1631b);
                        mo4368a(pushTaskBean, string5);
                        C0618g.f1617am++;
                        C0618g.f1616al.put(str, Long.valueOf(currentTimeMillis));
                    }
                }
            } else if (string.equals("turnOffPush")) {
                C0617f.m2395a().mo4623b(C0618g.f1635f.getPackageName());
                AssistPushManager.getInstance().turnOffPush(C0618g.f1635f);
            } else if (string.equals("bindAlias")) {
                String string6 = bundle.getString("alias");
                ActivityC0460a.m1698b("CoreAction|onPushManagerMessage bindAlias...");
                mo4387b(string6);
            } else if (string.equals("unbindAlias")) {
                String string7 = bundle.getString("alias");
                boolean z = bundle.getBoolean("isSeft");
                ActivityC0460a.m1698b("CoreAction|onPushManagerMessage unbindAlias...");
                mo4375a(string7, z);
            }
        }
    }

    /* renamed from: a */
    public void mo4367a(PushTaskBean pushTaskBean) {
        C0640c cVar = new C0640c();
        cVar.mo4688a();
        cVar.f1710c = "RCV" + pushTaskBean.getMessageId();
        cVar.f1711d = C0618g.f1647r;
        cVar.f1708a = (int) System.currentTimeMillis();
        C0617f.m2395a().mo4628g().mo4736a("C-" + C0618g.f1647r, cVar);
        ActivityC0460a.m1698b("CoreAction|cdnreceive " + pushTaskBean.getTaskId() + "|" + pushTaskBean.getMessageId());
    }

    /* renamed from: a */
    public void mo4368a(PushTaskBean pushTaskBean, String str) {
        if (pushTaskBean.isCDNType()) {
            mo4386b(pushTaskBean, str);
        } else {
            mo4369a(pushTaskBean, str, "ok");
        }
    }

    /* renamed from: a */
    public void mo4369a(PushTaskBean pushTaskBean, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PushConsts.CMD_ACTION, "pushmessage_feedback");
            jSONObject.put("appid", pushTaskBean.getAppid());
            jSONObject.put("id", String.valueOf(currentTimeMillis));
            jSONObject.put(C1447g.f3463a, pushTaskBean.getAppKey());
            jSONObject.put("messageid", pushTaskBean.getMessageId());
            jSONObject.put("taskid", pushTaskBean.getTaskId());
            jSONObject.put("actionid", str);
            jSONObject.put("result", str2);
            jSONObject.put("timestamp", String.valueOf(System.currentTimeMillis()));
        } catch (Exception e) {
        }
        String jSONObject2 = jSONObject.toString();
        C0641d dVar = new C0641d();
        dVar.mo4693a();
        dVar.f1715a = (int) currentTimeMillis;
        dVar.f1718d = "17258000";
        dVar.f1719e = jSONObject2;
        dVar.f1721g = C0618g.f1647r;
        C0617f.m2395a().mo4628g().mo4736a("C-" + C0618g.f1647r, dVar);
        C0565d a = C0565d.m2181a();
        if (a != null) {
            a.mo4436a(new C0596i(currentTimeMillis, jSONObject2, (byte) 3, currentTimeMillis));
        }
        ActivityC0460a.m1698b("feedback|" + pushTaskBean.getTaskId() + "|" + pushTaskBean.getMessageId() + "|" + str);
    }

    /* renamed from: a */
    public void mo4370a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PushConsts.CMD_ACTION, "received");
            jSONObject.put("id", str);
        } catch (JSONException e) {
        }
        String jSONObject2 = jSONObject.toString();
        C0641d dVar = new C0641d();
        dVar.mo4693a();
        dVar.f1715a = (int) System.currentTimeMillis();
        dVar.f1718d = "17258000";
        dVar.f1719e = jSONObject2;
        dVar.f1721g = C0618g.f1647r;
        C0617f.m2395a().mo4628g().mo4736a("C-" + C0618g.f1647r, dVar);
    }

    /* renamed from: a */
    public void mo4371a(String str, C0638a aVar, PushTaskBean pushTaskBean) {
        C0456c.m1661b().mo4216a(new C1138a(new C0605c(str, aVar, pushTaskBean)), false, true);
    }

    /* renamed from: a */
    public void mo4372a(String str, String str2) {
        if (!TextUtils.isEmpty(C0618g.f1647r)) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(PushConsts.CMD_ACTION, "set_tag");
                    jSONObject.put("id", String.valueOf(currentTimeMillis));
                    jSONObject.put("cid", C0618g.f1647r);
                    jSONObject.put("appid", C0618g.f1602a);
                    jSONObject.put("tags", URLEncoder.encode(str, "utf-8"));
                    jSONObject.put("sn", str2);
                } catch (Exception e) {
                }
                String jSONObject2 = jSONObject.toString();
                C0565d a = C0565d.m2181a();
                if (a != null) {
                    a.mo4436a(new C0596i(currentTimeMillis, jSONObject2, (byte) 2, currentTimeMillis));
                }
                C0641d dVar = new C0641d();
                dVar.mo4693a();
                dVar.f1718d = "17258000";
                dVar.f1719e = jSONObject2;
                C0456c.m1661b().mo4163a(SDKUrlConfig.getCmAddress(), 3, C0617f.m2395a().mo4627f(), dVar, false);
                ActivityC0460a.m1698b("settag");
            } catch (Exception e2) {
            }
        }
    }

    @TargetApi(12)
    /* renamed from: a */
    public void mo4373a(String str, String str2, String str3, String str4) {
        if (C0618g.f1635f != null) {
            ActivityC0460a.m1698b("startapp|broadcastPayload");
            byte[] bArr = null;
            if (str4 != null) {
                bArr = str4.getBytes();
            } else {
                PushTaskBean pushTaskBean = C0618g.f1612ah.get(mo4393c(str, str2));
                if (pushTaskBean != null) {
                    bArr = pushTaskBean.getMsgExtra();
                }
            }
            if (bArr != null) {
                ActivityC0460a.m1698b("startapp|broadcast|payload = " + new String(bArr));
            } else {
                ActivityC0460a.m1698b("startapp|broadcast|payload is empty!");
            }
            try {
                Class b = mo4382b(C0618g.f1635f);
                if (!(b == null || C0618g.f1602a == null || !C0618g.f1602a.equals(str3))) {
                    Intent intent = new Intent(C0618g.f1635f, b);
                    Bundle bundle = new Bundle();
                    bundle.putInt(PushConsts.CMD_ACTION, PushConsts.GET_MSG_DATA);
                    bundle.putSerializable(PushConsts.KEY_MESSAGE_DATA, new GTTransmitMessage(str, str2, str2 + ":" + str, bArr));
                    intent.putExtras(bundle);
                    C0618g.f1635f.startService(intent);
                }
            } catch (Throwable th) {
                ActivityC0460a.m1698b("CoreAction|" + th.toString());
            }
            m2038a(str, str2, str3, bArr);
        }
    }

    /* renamed from: a */
    public void mo4374a(String str, String str2, String str3, String str4, long j) {
        if (C0618g.f1635f != null) {
            try {
                Class b = mo4382b(C0618g.f1635f);
                if (!(b == null || C0618g.f1602a == null || !C0618g.f1602a.equals(str))) {
                    Intent intent = new Intent(C0618g.f1635f, b);
                    Bundle bundle = new Bundle();
                    bundle.putInt(PushConsts.CMD_ACTION, PushConsts.KEY_CMD_RESULT);
                    bundle.putSerializable(PushConsts.KEY_CMD_MSG, new FeedbackCmdMessage(str2, str3, str4, j, PushConsts.THIRDPART_FEEDBACK));
                    intent.putExtras(bundle);
                    C0618g.f1635f.startService(intent);
                }
            } catch (Throwable th) {
                ActivityC0460a.m1698b("CoreAction|" + th.toString());
            }
            Intent E = m2032E();
            Bundle bundle2 = new Bundle();
            bundle2.putInt(PushConsts.CMD_ACTION, PushConsts.THIRDPART_FEEDBACK);
            bundle2.putString("appid", str);
            bundle2.putString("taskid", str2);
            bundle2.putString("actionid", str3);
            bundle2.putString("result", str4);
            bundle2.putLong("timestamp", j);
            E.putExtras(bundle2);
            C0618g.f1635f.sendBroadcast(E);
        }
    }

    /* renamed from: a */
    public void mo4375a(String str, boolean z) {
        if (!z || !TextUtils.isEmpty(C0618g.f1647r)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - C0618g.f1593R > 5000) {
                String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(currentTimeMillis));
                if (!format.equals(C0618g.f1592Q)) {
                    C0568g.m2192a().mo4461f(format);
                    C0568g.m2192a().mo4439a(0);
                }
                if (C0618g.f1594S < 100) {
                    C0618g.f1593R = currentTimeMillis;
                    C0568g.m2192a().mo4439a(C0618g.f1594S + 1);
                    C0456c.m1661b().mo4216a(new C1142e(new C0610h(SDKUrlConfig.getAmpServiceUrl(), str, z)), false, true);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo4376a(String str, byte[] bArr) {
        if (C0618g.f1647r != null) {
            JSONObject jSONObject = new JSONObject();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                jSONObject.put(PushConsts.CMD_ACTION, "sendmessage");
                jSONObject.put("id", String.valueOf(currentTimeMillis));
                jSONObject.put("cid", C0618g.f1647r);
                jSONObject.put("appid", C0618g.f1602a);
                jSONObject.put("taskid", str);
                jSONObject.put("extraData", C1159i.m4780b(bArr, 0));
                String jSONObject2 = jSONObject.toString();
                C0565d.m2181a().mo4436a(new C0596i(currentTimeMillis, jSONObject2, (byte) 6, currentTimeMillis));
                C0641d dVar = new C0641d();
                dVar.mo4693a();
                dVar.f1715a = (int) currentTimeMillis;
                dVar.f1718d = C0618g.f1647r;
                dVar.f1719e = jSONObject2;
                dVar.f1720f = bArr;
                dVar.f1721g = C0618g.f1647r;
                C0617f.m2395a().mo4628g().mo4736a("C-" + C0618g.f1647r, dVar);
                if (str != null && str.startsWith("4T5@S_")) {
                    ActivityC0460a.m1698b("CoreAction sending lbs report message : " + jSONObject2);
                }
            } catch (Throwable th) {
                ActivityC0460a.m1698b("CoreAction|" + th.toString());
            }
        }
    }

    @Override // com.igexin.push.p036e.AbstractC0671k
    /* renamed from: a */
    public void mo4377a(boolean z) {
    }

    @Override // com.igexin.push.core.p027a.AbstractC0520a
    /* renamed from: a */
    public boolean mo4350a(AbstractC0470d dVar) {
        return false;
    }

    @Override // com.igexin.push.p036e.AbstractC0671k
    /* renamed from: a */
    public boolean mo4378a(AbstractC0642e eVar) {
        if (eVar == null) {
            return false;
        }
        AbstractC0520a aVar = f1363a.get(Integer.valueOf(eVar.f1723i));
        if ((eVar instanceof C0647j) || (eVar instanceof C0650m) || (eVar instanceof C0652o) || (eVar instanceof C0654q) || (eVar instanceof C0645h)) {
            ActivityC0460a.m1698b("CoreAction|receive : " + eVar.getClass().getName() + " resp ~~~~");
            C0444d.m1594a().mo4142a(eVar.getClass().getName());
        }
        if ((eVar instanceof C0650m) || (eVar instanceof C0652o) || (eVar instanceof C0654q)) {
            C0618g.f1579D = 0;
            C0494i.m1834a().mo4281e().mo4264b();
        }
        if (aVar != null) {
            aVar.mo4351a(eVar);
        }
        C1145c.m4710g().mo5899h();
        return true;
    }

    @Override // com.igexin.push.core.p027a.AbstractC0520a
    /* renamed from: a */
    public boolean mo4351a(Object obj) {
        C0670j g = C0617f.m2395a().mo4628g();
        if ((obj instanceof AbstractC0642e) && g != null) {
            g.mo4739a((AbstractC0642e) obj);
        } else if (obj instanceof C0633a) {
            C0444d.m1594a().mo4143a(false);
        } else if (obj instanceof C0634b) {
            ActivityC0460a.m1698b("CoreAction|ReconnectCheckNotifyType ###");
            C0444d.m1594a().mo4143a(((C0634b) obj).mo4678a());
        } else if (obj instanceof C0636d) {
            m2030C();
        } else if (obj instanceof C0635c) {
            ActivityC0460a.m1698b("CoreAction|ReconnectNotifyType ###");
            m2047f(((C0635c) obj).mo4679a());
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo4379a(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("taskid", str);
        bundle.putString("messageid", str2);
        bundle.putString("actionid", str3);
        Message message = new Message();
        message.what = C0519a.f1343g;
        message.obj = bundle;
        return C0617f.m2395a().mo4618a(message);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0094 A[Catch:{ Throwable -> 0x00c6 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo4380a(org.json.JSONObject r11, com.igexin.push.core.bean.PushTaskBean r12) {
        /*
        // Method dump skipped, instructions count: 241
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.p027a.C0535e.mo4380a(org.json.JSONObject, com.igexin.push.core.bean.PushTaskBean):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0211  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo4381a(org.json.JSONObject r13, byte[] r14, boolean r15) {
        /*
        // Method dump skipped, instructions count: 575
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.p027a.C0535e.mo4381a(org.json.JSONObject, byte[], boolean):boolean");
    }

    /* renamed from: b */
    public Class mo4382b(Context context) {
        return GTServiceManager.getInstance().getUserIntentService(context);
    }

    @Override // com.igexin.push.p036e.AbstractC0671k
    /* renamed from: b */
    public void mo4383b() {
        mo4397d();
    }

    /* renamed from: b */
    public void mo4384b(int i, String str) {
        C0514k.f1313e = i;
        C0504a.m1940a().mo4346d();
    }

    /* renamed from: b */
    public void mo4385b(Intent intent) {
        if (intent != null && intent.hasExtra("isSlave")) {
            boolean booleanExtra = intent.getBooleanExtra("isSlave", false);
            ActivityC0460a.m1698b("CoreAction|onServiceInitializeForSlave isSlave =" + booleanExtra);
            if (booleanExtra) {
                C0617f.m2395a().mo4621a(true);
                if (intent.hasExtra("op_app")) {
                    C0618g.f1578C = intent.getStringExtra("op_app");
                } else {
                    C0618g.f1578C = "";
                }
                if (C0618g.f1641l) {
                    mo4409k();
                }
            }
        }
    }

    /* renamed from: b */
    public void mo4386b(PushTaskBean pushTaskBean, String str) {
        if (pushTaskBean != null && !TextUtils.isEmpty(pushTaskBean.getMessageId())) {
            String str2 = pushTaskBean.getMessageId() + "|" + str;
            if (C0618g.f1615ak.containsKey(str2)) {
                C0640c cVar = C0618g.f1615ak.get(str2);
                if (cVar.mo4691c() < 2) {
                    C0617f.m2395a().mo4628g().mo4736a("C-" + C0618g.f1647r, cVar);
                    cVar.mo4689a(cVar.mo4691c() + 1);
                    m2037a(cVar, pushTaskBean, str, str2);
                }
            } else {
                C0640c cVar2 = new C0640c();
                long currentTimeMillis = System.currentTimeMillis();
                cVar2.mo4688a();
                cVar2.f1710c = "FDB" + pushTaskBean.getMessageId() + "|" + pushTaskBean.getTaskId() + "|" + str + "|" + "ok" + "|" + currentTimeMillis;
                cVar2.f1711d = C0618g.f1647r;
                cVar2.f1708a = (int) currentTimeMillis;
                C0617f.m2395a().mo4628g().mo4736a("C-" + C0618g.f1647r, cVar2);
                m2037a(cVar2, pushTaskBean, str, str2);
            }
            ActivityC0460a.m1698b("cdnfeedback|" + pushTaskBean.getTaskId() + "|" + pushTaskBean.getMessageId() + "|" + str);
        }
    }

    /* renamed from: b */
    public void mo4387b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - C0618g.f1593R > 5000) {
            String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(currentTimeMillis));
            if (!format.equals(C0618g.f1592Q)) {
                C0568g.m2192a().mo4461f(format);
                C0568g.m2192a().mo4439a(0);
            }
            ActivityC0460a.m1698b("-> CoreRuntimeInfo.opAliasTimes:" + C0618g.f1594S);
            if (C0618g.f1594S < 100) {
                ActivityC0460a.m1698b("requestService bindAlias HttpTask url : " + SDKUrlConfig.getAmpServiceUrl());
                C0618g.f1593R = currentTimeMillis;
                C0568g.m2192a().mo4439a(C0618g.f1594S + 1);
                C0456c.m1661b().mo4216a(new C1142e(new C0604b(SDKUrlConfig.getAmpServiceUrl(), str)), false, true);
            }
        }
    }

    /* renamed from: b */
    public void mo4388b(String str, String str2) {
        if (C0618g.f1635f != null) {
            try {
                Class b = mo4382b(C0618g.f1635f);
                if (b != null) {
                    Intent intent = new Intent(C0618g.f1635f, b);
                    Bundle bundle = new Bundle();
                    bundle.putInt(PushConsts.CMD_ACTION, PushConsts.KEY_CMD_RESULT);
                    bundle.putSerializable(PushConsts.KEY_CMD_MSG, new SetTagCmdMessage(str, str2, PushConsts.SET_TAG_RESULT));
                    intent.putExtras(bundle);
                    C0618g.f1635f.startService(intent);
                }
            } catch (Throwable th) {
                ActivityC0460a.m1698b("CoreAction|" + th.toString());
            }
            Intent E = m2032E();
            Bundle bundle2 = new Bundle();
            bundle2.putInt(PushConsts.CMD_ACTION, PushConsts.SET_TAG_RESULT);
            bundle2.putString("sn", str);
            bundle2.putString("code", str2);
            E.putExtras(bundle2);
            C0618g.f1635f.sendBroadcast(E);
        }
    }

    /* renamed from: b */
    public void mo4389b(String str, String str2, String str3, String str4) {
        ActivityC0460a.m1698b("CoreAction start broadcastExecute");
        if (C0618g.f1635f != null) {
            Intent intent = new Intent("com.igexin.sdk.action.execute");
            intent.putExtra("taskid", str);
            intent.putExtra("messageid", str2);
            intent.putExtra("appid", C0618g.f1602a);
            intent.putExtra("pkgname", C0618g.f1634e);
            C0618g.f1635f.sendBroadcast(intent);
        }
    }

    /* renamed from: b */
    public void mo4390b(boolean z) {
        C0456c.m1661b().mo4218a(new C0636d());
        C0456c.m1661b().mo4171c();
        mo4403e(z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a9 A[SYNTHETIC, Splitter:B:23:0x00a9] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f6  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo4391b(java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 371
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.p027a.C0535e.mo4391b(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004b A[SYNTHETIC, Splitter:B:14:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0087  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.igexin.push.p032d.p035c.C0648k mo4392c() {
        /*
        // Method dump skipped, instructions count: 149
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.p027a.C0535e.mo4392c():com.igexin.push.d.c.k");
    }

    /* renamed from: c */
    public String mo4393c(String str, String str2) {
        return str + ":" + str2;
    }

    /* renamed from: c */
    public void mo4394c(Intent intent) {
        if (intent != null && intent.getAction() != null) {
            try {
                String action = intent.getAction();
                if (PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(action)) {
                    if (C0456c.m1661b() != null) {
                        m2031D();
                    }
                } else if ("com.igexin.sdk.action.snlrefresh".equals(action) || C0618g.f1596U.equals(action) || "com.igexin.sdk.action.snlretire".equals(action)) {
                    C0617f.m2395a().mo4629h().mo4718a(intent);
                } else if ("com.igexin.sdk.action.execute".equals(action)) {
                    m2045f(intent);
                } else if ("com.igexin.sdk.action.doaction".equals(action)) {
                    m2042e(intent);
                } else if ("android.intent.action.TIME_SET".equals(action)) {
                    if (C0514k.f1310b != 0) {
                        C0479c.m1784c().mo4250d();
                    }
                } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                    C0618g.f1645p = 1;
                    if (mo4418t()) {
                        mo4417s();
                    }
                } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    C0618g.f1645p = 0;
                } else if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                    m2046f(intent.getDataString());
                } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                    m2043e(intent.getDataString());
                } else if ("com.igexin.sdk.action.core.clearmsg".equals(action)) {
                    C0617f.m2395a().mo4632k().mo4256a("message", (String) null);
                } else if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action) && intent.getIntExtra("wifi_state", 0) == 3) {
                    C0617f.m2395a().mo4625d();
                }
            } catch (Throwable th) {
                ActivityC0460a.m1698b("CoreAction" + th.toString());
            }
        }
    }

    /* renamed from: c */
    public void mo4395c(String str) {
        C0456c.m1661b().mo4216a(new C1140c(new C0611i(SDKUrlConfig.getBiUploadServiceUrl(), ((mo4361a(true, 4) + "2.10.3.5|sdkconfig-error|") + str).getBytes(), 0, true)), false, true);
    }

    /* renamed from: c */
    public void mo4396c(boolean z) {
        mo4404f();
        mo4401d(z);
    }

    /* renamed from: d */
    public int mo4397d() {
        if (!C0618g.f1638i || !C0618g.f1639j || C1151a.m4739a(System.currentTimeMillis()) || !C1151a.m4747b()) {
            ActivityC0460a.m1698b("CoreAction|keyNegotiate stop ++++++++++");
            return -1;
        }
        C0646i iVar = new C0646i();
        iVar.f1747a = C0618g.f1602a;
        return !(C0617f.m2395a().mo4628g().mo4737a("K-", iVar, true) >= 0) ? 0 : 1;
    }

    /* renamed from: d */
    public EnumC0554b mo4398d(String str, String str2) {
        EnumC0554b bVar;
        EnumC0554b bVar2 = EnumC0554b.success;
        int i = 0;
        PushTaskBean pushTaskBean = C0618g.f1612ah.get(mo4393c(str, str2));
        if (pushTaskBean == null) {
            return EnumC0554b.stop;
        }
        Iterator<BaseAction> it = pushTaskBean.getActionChains().iterator();
        while (true) {
            EnumC0554b bVar3 = bVar2;
            if (it.hasNext()) {
                BaseAction next = it.next();
                EnumC0554b bVar4 = EnumC0554b.stop;
                if (next == null) {
                    return bVar4;
                }
                Iterator<IPushExtension> it2 = C0672a.m2607a().mo4747d().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        bVar = bVar4;
                        break;
                    }
                    bVar4 = it2.next().prepareExecuteAction(pushTaskBean, next);
                    if (bVar4 != EnumC0554b.stop) {
                        bVar = bVar4;
                        break;
                    }
                }
                if (bVar == EnumC0554b.stop) {
                    AbstractC0521a aVar = f1364b.get(next.getType());
                    if (aVar == null) {
                        return bVar;
                    }
                    bVar = aVar.mo4352a(pushTaskBean, next);
                    if (bVar == EnumC0554b.stop) {
                        return bVar;
                    }
                }
                bVar2 = bVar3 == EnumC0554b.success ? bVar : bVar3;
                i = bVar == EnumC0554b.wait ? i + 1 : i;
            } else {
                if (i != 0 && !C0618g.m2426a(str, Integer.valueOf(i), true)) {
                    bVar3 = EnumC0554b.success;
                }
                return bVar3;
            }
        }
    }

    /* renamed from: d */
    public String mo4399d(String str) {
        if (C0618g.m2427b() == null) {
            return null;
        }
        return C0618g.m2427b().get(str);
    }

    /* renamed from: d */
    public void mo4400d(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("from");
            String stringExtra2 = intent.getStringExtra("did");
            if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
                ActivityC0460a.m1698b("CoreAction|doThirdGuardSt from or did is empty");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(stringExtra).append("|").append(C0618g.f1635f.getPackageName()).append("|").append(stringExtra2).append("|").append(C0618g.f1653x).append("|").append(C0618g.f1602a).append("|").append(C0618g.f1647r).append("|").append(System.currentTimeMillis());
            C0561af.m2162a().mo4429a("21", sb.toString());
        } catch (Throwable th) {
            ActivityC0460a.m1698b("CoreAction|doThirdGuardSt exception: " + th.toString());
        }
    }

    /* renamed from: d */
    public void mo4401d(boolean z) {
        C0456c.m1661b().mo4218a(new C0634b(z));
        C0456c.m1661b().mo4171c();
    }

    /* renamed from: e */
    public void mo4402e() {
        boolean z = false;
        if (C0618g.f1640k) {
            C0618g.f1640k = !C0618g.f1640k;
            C0618g.f1586K = (((long) Math.abs(new Random().nextInt() % 24)) * C1370a.f3218j) + System.currentTimeMillis();
        }
        C0494i.m1834a().mo4281e().mo4270g();
        if (C0618g.f1646q == 0) {
            ActivityC0460a.m1698b("registerReq #####");
            if (C0617f.m2395a().mo4628g().mo4737a("R-" + C0618g.f1576A, (AbstractC0642e) new C0643f(C0618g.f1649t, C0618g.f1650u, C0618g.f1576A, C0618g.f1602a), true) >= 0) {
                z = true;
            }
            ActivityC0460a.m1698b("registerReq|" + z + "|" + C0618g.f1576A);
            return;
        }
        C0648k c = mo4392c();
        ActivityC0460a.m1698b("loginReqBefore|" + c.f1753a);
        if (C0617f.m2395a().mo4628g().mo4737a("S-" + String.valueOf(C0618g.f1646q), (AbstractC0642e) c, true) >= 0) {
            z = true;
        }
        if (z) {
            ActivityC0460a.m1698b("CoreAction|loginReq|" + C0618g.f1647r);
        }
    }

    /* renamed from: e */
    public void mo4403e(boolean z) {
        C0456c.m1661b().mo4218a(new C0635c(z));
        C0456c.m1661b().mo4171c();
    }

    /* renamed from: f */
    public void mo4404f() {
        C0444d.m1594a().mo4144b();
    }

    /* renamed from: g */
    public int mo4405g() {
        ActivityC0460a.m1696a("CoreAction|send heart beat data ........");
        return C0617f.m2395a().mo4628g().mo4737a("H-" + C0618g.f1647r, (AbstractC0642e) new C0645h(), true);
    }

    /* renamed from: h */
    public void mo4406h() {
        try {
            for (C0596i iVar : C0565d.m2181a().mo4438b()) {
                if (iVar.mo4547d() + 20000 <= System.currentTimeMillis()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject(iVar.mo4545b());
                    C0641d dVar = new C0641d();
                    dVar.mo4693a();
                    dVar.f1715a = (int) currentTimeMillis;
                    dVar.f1718d = "17258000";
                    if (jSONObject.has("extraData")) {
                        dVar.f1720f = C1159i.m4778a(jSONObject.optString("extraData").getBytes(), 0);
                        jSONObject.remove("extraData");
                    }
                    dVar.f1719e = iVar.mo4545b();
                    dVar.f1721g = C0618g.f1647r;
                    C0617f.m2395a().mo4628g().mo4736a("C-" + C0618g.f1647r, dVar);
                    ActivityC0460a.m1698b("freshral|" + iVar.mo4545b());
                    C0565d.m2181a().mo4437a(iVar.mo4543a());
                    iVar.mo4544a(System.currentTimeMillis() + 20000);
                    C0565d.m2181a().mo4436a(iVar);
                    return;
                }
            }
        } catch (Throwable th) {
            ActivityC0460a.m1698b("CoreActionfreshRAL error :" + th.toString());
        }
    }

    /* renamed from: i */
    public void mo4407i() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PushConsts.CMD_ACTION, "request_deviceid");
            jSONObject.put("id", String.valueOf(currentTimeMillis));
        } catch (JSONException e) {
        }
        String jSONObject2 = jSONObject.toString();
        C0641d dVar = new C0641d();
        dVar.mo4693a();
        dVar.f1715a = (int) currentTimeMillis;
        dVar.f1718d = "17258000";
        dVar.f1719e = jSONObject2;
        dVar.f1721g = C0618g.f1647r;
        C0617f.m2395a().mo4628g().mo4736a("C-" + C0618g.f1647r, dVar);
        ActivityC0460a.m1698b("CoreAction|deviceidReq");
    }

    /* renamed from: j */
    public void mo4408j() {
        boolean z = true;
        try {
            if ((System.currentTimeMillis() - C0618g.f1581F) - C1370a.f3217i <= 0) {
                z = false;
            }
            if (z) {
                C0568g.m2192a().mo4446b(0);
                C0568g.m2192a().mo4463h(System.currentTimeMillis());
            }
            if (C0618g.f1630az <= 5) {
                C0568g.m2192a().mo4446b(C0618g.f1630az + 1);
                C0456c.m1661b().mo4216a(new C0537g(this), false, true);
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: k */
    public void mo4409k() {
        if (C0618g.f1635f != null) {
            Log.d("PushService", "clientid is " + C0618g.f1647r);
            ActivityC0460a.m1698b("broadcastClientid|" + C0618g.f1647r);
            try {
                Class b = mo4382b(C0618g.f1635f);
                if (b != null) {
                    Intent intent = new Intent(C0618g.f1635f, b);
                    Bundle bundle = new Bundle();
                    bundle.putInt(PushConsts.CMD_ACTION, PushConsts.GET_CLIENTID);
                    bundle.putString(PushConsts.KEY_CLIENT_ID, C0618g.f1647r);
                    intent.putExtras(bundle);
                    C0618g.f1635f.startService(intent);
                }
            } catch (Throwable th) {
                ActivityC0460a.m1698b("CoreAction|" + th.toString());
            }
            Intent E = m2032E();
            Bundle bundle2 = new Bundle();
            bundle2.putInt(PushConsts.CMD_ACTION, PushConsts.GET_CLIENTID);
            bundle2.putString(PushConsts.KEY_CLIENT_ID, C0618g.f1647r);
            E.putExtras(bundle2);
            C0618g.f1635f.sendBroadcast(E);
        }
    }

    /* renamed from: l */
    public void mo4410l() {
        if (C0618g.f1635f != null) {
            try {
                Class b = mo4382b(C0618g.f1635f);
                if (b != null) {
                    Intent intent = new Intent(C0618g.f1635f, b);
                    Bundle bundle = new Bundle();
                    bundle.putInt(PushConsts.CMD_ACTION, PushConsts.GET_SDKONLINESTATE);
                    bundle.putBoolean(PushConsts.KEY_ONLINE_STATE, C0618g.f1641l);
                    intent.putExtras(bundle);
                    C0618g.f1635f.startService(intent);
                }
            } catch (Throwable th) {
                ActivityC0460a.m1698b("CoreAction|" + th.toString());
            }
            Intent E = m2032E();
            Bundle bundle2 = new Bundle();
            bundle2.putInt(PushConsts.CMD_ACTION, PushConsts.GET_SDKONLINESTATE);
            bundle2.putBoolean(PushConsts.KEY_ONLINE_STATE, C0618g.f1641l);
            E.putExtras(bundle2);
            C0618g.f1635f.sendBroadcast(E);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002f A[SYNTHETIC, Splitter:B:14:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0034 A[SYNTHETIC, Splitter:B:17:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0057 A[SYNTHETIC, Splitter:B:33:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005c A[SYNTHETIC, Splitter:B:36:0x005c] */
    /* renamed from: m */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String mo4411m() {
        /*
        // Method dump skipped, instructions count: 119
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.p027a.C0535e.mo4411m():java.lang.String");
    }

    /* renamed from: n */
    public void mo4412n() {
        ArrayList arrayList = new ArrayList();
        m2039a((List<C0600m>) arrayList);
        if (!arrayList.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PushConsts.CMD_ACTION, "reportapplist");
                jSONObject.put("session_last", C0618g.f1646q);
                JSONArray jSONArray = new JSONArray();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("appid", arrayList.get(i).mo4575d());
                    jSONObject2.put("name", arrayList.get(i).mo4571b());
                    jSONObject2.put("version", arrayList.get(i).mo4573c());
                    jSONObject2.put("versionName", arrayList.get(i).mo4569a());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("applist", jSONArray);
            } catch (Exception e) {
            }
            C0456c.m1661b().mo4216a(new C1140c(new C0603a(SDKUrlConfig.getBiUploadServiceUrl(), jSONObject.toString().getBytes())), false, true);
            m2048g(mo4413o());
            ActivityC0460a.m1698b("reportapplist");
        }
    }

    /* renamed from: o */
    public String mo4413o() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        m2039a((List<C0600m>) arrayList2);
        int size = arrayList2.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                arrayList.add(arrayList2.get(i).mo4575d());
            }
        }
        return arrayList.toString();
    }

    /* renamed from: p */
    public boolean mo4414p() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6 = false;
        if (this.f1367e.get()) {
            return this.f1366d;
        }
        if (C0618g.f1635f == null) {
        }
        String packageName = C0618g.f1635f.getApplicationContext().getPackageName();
        try {
            ServiceInfo[] serviceInfoArr = C0618g.f1635f.getPackageManager().getPackageInfo(packageName, 4).services;
            if (serviceInfoArr != null) {
                int length = serviceInfoArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    } else if (serviceInfoArr[i].name.contains("DownloadService")) {
                        z3 = true;
                        break;
                    } else {
                        i++;
                    }
                }
            }
            z3 = false;
            try {
                ProviderInfo[] providerInfoArr = C0618g.f1635f.getPackageManager().getPackageInfo(packageName, 8).providers;
                if (providerInfoArr != null) {
                    int length2 = providerInfoArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length2) {
                            break;
                        } else if (providerInfoArr[i2].name.contains("DownloadProvider")) {
                            z4 = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                z4 = false;
            } catch (Exception e) {
                z2 = false;
                z = z3;
                z3 = z;
                z4 = z2;
                z5 = false;
                z6 = true;
                this.f1366d = z6;
                this.f1367e.set(true);
                return this.f1366d;
            }
            try {
                ActivityInfo[] activityInfoArr = C0618g.f1635f.getPackageManager().getPackageInfo(packageName, 2).receivers;
                if (activityInfoArr != null) {
                    int length3 = activityInfoArr.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length3) {
                            break;
                        } else if (activityInfoArr[i3].name.contains("DownloadReceiver")) {
                            z5 = true;
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                z5 = false;
            } catch (Exception e2) {
                z2 = z4;
                z = z3;
                z3 = z;
                z4 = z2;
                z5 = false;
                z6 = true;
                this.f1366d = z6;
                this.f1367e.set(true);
                return this.f1366d;
            }
        } catch (Exception e3) {
            z2 = false;
            z = false;
            z3 = z;
            z4 = z2;
            z5 = false;
            z6 = true;
            this.f1366d = z6;
            this.f1367e.set(true);
            return this.f1366d;
        }
        if (z3 && z4 && z5) {
            z6 = true;
        }
        this.f1366d = z6;
        this.f1367e.set(true);
        return this.f1366d;
    }

    /* renamed from: q */
    public void mo4415q() {
        C0617f.m2395a().mo4632k().mo4256a("message", "createtime <= " + (System.currentTimeMillis() - 604800000));
    }

    /* renamed from: r */
    public void mo4416r() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String format = simpleDateFormat.format(new Date());
        File file = new File("/sdcard/libs//");
        String str = C0618g.f1634e;
        if (str == null) {
            str = "unknowPacageName";
        }
        if (file.exists()) {
            String[] list = file.list();
            int length = list.length;
            for (int i = 0; i < length; i++) {
                int length2 = list[i].length();
                if (list[i].startsWith(str) && list[i].endsWith(".log") && length2 > str.length() + 14 && str.equals(list[i].substring(0, length2 - 15))) {
                    try {
                        if (Math.abs((simpleDateFormat.parse(format).getTime() - simpleDateFormat.parse(list[i].substring(str.length() + 1, length2 - 4)).getTime()) / C1370a.f3217i) > 6) {
                            File file2 = new File("/sdcard/libs//" + list[i]);
                            if (file2.exists()) {
                                file2.delete();
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
    }

    /* renamed from: s */
    public void mo4417s() {
        try {
            if (!m2033F()) {
                ActivityC0460a.m1698b("CoreAction--------checkConditionStatus start to read pushMessageMap data...");
                for (Map.Entry<String, PushTaskBean> entry : C0618g.f1612ah.entrySet()) {
                    String key = entry.getKey();
                    PushTaskBean value = entry.getValue();
                    String str = "";
                    if (value != null && value.getStatus() == C0519a.f1347k) {
                        String taskId = value.getTaskId();
                        Map<String, String> conditionMap = value.getConditionMap();
                        if (conditionMap == null) {
                            return;
                        }
                        if (!conditionMap.containsKey("endTime") || Long.valueOf(conditionMap.get("endTime")).longValue() >= System.currentTimeMillis()) {
                            if (conditionMap.containsKey("wifi")) {
                                int intValue = Integer.valueOf(conditionMap.get("wifi")).intValue();
                                mo4420v();
                                if (intValue != C0618g.f1644o) {
                                }
                            }
                            if (conditionMap.containsKey("screenOn")) {
                                int intValue2 = Integer.valueOf(conditionMap.get("screenOn")).intValue();
                                mo4419u();
                                if (intValue2 != C0618g.f1645p) {
                                }
                            }
                            if (conditionMap.containsKey("ssid")) {
                                String str2 = conditionMap.get("ssid");
                                mo4421w();
                                if (C0618g.f1618an.containsValue(str2)) {
                                    str = str2;
                                }
                            }
                            if (conditionMap.containsKey("bssid")) {
                                String str3 = conditionMap.get("bssid");
                                if (C0618g.f1618an.containsKey(str3)) {
                                    if (!C0618g.f1618an.get(str3).equals(str)) {
                                    }
                                }
                            }
                            if (!conditionMap.containsKey("startTime") || Long.valueOf(conditionMap.get("startTime")).longValue() <= System.currentTimeMillis()) {
                                m2034a().mo4389b(taskId, value.getMessageId(), C0618g.f1602a, C0618g.f1634e);
                                m2035a(C0519a.f1348l, taskId, key);
                                value.setStatus(C0519a.f1348l);
                            }
                        } else {
                            m2035a(C0519a.f1349m, taskId, key);
                            value.setStatus(C0519a.f1348l);
                        }
                    }
                }
            }
        } catch (Exception e) {
            ActivityC0460a.m1698b("CoreAction|" + e.toString());
        }
    }

    /* renamed from: t */
    public boolean mo4418t() {
        long currentTimeMillis = System.currentTimeMillis();
        if (C0618g.f1583H <= 0) {
            C0618g.f1583H = currentTimeMillis - 60000;
            return true;
        } else if (currentTimeMillis - C0618g.f1583H <= 60000) {
            return false;
        } else {
            C0618g.f1583H = currentTimeMillis;
            return true;
        }
    }

    /* renamed from: u */
    public void mo4419u() {
        if (((PowerManager) C0618g.f1635f.getSystemService("power")).isScreenOn()) {
            C0618g.f1645p = 1;
        } else {
            C0618g.f1645p = 0;
        }
    }

    /* renamed from: v */
    public void mo4420v() {
        NetworkInfo.State state = ((ConnectivityManager) C0618g.f1635f.getSystemService("connectivity")).getNetworkInfo(1).getState();
        if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
            C0618g.f1644o = 1;
        } else {
            C0618g.f1644o = 0;
        }
    }

    /* renamed from: w */
    public void mo4421w() {
        try {
            List<ScanResult> scanResults = ((WifiManager) C0618g.f1635f.getSystemService("wifi")).getScanResults();
            C0618g.f1618an.clear();
            if (!(scanResults == null || scanResults.isEmpty())) {
                for (int i = 0; i < scanResults.size(); i++) {
                    C0618g.f1618an.put(scanResults.get(i).BSSID, scanResults.get(i).SSID);
                }
            }
        } catch (Throwable th) {
            ActivityC0460a.m1698b("CoreAction|" + th.toString());
        }
    }

    /* renamed from: x */
    public void mo4422x() {
        if (C0514k.f1323o && System.currentTimeMillis() - this.f1368f >= 300000) {
            this.f1368f = System.currentTimeMillis();
            Map<String, String> d = C0568g.m2192a().mo4454d();
            if (!d.isEmpty() && C0514k.f1297C > 0) {
                int i = 0;
                for (Map.Entry<String, String> entry : d.entrySet()) {
                    if (i < C0514k.f1297C) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (!C0514k.f1299E || !C1151a.m4745a(key, "com.igexin.sdk.GActivity")) {
                            m2044e(key, value);
                        } else {
                            try {
                                C0617f.m2395a().mo4619a(new C0539i(this, (long) ((new Random().nextInt(6) + 1) * 1000), key, value));
                            } catch (Exception e) {
                            }
                        }
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: y */
    public void mo4423y() {
        int i = C0618g.f1617am - 100;
        if (i < 0) {
            C0618g.f1617am = 0;
        } else {
            C0618g.f1617am = i;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<Map.Entry<String, Long>> it = C0618g.f1616al.entrySet().iterator();
        while (it.hasNext()) {
            if (currentTimeMillis - it.next().getValue().longValue() > C1370a.f3218j) {
                it.remove();
            }
        }
    }

    /* renamed from: z */
    public void mo4424z() {
        if (C0618g.f1590O < System.currentTimeMillis()) {
            C0568g.m2192a().mo4444a(false);
        }
    }
}
