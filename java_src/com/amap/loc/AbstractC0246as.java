package com.amap.loc;

import android.content.Context;
import dalvik.system.DexFile;
import java.util.HashMap;
import java.util.Map;

/* access modifiers changed from: package-private */
/* renamed from: com.amap.loc.as */
/* compiled from: BaseClassLoader */
public abstract class AbstractC0246as extends ClassLoader {

    /* renamed from: a */
    protected final Context f318a;

    /* renamed from: b */
    protected final Map<String, Class<?>> f319b = new HashMap();

    /* renamed from: c */
    protected DexFile f320c = null;

    /* renamed from: d */
    volatile boolean f321d = true;

    /* renamed from: e */
    protected C0360q f322e;

    /* renamed from: f */
    protected String f323f;

    public AbstractC0246as(Context context, C0360q qVar, boolean z) {
        super(context.getClassLoader());
        this.f318a = context;
        this.f322e = qVar;
    }

    /* renamed from: a */
    public boolean mo3693a() {
        return this.f320c != null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo3694b() {
        try {
            this.f319b.clear();
            if (this.f320c != null) {
                this.f320c.close();
            }
        } catch (Throwable th) {
            C0263ba.m657a(th, "BaseClassLoader", "releaseDexFile()");
        }
    }
}
