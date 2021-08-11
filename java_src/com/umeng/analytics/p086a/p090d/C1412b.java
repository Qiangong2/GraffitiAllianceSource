package com.umeng.analytics.p086a.p090d;

import android.text.TextUtils;
import java.util.List;

/* renamed from: com.umeng.analytics.a.d.b */
/* compiled from: UMCCAggregatedRestrictionManager */
public class C1412b {

    /* access modifiers changed from: private */
    /* renamed from: com.umeng.analytics.a.d.b$a */
    /* compiled from: UMCCAggregatedRestrictionManager */
    public static class C1414a {

        /* renamed from: a */
        private static final C1412b f3341a = new C1412b();

        private C1414a() {
        }
    }

    private C1412b() {
    }

    /* renamed from: a */
    public static C1412b m5211a() {
        return C1414a.f3341a;
    }

    /* renamed from: a */
    public boolean mo8472a(String str) {
        if ("".equals(str)) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.getBytes().length < 160 && m5212a(str, 48);
    }

    /* renamed from: b */
    public boolean mo8475b(String str) {
        if (!TextUtils.isEmpty(str) && str.length() < 16 && m5212a(str, 48)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo8473a(List<String> list) {
        if (list == null) {
            return false;
        }
        if (list.size() <= 1) {
            return true;
        }
        for (int i = 1; i < list.size(); i++) {
            if (TextUtils.isEmpty(list.get(i))) {
                return false;
            }
            if (!m5212a(list.get(i), 48)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m5212a(String str, int i) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) < i) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public int mo8474b() {
        return 8;
    }

    /* renamed from: c */
    public int mo8477c() {
        return 128;
    }

    /* renamed from: d */
    public int mo8478d() {
        return 512;
    }

    /* renamed from: b */
    public boolean mo8476b(List<String> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        int i = 0;
        for (String str : list) {
            i = str.getBytes().length + i;
        }
        if (i < 256) {
            return true;
        }
        return false;
    }
}
