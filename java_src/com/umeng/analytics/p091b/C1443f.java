package com.umeng.analytics.p091b;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.C1370a;
import com.umeng.analytics.p093d.C1488m;
import com.umeng.p085a.C1341c;
import com.umeng.p085a.C1343e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.umeng.analytics.b.f */
/* compiled from: UMStoreManager */
public class C1443f {

    /* renamed from: a */
    public static final int f3422a = 2049;

    /* renamed from: b */
    public static final int f3423b = 2050;

    /* renamed from: c */
    private static Context f3424c = null;

    /* renamed from: d */
    private static String f3425d = null;

    /* renamed from: e */
    private static final String f3426e = "umeng+";

    /* renamed from: f */
    private static final String f3427f = "ek__id";

    /* renamed from: g */
    private static final String f3428g = "ek_key";

    /* renamed from: h */
    private List<String> f3429h;

    /* renamed from: com.umeng.analytics.b.f$a */
    /* compiled from: UMStoreManager */
    public enum EnumC1445a {
        AUTOPAGE,
        PAGE,
        BEGIN,
        END,
        NEWSESSION
    }

    /* access modifiers changed from: private */
    /* renamed from: com.umeng.analytics.b.f$b */
    /* compiled from: UMStoreManager */
    public static class C1446b {

        /* renamed from: a */
        private static final C1443f f3436a = new C1443f();

        private C1446b() {
        }
    }

    private C1443f() {
        this.f3429h = new ArrayList();
        if (f3424c != null) {
            m5321b();
            this.f3429h.clear();
        }
    }

    /* renamed from: a */
    public static final C1443f m5318a(Context context) {
        f3424c = context;
        return C1446b.f3436a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0088, code lost:
        r0.endTransaction();
        com.umeng.analytics.p091b.C1441d.m5309a(com.umeng.analytics.p091b.C1443f.f3424c).mo8537b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0095, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0096, code lost:
        r1 = null;
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0087 A[ExcHandler: Throwable (th java.lang.Throwable), Splitter:B:1:0x0001] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8540a(org.json.JSONArray r8) {
        /*
        // Method dump skipped, instructions count: 173
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.p091b.C1443f.mo8540a(org.json.JSONArray):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0048, code lost:
        r0.endTransaction();
        com.umeng.analytics.p091b.C1441d.m5309a(com.umeng.analytics.p091b.C1443f.f3424c).mo8537b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0055, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0056, code lost:
        r1 = null;
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0047 A[ExcHandler: Throwable (th java.lang.Throwable), Splitter:B:1:0x0001] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo8542a(java.lang.String r6, java.lang.String r7, int r8) {
        /*
        // Method dump skipped, instructions count: 107
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.p091b.C1443f.mo8542a(java.lang.String, java.lang.String, int):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01e8  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo8543a(java.lang.String r9, org.json.JSONObject r10, com.umeng.analytics.p091b.C1443f.EnumC1445a r11) {
        /*
        // Method dump skipped, instructions count: 533
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.p091b.C1443f.mo8543a(java.lang.String, org.json.JSONObject, com.umeng.analytics.b.f$a):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5319a(java.lang.String r6, org.json.JSONObject r7, android.database.sqlite.SQLiteDatabase r8, java.lang.String r9) throws org.json.JSONException {
        /*
        // Method dump skipped, instructions count: 210
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.p091b.C1443f.m5319a(java.lang.String, org.json.JSONObject, android.database.sqlite.SQLiteDatabase, java.lang.String):void");
    }

    /* renamed from: a */
    public JSONObject mo8539a() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        m5323c(jSONObject2);
        m5322b(jSONObject2);
        m5320a(jSONObject2);
        try {
            if (jSONObject2.length() > 0) {
                jSONObject.put(C1370a.f3234z, jSONObject2);
            }
        } catch (Throwable th) {
        }
        return jSONObject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0093  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5320a(org.json.JSONObject r12) {
        /*
        // Method dump skipped, instructions count: 384
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.p091b.C1443f.m5320a(org.json.JSONObject):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0090, code lost:
        r2 = r1;
        r1 = r0;
        r0 = r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003f A[ExcHandler: Throwable (th java.lang.Throwable), Splitter:B:3:0x000b] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0079  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5322b(org.json.JSONObject r7) {
        /*
        // Method dump skipped, instructions count: 152
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.p091b.C1443f.m5322b(org.json.JSONObject):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0119, code lost:
        if (0 != 0) goto L_0x011b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x011b, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x011e, code lost:
        r3.endTransaction();
        com.umeng.analytics.p091b.C1441d.m5309a(com.umeng.analytics.p091b.C1443f.f3424c).mo8537b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x014d, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x014e, code lost:
        r4 = null;
        r3 = null;
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0156, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0166, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0167, code lost:
        r4 = r3;
        r3 = null;
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0118 A[ExcHandler: Throwable (th java.lang.Throwable), Splitter:B:1:0x0002] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0156  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5323c(org.json.JSONObject r18) {
        /*
        // Method dump skipped, instructions count: 374
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.p091b.C1443f.m5323c(org.json.JSONObject):void");
    }

    /* renamed from: a */
    public void mo8541a(boolean z, boolean z2) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            sQLiteDatabase = C1441d.m5309a(f3424c).mo8536a();
            try {
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL("delete from __er");
                sQLiteDatabase.execSQL("delete from __et");
                if (!z2) {
                    if (this.f3429h.size() > 0) {
                        for (int i = 0; i < this.f3429h.size(); i++) {
                            sQLiteDatabase.execSQL("delete from __sd where __ii=\"" + this.f3429h.get(i) + "\"");
                        }
                    }
                    this.f3429h.clear();
                } else if (z) {
                    sQLiteDatabase.execSQL("delete from __sd");
                }
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                C1441d.m5309a(f3424c).mo8537b();
            } catch (Throwable th2) {
                th = th2;
                sQLiteDatabase.endTransaction();
                C1441d.m5309a(f3424c).mo8537b();
                throw th;
            }
        } catch (Throwable th3) {
            sQLiteDatabase = null;
            th = th3;
            sQLiteDatabase.endTransaction();
            C1441d.m5309a(f3424c).mo8537b();
            throw th;
        }
    }

    /* renamed from: b */
    private void m5321b() {
        try {
            if (TextUtils.isEmpty(f3425d)) {
                SharedPreferences a = C1488m.m5522a(f3424c);
                String string = a.getString(f3427f, null);
                if (TextUtils.isEmpty(string)) {
                    string = C1343e.m4926A(f3424c);
                    if (!TextUtils.isEmpty(string)) {
                        a.edit().putString(f3427f, string).commit();
                    }
                }
                if (!TextUtils.isEmpty(string)) {
                    String substring = string.substring(1, 9);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < substring.length(); i++) {
                        char charAt = substring.charAt(i);
                        if (!Character.isDigit(charAt)) {
                            sb.append(charAt);
                        } else if (Integer.parseInt(Character.toString(charAt)) == 0) {
                            sb.append(0);
                        } else {
                            sb.append(10 - Integer.parseInt(Character.toString(charAt)));
                        }
                    }
                    f3425d = sb.toString();
                }
                if (!TextUtils.isEmpty(f3425d)) {
                    f3425d += new StringBuilder(f3425d).reverse().toString();
                    String string2 = a.getString(f3428g, null);
                    if (TextUtils.isEmpty(string2)) {
                        a.edit().putString(f3428g, mo8538a(f3426e)).commit();
                    } else if (!f3426e.equals(mo8544b(string2))) {
                        mo8541a(true, false);
                    }
                }
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    public String mo8538a(String str) {
        try {
            if (TextUtils.isEmpty(f3425d)) {
                return str;
            }
            return Base64.encodeToString(C1341c.m4916a(str.getBytes(), f3425d.getBytes()), 0);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: b */
    public String mo8544b(String str) {
        try {
            if (TextUtils.isEmpty(f3425d)) {
                return str;
            }
            return new String(C1341c.m4919b(Base64.decode(str.getBytes(), 0), f3425d.getBytes()));
        } catch (Exception e) {
            return null;
        }
    }
}
