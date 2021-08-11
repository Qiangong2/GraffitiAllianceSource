package com.pwrd.onesdk.demo.yixin.yxapi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;
import com.tencent.qcloud.core.util.IOUtils;
import im.yixin.gamesdk.api.BaseYXGameEntryActivity;
import im.yixin.gamesdk.api.YXGameRequestListener;
import im.yixin.sdk.api.BaseReq;
import im.yixin.sdk.api.BaseResp;
import im.yixin.sdk.api.SendAuthToYX;
import im.yixin.sdk.api.SendMessageToYX;
import im.yixin.sdk.api.ShowYXMessageFromYX;
import org.pwrd.paho.client.mqttv3.internal.ClientDefaults;

public class YXEntryActivity extends BaseYXGameEntryActivity {
    private static final String TAG = YXEntryActivity.class.getName();

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.pwrd.onesdk.demo.yixin.yxapi.YXEntryActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void onResp(BaseResp resp) {
        Log.i(TAG, "onResp called: errCode=" + resp.errCode + ",errStr=" + resp.errStr + ",transaction=" + resp.transaction);
        switch (resp.getType()) {
            case 1:
                switch (((SendMessageToYX.Resp) resp).errCode) {
                    case -3:
                        Toast.makeText((Context) this, (CharSequence) "发送失败", 1).show();
                        return;
                    case -2:
                        Toast.makeText((Context) this, (CharSequence) "用户取消", 1).show();
                        return;
                    case -1:
                        Toast.makeText((Context) this, (CharSequence) "分享失败", 1).show();
                        return;
                    case 0:
                        Toast.makeText((Context) this, (CharSequence) "分享成功", 1).show();
                        return;
                    default:
                        return;
                }
            case 2:
                SendAuthToYX.Resp resp2 = (SendAuthToYX.Resp) resp;
                switch (resp2.errCode) {
                    case -4:
                        showMsg("用户拒绝", new String[0]);
                        finish();
                        return;
                    case -3:
                    default:
                        return;
                    case -2:
                        showMsg("用户取消", new String[0]);
                        finish();
                        return;
                    case -1:
                        showMsg("失败", new String[0]);
                        finish();
                        return;
                    case 0:
                        Log.i(TAG, "YXEntryActivity YixinConstants.RESP_SEND_AUTH_TYPE ERR_OK");
                        showMsg("获取Code成功，code=" + resp2.code, new String[0]);
                        getToken(resp2.code);
                        return;
                }
            default:
                return;
        }
    }

    public void onReq(BaseReq req) {
        Log.i("YXEntryActivity", "onReq called: transaction=" + req.transaction);
        switch (req.getType()) {
            case 1:
                SendMessageToYX.Req req1 = (SendMessageToYX.Req) req;
                showMsg("回调-SendMessageToYX.Req", "title=" + req1.message.title, "desc=" + req1.message.description, "transcion=" + req1.transaction);
                return;
            case 2:
            default:
                return;
            case 3:
                ShowYXMessageFromYX.Req req2 = (ShowYXMessageFromYX.Req) req;
                showMsg("回调-ShowYXMessageFromYX.Req", "extend=" + req2.extInfo, "transcion=" + req2.transaction);
                new Handler().post(new Runnable() {
                    /* class com.pwrd.onesdk.demo.yixin.yxapi.YXEntryActivity.RunnableC13071 */

                    public void run() {
                        Intent intent = YXEntryActivity.this.getApplicationContext().getPackageManager().getLaunchIntentForPackage(YXEntryActivity.this.getPackageName());
                        intent.addFlags(67108864);
                        intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
                        YXEntryActivity.this.startActivity(intent);
                        YXEntryActivity.this.finish();
                    }
                });
                return;
        }
    }

    public void showMsg(String apiName, String... m1) {
        StringBuffer sb = new StringBuffer("------api:" + apiName + "-----");
        for (String m : m1) {
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            sb.append(m);
        }
        Log.i("YXEntryActivity", sb.toString());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.pwrd.onesdk.demo.yixin.yxapi.YXEntryActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void getToken(String code) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("登录中...");
        getIYXGameApi().fetchToken(this, code, new YXGameRequestListener<Void>() {
            /* class com.pwrd.onesdk.demo.yixin.yxapi.YXEntryActivity.C13082 */

            public void onPreRequest() {
                progressDialog.show();
            }

            public void callback(int status, Void aVoid) {
                progressDialog.dismiss();
                if (status == 0) {
                    YXEntryActivity.this.showMsg(YXEntryActivity.TAG, "登录成功");
                } else {
                    YXEntryActivity.this.showMsg(YXEntryActivity.TAG, "登录失败");
                }
                YXEntryActivity.this.finish();
            }
        });
    }
}
