package com.umeng.analytics.p093d;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.p091b.C1443f;
import com.umeng.analytics.p091b.C1447g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.d.r */
/* compiled from: ViewPageTracker */
public class C1495r {

    /* renamed from: b */
    private static JSONObject f3713b = new JSONObject();

    /* renamed from: a */
    private final Map<String, Long> f3714a = new HashMap();

    /* renamed from: a */
    public void mo8668a(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f3714a) {
                this.f3714a.put(str, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    /* renamed from: b */
    public void mo8669b(String str) {
        Long remove;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f3714a) {
                remove = this.f3714a.remove(str);
            }
            if (remove != null) {
                long currentTimeMillis = System.currentTimeMillis() - remove.longValue();
                synchronized (f3713b) {
                    try {
                        f3713b = new JSONObject();
                        f3713b.put(C1447g.f3482ab, str);
                        f3713b.put("duration", currentTimeMillis);
                    } catch (Throwable th) {
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void mo8667a() {
        long j;
        String str;
        String str2 = null;
        long j2 = 0;
        synchronized (this.f3714a) {
            for (Map.Entry<String, Long> entry : this.f3714a.entrySet()) {
                if (entry.getValue().longValue() > j2) {
                    long longValue = entry.getValue().longValue();
                    str = entry.getKey();
                    j = longValue;
                } else {
                    j = j2;
                    str = str2;
                }
                str2 = str;
                j2 = j;
            }
        }
        if (str2 != null) {
            mo8669b(str2);
        }
    }

    /* renamed from: a */
    public static void m5564a(Context context) {
        if (context != null) {
            try {
                synchronized (f3713b) {
                    if (f3713b.length() > 0) {
                        C1443f.m5318a(context).mo8543a(C1493p.m5539a(), f3713b, C1443f.EnumC1445a.PAGE);
                        f3713b = new JSONObject();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
