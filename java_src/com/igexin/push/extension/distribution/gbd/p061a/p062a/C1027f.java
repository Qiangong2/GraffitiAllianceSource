package com.igexin.push.extension.distribution.gbd.p061a.p062a;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import com.igexin.push.core.C0618g;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1080b;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.extension.distribution.gbd.p076i.C1116e;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* renamed from: com.igexin.push.extension.distribution.gbd.a.a.f */
public class C1027f {

    /* renamed from: a */
    private static C1027f f2621a;

    /* renamed from: b */
    private Context f2622b;

    private C1027f(Context context) {
        this.f2622b = context;
    }

    /* renamed from: a */
    private int m4130a(String str, String str2) {
        int length = str.split(str2).length - 1;
        if (length > 0) {
            return length;
        }
        return 0;
    }

    /* renamed from: a */
    public static C1027f m4131a() {
        if (f2621a == null) {
            f2621a = new C1027f(C0618g.f1635f);
        }
        return f2621a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x013d A[SYNTHETIC, Splitter:B:79:0x013d] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x015b A[SYNTHETIC, Splitter:B:91:0x015b] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.ArrayList<java.lang.String[]> m4132a(java.lang.String r17, boolean r18, java.lang.String r19) {
        /*
        // Method dump skipped, instructions count: 361
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.gbd.p061a.p062a.C1027f.m4132a(java.lang.String, boolean, java.lang.String):java.util.ArrayList");
    }

    /* renamed from: a */
    private List<String> m4133a(ArrayList<String[]> arrayList, List<ActivityManager.RecentTaskInfo> list) {
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            Iterator<String[]> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(0, it.next()[9]);
            }
        } else {
            for (ActivityManager.RecentTaskInfo recentTaskInfo : list) {
                arrayList2.add(recentTaskInfo.baseIntent.getComponent().getPackageName());
            }
        }
        return arrayList2;
    }

    /* renamed from: a */
    private void m4134a(String str) {
        C1080b.m4391a().mo5812a(str, mo5681c());
        C1115d.m4559b("GBD_RALA", "recent app data: type = " + mo5681c());
    }

    /* renamed from: e */
    private List<String> m4135e() {
        try {
            return m4133a((ArrayList<String[]>) null, ((ActivityManager) this.f2622b.getSystemService("activity")).getRecentTasks(10, 1));
        } catch (Exception e) {
            C1115d.m4558a(e);
            return null;
        }
    }

    /* renamed from: f */
    private List<String> m4136f() {
        try {
            ArrayList<String[]> a = m4132a("ps -P", true, "");
            if (a == null || a.isEmpty()) {
                return null;
            }
            if (a.isEmpty()) {
                return null;
            }
            ArrayList<String[]> a2 = m4132a("ps -P", false, a.get(0)[1]);
            if (a2 == null || a2.isEmpty()) {
                return null;
            }
            return m4133a(a2, (List<ActivityManager.RecentTaskInfo>) null);
        } catch (Exception e) {
            C1115d.m4558a(e);
            return null;
        }
    }

    /* renamed from: b */
    public void mo5680b() {
        int i;
        try {
            C1115d.m4559b("GBD_RALA", "dosample");
            List<String> f = Build.VERSION.SDK_INT >= 21 ? m4136f() : m4135e();
            if (f != null) {
                String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(C1116e.m4607k()));
                StringBuilder sb = new StringBuilder();
                sb.append(format);
                sb.append("|");
                sb.append(C0618g.f1647r);
                sb.append("|");
                sb.append(C0618g.f1602a);
                sb.append("|");
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                for (String str : f) {
                    if (!arrayList.contains(str)) {
                        arrayList.add(str);
                        if (i2 == 0) {
                            sb.append(str);
                        } else {
                            sb.append(MiPushClient.ACCEPT_TIME_SEPARATOR).append(str);
                        }
                        i = i2 + 1;
                        if (i >= 10) {
                            break;
                        }
                    } else {
                        i = i2;
                    }
                    i2 = i;
                }
                sb.append("|");
                sb.append("ANDROID");
                m4134a(sb.toString());
            }
        } catch (Exception e) {
            C1115d.m4558a(e);
        }
    }

    /* renamed from: c */
    public int mo5681c() {
        return 6;
    }

    /* renamed from: d */
    public String mo5682d() {
        return "* * * * *";
    }
}
