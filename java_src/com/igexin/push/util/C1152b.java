package com.igexin.push.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.sdk.PushBuildConfig;
import com.umeng.analytics.C1370a;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.igexin.push.util.b */
public class C1152b {
    /* renamed from: a */
    public static void m4754a(AbstractC1154d dVar, Context context) {
        new Thread(new RunnableC1153c(context, dVar)).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static boolean m4757c(Context context) {
        try {
            byte[] a = C1155e.m4764a(context.getFilesDir().getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + "init_er.pid");
            return a == null || System.currentTimeMillis() - Long.valueOf(new String(a)).longValue() > C1370a.f3217i;
        } catch (Exception e) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static String m4758d(Context context) {
        String packageName = context.getPackageName();
        String str = null;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(packageName, 128);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                str = applicationInfo.metaData.getString(AssistPushConsts.GETUI_APPID);
            }
        } catch (Exception e) {
        }
        String str2 = Build.MODEL;
        String str3 = Build.VERSION.SDK;
        String str4 = Build.VERSION.RELEASE;
        File file = new File(context.getApplicationInfo().nativeLibraryDir + File.separator + "libgetuiext2.so");
        StringBuilder sb = new StringBuilder();
        sb.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date()));
        sb.append("|");
        sb.append(str);
        sb.append("|");
        sb.append(PushBuildConfig.sdk_conf_version);
        sb.append("|");
        sb.append(file.exists());
        sb.append("|");
        sb.append(C1163m.m4786a(context));
        sb.append("|");
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        sb.append("|");
        sb.append(str4);
        sb.append("|");
        sb.append(C1163m.m4787b(context));
        sb.append("|");
        sb.append(C1163m.m4785a());
        sb.append("|");
        sb.append(packageName);
        if (EncryptUtils.errorMsg != null) {
            sb.append("|");
            sb.append(EncryptUtils.errorMsg);
        }
        ActivityC0460a.m1698b("ErrorReport|" + sb.toString());
        return sb.toString();
    }
}
