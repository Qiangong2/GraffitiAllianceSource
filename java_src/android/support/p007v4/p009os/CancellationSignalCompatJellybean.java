package android.support.p007v4.p009os;

import android.os.CancellationSignal;

/* access modifiers changed from: package-private */
/* renamed from: android.support.v4.os.CancellationSignalCompatJellybean */
public class CancellationSignalCompatJellybean {
    CancellationSignalCompatJellybean() {
    }

    public static Object create() {
        return new CancellationSignal();
    }

    public static void cancel(Object cancellationSignalObj) {
        ((CancellationSignal) cancellationSignalObj).cancel();
    }
}
