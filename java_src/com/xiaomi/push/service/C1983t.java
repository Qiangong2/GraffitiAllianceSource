package com.xiaomi.push.service;

import android.content.SharedPreferences;
import com.xiaomi.channel.commonutils.string.C1873d;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/* renamed from: com.xiaomi.push.service.t */
public class C1983t {

    /* renamed from: a */
    private static Object f5114a = new Object();

    /* renamed from: b */
    private static Map<String, Queue<String>> f5115b = new HashMap();

    /* renamed from: a */
    public static boolean m7396a(XMPushService xMPushService, String str, String str2) {
        synchronized (f5114a) {
            SharedPreferences sharedPreferences = xMPushService.getSharedPreferences("push_message_ids", 0);
            Queue<String> queue = f5115b.get(str);
            if (queue == null) {
                String[] split = sharedPreferences.getString(str, "").split(MiPushClient.ACCEPT_TIME_SEPARATOR);
                queue = new LinkedList<>();
                for (String str3 : split) {
                    queue.add(str3);
                }
                f5115b.put(str, queue);
            }
            if (queue.contains(str2)) {
                return true;
            }
            queue.add(str2);
            if (queue.size() > 10) {
                queue.poll();
            }
            String a = C1873d.m6783a(queue, MiPushClient.ACCEPT_TIME_SEPARATOR);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str, a);
            edit.commit();
            return false;
        }
    }
}
