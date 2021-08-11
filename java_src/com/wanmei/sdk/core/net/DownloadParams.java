package com.wanmei.sdk.core.net;

public final class DownloadParams {

    /* renamed from: a */
    protected static String f4456a;

    /* renamed from: b */
    protected static String f4457b;

    /* renamed from: c */
    protected static String f4458c;

    /* renamed from: d */
    private static Mode f4459d = Mode.online;

    /* renamed from: e */
    private static String f4460e;

    public enum Mode {
        online,
        testOnline,
        sample,
        sampleTest
    }

    /* renamed from: a */
    public static void m6502a() {
        switch (f4459d) {
            case online:
                f4460e = "https://apidev.laohu.com/sdkapi";
                f4456a = "http://faq.csh.laohu.com/faq";
                f4457b = "queue.csh.laohu.com";
                f4458c = "36101";
                return;
            case testOnline:
                f4460e = "http://testapidev.laohu.com/sdkapi";
                f4456a = "http://faq.csh.laohu.com/faq";
                f4457b = "queue.csh.laohu.com";
                f4458c = "36101";
                return;
            case sample:
                f4460e = "http://apidev.laohu.com/sdkapi/test";
                f4456a = "http://faq.csh.laohu.com/faq";
                f4457b = "queue.csh.laohu.com";
                f4458c = "36101";
                return;
            case sampleTest:
                f4460e = "http://testapidev.laohu.com/sdkapi/test";
                f4456a = "http://faq.csh.laohu.com/faq";
                f4457b = "queue.csh.laohu.com";
                f4458c = "36101";
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public static void m6503a(Mode mode) {
        f4459d = mode;
    }

    /* renamed from: b */
    public static String m6504b() {
        return f4460e + "/user/login";
    }

    /* renamed from: c */
    public static String m6505c() {
        return f4460e + "/bill/preBilling";
    }

    /* renamed from: d */
    public static Mode m6506d() {
        return f4459d;
    }
}
