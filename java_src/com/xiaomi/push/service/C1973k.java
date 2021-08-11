package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.smack.C2023p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.xiaomi.push.service.k */
public class C1973k {

    /* renamed from: a */
    private static final Map<String, byte[]> f5088a = new HashMap();

    /* renamed from: b */
    private static ArrayList<Pair<String, byte[]>> f5089b = new ArrayList<>();

    /* renamed from: a */
    public static void m7340a(Context context, int i, String str) {
        synchronized (f5088a) {
            for (String str2 : f5088a.keySet()) {
                m7341a(context, str2, f5088a.get(str2), i, str);
            }
            f5088a.clear();
        }
    }

    /* renamed from: a */
    public static void m7341a(Context context, String str, byte[] bArr, int i, String str2) {
        Intent intent = new Intent("com.xiaomi.mipush.ERROR");
        intent.setPackage(str);
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mipush_error_code", i);
        intent.putExtra("mipush_error_msg", str2);
        context.sendBroadcast(intent, C1964b.m7303a(str));
    }

    /* renamed from: a */
    public static void m7342a(XMPushService xMPushService) {
        try {
            synchronized (f5088a) {
                for (String str : f5088a.keySet()) {
                    xMPushService.mo10355a(str, f5088a.get(str));
                }
                f5088a.clear();
            }
        } catch (C2023p e) {
            AbstractC1855b.m6720a(e);
            xMPushService.mo10349a(10, e);
        }
    }

    /* renamed from: a */
    public static void m7343a(String str, byte[] bArr) {
        synchronized (f5088a) {
            f5088a.put(str, bArr);
        }
    }

    /* renamed from: b */
    public static void m7344b(XMPushService xMPushService) {
        ArrayList<Pair<String, byte[]>> arrayList;
        try {
            synchronized (f5089b) {
                arrayList = f5089b;
                f5089b = new ArrayList<>();
            }
            Iterator<Pair<String, byte[]>> it = arrayList.iterator();
            while (it.hasNext()) {
                Pair<String, byte[]> next = it.next();
                xMPushService.mo10355a((String) next.first, (byte[]) next.second);
            }
        } catch (C2023p e) {
            AbstractC1855b.m6720a(e);
            xMPushService.mo10349a(10, e);
        }
    }

    /* renamed from: b */
    public static void m7345b(String str, byte[] bArr) {
        synchronized (f5089b) {
            f5089b.add(new Pair<>(str, bArr));
            if (f5089b.size() > 50) {
                f5089b.remove(0);
            }
        }
    }
}
