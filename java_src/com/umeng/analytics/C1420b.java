package com.umeng.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.p086a.p088b.C1387a;
import com.umeng.analytics.p086a.p090d.C1395a;
import com.umeng.analytics.p091b.C1443f;
import com.umeng.analytics.p091b.C1447g;
import com.umeng.analytics.p093d.AbstractC1486k;
import com.umeng.analytics.p093d.C1469b;
import com.umeng.analytics.p093d.C1474d;
import com.umeng.analytics.p093d.C1478e;
import com.umeng.analytics.p093d.C1479f;
import com.umeng.analytics.p093d.C1488m;
import com.umeng.analytics.p093d.C1493p;
import com.umeng.analytics.p093d.C1495r;
import com.umeng.p085a.AbstractC1345g;
import com.umeng.p085a.AbstractRunnableC1359k;
import com.umeng.p085a.C1341c;
import com.umeng.p085a.C1343e;
import com.umeng.p085a.C1346h;
import com.umeng.p085a.C1347i;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.b */
/* compiled from: InternalAgent */
public class C1420b implements AbstractC1486k {

    /* renamed from: j */
    private static final String f3350j = "sp";

    /* renamed from: a */
    private Context f3351a = null;

    /* renamed from: b */
    private AbstractC1345g f3352b;

    /* renamed from: c */
    private C1478e f3353c = new C1478e();

    /* renamed from: d */
    private C1495r f3354d = new C1495r();

    /* renamed from: e */
    private C1493p f3355e = new C1493p();

    /* renamed from: f */
    private C1479f f3356f = null;

    /* renamed from: g */
    private C1474d f3357g = null;

    /* renamed from: h */
    private C1469b f3358h = null;

    /* renamed from: i */
    private C1395a f3359i = null;

    /* renamed from: k */
    private boolean f3360k = false;

    /* renamed from: l */
    private boolean f3361l = false;

    /* renamed from: m */
    private JSONObject f3362m = null;

    /* renamed from: n */
    private boolean f3363n = false;

    C1420b() {
        this.f3353c.mo8630a(this);
    }

    /* renamed from: g */
    private void m5255g(Context context) {
        if (context != null) {
            try {
                if (Build.VERSION.SDK_INT > 13 && !this.f3363n && (context instanceof Activity)) {
                    this.f3358h = new C1469b((Activity) context);
                    this.f3363n = true;
                }
                if (!this.f3360k) {
                    this.f3351a = context.getApplicationContext();
                    this.f3356f = new C1479f(this.f3351a);
                    this.f3357g = C1474d.m5473b(this.f3351a);
                    this.f3360k = true;
                    if (this.f3359i == null) {
                        this.f3359i = C1395a.m5162a(this.f3351a);
                    }
                    if (!this.f3361l) {
                        C1347i.m5018b(new AbstractRunnableC1359k() {
                            /* class com.umeng.analytics.C1420b.C14211 */

                            @Override // com.umeng.p085a.AbstractRunnableC1359k
                            /* renamed from: a */
                            public void mo8374a() {
                                C1420b.this.f3359i.mo8461a(new C1387a() {
                                    /* class com.umeng.analytics.C1420b.C14211.C14221 */

                                    @Override // com.umeng.analytics.p086a.p088b.AbstractC1388b, com.umeng.analytics.p086a.p088b.C1387a
                                    /* renamed from: a */
                                    public void mo8391a(Object obj, boolean z) {
                                        C1420b.this.f3361l = true;
                                    }
                                });
                            }
                        });
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8512a(String str) {
        if (!AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
            try {
                this.f3354d.mo8668a(str);
            } catch (Exception e) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo8521b(String str) {
        if (!AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
            try {
                this.f3354d.mo8669b(str);
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    public void mo8510a(AbstractC1345g gVar) {
        this.f3352b = gVar;
    }

    /* renamed from: a */
    public void mo8499a(Context context, int i) {
        AnalyticsConfig.m5067a(context, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8498a(final Context context) {
        if (context == null) {
            C1346h.m5009e("unexpected null context in onResume");
            return;
        }
        if (AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
            this.f3354d.mo8668a(context.getClass().getName());
        }
        try {
            if (!this.f3360k || !this.f3363n) {
                m5255g(context);
            }
            C1347i.m5016a(new AbstractRunnableC1359k() {
                /* class com.umeng.analytics.C1420b.C14232 */

                @Override // com.umeng.p085a.AbstractRunnableC1359k
                /* renamed from: a */
                public void mo8374a() {
                    C1420b.this.m5256h(context.getApplicationContext());
                }
            });
        } catch (Exception e) {
            C1346h.m5011e("Exception occurred in Mobclick.onResume(). ", e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo8519b(final Context context) {
        if (context == null) {
            C1346h.m5009e("unexpected null context in onPause");
            return;
        }
        if (AnalyticsConfig.ACTIVITY_DURATION_OPEN) {
            this.f3354d.mo8669b(context.getClass().getName());
        }
        try {
            if (!this.f3360k || !this.f3363n) {
                m5255g(context);
            }
            C1347i.m5016a(new AbstractRunnableC1359k() {
                /* class com.umeng.analytics.C1420b.C14243 */

                @Override // com.umeng.p085a.AbstractRunnableC1359k
                /* renamed from: a */
                public void mo8374a() {
                    C1420b.this.m5257i(context.getApplicationContext());
                    C1420b.this.f3359i.mo8469f();
                }
            });
        } catch (Exception e) {
            if (C1346h.f3145a) {
                C1346h.m5011e("Exception occurred in Mobclick.onRause(). ", e);
            }
        }
    }

    /* renamed from: a */
    public C1493p mo8495a() {
        return this.f3355e;
    }

    /* renamed from: a */
    public void mo8504a(Context context, String str, HashMap<String, Object> hashMap) {
        try {
            if (!this.f3360k || !this.f3363n) {
                m5255g(context);
            }
            this.f3356f.mo8637b(str, hashMap);
        } catch (Exception e) {
            if (C1346h.f3145a) {
                C1346h.m5013e(e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8501a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (context == null) {
                C1346h.m5009e("unexpected null context in reportError");
                return;
            }
            try {
                if (!this.f3360k || !this.f3363n) {
                    m5255g(context);
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put(C1447g.f3471aH, 2);
                jSONObject.put(C1447g.f3472aI, str);
                C1443f.m5318a(this.f3351a).mo8542a(C1493p.m5539a(), jSONObject.toString(), 2);
            } catch (Exception e) {
                if (C1346h.f3145a) {
                    C1346h.m5013e(e);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8507a(Context context, Throwable th) {
        if (context != null && th != null) {
            try {
                mo8501a(context, C1341c.m4912a(th));
            } catch (Exception e) {
                if (C1346h.f3145a) {
                    C1346h.m5013e(e);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: h */
    private void m5256h(Context context) {
        this.f3355e.mo8654c(context);
        if (this.f3352b != null) {
            this.f3352b.mo8368a();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: i */
    private void m5257i(Context context) {
        this.f3355e.mo8655d(context);
        C1495r.m5564a(context);
        C1469b.m5435b(context);
        this.f3357g.mo8628a(this.f3351a).mo8619a(context);
        if (this.f3352b != null) {
            this.f3352b.mo8369b();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo8523c(Context context) {
        try {
            if (!this.f3360k || !this.f3363n) {
                m5255g(context);
            }
            this.f3357g.mo8618a();
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    public void mo8509a(Context context, List<String> list, int i, String str) {
        try {
            if (!this.f3360k || !this.f3363n) {
                m5255g(context);
            }
            this.f3356f.mo8636a(list, i, str);
        } catch (Exception e) {
            if (C1346h.f3145a) {
                C1346h.m5013e(e);
            }
        }
    }

    /* renamed from: a */
    public void mo8503a(Context context, String str, String str2, long j, int i) {
        try {
            if (!this.f3360k || !this.f3363n) {
                m5255g(context);
            }
            this.f3356f.mo8633a(str, str2, j, i);
        } catch (Exception e) {
            if (C1346h.f3145a) {
                C1346h.m5013e(e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8506a(Context context, String str, Map<String, Object> map, long j) {
        try {
            if (!this.f3360k || !this.f3363n) {
                m5255g(context);
            }
            this.f3356f.mo8635a(str, map, j);
        } catch (Exception e) {
            if (C1346h.f3145a) {
                C1346h.m5013e(e);
            }
        }
    }

    /* renamed from: a */
    public void mo8505a(Context context, String str, Map<String, Object> map) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo8527d(Context context) {
        try {
            this.f3358h.mo8609a(context);
            this.f3354d.mo8667a();
            m5257i(context);
            C1488m.m5522a(context).edit().commit();
            this.f3359i.mo8467d();
            C1347i.m5015a();
        } catch (Exception e) {
            if (C1346h.f3145a) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.umeng.analytics.p093d.AbstractC1486k
    /* renamed from: a */
    public void mo8514a(Throwable th) {
        try {
            this.f3354d.mo8667a();
            if (this.f3351a != null) {
                if (!(th == null || this.f3357g == null)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONObject.put(C1447g.f3471aH, 1);
                    jSONObject.put(C1447g.f3472aI, C1341c.m4912a(th));
                    C1443f.m5318a(this.f3351a).mo8542a(C1493p.m5539a(), jSONObject.toString(), 1);
                }
                this.f3359i.mo8468e();
                this.f3358h.mo8609a(this.f3351a);
                m5257i(this.f3351a);
                C1488m.m5522a(this.f3351a).edit().commit();
            }
            C1347i.m5015a();
        } catch (Exception e) {
            if (C1346h.f3145a) {
                C1346h.m5011e("Exception in onAppCrash", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8513a(final String str, final String str2) {
        try {
            C1347i.m5016a(new AbstractRunnableC1359k() {
                /* class com.umeng.analytics.C1420b.C14254 */

                @Override // com.umeng.p085a.AbstractRunnableC1359k
                /* renamed from: a */
                public void mo8374a() {
                    String[] a = C1448c.m5333a(C1420b.this.f3351a);
                    if (a == null || !str.equals(a[0]) || !str2.equals(a[1])) {
                        C1420b.this.f3357g.mo8628a(C1420b.this.f3351a).mo8619a(C1420b.this.f3351a);
                        boolean e = C1420b.this.mo8495a().mo8656e(C1420b.this.f3351a);
                        C1474d.m5473b(C1420b.this.f3351a).mo8623b();
                        if (e) {
                            C1420b.this.mo8495a().mo8657f(C1420b.this.f3351a);
                        }
                        C1448c.m5332a(C1420b.this.f3351a, str, str2);
                    }
                }
            });
        } catch (Exception e) {
            if (C1346h.f3145a) {
                C1346h.m5011e(" Excepthon  in  onProfileSignIn", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo8517b() {
        try {
            C1347i.m5016a(new AbstractRunnableC1359k() {
                /* class com.umeng.analytics.C1420b.C14265 */

                @Override // com.umeng.p085a.AbstractRunnableC1359k
                /* renamed from: a */
                public void mo8374a() {
                    String[] a = C1448c.m5333a(C1420b.this.f3351a);
                    if (a != null && !TextUtils.isEmpty(a[0]) && !TextUtils.isEmpty(a[1])) {
                        C1420b.this.f3357g.mo8628a(C1420b.this.f3351a).mo8619a(C1420b.this.f3351a);
                        boolean e = C1420b.this.mo8495a().mo8656e(C1420b.this.f3351a);
                        C1474d.m5473b(C1420b.this.f3351a).mo8623b();
                        if (e) {
                            C1420b.this.mo8495a().mo8657f(C1420b.this.f3351a);
                        }
                        C1448c.m5334b(C1420b.this.f3351a);
                    }
                }
            });
        } catch (Exception e) {
            if (C1346h.f3145a) {
                C1346h.m5011e(" Excepthon  in  onProfileSignOff", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8516a(boolean z) {
        AnalyticsConfig.CATCH_EXCEPTION = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8515a(GL10 gl10) {
        String[] a = C1343e.m4939a(gl10);
        if (a.length == 2) {
            AnalyticsConfig.GPU_VENDER = a[0];
            AnalyticsConfig.GPU_RENDERER = a[1];
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo8522b(boolean z) {
        AnalyticsConfig.ACTIVITY_DURATION_OPEN = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo8525c(boolean z) {
        C1370a.f3212d = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo8528d(boolean z) {
        C1346h.f3145a = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo8530e(boolean z) {
        AnalyticsConfig.m5070a(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8496a(double d, double d2) {
        if (AnalyticsConfig.f3194a == null) {
            AnalyticsConfig.f3194a = new double[2];
        }
        AnalyticsConfig.f3194a[0] = d;
        AnalyticsConfig.f3194a[1] = d2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8497a(long j) {
        AnalyticsConfig.sLatentWindow = ((int) j) * 1000;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8500a(Context context, MobclickAgent.EScenarioType eScenarioType) {
        if (context != null) {
            this.f3351a = context.getApplicationContext();
        }
        if (eScenarioType != null) {
            mo8499a(context, eScenarioType.toValue());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo8520b(Context context, String str) {
        if (context != null) {
            this.f3351a = context.getApplicationContext();
        }
        AnalyticsConfig.m5071b(context, str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8511a(MobclickAgent.UMAnalyticsConfig uMAnalyticsConfig) {
        if (uMAnalyticsConfig.mContext != null) {
            this.f3351a = uMAnalyticsConfig.mContext.getApplicationContext();
        }
        if (!TextUtils.isEmpty(uMAnalyticsConfig.mAppkey)) {
            AnalyticsConfig.m5068a(uMAnalyticsConfig.mContext, uMAnalyticsConfig.mAppkey);
            if (!TextUtils.isEmpty(uMAnalyticsConfig.mChannelId)) {
                AnalyticsConfig.m5069a(uMAnalyticsConfig.mChannelId);
            }
            AnalyticsConfig.CATCH_EXCEPTION = uMAnalyticsConfig.mIsCrashEnable;
            mo8500a(this.f3351a, uMAnalyticsConfig.mType);
            return;
        }
        C1346h.m5009e("the appkey is null!");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo8518b(long j) {
        AnalyticsConfig.kContinueSessionMillis = j;
    }

    /* renamed from: a */
    public void mo8502a(Context context, String str, Object obj) {
    }

    /* renamed from: c */
    public void mo8524c(Context context, String str) {
    }

    /* renamed from: d */
    public Object mo8526d(Context context, String str) {
        return null;
    }

    /* renamed from: e */
    public String mo8529e(Context context) {
        return null;
    }

    /* renamed from: j */
    private JSONObject m5258j(Context context) {
        try {
            String string = C1488m.m5522a(context).getString(f3350j, null);
            if (!TextUtils.isEmpty(string)) {
                return new JSONObject(string);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: f */
    public void mo8531f(Context context) {
    }

    /* renamed from: a */
    public void mo8508a(Context context, List<String> list) {
        try {
            if (!this.f3360k || !this.f3363n) {
                m5255g(context);
            }
            this.f3356f.mo8632a(context, list);
        } catch (Exception e) {
            C1346h.m5013e(e);
        }
    }
}
