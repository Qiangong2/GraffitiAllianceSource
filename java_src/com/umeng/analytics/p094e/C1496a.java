package com.umeng.analytics.p094e;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.p091b.C1447g;
import com.umeng.analytics.p092c.C1451c;
import com.umeng.analytics.p092c.C1457h;
import com.umeng.analytics.p093d.AbstractC1487l;
import com.umeng.p085a.C1346h;
import com.xiaomi.mipush.sdk.MiPushClient;

/* renamed from: com.umeng.analytics.e.a */
/* compiled from: ABTest */
public class C1496a implements AbstractC1487l {

    /* renamed from: i */
    private static C1496a f3715i = null;

    /* renamed from: a */
    private boolean f3716a = false;

    /* renamed from: b */
    private int f3717b = -1;

    /* renamed from: c */
    private int f3718c = -1;

    /* renamed from: d */
    private int f3719d = -1;

    /* renamed from: e */
    private float f3720e = 0.0f;

    /* renamed from: f */
    private float f3721f = 0.0f;

    /* renamed from: g */
    private String f3722g = null;

    /* renamed from: h */
    private Context f3723h = null;

    /* renamed from: a */
    public static synchronized C1496a m5568a(Context context) {
        C1496a aVar;
        synchronized (C1496a.class) {
            if (f3715i == null) {
                C1457h.C1458a b = C1457h.m5380a(context).mo8580b();
                f3715i = new C1496a(context, b.mo8599f(null), b.mo8596d(0));
            }
            aVar = f3715i;
        }
        return aVar;
    }

    private C1496a(Context context, String str, int i) {
        this.f3723h = context;
        mo8670a(str, i);
    }

    /* renamed from: b */
    private float m5570b(String str, int i) {
        int i2 = i * 2;
        if (str == null) {
            return 0.0f;
        }
        return ((float) Integer.valueOf(str.substring(i2, i2 + 5), 16).intValue()) / 1048576.0f;
    }

    /* renamed from: a */
    public void mo8670a(String str, int i) {
        this.f3718c = i;
        String a = C1451c.m5348a(this.f3723h);
        if (TextUtils.isEmpty(a) || TextUtils.isEmpty(str)) {
            this.f3716a = false;
            return;
        }
        try {
            this.f3720e = m5570b(a, 12);
            this.f3721f = m5570b(a, 6);
            if (str.startsWith("SIG7")) {
                m5571b(str);
            } else if (str.startsWith("FIXED")) {
                m5572c(str);
            }
        } catch (Exception e) {
            this.f3716a = false;
            C1346h.m5011e("v:" + str, e);
        }
    }

    /* renamed from: a */
    public static boolean m5569a(String str) {
        int parseInt;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] split = str.split("\\|");
        if (split.length != 6) {
            return false;
        }
        if (!split[0].startsWith("SIG7") || split[1].split(MiPushClient.ACCEPT_TIME_SEPARATOR).length != split[5].split(MiPushClient.ACCEPT_TIME_SEPARATOR).length) {
            return split[0].startsWith("FIXED") && split[5].split(MiPushClient.ACCEPT_TIME_SEPARATOR).length >= (parseInt = Integer.parseInt(split[1])) && parseInt >= 1;
        }
        return true;
    }

    /* renamed from: b */
    private void m5571b(String str) {
        if (str != null) {
            String[] split = str.split("\\|");
            if (this.f3720e > (split[2].equals("SIG13") ? Float.valueOf(split[3]).floatValue() : 0.0f)) {
                this.f3716a = false;
                return;
            }
            float[] fArr = null;
            if (split[0].equals("SIG7")) {
                String[] split2 = split[1].split(MiPushClient.ACCEPT_TIME_SEPARATOR);
                float[] fArr2 = new float[split2.length];
                for (int i = 0; i < split2.length; i++) {
                    fArr2[i] = Float.valueOf(split2[i]).floatValue();
                }
                fArr = fArr2;
            }
            int[] iArr = null;
            if (split[4].equals("RPT")) {
                this.f3722g = "RPT";
                String[] split3 = split[5].split(MiPushClient.ACCEPT_TIME_SEPARATOR);
                int[] iArr2 = new int[split3.length];
                for (int i2 = 0; i2 < split3.length; i2++) {
                    iArr2[i2] = Integer.valueOf(split3[i2]).intValue();
                }
                iArr = iArr2;
            } else if (split[4].equals("DOM")) {
                this.f3716a = true;
                this.f3722g = "DOM";
                try {
                    String[] split4 = split[5].split(MiPushClient.ACCEPT_TIME_SEPARATOR);
                    iArr = new int[split4.length];
                    for (int i3 = 0; i3 < split4.length; i3++) {
                        iArr[i3] = Integer.valueOf(split4[i3]).intValue();
                    }
                } catch (Exception e) {
                }
            }
            float f = 0.0f;
            int i4 = 0;
            while (true) {
                if (i4 >= fArr.length) {
                    i4 = -1;
                    break;
                }
                f += fArr[i4];
                if (this.f3721f < f) {
                    break;
                }
                i4++;
            }
            if (i4 != -1) {
                this.f3716a = true;
                this.f3719d = i4 + 1;
                if (iArr != null) {
                    this.f3717b = iArr[i4];
                    return;
                }
                return;
            }
            this.f3716a = false;
        }
    }

    /* renamed from: c */
    private void m5572c(String str) {
        if (str != null) {
            String[] split = str.split("\\|");
            float f = 0.0f;
            if (split[2].equals("SIG13")) {
                f = Float.valueOf(split[3]).floatValue();
            }
            if (this.f3720e > f) {
                this.f3716a = false;
                return;
            }
            int intValue = split[0].equals("FIXED") ? Integer.valueOf(split[1]).intValue() : -1;
            int[] iArr = null;
            if (split[4].equals("RPT")) {
                this.f3722g = "RPT";
                String[] split2 = split[5].split(MiPushClient.ACCEPT_TIME_SEPARATOR);
                int[] iArr2 = new int[split2.length];
                for (int i = 0; i < split2.length; i++) {
                    iArr2[i] = Integer.valueOf(split2[i]).intValue();
                }
                iArr = iArr2;
            } else if (split[4].equals("DOM")) {
                this.f3722g = "DOM";
                this.f3716a = true;
                try {
                    String[] split3 = split[5].split(MiPushClient.ACCEPT_TIME_SEPARATOR);
                    iArr = new int[split3.length];
                    for (int i2 = 0; i2 < split3.length; i2++) {
                        iArr[i2] = Integer.valueOf(split3[i2]).intValue();
                    }
                } catch (Exception e) {
                }
            }
            if (intValue != -1) {
                this.f3716a = true;
                this.f3719d = intValue;
                if (iArr != null) {
                    this.f3717b = iArr[intValue - 1];
                    return;
                }
                return;
            }
            this.f3716a = false;
        }
    }

    /* renamed from: a */
    public boolean mo8671a() {
        return this.f3716a;
    }

    /* renamed from: b */
    public int mo8672b() {
        return this.f3717b;
    }

    /* renamed from: c */
    public int mo8673c() {
        return this.f3718c;
    }

    /* renamed from: d */
    public int mo8674d() {
        return this.f3719d;
    }

    /* renamed from: e */
    public String mo8675e() {
        if (!this.f3716a) {
            return C1447g.f3469aF;
        }
        return String.valueOf(this.f3719d);
    }

    /* renamed from: f */
    public String mo8676f() {
        return this.f3722g;
    }

    @Override // com.umeng.analytics.p093d.AbstractC1487l
    /* renamed from: a */
    public void mo8620a(C1457h.C1458a aVar) {
        mo8670a(aVar.mo8599f(null), aVar.mo8596d(0));
    }

    public String toString() {
        return " p13:" + this.f3720e + " p07:" + this.f3721f + " policy:" + this.f3717b + " interval:" + this.f3718c;
    }
}
