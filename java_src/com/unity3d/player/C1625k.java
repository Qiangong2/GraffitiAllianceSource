package com.unity3d.player;

import android.os.Build;
import java.lang.Thread;

/* renamed from: com.unity3d.player.k */
final class C1625k implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private volatile Thread.UncaughtExceptionHandler f4162a;

    C1625k() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized boolean mo9113a() {
        boolean z;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler == this) {
            z = false;
        } else {
            this.f4162a = defaultUncaughtExceptionHandler;
            Thread.setDefaultUncaughtExceptionHandler(this);
            z = true;
        }
        return z;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        try {
            Error error = new Error(String.format("FATAL EXCEPTION [%s]\n", thread.getName()) + String.format("Unity version     : %s\n", "5.6.5p4") + String.format("Device model      : %s %s\n", Build.MANUFACTURER, Build.MODEL) + String.format("Device fingerprint: %s\n", Build.FINGERPRINT));
            error.setStackTrace(new StackTraceElement[0]);
            error.initCause(th);
            this.f4162a.uncaughtException(thread, error);
        } catch (Throwable th2) {
            this.f4162a.uncaughtException(thread, th);
        }
        return;
    }
}
