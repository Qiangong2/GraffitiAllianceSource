package com.igexin.push.extension.distribution.gbd.p076i;

import android.app.ActivityManager;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.igexin.push.extension.distribution.gbd.p067c.C1069c;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: com.igexin.push.extension.distribution.gbd.i.o */
public class C1126o {
    /* renamed from: a */
    private static int m4623a(String str, String str2) {
        int length = str.split(str2).length - 1;
        if (length > 0) {
            return length;
        }
        return 0;
    }

    /* renamed from: a */
    private static String m4624a(int i) {
        String str;
        try {
            str = m4625a(String.format("/proc/%d/cmdline", Integer.valueOf(i))).trim();
        } catch (Exception e) {
            C1115d.m4558a(e);
            str = null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            return m4625a(String.format("/proc/%d/stat", Integer.valueOf(i))).split("\\s+")[1].replace("(", "").replace(")", "");
        } catch (Exception e2) {
            C1115d.m4558a(e2);
            return str;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004a A[SYNTHETIC, Splitter:B:26:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004f A[SYNTHETIC, Splitter:B:29:0x004f] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m4625a(java.lang.String r6) {
        /*
            r1 = 0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0045 }
            r5.<init>()     // Catch:{ all -> 0x0045 }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ all -> 0x0045 }
            r2.<init>(r6)     // Catch:{ all -> 0x0045 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x005d }
            r3.<init>(r2)     // Catch:{ all -> 0x005d }
            java.lang.String r4 = r3.readLine()     // Catch:{ all -> 0x0060 }
            java.lang.String r0 = ""
        L_0x0016:
            if (r4 == 0) goto L_0x0026
            java.lang.StringBuilder r0 = r5.append(r0)     // Catch:{ all -> 0x0060 }
            r0.append(r4)     // Catch:{ all -> 0x0060 }
            java.lang.String r0 = "\n"
            java.lang.String r4 = r3.readLine()     // Catch:{ all -> 0x0060 }
            goto L_0x0016
        L_0x0026:
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x0060 }
            if (r2 == 0) goto L_0x002f
            r2.close()     // Catch:{ Exception -> 0x0035 }
        L_0x002f:
            if (r3 == 0) goto L_0x0034
            r3.close()     // Catch:{ Exception -> 0x0040 }
        L_0x0034:
            return r0
        L_0x0035:
            r2 = move-exception
            com.igexin.push.extension.distribution.gbd.p076i.C1115d.m4558a(r2)     // Catch:{ Throwable -> 0x003a }
            goto L_0x002f
        L_0x003a:
            r0 = move-exception
            com.igexin.push.extension.distribution.gbd.p076i.C1115d.m4558a(r0)
            r0 = r1
            goto L_0x0034
        L_0x0040:
            r2 = move-exception
            com.igexin.push.extension.distribution.gbd.p076i.C1115d.m4558a(r2)
            goto L_0x0034
        L_0x0045:
            r0 = move-exception
            r2 = r1
            r3 = r1
        L_0x0048:
            if (r2 == 0) goto L_0x004d
            r2.close()     // Catch:{ Exception -> 0x0053 }
        L_0x004d:
            if (r3 == 0) goto L_0x0052
            r3.close()     // Catch:{ Exception -> 0x0058 }
        L_0x0052:
            throw r0
        L_0x0053:
            r2 = move-exception
            com.igexin.push.extension.distribution.gbd.p076i.C1115d.m4558a(r2)
            goto L_0x004d
        L_0x0058:
            r2 = move-exception
            com.igexin.push.extension.distribution.gbd.p076i.C1115d.m4558a(r2)
            goto L_0x0052
        L_0x005d:
            r0 = move-exception
            r3 = r1
            goto L_0x0048
        L_0x0060:
            r0 = move-exception
            goto L_0x0048
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.gbd.p076i.C1126o.m4625a(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    private static String m4626a(String str, boolean z) {
        String str2;
        String str3;
        try {
            if (!Pattern.compile("^([a-zA-Z]+[.][a-zA-Z]+)[.]*.*").matcher(str).find() || str.startsWith("com.android") || str.startsWith("android.process") || str.startsWith("org.")) {
                return null;
            }
            if (str.contains(":")) {
                String[] split = str.split(":");
                String str4 = split[0];
                str2 = split[1];
                str3 = str4;
            } else {
                str2 = null;
                str3 = str;
            }
            try {
                PackageInfo packageInfo = C1069c.f2824a.getPackageManager().getPackageInfo(str3, 0);
                if ((packageInfo.applicationInfo.flags & 1) == 0 || (packageInfo.applicationInfo.flags & 128) != 0) {
                    return (!z || str2 == null) ? str3 : str3 + ":" + str2;
                }
            } catch (Exception e) {
                C1115d.m4558a(e);
            }
            return null;
        } catch (Throwable th) {
            C1115d.m4558a(th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x013b A[SYNTHETIC, Splitter:B:79:0x013b] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0159 A[SYNTHETIC, Splitter:B:91:0x0159] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<java.lang.String[]> m4627a(java.lang.String r16, boolean r17, java.lang.String r18) {
        /*
        // Method dump skipped, instructions count: 359
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.gbd.p076i.C1126o.m4627a(java.lang.String, boolean, java.lang.String):java.util.ArrayList");
    }

    /* renamed from: a */
    private static List<String> m4628a() {
        try {
            ArrayList<String[]> a = m4627a("ps -P", true, "");
            if (a == null || a.isEmpty()) {
                return null;
            }
            if (a.isEmpty()) {
                return null;
            }
            ArrayList<String[]> a2 = m4627a("ps -P", false, a.get(0)[1]);
            if (a2 == null || a2.isEmpty()) {
                return null;
            }
            return m4629a(a2, (List<ActivityManager.RecentTaskInfo>) null);
        } catch (Exception e) {
            C1115d.m4558a(e);
            return null;
        }
    }

    /* renamed from: a */
    private static List<String> m4629a(ArrayList<String[]> arrayList, List<ActivityManager.RecentTaskInfo> list) {
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            Iterator<String[]> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(0, it.next()[9]);
            }
        } else {
            for (ActivityManager.RecentTaskInfo recentTaskInfo : list) {
                arrayList2.add(recentTaskInfo.baseIntent.getComponent().getPackageName());
            }
        }
        return arrayList2;
    }

    /* renamed from: a */
    public static List<String> m4630a(boolean z) {
        List<String> b = m4631b(z);
        if (b == null || b.isEmpty()) {
            b = m4628a();
        }
        if (b != null) {
            C1115d.m4559b("GBD_RAU", ">21 recent = " + b.toString());
        }
        return b;
    }

    /* renamed from: b */
    private static List<String> m4631b(boolean z) {
        ArrayList arrayList = new ArrayList();
        for (File file : new File("/proc").listFiles(new C1127p())) {
            try {
                try {
                    String a = m4624a(Integer.parseInt(file.getName()));
                    if (!TextUtils.isEmpty(a)) {
                        a = m4626a(a, z);
                    }
                    if (!TextUtils.isEmpty(a) && !arrayList.contains(a)) {
                        arrayList.add(a);
                    }
                } catch (Throwable th) {
                    C1115d.m4558a(th);
                }
            } catch (Exception e) {
            }
        }
        return arrayList;
    }
}
