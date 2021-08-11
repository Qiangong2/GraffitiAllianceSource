package com.wanmei.push.p100d;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

/* renamed from: com.wanmei.push.d.b */
public class C1678b {

    /* renamed from: a */
    private static final String f4266a = C1678b.class.getSimpleName();

    /* renamed from: a */
    public static String m6275a(Context context) {
        String sb;
        String str = "db/";
        if ("mounted".equals(Environment.getExternalStorageState())) {
            StringBuilder append = new StringBuilder().append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/perfectPush/push/");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb = append.append(str).toString();
        } else {
            StringBuilder append2 = new StringBuilder().append(context.getDir(context.getPackageName(), 0).getAbsolutePath()).append("/perfectPush/push/");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb = append2.append(str).toString();
        }
        if (sb == null) {
            throw new IllegalArgumentException("createNewDir dirPath is Null");
        }
        File file = new File(sb);
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            file.mkdir();
        }
        return sb;
    }
}
