package plugins;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.unity3d.player.UnityPlayer;
import com.wanmei.sdk.core.open.SDKBase;
import com.wanmei.sdk.core.open.SDKInterface;
import com.wanmei.sdk.core.open.UserInfo;

public class OneSdkPlugin {
    private static final int ONESDK_APPID = 1243;
    private static final String ONESDK_APPKEY = "rbflsiyyy9kttglfnl5v367h7msuucxm";
    private static final String TAG = "CQQ_ONESDK";
    String balance;
    String createTime;

    /* renamed from: id */
    String f6260id;
    String level;
    private Activity mActivity;
    private Context mContext;
    String name;
    String partyName;
    String vip;
    int zoneId;
    String zoneName;

    public void OneSdkInit(Context context, Activity activity) {
        this.mContext = context;
        this.mActivity = activity;
        SDKBase.getInstance(this.mActivity).init(ONESDK_APPID, ONESDK_APPKEY, new SDKInterface.InitCallBack() {
            /* class plugins.OneSdkPlugin.C22001 */

            @Override // com.wanmei.sdk.core.open.SDKInterface.InitCallBack
            public void initSucceed(String msg) {
                Log.d(OneSdkPlugin.TAG, "onInitSucceed");
                OneSdkPlugin.this.OneSdkLogin();
            }

            @Override // com.wanmei.sdk.core.open.SDKInterface.InitCallBack
            public void initFailed(String msg) {
                Log.d(OneSdkPlugin.TAG, "onInitFailed");
                OneSdkPlugin.this.LoginFail();
            }
        });
        SDKBase.getInstance(this.mActivity).setLogoutCallBack(new SDKInterface.LogoutCallBack() {
            /* class plugins.OneSdkPlugin.C22012 */

            @Override // com.wanmei.sdk.core.open.SDKInterface.LogoutCallBack
            public void succeed() {
                OneSdkPlugin.this.ReLogin("");
            }

            @Override // com.wanmei.sdk.core.open.SDKInterface.LogoutCallBack
            public void failed(String msg) {
                Log.d(OneSdkPlugin.TAG, "onLogoutFailed");
                OneSdkPlugin.this.ReLogin("logout fail");
            }
        });
    }

    public void OneSdkLogin() {
        SDKBase.getInstance(this.mActivity).doLogin(new SDKInterface.LoginCallBack() {
            /* class plugins.OneSdkPlugin.C22023 */

            @Override // com.wanmei.sdk.core.open.SDKInterface.LoginCallBack
            public void succeed(String userId, String token, String password, String msg) {
                OneSdkPlugin.this.CallUnityMethod("Android_DoLogin", String.format("%s,%s,%s,%s", userId, token, password, "" + SDKBase.getInstance(OneSdkPlugin.this.mActivity).getChannelId()));
            }

            @Override // com.wanmei.sdk.core.open.SDKInterface.LoginCallBack
            public void failed(String msg) {
                OneSdkPlugin.this.LoginFail();
            }

            @Override // com.wanmei.sdk.core.open.SDKInterface.LoginCallBack
            public void cancelled() {
                OneSdkPlugin.this.LoginFail();
            }
        });
    }

    private UserInfo getUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setRoleId(this.f6260id);
        userInfo.setRoleName(this.name);
        userInfo.setLv(this.level);
        userInfo.setZoneId(this.zoneId);
        userInfo.setZoneName(this.zoneName);
        userInfo.setPartyName("NULL");
        userInfo.setBalance("-1");
        userInfo.setVip(this.vip);
        userInfo.setRoleCreateTime("1480747870");
        return userInfo;
    }

    public void EnterServerSubmitUserInfo(String roleId, String roleName, String roleLevel, int roleZoneId, String roleZoneName, String rolePartyName, String roleBalance, String roldVip, String roleCreateTime) {
        this.f6260id = roleId;
        this.name = roleName;
        this.level = roleLevel;
        this.zoneId = roleZoneId;
        this.zoneName = roleZoneName;
        this.partyName = rolePartyName;
        this.balance = roleBalance;
        this.vip = roldVip;
        this.createTime = roleCreateTime;
        SDKBase.getInstance(this.mActivity).submitUserInfo(SDKBase.UserInfoType.LOGIN, getUserInfo(), new SDKInterface.CompleteCallBack() {
            /* class plugins.OneSdkPlugin.C22034 */

            @Override // com.wanmei.sdk.core.open.SDKInterface.CompleteCallBack
            public void onComplete() {
            }
        });
    }

    public void CreateRoleSubmitUserInfo(String roleId, String roleName, String roleLevel, int roleZoneId, String roleZoneName, String rolePartyName, String roleBalance, String roldVip, String roleCreateTime) {
        this.f6260id = roleId;
        this.name = roleName;
        this.level = roleLevel;
        this.zoneId = roleZoneId;
        this.zoneName = roleZoneName;
        this.partyName = rolePartyName;
        this.balance = roleBalance;
        this.vip = roldVip;
        this.createTime = roleCreateTime;
        SDKBase.getInstance(this.mActivity).submitUserInfo(SDKBase.UserInfoType.CREATE_ROLE, getUserInfo(), new SDKInterface.CompleteCallBack() {
            /* class plugins.OneSdkPlugin.C22045 */

            @Override // com.wanmei.sdk.core.open.SDKInterface.CompleteCallBack
            public void onComplete() {
            }
        });
    }

    public void RoleLevelUpSubmitUserInfo(String roleLevel) {
        this.level = roleLevel;
        SDKBase.getInstance(this.mActivity).submitUserInfo(SDKBase.UserInfoType.ROLE_LEVEL_CHANGE, getUserInfo(), new SDKInterface.CompleteCallBack() {
            /* class plugins.OneSdkPlugin.C22056 */

            @Override // com.wanmei.sdk.core.open.SDKInterface.CompleteCallBack
            public void onComplete() {
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void CallUnityMethod(String arg2, String arg3) {
        UnityPlayer.UnitySendMessage("MainRoot", arg2, arg3);
    }

    /* access modifiers changed from: package-private */
    public void LoginFail() {
        CallUnityMethod("Android_DoLogin", String.format("%s,%s,%s,%s", "null", "null", "null", "0"));
    }

    /* access modifiers changed from: package-private */
    public void ReLogin(String str) {
        CallUnityMethod("Android_ReLogin", str);
    }
}
