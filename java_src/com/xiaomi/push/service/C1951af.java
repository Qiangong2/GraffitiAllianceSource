package com.xiaomi.push.service;

import com.google.protobuf.micro.C0396a;
import com.google.protobuf.micro.C0397b;
import com.xiaomi.channel.commonutils.file.C1851a;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.channel.commonutils.misc.C1857b;
import com.xiaomi.push.protobuf.C1928a;
import com.xiaomi.push.protobuf.C1930b;
import com.xiaomi.smack.util.C2046h;
import com.xiaomi.smack.util.C2047i;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.push.service.af */
public class C1951af {

    /* renamed from: d */
    private static C1951af f5042d = new C1951af();

    /* renamed from: a */
    private List<AbstractC1952a> f5043a = new ArrayList();

    /* renamed from: b */
    private C1928a.C1929a f5044b;

    /* renamed from: c */
    private C1857b.AbstractC1859b f5045c;

    /* renamed from: com.xiaomi.push.service.af$a */
    public static abstract class AbstractC1952a {
        /* renamed from: a */
        public void mo10392a(C1928a.C1929a aVar) {
        }

        /* renamed from: a */
        public void mo10393a(C1930b.C1931a aVar) {
        }
    }

    static {
        f5042d.m7277f();
    }

    private C1951af() {
    }

    /* renamed from: a */
    public static C1951af m7272a() {
        return f5042d;
    }

    /* renamed from: e */
    private void m7276e() {
        if (this.f5045c == null) {
            this.f5045c = new C1953ag(this);
            C2047i.m7709a(this.f5045c);
        }
    }

    /* renamed from: f */
    private void m7277f() {
        Throwable th;
        Exception e;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            if (this.f5044b != null) {
                bufferedInputStream = new BufferedInputStream(C2046h.m7706a().openFileInput("XMCloudCfg"));
                try {
                    this.f5044b = C1928a.C1929a.m7134c(C0396a.m1434a(bufferedInputStream));
                    bufferedInputStream.close();
                } catch (Exception e2) {
                    bufferedInputStream2 = bufferedInputStream;
                    e = e2;
                    try {
                        AbstractC1855b.m6718a("save config failure: " + e.getMessage());
                        C1851a.m6703a(bufferedInputStream2);
                    } catch (Throwable th2) {
                        th = th2;
                        C1851a.m6703a(bufferedInputStream2);
                        throw th;
                    }
                } catch (Throwable th3) {
                    bufferedInputStream2 = bufferedInputStream;
                    th = th3;
                    C1851a.m6703a(bufferedInputStream2);
                    throw th;
                }
            } else {
                bufferedInputStream = null;
            }
            C1851a.m6703a(bufferedInputStream);
        } catch (Exception e3) {
            e = e3;
            AbstractC1855b.m6718a("save config failure: " + e.getMessage());
            C1851a.m6703a(bufferedInputStream2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m7278g() {
        try {
            if (this.f5044b != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(C2046h.m7706a().openFileOutput("XMCloudCfg", 0));
                C0397b a = C0397b.m1453a(bufferedOutputStream);
                this.f5044b.mo4057a(a);
                a.mo4036a();
                bufferedOutputStream.close();
            }
        } catch (Exception e) {
            AbstractC1855b.m6718a("save config failure: " + e.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10387a(C1930b.C1931a aVar) {
        AbstractC1952a[] aVarArr;
        if (aVar.mo10337h() && aVar.mo10336g() > mo10390c()) {
            m7276e();
        }
        synchronized (this) {
            aVarArr = (AbstractC1952a[]) this.f5043a.toArray(new AbstractC1952a[this.f5043a.size()]);
        }
        for (AbstractC1952a aVar2 : aVarArr) {
            aVar2.mo10393a(aVar);
        }
    }

    /* renamed from: a */
    public synchronized void mo10388a(AbstractC1952a aVar) {
        this.f5043a.add(aVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo10389b() {
        this.f5043a.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo10390c() {
        if (this.f5044b != null) {
            return this.f5044b.mo10317c();
        }
        return 0;
    }

    /* renamed from: d */
    public C1928a.C1929a mo10391d() {
        return this.f5044b;
    }
}
