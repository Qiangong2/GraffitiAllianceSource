package com.igexin.push.extension.distribution.basic.p053h;

import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0618g;

/* renamed from: com.igexin.push.extension.distribution.basic.h.c */
public class C0770c {
    /* renamed from: a */
    public static String m3175a() {
        return "http://d.gt.igexin.com/api.htm";
    }

    /* renamed from: a */
    private static String m3176a(String str) {
        try {
            Class<?> cls = Class.forName("com.igexin.push.config.SDKUrlConfig");
            return (String) cls.getMethod(str, new Class[0]).invoke(cls, new Object[0]);
        } catch (Exception e) {
            ActivityC0460a.m1698b("Basic_BasicUrl-> get method :" + str + "() error, use default");
            return null;
        }
    }

    /* renamed from: b */
    public static String m3177b() {
        String a = m3176a("getBiUploadServiceUrl");
        return a == null ? C0618g.m2423a() : a;
    }

    /* renamed from: c */
    public static String m3178c() {
        String a = m3176a("getConfigServiceUrl");
        return a == null ? C0618g.m2423a() : a;
    }
}
