package com.unity3d.player;

import java.lang.reflect.Method;
import java.util.HashMap;

/* access modifiers changed from: package-private */
/* renamed from: com.unity3d.player.m */
public final class C1627m {

    /* renamed from: a */
    private HashMap f4168a = new HashMap();

    /* renamed from: b */
    private Class f4169b = null;

    /* renamed from: c */
    private Object f4170c = null;

    /* access modifiers changed from: package-private */
    /* renamed from: com.unity3d.player.m$a */
    public class C1628a {

        /* renamed from: a */
        public Class[] f4171a;

        /* renamed from: b */
        public Method f4172b = null;

        public C1628a(Class[] clsArr) {
            this.f4171a = clsArr;
        }
    }

    public C1627m(Class cls, Object obj) {
        this.f4169b = cls;
        this.f4170c = obj;
    }

    /* renamed from: a */
    private void m6145a(String str, C1628a aVar) {
        try {
            aVar.f4172b = this.f4169b.getMethod(str, aVar.f4171a);
        } catch (Exception e) {
            C1614e.Log(6, "Exception while trying to get method " + str + ". " + e.getLocalizedMessage());
            aVar.f4172b = null;
        }
    }

    /* renamed from: a */
    public final Object mo9123a(String str, Object... objArr) {
        Object obj;
        if (!this.f4168a.containsKey(str)) {
            C1614e.Log(6, "No definition for method " + str + " can be found");
            return null;
        }
        C1628a aVar = (C1628a) this.f4168a.get(str);
        if (aVar.f4172b == null) {
            m6145a(str, aVar);
        }
        if (aVar.f4172b == null) {
            C1614e.Log(6, "Unable to create method: " + str);
            return null;
        }
        try {
            obj = objArr.length == 0 ? aVar.f4172b.invoke(this.f4170c, new Object[0]) : aVar.f4172b.invoke(this.f4170c, objArr);
        } catch (Exception e) {
            C1614e.Log(6, "Error trying to call delegated method " + str + ". " + e.getLocalizedMessage());
            obj = null;
        }
        return obj;
    }

    /* renamed from: a */
    public final void mo9124a(String str, Class[] clsArr) {
        this.f4168a.put(str, new C1628a(clsArr));
    }
}
