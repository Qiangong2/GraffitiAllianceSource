package com.igexin.push.extension.distribution.gbd.p074h.p075a;

import android.os.Message;
import com.igexin.push.extension.distribution.gbd.p061a.p062a.C1027f;
import com.igexin.push.extension.distribution.gbd.p061a.p064c.C1045f;
import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1083e;
import com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.igexin.push.extension.distribution.gbd.h.a.b */
public class C1100b extends AbstractC1111b {

    /* renamed from: c */
    private static C1100b f2961c;

    private C1100b() {
        this.f2972a = C1069c.f2846w;
        this.f2973b = m4504e();
    }

    /* renamed from: a */
    private void m4501a(int i, int i2) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.arg1 = i2;
        if (C1069c.f2826c != null) {
            C1069c.f2826c.sendMessage(obtain);
        }
    }

    /* renamed from: a */
    private boolean m4502a(String str) {
        String[] split = str.split(" ");
        String[] split2 = new SimpleDateFormat("mm HH dd MM yy", Locale.getDefault()).format(new Date()).split(" ");
        for (int i = 0; i < split2.length; i++) {
            if (!split[i].equals("*")) {
                if (split[i].startsWith("*/")) {
                    int intValue = Integer.valueOf(split[i].substring(2)).intValue();
                    if (intValue > 0 && Integer.valueOf(split2[i]).intValue() % intValue != 0) {
                        return false;
                    }
                } else if (!split2[i].equals(split[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: d */
    public static C1100b m4503d() {
        if (f2961c == null) {
            f2961c = new C1100b();
        }
        return f2961c;
    }

    /* renamed from: e */
    private long m4504e() {
        Date date = new Date(new Date().getTime() - C1069c.f2831h);
        int intValue = Integer.valueOf(new SimpleDateFormat("mm", Locale.getDefault()).format(date)).intValue();
        int intValue2 = Integer.valueOf(new SimpleDateFormat("ss", Locale.getDefault()).format(date)).intValue();
        int i = (3600 - (((intValue * 60) + intValue2) % 3600)) * 1000;
        C1115d.m4559b("GBD_CT", "calcDelay nowMinute:" + intValue + "|nowSecond:" + intValue2 + "|delaySeconds:" + i);
        return (long) i;
    }

    @Override // com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b
    /* renamed from: a */
    public void mo5870a() {
        C1115d.m4559b("GBD_CT", "doTask...");
        if (m4502a(C1045f.m4230a().mo5709c())) {
            m4501a(1, 12);
        }
        if (m4502a(C1027f.m4131a().mo5682d()) && C1067a.f2756G) {
            m4501a(4, 42);
        }
    }

    @Override // com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b
    /* renamed from: a */
    public void mo5871a(long j) {
        this.f2972a = j;
        this.f2973b = m4504e();
        C1083e.m4408a().mo5828d(j);
    }

    @Override // com.igexin.push.extension.distribution.gbd.p074h.AbstractC1111b
    /* renamed from: c */
    public boolean mo5872c() {
        return true;
    }
}
