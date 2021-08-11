package com.amap.api.location;

import android.content.Context;
import android.text.TextUtils;
import com.amap.loc.C0310c;
import com.amap.loc.C0332cs;
import com.amap.loc.C0358p;
import java.io.File;
import java.math.BigDecimal;

/* renamed from: com.amap.api.location.a */
/* compiled from: OffsetUtil */
public class C0214a {

    /* renamed from: a */
    static double f215a = 3.141592653589793d;

    /* renamed from: b */
    private static boolean f216b = false;

    /* renamed from: a */
    private static double m349a(double d) {
        return Math.sin(3000.0d * d * (f215a / 180.0d)) * 2.0E-5d;
    }

    /* renamed from: a */
    public static double m350a(double d, double d2) {
        return (Math.cos(d2 / 100000.0d) * (d / 18000.0d)) + (Math.sin(d / 100000.0d) * (d2 / 9000.0d));
    }

    /* renamed from: a */
    private static double m351a(double d, int i) {
        return new BigDecimal(d).setScale(i, 4).doubleValue();
    }

    /* renamed from: a */
    private static DPoint m352a(double d, double d2, double d3, double d4) {
        DPoint dPoint = new DPoint();
        double d5 = d - d3;
        double d6 = d2 - d4;
        DPoint d7 = m362d(d5, d6);
        dPoint.setLongitude(m351a((d5 + d) - d7.getLongitude(), 8));
        dPoint.setLatitude(m351a((d2 + d6) - d7.getLatitude(), 8));
        return dPoint;
    }

    /* renamed from: a */
    public static DPoint m353a(Context context, double d, double d2) {
        if (context == null) {
            return null;
        }
        return m354a(context, new DPoint(d2, d));
    }

    /* renamed from: a */
    public static DPoint m354a(Context context, DPoint dPoint) {
        if (context == null) {
            return null;
        }
        String a = C0358p.m1319a(context, "libwgs2gcj.so");
        if (!TextUtils.isEmpty(a) && new File(a).exists() && !f216b) {
            try {
                System.load(a);
                f216b = true;
            } catch (Throwable th) {
                C0310c.m956a(th, "OffsetUtil", "offset");
            }
        }
        return m357a(dPoint, f216b);
    }

    /* renamed from: a */
    public static DPoint m355a(DPoint dPoint) {
        if (dPoint == null) {
            return dPoint;
        }
        try {
            return m356a(dPoint, 2);
        } catch (Throwable th) {
            C0310c.m956a(th, "OffsetUtil", "B2G");
            return dPoint;
        }
    }

    /* renamed from: a */
    private static DPoint m356a(DPoint dPoint, int i) {
        double d = 0.006401062d;
        double d2 = 0.0060424805d;
        int i2 = 0;
        DPoint dPoint2 = null;
        while (i2 < i) {
            DPoint a = m352a(dPoint.getLongitude(), dPoint.getLatitude(), d, d2);
            d = dPoint.getLongitude() - a.getLongitude();
            d2 = dPoint.getLatitude() - a.getLatitude();
            i2++;
            dPoint2 = a;
        }
        return dPoint2;
    }

    /* renamed from: a */
    private static DPoint m357a(DPoint dPoint, boolean z) {
        double[] a;
        try {
            if (!C0310c.m957a(dPoint.getLatitude(), dPoint.getLongitude())) {
                return dPoint;
            }
            double[] dArr = new double[2];
            if (z) {
                try {
                    if (CoordUtil.convertToGcj(new double[]{dPoint.getLongitude(), dPoint.getLatitude()}, dArr) != 0) {
                    }
                } catch (Throwable th) {
                    C0310c.m956a(th, "OffsetUtil", "cover part1");
                } finally {
                    C0332cs.m1199a(dPoint.getLongitude(), dPoint.getLatitude());
                }
                a = dArr;
            } else {
                a = C0332cs.m1199a(dPoint.getLongitude(), dPoint.getLatitude());
            }
            return new DPoint(a[1], a[0]);
        } catch (Throwable th2) {
            C0310c.m956a(th2, "OffsetUtil", "cover part2");
            return dPoint;
        }
    }

    /* renamed from: b */
    private static double m358b(double d) {
        return Math.cos(3000.0d * d * (f215a / 180.0d)) * 3.0E-6d;
    }

    /* renamed from: b */
    public static double m359b(double d, double d2) {
        return (Math.sin(d2 / 100000.0d) * (d / 18000.0d)) + (Math.cos(d / 100000.0d) * (d2 / 9000.0d));
    }

    /* renamed from: b */
    public static DPoint m360b(Context context, DPoint dPoint) {
        try {
            return m354a(context, m361c(dPoint.getLongitude(), dPoint.getLatitude()));
        } catch (Throwable th) {
            C0310c.m956a(th, "OffsetUtil", "marbar2G");
            return dPoint;
        }
    }

    /* renamed from: c */
    private static DPoint m361c(double d, double d2) {
        double d3 = (double) (((long) (100000.0d * d)) % 36000000);
        double d4 = (double) (((long) (100000.0d * d2)) % 36000000);
        int i = (int) ((-m359b(d3, d4)) + d4);
        int i2 = (int) (((double) (d3 > 0.0d ? 1 : -1)) + (-m350a((double) ((int) ((-m350a(d3, d4)) + d3)), (double) i)) + d3);
        return new DPoint(((double) ((int) (((double) (d4 > 0.0d ? 1 : -1)) + ((-m359b((double) i2, (double) i)) + d4)))) / 100000.0d, ((double) i2) / 100000.0d);
    }

    /* renamed from: d */
    private static DPoint m362d(double d, double d2) {
        DPoint dPoint = new DPoint();
        dPoint.setLongitude(m351a((Math.cos(m358b(d) + Math.atan2(d2, d)) * (m349a(d2) + Math.sqrt((d * d) + (d2 * d2)))) + 0.0065d, 8));
        dPoint.setLatitude(m351a((Math.sin(m358b(d) + Math.atan2(d2, d)) * (m349a(d2) + Math.sqrt((d * d) + (d2 * d2)))) + 0.006d, 8));
        return dPoint;
    }
}
