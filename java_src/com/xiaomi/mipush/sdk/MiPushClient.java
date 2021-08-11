package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.umeng.analytics.C1370a;
import com.umeng.analytics.p091b.C1447g;
import com.xiaomi.channel.commonutils.android.AbstractC1850a;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.channel.commonutils.string.C1873d;
import com.xiaomi.xmpush.thrift.C2067c;
import com.xiaomi.xmpush.thrift.C2073f;
import com.xiaomi.xmpush.thrift.C2079i;
import com.xiaomi.xmpush.thrift.C2081j;
import com.xiaomi.xmpush.thrift.C2091o;
import com.xiaomi.xmpush.thrift.C2095q;
import com.xiaomi.xmpush.thrift.C2099s;
import com.xiaomi.xmpush.thrift.EnumC2064a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

public abstract class MiPushClient {
    public static final String ACCEPT_TIME_SEPARATOR = ",";
    public static final String COMMAND_REGISTER = "register";
    public static final String COMMAND_SET_ACCEPT_TIME = "accept-time";
    public static final String COMMAND_SET_ACCOUNT = "set-account";
    public static final String COMMAND_SET_ALIAS = "set-alias";
    public static final String COMMAND_SUBSCRIBE_TOPIC = "subscribe-topic";
    public static final String COMMAND_UNSET_ACCOUNT = "unset-account";
    public static final String COMMAND_UNSET_ALIAS = "unset-alias";
    public static final String COMMAND_UNSUBSCRIBE_TOPIC = "unsubscibe-topic";
    private static boolean awakeService = true;
    private static Context sContext;
    private static long sCurMsgId = System.currentTimeMillis();

    @Deprecated
    public static abstract class MiPushClientCallback {
        private String category;

        /* access modifiers changed from: protected */
        public String getCategory() {
            return this.category;
        }

        public void onCommandResult(String str, long j, String str2, List<String> list) {
        }

        public void onInitializeResult(long j, String str, String str2) {
        }

        public void onReceiveMessage(MiPushMessage miPushMessage) {
        }

        public void onReceiveMessage(String str, String str2, String str3, boolean z) {
        }

        public void onSubscribeResult(long j, String str, String str2) {
        }

        public void onUnsubscribeResult(long j, String str, String str2) {
        }

        /* access modifiers changed from: protected */
        public void setCategory(String str) {
            this.category = str;
        }
    }

    /* renamed from: com.xiaomi.mipush.sdk.MiPushClient$a */
    public static class C1898a extends Exception {

        /* renamed from: a */
        private PackageItemInfo f4850a;

        public C1898a(String str, PackageItemInfo packageItemInfo) {
            super(str);
            this.f4850a = packageItemInfo;
        }
    }

    private static boolean acceptTimeSet(Context context, String str, String str2) {
        return TextUtils.equals(context.getSharedPreferences("mipush_extra", 0).getString("accept_time", ""), str + ACCEPT_TIME_SEPARATOR + str2);
    }

    public static long accountSetTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("account_" + str, -1);
    }

    static synchronized void addAcceptTime(Context context, String str, String str2) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putString("accept_time", str + ACCEPT_TIME_SEPARATOR + str2).commit();
        }
    }

    static synchronized void addAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("account_" + str, System.currentTimeMillis()).commit();
        }
    }

    static synchronized void addAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("alias_" + str, System.currentTimeMillis()).commit();
        }
    }

    private static void addPullNotificationTime(Context context) {
        context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_pull_notification", System.currentTimeMillis()).commit();
    }

    private static void addRegRequestTime(Context context) {
        context.getSharedPreferences("mipush_extra", 0).edit().putLong("last_reg_request", System.currentTimeMillis()).commit();
    }

    static synchronized void addTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().putLong("topic_" + str, System.currentTimeMillis()).commit();
        }
    }

    public static long aliasSetTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("alias_" + str, -1);
    }

    private static void awakePushServices(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        if (System.currentTimeMillis() - 600000 >= sharedPreferences.getLong("wake_up", 0)) {
            sharedPreferences.edit().putLong("wake_up", System.currentTimeMillis()).commit();
            new Thread(new RunnableC1905d(context)).start();
        }
    }

    public static void checkManifest(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4100);
            checkReceivers(context);
            checkServices(context, packageInfo);
            checkPermissions(context, packageInfo);
        } catch (PackageManager.NameNotFoundException e) {
            AbstractC1855b.m6720a(e);
        }
    }

    private static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException("param " + str + " is not nullable");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void checkPermissions(android.content.Context r9, android.content.pm.PackageInfo r10) {
        /*
        // Method dump skipped, instructions count: 183
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.MiPushClient.checkPermissions(android.content.Context, android.content.pm.PackageInfo):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0090 A[EDGE_INSN: B:29:0x0090->B:17:0x0090 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void checkReceivers(android.content.Context r9) {
        /*
        // Method dump skipped, instructions count: 172
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.MiPushClient.checkReceivers(android.content.Context):void");
    }

    private static void checkServices(Context context, PackageInfo packageInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put("com.xiaomi.push.service.XMPushService", new Boolean[]{true, false});
        hashMap.put(PushMessageHandler.class.getCanonicalName(), new Boolean[]{true, true});
        hashMap.put(MessageHandleService.class.getCanonicalName(), new Boolean[]{true, false});
        if (packageInfo.services != null) {
            ServiceInfo[] serviceInfoArr = packageInfo.services;
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (!TextUtils.isEmpty(serviceInfo.name) && hashMap.containsKey(serviceInfo.name)) {
                    Boolean[] boolArr = (Boolean[]) hashMap.remove(serviceInfo.name);
                    if (boolArr[0].booleanValue() != serviceInfo.enabled) {
                        throw new C1898a(String.format("Wrong attribute: %n    <service android:name=\"%1$s\" .../> android:enabled should be %<b.", serviceInfo.name, boolArr[0]), serviceInfo);
                    } else if (boolArr[1].booleanValue() != serviceInfo.exported) {
                        throw new C1898a(String.format("Wrong attribute: %n    <service android:name=\"%1$s\" .../> android:exported should be %<b.", serviceInfo.name, boolArr[1]), serviceInfo);
                    } else if (hashMap.isEmpty()) {
                        break;
                    }
                }
            }
        }
        if (!hashMap.isEmpty()) {
            throw new C1898a(String.format("<service android:name=\"%1$s\" /> is missing or disabled.", hashMap.keySet().iterator().next()), null);
        }
    }

    protected static void clearExtras(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        long j = sharedPreferences.getLong("wake_up", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.clear();
        if (j > 0) {
            edit.putLong("wake_up", j);
        }
        edit.commit();
    }

    public static void clearLocalNotificationType(Context context) {
        C1910g.m6998a(context).mo10215e();
    }

    public static void clearNotification(Context context) {
        C1910g.m6998a(context).mo10202a(-1);
    }

    public static void clearNotification(Context context, int i) {
        C1910g.m6998a(context).mo10202a(i);
    }

    private static void findAndCheckReceiverInfo(PackageManager packageManager, Intent intent, Class<?> cls, Boolean[] boolArr) {
        boolean z;
        Iterator<ResolveInfo> it = packageManager.queryBroadcastReceivers(intent, 16384).iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            ActivityInfo activityInfo = it.next().activityInfo;
            if (activityInfo != null && cls.getCanonicalName().equals(activityInfo.name)) {
                if (boolArr[0].booleanValue() != activityInfo.enabled) {
                    throw new C1898a(String.format("Wrong attribute: %n    <receiver android:name=\"%1$s\" .../> android:enabled should be %<b.", activityInfo.name, boolArr[0]), activityInfo);
                } else if (boolArr[1].booleanValue() != activityInfo.exported) {
                    throw new C1898a(String.format("Wrong attribute: %n    <receiver android:name=\"%1$s\" .../> android:exported should be %<b.", activityInfo.name, boolArr[1]), activityInfo);
                } else {
                    z = true;
                }
            }
        }
        if (!z) {
            throw new C1898a(String.format("<receiver android:name=\"%1$s\" /> is missing or disabled.", cls.getCanonicalName()), null);
        }
    }

    protected static synchronized String generatePacketID() {
        String str;
        synchronized (MiPushClient.class) {
            str = C1873d.m6781a(4) + sCurMsgId;
            sCurMsgId++;
        }
        return str;
    }

    public static List<String> getAllAlias(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("alias_")) {
                arrayList.add(str.substring("alias_".length()));
            }
        }
        return arrayList;
    }

    public static List<String> getAllTopic(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("topic_") && !str.contains("**ALL**")) {
                arrayList.add(str.substring("topic_".length()));
            }
        }
        return arrayList;
    }

    public static List<String> getAllUserAccount(Context context) {
        ArrayList arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("account_")) {
                arrayList.add(str.substring("account_".length()));
            }
        }
        return arrayList;
    }

    public static String getRegId(Context context) {
        if (C1900a.m6949a(context).mo10182i()) {
            return C1900a.m6949a(context).mo10178e();
        }
        return null;
    }

    @Deprecated
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback) {
        boolean z = false;
        checkNotNull(context, C1447g.f3472aI);
        checkNotNull(str, "appID");
        checkNotNull(str2, "appToken");
        try {
            sContext = context.getApplicationContext();
            if (sContext == null) {
                sContext = context;
            }
            if (miPushClientCallback != null) {
                PushMessageHandler.m6944a(miPushClientCallback);
            }
            if (C1900a.m6949a(sContext).mo10186m() != Constants.m6935a()) {
                z = true;
            }
            if (z || shouldSendRegRequest(sContext)) {
                if (z || !C1900a.m6949a(sContext).mo10173a(str, str2) || C1900a.m6949a(sContext).mo10187n()) {
                    String a = C1873d.m6781a(6);
                    C1900a.m6949a(sContext).mo10181h();
                    C1900a.m6949a(sContext).mo10168a(Constants.m6935a());
                    C1900a.m6949a(sContext).mo10170a(str, str2, a);
                    clearExtras(sContext);
                    C2081j jVar = new C2081j();
                    jVar.mo10880a(generatePacketID());
                    jVar.mo10884b(str);
                    jVar.mo10891e(str2);
                    jVar.mo10889d(context.getPackageName());
                    jVar.mo10894f(a);
                    jVar.mo10886c(C1900a.m6950a(context, context.getPackageName()));
                    C1910g.m6998a(sContext).mo10203a(jVar, z);
                } else {
                    if (1 == PushMessageHelper.getPushMode(context)) {
                        checkNotNull(miPushClientCallback, "callback");
                        miPushClientCallback.onInitializeResult(0, null, C1900a.m6949a(context).mo10178e());
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(C1900a.m6949a(context).mo10178e());
                        PushMessageHelper.sendCommandMessageBroadcast(sContext, PushMessageHelper.generateCommandMessage(COMMAND_REGISTER, arrayList, 0, null, null));
                    }
                    C1910g.m6998a(context).mo10201a();
                    if (C1900a.m6949a(sContext).mo10172a()) {
                        C2079i iVar = new C2079i();
                        iVar.mo10861b(C1900a.m6949a(context).mo10176c());
                        iVar.mo10864c("client_info_update");
                        iVar.mo10855a(generatePacketID());
                        iVar.f5774h = new HashMap();
                        iVar.f5774h.put(C1447g.f3509d, C1900a.m6950a(sContext, sContext.getPackageName()));
                        String g = C1900a.m6949a(sContext).mo10180g();
                        if (!TextUtils.isEmpty(g)) {
                            iVar.f5774h.put("deviceid", g);
                        }
                        C1910g.m6998a(context).mo10207a(iVar, EnumC2064a.Notification, false, null);
                    }
                    if (!AbstractC1850a.m6700a(sContext, "update_devId", false)) {
                        updateIMEI();
                        AbstractC1850a.m6701b(sContext, "update_devId", true);
                    }
                    if (shouldUseMIUIPush(sContext) && shouldPullNotification(sContext)) {
                        C2079i iVar2 = new C2079i();
                        iVar2.mo10861b(C1900a.m6949a(sContext).mo10176c());
                        iVar2.mo10864c("pull");
                        iVar2.mo10855a(generatePacketID());
                        iVar2.mo10857a(false);
                        C1910g.m6998a(sContext).mo10208a(iVar2, EnumC2064a.Notification, false, null, false);
                        addPullNotificationTime(sContext);
                    }
                }
                if (awakeService) {
                    awakePushServices(sContext);
                }
                addRegRequestTime(sContext);
                return;
            }
            C1910g.m6998a(context).mo10201a();
            AbstractC1855b.m6718a("Could not send  register message within 5s repeatly .");
        } catch (Throwable th) {
            AbstractC1855b.m6720a(th);
        }
    }

    public static void pausePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 0, 0, str);
    }

    static void reInitialize(Context context) {
        if (C1900a.m6949a(context).mo10182i()) {
            String a = C1873d.m6781a(6);
            String c = C1900a.m6949a(context).mo10176c();
            String d = C1900a.m6949a(context).mo10177d();
            C1900a.m6949a(context).mo10181h();
            C1900a.m6949a(context).mo10170a(c, d, a);
            C2081j jVar = new C2081j();
            jVar.mo10880a(generatePacketID());
            jVar.mo10884b(c);
            jVar.mo10891e(d);
            jVar.mo10894f(a);
            jVar.mo10889d(context.getPackageName());
            jVar.mo10886c(C1900a.m6950a(context, context.getPackageName()));
            C1910g.m6998a(context).mo10203a(jVar, false);
        }
    }

    public static void registerPush(Context context, String str, String str2) {
        new Thread(new RunnableC1903b(context, str, str2)).start();
    }

    static synchronized void removeAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("account_" + str).commit();
        }
    }

    static synchronized void removeAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("alias_" + str).commit();
        }
    }

    static synchronized void removeTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            context.getSharedPreferences("mipush_extra", 0).edit().remove("topic_" + str).commit();
        }
    }

    static void reportIgnoreRegMessageClicked(Context context, String str, C2067c cVar, String str2, String str3) {
        C2079i iVar = new C2079i();
        if (TextUtils.isEmpty(str3)) {
            AbstractC1855b.m6723d("do not report clicked message");
            return;
        }
        iVar.mo10861b(str3);
        iVar.mo10864c("bar:click");
        iVar.mo10855a(str);
        iVar.mo10857a(false);
        C1910g.m6998a(context).mo10210a(iVar, EnumC2064a.Notification, false, true, cVar, true, str2, str3);
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        C2067c cVar = new C2067c();
        cVar.mo10696a(miPushMessage.getMessageId());
        cVar.mo10703b(miPushMessage.getTopic());
        cVar.mo10712d(miPushMessage.getDescription());
        cVar.mo10707c(miPushMessage.getTitle());
        cVar.mo10706c(miPushMessage.getNotifyId());
        cVar.mo10695a(miPushMessage.getNotifyType());
        cVar.mo10702b(miPushMessage.getPassThrough());
        cVar.mo10697a(miPushMessage.getExtra());
        reportMessageClicked(context, miPushMessage.getMessageId(), cVar, null);
    }

    @Deprecated
    public static void reportMessageClicked(Context context, String str) {
        reportMessageClicked(context, str, null, null);
    }

    static void reportMessageClicked(Context context, String str, C2067c cVar, String str2) {
        C2079i iVar = new C2079i();
        if (!TextUtils.isEmpty(str2)) {
            iVar.mo10861b(str2);
        } else if (C1900a.m6949a(context).mo10175b()) {
            iVar.mo10861b(C1900a.m6949a(context).mo10176c());
        } else {
            AbstractC1855b.m6723d("do not report clicked message");
            return;
        }
        iVar.mo10864c("bar:click");
        iVar.mo10855a(str);
        iVar.mo10857a(false);
        C1910g.m6998a(context).mo10207a(iVar, EnumC2064a.Notification, false, cVar);
    }

    public static void resumePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 23, 59, str);
    }

    public static void setAcceptTime(Context context, int i, int i2, int i3, int i4, String str) {
        if (i < 0 || i >= 24 || i3 < 0 || i3 >= 24 || i2 < 0 || i2 >= 60 || i4 < 0 || i4 >= 60) {
            throw new IllegalArgumentException("the input parameter is not valid.");
        }
        long rawOffset = (long) (((TimeZone.getTimeZone("GMT+08").getRawOffset() - TimeZone.getDefault().getRawOffset()) / 1000) / 60);
        long j = ((((long) ((i * 60) + i2)) + rawOffset) + 1440) % 1440;
        long j2 = ((rawOffset + ((long) ((i3 * 60) + i4))) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j / 60), Long.valueOf(j % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60)));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i), Integer.valueOf(i2)));
        arrayList2.add(String.format("%1$02d:%2$02d", Integer.valueOf(i3), Integer.valueOf(i4)));
        if (!acceptTimeSet(context, (String) arrayList.get(0), (String) arrayList.get(1))) {
            setCommand(context, COMMAND_SET_ACCEPT_TIME, arrayList, str);
        } else if (1 == PushMessageHelper.getPushMode(context)) {
            PushMessageHandler.m6943a(context, str, COMMAND_SET_ACCEPT_TIME, 0, null, arrayList2);
        } else {
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(COMMAND_SET_ACCEPT_TIME, arrayList2, 0, null, null));
        }
    }

    public static void setAlias(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            setCommand(context, COMMAND_SET_ALIAS, str, str2);
        }
    }

    protected static void setCommand(Context context, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        if (!COMMAND_SET_ALIAS.equalsIgnoreCase(str) || System.currentTimeMillis() - aliasSetTime(context, str2) >= C1370a.f3218j) {
            if (COMMAND_UNSET_ALIAS.equalsIgnoreCase(str) && aliasSetTime(context, str2) < 0) {
                AbstractC1855b.m6718a("Don't cancel alias for " + arrayList + " is unseted");
            } else if (!COMMAND_SET_ACCOUNT.equalsIgnoreCase(str) || System.currentTimeMillis() - accountSetTime(context, str2) >= C1370a.f3218j) {
                if (!COMMAND_UNSET_ACCOUNT.equalsIgnoreCase(str) || accountSetTime(context, str2) >= 0) {
                    setCommand(context, str, arrayList, str3);
                } else {
                    AbstractC1855b.m6718a("Don't cancel account for " + arrayList + " is unseted");
                }
            } else if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.m6943a(context, str3, str, 0, null, arrayList);
            } else {
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(COMMAND_SET_ACCOUNT, arrayList, 0, null, null));
            }
        } else if (1 == PushMessageHelper.getPushMode(context)) {
            PushMessageHandler.m6943a(context, str3, str, 0, null, arrayList);
        } else {
            PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(COMMAND_SET_ALIAS, arrayList, 0, null, null));
        }
    }

    protected static void setCommand(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (!TextUtils.isEmpty(C1900a.m6949a(context).mo10176c())) {
            C2073f fVar = new C2073f();
            fVar.mo10778a(generatePacketID());
            fVar.mo10782b(C1900a.m6949a(context).mo10176c());
            fVar.mo10784c(str);
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                fVar.mo10787d(it.next());
            }
            fVar.mo10792f(str2);
            fVar.mo10789e(context.getPackageName());
            C1910g.m6998a(context).mo10205a(fVar, EnumC2064a.Command, (C2067c) null);
        }
    }

    public static void setLocalNotificationType(Context context, int i) {
        C1910g.m6998a(context).mo10211b(i & -1);
    }

    public static void setUserAccount(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            setCommand(context, COMMAND_SET_ACCOUNT, str, str2);
        }
    }

    private static boolean shouldPullNotification(Context context) {
        return System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1) > 300000;
    }

    private static boolean shouldSendRegRequest(Context context) {
        return System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1) > 5000;
    }

    public static boolean shouldUseMIUIPush(Context context) {
        return C1910g.m6998a(context).mo10212b();
    }

    public static void subscribe(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(C1900a.m6949a(context).mo10176c()) && !TextUtils.isEmpty(str)) {
            if (System.currentTimeMillis() - topicSubscribedTime(context, str) > C1370a.f3217i) {
                C2091o oVar = new C2091o();
                oVar.mo10984a(generatePacketID());
                oVar.mo10988b(C1900a.m6949a(context).mo10176c());
                oVar.mo10990c(str);
                oVar.mo10993d(context.getPackageName());
                oVar.mo10995e(str2);
                C1910g.m6998a(context).mo10205a(oVar, EnumC2064a.Subscription, (C2067c) null);
            } else if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.m6942a(context, str2, 0, null, str);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(COMMAND_SUBSCRIBE_TOPIC, arrayList, 0, null, null));
            }
        }
    }

    public static long topicSubscribedTime(Context context, String str) {
        return context.getSharedPreferences("mipush_extra", 0).getLong("topic_" + str, -1);
    }

    public static void unregisterPush(Context context) {
        if (C1900a.m6949a(context).mo10175b()) {
            C2095q qVar = new C2095q();
            qVar.mo11025a(generatePacketID());
            qVar.mo11029b(C1900a.m6949a(context).mo10176c());
            qVar.mo11031c(C1900a.m6949a(context).mo10178e());
            qVar.mo11036e(C1900a.m6949a(context).mo10177d());
            qVar.mo11034d(context.getPackageName());
            C1910g.m6998a(context).mo10204a(qVar);
            PushMessageHandler.m6938a();
            C1900a.m6949a(context).mo10184k();
            clearExtras(context);
            clearLocalNotificationType(context);
            clearNotification(context);
        }
    }

    public static void unsetAlias(Context context, String str, String str2) {
        setCommand(context, COMMAND_UNSET_ALIAS, str, str2);
    }

    public static void unsetUserAccount(Context context, String str, String str2) {
        setCommand(context, COMMAND_UNSET_ACCOUNT, str, str2);
    }

    public static void unsubscribe(Context context, String str, String str2) {
        if (C1900a.m6949a(context).mo10175b()) {
            if (topicSubscribedTime(context, str) < 0) {
                AbstractC1855b.m6718a("Don't cancel subscribe for " + str + " is unsubscribed");
                return;
            }
            C2099s sVar = new C2099s();
            sVar.mo11065a(generatePacketID());
            sVar.mo11069b(C1900a.m6949a(context).mo10176c());
            sVar.mo11071c(str);
            sVar.mo11074d(context.getPackageName());
            sVar.mo11076e(str2);
            C1910g.m6998a(context).mo10205a(sVar, EnumC2064a.UnSubscription, (C2067c) null);
        }
    }

    private static void updateIMEI() {
        new Thread(new RunnableC1904c()).start();
    }
}
