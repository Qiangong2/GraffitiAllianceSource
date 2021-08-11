package com.xiaomi.push.service;

import com.tencent.gcloud.voice.GCloudVoiceErrno;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.push.service.XMPushService;

/* renamed from: com.xiaomi.push.service.ad */
class C1949ad {

    /* renamed from: e */
    private static int f5035e = GCloudVoiceErrno.GCLOUD_VOICE_TVE_CREATE;

    /* renamed from: a */
    private XMPushService f5036a;

    /* renamed from: b */
    private int f5037b;

    /* renamed from: c */
    private long f5038c;

    /* renamed from: d */
    private int f5039d = 0;

    public C1949ad(XMPushService xMPushService) {
        this.f5036a = xMPushService;
        this.f5037b = 10;
        this.f5038c = 0;
    }

    /* renamed from: b */
    private int m7265b() {
        int i = 40;
        if (this.f5039d > 8) {
            return GCloudVoiceErrno.GCLOUD_VOICE_TVE_CREATE;
        }
        if (this.f5039d > 4) {
            return 60;
        }
        if (this.f5039d >= 1) {
            return 10;
        }
        if (this.f5038c == 0) {
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f5038c;
        if (currentTimeMillis < 300000) {
            if (this.f5037b >= f5035e) {
                return this.f5037b;
            }
            int i2 = this.f5037b;
            this.f5037b = (int) (((double) this.f5037b) * 1.5d);
            return i2;
        } else if (currentTimeMillis < 900000) {
            if (this.f5037b < 40) {
                i = this.f5037b;
            }
            this.f5037b = i;
            return this.f5037b;
        } else if (currentTimeMillis < 1800000) {
            this.f5037b = this.f5037b < 20 ? this.f5037b : 20;
            return this.f5037b;
        } else {
            this.f5037b = 10;
            return this.f5037b;
        }
    }

    /* renamed from: a */
    public void mo10385a() {
        this.f5038c = System.currentTimeMillis();
        this.f5036a.mo10348a(1);
        this.f5039d = 0;
    }

    /* renamed from: a */
    public void mo10386a(boolean z) {
        if (!this.f5036a.mo10359a()) {
            AbstractC1855b.m6722c("should not reconnect as no client or network.");
        } else if (z) {
            this.f5036a.mo10348a(1);
            XMPushService xMPushService = this.f5036a;
            XMPushService xMPushService2 = this.f5036a;
            xMPushService2.getClass();
            xMPushService.mo10350a(new XMPushService.C1935c());
            this.f5039d++;
        } else if (!this.f5036a.mo10364b(1)) {
            int b = m7265b();
            AbstractC1855b.m6718a("schedule reconnect in " + b + "s");
            XMPushService xMPushService3 = this.f5036a;
            XMPushService xMPushService4 = this.f5036a;
            xMPushService4.getClass();
            xMPushService3.mo10351a(new XMPushService.C1935c(), (long) (b * 1000));
            this.f5039d++;
            if (this.f5039d == 3) {
                C1985u.m7402a();
            }
        }
    }
}
