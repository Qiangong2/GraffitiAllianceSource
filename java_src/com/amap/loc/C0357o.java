package com.amap.loc;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;

/* renamed from: com.amap.loc.o */
/* compiled from: ProxyUtil */
public class C0357o {
    /* renamed from: a */
    private static String m1311a() {
        String str;
        try {
            str = Proxy.getDefaultHost();
        } catch (Throwable th) {
            C0365t.m1372a(th, "ProxyUtil", "getDefHost");
            str = null;
        }
        return str == null ? "null" : str;
    }

    /* renamed from: a */
    public static String m1312a(String str) {
        return C0363r.m1362c(str);
    }

    /* renamed from: a */
    public static java.net.Proxy m1313a(Context context) {
        try {
            return Build.VERSION.SDK_INT >= 11 ? m1314a(context, new URI("http://restapi.amap.com")) : m1317b(context);
        } catch (Throwable th) {
            C0365t.m1372a(th, "ProxyUtil", "getProxy");
            return null;
        }
    }

    /* renamed from: a */
    private static java.net.Proxy m1314a(Context context, URI uri) {
        if (m1318c(context)) {
            try {
                List<java.net.Proxy> select = ProxySelector.getDefault().select(uri);
                if (select == null || select.isEmpty()) {
                    return null;
                }
                java.net.Proxy proxy = select.get(0);
                if (proxy == null || proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                return proxy;
            } catch (Throwable th) {
                C0365t.m1372a(th, "ProxyUtil", "getProxySelectorCfg");
            }
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m1315a(String str, int i) {
        return (str == null || str.length() <= 0 || i == -1) ? false : true;
    }

    /* renamed from: b */
    private static int m1316b() {
        try {
            return android.net.Proxy.getDefaultPort();
        } catch (Throwable th) {
            C0365t.m1372a(th, "ProxyUtil", "getDefPort");
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0067 A[SYNTHETIC, Splitter:B:30:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070 A[Catch:{ Throwable -> 0x0162 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00c6 A[Catch:{ all -> 0x0172 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00f9 A[SYNTHETIC, Splitter:B:72:0x00f9] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x013c A[SYNTHETIC, Splitter:B:92:0x013c] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0152 A[SYNTHETIC, Splitter:B:99:0x0152] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.net.Proxy m1317b(android.content.Context r12) {
        /*
        // Method dump skipped, instructions count: 447
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0357o.m1317b(android.content.Context):java.net.Proxy");
    }

    /* renamed from: c */
    private static boolean m1318c(Context context) {
        return C0353l.m1280m(context) == 0;
    }
}
