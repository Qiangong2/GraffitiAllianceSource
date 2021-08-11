package com.igexin.push.extension.distribution.basic.p042c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;

/* renamed from: com.igexin.push.extension.distribution.basic.c.i */
public class C0743i extends BroadcastReceiver {

    /* renamed from: a */
    private static C0743i f2041a;

    /* renamed from: a */
    public static C0743i m3029a() {
        if (f2041a == null) {
            f2041a = new C0743i();
        }
        return f2041a;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (C0741g.m3010a() == null) {
            return;
        }
        if (action.equals("com.igexin.sdk.action.INSTALL") || action.equals("android.intent.action.PACKAGE_ADDED") || action.equals("android.intent.action.PACKAGE_REMOVED")) {
            Message message = new Message();
            message.what = C0735a.f2012a;
            message.obj = intent;
            C0741g.m3010a().mo5017a(message);
        } else if (action.equals("com.igexin.sdk.action.notification.burying.point")) {
            String stringExtra = intent.getStringExtra("checkpackage");
            String stringExtra2 = intent.getStringExtra("accesstoken");
            if (stringExtra != null && stringExtra2 != null && stringExtra.equals(C0618g.f1635f.getPackageName()) && stringExtra2.equals(C0744j.f2045d)) {
                intent.setAction("com.igexin.sdk.action.doaction");
                intent.putExtra("accesstoken", C0618g.f1622ar);
                C0618g.f1635f.sendBroadcast(intent);
                PushTaskBean pushTaskBean = new PushTaskBean();
                pushTaskBean.setAppid(intent.getStringExtra("appid"));
                pushTaskBean.setMessageId(intent.getStringExtra("messageid"));
                pushTaskBean.setTaskId(intent.getStringExtra("taskid"));
                pushTaskBean.setId(intent.getStringExtra("id"));
                pushTaskBean.setAppKey(C0618g.f1631b);
                try {
                    int parseInt = Integer.parseInt(intent.getStringExtra("feedbackid")) + 30010;
                    pushTaskBean.setCurrentActionid(parseInt);
                    C0535e.m2034a().mo4369a(pushTaskBean, parseInt + "", intent.getBooleanExtra("isFloat", false) ? "notifyFloat:" + intent.getStringExtra("bigStyle") : "notifyStyle:" + intent.getStringExtra("notifyStyle"));
                } catch (Exception e) {
                }
            }
        }
    }
}
