package com.igexin.push.extension.distribution.basic.p042c;

import android.os.Looper;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;

/* renamed from: com.igexin.push.extension.distribution.basic.c.k */
public class C0745k extends Thread {
    public void run() {
        if (Looper.myLooper() == null) {
            Looper.prepare();
            try {
                if (C0741g.m3010a() != null) {
                    C0741g.m3010a().mo5016a(new HandlerC0740f());
                }
                C0741g.m3010a().mo5020c();
            } catch (Throwable th) {
                ActivityC0460a.m1698b("ExtensionThread|" + th.toString());
            }
            Looper.loop();
        }
    }
}
