package com.igexin.push.extension.distribution.basic.p054i.p057c;

import com.igexin.push.extension.distribution.basic.p054i.p055a.C0803k;
import com.tencent.qcloud.core.util.IOUtils;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.push.extension.distribution.basic.i.c.a */
public class C0821a {

    /* renamed from: a */
    private final String f2303a;

    /* renamed from: b */
    private final int f2304b;

    /* renamed from: c */
    private int f2305c = 0;

    /* renamed from: d */
    private int f2306d = 0;

    C0821a(String str) {
        C0803k.m3393a((Object) str);
        String replaceAll = str.replaceAll("\r\n?", IOUtils.LINE_SEPARATOR_UNIX);
        this.f2303a = replaceAll;
        this.f2304b = replaceAll.length();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5376a() {
        return this.f2305c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo5377a(char c) {
        int indexOf = this.f2303a.indexOf(c, this.f2305c);
        if (indexOf == -1) {
            return mo5394i();
        }
        String substring = this.f2303a.substring(this.f2305c, indexOf);
        this.f2305c += substring.length();
        return substring;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo5378a(String str) {
        int indexOf = this.f2303a.indexOf(str, this.f2305c);
        if (indexOf == -1) {
            return mo5394i();
        }
        String substring = this.f2303a.substring(this.f2305c, indexOf);
        this.f2305c += substring.length();
        return substring;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo5379a(char... cArr) {
        int i = this.f2305c;
        loop0:
        while (!mo5380b()) {
            char charAt = this.f2303a.charAt(this.f2305c);
            for (char c : cArr) {
                if (c == charAt) {
                    break loop0;
                }
            }
            this.f2305c++;
        }
        return this.f2305c > i ? this.f2303a.substring(i, this.f2305c) : "";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo5380b() {
        return this.f2305c >= this.f2304b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo5381b(char c) {
        return !mo5380b() && this.f2303a.charAt(this.f2305c) == c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo5382b(String str) {
        return this.f2303a.startsWith(str, this.f2305c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo5383b(char... cArr) {
        if (mo5380b()) {
            return false;
        }
        char charAt = this.f2303a.charAt(this.f2305c);
        for (char c : cArr) {
            if (c == charAt) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public char mo5384c() {
        if (mo5380b()) {
            return 65535;
        }
        return this.f2303a.charAt(this.f2305c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo5385c(String str) {
        return this.f2303a.regionMatches(true, this.f2305c, str, 0, str.length());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public char mo5386d() {
        char charAt = mo5380b() ? 65535 : this.f2303a.charAt(this.f2305c);
        this.f2305c++;
        return charAt;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo5387d(String str) {
        if (!mo5382b(str)) {
            return false;
        }
        this.f2305c += str.length();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo5388e() {
        this.f2305c--;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo5389e(String str) {
        if (!mo5385c(str)) {
            return false;
        }
        this.f2305c += str.length();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo5390f() {
        this.f2305c++;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo5391f(String str) {
        return this.f2303a.indexOf(str.toLowerCase(), this.f2305c) > -1 || this.f2303a.indexOf(str.toUpperCase(), this.f2305c) > -1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo5392g() {
        this.f2306d = this.f2305c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo5393h() {
        this.f2305c = this.f2306d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public String mo5394i() {
        String substring = this.f2303a.substring(this.f2305c, this.f2303a.length());
        this.f2305c = this.f2303a.length();
        return substring;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public String mo5395j() {
        int i = this.f2305c;
        while (!mo5380b() && (((r1 = this.f2303a.charAt(this.f2305c)) >= 'A' && r1 <= 'Z') || (r1 >= 'a' && r1 <= 'z'))) {
            this.f2305c++;
        }
        return this.f2303a.substring(i, this.f2305c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public String mo5396k() {
        int i = this.f2305c;
        while (!mo5380b() && (((r1 = this.f2303a.charAt(this.f2305c)) >= 'A' && r1 <= 'Z') || (r1 >= 'a' && r1 <= 'z'))) {
            this.f2305c++;
        }
        while (!mo5380b() && (r1 = this.f2303a.charAt(this.f2305c)) >= '0' && r1 <= '9') {
            this.f2305c++;
        }
        return this.f2303a.substring(i, this.f2305c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public String mo5397l() {
        int i = this.f2305c;
        while (!mo5380b() && (((r1 = this.f2303a.charAt(this.f2305c)) >= '0' && r1 <= '9') || ((r1 >= 'A' && r1 <= 'F') || (r1 >= 'a' && r1 <= 'f')))) {
            this.f2305c++;
        }
        return this.f2303a.substring(i, this.f2305c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public String mo5398m() {
        int i = this.f2305c;
        while (!mo5380b() && (r1 = this.f2303a.charAt(this.f2305c)) >= '0' && r1 <= '9') {
            this.f2305c++;
        }
        return this.f2303a.substring(i, this.f2305c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public boolean mo5399n() {
        if (mo5380b()) {
            return false;
        }
        char charAt = this.f2303a.charAt(this.f2305c);
        return (charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z');
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public boolean mo5400o() {
        char charAt;
        return !mo5380b() && (charAt = this.f2303a.charAt(this.f2305c)) >= '0' && charAt <= '9';
    }

    public String toString() {
        return this.f2303a.substring(this.f2305c);
    }
}
