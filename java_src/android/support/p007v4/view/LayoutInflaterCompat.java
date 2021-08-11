package android.support.p007v4.view;

import android.os.Build;
import android.view.LayoutInflater;

/* renamed from: android.support.v4.view.LayoutInflaterCompat */
public class LayoutInflaterCompat {
    static final LayoutInflaterCompatImpl IMPL;

    /* access modifiers changed from: package-private */
    /* renamed from: android.support.v4.view.LayoutInflaterCompat$LayoutInflaterCompatImpl */
    public interface LayoutInflaterCompatImpl {
        void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory);
    }

    /* renamed from: android.support.v4.view.LayoutInflaterCompat$LayoutInflaterCompatImplBase */
    static class LayoutInflaterCompatImplBase implements LayoutInflaterCompatImpl {
        LayoutInflaterCompatImplBase() {
        }

        @Override // android.support.p007v4.view.LayoutInflaterCompat.LayoutInflaterCompatImpl
        public void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory factory) {
            LayoutInflaterCompatBase.setFactory(layoutInflater, factory);
        }
    }

    /* renamed from: android.support.v4.view.LayoutInflaterCompat$LayoutInflaterCompatImplV11 */
    static class LayoutInflaterCompatImplV11 extends LayoutInflaterCompatImplBase {
        LayoutInflaterCompatImplV11() {
        }

        @Override // android.support.p007v4.view.LayoutInflaterCompat.LayoutInflaterCompatImpl, android.support.p007v4.view.LayoutInflaterCompat.LayoutInflaterCompatImplBase
        public void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory factory) {
            LayoutInflaterCompatHC.setFactory(layoutInflater, factory);
        }
    }

    /* renamed from: android.support.v4.view.LayoutInflaterCompat$LayoutInflaterCompatImplV21 */
    static class LayoutInflaterCompatImplV21 extends LayoutInflaterCompatImplV11 {
        LayoutInflaterCompatImplV21() {
        }

        @Override // android.support.p007v4.view.LayoutInflaterCompat.LayoutInflaterCompatImpl, android.support.p007v4.view.LayoutInflaterCompat.LayoutInflaterCompatImplV11, android.support.p007v4.view.LayoutInflaterCompat.LayoutInflaterCompatImplBase
        public void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory factory) {
            LayoutInflaterCompatLollipop.setFactory(layoutInflater, factory);
        }
    }

    static {
        int version = Build.VERSION.SDK_INT;
        if (version >= 21) {
            IMPL = new LayoutInflaterCompatImplV21();
        } else if (version >= 11) {
            IMPL = new LayoutInflaterCompatImplV11();
        } else {
            IMPL = new LayoutInflaterCompatImplBase();
        }
    }

    private LayoutInflaterCompat() {
    }

    public static void setFactory(LayoutInflater inflater, LayoutInflaterFactory factory) {
        IMPL.setFactory(inflater, factory);
    }
}
