package com.igexin.push.core.p029b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.igexin.p012b.p013a.p014a.C0435a;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p022b.C0476a;
import com.igexin.push.core.C0618g;
import com.igexin.push.util.C1155e;
import com.igexin.push.util.EncryptUtils;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/* renamed from: com.igexin.push.core.b.g */
public class C0568g implements AbstractC0555a {

    /* renamed from: a */
    private static final String f1412a = C0568g.class.getName();

    /* renamed from: b */
    private static C0568g f1413b;

    /* renamed from: c */
    private Map<String, String> f1414c = new TreeMap();

    /* renamed from: d */
    private boolean f1415d;

    private C0568g() {
    }

    /* renamed from: a */
    public static C0568g m2192a() {
        if (f1413b == null) {
            f1413b = new C0568g();
        }
        return f1413b;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2193a(SQLiteDatabase sQLiteDatabase, int i, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(i));
        contentValues.put("value", str);
        sQLiteDatabase.replace("runtime", null, contentValues);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2194a(SQLiteDatabase sQLiteDatabase, int i, byte[] bArr) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(i));
        contentValues.put("value", bArr);
        sQLiteDatabase.replace("runtime", null, contentValues);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004b  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] m2198a(android.database.sqlite.SQLiteDatabase r6, int r7) {
        /*
            r5 = this;
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003d, all -> 0x0045 }
            r1.<init>()     // Catch:{ Exception -> 0x003d, all -> 0x0045 }
            java.lang.String r2 = "select value from runtime where id="
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Exception -> 0x003d, all -> 0x0045 }
            java.lang.StringBuilder r1 = r1.append(r7)     // Catch:{ Exception -> 0x003d, all -> 0x0045 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x003d, all -> 0x0045 }
            r2 = 0
            android.database.Cursor r1 = r6.rawQuery(r1, r2)     // Catch:{ Exception -> 0x003d, all -> 0x0045 }
            if (r1 == 0) goto L_0x0037
            boolean r2 = r1.moveToFirst()     // Catch:{ Exception -> 0x0051, all -> 0x004f }
            if (r2 == 0) goto L_0x0037
            java.lang.String r2 = "value"
            int r2 = r1.getColumnIndex(r2)     // Catch:{ Exception -> 0x0051, all -> 0x004f }
            byte[] r2 = r1.getBlob(r2)     // Catch:{ Exception -> 0x0051, all -> 0x004f }
            java.lang.String r3 = com.igexin.push.core.C0618g.f1577B     // Catch:{ Exception -> 0x0051, all -> 0x004f }
            byte[] r0 = com.igexin.p012b.p013a.p014a.C0435a.m1577c(r2, r3)     // Catch:{ Exception -> 0x0051, all -> 0x004f }
            if (r1 == 0) goto L_0x0036
            r1.close()
        L_0x0036:
            return r0
        L_0x0037:
            if (r1 == 0) goto L_0x0036
            r1.close()
            goto L_0x0036
        L_0x003d:
            r1 = move-exception
            r1 = r0
        L_0x003f:
            if (r1 == 0) goto L_0x0036
            r1.close()
            goto L_0x0036
        L_0x0045:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0049:
            if (r1 == 0) goto L_0x004e
            r1.close()
        L_0x004e:
            throw r0
        L_0x004f:
            r0 = move-exception
            goto L_0x0049
        L_0x0051:
            r2 = move-exception
            goto L_0x003f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.p029b.C0568g.m2198a(android.database.sqlite.SQLiteDatabase, int):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0045  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m2200b(android.database.sqlite.SQLiteDatabase r5, int r6) {
        /*
            r4 = this;
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0037, all -> 0x003f }
            r1.<init>()     // Catch:{ Exception -> 0x0037, all -> 0x003f }
            java.lang.String r2 = "select value from runtime where id="
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Exception -> 0x0037, all -> 0x003f }
            java.lang.StringBuilder r1 = r1.append(r6)     // Catch:{ Exception -> 0x0037, all -> 0x003f }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0037, all -> 0x003f }
            r2 = 0
            android.database.Cursor r1 = r5.rawQuery(r1, r2)     // Catch:{ Exception -> 0x0037, all -> 0x003f }
            if (r1 == 0) goto L_0x0031
            boolean r2 = r1.moveToFirst()     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            if (r2 == 0) goto L_0x0031
            java.lang.String r2 = "value"
            int r2 = r1.getColumnIndex(r2)     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            java.lang.String r0 = r1.getString(r2)     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            if (r1 == 0) goto L_0x0030
            r1.close()
        L_0x0030:
            return r0
        L_0x0031:
            if (r1 == 0) goto L_0x0030
            r1.close()
            goto L_0x0030
        L_0x0037:
            r1 = move-exception
            r1 = r0
        L_0x0039:
            if (r1 == 0) goto L_0x0030
            r1.close()
            goto L_0x0030
        L_0x003f:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
        L_0x0043:
            if (r1 == 0) goto L_0x0048
            r1.close()
        L_0x0048:
            throw r0
        L_0x0049:
            r0 = move-exception
            goto L_0x0043
        L_0x004b:
            r2 = move-exception
            goto L_0x0039
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.p029b.C0568g.m2200b(android.database.sqlite.SQLiteDatabase, int):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0046, code lost:
        if (0 != 0) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0048, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0052, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0059, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005a, code lost:
        r1 = r0;
        r0 = r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0045 A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:1:0x0004] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0052  */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2201e(android.database.sqlite.SQLiteDatabase r6) {
        /*
            r5 = this;
            r0 = 0
            java.lang.String r1 = "select value from runtime where id=25"
            r2 = 0
            android.database.Cursor r0 = r6.rawQuery(r1, r2)     // Catch:{ Exception -> 0x0045, all -> 0x004c }
            if (r0 == 0) goto L_0x002f
            boolean r1 = r0.moveToFirst()     // Catch:{ Exception -> 0x0045, all -> 0x0059 }
            if (r1 == 0) goto L_0x002f
            java.lang.String r1 = new java.lang.String     // Catch:{ Exception -> 0x0045, all -> 0x0059 }
            java.lang.String r2 = "value"
            int r2 = r0.getColumnIndex(r2)     // Catch:{ Exception -> 0x0045, all -> 0x0059 }
            byte[] r2 = r0.getBlob(r2)     // Catch:{ Exception -> 0x0045, all -> 0x0059 }
            android.content.Context r3 = com.igexin.push.core.C0618g.f1635f     // Catch:{ Exception -> 0x0045, all -> 0x0059 }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ Exception -> 0x0045, all -> 0x0059 }
            java.lang.String r3 = com.igexin.p012b.p022b.C0476a.m1773a(r3)     // Catch:{ Exception -> 0x0045, all -> 0x0059 }
            byte[] r2 = com.igexin.p012b.p013a.p014a.C0435a.m1577c(r2, r3)     // Catch:{ Exception -> 0x0045, all -> 0x0059 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0045, all -> 0x0059 }
            com.igexin.push.core.C0618g.f1577B = r1     // Catch:{ Exception -> 0x0045, all -> 0x0059 }
        L_0x002f:
            if (r0 == 0) goto L_0x0034
            r0.close()
        L_0x0034:
            java.lang.String r0 = com.igexin.push.core.C0618g.f1577B
            if (r0 != 0) goto L_0x0044
            java.lang.String r0 = com.igexin.push.core.C0618g.f1649t
            if (r0 != 0) goto L_0x0056
            java.lang.String r0 = "cantgetimei"
        L_0x003e:
            java.lang.String r0 = com.igexin.p012b.p022b.C0476a.m1773a(r0)
            com.igexin.push.core.C0618g.f1577B = r0
        L_0x0044:
            return
        L_0x0045:
            r1 = move-exception
            if (r0 == 0) goto L_0x0034
            r0.close()
            goto L_0x0034
        L_0x004c:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0050:
            if (r1 == 0) goto L_0x0055
            r1.close()
        L_0x0055:
            throw r0
        L_0x0056:
            java.lang.String r0 = com.igexin.push.core.C0618g.f1649t
            goto L_0x003e
        L_0x0059:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L_0x0050
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.p029b.C0568g.m2201e(android.database.sqlite.SQLiteDatabase):void");
    }

    /* renamed from: e */
    private boolean m2202e() {
        return C0456c.m1661b().mo4216a(new C0586y(this), false, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m2203f() {
        C1155e.m4760a();
        String c = C1155e.m4769c();
        if (c == null || c.length() <= 5) {
            C1155e.m4771e();
        }
    }

    /* renamed from: f */
    private void m2204f(SQLiteDatabase sQLiteDatabase) {
        String b = m2200b(sQLiteDatabase, 2);
        if (!TextUtils.isEmpty(b)) {
            if (b.equals("null")) {
                b = null;
            }
            C0618g.f1653x = b;
        }
    }

    /* renamed from: g */
    private String m2205g() {
        String str = "";
        Random random = new Random(Math.abs(new Random().nextLong()));
        for (int i = 0; i < 15; i++) {
            str = str + random.nextInt(10);
        }
        return str;
    }

    /* renamed from: g */
    private void m2206g(SQLiteDatabase sQLiteDatabase) {
        String b = m2200b(sQLiteDatabase, 46);
        if (!TextUtils.isEmpty(b)) {
            if (b.equals("null")) {
                b = null;
            }
            C0618g.f1654y = b;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public byte[] m2207g(String str) {
        return EncryptUtils.getBytesEncrypted(str.getBytes());
    }

    /* renamed from: h */
    private void m2208h(SQLiteDatabase sQLiteDatabase) {
        String b = m2200b(sQLiteDatabase, 48);
        if (!TextUtils.isEmpty(b)) {
            if (b.equals("null")) {
                b = null;
            }
            C0618g.f1655z = b;
        }
    }

    /* renamed from: i */
    private void m2209i(SQLiteDatabase sQLiteDatabase) {
        String b = m2200b(sQLiteDatabase, 3);
        if (!TextUtils.isEmpty(b)) {
            if (b.equals("null")) {
                b = null;
            }
            C0618g.f1576A = b;
        }
    }

    /* renamed from: j */
    private void m2210j(SQLiteDatabase sQLiteDatabase) {
        byte[] a = m2198a(sQLiteDatabase, 1);
        if (a != null) {
            try {
                String str = new String(a);
                C0618g.f1646q = str.equals("null") ? 0 : Long.parseLong(str);
            } catch (Exception e) {
            }
            ActivityC0460a.m1698b(f1412a + "|db version changed, save session = " + C0618g.f1646q);
        }
    }

    /* renamed from: k */
    private void m2211k(SQLiteDatabase sQLiteDatabase) {
        byte[] a = m2198a(sQLiteDatabase, 20);
        if (a != null) {
            String str = new String(a);
            if (str.equals("null")) {
                str = null;
            }
            C0618g.f1648s = str;
            C0618g.f1647r = str;
            ActivityC0460a.m1698b(f1412a + "|db version changed, save cid = " + str);
        }
    }

    @Override // com.igexin.push.core.p029b.AbstractC0555a
    /* renamed from: a */
    public void mo4339a(SQLiteDatabase sQLiteDatabase) {
    }

    /* renamed from: a */
    public boolean mo4439a(int i) {
        C0618g.f1594S = i;
        return C0456c.m1661b().mo4216a(new C0576o(this), false, true);
    }

    /* renamed from: a */
    public boolean mo4440a(long j) {
        if (j == C0618g.f1582G) {
            return false;
        }
        C0618g.f1582G = j;
        return C0456c.m1661b().mo4216a(new C0580s(this), false, true);
    }

    /* renamed from: a */
    public boolean mo4441a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        C0618g.f1652w = str;
        return C0456c.m1661b().mo4216a(new C0587z(this), false, true);
    }

    /* renamed from: a */
    public boolean mo4442a(String str, String str2, long j) {
        C0618g.f1646q = j;
        if (TextUtils.isEmpty(C0618g.f1653x)) {
            C0618g.f1653x = str2;
        }
        C0618g.f1647r = str;
        return m2202e();
    }

    /* renamed from: a */
    public boolean mo4443a(String str, boolean z) {
        String str2 = null;
        if (str == null) {
            return false;
        }
        if (z) {
            if (!str.equals(C0618g.f1627aw)) {
                if (!str.equals("null")) {
                    str2 = str;
                }
                C0618g.f1627aw = str2;
                return C0456c.m1661b().mo4216a(new C0577p(this, str), false, true);
            }
        } else if (!str.equals(C0618g.f1628ax)) {
            if (!str.equals("null")) {
                str2 = str;
            }
            C0618g.f1628ax = str2;
            return C0456c.m1661b().mo4216a(new C0578q(this, str), false, true);
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo4444a(boolean z) {
        if (C0618g.f1589N == z) {
            return false;
        }
        C0618g.f1589N = z;
        return C0456c.m1661b().mo4216a(new C0573l(this), false, true);
    }

    /* renamed from: b */
    public void mo4445b() {
        C0456c.m1661b().mo4216a(new C0569h(this), false, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0241, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0242, code lost:
        r1 = r0;
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0247, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x006d, code lost:
        r0.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0241 A[ExcHandler: all (r1v23 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:4:0x0013] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x0484  */
    /* JADX WARNING: Removed duplicated region for block: B:262:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x018e  */
    @Override // com.igexin.push.core.p029b.AbstractC0555a
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo4342b(android.database.sqlite.SQLiteDatabase r12) {
        /*
        // Method dump skipped, instructions count: 1274
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.p029b.C0568g.mo4342b(android.database.sqlite.SQLiteDatabase):void");
    }

    /* renamed from: b */
    public boolean mo4446b(int i) {
        if (C0618g.f1630az == i) {
            return false;
        }
        C0618g.f1630az = i;
        return C0456c.m1661b().mo4216a(new C0584w(this), false, true);
    }

    /* renamed from: b */
    public boolean mo4447b(long j) {
        C0618g.m2424a(j);
        return C0456c.m1661b().mo4216a(new C0556aa(this), false, true);
    }

    /* renamed from: b */
    public boolean mo4448b(String str) {
        C0618g.f1653x = str;
        return C0456c.m1661b().mo4216a(new C0557ab(this), false, true);
    }

    /* renamed from: b */
    public boolean mo4449b(String str, boolean z) {
        String str2 = null;
        if (str == null) {
            return false;
        }
        if (z) {
            if (!str.equals(C0618g.f1625au)) {
                if (!str.equals("null")) {
                    str2 = str;
                }
                C0618g.f1625au = str2;
                return C0456c.m1661b().mo4216a(new C0579r(this, str), false, true);
            }
        } else if (!str.equals(C0618g.f1626av)) {
            if (!str.equals("null")) {
                str2 = str;
            }
            C0618g.f1626av = str2;
            return C0456c.m1661b().mo4216a(new C0581t(this, str), false, true);
        }
        return false;
    }

    /* renamed from: b */
    public boolean mo4450b(boolean z) {
        return C0456c.m1661b().mo4216a(new C0585x(this, z), false, true);
    }

    @Override // com.igexin.push.core.p029b.AbstractC0555a
    /* renamed from: c */
    public void mo4345c(SQLiteDatabase sQLiteDatabase) {
        m2194a(sQLiteDatabase, 1, C0435a.m1578d(String.valueOf(C0618g.f1646q).getBytes(), C0618g.f1577B));
        m2193a(sQLiteDatabase, 4, String.valueOf(C0618g.f1640k));
        m2193a(sQLiteDatabase, 8, String.valueOf(C0618g.f1582G));
        m2193a(sQLiteDatabase, 32, String.valueOf(C0618g.f1587L));
        m2193a(sQLiteDatabase, 3, C0618g.f1576A);
        m2193a(sQLiteDatabase, 11, String.valueOf(C0618g.f1585J));
        m2193a(sQLiteDatabase, 12, String.valueOf(C0618g.f1586K));
        m2194a(sQLiteDatabase, 20, C0435a.m1578d(C0618g.f1647r.getBytes(), C0618g.f1577B));
        m2193a(sQLiteDatabase, 2, C0618g.f1653x);
        m2194a(sQLiteDatabase, 25, C0435a.m1578d(C0618g.f1577B.getBytes(), C0476a.m1773a(C0618g.f1635f.getPackageName())));
    }

    /* renamed from: c */
    public boolean mo4451c() {
        C0618g.f1646q = 0;
        C0618g.f1647r = "null";
        return m2202e();
    }

    /* renamed from: c */
    public boolean mo4452c(long j) {
        if (C0618g.f1586K == j) {
            return false;
        }
        C0618g.f1586K = j;
        C0456c.m1661b().mo4216a(new C0560ae(this), false, true);
        return true;
    }

    /* renamed from: c */
    public boolean mo4453c(String str) {
        C0618g.f1654y = str;
        return C0456c.m1661b().mo4216a(new C0558ac(this), false, true);
    }

    /* renamed from: d */
    public Map<String, String> mo4454d() {
        return this.f1414c;
    }

    /* renamed from: d */
    public void mo4455d(SQLiteDatabase sQLiteDatabase) {
        this.f1415d = true;
        m2201e(sQLiteDatabase);
        m2210j(sQLiteDatabase);
        m2211k(sQLiteDatabase);
        m2209i(sQLiteDatabase);
        m2204f(sQLiteDatabase);
        m2206g(sQLiteDatabase);
        m2208h(sQLiteDatabase);
    }

    /* renamed from: d */
    public boolean mo4456d(long j) {
        C0618g.f1624at = j;
        ActivityC0460a.m1698b(f1412a + "|save idc config failed time : " + j);
        return C0456c.m1661b().mo4216a(new C0570i(this, j), false, true);
    }

    /* renamed from: d */
    public boolean mo4457d(String str) {
        C0618g.f1655z = str;
        return C0456c.m1661b().mo4216a(new C0559ad(this), false, true);
    }

    /* renamed from: e */
    public boolean mo4458e(long j) {
        if (C0618g.f1585J == j) {
            return false;
        }
        C0618g.f1585J = j;
        return C0456c.m1661b().mo4216a(new C0571j(this), false, true);
    }

    /* renamed from: e */
    public boolean mo4459e(String str) {
        if (str == null || str.equals(C0618g.f1588M)) {
            return false;
        }
        C0618g.f1588M = str;
        C0456c.m1661b().mo4216a(new C0572k(this), false, true);
        return true;
    }

    /* renamed from: f */
    public boolean mo4460f(long j) {
        if (C0618g.f1590O == j) {
            return false;
        }
        C0618g.f1590O = j;
        return C0456c.m1661b().mo4216a(new C0574m(this), false, true);
    }

    /* renamed from: f */
    public boolean mo4461f(String str) {
        if (str.equals(C0618g.f1592Q)) {
            return false;
        }
        C0618g.f1592Q = str;
        return C0456c.m1661b().mo4216a(new C0575n(this), false, true);
    }

    /* renamed from: g */
    public boolean mo4462g(long j) {
        if (C0618g.f1587L == j) {
            return false;
        }
        C0618g.f1587L = j;
        return C0456c.m1661b().mo4216a(new C0582u(this), false, true);
    }

    /* renamed from: h */
    public boolean mo4463h(long j) {
        if (C0618g.f1581F == j) {
            return false;
        }
        C0618g.f1581F = j;
        return C0456c.m1661b().mo4216a(new C0583v(this), false, true);
    }
}
