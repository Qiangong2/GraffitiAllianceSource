package com.igexin.push.extension.distribution.gbd.p061a.p062a;

import android.content.Context;
import android.text.TextUtils;
import com.igexin.push.core.C0618g;
import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1080b;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1083e;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.extension.distribution.gbd.p076i.C1116e;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.igexin.push.extension.distribution.gbd.a.a.g */
public class C1028g {

    /* renamed from: b */
    private static C1028g f2623b;

    /* renamed from: a */
    private Context f2624a;

    private C1028g(Context context) {
        this.f2624a = context;
    }

    /* renamed from: a */
    public static C1028g m4140a() {
        if (f2623b == null) {
            f2623b = new C1028g(C0618g.f1635f);
        }
        return f2623b;
    }

    /* renamed from: a */
    private void m4141a(String str) {
        C1083e.m4408a().mo5826c(str);
        C1080b.m4391a().mo5812a(str, mo5684c());
    }

    /* renamed from: d */
    private String m4142d() {
        if (TextUtils.isEmpty(C1067a.f2780ad)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String[] split = C1067a.f2780ad.split(MiPushClient.ACCEPT_TIME_SEPARATOR);
        for (String str : split) {
            sb.append(str);
            sb.append(":");
            sb.append(C1116e.m4587c(str, this.f2624a) ? "1" : "0");
            sb.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
        }
        return (sb.toString().endsWith(MiPushClient.ACCEPT_TIME_SEPARATOR) ? sb.deleteCharAt(sb.length() - 1) : sb).toString();
    }

    /* renamed from: b */
    public void mo5683b() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(C1116e.m4607k())));
            sb.append("|");
            sb.append(C0618g.f1647r);
            sb.append("|");
            sb.append(C0618g.f1602a);
            sb.append("|");
            String d = m4142d();
            if (!TextUtils.isEmpty(d)) {
                sb.append(d);
            }
            sb.append("|");
            sb.append("ANDROID");
            m4141a(sb.toString());
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }

    /* renamed from: c */
    public int mo5684c() {
        return 34;
    }
}
