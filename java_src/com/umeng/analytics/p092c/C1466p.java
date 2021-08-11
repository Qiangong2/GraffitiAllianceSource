package com.umeng.analytics.p092c;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.p093d.C1488m;

/* renamed from: com.umeng.analytics.c.p */
/* compiled from: UUIDTracker */
public class C1466p extends AbstractC1449a {

    /* renamed from: a */
    private static final String f3609a = "uuid";

    /* renamed from: e */
    private static final String f3610e = "yosuid";

    /* renamed from: f */
    private static final String f3611f = "23346339";

    /* renamed from: b */
    private Context f3612b = null;

    /* renamed from: c */
    private String f3613c = null;

    /* renamed from: d */
    private String f3614d = null;

    public C1466p(Context context) {
        super(f3609a);
        this.f3612b = context;
        this.f3613c = null;
        this.f3614d = null;
    }

    @Override // com.umeng.analytics.p092c.AbstractC1449a
    /* renamed from: f */
    public String mo8554f() {
        SharedPreferences a;
        SharedPreferences.Editor edit;
        try {
            if (!(TextUtils.isEmpty(m5429a("ro.yunos.version", "")) || this.f3612b == null || (a = C1488m.m5522a(this.f3612b)) == null)) {
                String string = a.getString(f3610e, "");
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
                this.f3614d = m5430b(f3611f);
                if (!(TextUtils.isEmpty(this.f3614d) || this.f3612b == null || a == null || (edit = a.edit()) == null)) {
                    edit.putString(f3610e, this.f3614d).commit();
                }
                return this.f3614d;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0194, code lost:
        r1 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0195, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0162, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0163, code lost:
        r4 = null;
        r1 = r0;
        r0 = r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d9 A[SYNTHETIC, Splitter:B:31:0x00d9] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00de A[SYNTHETIC, Splitter:B:34:0x00de] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e3 A[SYNTHETIC, Splitter:B:37:0x00e3] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0111 A[SYNTHETIC, Splitter:B:56:0x0111] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0116 A[SYNTHETIC, Splitter:B:59:0x0116] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x011b A[SYNTHETIC, Splitter:B:62:0x011b] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0139 A[SYNTHETIC, Splitter:B:75:0x0139] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x013e A[SYNTHETIC, Splitter:B:78:0x013e] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0143 A[SYNTHETIC, Splitter:B:81:0x0143] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0162 A[ExcHandler: all (r1v28 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:13:0x00a7] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m5430b(java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 416
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.p092c.C1466p.m5430b(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static String m5429a(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }
}
