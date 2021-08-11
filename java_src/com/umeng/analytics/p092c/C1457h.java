package com.umeng.analytics.p092c;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.C1370a;
import com.umeng.analytics.p091b.C1447g;
import com.umeng.analytics.p093d.AbstractC1487l;
import com.umeng.analytics.p094e.C1496a;
import com.umeng.analytics.p095f.C1521e;
import com.umeng.analytics.p095f.C1528f;
import com.umeng.p085a.C1341c;
import com.umeng.p085a.C1344f;
import com.umeng.p085a.C1348j;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import p000a.p001a.p002a.C0049m;

/* renamed from: com.umeng.analytics.c.h */
/* compiled from: ImprintHandler */
public class C1457h {

    /* renamed from: a */
    private static final String f3570a = ".imprint";

    /* renamed from: b */
    private static final byte[] f3571b = "pbl0".getBytes();

    /* renamed from: f */
    private static C1457h f3572f;

    /* renamed from: c */
    private AbstractC1487l f3573c;

    /* renamed from: d */
    private C1458a f3574d = new C1458a();

    /* renamed from: e */
    private C1521e f3575e = null;

    /* renamed from: g */
    private Context f3576g;

    C1457h(Context context) {
        this.f3576g = context;
    }

    /* renamed from: a */
    public static synchronized C1457h m5380a(Context context) {
        C1457h hVar;
        synchronized (C1457h.class) {
            if (f3572f == null) {
                f3572f = new C1457h(context);
                f3572f.mo8582c();
            }
            hVar = f3572f;
        }
        return hVar;
    }

    /* renamed from: a */
    public void mo8578a(AbstractC1487l lVar) {
        this.f3573c = lVar;
    }

    /* renamed from: a */
    public String mo8577a(C1521e eVar) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : new TreeMap(eVar.mo8782d()).entrySet()) {
            sb.append((String) entry.getKey());
            if (((C1528f) entry.getValue()).mo8809e()) {
                sb.append(((C1528f) entry.getValue()).mo8806c());
            }
            sb.append(((C1528f) entry.getValue()).mo8810f());
            sb.append(((C1528f) entry.getValue()).mo8813i());
        }
        sb.append(eVar.f3821b);
        return C1344f.m4973a(sb.toString()).toLowerCase(Locale.US);
    }

    /* renamed from: c */
    private boolean m5383c(C1521e eVar) {
        if (!eVar.mo8788j().equals(mo8577a(eVar))) {
            return false;
        }
        for (C1528f fVar : eVar.mo8782d().values()) {
            byte[] a = C1341c.m4915a(fVar.mo8813i());
            byte[] a2 = mo8579a(fVar);
            int i = 0;
            while (true) {
                if (i < 4) {
                    if (a[i] != a2[i]) {
                        return false;
                    }
                    i++;
                }
            }
        }
        return true;
    }

    /* renamed from: a */
    public byte[] mo8579a(C1528f fVar) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(null);
        allocate.putLong(fVar.mo8810f());
        byte[] array = allocate.array();
        byte[] bArr = f3571b;
        byte[] bArr2 = new byte[4];
        for (int i = 0; i < 4; i++) {
            bArr2[i] = (byte) (array[i] ^ bArr[i]);
        }
        return bArr2;
    }

    /* renamed from: b */
    public void mo8581b(C1521e eVar) {
        C1521e a;
        String str = null;
        if (eVar != null && m5383c(eVar)) {
            boolean z = false;
            synchronized (this) {
                C1521e eVar2 = this.f3575e;
                String j = eVar2 == null ? null : eVar2.mo8788j();
                if (eVar2 == null) {
                    a = m5384d(eVar);
                } else {
                    a = m5381a(eVar2, eVar);
                }
                this.f3575e = a;
                if (a != null) {
                    str = a.mo8788j();
                }
                if (!m5382a(j, str)) {
                    z = true;
                }
            }
            if (this.f3575e != null && z) {
                this.f3574d.mo8588a(this.f3575e);
                if (this.f3573c != null) {
                    this.f3573c.mo8620a(this.f3574d);
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m5382a(String str, String str2) {
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 != null) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private C1521e m5381a(C1521e eVar, C1521e eVar2) {
        if (eVar2 != null) {
            Map<String, C1528f> d = eVar.mo8782d();
            for (Map.Entry<String, C1528f> entry : eVar2.mo8782d().entrySet()) {
                if (entry.getValue().mo8809e()) {
                    d.put(entry.getKey(), entry.getValue());
                } else {
                    d.remove(entry.getKey());
                }
            }
            eVar.mo8773a(eVar2.mo8785g());
            eVar.mo8774a(mo8577a(eVar));
        }
        return eVar;
    }

    /* renamed from: d */
    private C1521e m5384d(C1521e eVar) {
        Map<String, C1528f> d = eVar.mo8782d();
        ArrayList<String> arrayList = new ArrayList(d.size() / 2);
        for (Map.Entry<String, C1528f> entry : d.entrySet()) {
            if (!entry.getValue().mo8809e()) {
                arrayList.add(entry.getKey());
            }
        }
        for (String str : arrayList) {
            d.remove(str);
        }
        return eVar;
    }

    /* renamed from: a */
    public synchronized C1521e mo8576a() {
        return this.f3575e;
    }

    /* renamed from: b */
    public C1458a mo8580b() {
        return this.f3574d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026 A[SYNTHETIC, Splitter:B:8:0x0026] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8582c() {
        /*
            r4 = this;
            r2 = 0
            java.io.File r0 = new java.io.File
            android.content.Context r1 = r4.f3576g
            java.io.File r1 = r1.getFilesDir()
            java.lang.String r3 = ".imprint"
            r0.<init>(r1, r3)
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x0015
        L_0x0014:
            return
        L_0x0015:
            android.content.Context r0 = r4.f3576g     // Catch:{ Exception -> 0x0040, all -> 0x0049 }
            java.lang.String r1 = ".imprint"
            java.io.FileInputStream r1 = r0.openFileInput(r1)     // Catch:{ Exception -> 0x0040, all -> 0x0049 }
            byte[] r2 = com.umeng.p085a.C1344f.m4980b(r1)     // Catch:{ Exception -> 0x0051 }
            com.umeng.p085a.C1344f.m4981c(r1)
        L_0x0024:
            if (r2 == 0) goto L_0x0014
            com.umeng.analytics.f.e r0 = new com.umeng.analytics.f.e     // Catch:{ Exception -> 0x003b }
            r0.<init>()     // Catch:{ Exception -> 0x003b }
            a.a.a.g r1 = new a.a.a.g     // Catch:{ Exception -> 0x003b }
            r1.<init>()     // Catch:{ Exception -> 0x003b }
            r1.mo102a(r0, r2)     // Catch:{ Exception -> 0x003b }
            r4.f3575e = r0     // Catch:{ Exception -> 0x003b }
            com.umeng.analytics.c.h$a r1 = r4.f3574d     // Catch:{ Exception -> 0x003b }
            r1.mo8588a(r0)     // Catch:{ Exception -> 0x003b }
            goto L_0x0014
        L_0x003b:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0014
        L_0x0040:
            r0 = move-exception
            r1 = r2
        L_0x0042:
            r0.printStackTrace()     // Catch:{ all -> 0x004e }
            com.umeng.p085a.C1344f.m4981c(r1)
            goto L_0x0024
        L_0x0049:
            r0 = move-exception
        L_0x004a:
            com.umeng.p085a.C1344f.m4981c(r2)
            throw r0
        L_0x004e:
            r0 = move-exception
            r2 = r1
            goto L_0x004a
        L_0x0051:
            r0 = move-exception
            goto L_0x0042
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.p092c.C1457h.mo8582c():void");
    }

    /* renamed from: d */
    public void mo8583d() {
        if (this.f3575e != null) {
            try {
                C1344f.m4976a(new File(this.f3576g.getFilesDir(), f3570a), new C0049m().mo116a(this.f3575e));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: e */
    public boolean mo8584e() {
        return new File(this.f3576g.getFilesDir(), f3570a).delete();
    }

    /* renamed from: com.umeng.analytics.c.h$a */
    /* compiled from: ImprintHandler */
    public static class C1458a {

        /* renamed from: a */
        private int f3577a = -1;

        /* renamed from: b */
        private int f3578b = -1;

        /* renamed from: c */
        private int f3579c = -1;

        /* renamed from: d */
        private int f3580d = -1;

        /* renamed from: e */
        private int f3581e = -1;

        /* renamed from: f */
        private String f3582f = null;

        /* renamed from: g */
        private int f3583g = -1;

        /* renamed from: h */
        private String f3584h = null;

        /* renamed from: i */
        private int f3585i = -1;

        /* renamed from: j */
        private int f3586j = -1;

        /* renamed from: k */
        private String f3587k = null;

        /* renamed from: l */
        private String f3588l = null;

        /* renamed from: m */
        private String f3589m = null;

        /* renamed from: n */
        private String f3590n = null;

        /* renamed from: o */
        private String f3591o = null;

        C1458a() {
        }

        C1458a(C1521e eVar) {
            mo8588a(eVar);
        }

        /* renamed from: a */
        public void mo8588a(C1521e eVar) {
            if (eVar != null) {
                this.f3577a = m5394a(eVar, "defcon");
                this.f3578b = m5394a(eVar, C1447g.f3494an);
                this.f3579c = m5394a(eVar, "codex");
                this.f3580d = m5394a(eVar, "report_policy");
                this.f3581e = m5394a(eVar, "report_interval");
                this.f3582f = m5395b(eVar, "client_test");
                this.f3583g = m5394a(eVar, "test_report_interval");
                this.f3584h = m5395b(eVar, "umid");
                this.f3585i = m5394a(eVar, "integrated_test");
                this.f3586j = m5394a(eVar, "latent_hours");
                this.f3587k = m5395b(eVar, C1447g.f3443G);
                this.f3588l = m5395b(eVar, "domain_p");
                this.f3589m = m5395b(eVar, "domain_s");
                this.f3590n = m5395b(eVar, C1447g.f3453Q);
                this.f3591o = m5395b(eVar, "track_list");
            }
        }

        /* renamed from: a */
        public String mo8587a(String str) {
            if (this.f3590n != null) {
                return this.f3590n;
            }
            return str;
        }

        /* renamed from: b */
        public String mo8592b(String str) {
            if (this.f3591o != null) {
                return this.f3591o;
            }
            return str;
        }

        /* renamed from: c */
        public String mo8595c(String str) {
            if (this.f3589m != null) {
                return this.f3589m;
            }
            return str;
        }

        /* renamed from: d */
        public String mo8597d(String str) {
            if (this.f3588l != null) {
                return this.f3588l;
            }
            return str;
        }

        /* renamed from: e */
        public String mo8598e(String str) {
            if (this.f3587k != null) {
                return this.f3587k;
            }
            return str;
        }

        /* renamed from: a */
        public int mo8585a(int i) {
            return (this.f3577a != -1 && this.f3577a <= 3 && this.f3577a >= 0) ? this.f3577a : i;
        }

        /* renamed from: b */
        public int mo8591b(int i) {
            return (this.f3578b != -1 && this.f3578b >= 0 && this.f3578b <= 1800) ? this.f3578b * 1000 : i;
        }

        /* renamed from: c */
        public int mo8594c(int i) {
            if (this.f3579c == 0 || this.f3579c == 1 || this.f3579c == -1) {
                return this.f3579c;
            }
            return i;
        }

        /* renamed from: a */
        public int[] mo8590a(int i, int i2) {
            if (this.f3580d == -1 || !C1348j.m5020a(this.f3580d)) {
                return new int[]{i, i2};
            }
            if (this.f3581e == -1 || this.f3581e < 90 || this.f3581e > 86400) {
                this.f3581e = 90;
            }
            return new int[]{this.f3580d, this.f3581e * 1000};
        }

        /* renamed from: f */
        public String mo8599f(String str) {
            return (this.f3582f == null || !C1496a.m5569a(this.f3582f)) ? str : this.f3582f;
        }

        /* renamed from: d */
        public int mo8596d(int i) {
            return (this.f3583g == -1 || this.f3583g < 90 || this.f3583g > 86400) ? i : this.f3583g * 1000;
        }

        /* renamed from: a */
        public boolean mo8589a() {
            return this.f3583g != -1;
        }

        /* renamed from: g */
        public String mo8600g(String str) {
            return this.f3584h;
        }

        /* renamed from: b */
        public boolean mo8593b() {
            return this.f3585i == 1;
        }

        /* renamed from: a */
        public long mo8586a(long j) {
            return (this.f3586j != -1 && this.f3586j >= 48) ? C1370a.f3218j * ((long) this.f3586j) : j;
        }

        /* renamed from: a */
        private int m5394a(C1521e eVar, String str) {
            if (eVar != null) {
                try {
                    if (eVar.mo8784f()) {
                        C1528f fVar = eVar.mo8782d().get(str);
                        if (fVar == null || TextUtils.isEmpty(fVar.mo8806c())) {
                            return -1;
                        }
                        try {
                            return Integer.parseInt(fVar.mo8806c().trim());
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return -1;
                }
            }
            return -1;
        }

        /* renamed from: b */
        private String m5395b(C1521e eVar, String str) {
            String str2;
            C1528f fVar;
            if (eVar == null) {
                return null;
            }
            try {
                if (!eVar.mo8784f() || (fVar = eVar.mo8782d().get(str)) == null || TextUtils.isEmpty(fVar.mo8806c())) {
                    return null;
                }
                str2 = fVar.mo8806c();
                return str2;
            } catch (Exception e) {
                e.printStackTrace();
                str2 = null;
            }
        }
    }
}
