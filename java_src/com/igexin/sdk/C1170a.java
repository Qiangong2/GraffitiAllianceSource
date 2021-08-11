package com.igexin.sdk;

import android.app.Service;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.util.AbstractC1154d;

/* access modifiers changed from: package-private */
/* renamed from: com.igexin.sdk.a */
public class C1170a implements AbstractC1154d {

    /* renamed from: a */
    final /* synthetic */ Service f3056a;

    /* renamed from: b */
    final /* synthetic */ GTServiceManager f3057b;

    C1170a(GTServiceManager gTServiceManager, Service service) {
        this.f3057b = gTServiceManager;
        this.f3056a = service;
    }

    @Override // com.igexin.push.util.AbstractC1154d
    /* renamed from: a */
    public void mo5905a(boolean z) {
        ActivityC0460a.m1698b(GTServiceManager.TAG + "|load so error, report bi result = " + z + " ###########");
        this.f3056a.stopSelf();
    }
}
