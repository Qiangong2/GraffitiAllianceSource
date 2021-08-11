package com.wanmei.sdk.core.open;

import android.app.Activity;
import android.content.Context;
import com.wanmei.push.PushAgent;
import com.wanmei.sdk.core.Proguard;
import com.wanmei.sdk.core.bean.Account;
import com.wanmei.sdk.core.bean.OrderInfo;
import com.wanmei.sdk.core.config.ChannelsReader;
import com.wanmei.sdk.core.net.DownloadParams;
import com.wanmei.sdk.core.open.SDKInterface;
import com.wanmei.sdk.core.param.BaseLoginParams;
import com.wanmei.sdk.core.param.BaseOrderParams;
import com.wanmei.sdk.core.task.LoginTask;
import com.wanmei.sdk.core.task.PayTask;
import com.wanmei.sdk.core.util.LogUtil;

public class SDKCoreFacade implements Proguard {
    private static volatile SDKCoreFacade INSTANCE = null;
    public static final int PLATFORM = 1;
    private SDKCore sdkCore = SDKCore.getInstance();

    private SDKCoreFacade() {
    }

    public static SDKCoreFacade getInstance() {
        if (INSTANCE == null) {
            synchronized (SDKCore.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SDKCoreFacade();
                }
            }
        }
        return INSTANCE;
    }

    public void doPay(Activity activity, BaseOrderParams orderParams, PayTask.PayCallBack listener) {
        this.sdkCore.doPay(activity, orderParams, listener);
    }

    public Account getAccount() {
        return this.sdkCore.getAccount();
    }

    public int getAppId() {
        return this.sdkCore.getAppId();
    }

    public String getAppKey() {
        return this.sdkCore.getAppKey();
    }

    public void getChannelConfig(Context context, int channelId, SDKInterface.ReadChannelCallBack readChannelCallBack) {
        ChannelsReader channelsReader = new ChannelsReader(context);
        if (readChannelCallBack != null) {
            channelsReader.getChannel(channelId, readChannelCallBack);
        }
    }

    public int getChannelId() {
        return this.sdkCore.getChannelId();
    }

    public OrderInfo getCommonOrderInfo() {
        return this.sdkCore.getCommonOrderInfo();
    }

    public String getLoginSchemeVersion() {
        return this.sdkCore.getLoginSchemeVersion();
    }

    public DownloadParams.Mode getMode() {
        return DownloadParams.m6506d();
    }

    public String getPaySchemeVersion() {
        return this.sdkCore.getPaySchemeVersion();
    }

    public String getPushDeviceId(Context context) {
        return PushAgent.getInstance(context).getDeviceId();
    }

    public void init(Context context, int appId, String appKey, int channelId) {
        this.sdkCore.init(context, appId, appKey, channelId);
    }

    public boolean isDebug() {
        return LogUtil.isLOG();
    }

    public void loginCommonSDK(Activity activity, BaseLoginParams loginParams, LoginTask.LoginCallBack listener) {
        this.sdkCore.loginCommonSDK(activity, loginParams, listener);
    }

    public void setDebug(boolean log) {
        LogUtil.setLOG(log);
    }

    public void setLoginSchemeVersion(String loginSchemeVersion) {
        this.sdkCore.setLoginSchemeVersion(loginSchemeVersion);
    }

    public void setMode(DownloadParams.Mode mode) {
        DownloadParams.m6503a(mode);
    }

    public void setPaySchemeVersion(String paySchemeVersion) {
        this.sdkCore.setPaySchemeVersion(paySchemeVersion);
    }
}
