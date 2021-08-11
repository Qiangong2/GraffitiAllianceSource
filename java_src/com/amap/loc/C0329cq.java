package com.amap.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import java.lang.reflect.Method;

/* renamed from: com.amap.loc.cq */
/* compiled from: SPUtil */
public class C0329cq {

    /* renamed from: a */
    private static Method f786a;

    /* renamed from: a */
    public static void m1138a(Context context, String str, String str2, int i) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putInt(str2, i);
            m1142a(edit);
        } catch (Throwable th) {
            C0310c.m956a(th, "SPUtil", "setPrefsInt");
        }
    }

    /* renamed from: a */
    public static void m1139a(Context context, String str, String str2, long j) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putLong(str2, j);
            m1142a(edit);
        } catch (Throwable th) {
            C0310c.m956a(th, "SPUtil", "setPrefsLong");
        }
    }

    /* renamed from: a */
    public static void m1140a(Context context, String str, String str2, String str3) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString(str2, str3);
            m1142a(edit);
        } catch (Throwable th) {
            C0310c.m956a(th, "SPUtil", "setPrefsInt");
        }
    }

    /* renamed from: a */
    public static void m1141a(Context context, String str, String str2, boolean z) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putBoolean(str2, z);
            m1142a(edit);
        } catch (Throwable th) {
            C0310c.m956a(th, "SPUtil", "updatePrefsBoolean");
        }
    }

    /* renamed from: a */
    public static void m1142a(SharedPreferences.Editor editor) {
        if (editor != null) {
            if (Build.VERSION.SDK_INT >= 9) {
                try {
                    if (f786a == null) {
                        f786a = SharedPreferences.Editor.class.getDeclaredMethod("apply", new Class[0]);
                    }
                    f786a.invoke(editor, new Object[0]);
                } catch (Throwable th) {
                    C0310c.m956a(th, "SPUtil", "applySharedPreference");
                    m1146b(editor);
                }
            } else {
                m1146b(editor);
            }
        }
    }

    /* renamed from: b */
    public static int m1143b(Context context, String str, String str2, int i) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i);
        } catch (Throwable th) {
            C0310c.m956a(th, "SPUtil", "getPrefsInt");
            return i;
        }
    }

    /* renamed from: b */
    public static long m1144b(Context context, String str, String str2, long j) {
        try {
            return context.getSharedPreferences(str, 0).getLong(str2, j);
        } catch (Throwable th) {
            C0310c.m956a(th, "SPUtil", "getPrefsLong");
            return j;
        }
    }

    /* renamed from: b */
    public static String m1145b(Context context, String str, String str2, String str3) {
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th) {
            C0310c.m956a(th, "SPUtil", "getPrefsInt");
            return str3;
        }
    }

    /* renamed from: b */
    private static void m1146b(final SharedPreferences.Editor editor) {
        try {
            new AsyncTask<Void, Void, Void>() {
                /* class com.amap.loc.C0329cq.AsyncTaskC03301 */

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public Void doInBackground(Void... voidArr) {
                    try {
                        if (editor == null) {
                            return null;
                        }
                        editor.commit();
                        return null;
                    } catch (Throwable th) {
                        C0310c.m956a(th, "SPUtil", "commit");
                        return null;
                    }
                }
            }.execute(null, null, null);
        } catch (Throwable th) {
            C0310c.m956a(th, "SPUtil", "commit1");
        }
    }

    /* renamed from: b */
    public static boolean m1147b(Context context, String str, String str2, boolean z) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, z);
        } catch (Throwable th) {
            C0310c.m956a(th, "SPUtil", "getPrefsBoolean");
            return z;
        }
    }
}
