package com.amap.loc;

import java.util.HashMap;
import java.util.Map;

@AbstractC0229ad(mo3651a = "file")
/* renamed from: com.amap.loc.az */
/* compiled from: DynamicPlugin */
public class C0256az {
    @AbstractC0230ae(mo3653a = "fname", mo3654b = 6)

    /* renamed from: a */
    private String f340a;
    @AbstractC0230ae(mo3653a = "md", mo3654b = 6)

    /* renamed from: b */
    private String f341b;
    @AbstractC0230ae(mo3653a = "sname", mo3654b = 6)

    /* renamed from: c */
    private String f342c;
    @AbstractC0230ae(mo3653a = "version", mo3654b = 6)

    /* renamed from: d */
    private String f343d;
    @AbstractC0230ae(mo3653a = "dversion", mo3654b = 6)

    /* renamed from: e */
    private String f344e;
    @AbstractC0230ae(mo3653a = "status", mo3654b = 6)

    /* renamed from: f */
    private String f345f;

    /* renamed from: com.amap.loc.az$a */
    /* compiled from: DynamicPlugin */
    public static class C0257a {

        /* renamed from: a */
        private String f346a;

        /* renamed from: b */
        private String f347b;

        /* renamed from: c */
        private String f348c;

        /* renamed from: d */
        private String f349d;

        /* renamed from: e */
        private String f350e;

        /* renamed from: f */
        private String f351f = "copy";

        public C0257a(String str, String str2, String str3, String str4, String str5) {
            this.f346a = str;
            this.f347b = str2;
            this.f348c = str3;
            this.f349d = str4;
            this.f350e = str5;
        }

        /* renamed from: a */
        public C0257a mo3712a(String str) {
            this.f351f = str;
            return this;
        }

        /* renamed from: a */
        public C0256az mo3713a() {
            return new C0256az(this);
        }
    }

    private C0256az() {
    }

    public C0256az(C0257a aVar) {
        this.f340a = aVar.f346a;
        this.f341b = aVar.f347b;
        this.f342c = aVar.f348c;
        this.f343d = aVar.f349d;
        this.f344e = aVar.f350e;
        this.f345f = aVar.f351f;
    }

    /* renamed from: a */
    public static String m590a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("sname", str);
        return C0228ac.m468a((Map<String, String>) hashMap);
    }

    /* renamed from: a */
    public static String m591a(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("sname", str);
        hashMap.put("dversion", str2);
        return C0228ac.m468a((Map<String, String>) hashMap);
    }

    /* renamed from: a */
    public static String m592a(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("fname", str);
        hashMap.put("sname", str2);
        hashMap.put("dversion", str4);
        hashMap.put("version", str3);
        return C0228ac.m468a((Map<String, String>) hashMap);
    }

    /* renamed from: b */
    public static String m593b(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("fname", str);
        return C0228ac.m468a((Map<String, String>) hashMap);
    }

    /* renamed from: b */
    public static String m594b(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("sname", str);
        hashMap.put("status", str2);
        return C0228ac.m468a((Map<String, String>) hashMap);
    }

    /* renamed from: a */
    public String mo3706a() {
        return this.f340a;
    }

    /* renamed from: b */
    public String mo3707b() {
        return this.f341b;
    }

    /* renamed from: c */
    public String mo3708c() {
        return this.f343d;
    }

    /* renamed from: c */
    public void mo3709c(String str) {
        this.f345f = str;
    }

    /* renamed from: d */
    public String mo3710d() {
        return this.f344e;
    }

    /* renamed from: e */
    public String mo3711e() {
        return this.f345f;
    }
}
