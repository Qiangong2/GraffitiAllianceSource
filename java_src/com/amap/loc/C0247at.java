package com.amap.loc;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.amap.loc.at */
/* compiled from: ClassLoaderFactory */
public class C0247at {

    /* renamed from: a */
    private static final C0247at f324a = new C0247at();

    /* renamed from: b */
    private final Map<String, AbstractC0246as> f325b = new HashMap();

    private C0247at() {
    }

    /* renamed from: a */
    public static C0247at m546a() {
        return f324a;
    }

    /* renamed from: a */
    private boolean m547a(C0360q qVar) {
        return qVar != null && !TextUtils.isEmpty(qVar.mo3941b()) && !TextUtils.isEmpty(qVar.mo3939a());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized AbstractC0246as mo3695a(Context context, C0360q qVar) throws Exception {
        AbstractC0246as asVar;
        if (!m547a(qVar) || context == null) {
            throw new Exception("sdkInfo or context referance is null");
        }
        String a = qVar.mo3939a();
        asVar = this.f325b.get(a);
        if (asVar == null) {
            try {
                C0252aw awVar = new C0252aw(context.getApplicationContext(), qVar, true);
                try {
                    this.f325b.put(a, awVar);
                    C0254ax.m583a(context, qVar);
                    asVar = awVar;
                } catch (Throwable th) {
                    asVar = awVar;
                }
            } catch (Throwable th2) {
            }
        }
        return asVar;
    }
}
