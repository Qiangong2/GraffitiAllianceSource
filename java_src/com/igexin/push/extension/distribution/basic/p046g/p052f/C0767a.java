package com.igexin.push.extension.distribution.basic.p046g.p052f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.StatFs;
import android.os.SystemClock;
import android.webkit.MimeTypeMap;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.extension.distribution.basic.p046g.C0752a;
import com.igexin.push.extension.distribution.basic.p046g.p047a.C0753a;
import java.io.File;
import java.util.Random;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.igexin.push.extension.distribution.basic.g.f.a */
public class C0767a {

    /* renamed from: a */
    public static Random f2127a = new Random(SystemClock.uptimeMillis());

    /* JADX WARNING: Removed duplicated region for block: B:16:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0077  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m3150a(com.igexin.push.extension.distribution.basic.p046g.p047a.C0753a r8, java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 194
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.p046g.p052f.C0767a.m3150a(com.igexin.push.extension.distribution.basic.g.a.a, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static String m3151a(String str) {
        return C0752a.f2082a + MqttTopic.TOPIC_LEVEL_SEPARATOR + str;
    }

    /* renamed from: a */
    private static String m3152a(String str, String str2, int i) {
        String str3 = null;
        if (str != null) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str2.substring(str2.lastIndexOf(46) + 1));
            if (mimeTypeFromExtension == null || !mimeTypeFromExtension.equalsIgnoreCase(str)) {
                str3 = m3153a(str, false);
            }
        }
        return str3 == null ? str2.substring(i) : str3;
    }

    /* renamed from: a */
    private static String m3153a(String str, boolean z) {
        String str2 = null;
        if (!(str == null || (str2 = MimeTypeMap.getSingleton().getExtensionFromMimeType(str)) == null)) {
            str2 = "." + str2;
        }
        return str2 == null ? (str == null || !str.toLowerCase().startsWith("text/")) ? z ? ".bin" : str2 : str.equalsIgnoreCase("text/html") ? ".html" : z ? ".txt" : str2 : str2;
    }

    /* renamed from: a */
    public static boolean m3154a(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1).isConnected();
    }

    /* renamed from: a */
    public static boolean m3155a(C0753a aVar) {
        try {
            File file = new File(C0752a.f2082a);
            if (!file.exists() && !file.mkdirs()) {
                return false;
            }
            StatFs statFs = new StatFs(file.getPath());
            long availableBlocks = (((long) statFs.getAvailableBlocks()) - 4) * ((long) statFs.getBlockSize());
            ActivityC0460a.m1698b("EXT-download-helper|remain space:" + availableBlocks);
            return availableBlocks > aVar.mo5071c();
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m3156b(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }
}
