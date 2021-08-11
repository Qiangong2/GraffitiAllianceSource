package com.unity3d.player;

import android.util.Log;

/* access modifiers changed from: package-private */
/* renamed from: com.unity3d.player.e */
public final class C1614e {

    /* renamed from: a */
    protected static boolean f4138a = false;

    protected static void Log(int i, String str) {
        if (!f4138a) {
            if (i == 6) {
                Log.e("Unity", str);
            }
            if (i == 5) {
                Log.w("Unity", str);
            }
        }
    }
}
