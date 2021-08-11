package com.amap.loc;

import android.content.Context;

/* renamed from: com.amap.loc.bm */
/* compiled from: OfflineLocEntity */
public class C0285bm {

    /* renamed from: a */
    private Context f471a;

    /* renamed from: b */
    private C0360q f472b;

    /* renamed from: c */
    private String f473c;

    public C0285bm(Context context, C0360q qVar, String str) {
        this.f471a = context.getApplicationContext();
        this.f472b = qVar;
        this.f473c = str;
    }

    /* renamed from: a */
    private static String m761a(Context context, C0360q qVar, String str) {
        return C0350k.m1258b(context, C0363r.m1358a(m762b(context, qVar, str)));
    }

    /* renamed from: b */
    private static String m762b(Context context, C0360q qVar, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"sdkversion\":\"").append(qVar.mo3941b()).append("\",\"product\":\"").append(qVar.mo3939a()).append("\",\"nt\":\"").append(C0353l.m1270c(context)).append("\",\"details\":").append(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public byte[] mo3772a() {
        return C0363r.m1358a(m761a(this.f471a, this.f472b, this.f473c));
    }
}
