package com.wanmei.push.p102e;

import com.pwrd.google.gson.GsonBuilder;
import com.pwrd.google.gson.reflect.TypeToken;
import org.json.JSONException;

/* renamed from: com.wanmei.push.e.e */
public final class C1705e {
    /* renamed from: a */
    public static <T> T m6357a(String str, TypeToken<T> typeToken) throws JSONException {
        return (T) new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().fromJson(str, typeToken.getType());
    }
}
