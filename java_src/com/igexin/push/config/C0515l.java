package com.igexin.push.config;

import android.content.Context;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.util.C1155e;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.igexin.push.config.l */
public class C0515l {

    /* renamed from: a */
    private static String f1335a = "FileConfig";

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003e A[SYNTHETIC, Splitter:B:13:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0047 A[SYNTHETIC, Splitter:B:18:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004b A[SYNTHETIC, Splitter:B:21:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009c A[SYNTHETIC, Splitter:B:38:0x009c] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a1 A[SYNTHETIC, Splitter:B:41:0x00a1] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ba A[SYNTHETIC, Splitter:B:54:0x00ba] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00bf A[SYNTHETIC, Splitter:B:57:0x00bf] */
    /* JADX WARNING: Removed duplicated region for block: B:81:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m1964a() {
        /*
        // Method dump skipped, instructions count: 229
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.config.C0515l.m1964a():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043 A[SYNTHETIC, Splitter:B:14:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048 A[SYNTHETIC, Splitter:B:17:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005d A[SYNTHETIC, Splitter:B:29:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0062 A[SYNTHETIC, Splitter:B:32:0x0062] */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m1965a(android.content.Context r6) {
        /*
        // Method dump skipped, instructions count: 126
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.config.C0515l.m1965a(android.content.Context):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:138:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a A[SYNTHETIC, Splitter:B:15:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0065 A[SYNTHETIC, Splitter:B:23:0x0065] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m1966a(java.io.InputStream r7) {
        /*
        // Method dump skipped, instructions count: 585
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.config.C0515l.m1966a(java.io.InputStream):void");
    }

    /* renamed from: b */
    public static void m1967b(Context context) {
        try {
            byte[] a = C1155e.m4764a(context.getFilesDir().getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + "conf_n.pid");
            if (a != null) {
                C0514k.f1329u = Boolean.valueOf(new String(a)).booleanValue();
            }
        } catch (Throwable th) {
            ActivityC0460a.m1698b(f1335a + "|load need confgi error = " + th.toString());
        }
    }
}
