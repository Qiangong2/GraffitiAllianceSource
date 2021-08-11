package com.wanmei.sdk.core.task;

import android.app.Activity;
import com.pwrd.android.volley.VolleyError;
import com.wanmei.sdk.core.LibCoreCode;
import com.wanmei.sdk.core.bean.LoginReq;
import com.wanmei.sdk.core.bean.LoginResp;
import com.wanmei.sdk.core.net.DownloadParams;
import com.wanmei.sdk.core.open.SDKCoreFacade;
import com.wanmei.sdk.core.param.BaseLoginParams;
import com.wanmei.sdk.core.util.Toast;

public class LoginTask extends AbstractC1807a<LoginResp> {

    /* renamed from: c */
    private BaseLoginParams f4503c;

    /* renamed from: d */
    private LoginListener f4504d;

    /* renamed from: e */
    private LoginCallBack f4505e;

    public interface LoginCallBack {
        void failed(String str);

        void succeed(String str);
    }

    public interface LoginListener {
        void onLoginResult(int i, String str);
    }

    public LoginTask(Activity activity, BaseLoginParams params, LoginCallBack callBack) {
        super(activity, DownloadParams.m6504b(), LoginResp.class, "验证中，请稍候...");
        this.f4503c = params;
        this.f4505e = callBack;
    }

    /* access modifiers changed from: protected */
    @Override // com.wanmei.sdk.core.task.AbstractC1807a
    /* renamed from: a */
    public void mo9821a(VolleyError volleyError) {
        Toast.makeToastOneSDKError(this.f4509a, "登录发生异常，请稍后重试", -20);
        if (this.f4504d != null) {
            this.f4504d.onLoginResult(1, LibCoreCode.MSG_ERROR);
        } else {
            this.f4505e.failed(volleyError.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9823a(LoginResp loginResp) {
        if (loginResp.getCode() == 0) {
            SDKCoreFacade.getInstance().getAccount().setUserId(loginResp.getUid());
            SDKCoreFacade.getInstance().getAccount().setToken(loginResp.getToken());
            SDKCoreFacade.getInstance().getAccount().setPassword(loginResp.getPassord());
        }
        if (this.f4504d != null) {
            this.f4504d.onLoginResult(loginResp.getCode(), loginResp.getMsg());
        } else if (loginResp.getCode() == 0) {
            this.f4505e.succeed(loginResp.getMsg());
        } else {
            this.f4505e.failed(loginResp.getMsg());
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.wanmei.sdk.core.task.AbstractC1807a
    /* renamed from: a */
    public void mo9824a(String str) {
        if (this.f4504d != null) {
            this.f4504d.onLoginResult(1, str);
        } else {
            this.f4505e.failed(str);
        }
    }

    /* renamed from: e */
    public LoginReq mo9825d() {
        LoginReq loginReq = new LoginReq();
        loginReq.setPlatUid(this.f4503c.getChannelUid());
        loginReq.setPlatToken(this.f4503c.getChannelToken());
        loginReq.setExtraMap(this.f4503c.getExtraParams());
        loginReq.setLoginSchemeVersion(SDKCoreFacade.getInstance().getLoginSchemeVersion());
        return loginReq;
    }
}
