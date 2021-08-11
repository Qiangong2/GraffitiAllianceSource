package com.igexin.push.core;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.igexin.assist.sdk.AssistPushManager;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.config.C0514k;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.p079f.p081b.C1149g;
import com.igexin.push.util.C1151a;
import com.igexin.sdk.PushConsts;

/* renamed from: com.igexin.push.core.e */
public class HandlerC0616e extends Handler {

    /* renamed from: a */
    private static String f1560a = HandlerC0616e.class.getName();

    /* renamed from: a */
    private void m2393a() {
        C0618g.f1584I = System.currentTimeMillis();
        boolean z = true;
        if (C1151a.m4739a(System.currentTimeMillis()) && "1".equals(C0535e.m2034a().mo4399d("ccs"))) {
            z = false;
        }
        if (z) {
            C0535e.m2034a().mo4422x();
        }
        if (C0618g.f1579D > C0514k.f1331w) {
            long j = C0514k.f1331w / 10;
            long random = ((long) (((Math.random() * ((double) j)) * 2.0d) - ((double) j))) + (C0514k.f1331w / 2);
            ActivityC0460a.m1698b(f1560a + "|userPresent, reConnectDelayTime = " + C0514k.f1331w + ", resetDelay = " + random);
            C0618g.f1579D = random;
            C1149g.m4727g().mo5903h();
        }
    }

    /* renamed from: a */
    private void m2394a(Intent intent) {
        Intent intent2;
        String stringExtra = intent.getStringExtra(PushConsts.CMD_ACTION);
        if (stringExtra.equals(PushConsts.ACTION_SERVICE_INITIALIZE)) {
            C0535e.m2034a().mo4365a(intent);
        } else if (stringExtra.equals(PushConsts.ACTION_SERVICE_INITIALIZE_SLAVE)) {
            C0535e.m2034a().mo4385b(intent);
            AssistPushManager.getInstance().turnOnPush(C0618g.f1635f);
        } else if (stringExtra.equals(PushConsts.ACTION_BROADCAST_PUSHMANAGER)) {
            C0535e.m2034a().mo4366a(intent.getBundleExtra("bundle"));
        } else if (stringExtra.equals(PushConsts.ACTION_BROADCAST_USER_PRESENT)) {
            m2393a();
        } else if (stringExtra.equals(PushConsts.ACTION_BROADCAST_NOTIFICATION_CLICK) && (intent2 = (Intent) intent.getParcelableExtra("broadcast_intent")) != null) {
            C0618g.f1635f.sendBroadcast(intent2);
        }
    }

    public void handleMessage(Message message) {
        try {
            if (message.obj != null) {
                if (message.what == C0519a.f1339c) {
                    Intent intent = (Intent) message.obj;
                    if (intent.hasExtra(PushConsts.CMD_ACTION)) {
                        m2394a(intent);
                    }
                } else if (message.what == C0519a.f1340d) {
                    C0535e.m2034a().mo4394c((Intent) message.obj);
                } else if (message.what == C0519a.f1341e) {
                    C0535e.m2034a().mo4394c((Intent) message.obj);
                } else if (message.what == C0519a.f1343g) {
                    Bundle bundle = (Bundle) message.obj;
                    String string = bundle.getString("taskid");
                    String string2 = bundle.getString("messageid");
                    String string3 = bundle.getString("actionid");
                    ActivityC0460a.m1698b(f1560a + "|hand execute_action taskid = " + string + ", actionid = " + string3);
                    C0535e.m2034a().mo4391b(string, string2, string3);
                } else if (message.what == C0519a.f1346j) {
                    C0535e.m2034a().mo4400d((Intent) message.obj);
                } else {
                    if (message.what == C0519a.f1342f) {
                    }
                }
            } else if (message.what == C0519a.f1345i) {
                C0535e.m2034a().mo4417s();
            }
        } catch (Throwable th) {
            ActivityC0460a.m1698b(f1560a + "|" + th.toString());
        }
    }
}
