package com.amap.loc;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.amap.loc.al */
/* compiled from: LogInfo */
public abstract class AbstractC0238al {
    @AbstractC0230ae(mo3653a = "b2", mo3654b = 2)

    /* renamed from: a */
    protected int f290a = -1;
    @AbstractC0230ae(mo3653a = "b1", mo3654b = 6)

    /* renamed from: b */
    protected String f291b;
    @AbstractC0230ae(mo3653a = "b3", mo3654b = 2)

    /* renamed from: c */
    protected int f292c = 1;
    @AbstractC0230ae(mo3653a = "a1", mo3654b = 6)

    /* renamed from: d */
    private String f293d;

    /* renamed from: c */
    public static String m497c(int i) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("b2").append(SimpleComparison.EQUAL_TO_OPERATION).append(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    /* renamed from: c */
    public static String m498c(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("b1", str);
        return C0228ac.m468a((Map<String, String>) hashMap);
    }

    /* renamed from: a */
    public int mo3665a() {
        return this.f290a;
    }

    /* renamed from: a */
    public void mo3666a(int i) {
        this.f290a = i;
    }

    /* renamed from: a */
    public void mo3667a(String str) {
        this.f291b = str;
    }

    /* renamed from: b */
    public String mo3668b() {
        return this.f291b;
    }

    /* renamed from: b */
    public void mo3669b(int i) {
        this.f292c = i;
    }

    /* renamed from: b */
    public void mo3670b(String str) {
        this.f293d = C0363r.m1359b(str);
    }

    /* renamed from: c */
    public int mo3671c() {
        return this.f292c;
    }
}
