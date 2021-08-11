package com.wanmei.sdk.core.util;

import android.content.Context;
import android.graphics.drawable.Drawable;

/* renamed from: com.wanmei.sdk.core.util.j */
public class C1849j {
    /* renamed from: a */
    public static int m6697a(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, context.getPackageName());
    }

    /* renamed from: a */
    public static Drawable m6698a(Context context, String str) {
        return context.getResources().getDrawable(m6697a(context, str, "drawable"));
    }
}
