package com.xiaomi.smack;

import java.util.Map;

/* renamed from: com.xiaomi.smack.b */
public class C2004b implements Cloneable {

    /* renamed from: b */
    public static String f5308b = "wcc-ml-test10.bj";

    /* renamed from: c */
    public static String f5309c = null;

    /* renamed from: a */
    private String f5310a;

    /* renamed from: d */
    private String f5311d;

    /* renamed from: e */
    private int f5312e;

    /* renamed from: f */
    private boolean f5313f = AbstractC2002a.f5288a;

    /* renamed from: g */
    private boolean f5314g = true;

    /* renamed from: h */
    private String f5315h;

    /* renamed from: i */
    private AbstractC2008e f5316i;

    public C2004b(Map<String, Integer> map, int i, String str, AbstractC2008e eVar) {
        m7514a(map, i, str, eVar);
    }

    /* renamed from: a */
    private void m7514a(Map<String, Integer> map, int i, String str, AbstractC2008e eVar) {
        this.f5311d = m7515b();
        this.f5312e = i;
        this.f5310a = str;
        this.f5316i = eVar;
    }

    /* renamed from: b */
    public static final String m7515b() {
        return f5309c != null ? f5309c : "app.chat.xiaomi.net";
    }

    /* renamed from: a */
    public void mo10525a(String str) {
        this.f5310a = str;
    }

    /* renamed from: a */
    public void mo10526a(boolean z) {
        this.f5313f = z;
    }

    /* renamed from: a */
    public byte[] mo10394a() {
        return null;
    }

    /* renamed from: b */
    public void mo10527b(String str) {
        this.f5315h = str;
    }

    /* renamed from: c */
    public String mo10528c() {
        return this.f5310a;
    }

    /* renamed from: c */
    public void mo10529c(String str) {
        this.f5311d = str;
    }

    /* renamed from: d */
    public String mo10530d() {
        return this.f5315h;
    }

    /* renamed from: e */
    public int mo10531e() {
        return this.f5312e;
    }

    /* renamed from: f */
    public String mo10532f() {
        return this.f5311d;
    }

    /* renamed from: g */
    public boolean mo10533g() {
        return this.f5313f;
    }
}
