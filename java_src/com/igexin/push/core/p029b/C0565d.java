package com.igexin.push.core.p029b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.igexin.p012b.p013a.p015b.C0456c;
import com.igexin.p012b.p022b.C0476a;
import com.igexin.push.core.bean.C0596i;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.igexin.push.core.b.d */
public class C0565d implements AbstractC0555a {

    /* renamed from: a */
    private static C0565d f1407a;

    /* renamed from: b */
    private List<C0596i> f1408b = new CopyOnWriteArrayList();

    private C0565d() {
    }

    /* renamed from: a */
    private int m2180a(int i) {
        int i2 = 0;
        for (C0596i iVar : this.f1408b) {
            i2 = iVar.mo4546c() == i ? i2 + 1 : i2;
        }
        return i2;
    }

    /* renamed from: a */
    public static C0565d m2181a() {
        if (f1407a == null) {
            f1407a = new C0565d();
        }
        return f1407a;
    }

    /* renamed from: b */
    private static ContentValues m2182b(C0596i iVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Long.valueOf(iVar.mo4543a()));
        contentValues.put("data", C0476a.m1776b(iVar.mo4545b().getBytes()));
        contentValues.put("type", Byte.valueOf(iVar.mo4546c()));
        contentValues.put("time", Long.valueOf(iVar.mo4547d()));
        return contentValues;
    }

    /* renamed from: b */
    private C0596i m2183b(long j) {
        for (C0596i iVar : this.f1408b) {
            if (iVar.mo4543a() == j) {
                return iVar;
            }
        }
        return null;
    }

    @Override // com.igexin.push.core.p029b.AbstractC0555a
    /* renamed from: a */
    public void mo4339a(SQLiteDatabase sQLiteDatabase) {
    }

    /* renamed from: a */
    public void mo4436a(C0596i iVar) {
        if (this.f1408b.size() < 107 && iVar != null) {
            switch (iVar.mo4546c()) {
                case 1:
                    if (m2180a(1) >= 1) {
                        return;
                    }
                    break;
                case 2:
                    if (m2180a(2) >= 3) {
                        return;
                    }
                    break;
                case 3:
                    if (m2180a(3) >= 90) {
                        return;
                    }
                    break;
                case 5:
                    if (m2180a(5) >= 3) {
                        return;
                    }
                    break;
                case 6:
                    if (m2180a(6) >= 10) {
                        return;
                    }
                    break;
            }
            this.f1408b.add(iVar);
            C0456c.m1661b().mo4216a(new C0566e(this, m2182b(iVar)), true, false);
        }
    }

    /* renamed from: a */
    public boolean mo4437a(long j) {
        C0596i b = m2183b(j);
        if (b == null) {
            return false;
        }
        this.f1408b.remove(b);
        C0456c.m1661b().mo4216a(new C0567f(this, m2182b(b), j), true, false);
        return true;
    }

    /* renamed from: b */
    public List<C0596i> mo4438b() {
        return this.f1408b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004a, code lost:
        if (0 != 0) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004c, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005c, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0060, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0061, code lost:
        r1 = r0;
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0049 A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:1:0x0004] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005c  */
    @Override // com.igexin.push.core.p029b.AbstractC0555a
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo4342b(android.database.sqlite.SQLiteDatabase r14) {
        /*
        // Method dump skipped, instructions count: 101
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.p029b.C0565d.mo4342b(android.database.sqlite.SQLiteDatabase):void");
    }

    @Override // com.igexin.push.core.p029b.AbstractC0555a
    /* renamed from: c */
    public void mo4345c(SQLiteDatabase sQLiteDatabase) {
    }
}
