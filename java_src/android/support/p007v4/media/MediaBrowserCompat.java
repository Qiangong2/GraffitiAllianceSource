package android.support.p007v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p007v4.media.IMediaBrowserServiceCompat;
import android.support.p007v4.media.IMediaBrowserServiceCompatCallbacks;
import android.support.p007v4.media.session.MediaSessionCompat;
import android.support.p007v4.p009os.ResultReceiver;
import android.support.p007v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* renamed from: android.support.v4.media.MediaBrowserCompat */
public final class MediaBrowserCompat {
    private final MediaBrowserImplBase mImpl;

    public MediaBrowserCompat(Context context, ComponentName serviceComponent, ConnectionCallback callback, Bundle rootHints) {
        this.mImpl = new MediaBrowserImplBase(context, serviceComponent, callback, rootHints);
    }

    public void connect() {
        this.mImpl.connect();
    }

    public void disconnect() {
        this.mImpl.disconnect();
    }

    public boolean isConnected() {
        return this.mImpl.isConnected();
    }

    @NonNull
    public ComponentName getServiceComponent() {
        return this.mImpl.getServiceComponent();
    }

    @NonNull
    public String getRoot() {
        return this.mImpl.getRoot();
    }

    @Nullable
    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    @NonNull
    public MediaSessionCompat.Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public void subscribe(@NonNull String parentId, @NonNull SubscriptionCallback callback) {
        this.mImpl.subscribe(parentId, callback);
    }

    public void unsubscribe(@NonNull String parentId) {
        this.mImpl.unsubscribe(parentId);
    }

    public void getItem(@NonNull String mediaId, @NonNull ItemCallback cb) {
        this.mImpl.getItem(mediaId, cb);
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem */
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() {
            /* class android.support.p007v4.media.MediaBrowserCompat.MediaItem.C01091 */

            @Override // android.os.Parcelable.Creator
            public MediaItem createFromParcel(Parcel in) {
                return new MediaItem(in);
            }

            @Override // android.os.Parcelable.Creator
            public MediaItem[] newArray(int size) {
                return new MediaItem[size];
            }
        };
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;
        private final MediaDescriptionCompat mDescription;
        private final int mFlags;

        @Retention(RetentionPolicy.SOURCE)
        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem$Flags */
        public @interface Flags {
        }

        public MediaItem(@NonNull MediaDescriptionCompat description, int flags) {
            if (description == null) {
                throw new IllegalArgumentException("description cannot be null");
            } else if (TextUtils.isEmpty(description.getMediaId())) {
                throw new IllegalArgumentException("description must have a non-empty media id");
            } else {
                this.mFlags = flags;
                this.mDescription = description;
            }
        }

        private MediaItem(Parcel in) {
            this.mFlags = in.readInt();
            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(in);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            out.writeInt(this.mFlags);
            this.mDescription.writeToParcel(out, flags);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("MediaItem{");
            sb.append("mFlags=").append(this.mFlags);
            sb.append(", mDescription=").append(this.mDescription);
            sb.append('}');
            return sb.toString();
        }

        public int getFlags() {
            return this.mFlags;
        }

        public boolean isBrowsable() {
            return (this.mFlags & 1) != 0;
        }

        public boolean isPlayable() {
            return (this.mFlags & 2) != 0;
        }

        @NonNull
        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        @NonNull
        public String getMediaId() {
            return this.mDescription.getMediaId();
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$ConnectionCallback */
    public static class ConnectionCallback {
        public void onConnected() {
        }

        public void onConnectionSuspended() {
        }

        public void onConnectionFailed() {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$SubscriptionCallback */
    public static abstract class SubscriptionCallback {
        public void onChildrenLoaded(@NonNull String parentId, @NonNull List<MediaItem> list) {
        }

        public void onError(@NonNull String parentId) {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$ItemCallback */
    public static abstract class ItemCallback {
        public void onItemLoaded(MediaItem item) {
        }

        public void onError(@NonNull String itemId) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase */
    public static class MediaBrowserImplBase {
        private static final int CONNECT_STATE_CONNECTED = 2;
        private static final int CONNECT_STATE_CONNECTING = 1;
        private static final int CONNECT_STATE_DISCONNECTED = 0;
        private static final int CONNECT_STATE_SUSPENDED = 3;
        private static final boolean DBG = false;
        private static final String TAG = "MediaBrowserCompat";
        private final ConnectionCallback mCallback;
        private final Context mContext;
        private Bundle mExtras;
        private final Handler mHandler = new Handler();
        private MediaSessionCompat.Token mMediaSessionToken;
        private final Bundle mRootHints;
        private String mRootId;
        private IMediaBrowserServiceCompat mServiceBinder;
        private IMediaBrowserServiceCompatCallbacks mServiceCallbacks;
        private final ComponentName mServiceComponent;
        private MediaServiceConnection mServiceConnection;
        private int mState = 0;
        private final ArrayMap<String, Subscription> mSubscriptions = new ArrayMap<>();

        public MediaBrowserImplBase(Context context, ComponentName serviceComponent, ConnectionCallback callback, Bundle rootHints) {
            if (context == null) {
                throw new IllegalArgumentException("context must not be null");
            } else if (serviceComponent == null) {
                throw new IllegalArgumentException("service component must not be null");
            } else if (callback == null) {
                throw new IllegalArgumentException("connection callback must not be null");
            } else {
                this.mContext = context;
                this.mServiceComponent = serviceComponent;
                this.mCallback = callback;
                this.mRootHints = rootHints;
            }
        }

        public void connect() {
            if (this.mState != 0) {
                throw new IllegalStateException("connect() called while not disconnected (state=" + getStateLabel(this.mState) + ")");
            } else if (this.mServiceBinder != null) {
                throw new RuntimeException("mServiceBinder should be null. Instead it is " + this.mServiceBinder);
            } else if (this.mServiceCallbacks != null) {
                throw new RuntimeException("mServiceCallbacks should be null. Instead it is " + this.mServiceCallbacks);
            } else {
                this.mState = 1;
                Intent intent = new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE);
                intent.setComponent(this.mServiceComponent);
                final MediaServiceConnection mediaServiceConnection = new MediaServiceConnection();
                this.mServiceConnection = mediaServiceConnection;
                boolean bound = false;
                try {
                    bound = this.mContext.bindService(intent, this.mServiceConnection, 1);
                } catch (Exception e) {
                    Log.e(TAG, "Failed binding to service " + this.mServiceComponent);
                }
                if (!bound) {
                    this.mHandler.post(new Runnable() {
                        /* class android.support.p007v4.media.MediaBrowserCompat.MediaBrowserImplBase.RunnableC01021 */

                        public void run() {
                            if (mediaServiceConnection == MediaBrowserImplBase.this.mServiceConnection) {
                                MediaBrowserImplBase.this.forceCloseConnection();
                                MediaBrowserImplBase.this.mCallback.onConnectionFailed();
                            }
                        }
                    });
                }
            }
        }

        public void disconnect() {
            if (this.mServiceCallbacks != null) {
                try {
                    this.mServiceBinder.disconnect(this.mServiceCallbacks);
                } catch (RemoteException e) {
                    Log.w(TAG, "RemoteException during connect for " + this.mServiceComponent);
                }
            }
            forceCloseConnection();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void forceCloseConnection() {
            if (this.mServiceConnection != null) {
                this.mContext.unbindService(this.mServiceConnection);
            }
            this.mState = 0;
            this.mServiceConnection = null;
            this.mServiceBinder = null;
            this.mServiceCallbacks = null;
            this.mRootId = null;
            this.mMediaSessionToken = null;
        }

        public boolean isConnected() {
            return this.mState == 2;
        }

        @NonNull
        public ComponentName getServiceComponent() {
            if (isConnected()) {
                return this.mServiceComponent;
            }
            throw new IllegalStateException("getServiceComponent() called while not connected (state=" + this.mState + ")");
        }

        @NonNull
        public String getRoot() {
            if (isConnected()) {
                return this.mRootId;
            }
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + getStateLabel(this.mState) + ")");
        }

        @Nullable
        public Bundle getExtras() {
            if (isConnected()) {
                return this.mExtras;
            }
            throw new IllegalStateException("getExtras() called while not connected (state=" + getStateLabel(this.mState) + ")");
        }

        @NonNull
        public MediaSessionCompat.Token getSessionToken() {
            if (isConnected()) {
                return this.mMediaSessionToken;
            }
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + ")");
        }

        public void subscribe(@NonNull String parentId, @NonNull SubscriptionCallback callback) {
            if (parentId == null) {
                throw new IllegalArgumentException("parentId is null");
            } else if (callback == null) {
                throw new IllegalArgumentException("callback is null");
            } else {
                Subscription sub = this.mSubscriptions.get(parentId);
                if (sub == null) {
                    sub = new Subscription(parentId);
                    this.mSubscriptions.put(parentId, sub);
                }
                sub.callback = callback;
                if (this.mState == 2) {
                    try {
                        this.mServiceBinder.addSubscription(parentId, this.mServiceCallbacks);
                    } catch (RemoteException e) {
                        Log.d(TAG, "addSubscription failed with RemoteException parentId=" + parentId);
                    }
                }
            }
        }

        public void unsubscribe(@NonNull String parentId) {
            if (TextUtils.isEmpty(parentId)) {
                throw new IllegalArgumentException("parentId is empty.");
            }
            Subscription sub = this.mSubscriptions.remove(parentId);
            if (this.mState == 2 && sub != null) {
                try {
                    this.mServiceBinder.removeSubscription(parentId, this.mServiceCallbacks);
                } catch (RemoteException e) {
                    Log.d(TAG, "removeSubscription failed with RemoteException parentId=" + parentId);
                }
            }
        }

        public void getItem(@NonNull final String mediaId, @NonNull final ItemCallback cb) {
            if (TextUtils.isEmpty(mediaId)) {
                throw new IllegalArgumentException("mediaId is empty.");
            } else if (cb == null) {
                throw new IllegalArgumentException("cb is null.");
            } else if (this.mState != 2) {
                Log.i(TAG, "Not connected, unable to retrieve the MediaItem.");
                this.mHandler.post(new Runnable() {
                    /* class android.support.p007v4.media.MediaBrowserCompat.MediaBrowserImplBase.RunnableC01032 */

                    public void run() {
                        cb.onError(mediaId);
                    }
                });
            } else {
                try {
                    this.mServiceBinder.getMediaItem(mediaId, new ResultReceiver(this.mHandler) {
                        /* class android.support.p007v4.media.MediaBrowserCompat.MediaBrowserImplBase.C01043 */

                        /* access modifiers changed from: protected */
                        @Override // android.support.p007v4.p009os.ResultReceiver
                        public void onReceiveResult(int resultCode, Bundle resultData) {
                            if (resultCode != 0 || resultData == null || !resultData.containsKey(MediaBrowserServiceCompat.KEY_MEDIA_ITEM)) {
                                cb.onError(mediaId);
                                return;
                            }
                            Parcelable item = resultData.getParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
                            if (!(item instanceof MediaItem)) {
                                cb.onError(mediaId);
                            } else {
                                cb.onItemLoaded((MediaItem) item);
                            }
                        }
                    });
                } catch (RemoteException e) {
                    Log.i(TAG, "Remote error getting media item.");
                    this.mHandler.post(new Runnable() {
                        /* class android.support.p007v4.media.MediaBrowserCompat.MediaBrowserImplBase.RunnableC01054 */

                        public void run() {
                            cb.onError(mediaId);
                        }
                    });
                }
            }
        }

        /* access modifiers changed from: private */
        public static String getStateLabel(int state) {
            switch (state) {
                case 0:
                    return "CONNECT_STATE_DISCONNECTED";
                case 1:
                    return "CONNECT_STATE_CONNECTING";
                case 2:
                    return "CONNECT_STATE_CONNECTED";
                case 3:
                    return "CONNECT_STATE_SUSPENDED";
                default:
                    return "UNKNOWN/" + state;
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void onServiceConnected(final IMediaBrowserServiceCompatCallbacks callback, final String root, final MediaSessionCompat.Token session, final Bundle extra) {
            this.mHandler.post(new Runnable() {
                /* class android.support.p007v4.media.MediaBrowserCompat.MediaBrowserImplBase.RunnableC01065 */

                public void run() {
                    if (MediaBrowserImplBase.this.isCurrent(callback, "onConnect")) {
                        if (MediaBrowserImplBase.this.mState != 1) {
                            Log.w(MediaBrowserImplBase.TAG, "onConnect from service while mState=" + MediaBrowserImplBase.getStateLabel(MediaBrowserImplBase.this.mState) + "... ignoring");
                            return;
                        }
                        MediaBrowserImplBase.this.mRootId = root;
                        MediaBrowserImplBase.this.mMediaSessionToken = session;
                        MediaBrowserImplBase.this.mExtras = extra;
                        MediaBrowserImplBase.this.mState = 2;
                        MediaBrowserImplBase.this.mCallback.onConnected();
                        for (String id : MediaBrowserImplBase.this.mSubscriptions.keySet()) {
                            try {
                                MediaBrowserImplBase.this.mServiceBinder.addSubscription(id, MediaBrowserImplBase.this.mServiceCallbacks);
                            } catch (RemoteException e) {
                                Log.d(MediaBrowserImplBase.TAG, "addSubscription failed with RemoteException parentId=" + id);
                            }
                        }
                    }
                }
            });
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void onConnectionFailed(final IMediaBrowserServiceCompatCallbacks callback) {
            this.mHandler.post(new Runnable() {
                /* class android.support.p007v4.media.MediaBrowserCompat.MediaBrowserImplBase.RunnableC01076 */

                public void run() {
                    Log.e(MediaBrowserImplBase.TAG, "onConnectFailed for " + MediaBrowserImplBase.this.mServiceComponent);
                    if (MediaBrowserImplBase.this.isCurrent(callback, "onConnectFailed")) {
                        if (MediaBrowserImplBase.this.mState != 1) {
                            Log.w(MediaBrowserImplBase.TAG, "onConnect from service while mState=" + MediaBrowserImplBase.getStateLabel(MediaBrowserImplBase.this.mState) + "... ignoring");
                            return;
                        }
                        MediaBrowserImplBase.this.forceCloseConnection();
                        MediaBrowserImplBase.this.mCallback.onConnectionFailed();
                    }
                }
            });
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void onLoadChildren(final IMediaBrowserServiceCompatCallbacks callback, final String parentId, final List list) {
            this.mHandler.post(new Runnable() {
                /* class android.support.p007v4.media.MediaBrowserCompat.MediaBrowserImplBase.RunnableC01087 */

                public void run() {
                    if (MediaBrowserImplBase.this.isCurrent(callback, "onLoadChildren")) {
                        List<MediaItem> data = list;
                        if (data == null) {
                            data = Collections.emptyList();
                        }
                        Subscription subscription = (Subscription) MediaBrowserImplBase.this.mSubscriptions.get(parentId);
                        if (subscription != null) {
                            subscription.callback.onChildrenLoaded(parentId, data);
                        }
                    }
                }
            });
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private boolean isCurrent(IMediaBrowserServiceCompatCallbacks callback, String funcName) {
            if (this.mServiceCallbacks == callback) {
                return true;
            }
            if (this.mState != 0) {
                Log.i(TAG, funcName + " for " + this.mServiceComponent + " with mServiceConnection=" + this.mServiceCallbacks + " this=" + this);
            }
            return false;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private ServiceCallbacks getNewServiceCallbacks() {
            return new ServiceCallbacks(this);
        }

        /* access modifiers changed from: package-private */
        public void dump() {
            Log.d(TAG, "MediaBrowserCompat...");
            Log.d(TAG, "  mServiceComponent=" + this.mServiceComponent);
            Log.d(TAG, "  mCallback=" + this.mCallback);
            Log.d(TAG, "  mRootHints=" + this.mRootHints);
            Log.d(TAG, "  mState=" + getStateLabel(this.mState));
            Log.d(TAG, "  mServiceConnection=" + this.mServiceConnection);
            Log.d(TAG, "  mServiceBinder=" + this.mServiceBinder);
            Log.d(TAG, "  mServiceCallbacks=" + this.mServiceCallbacks);
            Log.d(TAG, "  mRootId=" + this.mRootId);
            Log.d(TAG, "  mMediaSessionToken=" + this.mMediaSessionToken);
        }

        /* access modifiers changed from: private */
        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection */
        public class MediaServiceConnection implements ServiceConnection {
            private MediaServiceConnection() {
            }

            public void onServiceConnected(ComponentName name, IBinder binder) {
                if (isCurrent("onServiceConnected")) {
                    MediaBrowserImplBase.this.mServiceBinder = IMediaBrowserServiceCompat.Stub.asInterface(binder);
                    MediaBrowserImplBase.this.mServiceCallbacks = MediaBrowserImplBase.this.getNewServiceCallbacks();
                    MediaBrowserImplBase.this.mState = 1;
                    try {
                        MediaBrowserImplBase.this.mServiceBinder.connect(MediaBrowserImplBase.this.mContext.getPackageName(), MediaBrowserImplBase.this.mRootHints, MediaBrowserImplBase.this.mServiceCallbacks);
                    } catch (RemoteException e) {
                        Log.w(MediaBrowserImplBase.TAG, "RemoteException during connect for " + MediaBrowserImplBase.this.mServiceComponent);
                    }
                }
            }

            public void onServiceDisconnected(ComponentName name) {
                if (isCurrent("onServiceDisconnected")) {
                    MediaBrowserImplBase.this.mServiceBinder = null;
                    MediaBrowserImplBase.this.mServiceCallbacks = null;
                    MediaBrowserImplBase.this.mState = 3;
                    MediaBrowserImplBase.this.mCallback.onConnectionSuspended();
                }
            }

            private boolean isCurrent(String funcName) {
                if (MediaBrowserImplBase.this.mServiceConnection == this) {
                    return true;
                }
                if (MediaBrowserImplBase.this.mState != 0) {
                    Log.i(MediaBrowserImplBase.TAG, funcName + " for " + MediaBrowserImplBase.this.mServiceComponent + " with mServiceConnection=" + MediaBrowserImplBase.this.mServiceConnection + " this=" + this);
                }
                return false;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$ServiceCallbacks */
        public static class ServiceCallbacks extends IMediaBrowserServiceCompatCallbacks.Stub {
            private WeakReference<MediaBrowserImplBase> mMediaBrowser;

            public ServiceCallbacks(MediaBrowserImplBase mediaBrowser) {
                this.mMediaBrowser = new WeakReference<>(mediaBrowser);
            }

            @Override // android.support.p007v4.media.IMediaBrowserServiceCompatCallbacks
            public void onConnect(String root, MediaSessionCompat.Token session, Bundle extras) {
                MediaBrowserImplBase mediaBrowser = this.mMediaBrowser.get();
                if (mediaBrowser != null) {
                    mediaBrowser.onServiceConnected(this, root, session, extras);
                }
            }

            @Override // android.support.p007v4.media.IMediaBrowserServiceCompatCallbacks
            public void onConnectFailed() {
                MediaBrowserImplBase mediaBrowser = this.mMediaBrowser.get();
                if (mediaBrowser != null) {
                    mediaBrowser.onConnectionFailed(this);
                }
            }

            @Override // android.support.p007v4.media.IMediaBrowserServiceCompatCallbacks
            public void onLoadChildren(String parentId, List list) {
                MediaBrowserImplBase mediaBrowser = this.mMediaBrowser.get();
                if (mediaBrowser != null) {
                    mediaBrowser.onLoadChildren(this, parentId, list);
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$Subscription */
        public static class Subscription {
            SubscriptionCallback callback;

            /* renamed from: id */
            final String f151id;

            Subscription(String id) {
                this.f151id = id;
            }
        }
    }
}
