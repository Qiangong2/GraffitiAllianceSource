package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.social.AbstractC1571d;
import com.umeng.analytics.social.UMPlatformData;
import com.umeng.analytics.social.UMSocialService;
import com.umeng.p085a.C1346h;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;

public class MobclickAgent {

    /* renamed from: a */
    private static final String f3201a = "input map is null";

    /* renamed from: b */
    private static final C1420b f3202b = new C1420b();

    public static void startWithConfigure(UMAnalyticsConfig uMAnalyticsConfig) {
        if (uMAnalyticsConfig != null) {
            f3202b.mo8511a(uMAnalyticsConfig);
        }
    }

    public static void setLocation(double d, double d2) {
        f3202b.mo8496a(d, d2);
    }

    public static void setLatencyWindow(long j) {
        f3202b.mo8497a(j);
    }

    public static void enableEncrypt(boolean z) {
        f3202b.mo8530e(z);
    }

    public static void setCatchUncaughtExceptions(boolean z) {
        f3202b.mo8516a(z);
    }

    public static void setSecret(Context context, String str) {
        f3202b.mo8520b(context, str);
    }

    public static void setScenarioType(Context context, EScenarioType eScenarioType) {
        f3202b.mo8500a(context, eScenarioType);
    }

    public static void setSessionContinueMillis(long j) {
        f3202b.mo8518b(j);
    }

    public static C1420b getAgent() {
        return f3202b;
    }

    public static void setCheckDevice(boolean z) {
        f3202b.mo8525c(z);
    }

    public static void setOpenGLContext(GL10 gl10) {
        f3202b.mo8515a(gl10);
    }

    public static void openActivityDurationTrack(boolean z) {
        f3202b.mo8522b(z);
    }

    public static void onPageStart(String str) {
        if (!TextUtils.isEmpty(str)) {
            f3202b.mo8512a(str);
        } else {
            C1346h.m5009e("pageName is null or empty");
        }
    }

    public static void onPageEnd(String str) {
        if (!TextUtils.isEmpty(str)) {
            f3202b.mo8521b(str);
        } else {
            C1346h.m5009e("pageName is null or empty");
        }
    }

    public static void setDebugMode(boolean z) {
        f3202b.mo8528d(z);
    }

    public static void onPause(Context context) {
        f3202b.mo8519b(context);
    }

    public static void onResume(Context context) {
        if (context == null) {
            C1346h.m5009e("unexpected null context in onResume");
        } else {
            f3202b.mo8498a(context);
        }
    }

    public static void reportError(Context context, String str) {
        f3202b.mo8501a(context, str);
    }

    public static void reportError(Context context, Throwable th) {
        f3202b.mo8507a(context, th);
    }

    public static void onEvent(Context context, List<String> list, int i, String str) {
        f3202b.mo8509a(context, list, i, str);
    }

    public static void onEvent(Context context, String str) {
        f3202b.mo8503a(context, str, null, -1, 1);
    }

    public static void onEvent(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            C1346h.m4997c("label is null or empty");
        } else {
            f3202b.mo8503a(context, str, str2, -1, 1);
        }
    }

    public static void onEvent(Context context, String str, Map<String, String> map) {
        if (map == null) {
            C1346h.m5009e(f3201a);
        } else {
            f3202b.mo8506a(context, str, new HashMap(map), -1);
        }
    }

    public static void onEventValue(Context context, String str, Map<String, String> map, int i) {
        HashMap hashMap;
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = new HashMap(map);
        }
        hashMap.put("__ct__", Integer.valueOf(i));
        f3202b.mo8506a(context, str, hashMap, -1);
    }

    public static void onSocialEvent(Context context, String str, UMPlatformData... uMPlatformDataArr) {
        if (context == null) {
            C1346h.m5009e("context is null in onShareEvent");
            return;
        }
        AbstractC1571d.f3986d = "3";
        UMSocialService.share(context, str, uMPlatformDataArr);
    }

    public static void onSocialEvent(Context context, UMPlatformData... uMPlatformDataArr) {
        if (context == null) {
            C1346h.m5009e("context is null in onShareEvent");
            return;
        }
        AbstractC1571d.f3986d = "3";
        UMSocialService.share(context, uMPlatformDataArr);
    }

    public static void onKillProcess(Context context) {
        f3202b.mo8527d(context);
    }

    public static void onProfileSignIn(String str) {
        onProfileSignIn("_adhoc", str);
    }

    public static void onProfileSignIn(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            C1346h.m5003d("uid is null");
        } else if (str2.length() > 64) {
            C1346h.m5003d("uid is Illegal(length bigger then  legitimate length).");
        } else if (TextUtils.isEmpty(str)) {
            f3202b.mo8513a("_adhoc", str2);
        } else if (str.length() > 32) {
            C1346h.m5003d("provider is Illegal(length bigger then  legitimate length).");
        } else {
            f3202b.mo8513a(str, str2);
        }
    }

    public static void onProfileSignOff() {
        f3202b.mo8517b();
    }

    public enum EScenarioType {
        E_UM_NORMAL(0),
        E_UM_GAME(1),
        E_UM_ANALYTICS_OEM(224),
        E_UM_GAME_OEM(225);
        

        /* renamed from: a */
        private int f3204a;

        private EScenarioType(int i) {
            this.f3204a = i;
        }

        public int toValue() {
            return this.f3204a;
        }
    }

    public static class UMAnalyticsConfig {
        public String mAppkey;
        public String mChannelId;
        public Context mContext;
        public boolean mIsCrashEnable;
        public EScenarioType mType;

        private UMAnalyticsConfig() {
            this.mAppkey = null;
            this.mChannelId = null;
            this.mIsCrashEnable = true;
            this.mType = EScenarioType.E_UM_NORMAL;
            this.mContext = null;
        }

        public UMAnalyticsConfig(Context context, String str, String str2) {
            this(context, str, str2, null, true);
        }

        public UMAnalyticsConfig(Context context, String str, String str2, EScenarioType eScenarioType) {
            this(context, str, str2, eScenarioType, true);
        }

        public UMAnalyticsConfig(Context context, String str, String str2, EScenarioType eScenarioType, boolean z) {
            this.mAppkey = null;
            this.mChannelId = null;
            this.mIsCrashEnable = true;
            this.mType = EScenarioType.E_UM_NORMAL;
            this.mContext = null;
            this.mContext = context;
            this.mAppkey = str;
            this.mChannelId = str2;
            this.mIsCrashEnable = z;
            if (eScenarioType != null) {
                this.mType = eScenarioType;
                return;
            }
            switch (AnalyticsConfig.getVerticalType(context)) {
                case 0:
                    this.mType = EScenarioType.E_UM_NORMAL;
                    return;
                case 1:
                    this.mType = EScenarioType.E_UM_GAME;
                    return;
                case 224:
                    this.mType = EScenarioType.E_UM_ANALYTICS_OEM;
                    return;
                case 225:
                    this.mType = EScenarioType.E_UM_GAME_OEM;
                    return;
                default:
                    return;
            }
        }
    }
}
