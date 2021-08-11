package com.amap.loc;

import android.content.Context;
import java.util.List;

/* renamed from: com.amap.loc.am */
/* compiled from: SDKDBOperation */
public class C0239am {

    /* renamed from: a */
    private C0228ac f294a;

    /* renamed from: b */
    private Context f295b;

    public C0239am(Context context, boolean z) {
        this.f295b = context;
        this.f294a = m506a(this.f295b, z);
    }

    /* renamed from: a */
    private C0228ac m506a(Context context, boolean z) {
        try {
            return new C0228ac(context, C0228ac.m465a((Class<? extends AbstractC0227ab>) C0236aj.class));
        } catch (Throwable th) {
            if (!z) {
                C0365t.m1372a(th, "SDKDB", "getDB");
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public List<C0360q> mo3672a() {
        try {
            return this.f294a.mo3643a(C0360q.m1333f(), C0360q.class, true);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public void mo3673a(C0360q qVar) {
        if (qVar != null) {
            try {
                if (this.f294a == null) {
                    this.f294a = m506a(this.f295b, false);
                }
                String a = C0360q.m1330a(qVar.mo3939a());
                List b = this.f294a.mo3650b(a, C0360q.class);
                if (b == null || b.size() == 0) {
                    this.f294a.mo3644a(qVar);
                } else {
                    this.f294a.mo3648a(a, qVar);
                }
            } catch (Throwable th) {
                C0365t.m1372a(th, "SDKDB", "insert");
                th.printStackTrace();
            }
        }
    }
}
