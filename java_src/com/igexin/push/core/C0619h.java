package com.igexin.push.core;

import android.os.Looper;

/* renamed from: com.igexin.push.core.h */
public class C0619h extends Thread {
    public void run() {
        Looper.prepare();
        if (C0617f.m2395a() != null) {
            C0617f.m2395a().mo4616a(new HandlerC0616e());
        }
        C0617f.m2395a().mo4622b();
        Looper.loop();
    }
}
