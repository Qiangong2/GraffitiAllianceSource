package com.amap.loc;

/* renamed from: com.amap.loc.bv */
/* compiled from: GeoHash */
public class C0303bv {

    /* renamed from: a */
    private static final char[] f586a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /* renamed from: b */
    private static final int[] f587b = {16, 8, 4, 2, 1};

    /* renamed from: a */
    public static final String m881a(double d, double d2) {
        return m882a(d, d2, 6);
    }

    /* renamed from: a */
    public static final String m882a(double d, double d2, int i) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        int i2 = 0;
        int i3 = 0;
        double[] dArr = {-90.0d, 90.0d};
        double[] dArr2 = {-180.0d, 180.0d};
        while (sb.length() < i) {
            if (z) {
                double d3 = (dArr2[0] + dArr2[1]) / 2.0d;
                if (d2 > d3) {
                    i3 |= f587b[i2];
                    dArr2[0] = d3;
                } else {
                    dArr2[1] = d3;
                }
            } else {
                double d4 = (dArr[0] + dArr[1]) / 2.0d;
                if (d > d4) {
                    i3 |= f587b[i2];
                    dArr[0] = d4;
                } else {
                    dArr[1] = d4;
                }
            }
            z = !z;
            if (i2 < 4) {
                i2++;
            } else {
                sb.append(f586a[i3]);
                i2 = 0;
                i3 = 0;
            }
        }
        return sb.toString();
    }
}
