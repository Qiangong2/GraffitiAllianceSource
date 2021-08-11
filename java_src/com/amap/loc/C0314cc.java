package com.amap.loc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.umeng.analytics.C1370a;

/* renamed from: com.amap.loc.cc */
/* compiled from: DB */
public class C0314cc {

    /* renamed from: a */
    private static C0314cc f653a = null;

    /* renamed from: b */
    private String f654b = "2.0.201501131131".replace(".", "");

    /* renamed from: c */
    private String f655c = null;

    /* renamed from: a */
    public static synchronized C0314cc m983a() {
        C0314cc ccVar;
        synchronized (C0314cc.class) {
            if (f653a == null) {
                f653a = new C0314cc();
            }
            ccVar = f653a;
        }
        return ccVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004f, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0057, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0058, code lost:
        if (0 != 0) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005a, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005d, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0057 A[ExcHandler: all (r0v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:2:0x000a] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m984a(android.database.sqlite.SQLiteDatabase r7, java.lang.String r8) {
        /*
            r6 = this;
            r2 = 0
            r1 = 1
            r0 = 0
            boolean r3 = android.text.TextUtils.isEmpty(r8)
            if (r3 == 0) goto L_0x000a
        L_0x0009:
            return r0
        L_0x000a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x004e, all -> 0x0057 }
            r3.<init>()     // Catch:{ Throwable -> 0x004e, all -> 0x0057 }
            java.lang.String r4 = "SELECT count(*) as c FROM sqlite_master WHERE type = 'table' AND name = '"
            r3.append(r4)     // Catch:{ Throwable -> 0x004e, all -> 0x0057 }
            java.lang.String r4 = r8.trim()     // Catch:{ Throwable -> 0x004e, all -> 0x0057 }
            java.lang.StringBuilder r4 = r3.append(r4)     // Catch:{ Throwable -> 0x004e, all -> 0x0057 }
            java.lang.String r5 = r6.f654b     // Catch:{ Throwable -> 0x004e, all -> 0x0057 }
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ Throwable -> 0x004e, all -> 0x0057 }
            java.lang.String r5 = "' "
            r4.append(r5)     // Catch:{ Throwable -> 0x004e, all -> 0x0057 }
            java.lang.String r4 = r3.toString()     // Catch:{ Throwable -> 0x004e, all -> 0x0057 }
            r5 = 0
            android.database.Cursor r2 = r7.rawQuery(r4, r5)     // Catch:{ Throwable -> 0x004e, all -> 0x0057 }
            if (r2 == 0) goto L_0x0040
            boolean r4 = r2.moveToFirst()     // Catch:{ Throwable -> 0x005e, all -> 0x0057 }
            if (r4 == 0) goto L_0x0040
            r4 = 0
            int r4 = r2.getInt(r4)     // Catch:{ Throwable -> 0x005e, all -> 0x0057 }
            if (r4 <= 0) goto L_0x0040
            r0 = r1
        L_0x0040:
            r4 = 0
            int r5 = r3.length()     // Catch:{ Throwable -> 0x005e, all -> 0x0057 }
            r3.delete(r4, r5)     // Catch:{ Throwable -> 0x005e, all -> 0x0057 }
            if (r2 == 0) goto L_0x0009
            r2.close()
            goto L_0x0009
        L_0x004e:
            r0 = move-exception
            r0 = r2
        L_0x0050:
            if (r0 == 0) goto L_0x0055
            r0.close()
        L_0x0055:
            r0 = r1
            goto L_0x0009
        L_0x0057:
            r0 = move-exception
            if (r2 == 0) goto L_0x005d
            r2.close()
        L_0x005d:
            throw r0
        L_0x005e:
            r0 = move-exception
            r0 = r2
            goto L_0x0050
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0314cc.m984a(android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x030a, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x030b, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0317, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0318, code lost:
        r2 = r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x030a A[ExcHandler: all (th java.lang.Throwable), Splitter:B:9:0x0012] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x031b A[LOOP:0: B:38:0x0090->B:116:0x031b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x017e A[EDGE_INSN: B:117:0x017e->B:56:0x017e ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x026d  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo3865a(android.content.Context r13) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 798
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0314cc.mo3865a(android.content.Context):void");
    }

    /* renamed from: a */
    public synchronized void mo3866a(Context context, int i) throws Exception {
        SQLiteDatabase sQLiteDatabase;
        Throwable th;
        String str;
        String[] strArr = null;
        synchronized (this) {
            if (context != null) {
                try {
                    sQLiteDatabase = context.openOrCreateDatabase("hmdb", 0, null);
                    try {
                        if (!m984a(sQLiteDatabase, "hist")) {
                            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                sQLiteDatabase.close();
                            }
                            SQLiteDatabase sQLiteDatabase2 = null;
                            if (0 != 0) {
                                if (sQLiteDatabase2.isOpen()) {
                                    sQLiteDatabase2.close();
                                }
                            }
                        } else {
                            switch (i) {
                                case 1:
                                    str = "time<?";
                                    strArr = new String[]{String.valueOf(C0331cr.m1156a() - C1370a.f3217i)};
                                    break;
                                case 2:
                                    str = "1";
                                    break;
                                default:
                                    str = null;
                                    break;
                            }
                            try {
                                sQLiteDatabase.delete("hist" + this.f654b, str, strArr);
                            } catch (Throwable th2) {
                                C0310c.m956a(th2, "DB", "clearHist");
                                String message = th2.getMessage();
                                if (TextUtils.isEmpty(message) || message.contains("no such table")) {
                                }
                            }
                            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                sQLiteDatabase.close();
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            C0310c.m956a(th, "DB", "clearHist p2");
                            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                sQLiteDatabase.close();
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            sQLiteDatabase.close();
                            throw th;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    sQLiteDatabase = null;
                    if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                        sQLiteDatabase.close();
                    }
                    throw th;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0166  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo3867a(android.content.Context r11, java.lang.String r12, java.lang.String r13, long r14) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 381
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0314cc.mo3867a(android.content.Context, java.lang.String, java.lang.String, long):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01c4  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01db  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo3868a(java.lang.String r11, com.amap.api.location.AMapLocation r12, java.lang.StringBuilder r13, android.content.Context r14) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 501
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0314cc.mo3868a(java.lang.String, com.amap.api.location.AMapLocation, java.lang.StringBuilder, android.content.Context):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d5, code lost:
        com.amap.loc.C0310c.m956a(r0, "DB", "fetchHm");
        r0 = r0.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ee, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x011e, code lost:
        r0 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x011e A[ExcHandler: all (th java.lang.Throwable), Splitter:B:12:0x0016] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo3869b(android.content.Context r12) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 301
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.loc.C0314cc.mo3869b(android.content.Context):void");
    }
}
