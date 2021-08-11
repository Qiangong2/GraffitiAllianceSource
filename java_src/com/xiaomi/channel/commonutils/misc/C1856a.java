package com.xiaomi.channel.commonutils.misc;

/* renamed from: com.xiaomi.channel.commonutils.misc.a */
public class C1856a {

    /* renamed from: a */
    public static final boolean f4607a = "@SHIP.TO.2A2FE0D7@".contains("2A2FE0D7");

    /* renamed from: b */
    public static final boolean f4608b = (f4607a || "DEBUG".equalsIgnoreCase("@SHIP.TO.2A2FE0D7@"));

    /* renamed from: c */
    public static final boolean f4609c = "LOGABLE".equalsIgnoreCase("@SHIP.TO.2A2FE0D7@");

    /* renamed from: d */
    public static final boolean f4610d = "@SHIP.TO.2A2FE0D7@".contains("YY");

    /* renamed from: e */
    public static boolean f4611e = "@SHIP.TO.2A2FE0D7@".equalsIgnoreCase("TEST");

    /* renamed from: f */
    public static final boolean f4612f = "BETA".equalsIgnoreCase("@SHIP.TO.2A2FE0D7@");

    /* renamed from: g */
    public static final boolean f4613g;

    /* renamed from: h */
    private static int f4614h;

    static {
        boolean z = false;
        if ("@SHIP.TO.2A2FE0D7@" != 0 && "@SHIP.TO.2A2FE0D7@".startsWith("RC")) {
            z = true;
        }
        f4613g = z;
        f4614h = 1;
        if ("@SHIP.TO.2A2FE0D7@".equalsIgnoreCase("SANDBOX")) {
            f4614h = 2;
        } else if ("@SHIP.TO.2A2FE0D7@".equalsIgnoreCase("ONEBOX")) {
            f4614h = 3;
        } else {
            f4614h = 1;
        }
    }

    /* renamed from: a */
    public static void m6725a(int i) {
        f4614h = i;
    }

    /* renamed from: a */
    public static boolean m6726a() {
        return f4614h == 2;
    }

    /* renamed from: b */
    public static boolean m6727b() {
        return f4614h == 3;
    }

    /* renamed from: c */
    public static int m6728c() {
        return f4614h;
    }
}
