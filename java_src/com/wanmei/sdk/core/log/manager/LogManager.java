package com.wanmei.sdk.core.log.manager;

import android.content.Context;
import com.wanmei.sdk.core.Proguard;
import com.wanmei.sdk.core.task.AsyncTaskC1811b;
import com.wanmei.sdk.core.task.AsyncTaskC1813c;
import com.wanmei.sdk.core.util.LogUtil;

public enum LogManager implements Proguard {
    INSTANCE;
    
    private static Context mContext;
    private static AbstractC1762a sManager;

    public static boolean getDebug() {
        if (mContext == null) {
            return false;
        }
        C1765c.m6499a();
        return C1765c.m6501a(mContext);
    }

    private void getDebugFromServer() {
        new AsyncTaskC1813c(mContext).execute(new Void[0]);
    }

    private static synchronized AbstractC1762a initManager(Context context) {
        AbstractC1762a aVar;
        synchronized (LogManager.class) {
            if (context == null) {
                aVar = null;
            } else {
                mContext = context;
                if (sManager == null) {
                    sManager = new C1763b(context);
                }
                aVar = sManager;
            }
        }
        return aVar;
    }

    private void updateTheLastNormalLog() {
        new AsyncTaskC1811b(mContext, false).execute(new Void[0]);
    }

    public AbstractC1762a getLogger() {
        return sManager;
    }

    public void init(Context context) {
        if (context != null) {
            mContext = context;
            sManager = initManager(context);
            getDebugFromServer();
            if (getDebug()) {
                LogUtil.setLOG(true);
                updateTheLastNormalLog();
            }
        }
    }

    public void upLoadLog() {
        new AsyncTaskC1811b(mContext, true).execute(new Void[0]);
    }
}
