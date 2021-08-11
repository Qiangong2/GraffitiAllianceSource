package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.xmpush.thrift.C2067c;
import com.xiaomi.xmpush.thrift.C2077h;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.pwrd.paho.client.mqttv3.internal.ClientDefaults;

/* renamed from: com.xiaomi.push.service.s */
public class C1982s {

    /* renamed from: a */
    public static long f5112a = 0;

    /* renamed from: b */
    private static LinkedList<Pair<Integer, String>> f5113b = new LinkedList<>();

    /* renamed from: a */
    private static int m7376a(Context context, String str, String str2) {
        if (str.equals(context.getPackageName())) {
            return context.getResources().getIdentifier(str2, "drawable", str);
        }
        return 0;
    }

    /* renamed from: a */
    private static Notification m7377a(Notification notification, String str) {
        try {
            Field declaredField = Notification.class.getDeclaredField("extraNotification");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(notification);
            Method declaredMethod = obj.getClass().getDeclaredMethod("setTargetPkg", CharSequence.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, str);
        } catch (Exception e) {
            AbstractC1855b.m6720a(e);
        }
        return notification;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private static Notification m7378a(Context context, C2077h hVar, byte[] bArr, RemoteViews remoteViews, PendingIntent pendingIntent) {
        C2067c m = hVar.mo10850m();
        Notification.Builder builder = new Notification.Builder(context);
        String[] a = m7387a(context, m);
        builder.setContentTitle(a[0]);
        builder.setContentText(a[1]);
        if (remoteViews != null) {
            builder.setContent(remoteViews);
        } else if (Build.VERSION.SDK_INT >= 16) {
            builder.setStyle(new Notification.BigTextStyle().bigText(a[1]));
        }
        builder.setWhen(System.currentTimeMillis());
        builder.setContentIntent(pendingIntent);
        int a2 = m7376a(context, m7382a(hVar), "mipush_notification");
        int a3 = m7376a(context, m7382a(hVar), "mipush_small_notification");
        if (a2 <= 0 || a3 <= 0) {
            builder.setSmallIcon(m7395f(context, m7382a(hVar)));
        } else {
            builder.setLargeIcon(m7380a(context, a2));
            builder.setSmallIcon(a3);
        }
        builder.setAutoCancel(true);
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> s = m.mo10731s();
        if (s != null && s.containsKey("ticker")) {
            builder.setTicker(s.get("ticker"));
        }
        if (currentTimeMillis - f5112a > 10000) {
            f5112a = currentTimeMillis;
            int c = m7394e(context, m7382a(hVar)) ? m7392c(context, m7382a(hVar)) : m.f5572f;
            builder.setDefaults(c);
            if (!(s == null || (c & 1) == 0)) {
                String str = s.get("sound_uri");
                if (!TextUtils.isEmpty(str) && str.startsWith("android.resource://" + m7382a(hVar))) {
                    builder.setDefaults(c ^ 1);
                    builder.setSound(Uri.parse(str));
                }
            }
        }
        return builder.getNotification();
    }

    /* renamed from: a */
    private static PendingIntent m7379a(Context context, C2077h hVar, C2067c cVar, byte[] bArr) {
        if (cVar != null && !TextUtils.isEmpty(cVar.f5573g)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(cVar.f5573g));
            intent.addFlags(ClientDefaults.MAX_MSG_SIZE);
            return PendingIntent.getActivity(context, 0, intent, 134217728);
        } else if (m7391b(hVar)) {
            Intent intent2 = new Intent();
            intent2.setComponent(new ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler"));
            intent2.putExtra("mipush_payload", bArr);
            intent2.putExtra("mipush_notified", true);
            intent2.addCategory(String.valueOf(cVar.mo10729q()));
            return PendingIntent.getService(context, 0, intent2, 134217728);
        } else {
            Intent intent3 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            intent3.setComponent(new ComponentName(hVar.f5739f, "com.xiaomi.mipush.sdk.PushMessageHandler"));
            intent3.putExtra("mipush_payload", bArr);
            intent3.putExtra("mipush_notified", true);
            intent3.addCategory(String.valueOf(cVar.mo10729q()));
            return PendingIntent.getService(context, 0, intent3, 134217728);
        }
    }

    /* renamed from: a */
    private static Bitmap m7380a(Context context, int i) {
        return m7381a(context.getResources().getDrawable(i));
    }

    /* renamed from: a */
    public static Bitmap m7381a(Drawable drawable) {
        int i = 1;
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicHeight > 0) {
            i = intrinsicHeight;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    /* renamed from: a */
    static String m7382a(C2077h hVar) {
        C2067c m;
        if (!(!"com.xiaomi.xmsf".equals(hVar.f5739f) || (m = hVar.mo10850m()) == null || m.mo10731s() == null)) {
            String str = m.mo10731s().get("miui_package_name");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return hVar.f5739f;
    }

    /* renamed from: a */
    public static void m7383a(Context context, C2077h hVar, byte[] bArr) {
        Notification notification;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        C2067c m = hVar.mo10850m();
        RemoteViews b = m7388b(context, hVar, bArr);
        PendingIntent a = m7379a(context, hVar, m, bArr);
        if (a == null) {
            AbstractC1855b.m6718a("The click PendingIntent is null. ");
            return;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            notification = m7378a(context, hVar, bArr, b, a);
        } else {
            Notification notification2 = new Notification(m7395f(context, m7382a(hVar)), null, System.currentTimeMillis());
            String[] a2 = m7387a(context, m);
            try {
                notification2.getClass().getMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class).invoke(notification2, context, a2[0], a2[1], a);
            } catch (NoSuchMethodException e) {
                AbstractC1855b.m6720a(e);
            } catch (IllegalAccessException e2) {
                AbstractC1855b.m6720a(e2);
            } catch (IllegalArgumentException e3) {
                AbstractC1855b.m6720a(e3);
            } catch (InvocationTargetException e4) {
                AbstractC1855b.m6720a(e4);
            }
            Map<String, String> s = m.mo10731s();
            if (s != null && s.containsKey("ticker")) {
                notification2.tickerText = s.get("ticker");
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - f5112a > 10000) {
                f5112a = currentTimeMillis;
                int c = m7394e(context, m7382a(hVar)) ? m7392c(context, m7382a(hVar)) : m.f5572f;
                notification2.defaults = c;
                if (!(s == null || (c & 1) == 0)) {
                    String str = s.get("sound_uri");
                    if (!TextUtils.isEmpty(str) && str.startsWith("android.resource://" + m7382a(hVar))) {
                        notification2.defaults = c ^ 1;
                        notification2.sound = Uri.parse(str);
                    }
                }
            }
            notification2.flags |= 16;
            if (b != null) {
                notification2.contentView = b;
            }
            notification = notification2;
        }
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            m7377a(notification, m7382a(hVar));
        }
        int q = m.mo10729q() + ((m7382a(hVar).hashCode() / 10) * 10);
        notificationManager.notify(q, notification);
        Pair<Integer, String> pair = new Pair<>(Integer.valueOf(q), m7382a(hVar));
        synchronized (f5113b) {
            f5113b.add(pair);
            if (f5113b.size() > 100) {
                f5113b.remove();
            }
        }
    }

    /* renamed from: a */
    public static void m7384a(Context context, String str, int i) {
        int hashCode = ((str.hashCode() / 10) * 10) + i;
        ((NotificationManager) context.getSystemService("notification")).cancel(hashCode);
        synchronized (f5113b) {
            Iterator<Pair<Integer, String>> it = f5113b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Pair<Integer, String> next = it.next();
                if (hashCode == ((Integer) next.first).intValue() && TextUtils.equals(str, (CharSequence) next.second)) {
                    f5113b.remove(next);
                    break;
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m7385a(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100 && Arrays.asList(runningAppProcessInfo.pkgList).contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m7386a(Map<String, String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return "1".equals(map.get("notify_foreground"));
    }

    /* renamed from: a */
    private static String[] m7387a(Context context, C2067c cVar) {
        String h = cVar.mo10719h();
        String j = cVar.mo10722j();
        Map<String, String> s = cVar.mo10731s();
        if (s != null) {
            int intValue = Float.valueOf((((float) context.getResources().getDisplayMetrics().widthPixels) / context.getResources().getDisplayMetrics().density) + 0.5f).intValue();
            if (intValue <= 320) {
                String str = s.get("title_short");
                if (!TextUtils.isEmpty(str)) {
                    h = str;
                }
                String str2 = s.get("description_short");
                if (TextUtils.isEmpty(str2)) {
                    str2 = j;
                }
                j = str2;
            } else if (intValue > 360) {
                String str3 = s.get("title_long");
                if (!TextUtils.isEmpty(str3)) {
                    h = str3;
                }
                String str4 = s.get("description_long");
                if (!TextUtils.isEmpty(str4)) {
                    j = str4;
                }
            }
        }
        return new String[]{h, j};
    }

    /* renamed from: b */
    private static RemoteViews m7388b(Context context, C2077h hVar, byte[] bArr) {
        C2067c m = hVar.mo10850m();
        String a = m7382a(hVar);
        Map<String, String> s = m.mo10731s();
        if (s == null) {
            return null;
        }
        String str = s.get("layout_name");
        String str2 = s.get("layout_value");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(a);
            int identifier = resourcesForApplication.getIdentifier(str, "layout", a);
            if (identifier == 0) {
                return null;
            }
            RemoteViews remoteViews = new RemoteViews(a, identifier);
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.has("text")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("text");
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String string = jSONObject2.getString(next);
                        int identifier2 = resourcesForApplication.getIdentifier(next, "id", a);
                        if (identifier2 > 0) {
                            remoteViews.setTextViewText(identifier2, string);
                        }
                    }
                }
                if (jSONObject.has("image")) {
                    JSONObject jSONObject3 = jSONObject.getJSONObject("image");
                    Iterator<String> keys2 = jSONObject3.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        String string2 = jSONObject3.getString(next2);
                        int identifier3 = resourcesForApplication.getIdentifier(next2, "id", a);
                        int identifier4 = resourcesForApplication.getIdentifier(string2, "drawable", a);
                        if (identifier3 > 0) {
                            remoteViews.setImageViewResource(identifier3, identifier4);
                        }
                    }
                }
                if (jSONObject.has("time")) {
                    JSONObject jSONObject4 = jSONObject.getJSONObject("time");
                    Iterator<String> keys3 = jSONObject4.keys();
                    while (keys3.hasNext()) {
                        String next3 = keys3.next();
                        String string3 = jSONObject4.getString(next3);
                        if (string3.length() == 0) {
                            string3 = "yy-MM-dd hh:mm";
                        }
                        int identifier5 = resourcesForApplication.getIdentifier(next3, "id", a);
                        if (identifier5 > 0) {
                            remoteViews.setTextViewText(identifier5, new SimpleDateFormat(string3).format(new Date(System.currentTimeMillis())));
                        }
                    }
                }
                return remoteViews;
            } catch (JSONException e) {
                AbstractC1855b.m6720a(e);
                return null;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            AbstractC1855b.m6720a(e2);
            return null;
        }
    }

    /* renamed from: b */
    public static void m7389b(Context context, String str) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        synchronized (f5113b) {
            Iterator it = ((LinkedList) f5113b.clone()).iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                if (TextUtils.equals((CharSequence) pair.second, str)) {
                    notificationManager.cancel(((Integer) pair.first).intValue());
                    f5113b.remove(pair);
                }
            }
        }
    }

    /* renamed from: b */
    static void m7390b(Context context, String str, int i) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i).commit();
    }

    /* renamed from: b */
    public static boolean m7391b(C2077h hVar) {
        C2067c m = hVar.mo10850m();
        return m != null && m.mo10735v();
    }

    /* renamed from: c */
    static int m7392c(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, Integer.MAX_VALUE);
    }

    /* renamed from: d */
    static void m7393d(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    /* renamed from: e */
    static boolean m7394e(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    /* renamed from: f */
    private static int m7395f(Context context, String str) {
        int a = m7376a(context, str, "mipush_notification");
        int a2 = m7376a(context, str, "mipush_small_notification");
        if (a <= 0) {
            a = a2 > 0 ? a2 : context.getApplicationInfo().icon;
        }
        return (a != 0 || Build.VERSION.SDK_INT < 9) ? a : context.getApplicationInfo().logo;
    }
}
