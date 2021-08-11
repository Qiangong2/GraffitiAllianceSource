package com.igexin.sdk;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTTransmitMessage;

public abstract class GTIntentService extends IntentService {
    public static final String TAG = "GTIntentService";

    public GTIntentService() {
        super(TAG);
    }

    private void processOnHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null && extras.get(PushConsts.CMD_ACTION) != null && (extras.get(PushConsts.CMD_ACTION) instanceof Integer)) {
            switch (extras.getInt(PushConsts.CMD_ACTION)) {
                case PushConsts.GET_MSG_DATA /*{ENCODED_INT: 10001}*/:
                    onReceiveMessageData(this, (GTTransmitMessage) intent.getSerializableExtra(PushConsts.KEY_MESSAGE_DATA));
                    return;
                case PushConsts.GET_CLIENTID /*{ENCODED_INT: 10002}*/:
                    onReceiveClientId(this, extras.getString(PushConsts.KEY_CLIENT_ID));
                    return;
                case 10003:
                case 10004:
                case PushConsts.CHECK_CLIENTID /*{ENCODED_INT: 10005}*/:
                case PushConsts.THIRDPART_FEEDBACK /*{ENCODED_INT: 10006}*/:
                case PushConsts.SET_TAG_RESULT /*{ENCODED_INT: 10009}*/:
                default:
                    return;
                case PushConsts.GET_SDKONLINESTATE /*{ENCODED_INT: 10007}*/:
                    onReceiveOnlineState(this, extras.getBoolean(PushConsts.KEY_ONLINE_STATE));
                    return;
                case PushConsts.GET_SDKSERVICEPID /*{ENCODED_INT: 10008}*/:
                    onReceiveServicePid(this, extras.getInt(PushConsts.KEY_SERVICE_PIT));
                    return;
                case PushConsts.KEY_CMD_RESULT /*{ENCODED_INT: 10010}*/:
                    onReceiveCommandResult(this, (GTCmdMessage) intent.getSerializableExtra(PushConsts.KEY_CMD_MSG));
                    return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        if (intent != null) {
            try {
                processOnHandleIntent(intent);
            } catch (Throwable th) {
                ActivityC0460a.m1698b("GTIntentService|" + th.toString());
            }
        }
    }

    public abstract void onReceiveClientId(Context context, String str);

    public abstract void onReceiveCommandResult(Context context, GTCmdMessage gTCmdMessage);

    public abstract void onReceiveMessageData(Context context, GTTransmitMessage gTTransmitMessage);

    public abstract void onReceiveOnlineState(Context context, boolean z);

    public abstract void onReceiveServicePid(Context context, int i);
}
