package org.apache.thrift.meta_data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.apache.thrift.AbstractC2158b;

/* renamed from: org.apache.thrift.meta_data.b */
public class C2167b implements Serializable {

    /* renamed from: d */
    private static Map<Class<? extends AbstractC2158b>, Map<?, C2167b>> f6170d = new HashMap();

    /* renamed from: a */
    public final String f6171a;

    /* renamed from: b */
    public final byte f6172b;

    /* renamed from: c */
    public final C2168c f6173c;

    public C2167b(String str, byte b, C2168c cVar) {
        this.f6171a = str;
        this.f6172b = b;
        this.f6173c = cVar;
    }

    /* renamed from: a */
    public static void m8203a(Class<? extends AbstractC2158b> cls, Map<?, C2167b> map) {
        f6170d.put(cls, map);
    }
}
