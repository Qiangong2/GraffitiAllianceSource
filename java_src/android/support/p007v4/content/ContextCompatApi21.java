package android.support.p007v4.content;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.io.File;

/* access modifiers changed from: package-private */
/* renamed from: android.support.v4.content.ContextCompatApi21 */
public class ContextCompatApi21 {
    ContextCompatApi21() {
    }

    public static Drawable getDrawable(Context context, int id) {
        return context.getDrawable(id);
    }

    public static File getNoBackupFilesDir(Context context) {
        return context.getNoBackupFilesDir();
    }

    public static File getCodeCacheDir(Context context) {
        return context.getCodeCacheDir();
    }
}
