package com.igexin.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.support.p007v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0519a;
import com.igexin.push.util.C1151a;
import com.igexin.push.util.C1155e;
import com.igexin.push.util.C1167q;
import com.igexin.sdk.p082a.C1173c;
import com.umeng.analytics.p091b.C1447g;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.security.MessageDigest;
import org.pwrd.paho.client.mqttv3.MqttTopic;

public class PushManager {

    /* renamed from: a */
    private long f3049a;

    /* renamed from: b */
    private long f3050b;

    /* renamed from: c */
    private long f3051c;

    /* renamed from: d */
    private byte[] f3052d;

    private PushManager() {
    }

    /* renamed from: a */
    private Class m4811a(Context context) {
        return GTServiceManager.getInstance().getUserPushService(context);
    }

    /* renamed from: a */
    private String m4812a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder("");
            for (byte b : digest) {
                int i = b;
                if (b < 0) {
                    i = b + 256;
                }
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i == 1 ? 1 : 0));
            }
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    private void m4813a(Context context, Bundle bundle) {
        try {
            Intent intent = new Intent(context.getApplicationContext(), m4811a(context));
            intent.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            context.getApplicationContext().startService(intent);
        } catch (Throwable th) {
        }
    }

    public static PushManager getInstance() {
        return C1179d.m4831a();
    }

    public boolean bindAlias(Context context, String str) {
        ActivityC0460a.m1698b("PushManager|call bindAlias");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f3051c < 5000) {
            Log.e("PushManager", "call - > bindAlias failed, it be called too frequently");
            return false;
        }
        this.f3051c = currentTimeMillis;
        Bundle bundle = new Bundle();
        bundle.putString(PushConsts.CMD_ACTION, "bindAlias");
        bundle.putString("alias", str);
        m4813a(context, bundle);
        return true;
    }

    public String getClientid(Context context) {
        String a;
        if (this.f3052d == null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                    String string = applicationInfo.metaData.getString(AssistPushConsts.GETUI_APPID);
                    String string2 = applicationInfo.metaData.getString(AssistPushConsts.GETUI_APPSECRET);
                    String string3 = applicationInfo.metaData.getString(AssistPushConsts.GETUI_APPKEY);
                    if (string != null) {
                        string = string.trim();
                    }
                    if (string2 != null) {
                        string2 = string2.trim();
                    }
                    if (string3 != null) {
                        string3 = string3.trim();
                    }
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && (a = m4812a(string + string2 + string3 + context.getPackageName())) != null) {
                        this.f3052d = a.getBytes();
                    }
                }
            } catch (Exception e) {
                ActivityC0460a.m1698b("PushManager|" + e.toString());
            }
        }
        if (this.f3052d != null) {
            byte[] a2 = C1155e.m4764a(context.getFilesDir().getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + "init.pid");
            if (!(this.f3052d == null || a2 == null || this.f3052d.length != a2.length)) {
                byte[] bArr = new byte[a2.length];
                for (int i = 0; i < bArr.length; i++) {
                    bArr[i] = (byte) (this.f3052d[i] ^ a2[i]);
                }
                return new String(bArr);
            }
        }
        return null;
    }

    public String getVersion(Context context) {
        return PushBuildConfig.sdk_conf_version;
    }

    public <T extends Service> void initialize(Context context, Class<T> cls) {
        try {
            String packageName = context.getApplicationContext().getPackageName();
            String a = C1151a.m4736a(context);
            if (a == null || (!a.contains("gtsync") && !a.contains("gtdms"))) {
                if (!C1151a.m4744a("PushManager", context, cls)) {
                    ActivityC0460a.m1698b("PushManager|init checkServiceSetCorrectly false");
                }
                if (cls == null || C0519a.f1350n.equals(cls.getName())) {
                    C1167q.m4792a(context, "us", "");
                    cls = PushService.class;
                } else if (!GTServiceManager.getInstance().getUserPushService(context).getName().equals(cls.getName())) {
                    C1167q.m4792a(context, "us", cls.getName());
                }
                Intent intent = new Intent(context.getApplicationContext(), (Class<?>) cls);
                intent.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_SERVICE_INITIALIZE);
                intent.putExtra("op_app", packageName);
                context.getApplicationContext().startService(intent);
                return;
            }
            ActivityC0460a.m1698b("PushManager|init by default = " + a);
        } catch (Throwable th) {
            ActivityC0460a.m1698b("PushManager|initialize|" + th.toString());
        }
    }

    public boolean isPushTurnedOn(Context context) {
        return new C1173c(context).mo5969c();
    }

    public <T extends GTIntentService> void registerPushIntentService(Context context, Class<T> cls) {
        ActivityC0460a.m1698b("PushManager|call registerPushIntentService");
        if (cls == null) {
            try {
                C1167q.m4792a(context, "uis", "");
                Log.d("PushManager", "call -> registerPushIntentService, parameter [userIntentService] is null, use default Receiver");
            } catch (Throwable th) {
                ActivityC0460a.m1698b("PushManager|registerPushIntentService|" + th.toString());
            }
        } else {
            try {
                Class.forName(cls.getName());
            } catch (Exception e) {
                ActivityC0460a.m1698b("PushManager|registerPushIntentService|" + e.toString());
            }
            if (!C1151a.m4748b(new Intent(context, (Class<?>) cls), context)) {
                Log.e("PushManager", "call - > registerPushIntentService, parameter [userIntentService] is set, but didn't find class \"" + cls.getName() + "\", please check your AndroidManifest");
            }
            Class userIntentService = GTServiceManager.getInstance().getUserIntentService(context);
            if (userIntentService == null || !cls.getName().equals(userIntentService.getName())) {
                C1167q.m4792a(context, "uis", cls.getName());
            }
        }
    }

    public boolean sendFeedbackMessage(Context context, String str, String str2, int i) {
        if (str == null || str2 == null || i < 90001 || i > 90999) {
            Log.e("PushManager", "call - > sendFeedbackMessage failed, parameter is illegal");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString(PushConsts.CMD_ACTION, "sendFeedbackMessage");
        bundle.putString("taskid", str);
        bundle.putString("messageid", str2);
        bundle.putString("actionid", String.valueOf(i));
        m4813a(context, bundle);
        return true;
    }

    public boolean sendMessage(Context context, String str, byte[] bArr) {
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || bArr == null || ((long) bArr.length) > PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM || currentTimeMillis - this.f3050b < 1000) {
            Log.e("PushManager", "call - > sendMessage failed, parameter is illegal or it be called too frequently");
            return false;
        }
        this.f3050b = currentTimeMillis;
        Bundle bundle = new Bundle();
        bundle.putString(PushConsts.CMD_ACTION, "sendMessage");
        bundle.putString("taskid", str);
        bundle.putByteArray("extraData", bArr);
        m4813a(context, bundle);
        return true;
    }

    public boolean setHeartbeatInterval(Context context, int i) {
        if (i < 0) {
            Log.e("PushManager", "call -> setHeartbeatInterval failed, parameter [interval] < 0, illegal");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString(PushConsts.CMD_ACTION, "setHeartbeatInterval");
        bundle.putInt(C1447g.f3496ap, i);
        m4813a(context, bundle);
        return true;
    }

    public boolean setSilentTime(Context context, int i, int i2) {
        if (i < 0 || i >= 24 || i2 < 0 || i2 > 23) {
            Log.e("PushManager", "call - > setSilentTime failed, parameter [beginHour] or [duration] value exceeding");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString(PushConsts.CMD_ACTION, "setSilentTime");
        bundle.putInt("beginHour", i);
        bundle.putInt("duration", i2);
        m4813a(context, bundle);
        return true;
    }

    public boolean setSocketTimeout(Context context, int i) {
        if (i < 0) {
            Log.e("PushManager", "call - > setSocketTimeout failed, parameter [timeout] < 0, illegal");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString(PushConsts.CMD_ACTION, "setSocketTimeout");
        bundle.putInt("timeout", i);
        m4813a(context, bundle);
        return true;
    }

    public int setTag(Context context, Tag[] tagArr, String str) {
        if (tagArr == null) {
            Log.e("PushManager", "call -> setTag failed, parameter [tags] is null");
            ActivityC0460a.m1698b("PushManager|tags is null");
            return PushConsts.SETTAG_ERROR_NULL;
        } else if (str == null) {
            Log.e("PushManager", "call -> setTag failed, parameter [sn] is null");
            ActivityC0460a.m1698b("PushManager|sn is null");
            return PushConsts.SETTAG_SN_NULL;
        } else if (((long) tagArr.length) > 200) {
            Log.e("PushManager", "call -> setTag failed, parameter [tags] len > 200 is exceeds");
            ActivityC0460a.m1698b("PushManager|tags len > 200 is exceeds");
            return PushConsts.SETTAG_ERROR_COUNT;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f3049a < 1000) {
                Log.e("PushManager", "call - > setTag failed, it be called too frequently");
                return PushConsts.SETTAG_ERROR_FREQUENCY;
            }
            StringBuilder sb = new StringBuilder();
            for (Tag tag : tagArr) {
                if (!(tag == null || tag.getName() == null)) {
                    sb.append(tag.getName());
                    sb.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
                }
            }
            if (sb.length() <= 0) {
                return PushConsts.SETTAG_ERROR_NULL;
            }
            sb.deleteCharAt(sb.length() - 1);
            Bundle bundle = new Bundle();
            bundle.putString(PushConsts.CMD_ACTION, "setTag");
            bundle.putString("tags", sb.toString());
            bundle.putString("sn", str);
            this.f3049a = currentTimeMillis;
            m4813a(context, bundle);
            return 0;
        }
    }

    public void stopService(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString(PushConsts.CMD_ACTION, "stopService");
        m4813a(context, bundle);
    }

    public void turnOffPush(Context context) {
        ActivityC0460a.m1698b("PushManager|call turnOffPush");
        Bundle bundle = new Bundle();
        bundle.putString(PushConsts.CMD_ACTION, "turnOffPush");
        m4813a(context, bundle);
    }

    public void turnOnPush(Context context) {
        ActivityC0460a.m1698b("PushManager|call turnOnPush");
        Intent intent = new Intent(context.getApplicationContext(), m4811a(context));
        intent.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_SERVICE_INITIALIZE_SLAVE);
        intent.putExtra("op_app", context.getApplicationContext().getPackageName());
        intent.putExtra("isSlave", true);
        context.getApplicationContext().startService(intent);
    }

    public boolean unBindAlias(Context context, String str, boolean z) {
        ActivityC0460a.m1698b("PushManager|call unBindAlias");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f3051c < 5000) {
            Log.e("PushManager", "call - > unBindAlias failed, it be called too frequently");
            return false;
        }
        this.f3051c = currentTimeMillis;
        Bundle bundle = new Bundle();
        bundle.putString(PushConsts.CMD_ACTION, "unbindAlias");
        bundle.putString("alias", str);
        bundle.putBoolean("isSeft", z);
        m4813a(context, bundle);
        return true;
    }
}
