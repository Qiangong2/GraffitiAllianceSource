package com.wanmei.sdk.core.open;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import com.wanmei.sdk.core.open.SDKInterface;

public class SDKFoundation {
    public void onActivityResult(int requestCode, int resultCode, Intent data, SDKInterface.CompleteCallBack completeCallBack) {
        completeCallBack.onComplete();
    }

    public void onConfigurationChanged(Configuration newConfig, SDKInterface.CompleteCallBack completeCallBack) {
        completeCallBack.onComplete();
    }

    public void onCreate(SDKInterface.CompleteCallBack completeCallBack) {
        completeCallBack.onComplete();
    }

    public void onDestroy(SDKInterface.CompleteCallBack completeCallBack) {
        completeCallBack.onComplete();
    }

    public boolean onKeyDown(int actionCode, KeyEvent action, SDKInterface.ExitCallBack exitCallBack) {
        exitCallBack.onGameHasExitView();
        return false;
    }

    public void onNewIntent(Intent intent, SDKInterface.CompleteCallBack completeCallBack) {
        completeCallBack.onComplete();
    }

    public void onPause(SDKInterface.CompleteCallBack completeCallBack) {
        completeCallBack.onComplete();
    }

    public void onRelease(SDKInterface.CompleteCallBack completeCallBack) {
        completeCallBack.onComplete();
    }

    public void onRestart(SDKInterface.CompleteCallBack completeCallBack) {
        completeCallBack.onComplete();
    }

    public void onRestoreInstanceState(Bundle savedInstanceState, SDKInterface.CompleteCallBack completeCallBack) {
        completeCallBack.onComplete();
    }

    public void onResume(SDKInterface.CompleteCallBack completeCallBack) {
        completeCallBack.onComplete();
    }

    public void onSaveInstanceState(Bundle outState, SDKInterface.CompleteCallBack completeCallBack) {
        completeCallBack.onComplete();
    }

    public void onStart(SDKInterface.CompleteCallBack completeCallBack) {
        completeCallBack.onComplete();
    }

    public void onStop(SDKInterface.CompleteCallBack completeCallBack) {
        completeCallBack.onComplete();
    }
}
