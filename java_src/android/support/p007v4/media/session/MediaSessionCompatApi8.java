package android.support.p007v4.media.session;

import android.content.ComponentName;
import android.content.Context;
import android.media.AudioManager;

/* access modifiers changed from: package-private */
/* renamed from: android.support.v4.media.session.MediaSessionCompatApi8 */
public class MediaSessionCompatApi8 {
    MediaSessionCompatApi8() {
    }

    public static void registerMediaButtonEventReceiver(Context context, ComponentName mbr) {
        ((AudioManager) context.getSystemService("audio")).registerMediaButtonEventReceiver(mbr);
    }

    public static void unregisterMediaButtonEventReceiver(Context context, ComponentName mbr) {
        ((AudioManager) context.getSystemService("audio")).unregisterMediaButtonEventReceiver(mbr);
    }
}
