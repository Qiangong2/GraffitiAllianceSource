package com.umeng.p085a;

import android.util.Log;
import com.umeng.analytics.C1370a;
import java.util.Formatter;
import java.util.Locale;

/* renamed from: com.umeng.a.h */
/* compiled from: MLog */
public class C1346h {

    /* renamed from: a */
    public static boolean f3145a = false;

    /* renamed from: b */
    private static String f3146b = C1370a.f3211c;

    /* renamed from: c */
    private static final int f3147c = 1;

    /* renamed from: d */
    private static final int f3148d = 2;

    /* renamed from: e */
    private static final int f3149e = 3;

    /* renamed from: f */
    private static final int f3150f = 4;

    /* renamed from: g */
    private static final int f3151g = 5;

    /* renamed from: h */
    private static int f3152h = 2000;

    private C1346h() {
    }

    /* renamed from: a */
    public static void m4990a(Locale locale, String str, Object... objArr) {
        try {
            m4998c(f3146b, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m5013e(th);
        }
    }

    /* renamed from: b */
    public static void m4996b(Locale locale, String str, Object... objArr) {
        try {
            m4992b(f3146b, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m5013e(th);
        }
    }

    /* renamed from: c */
    public static void m5002c(Locale locale, String str, Object... objArr) {
        try {
            m5010e(f3146b, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m5013e(th);
        }
    }

    /* renamed from: d */
    public static void m5008d(Locale locale, String str, Object... objArr) {
        try {
            m4986a(f3146b, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m5013e(th);
        }
    }

    /* renamed from: e */
    public static void m5014e(Locale locale, String str, Object... objArr) {
        try {
            m5004d(f3146b, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m5013e(th);
        }
    }

    /* renamed from: a */
    public static void m4988a(String str, Object... objArr) {
        String str2 = "";
        try {
            if (str.contains("%")) {
                m4998c(f3146b, new Formatter().format(str, objArr).toString(), (Throwable) null);
                return;
            }
            if (objArr != null) {
                str2 = (String) objArr[0];
            }
            m4998c(str, str2, (Throwable) null);
        } catch (Throwable th) {
            m5013e(th);
        }
    }

    /* renamed from: b */
    public static void m4994b(String str, Object... objArr) {
        String str2 = "";
        try {
            if (str.contains("%")) {
                m4992b(f3146b, new Formatter().format(str, objArr).toString(), (Throwable) null);
                return;
            }
            if (objArr != null) {
                str2 = (String) objArr[0];
            }
            m4992b(str, str2, (Throwable) null);
        } catch (Throwable th) {
            m5013e(th);
        }
    }

    /* renamed from: c */
    public static void m5000c(String str, Object... objArr) {
        String str2 = "";
        try {
            if (str.contains("%")) {
                m5010e(f3146b, new Formatter().format(str, objArr).toString(), (Throwable) null);
                return;
            }
            if (objArr != null) {
                str2 = (String) objArr[0];
            }
            m5010e(str, str2, (Throwable) null);
        } catch (Throwable th) {
            m5013e(th);
        }
    }

    /* renamed from: d */
    public static void m5006d(String str, Object... objArr) {
        String str2 = "";
        try {
            if (str.contains("%")) {
                m4986a(f3146b, new Formatter().format(str, objArr).toString(), (Throwable) null);
                return;
            }
            if (objArr != null) {
                str2 = (String) objArr[0];
            }
            m4986a(str, str2, (Throwable) null);
        } catch (Throwable th) {
            m5013e(th);
        }
    }

    /* renamed from: e */
    public static void m5012e(String str, Object... objArr) {
        String str2 = "";
        try {
            if (str.contains("%")) {
                m5004d(f3146b, new Formatter().format(str, objArr).toString(), (Throwable) null);
                return;
            }
            if (objArr != null) {
                str2 = (String) objArr[0];
            }
            m5004d(str, str2, (Throwable) null);
        } catch (Throwable th) {
            m5013e(th);
        }
    }

    /* renamed from: a */
    public static void m4989a(Throwable th) {
        m4998c(f3146b, (String) null, th);
    }

    /* renamed from: b */
    public static void m4995b(Throwable th) {
        m4986a(f3146b, (String) null, th);
    }

    /* renamed from: c */
    public static void m5001c(Throwable th) {
        m5004d(f3146b, (String) null, th);
    }

    /* renamed from: d */
    public static void m5007d(Throwable th) {
        m4992b(f3146b, (String) null, th);
    }

    /* renamed from: e */
    public static void m5013e(Throwable th) {
        m5010e(f3146b, (String) null, th);
    }

    /* renamed from: a */
    public static void m4987a(String str, Throwable th) {
        m4998c(f3146b, str, th);
    }

    /* renamed from: b */
    public static void m4993b(String str, Throwable th) {
        m4986a(f3146b, str, th);
    }

    /* renamed from: c */
    public static void m4999c(String str, Throwable th) {
        m5004d(f3146b, str, th);
    }

    /* renamed from: d */
    public static void m5005d(String str, Throwable th) {
        m4992b(f3146b, str, th);
    }

    /* renamed from: e */
    public static void m5011e(String str, Throwable th) {
        m5010e(f3146b, str, th);
    }

    /* renamed from: a */
    public static void m4985a(String str) {
        m4986a(f3146b, str, (Throwable) null);
    }

    /* renamed from: b */
    public static void m4991b(String str) {
        m4992b(f3146b, str, (Throwable) null);
    }

    /* renamed from: c */
    public static void m4997c(String str) {
        m4998c(f3146b, str, (Throwable) null);
    }

    /* renamed from: d */
    public static void m5003d(String str) {
        m5004d(f3146b, str, (Throwable) null);
    }

    /* renamed from: e */
    public static void m5009e(String str) {
        m5010e(f3146b, str, (Throwable) null);
    }

    /* renamed from: a */
    public static void m4986a(String str, String str2, Throwable th) {
        if (f3145a) {
            m4984a(1, str, str2, th);
        }
    }

    /* renamed from: b */
    public static void m4992b(String str, String str2, Throwable th) {
        if (f3145a) {
            m4984a(2, str, str2, th);
        }
    }

    /* renamed from: c */
    public static void m4998c(String str, String str2, Throwable th) {
        if (f3145a) {
            m4984a(3, str, str2, th);
        }
    }

    /* renamed from: d */
    public static void m5004d(String str, String str2, Throwable th) {
        if (f3145a) {
            m4984a(4, str, str2, th);
        }
    }

    /* renamed from: e */
    public static void m5010e(String str, String str2, Throwable th) {
        if (f3145a) {
            m4984a(5, str, str2, th);
        }
    }

    /* renamed from: a */
    private static void m4984a(int i, String str, String str2, Throwable th) {
        int length = str2.length();
        int i2 = 0;
        int i3 = f3152h;
        int i4 = 0;
        while (i2 < 100) {
            if (length > i3) {
                switch (i) {
                    case 1:
                        Log.v(str, str2.substring(i4, i3));
                        break;
                    case 2:
                        Log.d(str, str2.substring(i4, i3));
                        break;
                    case 3:
                        Log.i(str, str2.substring(i4, i3));
                        break;
                    case 4:
                        Log.w(str, str2.substring(i4, i3));
                        break;
                    case 5:
                        Log.e(str, str2.substring(i4, i3));
                        break;
                }
                int i5 = i3 + f3152h;
                if (th != null) {
                    StackTraceElement[] stackTrace = th.getStackTrace();
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        switch (i) {
                            case 1:
                                Log.v(str, "\t\tat\t" + stackTraceElement.toString());
                                break;
                            case 2:
                                Log.d(str, "\t\tat\t" + stackTraceElement.toString());
                                break;
                            case 3:
                                Log.i(str, "\t\tat\t" + stackTraceElement.toString());
                                break;
                            case 4:
                                Log.w(str, "\t\tat\t" + stackTraceElement.toString());
                                break;
                            case 5:
                                Log.e(str, "\t\tat\t" + stackTraceElement.toString());
                                break;
                        }
                    }
                }
                i2++;
                i4 = i3;
                i3 = i5;
            } else {
                switch (i) {
                    case 1:
                        Log.v(str, str2.substring(i4, length));
                        return;
                    case 2:
                        Log.d(str, str2.substring(i4, length));
                        return;
                    case 3:
                        Log.i(str, str2.substring(i4, length));
                        return;
                    case 4:
                        Log.w(str, str2.substring(i4, length));
                        return;
                    case 5:
                        Log.e(str, str2.substring(i4, length));
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
