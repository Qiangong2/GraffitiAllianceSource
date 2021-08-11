package com.umeng.analytics.p092c;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.C1370a;
import com.umeng.analytics.p093d.C1488m;
import com.umeng.analytics.p095f.C1500b;
import com.umeng.analytics.p095f.C1514d;
import com.umeng.p085a.C1344f;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import p000a.p001a.p002a.C0043g;
import p000a.p001a.p002a.C0049m;

/* renamed from: com.umeng.analytics.c.f */
/* compiled from: IdTracker */
public class C1454f {

    /* renamed from: a */
    public static C1454f f3558a;

    /* renamed from: b */
    private final String f3559b = "umeng_it.cache";

    /* renamed from: c */
    private File f3560c;

    /* renamed from: d */
    private C1514d f3561d = null;

    /* renamed from: e */
    private long f3562e;

    /* renamed from: f */
    private long f3563f;

    /* renamed from: g */
    private Set<AbstractC1449a> f3564g = new HashSet();

    /* renamed from: h */
    private C1455a f3565h = null;

    C1454f(Context context) {
        this.f3560c = new File(context.getFilesDir(), "umeng_it.cache");
        this.f3563f = C1370a.f3217i;
        this.f3565h = new C1455a(context);
        this.f3565h.mo8573b();
    }

    /* renamed from: a */
    public static synchronized C1454f m5362a(Context context) {
        C1454f fVar;
        synchronized (C1454f.class) {
            if (f3558a == null) {
                f3558a = new C1454f(context);
                f3558a.mo8565a(new C1456g(context));
                f3558a.mo8565a(new C1450b(context));
                f3558a.mo8565a(new C1465o(context));
                f3558a.mo8565a(new C1453e(context));
                f3558a.mo8565a(new C1452d(context));
                f3558a.mo8565a(new C1459i(context));
                f3558a.mo8565a(new C1462l());
                f3558a.mo8565a(new C1466p(context));
                C1464n nVar = new C1464n(context);
                if (!TextUtils.isEmpty(nVar.mo8554f())) {
                    f3558a.mo8565a(nVar);
                }
                C1461k kVar = new C1461k(context);
                if (kVar.mo8601g()) {
                    f3558a.mo8565a(kVar);
                    f3558a.mo8565a(new C1460j(context));
                    kVar.mo8603i();
                }
                f3558a.mo8569e();
            }
            fVar = f3558a;
        }
        return fVar;
    }

    /* renamed from: a */
    public boolean mo8565a(AbstractC1449a aVar) {
        if (this.f3565h.mo8572a(aVar.mo8550b())) {
            return this.f3564g.add(aVar);
        }
        return false;
    }

    /* renamed from: a */
    public void mo8564a(long j) {
        this.f3563f = j;
    }

    /* renamed from: a */
    public void mo8563a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f3562e >= this.f3563f) {
            boolean z = false;
            for (AbstractC1449a aVar : this.f3564g) {
                if (aVar.mo8551c()) {
                    if (aVar.mo8549a()) {
                        z = true;
                        if (!aVar.mo8551c()) {
                            this.f3565h.mo8574b(aVar.mo8550b());
                        }
                    }
                    z = z;
                }
            }
            if (z) {
                m5364g();
                this.f3565h.mo8571a();
                mo8570f();
            }
            this.f3562e = currentTimeMillis;
        }
    }

    /* renamed from: b */
    public C1514d mo8566b() {
        return this.f3561d;
    }

    /* renamed from: g */
    private void m5364g() {
        C1514d dVar = new C1514d();
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (AbstractC1449a aVar : this.f3564g) {
            if (aVar.mo8551c()) {
                if (aVar.mo8552d() != null) {
                    hashMap.put(aVar.mo8550b(), aVar.mo8552d());
                }
                if (aVar.mo8553e() != null && !aVar.mo8553e().isEmpty()) {
                    arrayList.addAll(aVar.mo8553e());
                }
            }
        }
        dVar.mo8745a(arrayList);
        dVar.mo8746a(hashMap);
        synchronized (this) {
            this.f3561d = dVar;
        }
    }

    /* renamed from: c */
    public String mo8567c() {
        return null;
    }

    /* renamed from: d */
    public void mo8568d() {
        boolean z = false;
        for (AbstractC1449a aVar : this.f3564g) {
            if (aVar.mo8551c()) {
                if (aVar.mo8553e() != null && !aVar.mo8553e().isEmpty()) {
                    aVar.mo8548a((List<C1500b>) null);
                    z = true;
                }
                z = z;
            }
        }
        if (z) {
            this.f3561d.mo8750b(false);
            mo8570f();
        }
    }

    /* renamed from: e */
    public void mo8569e() {
        C1514d h = m5365h();
        if (h != null) {
            ArrayList<AbstractC1449a> arrayList = new ArrayList(this.f3564g.size());
            synchronized (this) {
                this.f3561d = h;
                for (AbstractC1449a aVar : this.f3564g) {
                    aVar.mo8547a(this.f3561d);
                    if (!aVar.mo8551c()) {
                        arrayList.add(aVar);
                    }
                }
                for (AbstractC1449a aVar2 : arrayList) {
                    this.f3564g.remove(aVar2);
                }
            }
            m5364g();
        }
    }

    /* renamed from: f */
    public void mo8570f() {
        if (this.f3561d != null) {
            m5363a(this.f3561d);
        }
    }

    /* renamed from: h */
    private C1514d m5365h() {
        FileInputStream fileInputStream;
        Throwable th;
        Exception e;
        if (!this.f3560c.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(this.f3560c);
            try {
                byte[] b = C1344f.m4980b(fileInputStream);
                C1514d dVar = new C1514d();
                new C0043g().mo102a(dVar, b);
                C1344f.m4981c(fileInputStream);
                return dVar;
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                    C1344f.m4981c(fileInputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    C1344f.m4981c(fileInputStream);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            e.printStackTrace();
            C1344f.m4981c(fileInputStream);
            return null;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            C1344f.m4981c(fileInputStream);
            throw th;
        }
    }

    /* renamed from: a */
    private void m5363a(C1514d dVar) {
        byte[] a;
        if (dVar != null) {
            try {
                synchronized (this) {
                    a = new C0049m().mo116a(dVar);
                }
                if (a != null) {
                    C1344f.m4976a(this.f3560c, a);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.umeng.analytics.c.f$a */
    /* compiled from: IdTracker */
    public static class C1455a {

        /* renamed from: a */
        private Context f3566a;

        /* renamed from: b */
        private Set<String> f3567b = new HashSet();

        public C1455a(Context context) {
            this.f3566a = context;
        }

        /* renamed from: a */
        public boolean mo8572a(String str) {
            return !this.f3567b.contains(str);
        }

        /* renamed from: b */
        public void mo8574b(String str) {
            this.f3567b.add(str);
        }

        /* renamed from: c */
        public void mo8575c(String str) {
            this.f3567b.remove(str);
        }

        /* renamed from: a */
        public void mo8571a() {
            if (!this.f3567b.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (String str : this.f3567b) {
                    sb.append(str);
                    sb.append(',');
                }
                sb.deleteCharAt(sb.length() - 1);
                C1488m.m5522a(this.f3566a).edit().putString("invld_id", sb.toString()).commit();
            }
        }

        /* renamed from: b */
        public void mo8573b() {
            String[] split;
            String string = C1488m.m5522a(this.f3566a).getString("invld_id", null);
            if (!(TextUtils.isEmpty(string) || (split = string.split(MiPushClient.ACCEPT_TIME_SEPARATOR)) == null)) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.f3567b.add(str);
                    }
                }
            }
        }
    }
}
