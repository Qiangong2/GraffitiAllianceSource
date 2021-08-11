package com.igexin.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.sdk.p082a.C1174d;

public class PushReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f3053a = PushReceiver.class.getName();

    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction() != null) {
            try {
                String d = C0535e.m2034a().mo4399d("ss");
                if (d == null || !d.equals("1") || new C1174d(context).mo5972c()) {
                    String action = intent.getAction();
                    if (PushConsts.ACTION_BROADCAST_PUSHMANAGER.equals(action)) {
                        if (intent.getExtras() != null) {
                            Intent intent2 = new Intent(context.getApplicationContext(), C0535e.m2034a().mo4360a(context));
                            intent2.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_BROADCAST_PUSHMANAGER);
                            intent2.putExtra("bundle", intent.getExtras());
                            context.getApplicationContext().startService(intent2);
                        }
                    } else if (PushConsts.ACTION_BROADCAST_REFRESHLS.equals(action)) {
                        String stringExtra = intent.getStringExtra("callback_pkgname");
                        String stringExtra2 = intent.getStringExtra("callback_classname");
                        Intent intent3 = new Intent(context.getApplicationContext(), C0535e.m2034a().mo4360a(context));
                        intent3.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_BROADCAST_REFRESHLS);
                        intent3.putExtra("callback_pkgname", stringExtra);
                        intent3.putExtra("callback_classname", stringExtra2);
                        context.startService(intent3);
                    } else if (PushConsts.ACTION_BROADCAST_TO_BOOT.equals(action) || action.equals("android.intent.action.ACTION_POWER_CONNECTED") || action.equals("android.intent.action.ACTION_POWER_DISCONNECTED") || action.equals("android.intent.action.MEDIA_MOUNTED")) {
                        context.startService(new Intent(context.getApplicationContext(), C0535e.m2034a().mo4360a(context)));
                    } else if (PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(action) || PushConsts.ACTION_BROADCAST_USER_PRESENT.equals(action)) {
                        Intent intent4 = new Intent(context.getApplicationContext(), C0535e.m2034a().mo4360a(context));
                        intent4.putExtra(PushConsts.CMD_ACTION, action);
                        context.startService(intent4);
                    }
                }
            } catch (Throwable th) {
                ActivityC0460a.m1698b(f3053a + "|" + th.toString());
            }
        }
    }
}
