package com.getui.getuiunity;

import android.content.Context;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTTransmitMessage;
import com.unity3d.player.UnityPlayer;
import com.wanmei.push.bean.Notice;
import org.json.JSONException;
import org.json.JSONObject;

public class GTPushIntentService extends GTIntentService {
    @Override // com.igexin.sdk.GTIntentService
    public void onReceiveServicePid(Context context, int pid) {
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onReceiveMessageData(Context context, GTTransmitMessage msg) {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("type", AssistPushConsts.MSG_TYPE_PAYLOAD);
            jsonObject.put("taskId", msg.getTaskId());
            jsonObject.put(Notice.MSG_ID, msg.getMessageId());
            jsonObject.put(AssistPushConsts.MSG_TYPE_PAYLOAD, new String(msg.getPayload()));
            UnityPlayer.UnitySendMessage(GTPushBridge.GAMA_OBJECT, "onReceiveMessage", jsonObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onReceiveClientId(Context context, String clientId) {
        UnityPlayer.UnitySendMessage(GTPushBridge.GAMA_OBJECT, "onReceiveClientId", clientId);
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onReceiveOnlineState(Context context, boolean online) {
    }

    @Override // com.igexin.sdk.GTIntentService
    public void onReceiveCommandResult(Context context, GTCmdMessage cmdMessage) {
    }
}
