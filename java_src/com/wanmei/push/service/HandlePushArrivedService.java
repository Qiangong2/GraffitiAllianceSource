package com.wanmei.push.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.wanmei.push.C1645b;
import com.wanmei.push.bean.Notice;
import com.wanmei.push.bean.PushMessage;
import com.wanmei.push.p100d.C1677a;
import com.wanmei.push.p104g.C1714f;
import java.util.HashMap;

public class HandlePushArrivedService extends Service {

    /* renamed from: a */
    private Handler f4362a;

    /* renamed from: a */
    static /* synthetic */ void m6395a(HandlePushArrivedService handlePushArrivedService, final PushMessage pushMessage) {
        C1645b.m6176a().mo9188a(new C1645b.AbstractC1651e() {
            /* class com.wanmei.push.service.HandlePushArrivedService.C17243 */

            @Override // com.wanmei.push.C1645b.AbstractC1651e
            /* renamed from: a */
            public final void mo9205a() {
                C1714f.m6383c(HandlePushArrivedService.this, "PERFECT_PUSH", "[" + HandlePushArrivedService.this.getPackageName() + "][HandlePushArrivedService sendReceiptToServer Success] PushMessage:" + pushMessage.toString());
            }

            @Override // com.wanmei.push.C1645b.AbstractC1651e
            /* renamed from: b */
            public final void mo9206b() {
                C1714f.m6383c(HandlePushArrivedService.this, "PERFECT_PUSH", "[" + HandlePushArrivedService.this.getPackageName() + "][HandlePushArrivedService sendReceiptToServer Fail] PushMessage:" + pushMessage.toString());
            }
        });
        HashMap hashMap = new HashMap();
        hashMap.put(Notice.MSG_ID, pushMessage.getMsgId());
        hashMap.put(Notice.IS_OFFLINE, pushMessage.getOffline());
        C1677a.m6259a();
        C1677a.m6268d(handlePushArrivedService, hashMap);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        C1714f.m6383c(this, "PERFECT_PUSH", "[" + getPackageName() + "][HandlePushArrivedService onCreate() IN]");
        this.f4362a = new Handler() {
            /* class com.wanmei.push.service.HandlePushArrivedService.HandlerC17221 */
        };
    }

    public void onDestroy() {
        super.onDestroy();
        C1714f.m6383c(this, "PERFECT_PUSH", "[" + getPackageName() + "][HandlePushArrivedService onDestroy() IN]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0081, code lost:
        r0 = (com.wanmei.push.bean.PushMessage) r10.getSerializableExtra("message");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int onStartCommand(android.content.Intent r10, int r11, int r12) {
        /*
        // Method dump skipped, instructions count: 807
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wanmei.push.service.HandlePushArrivedService.onStartCommand(android.content.Intent, int, int):int");
    }
}
