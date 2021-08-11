package com.igexin.push.extension.distribution.gbd.p071f;

import com.igexin.push.core.C0618g;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;

/* renamed from: com.igexin.push.extension.distribution.gbd.f.b */
public class C1091b {
    /* renamed from: a */
    public static String m4465a() {
        String a = m4466a("getBiUploadServiceUrl");
        return a == null ? C0618g.m2423a() : a;
    }

    /* renamed from: a */
    private static String m4466a(String str) {
        try {
            Class<?> cls = Class.forName("com.igexin.push.config.SDKUrlConfig");
            return (String) cls.getMethod(str, new Class[0]).invoke(cls, new Object[0]);
        } catch (Exception e) {
            C1115d.m4559b("GBDGBDUrl", "GBD_GBDUrl-> get method :" + str + "() error, use default");
            return null;
        }
    }

    /* renamed from: b */
    public static String m4467b() {
        String a = m4466a("getConfigServiceUrl");
        return a == null ? C0618g.m2423a() : a;
    }
}
