package com.igexin.assist.util;

import android.content.Context;
import android.text.TextUtils;
import com.igexin.push.util.C1167q;
import com.igexin.sdk.PushManager;

public class AssistUtils {
    public static void startGetuiService(Context context) {
        if (context != null) {
            try {
                String str = (String) C1167q.m4793b(context, "us", "");
                PushManager.getInstance().initialize(context, !TextUtils.isEmpty(str) ? Class.forName(str) : null);
            } catch (Throwable th) {
            }
        }
    }
}
