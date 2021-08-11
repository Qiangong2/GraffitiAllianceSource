package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import java.util.List;

/* access modifiers changed from: package-private */
/* renamed from: com.xiaomi.mipush.sdk.d */
public final class RunnableC1905d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f4869a;

    RunnableC1905d(Context context) {
        this.f4869a = context;
    }

    public void run() {
        if (!MiPushClient.shouldUseMIUIPush(this.f4869a) && 1 == C1900a.m6949a(this.f4869a).mo10186m()) {
            try {
                List<PackageInfo> installedPackages = this.f4869a.getPackageManager().getInstalledPackages(4);
                if (installedPackages != null) {
                    for (PackageInfo packageInfo : installedPackages) {
                        ServiceInfo[] serviceInfoArr = packageInfo.services;
                        if (serviceInfoArr != null) {
                            for (ServiceInfo serviceInfo : serviceInfoArr) {
                                if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !this.f4869a.getPackageName().equals(serviceInfo.packageName)) {
                                    try {
                                        Thread.sleep(((long) ((Math.random() * 2.0d) + 1.0d)) * 1000);
                                    } catch (InterruptedException e) {
                                    }
                                    Intent intent = new Intent();
                                    intent.setClassName(serviceInfo.packageName, serviceInfo.name);
                                    intent.setAction("com.xiaomi.mipush.sdk.WAKEUP");
                                    this.f4869a.startService(intent);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
    }
}
