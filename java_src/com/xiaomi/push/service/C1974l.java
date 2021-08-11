package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.push.service.C1987w;
import com.xiaomi.smack.packet.AbstractC2028d;
import com.xiaomi.smack.packet.C2024a;
import com.xiaomi.smack.packet.C2027c;
import com.xiaomi.smack.util.C2049k;
import com.xiaomi.xmpush.thrift.C2067c;
import com.xiaomi.xmpush.thrift.C2071e;
import com.xiaomi.xmpush.thrift.C2077h;
import com.xiaomi.xmpush.thrift.C2103u;
import com.xiaomi.xmpush.thrift.EnumC2064a;
import java.io.IOException;
import java.util.List;
import org.apache.thrift.C2164f;
import org.json.JSONException;

/* renamed from: com.xiaomi.push.service.l */
public class C1974l {
    /* renamed from: a */
    private static void m7347a(XMPushService xMPushService, C2077h hVar, String str) {
        xMPushService.mo10350a(new C1979q(4, xMPushService, hVar, str));
    }

    /* renamed from: a */
    private static void m7348a(XMPushService xMPushService, C2077h hVar, String str, String str2) {
        xMPushService.mo10350a(new C1980r(4, xMPushService, hVar, str, str2));
    }

    /* renamed from: a */
    private static void m7349a(XMPushService xMPushService, byte[] bArr, long j) {
        boolean z;
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        C2077h hVar = new C2077h();
        try {
            C2103u.m8168a(hVar, bArr);
            if (!TextUtils.isEmpty(hVar.f5739f)) {
                Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                intent.putExtra("mipush_payload", bArr);
                intent.putExtra("mrt", Long.toString(valueOf.longValue()));
                intent.setPackage(hVar.f5739f);
                String a = C1982s.m7382a(hVar);
                C2049k.m7718a(xMPushService, a, j, true, System.currentTimeMillis());
                C2067c m = hVar.mo10850m();
                if (m != null) {
                    m.mo10698a("mrt", Long.toString(valueOf.longValue()));
                }
                if (EnumC2064a.SendMessage == hVar.mo10823a() && C1971i.m7334a(xMPushService).mo10415a(hVar.f5739f) && !C1982s.m7391b(hVar)) {
                    String str = "";
                    if (m != null) {
                        str = m.mo10704b();
                    }
                    AbstractC1855b.m6718a("Drop a message for unregistered, msgid=" + str);
                    m7347a(xMPushService, hVar, hVar.f5739f);
                } else if (EnumC2064a.SendMessage != hVar.mo10823a() || TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") || TextUtils.equals(xMPushService.getPackageName(), hVar.f5739f)) {
                    if (!(m == null || m.mo10704b() == null)) {
                        AbstractC1855b.m6718a(String.format("receive a message, appid=%1$s, msgid= %2$s", hVar.mo10844h(), m.mo10704b()));
                    }
                    if (m7357c(hVar) && m7351a(xMPushService, a)) {
                        m7356c(xMPushService, hVar);
                    } else if (m7352a(hVar) && !m7351a(xMPushService, a) && !m7355b(hVar)) {
                        m7358d(xMPushService, hVar);
                    } else if ((!C1982s.m7391b(hVar) || !m7354b(xMPushService, hVar.f5739f)) && !m7350a(xMPushService, intent)) {
                        xMPushService.mo10350a(new C1975m(4, xMPushService, hVar));
                    } else {
                        if (EnumC2064a.Registration == hVar.mo10823a()) {
                            String j2 = hVar.mo10847j();
                            SharedPreferences.Editor edit = xMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
                            edit.putString(j2, hVar.f5738e);
                            edit.commit();
                        }
                        if (m == null || TextUtils.isEmpty(m.mo10719h()) || TextUtils.isEmpty(m.mo10722j()) || m.f5574h == 1 || (!C1982s.m7386a(m.mo10731s()) && C1982s.m7385a(xMPushService, hVar.f5739f))) {
                            xMPushService.sendBroadcast(intent, C1964b.m7303a(hVar.f5739f));
                        } else {
                            String str2 = null;
                            if (m != null) {
                                if (m.f5576j != null) {
                                    str2 = m.f5576j.get("jobkey");
                                }
                                if (TextUtils.isEmpty(str2)) {
                                    str2 = m.mo10704b();
                                }
                                z = C1983t.m7396a(xMPushService, hVar.f5739f, str2);
                            } else {
                                z = false;
                            }
                            if (z) {
                                AbstractC1855b.m6718a("drop a duplicate message, key=" + str2);
                            } else {
                                C1982s.m7383a(xMPushService, hVar, bArr);
                                if (!C1982s.m7391b(hVar)) {
                                    Intent intent2 = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
                                    intent2.putExtra("mipush_payload", bArr);
                                    intent2.setPackage(hVar.f5739f);
                                    try {
                                        List<ResolveInfo> queryBroadcastReceivers = xMPushService.getPackageManager().queryBroadcastReceivers(intent2, 0);
                                        if (queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty()) {
                                            xMPushService.sendBroadcast(intent2, C1964b.m7303a(hVar.f5739f));
                                        }
                                    } catch (Exception e) {
                                        xMPushService.sendBroadcast(intent2, C1964b.m7303a(hVar.f5739f));
                                    }
                                }
                            }
                            m7353b(xMPushService, hVar);
                        }
                        if (hVar.mo10823a() == EnumC2064a.UnRegistration && !"com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
                            xMPushService.stopSelf();
                        }
                    }
                } else {
                    AbstractC1855b.m6718a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + hVar.f5739f);
                    m7348a(xMPushService, hVar, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + hVar.f5739f);
                }
            } else {
                AbstractC1855b.m6718a("receive a mipush message without package name");
            }
        } catch (C2164f e2) {
            AbstractC1855b.m6720a(e2);
        }
    }

    /* renamed from: a */
    private static boolean m7350a(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            return queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty();
        } catch (Exception e) {
            return true;
        }
    }

    /* renamed from: a */
    private static boolean m7351a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
        intent.setPackage(str);
        Intent intent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
        intent2.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        try {
            return !packageManager.queryBroadcastReceivers(intent2, 32).isEmpty() || !packageManager.queryIntentServices(intent, 32).isEmpty();
        } catch (Exception e) {
            AbstractC1855b.m6720a(e);
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m7352a(C2077h hVar) {
        return "com.xiaomi.xmsf".equals(hVar.f5739f) && hVar.mo10850m() != null && hVar.mo10850m().mo10731s() != null && hVar.mo10850m().mo10731s().containsKey("miui_package_name");
    }

    /* renamed from: b */
    private static void m7353b(XMPushService xMPushService, C2077h hVar) {
        xMPushService.mo10350a(new C1976n(4, xMPushService, hVar));
    }

    /* renamed from: b */
    private static boolean m7354b(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    /* renamed from: b */
    private static boolean m7355b(C2077h hVar) {
        return hVar.mo10850m().mo10731s().containsKey("notify_effect");
    }

    /* renamed from: c */
    private static void m7356c(XMPushService xMPushService, C2077h hVar) {
        xMPushService.mo10350a(new C1977o(4, xMPushService, hVar));
    }

    /* renamed from: c */
    private static boolean m7357c(C2077h hVar) {
        if (hVar.mo10850m() == null || hVar.mo10850m().mo10731s() == null) {
            return false;
        }
        return "1".equals(hVar.mo10850m().mo10731s().get("obslete_ads_message"));
    }

    /* renamed from: d */
    private static void m7358d(XMPushService xMPushService, C2077h hVar) {
        xMPushService.mo10350a(new C1978p(4, xMPushService, hVar));
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static C2077h m7359e(XMPushService xMPushService, C2077h hVar) {
        C2071e eVar = new C2071e();
        eVar.mo10760b(hVar.mo10844h());
        C2067c m = hVar.mo10850m();
        if (m != null) {
            eVar.mo10755a(m.mo10704b());
            eVar.mo10754a(m.mo10711d());
            if (!TextUtils.isEmpty(m.mo10717f())) {
                eVar.mo10762c(m.mo10717f());
            }
        }
        C2077h a = xMPushService.mo10347a(hVar.mo10847j(), hVar.mo10844h(), eVar, EnumC2064a.AckMessage);
        C2067c a2 = hVar.mo10850m().mo10694a();
        a2.mo10698a("mat", Long.toString(System.currentTimeMillis()));
        a.mo10825a(a2);
        return a;
    }

    /* renamed from: a */
    public void mo10418a(Context context, C1987w.C1989b bVar, boolean z, int i, String str) {
        C1969g a;
        if (!z && (a = C1970h.m7328a(context)) != null && "token-expired".equals(str)) {
            try {
                C1970h.m7329a(context, a.f5075d, a.f5076e, a.f5077f);
            } catch (IOException e) {
                AbstractC1855b.m6720a(e);
            } catch (JSONException e2) {
                AbstractC1855b.m6720a(e2);
            }
        }
    }

    /* renamed from: a */
    public void mo10419a(XMPushService xMPushService, AbstractC2028d dVar, C1987w.C1989b bVar) {
        if (dVar instanceof C2027c) {
            C2027c cVar = (C2027c) dVar;
            C2024a p = cVar.mo10619p("s");
            if (p != null) {
                try {
                    m7349a(xMPushService, C1948ac.m7263b(C1948ac.m7260a(bVar.f5135i, cVar.mo10609k()), p.mo10571c()), (long) C2049k.m7714a(dVar.mo10546a()));
                } catch (IllegalArgumentException e) {
                    AbstractC1855b.m6720a(e);
                }
            }
        } else {
            AbstractC1855b.m6718a("not a mipush message");
        }
    }
}
