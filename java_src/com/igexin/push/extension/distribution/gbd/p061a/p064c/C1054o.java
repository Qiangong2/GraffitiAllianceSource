package com.igexin.push.extension.distribution.gbd.p061a.p064c;

import android.content.Context;
import android.net.wifi.ScanResult;
import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1083e;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.extension.distribution.gbd.p076i.C1128q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.igexin.push.extension.distribution.gbd.a.c.o */
public class C1054o {

    /* renamed from: c */
    private static String f2706c = "GBD_WA";

    /* renamed from: a */
    protected EnumC1047h f2707a = EnumC1047h.SCAN_END;

    /* renamed from: b */
    protected int f2708b = C1045f.f2668a;

    /* renamed from: d */
    private C1045f f2709d;

    /* renamed from: e */
    private Comparator<ScanResult> f2710e;

    /* renamed from: f */
    private Comparator<Long> f2711f;

    /* renamed from: g */
    private C1128q<Long> f2712g;

    /* renamed from: h */
    private List<ScanResult> f2713h;

    /* renamed from: i */
    private Context f2714i;

    public C1054o(Context context) {
        this.f2714i = context;
        m4266c();
        m4268d();
    }

    /* renamed from: a */
    private void m4264a(Object obj, int i) {
        List<Long> a;
        int i2 = 0;
        this.f2707a = EnumC1047h.SCAN_END;
        if (obj != null || i != 5) {
            if (obj == null && i == -1) {
                m4265b(C1045f.f2676i);
            } else if (obj == null && i == 11) {
                m4265b(C1045f.f2672e);
            } else {
                try {
                    ArrayList arrayList = new ArrayList();
                    if (obj != null) {
                        List list = (List) obj;
                        if (list.size() != 0) {
                            Collections.sort(list, this.f2710e);
                            for (int i3 = 0; i3 < list.size(); i3++) {
                                ScanResult scanResult = (ScanResult) list.get(i3);
                                long parseLong = Long.parseLong(scanResult.BSSID.replaceAll(":", ""), 16);
                                if (parseLong == 0 || scanResult.level <= C1067a.f2797h || arrayList.contains(Long.valueOf(parseLong))) {
                                    i2 = i2;
                                } else {
                                    if (i2 >= C1067a.f2799j) {
                                        break;
                                    }
                                    arrayList.add(Long.valueOf(parseLong));
                                    this.f2713h.add(scanResult);
                                    i2++;
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                Collections.sort(arrayList, this.f2711f);
                                if (!C1069c.f2832i.isEmpty() && (a = this.f2712g.mo5889a(arrayList, C1069c.f2832i)) != null && !a.isEmpty() && ((int) ((((double) (arrayList.size() - a.size())) / ((double) arrayList.size())) * 100.0d)) < C1067a.f2800k && i == 11) {
                                    m4265b(C1045f.f2674g);
                                    return;
                                }
                            } else if (i == 11) {
                                m4265b(C1045f.f2675h);
                                return;
                            }
                        } else if (i == 11) {
                            m4265b(C1045f.f2673f);
                            return;
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        C1083e.m4408a().mo5820a(arrayList);
                    }
                    this.f2709d.mo5706a(this.f2713h, C1045f.f2668a);
                } catch (Exception e) {
                    C1115d.m4558a(e);
                }
            }
        }
    }

    /* renamed from: b */
    private void m4265b(int i) {
        try {
            this.f2708b = i;
            this.f2713h.clear();
            this.f2709d.mo5706a(this.f2713h, i);
        } catch (Exception e) {
            C1115d.m4558a(e);
        }
    }

    /* renamed from: c */
    private void m4266c() {
        this.f2713h = new ArrayList();
        this.f2710e = new C1055p(this);
        this.f2711f = new C1056q(this);
        this.f2712g = new C1128q<>(this.f2711f);
    }

    /* renamed from: c */
    private void m4267c(int i) {
        if (C1069c.f2829f) {
            if (C1069c.f2830g == 0) {
                C1069c.f2830g = System.currentTimeMillis();
            }
            if (System.currentTimeMillis() - C1069c.f2830g > ((long) (C1067a.f2798i * 1000))) {
                C1115d.m4559b(f2706c, "timeout, type is " + i);
                if (i == 12) {
                    C1115d.m4557a(f2706c, "timeout report");
                    m4264a(null, i);
                    return;
                }
                m4264a(null, 5);
                return;
            }
            C1069c.f2830g = 0;
            try {
                m4264a(C1069c.f2827d.getScanResults(), i);
            } catch (Exception e) {
                m4264a(null, -1);
                C1115d.m4558a(e);
            }
        } else if (i == 12) {
            m4264a(null, i);
        } else {
            m4264a(null, 5);
        }
    }

    /* renamed from: d */
    private void m4268d() {
        if (!C1069c.f2832i.isEmpty()) {
            Collections.sort(C1069c.f2832i, this.f2711f);
        }
    }

    /* renamed from: a */
    public List<ScanResult> mo5717a() {
        return this.f2713h;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5718a(int i) {
        this.f2713h.clear();
        this.f2707a = EnumC1047h.SCAN_START;
        this.f2708b = C1045f.f2668a;
        m4267c(i);
    }

    /* renamed from: a */
    public void mo5719a(C1045f fVar) {
        this.f2709d = fVar;
    }

    /* renamed from: b */
    public int mo5720b() {
        return this.f2708b;
    }
}
