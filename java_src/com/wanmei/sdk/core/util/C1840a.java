package com.wanmei.sdk.core.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import dalvik.system.DexClassLoader;
import dalvik.system.DexFile;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;

/* renamed from: com.wanmei.sdk.core.util.a */
public final class C1840a {

    /* renamed from: a */
    private static final String f4580a = C1840a.class.getName();

    /* renamed from: b */
    private static C1840a f4581b;

    /* renamed from: c */
    private Activity f4582c;

    /* renamed from: d */
    private String f4583d;

    /* renamed from: e */
    private String f4584e;

    /* renamed from: f */
    private DexClassLoader f4585f;

    /* renamed from: g */
    private DexFile f4586g;

    private C1840a() {
    }

    /* renamed from: a */
    public static synchronized C1840a m6677a() {
        C1840a aVar;
        synchronized (C1840a.class) {
            if (f4581b == null) {
                f4581b = new C1840a();
            }
            aVar = f4581b;
        }
        return aVar;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public <T> T mo9910a(Class<T> cls) {
        Class<? extends U> cls2;
        Enumeration<String> entries = this.f4586g.entries();
        Class<? extends U> cls3 = null;
        while (entries.hasMoreElements()) {
            try {
                Class loadClass = this.f4585f.loadClass(entries.nextElement());
                if (cls.isAssignableFrom(loadClass)) {
                    LogUtil.m6672d(f4580a, loadClass.getName() + " >>will be cast to>> " + cls.getName());
                    cls2 = loadClass.asSubclass(cls);
                } else {
                    cls2 = cls3;
                }
                cls3 = cls2;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            } catch (ClassCastException e3) {
            }
        }
        if (cls3 != null) {
            try {
                return cls3.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (IllegalArgumentException e4) {
                e4.printStackTrace();
            } catch (InstantiationException e5) {
                e5.printStackTrace();
            } catch (IllegalAccessException e6) {
                e6.printStackTrace();
            } catch (InvocationTargetException e7) {
                e7.printStackTrace();
            } catch (NoSuchMethodException e8) {
                e8.printStackTrace();
            }
        }
        throw new RuntimeException("can't instantiation");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0060 A[SYNTHETIC, Splitter:B:19:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0065 A[Catch:{ IOException -> 0x008f }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0081 A[SYNTHETIC, Splitter:B:36:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0086 A[Catch:{ IOException -> 0x008a }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo9911a(android.app.Activity r6) {
        /*
        // Method dump skipped, instructions count: 168
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wanmei.sdk.core.util.C1840a.mo9911a(android.app.Activity):void");
    }

    /* renamed from: b */
    public void mo9912b() {
        this.f4585f = new DexClassLoader(this.f4584e, this.f4583d, null, this.f4582c.getClassLoader());
        try {
            this.f4586g = DexFile.loadDex(this.f4584e, this.f4583d + "/classes.dex", 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
