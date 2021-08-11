package com.igexin.push.extension.distribution.basic.p046g.p048b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.igexin.push.extension.distribution.basic.p046g.p047a.C0753a;

/* renamed from: com.igexin.push.extension.distribution.basic.g.b.b */
public class C0759b {

    /* renamed from: a */
    private static C0759b f2117a;

    /* renamed from: b */
    private C0758a f2118b;

    /* renamed from: c */
    private SQLiteDatabase f2119c = this.f2118b.getWritableDatabase();

    private C0759b(Context context) {
        this.f2118b = new C0758a(context);
    }

    /* renamed from: a */
    public static C0759b m3088a(Context context) {
        if (f2117a == null) {
            synchronized (C0759b.class) {
                if (f2117a == null) {
                    f2117a = new C0759b(context.getApplicationContext());
                }
            }
        }
        return f2117a;
    }

    /* renamed from: a */
    public long mo5088a(C0753a aVar) {
        long j = -1;
        this.f2119c.beginTransaction();
        try {
            j = this.f2119c.insert("download", null, aVar.mo5081l());
            this.f2119c.setTransactionSuccessful();
        } catch (Throwable th) {
        } finally {
            this.f2119c.endTransaction();
        }
        return j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        r9.f2119c.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0027 A[ExcHandler: all (r0v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x0006] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.database.Cursor mo5089a() {
        /*
            r9 = this;
            r8 = 0
            android.database.sqlite.SQLiteDatabase r0 = r9.f2119c
            r0.beginTransaction()
            android.database.sqlite.SQLiteDatabase r0 = r9.f2119c     // Catch:{ Throwable -> 0x001f, all -> 0x0027 }
            java.lang.String r1 = "download"
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Throwable -> 0x001f, all -> 0x0027 }
            android.database.sqlite.SQLiteDatabase r1 = r9.f2119c     // Catch:{ Throwable -> 0x002e, all -> 0x0027 }
            r1.setTransactionSuccessful()     // Catch:{ Throwable -> 0x002e, all -> 0x0027 }
            android.database.sqlite.SQLiteDatabase r1 = r9.f2119c
            r1.endTransaction()
        L_0x001e:
            return r0
        L_0x001f:
            r0 = move-exception
            r0 = r8
        L_0x0021:
            android.database.sqlite.SQLiteDatabase r1 = r9.f2119c
            r1.endTransaction()
            goto L_0x001e
        L_0x0027:
            r0 = move-exception
            android.database.sqlite.SQLiteDatabase r1 = r9.f2119c
            r1.endTransaction()
            throw r0
        L_0x002e:
            r1 = move-exception
            goto L_0x0021
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.p046g.p048b.C0759b.mo5089a():android.database.Cursor");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        r10.f2119c.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035 A[ExcHandler: all (r0v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x0009] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo5090a(int r11) {
        /*
            r10 = this;
            r4 = 0
            r0 = 1
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.f2119c
            r2.beginTransaction()
            android.database.sqlite.SQLiteDatabase r2 = r10.f2119c     // Catch:{ Throwable -> 0x002d, all -> 0x0035 }
            java.lang.String r3 = "download"
            java.lang.String r6 = "id = ? "
            r7 = 1
            java.lang.String[] r7 = new java.lang.String[r7]     // Catch:{ Throwable -> 0x002d, all -> 0x0035 }
            r8 = 0
            java.lang.String r9 = java.lang.String.valueOf(r11)     // Catch:{ Throwable -> 0x002d, all -> 0x0035 }
            r7[r8] = r9     // Catch:{ Throwable -> 0x002d, all -> 0x0035 }
            int r2 = r2.delete(r3, r6, r7)     // Catch:{ Throwable -> 0x002d, all -> 0x0035 }
            long r2 = (long) r2
            android.database.sqlite.SQLiteDatabase r6 = r10.f2119c     // Catch:{ Throwable -> 0x003e, all -> 0x0035 }
            r6.setTransactionSuccessful()     // Catch:{ Throwable -> 0x003e, all -> 0x0035 }
            android.database.sqlite.SQLiteDatabase r6 = r10.f2119c
            r6.endTransaction()
        L_0x0028:
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x003c
        L_0x002c:
            return r0
        L_0x002d:
            r2 = move-exception
            r2 = r4
        L_0x002f:
            android.database.sqlite.SQLiteDatabase r6 = r10.f2119c
            r6.endTransaction()
            goto L_0x0028
        L_0x0035:
            r0 = move-exception
            android.database.sqlite.SQLiteDatabase r1 = r10.f2119c
            r1.endTransaction()
            throw r0
        L_0x003c:
            r0 = r1
            goto L_0x002c
        L_0x003e:
            r6 = move-exception
            goto L_0x002f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.p046g.p048b.C0759b.mo5090a(int):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0038, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        r10.f2119c.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003e, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0038 A[ExcHandler: all (r0v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x0007] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo5091b(com.igexin.push.extension.distribution.basic.p046g.p047a.C0753a r11) {
        /*
            r10 = this;
            r0 = 1
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.f2119c
            r2.beginTransaction()
            android.database.sqlite.SQLiteDatabase r2 = r10.f2119c     // Catch:{ Throwable -> 0x0030, all -> 0x0038 }
            java.lang.String r3 = "download"
            android.content.ContentValues r4 = r11.mo5081l()     // Catch:{ Throwable -> 0x0030, all -> 0x0038 }
            java.lang.String r5 = "id = ? "
            r6 = 1
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ Throwable -> 0x0030, all -> 0x0038 }
            r7 = 0
            long r8 = r11.mo5062a()     // Catch:{ Throwable -> 0x0030, all -> 0x0038 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ Throwable -> 0x0030, all -> 0x0038 }
            r6[r7] = r8     // Catch:{ Throwable -> 0x0030, all -> 0x0038 }
            int r2 = r2.update(r3, r4, r5, r6)     // Catch:{ Throwable -> 0x0030, all -> 0x0038 }
            android.database.sqlite.SQLiteDatabase r3 = r10.f2119c     // Catch:{ Throwable -> 0x0041, all -> 0x0038 }
            r3.setTransactionSuccessful()     // Catch:{ Throwable -> 0x0041, all -> 0x0038 }
            android.database.sqlite.SQLiteDatabase r3 = r10.f2119c
            r3.endTransaction()
        L_0x002d:
            if (r2 == 0) goto L_0x003f
        L_0x002f:
            return r0
        L_0x0030:
            r2 = move-exception
            r2 = r1
        L_0x0032:
            android.database.sqlite.SQLiteDatabase r3 = r10.f2119c
            r3.endTransaction()
            goto L_0x002d
        L_0x0038:
            r0 = move-exception
            android.database.sqlite.SQLiteDatabase r1 = r10.f2119c
            r1.endTransaction()
            throw r0
        L_0x003f:
            r0 = r1
            goto L_0x002f
        L_0x0041:
            r3 = move-exception
            goto L_0x0032
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.p046g.p048b.C0759b.mo5091b(com.igexin.push.extension.distribution.basic.g.a.a):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0053, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0054, code lost:
        r12.f2119c.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0059, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0053 A[ExcHandler: all (r0v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x0023] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo5092c(com.igexin.push.extension.distribution.basic.p046g.p047a.C0753a r13) {
        /*
            r12 = this;
            r4 = 0
            r0 = 1
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "EXT-download-DownloaderDatabase|delete task:"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r13.mo5067b()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.igexin.p012b.p013a.p019c.ActivityC0460a.m1698b(r2)
            android.database.sqlite.SQLiteDatabase r2 = r12.f2119c
            r2.beginTransaction()
            android.database.sqlite.SQLiteDatabase r2 = r12.f2119c     // Catch:{ Throwable -> 0x004b, all -> 0x0053 }
            java.lang.String r3 = "download"
            java.lang.String r6 = "id = ? "
            r7 = 1
            java.lang.String[] r7 = new java.lang.String[r7]     // Catch:{ Throwable -> 0x004b, all -> 0x0053 }
            r8 = 0
            long r10 = r13.mo5062a()     // Catch:{ Throwable -> 0x004b, all -> 0x0053 }
            java.lang.String r9 = java.lang.String.valueOf(r10)     // Catch:{ Throwable -> 0x004b, all -> 0x0053 }
            r7[r8] = r9     // Catch:{ Throwable -> 0x004b, all -> 0x0053 }
            int r2 = r2.delete(r3, r6, r7)     // Catch:{ Throwable -> 0x004b, all -> 0x0053 }
            long r2 = (long) r2
            android.database.sqlite.SQLiteDatabase r6 = r12.f2119c     // Catch:{ Throwable -> 0x005c, all -> 0x0053 }
            r6.setTransactionSuccessful()     // Catch:{ Throwable -> 0x005c, all -> 0x0053 }
            android.database.sqlite.SQLiteDatabase r6 = r12.f2119c
            r6.endTransaction()
        L_0x0046:
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x005a
        L_0x004a:
            return r0
        L_0x004b:
            r2 = move-exception
            r2 = r4
        L_0x004d:
            android.database.sqlite.SQLiteDatabase r6 = r12.f2119c
            r6.endTransaction()
            goto L_0x0046
        L_0x0053:
            r0 = move-exception
            android.database.sqlite.SQLiteDatabase r1 = r12.f2119c
            r1.endTransaction()
            throw r0
        L_0x005a:
            r0 = r1
            goto L_0x004a
        L_0x005c:
            r6 = move-exception
            goto L_0x004d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.p046g.p048b.C0759b.mo5092c(com.igexin.push.extension.distribution.basic.g.a.a):boolean");
    }
}
