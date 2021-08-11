package com.amap.loc;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Constructor;

/* renamed from: com.amap.loc.ar */
/* compiled from: InstanceFactory */
public class C0244ar {
    /* renamed from: a */
    public static <T> T m536a(Context context, C0360q qVar, String str, Class cls, Class[] clsArr, Object[] objArr) throws C0341h {
        T t = (T) m537a(m543b(context, qVar), str, clsArr, objArr);
        if (t != null || (t = (T) m538a(cls, clsArr, objArr)) != null) {
            return t;
        }
        throw new C0341h("获取对象错误");
    }

    /* renamed from: a */
    private static <T> T m537a(AbstractC0246as asVar, String str, Class[] clsArr, Object[] objArr) {
        Class<?> loadClass;
        try {
            if (m542a(asVar) && (loadClass = asVar.loadClass(str)) != null) {
                Constructor<?> declaredConstructor = loadClass.getDeclaredConstructor(clsArr);
                declaredConstructor.setAccessible(true);
                return (T) declaredConstructor.newInstance(objArr);
            }
        } catch (Throwable th) {
            C0263ba.m657a(th, "IFactory", "getWrap");
        }
        return null;
    }

    /* renamed from: a */
    private static <T> T m538a(Class cls, Class[] clsArr, Object[] objArr) {
        if (cls == null) {
            return null;
        }
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(objArr);
        } catch (Throwable th) {
            C0263ba.m657a(th, "IFactory", "gIns2()");
            return null;
        }
    }

    /* renamed from: a */
    public static void m539a(Context context, C0243aq aqVar, C0360q qVar) {
        if (aqVar != null) {
            try {
                if (!TextUtils.isEmpty(aqVar.mo3689a()) && !TextUtils.isEmpty(aqVar.mo3690b()) && !TextUtils.isEmpty(aqVar.mo3691c())) {
                    new C0242ap(context, aqVar, qVar).mo3682a();
                }
            } catch (Throwable th) {
                C0263ba.m657a(th, "IFactory", "dDownload()");
            }
        }
    }

    /* renamed from: a */
    public static void m540a(final Context context, final String str) {
        try {
            C0371w.m1393b().submit(new Runnable() {
                /* class com.amap.loc.C0244ar.RunnableC02451 */

                public void run() {
                    try {
                        C0249av.m562a(new C0228ac(context, C0255ay.m585c()), context, str);
                    } catch (Throwable th) {
                        C0263ba.m657a(th, "InstanceFactory", "rollBack");
                    }
                }
            });
        } catch (Throwable th) {
            C0263ba.m657a(th, "InstanceFactory", "rollBack");
        }
    }

    /* renamed from: a */
    public static boolean m541a(Context context, C0360q qVar) {
        try {
            File file = new File(C0249av.m563b(context, qVar.mo3939a(), qVar.mo3941b()));
            if (file.exists()) {
                return true;
            }
            C0249av.m560a(context, file, qVar);
            return false;
        } catch (Throwable th) {
            C0263ba.m657a(th, "IFactory", "isdowned");
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m542a(AbstractC0246as asVar) {
        return asVar != null && asVar.mo3693a() && asVar.f321d;
    }

    /* renamed from: b */
    private static AbstractC0246as m543b(Context context, C0360q qVar) {
        try {
            if (m541a(context, qVar)) {
                return C0247at.m546a().mo3695a(context, qVar);
            }
            return null;
        } catch (Throwable th) {
            C0263ba.m657a(th, "IFactory", "gIns1");
            return null;
        }
    }
}
