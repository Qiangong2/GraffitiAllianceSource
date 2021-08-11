package com.wanmei.sdk.core.net;

import com.pwrd.google.gson.GsonBuilder;
import java.lang.reflect.Type;

/* renamed from: com.wanmei.sdk.core.net.a */
public class C1767a {
    /* renamed from: a */
    public static <T> T m6507a(String str, Class<T> cls) {
        Object fromJson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().fromJson(str, (Type) cls);
        T t = (T) fromJson;
        if (t != null) {
            return t;
        }
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            return t;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return t;
        }
    }
}
