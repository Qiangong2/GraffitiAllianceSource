package com.xiaomi.push.log;

import com.xiaomi.channel.commonutils.logger.LoggerInterface;

/* renamed from: com.xiaomi.push.log.e */
public class C1925e implements LoggerInterface {

    /* renamed from: a */
    private LoggerInterface f4960a = null;

    /* renamed from: b */
    private LoggerInterface f4961b = null;

    public C1925e(LoggerInterface loggerInterface, LoggerInterface loggerInterface2) {
        this.f4960a = loggerInterface;
        this.f4961b = loggerInterface2;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str) {
        if (this.f4960a != null) {
            this.f4960a.log(str);
        }
        if (this.f4961b != null) {
            this.f4961b.log(str);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str, Throwable th) {
        if (this.f4960a != null) {
            this.f4960a.log(str, th);
        }
        if (this.f4961b != null) {
            this.f4961b.log(str, th);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void setTag(String str) {
    }
}
