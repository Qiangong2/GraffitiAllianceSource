package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.push.log.C1925e;
import com.xiaomi.push.log.C1926f;

public class Logger {
    private static boolean sDisablePushLog = false;
    private static LoggerInterface sUserLogger = null;

    public static void disablePushFileLog(Context context) {
        sDisablePushLog = true;
        setPushLog(context);
    }

    public static void enablePushFileLog(Context context) {
        sDisablePushLog = false;
        setPushLog(context);
    }

    private static boolean hasWritePermission(Context context) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr == null) {
                return false;
            }
            for (String str : strArr) {
                if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static void setLogger(Context context, LoggerInterface loggerInterface) {
        sUserLogger = loggerInterface;
        setPushLog(context);
    }

    private static void setPushLog(Context context) {
        boolean z = sUserLogger != null;
        C1926f fVar = new C1926f(context);
        if (!sDisablePushLog && hasWritePermission(context) && z) {
            AbstractC1855b.m6716a(new C1925e(sUserLogger, fVar));
        } else if (!sDisablePushLog && hasWritePermission(context)) {
            AbstractC1855b.m6716a(fVar);
        } else if (z) {
            AbstractC1855b.m6716a(sUserLogger);
        } else {
            AbstractC1855b.m6716a(new C1925e(null, null));
        }
    }
}
