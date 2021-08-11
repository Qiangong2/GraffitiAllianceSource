package android.support.p007v4.content;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* access modifiers changed from: package-private */
/* renamed from: android.support.v4.content.ContextCompatJellybean */
public class ContextCompatJellybean {
    ContextCompatJellybean() {
    }

    public static void startActivities(Context context, Intent[] intents, Bundle options) {
        context.startActivities(intents, options);
    }
}
