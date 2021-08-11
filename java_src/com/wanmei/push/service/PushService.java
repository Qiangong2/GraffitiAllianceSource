package com.wanmei.push.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.igexin.sdk.PushConsts;
import com.pwrd.google.gson.reflect.TypeToken;
import com.wanmei.push.C1645b;
import com.wanmei.push.ResponseCode;
import com.wanmei.push.bean.AppInfo;
import com.wanmei.push.bean.AppState;
import com.wanmei.push.bean.Notice;
import com.wanmei.push.bean.PushMessage;
import com.wanmei.push.p097a.AbstractC1639a;
import com.wanmei.push.p097a.AbstractC1642b;
import com.wanmei.push.p100d.C1677a;
import com.wanmei.push.p101db.C1686d;
import com.wanmei.push.p102e.C1687a;
import com.wanmei.push.p102e.C1705e;
import com.wanmei.push.p103f.C1706a;
import com.wanmei.push.p104g.C1711c;
import com.wanmei.push.p104g.C1713e;
import com.wanmei.push.p104g.C1714f;
import com.wanmei.push.p104g.C1715g;
import com.wanmei.push.p104g.C1717i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.pwrd.paho.client.mqttv3.IMqttActionListener;
import org.pwrd.paho.client.mqttv3.IMqttDeliveryToken;
import org.pwrd.paho.client.mqttv3.IMqttToken;
import org.pwrd.paho.client.mqttv3.MqttAsyncClient;
import org.pwrd.paho.client.mqttv3.MqttCallback;
import org.pwrd.paho.client.mqttv3.MqttClientPersistence;
import org.pwrd.paho.client.mqttv3.MqttConnectOptions;
import org.pwrd.paho.client.mqttv3.MqttException;
import org.pwrd.paho.client.mqttv3.MqttMessage;

public class PushService extends Service {

    /* renamed from: a */
    private static int[] f4370a = {0};

    /* renamed from: b */
    private static boolean f4371b = false;

    /* renamed from: c */
    private static int f4372c = 0;

    /* renamed from: d */
    private static MqttClientPersistence f4373d = null;

    /* renamed from: e */
    private static C1735a f4374e;

    /* renamed from: f */
    private static boolean f4375f = false;

    /* renamed from: g */
    private ConnectivityManager f4376g;

    /* renamed from: h */
    private SharedPreferences f4377h;

    /* renamed from: i */
    private C1745c f4378i;

    /* renamed from: j */
    private C1746d f4379j;

    /* renamed from: k */
    private boolean f4380k;

    /* renamed from: l */
    private long f4381l;

    /* renamed from: m */
    private Handler f4382m;

    /* renamed from: n */
    private C1706a f4383n;

    /* renamed from: o */
    private List<AppInfo> f4384o = new ArrayList();

    /* renamed from: p */
    private IBinder f4385p = new AbstractC1642b.AbstractBinderC1643a() {
        /* class com.wanmei.push.service.PushService.BinderC17261 */

        @Override // com.wanmei.push.p097a.AbstractC1642b
        /* renamed from: a */
        public final void mo9175a(String str, final String str2, final AbstractC1639a aVar) throws RemoteException {
            boolean z = false;
            try {
                for (AppInfo appInfo : PushService.this.f4384o) {
                    z = (!appInfo.getAppClientId().equals(str) || !appInfo.getPackageName().equals(str2)) ? z : true;
                }
                if (!z) {
                    AppInfo appInfo2 = new AppInfo();
                    appInfo2.setAppClientId(str);
                    appInfo2.setPackageName(str2);
                    PushService.this.f4384o.add(appInfo2);
                    C1746d dVar = PushService.this.f4379j;
                    C1746d unused = PushService.this.f4379j;
                    dVar.mo9444a(C1746d.m6468a(PushService.this.f4384o));
                }
                if (PushService.f4374e == null) {
                    PushService.this.m6432i();
                }
                PushService.f4374e.mo9426b(C1744b.m6461a(str, str2), new IMqttActionListener() {
                    /* class com.wanmei.push.service.PushService.BinderC17261.C17271 */

                    @Override // org.pwrd.paho.client.mqttv3.IMqttActionListener
                    public final void onFailure(IMqttToken iMqttToken, Throwable throwable) {
                        PushService.this.m6410a((PushService) ("[ -- App Regist Error -- ][" + str2 + "]"), (String) throwable);
                    }

                    @Override // org.pwrd.paho.client.mqttv3.IMqttActionListener
                    public final void onSuccess(IMqttToken iMqttToken) {
                        try {
                            if (!str2.equals(PushService.this.getApplicationContext().getPackageName())) {
                                PushService.m6407a(PushService.this, str2);
                            }
                            aVar.mo9170a();
                            PushService pushService = PushService.this;
                            StringBuilder append = new StringBuilder("[ -- App Regist Success -- ][").append(str2).append("], [ AppInfo : ");
                            C1746d unused = PushService.this.f4379j;
                            pushService.m6410a((PushService) append.append(C1746d.m6468a(PushService.this.f4384o)).append(" ] ").toString(), (String) null);
                        } catch (Exception e) {
                            PushService.this.m6410a((PushService) ("[ -- App Regist Error -- ][" + str2 + "]"), (String) e);
                        }
                    }
                });
            } catch (Exception e) {
                PushService.this.m6410a((PushService) ("[ -- App Regist Error -- ][" + str2 + "]"), (String) e);
                aVar.mo9171a(ResponseCode.PUSH_OPEN_FAIL_CODE);
            }
        }
    };

    /* renamed from: q */
    private BroadcastReceiver f4386q = new BroadcastReceiver() {
        /* class com.wanmei.push.service.PushService.C17282 */

        public final void onReceive(Context context, Intent intent) {
            NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
            boolean z = networkInfo != null && networkInfo.isConnected();
            PushService.this.m6410a((PushService) ("Connectivity changed: connected=" + z), (String) null);
            if (z) {
                PushService.this.m6420c((PushService) true);
            } else if (PushService.f4374e != null) {
                PushService.f4374e.mo9422a();
                PushService.this.mo9409a();
                C1735a unused = PushService.f4374e = null;
            }
        }
    };

    /* renamed from: r */
    private BroadcastReceiver f4387r = new BroadcastReceiver() {
        /* class com.wanmei.push.service.PushService.C17293 */

        public final void onReceive(Context context, Intent intent) {
            boolean z;
            if ("android.intent.action.PACKAGE_REMOVED".equals(intent.getAction())) {
                boolean z2 = false;
                try {
                    Iterator it = PushService.this.f4384o.iterator();
                    while (it.hasNext()) {
                        AppInfo appInfo = (AppInfo) it.next();
                        if (appInfo.getPackageName().equals(C1713e.m6375a(intent))) {
                            it.remove();
                            PushService.this.m6405a((PushService) appInfo);
                            PushService.this.m6410a((PushService) ("PushService PackageRemovedReceiver : [" + C1713e.m6375a(intent) + "] Has Removed"), (String) null);
                            z = true;
                        } else {
                            z = z2;
                        }
                        z2 = z;
                    }
                    if (z2) {
                        C1746d dVar = PushService.this.f4379j;
                        C1746d unused = PushService.this.f4379j;
                        dVar.mo9444a(C1746d.m6468a(PushService.this.f4384o));
                    }
                } catch (Exception e) {
                    PushService.this.m6410a((PushService) "PushService PackageRemovedReceiver Error.", (String) e);
                }
            }
        }
    };

    /* access modifiers changed from: private */
    /* renamed from: com.wanmei.push.service.PushService$a */
    public class C1735a implements MqttCallback {

        /* renamed from: a */
        MqttAsyncClient f4401a = null;

        /* renamed from: b */
        MqttConnectOptions f4402b = null;

        public C1735a(final String str) throws MqttException {
            PushService.this.m6410a((PushService) ("MQTTConnection() IN [brokerHostName][" + str + "]"), (String) null);
            String string = PushService.this.f4377h.getString("preference_deviceID", "");
            this.f4402b = new MqttConnectOptions();
            this.f4402b.setCleanSession(true);
            String str2 = "mobile" + C1711c.m6371a(PushService.this);
            this.f4402b.setUserName(str2);
            StringBuilder sb = new StringBuilder();
            sb.append("0859fc7b49769ddd89a8cac544fbfd9b".substring(2, 5) + "0859fc7b49769ddd89a8cac544fbfd9b".substring(10, 16) + "0859fc7b49769ddd89a8cac544fbfd9b".substring(18, 20) + "0859fc7b49769ddd89a8cac544fbfd9b".substring(14, 19));
            sb.append(str2);
            this.f4402b.setPassword(C1715g.m6384a(sb.toString()).toCharArray());
            this.f4401a = new MqttAsyncClient("tcp://" + str + ":6993", string, PushService.f4373d, new C1741a(PushService.this));
            this.f4401a.setCallback(this);
            this.f4401a.connect(this.f4402b, PushService.this, new IMqttActionListener(PushService.this) {
                /* class com.wanmei.push.service.PushService.C1735a.C17361 */

                @Override // org.pwrd.paho.client.mqttv3.IMqttActionListener
                public final void onFailure(IMqttToken iMqttToken, Throwable throwable) {
                    PushService.this.m6410a((PushService) ("PushService MQTTConnection Connect onFailure" + throwable.toString()), (String) null);
                    PushService.this.m6415b((PushService) "android.intent.action.PERFECT_PUSH_STATUS_START_FAIL");
                    if (PushService.this.m6441n()) {
                        PushService.this.mo9410a(PushService.this.f4381l);
                    }
                }

                @Override // org.pwrd.paho.client.mqttv3.IMqttActionListener
                public final void onSuccess(IMqttToken iMqttToken) {
                    try {
                        C1735a aVar = C1735a.this;
                        String str = str;
                        aVar.mo9423a(C1744b.m6460a(PushService.this), new IMqttActionListener() {
                            /* class com.wanmei.push.service.PushService.C1735a.C17361.C17371 */

                            @Override // org.pwrd.paho.client.mqttv3.IMqttActionListener
                            public final void onFailure(IMqttToken iMqttToken, Throwable throwable) {
                                PushService.this.m6410a((PushService) ("PushService MQTTConnection subscribeToTopic onFailure. topic : " + C1744b.m6460a(PushService.this) + throwable.toString()), (String) null);
                                PushService.this.m6415b((PushService) "android.intent.action.PERFECT_PUSH_STATUS_START_FAIL");
                                if (PushService.this.m6441n()) {
                                    PushService.this.mo9410a(PushService.this.f4381l);
                                }
                            }

                            @Override // org.pwrd.paho.client.mqttv3.IMqttActionListener
                            public final void onSuccess(IMqttToken iMqttToken) {
                                PushService.this.m6410a((PushService) ("Connection established to " + str + " on topic " + C1744b.m6460a(PushService.this)), (String) null);
                                try {
                                    C1735a aVar = C1735a.this;
                                    String str = str;
                                    aVar.mo9424a(PushService.this.f4384o, new IMqttActionListener() {
                                        /* class com.wanmei.push.service.PushService.C1735a.C17361.C17371.C17381 */

                                        @Override // org.pwrd.paho.client.mqttv3.IMqttActionListener
                                        public final void onFailure(IMqttToken iMqttToken, Throwable throwable) {
                                            PushService.this.m6410a((PushService) ("PushService MQTTConnection subscribeToTopic onFailure. topics : " + Arrays.toString(C1744b.m6462a(PushService.this.f4384o)) + throwable.toString()), (String) null);
                                            PushService.this.m6415b((PushService) "android.intent.action.PERFECT_PUSH_STATUS_START_FAIL");
                                            if (PushService.this.m6441n()) {
                                                PushService.this.mo9410a(PushService.this.f4381l);
                                            }
                                        }

                                        @Override // org.pwrd.paho.client.mqttv3.IMqttActionListener
                                        public final void onSuccess(IMqttToken iMqttToken) {
                                            PushService.this.f4381l = System.currentTimeMillis();
                                            PushService.m6424e(PushService.this);
                                            PushService.m6427f(PushService.this);
                                            PushService.this.m6410a((PushService) ("Connection established to " + str + " on topics " + Arrays.toString(C1744b.m6462a(PushService.this.f4384o))), (String) null);
                                            PushService.m6429g(PushService.this);
                                            PushService.this.m6416b((PushService) true);
                                            PushService.this.m6415b((PushService) "android.intent.action.PERFECT_PUSH_STATUS_START_SUCCESS");
                                        }
                                    });
                                } catch (MqttException e) {
                                    PushService.this.m6410a((PushService) ("MqttException: " + (e.getMessage() != null ? e.getMessage() : "NULL")), (String) e);
                                    PushService.this.m6415b((PushService) "android.intent.action.PERFECT_PUSH_STATUS_START_FAIL");
                                    if (PushService.this.m6441n()) {
                                        PushService.this.mo9410a(PushService.this.f4381l);
                                    }
                                }
                            }
                        });
                    } catch (MqttException e) {
                        PushService.this.m6410a((PushService) ("MqttException: " + (e.getMessage() != null ? e.getMessage() : "NULL")), (String) e);
                        PushService.this.m6415b((PushService) "android.intent.action.PERFECT_PUSH_STATUS_START_FAIL");
                        if (PushService.this.m6441n()) {
                            PushService.this.mo9410a(PushService.this.f4381l);
                        }
                    }
                }
            });
        }

        /* renamed from: a */
        private void m6449a(String[] strArr, int[] iArr, IMqttActionListener iMqttActionListener) throws MqttException {
            PushService.this.m6410a((PushService) ("subscribeToTopic() IN [topicName][" + Arrays.toString(strArr) + "]"), (String) null);
            if (this.f4401a == null || !this.f4401a.isConnected()) {
                PushService.this.m6410a((PushService) "Connection error : No connection", (String) null);
            } else {
                this.f4401a.subscribe(strArr, iArr, PushService.this, iMqttActionListener);
            }
        }

        /* renamed from: a */
        public final void mo9422a() {
            try {
                PushService.m6424e(PushService.this);
                this.f4401a.disconnect();
            } catch (MqttException e) {
                PushService.this.m6410a((PushService) ("MqttException" + (e.getMessage() != null ? e.getMessage() : " NULL")), (String) e);
            }
        }

        /* renamed from: a */
        public final void mo9423a(String str, IMqttActionListener iMqttActionListener) throws MqttException {
            m6449a(new String[]{str}, PushService.f4370a, iMqttActionListener);
        }

        /* renamed from: a */
        public final void mo9424a(List<AppInfo> list, IMqttActionListener iMqttActionListener) throws MqttException {
            String[] a = C1744b.m6462a(list);
            List list2 = PushService.this.f4384o;
            int[] iArr = new int[list2.size()];
            for (int i = 0; i < list2.size(); i++) {
                iArr[i] = 0;
            }
            m6449a(a, iArr, iMqttActionListener);
        }

        /* renamed from: b */
        public final void mo9425b() throws MqttException {
            PushService.this.m6410a((PushService) ("[ -- keep Service alive -- ] Current App Info : " + PushService.this.f4384o.toString()), (String) null);
        }

        /* renamed from: b */
        public final void mo9426b(String str, IMqttActionListener iMqttActionListener) throws MqttException {
            m6449a(new String[]{str}, PushService.f4370a, iMqttActionListener);
        }

        @Override // org.pwrd.paho.client.mqttv3.MqttCallback
        public final void connectionLost(Throwable arg0) {
            PushService.this.m6410a((PushService) "Loss of connectionconnection downed", (String) arg0);
            PushService.m6424e(PushService.this);
            C1735a unused = PushService.f4374e = null;
            if (!PushService.this.m6441n() || !PushService.this.f4380k) {
                PushService.this.stopSelf();
            } else {
                PushService.this.m6420c((PushService) false);
            }
        }

        @Override // org.pwrd.paho.client.mqttv3.MqttCallback
        public final void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
            try {
                PushService.this.m6410a((PushService) ("[ -- DeliveryComplete -- ][" + iMqttDeliveryToken.getMessage().toString() + "]"), (String) null);
            } catch (MqttException e) {
                e.printStackTrace();
            }
        }

        @Override // org.pwrd.paho.client.mqttv3.MqttCallback
        public final void messageArrived(String str, MqttMessage mqttMessage) throws Exception {
            PushService.this.m6410a((PushService) ("[ -- PUSH Message Arrived -- ][" + mqttMessage.toString() + "]"), (String) null);
            if (C1717i.m6391a()) {
                PushService.m6423d(PushService.this, mqttMessage.toString());
            } else {
                PushService.this.m6410a((PushService) "Is not primary system", (String) null);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.wanmei.push.service.PushService$b */
    public class AsyncTaskC1739b extends AsyncTask<Void, Void, Void> {
        private AsyncTaskC1739b() {
        }

        /* synthetic */ AsyncTaskC1739b(PushService pushService, byte b) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ Void doInBackground(Void[] voidArr) {
            if (PushService.f4374e != null && PushService.f4374e.f4401a != null && PushService.f4374e.f4401a.isConnected()) {
                return null;
            }
            PushService.this.m6432i();
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ void onPostExecute(Void r2) {
            boolean unused = PushService.f4375f = false;
            super.onPostExecute(r2);
        }

        /* access modifiers changed from: protected */
        public final void onPreExecute() {
            boolean unused = PushService.f4375f = true;
            super.onPreExecute();
        }
    }

    /* renamed from: com.wanmei.push.service.PushService$c */
    private class AsyncTaskC1740c extends AsyncTask<Void, Void, Void> {
        private AsyncTaskC1740c() {
        }

        /* synthetic */ AsyncTaskC1740c(PushService pushService, byte b) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* synthetic */ Void doInBackground(Void[] voidArr) {
            PushService.this.m6435j();
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public final /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
            super.onPostExecute(r1);
        }
    }

    /* renamed from: a */
    private PushMessage m6401a(Intent intent, String str) {
        Exception e;
        PushMessage pushMessage;
        try {
            pushMessage = m6402a(str);
            try {
                Bundle bundle = new Bundle();
                bundle.putSerializable("message", pushMessage);
                intent.putExtras(bundle);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return pushMessage;
            }
        } catch (Exception e3) {
            pushMessage = null;
            e = e3;
            e.printStackTrace();
            return pushMessage;
        }
        return pushMessage;
    }

    /* renamed from: a */
    private PushMessage m6402a(String str) {
        try {
            return (PushMessage) C1705e.m6357a(str, new TypeToken<PushMessage>() {
                /* class com.wanmei.push.service.PushService.C17326 */
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static void m6404a(Context context) {
        Intent intent = new Intent(context, PushService.class);
        intent.setAction("perfectPush.START");
        context.startService(intent);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private void m6405a(final AppInfo appInfo) {
        C1645b.m6176a().mo9190a(new C1645b.AbstractC1653g() {
            /* class com.wanmei.push.service.PushService.C17337 */

            @Override // com.wanmei.push.C1645b.AbstractC1653g
            /* renamed from: a */
            public final void mo9207a() {
                C1714f.m6383c(PushService.this, "PERFECT_PUSH", "[PushService sendAppStateUpdateToServer Success] [" + appInfo.getPackageName() + "] Has Removed");
            }

            @Override // com.wanmei.push.C1645b.AbstractC1653g
            /* renamed from: b */
            public final void mo9208b() {
                C1714f.m6383c(PushService.this, "PERFECT_PUSH", "[PushService sendAppStateUpdateToServer Fail] [" + appInfo.getPackageName() + "] Has Removed");
            }
        });
        HashMap hashMap = new HashMap();
        hashMap.put(AppState.APP_ID, appInfo.getAppClientId());
        hashMap.put(AppState.PACKAGE_NAME, appInfo.getPackageName());
        hashMap.put(AppState.STATE, "3");
        C1677a.m6259a();
        C1677a.m6264b(this, hashMap);
    }

    /* renamed from: a */
    static /* synthetic */ void m6407a(PushService pushService, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.PERFECT_PUSH_STATUS_REFRESH");
        intent.putExtra("hostPackageName", pushService.getApplicationContext().getPackageName());
        intent.putExtra("successorPackageName", str);
        pushService.sendBroadcast(intent);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private void m6410a(String str, Throwable th) {
        if (th != null) {
            C1714f.m6377a(this, "PERFECT_PUSH", str, th);
        } else {
            C1714f.m6381b(this, "PERFECT_PUSH", str);
        }
        if (this.f4378i != null) {
            try {
                this.f4378i.mo9440a(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: b */
    private void m6415b(String str) {
        Intent intent = new Intent();
        intent.setAction(str);
        intent.putExtra("hostPackageName", getApplicationContext().getPackageName());
        if (this.f4384o.size() > 1) {
            for (AppInfo appInfo : this.f4384o) {
                if (!appInfo.getPackageName().equals(getApplicationContext().getPackageName())) {
                    intent.putExtra("successorPackageName", appInfo.getPackageName());
                }
            }
        }
        sendBroadcast(intent);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: b */
    private void m6416b(boolean z) {
        this.f4377h.edit().putBoolean("preference_is_started", z).commit();
        this.f4380k = z;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: c */
    private synchronized void m6420c(boolean z) {
        if (this.f4380k && f4374e == null && !f4375f) {
            long b = this.f4383n.mo9368b();
            m6410a("Connect Lost Reconnecting...", (Throwable) null);
            if (z) {
                new AsyncTaskC1739b(this, (byte) 0).execute(new Void[0]);
            } else {
                this.f4382m.postDelayed(new Runnable() {
                    /* class com.wanmei.push.service.PushService.RunnableC17315 */

                    public final void run() {
                        new AsyncTaskC1739b(PushService.this, (byte) 0).execute(new Void[0]);
                    }
                }, b);
            }
        }
    }

    /* renamed from: d */
    static /* synthetic */ void m6423d(PushService pushService, String str) {
        Intent intent = new Intent();
        final PushMessage a = pushService.m6401a(intent, str);
        if (a == null) {
            return;
        }
        if (pushService.f4384o.isEmpty()) {
            C1645b.m6176a().mo9190a(new C1645b.AbstractC1653g() {
                /* class com.wanmei.push.service.PushService.C17348 */

                @Override // com.wanmei.push.C1645b.AbstractC1653g
                /* renamed from: a */
                public final void mo9207a() {
                    C1714f.m6383c(PushService.this, "PERFECT_PUSH", "[" + PushService.this.getPackageName() + "][PushService sendAppStateUpdateToServer Success] [" + a.getBundleId() + "] Has Removed");
                }

                @Override // com.wanmei.push.C1645b.AbstractC1653g
                /* renamed from: b */
                public final void mo9208b() {
                    C1714f.m6383c(PushService.this, "PERFECT_PUSH", "[" + PushService.this.getPackageName() + "][PushService sendAppStateUpdateToServer Fail] [" + a.getBundleId() + "] Has Removed");
                }
            });
            HashMap hashMap = new HashMap();
            hashMap.put(AppState.APP_ID, a.getAppId());
            hashMap.put(AppState.PACKAGE_NAME, a.getBundleId());
            hashMap.put(AppState.STATE, "3");
            C1677a.m6259a();
            C1677a.m6264b(pushService, hashMap);
        } else if (TextUtils.isEmpty(a.getBundleId())) {
            for (AppInfo appInfo : pushService.f4384o) {
                if (a.getAppId().equals(appInfo.getAppClientId())) {
                    pushService.m6410a("sendBroadcast appid = " + a.getAppId(), (Throwable) null);
                    pushService.m6410a("sendBroadcast package = " + appInfo.getPackageName(), (Throwable) null);
                    intent.setAction(appInfo.getPackageName() + ".intent.action.PERFECT_PUSH_ARRIVED");
                    pushService.sendBroadcast(intent);
                }
            }
        } else {
            for (AppInfo appInfo2 : pushService.f4384o) {
                if (a.getAppId().equals(appInfo2.getAppClientId()) && a.getBundleId().equals(appInfo2.getPackageName())) {
                    pushService.m6410a("sendBroadcast appid = " + a.getAppId(), (Throwable) null);
                    pushService.m6410a("sendBroadcast package = " + appInfo2.getPackageName(), (Throwable) null);
                    intent.setAction(appInfo2.getPackageName() + ".intent.action.PERFECT_PUSH_ARRIVED");
                    pushService.sendBroadcast(intent);
                }
            }
        }
    }

    /* renamed from: e */
    static /* synthetic */ void m6424e(PushService pushService) {
        Intent intent = new Intent();
        intent.setClass(pushService, PushService.class);
        intent.setAction("perfectPush.KEEP_ALIVE");
        ((AlarmManager) pushService.getSystemService("alarm")).cancel(PendingIntent.getService(pushService, 0, intent, 0));
    }

    /* renamed from: f */
    private void m6426f() {
        m6410a("PushService Creating, Check Retry Send Msg To Server", (Throwable) null);
        List<Notice> a = C1686d.m6314a((Context) this).mo9334a();
        if (a != null) {
            for (Notice notice : a) {
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(notice.getMsgId())) {
                    hashMap.put(Notice.MSG_ID, notice.getMsgId());
                }
                if (!TextUtils.isEmpty(notice.getIsOffline())) {
                    hashMap.put(Notice.IS_OFFLINE, notice.getIsOffline());
                }
                if (!TextUtils.isEmpty(notice.getApiAddr())) {
                    hashMap.put("apiADDR", notice.getApiAddr());
                }
                if (hashMap.containsKey("apiADDR") && ((String) hashMap.get("apiADDR")).equals(C1687a.f4298h)) {
                    C1677a.m6259a();
                    C1677a.m6268d(this, hashMap);
                }
                if (hashMap.containsKey("apiADDR") && ((String) hashMap.get("apiADDR")).equals(C1687a.f4299i)) {
                    C1677a.m6259a();
                    C1677a.m6272f(this, hashMap);
                }
            }
        }
        List<AppState> b = C1686d.m6314a((Context) this).mo9337b();
        if (b != null) {
            for (AppState appState : b) {
                HashMap hashMap2 = new HashMap();
                if (!TextUtils.isEmpty(appState.getAppId())) {
                    hashMap2.put(AppState.APP_ID, appState.getAppId());
                }
                if (!TextUtils.isEmpty(appState.getPkName())) {
                    hashMap2.put(AppState.PACKAGE_NAME, appState.getPkName());
                }
                if (!TextUtils.isEmpty(appState.getApiAddr())) {
                    hashMap2.put("apiADDR", appState.getApiAddr());
                }
                if (!TextUtils.isEmpty(appState.getState())) {
                    hashMap2.put(AppState.STATE, appState.getState());
                }
                if (hashMap2.containsKey("apiADDR") && ((String) hashMap2.get("apiADDR")).equals(C1687a.f4297g)) {
                    C1677a.m6259a();
                    C1677a.m6264b(this, hashMap2);
                }
            }
        }
    }

    /* renamed from: f */
    static /* synthetic */ void m6427f(PushService pushService) {
        Intent intent = new Intent();
        intent.setClass(pushService, PushService.class);
        intent.setAction("perfectPush.KEEP_ALIVE");
        ((AlarmManager) pushService.getSystemService("alarm")).setRepeating(0, System.currentTimeMillis() + 30000, 30000, PendingIntent.getService(pushService, 0, intent, 0));
    }

    /* renamed from: g */
    private void m6428g() {
        boolean z;
        boolean z2;
        List<AppInfo> b = this.f4379j.mo9446b(this.f4379j.mo9445b());
        this.f4384o.clear();
        if (b != null) {
            this.f4384o.addAll(b);
        }
        boolean z3 = false;
        for (AppInfo appInfo : this.f4384o) {
            z3 = (appInfo.getAppClientId() == null || appInfo.getPackageName() == null || !appInfo.getAppClientId().equals(C1744b.m6463b(this)) || !appInfo.getPackageName().equals(getApplicationContext().getPackageName())) ? z3 : true;
        }
        if (!z3) {
            AppInfo appInfo2 = new AppInfo();
            appInfo2.setAppClientId(C1744b.m6463b(this));
            appInfo2.setPackageName(getApplicationContext().getPackageName());
            this.f4384o.add(appInfo2);
            z = true;
        } else {
            z = false;
        }
        Iterator<AppInfo> it = this.f4384o.iterator();
        while (it.hasNext()) {
            AppInfo next = it.next();
            String packageName = next.getPackageName();
            Iterator<PackageInfo> it2 = getApplicationContext().getPackageManager().getInstalledPackages(0).iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().packageName.equalsIgnoreCase(packageName)) {
                        z2 = true;
                        break;
                    }
                } else {
                    z2 = false;
                    break;
                }
            }
            if (!z2) {
                it.remove();
                m6405a(next);
                z = true;
            } else {
                z = z;
            }
        }
        if (z) {
            try {
                C1746d dVar = this.f4379j;
                C1746d dVar2 = this.f4379j;
                dVar.mo9444a(C1746d.m6468a(this.f4384o));
            } catch (Exception e) {
                m6410a("PushService initAppInfo: AppInfoHasChanged, Save AppInfo Error.", e);
            }
        }
    }

    /* renamed from: g */
    static /* synthetic */ void m6429g(PushService pushService) {
        pushService.m6410a("regist Receiver...", (Throwable) null);
        pushService.registerReceiver(pushService.f4386q, new IntentFilter(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        pushService.registerReceiver(pushService.f4387r, intentFilter);
        pushService.m6410a("regist Receiver Done", (Throwable) null);
    }

    /* renamed from: h */
    private boolean m6431h() {
        return this.f4377h.getBoolean("preference_is_started", false);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: i */
    private synchronized void m6432i() {
        m6410a("Starting Service Connect...", (Throwable) null);
        m6436k();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: j */
    private synchronized void m6435j() {
        if (!this.f4380k) {
            m6410a("Attempt to stop connection not active.", (Throwable) null);
        } else {
            m6416b(false);
            unregisterReceiver(this.f4386q);
            unregisterReceiver(this.f4387r);
            m6410a("unregist Receiver Done", (Throwable) null);
            mo9409a();
            if (f4374e != null) {
                f4374e.mo9422a();
                f4374e = null;
            }
        }
    }

    /* renamed from: k */
    private synchronized void m6436k() {
        m6410a("Connecting...", (Throwable) null);
        if (this.f4377h.getString("preference_deviceID", null) == null) {
            m6410a("Device ID not found.", (Throwable) null);
        } else {
            try {
                f4374e = new C1735a("pushserver.laohu.com");
            } catch (MqttException e) {
                m6410a("MqttException: " + (e.getMessage() != null ? e.getMessage() : "NULL"), e);
                m6415b("android.intent.action.PERFECT_PUSH_STATUS_START_FAIL");
                if (m6441n()) {
                    mo9410a(this.f4381l);
                }
            }
        }
    }

    /* renamed from: l */
    private synchronized void m6438l() {
        try {
            if (this.f4380k && f4374e != null) {
                f4374e.mo9425b();
            }
        } catch (Exception e) {
            m6410a("PushService keepAlive Exception: " + (e.getMessage() != null ? e.getMessage() : "NULL"), e);
            f4374e.mo9422a();
            f4374e = null;
            mo9409a();
        }
    }

    /* renamed from: m */
    private synchronized void m6440m() {
        m6410a("Connect Retry...", (Throwable) null);
        if (!f4375f) {
            new AsyncTaskC1739b(this, (byte) 0).execute(new Void[0]);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: n */
    private boolean m6441n() {
        NetworkInfo activeNetworkInfo = this.f4376g.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* renamed from: a */
    public final void mo9409a() {
        Intent intent = new Intent();
        intent.setClass(this, PushService.class);
        intent.setAction("perfectPush.RECONNECT");
        ((AlarmManager) getSystemService("alarm")).cancel(PendingIntent.getService(this, 0, intent, 0));
    }

    /* renamed from: a */
    public final void mo9410a(long j) {
        long j2 = this.f4377h.getLong("preference_retry_interval", 60000);
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - j;
        long min = j3 < j2 ? Math.min(2 * j3, 60000L) : 60000;
        m6410a("Rescheduling reconnection in " + min + "ms.", (Throwable) null);
        this.f4377h.edit().putLong("preference_retry_interval", min).commit();
        Intent intent = new Intent();
        intent.setClass(this, PushService.class);
        intent.setAction("perfectPush.RECONNECT");
        ((AlarmManager) getSystemService("alarm")).set(0, min + currentTimeMillis, PendingIntent.getService(this, 0, intent, 0));
    }

    public IBinder onBind(Intent intent) {
        m6410a("PushService onBind() IN ", (Throwable) null);
        return this.f4385p;
    }

    public void onCreate() {
        super.onCreate();
        m6410a("PushService onCreate() IN", (Throwable) null);
        m6410a("PushService Creating service", (Throwable) null);
        this.f4381l = System.currentTimeMillis();
        this.f4382m = new Handler() {
            /* class com.wanmei.push.service.PushService.HandlerC17304 */
        };
        this.f4383n = C1706a.m6358a();
        try {
            if (C1745c.m6464a()) {
                this.f4378i = new C1745c();
                m6410a("Opened log at " + this.f4378i.mo9441b(), (Throwable) null);
            }
        } catch (IOException e) {
            m6410a("Failed to open log :" + e.getMessage(), e);
        }
        try {
            this.f4379j = new C1746d(this);
            m6410a("Opened Data at " + this.f4379j.mo9443a(), (Throwable) null);
        } catch (IOException e2) {
            m6410a("Failed to open Data :" + e2.getMessage(), e2);
        }
        m6426f();
        m6428g();
        m6410a("PushService Creating, AppInfo : " + this.f4384o.toString(), (Throwable) null);
        this.f4377h = getSharedPreferences("preference_push_service", 0);
        this.f4377h.edit().putString("preference_deviceID", String.valueOf(C1711c.m6371a(this))).commit();
        this.f4376g = (ConnectivityManager) getSystemService("connectivity");
        m6410a("handleCrashedService() IN [wasStarted()][" + m6431h() + "]", (Throwable) null);
        if (m6431h()) {
            m6410a("Handling crashed service...", (Throwable) null);
            if (!f4375f) {
                new AsyncTaskC1739b(this, (byte) 0).execute(new Void[0]);
            }
        }
    }

    public void onDestroy() {
        m6410a("PushService onDestroy() IN [started = ][" + this.f4380k + "]", (Throwable) null);
        try {
            if (this.f4378i != null) {
                this.f4378i.mo9442c();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onRebind(Intent intent) {
        m6410a("PushService onRebind() IN ", (Throwable) null);
        super.onRebind(intent);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        m6410a("PushService onStartCommand() IN ", (Throwable) null);
        m6410a("PushService started with intent=" + intent, (Throwable) null);
        if (intent == null) {
            return 1;
        }
        if (intent.getAction().equals("perfectPush.STOP")) {
            new AsyncTaskC1740c(this, (byte) 0).execute(new Void[0]);
            stopSelf();
            return 1;
        } else if (intent.getAction().equals("perfectPush.START")) {
            if (f4375f) {
                return 1;
            }
            new AsyncTaskC1739b(this, (byte) 0).execute(new Void[0]);
            return 1;
        } else if (intent.getAction().equals("perfectPush.KEEP_ALIVE")) {
            m6438l();
            return 1;
        } else if (!intent.getAction().equals("perfectPush.RECONNECT") || !m6441n()) {
            return 1;
        } else {
            m6440m();
            return 1;
        }
    }

    public boolean onUnbind(Intent intent) {
        m6410a("PushService onUnbind() IN ", (Throwable) null);
        return super.onUnbind(intent);
    }
}
