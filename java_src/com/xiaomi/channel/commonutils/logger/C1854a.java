package com.xiaomi.channel.commonutils.logger;

import android.util.Log;

/* renamed from: com.xiaomi.channel.commonutils.logger.a */
public class C1854a implements LoggerInterface {

    /* renamed from: a */
    private String f4600a = "xiaomi";

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str) {
        Log.v(this.f4600a, str);
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str, Throwable th) {
        Log.v(this.f4600a, str, th);
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void setTag(String str) {
        this.f4600a = str;
    }
}
