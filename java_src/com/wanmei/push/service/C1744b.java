package com.wanmei.push.service;

import android.content.Context;
import com.wanmei.push.C1645b;
import com.wanmei.push.bean.AppInfo;
import com.wanmei.push.p104g.C1711c;
import com.wanmei.push.p104g.C1714f;
import com.wanmei.push.p104g.C1715g;
import java.util.List;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.wanmei.push.service.b */
public final class C1744b {
    /* renamed from: a */
    public static String m6460a(Context context) {
        return "unicast/1/" + C1711c.m6371a(context);
    }

    /* renamed from: a */
    public static String m6461a(String str, String str2) {
        return "broadcast/" + str + MqttTopic.TOPIC_LEVEL_SEPARATOR + C1715g.m6384a(str2);
    }

    /* renamed from: a */
    public static String[] m6462a(List<AppInfo> list) {
        String[] strArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strArr[i] = m6461a(list.get(i).getAppClientId(), list.get(i).getPackageName());
        }
        return strArr;
    }

    /* renamed from: b */
    public static String m6463b(Context context) {
        if (C1645b.m6176a().mo9198c(context)) {
            return C1645b.m6176a().mo9193b(context).getAppClientId();
        }
        C1714f.m6382b("PERFECT_PUSH", "getmAppId Error : AppInfo is not available");
        return "";
    }
}
