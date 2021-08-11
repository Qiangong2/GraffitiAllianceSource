package com.wanmei.sdk.core.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.wanmei.sdk.core.util.i */
public class C1848i {

    /* renamed from: a */
    private static final ConcurrentHashMap<String, Pattern> f4598a = new ConcurrentHashMap<>();

    /* renamed from: a */
    public static String m6695a(String str, String str2) {
        Pattern compile;
        if (!m6696a(str2)) {
            if (f4598a.containsKey(str)) {
                compile = f4598a.get(str);
            } else {
                compile = Pattern.compile(str);
                f4598a.put(str, compile);
            }
            Matcher matcher = compile.matcher(str2);
            if (matcher.find()) {
                return matcher.groupCount() > 0 ? matcher.group(1) : matcher.group();
            }
        }
        return "";
    }

    /* renamed from: a */
    public static boolean m6696a(String str) {
        return str == null || str.length() == 0;
    }
}
