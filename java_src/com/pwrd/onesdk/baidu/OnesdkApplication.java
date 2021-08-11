package com.pwrd.onesdk.baidu;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.util.Log;
import java.lang.reflect.Method;

public class OnesdkApplication extends Application {
    /* access modifiers changed from: protected */
    public void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Log.d("Onesdk", "MultiDex.install");
        MultiDex.install(this);
        try {
            Class<?> threadClass = Class.forName("com.baidu.gamesdk.BDGameSDK");
            Log.d("Onesdk", "threadClass:" + threadClass.getSimpleName());
            Method method = threadClass.getMethod("initApplication", Application.class);
            Log.d("Onesdk", "method:" + method.getName());
            method.invoke(null, this);
            Log.d("Onesdk", "method invoke");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
