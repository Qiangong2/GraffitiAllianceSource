package com.umeng.analytics.p086a.p090d;

import com.umeng.analytics.C1370a;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* renamed from: com.umeng.analytics.a.d.e */
/* compiled from: UMCCTimeRange */
public class C1419e {

    /* renamed from: a */
    public static final int f3346a = 1;

    /* renamed from: b */
    private static final int f3347b = 1000;

    /* renamed from: c */
    private static final int f3348c = 1001;

    /* renamed from: d */
    private static final int f3349d = 1002;

    /* renamed from: a */
    public static String m5243a(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        return String.valueOf(((long) ((((instance.get(12) / 6) + 1) + (instance.get(11) * 10)) - 1)) + (m5245b(j) * 240));
    }

    /* renamed from: b */
    public static long m5245b(long j) {
        long j2 = 0;
        try {
            long time = new SimpleDateFormat("yyyy", Locale.getDefault()).parse("1970").getTime();
            long j3 = (j - time) / C1370a.f3217i;
            if ((j - time) % C1370a.f3217i > 0) {
                j2 = 1;
            }
            return j2 + j3;
        } catch (Throwable th) {
            return 0;
        }
    }

    /* renamed from: c */
    public static long m5246c(long j) {
        return m5242a(j, (int) f3348c);
    }

    /* renamed from: d */
    public static long m5247d(long j) {
        return m5242a(j, (int) f3349d);
    }

    /* renamed from: a */
    private static long m5242a(long j, int i) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        int i2 = (instance.get(12) / 6) + 1 + (instance.get(11) * 10);
        int i3 = instance.get(13);
        int i4 = 0;
        if (i == f3349d) {
            i4 = 360 - (((instance.get(12) % 6) * 60) + i3);
        } else if (i == f3348c) {
            i4 = 60 - (i3 % 60);
            if (i2 % 6 == 0) {
                i4 += 60;
            }
        }
        return (long) (i4 * f3347b);
    }

    /* renamed from: a */
    public static boolean m5244a(long j, long j2) {
        if (m5248e(j) == m5248e(j2)) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    private static int m5248e(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        return instance.get(5);
    }
}
