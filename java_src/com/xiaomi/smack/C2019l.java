package com.xiaomi.smack;

import android.os.SystemClock;
import android.support.p007v4.view.MotionEventCompat;
import android.support.p007v4.view.ViewCompat;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.channel.commonutils.network.C1865d;
import com.xiaomi.network.Fallback;
import com.xiaomi.network.HostManager;
import com.xiaomi.push.service.C1987w;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.filter.AbstractC2010a;
import com.xiaomi.smack.packet.AbstractC2028d;
import com.xiaomi.smack.packet.C2030f;
import com.xiaomi.smack.util.C2047i;
import com.xiaomi.stats.C2062g;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import p000a.p001a.p002a.p004b.C0027o;

/* renamed from: com.xiaomi.smack.l */
public class C2019l extends AbstractC2002a {

    /* renamed from: A */
    private int f5334A;

    /* renamed from: n */
    public Exception f5335n = null;

    /* renamed from: o */
    protected Socket f5336o;

    /* renamed from: p */
    String f5337p = null;

    /* renamed from: q */
    C2013i f5338q;

    /* renamed from: r */
    C2011g f5339r;

    /* renamed from: s */
    private String f5340s = null;

    /* renamed from: t */
    private String f5341t = "";

    /* renamed from: u */
    private String f5342u;

    /* renamed from: v */
    private XMPushService f5343v;

    /* renamed from: w */
    private volatile long f5344w = 0;

    /* renamed from: x */
    private volatile long f5345x = 0;

    /* renamed from: y */
    private final String f5346y = "<pf><p>t:%1$d</p></pf>";

    /* renamed from: z */
    private volatile long f5347z = 0;

    public C2019l(XMPushService xMPushService, C2004b bVar) {
        super(xMPushService, bVar);
        this.f5343v = xMPushService;
    }

    /* renamed from: a */
    private void m7567a(C2004b bVar) {
        m7569a(bVar.mo10532f(), bVar.mo10531e());
    }

    /* renamed from: a */
    private void m7568a(Exception exc) {
        if (SystemClock.elapsedRealtime() - this.f5347z >= 300000) {
            this.f5334A = 0;
        } else if (C1865d.m6762d(this.f5343v)) {
            this.f5334A++;
            if (this.f5334A >= 2) {
                String c = mo10509c();
                AbstractC1855b.m6718a("max short conn time reached, sink down current host:" + c);
                m7570a(c, 0, exc);
                this.f5334A = 0;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0224, code lost:
        if (android.text.TextUtils.equals(r10, com.xiaomi.channel.commonutils.network.C1865d.m6764f(r16.f5343v)) != false) goto L_0x0226;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0112 A[SYNTHETIC, Splitter:B:25:0x0112] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0227 A[RETURN] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m7569a(java.lang.String r17, int r18) {
        /*
        // Method dump skipped, instructions count: 570
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smack.C2019l.m7569a(java.lang.String, int):void");
    }

    /* renamed from: a */
    private void m7570a(String str, long j, Exception exc) {
        Fallback fallbacksByHost = HostManager.getInstance().getFallbacksByHost(C2004b.m7515b(), false);
        if (fallbacksByHost != null) {
            fallbacksByHost.mo10240b(str, j, 0, exc);
            HostManager.getInstance().persist();
        }
    }

    /* renamed from: x */
    private synchronized void m7571x() {
        m7572y();
        this.f5338q = new C2013i(this);
        this.f5339r = new C2011g(this);
        if (this.f5300l.mo10533g()) {
            mo10498a(this.f5295g.mo10101c(), (AbstractC2010a) null);
            if (this.f5295g.mo10102d() != null) {
                mo10507b(this.f5295g.mo10102d(), null);
            }
        }
        this.f5338q.mo10543c();
        this.f5339r.mo10536b();
    }

    /* renamed from: y */
    private void m7572y() {
        try {
            this.f5296h = new BufferedReader(new InputStreamReader(this.f5336o.getInputStream(), "UTF-8"), 4096);
            this.f5297i = new BufferedWriter(new OutputStreamWriter(this.f5336o.getOutputStream(), "UTF-8"));
            if (this.f5296h != null && this.f5297i != null) {
                mo10512f();
            }
        } catch (Exception e) {
            throw new C2023p("Error to init reader and writer", e);
        }
    }

    /* renamed from: a */
    public void mo10550a(int i, Exception exc) {
        this.f5343v.mo10350a(new C2021n(this, 2, i, exc));
    }

    @Override // com.xiaomi.smack.AbstractC2002a
    /* renamed from: a */
    public synchronized void mo10496a(C1987w.C1989b bVar) {
        new C2015k().mo10545a(bVar, mo10554r(), this);
    }

    @Override // com.xiaomi.smack.AbstractC2002a
    /* renamed from: a */
    public void mo10499a(AbstractC2028d dVar) {
        if (this.f5338q != null) {
            this.f5338q.mo10541a(dVar);
            return;
        }
        throw new C2023p("the writer is null.");
    }

    @Override // com.xiaomi.smack.AbstractC2002a
    /* renamed from: a */
    public void mo10500a(C2030f fVar, int i, Exception exc) {
        mo10551b(fVar, i, exc);
        if (exc != null && this.f5347z != 0) {
            m7568a(exc);
        }
    }

    @Override // com.xiaomi.smack.AbstractC2002a
    /* renamed from: a */
    public synchronized void mo10502a(String str, String str2) {
        C2030f fVar = new C2030f(C2030f.EnumC2032b.unavailable);
        fVar.mo10612l(str);
        fVar.mo10616n(str2);
        if (this.f5338q != null) {
            this.f5338q.mo10541a(fVar);
        }
    }

    @Override // com.xiaomi.smack.AbstractC2002a
    /* renamed from: a */
    public void mo10503a(AbstractC2028d[] dVarArr) {
        for (AbstractC2028d dVar : dVarArr) {
            mo10499a(dVar);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public synchronized void mo10551b(C2030f fVar, int i, Exception exc) {
        if (mo10520n() != 2) {
            mo10495a(2, i, exc);
            this.f5298j = "";
            if (this.f5339r != null) {
                this.f5339r.mo10537c();
                this.f5339r.mo10538d();
                this.f5339r = null;
            }
            if (this.f5338q != null) {
                try {
                    this.f5338q.mo10542b();
                } catch (IOException e) {
                    AbstractC1855b.m6720a(e);
                }
                this.f5338q.mo10540a();
                this.f5338q = null;
            }
            try {
                this.f5336o.close();
            } catch (Throwable th) {
            }
            if (this.f5296h != null) {
                try {
                    this.f5296h.close();
                } catch (Throwable th2) {
                }
                this.f5296h = null;
            }
            if (this.f5297i != null) {
                try {
                    this.f5297i.close();
                } catch (Throwable th3) {
                }
                this.f5297i = null;
            }
            this.f5344w = 0;
            this.f5345x = 0;
        }
    }

    /* renamed from: b */
    public void mo10552b(String str) {
        this.f5341t = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Fallback mo10553c(String str) {
        Fallback fallbacksByHost = HostManager.getInstance().getFallbacksByHost(str, false);
        if (!fallbacksByHost.mo10241b()) {
            C2047i.m7711a(new RunnableC2022o(this, str));
        }
        this.f5292d = 0;
        try {
            byte[] address = InetAddress.getByName(fallbacksByHost.f4898f).getAddress();
            this.f5292d = address[0] & 255;
            this.f5292d |= (address[1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK;
            this.f5292d |= (address[2] << C0027o.f105n) & 16711680;
            this.f5292d = ((address[3] << 24) & ViewCompat.MEASURED_STATE_MASK) | this.f5292d;
        } catch (UnknownHostException e) {
        }
        return fallbacksByHost;
    }

    @Override // com.xiaomi.smack.AbstractC2002a
    /* renamed from: c */
    public String mo10509c() {
        return this.f5342u;
    }

    @Override // com.xiaomi.smack.AbstractC2002a
    /* renamed from: m */
    public void mo10519m() {
        if (this.f5338q != null) {
            this.f5338q.mo10544d();
            this.f5343v.mo10351a(new C2020m(this, 13, System.currentTimeMillis()), 15000);
            return;
        }
        throw new C2023p("the packetwriter is null.");
    }

    /* renamed from: r */
    public String mo10554r() {
        return this.f5298j;
    }

    /* renamed from: s */
    public synchronized void mo10555s() {
        try {
            if (mo10514h() || mo10513g()) {
                AbstractC1855b.m6718a("WARNING: current xmpp has connected");
            } else {
                mo10495a(0, 0, (Exception) null);
                m7567a(this.f5300l);
            }
        } catch (IOException e) {
            throw new C2023p(e);
        }
    }

    /* renamed from: t */
    public String mo10556t() {
        String format = (this.f5345x == 0 || this.f5344w == 0) ? "" : String.format("<pf><p>t:%1$d</p></pf>", Long.valueOf(this.f5345x - this.f5344w));
        String c = C2062g.m7769c();
        return String.format(this.f5341t, format, c != null ? "<q>" + c + "</q>" : "");
    }

    /* renamed from: u */
    public Socket mo10557u() {
        return new Socket();
    }

    /* renamed from: v */
    public void mo10558v() {
        this.f5344w = SystemClock.uptimeMillis();
    }

    /* renamed from: w */
    public void mo10559w() {
        this.f5345x = SystemClock.uptimeMillis();
    }
}
