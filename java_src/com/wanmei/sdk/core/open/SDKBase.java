package com.wanmei.sdk.core.open;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.wanmei.push.PushAgent;
import com.wanmei.sdk.core.Proguard;
import com.wanmei.sdk.core.config.ConfigReader;
import com.wanmei.sdk.core.net.DownloadParams;
import com.wanmei.sdk.core.open.SDKInterface;
import com.wanmei.sdk.core.p106ui.floatview.C1839c;
import com.wanmei.sdk.core.p106ui.floatview.FloatViewItem;
import com.wanmei.sdk.core.param.BaseLoginParams;
import com.wanmei.sdk.core.param.OrderParams;
import com.wanmei.sdk.core.param.Param;
import com.wanmei.sdk.core.task.LoginTask;
import com.wanmei.sdk.core.task.PayTask;
import com.wanmei.sdk.core.util.C1840a;
import com.wanmei.sdk.core.util.LogUtil;
import com.wanmei.sdk.core.util.Toast;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;

public abstract class SDKBase extends SDKImpl implements Proguard {
    private static final String CHANNEL_LOGIN_ERROR_MSG = "登录发生异常，请稍后重试";
    private static final String CHANNEL_PAY_ERROR_MSG = "本次支付没有成功，请稍后重试";
    private static final String DEFAULT_CONFIG_FILE_NAME = "OneSDK.config";
    private static final String FLASH_PIC_LANDSCAPE = "common_flash_landscape.png";
    private static final String FLASH_PIC_PORTRAIT = "common_flash_portrait.png";
    private static final int FLASH_TIMER_TIME_MILLISECEND = 3000;
    private static volatile SDKBase INSTANCE = null;
    private static final long INTERVAL = 2000;
    private static final String TAG = SDKBase.class.getName();
    private static Activity mActivity;
    private String commonOrderMsg;
    private HashMap<IntervalType, Long> lastTimeHashMap = new HashMap<>();
    private int mAppId;
    private String mAppKey;
    private int mChannelId;
    private volatile InitState mChannelInitState = InitState.process;
    private String mChannelName;
    private String mConfigFileName;
    private String mConfigFilePath;
    private ConfigReader mConfigReader;
    private volatile boolean mHasLogin = false;
    protected SDKInterface.InitCallBack mInitCallBack;
    private volatile String mInitMsg;
    protected SDKInterface.LoginCallBack mLoginCallBack;
    protected SDKInterface.LogoutCallBack mLogoutCallBack;
    private volatile InitState mOnesdkInitState = InitState.process;
    protected SDKInterface.PayCallBack mPayCallBack;

    /* access modifiers changed from: private */
    public enum InitState {
        success,
        process,
        fail
    }

    /* access modifiers changed from: private */
    public enum IntervalType {
        INIT,
        LOGIN,
        PAY,
        LOGOUT
    }

    public enum UserInfoType {
        CREATE_ROLE,
        LOGIN,
        ROLE_LEVEL_CHANGE
    }

    protected SDKBase() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean checkInit() {
        if (this.mOnesdkInitState == InitState.success && this.mChannelInitState == InitState.success) {
            return true;
        }
        Toast.makeToast(getActivity(), "请等待初始化成功");
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean checkInterval(IntervalType intervalType) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - (this.lastTimeHashMap.get(intervalType) == null ? 0 : this.lastTimeHashMap.get(intervalType).longValue()) > INTERVAL) {
            this.lastTimeHashMap.put(intervalType, Long.valueOf(currentTimeMillis));
            return true;
        }
        this.lastTimeHashMap.put(intervalType, Long.valueOf(currentTimeMillis));
        android.widget.Toast.makeText(getActivity(), "请稍等几秒后再试", 0).show();
        LogUtil.m6673e(TAG, "less than 2000 milliseconds between two requests," + intervalType);
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean checkLogin() {
        if (!this.mHasLogin) {
            Toast.makeToast(getActivity(), "未登录");
        }
        return this.mHasLogin;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void commonOrder(final OrderParams orderParams) {
        SDKCoreFacade.getInstance().doPay(getActivity(), orderParams, new PayTask.PayCallBack() {
            /* class com.wanmei.sdk.core.open.SDKBase.C178916 */

            @Override // com.wanmei.sdk.core.task.PayTask.PayCallBack
            public void failed(String msg) {
                LogUtil.m6672d(SDKBase.TAG, "SDKCoreFacade.getInstance().doPay failed: msg: " + msg);
                SDKBase.this.payOneSDKFailed(msg);
            }

            @Override // com.wanmei.sdk.core.task.PayTask.PayCallBack
            public void succeed(String commonOrderId, String msg) {
                LogUtil.m6672d(SDKBase.TAG, "SDKCoreFacade.getInstance().doPay succeed: commonOrderId: " + commonOrderId + " msg: " + msg);
                SDKBase.this.commonOrderMsg = msg;
                SDKBase.mActivity.runOnUiThread(new Runnable() {
                    /* class com.wanmei.sdk.core.open.SDKBase.C178916.RunnableC17901 */

                    public void run() {
                        SDKBase.this.doPayImpl(orderParams);
                    }
                });
            }
        });
    }

    private void destroyFloatView(Context con) {
        if (getFloatViewItemImpl() != null) {
            C1839c.m6668a().mo9909b(con);
        } else {
            destroyFloatViewImpl();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void dismissFloatView(Context con) {
        if (getFloatViewItemImpl() != null) {
            C1839c.m6668a().mo9907a(con);
        } else {
            dismissFloatViewImpl();
        }
    }

    private void doInitImpl() {
        this.mChannelInitState = InitState.process;
        initImpl();
    }

    private void doLogout(final SDKInterface.LogoutCallBack logoutCallBack) {
        getActivity().runOnUiThread(new Runnable() {
            /* class com.wanmei.sdk.core.open.SDKBase.RunnableC179117 */

            public void run() {
                if (logoutCallBack == null) {
                    throw new RuntimeException("logoutCallBack is null");
                }
                SDKBase.this.mLogoutCallBack = logoutCallBack;
                if (SDKBase.this.checkInterval(IntervalType.LOGOUT) && SDKBase.this.checkInit() && SDKBase.this.checkLogin()) {
                    SDKBase.this.doLogoutImpl();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void doNext() {
        try {
            SDKCoreFacade.getInstance().init(mActivity, this.mAppId, this.mAppKey, this.mChannelId);
            SDKCoreFacade.getInstance().setLoginSchemeVersion(getLoginSchemeVersion());
            SDKCoreFacade.getInstance().setPaySchemeVersion(getPaySchemeVersion());
            readConfig(this.mAppId, this.mAppKey, getVersion(), this.mConfigFileName, getConfigReader());
            try {
                if (!SDKCoreFacade.getInstance().getMode().equals(DownloadParams.Mode.sample)) {
                    initPushSDK();
                }
            } catch (Exception e) {
                Log.d(TAG, "Exception initPushSDK()");
                e.printStackTrace();
            }
            tryFlash();
            doInitImpl();
        } catch (Exception e2) {
            e2.printStackTrace();
            initFailed("");
        }
    }

    public static Activity getActivity() {
        return mActivity;
    }

    public static SDKBase getInstance(Activity activity) {
        mActivity = activity;
        if (INSTANCE == null) {
            synchronized (SDKBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = getInstanceImpl();
                }
            }
        }
        return INSTANCE;
    }

    private static SDKBase getInstanceImpl() {
        SDKBase sDKBase;
        synchronized (SDKMutidexApplication.class) {
            try {
                Log.d(TAG, "getInstanceImpl");
                if (SDKMutidexApplication.useMutiDex() && !SDKMutidexApplication.hasLoadMutiDex()) {
                    Log.d(TAG, "before wait");
                    SDKMutidexApplication.class.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            C1840a.m6677a().mo9911a(getActivity());
            C1840a.m6677a().mo9912b();
            sDKBase = (SDKBase) C1840a.m6677a().mo9910a(SDKBase.class);
        }
        return sDKBase;
    }

    private void initPushSDK() {
        PushAgent instance = PushAgent.getInstance(getActivity());
        instance.setPushNotifyIcon(getActivity().getApplicationInfo().icon);
        instance.oneSDKInitPush(new StringBuilder().append(this.mAppId).toString(), this.mAppKey);
        instance.setDebugMode(SDKCoreFacade.getInstance().isDebug());
        instance.openPush(new PushAgent.OnPushOpenCallBack() {
            /* class com.wanmei.sdk.core.open.SDKBase.C17942 */

            @Override // com.wanmei.push.PushAgent.OnPushOpenCallBack
            public void openFail(int code) {
                Log.d(SDKBase.TAG, "openPush openFail code: " + code);
            }

            @Override // com.wanmei.push.PushAgent.OnPushOpenCallBack
            public void openSuccess() {
                Log.d(SDKBase.TAG, "openPush openSuccess");
            }
        });
    }

    private synchronized void notifyInitResult() {
        getActivity().runOnUiThread(new Runnable() {
            /* class com.wanmei.sdk.core.open.SDKBase.RunnableC17983 */

            public void run() {
                if (SDKBase.this.mOnesdkInitState == InitState.success && SDKBase.this.mChannelInitState == InitState.success) {
                    SDKBase.this.mInitCallBack.initSucceed(SDKBase.this.mInitMsg);
                } else if (SDKBase.this.mOnesdkInitState == InitState.fail || SDKBase.this.mChannelInitState == InitState.fail) {
                    SDKBase.this.mInitCallBack.initFailed(SDKBase.this.mInitMsg);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onOnesdkInitSuccess() {
        this.mOnesdkInitState = InitState.success;
        notifyInitResult();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void showFloatView(Context con, int floatViewPlace) {
        FloatViewItem[] floatViewItemImpl = getFloatViewItemImpl();
        if (floatViewItemImpl != null) {
            C1839c.m6668a().mo9908a(con, floatViewPlace, floatViewItemImpl);
        } else {
            showFloatViewImpl();
        }
    }

    private void tryFlash() {
        try {
            Configuration configuration = getActivity().getResources().getConfiguration();
            String str = FLASH_PIC_PORTRAIT;
            if (configuration.orientation == 1) {
                str = FLASH_PIC_PORTRAIT;
            } else if (configuration.orientation == 2) {
                str = FLASH_PIC_LANDSCAPE;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(getActivity().getResources(), BitmapFactory.decodeStream(getActivity().getAssets().open(str)));
            final Dialog dialog = new Dialog(getActivity());
            dialog.requestWindowFeature(1);
            dialog.getWindow().setFlags(1024, 1024);
            LinearLayout linearLayout = new LinearLayout(getActivity());
            linearLayout.setBackgroundDrawable(bitmapDrawable);
            dialog.setContentView(linearLayout, new ViewGroup.LayoutParams(-1, -1));
            dialog.setCancelable(false);
            dialog.getWindow().setBackgroundDrawableResource(17170445);
            dialog.getWindow().setLayout(-1, -1);
            dialog.show();
            new Timer().schedule(new TimerTask() {
                /* class com.wanmei.sdk.core.open.SDKBase.C179520 */

                public void run() {
                    SDKBase.getActivity().runOnUiThread(new Runnable() {
                        /* class com.wanmei.sdk.core.open.SDKBase.C179520.RunnableC17961 */

                        public void run() {
                            dialog.dismiss();
                            LogUtil.m6675v(SDKBase.TAG, "flash finished");
                            if (SDKBase.this.mChannelInitState != InitState.fail) {
                                SDKBase.this.onOnesdkInitSuccess();
                            }
                        }
                    });
                }
            }, 3000);
        } catch (Exception e) {
            getActivity().runOnUiThread(new Runnable() {
                /* class com.wanmei.sdk.core.open.SDKBase.RunnableC179721 */

                public void run() {
                    Log.d(SDKBase.TAG, "flash failed");
                    SDKBase.this.onOnesdkInitSuccess();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void destroyFloatViewImpl() {
    }

    /* access modifiers changed from: protected */
    public void dismissFloatViewImpl() {
    }

    public void doLogin(final SDKInterface.LoginCallBack loginCallBack) {
        getActivity().runOnUiThread(new Runnable() {
            /* class com.wanmei.sdk.core.open.SDKBase.RunnableC17994 */

            public void run() {
                if (loginCallBack == null) {
                    throw new RuntimeException("loginCallBack is null");
                }
                SDKBase.this.mLoginCallBack = loginCallBack;
                if (SDKBase.this.checkInterval(IntervalType.LOGIN) && SDKBase.this.checkInit()) {
                    SDKBase.this.doLoginImpl();
                }
            }
        });
    }

    public void doLogout() {
        doLogout(this.mLogoutCallBack);
    }

    public void doPay(final OrderParams orderParams, final SDKInterface.PayCallBack payCallBack) {
        getActivity().runOnUiThread(new Runnable() {
            /* class com.wanmei.sdk.core.open.SDKBase.RunnableC178310 */

            public void run() {
                if (payCallBack == null) {
                    throw new RuntimeException("payCallBack is null");
                }
                SDKBase.this.mPayCallBack = payCallBack;
                if (SDKBase.this.checkInterval(IntervalType.PAY) && SDKBase.this.checkInit() && SDKBase.this.checkLogin()) {
                    SDKBase.this.commonOrder(orderParams);
                }
            }
        });
    }

    public int getAppId() {
        return this.mAppId;
    }

    public void getChannelConfig(int channelId, SDKInterface.ReadChannelCallBack readChannelCallBack) {
        SDKCoreFacade.getInstance().getChannelConfig(mActivity, channelId, readChannelCallBack);
    }

    public abstract int getChannelId();

    public abstract String getChannelName();

    public String getCommonOrderId() {
        return SDKCoreFacade.getInstance().getCommonOrderInfo().getOrderId();
    }

    public String getCommonOrderMsg() {
        return this.commonOrderMsg;
    }

    /* access modifiers changed from: protected */
    public abstract ConfigReader getConfigReader();

    /* access modifiers changed from: protected */
    public FloatViewItem[] getFloatViewItemImpl() {
        return null;
    }

    /* access modifiers changed from: protected */
    public int getFloatViewPlace() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public HashMap<String, Param> getInitConfig() {
        return this.mConfigReader.getInitConfig();
    }

    /* access modifiers changed from: protected */
    public HashMap<String, Param> getLoginConfig() {
        return this.mConfigReader.getLoginConfig();
    }

    /* access modifiers changed from: protected */
    public String getLoginSchemeVersion() {
        return "";
    }

    public String getPassword() {
        return SDKCoreFacade.getInstance().getAccount().getPassword();
    }

    /* access modifiers changed from: protected */
    public HashMap<String, Param> getPayConfig() {
        return this.mConfigReader.getPayConfig();
    }

    /* access modifiers changed from: protected */
    public String getPaySchemeVersion() {
        return "";
    }

    public String getPushDeviceId() {
        return SDKCoreFacade.getInstance().getPushDeviceId(getActivity());
    }

    public String getToken() {
        return SDKCoreFacade.getInstance().getAccount().getToken();
    }

    public String getUserId() {
        return SDKCoreFacade.getInstance().getAccount().getUserId();
    }

    /* access modifiers changed from: protected */
    public abstract String getVersion();

    public void init(int appId, String appKey, SDKInterface.InitCallBack initCallBack) {
        init(appId, appKey, DEFAULT_CONFIG_FILE_NAME, initCallBack);
    }

    public void init(int appId, String appKey, String configFileName, final SDKInterface.InitCallBack initCallBack) {
        this.mHasLogin = false;
        this.mChannelInitState = InitState.process;
        this.mOnesdkInitState = InitState.process;
        this.mInitCallBack = initCallBack;
        this.mAppId = appId;
        this.mAppKey = appKey;
        this.mChannelId = getChannelId();
        this.mChannelName = getChannelName();
        this.mConfigFileName = configFileName;
        LogUtil.m6672d(TAG, "channelId : " + this.mChannelId + "channelName : " + this.mChannelName);
        getActivity().runOnUiThread(new Runnable() {
            /* class com.wanmei.sdk.core.open.SDKBase.RunnableC17821 */

            public void run() {
                if (initCallBack == null) {
                    throw new RuntimeException("initCallBack is null");
                } else if (SDKBase.this.checkInterval(IntervalType.INIT)) {
                    SDKBase.this.doNext();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void initFailed(String msg) {
        this.mChannelInitState = InitState.fail;
        this.mInitMsg = msg;
        notifyInitResult();
    }

    /* access modifiers changed from: protected */
    public void initSucceed(String msg) {
        this.mChannelInitState = InitState.success;
        this.mInitMsg = msg;
        notifyInitResult();
    }

    public boolean isHasInit() {
        return this.mOnesdkInitState == InitState.success && this.mChannelInitState == InitState.success;
    }

    public boolean isHasLogin() {
        return this.mHasLogin;
    }

    /* access modifiers changed from: protected */
    public void loginCancelled() {
        getActivity().runOnUiThread(new Runnable() {
            /* class com.wanmei.sdk.core.open.SDKBase.RunnableC18049 */

            public void run() {
                SDKBase.this.mLoginCallBack.cancelled();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void loginFailed(final String msg) {
        getActivity().runOnUiThread(new Runnable() {
            /* class com.wanmei.sdk.core.open.SDKBase.RunnableC18027 */

            public void run() {
                Toast.makeToastChannelError(SDKBase.getActivity(), SDKBase.this.getChannelName(), SDKBase.CHANNEL_LOGIN_ERROR_MSG, -40);
                SDKBase.this.mLoginCallBack.failed(msg);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void loginOneSDK(String uid, String token, BaseLoginParams baseLoginParams) {
        LogUtil.m6672d(TAG, "loginOneSDK:  uid: " + uid + " token: " + token);
        baseLoginParams.setBasicParams(uid, token);
        SDKCoreFacade.getInstance().loginCommonSDK(getActivity(), baseLoginParams, new LoginTask.LoginCallBack() {
            /* class com.wanmei.sdk.core.open.SDKBase.C18005 */

            @Override // com.wanmei.sdk.core.task.LoginTask.LoginCallBack
            public void failed(String msg) {
                LogUtil.m6672d(SDKBase.TAG, "login failed, msg:" + msg);
                SDKBase.this.loginOneSDKFailed(msg);
            }

            @Override // com.wanmei.sdk.core.task.LoginTask.LoginCallBack
            public void succeed(String msg) {
                LogUtil.m6672d(SDKBase.TAG, "login succeed msg:" + msg);
                SDKBase.this.loginSucceed(msg);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void loginOneSDKFailed(final String msg) {
        getActivity().runOnUiThread(new Runnable() {
            /* class com.wanmei.sdk.core.open.SDKBase.RunnableC18038 */

            public void run() {
                Toast.makeToastOneSDKError(SDKBase.getActivity(), SDKBase.CHANNEL_LOGIN_ERROR_MSG, -20);
                SDKBase.this.mLoginCallBack.failed(msg);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void loginSucceed(final String msg) {
        getActivity().runOnUiThread(new Runnable() {
            /* class com.wanmei.sdk.core.open.SDKBase.RunnableC18016 */

            public void run() {
                SDKBase.this.mHasLogin = true;
                SDKBase.this.mLoginCallBack.succeed(SDKBase.this.getUserId(), SDKBase.this.getToken(), SDKBase.this.getPassword(), msg);
                SDKBase.this.showFloatView(SDKBase.getActivity(), SDKBase.this.getFloatViewPlace());
            }
        });
    }

    /* access modifiers changed from: protected */
    public void logoutFailed(final String msg) {
        getActivity().runOnUiThread(new Runnable() {
            /* class com.wanmei.sdk.core.open.SDKBase.RunnableC179319 */

            public void run() {
                SDKBase.this.mLogoutCallBack.failed(msg);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void logoutSucceed() {
        getActivity().runOnUiThread(new Runnable() {
            /* class com.wanmei.sdk.core.open.SDKBase.RunnableC179218 */

            public void run() {
                SDKBase.this.mHasLogin = false;
                SDKBase.this.mLogoutCallBack.succeed();
                SDKBase.this.dismissFloatView(SDKBase.getActivity());
            }
        });
    }

    @Override // com.wanmei.sdk.core.open.SDKFoundation
    public void onDestroy(SDKInterface.CompleteCallBack completeCallBack) {
        this.mHasLogin = false;
        destroyFloatView(getActivity());
        completeCallBack.onComplete();
    }

    /* access modifiers changed from: protected */
    public void payCancelled(final String msg) {
        getActivity().runOnUiThread(new Runnable() {
            /* class com.wanmei.sdk.core.open.SDKBase.RunnableC178714 */

            public void run() {
                SDKBase.this.mPayCallBack.cancelled("", msg);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void payFailed(final String msg) {
        getActivity().runOnUiThread(new Runnable() {
            /* class com.wanmei.sdk.core.open.SDKBase.RunnableC178512 */

            public void run() {
                Toast.makeToastChannelError(SDKBase.getActivity(), SDKBase.this.getChannelName(), SDKBase.CHANNEL_PAY_ERROR_MSG, -50);
                SDKBase.this.mPayCallBack.failed("", msg);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void payOneSDKFailed(final String msg) {
        getActivity().runOnUiThread(new Runnable() {
            /* class com.wanmei.sdk.core.open.SDKBase.RunnableC178613 */

            public void run() {
                Toast.makeToastOneSDKError(SDKBase.getActivity(), SDKBase.CHANNEL_PAY_ERROR_MSG, -30);
                SDKBase.this.mPayCallBack.failed("", msg);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void payOrdered(final String msg) {
        getActivity().runOnUiThread(new Runnable() {
            /* class com.wanmei.sdk.core.open.SDKBase.RunnableC178815 */

            public void run() {
                SDKBase.this.mPayCallBack.ordered(SDKBase.this.getCommonOrderId(), msg);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void paySucceed(final String msg) {
        getActivity().runOnUiThread(new Runnable() {
            /* class com.wanmei.sdk.core.open.SDKBase.RunnableC178411 */

            public void run() {
                SDKBase.this.mPayCallBack.succeed(SDKBase.this.getCommonOrderId(), msg);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void readConfig(int appId, String appKey, String version, String configFileName, ConfigReader configReader) throws JSONException {
        this.mConfigReader = configReader;
        this.mConfigReader.setBasic(appId, appKey, version);
        if (!TextUtils.isEmpty(this.mConfigFilePath)) {
            this.mConfigReader.readConfigFilePath(this.mConfigFilePath);
        } else {
            this.mConfigReader.readConfigFileName(configFileName);
        }
    }

    public void setConfigFilePath(String configFilePath) {
        this.mConfigFilePath = configFilePath;
    }

    /* access modifiers changed from: protected */
    public void setHasInit(boolean hasInit) {
        if (hasInit) {
            this.mOnesdkInitState = InitState.success;
            this.mChannelInitState = InitState.success;
            return;
        }
        this.mOnesdkInitState = InitState.process;
        this.mChannelInitState = InitState.process;
    }

    /* access modifiers changed from: protected */
    public void setHasLogin(boolean hasLogin) {
        this.mHasLogin = hasLogin;
    }

    public void setLogoutCallBack(SDKInterface.LogoutCallBack logoutCallBack) {
        this.mLogoutCallBack = logoutCallBack;
    }

    /* access modifiers changed from: protected */
    public void showFloatViewImpl() {
    }

    public void submitUserInfo(UserInfoType userInfoType, UserInfo userInfo, SDKInterface.CompleteCallBack completeCallBack) {
        completeCallBack.onComplete();
    }
}
