package com.xiaomi.channel.commonutils.network;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.channel.commonutils.network.b */
public class C1863b {

    /* renamed from: a */
    public int f4628a;

    /* renamed from: b */
    public Map<String, String> f4629b = new HashMap();

    /* renamed from: c */
    public String f4630c;

    /* renamed from: a */
    public String mo9938a() {
        return this.f4630c;
    }

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", Integer.valueOf(this.f4628a), this.f4629b.toString(), this.f4630c);
    }
}
