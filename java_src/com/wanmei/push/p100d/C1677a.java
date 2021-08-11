package com.wanmei.push.p100d;

import android.content.Context;
import com.wanmei.push.bean.StandardBaseResult;
import com.wanmei.push.bean.SyncAppInfo;
import com.wanmei.push.p098b.AsyncTaskC1655a;
import com.wanmei.push.p098b.AsyncTaskC1657b;
import com.wanmei.push.p098b.AsyncTaskC1659c;
import com.wanmei.push.p098b.AsyncTaskC1662d;
import com.wanmei.push.p098b.AsyncTaskC1665e;
import com.wanmei.push.p098b.AsyncTaskC1668g;
import com.wanmei.push.p098b.AsyncTaskC1669h;
import com.wanmei.push.p098b.AsyncTaskC1671i;
import com.wanmei.push.p102e.C1688b;
import com.wanmei.push.p104g.C1717i;
import java.util.Map;

/* renamed from: com.wanmei.push.d.a */
public final class C1677a {

    /* renamed from: a */
    private static C1677a f4265a = new C1677a();

    private C1677a() {
    }

    /* renamed from: a */
    public static StandardBaseResult<?> m6258a(Context context, Map<String, String> map) {
        return C1688b.m6322a(context).mo9341a(map);
    }

    /* renamed from: a */
    public static C1677a m6259a() {
        return f4265a;
    }

    /* renamed from: a */
    public static void m6260a(Context context) {
        new AsyncTaskC1655a(context).execute(new Object[]{0});
    }

    /* renamed from: a */
    public static void m6261a(Context context, String str, String str2) {
        new AsyncTaskC1662d(context, str, str2).execute(new Object[0]);
    }

    /* renamed from: b */
    public static StandardBaseResult<?> m6262b(Context context) {
        return C1688b.m6322a(context).mo9338a();
    }

    /* renamed from: b */
    public static StandardBaseResult<String> m6263b(Context context, String str, String str2) {
        return C1688b.m6322a(context).mo9340a(str, str2);
    }

    /* renamed from: b */
    public static void m6264b(Context context, Map<String, String> map) {
        new AsyncTaskC1669h(context, map).execute(new Object[]{0});
    }

    /* renamed from: c */
    public static StandardBaseResult<String> m6265c(Context context) {
        C1688b a = C1688b.m6322a(context);
        String str = "";
        if (C1717i.m6392b()) {
            str = "xiaomi";
        }
        return a.mo9339a(str);
    }

    /* renamed from: c */
    public static StandardBaseResult<?> m6266c(Context context, Map<String, String> map) {
        return C1688b.m6322a(context).mo9343b(map);
    }

    /* renamed from: d */
    public static void m6267d(Context context) {
        new AsyncTaskC1671i(context).execute(new Object[]{0});
    }

    /* renamed from: d */
    public static void m6268d(Context context, Map<String, String> map) {
        new AsyncTaskC1665e(context, map).execute(new Object[]{0});
    }

    /* renamed from: e */
    public static StandardBaseResult<?> m6269e(Context context) {
        return C1688b.m6322a(context).mo9342b();
    }

    /* renamed from: e */
    public static StandardBaseResult<?> m6270e(Context context, Map<String, String> map) {
        return C1688b.m6322a(context).mo9345c(map);
    }

    /* renamed from: f */
    public static void m6271f(Context context) {
        new AsyncTaskC1668g(context).execute(new Object[]{0});
    }

    /* renamed from: f */
    public static void m6272f(Context context, Map<String, String> map) {
        new AsyncTaskC1657b(context, map).execute(new Object[]{0});
    }

    /* renamed from: g */
    public static void m6273g(Context context) {
        new AsyncTaskC1659c(context).execute(new Object[]{0});
    }

    /* renamed from: h */
    public static StandardBaseResult<SyncAppInfo> m6274h(Context context) {
        return C1688b.m6322a(context).mo9344c();
    }
}
