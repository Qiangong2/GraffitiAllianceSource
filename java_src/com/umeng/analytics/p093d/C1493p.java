package com.umeng.analytics.p093d;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.C1370a;
import com.umeng.analytics.p091b.C1428b;
import com.umeng.analytics.p091b.C1443f;
import com.umeng.analytics.p091b.C1447g;
import com.umeng.p085a.C1343e;
import com.umeng.p085a.C1344f;
import com.umeng.p085a.C1346h;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.d.p */
/* compiled from: SessionTracker */
public class C1493p {

    /* renamed from: a */
    private static final String f3692a = "session_start_time";

    /* renamed from: b */
    private static final String f3693b = "session_end_time";

    /* renamed from: c */
    private static final String f3694c = "session_id";

    /* renamed from: f */
    private static String f3695f = null;

    /* renamed from: g */
    private static Context f3696g = null;

    /* renamed from: d */
    private final String f3697d = "a_start_time";

    /* renamed from: e */
    private final String f3698e = "a_end_time";

    /* renamed from: a */
    public boolean mo8652a(Context context) {
        SharedPreferences a = C1488m.m5522a(context);
        String string = a.getString(f3694c, null);
        if (string == null) {
            return false;
        }
        long j = a.getLong(f3692a, 0);
        long j2 = a.getLong(f3693b, 0);
        if (j2 == 0 || Math.abs(j2 - j) > C1370a.f3217i) {
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(C1428b.C1435c.C1436a.f3398a, string);
            jSONObject.put("__e", j);
            jSONObject.put(C1428b.C1435c.C1436a.f3404g, j2);
            double[] location = AnalyticsConfig.getLocation();
            if (location != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(C1447g.f3485ae, location[0]);
                jSONObject2.put(C1447g.f3486af, location[1]);
                jSONObject2.put("ts", System.currentTimeMillis());
                jSONObject.put(C1428b.C1435c.C1436a.f3402e, jSONObject2);
            }
            Class<?> cls = Class.forName("android.net.TrafficStats");
            Method method = cls.getMethod("getUidRxBytes", Integer.TYPE);
            Method method2 = cls.getMethod("getUidTxBytes", Integer.TYPE);
            int i = context.getApplicationInfo().uid;
            if (i == -1) {
                return false;
            }
            long longValue = ((Long) method.invoke(null, Integer.valueOf(i))).longValue();
            long longValue2 = ((Long) method2.invoke(null, Integer.valueOf(i))).longValue();
            if (longValue > 0 && longValue2 > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(C1447g.f3490aj, longValue);
                jSONObject3.put(C1447g.f3489ai, longValue2);
                jSONObject.put(C1428b.C1435c.C1436a.f3401d, jSONObject3);
            }
            C1443f.m5318a(context).mo8543a(string, jSONObject, C1443f.EnumC1445a.NEWSESSION);
            C1495r.m5564a(f3696g);
            C1469b.m5435b(f3696g);
            m5541a(a);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: a */
    private void m5541a(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove(f3692a);
        edit.remove(f3693b);
        edit.remove("a_start_time");
        edit.remove("a_end_time");
        edit.commit();
    }

    /* renamed from: b */
    public String mo8653b(Context context) {
        String c = C1343e.m4944c(context);
        String appkey = AnalyticsConfig.getAppkey(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (appkey == null) {
            throw new RuntimeException("Appkey is null or empty, Please check AndroidManifest.xml");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(currentTimeMillis).append(appkey).append(c);
        f3695f = C1344f.m4973a(sb.toString());
        return f3695f;
    }

    /* renamed from: c */
    public void mo8654c(Context context) {
        f3696g = context;
        SharedPreferences a = C1488m.m5522a(context);
        if (a != null) {
            SharedPreferences.Editor edit = a.edit();
            int i = a.getInt(C1370a.f3206B, 0);
            int parseInt = Integer.parseInt(C1343e.m4934a(f3696g));
            if (i != 0 && parseInt != i) {
                try {
                    edit.putInt("vers_code", i);
                    edit.putString("vers_name", a.getString(C1370a.f3207C, ""));
                    edit.commit();
                } catch (Throwable th) {
                }
                if (m5543g(context) == null) {
                    m5540a(context, a);
                }
                mo8656e(f3696g);
                C1474d.m5473b(f3696g).mo8623b();
                mo8657f(f3696g);
                C1474d.m5473b(f3696g).mo8618a();
            } else if (m5542b(a)) {
                C1346h.m4997c("Start new session: " + m5540a(context, a));
            } else {
                String string = a.getString(f3694c, null);
                edit.putLong("a_start_time", System.currentTimeMillis());
                edit.putLong("a_end_time", 0);
                edit.commit();
                C1346h.m4997c("Extend current session: " + string);
            }
        }
    }

    /* renamed from: d */
    public void mo8655d(Context context) {
        SharedPreferences a = C1488m.m5522a(context);
        if (a != null) {
            if (a.getLong("a_start_time", 0) != 0 || !AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
                long currentTimeMillis = System.currentTimeMillis();
                SharedPreferences.Editor edit = a.edit();
                edit.putLong("a_start_time", 0);
                edit.putLong("a_end_time", currentTimeMillis);
                edit.putLong(f3693b, currentTimeMillis);
                edit.commit();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(C1428b.C1435c.C1436a.f3404g, currentTimeMillis);
                    C1443f.m5318a(context).mo8543a(m5539a(), jSONObject, C1443f.EnumC1445a.END);
                } catch (Throwable th) {
                }
            } else {
                C1346h.m5009e("onPause called before onResume");
            }
        }
    }

    /* renamed from: b */
    private boolean m5542b(SharedPreferences sharedPreferences) {
        long j = sharedPreferences.getLong("a_start_time", 0);
        long j2 = sharedPreferences.getLong("a_end_time", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (j != 0 && currentTimeMillis - j < AnalyticsConfig.kContinueSessionMillis) {
            C1346h.m5009e("onResume called before onPause");
            return false;
        } else if (currentTimeMillis - j2 > AnalyticsConfig.kContinueSessionMillis) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: a */
    private String m5540a(Context context, SharedPreferences sharedPreferences) {
        C1474d b = C1474d.m5473b(context);
        String b2 = mo8653b(context);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__e", currentTimeMillis);
            C1443f.m5318a(f3696g).mo8543a(b2, jSONObject, C1443f.EnumC1445a.BEGIN);
        } catch (Throwable th) {
        }
        mo8652a(context);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(f3694c, b2);
        edit.putLong(f3692a, System.currentTimeMillis());
        edit.putLong(f3693b, 0);
        edit.putLong("a_start_time", currentTimeMillis);
        edit.putLong("a_end_time", 0);
        edit.putInt(C1370a.f3206B, Integer.parseInt(C1343e.m4934a(context)));
        edit.putString(C1370a.f3207C, C1343e.m4941b(context));
        edit.commit();
        b.mo8621a((Object) true);
        return b2;
    }

    /* renamed from: e */
    public boolean mo8656e(Context context) {
        boolean z = false;
        SharedPreferences a = C1488m.m5522a(context);
        if (!(a == null || a.getString(f3694c, null) == null)) {
            long j = a.getLong("a_start_time", 0);
            long j2 = a.getLong("a_end_time", 0);
            if (j > 0 && j2 == 0) {
                z = true;
                mo8655d(context);
            }
            mo8652a(context);
        }
        return z;
    }

    /* renamed from: f */
    public void mo8657f(Context context) {
        SharedPreferences a = C1488m.m5522a(context);
        if (a != null) {
            String b = mo8653b(context);
            SharedPreferences.Editor edit = a.edit();
            long currentTimeMillis = System.currentTimeMillis();
            edit.putString(f3694c, b);
            edit.putLong(f3692a, System.currentTimeMillis());
            edit.putLong(f3693b, 0);
            edit.putLong("a_start_time", currentTimeMillis);
            edit.putLong("a_end_time", 0);
            edit.putInt(C1370a.f3206B, Integer.parseInt(C1343e.m4934a(context)));
            edit.putString(C1370a.f3207C, C1343e.m4941b(context));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("__e", currentTimeMillis);
                C1443f.m5318a(f3696g).mo8543a(b, jSONObject, C1443f.EnumC1445a.BEGIN);
            } catch (Throwable th) {
            }
            edit.commit();
        }
    }

    /* renamed from: g */
    public static String m5543g(Context context) {
        if (f3695f == null) {
            f3695f = C1488m.m5522a(context).getString(f3694c, null);
        }
        return f3695f;
    }

    /* renamed from: a */
    public static String m5539a() {
        return m5543g(f3696g);
    }
}
