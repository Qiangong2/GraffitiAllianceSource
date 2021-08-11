package com.igexin.push.p036e;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.support.p007v4.view.MotionEventCompat;
import com.igexin.p012b.p013a.p015b.C0459f;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p022b.C0476a;
import com.igexin.push.config.C0514k;
import com.igexin.push.core.C0617f;
import com.igexin.push.core.C0618g;
import com.igexin.push.core.C0628q;
import com.igexin.push.core.EnumC0602c;
import com.igexin.push.core.EnumC0613d;
import com.igexin.push.core.p027a.C0535e;
import com.igexin.push.p032d.p035c.AbstractC0642e;
import com.igexin.push.p032d.p035c.C0638a;
import com.igexin.push.p032d.p035c.C0639b;
import com.igexin.push.p032d.p035c.C0640c;
import com.igexin.push.p032d.p035c.C0641d;
import com.igexin.push.p032d.p035c.C0643f;
import com.igexin.push.p032d.p035c.C0646i;
import com.igexin.push.p032d.p035c.C0648k;
import com.igexin.push.p032d.p035c.C0650m;
import com.igexin.push.p032d.p035c.C0651n;
import com.igexin.push.p032d.p035c.C0652o;
import com.igexin.push.p032d.p035c.C0653p;
import com.igexin.push.p032d.p035c.C0654q;
import com.igexin.push.p079f.p081b.AbstractC1150h;
import com.igexin.push.util.C1151a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.igexin.push.e.c */
public class C0663c {

    /* renamed from: a */
    private Context f1794a;

    /* renamed from: b */
    private EnumC0613d f1795b;

    /* renamed from: c */
    private AbstractC1150h f1796c;

    /* renamed from: d */
    private AbstractC1150h f1797d;

    /* renamed from: e */
    private C0662b f1798e;

    /* renamed from: f */
    private List<C0669i> f1799f;

    /* renamed from: g */
    private Map<String, C0662b> f1800g;

    /* renamed from: h */
    private Map<String, C0662b> f1801h;

    /* renamed from: i */
    private boolean f1802i;

    /* renamed from: a */
    private AbstractC0642e m2553a(byte[] bArr) {
        C0639b b = m2557b(bArr);
        AbstractC0642e eVar = null;
        switch (b.f1702b) {
            case 4:
                eVar = new C0648k();
                break;
            case 5:
                eVar = new C0650m();
                break;
            case 6:
                eVar = new C0643f();
                break;
            case 9:
                eVar = new C0654q();
                break;
            case MotionEventCompat.AXIS_TILT:
                eVar = new C0641d();
                break;
            case 26:
                eVar = new C0653p();
                break;
            case 27:
                eVar = new C0640c();
                break;
            case 28:
                eVar = new C0638a();
                break;
            case MotionEventCompat.AXIS_GENERIC_5:
                eVar = new C0651n();
                break;
            case MotionEventCompat.AXIS_GENERIC_6:
                eVar = new C0652o();
                break;
            case 96:
                eVar = new C0646i();
                break;
        }
        if (eVar != null) {
            eVar.mo4682a(b.f1705e);
        }
        return eVar;
    }

    /* renamed from: b */
    private C0639b m2557b(byte[] bArr) {
        C0639b bVar = new C0639b();
        bVar.f1701a = C0459f.m1690c(bArr, 0);
        bVar.f1702b = bArr[2];
        bVar.f1705e = new byte[bVar.f1701a];
        C0459f.m1678a(bArr, 3, bVar.f1705e, 0, bVar.f1701a);
        return bVar;
    }

    /* renamed from: b */
    private void m2558b(C0661a aVar) {
        switch (C0668h.f1810b[aVar.f1788a.ordinal()]) {
            case 1:
                this.f1799f.clear();
                this.f1800g.clear();
                this.f1801h.clear();
                if (this.f1796c != null) {
                    this.f1796c.mo4207u();
                }
                if (this.f1797d != null) {
                    this.f1797d.mo4207u();
                }
                this.f1802i = false;
                boolean z = C0618g.f1638i;
                boolean z2 = C0618g.f1639j;
                boolean a = C1151a.m4739a(System.currentTimeMillis());
                boolean b = C1151a.m4747b();
                if (z && z2 && !a && b) {
                    if (C0514k.f1321m) {
                        Intent intent = new Intent();
                        intent.setAction("com.igexin.sdk.action.snlrefresh");
                        intent.putExtra("groupid", C0618g.f1633d);
                        intent.putExtra("branch", "open");
                        intent.putExtra("responseSNLAction", C0618g.f1596U);
                        this.f1794a.sendBroadcast(intent);
                        this.f1796c = new C0664d(this, 1000);
                        if (!C0617f.m2395a().mo4619a(this.f1796c)) {
                        }
                        return;
                    }
                    ActivityC0460a.m1698b("SNLCoordinator|isSnl = false, doActive");
                    m2564d();
                    return;
                }
                return;
            case 2:
                int size = this.f1799f.size();
                if (size == 0) {
                    m2564d();
                    return;
                }
                int i = 1;
                C0669i iVar = this.f1799f.get(0);
                while (i < size) {
                    C0669i iVar2 = this.f1799f.get(i);
                    if (iVar2.mo4734c() >= iVar.mo4734c()) {
                        iVar2 = iVar;
                    }
                    i++;
                    iVar = iVar2;
                }
                if (this.f1794a.getPackageName().equals(iVar.mo4728a())) {
                    m2564d();
                    return;
                }
                this.f1795b = EnumC0613d.prepare;
                this.f1798e = new C0662b();
                this.f1798e.mo4706a(iVar.mo4728a());
                this.f1798e.mo4708b(iVar.mo4731b());
                C0661a aVar2 = new C0661a();
                aVar2.mo4702a(EnumC0602c.determine);
                mo4719a(aVar2);
                return;
            case 3:
            case 4:
                if (this.f1796c != null) {
                    this.f1796c.mo4207u();
                }
                m2562c();
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    private void m2559b(String str) {
        C0662b bVar = this.f1800g.get(str);
        bVar.mo4704a(new ServiceConnectionC0667g(this, bVar, str));
        try {
            Context createPackageContext = this.f1794a.createPackageContext(bVar.mo4703a(), 3);
            this.f1794a.bindService(new Intent(createPackageContext, createPackageContext.getClassLoader().loadClass(bVar.mo4707b())), bVar.mo4711d(), 0);
        } catch (Exception e) {
        }
        this.f1800g.put(str, bVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public List<String> m2561c(String str) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, C0662b> entry : this.f1801h.entrySet()) {
            if (entry.getValue().mo4712e().equals(str)) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m2562c() {
        this.f1795b = EnumC0613d.init;
        C0661a aVar = new C0661a();
        aVar.mo4702a(EnumC0602c.start);
        mo4719a(aVar);
    }

    /* renamed from: c */
    private void m2563c(C0661a aVar) {
        switch (C0668h.f1810b[aVar.f1788a.ordinal()]) {
            case 3:
            case 4:
                if (this.f1797d != null) {
                    this.f1797d.mo4207u();
                }
                if (this.f1798e.mo4709c() != null) {
                    try {
                        this.f1794a.unbindService(this.f1798e.mo4711d());
                    } catch (Exception e) {
                    }
                }
                m2562c();
                return;
            case 5:
                this.f1797d = new C0665e(this, 5000);
                if (!C0617f.m2395a().mo4619a(this.f1797d)) {
                }
                this.f1798e.mo4704a(new ServiceConnectionC0666f(this));
                try {
                    Context createPackageContext = this.f1794a.createPackageContext(this.f1798e.mo4703a(), 3);
                    this.f1794a.bindService(new Intent(createPackageContext, createPackageContext.getClassLoader().loadClass(this.f1798e.mo4707b())), this.f1798e.mo4711d(), 0);
                    return;
                } catch (Exception e2) {
                    return;
                }
            case 6:
                try {
                    this.f1798e.mo4709c().onPSNLConnected(this.f1794a.getPackageName(), C0535e.m2034a().mo4360a(C0618g.f1635f).getName(), "", 0);
                    return;
                } catch (Exception e3) {
                    return;
                }
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m2564d() {
        this.f1799f.clear();
        this.f1795b = EnumC0613d.active;
        if (this.f1802i) {
            for (Map.Entry<String, C0662b> entry : this.f1800g.entrySet()) {
                m2559b(entry.getKey());
            }
            this.f1802i = false;
        }
        ActivityC0460a.m1698b("SNLCoordinator|doActive, state = " + this.f1795b + ", setASNL = true");
        C0617f.m2395a().mo4628g().mo4740a(true);
    }

    /* renamed from: d */
    private void m2565d(C0661a aVar) {
        switch (C0668h.f1810b[aVar.f1788a.ordinal()]) {
            case 3:
                ActivityC0460a.m1698b("SNLCoordinator|event = stop, setASNL(false)");
                C0617f.m2395a().mo4628g().mo4740a(false);
                C0617f.m2395a().mo4628g().mo4743b(true);
                if (C0514k.f1321m) {
                    Intent intent = new Intent();
                    intent.setAction("com.igexin.sdk.action.snlretire");
                    intent.putExtra("groupid", C0618g.f1633d);
                    intent.putExtra("branch", "open");
                    this.f1794a.sendBroadcast(intent);
                    return;
                }
                C0661a aVar2 = new C0661a();
                aVar2.mo4702a(EnumC0602c.retire);
                C0617f.m2395a().mo4629h().mo4719a(aVar2);
                return;
            case 4:
                C0618g.f1595T = System.currentTimeMillis();
                for (Map.Entry<String, C0662b> entry : this.f1800g.entrySet()) {
                    try {
                        this.f1794a.unbindService(entry.getValue().mo4711d());
                    } catch (Exception e) {
                    }
                }
                ActivityC0460a.m1698b("SNLCoordinator | state = " + EnumC0613d.passive + ", setASNL(false)");
                C0617f.m2395a().mo4628g().mo4740a(false);
                m2562c();
                return;
            case 5:
            case 6:
            default:
                return;
            case 7:
                Intent intent2 = new Intent();
                intent2.setAction("com.igexin.sdk.action.snlretire");
                intent2.putExtra("groupid", C0618g.f1633d);
                intent2.putExtra("branch", "open");
                this.f1794a.sendBroadcast(intent2);
                return;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: e */
    private void m2568e(C0661a aVar) {
        switch (C0668h.f1810b[aVar.f1788a.ordinal()]) {
            case 3:
                if (C0618g.f1641l) {
                    C0651n nVar = new C0651n();
                    nVar.f1765a = C0618g.f1646q;
                    C0617f.m2395a().mo4628g().mo4737a("S-" + String.valueOf(C0618g.f1646q), (AbstractC0642e) nVar, true);
                    break;
                }
                break;
            case 4:
                break;
            default:
                return;
        }
        C0618g.f1595T = System.currentTimeMillis();
        C0617f.m2395a().mo4628g().mo4743b(true);
        try {
            this.f1794a.unbindService(this.f1798e.mo4711d());
        } catch (Exception e) {
        }
        m2562c();
    }

    /* renamed from: a */
    public int mo4713a(String str) {
        if (this.f1795b != EnumC0613d.prepare || str.equals("")) {
            return -1;
        }
        this.f1797d.mo4207u();
        this.f1800g.clear();
        this.f1801h.clear();
        this.f1802i = false;
        this.f1799f.clear();
        this.f1798e.mo4710c(str);
        this.f1795b = EnumC0613d.passive;
        ActivityC0460a.m1698b("SNLCoordinator | state = " + EnumC0613d.passive + ", setASNL(false)");
        C0617f.m2395a().mo4628g().mo4740a(false);
        return 0;
    }

    /* renamed from: a */
    public int mo4714a(String str, AbstractC0642e eVar) {
        C0639b bVar = new C0639b();
        bVar.f1705e = eVar.mo4685d();
        if (bVar.f1705e != null) {
            bVar.f1701a = bVar.f1705e.length;
            bVar.f1702b = (byte) eVar.f1723i;
            byte[] a = bVar.mo4687a();
            if (!(this.f1798e == null || this.f1798e.mo4709c() == null)) {
                try {
                    return this.f1798e.mo4709c().sendByASNL(this.f1798e.mo4712e(), str, a);
                } catch (Exception e) {
                    m2562c();
                }
            }
        }
        return -1;
    }

    /* renamed from: a */
    public int mo4715a(String str, String str2) {
        if (this.f1795b == EnumC0613d.prepare || this.f1795b == EnumC0613d.passive) {
            return -1;
        }
        C0662b bVar = new C0662b();
        bVar.mo4706a(str);
        bVar.mo4708b(str2);
        bVar.mo4710c(str);
        this.f1800g.put(str, bVar);
        if (this.f1795b == EnumC0613d.active) {
            m2559b(str);
        } else {
            this.f1802i = true;
        }
        return 0;
    }

    /* renamed from: a */
    public int mo4716a(String str, String str2, byte[] bArr) {
        AbstractC0642e a = m2553a(bArr);
        C0662b bVar = this.f1800g.get(str);
        if (bVar == null || !C0618g.f1641l) {
            return -1;
        }
        this.f1801h.put(str2, bVar);
        return C0617f.m2395a().mo4628g().mo4736a(str2, a);
    }

    /* renamed from: a */
    public void mo4717a(Context context) {
        this.f1794a = context;
        this.f1795b = EnumC0613d.init;
        this.f1799f = new ArrayList();
        this.f1800g = new HashMap();
        this.f1801h = new HashMap();
    }

    /* renamed from: a */
    public void mo4718a(Intent intent) {
        if (intent.getAction().equals("com.igexin.sdk.action.snlrefresh") && C0514k.f1321m) {
            String stringExtra = intent.getStringExtra("groupid");
            String stringExtra2 = intent.getStringExtra("responseSNLAction");
            boolean z = C0618g.f1638i;
            boolean z2 = C0618g.f1639j;
            String stringExtra3 = intent.getStringExtra("branch");
            boolean a = C1151a.m4739a(System.currentTimeMillis());
            long a2 = C0628q.m2446a() + C0628q.m2447b();
            if (C0618g.f1633d.equals(stringExtra) && "open".equals(stringExtra3) && z && z2 && !a) {
                Intent intent2 = new Intent();
                intent2.setAction(stringExtra2);
                intent2.putExtra("groupid", C0618g.f1633d);
                intent2.putExtra("branch", "open");
                intent2.putExtra("pkgname", C0618g.f1635f.getPackageName());
                intent2.putExtra("classname", C0535e.m2034a().mo4360a(C0618g.f1635f));
                intent2.putExtra("startup_time", C0618g.f1595T);
                intent2.putExtra("network_traffic", a2);
                C0618g.f1635f.sendBroadcast(intent2);
            }
        } else if (intent.getAction().equals(C0618g.f1596U) && C0514k.f1321m) {
            String stringExtra4 = intent.getStringExtra("groupid");
            String stringExtra5 = intent.getStringExtra("branch");
            if (C0618g.f1633d.equals(stringExtra4) && "open".equals(stringExtra5)) {
                C0669i iVar = new C0669i();
                iVar.mo4730a(intent.getStringExtra("groupid"));
                iVar.mo4733b(intent.getStringExtra("pkgname"));
                iVar.mo4735c(intent.getStringExtra("classname"));
                iVar.mo4729a(intent.getLongExtra("startup_time", 0));
                iVar.mo4732b(intent.getLongExtra("network_traffic", 0));
                this.f1799f.add(iVar);
            }
        } else if (intent.getAction().equals("com.igexin.sdk.action.snlretire") && C0514k.f1321m) {
            String stringExtra6 = intent.getStringExtra("groupid");
            String stringExtra7 = intent.getStringExtra("branch");
            if (C0618g.f1633d.equals(stringExtra6) && "open".equals(stringExtra7)) {
                C0661a aVar = new C0661a();
                aVar.mo4702a(EnumC0602c.retire);
                C0617f.m2395a().mo4629h().mo4719a(aVar);
            }
        }
    }

    /* renamed from: a */
    public void mo4719a(C0661a aVar) {
        ActivityC0460a.m1698b("SNLCoordinator|state = " + this.f1795b + ", doEvent = " + aVar.f1788a);
        switch (C0668h.f1809a[this.f1795b.ordinal()]) {
            case 1:
                m2558b(aVar);
                return;
            case 2:
                m2563c(aVar);
                return;
            case 3:
                m2565d(aVar);
                return;
            case 4:
                m2568e(aVar);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public boolean mo4720a() {
        if (this.f1795b != EnumC0613d.active) {
            return false;
        }
        for (Map.Entry<String, C0662b> entry : this.f1800g.entrySet()) {
            try {
                entry.getValue().mo4709c().onASNLNetworkConnected();
            } catch (Exception e) {
            }
        }
        return true;
    }

    /* renamed from: b */
    public int mo4721b(String str, AbstractC0642e eVar) {
        C0639b bVar = new C0639b();
        bVar.f1705e = eVar.mo4685d();
        bVar.f1701a = bVar.f1705e.length;
        bVar.f1702b = (byte) eVar.f1723i;
        byte[] a = bVar.mo4687a();
        C0662b bVar2 = this.f1801h.get(str);
        if (bVar2 != null) {
            try {
                if (str.startsWith("S-")) {
                    this.f1801h.put("C-" + C0476a.m1773a(str.substring(2, str.length())), bVar2);
                }
                return bVar2.mo4709c().receiveToPSNL(bVar2.mo4712e(), str, a);
            } catch (RemoteException e) {
                this.f1800g.remove(bVar2.mo4712e());
                this.f1801h.remove(str);
            }
        }
        return -1;
    }

    /* renamed from: b */
    public int mo4722b(String str, String str2, byte[] bArr) {
        C0617f.m2395a().mo4628g().mo4739a(m2553a(bArr));
        return 0;
    }

    /* renamed from: b */
    public boolean mo4723b() {
        if (this.f1795b != EnumC0613d.active) {
            return false;
        }
        for (Map.Entry<String, C0662b> entry : this.f1800g.entrySet()) {
            try {
                entry.getValue().mo4709c().onASNLNetworkDisconnected();
            } catch (Exception e) {
            }
        }
        return true;
    }
}
