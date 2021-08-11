package com.igexin.push.p036e;

import android.content.Context;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.config.C0514k;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.C0617f;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.C0620i;
import com.igexin.push.core.EnumC0602c;
import com.igexin.push.core.EnumC0622k;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.p026c.C0486a;
import com.igexin.push.p026c.C0494i;
import com.igexin.push.p032d.C0632b;
import com.igexin.push.p032d.C0659h;
import com.igexin.push.p032d.p035c.AbstractC0642e;
import com.igexin.push.p032d.p035c.C0638a;
import com.igexin.push.p032d.p035c.C0640c;
import com.igexin.push.p032d.p035c.C0641d;
import com.igexin.push.p032d.p035c.C0643f;
import com.igexin.push.p032d.p035c.C0646i;
import com.igexin.push.p032d.p035c.C0648k;
import com.igexin.push.p032d.p035c.C0650m;
import com.igexin.push.p032d.p035c.C0651n;
import com.igexin.push.p032d.p035c.C0652o;
import com.igexin.push.p032d.p035c.C0653p;
import com.igexin.push.p032d.p035c.C0654q;
import com.igexin.push.p079f.p081b.C1149g;

/* renamed from: com.igexin.push.e.j */
public class C0670j {

    /* renamed from: a */
    private static String f1816a = C0670j.class.getName();

    /* renamed from: b */
    private C0456c f1817b;

    /* renamed from: c */
    private AbstractC0671k f1818c;

    /* renamed from: d */
    private boolean f1819d;

    /* renamed from: e */
    private long f1820e = 0;

    /* renamed from: f */
    private long f1821f = 0;

    /* renamed from: g */
    private boolean f1822g;

    /* renamed from: b */
    private String m2593b(AbstractC0642e eVar) {
        if (eVar instanceof C0643f) {
            return "R-" + ((C0643f) eVar).mo4696a();
        }
        if (eVar instanceof C0654q) {
            return "R-" + ((C0654q) eVar).f1781b;
        }
        if (eVar instanceof C0648k) {
            return "S-" + String.valueOf(((C0648k) eVar).f1753a);
        }
        if (eVar instanceof C0650m) {
            if (((C0650m) eVar).f1764e != 0) {
                return "S-" + String.valueOf(((C0650m) eVar).f1764e);
            }
        } else if (eVar instanceof C0651n) {
            return "S-" + String.valueOf(((C0651n) eVar).f1765a);
        } else {
            if (eVar instanceof C0652o) {
                return "S-" + String.valueOf(((C0652o) eVar).f1770e);
            }
            if (eVar instanceof C0641d) {
                return "C-" + ((C0641d) eVar).f1721g;
            }
            if (eVar instanceof C0653p) {
                return "C-" + ((C0653p) eVar).f1778g;
            }
            if (eVar instanceof C0638a) {
                return "C-" + ((C0638a) eVar).f1697d;
            }
            if (eVar instanceof C0640c) {
                return "C-" + ((C0640c) eVar).f1711d;
            }
        }
        return "";
    }

    /* renamed from: c */
    private boolean m2594c() {
        if (!C0514k.f1321m || this.f1820e + this.f1821f < C0514k.f1322n) {
            return false;
        }
        C0661a aVar = new C0661a();
        aVar.mo4702a(EnumC0602c.check);
        C0617f.m2395a().mo4629h().mo4719a(aVar);
        return false;
    }

    /* renamed from: a */
    public int mo4736a(String str, AbstractC0642e eVar) {
        return mo4737a(str, eVar, false);
    }

    /* renamed from: a */
    public int mo4737a(String str, AbstractC0642e eVar, boolean z) {
        if (str == null || eVar == null) {
            return -1;
        }
        if (!C0618g.f1641l && !(eVar instanceof C0646i) && !(eVar instanceof C0648k) && !(eVar instanceof C0643f)) {
            ActivityC0460a.m1696a("snl|sendData|not online|" + eVar.getClass().getName());
            return -3;
        } else if (!this.f1819d) {
            return C0617f.m2395a().mo4629h().mo4714a(str, eVar);
        } else {
            if (z) {
                int i = 10;
                if (C0514k.f1313e > 0) {
                    i = C0514k.f1313e;
                }
                if (this.f1817b.mo4166a(SDKUrlConfig.getCmAddress(), 3, C0617f.m2395a().mo4627f(), eVar, true, i, new C0659h()) == null) {
                    return -2;
                }
            } else if (this.f1817b.mo4163a(SDKUrlConfig.getCmAddress(), 3, C0617f.m2395a().mo4627f(), eVar, true) == null) {
                return -2;
            }
            byte[] d = eVar.mo4685d();
            if (d != null) {
                this.f1821f = ((long) d.length) + 8 + this.f1821f;
            } else {
                this.f1821f += 8;
            }
            m2594c();
            return 0;
        }
    }

    /* renamed from: a */
    public void mo4738a(Context context, C0456c cVar, AbstractC0671k kVar) {
        this.f1817b = cVar;
        this.f1818c = kVar;
    }

    /* renamed from: a */
    public void mo4739a(AbstractC0642e eVar) {
        if (eVar != null) {
            if (this.f1819d) {
                String b = m2593b(eVar);
                if (!b.equals("S-") && !b.equals("R-")) {
                    if (b.length() > 0 && !b.equals("C-") && !b.equals("C-" + C0618g.f1647r) && !b.equals("R-" + C0618g.f1576A) && !b.equals("S-" + C0618g.f1646q)) {
                        C0617f.m2395a().mo4629h().mo4721b(b, eVar);
                    } else if (this.f1818c != null) {
                        this.f1818c.mo4378a(eVar);
                    }
                    byte[] d = eVar.mo4685d();
                    if (d != null) {
                        this.f1820e = ((long) d.length) + 8 + this.f1820e;
                    } else {
                        this.f1820e += 8;
                    }
                    m2594c();
                }
            } else if (this.f1818c != null) {
                this.f1818c.mo4378a(eVar);
            }
        }
    }

    /* renamed from: a */
    public void mo4740a(boolean z) {
        ActivityC0460a.m1698b(f1816a + "|call setASNL, param isASNL = " + z + "; this.isASNL = " + this.f1819d);
        if (this.f1819d != z) {
            this.f1819d = z;
            this.f1822g = false;
            if (z) {
                ActivityC0460a.m1698b(f1816a + "|commit reconnectCheckNotify");
                this.f1821f = 0;
                this.f1820e = 0;
                C0535e.m2034a().mo4401d(true);
                return;
            }
            ActivityC0460a.m1698b(f1816a + "|isASNL = false, this.isASNL = true, disconnect tcp !!!");
            C0535e.m2034a().mo4404f();
        }
    }

    /* renamed from: a */
    public boolean mo4741a() {
        return this.f1819d;
    }

    /* renamed from: b */
    public void mo4742b() {
        C0618g.f1579D = 0;
        if (!this.f1819d && this.f1818c != null) {
            this.f1818c.mo4383b();
        }
    }

    /* renamed from: b */
    public void mo4743b(boolean z) {
        if (C0618g.f1641l) {
            C0618g.f1641l = false;
            C0535e.m2034a().mo4410l();
        }
        C0486a e = C0494i.m1834a().mo4281e();
        if (!z) {
            ActivityC0460a.m1698b(f1816a + "|disconnected by network ####");
            C0620i.m2432a().mo4638a(EnumC0622k.NETWORK_ERROR);
            e.mo4272i();
            ActivityC0460a.m1698b(f1816a + "|autoReconnect notifyNetworkDisconnected");
            C0535e.m2034a().mo4401d(true);
        } else {
            e.mo4272i();
            ActivityC0460a.m1698b(f1816a + "|disconnected by user ####");
        }
        if (this.f1819d) {
            C0617f.m2395a().mo4629h().mo4723b();
        } else if (this.f1818c != null) {
            this.f1818c.mo4377a(z);
        }
    }

    /* renamed from: c */
    public void mo4744c(boolean z) {
        C0618g.f1579D = C0632b.m2464a().mo4673c().mo4701a(z);
        C0494i.m1834a().mo4281e().mo4266c();
        C1149g.m4727g().mo5903h();
    }
}
