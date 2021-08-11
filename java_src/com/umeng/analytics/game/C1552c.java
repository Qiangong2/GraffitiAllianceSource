package com.umeng.analytics.game;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.C1420b;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.game.C1550b;
import com.umeng.analytics.p093d.C1488m;
import com.umeng.p085a.AbstractC1345g;
import com.umeng.p085a.AbstractRunnableC1359k;
import com.umeng.p085a.C1346h;
import com.umeng.p085a.C1347i;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/* access modifiers changed from: package-private */
/* renamed from: com.umeng.analytics.game.c */
/* compiled from: InternalGameAgent */
public class C1552c implements AbstractC1345g {

    /* renamed from: a */
    private C1420b f3934a = MobclickAgent.getAgent();

    /* renamed from: b */
    private C1550b f3935b = null;

    /* renamed from: c */
    private final int f3936c = 100;

    /* renamed from: d */
    private final int f3937d = 1;

    /* renamed from: e */
    private final int f3938e = 0;

    /* renamed from: f */
    private final int f3939f = -1;

    /* renamed from: g */
    private final int f3940g = 1;

    /* renamed from: h */
    private final String f3941h = "level";

    /* renamed from: i */
    private final String f3942i = "pay";

    /* renamed from: j */
    private final String f3943j = "buy";

    /* renamed from: k */
    private final String f3944k = "use";

    /* renamed from: l */
    private final String f3945l = "bonus";

    /* renamed from: m */
    private final String f3946m = "item";

    /* renamed from: n */
    private final String f3947n = "cash";

    /* renamed from: o */
    private final String f3948o = "coin";

    /* renamed from: p */
    private final String f3949p = "source";

    /* renamed from: q */
    private final String f3950q = "amount";

    /* renamed from: r */
    private final String f3951r = "user_level";

    /* renamed from: s */
    private final String f3952s = "bonus_source";

    /* renamed from: t */
    private final String f3953t = "level";

    /* renamed from: u */
    private final String f3954u = "status";

    /* renamed from: v */
    private final String f3955v = "duration";

    /* renamed from: w */
    private final String f3956w = "curtype";

    /* renamed from: x */
    private final String f3957x = "orderid";

    /* renamed from: y */
    private final String f3958y = "UMGameAgent.init(Context) should be called before any game api";

    /* renamed from: z */
    private Context f3959z;

    public C1552c() {
        C1549a.f3921a = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8926a(Context context) {
        if (context == null) {
            C1346h.m5009e("Context is null, can't init GameAgent");
            return;
        }
        this.f3959z = context.getApplicationContext();
        this.f3934a.mo8510a(this);
        this.f3935b = new C1550b(this.f3959z);
        this.f3934a.mo8499a(context, 1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8930a(boolean z) {
        C1346h.m4991b(String.format("Trace sleep time : %b", Boolean.valueOf(z)));
        C1549a.f3921a = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8927a(String str) {
        this.f3935b.f3923b = str;
        SharedPreferences a = C1488m.m5522a(this.f3959z);
        if (a != null) {
            SharedPreferences.Editor edit = a.edit();
            edit.putString("userlevel", str);
            edit.commit();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo8931b(final String str) {
        if (this.f3959z == null) {
            C1346h.m5009e("UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        this.f3935b.f3922a = str;
        C1347i.m5016a(new AbstractRunnableC1359k() {
            /* class com.umeng.analytics.game.C1552c.C15531 */

            @Override // com.umeng.p085a.AbstractRunnableC1359k
            /* renamed from: a */
            public void mo8374a() {
                C1552c.this.f3935b.mo8911a(str);
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("level", str);
                hashMap.put("status", 0);
                if (C1552c.this.f3935b.f3923b != null) {
                    hashMap.put("user_level", C1552c.this.f3935b.f3923b);
                }
                C1552c.this.f3934a.mo8504a(C1552c.this.f3959z, "level", hashMap);
            }
        });
    }

    /* renamed from: a */
    private void m5988a(final String str, final int i) {
        if (this.f3959z == null) {
            C1346h.m5009e("UMGameAgent.init(Context) should be called before any game api");
        } else {
            C1347i.m5016a(new AbstractRunnableC1359k() {
                /* class com.umeng.analytics.game.C1552c.C15542 */

                @Override // com.umeng.p085a.AbstractRunnableC1359k
                /* renamed from: a */
                public void mo8374a() {
                    C1550b.C1551a b = C1552c.this.f3935b.mo8913b(str);
                    if (b != null) {
                        long e = b.mo8920e();
                        if (e <= 0) {
                            C1346h.m4991b("level duration is 0");
                            return;
                        }
                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("level", str);
                        hashMap.put("status", Integer.valueOf(i));
                        hashMap.put("duration", Long.valueOf(e));
                        if (C1552c.this.f3935b.f3923b != null) {
                            hashMap.put("user_level", C1552c.this.f3935b.f3923b);
                        }
                        C1552c.this.f3934a.mo8504a(C1552c.this.f3959z, "level", hashMap);
                        return;
                    }
                    C1346h.m5003d(String.format("finishLevel(or failLevel) called before startLevel", new Object[0]));
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo8933c(String str) {
        if (this.f3959z == null) {
            C1346h.m5009e("UMGameAgent.init(Context) should be called before any game api");
        } else {
            m5988a(str, 1);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo8934d(String str) {
        if (this.f3959z == null) {
            C1346h.m5009e("UMGameAgent.init(Context) should be called before any game api");
        } else {
            m5988a(str, -1);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8922a(double d, double d2, int i) {
        if (this.f3959z == null) {
            C1346h.m5009e("UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("cash", Long.valueOf((long) (d * 100.0d)));
        hashMap.put("coin", Long.valueOf((long) (d2 * 100.0d)));
        hashMap.put("source", Integer.valueOf(i));
        if (this.f3935b.f3923b != null) {
            hashMap.put("user_level", this.f3935b.f3923b);
        }
        if (this.f3935b.f3922a != null) {
            hashMap.put("level", this.f3935b.f3922a);
        }
        this.f3934a.mo8504a(this.f3959z, "pay", hashMap);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8925a(double d, String str, int i, double d2, int i2) {
        mo8922a(d, d2 * ((double) i), i2);
        mo8928a(str, i, d2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8928a(String str, int i, double d) {
        if (this.f3959z == null) {
            C1346h.m5009e("UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("item", str);
        hashMap.put("amount", Integer.valueOf(i));
        hashMap.put("coin", Long.valueOf((long) (((double) i) * d * 100.0d)));
        if (this.f3935b.f3923b != null) {
            hashMap.put("user_level", this.f3935b.f3923b);
        }
        if (this.f3935b.f3922a != null) {
            hashMap.put("level", this.f3935b.f3922a);
        }
        this.f3934a.mo8504a(this.f3959z, "buy", hashMap);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo8932b(String str, int i, double d) {
        if (this.f3959z == null) {
            C1346h.m5009e("UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("item", str);
        hashMap.put("amount", Integer.valueOf(i));
        hashMap.put("coin", Long.valueOf((long) (((double) i) * d * 100.0d)));
        if (this.f3935b.f3923b != null) {
            hashMap.put("user_level", this.f3935b.f3923b);
        }
        if (this.f3935b.f3922a != null) {
            hashMap.put("level", this.f3935b.f3922a);
        }
        this.f3934a.mo8504a(this.f3959z, "use", hashMap);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8923a(double d, int i) {
        if (this.f3959z == null) {
            C1346h.m5009e("UMGameAgent.init(Context) should be called before any game api");
            return;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("coin", Long.valueOf((long) (100.0d * d)));
        hashMap.put("bonus_source", Integer.valueOf(i));
        if (this.f3935b.f3923b != null) {
            hashMap.put("user_level", this.f3935b.f3923b);
        }
        if (this.f3935b.f3922a != null) {
            hashMap.put("level", this.f3935b.f3922a);
        }
        this.f3934a.mo8504a(this.f3959z, "bonus", hashMap);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8929a(String str, int i, double d, int i2) {
        mo8923a(((double) i) * d, i2);
        mo8928a(str, i, d);
    }

    @Override // com.umeng.p085a.AbstractC1345g
    /* renamed from: a */
    public void mo8368a() {
        C1346h.m4991b("App resume from background");
        if (this.f3959z == null) {
            C1346h.m5009e("UMGameAgent.init(Context) should be called before any game api");
        } else if (C1549a.f3921a) {
            this.f3935b.mo8914b();
        }
    }

    @Override // com.umeng.p085a.AbstractC1345g
    /* renamed from: b */
    public void mo8369b() {
        if (this.f3959z == null) {
            C1346h.m5009e("UMGameAgent.init(Context) should be called before any game api");
        } else if (C1549a.f3921a) {
            this.f3935b.mo8912a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8924a(double d, String str, double d2, int i, String str2) {
        if (this.f3959z == null) {
            C1346h.m5009e("UMGameAgent.init(Context) should be called before any game api");
        } else if (d >= 0.0d && d2 >= 0.0d) {
            HashMap<String, Object> hashMap = new HashMap<>();
            if (!TextUtils.isEmpty(str) && str.length() > 0 && str.length() <= 3) {
                hashMap.put("curtype", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                try {
                    int length = str2.getBytes("UTF-8").length;
                    if (length > 0 && length <= 1024) {
                        hashMap.put("orderid", str2);
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            hashMap.put("cash", Long.valueOf((long) (d * 100.0d)));
            hashMap.put("coin", Long.valueOf((long) (d2 * 100.0d)));
            hashMap.put("source", Integer.valueOf(i));
            if (this.f3935b.f3923b != null) {
                hashMap.put("user_level", this.f3935b.f3923b);
            }
            if (this.f3935b.f3922a != null) {
                hashMap.put("level", this.f3935b.f3922a);
            }
            this.f3934a.mo8504a(this.f3959z, "pay", hashMap);
        }
    }
}
