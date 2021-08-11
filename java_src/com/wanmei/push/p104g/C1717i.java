package com.wanmei.push.p104g;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/* renamed from: com.wanmei.push.g.i */
public final class C1717i {
    /* renamed from: a */
    public static boolean m6391a() {
        return !(m6392b());
    }

    /* renamed from: b */
    public static boolean m6392b() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            return (properties.getProperty("ro.miui.ui.version.code", null) == null && properties.getProperty("ro.miui.ui.version.name", null) == null && properties.getProperty("ro.miui.internal.storage", null) == null) ? false : true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
