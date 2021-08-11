package com.wanmei.push.p104g;

import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.wanmei.push.g.k */
public final class C1719k {

    /* renamed from: a */
    private static final ConcurrentHashMap<String, Pattern> f4361a = new ConcurrentHashMap<>();

    /* renamed from: a */
    public static String m6393a(String str, String str2) {
        Pattern compile;
        if (!m6394a(str2)) {
            if (f4361a.containsKey(str)) {
                compile = f4361a.get(str);
            } else {
                compile = Pattern.compile(str);
                f4361a.put(str, compile);
            }
            Matcher matcher = compile.matcher(str2);
            if (matcher.find()) {
                return matcher.groupCount() > 0 ? matcher.group(1) : matcher.group();
            }
        }
        return "";
    }

    /* renamed from: a */
    public static boolean m6394a(String str) {
        return str == null || str.length() == 0 || str.equals("");
    }
}
