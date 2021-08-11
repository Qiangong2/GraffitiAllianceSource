package com.igexin.push.extension.distribution.basic.p042c;

import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.Message;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0519a;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.extension.distribution.basic.p045f.C0750a;
import com.igexin.push.extension.distribution.basic.p045f.C0751b;
import com.igexin.push.extension.distribution.basic.p046g.C0752a;
import com.igexin.push.extension.distribution.basic.p046g.p049c.C0761b;
import com.igexin.push.extension.distribution.basic.p053h.C0768a;
import com.igexin.push.extension.distribution.basic.p053h.C0776i;
import com.igexin.sdk.PushConsts;
import com.tencent.qcloud.core.util.IOUtils;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.igexin.push.extension.distribution.basic.c.g */
public class C0741g {

    /* renamed from: a */
    private static final String f2030a = ("EXT-" + C0741g.class.getName());

    /* renamed from: d */
    private static C0741g f2031d;

    /* renamed from: b */
    private C0750a f2032b;

    /* renamed from: c */
    private Context f2033c;

    /* renamed from: e */
    private ConcurrentLinkedQueue<Message> f2034e = new ConcurrentLinkedQueue<>();

    /* renamed from: f */
    private Handler f2035f;

    /* renamed from: g */
    private C0745k f2036g;

    /* renamed from: h */
    private String f2037h;

    private C0741g(Context context) {
        this.f2033c = context;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme("package");
        intentFilter.addAction("com.igexin.sdk.action.INSTALL");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        this.f2033c.registerReceiver(C0743i.m3029a(), intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("com.igexin.sdk.action.notification.burying.point");
        this.f2033c.registerReceiver(C0743i.m3029a(), intentFilter2);
        this.f2036g = new C0745k();
        this.f2037h = "/sdcard/libs//com.getui.sdk.deviceId.db";
    }

    /* renamed from: a */
    public static C0741g m3010a() {
        if (f2031d == null) {
            f2031d = new C0741g(C0744j.f2042a);
        }
        return f2031d;
    }

    /* renamed from: a */
    private void m3011a(File file) {
        File[] listFiles = file.listFiles();
        for (File file2 : listFiles) {
            while (file2.exists()) {
                if (file2.isFile()) {
                    file2.delete();
                } else if (!file2.delete()) {
                    m3011a(file2);
                }
            }
        }
        file.delete();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00cd A[SYNTHETIC, Splitter:B:24:0x00cd] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d7 A[SYNTHETIC, Splitter:B:29:0x00d7] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3012d(java.lang.String r6) {
        /*
        // Method dump skipped, instructions count: 238
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.p042c.C0741g.m3012d(java.lang.String):void");
    }

    /* renamed from: e */
    private void m3013e(String str) {
        try {
            C0751b bVar = new C0751b(this.f2033c);
            if (bVar.mo5053a()) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", (Integer) 2);
                contentValues.put("value", str);
                bVar.mo5052a("runtime", null, contentValues);
                bVar.close();
            }
        } catch (Exception e) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002e A[SYNTHETIC, Splitter:B:13:0x002e] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033 A[SYNTHETIC, Splitter:B:16:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0071 A[SYNTHETIC, Splitter:B:34:0x0071] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0076 A[SYNTHETIC, Splitter:B:37:0x0076] */
    /* renamed from: k */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m3014k() {
        /*
        // Method dump skipped, instructions count: 146
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.p042c.C0741g.m3014k():java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009e  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String mo5015a(java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 168
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.p042c.C0741g.mo5015a(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public void mo5016a(HandlerC0740f fVar) {
        this.f2035f = fVar;
    }

    /* renamed from: a */
    public boolean mo5017a(Message message) {
        if (this.f2035f == null) {
            this.f2034e.add(message);
            return false;
        }
        this.f2035f.sendMessage(message);
        return true;
    }

    /* renamed from: b */
    public String mo5018b(String str) {
        String str2 = null;
        List<PackageInfo> installedPackages = C0618g.f1635f.getPackageManager().getInstalledPackages(132);
        int i = 0;
        while (i < installedPackages.size()) {
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            PackageInfo packageInfo = installedPackages.get(i);
            ServiceInfo[] serviceInfoArr = packageInfo.services;
            String str3 = packageInfo.packageName;
            if (serviceInfoArr != null) {
                for (ServiceInfo serviceInfo : serviceInfoArr) {
                    String str4 = serviceInfo.name;
                    if (str4.equals("com.baidu.android.pushservice.PushService")) {
                        z = true;
                    } else if (str4.equals("cn.jpush.android.service.PushService")) {
                        z2 = true;
                    } else if (str4.equals("com.jnt.pushmedium.JntPushService")) {
                        z3 = true;
                    }
                }
            }
            boolean containsKey = packageInfo.applicationInfo.metaData != null ? packageInfo.applicationInfo.metaData.containsKey("UMENG_APPKEY") : false;
            i++;
            str2 = (z || containsKey || z2 || z3) ? (str2 != null ? str2 + IOUtils.LINE_SEPARATOR_UNIX + C0535e.m2034a().mo4361a(false, 4) : C0535e.m2034a().mo4361a(false, 4)) + str + "|" + str3 + "|" + z + "|" + containsKey + "|" + z3 + "|" + z2 : str2;
        }
        return str2;
    }

    /* renamed from: b */
    public boolean mo5019b() {
        this.f2036g.start();
        return true;
    }

    /* renamed from: c */
    public void mo5020c() {
        Iterator<Message> it = this.f2034e.iterator();
        while (it.hasNext()) {
            Message next = it.next();
            if (this.f2035f != null) {
                this.f2035f.sendMessage(next);
            }
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        this.f2033c.registerReceiver(C0761b.m3107a(), intentFilter);
        C0752a a = C0752a.m3056a(this.f2033c, "ext_download.db");
        if (a.mo5061c()) {
            a.mo5058a();
        }
        C0535e.m2034a().mo4414p();
    }

    /* renamed from: c */
    public void mo5021c(String str) {
        String str2 = C0618g.f1634e + "." + str + ".log";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        File file = new File("/sdcard/libs//");
        if (file.exists()) {
            String[] list = file.list();
            for (String str3 : list) {
                if (str3.equals(str2)) {
                    File file2 = new File("/sdcard/libs//" + str2);
                    try {
                        int length = (int) (file2.length() / 51200);
                        if (file2.length() % 51200 < 51200) {
                            length++;
                        }
                        ActivityC0460a.m1698b("upload blockCnt=" + length);
                        long lastModified = file2.lastModified();
                        int i = 0;
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file2));
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                            if (byteArrayOutputStream.size() >= 51200) {
                                ActivityC0460a.m1698b("upload blockSeq=" + i + "--blockCnt=" + length);
                                C0456c.m1661b().mo4216a(new C0768a(new C0776i(byteArrayOutputStream.toByteArray(), lastModified, length, i)), false, true);
                                byteArrayOutputStream.reset();
                                i++;
                            }
                        }
                        if (byteArrayOutputStream.size() < 51200) {
                            C0456c.m1661b().mo4216a(new C0768a(new C0776i(byteArrayOutputStream.toByteArray(), lastModified, length, i)), false, true);
                        }
                        bufferedInputStream.close();
                    } catch (Exception e) {
                    }
                }
            }
        }
    }

    /* renamed from: d */
    public C0750a mo5022d() {
        if (this.f2032b == null) {
            this.f2032b = new C0750a(this.f2033c);
        }
        return this.f2032b;
    }

    /* renamed from: e */
    public boolean mo5023e() {
        try {
            ActivityInfo[] activityInfoArr = this.f2033c.getPackageManager().getPackageInfo(this.f2033c.getApplicationContext().getPackageName(), 1).activities;
            if (activityInfoArr != null) {
                for (ActivityInfo activityInfo : activityInfoArr) {
                    if (activityInfo.name.contains("PushActivity")) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0081, code lost:
        if (0 != 0) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0083, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0093, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0097, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0098, code lost:
        r1 = r0;
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0080 A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:1:0x000c] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0093  */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo5024f() {
        /*
        // Method dump skipped, instructions count: 156
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.p042c.C0741g.mo5024f():void");
    }

    /* renamed from: g */
    public void mo5025g() {
        File file = new File(C0519a.f1338b);
        if (file.exists()) {
            File[] listFiles = file.listFiles(new C0742h(this));
            for (File file2 : listFiles) {
                if (file2.exists()) {
                    m3011a(file2);
                }
            }
        }
    }

    /* renamed from: h */
    public String mo5026h() {
        String str;
        List<PackageInfo> installedPackages = C0618g.f1635f.getPackageManager().getInstalledPackages(4);
        if (installedPackages.size() == 0) {
            return null;
        }
        String a = C0535e.m2034a().mo4361a(false, 5);
        String str2 = "";
        int i = 0;
        for (PackageInfo packageInfo : installedPackages) {
            i++;
            if ((packageInfo.applicationInfo.flags & 1) != 1) {
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                String str3 = packageInfo.packageName;
                if (serviceInfoArr != null && serviceInfoArr.length > 0) {
                    String str4 = serviceInfoArr[0].name;
                    for (int i2 = 1; i2 < serviceInfoArr.length; i2++) {
                        str4 = str4 + MiPushClient.ACCEPT_TIME_SEPARATOR + serviceInfoArr[i2].name;
                    }
                    str = ((str2 + a) + "|" + str3) + "|" + str4 + IOUtils.LINE_SEPARATOR_UNIX;
                    str2 = str;
                }
            }
            str = str2;
            str2 = str;
        }
        return str2;
    }

    /* renamed from: i */
    public void mo5027i() {
        String k = m3014k();
        ActivityC0460a.m1698b(f2030a + "|read from com.getui.sdk.deviceId.db = " + k + "; CoreRuntimeInfo.deviceId = " + C0618g.f1653x);
        if (k != null) {
            if (!k.equals(C0618g.f1653x)) {
                C0618g.f1653x = k;
                m3013e(k);
            }
        } else if (C0618g.f1653x != null) {
            m3012d(C0618g.f1653x);
        } else {
            ActivityC0460a.m1698b(f2030a + "|updateDeviceId new file deviceId and CoreRuntimeInfo deviceId is null return");
        }
    }

    /* renamed from: j */
    public void mo5028j() {
        this.f2033c.unregisterReceiver(C0743i.m3029a());
    }
}
