package android.support.p007v4.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* renamed from: android.support.v4.net.ConnectivityManagerCompatGingerbread */
class ConnectivityManagerCompatGingerbread {
    ConnectivityManagerCompatGingerbread() {
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager cm) {
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null) {
            return true;
        }
        switch (info.getType()) {
            case 0:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            default:
                return true;
            case 1:
                return false;
        }
    }
}
