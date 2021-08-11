package com.amap.loc;

import android.content.Context;
import android.os.Looper;
import java.util.Date;
import java.util.List;

/* renamed from: com.amap.loc.y */
/* compiled from: CrashLogProcessor */
public class C0375y extends AbstractC0225aa {

    /* renamed from: a */
    private static boolean f952a = true;

    protected C0375y(int i) {
        super(i);
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.loc.AbstractC0225aa
    /* renamed from: a */
    public String mo3626a(String str) {
        return C0356n.m1307c(str + C0363r.m1348a(new Date().getTime()));
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.loc.AbstractC0225aa
    /* renamed from: a */
    public String mo3628a(List<C0360q> list) {
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // com.amap.loc.AbstractC0225aa
    /* renamed from: a */
    public boolean mo3633a(Context context) {
        if (!f952a) {
            return false;
        }
        f952a = false;
        synchronized (Looper.getMainLooper()) {
            C0240an anVar = new C0240an(context);
            C0241ao a = anVar.mo3674a();
            if (a == null) {
                return true;
            }
            if (!a.mo3677a()) {
                return false;
            }
            a.mo3676a(false);
            anVar.mo3675a(a);
            return true;
        }
    }
}
