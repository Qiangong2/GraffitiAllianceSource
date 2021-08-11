package com.umeng.analytics;

import android.content.Context;
import android.os.Build;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.game.UMGameAgent;
import java.util.Arrays;

public class UnityUtil {
    public static void initUnity(Context context, String appkey, String channel, String version) {
        AnalyticsConfig.mWrapperType = "Unity";
        AnalyticsConfig.mWrapperVersion = version;
        MobclickAgent.startWithConfigure(new MobclickAgent.UMAnalyticsConfig(context, appkey, channel, MobclickAgent.EScenarioType.E_UM_GAME));
        UMGameAgent.init(context);
    }

    public static void onEventForUnity(Context context, String keyPath, int value, String label) {
        MobclickAgent.onEvent(context, Arrays.asList(keyPath.split(";=umengUnity=;")), value, label);
    }

    public static boolean checkPermission(Context context, String permission) {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                if (((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, permission)).intValue() == 0) {
                    return true;
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        } else if (context.getPackageManager().checkPermission(permission, context.getPackageName()) == 0) {
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006e A[SYNTHETIC, Splitter:B:31:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0073 A[SYNTHETIC, Splitter:B:34:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008a A[SYNTHETIC, Splitter:B:44:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008f A[SYNTHETIC, Splitter:B:47:0x008f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getDeviceInfo(android.content.Context r10) {
        /*
        // Method dump skipped, instructions count: 174
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.UnityUtil.getDeviceInfo(android.content.Context):java.lang.String");
    }
}
