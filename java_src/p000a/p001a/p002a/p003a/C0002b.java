package p000a.p001a.p002a.p003a;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import p000a.p001a.p002a.AbstractC0033d;
import p000a.p001a.p002a.AbstractC0047k;

/* renamed from: a.a.a.a.b */
/* compiled from: FieldMetaData */
public class C0002b implements Serializable {

    /* renamed from: d */
    private static Map<Class<? extends AbstractC0033d>, Map<? extends AbstractC0047k, C0002b>> f1d = new HashMap();

    /* renamed from: a */
    public final String f2a;

    /* renamed from: b */
    public final byte f3b;

    /* renamed from: c */
    public final C0003c f4c;

    public C0002b(String str, byte b, C0003c cVar) {
        this.f2a = str;
        this.f3b = b;
        this.f4c = cVar;
    }

    /* renamed from: a */
    public static void m17a(Class<? extends AbstractC0033d> cls, Map<? extends AbstractC0047k, C0002b> map) {
        f1d.put(cls, map);
    }

    /* renamed from: a */
    public static Map<? extends AbstractC0047k, C0002b> m16a(Class<? extends AbstractC0033d> cls) {
        if (!f1d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException("InstantiationException for TBase class: " + cls.getName() + ", message: " + e.getMessage());
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("IllegalAccessException for TBase class: " + cls.getName() + ", message: " + e2.getMessage());
            }
        }
        return f1d.get(cls);
    }
}
