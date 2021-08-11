package com.wanmei.push.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.wanmei.push.p104g.C1714f;
import org.pwrd.paho.client.mqttv3.IMqttActionListener;
import org.pwrd.paho.client.mqttv3.IMqttToken;
import org.pwrd.paho.client.mqttv3.MqttPingSender;
import org.pwrd.paho.client.mqttv3.MqttToken;
import org.pwrd.paho.client.mqttv3.internal.ClientComms;

/* renamed from: com.wanmei.push.service.a */
final class C1741a implements MqttPingSender {

    /* renamed from: a */
    private ClientComms f4411a;

    /* renamed from: b */
    private PushService f4412b;

    /* renamed from: c */
    private BroadcastReceiver f4413c;

    /* renamed from: d */
    private C1741a f4414d;

    /* renamed from: e */
    private PendingIntent f4415e;

    /* renamed from: f */
    private volatile boolean f4416f = false;

    /* renamed from: com.wanmei.push.service.a$a */
    class C1742a extends BroadcastReceiver {

        /* renamed from: b */
        private PowerManager.WakeLock f4418b;

        /* renamed from: c */
        private String f4419c = ("perfectPush.client." + C1741a.this.f4414d.f4411a.getClient().getClientId());

        C1742a() {
        }

        public final void onReceive(Context context, Intent intent) {
            C1714f.m6381b(C1741a.this.f4412b, "PERFECT_PUSH", "AlarmPingSender AlarmReceiver Ping " + intent.getIntExtra("android.intent.extra.ALARM_COUNT", -1) + " times.");
            C1714f.m6381b(C1741a.this.f4412b, "PERFECT_PUSH", "AlarmPingSender AlarmReceiver Check time : " + System.currentTimeMillis());
            MqttToken checkForActivity = C1741a.this.f4411a.checkForActivity();
            if (checkForActivity != null) {
                if (this.f4418b == null) {
                    this.f4418b = ((PowerManager) C1741a.this.f4412b.getSystemService("power")).newWakeLock(1, this.f4419c);
                }
                this.f4418b.acquire();
                checkForActivity.setActionCallback(new IMqttActionListener() {
                    /* class com.wanmei.push.service.C1741a.C1742a.C17431 */

                    @Override // org.pwrd.paho.client.mqttv3.IMqttActionListener
                    public final void onFailure(IMqttToken iMqttToken, Throwable th) {
                        C1714f.m6379a("PERFECT_PUSH", "AlarmPingSender AlarmReceiver Failure. Release lock(" + C1742a.this.f4419c + "):" + System.currentTimeMillis());
                        if (C1742a.this.f4418b != null && C1742a.this.f4418b.isHeld()) {
                            C1742a.this.f4418b.release();
                        }
                    }

                    @Override // org.pwrd.paho.client.mqttv3.IMqttActionListener
                    public final void onSuccess(IMqttToken iMqttToken) {
                        C1714f.m6379a("PERFECT_PUSH", "AlarmPingSender AlarmReceiver Success. Release lock(" + C1742a.this.f4419c + "):" + System.currentTimeMillis());
                        if (C1742a.this.f4418b != null && C1742a.this.f4418b.isHeld()) {
                            C1742a.this.f4418b.release();
                        }
                    }
                });
            }
        }
    }

    public C1741a(PushService pushService) {
        if (pushService == null) {
            throw new IllegalArgumentException("Neither service nor client can be null.");
        }
        this.f4412b = pushService;
        this.f4414d = this;
    }

    @Override // org.pwrd.paho.client.mqttv3.MqttPingSender
    public final void init(ClientComms comms) {
        this.f4411a = comms;
        this.f4413c = new C1742a();
    }

    @Override // org.pwrd.paho.client.mqttv3.MqttPingSender
    public final void schedule(long delayInMilliseconds) {
        long currentTimeMillis = System.currentTimeMillis() + delayInMilliseconds;
        C1714f.m6381b(this.f4412b, "PERFECT_PUSH", "Schedule next AlarmPingSender at " + currentTimeMillis);
        ((AlarmManager) this.f4412b.getSystemService("alarm")).set(0, currentTimeMillis, this.f4415e);
    }

    @Override // org.pwrd.paho.client.mqttv3.MqttPingSender
    public final void start() {
        String str = "perfectPush.pingSender." + this.f4411a.getClient().getClientId();
        C1714f.m6381b(this.f4412b, "PERFECT_PUSH", "Register AlarmPingSenderReceiver to PushService " + str);
        this.f4412b.registerReceiver(this.f4413c, new IntentFilter(str));
        this.f4415e = PendingIntent.getBroadcast(this.f4412b, 0, new Intent(str), 134217728);
        schedule(this.f4411a.getKeepAlive());
        this.f4416f = true;
    }

    @Override // org.pwrd.paho.client.mqttv3.MqttPingSender
    public final void stop() {
        ((AlarmManager) this.f4412b.getSystemService("alarm")).cancel(this.f4415e);
        C1714f.m6381b(this.f4412b, "PERFECT_PUSH", "Unregister AlarmPingSenderReceiver to PushService " + this.f4411a.getClient().getClientId());
        if (this.f4416f) {
            this.f4416f = false;
            try {
                this.f4412b.unregisterReceiver(this.f4413c);
            } catch (IllegalArgumentException e) {
                C1714f.m6380a("PERFECT_PUSH", "Unregister AlarmPingSenderReceiver to PushService " + this.f4411a.getClient().getClientId() + " IllegalArgumentException : ", e);
            }
        }
    }
}
