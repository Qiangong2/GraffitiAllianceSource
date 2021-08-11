package com.xiaomi.smack.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.umeng.analytics.p091b.C1447g;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.channel.commonutils.misc.C1857b;
import com.xiaomi.push.providers.C1932a;
import com.xiaomi.push.service.XMPushService;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.xiaomi.smack.util.k */
public class C2049k {

    /* renamed from: a */
    private static C1857b f5469a = new C1857b(true);

    /* renamed from: b */
    private static int f5470b = -1;

    /* renamed from: c */
    private static final Object f5471c = new Object();

    /* renamed from: d */
    private static List<C2050a> f5472d = Collections.synchronizedList(new ArrayList());

    /* renamed from: e */
    private static String f5473e = "";

    /* renamed from: f */
    private static C1932a f5474f = null;

    /* access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.smack.util.k$a */
    public static class C2050a {

        /* renamed from: a */
        public String f5475a = "";

        /* renamed from: b */
        public long f5476b = 0;

        /* renamed from: c */
        public int f5477c = -1;

        /* renamed from: d */
        public int f5478d = -1;

        /* renamed from: e */
        public String f5479e = "";

        /* renamed from: f */
        public long f5480f = 0;

        public C2050a(String str, long j, int i, int i2, String str2, long j2) {
            this.f5475a = str;
            this.f5476b = j;
            this.f5477c = i;
            this.f5478d = i2;
            this.f5479e = str2;
            this.f5480f = j2;
        }

        /* renamed from: a */
        public boolean mo10661a(C2050a aVar) {
            return TextUtils.equals(aVar.f5475a, this.f5475a) && TextUtils.equals(aVar.f5479e, this.f5479e) && aVar.f5477c == this.f5477c && aVar.f5478d == this.f5478d && Math.abs(aVar.f5476b - this.f5476b) <= 5000;
        }
    }

    /* renamed from: a */
    private static int m7713a(Context context) {
        if (f5470b == -1) {
            f5470b = m7720b(context);
        }
        return f5470b;
    }

    /* renamed from: a */
    public static int m7714a(String str) {
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException e) {
            return str.getBytes().length;
        }
    }

    /* renamed from: a */
    private static long m7715a(int i, long j) {
        return (((long) (i == 0 ? 13 : 11)) * j) / 10;
    }

    /* renamed from: a */
    public static void m7718a(XMPushService xMPushService, String str, long j, boolean z, long j2) {
        int a;
        boolean isEmpty;
        if (xMPushService != null && !TextUtils.isEmpty(str) && "com.xiaomi.xmsf".equals(xMPushService.getPackageName()) && !"com.xiaomi.xmsf".equals(str) && -1 != (a = m7713a(xMPushService))) {
            synchronized (f5471c) {
                isEmpty = f5472d.isEmpty();
                m7719a(new C2050a(str, j2, a, z ? 1 : 0, a == 0 ? m7723c(xMPushService) : "", m7715a(a, j)));
            }
            if (isEmpty) {
                f5469a.mo9928a(new C2051l(xMPushService), 5000);
            }
        }
    }

    /* renamed from: a */
    private static void m7719a(C2050a aVar) {
        for (C2050a aVar2 : f5472d) {
            if (aVar2.mo10661a(aVar)) {
                aVar2.f5480f += aVar.f5480f;
                return;
            }
        }
        f5472d.add(aVar);
    }

    /* renamed from: b */
    private static int m7720b(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return -1;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return -1;
                }
                return activeNetworkInfo.getType();
            } catch (Exception e) {
                return -1;
            }
        } catch (Exception e2) {
            return -1;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m7722b(Context context, List<C2050a> list) {
        try {
            synchronized (C1932a.f4988a) {
                SQLiteDatabase writableDatabase = m7724d(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    for (C2050a aVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(C1447g.f3510e, aVar.f5475a);
                        contentValues.put("message_ts", Long.valueOf(aVar.f5476b));
                        contentValues.put("network_type", Integer.valueOf(aVar.f5477c));
                        contentValues.put("bytes", Long.valueOf(aVar.f5480f));
                        contentValues.put("rcv", Integer.valueOf(aVar.f5478d));
                        contentValues.put("imsi", aVar.f5479e);
                        writableDatabase.insert(C1447g.f3488ah, null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (SQLiteException e) {
            AbstractC1855b.m6720a(e);
        }
    }

    /* renamed from: c */
    private static synchronized String m7723c(Context context) {
        String str;
        synchronized (C2049k.class) {
            if (!TextUtils.isEmpty(f5473e)) {
                str = f5473e;
            } else {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        f5473e = telephonyManager.getSubscriberId();
                    }
                } catch (Exception e) {
                }
                str = f5473e;
            }
        }
        return str;
    }

    /* renamed from: d */
    private static C1932a m7724d(Context context) {
        if (f5474f != null) {
            return f5474f;
        }
        f5474f = new C1932a(context);
        return f5474f;
    }
}
