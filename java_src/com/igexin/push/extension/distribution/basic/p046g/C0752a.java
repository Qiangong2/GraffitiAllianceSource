package com.igexin.push.extension.distribution.basic.p046g;

import android.app.NotificationManager;
import android.content.Context;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.extension.distribution.basic.p046g.p047a.C0753a;
import com.igexin.push.extension.distribution.basic.p046g.p047a.C0754b;
import com.igexin.push.extension.distribution.basic.p046g.p047a.RunnableC0757e;
import com.igexin.push.extension.distribution.basic.p046g.p048b.C0758a;
import com.igexin.push.extension.distribution.basic.p046g.p048b.C0759b;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.igexin.push.extension.distribution.basic.g.a */
public class C0752a {

    /* renamed from: a */
    public static String f2082a = "/sdcard/libs/tmp/";

    /* renamed from: b */
    private static C0752a f2083b;

    /* renamed from: c */
    private Context f2084c;

    /* renamed from: d */
    private AtomicBoolean f2085d = new AtomicBoolean(false);

    private C0752a(Context context, String str) {
        this.f2084c = context;
        C0758a.f2116a = str;
    }

    /* renamed from: a */
    public static C0752a m3056a(Context context, String str) {
        if (f2083b == null) {
            f2083b = new C0752a(context, str);
        }
        return f2083b;
    }

    /* renamed from: d */
    private boolean m3057d() {
        File file = new File(f2082a);
        if (!file.exists()) {
            return file.mkdirs();
        }
        return true;
    }

    /* renamed from: a */
    public long mo5057a(C0753a aVar) {
        mo5058a();
        try {
            aVar.mo5064a(C0759b.m3088a(this.f2084c).mo5088a(aVar));
            C0754b.m3084a().mo5082a(this.f2084c, new RunnableC0757e(this.f2084c, aVar));
        } catch (Throwable th) {
        }
        return aVar.mo5062a();
    }

    /* renamed from: a */
    public void mo5058a() {
        if (this.f2085d.getAndSet(true)) {
            ActivityC0460a.m1698b("EXT-download-Downloader |downloader started");
            return;
        }
        ActivityC0460a.m1698b("EXT-download-Downloader|downloader starting...");
        try {
            if (m3057d()) {
                for (C0753a aVar : C0753a.m3063a(C0759b.m3088a(this.f2084c).mo5089a())) {
                    C0754b.m3084a().mo5082a(this.f2084c, new RunnableC0757e(this.f2084c, aVar));
                }
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    public void mo5059a(int i) {
        ((NotificationManager) this.f2084c.getSystemService("notification")).cancel(i);
        C0759b.m3088a(this.f2084c).mo5090a(i);
    }

    /* renamed from: b */
    public void mo5060b() {
        this.f2085d.set(false);
        mo5058a();
    }

    /* renamed from: c */
    public boolean mo5061c() {
        try {
            List<C0753a> a = C0753a.m3063a(C0759b.m3088a(this.f2084c).mo5089a());
            return a != null && a.size() > 0;
        } catch (Throwable th) {
        }
    }
}
