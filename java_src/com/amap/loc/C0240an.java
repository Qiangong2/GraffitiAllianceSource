package com.amap.loc;

import android.content.Context;
import java.util.List;

/* renamed from: com.amap.loc.an */
/* compiled from: UpdateLogDBOperation */
public class C0240an {

    /* renamed from: a */
    private C0228ac f296a = m509a(this.f297b);

    /* renamed from: b */
    private Context f297b;

    public C0240an(Context context) {
        this.f297b = context;
    }

    /* renamed from: a */
    private C0228ac m509a(Context context) {
        try {
            return new C0228ac(context, C0228ac.m465a((Class<? extends AbstractC0227ab>) C0236aj.class));
        } catch (Throwable th) {
            C0365t.m1372a(th, "UpdateLogDB", "getDB");
            return null;
        }
    }

    /* renamed from: a */
    public C0241ao mo3674a() {
        try {
            if (this.f296a == null) {
                this.f296a = m509a(this.f297b);
            }
            List b = this.f296a.mo3650b("1=1", C0241ao.class);
            if (b.size() > 0) {
                return (C0241ao) b.get(0);
            }
        } catch (Throwable th) {
            C0365t.m1372a(th, "UpdateLogDB", "getUpdateLog");
        }
        return null;
    }

    /* renamed from: a */
    public void mo3675a(C0241ao aoVar) {
        if (aoVar != null) {
            try {
                if (this.f296a == null) {
                    this.f296a = m509a(this.f297b);
                }
                List b = this.f296a.mo3650b("1=1", C0241ao.class);
                if (b == null || b.size() == 0) {
                    this.f296a.mo3644a(aoVar);
                } else {
                    this.f296a.mo3648a("1=1", aoVar);
                }
            } catch (Throwable th) {
                C0365t.m1372a(th, "UpdateLogDB", "updateLog");
            }
        }
    }
}
