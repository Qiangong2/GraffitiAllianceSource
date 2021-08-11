package com.igexin.push.core;

import com.igexin.push.config.C0513j;
import com.igexin.sdk.aidl.AbstractBinderC1175a;

/* renamed from: com.igexin.push.core.o */
public class C0626o {

    /* renamed from: a */
    private static String f1674a = C0513j.f1294a;

    /* renamed from: b */
    private static AbstractBinderC1175a f1675b;

    /* renamed from: a */
    public static AbstractBinderC1175a m2445a() {
        if (f1675b == null) {
            f1675b = new BinderC0627p();
        }
        return f1675b;
    }
}
