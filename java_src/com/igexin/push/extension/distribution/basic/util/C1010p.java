package com.igexin.push.extension.distribution.basic.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import com.igexin.push.core.C0617f;
import com.igexin.push.core.C0618g;

/* renamed from: com.igexin.push.extension.distribution.basic.util.p */
public class C1010p {
    /* renamed from: a */
    public static void m4063a(NotificationManager notificationManager, int i, Notification notification) {
        try {
            if (C0997c.m4009e()) {
                ((Service) C0618g.f1635f).startForeground(i, notification);
                C0617f.m2395a().mo4619a(new C1011q(1000));
                return;
            }
            notificationManager.notify(i, notification);
        } catch (Throwable th) {
        }
    }
}
