package com.amap.loc;

import android.content.Context;
import android.os.Looper;
import java.util.List;

/* renamed from: com.amap.loc.z */
/* compiled from: ExceptionLogProcessor */
public class C0376z extends AbstractC0225aa {

    /* renamed from: a */
    private static boolean f953a = true;

    protected C0376z(int i) {
        super(i);
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
        if (C0353l.m1280m(context) != 1 || !f953a) {
            return false;
        }
        f953a = false;
        synchronized (Looper.getMainLooper()) {
            C0240an anVar = new C0240an(context);
            C0241ao a = anVar.mo3674a();
            if (a == null) {
                return true;
            }
            if (!a.mo3679b()) {
                return false;
            }
            a.mo3678b(false);
            anVar.mo3675a(a);
            return true;
        }
    }
}
