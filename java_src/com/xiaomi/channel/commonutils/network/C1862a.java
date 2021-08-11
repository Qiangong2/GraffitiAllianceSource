package com.xiaomi.channel.commonutils.network;

/* renamed from: com.xiaomi.channel.commonutils.network.a */
public class C1862a implements AbstractC1864c {

    /* renamed from: a */
    private final String f4626a;

    /* renamed from: b */
    private final String f4627b;

    public C1862a(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.f4626a = str;
        this.f4627b = str2;
    }

    @Override // com.xiaomi.channel.commonutils.network.AbstractC1864c
    /* renamed from: a */
    public String mo9936a() {
        return this.f4626a;
    }

    @Override // com.xiaomi.channel.commonutils.network.AbstractC1864c
    /* renamed from: b */
    public String mo9937b() {
        return this.f4627b;
    }
}
