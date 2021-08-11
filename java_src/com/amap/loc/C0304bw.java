package com.amap.loc;

import android.support.p007v4.p009os.EnvironmentCompat;
import java.util.Locale;

/* renamed from: com.amap.loc.bw */
/* compiled from: Cgi */
public class C0304bw {

    /* renamed from: a */
    public String f588a = "";

    /* renamed from: b */
    public String f589b = "";

    /* renamed from: c */
    public int f590c = 0;

    /* renamed from: d */
    public int f591d = 0;

    /* renamed from: e */
    public int f592e = 0;

    /* renamed from: f */
    public int f593f = 0;

    /* renamed from: g */
    public int f594g = 0;

    /* renamed from: h */
    public int f595h = 0;

    /* renamed from: i */
    public int f596i = 0;

    /* renamed from: j */
    public int f597j = -113;

    /* renamed from: k */
    public int f598k = 9;

    protected C0304bw(int i) {
        this.f598k = i;
    }

    /* renamed from: a */
    public boolean mo3819a(C0304bw bwVar) {
        if (bwVar == null) {
            return false;
        }
        switch (bwVar.f598k) {
            case 1:
                return this.f598k == 1 && bwVar.f590c == this.f590c && bwVar.f591d == this.f591d && bwVar.f589b != null && bwVar.f589b.equals(this.f589b);
            case 2:
                return this.f598k == 2 && bwVar.f596i == this.f596i && bwVar.f595h == this.f595h && bwVar.f594g == this.f594g;
            default:
                return false;
        }
    }

    public String toString() {
        switch (this.f598k) {
            case 1:
                return String.format(Locale.US, "GSM lac=%d, cid=%d, mnc=%s", Integer.valueOf(this.f590c), Integer.valueOf(this.f591d), this.f589b);
            case 2:
                return String.format(Locale.US, "CDMA bid=%d, nid=%d, sid=%d", Integer.valueOf(this.f596i), Integer.valueOf(this.f595h), Integer.valueOf(this.f594g));
            default:
                return EnvironmentCompat.MEDIA_UNKNOWN;
        }
    }
}
