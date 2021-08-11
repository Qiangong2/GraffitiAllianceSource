package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.push.service.C1987w;
import com.xiaomi.smack.packet.AbstractC2028d;
import com.xiaomi.smack.packet.C2025b;
import com.xiaomi.smack.packet.C2027c;
import com.xiaomi.smack.packet.C2030f;

/* renamed from: com.xiaomi.push.service.b */
public class C1964b {

    /* renamed from: a */
    private C1974l f5063a = new C1974l();

    /* renamed from: a */
    public static String m7303a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }

    /* renamed from: a */
    private static void m7304a(Context context, Intent intent, String str) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, m7303a(str));
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0035  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.xiaomi.push.service.C1987w.C1989b mo10398a(com.xiaomi.smack.packet.AbstractC2028d r7) {
        /*
            r6 = this;
            r1 = 0
            com.xiaomi.push.service.w r0 = com.xiaomi.push.service.C1987w.m7406a()
            java.lang.String r2 = r7.mo10611l()
            java.util.Collection r0 = r0.mo10439c(r2)
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x0015
            r0 = r1
        L_0x0014:
            return r0
        L_0x0015:
            java.util.Iterator r2 = r0.iterator()
            int r0 = r0.size()
            r3 = 1
            if (r0 != r3) goto L_0x0027
            java.lang.Object r0 = r2.next()
            com.xiaomi.push.service.w$b r0 = (com.xiaomi.push.service.C1987w.C1989b) r0
            goto L_0x0014
        L_0x0027:
            java.lang.String r3 = r7.mo10615n()
            java.lang.String r4 = r7.mo10613m()
        L_0x002f:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x004c
            java.lang.Object r0 = r2.next()
            com.xiaomi.push.service.w$b r0 = (com.xiaomi.push.service.C1987w.C1989b) r0
            java.lang.String r5 = r0.f5128b
            boolean r5 = android.text.TextUtils.equals(r3, r5)
            if (r5 != 0) goto L_0x0014
            java.lang.String r5 = r0.f5128b
            boolean r5 = android.text.TextUtils.equals(r4, r5)
            if (r5 == 0) goto L_0x002f
            goto L_0x0014
        L_0x004c:
            r0 = r1
            goto L_0x0014
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C1964b.mo10398a(com.xiaomi.smack.packet.d):com.xiaomi.push.service.w$b");
    }

    /* renamed from: a */
    public void mo10399a(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.service_started");
        context.sendBroadcast(intent);
    }

    /* renamed from: a */
    public void mo10400a(Context context, C1987w.C1989b bVar, int i) {
        if (!"5".equalsIgnoreCase(bVar.f5134h)) {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.channel_closed");
            intent.setPackage(bVar.f5127a);
            intent.putExtra(AbstractC1993y.f5168q, bVar.f5134h);
            intent.putExtra("ext_reason", i);
            intent.putExtra(AbstractC1993y.f5167p, bVar.f5128b);
            intent.putExtra(AbstractC1993y.f5150B, bVar.f5136j);
            m7304a(context, intent, bVar.f5127a);
        }
    }

    /* renamed from: a */
    public void mo10401a(Context context, C1987w.C1989b bVar, String str, String str2) {
        if ("5".equalsIgnoreCase(bVar.f5134h)) {
            AbstractC1855b.m6723d("mipush kicked by server");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.kicked");
        intent.setPackage(bVar.f5127a);
        intent.putExtra("ext_kick_type", str);
        intent.putExtra("ext_kick_reason", str2);
        intent.putExtra("ext_chid", bVar.f5134h);
        intent.putExtra(AbstractC1993y.f5167p, bVar.f5128b);
        intent.putExtra(AbstractC1993y.f5150B, bVar.f5136j);
        m7304a(context, intent, bVar.f5127a);
    }

    /* renamed from: a */
    public void mo10402a(Context context, C1987w.C1989b bVar, boolean z, int i, String str) {
        if ("5".equalsIgnoreCase(bVar.f5134h)) {
            this.f5063a.mo10418a(context, bVar, z, i, str);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_opened");
        intent.setPackage(bVar.f5127a);
        intent.putExtra("ext_succeeded", z);
        if (!z) {
            intent.putExtra("ext_reason", i);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("ext_reason_msg", str);
        }
        intent.putExtra("ext_chid", bVar.f5134h);
        intent.putExtra(AbstractC1993y.f5167p, bVar.f5128b);
        intent.putExtra(AbstractC1993y.f5150B, bVar.f5136j);
        m7304a(context, intent, bVar.f5127a);
    }

    /* renamed from: a */
    public void mo10403a(XMPushService xMPushService, String str, AbstractC2028d dVar) {
        String str2;
        C1987w.C1989b a = mo10398a(dVar);
        if (a == null) {
            AbstractC1855b.m6723d("error while notify channel closed! channel " + str + " not registered");
        } else if ("5".equalsIgnoreCase(str)) {
            this.f5063a.mo10419a(xMPushService, dVar, a);
        } else {
            String str3 = a.f5127a;
            if (dVar instanceof C2027c) {
                str2 = "com.xiaomi.push.new_msg";
            } else if (dVar instanceof C2025b) {
                str2 = "com.xiaomi.push.new_iq";
            } else if (dVar instanceof C2030f) {
                str2 = "com.xiaomi.push.new_pres";
            } else {
                AbstractC1855b.m6723d("unknown packet type, drop it");
                return;
            }
            Intent intent = new Intent();
            intent.setAction(str2);
            intent.setPackage(str3);
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_packet", dVar.mo10581c());
            intent.putExtra(AbstractC1993y.f5150B, a.f5136j);
            intent.putExtra(AbstractC1993y.f5172u, a.f5135i);
            m7304a(xMPushService, intent, str3);
        }
    }
}
