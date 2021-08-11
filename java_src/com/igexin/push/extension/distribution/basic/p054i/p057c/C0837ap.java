package com.igexin.push.extension.distribution.basic.p054i.p057c;

import com.igexin.push.extension.distribution.basic.p054i.p055a.C0802j;
import com.igexin.push.extension.distribution.basic.p054i.p055a.C0803k;

/* renamed from: com.igexin.push.extension.distribution.basic.i.c.ap */
public class C0837ap {

    /* renamed from: a */
    private String f2346a;

    /* renamed from: b */
    private int f2347b = 0;

    public C0837ap(String str) {
        C0803k.m3393a((Object) str);
        this.f2346a = str;
    }

    /* renamed from: f */
    public static String m3625f(String str) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        char c = 0;
        while (i < length) {
            char c2 = charArray[i];
            if (c2 != '\\') {
                sb.append(c2);
            } else if (c != 0 && c == '\\') {
                sb.append(c2);
            }
            i++;
            c = c2;
        }
        return sb.toString();
    }

    /* renamed from: i */
    private int m3626i() {
        return this.f2346a.length() - this.f2347b;
    }

    /* renamed from: a */
    public String mo5452a(char c, char c2) {
        char c3 = 0;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (!mo5453a()) {
            Character valueOf = Character.valueOf(mo5462d());
            if (c3 == 0 || c3 != '\\') {
                if (valueOf.equals(Character.valueOf(c))) {
                    i++;
                } else if (valueOf.equals(Character.valueOf(c2))) {
                    i--;
                }
            }
            if (i > 0 && c3 != 0) {
                sb.append(valueOf);
            }
            c3 = valueOf.charValue();
            if (i <= 0) {
                break;
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public boolean mo5453a() {
        return m3626i() == 0;
    }

    /* renamed from: a */
    public boolean mo5454a(String str) {
        return this.f2346a.regionMatches(true, this.f2347b, str, 0, str.length());
    }

    /* renamed from: a */
    public boolean mo5455a(char... cArr) {
        if (mo5453a()) {
            return false;
        }
        for (char c : cArr) {
            if (this.f2346a.charAt(this.f2347b) == c) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo5456a(String... strArr) {
        for (String str : strArr) {
            if (mo5454a(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public String mo5457b(String... strArr) {
        int i = this.f2347b;
        while (!mo5453a() && !mo5456a(strArr)) {
            this.f2347b++;
        }
        return this.f2346a.substring(i, this.f2347b);
    }

    /* renamed from: b */
    public boolean mo5458b() {
        return !mo5453a() && C0802j.m3390b(this.f2346a.charAt(this.f2347b));
    }

    /* renamed from: b */
    public boolean mo5459b(String str) {
        if (!mo5454a(str)) {
            return false;
        }
        this.f2347b += str.length();
        return true;
    }

    /* renamed from: c */
    public void mo5460c(String str) {
        if (!mo5454a(str)) {
            throw new IllegalStateException("Queue did not match expected sequence");
        }
        int length = str.length();
        if (length > m3626i()) {
            throw new IllegalStateException("Queue not long enough to consume sequence");
        }
        this.f2347b = length + this.f2347b;
    }

    /* renamed from: c */
    public boolean mo5461c() {
        return !mo5453a() && Character.isLetterOrDigit(this.f2346a.charAt(this.f2347b));
    }

    /* renamed from: d */
    public char mo5462d() {
        String str = this.f2346a;
        int i = this.f2347b;
        this.f2347b = i + 1;
        return str.charAt(i);
    }

    /* renamed from: d */
    public String mo5463d(String str) {
        int indexOf = this.f2346a.indexOf(str, this.f2347b);
        if (indexOf == -1) {
            return mo5468h();
        }
        String substring = this.f2346a.substring(this.f2347b, indexOf);
        this.f2347b += substring.length();
        return substring;
    }

    /* renamed from: e */
    public String mo5464e(String str) {
        String d = mo5463d(str);
        mo5459b(str);
        return d;
    }

    /* renamed from: e */
    public boolean mo5465e() {
        boolean z = false;
        while (mo5458b()) {
            this.f2347b++;
            z = true;
        }
        return z;
    }

    /* renamed from: f */
    public String mo5466f() {
        int i = this.f2347b;
        while (!mo5453a() && (mo5461c() || mo5455a('|', '_', '-'))) {
            this.f2347b++;
        }
        return this.f2346a.substring(i, this.f2347b);
    }

    /* renamed from: g */
    public String mo5467g() {
        int i = this.f2347b;
        while (!mo5453a() && (mo5461c() || mo5455a('-', '_'))) {
            this.f2347b++;
        }
        return this.f2346a.substring(i, this.f2347b);
    }

    /* renamed from: h */
    public String mo5468h() {
        StringBuilder sb = new StringBuilder();
        while (!mo5453a()) {
            sb.append(mo5462d());
        }
        return sb.toString();
    }

    public String toString() {
        return this.f2346a.substring(this.f2347b);
    }
}
