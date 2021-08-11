package com.igexin.push.extension.distribution.basic.p037a;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.p007v4.app.NotificationCompat;
import android.text.Html;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.core.p027a.p028a.AbstractC0521a;
import com.igexin.push.extension.distribution.basic.headsup.C0786j;
import com.igexin.push.extension.distribution.basic.headsup.C0788l;
import com.igexin.push.extension.distribution.basic.headsup.C0789m;
import com.igexin.push.extension.distribution.basic.p041b.C0725m;
import com.igexin.push.extension.distribution.basic.p042c.C0744j;
import com.igexin.push.extension.distribution.basic.p042c.EnumC0736b;
import com.igexin.push.extension.distribution.basic.p042c.EnumC0737c;
import com.igexin.push.extension.distribution.basic.p053h.C0768a;
import com.igexin.push.extension.distribution.basic.p053h.C0771d;
import com.igexin.push.extension.distribution.basic.p060k.C0992l;
import com.igexin.push.extension.distribution.basic.util.C0997c;
import com.igexin.push.extension.distribution.basic.util.C0999e;
import com.igexin.push.extension.distribution.basic.util.C1001g;
import com.igexin.push.extension.distribution.basic.util.C1003i;
import com.igexin.push.extension.distribution.basic.util.C1007m;
import com.igexin.push.extension.distribution.basic.util.C1009o;
import com.igexin.push.extension.distribution.basic.util.C1010p;
import com.igexin.sdk.PushBuildConfig;
import com.igexin.sdk.PushConsts;
import com.tencent.qcloud.core.util.IOUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* renamed from: com.igexin.push.extension.distribution.basic.a.o */
public class C0701o implements AbstractC0521a {

    /* renamed from: a */
    private static final String f1868a = ("EXT-" + C0701o.class.getName());

    /* renamed from: a */
    private int m2724a() {
        try {
            Field field = Class.forName("com.android.internal.R$id").getField("icon");
            field.setAccessible(true);
            return field.getInt(null);
        } catch (Exception e) {
            return 0;
        }
    }

    /* renamed from: a */
    private int m2725a(C0725m mVar, boolean z) {
        if (z) {
            int identifier = C0618g.f1635f.getResources().getIdentifier("push_small", "drawable", C0618g.f1634e);
            if (identifier == 0) {
                identifier = C0618g.f1635f.getResources().getIdentifier("push_small", "mipmap", C0618g.f1634e);
            }
            if (identifier != 0) {
                ActivityC0460a.m1698b(f1868a + "|push_small.png is set, use default push_small");
                return identifier;
            }
            ActivityC0460a.m1698b(f1868a + "|push_small.png is missing");
        }
        int identifier2 = C0618g.f1635f.getResources().getIdentifier("push", "drawable", C0618g.f1634e);
        if (identifier2 == 0) {
            identifier2 = C0618g.f1635f.getResources().getIdentifier("push", "mipmap", C0618g.f1634e);
        }
        if (TextUtils.isEmpty(mVar.mo4938p())) {
            if (identifier2 == 0) {
                identifier2 = 17301651;
            }
            return identifier2;
        } else if ("null".equals(mVar.mo4938p())) {
            return 17301651;
        } else {
            if (mVar.mo4938p().startsWith("@")) {
                String p = mVar.mo4938p();
                return p.substring(1, p.length()).endsWith("email") ? 17301647 : 17301651;
            }
            int identifier3 = C0618g.f1635f.getResources().getIdentifier(mVar.mo4938p(), "drawable", C0618g.f1634e);
            if (identifier3 == 0) {
                identifier3 = C0618g.f1635f.getResources().getIdentifier(mVar.mo4938p(), "mipmap", C0618g.f1634e);
            }
            if (identifier3 != 0) {
                return identifier3;
            }
            if (identifier2 != 0) {
                return identifier2;
            }
            return 17301651;
        }
    }

    /* renamed from: a */
    private Notification m2726a(Notification notification, C0725m mVar) {
        notification.defaults = 4;
        notification.ledARGB = -16711936;
        notification.ledOnMS = 1000;
        notification.ledOffMS = 3000;
        notification.flags = 1;
        if (!mVar.mo4937o()) {
            notification.defaults |= 1;
        }
        if (!mVar.mo4935m()) {
            notification.flags |= 16;
        } else {
            notification.flags |= 32;
        }
        if (!mVar.mo4936n()) {
            notification.defaults |= 2;
        }
        notification.icon = m2725a(mVar, true);
        return notification;
    }

    /* renamed from: a */
    private PendingIntent m2727a(String str, String str2, int i, C0725m mVar, boolean z) {
        Intent intent = new Intent("com.igexin.sdk.action.notification.burying.point");
        intent.putExtra("taskid", str);
        intent.putExtra("messageid", str2);
        intent.putExtra("appid", C0618g.f1602a);
        intent.putExtra("actionid", mVar.getDoActionId());
        intent.putExtra("accesstoken", C0744j.f2045d);
        intent.putExtra("notifID", i);
        intent.putExtra("notifyStyle", mVar.mo4947y() + "");
        intent.putExtra("id", mVar.mo4901c() + "");
        intent.putExtra("bigStyle", mVar.mo4913f() + "");
        intent.putExtra("isFloat", z);
        intent.putExtra("checkpackage", C0618g.f1635f.getPackageName());
        intent.putExtra("feedbackid", mVar.getActionId().substring(mVar.getActionId().length() - 1));
        if (PushBuildConfig.sdk_conf_version.compareTo("2.10.3.0") < 0) {
            return PendingIntent.getBroadcast(C0618g.f1635f, new Random().nextInt(1000), intent, 134217728);
        }
        try {
            Intent intent2 = new Intent(C0618g.f1635f, Class.forName(C1003i.m4035a(C0744j.f2042a)));
            intent2.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_BROADCAST_NOTIFICATION_CLICK);
            intent2.putExtra("broadcast_intent", intent);
            return PendingIntent.getService(C0618g.f1635f, new Random().nextInt(1000), intent2, 134217728);
        } catch (Throwable th) {
            return PendingIntent.getBroadcast(C0618g.f1635f, new Random().nextInt(1000), intent, 134217728);
        }
    }

    /* renamed from: b */
    private void m2728b(String str, String str2, C0725m mVar, int i) {
        Bitmap b;
        Bitmap b2;
        Bitmap b3;
        Bitmap b4;
        int a = m2725a(mVar, true);
        int a2 = m2725a(mVar, false);
        C0992l a3 = C0992l.m3982a(C0618g.f1635f);
        if (a3.mo5638a("getui_notification", "layout") != 0 && m2732d() && !mVar.mo4900b()) {
            int a4 = a3.mo5638a("getui_notification_bg", "id");
            int a5 = a3.mo5638a("getui_notification_icon", "id");
            int a6 = a3.mo5638a("getui_notification_date", "id");
            int a7 = a3.mo5638a("getui_notification_icon2", "id");
            int a8 = a3.mo5638a("getui_notification_headsup", "id");
            int a9 = a3.mo5638a("getui_icon_headsup", "id");
            int a10 = a3.mo5638a("getui_title_headsup", "id");
            int a11 = a3.mo5638a("getui_time_headsup", "id");
            int a12 = a3.mo5638a("getui_message_headsup", "id");
            int a13 = a3.mo5638a("getui_headsup_banner", "id");
            if (a4 != 0 && a5 != 0 && a6 != 0 && a7 != 0 && a8 != 0 && a9 != 0 && a10 != 0 && a11 != 0 && a12 != 0 && a13 != 0) {
                PendingIntent a14 = m2727a(str, str2, i, mVar, true);
                C0789m a15 = C0789m.m3318a(C0618g.f1635f);
                C0788l lVar = new C0788l(C0618g.f1635f);
                lVar.setContentTitle((CharSequence) mVar.mo4930k());
                String g = mVar.mo4917g();
                String t = mVar.mo4942t();
                String s = mVar.mo4941s();
                lVar.setSmallIcon(a);
                lVar.setContentIntent(a14);
                lVar.setContentText(mVar.mo4932l());
                lVar.mo5218b(mVar.mo4889C());
                if (mVar.mo4947y() == 4) {
                    if (t != null && !t.equals("") && (b4 = C1007m.m4045b(t)) != null) {
                        lVar.mo5217b(b4);
                        lVar.mo5212a(EnumC0736b.SMALLBANNER);
                    } else {
                        return;
                    }
                } else if (mVar.mo4947y() == 6) {
                    if (s == null || "".equals(s)) {
                        Bitmap decodeResource = BitmapFactory.decodeResource(C0618g.f1635f.getResources(), a2);
                        if (decodeResource != null) {
                            lVar.mo5222c(decodeResource);
                        }
                    } else {
                        Bitmap b5 = C1007m.m4045b(s);
                        if (b5 != null) {
                            lVar.mo5222c(b5);
                        }
                    }
                    if (mVar.mo4913f() == 1) {
                        if (!(g == null || "".equals(g) || (b3 = C1007m.m4045b(g)) == null)) {
                            lVar.mo5211a(b3);
                        }
                        lVar.mo5212a(EnumC0736b.PICTURE);
                    } else if (mVar.mo4913f() == 2) {
                        if (mVar.mo4909e() != null && !mVar.mo4909e().equals("")) {
                            if (mVar.mo4909e().length() > 100) {
                                lVar.mo5213a(mVar.mo4909e().substring(0, 100) + "...");
                            } else {
                                lVar.mo5213a(mVar.mo4909e());
                            }
                            lVar.mo5212a(EnumC0736b.TEXT);
                        }
                    } else if (mVar.mo4913f() == 3) {
                        if (!(g == null || "".equals(g) || (b2 = C1007m.m4045b(g)) == null)) {
                            lVar.mo5211a(b2);
                        }
                        if (!(t == null || t.equals("") || (b = C1007m.m4045b(t)) == null)) {
                            lVar.mo5217b(b);
                        }
                        lVar.mo5212a(EnumC0736b.BANNER);
                    }
                } else {
                    lVar.mo5212a(EnumC0736b.NONE);
                    if (s == null || "".equals(s)) {
                        Bitmap decodeResource2 = BitmapFactory.decodeResource(C0618g.f1635f.getResources(), a2);
                        if (decodeResource2 != null) {
                            lVar.mo5222c(decodeResource2);
                        }
                    } else {
                        Bitmap b6 = C1007m.m4045b(s);
                        if (b6 != null) {
                            lVar.mo5222c(b6);
                        }
                    }
                }
                C0789m.m3318a(C0618g.f1635f).mo5229a();
                C0786j a16 = lVar.mo5195a();
                a16.mo5180c(false);
                a15.mo5230a(i, a16);
            }
        }
    }

    /* renamed from: b */
    private boolean m2729b() {
        return C0618g.f1635f.getResources().getConfiguration().orientation != 2 && C0618g.f1635f.getResources().getConfiguration().orientation == 1;
    }

    @TargetApi(16)
    /* renamed from: c */
    private void m2730c(String str, String str2, C0725m mVar, int i) {
        Drawable a;
        Bitmap a2;
        Bitmap b;
        Bitmap b2;
        Bitmap b3;
        if (!mVar.mo4900b()) {
            String g = mVar.mo4917g();
            String t = mVar.mo4942t();
            String s = mVar.mo4941s();
            String D = mVar.mo4890D();
            C0618g.f1613ai.put(str, Integer.valueOf(i));
            PendingIntent a3 = m2727a(str, str2, i, mVar, false);
            NotificationManager notificationManager = (NotificationManager) C0618g.f1635f.getSystemService("notification");
            NotificationCompat.Builder builder = new NotificationCompat.Builder(C0618g.f1635f);
            builder.setContentText(mVar.mo4932l());
            builder.setContentTitle(mVar.mo4930k());
            RemoteViews remoteViews = null;
            RemoteViews remoteViews2 = null;
            if (mVar.mo4913f() == 1 || mVar.mo4913f() == 2) {
                C0992l a4 = C0992l.m3982a(C0618g.f1635f);
                int a5 = a4.mo5638a("getui_notification", "layout");
                remoteViews = new RemoteViews(C0618g.f1634e, a5);
                remoteViews2 = new RemoteViews(C0618g.f1634e, a5);
                boolean a6 = C0997c.m3999a(a5);
                if (a5 != 0) {
                    int a7 = a4.mo5638a("getui_big_default_Content", "id");
                    int a8 = a4.mo5638a("getui_big_bigview_defaultView", "id");
                    int a9 = a4.mo5638a("getui_big_bigtext_defaultView", "id");
                    int a10 = a4.mo5638a("getui_big_notification_icon", "id");
                    int a11 = a4.mo5638a("getui_big_notification_date", "id");
                    int a12 = a4.mo5638a("getui_big_notification_icon2", "id");
                    int a13 = a4.mo5638a("getui_big_notification_title", "id");
                    int a14 = a4.mo5638a("getui_big_notification_content", "id");
                    int a15 = a4.mo5638a("getui_big_notification_title_center", "id");
                    int a16 = a4.mo5638a("getui_notification_bg", "id");
                    int a17 = a4.mo5638a("getui_notification_icon", "id");
                    int a18 = a4.mo5638a("getui_notification_date", "id");
                    int a19 = a4.mo5638a("getui_notification_icon2", "id");
                    int a20 = a4.mo5638a("getui_notification_style1", "id");
                    int a21 = a4.mo5638a("getui_notification_style1_title", "id");
                    int a22 = a4.mo5638a("getui_notification_style1_content", "id");
                    if (a7 != 0 && a8 != 0 && a9 != 0 && a10 != 0 && a11 != 0 && a12 != 0 && a13 != 0 && a14 != 0 && a15 != 0 && a16 != 0 && a17 != 0 && a18 != 0 && a19 != 0 && a20 != 0 && a21 != 0 && a22 != 0) {
                        if (a6) {
                            try {
                                C1009o a23 = C1009o.m4050a(C0618g.f1635f);
                                remoteViews.setTextViewTextSize(a11, 0, a23.mo5657f());
                                remoteViews.setTextViewTextSize(a15, 0, a23.mo5655d());
                                remoteViews.setTextViewTextSize(a13, 0, a23.mo5655d());
                                remoteViews.setTextViewTextSize(a9, 0, a23.mo5656e());
                                remoteViews.setTextViewTextSize(a14, 0, a23.mo5656e());
                                remoteViews2.setTextViewTextSize(a18, 0, a23.mo5657f());
                                remoteViews2.setTextViewTextSize(a21, 0, a23.mo5655d());
                                remoteViews2.setTextViewTextSize(a22, 0, a23.mo5656e());
                                remoteViews.setTextColor(a11, a23.mo5654c());
                                remoteViews.setTextColor(a15, a23.mo5652a());
                                remoteViews.setTextColor(a13, a23.mo5652a());
                                remoteViews.setTextColor(a9, a23.mo5653b());
                                remoteViews.setTextColor(a14, a23.mo5653b());
                                remoteViews2.setTextColor(a18, a23.mo5654c());
                                remoteViews2.setTextColor(a21, a23.mo5652a());
                                remoteViews2.setTextColor(a22, a23.mo5653b());
                            } catch (Exception e) {
                            }
                        }
                        remoteViews.setViewVisibility(a16, 8);
                        remoteViews.setViewVisibility(a17, 8);
                        remoteViews.setViewVisibility(a18, 8);
                        remoteViews.setViewVisibility(a19, 8);
                        remoteViews.setViewVisibility(a7, 0);
                        if (mVar.mo4913f() == 1) {
                            remoteViews.setViewVisibility(a15, 8);
                        } else if (mVar.mo4913f() == 2) {
                            remoteViews.setViewVisibility(a13, 8);
                            remoteViews.setViewVisibility(a14, 8);
                            if (!a6 && C0999e.m4016a() && C0999e.m4017b()) {
                                remoteViews.setTextColor(a15, Color.rgb(32, 32, 32));
                            }
                            remoteViews.setTextViewText(a15, mVar.mo4930k());
                        }
                        remoteViews2.setViewVisibility(a20, 0);
                        remoteViews2.setViewVisibility(a16, 8);
                        remoteViews.setTextViewText(a14, mVar.mo4932l());
                        if (mVar.mo4889C()) {
                            String format = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
                            remoteViews.setTextViewText(a11, format);
                            remoteViews2.setTextViewText(a18, format);
                        }
                        if (!a6 && C0999e.m4016a() && C0999e.m4017b()) {
                            int rgb = Color.rgb(32, 32, 32);
                            remoteViews2.setTextColor(a21, rgb);
                            remoteViews.setTextColor(a13, rgb);
                        }
                        remoteViews.setTextViewText(a13, mVar.mo4930k());
                        remoteViews2.setTextViewText(a21, mVar.mo4930k());
                        remoteViews2.setTextViewText(a22, mVar.mo4932l());
                        if (g != null && !"".equals(g) && mVar.mo4913f() == 1 && (b = C1007m.m4045b(g)) != null) {
                            remoteViews.setViewVisibility(a8, 0);
                            remoteViews.setImageViewBitmap(a8, b);
                        }
                        if (mVar.mo4909e() != null && !mVar.mo4909e().equals("") && mVar.mo4913f() == 2) {
                            remoteViews.setViewVisibility(a9, 0);
                            if (!a6 && C0999e.m4016a() && C0999e.m4017b()) {
                                remoteViews.setTextColor(a9, Color.rgb(153, 153, 153));
                            }
                            if (mVar.mo4909e().length() > 100) {
                                remoteViews.setTextViewText(a9, mVar.mo4909e().substring(0, 100) + "...\n");
                            } else {
                                remoteViews.setTextViewText(a9, mVar.mo4909e() + IOUtils.LINE_SEPARATOR_UNIX);
                            }
                        }
                        if (s == null || s.equals("")) {
                            Bitmap decodeResource = BitmapFactory.decodeResource(C0618g.f1635f.getResources(), m2725a(mVar, false));
                            if (decodeResource != null) {
                                remoteViews2.setImageViewBitmap(a17, decodeResource);
                                remoteViews.setImageViewBitmap(a10, decodeResource);
                            }
                        } else {
                            Bitmap b4 = C1007m.m4045b(s);
                            if (b4 != null) {
                                remoteViews2.setImageViewBitmap(a17, b4);
                                remoteViews.setImageViewBitmap(a10, b4);
                            }
                        }
                        if (D != null) {
                            Bitmap b5 = C1007m.m4045b(D);
                            if (b5 != null) {
                                remoteViews.setImageViewBitmap(a12, b5);
                                remoteViews2.setImageViewBitmap(a19, b5);
                            }
                        } else if (!(mVar.mo4948z() == null || !mVar.mo4948z().startsWith("@package:") || (a = C1007m.m4044a(mVar.mo4948z().substring(9))) == null || (a2 = C1007m.m4043a(a)) == null)) {
                            remoteViews.setImageViewBitmap(a12, a2);
                            remoteViews2.setImageViewBitmap(a19, a2);
                        }
                        remoteViews.setOnClickPendingIntent(a7, a3);
                        remoteViews2.setOnClickPendingIntent(a20, a3);
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else if (mVar.mo4913f() == 3) {
                C0992l a24 = C0992l.m3982a(C0618g.f1635f);
                int a25 = a24.mo5638a("getui_notification", "layout");
                remoteViews = new RemoteViews(C0618g.f1634e, a25);
                remoteViews2 = new RemoteViews(C0618g.f1634e, a25);
                if (a25 != 0) {
                    int a26 = a24.mo5638a("getui_bigview_banner", "id");
                    int a27 = a24.mo5638a("getui_bigview_expanded", "id");
                    int a28 = a24.mo5638a("getui_notification_bg", "id");
                    int a29 = a24.mo5638a("getui_notification_icon", "id");
                    int a30 = a24.mo5638a("getui_notification_date", "id");
                    int a31 = a24.mo5638a("getui_notification_icon2", "id");
                    if (a26 != 0 && a27 != 0 && a28 != 0 && a29 != 0 && a30 != 0 && a31 != 0) {
                        remoteViews.setViewVisibility(a28, 8);
                        remoteViews.setViewVisibility(a29, 8);
                        remoteViews.setViewVisibility(a30, 8);
                        remoteViews.setViewVisibility(a31, 8);
                        remoteViews2.setViewVisibility(a28, 8);
                        remoteViews2.setViewVisibility(a29, 8);
                        remoteViews2.setViewVisibility(a30, 8);
                        remoteViews2.setViewVisibility(a31, 8);
                        if (!(g == null || "".equals(g) || (b3 = C1007m.m4045b(g)) == null)) {
                            remoteViews.setViewVisibility(a27, 0);
                            remoteViews.setImageViewBitmap(a27, b3);
                        }
                        if (!(t == null || "".equals(t) || (b2 = C1007m.m4045b(t)) == null)) {
                            remoteViews2.setViewVisibility(a26, 0);
                            remoteViews2.setImageViewBitmap(a26, b2);
                        }
                        remoteViews.setOnClickPendingIntent(a27, a3);
                        remoteViews2.setOnClickPendingIntent(a26, a3);
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            builder.setPriority(mVar.mo4892a());
            Notification a32 = m2726a(builder.build(), mVar);
            a32.bigContentView = remoteViews;
            a32.contentView = remoteViews2;
            C1010p.m4063a(notificationManager, i, a32);
        }
    }

    /* renamed from: c */
    private boolean m2731c() {
        return Build.VERSION.SDK_INT >= 16;
    }

    /* renamed from: d */
    private boolean m2732d() {
        return C0618g.f1635f.getPackageManager().checkPermission("android.permission.SYSTEM_ALERT_WINDOW", C0618g.f1635f.getPackageName()) == 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x003d  */
    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.igexin.push.core.EnumC0554b mo4352a(com.igexin.push.core.bean.PushTaskBean r14, com.igexin.push.core.bean.BaseAction r15) {
        /*
        // Method dump skipped, instructions count: 213
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.p037a.C0701o.mo4352a(com.igexin.push.core.bean.PushTaskBean, com.igexin.push.core.bean.BaseAction):com.igexin.push.core.b");
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: a */
    public BaseAction mo4353a(JSONObject jSONObject) {
        try {
            C0992l a = C0992l.m3982a(C0744j.f2042a);
            int a2 = a.mo5638a("getui_notification", "layout");
            int a3 = a.mo5638a("notification", "layout");
            C0725m mVar = new C0725m();
            mVar.setType("notification");
            mVar.setActionId(jSONObject.getString("actionid"));
            mVar.setDoActionId(jSONObject.getString("do"));
            mVar.mo4894a(EnumC0737c.basic);
            int i = 1;
            if (jSONObject.has("notifyStyle")) {
                try {
                    i = jSONObject.getInt("notifyStyle");
                } catch (Exception e) {
                    i = 1;
                }
                if (i > 6 || i < 0) {
                    i = 1;
                }
            }
            int i2 = 0;
            if (jSONObject.has("bigStyle")) {
                try {
                    i2 = jSONObject.getInt("bigStyle");
                } catch (Exception e2) {
                    i2 = 0;
                }
                if (i2 > 3 || i2 < 1) {
                    i2 = 0;
                }
            }
            int a4 = a.mo5638a("getui_notification", "layout");
            if (C1001g.m4029a(PushBuildConfig.sdk_conf_version, "2.6.0.0") == -1 || !m2731c() || !C0997c.m4013h()) {
                if (i == 6) {
                    if (i2 == 1 || i2 == 2 || i2 == 0) {
                        i = 1;
                    }
                    if (i2 == 3) {
                        i = 4;
                    }
                }
            } else if (a4 != 0) {
                try {
                    if (jSONObject.has("priority")) {
                        int i3 = jSONObject.getInt("priority");
                        if (i3 <= -3 || i3 >= 3) {
                            mVar.mo4893a(0);
                        } else {
                            mVar.mo4893a(i3);
                        }
                    }
                } catch (Exception e3) {
                    mVar.mo4893a(0);
                }
                if (i != 6 || i2 == 0) {
                    if (i == 6 && i2 == 0) {
                        mVar.mo4896a(true);
                    }
                } else if (i2 == 1 && jSONObject.has("big_image_url") && jSONObject.getString("big_image_url").startsWith("http")) {
                    mVar.mo4906d(jSONObject.getString("big_image_url"));
                } else if (i2 == 2 && jSONObject.has("big_text") && !jSONObject.getString("big_text").equals("")) {
                    mVar.mo4898b(jSONObject.getString("big_text"));
                } else if (i2 != 3 || !jSONObject.has("big_image_url") || !jSONObject.getString("big_image_url").startsWith("http") || !jSONObject.has("banner_url") || !jSONObject.getString("banner_url").startsWith("http")) {
                    mVar.mo4896a(true);
                } else {
                    mVar.mo4906d(jSONObject.getString("big_image_url"));
                }
                if (jSONObject.has("isFloat") && Build.VERSION.SDK_INT >= 11) {
                    mVar.mo4899b(jSONObject.getBoolean("isFloat"));
                }
            } else {
                mVar.mo4896a(true);
            }
            mVar.mo4897b(i2);
            if (a2 != 0) {
                int a5 = a.mo5638a("getui_notification_style1", "id");
                int a6 = a.mo5638a("getui_notification_style2", "id");
                int a7 = a.mo5638a("getui_notification_style3", "id");
                int a8 = a.mo5638a("getui_notification_icon", "id");
                int a9 = a.mo5638a("getui_notification_bg", "id");
                int a10 = a.mo5638a("getui_notification_date", "id");
                int a11 = a.mo5638a("getui_notification_icon2", "id");
                int a12 = a.mo5638a("getui_notification_style1_title", "id");
                int a13 = a.mo5638a("getui_notification_style1_content", "id");
                int a14 = a.mo5638a("getui_notification__style2_title", "id");
                int a15 = a.mo5638a("getui_notification_style3_content", "id");
                if (!(a5 == 0 || a6 == 0 || a7 == 0 || a8 == 0 || a9 == 0 || a10 == 0 || a11 == 0 || a12 == 0 || a13 == 0 || a14 == 0 || a15 == 0)) {
                    mVar.mo4894a(EnumC0737c.getuinotification);
                }
            }
            if (mVar.mo4891E() == EnumC0737c.basic && a3 != 0) {
                int a16 = a.mo5638a("notification_icon", "id");
                int a17 = a.mo5638a("notification_background", "id");
                int a18 = a.mo5638a("notification_title", "id");
                int a19 = a.mo5638a("notification_name", "id");
                if (!(a16 == 0 || a17 == 0 || a18 == 0 || a19 == 0)) {
                    mVar.mo4894a(EnumC0737c.notification);
                }
            }
            if (jSONObject.has("id")) {
                mVar.mo4895a(jSONObject.getString("id"));
            }
            if (jSONObject.has("logo_url") && jSONObject.getString("logo_url").startsWith("http")) {
                mVar.mo4921h(jSONObject.getString("logo_url"));
            }
            if (jSONObject.has("banner_url") && jSONObject.getString("banner_url").startsWith("http")) {
                mVar.mo4925i(jSONObject.getString("banner_url"));
            }
            if (jSONObject.has("banner_url") && jSONObject.getString("banner_url").equals("") && i == 4) {
                mVar.mo4896a(true);
            }
            mVar.mo4914f(i);
            if (mVar.mo4891E() == EnumC0737c.notification && mVar.mo4939q() == null && mVar.mo4940r() == null) {
                mVar.mo4894a(EnumC0737c.basic);
            }
            if (jSONObject.has("title")) {
                mVar.mo4911e(jSONObject.getString("title"));
            }
            if (jSONObject.has("text")) {
                mVar.mo4915f(jSONObject.getString("text"));
            }
            if (jSONObject.has("logo") && !"".equals(jSONObject.getString("logo"))) {
                String string = jSONObject.getString("logo");
                if (string.lastIndexOf(".png") == -1 && string.lastIndexOf(".jpeg") == -1) {
                    string = "";
                } else {
                    int indexOf = string.indexOf(".png");
                    if (indexOf == -1) {
                        indexOf = string.indexOf(".jpeg");
                    }
                    if (indexOf != -1) {
                        string = string.substring(0, indexOf);
                        if (Pattern.compile("^\\d+$").matcher(string).matches()) {
                            string = "";
                        }
                    }
                }
                mVar.mo4919g(string);
            }
            try {
                if (jSONObject.has("timestamp")) {
                    mVar.mo4929j(jSONObject.getBoolean("timestamp"));
                }
            } catch (Exception e4) {
            }
            if (jSONObject.has("second_icon_url") && (jSONObject.getString("second_icon_url").startsWith("@url:http") || jSONObject.getString("second_icon_url").startsWith("@package:"))) {
                String string2 = jSONObject.getString("second_icon_url");
                if (string2.startsWith("@url:http")) {
                    mVar.mo4933l(string2.substring(5));
                } else {
                    mVar.mo4933l(string2);
                }
            }
            if (jSONObject.has("is_noclear")) {
                mVar.mo4907d(jSONObject.getBoolean("is_noclear"));
            }
            if (jSONObject.has("is_novibrate")) {
                mVar.mo4912e(jSONObject.getBoolean("is_novibrate"));
            }
            if (jSONObject.has("is_noring")) {
                mVar.mo4916f(jSONObject.getBoolean("is_noring"));
            }
            return mVar;
        } catch (Exception e5) {
            return null;
        }
    }

    /* renamed from: a */
    public void mo4776a(String str, String str2, C0725m mVar, int i) {
        Notification notification;
        int a;
        Drawable a2;
        Bitmap a3;
        Bitmap b;
        Bitmap b2;
        Bitmap b3;
        C0618g.f1613ai.put(str, Integer.valueOf(i));
        PendingIntent a4 = m2727a(str, str2, i, mVar, false);
        NotificationManager notificationManager = (NotificationManager) C0618g.f1635f.getSystemService("notification");
        Notification notification2 = new Notification();
        notification2.tickerText = mVar.mo4932l();
        Notification a5 = m2726a(notification2, mVar);
        String s = mVar.mo4941s();
        String t = mVar.mo4942t();
        String k = mVar.mo4930k();
        String l = mVar.mo4932l();
        if (mVar.mo4891E() == EnumC0737c.basic || ((mVar.mo4891E() == EnumC0737c.getuinotification && mVar.mo4947y() == 0) || (C0997c.m4009e() && mVar.mo4947y() == 1))) {
            Bitmap bitmap = null;
            if (s != null && !"".equals(s)) {
                Bitmap b4 = C1007m.m4045b(s);
                ActivityC0460a.m1698b(f1868a + "|use net logo bitmap is null = " + (b4 == null));
                bitmap = b4;
            }
            if (bitmap == null) {
                bitmap = BitmapFactory.decodeResource(C0744j.f2042a.getResources(), m2725a(mVar, false));
            }
            if (Build.VERSION.SDK_INT >= 11) {
                notification = m2726a(new Notification.Builder(C0618g.f1635f).setSmallIcon(a5.icon).setTicker(a5.tickerText).setWhen(System.currentTimeMillis()).setContentTitle(k).setLargeIcon(bitmap).setContentIntent(a4).setContentText(l).getNotification(), mVar);
                if (!C0997c.m4009e() && Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 24) {
                    try {
                        Field field = Class.forName("com.android.internal.R$id").getField("right_icon");
                        field.setAccessible(true);
                        int i2 = field.getInt(null);
                        if (notification.contentView != null) {
                            notification.contentView.setViewVisibility(i2, 8);
                        }
                    } catch (Exception e) {
                    }
                }
            } else {
                try {
                    if (!(a5.contentView == null || bitmap == null || (a = m2724a()) <= 0)) {
                        a5.contentView.setImageViewBitmap(a, bitmap);
                    }
                    Method method = Class.forName("android.app.Notification").getMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class);
                    method.setAccessible(true);
                    method.invoke(a5, C0618g.f1635f, k, l, a4);
                    notification = a5;
                } catch (Exception e2) {
                    ActivityC0460a.m1698b(f1868a + "reflect invoke setLatestEventInfo failed!");
                    return;
                }
            }
            if (!C0997c.m4012g()) {
                notificationManager.notify(i, notification);
                return;
            } else if (mVar.mo4947y() != 4) {
                a5 = notification;
            } else {
                return;
            }
        } else {
            C0992l a6 = C0992l.m3982a(C0618g.f1635f);
            if (mVar.mo4891E() == EnumC0737c.notification) {
                a5.contentView = new RemoteViews(C0618g.f1634e, a6.mo5638a("notification", "layout"));
                int a7 = a6.mo5638a("notification_icon", "id");
                int a8 = a6.mo5638a("notification_background", "id");
                int a9 = a6.mo5638a("update_notification_progressblock", "id");
                int a10 = a6.mo5638a("notification_title", "id");
                int a11 = a6.mo5638a("notification_name", "id");
                boolean z = false;
                if (!(s == null || (b3 = C1007m.m4045b(s)) == null)) {
                    a5.contentView.setImageViewBitmap(a7, b3);
                    z = true;
                }
                if (!z) {
                    a5.contentView.setImageViewResource(a7, m2725a(mVar, false));
                }
                if (!(t == null || (b2 = C1007m.m4045b(t)) == null)) {
                    a5.contentView.setImageViewBitmap(a8, b2);
                }
                if (C0999e.m4016a() && C0999e.m4017b()) {
                    a5.contentView.setTextColor(a10, Color.rgb(32, 32, 32));
                }
                a5.contentView.setTextViewText(a10, k);
                a5.contentView.setTextViewText(a11, l);
                if (a9 != 0) {
                    if (a6.mo5638a("app_download_notification", "layout") == 0) {
                        a5.contentView.setViewVisibility(a9, 8);
                    } else if (C1001g.m4029a(PushBuildConfig.sdk_conf_version, "2.3.0.0") != -1) {
                        a5.contentView.setViewVisibility(a9, 8);
                    }
                }
            } else if (mVar.mo4891E() == EnumC0737c.getuinotification) {
                int a12 = a6.mo5638a("getui_notification", "layout");
                int a13 = a6.mo5638a("getui_notification_icon", "id");
                int a14 = a6.mo5638a("getui_notification_bg", "id");
                int a15 = a6.mo5638a("getui_notification_date", "id");
                int a16 = a6.mo5638a("getui_notification_icon2", "id");
                a5.contentView = new RemoteViews(C0618g.f1634e, a12);
                boolean a17 = C0997c.m3999a(a12);
                if (a17) {
                    a5.contentView.setTextColor(a15, C1009o.m4050a(C0618g.f1635f).mo5654c());
                    if (Build.VERSION.SDK_INT >= 16) {
                        a5.contentView.setTextViewTextSize(a15, 0, C1009o.m4050a(C0618g.f1635f).mo5657f());
                    }
                }
                int y = mVar.mo4947y();
                if (y != 4) {
                    boolean z2 = false;
                    if (!(s == null || (b = C1007m.m4045b(s)) == null)) {
                        a5.contentView.setImageViewBitmap(a13, b);
                        z2 = true;
                    }
                    if (!z2) {
                        a5.contentView.setImageViewResource(a13, m2725a(mVar, false));
                    }
                    if (mVar.mo4889C()) {
                        a5.contentView.setTextViewText(a15, new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date()));
                    }
                    String D = mVar.mo4890D();
                    if (D != null) {
                        Bitmap b5 = C1007m.m4045b(D);
                        if (b5 != null) {
                            a5.contentView.setImageViewBitmap(a16, b5);
                        }
                    } else if (!(mVar.mo4948z() == null || !mVar.mo4948z().startsWith("@package:") || (a2 = C1007m.m4044a(mVar.mo4948z().substring(9))) == null || (a3 = C1007m.m4043a(a2)) == null)) {
                        a5.contentView.setImageViewBitmap(a16, a3);
                    }
                }
                if (t != null) {
                    Bitmap b6 = C1007m.m4045b(t);
                    if (b6 != null) {
                        a5.contentView.setImageViewBitmap(a14, b6);
                    } else if (y == 4) {
                        return;
                    }
                } else if (y == 4) {
                    return;
                }
                if (y == 1) {
                    int a18 = a6.mo5638a("getui_notification_style1", "id");
                    int a19 = a6.mo5638a("getui_notification_style1_title", "id");
                    int a20 = a6.mo5638a("getui_notification_style1_content", "id");
                    a5.contentView.setViewVisibility(a18, 0);
                    a5.contentView.setTextViewText(a19, k);
                    a5.contentView.setTextViewText(a20, l);
                    if (a17) {
                        C1009o a21 = C1009o.m4050a(C0618g.f1635f);
                        a5.contentView.setTextColor(a19, a21.mo5652a());
                        a5.contentView.setTextColor(a20, a21.mo5653b());
                        if (Build.VERSION.SDK_INT >= 16) {
                            a5.contentView.setTextViewTextSize(a19, 0, a21.mo5655d());
                            a5.contentView.setTextViewTextSize(a20, 0, a21.mo5656e());
                        } else {
                            a5.contentView.setTextViewText(a19, Html.fromHtml("<font> <h4>" + k + "</h4></font>"));
                            a5.contentView.setTextViewText(a20, l);
                        }
                    } else if (C0999e.m4016a() && C0999e.m4017b()) {
                        a5.contentView.setTextColor(a19, Color.rgb(32, 32, 32));
                    }
                } else if (y == 2) {
                    int a22 = a6.mo5638a("getui_notification_style2", "id");
                    int a23 = a6.mo5638a("getui_notification__style2_title", "id");
                    a5.contentView.setViewVisibility(a22, 0);
                    a5.contentView.setTextViewText(a23, k);
                    if (a17) {
                        C1009o a24 = C1009o.m4050a(C0618g.f1635f);
                        a5.contentView.setTextColor(a23, a24.mo5652a());
                        if (Build.VERSION.SDK_INT >= 16) {
                            a5.contentView.setTextViewTextSize(a23, 0, a24.mo5655d());
                        } else {
                            a5.contentView.setTextViewText(a23, Html.fromHtml("<font> <h4>" + k + "</h4></font>"));
                        }
                    } else if (C0999e.m4016a() && C0999e.m4017b()) {
                        a5.contentView.setTextColor(a23, Color.rgb(32, 32, 32));
                    }
                } else if (y == 3) {
                    int a25 = a6.mo5638a("getui_notification_style3", "id");
                    int a26 = a6.mo5638a("getui_notification_style3_content", "id");
                    a5.contentView.setViewVisibility(a25, 0);
                    a5.contentView.setTextViewText(a26, l);
                    if (a17) {
                        C1009o a27 = C1009o.m4050a(C0618g.f1635f);
                        a5.contentView.setTextColor(a26, a27.mo5653b());
                        if (Build.VERSION.SDK_INT >= 16) {
                            a5.contentView.setTextViewTextSize(a26, 0, a27.mo5656e());
                        } else {
                            a5.contentView.setTextViewText(a26, l);
                        }
                    } else if (C0999e.m4016a() && C0999e.m4017b()) {
                        a5.contentView.setTextColor(a26, Color.rgb(153, 153, 153));
                    }
                }
            } else {
                return;
            }
            a5.contentIntent = a4;
        }
        C1010p.m4063a(notificationManager, i, a5);
    }

    /* renamed from: a */
    public void mo4777a(String str, String str2, String str3, BaseAction baseAction, int i) {
        String str4 = "width=" + C0744j.f2044c + "&height=" + C0744j.f2043b;
        C0771d dVar = new C0771d(!str.contains(str4) ? str.indexOf("?") > 0 ? str + "&" + str4 : str + "?" + str4 : str, str, str2, baseAction, i, new C0702p(this, baseAction, str2, str3, str, i));
        if (i == 2) {
            ((C0725m) baseAction).mo4905d(((C0725m) baseAction).mo4945w() + 1);
        } else if (i == 3) {
            ((C0725m) baseAction).mo4910e(((C0725m) baseAction).mo4946x() + 1);
        } else if (i == 6) {
            ((C0725m) baseAction).mo4918g(((C0725m) baseAction).mo4888B() + 1);
        } else if (i == 8) {
            ((C0725m) baseAction).mo4902c(((C0725m) baseAction).mo4924i() + 1);
        }
        C0456c.m1661b().mo4216a(new C0768a(dVar), false, true);
    }

    @Override // com.igexin.push.core.p027a.p028a.AbstractC0521a
    /* renamed from: b */
    public boolean mo4354b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        if (pushTaskBean == null || baseAction == null || !(baseAction instanceof C0725m)) {
            return true;
        }
        C0725m mVar = (C0725m) baseAction;
        int currentTimeMillis = (int) System.currentTimeMillis();
        int i = 0;
        try {
            i = Integer.parseInt(mVar.getActionId().substring(mVar.getActionId().length() - 1)) + 30000;
        } catch (Exception e) {
        }
        if (mVar.mo4908d() && m2729b() && Build.VERSION.SDK_INT >= 11) {
            try {
                m2728b(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), mVar, currentTimeMillis);
                if (i != 0) {
                    C0535e.m2034a().mo4369a(pushTaskBean, i + "", "notifyFloat:" + mVar.mo4913f());
                }
            } catch (Throwable th) {
            }
        }
        if (mVar.mo4947y() == 6) {
            m2730c(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), mVar, currentTimeMillis);
            if (i != 0) {
                C0535e.m2034a().mo4369a(pushTaskBean, i + "", "notifyStyle:" + mVar.mo4947y());
            }
        } else {
            mo4776a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), mVar, currentTimeMillis);
            if (i != 0) {
                C0535e.m2034a().mo4369a(pushTaskBean, i + "", "notifyStyle:" + mVar.mo4947y());
            }
        }
        pushTaskBean.setPerActionid(Integer.parseInt(mVar.getActionId()));
        pushTaskBean.setCurrentActionid(Integer.parseInt(mVar.getDoActionId()));
        return true;
    }
}
