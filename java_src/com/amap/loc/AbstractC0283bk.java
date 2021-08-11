package com.amap.loc;

import android.text.TextUtils;
import java.net.Proxy;
import java.util.Map;

/* renamed from: com.amap.loc.bk */
/* compiled from: Request */
public abstract class AbstractC0283bk {

    /* renamed from: c */
    int f465c = 20000;

    /* renamed from: d */
    int f466d = 20000;

    /* renamed from: e */
    Proxy f467e = null;

    /* renamed from: a */
    public abstract Map<String, String> mo3696a();

    /* renamed from: a */
    public final void mo3767a(int i) {
        this.f465c = i;
    }

    /* renamed from: a */
    public final void mo3768a(Proxy proxy) {
        this.f467e = proxy;
    }

    /* renamed from: b */
    public abstract String mo3697b();

    /* renamed from: b */
    public final void mo3769b(int i) {
        this.f466d = i;
    }

    /* renamed from: c */
    public abstract Map<String, String> mo3698c();

    /* renamed from: d */
    public byte[] mo3754d() {
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public String mo3770i() {
        byte[] d = mo3754d();
        if (d == null || d.length == 0) {
            return mo3697b();
        }
        Map<String, String> c = mo3698c();
        if (c == null) {
            return mo3697b();
        }
        String a = C0280bi.m742a(c);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(mo3697b()).append("?").append(a);
        return stringBuffer.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public byte[] mo3771j() {
        byte[] d = mo3754d();
        if (d != null && d.length != 0) {
            return d;
        }
        String a = C0280bi.m742a(mo3698c());
        return !TextUtils.isEmpty(a) ? C0363r.m1358a(a) : d;
    }
}
