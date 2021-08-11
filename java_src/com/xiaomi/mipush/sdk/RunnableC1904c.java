package com.xiaomi.mipush.sdk;

import com.xiaomi.channel.commonutils.string.C1873d;
import com.xiaomi.push.service.C1968f;
import com.xiaomi.xmpush.thrift.C2079i;
import com.xiaomi.xmpush.thrift.EnumC2064a;
import java.util.HashMap;

/* access modifiers changed from: package-private */
/* renamed from: com.xiaomi.mipush.sdk.c */
public final class RunnableC1904c implements Runnable {
    RunnableC1904c() {
    }

    public void run() {
        if (C1968f.m7323b(MiPushClient.sContext) != null) {
            C2079i iVar = new C2079i();
            iVar.mo10861b(C1900a.m6949a(MiPushClient.sContext).mo10176c());
            iVar.mo10864c("client_info_update");
            iVar.mo10855a(MiPushClient.generatePacketID());
            iVar.mo10856a(new HashMap());
            iVar.mo10872h().put("imei_md5", C1873d.m6782a(C1968f.m7323b(MiPushClient.sContext)));
            C1910g.m6998a(MiPushClient.sContext).mo10207a(iVar, EnumC2064a.Notification, false, null);
        }
    }
}
