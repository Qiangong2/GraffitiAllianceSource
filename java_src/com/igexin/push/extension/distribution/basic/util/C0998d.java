package com.igexin.push.extension.distribution.basic.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/* renamed from: com.igexin.push.extension.distribution.basic.util.d */
public class C0998d {

    /* renamed from: a */
    private final Properties f2543a = new Properties();

    private C0998d() {
        this.f2543a.load(new FileInputStream(new File("/system/build.prop")));
    }

    /* renamed from: a */
    public static C0998d m4014a() {
        return new C0998d();
    }

    /* renamed from: a */
    public String mo5647a(String str, String str2) {
        return this.f2543a.getProperty(str, str2);
    }
}
