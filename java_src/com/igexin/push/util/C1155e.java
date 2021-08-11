package com.igexin.push.util;

import android.content.Context;
import android.text.TextUtils;
import com.igexin.p012b.p013a.p014a.C0435a;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.config.C0514k;
import com.igexin.push.core.C0618g;
import com.igexin.sdk.p082a.C1172b;
import com.tencent.qcloud.core.util.IOUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.igexin.push.util.e */
public class C1155e {

    /* renamed from: a */
    private static final Object f3021a = new Object();

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00b7 A[SYNTHETIC, Splitter:B:21:0x00b7] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c2 A[SYNTHETIC, Splitter:B:26:0x00c2] */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m4760a() {
        /*
        // Method dump skipped, instructions count: 209
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.C1155e.m4760a():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0018 A[SYNTHETIC, Splitter:B:11:0x0018] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0021 A[SYNTHETIC, Splitter:B:16:0x0021] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m4762a(byte[] r4, java.lang.String r5, boolean r6) {
        /*
            r1 = 0
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0014, all -> 0x001e }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0014, all -> 0x001e }
            r2.<init>(r5)     // Catch:{ Exception -> 0x0014, all -> 0x001e }
            r0.<init>(r2, r6)     // Catch:{ Exception -> 0x0014, all -> 0x001e }
            r0.write(r4)     // Catch:{ Exception -> 0x002e, all -> 0x0029 }
            if (r0 == 0) goto L_0x0013
            r0.close()     // Catch:{ Exception -> 0x0025 }
        L_0x0013:
            return
        L_0x0014:
            r0 = move-exception
            r0 = r1
        L_0x0016:
            if (r0 == 0) goto L_0x0013
            r0.close()     // Catch:{ Exception -> 0x001c }
            goto L_0x0013
        L_0x001c:
            r0 = move-exception
            goto L_0x0013
        L_0x001e:
            r0 = move-exception
        L_0x001f:
            if (r1 == 0) goto L_0x0024
            r1.close()     // Catch:{ Exception -> 0x0027 }
        L_0x0024:
            throw r0
        L_0x0025:
            r0 = move-exception
            goto L_0x0013
        L_0x0027:
            r1 = move-exception
            goto L_0x0024
        L_0x0029:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
            goto L_0x001f
        L_0x002e:
            r1 = move-exception
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.C1155e.m4762a(byte[], java.lang.String, boolean):void");
    }

    /* renamed from: a */
    public static boolean m4763a(Context context) {
        return !new C1172b(context).mo5966b();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0060 A[SYNTHETIC, Splitter:B:17:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0065 A[SYNTHETIC, Splitter:B:20:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0082 A[SYNTHETIC, Splitter:B:34:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0087 A[SYNTHETIC, Splitter:B:37:0x0087] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] m4764a(java.lang.String r6) {
        /*
        // Method dump skipped, instructions count: 160
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.C1155e.m4764a(java.lang.String):byte[]");
    }

    /* renamed from: b */
    public static String m4765b() {
        String str = null;
        try {
            byte[] a = m4764a(C0618g.f1598W);
            if (a == null) {
                ActivityC0460a.m1698b("FileUtils | read file cid id = null");
                return str;
            }
            String[] split = new String(C0435a.m1577c(a, C0618g.f1577B)).split("\\|");
            if (split.length > 2) {
                String str2 = split[2];
                if (str2 != null) {
                    try {
                        if (!str2.equals("null")) {
                            str = str2;
                        }
                    } catch (Exception e) {
                        str = str2;
                    }
                } else {
                    str = str2;
                }
            }
            ActivityC0460a.m1698b("FileUtils|get cid from file cid = " + str);
            return str;
        } catch (Exception e2) {
        }
    }

    /* renamed from: b */
    private static String m4766b(String str) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()) + "|" + C0618g.f1647r + "|" + C0618g.f1602a + "|" + "1" + "|" + str;
    }

    /* renamed from: b */
    public static void m4767b(Context context) {
        File file = new File(context.getFilesDir().getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + "init_c.pid");
        if (file.exists()) {
            file.delete();
        }
        if (!C0514k.f1330v) {
            ActivityC0460a.m1698b("FileUtils|isReportInitialize = false");
        } else if (C0618g.f1636g.get()) {
            C0456c.m1661b().mo4216a(new C1157g(context), false, true);
        } else {
            new Thread(new RunnableC1158h(context)).start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m4768b(Context context, String str) {
        if (context != null && str != null) {
            String str2 = context.getFilesDir().getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + "init_c1.pid";
            synchronized (f3021a) {
                if (str.length() == 0) {
                    m4762a(str.getBytes(), str2, false);
                } else {
                    m4762a((str + "|").getBytes(), str2, true);
                }
            }
        }
    }

    /* renamed from: c */
    public static String m4769c() {
        String str;
        Exception e;
        try {
            ActivityC0460a.m1698b("FileUtils|get device id from file : " + C0618g.f1599X);
            byte[] a = m4764a(C0618g.f1599X);
            if (a == null) {
                ActivityC0460a.m1698b("FileUtils|read file device id = null");
                return null;
            }
            str = new String(a, "utf-8");
            try {
                ActivityC0460a.m1698b("FileUtils|read file device id = " + str);
                return str;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            str = null;
            e = e3;
            ActivityC0460a.m1698b("FileUtils|get device id from file : " + e.toString());
            return str;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003b, code lost:
        if (r0 != 0) goto L_0x003d;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long m4770d() {
        /*
        // Method dump skipped, instructions count: 121
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.C1155e.m4770d():long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a1 A[SYNTHETIC, Splitter:B:26:0x00a1] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ac A[SYNTHETIC, Splitter:B:31:0x00ac] */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m4771e() {
        /*
        // Method dump skipped, instructions count: 195
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.C1155e.m4771e():void");
    }

    /* renamed from: f */
    public static void m4772f() {
        C0456c.m1661b().mo4216a(new C1156f(), false, true);
    }

    /* renamed from: g */
    public static void m4773g() {
        m4768b(C0618g.f1635f, "");
    }

    /* renamed from: h */
    public static String m4774h() {
        byte[] a;
        String str = C0618g.f1635f.getFilesDir().getPath() + MqttTopic.TOPIC_LEVEL_SEPARATOR + "init_c1.pid";
        try {
            synchronized (f3021a) {
                a = m4764a(str);
            }
            if (a == null) {
                return null;
            }
            String str2 = new String(a);
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            if (str2.endsWith("|")) {
                str2 = str2.substring(0, str2.length() - 1);
            }
            String[] split = str2.split("\\|");
            if (split.length <= 300 || System.currentTimeMillis() - Long.parseLong(split[0]) <= 604800000) {
                StringBuilder sb = new StringBuilder();
                for (String str3 : split) {
                    sb.append(m4766b(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(Long.parseLong(str3))))).append(IOUtils.LINE_SEPARATOR_UNIX);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                return sb.toString();
            }
            m4773g();
            return null;
        } catch (Throwable th) {
            ActivityC0460a.m1698b("FileUtils|upload init data error = " + th.toString());
            m4773g();
            return null;
        }
    }
}
