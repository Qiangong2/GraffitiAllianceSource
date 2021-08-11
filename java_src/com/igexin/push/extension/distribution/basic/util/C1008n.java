package com.igexin.push.extension.distribution.basic.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.igexin.push.extension.distribution.basic.util.n */
public class C1008n {
    /* renamed from: a */
    private String m4046a(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 1) + "";
    }

    /* renamed from: a */
    public String mo5649a(Context context, String str, List<String> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(":");
        boolean z = false;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            Bundle bundle = applicationInfo.metaData;
            sb.append(m4046a(applicationInfo));
            if (bundle != null) {
                for (String str2 : bundle.keySet()) {
                    if (list.contains(str2)) {
                        z = true;
                        Object obj = bundle.get(str2);
                        sb.append("&");
                        sb.append(str2);
                        sb.append("?");
                        sb.append(obj.toString());
                    }
                    z = z;
                }
                if (z) {
                    return sb.toString();
                }
            }
        } catch (Throwable th) {
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [android.content.pm.ActivityInfo[]] */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.content.pm.ServiceInfo[]] */
    /* JADX WARN: Type inference failed for: r0v16, types: [android.content.pm.ActivityInfo[]] */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String mo5650a(android.content.Context r12, java.lang.String r13, java.util.List<java.lang.String> r14, int r15) {
        /*
        // Method dump skipped, instructions count: 190
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.util.C1008n.mo5650a(android.content.Context, java.lang.String, java.util.List, int):java.lang.String");
    }

    /* renamed from: a */
    public List<String> mo5651a(Context context) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(0);
        Collections.sort(installedApplications, new ApplicationInfo.DisplayNameComparator(packageManager));
        for (ApplicationInfo applicationInfo : installedApplications) {
            arrayList.add(applicationInfo.packageName);
        }
        return arrayList;
    }
}
