package p000a.p001a.p002a;

import java.lang.reflect.InvocationTargetException;

/* renamed from: a.a.a.i */
/* compiled from: TEnumHelper */
public class C0045i {
    /* renamed from: a */
    public static AbstractC0044h m278a(Class<? extends AbstractC0044h> cls, int i) {
        try {
            return (AbstractC0044h) cls.getMethod("findByValue", Integer.TYPE).invoke(null, Integer.valueOf(i));
        } catch (NoSuchMethodException e) {
            return null;
        } catch (IllegalAccessException e2) {
            return null;
        } catch (InvocationTargetException e3) {
            return null;
        }
    }
}
