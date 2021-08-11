package com.igexin.push.util;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: com.igexin.push.util.q */
public class C1167q {
    /* renamed from: a */
    public static void m4792a(Context context, String str, Object obj) {
        SharedPreferences.Editor edit = context.getSharedPreferences("getui_sp", 0).edit();
        if (obj instanceof String) {
            edit.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Long) {
            edit.putLong(str, ((Long) obj).longValue());
        }
        edit.commit();
    }

    /* renamed from: b */
    public static Object m4793b(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("getui_sp", 0);
        return obj instanceof String ? sharedPreferences.getString(str, (String) obj) : obj instanceof Integer ? Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue())) : obj instanceof Boolean ? Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue())) : obj instanceof Float ? Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue())) : obj instanceof Long ? Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue())) : obj;
    }
}
