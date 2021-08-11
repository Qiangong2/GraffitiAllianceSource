package com.wanmei.push.p104g;

import android.content.Intent;
import android.text.TextUtils;

/* renamed from: com.wanmei.push.g.e */
public final class C1713e {
    /* renamed from: a */
    public static String m6375a(Intent intent) {
        if (intent == null || TextUtils.isEmpty(intent.getDataString())) {
            return "";
        }
        return intent.getDataString().substring(intent.getDataString().indexOf("package:") + 8, intent.getDataString().length());
    }
}
