package com.xiaomi.push.service;

import android.content.Context;
import android.support.p007v4.p009os.EnvironmentCompat;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.xiaomi.push.service.w */
public class C1987w {

    /* renamed from: a */
    private static C1987w f5124a;

    /* renamed from: b */
    private ConcurrentHashMap<String, HashMap<String, C1989b>> f5125b = new ConcurrentHashMap<>();

    /* renamed from: c */
    private List<AbstractC1988a> f5126c = new ArrayList();

    /* renamed from: com.xiaomi.push.service.w$a */
    public interface AbstractC1988a {
        /* renamed from: a */
        void mo10395a();
    }

    /* renamed from: com.xiaomi.push.service.w$b */
    public static class C1989b {

        /* renamed from: a */
        public String f5127a;

        /* renamed from: b */
        public String f5128b;

        /* renamed from: c */
        public String f5129c;

        /* renamed from: d */
        public String f5130d;

        /* renamed from: e */
        public boolean f5131e;

        /* renamed from: f */
        public String f5132f;

        /* renamed from: g */
        public String f5133g;

        /* renamed from: h */
        public String f5134h;

        /* renamed from: i */
        public String f5135i;

        /* renamed from: j */
        public String f5136j;

        /* renamed from: k */
        public C1964b f5137k;

        /* renamed from: l */
        public Context f5138l;

        /* renamed from: m */
        EnumC1991c f5139m = EnumC1991c.unbind;

        /* renamed from: n */
        private int f5140n = 0;

        /* renamed from: o */
        private List<AbstractC1990a> f5141o = new ArrayList();

        /* renamed from: p */
        private XMPushService f5142p;

        /* renamed from: q */
        private XMPushService.C1934b f5143q = new XMPushService.C1934b(this);

        /* renamed from: com.xiaomi.push.service.w$b$a */
        public interface AbstractC1990a {
            /* renamed from: a */
            void mo10396a(EnumC1991c cVar, EnumC1991c cVar2, int i);
        }

        public C1989b(XMPushService xMPushService) {
            this.f5142p = xMPushService;
            mo10444a(new C1992x(this));
        }

        /* renamed from: a */
        public long mo10442a() {
            return 1000 * (((long) ((Math.random() * 20.0d) - 10.0d)) + ((long) ((this.f5140n + 1) * 15)));
        }

        /* renamed from: a */
        public String mo10443a(int i) {
            switch (i) {
                case 1:
                    return "OPEN";
                case 2:
                    return "CLOSE";
                case 3:
                    return "KICK";
                default:
                    return EnvironmentCompat.MEDIA_UNKNOWN;
            }
        }

        /* renamed from: a */
        public void mo10444a(AbstractC1990a aVar) {
            synchronized (this.f5141o) {
                this.f5141o.add(aVar);
            }
        }

        /* renamed from: a */
        public void mo10445a(EnumC1991c cVar, int i, int i2, String str, String str2) {
            boolean z = true;
            synchronized (this.f5141o) {
                for (AbstractC1990a aVar : this.f5141o) {
                    aVar.mo10396a(this.f5139m, cVar, i2);
                }
            }
            if (this.f5139m != cVar) {
                AbstractC1855b.m6718a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", this.f5139m, cVar, mo10443a(i), AbstractC1993y.m7431a(i2), str, str2, this.f5134h));
                this.f5139m = cVar;
            }
            if (this.f5137k == null) {
                AbstractC1855b.m6723d("status changed while the client dispatcher is missing");
            } else if (i == 2) {
                this.f5137k.mo10400a(this.f5138l, this, i2);
            } else if (i == 3) {
                this.f5137k.mo10401a(this.f5138l, this, str2, str);
            } else if (i == 1) {
                if (cVar != EnumC1991c.binded) {
                    z = false;
                }
                if (!z && "wait".equals(str2)) {
                    this.f5140n++;
                } else if (z) {
                    this.f5140n = 0;
                }
                this.f5137k.mo10402a(this.f5138l, this, z, i2, str);
            }
        }

        /* renamed from: b */
        public void mo10446b(AbstractC1990a aVar) {
            synchronized (this.f5141o) {
                this.f5141o.remove(aVar);
            }
        }
    }

    /* renamed from: com.xiaomi.push.service.w$c */
    public enum EnumC1991c {
        unbind,
        binding,
        binded
    }

    private C1987w() {
    }

    /* renamed from: a */
    public static synchronized C1987w m7406a() {
        C1987w wVar;
        synchronized (C1987w.class) {
            if (f5124a == null) {
                f5124a = new C1987w();
            }
            wVar = f5124a;
        }
        return wVar;
    }

    /* renamed from: d */
    private String m7407d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("@");
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    /* renamed from: a */
    public synchronized void mo10429a(Context context) {
        for (HashMap<String, C1989b> hashMap : this.f5125b.values()) {
            for (C1989b bVar : hashMap.values()) {
                bVar.mo10445a(EnumC1991c.unbind, 1, 3, null, null);
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo10430a(Context context, int i) {
        for (HashMap<String, C1989b> hashMap : this.f5125b.values()) {
            for (C1989b bVar : hashMap.values()) {
                bVar.mo10445a(EnumC1991c.unbind, 2, i, null, null);
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo10431a(AbstractC1988a aVar) {
        this.f5126c.add(aVar);
    }

    /* renamed from: a */
    public synchronized void mo10432a(C1989b bVar) {
        HashMap<String, C1989b> hashMap = this.f5125b.get(bVar.f5134h);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.f5125b.put(bVar.f5134h, hashMap);
        }
        hashMap.put(m7407d(bVar.f5128b), bVar);
        for (AbstractC1988a aVar : this.f5126c) {
            aVar.mo10395a();
        }
    }

    /* renamed from: a */
    public synchronized void mo10433a(String str) {
        HashMap<String, C1989b> hashMap = this.f5125b.get(str);
        if (hashMap != null) {
            hashMap.clear();
            this.f5125b.remove(str);
        }
        for (AbstractC1988a aVar : this.f5126c) {
            aVar.mo10395a();
        }
    }

    /* renamed from: a */
    public synchronized void mo10434a(String str, String str2) {
        HashMap<String, C1989b> hashMap = this.f5125b.get(str);
        if (hashMap != null) {
            hashMap.remove(m7407d(str2));
            if (hashMap.isEmpty()) {
                this.f5125b.remove(str);
            }
        }
        for (AbstractC1988a aVar : this.f5126c) {
            aVar.mo10395a();
        }
    }

    /* renamed from: b */
    public synchronized C1989b mo10435b(String str, String str2) {
        HashMap<String, C1989b> hashMap;
        hashMap = this.f5125b.get(str);
        return hashMap == null ? null : hashMap.get(m7407d(str2));
    }

    /* renamed from: b */
    public synchronized ArrayList<C1989b> mo10436b() {
        ArrayList<C1989b> arrayList;
        arrayList = new ArrayList<>();
        for (HashMap<String, C1989b> hashMap : this.f5125b.values()) {
            arrayList.addAll(hashMap.values());
        }
        return arrayList;
    }

    /* renamed from: b */
    public synchronized List<String> mo10437b(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (HashMap<String, C1989b> hashMap : this.f5125b.values()) {
            for (C1989b bVar : hashMap.values()) {
                if (str.equals(bVar.f5127a)) {
                    arrayList.add(bVar.f5134h);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public synchronized int mo10438c() {
        return this.f5125b.size();
    }

    /* renamed from: c */
    public synchronized Collection<C1989b> mo10439c(String str) {
        return !this.f5125b.containsKey(str) ? new ArrayList<>() : ((HashMap) this.f5125b.get(str).clone()).values();
    }

    /* renamed from: d */
    public synchronized void mo10440d() {
        this.f5125b.clear();
    }

    /* renamed from: e */
    public synchronized void mo10441e() {
        this.f5126c.clear();
    }
}
