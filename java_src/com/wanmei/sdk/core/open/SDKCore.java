package com.wanmei.sdk.core.open;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.igexin.sdk.PushConsts;
import com.umeng.analytics.p086a.p087a.C1376d;
import com.umeng.analytics.p091b.C1447g;
import com.wanmei.sdk.core.Proguard;
import com.wanmei.sdk.core.bean.Account;
import com.wanmei.sdk.core.bean.AppInfo;
import com.wanmei.sdk.core.bean.OrderInfo;
import com.wanmei.sdk.core.log.manager.LogManager;
import com.wanmei.sdk.core.net.C1768b;
import com.wanmei.sdk.core.net.DownloadParams;
import com.wanmei.sdk.core.param.BaseLoginParams;
import com.wanmei.sdk.core.param.BaseOrderParams;
import com.wanmei.sdk.core.task.LoginTask;
import com.wanmei.sdk.core.task.PayTask;
import com.wanmei.sdk.core.util.C1841b;
import com.wanmei.sdk.core.util.LogUtil;
import com.wanmei.sdk.core.util.Util;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.Executors;

public class SDKCore implements Proguard {
    private static volatile SDKCore INSTANCE;
    private static final String TAG = SDKCore.class.getName();
    private static volatile Account mAccount;
    private static volatile AppInfo mAppInfo;
    private static volatile OrderInfo mOrderInfo;

    private SDKCore() {
    }

    public static SDKCore getInstance() {
        if (INSTANCE == null) {
            synchronized (SDKCore.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SDKCore();
                }
            }
        }
        return INSTANCE;
    }

    private void setAndPersistAppInfo(Context context, int appId, String appKey, int channelId) {
        if (mAppInfo == null) {
            synchronized (SDKCore.class) {
                if (mAppInfo == null) {
                    mAppInfo = new AppInfo();
                }
            }
        }
        mAppInfo.setAppId(appId);
        mAppInfo.setAppKey(appKey);
        mAppInfo.setChannelId(channelId);
    }

    public void doPay(Activity activity, BaseOrderParams paramMap, PayTask.PayCallBack listener) {
        if (mAppInfo == null) {
            throw new RuntimeException("no appInfo");
        } else if (mAccount == null) {
            throw new RuntimeException("no login");
        } else if (paramMap == null) {
            throw new RuntimeException("no orderParams");
        } else {
            paramMap.validate();
            new PayTask(activity, paramMap, listener).mo9832c();
        }
    }

    public Account getAccount() {
        if (mAccount == null) {
            synchronized (SDKCore.class) {
                if (mAccount == null) {
                    mAccount = new Account();
                }
            }
        }
        return mAccount;
    }

    public int getAppId() {
        if (mAppInfo == null) {
            return 0;
        }
        return mAppInfo.getAppId();
    }

    public String getAppKey() {
        return mAppInfo == null ? "" : mAppInfo.getAppKey();
    }

    public int getChannelId() {
        if (mAppInfo == null) {
            return 0;
        }
        return mAppInfo.getChannelId();
    }

    public String getCommonOrderId() {
        return mOrderInfo.getOrderId() == null ? "" : mOrderInfo.getOrderId();
    }

    public OrderInfo getCommonOrderInfo() {
        if (mOrderInfo == null) {
            synchronized (SDKCore.class) {
                if (mOrderInfo == null) {
                    mOrderInfo = new OrderInfo();
                }
            }
        }
        return mOrderInfo;
    }

    public String getLoginSchemeVersion() {
        return mAppInfo == null ? "" : mAppInfo.getLoginSchemeVersion();
    }

    public String getPaySchemeVersion() {
        return mAppInfo == null ? "" : mAppInfo.getPaySchemeVersion();
    }

    public void init(final Context context, final int appId, String appKey, final int channelId) {
        if (context == null || appId <= 0 || TextUtils.isEmpty(appKey) || channelId <= 0) {
            throw new RuntimeException("params are wrong");
        }
        setAndPersistAppInfo(context, appId, appKey, channelId);
        LogManager.INSTANCE.init(context);
        DownloadParams.m6502a();
        LogManager.INSTANCE.getLogger().mo9550a();
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            /* class com.wanmei.sdk.core.open.SDKCore.RunnableC18051 */

            public void run() {
                C1768b bVar = new C1768b(context);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("appid", new StringBuilder().append(appId).toString());
                hashMap.put(C1447g.f3507b, new StringBuilder().append(channelId).toString());
                hashMap.put("dt", Build.MODEL);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                hashMap.put("ppi", displayMetrics.widthPixels + "X" + displayMetrics.heightPixels);
                hashMap.put(C1376d.C1383c.f3266a, Build.VERSION.RELEASE);
                hashMap.put("net", C1841b.m6682a(context));
                hashMap.put("isp", C1841b.m6684b(context));
                hashMap.put("ip", C1841b.m6681a());
                String sb = new StringBuilder().append(Calendar.getInstance().getTimeInMillis()).toString();
                hashMap.put("ltime", sb);
                String c = C1841b.m6685c(context);
                hashMap.put("udid", c);
                hashMap.put("sign", Util.md5(sb + c));
                hashMap.put(PushConsts.CMD_ACTION, "start");
                hashMap.put("platform", "android");
                hashMap.put("dmem", C1841b.m6683b());
                bVar.mo9556a("http://log.laohu.com/open", hashMap);
            }
        });
    }

    public boolean isDebug() {
        return LogUtil.isLOG();
    }

    public void loginCommonSDK(Activity activity, BaseLoginParams loginParams, LoginTask.LoginCallBack listener) {
        new LoginTask(activity, loginParams, listener).mo9832c();
    }

    public void setDebug(boolean log) {
        LogUtil.setLOG(log);
    }

    public void setLoginSchemeVersion(String loginSchemeVersion) {
        if (mAppInfo == null) {
            throw new RuntimeException("mAppInfo is null");
        }
        mAppInfo.setLoginSchemeVersion(loginSchemeVersion);
    }

    public void setPaySchemeVersion(String paySchemeVersion) {
        if (mAppInfo == null) {
            throw new RuntimeException("mAppInfo is null");
        }
        mAppInfo.setPaySchemeVersion(paySchemeVersion);
    }
}
