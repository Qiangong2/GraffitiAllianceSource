package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.service.C1987w;
import java.util.Locale;

/* renamed from: com.xiaomi.push.service.g */
public class C1969g {

    /* renamed from: a */
    public final String f5072a;

    /* renamed from: b */
    protected final String f5073b;

    /* renamed from: c */
    protected final String f5074c;

    /* renamed from: d */
    protected final String f5075d;

    /* renamed from: e */
    protected final String f5076e;

    /* renamed from: f */
    protected final String f5077f;

    /* renamed from: g */
    protected final int f5078g;

    public C1969g(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.f5072a = str;
        this.f5073b = str2;
        this.f5074c = str3;
        this.f5075d = str4;
        this.f5076e = str5;
        this.f5077f = str6;
        this.f5078g = i;
    }

    /* renamed from: a */
    private static boolean m7326a(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    /* renamed from: a */
    public C1987w.C1989b mo10414a(XMPushService xMPushService) {
        C1987w.C1989b bVar = new C1987w.C1989b(xMPushService);
        bVar.f5127a = xMPushService.getPackageName();
        bVar.f5128b = this.f5072a;
        bVar.f5135i = this.f5074c;
        bVar.f5129c = this.f5073b;
        bVar.f5134h = "5";
        bVar.f5130d = "XMPUSH-PASS";
        bVar.f5131e = false;
        bVar.f5132f = "sdk_ver:8";
        bVar.f5133g = String.format("%1$s:%2$s,%3$s:%4$s", "appid", m7326a(xMPushService) ? "1000271" : this.f5075d, "locale", Locale.getDefault().toString());
        bVar.f5137k = xMPushService.mo10366d();
        return bVar;
    }
}
