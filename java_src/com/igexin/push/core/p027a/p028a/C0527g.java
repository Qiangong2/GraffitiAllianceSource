package com.igexin.push.core.p027a.p028a;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.config.C0513j;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.EnumC0554b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.C0595h;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.util.C1151a;
import com.igexin.sdk.GTServiceManager;
import com.igexin.sdk.PushConsts;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.igexin.push.core.a.a.g */
public class C0527g implements AbstractC0521a {

    /* renamed from: a */
    private static final String f1354a = C0513j.f1294a;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002a  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m1993a(com.igexin.push.core.bean.C0595h r8, boolean r9) {
        /*
        // Method dump skipped, instructions count: 257
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.p027a.p028a.C0527g.m1993a(com.igexin.push.core.bean.h, boolean):int");
    }

    /* renamed from: a */
    private PendingIntent m1994a(String str, String str2, String str3, int i) {
        Intent intent = new Intent("com.igexin.sdk.action.doaction");
        intent.putExtra("taskid", str);
        intent.putExtra("messageid", str2);
        intent.putExtra("appid", C0618g.f1602a);
        intent.putExtra("actionid", str3);
        intent.putExtra("accesstoken", C0618g.f1622ar);
        intent.putExtra("notifID", i);
        Intent intent2 = new Intent(C0618g.f1635f, GTServiceManager.getInstance().getUserPushService(C0618g.f1635f));
        intent2.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_BROADCAST_NOTIFICATION_CLICK);
        intent2.putExtra("broadcast_intent", intent);
        return PendingIntent.getService(C0618g.f1635f, new Random().nextInt(1000), intent2, 134217728);
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public EnumC0554b mo4352a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return EnumC0554b.success;
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public BaseAction mo4353a(JSONObject jSONObject) {
        try {
            C0595h hVar = new C0595h();
            hVar.setType("notification");
            hVar.setActionId(jSONObject.getString("actionid"));
            hVar.setDoActionId(jSONObject.getString("do"));
            String string = jSONObject.getString("title");
            String string2 = jSONObject.getString("text");
            hVar.mo4526a(string);
            hVar.mo4529b(string2);
            if (jSONObject.has("logo") && !"".equals(jSONObject.getString("logo"))) {
                String string3 = jSONObject.getString("logo");
                if (string3.lastIndexOf(".png") == -1 && string3.lastIndexOf(".jpeg") == -1) {
                    string3 = "";
                } else {
                    int indexOf = string3.indexOf(".png");
                    if (indexOf == -1) {
                        indexOf = string3.indexOf(".jpeg");
                    }
                    if (indexOf != -1) {
                        string3 = string3.substring(0, indexOf);
                        if (Pattern.compile("^\\d+$").matcher(string3).matches()) {
                            string3 = "";
                        }
                    }
                }
                hVar.mo4531c(string3);
            }
            if (jSONObject.has("is_noclear")) {
                hVar.mo4527a(jSONObject.getBoolean("is_noclear"));
            }
            if (jSONObject.has("is_novibrate")) {
                hVar.mo4530b(jSONObject.getBoolean("is_novibrate"));
            }
            if (jSONObject.has("is_noring")) {
                hVar.mo4532c(jSONObject.getBoolean("is_noring"));
            }
            if (jSONObject.has("is_chklayout")) {
                hVar.mo4535d(jSONObject.getBoolean("is_chklayout"));
            }
            if (jSONObject.has("logo_url")) {
                hVar.mo4534d(jSONObject.getString("logo_url"));
            }
            if (jSONObject.has("banner_url")) {
                hVar.mo4537e(jSONObject.getString("banner_url"));
            }
            return hVar;
        } catch (JSONException e) {
            return null;
        }
    }

    /* renamed from: a */
    public void mo4356a(String str, String str2, C0595h hVar) {
        Notification notification;
        int currentTimeMillis = (int) System.currentTimeMillis();
        C0618g.f1613ai.put(str, Integer.valueOf(currentTimeMillis));
        PendingIntent a = m1994a(str, str2, hVar.getDoActionId(), currentTimeMillis);
        NotificationManager notificationManager = (NotificationManager) C0618g.f1635f.getSystemService("notification");
        int a2 = m1993a(hVar, false);
        if (Build.VERSION.SDK_INT < 11) {
            notification = new Notification();
            notification.icon = a2;
            try {
                Method method = Class.forName("android.app.Notification").getMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class);
                method.setAccessible(true);
                method.invoke(notification, C0618g.f1635f, hVar.mo4525a(), hVar.mo4528b(), a);
            } catch (Exception e) {
                ActivityC0460a.m1698b(f1354a + "reflect invoke setLatestEventInfo failed!");
                return;
            }
        } else {
            notification = new Notification.Builder(C0618g.f1635f).setContentTitle(hVar.mo4525a()).setContentText(hVar.mo4528b()).setSmallIcon(m1993a(hVar, true)).setLargeIcon(BitmapFactory.decodeResource(C0618g.f1635f.getResources(), a2)).setContentIntent(a).getNotification();
            if (C1151a.m4753f() && Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 24) {
                try {
                    Field field = Class.forName("com.android.internal.R$id").getField("right_icon");
                    field.setAccessible(true);
                    int i = field.getInt(null);
                    if (!(notification.contentView == null || i == 0)) {
                        notification.contentView.setViewVisibility(i, 8);
                    }
                } catch (Exception e2) {
                }
            }
        }
        notification.tickerText = hVar.mo4528b();
        notification.defaults = 4;
        notification.ledARGB = -16711936;
        notification.ledOnMS = 1000;
        notification.ledOffMS = 3000;
        notification.flags = 1;
        if (!hVar.mo4533c()) {
            notification.flags |= 16;
        } else {
            notification.flags |= 32;
        }
        if (!hVar.mo4538e()) {
            notification.defaults |= 1;
        }
        if (!hVar.mo4536d()) {
            notification.defaults |= 2;
        }
        if ((hVar.mo4541h() == null && hVar.mo4540g() == null) || !hVar.mo4542i()) {
            notificationManager.notify(currentTimeMillis, notification);
        }
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        if (pushTaskBean == null || baseAction == null || !(baseAction instanceof C0595h)) {
            return true;
        }
        C0595h hVar = (C0595h) baseAction;
        if (TextUtils.isEmpty(hVar.mo4525a()) || TextUtils.isEmpty(hVar.mo4528b())) {
            ActivityC0460a.m1697a(f1354a, "title = " + hVar.mo4525a() + ", content = " + hVar.mo4528b() + ", is invalid, don't show");
            ActivityC0460a.m1698b(f1354a + " title = " + hVar.mo4525a() + ", content = " + hVar.mo4528b() + ", is invalid, don't show");
            return true;
        }
        mo4356a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), hVar);
        return true;
    }
}
