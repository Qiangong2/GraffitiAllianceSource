package com.umeng.analytics.p093d;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.C1370a;
import com.umeng.analytics.p086a.p090d.C1419e;
import com.umeng.analytics.p091b.C1447g;
import com.umeng.analytics.p092c.C1451c;
import com.umeng.analytics.p092c.C1454f;
import com.umeng.analytics.p092c.C1457h;
import com.umeng.analytics.p095f.C1535g;
import com.umeng.p085a.C1341c;
import com.umeng.p085a.C1343e;
import com.umeng.p085a.C1344f;
import com.umeng.p085a.C1346h;
import com.umeng.p085a.C1360l;
import java.io.File;
import java.io.FileInputStream;
import org.json.JSONObject;
import p000a.p001a.p002a.C0043g;
import p000a.p001a.p002a.C0049m;
import p000a.p001a.p002a.p004b.C0009a;

/* renamed from: com.umeng.analytics.d.o */
/* compiled from: Sender */
public class C1491o {

    /* renamed from: a */
    private static final int f3679a = 1;

    /* renamed from: b */
    private static final int f3680b = 2;

    /* renamed from: c */
    private static final int f3681c = 3;

    /* renamed from: g */
    private static Context f3682g;

    /* renamed from: d */
    private C1454f f3683d;

    /* renamed from: e */
    private C1457h f3684e;

    /* renamed from: f */
    private final int f3685f = 1;

    /* renamed from: h */
    private C1494q f3686h;

    /* renamed from: i */
    private C1484i f3687i;

    /* renamed from: j */
    private JSONObject f3688j;

    /* renamed from: k */
    private boolean f3689k = false;

    /* renamed from: l */
    private boolean f3690l;

    public C1491o(Context context, C1494q qVar) {
        this.f3683d = C1454f.m5362a(context);
        this.f3684e = C1457h.m5380a(context);
        f3682g = context;
        this.f3686h = qVar;
        this.f3687i = new C1484i(context);
        this.f3687i.mo8643a(this.f3686h);
    }

    /* renamed from: a */
    public void mo8649a(JSONObject jSONObject) {
        this.f3688j = jSONObject;
    }

    /* renamed from: a */
    public void mo8650a(boolean z) {
        this.f3689k = z;
    }

    /* renamed from: b */
    public void mo8651b(boolean z) {
        this.f3690l = z;
    }

    /* renamed from: a */
    public void mo8648a(AbstractC1487l lVar) {
        this.f3684e.mo8578a(lVar);
    }

    /* renamed from: a */
    public void mo8647a() {
        try {
            if (this.f3688j != null) {
                m5530c();
            } else {
                m5527b();
            }
        } catch (Throwable th) {
        }
        try {
            if (C1343e.m4955k(f3682g)) {
                SharedPreferences a = C1488m.m5522a(f3682g);
                if (a != null) {
                    String string = a.getString(C1370a.f3226r, "");
                    long b = C1419e.m5245b(System.currentTimeMillis());
                    if (TextUtils.isEmpty(string)) {
                        long j = a.getLong(C1370a.f3227s, -1);
                        int i = a.getInt(C1370a.f3228t, 0);
                        if (j == -1) {
                            a.edit().putInt(C1370a.f3228t, i + 1).commit();
                            this.f3687i.mo8642a();
                        } else if (b != j) {
                            a.edit().putInt(C1370a.f3228t, 1).commit();
                            this.f3687i.mo8642a();
                        } else if (i < 2) {
                            a.edit().putInt(C1370a.f3228t, i + 1).commit();
                            this.f3687i.mo8642a();
                        }
                        a.edit().putLong(C1370a.f3227s, b).commit();
                        return;
                    }
                    return;
                }
                this.f3687i.mo8642a();
            }
        } catch (Throwable th2) {
        }
    }

    /* renamed from: b */
    private void m5527b() {
        C1360l.m5038a(f3682g).mo8390i().mo8392a(new C1360l.AbstractC1365b() {
            /* class com.umeng.analytics.p093d.C1491o.C14921 */

            @Override // com.umeng.p085a.C1360l.AbstractC1365b
            /* renamed from: a */
            public void mo8399a(File file) {
            }

            @Override // com.umeng.p085a.C1360l.AbstractC1365b
            /* renamed from: b */
            public boolean mo8400b(File file) {
                FileInputStream fileInputStream;
                Throwable th;
                byte[] b;
                int a;
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        b = C1344f.m4980b(fileInputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        C1344f.m4981c(fileInputStream);
                        throw th;
                    }
                    try {
                        C1344f.m4981c(fileInputStream);
                        byte[] a2 = C1491o.this.f3687i.mo8644a(b);
                        if (a2 == null) {
                            a = 1;
                        } else {
                            a = C1491o.this.m5525a((C1491o) a2);
                        }
                        return C1491o.this.f3690l || a != 1;
                    } catch (Exception e) {
                        return false;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileInputStream = null;
                    C1344f.m4981c(fileInputStream);
                    throw th;
                }
            }

            @Override // com.umeng.p085a.C1360l.AbstractC1365b
            /* renamed from: c */
            public void mo8401c(File file) {
                C1491o.this.f3686h.mo8664k();
            }
        });
    }

    /* renamed from: c */
    private void m5530c() {
        C1451c b;
        int a;
        try {
            this.f3683d.mo8563a();
            try {
                String encodeToString = Base64.encodeToString(new C0049m().mo116a(this.f3683d.mo8566b()), 0);
                if (!TextUtils.isEmpty(encodeToString)) {
                    JSONObject jSONObject = this.f3688j.getJSONObject(C1370a.f3205A);
                    jSONObject.put(C1447g.f3451O, encodeToString);
                    this.f3688j.put(C1370a.f3205A, jSONObject);
                }
            } catch (Exception e) {
            }
            byte[] bytes = String.valueOf(this.f3688j).getBytes();
            if (bytes != null && !C1341c.m4914a(f3682g, bytes)) {
                if (!this.f3689k) {
                    b = C1451c.m5347a(f3682g, AnalyticsConfig.getAppkey(f3682g), bytes);
                } else {
                    b = C1451c.m5350b(f3682g, AnalyticsConfig.getAppkey(f3682g), bytes);
                }
                byte[] c = b.mo8561c();
                C1360l.m5038a(f3682g).mo8388g();
                byte[] a2 = this.f3687i.mo8644a(c);
                if (a2 == null) {
                    a = 1;
                } else {
                    a = m5525a(a2);
                }
                switch (a) {
                    case 1:
                        if (!this.f3690l) {
                            C1360l.m5038a(f3682g).mo8379a(c);
                            return;
                        }
                        return;
                    case 2:
                        this.f3683d.mo8568d();
                        this.f3686h.mo8664k();
                        return;
                    case 3:
                        this.f3686h.mo8664k();
                        return;
                    default:
                        return;
                }
            }
        } catch (Throwable th) {
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private int m5525a(byte[] bArr) {
        C1535g gVar = new C1535g();
        try {
            new C0043g(new C0009a.C0010a()).mo102a(gVar, bArr);
            if (gVar.f3859a == 1) {
                this.f3684e.mo8581b(gVar.mo8838i());
                this.f3684e.mo8583d();
            }
            C1346h.m4997c("send log:" + gVar.mo8835f());
        } catch (Throwable th) {
        }
        if (gVar.f3859a == 1) {
            return 2;
        }
        return 3;
    }
}
