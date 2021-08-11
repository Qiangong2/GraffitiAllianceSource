package com.getui.getuiunity;

import android.content.Context;
import com.igexin.sdk.PushManager;
import com.igexin.sdk.Tag;
import com.unity3d.player.UnityPlayer;
import com.xiaomi.mipush.sdk.MiPushClient;

public class GTPushBridge {
    public static String GAMA_OBJECT = "Main Camera";
    public static Context mContext;
    private static GTPushBridge pushBridge = new GTPushBridge();

    public static GTPushBridge getInstance() {
        return pushBridge;
    }

    public void initPush(String gameObject) {
        GAMA_OBJECT = gameObject;
        mContext = UnityPlayer.currentActivity.getApplicationContext();
        PushManager.getInstance().initialize(mContext, GTPushService.class);
        PushManager.getInstance().registerPushIntentService(mContext, GTPushIntentService.class);
    }

    public void setPushMode(boolean turnOn) {
        if (turnOn != PushManager.getInstance().isPushTurnedOn(mContext)) {
            if (turnOn) {
                PushManager.getInstance().turnOnPush(mContext);
            } else {
                PushManager.getInstance().turnOffPush(mContext);
            }
        }
    }

    public String getVersion() {
        return PushManager.getInstance().getVersion(mContext);
    }

    public String getClientId() {
        return PushManager.getInstance().getClientid(mContext);
    }

    public boolean isPushTurnOn() {
        return PushManager.getInstance().isPushTurnedOn(mContext);
    }

    public void turnOnPush() {
        if (!PushManager.getInstance().isPushTurnedOn(mContext)) {
            PushManager.getInstance().turnOnPush(mContext);
        }
    }

    public void turnOffPush() {
        if (PushManager.getInstance().isPushTurnedOn(mContext)) {
            PushManager.getInstance().turnOffPush(mContext);
        }
    }

    public int setTag(String tagNames) {
        Tag[] tags;
        String[] tagNameArray = tagNames.split(MiPushClient.ACCEPT_TIME_SEPARATOR);
        if (tagNames == null || tagNameArray.length <= 0) {
            tags = null;
        } else {
            tags = new Tag[tagNameArray.length];
            for (int i = 0; i < tagNameArray.length; i++) {
                Tag tag = new Tag();
                tag.setName(tagNameArray[i]);
                tags[i] = tag;
            }
        }
        return PushManager.getInstance().setTag(mContext, tags, "sn-default");
    }

    public boolean bindAlias(String alias) {
        return PushManager.getInstance().bindAlias(mContext, alias);
    }

    public boolean unBindAlias(String alias) {
        return PushManager.getInstance().unBindAlias(mContext, alias, true);
    }
}
