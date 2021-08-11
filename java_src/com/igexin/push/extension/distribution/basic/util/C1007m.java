package com.igexin.push.extension.distribution.basic.util;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.igexin.push.core.C0618g;

/* renamed from: com.igexin.push.extension.distribution.basic.util.m */
public class C1007m {
    /* renamed from: a */
    public static Bitmap m4043a(Drawable drawable) {
        if (drawable != null) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        return null;
    }

    /* renamed from: a */
    public static Drawable m4044a(String str) {
        PackageManager packageManager = C0618g.f1635f.getPackageManager();
        try {
            return packageManager.getApplicationInfo(str, 0).loadIcon(packageManager);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    /* renamed from: b */
    public static Bitmap m4045b(String str) {
        if (str != null) {
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(str);
                if (decodeFile != null) {
                    return decodeFile;
                }
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
