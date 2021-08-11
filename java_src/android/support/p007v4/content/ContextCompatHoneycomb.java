package android.support.p007v4.content;

import android.content.Context;
import android.content.Intent;
import java.io.File;

/* access modifiers changed from: package-private */
/* renamed from: android.support.v4.content.ContextCompatHoneycomb */
public class ContextCompatHoneycomb {
    ContextCompatHoneycomb() {
    }

    static void startActivities(Context context, Intent[] intents) {
        context.startActivities(intents);
    }

    public static File getObbDir(Context context) {
        return context.getObbDir();
    }
}
