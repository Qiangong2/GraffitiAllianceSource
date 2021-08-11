package com.xiaomi.mipush.sdk;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PushMessageHandler extends IntentService {

    /* renamed from: a */
    private static List<MiPushClient.MiPushClientCallback> f4851a = new ArrayList();

    /* access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.mipush.sdk.PushMessageHandler$a */
    public interface AbstractC1899a extends Serializable {
    }

    public PushMessageHandler() {
        super("mipush message handler");
    }

    /* renamed from: a */
    protected static void m6938a() {
        synchronized (f4851a) {
            f4851a.clear();
        }
    }

    /* renamed from: a */
    public static void m6939a(long j, String str, String str2) {
        synchronized (f4851a) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : f4851a) {
                miPushClientCallback.onInitializeResult(j, str, str2);
            }
        }
    }

    /* renamed from: a */
    public static void m6940a(Context context, MiPushMessage miPushMessage) {
        synchronized (f4851a) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : f4851a) {
                if (m6945a(miPushMessage.getCategory(), miPushClientCallback.getCategory())) {
                    miPushClientCallback.onReceiveMessage(miPushMessage.getContent(), miPushMessage.getAlias(), miPushMessage.getTopic(), miPushMessage.isNotified());
                    miPushClientCallback.onReceiveMessage(miPushMessage);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m6941a(Context context, AbstractC1899a aVar) {
        String str = null;
        if (aVar instanceof MiPushMessage) {
            m6940a(context, (MiPushMessage) aVar);
        } else if (aVar instanceof MiPushCommandMessage) {
            MiPushCommandMessage miPushCommandMessage = (MiPushCommandMessage) aVar;
            String command = miPushCommandMessage.getCommand();
            if (MiPushClient.COMMAND_REGISTER.equals(command)) {
                List<String> commandArguments = miPushCommandMessage.getCommandArguments();
                if (commandArguments != null && !commandArguments.isEmpty()) {
                    str = commandArguments.get(0);
                }
                m6939a(miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), str);
            } else if (MiPushClient.COMMAND_SET_ALIAS.equals(command) || MiPushClient.COMMAND_UNSET_ALIAS.equals(command) || MiPushClient.COMMAND_SET_ACCEPT_TIME.equals(command)) {
                m6943a(context, miPushCommandMessage.getCategory(), command, miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), miPushCommandMessage.getCommandArguments());
            } else if (MiPushClient.COMMAND_SUBSCRIBE_TOPIC.equals(command)) {
                List<String> commandArguments2 = miPushCommandMessage.getCommandArguments();
                m6942a(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), (commandArguments2 == null || commandArguments2.isEmpty()) ? null : commandArguments2.get(0));
            } else if (MiPushClient.COMMAND_UNSUBSCRIBE_TOPIC.equals(command)) {
                List<String> commandArguments3 = miPushCommandMessage.getCommandArguments();
                m6946b(context, miPushCommandMessage.getCategory(), miPushCommandMessage.getResultCode(), miPushCommandMessage.getReason(), (commandArguments3 == null || commandArguments3.isEmpty()) ? null : commandArguments3.get(0));
            }
        }
    }

    /* renamed from: a */
    protected static void m6942a(Context context, String str, long j, String str2, String str3) {
        synchronized (f4851a) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : f4851a) {
                if (m6945a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onSubscribeResult(j, str2, str3);
                }
            }
        }
    }

    /* renamed from: a */
    protected static void m6943a(Context context, String str, String str2, long j, String str3, List<String> list) {
        synchronized (f4851a) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : f4851a) {
                if (m6945a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onCommandResult(str2, j, str3, list);
                }
            }
        }
    }

    /* renamed from: a */
    protected static void m6944a(MiPushClient.MiPushClientCallback miPushClientCallback) {
        synchronized (f4851a) {
            if (!f4851a.contains(miPushClientCallback)) {
                f4851a.add(miPushClientCallback);
            }
        }
    }

    /* renamed from: a */
    protected static boolean m6945a(String str, String str2) {
        return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || TextUtils.equals(str, str2);
    }

    /* renamed from: b */
    protected static void m6946b(Context context, String str, long j, String str2, String str3) {
        synchronized (f4851a) {
            for (MiPushClient.MiPushClientCallback miPushClientCallback : f4851a) {
                if (m6945a(str, miPushClientCallback.getCategory())) {
                    miPushClientCallback.onUnsubscribeResult(j, str2, str3);
                }
            }
        }
    }

    /* renamed from: b */
    public static boolean m6947b() {
        return f4851a.isEmpty();
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        ResolveInfo resolveInfo;
        try {
            if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
                if (C1900a.m6949a(this).mo10182i()) {
                    C1910g.m6998a(this).mo10201a();
                }
            } else if (1 != PushMessageHelper.getPushMode(this)) {
                Intent intent2 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                intent2.setPackage(getPackageName());
                intent2.putExtras(intent);
                List<ResolveInfo> queryBroadcastReceivers = getPackageManager().queryBroadcastReceivers(intent2, 32);
                if (queryBroadcastReceivers != null) {
                    Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        resolveInfo = it.next();
                        if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.packageName.equals(getPackageName())) {
                            break;
                        }
                    }
                }
                resolveInfo = null;
                if (resolveInfo != null) {
                    ((PushMessageReceiver) Class.forName(resolveInfo.activityInfo.name).newInstance()).onReceive(getApplicationContext(), intent2);
                } else {
                    AbstractC1855b.m6723d("cannot find the receiver to handler this message, check your manifest");
                }
            } else if (m6947b()) {
                AbstractC1855b.m6723d("receive a message before application calling initialize");
            } else {
                AbstractC1899a a = C1908f.m6991a(this).mo10199a(intent);
                if (a != null) {
                    m6941a(this, a);
                }
            }
        } catch (Exception e) {
            AbstractC1855b.m6720a(e);
        } catch (Throwable th) {
            AbstractC1855b.m6720a(th);
        }
    }
}
