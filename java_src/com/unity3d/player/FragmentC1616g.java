package com.unity3d.player;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

/* renamed from: com.unity3d.player.g */
public final class FragmentC1616g extends Fragment {

    /* renamed from: a */
    private final Runnable f4139a;

    public FragmentC1616g() {
        this.f4139a = null;
    }

    public FragmentC1616g(Runnable runnable) {
        this.f4139a = runnable;
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.f4139a == null) {
            getFragmentManager().beginTransaction().remove(this).commit();
        } else {
            requestPermissions(getArguments().getStringArray("PermissionNames"), 15881);
        }
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 15881) {
            int i2 = 0;
            while (i2 < strArr.length && i2 < iArr.length) {
                C1614e.Log(4, strArr[i2] + (iArr[i2] == 0 ? " granted" : " denied"));
                i2++;
            }
            FragmentTransaction beginTransaction = getActivity().getFragmentManager().beginTransaction();
            beginTransaction.remove(this);
            beginTransaction.commit();
            this.f4139a.run();
        }
    }
}
