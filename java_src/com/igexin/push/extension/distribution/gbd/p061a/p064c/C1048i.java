package com.igexin.push.extension.distribution.gbd.p061a.p064c;

import android.content.Context;
import android.text.TextUtils;
import com.igexin.push.core.C0618g;
import com.igexin.push.extension.distribution.gbd.p066b.C1063f;
import com.igexin.push.extension.distribution.gbd.p066b.C1065h;
import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import com.igexin.push.extension.distribution.gbd.p068d.C1071b;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1080b;
import com.igexin.push.extension.distribution.gbd.p069e.p070a.C1083e;
import com.igexin.push.extension.distribution.gbd.p076i.C1115d;
import com.igexin.push.extension.distribution.gbd.p076i.C1116e;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.pwrd.paho.client.mqttv3.MqttTopic;

/* renamed from: com.igexin.push.extension.distribution.gbd.a.c.i */
public class C1048i {

    /* renamed from: b */
    private static C1048i f2691b;

    /* renamed from: a */
    private Context f2692a;

    /* renamed from: c */
    private DatagramSocket f2693c;

    /* renamed from: d */
    private String f2694d;

    /* renamed from: e */
    private ThreadPoolExecutor f2695e;

    /* renamed from: f */
    private ThreadPoolExecutor f2696f;

    /* renamed from: g */
    private Map<String, String> f2697g;

    /* renamed from: h */
    private Map<String, String> f2698h;

    private C1048i(Context context) {
        try {
            this.f2692a = context;
            this.f2697g = Collections.synchronizedMap(new HashMap());
            this.f2698h = Collections.synchronizedMap(new HashMap());
            this.f2695e = new ThreadPoolExecutor(2, 3, 3, TimeUnit.SECONDS, new LinkedBlockingDeque(C1067a.f2767R));
            this.f2696f = new ThreadPoolExecutor(2, 3, 3, TimeUnit.SECONDS, new LinkedBlockingDeque(C1067a.f2767R));
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }

    /* renamed from: a */
    public static C1048i m4250a() {
        if (f2691b == null) {
            f2691b = new C1048i(C1069c.f2824a);
        }
        return f2691b;
    }

    /* access modifiers changed from: public */
    /* renamed from: a */
    private void m4253a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(C1116e.m4607k()));
            C1065h b = C1116e.m4576b(this.f2692a);
            String b2 = b.mo5779b();
            if (!TextUtils.isEmpty(b2)) {
                b2 = b2.replace(":", "");
            }
            StringBuilder sb = new StringBuilder();
            sb.append(format);
            sb.append("|");
            sb.append(C0618g.f1647r);
            sb.append("|");
            sb.append(C0618g.f1602a);
            sb.append("|");
            sb.append(b.mo5781c()).append(MqttTopic.MULTI_LEVEL_WILDCARD).append(b.mo5777a());
            sb.append("|");
            sb.append(b2);
            sb.append("|");
            sb.append(str);
            sb.append("|");
            sb.append(str2);
            sb.append("|");
            sb.append(str3);
            sb.append("|");
            sb.append(b.mo5783d());
            sb.append("|");
            sb.append(b.mo5785e());
            sb.append("|");
            sb.append("ANDROID");
            C1080b.m4391a().mo5812a(sb.toString(), mo5712c());
            C1115d.m4559b("GBD_SLMA", "save type = " + mo5712c());
        }
    }

    /* renamed from: d */
    private ArrayList<C1063f> m4257d() {
        int e = C1116e.m4592e();
        long a = C1116e.m4560a(C1116e.m4575b(this.f2694d), e);
        long b = C1116e.m4574b(C1116e.m4575b(this.f2694d), e);
        C1115d.m4559b("GBD_SLMA", "start " + a + ", end " + b);
        C1115d.m4559b("GBD_SLMA", "cn = " + (((int) (b - a)) + 1));
        long b2 = C1116e.m4575b(this.f2694d);
        ArrayList<C1063f> arrayList = new ArrayList<>();
        if (((long) C1067a.f2767R) > 254) {
            long c = C1116e.m4582c(b2, 1);
            long c2 = C1116e.m4582c(a, 0);
            long c3 = C1116e.m4582c(b, 0);
            C1063f fVar = new C1063f();
            fVar.mo5764a(C1116e.m4561a(b2, c, c2));
            fVar.mo5766b(C1116e.m4561a(b2, c, c3));
            arrayList.add(fVar);
            ArrayList<Long> g = C1116e.m4600g();
            if (g != null && g.size() > 0) {
                g.remove(Long.valueOf(c));
                long j = ((long) C1067a.f2767R) - 254;
                for (int i = 0; i < g.size(); i++) {
                    C1063f fVar2 = new C1063f();
                    if (j >= 254) {
                        fVar2.mo5764a(C1116e.m4561a(b2, g.get(i).longValue(), c2));
                        fVar2.mo5766b(C1116e.m4561a(b2, g.get(i).longValue(), c3));
                        arrayList.add(fVar2);
                        j -= 254;
                    } else if (j > 0) {
                        fVar2.mo5764a(C1116e.m4561a(b2, g.get(i).longValue(), c2));
                        fVar2.mo5766b(C1116e.m4561a(b2, g.get(i).longValue(), j));
                        arrayList.add(fVar2);
                        j = 0;
                    }
                }
            }
        } else {
            C1063f fVar3 = new C1063f();
            fVar3.mo5764a(a);
            fVar3.mo5766b(((long) C1067a.f2767R) + a);
            arrayList.add(fVar3);
        }
        return arrayList;
    }

    /* access modifiers changed from: public */
    /* renamed from: e */
    private byte[] m4260e() {
        byte[] bArr = new byte[50];
        bArr[0] = 126;
        bArr[1] = 40;
        bArr[2] = 0;
        bArr[3] = 0;
        bArr[4] = 0;
        bArr[5] = 1;
        bArr[6] = 0;
        bArr[7] = 0;
        bArr[8] = 0;
        bArr[9] = 0;
        bArr[10] = 0;
        bArr[11] = 0;
        bArr[12] = 32;
        bArr[13] = 67;
        bArr[14] = 75;
        for (int i = 15; i < 45; i++) {
            bArr[i] = 65;
        }
        bArr[45] = 0;
        bArr[46] = 0;
        bArr[47] = 33;
        bArr[48] = 0;
        bArr[49] = 1;
        return bArr;
    }

    /* renamed from: b */
    public void mo5711b() {
        try {
            C1115d.m4559b("GBD_SLMA", "dosample");
            if (this.f2698h != null) {
                this.f2698h.clear();
            }
            if (this.f2697g != null) {
                this.f2697g.clear();
            }
            boolean e = C1071b.m4348a().mo5797e();
            C1115d.m4559b("GBD_SLMA", "doSample checkSafeStatus = " + e);
            if (!e) {
                C1115d.m4559b("GBD_SLMA", "failed, wa = " + C1067a.f2792c + ", ws = " + C1067a.f2793d);
            } else if (!C1116e.m4591d(this.f2692a) || !C1083e.m4408a().mo5831e()) {
                C1115d.m4559b("GBD_SLMA", "wif = false or port failed");
            } else {
                this.f2694d = C1116e.m4589d();
                ArrayList<C1063f> d = m4257d();
                if (!(d == null || d.isEmpty())) {
                    if (this.f2693c == null) {
                        this.f2693c = new DatagramSocket();
                    }
                    Iterator<C1063f> it = d.iterator();
                    while (it.hasNext()) {
                        C1063f next = it.next();
                        for (long a = next.mo5763a(); a <= next.mo5765b(); a++) {
                            this.f2695e.execute(new RunnableC1053n(this, C1116e.m4564a(a)));
                        }
                    }
                    this.f2695e.execute(new RunnableC1050k(this));
                }
            }
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }

    /* renamed from: c */
    public int mo5712c() {
        return 27;
    }
}
