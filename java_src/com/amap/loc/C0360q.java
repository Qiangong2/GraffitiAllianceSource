package com.amap.loc;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

@AbstractC0229ad(mo3651a = "a")
/* renamed from: com.amap.loc.q */
/* compiled from: SDKInfo */
public class C0360q {
    @AbstractC0230ae(mo3653a = "a1", mo3654b = 6)

    /* renamed from: a */
    private String f899a;
    @AbstractC0230ae(mo3653a = "a2", mo3654b = 6)

    /* renamed from: b */
    private String f900b;
    @AbstractC0230ae(mo3653a = "a6", mo3654b = 2)

    /* renamed from: c */
    private int f901c;
    @AbstractC0230ae(mo3653a = "a3", mo3654b = 6)

    /* renamed from: d */
    private String f902d;
    @AbstractC0230ae(mo3653a = "a4", mo3654b = 6)

    /* renamed from: e */
    private String f903e;
    @AbstractC0230ae(mo3653a = "a5", mo3654b = 6)

    /* renamed from: f */
    private String f904f;

    /* renamed from: g */
    private String f905g;

    /* renamed from: h */
    private String f906h;

    /* renamed from: i */
    private String f907i;

    /* renamed from: j */
    private String f908j;

    /* renamed from: k */
    private String[] f909k;

    /* renamed from: com.amap.loc.q$a */
    /* compiled from: SDKInfo */
    public static class C0362a {

        /* renamed from: a */
        private String f910a;

        /* renamed from: b */
        private String f911b;

        /* renamed from: c */
        private String f912c;

        /* renamed from: d */
        private boolean f913d = true;

        /* renamed from: e */
        private String f914e = "standard";

        /* renamed from: f */
        private String[] f915f = null;

        public C0362a(String str, String str2, String str3) {
            this.f910a = str2;
            this.f912c = str3;
            this.f911b = str;
        }

        /* renamed from: a */
        public C0362a mo3945a(String[] strArr) {
            this.f915f = (String[]) strArr.clone();
            return this;
        }

        /* renamed from: a */
        public C0360q mo3946a() throws C0341h {
            if (this.f915f != null) {
                return new C0360q(this);
            }
            throw new C0341h("sdk packages is null");
        }
    }

    private C0360q() {
        this.f901c = 1;
        this.f909k = null;
    }

    private C0360q(C0362a aVar) {
        int i = 1;
        this.f901c = 1;
        this.f909k = null;
        this.f905g = aVar.f910a;
        this.f907i = aVar.f911b;
        this.f906h = aVar.f912c;
        this.f901c = !aVar.f913d ? 0 : i;
        this.f908j = aVar.f914e;
        this.f909k = aVar.f915f;
        this.f900b = C0363r.m1359b(this.f905g);
        this.f899a = C0363r.m1359b(this.f907i);
        this.f902d = C0363r.m1359b(this.f906h);
        this.f903e = C0363r.m1359b(m1331a(this.f909k));
        this.f904f = C0363r.m1359b(this.f908j);
    }

    /* renamed from: a */
    public static String m1330a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("a1", C0363r.m1359b(str));
        return C0228ac.m468a((Map<String, String>) hashMap);
    }

    /* renamed from: a */
    private String m1331a(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                sb.append(str).append(";");
            }
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    private String[] m1332b(String str) {
        try {
            return str.split(";");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: f */
    public static String m1333f() {
        return "a6=1";
    }

    /* renamed from: a */
    public String mo3939a() {
        if (TextUtils.isEmpty(this.f907i) && !TextUtils.isEmpty(this.f899a)) {
            this.f907i = C0363r.m1362c(this.f899a);
        }
        return this.f907i;
    }

    /* renamed from: a */
    public void mo3940a(boolean z) {
        this.f901c = z ? 1 : 0;
    }

    /* renamed from: b */
    public String mo3941b() {
        if (TextUtils.isEmpty(this.f905g) && !TextUtils.isEmpty(this.f900b)) {
            this.f905g = C0363r.m1362c(this.f900b);
        }
        return this.f905g;
    }

    /* renamed from: c */
    public String mo3942c() {
        if (TextUtils.isEmpty(this.f908j) && !TextUtils.isEmpty(this.f904f)) {
            this.f908j = C0363r.m1362c(this.f904f);
        }
        if (TextUtils.isEmpty(this.f908j)) {
            this.f908j = "standard";
        }
        return this.f908j;
    }

    /* renamed from: d */
    public boolean mo3943d() {
        return this.f901c == 1;
    }

    /* renamed from: e */
    public String[] mo3944e() {
        if ((this.f909k == null || this.f909k.length == 0) && !TextUtils.isEmpty(this.f903e)) {
            this.f909k = m1332b(C0363r.m1362c(this.f903e));
        }
        return (String[]) this.f909k.clone();
    }
}
