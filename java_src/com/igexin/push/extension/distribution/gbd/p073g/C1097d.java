package com.igexin.push.extension.distribution.gbd.p073g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.push.extension.distribution.gbd.p066b.C1066i;
import com.igexin.push.extension.distribution.gbd.p076i.C1113b;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.extension.distribution.gbd.p077j.AbstractC1134c;
import com.igexin.push.extension.distribution.gbd.p077j.C1133b;
import com.igexin.push.extension.distribution.gbd.p077j.C1135d;
import com.igexin.sdk.PushConsts;

/* renamed from: com.igexin.push.extension.distribution.gbd.g.d */
public class C1097d extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras.containsKey(PushConsts.CMD_ACTION) && extras.containsKey(AssistPushConsts.MSG_TYPE_PAYLOAD)) {
            try {
                String string = extras.getString("taskid");
                String string2 = extras.getString("messageid");
                C1066i a = C1135d.m4650a(new String(extras.getByteArray(AssistPushConsts.MSG_TYPE_PAYLOAD)));
                AbstractC1134c a2 = C1133b.m4647a(a);
                if (a2 != null && a2.mo5892a()) {
                    a2.mo5891a(a);
                }
                C1113b.m4554a(string, string2, "20010");
            } catch (Exception e) {
                C1115d.m4558a(e);
                C1115d.m4559b("GBD_TransmissionReceiver", e.toString());
            }
        }
    }
}
