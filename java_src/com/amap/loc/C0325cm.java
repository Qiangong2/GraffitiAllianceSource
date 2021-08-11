package com.amap.loc;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: com.amap.loc.cm */
/* compiled from: Reflect */
public class C0325cm {
    /* renamed from: a */
    public static Object m1109a(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws Exception {
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return declaredMethod.invoke(null, objArr);
    }

    /* renamed from: a */
    public static Object m1110a(Object obj, String str, Object... objArr) throws Exception {
        Class<?> cls = obj.getClass();
        Class<?>[] clsArr = new Class[objArr.length];
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
            if (clsArr[i] == Integer.class) {
                clsArr[i] = Integer.TYPE;
            }
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        try {
            return declaredMethod.invoke(obj, objArr);
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: a */
    public static Object m1111a(String str, String str2) throws Exception {
        Class<?> cls = Class.forName(str);
        Field field = cls.getField(str2);
        field.setAccessible(true);
        return field.get(cls);
    }

    /* renamed from: a */
    public static Object m1112a(String str, String str2, Object[] objArr, Class<?>[] clsArr) throws Exception {
        return m1109a(Class.forName(str), str2, objArr, clsArr);
    }

    /* renamed from: b */
    public static int m1113b(Object obj, String str, Object... objArr) throws Exception {
        return ((Integer) m1110a(obj, str, objArr)).intValue();
    }

    /* renamed from: b */
    public static int m1114b(String str, String str2) throws Exception {
        return ((Integer) m1111a(str, str2)).intValue();
    }
}
