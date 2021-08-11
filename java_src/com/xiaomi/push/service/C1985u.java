package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.network.Host;
import com.xiaomi.push.protobuf.C1928a;
import com.xiaomi.stats.C2059e;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* renamed from: com.xiaomi.push.service.u */
public class C1985u {

    /* renamed from: a */
    private static final Pattern f5119a = Pattern.compile("([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})");

    /* renamed from: b */
    private static long f5120b = 0;

    /* renamed from: c */
    private static ThreadPoolExecutor f5121c = new ThreadPoolExecutor(1, 1, 20, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a */
    public static void m7402a() {
        C1928a.C1929a d;
        long currentTimeMillis = System.currentTimeMillis();
        if ((f5121c.getActiveCount() <= 0 || currentTimeMillis - f5120b >= 1800000) && C2059e.m7746a().mo10667c() && (d = C1951af.m7272a().mo10391d()) != null && d.mo10326l() > 0) {
            f5120b = currentTimeMillis;
            m7403a(d.mo10325k(), true);
        }
    }

    /* renamed from: a */
    public static void m7403a(List<String> list, boolean z) {
        f5121c.execute(new RunnableC1986v(list, z));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m7405b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            AbstractC1855b.m6718a("ConnectivityTest: begin to connect to " + str);
            Socket socket = new Socket();
            socket.connect(Host.m7055b(str, 5222), 5000);
            socket.setTcpNoDelay(true);
            AbstractC1855b.m6718a("ConnectivityTest: connect to " + str + " in " + (System.currentTimeMillis() - currentTimeMillis));
            socket.close();
            return true;
        } catch (Throwable th) {
            AbstractC1855b.m6723d("ConnectivityTest: could not connect to:" + str + " exception: " + th.getClass().getSimpleName() + " description: " + th.getMessage());
            return false;
        }
    }
}
