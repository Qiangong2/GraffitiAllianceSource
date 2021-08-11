package com.igexin.push.core.p029b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p013a.p019c.ActivityC0460a;
import com.igexin.p012b.p022b.C0476a;
import com.igexin.push.core.C0617f;
import com.igexin.push.core.bean.C0597j;
import com.igexin.push.core.p030c.C0612j;
import com.igexin.push.p079f.p080a.C1140c;
import com.tencent.gcloud.voice.GCloudVoiceErrno;
import com.tencent.qcloud.core.util.IOUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.igexin.push.core.b.af */
public class C0561af implements AbstractC0555a {

    /* renamed from: a */
    private static final String f1395a = C0561af.class.getName();

    /* renamed from: b */
    private static int f1396b = GCloudVoiceErrno.GCLOUD_VOICE_PERMISSION_MIC;

    /* renamed from: c */
    private static int f1397c = 50;

    /* renamed from: f */
    private static C0561af f1398f;

    /* renamed from: d */
    private int f1399d;

    /* renamed from: e */
    private ArrayList<C0597j> f1400e = null;

    private C0561af() {
    }

    /* renamed from: a */
    static /* synthetic */ int m2161a(C0561af afVar) {
        int i = afVar.f1399d;
        afVar.f1399d = i + 1;
        return i;
    }

    /* renamed from: a */
    public static C0561af m2162a() {
        if (f1398f == null) {
            f1398f = new C0561af();
        }
        return f1398f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0095  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<com.igexin.push.core.bean.C0597j> mo4428a(java.lang.String r9) {
        /*
        // Method dump skipped, instructions count: 158
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.p029b.C0561af.mo4428a(java.lang.String):java.util.ArrayList");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @Override // com.igexin.push.core.p029b.AbstractC0555a
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo4339a(android.database.sqlite.SQLiteDatabase r8) {
        /*
            r7 = this;
            r6 = 0
            com.igexin.push.core.f r0 = com.igexin.push.core.C0617f.m2395a()     // Catch:{ Throwable -> 0x0021, all -> 0x0029 }
            com.igexin.push.b.b r0 = r0.mo4632k()     // Catch:{ Throwable -> 0x0021, all -> 0x0029 }
            java.lang.String r1 = "st"
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r0 = r0.mo4253a(r1, r2, r3, r4, r5)     // Catch:{ Throwable -> 0x0021, all -> 0x0029 }
            if (r0 == 0) goto L_0x001b
            int r1 = r0.getCount()     // Catch:{ Throwable -> 0x0034, all -> 0x0030 }
            r7.f1399d = r1     // Catch:{ Throwable -> 0x0034, all -> 0x0030 }
        L_0x001b:
            if (r0 == 0) goto L_0x0020
            r0.close()
        L_0x0020:
            return
        L_0x0021:
            r0 = move-exception
            r0 = r6
        L_0x0023:
            if (r0 == 0) goto L_0x0020
            r0.close()
            goto L_0x0020
        L_0x0029:
            r0 = move-exception
        L_0x002a:
            if (r6 == 0) goto L_0x002f
            r6.close()
        L_0x002f:
            throw r0
        L_0x0030:
            r1 = move-exception
            r6 = r0
            r0 = r1
            goto L_0x002a
        L_0x0034:
            r1 = move-exception
            goto L_0x0023
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.p029b.C0561af.mo4339a(android.database.sqlite.SQLiteDatabase):void");
    }

    /* renamed from: a */
    public void mo4429a(String str, String str2) {
        if (this.f1399d >= f1396b) {
            ActivityC0460a.m1698b(f1395a + "|rowCount >= 200 can not insert");
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", str);
        contentValues.put("value", C0476a.m1776b(str2.getBytes()));
        contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
        C0456c.m1661b().mo4216a(new C0562ag(this, contentValues), false, true);
    }

    /* renamed from: a */
    public void mo4430a(String str, ArrayList<C0597j> arrayList) {
        try {
            String[] strArr = new String[arrayList.size()];
            Iterator<C0597j> it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                C0597j next = it.next();
                strArr[i] = String.valueOf(next.mo4548a());
                this.f1400e.remove(next);
                i++;
            }
            C0617f.m2395a().mo4632k().mo4257a("st", new String[]{"id"}, strArr);
            if (this.f1400e.size() > 0) {
                mo4432c(str);
            }
        } catch (Throwable th) {
            ActivityC0460a.m1698b(f1395a + "|onReportResult exception:" + th.toString());
        }
    }

    @Override // com.igexin.push.core.p029b.AbstractC0555a
    /* renamed from: b */
    public void mo4342b(SQLiteDatabase sQLiteDatabase) {
    }

    /* renamed from: b */
    public void mo4431b(String str) {
        this.f1400e = mo4428a(str);
        mo4432c(str);
    }

    @Override // com.igexin.push.core.p029b.AbstractC0555a
    /* renamed from: c */
    public void mo4345c(SQLiteDatabase sQLiteDatabase) {
    }

    /* renamed from: c */
    public void mo4432c(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            Iterator<C0597j> it = this.f1400e.iterator();
            while (it.hasNext()) {
                C0597j next = it.next();
                if (arrayList.size() >= f1397c) {
                    break;
                }
                arrayList.add(next);
                sb.append(next.mo4552b());
                sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            String sb2 = sb.toString();
            if (!TextUtils.isEmpty(sb2)) {
                C0456c.m1661b().mo4216a(new C1140c(new C0612j(sb2.getBytes(), str, arrayList)), false, true);
            }
        } catch (Throwable th) {
            ActivityC0460a.m1698b(f1395a + "|doSTReport exception:" + th.toString());
        }
    }
}
