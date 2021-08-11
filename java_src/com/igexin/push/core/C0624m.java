package com.igexin.push.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;

/* renamed from: com.igexin.push.core.m */
public class C0624m extends BroadcastReceiver {

    /* renamed from: a */
    private static C0624m f1672a;

    private C0624m() {
    }

    /* renamed from: a */
    public static C0624m m2442a() {
        if (f1672a == null) {
            f1672a = new C0624m();
        }
        return f1672a;
    }

    public void onReceive(Context context, Intent intent) {
        if (C0617f.m2395a() != null) {
            Message message = new Message();
            message.what = C0519a.f1340d;
            message.obj = intent;
            C0617f.m2395a().mo4618a(message);
        }
    }
}
