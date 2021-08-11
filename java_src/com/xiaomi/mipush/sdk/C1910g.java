package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.Looper;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.channel.commonutils.network.C1865d;
import com.xiaomi.channel.commonutils.string.C1872c;
import com.xiaomi.push.service.AbstractC1993y;
import com.xiaomi.push.service.C1946aa;
import com.xiaomi.xmpush.thrift.C2067c;
import com.xiaomi.xmpush.thrift.C2077h;
import com.xiaomi.xmpush.thrift.C2081j;
import com.xiaomi.xmpush.thrift.C2095q;
import com.xiaomi.xmpush.thrift.C2103u;
import com.xiaomi.xmpush.thrift.EnumC2064a;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.thrift.AbstractC2158b;

/* renamed from: com.xiaomi.mipush.sdk.g */
public class C1910g {

    /* renamed from: b */
    private static C1910g f4877b;

    /* renamed from: e */
    private static final ArrayList<C1911a> f4878e = new ArrayList<>();

    /* renamed from: a */
    private boolean f4879a = false;

    /* renamed from: c */
    private Context f4880c;

    /* renamed from: d */
    private String f4881d;

    /* renamed from: f */
    private Intent f4882f = null;

    /* renamed from: g */
    private Integer f4883g = null;

    /* access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.mipush.sdk.g$a */
    public static class C1911a<T extends AbstractC2158b<T, ?>> {

        /* renamed from: a */
        T f4884a;

        /* renamed from: b */
        EnumC2064a f4885b;

        /* renamed from: c */
        boolean f4886c;

        C1911a() {
        }
    }

    private C1910g(Context context) {
        this.f4880c = context.getApplicationContext();
        this.f4881d = null;
        this.f4879a = m7001g();
    }

    /* renamed from: a */
    public static C1910g m6998a(Context context) {
        if (f4877b == null) {
            f4877b = new C1910g(context);
        }
        return f4877b;
    }

    /* renamed from: g */
    private boolean m7001g() {
        try {
            PackageInfo packageInfo = this.f4880c.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            return packageInfo != null && packageInfo.versionCode >= 105;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: h */
    private Intent m7002h() {
        Intent intent = new Intent();
        String packageName = this.f4880c.getPackageName();
        if (!mo10212b() || "com.xiaomi.xmsf".equals(packageName)) {
            m7005k();
            intent.setComponent(new ComponentName(this.f4880c, "com.xiaomi.push.service.XMPushService"));
            intent.putExtra("mipush_app_package", packageName);
        } else {
            intent.setPackage("com.xiaomi.xmsf");
            intent.setClassName("com.xiaomi.xmsf", m7003i());
            intent.putExtra("mipush_app_package", packageName);
            m7004j();
        }
        return intent;
    }

    /* renamed from: i */
    private String m7003i() {
        try {
            return this.f4880c.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
        } catch (Exception e) {
        }
    }

    /* renamed from: j */
    private void m7004j() {
        try {
            this.f4880c.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f4880c, "com.xiaomi.push.service.XMPushService"), 2, 1);
        } catch (Throwable th) {
        }
    }

    /* renamed from: k */
    private void m7005k() {
        try {
            this.f4880c.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f4880c, "com.xiaomi.push.service.XMPushService"), 1, 1);
        } catch (Throwable th) {
        }
    }

    /* renamed from: l */
    private boolean m7006l() {
        String packageName = this.f4880c.getPackageName();
        return packageName.contains("miui") || packageName.contains("xiaomi") || (this.f4880c.getApplicationInfo().flags & 1) != 0;
    }

    /* renamed from: a */
    public void mo10201a() {
        this.f4880c.startService(m7002h());
    }

    /* renamed from: a */
    public void mo10202a(int i) {
        Intent h = m7002h();
        h.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        h.putExtra(AbstractC1993y.f5176y, this.f4880c.getPackageName());
        h.putExtra(AbstractC1993y.f5177z, i);
        this.f4880c.startService(h);
    }

    /* renamed from: a */
    public final void mo10203a(C2081j jVar, boolean z) {
        this.f4882f = null;
        Intent h = m7002h();
        byte[] a = C2103u.m8169a(C1906e.m6981a(this.f4880c, jVar, EnumC2064a.Registration));
        if (a == null) {
            AbstractC1855b.m6718a("register fail, because msgBytes is null.");
            return;
        }
        h.setAction("com.xiaomi.mipush.REGISTER_APP");
        h.putExtra("mipush_app_id", C1900a.m6949a(this.f4880c).mo10176c());
        h.putExtra("mipush_payload", a);
        h.putExtra("mipush_session", this.f4881d);
        h.putExtra("mipush_env_chanage", z);
        h.putExtra("mipush_env_type", C1900a.m6949a(this.f4880c).mo10186m());
        if (!C1865d.m6762d(this.f4880c) || !mo10216f()) {
            this.f4882f = h;
        } else {
            this.f4880c.startService(h);
        }
    }

    /* renamed from: a */
    public final void mo10204a(C2095q qVar) {
        Intent h = m7002h();
        byte[] a = C2103u.m8169a(C1906e.m6981a(this.f4880c, qVar, EnumC2064a.UnRegistration));
        if (a == null) {
            AbstractC1855b.m6718a("unregister fail, because msgBytes is null.");
            return;
        }
        h.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        h.putExtra("mipush_app_id", C1900a.m6949a(this.f4880c).mo10176c());
        h.putExtra("mipush_payload", a);
        this.f4880c.startService(h);
    }

    /* renamed from: a */
    public final <T extends AbstractC2158b<T, ?>> void mo10205a(T t, EnumC2064a aVar, C2067c cVar) {
        mo10207a(t, aVar, !aVar.equals(EnumC2064a.Registration), cVar);
    }

    /* renamed from: a */
    public <T extends AbstractC2158b<T, ?>> void mo10206a(T t, EnumC2064a aVar, boolean z) {
        C1911a aVar2 = new C1911a();
        aVar2.f4884a = t;
        aVar2.f4885b = aVar;
        aVar2.f4886c = z;
        synchronized (f4878e) {
            f4878e.add(aVar2);
            if (f4878e.size() > 10) {
                f4878e.remove(0);
            }
        }
    }

    /* renamed from: a */
    public final <T extends AbstractC2158b<T, ?>> void mo10207a(T t, EnumC2064a aVar, boolean z, C2067c cVar) {
        mo10209a(t, aVar, z, true, cVar, true);
    }

    /* renamed from: a */
    public final <T extends AbstractC2158b<T, ?>> void mo10208a(T t, EnumC2064a aVar, boolean z, C2067c cVar, boolean z2) {
        mo10209a(t, aVar, z, true, cVar, z2);
    }

    /* renamed from: a */
    public final <T extends AbstractC2158b<T, ?>> void mo10209a(T t, EnumC2064a aVar, boolean z, boolean z2, C2067c cVar, boolean z3) {
        mo10210a(t, aVar, z, z2, cVar, z3, this.f4880c.getPackageName(), C1900a.m6949a(this.f4880c).mo10176c());
    }

    /* renamed from: a */
    public final <T extends AbstractC2158b<T, ?>> void mo10210a(T t, EnumC2064a aVar, boolean z, boolean z2, C2067c cVar, boolean z3, String str, String str2) {
        if (C1900a.m6949a(this.f4880c).mo10182i()) {
            Intent h = m7002h();
            C2077h a = C1906e.m6982a(this.f4880c, t, aVar, z, str, str2);
            if (cVar != null) {
                a.mo10825a(cVar);
            }
            byte[] a2 = C2103u.m8169a(a);
            if (a2 == null) {
                AbstractC1855b.m6718a("send message fail, because msgBytes is null.");
                return;
            }
            h.setAction("com.xiaomi.mipush.SEND_MESSAGE");
            h.putExtra("mipush_payload", a2);
            h.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
            this.f4880c.startService(h);
        } else if (z2) {
            mo10206a(t, aVar, z);
        } else {
            AbstractC1855b.m6718a("drop the message before initialization.");
        }
    }

    /* renamed from: b */
    public void mo10211b(int i) {
        Intent h = m7002h();
        h.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        h.putExtra(AbstractC1993y.f5176y, this.f4880c.getPackageName());
        h.putExtra(AbstractC1993y.f5149A, i);
        h.putExtra(AbstractC1993y.f5151C, C1872c.m6780b(this.f4880c.getPackageName() + i));
        this.f4880c.startService(h);
    }

    /* renamed from: b */
    public boolean mo10212b() {
        return this.f4879a && 1 == C1900a.m6949a(this.f4880c).mo10186m();
    }

    /* renamed from: c */
    public void mo10213c() {
        if (this.f4882f != null) {
            this.f4880c.startService(this.f4882f);
            this.f4882f = null;
        }
    }

    /* renamed from: d */
    public void mo10214d() {
        synchronized (f4878e) {
            Iterator<C1911a> it = f4878e.iterator();
            while (it.hasNext()) {
                C1911a next = it.next();
                mo10209a(next.f4884a, next.f4885b, next.f4886c, false, null, true);
            }
            f4878e.clear();
        }
    }

    /* renamed from: e */
    public void mo10215e() {
        Intent h = m7002h();
        h.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        h.putExtra(AbstractC1993y.f5176y, this.f4880c.getPackageName());
        h.putExtra(AbstractC1993y.f5151C, C1872c.m6780b(this.f4880c.getPackageName()));
        this.f4880c.startService(h);
    }

    /* renamed from: f */
    public boolean mo10216f() {
        if (!mo10212b() || !m7006l()) {
            return true;
        }
        if (this.f4883g == null) {
            this.f4883g = Integer.valueOf(C1946aa.m7251a(this.f4880c).mo10382b());
            if (this.f4883g.intValue() == 0) {
                this.f4880c.getContentResolver().registerContentObserver(C1946aa.m7251a(this.f4880c).mo10383c(), false, new C1912h(this, new Handler(Looper.getMainLooper())));
            }
        }
        return this.f4883g.intValue() != 0;
    }
}
