package com.cqq.test;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.KeyEvent;
import com.unity3d.player.UnityPlayerActivity;
import com.wanmei.sdk.core.open.SDKBase;
import com.wanmei.sdk.core.open.SDKInterface;
import plugins.AmapPlugin;
import plugins.ClipboardPlugin;
import plugins.CosSdkPlugin;
import plugins.GVoicePlugin;
import plugins.OneSdkPlugin;

public class MainActivity extends UnityPlayerActivity {
    AmapPlugin _ap = null;
    ClipboardPlugin _clip;
    CosSdkPlugin _cos;
    GVoicePlugin _gvp;
    OneSdkPlugin _osp;
    private boolean isOpenKeyCode = false;
    private Intent onHomeIntent;

    public AmapPlugin GetAmap() {
        if (this._ap == null) {
            this._ap = new AmapPlugin();
            this._ap.LocationInit(getApplicationContext(), this);
        }
        return this._ap;
    }

    public GVoicePlugin GetGvoice() {
        if (this._gvp == null) {
            this._gvp = new GVoicePlugin();
            this._gvp.VoiceInit(getApplicationContext(), this);
        }
        return this._gvp;
    }

    public OneSdkPlugin GetOneSdk() {
        if (this._osp == null) {
            this._osp = new OneSdkPlugin();
            this._osp.OneSdkInit(getApplicationContext(), this);
            this.isOpenKeyCode = true;
        }
        return this._osp;
    }

    public CosSdkPlugin GetCosSdk() {
        if (this._cos == null) {
            this._cos = new CosSdkPlugin();
            this._cos.Init(getApplicationContext(), this);
        }
        return this._cos;
    }

    public ClipboardPlugin GetClipboard() {
        if (this._clip == null) {
            this._clip = new ClipboardPlugin();
            this._clip.Init(getApplicationContext(), this);
        }
        return this._clip;
    }

    /* access modifiers changed from: protected */
    @Override // com.unity3d.player.UnityPlayerActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKBase.getInstance(this).onCreate(new SDKInterface.CompleteCallBack() {
            /* class com.cqq.test.MainActivity.C03771 */

            @Override // com.wanmei.sdk.core.open.SDKInterface.CompleteCallBack
            public void onComplete() {
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        SDKBase.getInstance(this).onStart(new SDKInterface.CompleteCallBack() {
            /* class com.cqq.test.MainActivity.C03852 */

            @Override // com.wanmei.sdk.core.open.SDKInterface.CompleteCallBack
            public void onComplete() {
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // com.unity3d.player.UnityPlayerActivity
    public void onPause() {
        super.onPause();
        SDKBase.getInstance(this).onPause(new SDKInterface.CompleteCallBack() {
            /* class com.cqq.test.MainActivity.C03863 */

            @Override // com.wanmei.sdk.core.open.SDKInterface.CompleteCallBack
            public void onComplete() {
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // com.unity3d.player.UnityPlayerActivity
    public void onResume() {
        super.onResume();
        SDKBase.getInstance(this).onResume(new SDKInterface.CompleteCallBack() {
            /* class com.cqq.test.MainActivity.C03874 */

            @Override // com.wanmei.sdk.core.open.SDKInterface.CompleteCallBack
            public void onComplete() {
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle outState) {
        SDKBase.getInstance(this).onSaveInstanceState(outState, new SDKInterface.CompleteCallBack() {
            /* class com.cqq.test.MainActivity.C03885 */

            @Override // com.wanmei.sdk.core.open.SDKInterface.CompleteCallBack
            public void onComplete() {
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        SDKBase.getInstance(this).onRestoreInstanceState(savedInstanceState, new SDKInterface.CompleteCallBack() {
            /* class com.cqq.test.MainActivity.C03896 */

            @Override // com.wanmei.sdk.core.open.SDKInterface.CompleteCallBack
            public void onComplete() {
            }
        });
    }

    @Override // com.unity3d.player.UnityPlayerActivity
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        SDKBase.getInstance(this).onConfigurationChanged(newConfig, new SDKInterface.CompleteCallBack() {
            /* class com.cqq.test.MainActivity.C03907 */

            @Override // com.wanmei.sdk.core.open.SDKInterface.CompleteCallBack
            public void onComplete() {
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        SDKBase.getInstance(this).onRestart(new SDKInterface.CompleteCallBack() {
            /* class com.cqq.test.MainActivity.C03918 */

            @Override // com.wanmei.sdk.core.open.SDKInterface.CompleteCallBack
            public void onComplete() {
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        SDKBase.getInstance(this).onStop(new SDKInterface.CompleteCallBack() {
            /* class com.cqq.test.MainActivity.C03929 */

            @Override // com.wanmei.sdk.core.open.SDKInterface.CompleteCallBack
            public void onComplete() {
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // com.unity3d.player.UnityPlayerActivity
    public void onDestroy() {
        super.onDestroy();
        SDKBase.getInstance(this).onDestroy(new SDKInterface.CompleteCallBack() {
            /* class com.cqq.test.MainActivity.C037810 */

            @Override // com.wanmei.sdk.core.open.SDKInterface.CompleteCallBack
            public void onComplete() {
                System.exit(0);
            }
        });
    }

    @Override // com.unity3d.player.UnityPlayerActivity
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 4 || !this.isOpenKeyCode) {
            return false;
        }
        return SDKBase.getInstance(this).onKeyDown(keyCode, event, new SDKInterface.ExitCallBack() {
            /* class com.cqq.test.MainActivity.C037911 */

            @Override // com.wanmei.sdk.core.open.SDKInterface.ExitCallBack
            public void onGameHasExitView() {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setMessage("是否退出游戏");
                alertDialog.setButton(-1, "退出", new DialogInterface.OnClickListener() {
                    /* class com.cqq.test.MainActivity.C037911.DialogInterface$OnClickListenerC03801 */

                    public void onClick(DialogInterface dialog, int which) {
                        SDKBase.getInstance(MainActivity.this).onRelease(new SDKInterface.CompleteCallBack() {
                            /* class com.cqq.test.MainActivity.C037911.DialogInterface$OnClickListenerC03801.C03811 */

                            @Override // com.wanmei.sdk.core.open.SDKInterface.CompleteCallBack
                            public void onComplete() {
                                System.exit(0);
                                Process.killProcess(Process.myPid());
                            }
                        });
                    }
                });
                alertDialog.setButton(-2, "取消", new DialogInterface.OnClickListener() {
                    /* class com.cqq.test.MainActivity.C037911.DialogInterface$OnClickListenerC03822 */

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertDialog.show();
            }

            @Override // com.wanmei.sdk.core.open.SDKInterface.ExitCallBack
            public void onChannelHasExitView() {
                MainActivity.this.finish();
                Process.killProcess(Process.myPid());
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        SDKBase.getInstance(this).onActivityResult(requestCode, resultCode, data, new SDKInterface.CompleteCallBack() {
            /* class com.cqq.test.MainActivity.C038312 */

            @Override // com.wanmei.sdk.core.open.SDKInterface.CompleteCallBack
            public void onComplete() {
            }
        });
        if (resultCode == -1) {
            switch (requestCode) {
                case CosSdkPlugin.CODE_SELECT_HEADICON /*{ENCODED_INT: 4010}*/:
                    this._cos.selectImageResult(data.getData(), requestCode);
                    return;
                case CosSdkPlugin.CODE_SELECT_PHOTO /*{ENCODED_INT: 4011}*/:
                    this._cos.selectImageResult(data.getData(), requestCode);
                    return;
                case CosSdkPlugin.CODE_CROP_HEADICON /*{ENCODED_INT: 4012}*/:
                    this._cos.cropImageResult(data.getExtras(), requestCode);
                    return;
                case CosSdkPlugin.CODE_CROP_PHOTO /*{ENCODED_INT: 4013}*/:
                    this._cos.cropImageResult(data.getExtras(), requestCode);
                    return;
                default:
                    Log.w("cqq_log", "result:" + resultCode + " request: " + requestCode);
                    return;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.unity3d.player.UnityPlayerActivity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        SDKBase.getInstance(this).onNewIntent(intent, new SDKInterface.CompleteCallBack() {
            /* class com.cqq.test.MainActivity.C038413 */

            @Override // com.wanmei.sdk.core.open.SDKInterface.CompleteCallBack
            public void onComplete() {
            }
        });
        this.onHomeIntent = intent;
    }
}
