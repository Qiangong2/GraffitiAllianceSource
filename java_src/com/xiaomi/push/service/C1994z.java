package com.xiaomi.push.service;

import android.content.Context;
import com.umeng.analytics.C1370a;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.channel.commonutils.network.C1865d;
import com.xiaomi.network.Fallback;
import com.xiaomi.network.HostFilter;
import com.xiaomi.network.HostManager;
import com.xiaomi.network.HostManagerV2;
import com.xiaomi.push.protobuf.C1928a;
import com.xiaomi.push.protobuf.C1930b;
import com.xiaomi.push.service.C1951af;
import com.xiaomi.push.thrift.EnumC1997a;
import com.xiaomi.smack.AbstractC2002a;
import com.xiaomi.smack.util.C2046h;
import com.xiaomi.stats.C2059e;
import com.xiaomi.stats.C2062g;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.xiaomi.push.service.z */
public class C1994z extends C1951af.AbstractC1952a implements HostManager.HostManagerFactory {

    /* renamed from: a */
    private XMPushService f5178a;

    /* renamed from: b */
    private long f5179b;

    /* access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.service.z$a */
    public static class C1995a implements HostManager.HttpGet {
        C1995a() {
        }

        @Override // com.xiaomi.network.HostManager.HttpGet
        /* renamed from: a */
        public String mo10282a(String str) {
            URL url = new URL(str);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            try {
                long currentTimeMillis = System.currentTimeMillis();
                String a = C1865d.m6752a(C2046h.m7706a(), url);
                C2062g.m7765a(url.getHost() + ":" + port, (int) (System.currentTimeMillis() - currentTimeMillis), null);
                return a;
            } catch (IOException e) {
                C2062g.m7765a(url.getHost() + ":" + port, -1, e);
                throw e;
            }
        }
    }

    /* renamed from: com.xiaomi.push.service.z$b */
    static class C1996b extends HostManagerV2 {
        protected C1996b(Context context, HostFilter hostFilter, HostManager.HttpGet httpGet, String str) {
            super(context, hostFilter, httpGet, str);
        }

        /* access modifiers changed from: protected */
        @Override // com.xiaomi.network.HostManagerV2, com.xiaomi.network.HostManager
        public String getRemoteFallbackJSON(ArrayList<String> arrayList, String str, String str2) {
            try {
                if (C2059e.m7746a().mo10667c()) {
                    str2 = C2046h.m7708b();
                }
                return super.getRemoteFallbackJSON(arrayList, str, str2);
            } catch (IOException e) {
                C2062g.m7762a(0, EnumC1997a.GSLB_ERR.mo10447a(), 1, null, C1865d.m6762d(this.sAppContext) ? 1 : 0);
                throw e;
            }
        }
    }

    C1994z(XMPushService xMPushService) {
        this.f5178a = xMPushService;
    }

    /* renamed from: a */
    public static void m7432a(XMPushService xMPushService) {
        C1994z zVar = new C1994z(xMPushService);
        C1951af.m7272a().mo10388a(zVar);
        C1928a.C1929a d = C1951af.m7272a().mo10391d();
        boolean z = true;
        if (d != null && d.mo10320f()) {
            z = d.mo10320f();
        }
        if (z) {
            HostManager.setHostManagerFactory(zVar);
        }
        HostManager.init(xMPushService, null, new C1995a(), "0", "push", "2.2");
    }

    @Override // com.xiaomi.network.HostManager.HostManagerFactory
    /* renamed from: a */
    public HostManager mo10281a(Context context, HostFilter hostFilter, HostManager.HttpGet httpGet, String str) {
        return new C1996b(context, hostFilter, httpGet, str);
    }

    @Override // com.xiaomi.push.service.C1951af.AbstractC1952a
    /* renamed from: a */
    public void mo10392a(C1928a.C1929a aVar) {
        if (aVar.mo10320f()) {
            AbstractC1855b.m6718a("Switch to BucketV2 :" + aVar.mo10319e());
            HostManager instance = HostManager.getInstance();
            synchronized (HostManager.class) {
                if (aVar.mo10319e()) {
                    if (!(instance instanceof HostManagerV2)) {
                        HostManager.setHostManagerFactory(this);
                        HostManager.init(this.f5178a, null, new C1995a(), "0", "push", "2.2");
                    }
                } else if (HostManager.getInstance() instanceof HostManagerV2) {
                    HostManager.setHostManagerFactory(null);
                    HostManager.init(this.f5178a, null, new C1995a(), "0", "push", "2.2");
                }
            }
        }
    }

    @Override // com.xiaomi.push.service.C1951af.AbstractC1952a
    /* renamed from: a */
    public void mo10393a(C1930b.C1931a aVar) {
        Fallback fallbacksByHost;
        boolean z;
        if (aVar.mo10333d() && System.currentTimeMillis() - this.f5179b > C1370a.f3218j) {
            AbstractC1855b.m6718a("fetch bucket :" + aVar.mo10332c());
            this.f5179b = System.currentTimeMillis();
            HostManager instance = HostManager.getInstance();
            instance.clear();
            instance.refreshFallbacks();
            AbstractC2002a g = this.f5178a.mo10369g();
            if (g != null && (fallbacksByHost = instance.getFallbacksByHost(g.mo10494a().mo10532f())) != null) {
                ArrayList<String> d = fallbacksByHost.mo10243d();
                Iterator<String> it = d.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().equals(g.mo10509c())) {
                            z = false;
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
                if (z && !d.isEmpty()) {
                    AbstractC1855b.m6718a("bucket changed, force reconnect");
                    this.f5178a.mo10349a(0, (Exception) null);
                    this.f5178a.mo10356a(false);
                }
            }
        }
    }
}
