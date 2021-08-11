package com.xiaomi.push.log;

import android.content.Context;
import android.content.SharedPreferences;
import com.igexin.assist.sdk.AssistPushConsts;
import com.umeng.analytics.C1370a;
import com.xiaomi.channel.commonutils.file.C1853c;
import com.xiaomi.channel.commonutils.logger.AbstractC1855b;
import com.xiaomi.channel.commonutils.misc.C1857b;
import com.xiaomi.channel.commonutils.network.C1865d;
import com.xiaomi.smack.util.C2046h;
import com.xiaomi.smack.util.C2047i;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.xiaomi.push.log.b */
public class C1919b {

    /* renamed from: c */
    private static C1919b f4937c = null;

    /* renamed from: a */
    private final ConcurrentLinkedQueue<C1921b> f4938a = new ConcurrentLinkedQueue<>();

    /* renamed from: b */
    private Context f4939b;

    /* renamed from: com.xiaomi.push.log.b$a */
    class C1920a extends C1921b {
        C1920a() {
            super();
        }

        @Override // com.xiaomi.push.log.C1919b.C1921b, com.xiaomi.channel.commonutils.misc.C1857b.AbstractC1859b
        /* renamed from: b */
        public void mo9932b() {
            C1919b.this.m7110b();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.push.log.b$b */
    public class C1921b extends C1857b.AbstractC1859b {

        /* renamed from: i */
        long f4941i = System.currentTimeMillis();

        C1921b() {
        }

        @Override // com.xiaomi.channel.commonutils.misc.C1857b.AbstractC1859b
        /* renamed from: b */
        public void mo9932b() {
        }

        /* renamed from: d */
        public boolean mo10309d() {
            return true;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public final boolean mo10310e() {
            return System.currentTimeMillis() - this.f4941i > 172800000;
        }
    }

    /* renamed from: com.xiaomi.push.log.b$c */
    class C1922c extends C1921b {

        /* renamed from: a */
        String f4943a;

        /* renamed from: b */
        String f4944b;

        /* renamed from: c */
        File f4945c;

        /* renamed from: d */
        int f4946d;

        /* renamed from: e */
        boolean f4947e;

        /* renamed from: f */
        boolean f4948f;

        C1922c(String str, String str2, File file, boolean z) {
            super();
            this.f4943a = str;
            this.f4944b = str2;
            this.f4945c = file;
            this.f4948f = z;
        }

        /* renamed from: f */
        private boolean m7120f() {
            int i;
            SharedPreferences sharedPreferences = C1919b.this.f4939b.getSharedPreferences("log.timestamp", 0);
            String string = sharedPreferences.getString("log.requst", "");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(string);
                currentTimeMillis = jSONObject.getLong("time");
                i = jSONObject.getInt("times");
            } catch (JSONException e) {
                i = 0;
            }
            if (System.currentTimeMillis() - currentTimeMillis >= C1370a.f3217i) {
                currentTimeMillis = System.currentTimeMillis();
                i = 0;
            } else if (i > 10) {
                return false;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("time", currentTimeMillis);
                jSONObject2.put("times", i + 1);
                sharedPreferences.edit().putString("log.requst", jSONObject2.toString()).commit();
            } catch (JSONException e2) {
                AbstractC1855b.m6722c("JSONException on put " + e2.getMessage());
            }
            return true;
        }

        @Override // com.xiaomi.push.log.C1919b.C1921b, com.xiaomi.channel.commonutils.misc.C1857b.AbstractC1859b
        /* renamed from: b */
        public void mo9932b() {
            try {
                if (m7120f()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uid", C2046h.m7708b());
                    hashMap.put(AssistPushConsts.MSG_TYPE_TOKEN, this.f4944b);
                    hashMap.put("net", C1865d.m6764f(C1919b.this.f4939b));
                    C1865d.m6755a(this.f4943a, hashMap, this.f4945c, "file");
                }
                this.f4947e = true;
            } catch (IOException e) {
            }
        }

        @Override // com.xiaomi.channel.commonutils.misc.C1857b.AbstractC1859b
        /* renamed from: c */
        public void mo9933c() {
            if (!this.f4947e) {
                this.f4946d++;
                if (this.f4946d < 3) {
                    C1919b.this.f4938a.add(this);
                }
            }
            if (this.f4947e || this.f4946d >= 3) {
                this.f4945c.delete();
            }
            C1919b.this.m7107a((C1919b) ((long) ((1 << this.f4946d) * 1000)));
        }

        @Override // com.xiaomi.push.log.C1919b.C1921b
        /* renamed from: d */
        public boolean mo10309d() {
            return C1865d.m6763e(C1919b.this.f4939b) || (this.f4948f && C1865d.m6762d(C1919b.this.f4939b));
        }
    }

    private C1919b(Context context) {
        this.f4939b = context;
        this.f4938a.add(new C1920a());
        m7111b(0);
    }

    /* renamed from: a */
    public static C1919b m7106a(Context context) {
        if (f4937c == null) {
            synchronized (C1919b.class) {
                if (f4937c == null) {
                    f4937c = new C1919b(context);
                }
            }
        }
        f4937c.f4939b = context;
        return f4937c;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private void m7107a(long j) {
        C1921b peek = this.f4938a.peek();
        if (peek != null && peek.mo10309d()) {
            m7111b(j);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: b */
    private void m7110b() {
        if (!C1853c.m6709b() && !C1853c.m6708a()) {
            try {
                File file = new File(this.f4939b.getExternalFilesDir(null) + "/.logcache");
                if (file.exists() && file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    for (File file2 : listFiles) {
                        file2.delete();
                    }
                }
            } catch (NullPointerException e) {
            }
        }
    }

    /* renamed from: b */
    private void m7111b(long j) {
        if (!this.f4938a.isEmpty()) {
            C2047i.m7710a(new C1924d(this), j);
        }
    }

    /* renamed from: c */
    private void m7112c() {
        while (!this.f4938a.isEmpty()) {
            if (this.f4938a.peek().mo10310e() || this.f4938a.size() > 6) {
                AbstractC1855b.m6722c("remove Expired task");
                this.f4938a.remove();
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public void mo10307a() {
        m7112c();
        m7107a(0);
    }

    /* renamed from: a */
    public void mo10308a(String str, String str2, Date date, Date date2, int i, boolean z) {
        this.f4938a.add(new C1923c(this, i, date, date2, str, str2, z));
        m7111b(0);
    }
}
