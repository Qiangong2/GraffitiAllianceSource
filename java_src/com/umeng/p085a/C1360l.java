package com.umeng.p085a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.C1370a;
import com.umeng.analytics.p086a.p088b.C1387a;
import com.umeng.analytics.p086a.p090d.C1395a;
import com.umeng.analytics.p091b.C1443f;
import com.umeng.analytics.p091b.C1447g;
import com.umeng.analytics.p093d.C1488m;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Locale;

/* renamed from: com.umeng.a.l */
/* compiled from: StoreHelper */
public final class C1360l {

    /* renamed from: a */
    private static C1360l f3180a = null;

    /* renamed from: b */
    private static Context f3181b = null;

    /* renamed from: c */
    private static String f3182c = null;

    /* renamed from: e */
    private static final String f3183e = "mobclick_agent_user_";

    /* renamed from: f */
    private static final String f3184f = "mobclick_agent_header_";

    /* renamed from: g */
    private static final String f3185g = "mobclick_agent_cached_";

    /* renamed from: d */
    private C1362a f3186d;

    /* renamed from: com.umeng.a.l$b */
    /* compiled from: StoreHelper */
    public interface AbstractC1365b {
        /* renamed from: a */
        void mo8399a(File file);

        /* renamed from: b */
        boolean mo8400b(File file);

        /* renamed from: c */
        void mo8401c(File file);
    }

    public C1360l(Context context) {
        this.f3186d = new C1362a(context);
    }

    /* renamed from: a */
    public static synchronized C1360l m5038a(Context context) {
        C1360l lVar;
        synchronized (C1360l.class) {
            f3181b = context.getApplicationContext();
            f3182c = context.getPackageName();
            if (f3180a == null) {
                f3180a = new C1360l(context);
            }
            lVar = f3180a;
        }
        return lVar;
    }

    /* renamed from: a */
    public void mo8378a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            SharedPreferences.Editor edit = m5040k().edit();
            edit.putString("au_p", str);
            edit.putString("au_u", str2);
            edit.commit();
        }
    }

    /* renamed from: a */
    public String[] mo8380a() {
        SharedPreferences k = m5040k();
        String string = k.getString("au_p", null);
        String string2 = k.getString("au_u", null);
        if (string == null || string2 == null) {
            return null;
        }
        return new String[]{string, string2};
    }

    /* renamed from: b */
    public void mo8381b() {
        m5040k().edit().remove("au_p").remove("au_u").commit();
    }

    /* renamed from: c */
    public String mo8383c() {
        SharedPreferences a = C1488m.m5522a(f3181b);
        if (a != null) {
            return a.getString(C1447g.f3463a, null);
        }
        return null;
    }

    /* renamed from: a */
    public void mo8377a(String str) {
        SharedPreferences a = C1488m.m5522a(f3181b);
        if (a != null) {
            a.edit().putString(C1447g.f3463a, str).commit();
        }
    }

    /* renamed from: d */
    public String mo8385d() {
        SharedPreferences a = C1488m.m5522a(f3181b);
        if (a != null) {
            return a.getString(C1447g.f3507b, null);
        }
        return null;
    }

    /* renamed from: b */
    public void mo8382b(String str) {
        SharedPreferences a = C1488m.m5522a(f3181b);
        if (a != null) {
            a.edit().putString(C1447g.f3507b, str).commit();
        }
    }

    /* renamed from: e */
    public String mo8386e() {
        SharedPreferences a = C1488m.m5522a(f3181b);
        if (a != null) {
            return a.getString("st", null);
        }
        return null;
    }

    /* renamed from: c */
    public void mo8384c(String str) {
        SharedPreferences a = C1488m.m5522a(f3181b);
        if (a != null) {
            a.edit().putString("st", str).commit();
        }
    }

    /* renamed from: a */
    public void mo8376a(int i) {
        SharedPreferences a = C1488m.m5522a(f3181b);
        if (a != null) {
            a.edit().putInt("vt", i).commit();
        }
    }

    /* renamed from: f */
    public int mo8387f() {
        SharedPreferences a = C1488m.m5522a(f3181b);
        if (a != null) {
            return a.getInt("vt", 0);
        }
        return 0;
    }

    /* renamed from: g */
    public void mo8388g() {
        f3181b.deleteFile(m5041l());
        f3181b.deleteFile(m5042m());
        C1443f.m5318a(f3181b).mo8541a(true, false);
        C1395a.m5162a(f3181b).mo8465b(new C1387a() {
            /* class com.umeng.p085a.C1360l.C13611 */

            @Override // com.umeng.analytics.p086a.p088b.AbstractC1388b, com.umeng.analytics.p086a.p088b.C1387a
            /* renamed from: a */
            public void mo8391a(Object obj, boolean z) {
                if (obj.equals("success")) {
                }
            }
        });
    }

    /* renamed from: a */
    public void mo8379a(byte[] bArr) {
        this.f3186d.mo8393a(bArr);
    }

    /* renamed from: h */
    public boolean mo8389h() {
        return this.f3186d.mo8394a();
    }

    /* renamed from: i */
    public C1362a mo8390i() {
        return this.f3186d;
    }

    /* renamed from: k */
    private SharedPreferences m5040k() {
        return f3181b.getSharedPreferences(f3183e + f3182c, 0);
    }

    /* renamed from: l */
    private String m5041l() {
        return f3184f + f3182c;
    }

    /* renamed from: m */
    private String m5042m() {
        SharedPreferences a = C1488m.m5522a(f3181b);
        if (a == null) {
            return f3185g + f3182c + C1343e.m4934a(f3181b);
        }
        int i = a.getInt(C1370a.f3206B, 0);
        int parseInt = Integer.parseInt(C1343e.m4934a(f3181b));
        if (i == 0 || parseInt == i) {
            return f3185g + f3182c + C1343e.m4934a(f3181b);
        }
        return f3185g + f3182c + i;
    }

    /* renamed from: com.umeng.a.l$a */
    /* compiled from: StoreHelper */
    public static class C1362a {

        /* renamed from: a */
        private final int f3188a;

        /* renamed from: b */
        private File f3189b;

        /* renamed from: c */
        private FilenameFilter f3190c;

        public C1362a(Context context) {
            this(context, ".um");
        }

        public C1362a(Context context, String str) {
            this.f3188a = 10;
            this.f3190c = new FilenameFilter() {
                /* class com.umeng.p085a.C1360l.C1362a.C13642 */

                public boolean accept(File file, String str) {
                    return str.startsWith("um");
                }
            };
            this.f3189b = new File(context.getFilesDir(), str);
            if (!this.f3189b.exists() || !this.f3189b.isDirectory()) {
                this.f3189b.mkdir();
            }
        }

        /* renamed from: a */
        public boolean mo8394a() {
            File[] listFiles = this.f3189b.listFiles();
            if (listFiles == null || listFiles.length <= 0) {
                return false;
            }
            return true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0047, code lost:
            r2[r0].delete();
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo8392a(com.umeng.p085a.C1360l.AbstractC1365b r6) {
            /*
                r5 = this;
                r0 = 0
                java.io.File r1 = r5.f3189b
                java.io.FilenameFilter r2 = r5.f3190c
                java.io.File[] r2 = r1.listFiles(r2)
                if (r2 == 0) goto L_0x0029
                int r1 = r2.length
                r3 = 10
                if (r1 < r3) goto L_0x0029
                java.util.Arrays.sort(r2)
                int r1 = r2.length
                int r3 = r1 + -10
                com.umeng.a.l$a$1 r1 = new com.umeng.a.l$a$1
                r1.<init>(r3)
                com.umeng.p085a.C1347i.m5018b(r1)
                r1 = r0
            L_0x001f:
                if (r1 >= r3) goto L_0x0029
                r4 = r2[r1]
                r4.delete()
                int r1 = r1 + 1
                goto L_0x001f
            L_0x0029:
                if (r2 == 0) goto L_0x0054
                int r1 = r2.length
                if (r1 <= 0) goto L_0x0054
                java.io.File r1 = r5.f3189b
                r6.mo8399a(r1)
                int r1 = r2.length
            L_0x0034:
                if (r0 >= r1) goto L_0x004f
                r3 = r2[r0]     // Catch:{ Throwable -> 0x0046, all -> 0x004d }
                boolean r3 = r6.mo8400b(r3)     // Catch:{ Throwable -> 0x0046, all -> 0x004d }
                if (r3 == 0) goto L_0x0043
                r3 = r2[r0]
                r3.delete()
            L_0x0043:
                int r0 = r0 + 1
                goto L_0x0034
            L_0x0046:
                r3 = move-exception
                r3 = r2[r0]
                r3.delete()
                goto L_0x0043
            L_0x004d:
                r0 = move-exception
                throw r0
            L_0x004f:
                java.io.File r0 = r5.f3189b
                r6.mo8401c(r0)
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.p085a.C1360l.C1362a.mo8392a(com.umeng.a.l$b):void");
        }

        /* renamed from: a */
        public void mo8393a(byte[] bArr) {
            if (bArr != null && bArr.length != 0) {
                try {
                    C1344f.m4976a(new File(this.f3189b, String.format(Locale.US, "um_cache_%d.env", Long.valueOf(System.currentTimeMillis()))), bArr);
                } catch (Exception e) {
                }
            }
        }

        /* renamed from: b */
        public void mo8395b() {
            File[] listFiles = this.f3189b.listFiles(this.f3190c);
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    file.delete();
                }
            }
        }

        /* renamed from: c */
        public int mo8396c() {
            File[] listFiles = this.f3189b.listFiles(this.f3190c);
            if (listFiles == null || listFiles.length <= 0) {
                return 0;
            }
            return listFiles.length;
        }
    }
}
