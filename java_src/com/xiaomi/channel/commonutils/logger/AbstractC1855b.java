package com.xiaomi.channel.commonutils.logger;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.xiaomi.channel.commonutils.logger.b */
public abstract class AbstractC1855b {

    /* renamed from: a */
    private static int f4601a = 2;

    /* renamed from: b */
    private static LoggerInterface f4602b = new C1854a();

    /* renamed from: c */
    private static final HashMap<Integer, Long> f4603c = new HashMap<>();

    /* renamed from: d */
    private static final HashMap<Integer, String> f4604d = new HashMap<>();

    /* renamed from: e */
    private static final Integer f4605e = -1;

    /* renamed from: f */
    private static AtomicInteger f4606f = new AtomicInteger(1);

    /* renamed from: a */
    public static void m6713a(int i, String str) {
        if (i >= f4601a) {
            f4602b.log(str);
        }
    }

    /* renamed from: a */
    public static void m6714a(int i, String str, Throwable th) {
        if (i >= f4601a) {
            f4602b.log(str, th);
        }
    }

    /* renamed from: a */
    public static void m6715a(int i, Throwable th) {
        if (i >= f4601a) {
            f4602b.log("", th);
        }
    }

    /* renamed from: a */
    public static void m6716a(LoggerInterface loggerInterface) {
        f4602b = loggerInterface;
    }

    /* renamed from: a */
    public static void m6717a(Integer num) {
        if (f4601a <= 1 && f4603c.containsKey(num)) {
            long currentTimeMillis = System.currentTimeMillis() - f4603c.remove(num).longValue();
            f4602b.log(f4604d.remove(num) + " ends in " + currentTimeMillis + " ms");
        }
    }

    /* renamed from: a */
    public static void m6718a(String str) {
        m6713a(2, "[Thread:" + Thread.currentThread().getId() + "] " + str);
    }

    /* renamed from: a */
    public static void m6719a(String str, Throwable th) {
        m6714a(4, str, th);
    }

    /* renamed from: a */
    public static void m6720a(Throwable th) {
        m6715a(4, th);
    }

    /* renamed from: b */
    public static void m6721b(String str) {
        m6713a(0, str);
    }

    /* renamed from: c */
    public static void m6722c(String str) {
        m6713a(1, "[Thread:" + Thread.currentThread().getId() + "] " + str);
    }

    /* renamed from: d */
    public static void m6723d(String str) {
        m6713a(4, str);
    }

    /* renamed from: e */
    public static Integer m6724e(String str) {
        if (f4601a > 1) {
            return f4605e;
        }
        Integer valueOf = Integer.valueOf(f4606f.incrementAndGet());
        f4603c.put(valueOf, Long.valueOf(System.currentTimeMillis()));
        f4604d.put(valueOf, str);
        f4602b.log(str + " starts");
        return valueOf;
    }
}
