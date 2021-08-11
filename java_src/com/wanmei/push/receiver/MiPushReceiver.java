package com.wanmei.push.receiver;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.pwrd.google.gson.reflect.TypeToken;
import com.wanmei.push.C1638a;
import com.wanmei.push.C1645b;
import com.wanmei.push.PushAgent;
import com.wanmei.push.bean.Notice;
import com.wanmei.push.bean.PushMessage;
import com.wanmei.push.p099c.C1675b;
import com.wanmei.push.p102e.C1705e;
import com.wanmei.push.p104g.C1714f;
import com.wanmei.push.service.HandlePushArrivedService;
import com.wanmei.push.service.HandlePushNotifyService;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import java.util.List;

public class MiPushReceiver extends PushMessageReceiver {
    private String mAlias;
    private String mCommand;
    private String mEndTime;
    private String mMessage;
    private String mReason;
    private String mRegId;
    private long mResultCode = -1;
    private String mStartTime;
    private String mTopic;

    private PushMessage assembleValueFromPushMessage(String message) {
        try {
            return (PushMessage) C1705e.m6357a(message, new TypeToken<PushMessage>() {
                /* class com.wanmei.push.receiver.MiPushReceiver.C17201 */
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean checkPushMessageAppid(Context context, PushMessage pushMessage) {
        return pushMessage != null && !TextUtils.isEmpty(pushMessage.getAppId()) && pushMessage.getAppId().equals(C1645b.m6176a().mo9193b(context).getAppClientId());
    }

    private void startHandlePushArrivedService(Context context, PushMessage pushMessage) {
        Intent intent = new Intent(context.getApplicationContext(), HandlePushArrivedService.class);
        intent.setAction(context.getPackageName() + ".intent.action.PERFECT_PUSH_ARRIVED");
        Bundle bundle = new Bundle();
        bundle.putSerializable("message", pushMessage);
        intent.putExtras(bundle);
        context.getApplicationContext().startService(intent);
        C1714f.m6383c(context, "PERFECT_PUSH", "[" + context.getPackageName() + "] PushArrivedReceiver Start HandlePushArrivedService, Msg : " + pushMessage.toString());
    }

    private void startHandlePushNotifyService(Context context, PushMessage pushMessage) {
        Intent intent = new Intent(context.getApplicationContext(), HandlePushNotifyService.class);
        intent.setAction(context.getPackageName() + ".intent.action.PERFECT_PUSH_CLICKED");
        intent.putExtra(Notice.MSG_ID, pushMessage.getMsgId());
        context.getApplicationContext().startService(intent);
        C1714f.m6383c(context, "PERFECT_PUSH", "[" + context.getPackageName() + "] PushNotifyReceiver Start HandlePushNotifyService, Msg : " + pushMessage.toString());
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onCommandResult(Context context, MiPushCommandMessage message) {
        String command = message.getCommand();
        List<String> commandArguments = message.getCommandArguments();
        String str = (commandArguments == null || commandArguments.size() <= 0) ? null : commandArguments.get(0);
        String str2 = (commandArguments == null || commandArguments.size() <= 1) ? null : commandArguments.get(1);
        if (MiPushClient.COMMAND_REGISTER.equals(command)) {
            if (message.getResultCode() == 0) {
                this.mRegId = str;
            }
        } else if (MiPushClient.COMMAND_SET_ALIAS.equals(command)) {
            C1714f.m6379a("PERFECT_PUSH", C1638a.m6167a("COMMAND_SET_ALIAS :" + message));
            if (message.getResultCode() == 0) {
                this.mAlias = str;
            }
        } else if (MiPushClient.COMMAND_UNSET_ALIAS.equals(command)) {
            C1714f.m6379a("PERFECT_PUSH", C1638a.m6167a("COMMAND_UNSET_ALIAS :" + message));
            if (message.getResultCode() == 0) {
                this.mAlias = str;
            }
        } else if (MiPushClient.COMMAND_SUBSCRIBE_TOPIC.equals(command)) {
            C1714f.m6379a("PERFECT_PUSH", C1638a.m6167a("COMMAND_SUBSCRIBE_TOPIC :" + message));
            if (message.getResultCode() == 0) {
                this.mTopic = str;
            }
        } else if (MiPushClient.COMMAND_UNSUBSCRIBE_TOPIC.equals(command)) {
            C1714f.m6379a("PERFECT_PUSH", C1638a.m6167a("COMMAND_UNSUBSCRIBE_TOPIC :" + message));
            if (message.getResultCode() == 0) {
                this.mTopic = str;
            }
        } else if (MiPushClient.COMMAND_SET_ACCEPT_TIME.equals(command)) {
            C1714f.m6379a("PERFECT_PUSH", C1638a.m6167a("COMMAND_SET_ACCEPT_TIME :" + message));
            if (message.getResultCode() == 0) {
                this.mStartTime = str;
                this.mEndTime = str2;
            }
        }
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageArrived(Context context, MiPushMessage message) {
        this.mMessage = message.getContent();
        if (!TextUtils.isEmpty(message.getTopic())) {
            this.mTopic = message.getTopic();
        } else if (!TextUtils.isEmpty(message.getAlias())) {
            this.mAlias = message.getAlias();
        }
        C1714f.m6379a("PERFECT_PUSH", C1638a.m6167a("onNotificationMessageArrived:" + this.mMessage));
        PushMessage assembleValueFromPushMessage = assembleValueFromPushMessage(this.mMessage);
        if (checkPushMessageAppid(context, assembleValueFromPushMessage)) {
            startHandlePushArrivedService(context, assembleValueFromPushMessage);
        }
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageClicked(Context context, MiPushMessage message) {
        this.mMessage = message.getContent();
        if (!TextUtils.isEmpty(message.getTopic())) {
            this.mTopic = message.getTopic();
        } else if (!TextUtils.isEmpty(message.getAlias())) {
            this.mAlias = message.getAlias();
        }
        PushMessage assembleValueFromPushMessage = assembleValueFromPushMessage(this.mMessage);
        if (checkPushMessageAppid(context, assembleValueFromPushMessage)) {
            startHandlePushNotifyService(context, assembleValueFromPushMessage);
        }
        C1714f.m6379a("PERFECT_PUSH", C1638a.m6167a("onNotificationMessageClicked :" + this.mMessage));
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceivePassThroughMessage(Context context, MiPushMessage message) {
        this.mMessage = message.getContent();
        if (!TextUtils.isEmpty(message.getTopic())) {
            this.mTopic = message.getTopic();
        } else if (!TextUtils.isEmpty(message.getAlias())) {
            this.mAlias = message.getAlias();
        }
        C1714f.m6379a("PERFECT_PUSH", C1638a.m6167a("onReceivePassThroughMessage :" + this.mMessage));
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceiveRegisterResult(Context context, MiPushCommandMessage message) {
        C1714f.m6379a("PERFECT_PUSH", C1638a.m6167a("onReceiveRegisterResult"));
        String command = message.getCommand();
        List<String> commandArguments = message.getCommandArguments();
        String str = (commandArguments == null || commandArguments.size() <= 0) ? null : commandArguments.get(0);
        if (commandArguments != null && commandArguments.size() > 1) {
            commandArguments.get(1);
        }
        if (MiPushClient.COMMAND_REGISTER.equals(command) && message.getResultCode() == 0) {
            this.mRegId = str;
        }
        new C1675b(context).mo9317a(new PushAgent.OnPushOpenCallBack() {
            /* class com.wanmei.push.receiver.MiPushReceiver.C17212 */

            @Override // com.wanmei.push.PushAgent.OnPushOpenCallBack
            public void openFail(int i) {
                C1714f.m6379a("PERFECT_PUSH", "xiaomi push openFailed");
            }

            @Override // com.wanmei.push.PushAgent.OnPushOpenCallBack
            public void openSuccess() {
                C1714f.m6379a("PERFECT_PUSH", "xiaomi push openSuccess");
            }
        });
    }
}
