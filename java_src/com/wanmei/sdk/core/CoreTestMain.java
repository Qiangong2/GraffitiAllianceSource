package com.wanmei.sdk.core;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.wanmei.sdk.core.log.manager.LogManager;
import com.wanmei.sdk.core.open.Channel;
import com.wanmei.sdk.core.open.SDKBase;
import com.wanmei.sdk.core.open.SDKCoreFacade;
import com.wanmei.sdk.core.open.SDKInterface;
import com.wanmei.sdk.core.util.LogUtil;

public class CoreTestMain extends Activity {

    /* renamed from: a */
    private final Context f4426a = this;

    /* renamed from: b */
    private Activity f4427b = this;

    /* renamed from: c */
    private Button f4428c;

    /* renamed from: d */
    private Button f4429d;

    /* renamed from: e */
    private EditText f4430e;

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private void m6473a() {
        SDKBase.getInstance(this).init(1001, "d44aad69bb50d9bb321fa1298c1cdeed", new SDKInterface.InitCallBack() {
            /* class com.wanmei.sdk.core.CoreTestMain.C17579 */

            @Override // com.wanmei.sdk.core.open.SDKInterface.InitCallBack
            public void initFailed(String reason) {
                Log.d("CoreTestMain", "initFailed");
                Toast.makeText(CoreTestMain.this.f4427b, "initFailed, reason:" + reason, 1).show();
            }

            @Override // com.wanmei.sdk.core.open.SDKInterface.InitCallBack
            public void initSucceed(String extraJson) {
                Log.d("CoreTestMain", "initSucceed");
                Toast.makeText(CoreTestMain.this.f4427b, "initSucceed, extraJson:" + extraJson, 1).show();
            }
        });
        SDKBase.getInstance(this).setLogoutCallBack(new SDKInterface.LogoutCallBack() {
            /* class com.wanmei.sdk.core.CoreTestMain.C174910 */

            @Override // com.wanmei.sdk.core.open.SDKInterface.LogoutCallBack
            public void failed(String msg) {
                Toast.makeText(CoreTestMain.this.getApplicationContext(), "logout failed,msg: " + msg, 0).show();
            }

            @Override // com.wanmei.sdk.core.open.SDKInterface.LogoutCallBack
            public void succeed() {
                Toast.makeText(CoreTestMain.this.getApplicationContext(), "logout succeed", 0).show();
            }
        });
    }

    /* renamed from: b */
    static /* synthetic */ void m6475b(CoreTestMain coreTestMain) {
        SDKBase.getInstance(coreTestMain.f4427b).doLogin(new SDKInterface.LoginCallBack() {
            /* class com.wanmei.sdk.core.CoreTestMain.C17502 */

            @Override // com.wanmei.sdk.core.open.SDKInterface.LoginCallBack
            public void cancelled() {
                Toast.makeText(CoreTestMain.this.f4427b, "login cancelled", 1).show();
            }

            @Override // com.wanmei.sdk.core.open.SDKInterface.LoginCallBack
            public void failed(String msg) {
                Toast.makeText(CoreTestMain.this.f4427b, "login failed, msg:" + msg, 1).show();
            }

            @Override // com.wanmei.sdk.core.open.SDKInterface.LoginCallBack
            public void succeed(String userId, String token, String password, String msg) {
                Toast.makeText(CoreTestMain.this.f4427b, "userId: " + userId + "\ntoken: " + token + "\npassword: " + password + "\nmsg: " + msg, 1).show();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SDKCoreFacade.getInstance().setDebug(true);
        ((Button) findViewById(R.id.initBtn)).setOnClickListener(new View.OnClickListener() {
            /* class com.wanmei.sdk.core.CoreTestMain.View$OnClickListenerC17481 */

            public void onClick(View v) {
                CoreTestMain.this.m6473a();
            }
        });
        ((Button) findViewById(R.id.loginBtn)).setOnClickListener(new View.OnClickListener() {
            /* class com.wanmei.sdk.core.CoreTestMain.View$OnClickListenerC17513 */

            public void onClick(View v) {
                CoreTestMain.m6475b(CoreTestMain.this);
            }
        });
        ((Button) findViewById(R.id.customServiceBtn)).setOnClickListener(new View.OnClickListener() {
            /* class com.wanmei.sdk.core.CoreTestMain.View$OnClickListenerC17524 */

            public void onClick(View v) {
            }
        });
        final long currentTimeMillis = System.currentTimeMillis();
        SDKBase.getInstance(this).getChannelConfig(104, new SDKInterface.ReadChannelCallBack() {
            /* class com.wanmei.sdk.core.CoreTestMain.C17535 */

            @Override // com.wanmei.sdk.core.open.SDKInterface.ReadChannelCallBack
            public void failed(String msg) {
                Log.d("LXD", "failed :" + msg);
                Toast.makeText(CoreTestMain.this.f4427b, "failed :" + msg, 0).show();
            }

            @Override // com.wanmei.sdk.core.open.SDKInterface.ReadChannelCallBack
            public void succeed(Channel channel) {
                Log.d("LXD", "Coast time is :" + (System.currentTimeMillis() - currentTimeMillis));
                Log.d("LXD", "channel :" + channel);
                Toast.makeText(CoreTestMain.this.f4427b, "channel :" + channel, 0).show();
            }
        });
        this.f4428c = (Button) findViewById(R.id.add_log_btn);
        this.f4429d = (Button) findViewById(R.id.crash_btn);
        this.f4430e = (EditText) findViewById(R.id.edit_text);
        this.f4428c.setOnClickListener(new View.OnClickListener() {
            /* class com.wanmei.sdk.core.CoreTestMain.View$OnClickListenerC17546 */

            public void onClick(View v) {
                String obj = CoreTestMain.this.f4430e.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    LogUtil.m6672d("CoreTestMain", obj);
                }
            }
        });
        this.f4429d.setOnClickListener(new View.OnClickListener() {
            /* class com.wanmei.sdk.core.CoreTestMain.View$OnClickListenerC17557 */

            public void onClick(View v) {
                String str = null;
                str.charAt(1);
            }
        });
        ((Button) findViewById(R.id.upload_btn)).setOnClickListener(new View.OnClickListener() {
            /* class com.wanmei.sdk.core.CoreTestMain.View$OnClickListenerC17568 */

            public void onClick(View v) {
                LogManager.INSTANCE.upLoadLog();
            }
        });
        m6473a();
    }
}
