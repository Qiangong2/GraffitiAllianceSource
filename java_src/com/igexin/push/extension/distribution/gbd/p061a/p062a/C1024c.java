package com.igexin.push.extension.distribution.gbd.p061a.p062a;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import com.igexin.push.core.C0618g;
import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1080b;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1083e;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.extension.distribution.gbd.p076i.C1116e;
import com.igexin.push.extension.distribution.gbd.p076i.C1126o;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* renamed from: com.igexin.push.extension.distribution.gbd.a.a.c */
public class C1024c {

    /* renamed from: b */
    private static C1024c f2614b;

    /* renamed from: a */
    private long f2615a;

    /* renamed from: c */
    private Context f2616c;

    /* renamed from: d */
    private HashMap<String, String> f2617d = new HashMap<>();

    private C1024c(Context context) {
        this.f2616c = context;
    }

    /* renamed from: a */
    public static C1024c m4113a() {
        if (f2614b == null) {
            f2614b = new C1024c(C0618g.f1635f);
        }
        return f2614b;
    }

    /* renamed from: a */
    private String m4114a(int i, int i2) {
        try {
            if (!C1083e.m4408a().mo5831e()) {
                return null;
            }
            List<String> g = m4121g();
            List<String> h = m4122h();
            if (g == null && h == null) {
                return null;
            }
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(C1116e.m4607k()));
            StringBuilder sb = new StringBuilder();
            sb.append(format);
            sb.append("|");
            sb.append(C0618g.f1647r);
            sb.append("|");
            sb.append(C0618g.f1602a);
            sb.append("|");
            if (i != 0) {
                sb.append(i);
            }
            sb.append("|");
            if (i2 != 0) {
                sb.append(i2);
            }
            sb.append("|");
            sb.append("|");
            sb.append(m4115a(g, 10));
            sb.append("|");
            sb.append(m4118b(h, C1067a.f2776a));
            sb.append("|");
            sb.append("ANDROID");
            return sb.toString();
        } catch (Exception e) {
            C1115d.m4558a(e);
            return null;
        }
    }

    /* renamed from: a */
    private String m4115a(List<String> list, int i) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        if (list == null || list.size() == 0) {
            return "";
        }
        int i2 = 0;
        for (String str : list) {
            if (!arrayList.contains(str)) {
                arrayList.add(str);
                if (i2 == 0) {
                    sb.append(str);
                } else {
                    sb.append(MiPushClient.ACCEPT_TIME_SEPARATOR).append(str);
                }
                i2++;
                if (i2 >= i) {
                    break;
                }
            } else {
                i2 = i2;
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    private List<String> m4116a(List<ActivityManager.RecentTaskInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (ActivityManager.RecentTaskInfo recentTaskInfo : list) {
            arrayList.add(recentTaskInfo.baseIntent.getComponent().getPackageName());
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m4117a(String str) {
        C1080b.m4391a().mo5812a(str, mo5676e());
        C1115d.m4559b("GBD_RNRAA", "save type = " + mo5676e());
    }

    /* renamed from: b */
    private String m4118b(List<String> list, int i) {
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (list == null || list.size() == 0) {
            return "";
        }
        for (String str : list) {
            if (!arrayList2.contains(str)) {
                arrayList2.add(str);
            }
        }
        for (String str2 : arrayList2) {
            if (str2.contains(":")) {
                String[] split = str2.split(":");
                if (split.length == 2) {
                    if (arrayList3.contains(split[0])) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= arrayList.size()) {
                                break;
                            }
                            String str3 = (String) arrayList.get(i2);
                            if (str3.contains(split[0] + ":")) {
                                arrayList.set(i2, str3 + "&" + split[1]);
                                break;
                            }
                            i2++;
                        }
                    } else {
                        arrayList3.add(split[0]);
                        arrayList.add(str2);
                    }
                }
            } else {
                arrayList.add(str2);
            }
        }
        int min = Math.min(arrayList.size(), i);
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < min; i3++) {
            sb.append((String) arrayList.get(i3));
            if (i3 < min - 1) {
                sb.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0092 A[Catch:{ Throwable -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ad A[Catch:{ Throwable -> 0x00cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00d7 A[EDGE_INSN: B:65:0x00d7->B:58:0x00d7 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d5 A[EDGE_INSN: B:68:0x00d5->B:57:0x00d5 ?: BREAK  , SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m4119b(java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 221
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.gbd.p061a.p062a.C1024c.m4119b(java.lang.String):boolean");
    }

    /* renamed from: f */
    private void m4120f() {
        if (this.f2617d != null) {
            m4117a(this.f2617d.get("unlock"));
            m4117a(this.f2617d.get("lock"));
            this.f2617d.clear();
        }
    }

    /* renamed from: g */
    private List<String> m4121g() {
        try {
            return m4116a(((ActivityManager) this.f2616c.getSystemService("activity")).getRecentTasks(10, 1));
        } catch (Exception e) {
            C1115d.m4558a(e);
            return null;
        }
    }

    /* renamed from: h */
    private List<String> m4122h() {
        try {
            List<String> a = C1126o.m4630a(true);
            if (a == null || a.isEmpty() || (a.size() == 1 && a.get(0).equals(this.f2616c.getPackageName()))) {
                return null;
            }
            try {
                Iterator<String> it = a.iterator();
                while (it.hasNext()) {
                    if (!m4119b(it.next())) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                C1115d.m4558a(th);
            }
            return a;
        } catch (Exception e) {
            C1115d.m4558a(e);
            return null;
        }
    }

    /* renamed from: b */
    public void mo5673b() {
        try {
            this.f2615a = System.currentTimeMillis();
            String a = m4114a(1, 0);
            if (!TextUtils.isEmpty(a)) {
                this.f2617d.put("unlock", a);
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }

    /* renamed from: c */
    public void mo5674c() {
        try {
            if (System.currentTimeMillis() - this.f2615a < 30000 || !this.f2617d.containsKey("unlock")) {
                this.f2617d.clear();
                return;
            }
            String a = m4114a(2, 0);
            if (!TextUtils.isEmpty(a)) {
                this.f2617d.put("lock", a);
                m4120f();
                return;
            }
            this.f2617d.clear();
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }

    /* renamed from: d */
    public void mo5675d() {
        C1115d.m4559b("GBD_RNRAA", "doSample");
        try {
            if (C1116e.m4584c(this.f2616c) && System.currentTimeMillis() - this.f2615a >= C1067a.f2813x * 1000) {
                String a = m4114a(0, 1);
                if (!TextUtils.isEmpty(a)) {
                    m4117a(a);
                }
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }

    /* renamed from: e */
    public int mo5676e() {
        return 24;
    }
}
