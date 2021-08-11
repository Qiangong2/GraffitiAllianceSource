package com.wanmei.push.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.IBinder;
import com.wanmei.push.C1645b;
import com.wanmei.push.bean.Notice;
import com.wanmei.push.p100d.C1677a;
import com.wanmei.push.p104g.C1714f;
import java.util.HashMap;
import org.pwrd.paho.client.mqttv3.internal.ClientDefaults;

public class HandlePushNotifyService extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        C1714f.m6383c(this, "PERFECT_PUSH", "[" + getPackageName() + "][HandlePushNotifyService onCreate() IN]");
    }

    public void onDestroy() {
        super.onDestroy();
        C1714f.m6383c(this, "PERFECT_PUSH", "[" + getPackageName() + "][HandlePushNotifyService onDestroy() IN]");
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        PackageInfo packageInfo;
        C1714f.m6383c(this, "PERFECT_PUSH", "[" + getPackageName() + "][HandlePushNotifyService onStartCommand() IN][intent][" + intent + "]");
        if (intent != null) {
            C1714f.m6383c(this, "PERFECT_PUSH", "[" + getPackageName() + "][HandlePushNotifyService onStartCommand() action:][" + intent.getAction() + "]");
            if (intent.getAction() != null && intent.getAction().equals(getApplicationContext().getPackageName() + ".intent.action.PERFECT_PUSH_CLICKED")) {
                final String stringExtra = intent.getStringExtra(Notice.MSG_ID);
                C1645b.m6176a().mo9187a(new C1645b.AbstractC1650d() {
                    /* class com.wanmei.push.service.HandlePushNotifyService.C17251 */

                    @Override // com.wanmei.push.C1645b.AbstractC1650d
                    /* renamed from: a */
                    public final void mo9203a() {
                        C1714f.m6383c(HandlePushNotifyService.this, "PERFECT_PUSH", "[" + HandlePushNotifyService.this.getPackageName() + "][HandlePushNotifyService sendPushClickToServer Success] MsgId : " + stringExtra);
                    }

                    @Override // com.wanmei.push.C1645b.AbstractC1650d
                    /* renamed from: b */
                    public final void mo9204b() {
                        C1714f.m6383c(HandlePushNotifyService.this, "PERFECT_PUSH", "[" + HandlePushNotifyService.this.getPackageName() + "][HandlePushNotifyService sendPushClickToServer Fail] MsgId : " + stringExtra);
                    }
                });
                HashMap hashMap = new HashMap();
                hashMap.put(Notice.MSG_ID, stringExtra);
                C1677a.m6259a();
                C1677a.m6272f(this, hashMap);
                String packageName = getApplicationContext().getPackageName();
                Intent intent2 = new Intent("android.intent.action.MAIN");
                try {
                    packageInfo = getPackageManager().getPackageInfo(packageName, 0);
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                    packageInfo = null;
                }
                if (packageInfo != null) {
                    Intent intent3 = new Intent("android.intent.action.MAIN", (Uri) null);
                    intent3.addCategory("android.intent.category.LAUNCHER");
                    intent3.setPackage(packageInfo.packageName);
                    ResolveInfo next = getPackageManager().queryIntentActivities(intent3, 0).iterator().next();
                    if (next != null) {
                        String str = next.activityInfo.name;
                        intent2.addCategory("android.intent.category.LAUNCHER");
                        intent2.setComponent(new ComponentName(packageName, str));
                        intent2.setFlags(ClientDefaults.MAX_MSG_SIZE);
                        getApplicationContext().startActivity(intent2);
                    }
                }
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
