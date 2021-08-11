package com.umeng.analytics.p086a.p090d;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.umeng.analytics.C1370a;
import com.umeng.analytics.p086a.p087a.C1376d;
import com.umeng.analytics.p086a.p088b.C1387a;
import com.umeng.analytics.p086a.p089c.C1389a;
import com.umeng.analytics.p086a.p089c.C1391b;
import com.umeng.analytics.p086a.p089c.C1394e;
import com.umeng.analytics.p093d.C1488m;
import com.umeng.p085a.AbstractRunnableC1359k;
import com.umeng.p085a.C1346h;
import com.umeng.p085a.C1347i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.a.d.a */
/* compiled from: UMCCAggregatedManager */
public class C1395a {

    /* renamed from: i */
    private static final int f3309i = 48;

    /* renamed from: j */
    private static final int f3310j = 49;

    /* renamed from: k */
    private static Context f3311k;

    /* renamed from: a */
    private C1389a f3312a;

    /* renamed from: b */
    private C1415c f3313b;

    /* renamed from: c */
    private C1418d f3314c;

    /* renamed from: d */
    private boolean f3315d;

    /* renamed from: e */
    private boolean f3316e;

    /* renamed from: f */
    private long f3317f;

    /* renamed from: g */
    private final String f3318g;

    /* renamed from: h */
    private final String f3319h;

    /* renamed from: l */
    private List<String> f3320l;

    /* renamed from: m */
    private HandlerC1410a f3321m;

    /* renamed from: n */
    private final Thread f3322n;

    /* access modifiers changed from: private */
    /* renamed from: com.umeng.analytics.a.d.a$b */
    /* compiled from: UMCCAggregatedManager */
    public static class C1411b {

        /* renamed from: a */
        private static final C1395a f3340a = new C1395a();

        private C1411b() {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.umeng.analytics.a.d.a$a */
    /* compiled from: UMCCAggregatedManager */
    public static class HandlerC1410a extends Handler {

        /* renamed from: a */
        private final WeakReference<C1395a> f3339a;

        public HandlerC1410a(C1395a aVar) {
            this.f3339a = new WeakReference<>(aVar);
        }

        public void handleMessage(Message message) {
            if (this.f3339a != null) {
                switch (message.what) {
                    case 48:
                        sendEmptyMessageDelayed(48, C1419e.m5246c(System.currentTimeMillis()));
                        C1395a.m5162a(C1395a.f3311k).m5185p();
                        return;
                    case C1395a.f3310j /*{ENCODED_INT: 49}*/:
                        sendEmptyMessageDelayed(C1395a.f3310j, C1419e.m5247d(System.currentTimeMillis()));
                        C1395a.m5162a(C1395a.f3311k).m5184o();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo8463a() {
        return this.f3315d;
    }

    private C1395a() {
        this.f3312a = null;
        this.f3313b = null;
        this.f3314c = null;
        this.f3315d = false;
        this.f3316e = false;
        this.f3317f = 0;
        this.f3318g = "main_fest_mode";
        this.f3319h = "main_fest_timestamp";
        this.f3320l = new ArrayList();
        this.f3321m = null;
        this.f3322n = new Thread(new Runnable() {
            /* class com.umeng.analytics.p086a.p090d.C1395a.RunnableC13961 */

            public void run() {
                Looper.prepare();
                if (C1395a.this.f3321m == null) {
                    C1395a.this.f3321m = new HandlerC1410a(C1395a.this);
                }
                C1395a.this.m5173h();
            }
        });
        if (f3311k != null) {
            if (this.f3312a == null) {
                this.f3312a = new C1389a();
            }
            if (this.f3313b == null) {
                this.f3313b = C1415c.m5221a(f3311k);
            }
            if (this.f3314c == null) {
                this.f3314c = new C1418d();
            }
        }
        this.f3322n.start();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: h */
    private void m5173h() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f3321m.sendEmptyMessageDelayed(48, C1419e.m5246c(currentTimeMillis));
        this.f3321m.sendEmptyMessageDelayed(f3310j, C1419e.m5247d(currentTimeMillis));
    }

    /* renamed from: a */
    public static final C1395a m5162a(Context context) {
        f3311k = context;
        return C1411b.f3340a;
    }

    /* renamed from: a */
    public void mo8461a(final C1387a aVar) {
        if (!this.f3315d) {
            C1347i.m5018b(new AbstractRunnableC1359k() {
                /* class com.umeng.analytics.p086a.p090d.C1395a.C14056 */

                @Override // com.umeng.p085a.AbstractRunnableC1359k
                /* renamed from: a */
                public void mo8374a() {
                    try {
                        C1395a.this.f3313b.mo8480a(new C1387a() {
                            /* class com.umeng.analytics.p086a.p090d.C1395a.C14056.C14061 */

                            @Override // com.umeng.analytics.p086a.p088b.AbstractC1388b, com.umeng.analytics.p086a.p088b.C1387a
                            /* renamed from: a */
                            public void mo8391a(Object obj, boolean z) {
                                if (obj instanceof Map) {
                                    C1395a.this.f3312a.mo8423a((Map) obj);
                                } else if ((obj instanceof String) || (obj instanceof Boolean)) {
                                }
                                C1395a.this.f3315d = true;
                            }
                        });
                        C1395a.this.m5181l();
                        C1395a.this.m5186q();
                        aVar.mo8391a("success", false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void mo8462a(final C1387a aVar, Map<List<String>, C1394e> map) {
        C1394e eVar = (C1394e) map.values().toArray()[0];
        List<String> a = eVar.mo8455a();
        if (this.f3320l.size() > 0 && this.f3320l.contains(C1376d.m5103a(a))) {
            this.f3312a.mo8420a(new C1387a() {
                /* class com.umeng.analytics.p086a.p090d.C1395a.C14077 */

                @Override // com.umeng.analytics.p086a.p088b.AbstractC1388b, com.umeng.analytics.p086a.p088b.C1387a
                /* renamed from: a */
                public void mo8391a(Object obj, boolean z) {
                    if (obj instanceof C1389a) {
                        C1395a.this.f3312a = (C1389a) obj;
                    }
                    aVar.mo8391a("success", false);
                }
            }, eVar);
        } else if (this.f3316e) {
            m5164a(eVar, a);
        } else if (m5176i()) {
            String a2 = C1376d.m5103a(a);
            if (!this.f3320l.contains(a2)) {
                this.f3320l.add(a2);
            }
            this.f3312a.mo8422a(new C1387a() {
                /* class com.umeng.analytics.p086a.p090d.C1395a.C14088 */

                @Override // com.umeng.analytics.p086a.p088b.AbstractC1388b, com.umeng.analytics.p086a.p088b.C1387a
                /* renamed from: a */
                public void mo8391a(Object obj, boolean z) {
                    C1395a.this.f3312a = (C1389a) obj;
                }
            }, a, eVar);
        } else {
            m5164a(eVar, a);
            m5178j();
        }
    }

    /* renamed from: a */
    private void m5164a(C1394e eVar, List<String> list) {
        this.f3312a.mo8421a(new C1387a() {
            /* class com.umeng.analytics.p086a.p090d.C1395a.C14099 */

            @Override // com.umeng.analytics.p086a.p088b.AbstractC1388b, com.umeng.analytics.p086a.p088b.C1387a
            /* renamed from: a */
            public void mo8391a(Object obj, boolean z) {
                if (obj instanceof C1389a) {
                    C1395a.this.f3312a = (C1389a) obj;
                } else if (obj instanceof Boolean) {
                    C1395a.this.m5183n();
                }
            }
        }, eVar, list, this.f3320l);
    }

    /* renamed from: i */
    private boolean m5176i() {
        if (this.f3320l.size() < C1412b.m5211a().mo8478d()) {
            return true;
        }
        return false;
    }

    /* renamed from: j */
    private void m5178j() {
        SharedPreferences a = C1488m.m5522a(f3311k);
        if (!a.getBoolean("main_fest_mode", false)) {
            this.f3316e = true;
            SharedPreferences.Editor edit = a.edit();
            edit.putBoolean("main_fest_mode", true);
            edit.putLong("main_fest_timestamp", System.currentTimeMillis());
            edit.commit();
        }
    }

    /* renamed from: k */
    private void m5179k() {
        SharedPreferences.Editor edit = C1488m.m5522a(f3311k).edit();
        edit.putBoolean("main_fest_mode", false);
        edit.putLong("main_fest_timestamp", 0);
        edit.commit();
        this.f3316e = false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: l */
    private void m5181l() {
        SharedPreferences a = C1488m.m5522a(f3311k);
        this.f3316e = a.getBoolean("main_fest_mode", false);
        this.f3317f = a.getLong("main_fest_timestamp", 0);
    }

    /* renamed from: b */
    public JSONObject mo8464b() {
        JSONObject a = this.f3313b.mo8479a();
        JSONObject jSONObject = new JSONObject();
        if (a == null || a.length() <= 0) {
            return null;
        }
        for (String str : this.f3320l) {
            if (a.has(str)) {
                try {
                    jSONObject.put(str, a.opt(str));
                } catch (Exception e) {
                }
            }
        }
        return jSONObject;
    }

    /* renamed from: c */
    public JSONObject mo8466c() {
        if (this.f3314c.mo8489a().size() > 0) {
            this.f3313b.mo8487b(new C1387a() {
                /* class com.umeng.analytics.p086a.p090d.C1395a.C139710 */

                @Override // com.umeng.analytics.p086a.p088b.AbstractC1388b, com.umeng.analytics.p086a.p088b.C1387a
                /* renamed from: a */
                public void mo8391a(Object obj, boolean z) {
                    if (obj instanceof String) {
                        C1395a.this.f3314c.mo8494b();
                    }
                }
            }, this.f3314c.mo8489a());
        }
        return this.f3313b.mo8486b(new C1387a());
    }

    /* renamed from: b */
    public void mo8465b(C1387a aVar) {
        boolean z = false;
        if (this.f3316e) {
            if (this.f3317f == 0) {
                m5181l();
            }
            z = C1419e.m5244a(System.currentTimeMillis(), this.f3317f);
        }
        if (!z) {
            m5179k();
            this.f3320l.clear();
        }
        this.f3314c.mo8494b();
        this.f3313b.mo8484a(new C1387a() {
            /* class com.umeng.analytics.p086a.p090d.C1395a.C139811 */

            @Override // com.umeng.analytics.p086a.p088b.AbstractC1388b, com.umeng.analytics.p086a.p088b.C1387a
            /* renamed from: a */
            public void mo8391a(Object obj, boolean z) {
                if (obj.equals("success")) {
                    C1395a.this.m5182m();
                }
            }
        }, z);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: m */
    private void m5182m() {
        for (Map.Entry<List<String>, C1391b> entry : this.f3312a.mo8417a().entrySet()) {
            List<String> key = entry.getKey();
            if (!this.f3320l.contains(key)) {
                this.f3320l.add(C1376d.m5103a(key));
            }
        }
        if (this.f3320l.size() > 0) {
            this.f3313b.mo8482a(new C1387a(), this.f3320l);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: n */
    private void m5183n() {
        this.f3314c.mo8490a(new C1387a() {
            /* class com.umeng.analytics.p086a.p090d.C1395a.C139912 */

            @Override // com.umeng.analytics.p086a.p088b.AbstractC1388b, com.umeng.analytics.p086a.p088b.C1387a
            /* renamed from: a */
            public void mo8391a(Object obj, boolean z) {
                C1395a.this.f3314c = (C1418d) obj;
            }
        }, C1370a.f3229u);
    }

    /* renamed from: a */
    public void mo8460a(long j, long j2, String str) {
        this.f3313b.mo8481a(new C1387a() {
            /* class com.umeng.analytics.p086a.p090d.C1395a.C140013 */

            @Override // com.umeng.analytics.p086a.p088b.AbstractC1388b, com.umeng.analytics.p086a.p088b.C1387a
            /* renamed from: a */
            public void mo8391a(Object obj, boolean z) {
                if (obj.equals("success")) {
                }
            }
        }, str, j, j2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: o */
    private void m5184o() {
        try {
            if (this.f3312a.mo8417a().size() > 0) {
                this.f3313b.mo8488c(new C1387a() {
                    /* class com.umeng.analytics.p086a.p090d.C1395a.C14012 */

                    @Override // com.umeng.analytics.p086a.p088b.AbstractC1388b, com.umeng.analytics.p086a.p088b.C1387a
                    /* renamed from: a */
                    public void mo8391a(Object obj, boolean z) {
                        if (obj instanceof String) {
                            C1395a.this.f3312a.mo8428d();
                        }
                    }
                }, this.f3312a.mo8417a());
            }
            if (this.f3314c.mo8489a().size() > 0) {
                this.f3313b.mo8487b(new C1387a() {
                    /* class com.umeng.analytics.p086a.p090d.C1395a.C14023 */

                    @Override // com.umeng.analytics.p086a.p088b.AbstractC1388b, com.umeng.analytics.p086a.p088b.C1387a
                    /* renamed from: a */
                    public void mo8391a(Object obj, boolean z) {
                        if (obj instanceof String) {
                            C1395a.this.f3314c.mo8494b();
                        }
                    }
                }, this.f3314c.mo8489a());
            }
            if (this.f3320l.size() > 0) {
                this.f3313b.mo8482a(new C1387a(), this.f3320l);
            }
        } catch (Throwable th) {
            C1346h.m4991b("converyMemoryToDataTable happen error: " + th.toString());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: p */
    private void m5185p() {
        try {
            if (this.f3312a.mo8417a().size() > 0) {
                this.f3313b.mo8483a(new C1387a() {
                    /* class com.umeng.analytics.p086a.p090d.C1395a.C14034 */

                    @Override // com.umeng.analytics.p086a.p088b.AbstractC1388b, com.umeng.analytics.p086a.p088b.C1387a
                    /* renamed from: a */
                    public void mo8391a(Object obj, boolean z) {
                    }
                }, this.f3312a.mo8417a());
            }
            if (this.f3314c.mo8489a().size() > 0) {
                this.f3313b.mo8487b(new C1387a() {
                    /* class com.umeng.analytics.p086a.p090d.C1395a.C14045 */

                    @Override // com.umeng.analytics.p086a.p088b.AbstractC1388b, com.umeng.analytics.p086a.p088b.C1387a
                    /* renamed from: a */
                    public void mo8391a(Object obj, boolean z) {
                        if (obj instanceof String) {
                            C1395a.this.f3314c.mo8494b();
                        }
                    }
                }, this.f3314c.mo8489a());
            }
            if (this.f3320l.size() > 0) {
                this.f3313b.mo8482a(new C1387a(), this.f3320l);
            }
        } catch (Throwable th) {
            C1346h.m4991b("convertMemoryToCacheTable happen error: " + th.toString());
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: q */
    private void m5186q() {
        List<String> b = this.f3313b.mo8485b();
        if (b != null) {
            this.f3320l = b;
        }
    }

    /* renamed from: d */
    public void mo8467d() {
        m5185p();
    }

    /* renamed from: e */
    public void mo8468e() {
        m5185p();
    }

    /* renamed from: f */
    public void mo8469f() {
        m5185p();
    }
}
