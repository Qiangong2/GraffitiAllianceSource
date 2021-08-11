package com.igexin.push.extension.distribution.basic.p054i.p057c;

import com.igexin.push.extension.distribution.basic.p054i.p055a.C0803k;
import com.umeng.analytics.C1370a;
import com.umeng.analytics.p091b.C1447g;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.igexin.push.extension.distribution.basic.i.c.ae */
public class C0826ae {

    /* renamed from: a */
    private static final Map<String, C0826ae> f2313a = new HashMap();

    /* renamed from: j */
    private static final String[] f2314j = {"html", "head", C1370a.f3234z, "frameset", "script", "noscript", C1447g.f3452P, "meta", "link", "title", "frame", "noframes", "section", "nav", "aside", "hgroup", C1370a.f3205A, "footer", "p", "h1", "h2", "h3", "h4", "h5", "h6", "ul", "ol", "pre", "div", "blockquote", "hr", "address", "figure", "figcaption", "form", "fieldset", "ins", "del", "dl", "dt", "dd", "li", "table", "caption", "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", "td", "video", "audio", "canvas", "details", "menu", "plaintext"};

    /* renamed from: k */
    private static final String[] f2315k = {"object", "base", "font", "tt", "i", "b", "u", "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", "a", "img", "br", "wbr", "map", "q", "sub", "sup", "bdo", "iframe", "embed", "span", "input", "select", "textarea", "label", "button", "optgroup", "option", "legend", "datalist", "keygen", "output", "progress", "meter", "area", "param", "source", "track", "summary", "command", "device"};

    /* renamed from: l */
    private static final String[] f2316l = {"meta", "link", "base", "frame", "img", "br", "wbr", "embed", "hr", "input", "keygen", "col", "command", "device"};

    /* renamed from: m */
    private static final String[] f2317m = {"title", "a", "p", "h1", "h2", "h3", "h4", "h5", "h6", "pre", "address", "li", "th", "td", "script", C1447g.f3452P};

    /* renamed from: n */
    private static final String[] f2318n = {"pre", "plaintext", "title"};

    /* renamed from: b */
    private String f2319b;

    /* renamed from: c */
    private boolean f2320c = true;

    /* renamed from: d */
    private boolean f2321d = true;

    /* renamed from: e */
    private boolean f2322e = true;

    /* renamed from: f */
    private boolean f2323f = true;

    /* renamed from: g */
    private boolean f2324g = false;

    /* renamed from: h */
    private boolean f2325h = false;

    /* renamed from: i */
    private boolean f2326i = false;

    static {
        for (String str : f2314j) {
            m3584a(new C0826ae(str));
        }
        for (String str2 : f2315k) {
            C0826ae aeVar = new C0826ae(str2);
            aeVar.f2320c = false;
            aeVar.f2322e = false;
            aeVar.f2321d = false;
            m3584a(aeVar);
        }
        for (String str3 : f2316l) {
            C0826ae aeVar2 = f2313a.get(str3);
            C0803k.m3393a(aeVar2);
            aeVar2.f2322e = false;
            aeVar2.f2323f = false;
            aeVar2.f2324g = true;
        }
        for (String str4 : f2317m) {
            C0826ae aeVar3 = f2313a.get(str4);
            C0803k.m3393a(aeVar3);
            aeVar3.f2321d = false;
        }
        for (String str5 : f2318n) {
            C0826ae aeVar4 = f2313a.get(str5);
            C0803k.m3393a(aeVar4);
            aeVar4.f2326i = true;
        }
    }

    private C0826ae(String str) {
        this.f2319b = str.toLowerCase();
    }

    /* renamed from: a */
    private static C0826ae m3584a(C0826ae aeVar) {
        synchronized (f2313a) {
            f2313a.put(aeVar.f2319b, aeVar);
        }
        return aeVar;
    }

    /* renamed from: a */
    public static C0826ae m3585a(String str) {
        C0826ae aeVar;
        C0803k.m3393a((Object) str);
        String lowerCase = str.trim().toLowerCase();
        C0803k.m3395a(lowerCase);
        synchronized (f2313a) {
            aeVar = f2313a.get(lowerCase);
            if (aeVar == null) {
                aeVar = new C0826ae(lowerCase);
                aeVar.f2320c = false;
                aeVar.f2322e = true;
            }
        }
        return aeVar;
    }

    /* renamed from: b */
    public static boolean m3586b(String str) {
        return f2313a.containsKey(str);
    }

    /* renamed from: a */
    public String mo5408a() {
        return this.f2319b;
    }

    /* renamed from: b */
    public boolean mo5409b() {
        return this.f2320c;
    }

    /* renamed from: c */
    public boolean mo5410c() {
        return this.f2321d;
    }

    /* renamed from: d */
    public boolean mo5411d() {
        return this.f2324g || this.f2325h;
    }

    /* renamed from: e */
    public boolean mo5412e() {
        return f2313a.containsKey(this.f2319b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0826ae)) {
            return false;
        }
        C0826ae aeVar = (C0826ae) obj;
        if (this.f2322e != aeVar.f2322e) {
            return false;
        }
        if (this.f2323f != aeVar.f2323f) {
            return false;
        }
        if (this.f2324g != aeVar.f2324g) {
            return false;
        }
        if (this.f2321d != aeVar.f2321d) {
            return false;
        }
        if (this.f2320c != aeVar.f2320c) {
            return false;
        }
        if (this.f2326i != aeVar.f2326i) {
            return false;
        }
        if (this.f2325h != aeVar.f2325h) {
            return false;
        }
        return this.f2319b.equals(aeVar.f2319b);
    }

    /* renamed from: f */
    public boolean mo5414f() {
        return this.f2326i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public C0826ae mo5415g() {
        this.f2325h = true;
        return this;
    }

    public int hashCode() {
        int i = 1;
        int hashCode = ((this.f2325h ? 1 : 0) + (((this.f2324g ? 1 : 0) + (((this.f2323f ? 1 : 0) + (((this.f2322e ? 1 : 0) + (((this.f2321d ? 1 : 0) + (((this.f2320c ? 1 : 0) + (this.f2319b.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (!this.f2326i) {
            i = 0;
        }
        return hashCode + i;
    }

    public String toString() {
        return this.f2319b;
    }
}
