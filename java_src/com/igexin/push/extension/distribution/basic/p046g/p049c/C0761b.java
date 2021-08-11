package com.igexin.push.extension.distribution.basic.p046g.p049c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.extension.distribution.basic.p046g.C0752a;
import com.igexin.sdk.PushConsts;

/* renamed from: com.igexin.push.extension.distribution.basic.g.c.b */
public class C0761b extends BroadcastReceiver {

    /* renamed from: a */
    private static C0761b f2123a;

    /* renamed from: a */
    public static C0761b m3107a() {
        if (f2123a == null) {
            f2123a = new C0761b();
        }
        return f2123a;
    }

    public void onReceive(Context context, Intent intent) {
        NetworkInfo networkInfo;
        try {
            if (intent.getAction().equals(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE) && (networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo")) != null && networkInfo.isConnected()) {
                ActivityC0460a.m1697a("DownloadReceiver", "net Connected");
                C0752a.m3056a(context, "ext_download.db").mo5060b();
            }
        } catch (Throwable th) {
        }
    }
}
