package com.wanmei.sdk.core.util;

import android.content.Context;
import com.wanmei.sdk.core.Proguard;
import com.wanmei.sdk.core.open.SDKCoreFacade;

public class Toast implements Proguard {
    public static void makeToast(Context context, String text) {
        android.widget.Toast.makeText(context, text, 1).show();
    }

    public static void makeToast(Context context, String text, int length) {
        android.widget.Toast.makeText(context, text, length).show();
    }

    public static void makeToastChannelError(Context context, String channelName, String text, int code) {
        if (SDKCoreFacade.getInstance().isDebug()) {
            android.widget.Toast.makeText(context, text + "，或联系" + channelName + "客服(One_" + code + ")", 1).show();
        }
    }

    public static void makeToastOneSDKError(Context context, String text, int code) {
        if (SDKCoreFacade.getInstance().isDebug()) {
            android.widget.Toast.makeText(context, text + "(One_" + code + ")", 1).show();
        }
    }
}
