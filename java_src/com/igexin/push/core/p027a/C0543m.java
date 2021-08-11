package com.igexin.push.core.p027a;

import android.text.TextUtils;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p013a.p020d.AbstractC0470d;
import com.igexin.p012b.p022b.C0476a;
import com.igexin.push.config.C0514k;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.C0617f;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.p029b.C0561af;
import com.igexin.push.core.p029b.C0568g;
import com.igexin.push.core.p030c.C0609g;
import com.igexin.push.p026c.C0494i;
import com.igexin.push.p032d.C0632b;
import com.igexin.push.p032d.p035c.C0650m;
import com.igexin.push.p079f.p080a.C1140c;
import com.igexin.push.util.C1155e;
import com.umeng.analytics.C1370a;

/* renamed from: com.igexin.push.core.a.m */
public class C0543m extends AbstractC0520a {
    /* renamed from: b */
    private void m2129b() {
        C0632b.m2464a().mo4676f();
        ActivityC0460a.m1698b("loginRsp|" + C0618g.f1647r + "|success");
        ActivityC0460a.m1698b("isCidBroadcasted|" + C0618g.f1642m);
        if (!C0618g.f1642m) {
            C0535e.m2034a().mo4409k();
            C0618g.f1642m = true;
        }
        C0618g.f1641l = true;
        C0535e.m2034a().mo4410l();
        C0535e.m2034a().mo4406h();
        if (TextUtils.isEmpty(C0618g.f1653x)) {
            ActivityC0460a.m1698b("LoginResultAction device id is empty, get device id from server +++++");
            C0535e.m2034a().mo4407i();
        }
        C1155e.m4772f();
        m2132e();
        mo4427a();
        m2131d();
        C0568g.m2192a().mo4445b();
        C0617f.m2395a().mo4629h().mo4720a();
        m2133f();
    }

    /* renamed from: c */
    private void m2130c() {
        ActivityC0460a.m1698b("loginRsp|" + C0618g.f1647r + "|failed");
        ActivityC0460a.m1698b("LoginResultAction login failed, clear session or cid");
        C0568g.m2192a().mo4451c();
        C0535e.m2034a().mo4396c(true);
    }

    /* renamed from: d */
    private void m2131d() {
        try {
            if ((System.currentTimeMillis() - C0618g.f1585J) - C1370a.f3217i > 0) {
                C0456c.m1661b().mo4216a(new C1140c(new C0609g(SDKUrlConfig.getConfigServiceUrl())), false, true);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: e */
    private void m2132e() {
        if ((System.currentTimeMillis() - C0618g.f1582G) - 259200000 >= 0 && C0514k.f1315g) {
            String d = C0535e.m2034a().mo4399d("ua");
            if (d == null || "1".equals(d)) {
                C0456c.m1661b().mo4216a(new C0545o(this), false, true);
            }
        }
    }

    /* renamed from: f */
    private void m2133f() {
        try {
            if (System.currentTimeMillis() - C0618g.f1587L > C1370a.f3217i) {
                C0568g.m2192a().mo4462g(System.currentTimeMillis());
                C0561af.m2162a().mo4431b("21");
            }
        } catch (Throwable th) {
            ActivityC0460a.m1698b("LoginResultAction|report third party guard exception :" + th.toString());
        }
    }

    /* renamed from: a */
    public void mo4427a() {
        boolean z = true;
        boolean z2 = (System.currentTimeMillis() - C0618g.f1581F) - C1370a.f3217i > 0;
        if (C0476a.m1774a(C0618g.f1655z, C0618g.f1654y)) {
            z = false;
        }
        if (!z2 && !z) {
            return;
        }
        if (TextUtils.isEmpty(C0618g.f1653x)) {
            if (C0618g.f1623as != null) {
                C0618g.f1623as.mo4207u();
                C0618g.f1623as = null;
            }
            C0618g.f1623as = new C0544n(this, 5000);
            C0617f.m2395a().mo4619a(C0618g.f1623as);
            return;
        }
        C0535e.m2034a().mo4408j();
    }

    @Override // com.igexin.push.core.p027a.AbstractC0520a
    /* renamed from: a */
    public boolean mo4350a(AbstractC0470d dVar) {
        return false;
    }

    @Override // com.igexin.push.core.p027a.AbstractC0520a
    /* renamed from: a */
    public boolean mo4351a(Object obj) {
        if (!(obj instanceof C0650m)) {
            return true;
        }
        C0618g.f1579D = 0;
        if (C0618g.f1641l) {
            return true;
        }
        C0494i.m1834a().mo4281e().mo4271h();
        if (((C0650m) obj).f1760a) {
            m2129b();
            return true;
        }
        m2130c();
        return true;
    }
}
