package com.igexin.push.extension.distribution.gbd.p061a.p063b;

import android.content.ContentValues;
import com.igexin.p012b.p022b.C0476a;
import com.igexin.push.core.C0617f;
import com.igexin.push.extension.distribution.gbd.p067c.C1067a;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.igexin.push.extension.distribution.gbd.a.b.i */
public class C1037i {
    /* renamed from: a */
    public static void m4195a(String str) {
        String a = C0476a.m1773a(str);
        if (C1069c.f2837n == null) {
            C1069c.f2837n = new HashMap();
        }
        if (!C1069c.f2837n.containsKey(a)) {
            C1069c.f2837n.put(a, str);
        }
    }

    /* renamed from: a */
    public static void m4196a(String str, int i, String str2, int i2) {
        if ((i != 1 && i != 2) || C1067a.f2764O) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("value", C0476a.m1773a(str));
            contentValues.put("t", str2);
            contentValues.put("type", Integer.valueOf(i));
            contentValues.put("status", Integer.valueOf(i2));
            C1069c.f2825b.mo5799a("look", contentValues);
        }
    }

    /* renamed from: a */
    public static void m4197a(Map<String, Object> map, int i, int i2) {
        if (map != null) {
            C0617f.m2395a().mo4619a(new C1038j((long) (i == 1 ? 120000 : i == 2 ? 180000 : 10000), map, i2, i));
        }
    }
}
