package com.igexin.assist.action;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.igexin.assist.MessageBean;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.core.p029b.C0564c;
import com.igexin.push.core.p029b.C0568g;
import com.igexin.push.util.C1167q;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.message.GTTransmitMessage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageManger {

    /* renamed from: a */
    private ExecutorService f1011a;

    private MessageManger() {
        this.f1011a = Executors.newSingleThreadExecutor();
    }

    /* renamed from: a */
    private Class m1550a(Context context) {
        try {
            String str = (String) C1167q.m4793b(context, "uis", "");
            if (!TextUtils.isEmpty(str)) {
                return Class.forName(str);
            }
        } catch (Throwable th) {
        }
        return null;
    }

    /* access modifiers changed from: public */
    /* renamed from: a */
    private void m1553a(C0430d dVar, Context context) {
        if (dVar != null && context != null) {
            try {
                C0564c cVar = new C0564c(context);
                if (!cVar.mo4434a(dVar.mo4106c())) {
                    cVar.mo4435b(dVar.mo4106c());
                    Class a = m1550a(context);
                    if (a != null) {
                        Intent intent = new Intent(context, a);
                        Bundle bundle = new Bundle();
                        bundle.putInt(PushConsts.CMD_ACTION, PushConsts.GET_MSG_DATA);
                        bundle.putSerializable(PushConsts.KEY_MESSAGE_DATA, new GTTransmitMessage(dVar.mo4106c(), dVar.mo4107d(), dVar.mo4107d() + ":" + dVar.mo4106c(), dVar.mo4105b()));
                        intent.putExtras(bundle);
                        context.startService(intent);
                        return;
                    }
                    Intent intent2 = new Intent();
                    if (Build.VERSION.SDK_INT >= 12) {
                        intent2.addFlags(32);
                    }
                    intent2.setAction("com.igexin.sdk.action." + dVar.mo4108e());
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt(PushConsts.CMD_ACTION, PushConsts.GET_MSG_DATA);
                    bundle2.putString("taskid", dVar.mo4106c());
                    bundle2.putString("messageid", dVar.mo4107d());
                    bundle2.putString("appid", dVar.mo4108e());
                    bundle2.putString("payloadid", dVar.mo4107d() + ":" + dVar.mo4106c());
                    bundle2.putString("packagename", dVar.mo4110g());
                    bundle2.putByteArray(AssistPushConsts.MSG_TYPE_PAYLOAD, dVar.mo4105b());
                    intent2.putExtras(bundle2);
                    context.sendBroadcast(intent2);
                }
            } catch (Throwable th) {
            }
        }
    }

    /* access modifiers changed from: public */
    /* renamed from: a */
    private void m1554a(String str) {
        try {
            if (!TextUtils.isEmpty(str) && C0618g.f1636g.get() && !str.equals(C0618g.f1654y)) {
                Log.e("Assist_MessageManger", "other token = " + str);
                C0568g.m2192a().mo4453c(str);
                if (C0618g.f1641l) {
                    C0535e.m2034a().mo4408j();
                }
            }
        } catch (Throwable th) {
        }
    }

    public static MessageManger getInstance() {
        return C0429c.f1014a;
    }

    public void addMessage(MessageBean messageBean) {
        if (this.f1011a != null) {
            this.f1011a.execute(new C0428b(this, messageBean));
        }
    }
}
