package com.wanmei.sdk.core.util;

import android.util.Log;
import com.wanmei.sdk.core.log.manager.LogManager;

public class LogUtil {
    private static boolean LOG = false;

    /* renamed from: d */
    public static void m6672d(String tag, String msg) {
        log(tag, msg);
        if (LOG) {
            Log.d(tag, msg);
        }
    }

    /* renamed from: e */
    public static void m6673e(String tag, String msg) {
        log(tag, msg);
        if (LOG) {
            Log.e(tag, msg);
        }
    }

    /* renamed from: e */
    public static void m6674e(String tag, String msg, Throwable tr) {
        log(tag, msg);
        if (LOG) {
            Log.e(tag, msg, tr);
        }
    }

    public static boolean isLOG() {
        return LOG;
    }

    public static void log(String tag, String msg) {
        if (LogManager.getDebug()) {
            try {
                LogManager.INSTANCE.getLogger().mo9551a(tag, msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void logcat(String tag, String msg) {
        if (LOG) {
            Log.d(tag, msg);
        }
    }

    public static void setLOG(boolean lOG) {
        LOG = lOG;
    }

    /* renamed from: v */
    public static void m6675v(String tag, String msg) {
        log(tag, msg);
        if (LOG) {
            Log.v(tag, msg);
        }
    }

    /* renamed from: w */
    public static void m6676w(String tag, String msg) {
        log(tag, msg);
        if (LOG) {
            Log.w(tag, msg);
        }
    }
}
