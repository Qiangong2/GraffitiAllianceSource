package com.wanmei.sdk.core.open;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.wanmei.sdk.core.task.C1814d;

public class SDKMutidexApplication extends Application {
    private static final String TAG = SDKMutidexApplication.class.getName();
    protected static volatile boolean mHasLoadMutiDex = false;
    protected static volatile boolean mUseMutiDex = false;

    public static boolean hasLoadMutiDex() {
        return mHasLoadMutiDex;
    }

    public static boolean useMutiDex() {
        return mUseMutiDex;
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Log.d(TAG, "attachBaseContext");
        mUseMutiDex = true;
        new C1814d(this, new C1814d.AbstractC1815a() {
            /* class com.wanmei.sdk.core.open.SDKMutidexApplication.C18061 */

            @Override // com.wanmei.sdk.core.task.C1814d.AbstractC1815a
            public void onFail() {
                Log.d(SDKMutidexApplication.TAG, "LoadMultiDexTask onFail");
                SDKMutidexApplication.mHasLoadMutiDex = false;
                throw new RuntimeException("loadMultiDex fail");
            }

            @Override // com.wanmei.sdk.core.task.C1814d.AbstractC1815a
            public void onSuccess() {
                Log.d(SDKMutidexApplication.TAG, "LoadMultiDexTask onSuccess");
                synchronized (SDKMutidexApplication.class) {
                    SDKMutidexApplication.mHasLoadMutiDex = true;
                    SDKMutidexApplication.class.notifyAll();
                }
            }
        }).mo9845a();
    }
}
