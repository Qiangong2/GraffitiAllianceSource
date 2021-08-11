package com.igexin.push.extension.distribution.gbd.p069e.p070a;

import android.content.ContentValues;
import android.support.p007v4.media.TransportMediator;
import android.text.TextUtils;
import com.igexin.p012b.p022b.C0476a;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.net.ServerSocket;
import java.util.List;

/* renamed from: com.igexin.push.extension.distribution.gbd.e.a.e */
public class C1083e {

    /* renamed from: a */
    private static C1083e f2938a;

    /* renamed from: a */
    public static C1083e m4408a() {
        if (f2938a == null) {
            f2938a = new C1083e();
        }
        return f2938a;
    }

    /* renamed from: a */
    private void m4409a(int i, String str) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("key", Integer.valueOf(i));
            contentValues.put("value", str);
            C1069c.f2825b.mo5802a("runtime", (String) null, contentValues);
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }

    /* renamed from: a */
    private void m4410a(int i, byte[] bArr) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("key", Integer.valueOf(i));
            contentValues.put("value", bArr);
            C1069c.f2825b.mo5802a("runtime", (String) null, contentValues);
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }

    /* renamed from: f */
    private ServerSocket m4411f() {
        try {
            return new ServerSocket(48432);
        } catch (Throwable th) {
            C1115d.m4557a("GBD_RDM", "open port error ！");
            return null;
        }
    }

    /* renamed from: a */
    public void mo5817a(int i) {
        m4409a(161, String.valueOf(i));
    }

    /* renamed from: a */
    public void mo5818a(long j) {
        C1069c.f2831h = j;
        m4409a(102, String.valueOf(j));
        C1115d.m4557a("GBD_RDM", "saveTimeOffset = " + j);
    }

    /* renamed from: a */
    public void mo5819a(String str) {
        if (!TextUtils.isEmpty(str)) {
            C1069c.f2845v = str;
            m4410a(139, C0476a.m1776b(str.getBytes()));
        }
    }

    /* renamed from: a */
    public void mo5820a(List<Long> list) {
        try {
            C1069c.f2832i.clear();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                long longValue = list.get(i).longValue();
                C1069c.f2832i.add(Long.valueOf(longValue));
                sb.append(longValue);
                if (i < list.size() - 1) {
                    sb.append(MiPushClient.ACCEPT_TIME_SEPARATOR);
                }
            }
            m4410a(103, C0476a.m1776b(sb.toString().getBytes()));
        } catch (Exception e) {
            C1115d.m4558a(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0051, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0052, code lost:
        r1 = r3;
        r2 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x010b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x010b A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x0011] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo5821b() {
        /*
        // Method dump skipped, instructions count: 538
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.gbd.p069e.p070a.C1083e.mo5821b():void");
    }

    /* renamed from: b */
    public void mo5822b(long j) {
        C1069c.f2844u = j;
        m4409a(140, String.valueOf(C1069c.f2844u));
    }

    /* renamed from: b */
    public void mo5823b(String str) {
        if (str != null) {
            m4409a(162, str);
        }
    }

    /* renamed from: c */
    public void mo5824c() {
        try {
            m4410a(TransportMediator.KEYCODE_MEDIA_RECORD, C0476a.m1776b(C1069c.f2839p.getBytes()));
        } catch (Exception e) {
            C1115d.m4558a(e);
        }
    }

    /* renamed from: c */
    public void mo5825c(long j) {
        C1069c.f2843t = j;
        m4409a(138, String.valueOf(C1069c.f2843t));
    }

    /* renamed from: c */
    public void mo5826c(String str) {
        if (!TextUtils.isEmpty(str)) {
            C1069c.f2821C = str;
            m4410a(157, C0476a.m1776b(str.getBytes()));
        }
    }

    /* renamed from: d */
    public void mo5827d() {
        try {
            m4410a(131, C0476a.m1776b(C1069c.f2840q.getBytes()));
        } catch (Exception e) {
            C1115d.m4558a(e);
        }
    }

    /* renamed from: d */
    public void mo5828d(long j) {
        C1069c.f2846w = j;
        m4409a(141, String.valueOf(C1069c.f2846w));
    }

    /* renamed from: d */
    public void mo5829d(String str) {
        if (!TextUtils.isEmpty(str)) {
            C1069c.f2841r = str;
            m4410a(151, C0476a.m1776b(str.getBytes()));
        }
    }

    /* renamed from: e */
    public void mo5830e(long j) {
        C1069c.f2847x = j;
        m4409a(142, String.valueOf(C1069c.f2847x));
    }

    /* renamed from: e */
    public boolean mo5831e() {
        if (C1069c.f2828e == null || C1069c.f2828e.isClosed()) {
            C1069c.f2828e = m4411f();
            if (C1069c.f2828e == null) {
                return false;
            }
        }
        C1115d.m4557a("GBD_RDM", "open port success !");
        return true;
    }

    /* renamed from: f */
    public void mo5832f(long j) {
        C1069c.f2848y = j;
        m4409a(145, String.valueOf(C1069c.f2848y));
    }

    /* renamed from: g */
    public void mo5833g(long j) {
        C1069c.f2820B = j;
        m4409a(158, String.valueOf(C1069c.f2820B));
    }

    /* renamed from: h */
    public void mo5834h(long j) {
        C1069c.f2833j = j;
        m4409a(104, String.valueOf(j));
    }

    /* renamed from: i */
    public void mo5835i(long j) {
        C1069c.f2834k = j;
        m4409a(TransportMediator.KEYCODE_MEDIA_PLAY, String.valueOf(j));
    }

    /* renamed from: j */
    public void mo5836j(long j) {
        C1069c.f2838o = j;
        m4409a(125, Long.toString(j));
    }

    /* renamed from: k */
    public void mo5837k(long j) {
        C1069c.f2842s = j;
        m4409a(154, String.valueOf(C1069c.f2842s));
    }
}
