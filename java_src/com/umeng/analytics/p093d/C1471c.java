package com.umeng.analytics.p093d;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.C1370a;
import com.umeng.analytics.C1448c;
import com.umeng.analytics.p086a.p090d.C1395a;
import com.umeng.analytics.p091b.C1443f;
import com.umeng.analytics.p091b.C1447g;
import com.umeng.analytics.p092c.C1451c;
import com.umeng.analytics.p092c.C1454f;
import com.umeng.analytics.p092c.C1457h;
import com.umeng.analytics.p094e.C1496a;
import com.umeng.analytics.p094e.C1497b;
import com.umeng.analytics.p094e.C1498c;
import com.umeng.analytics.p095f.C1521e;
import com.umeng.p085a.AbstractRunnableC1359k;
import com.umeng.p085a.C1341c;
import com.umeng.p085a.C1343e;
import com.umeng.p085a.C1344f;
import com.umeng.p085a.C1346h;
import com.umeng.p085a.C1347i;
import com.umeng.p085a.C1348j;
import com.umeng.p085a.C1360l;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000a.p001a.p002a.C0049m;

/* renamed from: com.umeng.analytics.d.c */
/* compiled from: CacheImpl */
public final class C1471c implements AbstractC1482g, AbstractC1487l {

    /* renamed from: j */
    private static Context f3623j = null;

    /* renamed from: q */
    private static final String f3624q = "thtstart";

    /* renamed from: r */
    private static final String f3625r = "gkvc";

    /* renamed from: s */
    private static final String f3626s = "ekvc";

    /* renamed from: a */
    String f3627a = null;

    /* renamed from: b */
    private C1360l f3628b = null;

    /* renamed from: c */
    private C1494q f3629c = null;

    /* renamed from: d */
    private C1497b f3630d = null;

    /* renamed from: e */
    private C1496a f3631e = null;

    /* renamed from: f */
    private C1498c f3632f = null;

    /* renamed from: g */
    private C1473a f3633g = null;

    /* renamed from: h */
    private C1457h.C1458a f3634h = null;

    /* renamed from: i */
    private long f3635i = 0;

    /* renamed from: k */
    private int f3636k = 10;

    /* renamed from: l */
    private JSONArray f3637l = new JSONArray();

    /* renamed from: m */
    private final int f3638m = 5000;

    /* renamed from: n */
    private int f3639n = 0;

    /* renamed from: o */
    private int f3640o = 0;

    /* renamed from: p */
    private long f3641p = 0;

    /* renamed from: t */
    private final long f3642t = 28800000;

    public C1471c(Context context) {
        f3623j = context;
        this.f3629c = new C1494q(context);
        this.f3628b = C1360l.m5038a(context);
        this.f3634h = C1457h.m5380a(context).mo8580b();
        this.f3633g = new C1473a();
        this.f3631e = C1496a.m5568a(f3623j);
        this.f3630d = C1497b.m5581a(f3623j);
        this.f3632f = C1498c.m5589a(f3623j, this.f3629c);
        SharedPreferences a = C1488m.m5522a(f3623j);
        this.f3641p = a.getLong(f3624q, 0);
        this.f3639n = a.getInt(f3625r, 0);
        this.f3640o = a.getInt(f3626s, 0);
        this.f3627a = C1457h.m5380a(f3623j).mo8580b().mo8592b((String) null);
    }

    @Override // com.umeng.analytics.p093d.AbstractC1482g
    /* renamed from: a */
    public void mo8618a() {
        if (C1343e.m4956l(f3623j)) {
            m5454d();
        } else {
            C1346h.m4991b("network is unavailable");
        }
    }

    @Override // com.umeng.analytics.p093d.AbstractC1482g
    /* renamed from: a */
    public void mo8621a(Object obj) {
        if (this.f3629c.mo8659f()) {
            this.f3635i = this.f3629c.mo8665l();
        }
        boolean z = true;
        if (obj instanceof JSONObject) {
            z = false;
            try {
                m5448b((JSONObject) obj);
            } catch (Throwable th) {
            }
        }
        if (m5444a(z)) {
            m5454d();
        }
    }

    /* renamed from: b */
    private void m5448b(JSONObject jSONObject) {
        try {
            if (2050 == jSONObject.getInt("__t")) {
                if (m5452c(this.f3639n)) {
                    this.f3639n++;
                } else {
                    return;
                }
            } else if (2049 == jSONObject.getInt("__t")) {
                if (m5452c(this.f3640o)) {
                    this.f3640o++;
                } else {
                    return;
                }
            }
            if (this.f3637l.length() > this.f3636k) {
                C1443f.m5318a(f3623j).mo8540a(this.f3637l);
                this.f3637l = new JSONArray();
            }
            if (this.f3641p == 0) {
                this.f3641p = System.currentTimeMillis();
            }
            this.f3637l.put(jSONObject);
        } catch (Throwable th) {
        }
    }

    @Override // com.umeng.analytics.p093d.AbstractC1482g
    /* renamed from: b */
    public void mo8623b() {
        m5451c(mo8617a(new int[0]));
    }

    /* renamed from: a */
    private void m5441a(int i) {
        m5451c(mo8617a(i, (int) (System.currentTimeMillis() - this.f3629c.mo8666m())));
        C1347i.m5017a(new AbstractRunnableC1359k() {
            /* class com.umeng.analytics.p093d.C1471c.C14721 */

            @Override // com.umeng.p085a.AbstractRunnableC1359k
            /* renamed from: a */
            public void mo8374a() {
                C1471c.this.mo8618a();
            }
        }, (long) i);
    }

    /* renamed from: c */
    private void m5451c(JSONObject jSONObject) {
        C1451c a;
        if (jSONObject != null) {
            try {
                C1454f a2 = C1454f.m5362a(f3623j);
                a2.mo8563a();
                try {
                    String encodeToString = Base64.encodeToString(new C0049m().mo116a(a2.mo8566b()), 0);
                    if (!TextUtils.isEmpty(encodeToString)) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject(C1370a.f3205A);
                        jSONObject2.put(C1447g.f3451O, encodeToString);
                        jSONObject.put(C1370a.f3205A, jSONObject2);
                    }
                } catch (Exception e) {
                }
                byte[] bytes = String.valueOf(jSONObject).getBytes();
                if (bytes != null && !C1341c.m4914a(f3623j, bytes)) {
                    if (m5457e()) {
                        a = C1451c.m5350b(f3623j, AnalyticsConfig.getAppkey(f3623j), bytes);
                    } else {
                        a = C1451c.m5347a(f3623j, AnalyticsConfig.getAppkey(f3623j), bytes);
                    }
                    byte[] c = a.mo8561c();
                    C1360l a3 = C1360l.m5038a(f3623j);
                    a3.mo8388g();
                    a3.mo8379a(c);
                    a2.mo8568d();
                }
            } catch (Exception e2) {
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public JSONObject mo8617a(int... iArr) {
        JSONObject a;
        JSONObject jSONObject;
        try {
            if (TextUtils.isEmpty(AnalyticsConfig.getAppkey(f3623j))) {
                C1346h.m5009e("Appkey is missing ,Please check AndroidManifest.xml");
                return null;
            }
            mo8619a(f3623j);
            a = C1443f.m5318a(f3623j).mo8539a();
            if (a == null) {
                a = new JSONObject();
            }
            try {
                jSONObject = a.getJSONObject(C1370a.f3234z);
            } catch (Throwable th) {
                jSONObject = new JSONObject();
            }
            JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
            SharedPreferences a2 = C1488m.m5522a(f3623j);
            if (a2 != null) {
                String string = a2.getString("userlevel", "");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("userlevel", string);
                }
            }
            if (this.f3629c.mo8659f() && this.f3635i != 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("ts", this.f3635i);
                jSONObject.put(C1447g.f3491ak, jSONObject3);
                jSONObject2.put(C1447g.f3491ak, jSONObject3);
            }
            JSONObject jSONObject4 = new JSONObject();
            JSONObject b = C1395a.m5162a(f3623j).mo8464b();
            if (b != null && b.length() > 0) {
                jSONObject4.put(C1447g.f3502av, b);
            }
            JSONObject c = C1395a.m5162a(f3623j).mo8466c();
            if (c != null && c.length() > 0) {
                jSONObject4.put(C1447g.f3465aB, c);
            }
            if (jSONObject4.length() > 0) {
                jSONObject.put(C1447g.f3501au, jSONObject4);
                jSONObject2.put(C1447g.f3501au, jSONObject4);
            }
            String[] a3 = C1448c.m5333a(f3623j);
            if (a3 != null && !TextUtils.isEmpty(a3[0]) && !TextUtils.isEmpty(a3[1])) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put(C1447g.f3499as, a3[0]);
                jSONObject5.put(C1447g.f3500at, a3[1]);
                if (jSONObject5.length() > 0) {
                    jSONObject.put(C1447g.f3498ar, jSONObject5);
                    jSONObject2.put(C1447g.f3498ar, jSONObject5);
                }
            }
            if (C1496a.m5568a(f3623j).mo8671a()) {
                m5455d(jSONObject);
            }
            this.f3630d.mo8680a(jSONObject, f3623j);
            if (iArr != null && iArr.length == 2) {
                JSONObject jSONObject6 = new JSONObject();
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put(C1447g.f3496ap, iArr[0] / 1000);
                jSONObject7.put(C1447g.f3495ao, iArr[1]);
                jSONObject6.put(C1447g.f3494an, jSONObject7);
                jSONObject.put(C1447g.f3493am, jSONObject6);
            }
            if (jSONObject.length() > 0) {
                a.put(C1370a.f3234z, jSONObject);
            } else {
                try {
                    a.remove(C1370a.f3234z);
                } catch (Throwable th2) {
                }
            }
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put(C1447g.f3463a, AnalyticsConfig.getAppkey(f3623j));
            jSONObject8.put(C1447g.f3507b, AnalyticsConfig.getChannel(f3623j));
            String a4 = C1344f.m4973a(AnalyticsConfig.getSecretKey(f3623j));
            if (!TextUtils.isEmpty(a4)) {
                jSONObject8.put(C1447g.f3508c, a4);
            }
            jSONObject8.put(C1447g.f3512g, C1343e.m4967w(f3623j));
            jSONObject8.put(C1447g.f3510e, C1343e.m4964t(f3623j));
            jSONObject8.put(C1447g.f3511f, C1343e.m4965u(f3623j));
            if (a2 == null) {
                try {
                    a2 = C1488m.m5522a(f3623j);
                } catch (Throwable th3) {
                    jSONObject8.put(C1447g.f3509d, C1343e.m4941b(f3623j));
                    jSONObject8.put(C1447g.f3513h, Integer.parseInt(C1343e.m4934a(f3623j)));
                }
            }
            if (a2 != null) {
                String string2 = a2.getString("vers_name", "");
                if (!TextUtils.isEmpty(string2)) {
                    jSONObject8.put(C1447g.f3509d, string2);
                    jSONObject8.put(C1447g.f3513h, a2.getInt("vers_code", 0));
                } else {
                    jSONObject8.put(C1447g.f3509d, C1343e.m4941b(f3623j));
                    jSONObject8.put(C1447g.f3513h, Integer.parseInt(C1343e.m4934a(f3623j)));
                }
            }
            if (!(AnalyticsConfig.mWrapperType == null || AnalyticsConfig.mWrapperVersion == null)) {
                jSONObject8.put(C1447g.f3514i, AnalyticsConfig.mWrapperType);
                jSONObject8.put(C1447g.f3515j, AnalyticsConfig.mWrapperVersion);
            }
            jSONObject8.put(C1447g.f3516k, "Android");
            jSONObject8.put(C1447g.f3517l, AnalyticsConfig.getSDKVersion(f3623j));
            jSONObject8.put(C1447g.f3518m, AnalyticsConfig.getVerticalType(f3623j));
            jSONObject8.put(C1447g.f3519n, C1343e.m4946d(f3623j));
            jSONObject8.put(C1447g.f3520o, C1343e.m4933a());
            jSONObject8.put(C1447g.f3521p, "Android");
            jSONObject8.put(C1447g.f3522q, Build.VERSION.RELEASE);
            int[] r = C1343e.m4962r(f3623j);
            if (r != null) {
                jSONObject8.put(C1447g.f3523r, r[1] + "*" + r[0]);
            }
            jSONObject8.put(C1447g.f3524s, C1343e.m4961q(f3623j));
            jSONObject8.put(C1447g.f3526u, C1343e.m4944c(f3623j));
            jSONObject8.put(C1447g.f3527v, Build.MODEL);
            jSONObject8.put(C1447g.f3528w, Build.BOARD);
            jSONObject8.put(C1447g.f3529x, Build.BRAND);
            jSONObject8.put(C1447g.f3530y, Build.TIME);
            jSONObject8.put(C1447g.f3531z, Build.MANUFACTURER);
            jSONObject8.put(C1447g.f3437A, Build.ID);
            jSONObject8.put(C1447g.f3438B, Build.DEVICE);
            String x = C1343e.m4968x(f3623j);
            if (!TextUtils.isEmpty(x)) {
                jSONObject8.put(C1447g.f3439C, x);
            }
            String y = C1343e.m4969y(f3623j);
            if (!TextUtils.isEmpty(y)) {
                jSONObject8.put(C1447g.f3440D, y);
            }
            Object[] j = C1343e.m4954j(f3623j);
            if (C1343e.f3140d.equals(j[0])) {
                jSONObject8.put(C1447g.f3445I, "wifi");
            } else if (C1343e.f3139c.equals(j[0])) {
                jSONObject8.put(C1447g.f3445I, C1343e.f3139c);
            } else {
                jSONObject8.put(C1447g.f3445I, "unknow");
            }
            if (!"".equals(j[1])) {
                jSONObject8.put(C1447g.f3446J, j[1]);
            }
            String e = C1343e.m4947e(f3623j);
            if (!TextUtils.isEmpty(e)) {
                jSONObject8.put(C1447g.f3525t, e);
            } else {
                jSONObject8.put(C1447g.f3525t, "");
            }
            Object[] o = C1343e.m4959o(f3623j);
            jSONObject8.put(C1447g.f3443G, o[0]);
            jSONObject8.put(C1447g.f3442F, o[1]);
            jSONObject8.put(C1447g.f3441E, C1343e.m4957m(f3623j));
            jSONObject8.put(C1447g.f3444H, C1343e.m4952h(f3623j));
            try {
                jSONObject8.put(C1447g.f3447K, a2.getInt("successful_request", 0));
                jSONObject8.put(C1447g.f3448L, a2.getInt(C1447g.f3448L, 0));
                jSONObject8.put(C1447g.f3449M, a2.getInt("last_request_spent_ms", 0));
            } catch (Exception e2) {
            }
            try {
                C1521e a5 = C1457h.m5380a(f3623j).mo8576a();
                if (a5 != null) {
                    jSONObject8.put(C1447g.f3450N, Base64.encodeToString(new C0049m().mo116a(a5), 0));
                }
            } catch (Exception e3) {
            }
            a.put(C1370a.f3205A, jSONObject8);
            jSONObject2.put(C1447g.f3517l, jSONObject8.getString(C1447g.f3517l)).put(C1447g.f3526u, jSONObject8.getString(C1447g.f3526u)).put(C1447g.f3527v, jSONObject8.getString(C1447g.f3527v)).put("version", jSONObject8.getString(C1447g.f3513h)).put(C1447g.f3463a, jSONObject8.getString(C1447g.f3463a)).put(C1447g.f3507b, jSONObject8.getString(C1447g.f3507b));
            if (!mo8622a(jSONObject8)) {
                a = null;
            }
            if (C1346h.f3145a && jSONObject2.length() > 0) {
                C1346h.m4991b(String.valueOf(jSONObject2));
            }
            if (a2 == null) {
                return a;
            }
            SharedPreferences.Editor edit = a2.edit();
            edit.remove("vers_name");
            edit.remove("vers_code");
            edit.remove("vers_date");
            edit.remove("vers_pre_version");
            edit.commit();
            return a;
        } catch (Throwable th4) {
            C1360l.m5038a(f3623j).mo8388g();
            return null;
        }
    }

    /* renamed from: d */
    private void m5455d(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(C1496a.m5568a(f3623j).mo8676f(), C1496a.m5568a(f3623j).mo8675e());
        jSONObject.put(C1447g.f3497aq, jSONObject2);
    }

    /* renamed from: a */
    private String[] m5445a(SharedPreferences.Editor editor, SharedPreferences sharedPreferences, String str, String str2) {
        String string = sharedPreferences.getString("pre_version", "");
        String string2 = sharedPreferences.getString("pre_date", "");
        String string3 = sharedPreferences.getString("cur_version", "");
        String b = C1343e.m4941b(f3623j);
        if (!string3.equals(b)) {
            string2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
            editor.putString("pre_version", string3);
            editor.putString("pre_date", string2);
            editor.putString("cur_version", b);
            editor.commit();
        } else {
            string3 = string;
        }
        return new String[]{string3, string2};
    }

    /* renamed from: a */
    private void m5443a(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        jSONObject.put(C1447g.f3454R, str);
        if (TextUtils.isEmpty(str2)) {
            str2 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
        }
        jSONObject.put(C1447g.f3455S, str2);
    }

    /* renamed from: a */
    public boolean mo8622a(JSONObject jSONObject) {
        if (TextUtils.isEmpty(C1447g.f3526u) || TextUtils.isEmpty(C1447g.f3524s) || TextUtils.isEmpty(C1447g.f3523r) || TextUtils.isEmpty(C1447g.f3463a) || TextUtils.isEmpty(C1447g.f3507b) || TextUtils.isEmpty(C1447g.f3511f) || TextUtils.isEmpty(C1447g.f3510e) || TextUtils.isEmpty(C1447g.f3509d)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private boolean m5444a(boolean z) {
        if (!C1343e.m4956l(f3623j)) {
            C1346h.m5009e("network is unavailable");
            return false;
        } else if (this.f3629c.mo8659f()) {
            return true;
        } else {
            return this.f3633g.mo8627b(z).mo8370a(z);
        }
    }

    /* renamed from: d */
    private void m5454d() {
        try {
            if (this.f3628b.mo8389h()) {
                C1491o oVar = new C1491o(f3623j, this.f3629c);
                oVar.mo8648a(this);
                if (this.f3630d.mo8683d()) {
                    oVar.mo8651b(true);
                }
                oVar.mo8647a();
                return;
            }
            JSONObject a = mo8617a(new int[0]);
            if (a.length() > 0) {
                C1491o oVar2 = new C1491o(f3623j, this.f3629c);
                oVar2.mo8648a(this);
                if (this.f3630d.mo8683d()) {
                    oVar2.mo8651b(true);
                }
                oVar2.mo8649a(a);
                oVar2.mo8650a(m5457e());
                oVar2.mo8647a();
            }
        } catch (Throwable th) {
            if (th != null) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: e */
    private boolean m5457e() {
        switch (this.f3634h.mo8594c(-1)) {
            case -1:
                return AnalyticsConfig.sEncrypt;
            case 0:
            default:
                return false;
            case 1:
                return true;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: b */
    private void m5447b(int i) {
        m5441a(i);
    }

    @Override // com.umeng.analytics.p093d.AbstractC1487l
    /* renamed from: a */
    public void mo8620a(C1457h.C1458a aVar) {
        this.f3631e.mo8620a(aVar);
        this.f3630d.mo8620a(aVar);
        this.f3632f.mo8620a(aVar);
        this.f3633g.mo8625a(aVar);
        this.f3627a = C1457h.m5380a(f3623j).mo8580b().mo8592b((String) null);
    }

    /* renamed from: com.umeng.analytics.d.c$a */
    /* compiled from: CacheImpl */
    public class C1473a {

        /* renamed from: b */
        private C1348j.C1356h f3645b;

        /* renamed from: c */
        private int f3646c = -1;

        /* renamed from: d */
        private int f3647d = -1;

        /* renamed from: e */
        private int f3648e = -1;

        /* renamed from: f */
        private int f3649f = -1;

        public C1473a() {
            int[] a = C1471c.this.f3634h.mo8590a(-1, -1);
            this.f3646c = a[0];
            this.f3647d = a[1];
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo8626a(boolean z) {
            C1348j.C1356h bVar;
            boolean z2 = true;
            int i = 0;
            if (C1471c.this.f3630d.mo8683d()) {
                if (!(this.f3645b instanceof C1348j.C1350b) || !this.f3645b.mo8371a()) {
                    z2 = false;
                }
                if (z2) {
                    bVar = this.f3645b;
                } else {
                    bVar = new C1348j.C1350b(C1471c.this.f3629c, C1471c.this.f3630d);
                }
                this.f3645b = bVar;
                return;
            }
            if (!(this.f3645b instanceof C1348j.C1351c) || !this.f3645b.mo8371a()) {
                z2 = false;
            }
            if (z2) {
                return;
            }
            if (z && C1471c.this.f3632f.mo8684a()) {
                this.f3645b = new C1348j.C1351c((int) C1471c.this.f3632f.mo8685b());
                C1471c.this.m5447b((C1471c) ((int) C1471c.this.f3632f.mo8685b()));
            } else if (C1346h.f3145a && C1471c.this.f3634h.mo8593b()) {
                this.f3645b = new C1348j.C1349a(C1471c.this.f3629c);
            } else if (!C1471c.this.f3631e.mo8671a() || !"RPT".equals(C1471c.this.f3631e.mo8676f())) {
                int i2 = this.f3648e;
                int i3 = this.f3649f;
                if (this.f3646c != -1) {
                    i2 = this.f3646c;
                    i3 = this.f3647d;
                }
                this.f3645b = m5467b(i2, i3);
            } else {
                if (C1471c.this.f3631e.mo8672b() == 6) {
                    if (C1471c.this.f3634h.mo8589a()) {
                        i = C1471c.this.f3634h.mo8596d(90000);
                    } else if (this.f3647d > 0) {
                        i = this.f3647d;
                    } else {
                        i = this.f3649f;
                    }
                }
                this.f3645b = m5467b(C1471c.this.f3631e.mo8672b(), i);
            }
        }

        /* renamed from: b */
        public C1348j.C1356h mo8627b(boolean z) {
            mo8626a(z);
            return this.f3645b;
        }

        /* renamed from: b */
        private C1348j.C1356h m5467b(int i, int i2) {
            switch (i) {
                case 0:
                    return this.f3645b instanceof C1348j.C1355g ? this.f3645b : new C1348j.C1355g();
                case 1:
                    return this.f3645b instanceof C1348j.C1352d ? this.f3645b : new C1348j.C1352d();
                case 2:
                case 3:
                case 7:
                default:
                    if (this.f3645b instanceof C1348j.C1352d) {
                        return this.f3645b;
                    }
                    return new C1348j.C1352d();
                case 4:
                    if (this.f3645b instanceof C1348j.C1354f) {
                        return this.f3645b;
                    }
                    return new C1348j.C1354f(C1471c.this.f3629c);
                case 5:
                    if (this.f3645b instanceof C1348j.C1357i) {
                        return this.f3645b;
                    }
                    return new C1348j.C1357i(C1471c.f3623j);
                case 6:
                    if (!(this.f3645b instanceof C1348j.C1353e)) {
                        return new C1348j.C1353e(C1471c.this.f3629c, (long) i2);
                    }
                    C1348j.C1356h hVar = this.f3645b;
                    ((C1348j.C1353e) hVar).mo8372a((long) i2);
                    return hVar;
                case 8:
                    if (this.f3645b instanceof C1348j.C1358j) {
                        return this.f3645b;
                    }
                    return new C1348j.C1358j(C1471c.this.f3629c);
            }
        }

        /* renamed from: a */
        public void mo8624a(int i, int i2) {
            this.f3648e = i;
            this.f3649f = i2;
        }

        /* renamed from: a */
        public void mo8625a(C1457h.C1458a aVar) {
            int[] a = aVar.mo8590a(-1, -1);
            this.f3646c = a[0];
            this.f3647d = a[1];
        }
    }

    /* renamed from: c */
    private boolean m5452c(int i) {
        if (this.f3641p == 0) {
            return true;
        }
        if (System.currentTimeMillis() - this.f3641p > 28800000) {
            m5458f();
            return true;
        } else if (i > 5000) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: a */
    public void mo8619a(Context context) {
        try {
            if (f3623j == null) {
                f3623j = context;
            }
            if (this.f3637l.length() > 0) {
                C1443f.m5318a(f3623j).mo8540a(this.f3637l);
                this.f3637l = new JSONArray();
            }
            C1488m.m5522a(f3623j).edit().putLong(f3624q, this.f3641p).putInt(f3625r, this.f3639n).putInt(f3626s, this.f3640o).commit();
        } catch (Throwable th) {
        }
    }

    /* renamed from: f */
    private void m5458f() {
        this.f3639n = 0;
        this.f3640o = 0;
        this.f3641p = System.currentTimeMillis();
    }
}
