package com.wanmei.push.p099c;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.wanmei.push.C1638a;
import com.wanmei.push.C1645b;
import com.wanmei.push.PushAgent;
import com.wanmei.push.p104g.C1714f;
import com.wanmei.push.p104g.C1717i;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.mipush.sdk.Logger;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.wanmei.push.c.b */
public final class C1675b implements AbstractC1674a {

    /* renamed from: a */
    private Context f4263a;

    public C1675b(Context context) {
        this.f4263a = context.getApplicationContext();
    }

    @Override // com.wanmei.push.p099c.AbstractC1674a
    /* renamed from: a */
    public final void mo9317a(PushAgent.OnPushOpenCallBack onPushOpenCallBack) {
        boolean b = C1717i.m6392b();
        C1714f.m6382b("PERFECT_PUSH", C1638a.m6167a("当前ROM类型为：" + (b ? "MIUI" : "不是MIUI")));
        if (b) {
            if (TextUtils.isEmpty(MiPushClient.getRegId(this.f4263a))) {
                C1714f.m6382b("PERFECT_PUSH", C1638a.m6167a("MiPush 没有注册成功,非MIUI设备无需注册"));
            } else {
                C1714f.m6382b("PERFECT_PUSH", "MiPush 的RegId:" + MiPushClient.getRegId(this.f4263a));
                String deviceId = C1645b.m6176a().mo9179a(this.f4263a).getDeviceId();
                String appClientId = C1645b.m6176a().mo9193b(this.f4263a).getAppClientId();
                if (TextUtils.isEmpty(deviceId)) {
                    C1714f.m6382b("PERFECT_PUSH", "无法获取push sdk的deviceId");
                } else {
                    C1714f.m6382b("PERFECT_PUSH", "设置MI PUSH Alias:" + deviceId);
                    MiPushClient.setAlias(this.f4263a, deviceId, null);
                    if (TextUtils.isEmpty(appClientId)) {
                        C1714f.m6382b("PERFECT_PUSH", "无法获取push appid");
                    } else {
                        String str = "broadcast/" + appClientId;
                        C1714f.m6382b("PERFECT_PUSH", "设置MI PUSH subscribe:" + str);
                        MiPushClient.subscribe(this.f4263a, str, null);
                    }
                }
            }
        }
        if (onPushOpenCallBack != null) {
            onPushOpenCallBack.openSuccess();
        }
    }

    @Override // com.wanmei.push.p099c.AbstractC1674a
    /* renamed from: a */
    public final void mo9318a(String str, String str2) {
        boolean z;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f4263a.getSystemService("activity")).getRunningAppProcesses();
        String packageName = this.f4263a.getPackageName();
        int myPid = Process.myPid();
        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            ActivityManager.RunningAppProcessInfo next = it.next();
            if (next.pid == myPid && packageName.equals(next.processName)) {
                z = true;
                break;
            }
        }
        if (z) {
            MiPushClient.registerPush(this.f4263a, str, str2);
        }
        Logger.setLogger(this.f4263a, new LoggerInterface() {
            /* class com.wanmei.push.p099c.C1675b.C16761 */

            @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
            public final void log(String content) {
                C1714f.m6379a("PERFECT_PUSH", content);
            }

            @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
            public final void log(String content, Throwable th) {
                C1714f.m6379a("PERFECT_PUSH", content);
            }

            @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
            public final void setTag(String str) {
            }
        });
    }
}
