package android.support.p007v4.net;

import android.os.Build;
import java.net.Socket;
import java.net.SocketException;

/* renamed from: android.support.v4.net.TrafficStatsCompat */
public class TrafficStatsCompat {
    private static final TrafficStatsCompatImpl IMPL;

    /* renamed from: android.support.v4.net.TrafficStatsCompat$TrafficStatsCompatImpl */
    interface TrafficStatsCompatImpl {
        void clearThreadStatsTag();

        int getThreadStatsTag();

        void incrementOperationCount(int i);

        void incrementOperationCount(int i, int i2);

        void setThreadStatsTag(int i);

        void tagSocket(Socket socket) throws SocketException;

        void untagSocket(Socket socket) throws SocketException;
    }

    /* renamed from: android.support.v4.net.TrafficStatsCompat$BaseTrafficStatsCompatImpl */
    static class BaseTrafficStatsCompatImpl implements TrafficStatsCompatImpl {
        private ThreadLocal<SocketTags> mThreadSocketTags = new ThreadLocal<SocketTags>() {
            /* class android.support.p007v4.net.TrafficStatsCompat.BaseTrafficStatsCompatImpl.C01431 */

            /* access modifiers changed from: protected */
            @Override // java.lang.ThreadLocal
            public SocketTags initialValue() {
                return new SocketTags();
            }
        };

        /* access modifiers changed from: private */
        /* renamed from: android.support.v4.net.TrafficStatsCompat$BaseTrafficStatsCompatImpl$SocketTags */
        public static class SocketTags {
            public int statsTag;

            private SocketTags() {
                this.statsTag = -1;
            }
        }

        BaseTrafficStatsCompatImpl() {
        }

        @Override // android.support.p007v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void clearThreadStatsTag() {
            this.mThreadSocketTags.get().statsTag = -1;
        }

        @Override // android.support.p007v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public int getThreadStatsTag() {
            return this.mThreadSocketTags.get().statsTag;
        }

        @Override // android.support.p007v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void incrementOperationCount(int operationCount) {
        }

        @Override // android.support.p007v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void incrementOperationCount(int tag, int operationCount) {
        }

        @Override // android.support.p007v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void setThreadStatsTag(int tag) {
            this.mThreadSocketTags.get().statsTag = tag;
        }

        @Override // android.support.p007v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void tagSocket(Socket socket) {
        }

        @Override // android.support.p007v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void untagSocket(Socket socket) {
        }
    }

    /* renamed from: android.support.v4.net.TrafficStatsCompat$IcsTrafficStatsCompatImpl */
    static class IcsTrafficStatsCompatImpl implements TrafficStatsCompatImpl {
        IcsTrafficStatsCompatImpl() {
        }

        @Override // android.support.p007v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void clearThreadStatsTag() {
            TrafficStatsCompatIcs.clearThreadStatsTag();
        }

        @Override // android.support.p007v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public int getThreadStatsTag() {
            return TrafficStatsCompatIcs.getThreadStatsTag();
        }

        @Override // android.support.p007v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void incrementOperationCount(int operationCount) {
            TrafficStatsCompatIcs.incrementOperationCount(operationCount);
        }

        @Override // android.support.p007v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void incrementOperationCount(int tag, int operationCount) {
            TrafficStatsCompatIcs.incrementOperationCount(tag, operationCount);
        }

        @Override // android.support.p007v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void setThreadStatsTag(int tag) {
            TrafficStatsCompatIcs.setThreadStatsTag(tag);
        }

        @Override // android.support.p007v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void tagSocket(Socket socket) throws SocketException {
            TrafficStatsCompatIcs.tagSocket(socket);
        }

        @Override // android.support.p007v4.net.TrafficStatsCompat.TrafficStatsCompatImpl
        public void untagSocket(Socket socket) throws SocketException {
            TrafficStatsCompatIcs.untagSocket(socket);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new IcsTrafficStatsCompatImpl();
        } else {
            IMPL = new BaseTrafficStatsCompatImpl();
        }
    }

    public static void clearThreadStatsTag() {
        IMPL.clearThreadStatsTag();
    }

    public static int getThreadStatsTag() {
        return IMPL.getThreadStatsTag();
    }

    public static void incrementOperationCount(int operationCount) {
        IMPL.incrementOperationCount(operationCount);
    }

    public static void incrementOperationCount(int tag, int operationCount) {
        IMPL.incrementOperationCount(tag, operationCount);
    }

    public static void setThreadStatsTag(int tag) {
        IMPL.setThreadStatsTag(tag);
    }

    public static void tagSocket(Socket socket) throws SocketException {
        IMPL.tagSocket(socket);
    }

    public static void untagSocket(Socket socket) throws SocketException {
        IMPL.untagSocket(socket);
    }
}
