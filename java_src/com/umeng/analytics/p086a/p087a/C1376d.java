package com.umeng.analytics.p086a.p087a;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;

/* renamed from: com.umeng.analytics.a.a.d */
/* compiled from: UMCCDBUtils */
public class C1376d {

    /* renamed from: a */
    public static final String f3243a = "/data/data/";

    /* renamed from: b */
    public static final String f3244b = "/databases/cc/";

    /* renamed from: c */
    public static final String f3245c = "cc.db";

    /* renamed from: d */
    public static final int f3246d = 1;

    /* renamed from: e */
    public static final String f3247e = "Id";

    /* renamed from: f */
    public static final String f3248f = "INTEGER";

    /* renamed from: com.umeng.analytics.a.a.d$a */
    /* compiled from: UMCCDBUtils */
    public static class C1377a {

        /* renamed from: a */
        public static final String f3249a = "aggregated";

        /* renamed from: b */
        public static final String f3250b = "aggregated_cache";

        /* renamed from: com.umeng.analytics.a.a.d$a$a */
        /* compiled from: UMCCDBUtils */
        public static class C1378a {

            /* renamed from: a */
            public static final String f3251a = "key";

            /* renamed from: b */
            public static final String f3252b = "totalTimestamp";

            /* renamed from: c */
            public static final String f3253c = "value";

            /* renamed from: d */
            public static final String f3254d = "count";

            /* renamed from: e */
            public static final String f3255e = "label";

            /* renamed from: f */
            public static final String f3256f = "timeWindowNum";
        }

        /* renamed from: com.umeng.analytics.a.a.d$a$b */
        /* compiled from: UMCCDBUtils */
        public static class C1379b {

            /* renamed from: a */
            public static final String f3257a = "TEXT";

            /* renamed from: b */
            public static final String f3258b = "TEXT";

            /* renamed from: c */
            public static final String f3259c = "INTEGER";

            /* renamed from: d */
            public static final String f3260d = "INTEGER";

            /* renamed from: e */
            public static final String f3261e = "TEXT";

            /* renamed from: f */
            public static final String f3262f = "TEXT";
        }
    }

    /* renamed from: com.umeng.analytics.a.a.d$b */
    /* compiled from: UMCCDBUtils */
    public static class C1380b {

        /* renamed from: a */
        public static final String f3263a = "limitedck";

        /* renamed from: com.umeng.analytics.a.a.d$b$a */
        /* compiled from: UMCCDBUtils */
        public static class C1381a {

            /* renamed from: a */
            public static final String f3264a = "ck";
        }

        /* renamed from: com.umeng.analytics.a.a.d$b$b */
        /* compiled from: UMCCDBUtils */
        public static class C1382b {

            /* renamed from: a */
            public static final String f3265a = "TEXT";
        }
    }

    /* renamed from: com.umeng.analytics.a.a.d$c */
    /* compiled from: UMCCDBUtils */
    public static class C1383c {

        /* renamed from: a */
        public static final String f3266a = "system";

        /* renamed from: com.umeng.analytics.a.a.d$c$a */
        /* compiled from: UMCCDBUtils */
        public static class C1384a {

            /* renamed from: a */
            public static final String f3267a = "key";

            /* renamed from: b */
            public static final String f3268b = "timeStamp";

            /* renamed from: c */
            public static final String f3269c = "count";

            /* renamed from: d */
            public static final String f3270d = "label";
        }

        /* renamed from: com.umeng.analytics.a.a.d$c$b */
        /* compiled from: UMCCDBUtils */
        public static class C1385b {

            /* renamed from: a */
            public static final String f3271a = "TEXT";

            /* renamed from: b */
            public static final String f3272b = "INTEGER";

            /* renamed from: c */
            public static final String f3273c = "INTEGER";

            /* renamed from: d */
            public static final String f3274d = "TEXT";
        }
    }

    /* renamed from: a */
    public static String m5102a(Context context) {
        return "/data/data/" + context.getPackageName() + f3244b;
    }

    /* renamed from: a */
    public static String m5103a(List<String> list) {
        return TextUtils.join("!", list);
    }

    /* renamed from: a */
    public static JSONArray m5104a(String str) {
        String[] split = str.split("!");
        JSONArray jSONArray = new JSONArray();
        for (String str2 : split) {
            jSONArray.put(str2);
        }
        return jSONArray;
    }

    /* renamed from: b */
    public static List<String> m5105b(String str) {
        return new ArrayList(Arrays.asList(str.split("!")));
    }

    /* renamed from: b */
    public static List<String> m5106b(List<String> list) {
        ArrayList arrayList = new ArrayList();
        try {
            for (String str : list) {
                if (Collections.frequency(arrayList, str) < 1) {
                    arrayList.add(str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
