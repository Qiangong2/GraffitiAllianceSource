package android.support.p007v4.view;

import android.view.ViewGroup;

/* renamed from: android.support.v4.view.ViewGroupCompatHC */
class ViewGroupCompatHC {
    private ViewGroupCompatHC() {
    }

    public static void setMotionEventSplittingEnabled(ViewGroup group, boolean split) {
        group.setMotionEventSplittingEnabled(split);
    }
}
