package android.support.p007v4.net;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

/* renamed from: android.support.v4.net.ConnectivityManagerCompat */
public class ConnectivityManagerCompat {
    private static final ConnectivityManagerCompatImpl IMPL;

    /* renamed from: android.support.v4.net.ConnectivityManagerCompat$ConnectivityManagerCompatImpl */
    interface ConnectivityManagerCompatImpl {
        boolean isActiveNetworkMetered(ConnectivityManager connectivityManager);
    }

    /* renamed from: android.support.v4.net.ConnectivityManagerCompat$BaseConnectivityManagerCompatImpl */
    static class BaseConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl {
        BaseConnectivityManagerCompatImpl() {
        }

        @Override // android.support.p007v4.net.ConnectivityManagerCompat.ConnectivityManagerCompatImpl
        public boolean isActiveNetworkMetered(ConnectivityManager cm) {
            NetworkInfo info = cm.getActiveNetworkInfo();
            if (info == null) {
                return true;
            }
            switch (info.getType()) {
                case 0:
                default:
                    return true;
                case 1:
                    return false;
            }
        }
    }

    /* renamed from: android.support.v4.net.ConnectivityManagerCompat$GingerbreadConnectivityManagerCompatImpl */
    static class GingerbreadConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl {
        GingerbreadConnectivityManagerCompatImpl() {
        }

        @Override // android.support.p007v4.net.ConnectivityManagerCompat.ConnectivityManagerCompatImpl
        public boolean isActiveNetworkMetered(ConnectivityManager cm) {
            return ConnectivityManagerCompatGingerbread.isActiveNetworkMetered(cm);
        }
    }

    /* renamed from: android.support.v4.net.ConnectivityManagerCompat$HoneycombMR2ConnectivityManagerCompatImpl */
    static class HoneycombMR2ConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl {
        HoneycombMR2ConnectivityManagerCompatImpl() {
        }

        @Override // android.support.p007v4.net.ConnectivityManagerCompat.ConnectivityManagerCompatImpl
        public boolean isActiveNetworkMetered(ConnectivityManager cm) {
            return ConnectivityManagerCompatHoneycombMR2.isActiveNetworkMetered(cm);
        }
    }

    /* renamed from: android.support.v4.net.ConnectivityManagerCompat$JellyBeanConnectivityManagerCompatImpl */
    static class JellyBeanConnectivityManagerCompatImpl implements ConnectivityManagerCompatImpl {
        JellyBeanConnectivityManagerCompatImpl() {
        }

        @Override // android.support.p007v4.net.ConnectivityManagerCompat.ConnectivityManagerCompatImpl
        public boolean isActiveNetworkMetered(ConnectivityManager cm) {
            return ConnectivityManagerCompatJellyBean.isActiveNetworkMetered(cm);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            IMPL = new JellyBeanConnectivityManagerCompatImpl();
        } else if (Build.VERSION.SDK_INT >= 13) {
            IMPL = new HoneycombMR2ConnectivityManagerCompatImpl();
        } else if (Build.VERSION.SDK_INT >= 8) {
            IMPL = new GingerbreadConnectivityManagerCompatImpl();
        } else {
            IMPL = new BaseConnectivityManagerCompatImpl();
        }
    }

    public static boolean isActiveNetworkMetered(ConnectivityManager cm) {
        return IMPL.isActiveNetworkMetered(cm);
    }

    public static NetworkInfo getNetworkInfoFromBroadcast(ConnectivityManager cm, Intent intent) {
        NetworkInfo info = (NetworkInfo) intent.getParcelableExtra("networkInfo");
        if (info != null) {
            return cm.getNetworkInfo(info.getType());
        }
        return null;
    }
}
