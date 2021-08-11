package com.igexin.p012b.p013a.p015b.p016a.p017a;

import android.text.TextUtils;
import com.igexin.p012b.p013a.p015b.C0459f;
import com.igexin.p012b.p013a.p015b.p016a.p017a.p018a.AbstractC0441d;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.p026c.C0494i;
import java.net.InetSocketAddress;
import java.net.Socket;

/* renamed from: com.igexin.b.a.b.a.a.c */
public final class C0443c extends AbstractC0437a {

    /* renamed from: i */
    private static final String f1036i = C0443c.class.getName();

    /* renamed from: L */
    private Socket f1037L;

    /* renamed from: j */
    private AbstractC0441d f1038j;

    public C0443c(AbstractC0441d dVar) {
        super(-2037, null, null);
        this.f1038j = dVar;
    }

    @Override // com.igexin.p012b.p013a.p020d.p021a.AbstractC0466e
    /* renamed from: b */
    public final int mo4136b() {
        return -2037;
    }

    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d
    /* renamed from: b_ */
    public void mo4137b_() {
        super.mo4137b_();
        C0494i.m1834a().mo4281e().mo4262a();
        String cmAddress = SDKUrlConfig.getCmAddress();
        try {
            String[] a = C0459f.m1684a(cmAddress);
            String str = a[1];
            int parseInt = Integer.parseInt(a[2]);
            ActivityC0460a.m1698b(f1036i + "|start connect :  " + cmAddress + " *********");
            if (this.f1038j != null) {
                this.f1038j.mo4134a(cmAddress);
            }
            this.f1037L = new Socket();
            try {
                this.f1037L.connect(new InetSocketAddress(str, parseInt), 10000);
                ActivityC0460a.m1698b(f1036i + "|connected :  " + cmAddress + " #########");
                if (this.f1029f != EnumC0442b.INTERRUPT) {
                    this.f1029f = EnumC0442b.NORMAL;
                }
            } catch (Exception e) {
                if (this.f1029f != EnumC0442b.INTERRUPT) {
                    this.f1029f = EnumC0442b.EXCEPTION;
                    this.f1030g = e.toString();
                }
            }
            this.f1028e = true;
        } catch (Exception e2) {
            ActivityC0460a.m1698b(f1036i + "|ips invalid, " + e2.toString());
            throw e2;
        }
    }

    @Override // com.igexin.p012b.p013a.p020d.AbstractC0470d, com.igexin.p012b.p013a.p015b.AbstractC0458e
    /* renamed from: f */
    public void mo4138f() {
        super.mo4138f();
        ActivityC0460a.m1698b(f1036i + "|dispose");
        if (this.f1038j != null) {
            if (this.f1029f == EnumC0442b.INTERRUPT) {
                this.f1038j.mo4129a(this);
            } else if (this.f1029f == EnumC0442b.EXCEPTION) {
                if (!TextUtils.isEmpty(this.f1030g)) {
                    this.f1038j.mo4133a(new Exception(this.f1030g));
                }
            } else if (this.f1029f == EnumC0442b.NORMAL && this.f1037L != null) {
                this.f1038j.mo4135a(this.f1037L);
            }
        }
        this.f1038j = null;
    }

    /* renamed from: h */
    public void mo4139h() {
        this.f1029f = EnumC0442b.INTERRUPT;
        try {
            if (this.f1037L != null && !this.f1028e) {
                this.f1037L.notifyAll();
            }
        } catch (Exception e) {
        }
    }
}
