package com.wanmei.push.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import com.igexin.sdk.PushConsts;
import com.wanmei.push.p100d.C1679c;
import com.wanmei.push.p100d.C1680d;
import com.wanmei.push.p104g.C1713e;
import com.wanmei.push.p104g.C1714f;

public class SystemStatusReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        C1714f.m6383c(context, "PERFECT_PUSH", "[" + context.getPackageName() + "] SystemStatusReceiver onReceive() Intent Action :[ " + intent.getAction() + " ]");
        if (PushConsts.ACTION_BROADCAST_TO_BOOT.equals(intent.getAction())) {
            C1679c.m6277a();
            if (C1679c.m6291g(context).equals(context.getApplicationContext().getPackageName())) {
                C1680d.m6296a(context.getApplicationContext()).mo9324b();
                C1714f.m6383c(context, "PERFECT_PUSH", "[" + context.getPackageName() + "] System Boot Completed, Start Push.");
            }
        } else if ("android.intent.action.PACKAGE_REMOVED".equals(intent.getAction())) {
            C1679c.m6277a();
            if (C1679c.m6291g(context).equals(C1713e.m6375a(intent))) {
                C1679c.m6277a();
                if (C1679c.m6292h(context).equals(context.getApplicationContext().getPackageName())) {
                    C1680d.m6296a(context.getApplicationContext()).mo9324b();
                    C1714f.m6383c(context, "PERFECT_PUSH", "[" + context.getPackageName() + "] Host Package [" + C1713e.m6375a(intent) + "] Removed, Successor Start Push.");
                }
            }
        } else if (PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(intent.getAction())) {
            C1679c.m6277a();
            if (C1679c.m6291g(context).equals(context.getApplicationContext().getPackageName())) {
                NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                if (networkInfo != null && networkInfo.isConnected()) {
                    C1680d.m6296a(context.getApplicationContext()).mo9324b();
                    C1714f.m6383c(context, "PERFECT_PUSH", "[" + context.getPackageName() + "] Connectivity Change Available, Start Push.");
                }
            }
        }
    }
}
