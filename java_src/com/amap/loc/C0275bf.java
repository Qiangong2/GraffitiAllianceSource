package com.amap.loc;

import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

/* renamed from: com.amap.loc.bf */
/* compiled from: BaseNetManager */
public class C0275bf {

    /* renamed from: a */
    private static C0275bf f447a;

    /* renamed from: com.amap.loc.bf$a */
    /* compiled from: BaseNetManager */
    public interface AbstractC0276a {
        /* renamed from: a */
        URLConnection mo3750a(Proxy proxy, URL url);
    }

    /* renamed from: a */
    public static C0275bf m719a() {
        if (f447a == null) {
            f447a = new C0275bf();
        }
        return f447a;
    }

    /* renamed from: a */
    public C0284bl mo3747a(AbstractC0283bk bkVar, boolean z) throws C0341h {
        try {
            mo3749b(bkVar);
            return new C0280bi(bkVar.f465c, bkVar.f466d, bkVar.f467e == null ? null : bkVar.f467e, z).mo3760a(bkVar.mo3770i(), bkVar.mo3696a(), bkVar.mo3771j());
        } catch (C0341h e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new C0341h("未知的错误");
        }
    }

    /* renamed from: a */
    public byte[] mo3748a(AbstractC0283bk bkVar) throws C0341h {
        try {
            C0284bl a = mo3747a(bkVar, false);
            if (a != null) {
                return a.f468a;
            }
            return null;
        } catch (C0341h e) {
            throw e;
        } catch (Throwable th) {
            C0365t.m1372a(th, "BaseNetManager", "makeSyncPostRequest");
            throw new C0341h("未知的错误");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo3749b(AbstractC0283bk bkVar) throws C0341h {
        if (bkVar == null) {
            throw new C0341h("requeust is null");
        } else if (bkVar.mo3697b() == null || "".equals(bkVar.mo3697b())) {
            throw new C0341h("request url is empty");
        }
    }
}
