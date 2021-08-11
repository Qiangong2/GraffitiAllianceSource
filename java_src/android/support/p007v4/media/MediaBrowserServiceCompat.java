package android.support.p007v4.media;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p007v4.media.IMediaBrowserServiceCompat;
import android.support.p007v4.media.MediaBrowserCompat;
import android.support.p007v4.media.session.MediaSessionCompat;
import android.support.p007v4.p009os.ResultReceiver;
import android.support.p007v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;

/* renamed from: android.support.v4.media.MediaBrowserServiceCompat */
public abstract class MediaBrowserServiceCompat extends Service {
    private static final boolean DBG = false;
    public static final String KEY_MEDIA_ITEM = "media_item";
    public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserServiceCompat";
    private static final String TAG = "MediaBrowserServiceCompat";
    private ServiceBinder mBinder;
    private final ArrayMap<IBinder, ConnectionRecord> mConnections = new ArrayMap<>();
    private final Handler mHandler = new Handler();
    MediaSessionCompat.Token mSession;

    @Nullable
    public abstract BrowserRoot onGetRoot(@NonNull String str, int i, @Nullable Bundle bundle);

    public abstract void onLoadChildren(@NonNull String str, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result);

    /* access modifiers changed from: private */
    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$ConnectionRecord */
    public class ConnectionRecord {
        IMediaBrowserServiceCompatCallbacks callbacks;
        String pkg;
        BrowserRoot root;
        Bundle rootHints;
        HashSet<String> subscriptions;

        private ConnectionRecord() {
            this.subscriptions = new HashSet<>();
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$Result */
    public class Result<T> {
        private Object mDebug;
        private boolean mDetachCalled;
        private boolean mSendResultCalled;

        Result(Object debug) {
            this.mDebug = debug;
        }

        public void sendResult(T result) {
            if (this.mSendResultCalled) {
                throw new IllegalStateException("sendResult() called twice for: " + this.mDebug);
            }
            this.mSendResultCalled = true;
            onResultSent(result);
        }

        public void detach() {
            if (this.mDetachCalled) {
                throw new IllegalStateException("detach() called when detach() had already been called for: " + this.mDebug);
            } else if (this.mSendResultCalled) {
                throw new IllegalStateException("detach() called when sendResult() had already been called for: " + this.mDebug);
            } else {
                this.mDetachCalled = true;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean isDone() {
            return this.mDetachCalled || this.mSendResultCalled;
        }

        /* access modifiers changed from: package-private */
        public void onResultSent(T t) {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$ServiceBinder */
    private class ServiceBinder extends IMediaBrowserServiceCompat.Stub {
        private ServiceBinder() {
        }

        @Override // android.support.p007v4.media.IMediaBrowserServiceCompat
        public void connect(final String pkg, final Bundle rootHints, final IMediaBrowserServiceCompatCallbacks callbacks) {
            final int uid = Binder.getCallingUid();
            if (!MediaBrowserServiceCompat.this.isValidPackage(pkg, uid)) {
                throw new IllegalArgumentException("Package/uid mismatch: uid=" + uid + " package=" + pkg);
            }
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable() {
                /* class android.support.p007v4.media.MediaBrowserServiceCompat.ServiceBinder.RunnableC01141 */

                public void run() {
                    IBinder b = callbacks.asBinder();
                    MediaBrowserServiceCompat.this.mConnections.remove(b);
                    ConnectionRecord connection = new ConnectionRecord();
                    connection.pkg = pkg;
                    connection.rootHints = rootHints;
                    connection.callbacks = callbacks;
                    connection.root = MediaBrowserServiceCompat.this.onGetRoot(pkg, uid, rootHints);
                    if (connection.root == null) {
                        Log.i(MediaBrowserServiceCompat.TAG, "No root for client " + pkg + " from service " + getClass().getName());
                        try {
                            callbacks.onConnectFailed();
                        } catch (RemoteException e) {
                            Log.w(MediaBrowserServiceCompat.TAG, "Calling onConnectFailed() failed. Ignoring. pkg=" + pkg);
                        }
                    } else {
                        try {
                            MediaBrowserServiceCompat.this.mConnections.put(b, connection);
                            if (MediaBrowserServiceCompat.this.mSession != null) {
                                callbacks.onConnect(connection.root.getRootId(), MediaBrowserServiceCompat.this.mSession, connection.root.getExtras());
                            }
                        } catch (RemoteException e2) {
                            Log.w(MediaBrowserServiceCompat.TAG, "Calling onConnect() failed. Dropping client. pkg=" + pkg);
                            MediaBrowserServiceCompat.this.mConnections.remove(b);
                        }
                    }
                }
            });
        }

        @Override // android.support.p007v4.media.IMediaBrowserServiceCompat
        public void disconnect(final IMediaBrowserServiceCompatCallbacks callbacks) {
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable() {
                /* class android.support.p007v4.media.MediaBrowserServiceCompat.ServiceBinder.RunnableC01152 */

                public void run() {
                    if (((ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.remove(callbacks.asBinder())) != null) {
                    }
                }
            });
        }

        @Override // android.support.p007v4.media.IMediaBrowserServiceCompat
        public void addSubscription(final String id, final IMediaBrowserServiceCompatCallbacks callbacks) {
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable() {
                /* class android.support.p007v4.media.MediaBrowserServiceCompat.ServiceBinder.RunnableC01163 */

                public void run() {
                    ConnectionRecord connection = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(callbacks.asBinder());
                    if (connection == null) {
                        Log.w(MediaBrowserServiceCompat.TAG, "addSubscription for callback that isn't registered id=" + id);
                    } else {
                        MediaBrowserServiceCompat.this.addSubscription(id, connection);
                    }
                }
            });
        }

        @Override // android.support.p007v4.media.IMediaBrowserServiceCompat
        public void removeSubscription(final String id, final IMediaBrowserServiceCompatCallbacks callbacks) {
            MediaBrowserServiceCompat.this.mHandler.post(new Runnable() {
                /* class android.support.p007v4.media.MediaBrowserServiceCompat.ServiceBinder.RunnableC01174 */

                public void run() {
                    ConnectionRecord connection = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(callbacks.asBinder());
                    if (connection == null) {
                        Log.w(MediaBrowserServiceCompat.TAG, "removeSubscription for callback that isn't registered id=" + id);
                    } else if (!connection.subscriptions.remove(id)) {
                        Log.w(MediaBrowserServiceCompat.TAG, "removeSubscription called for " + id + " which is not subscribed");
                    }
                }
            });
        }

        @Override // android.support.p007v4.media.IMediaBrowserServiceCompat
        public void getMediaItem(final String mediaId, final ResultReceiver receiver) {
            if (!TextUtils.isEmpty(mediaId) && receiver != null) {
                MediaBrowserServiceCompat.this.mHandler.post(new Runnable() {
                    /* class android.support.p007v4.media.MediaBrowserServiceCompat.ServiceBinder.RunnableC01185 */

                    public void run() {
                        MediaBrowserServiceCompat.this.performLoadItem(mediaId, receiver);
                    }
                });
            }
        }
    }

    public void onCreate() {
        super.onCreate();
        this.mBinder = new ServiceBinder();
    }

    public IBinder onBind(Intent intent) {
        if (SERVICE_INTERFACE.equals(intent.getAction())) {
            return this.mBinder;
        }
        return null;
    }

    public void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
    }

    public void onLoadItem(String itemId, Result<MediaBrowserCompat.MediaItem> result) {
        result.sendResult(null);
    }

    public void setSessionToken(final MediaSessionCompat.Token token) {
        if (token == null) {
            throw new IllegalArgumentException("Session token may not be null.");
        } else if (this.mSession != null) {
            throw new IllegalStateException("The session token has already been set.");
        } else {
            this.mSession = token;
            this.mHandler.post(new Runnable() {
                /* class android.support.p007v4.media.MediaBrowserServiceCompat.RunnableC01101 */

                public void run() {
                    for (IBinder key : MediaBrowserServiceCompat.this.mConnections.keySet()) {
                        ConnectionRecord connection = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(key);
                        try {
                            connection.callbacks.onConnect(connection.root.getRootId(), token, connection.root.getExtras());
                        } catch (RemoteException e) {
                            Log.w(MediaBrowserServiceCompat.TAG, "Connection for " + connection.pkg + " is no longer valid.");
                            MediaBrowserServiceCompat.this.mConnections.remove(key);
                        }
                    }
                }
            });
        }
    }

    @Nullable
    public MediaSessionCompat.Token getSessionToken() {
        return this.mSession;
    }

    public void notifyChildrenChanged(@NonNull final String parentId) {
        if (parentId == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        this.mHandler.post(new Runnable() {
            /* class android.support.p007v4.media.MediaBrowserServiceCompat.RunnableC01112 */

            public void run() {
                for (IBinder binder : MediaBrowserServiceCompat.this.mConnections.keySet()) {
                    ConnectionRecord connection = (ConnectionRecord) MediaBrowserServiceCompat.this.mConnections.get(binder);
                    if (connection.subscriptions.contains(parentId)) {
                        MediaBrowserServiceCompat.this.performLoadChildren(parentId, connection);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean isValidPackage(String pkg, int uid) {
        if (pkg == null) {
            return false;
        }
        for (String str : getPackageManager().getPackagesForUid(uid)) {
            if (str.equals(pkg)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addSubscription(String id, ConnectionRecord connection) {
        connection.subscriptions.add(id);
        performLoadChildren(id, connection);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void performLoadChildren(final String parentId, final ConnectionRecord connection) {
        Result<List<MediaBrowserCompat.MediaItem>> result = new Result<List<MediaBrowserCompat.MediaItem>>(parentId) {
            /* class android.support.p007v4.media.MediaBrowserServiceCompat.C01123 */

            /* access modifiers changed from: package-private */
            public void onResultSent(List<MediaBrowserCompat.MediaItem> list) {
                if (list == null) {
                    throw new IllegalStateException("onLoadChildren sent null list for id " + parentId);
                } else if (MediaBrowserServiceCompat.this.mConnections.get(connection.callbacks.asBinder()) == connection) {
                    try {
                        connection.callbacks.onLoadChildren(parentId, list);
                    } catch (RemoteException e) {
                        Log.w(MediaBrowserServiceCompat.TAG, "Calling onLoadChildren() failed for id=" + parentId + " package=" + connection.pkg);
                    }
                }
            }
        };
        onLoadChildren(parentId, result);
        if (!result.isDone()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + connection.pkg + " id=" + parentId);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void performLoadItem(String itemId, final ResultReceiver receiver) {
        Result<MediaBrowserCompat.MediaItem> result = new Result<MediaBrowserCompat.MediaItem>(itemId) {
            /* class android.support.p007v4.media.MediaBrowserServiceCompat.C01134 */

            /* access modifiers changed from: package-private */
            public void onResultSent(MediaBrowserCompat.MediaItem item) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM, item);
                receiver.send(0, bundle);
            }
        };
        onLoadItem(itemId, result);
        if (!result.isDone()) {
            throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + itemId);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$BrowserRoot */
    public static final class BrowserRoot {
        private final Bundle mExtras;
        private final String mRootId;

        public BrowserRoot(@NonNull String rootId, @Nullable Bundle extras) {
            if (rootId == null) {
                throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
            }
            this.mRootId = rootId;
            this.mExtras = extras;
        }

        public String getRootId() {
            return this.mRootId;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }
    }
}
