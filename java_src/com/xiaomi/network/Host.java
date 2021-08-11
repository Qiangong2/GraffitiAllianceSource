package com.xiaomi.network;

import java.net.InetSocketAddress;

public final class Host {

    /* renamed from: a */
    private String f4907a;

    /* renamed from: b */
    private int f4908b;

    public Host(String str, int i) {
        this.f4907a = str;
        this.f4908b = i;
    }

    /* renamed from: a */
    public static Host m7054a(String str, int i) {
        int lastIndexOf = str.lastIndexOf(":");
        if (lastIndexOf != -1) {
            String substring = str.substring(0, lastIndexOf);
            try {
                int parseInt = Integer.parseInt(str.substring(lastIndexOf + 1));
                if (parseInt > 0) {
                    i = parseInt;
                }
                str = substring;
            } catch (NumberFormatException e) {
                str = substring;
            }
        }
        return new Host(str, i);
    }

    /* renamed from: b */
    public static InetSocketAddress m7055b(String str, int i) {
        Host a = m7054a(str, i);
        return new InetSocketAddress(a.mo10258b(), a.mo10257a());
    }

    /* renamed from: a */
    public int mo10257a() {
        return this.f4908b;
    }

    /* renamed from: b */
    public String mo10258b() {
        return this.f4907a;
    }

    public String toString() {
        return this.f4908b > 0 ? this.f4907a + ":" + this.f4908b : this.f4907a;
    }
}
