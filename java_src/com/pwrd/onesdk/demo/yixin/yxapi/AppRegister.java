package com.pwrd.onesdk.demo.yixin.yxapi;

import android.content.Context;
import android.content.pm.PackageManager;
import com.wanmei.sdk.core.util.LogUtil;
import im.yixin.sdk.api.YXAPIBaseBroadcastReceiver;
import im.yixin.sdk.channel.YXMessageProtocol;

public class AppRegister extends YXAPIBaseBroadcastReceiver {
    /* access modifiers changed from: protected */
    public String getAppId(Context context) {
        String msg = "";
        try {
            msg = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("YX_GAME_ID");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        LogUtil.m6672d("AppRegister", " msg == " + msg);
        return msg;
    }

    /* access modifiers changed from: protected */
    public void onAfterYixinStart(YXMessageProtocol protocol) {
    }
}
