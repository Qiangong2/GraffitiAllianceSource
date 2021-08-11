package com.unity3d.player;

import android.os.Build;

/* renamed from: com.unity3d.player.h */
public final class C1617h {

    /* renamed from: a */
    static final boolean f4140a = (Build.VERSION.SDK_INT >= 19);

    /* renamed from: b */
    static final boolean f4141b = (Build.VERSION.SDK_INT >= 21);

    /* renamed from: c */
    static final boolean f4142c;

    /* renamed from: d */
    static final AbstractC1612c f4143d;

    static {
        boolean z = true;
        if (Build.VERSION.SDK_INT < 23) {
            z = false;
        }
        f4142c = z;
        f4143d = z ? new C1615f() : null;
    }
}
