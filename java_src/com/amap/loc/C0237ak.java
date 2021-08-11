package com.amap.loc;

import android.content.Context;
import java.util.List;

/* renamed from: com.amap.loc.ak */
/* compiled from: LogDBOperation */
public class C0237ak {

    /* renamed from: a */
    private C0228ac f289a;

    public C0237ak(Context context) {
        try {
            this.f289a = new C0228ac(context, C0228ac.m465a((Class<? extends AbstractC0227ab>) C0236aj.class));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: c */
    private void m491c(String str, Class<? extends AbstractC0238al> cls) {
        this.f289a.mo3647a(AbstractC0238al.m498c(str), (Class) cls);
    }

    /* renamed from: a */
    public List<? extends AbstractC0238al> mo3660a(int i, Class<? extends AbstractC0238al> cls) {
        try {
            return this.f289a.mo3650b(AbstractC0238al.m497c(i), cls);
        } catch (Throwable th) {
            C0365t.m1372a(th, "LogDB", "ByState");
            return null;
        }
    }

    /* renamed from: a */
    public void mo3661a(AbstractC0238al alVar) {
        if (alVar != null) {
            String c = AbstractC0238al.m498c(alVar.mo3668b());
            List a = this.f289a.mo3643a(c, (Class) alVar.getClass(), true);
            if (a == null || a.size() == 0) {
                this.f289a.mo3646a((Object) alVar, true);
                return;
            }
            AbstractC0238al alVar2 = (AbstractC0238al) a.get(0);
            if (alVar.mo3665a() == 0) {
                alVar2.mo3669b(alVar2.mo3671c() + 1);
            } else {
                alVar2.mo3669b(0);
            }
            this.f289a.mo3649a(c, (Object) alVar2, true);
        }
    }

    /* renamed from: a */
    public void mo3662a(String str, Class<? extends AbstractC0238al> cls) {
        try {
            m491c(str, cls);
        } catch (Throwable th) {
            C0365t.m1372a(th, "LogDB", "delLog");
        }
    }

    /* renamed from: b */
    public void mo3663b(AbstractC0238al alVar) {
        try {
            this.f289a.mo3648a(AbstractC0238al.m498c(alVar.mo3668b()), alVar);
        } catch (Throwable th) {
            C0365t.m1372a(th, "LogDB", "updateLogInfo");
        }
    }

    /* renamed from: b */
    public void mo3664b(String str, Class<? extends AbstractC0238al> cls) {
        try {
            m491c(str, cls);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
