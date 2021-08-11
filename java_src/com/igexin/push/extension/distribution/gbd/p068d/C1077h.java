package com.igexin.push.extension.distribution.gbd.p068d;

import android.os.Looper;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;

/* renamed from: com.igexin.push.extension.distribution.gbd.d.h */
public class C1077h extends Thread {
    public void run() {
        Thread.currentThread().setName("GBD-Thread");
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        try {
            if (C1069c.f2826c == null) {
                C1069c.f2826c = new HandlerC1070a();
            }
            C1071b.m4348a().mo5794b();
        } catch (Throwable th) {
            C1115d.m4558a(th);
            C1115d.m4559b("GBDThread", th.toString());
        }
        Looper.loop();
    }
}
