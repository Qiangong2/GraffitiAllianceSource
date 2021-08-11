package com.amap.loc;

import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.amap.loc.aq */
/* compiled from: DexDownloadItem */
public class C0243aq {

    /* renamed from: a */
    String f307a;

    /* renamed from: b */
    String f308b;

    /* renamed from: c */
    String f309c;

    /* renamed from: d */
    String f310d;

    /* renamed from: e */
    String f311e;

    /* renamed from: f */
    int f312f;

    /* renamed from: g */
    int f313g;

    /* renamed from: h */
    private String f314h;

    /* renamed from: i */
    private String f315i;

    public C0243aq(String str, String str2, String str3) {
        this.f314h = str;
        this.f315i = str2;
        try {
            String[] split = str.split(MqttTopic.TOPIC_LEVEL_SEPARATOR);
            int length = split.length;
            if (length > 1) {
                this.f307a = split[length - 1];
                String[] split2 = this.f307a.split("_");
                this.f308b = split2[0];
                this.f309c = split2[2];
                this.f310d = split2[1];
                this.f312f = Integer.parseInt(split2[3]);
                this.f313g = Integer.parseInt(split2[4].split("\\.")[0]);
            }
        } catch (Throwable th) {
            C0263ba.m657a(th, "DexDownloadItem", "DexDownloadItem");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo3689a() {
        return this.f314h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo3690b() {
        return this.f315i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo3691c() {
        return this.f309c;
    }
}
