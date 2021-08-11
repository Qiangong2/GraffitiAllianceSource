package android.support.p007v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.p007v4.media.MediaDescriptionCompat;
import android.support.p007v4.media.MediaMetadataCompat;
import android.support.p007v4.media.RatingCompat;
import android.support.p007v4.media.VolumeProviderCompat;
import android.support.p007v4.media.session.IMediaSession;
import android.support.p007v4.media.session.MediaSessionCompatApi14;
import android.support.p007v4.media.session.MediaSessionCompatApi21;
import android.support.p007v4.media.session.MediaSessionCompatApi23;
import android.support.p007v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: android.support.v4.media.session.MediaSessionCompat */
public class MediaSessionCompat {
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
    private static final String TAG = "MediaSessionCompat";
    private final ArrayList<OnActiveChangeListener> mActiveListeners;
    private final MediaControllerCompat mController;
    private final MediaSessionImpl mImpl;

    /* access modifiers changed from: package-private */
    /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImpl */
    public interface MediaSessionImpl {
        Object getMediaSession();

        Object getRemoteControlClient();

        Token getSessionToken();

        boolean isActive();

        void release();

        void sendSessionEvent(String str, Bundle bundle);

        void setActive(boolean z);

        void setCallback(Callback callback, Handler handler);

        void setExtras(Bundle bundle);

        void setFlags(int i);

        void setMediaButtonReceiver(PendingIntent pendingIntent);

        void setMetadata(MediaMetadataCompat mediaMetadataCompat);

        void setPlaybackState(PlaybackStateCompat playbackStateCompat);

        void setPlaybackToLocal(int i);

        void setPlaybackToRemote(VolumeProviderCompat volumeProviderCompat);

        void setQueue(List<QueueItem> list);

        void setQueueTitle(CharSequence charSequence);

        void setRatingType(int i);

        void setSessionActivity(PendingIntent pendingIntent);
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$OnActiveChangeListener */
    public interface OnActiveChangeListener {
        void onActiveChanged();
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: android.support.v4.media.session.MediaSessionCompat$SessionFlags */
    public @interface SessionFlags {
    }

    public MediaSessionCompat(Context context, String tag) {
        this(context, tag, null, null);
    }

    public MediaSessionCompat(Context context, String tag, ComponentName mediaButtonEventReceiver, PendingIntent mbrIntent) {
        this.mActiveListeners = new ArrayList<>();
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        } else if (TextUtils.isEmpty(tag)) {
            throw new IllegalArgumentException("tag must not be null or empty");
        } else {
            if (mediaButtonEventReceiver == null) {
                Intent queryIntent = new Intent("android.intent.action.MEDIA_BUTTON");
                queryIntent.setPackage(context.getPackageName());
                List<ResolveInfo> resolveInfos = context.getPackageManager().queryBroadcastReceivers(queryIntent, 0);
                if (resolveInfos.size() == 1) {
                    ResolveInfo resolveInfo = resolveInfos.get(0);
                    mediaButtonEventReceiver = new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
                } else if (resolveInfos.size() > 1) {
                    Log.w(TAG, "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, using null. Provide a specific ComponentName to use as this session's media button receiver");
                }
            }
            if (mediaButtonEventReceiver != null && mbrIntent == null) {
                Intent mediaButtonIntent = new Intent("android.intent.action.MEDIA_BUTTON");
                mediaButtonIntent.setComponent(mediaButtonEventReceiver);
                mbrIntent = PendingIntent.getBroadcast(context, 0, mediaButtonIntent, 0);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.mImpl = new MediaSessionImplApi21(context, tag);
                this.mImpl.setMediaButtonReceiver(mbrIntent);
            } else {
                this.mImpl = new MediaSessionImplBase(context, tag, mediaButtonEventReceiver, mbrIntent);
            }
            this.mController = new MediaControllerCompat(context, this);
        }
    }

    private MediaSessionCompat(Context context, MediaSessionImpl impl) {
        this.mActiveListeners = new ArrayList<>();
        this.mImpl = impl;
        this.mController = new MediaControllerCompat(context, this);
    }

    public void setCallback(Callback callback) {
        setCallback(callback, null);
    }

    public void setCallback(Callback callback, Handler handler) {
        MediaSessionImpl mediaSessionImpl = this.mImpl;
        if (handler == null) {
            handler = new Handler();
        }
        mediaSessionImpl.setCallback(callback, handler);
    }

    public void setSessionActivity(PendingIntent pi) {
        this.mImpl.setSessionActivity(pi);
    }

    public void setMediaButtonReceiver(PendingIntent mbr) {
        this.mImpl.setMediaButtonReceiver(mbr);
    }

    public void setFlags(int flags) {
        this.mImpl.setFlags(flags);
    }

    public void setPlaybackToLocal(int stream) {
        this.mImpl.setPlaybackToLocal(stream);
    }

    public void setPlaybackToRemote(VolumeProviderCompat volumeProvider) {
        if (volumeProvider == null) {
            throw new IllegalArgumentException("volumeProvider may not be null!");
        }
        this.mImpl.setPlaybackToRemote(volumeProvider);
    }

    public void setActive(boolean active) {
        this.mImpl.setActive(active);
        Iterator i$ = this.mActiveListeners.iterator();
        while (i$.hasNext()) {
            i$.next().onActiveChanged();
        }
    }

    public boolean isActive() {
        return this.mImpl.isActive();
    }

    public void sendSessionEvent(String event, Bundle extras) {
        if (TextUtils.isEmpty(event)) {
            throw new IllegalArgumentException("event cannot be null or empty");
        }
        this.mImpl.sendSessionEvent(event, extras);
    }

    public void release() {
        this.mImpl.release();
    }

    public Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public MediaControllerCompat getController() {
        return this.mController;
    }

    public void setPlaybackState(PlaybackStateCompat state) {
        this.mImpl.setPlaybackState(state);
    }

    public void setMetadata(MediaMetadataCompat metadata) {
        this.mImpl.setMetadata(metadata);
    }

    public void setQueue(List<QueueItem> queue) {
        this.mImpl.setQueue(queue);
    }

    public void setQueueTitle(CharSequence title) {
        this.mImpl.setQueueTitle(title);
    }

    public void setRatingType(int type) {
        this.mImpl.setRatingType(type);
    }

    public void setExtras(Bundle extras) {
        this.mImpl.setExtras(extras);
    }

    public Object getMediaSession() {
        return this.mImpl.getMediaSession();
    }

    public Object getRemoteControlClient() {
        return this.mImpl.getRemoteControlClient();
    }

    public void addOnActiveChangeListener(OnActiveChangeListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        this.mActiveListeners.add(listener);
    }

    public void removeOnActiveChangeListener(OnActiveChangeListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        this.mActiveListeners.remove(listener);
    }

    public static MediaSessionCompat obtain(Context context, Object mediaSession) {
        return new MediaSessionCompat(context, new MediaSessionImplApi21(mediaSession));
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$Callback */
    public static abstract class Callback {
        final Object mCallbackObj;

        public Callback() {
            if (Build.VERSION.SDK_INT >= 23) {
                this.mCallbackObj = MediaSessionCompatApi23.createCallback(new StubApi23());
            } else if (Build.VERSION.SDK_INT >= 21) {
                this.mCallbackObj = MediaSessionCompatApi21.createCallback(new StubApi21());
            } else {
                this.mCallbackObj = null;
            }
        }

        public void onCommand(String command, Bundle extras, ResultReceiver cb) {
        }

        public boolean onMediaButtonEvent(Intent mediaButtonEvent) {
            return false;
        }

        public void onPlay() {
        }

        public void onPlayFromMediaId(String mediaId, Bundle extras) {
        }

        public void onPlayFromSearch(String query, Bundle extras) {
        }

        public void onPlayFromUri(Uri uri, Bundle extras) {
        }

        public void onSkipToQueueItem(long id) {
        }

        public void onPause() {
        }

        public void onSkipToNext() {
        }

        public void onSkipToPrevious() {
        }

        public void onFastForward() {
        }

        public void onRewind() {
        }

        public void onStop() {
        }

        public void onSeekTo(long pos) {
        }

        public void onSetRating(RatingCompat rating) {
        }

        public void onCustomAction(String action, Bundle extras) {
        }

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$Callback$StubApi21 */
        private class StubApi21 implements MediaSessionCompatApi21.Callback {
            private StubApi21() {
            }

            @Override // android.support.p007v4.media.session.MediaSessionCompatApi21.Callback
            public void onCommand(String command, Bundle extras, ResultReceiver cb) {
                Callback.this.onCommand(command, extras, cb);
            }

            @Override // android.support.p007v4.media.session.MediaSessionCompatApi21.Callback
            public boolean onMediaButtonEvent(Intent mediaButtonIntent) {
                return Callback.this.onMediaButtonEvent(mediaButtonIntent);
            }

            @Override // android.support.p007v4.media.session.MediaSessionCompatApi21.Callback
            public void onPlay() {
                Callback.this.onPlay();
            }

            @Override // android.support.p007v4.media.session.MediaSessionCompatApi21.Callback
            public void onPlayFromMediaId(String mediaId, Bundle extras) {
                Callback.this.onPlayFromMediaId(mediaId, extras);
            }

            @Override // android.support.p007v4.media.session.MediaSessionCompatApi21.Callback
            public void onPlayFromSearch(String search, Bundle extras) {
                Callback.this.onPlayFromSearch(search, extras);
            }

            @Override // android.support.p007v4.media.session.MediaSessionCompatApi21.Callback
            public void onSkipToQueueItem(long id) {
                Callback.this.onSkipToQueueItem(id);
            }

            @Override // android.support.p007v4.media.session.MediaSessionCompatApi21.Callback
            public void onPause() {
                Callback.this.onPause();
            }

            @Override // android.support.p007v4.media.session.MediaSessionCompatApi21.Callback
            public void onSkipToNext() {
                Callback.this.onSkipToNext();
            }

            @Override // android.support.p007v4.media.session.MediaSessionCompatApi21.Callback
            public void onSkipToPrevious() {
                Callback.this.onSkipToPrevious();
            }

            @Override // android.support.p007v4.media.session.MediaSessionCompatApi21.Callback
            public void onFastForward() {
                Callback.this.onFastForward();
            }

            @Override // android.support.p007v4.media.session.MediaSessionCompatApi21.Callback
            public void onRewind() {
                Callback.this.onRewind();
            }

            @Override // android.support.p007v4.media.session.MediaSessionCompatApi21.Callback
            public void onStop() {
                Callback.this.onStop();
            }

            @Override // android.support.p007v4.media.session.MediaSessionCompatApi21.Callback
            public void onSeekTo(long pos) {
                Callback.this.onSeekTo(pos);
            }

            @Override // android.support.p007v4.media.session.MediaSessionCompatApi21.Callback
            public void onSetRating(Object ratingObj) {
                Callback.this.onSetRating(RatingCompat.fromRating(ratingObj));
            }

            @Override // android.support.p007v4.media.session.MediaSessionCompatApi21.Callback
            public void onCustomAction(String action, Bundle extras) {
                Callback.this.onCustomAction(action, extras);
            }
        }

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$Callback$StubApi23 */
        private class StubApi23 extends StubApi21 implements MediaSessionCompatApi23.Callback {
            private StubApi23() {
                super();
            }

            @Override // android.support.p007v4.media.session.MediaSessionCompatApi23.Callback
            public void onPlayFromUri(Uri uri, Bundle extras) {
                Callback.this.onPlayFromUri(uri, extras);
            }
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$Token */
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new Parcelable.Creator<Token>() {
            /* class android.support.p007v4.media.session.MediaSessionCompat.Token.C01381 */

            @Override // android.os.Parcelable.Creator
            public Token createFromParcel(Parcel in) {
                Object readStrongBinder;
                if (Build.VERSION.SDK_INT >= 21) {
                    readStrongBinder = in.readParcelable(null);
                } else {
                    readStrongBinder = in.readStrongBinder();
                }
                return new Token(readStrongBinder);
            }

            @Override // android.os.Parcelable.Creator
            public Token[] newArray(int size) {
                return new Token[size];
            }
        };
        private final Object mInner;

        Token(Object inner) {
            this.mInner = inner;
        }

        public static Token fromToken(Object token) {
            if (token == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new Token(MediaSessionCompatApi21.verifyToken(token));
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            if (Build.VERSION.SDK_INT >= 21) {
                dest.writeParcelable((Parcelable) this.mInner, flags);
            } else {
                dest.writeStrongBinder((IBinder) this.mInner);
            }
        }

        public Object getToken() {
            return this.mInner;
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$QueueItem */
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new Parcelable.Creator<QueueItem>() {
            /* class android.support.p007v4.media.session.MediaSessionCompat.QueueItem.C01361 */

            @Override // android.os.Parcelable.Creator
            public QueueItem createFromParcel(Parcel p) {
                return new QueueItem(p);
            }

            @Override // android.os.Parcelable.Creator
            public QueueItem[] newArray(int size) {
                return new QueueItem[size];
            }
        };
        public static final int UNKNOWN_ID = -1;
        private final MediaDescriptionCompat mDescription;
        private final long mId;
        private Object mItem;

        public QueueItem(MediaDescriptionCompat description, long id) {
            this(null, description, id);
        }

        private QueueItem(Object queueItem, MediaDescriptionCompat description, long id) {
            if (description == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            } else if (id == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            } else {
                this.mDescription = description;
                this.mId = id;
                this.mItem = queueItem;
            }
        }

        private QueueItem(Parcel in) {
            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(in);
            this.mId = in.readLong();
        }

        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public long getQueueId() {
            return this.mId;
        }

        public void writeToParcel(Parcel dest, int flags) {
            this.mDescription.writeToParcel(dest, flags);
            dest.writeLong(this.mId);
        }

        public int describeContents() {
            return 0;
        }

        public Object getQueueItem() {
            if (this.mItem != null || Build.VERSION.SDK_INT < 21) {
                return this.mItem;
            }
            this.mItem = MediaSessionCompatApi21.QueueItem.createItem(this.mDescription.getMediaDescription(), this.mId);
            return this.mItem;
        }

        public static QueueItem obtain(Object queueItem) {
            return new QueueItem(queueItem, MediaDescriptionCompat.fromMediaDescription(MediaSessionCompatApi21.QueueItem.getDescription(queueItem)), MediaSessionCompatApi21.QueueItem.getQueueId(queueItem));
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.mDescription + ", Id=" + this.mId + " }";
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper */
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new Parcelable.Creator<ResultReceiverWrapper>() {
            /* class android.support.p007v4.media.session.MediaSessionCompat.ResultReceiverWrapper.C01371 */

            @Override // android.os.Parcelable.Creator
            public ResultReceiverWrapper createFromParcel(Parcel p) {
                return new ResultReceiverWrapper(p);
            }

            @Override // android.os.Parcelable.Creator
            public ResultReceiverWrapper[] newArray(int size) {
                return new ResultReceiverWrapper[size];
            }
        };
        private ResultReceiver mResultReceiver;

        public ResultReceiverWrapper(ResultReceiver resultReceiver) {
            this.mResultReceiver = resultReceiver;
        }

        ResultReceiverWrapper(Parcel in) {
            this.mResultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(in);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            this.mResultReceiver.writeToParcel(dest, flags);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase */
    public static class MediaSessionImplBase implements MediaSessionImpl {
        private final AudioManager mAudioManager;
        private Callback mCallback;
        private final ComponentName mComponentName;
        private final Context mContext;
        private final RemoteCallbackList<IMediaControllerCallback> mControllerCallbacks = new RemoteCallbackList<>();
        private boolean mDestroyed = false;
        private Bundle mExtras;
        private int mFlags;
        private final MessageHandler mHandler;
        private boolean mIsActive = false;
        private boolean mIsMbrRegistered = false;
        private boolean mIsRccRegistered = false;
        private int mLocalStream;
        private final Object mLock = new Object();
        private final PendingIntent mMediaButtonEventReceiver;
        private MediaMetadataCompat mMetadata;
        private final String mPackageName;
        private List<QueueItem> mQueue;
        private CharSequence mQueueTitle;
        private int mRatingType;
        private final Object mRccObj;
        private PendingIntent mSessionActivity;
        private PlaybackStateCompat mState;
        private final MediaSessionStub mStub;
        private final String mTag;
        private final Token mToken;
        private VolumeProviderCompat.Callback mVolumeCallback = new VolumeProviderCompat.Callback() {
            /* class android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImplBase.C01341 */

            @Override // android.support.p007v4.media.VolumeProviderCompat.Callback
            public void onVolumeChanged(VolumeProviderCompat volumeProvider) {
                if (MediaSessionImplBase.this.mVolumeProvider == volumeProvider) {
                    MediaSessionImplBase.this.sendVolumeInfoChanged(new ParcelableVolumeInfo(MediaSessionImplBase.this.mVolumeType, MediaSessionImplBase.this.mLocalStream, volumeProvider.getVolumeControl(), volumeProvider.getMaxVolume(), volumeProvider.getCurrentVolume()));
                }
            }
        };
        private VolumeProviderCompat mVolumeProvider;
        private int mVolumeType;

        public MediaSessionImplBase(Context context, String tag, ComponentName mbrComponent, PendingIntent mbr) {
            if (mbrComponent == null) {
                throw new IllegalArgumentException("MediaButtonReceiver component may not be null.");
            }
            this.mContext = context;
            this.mPackageName = context.getPackageName();
            this.mAudioManager = (AudioManager) context.getSystemService("audio");
            this.mTag = tag;
            this.mComponentName = mbrComponent;
            this.mMediaButtonEventReceiver = mbr;
            this.mStub = new MediaSessionStub();
            this.mToken = new Token(this.mStub);
            this.mHandler = new MessageHandler(Looper.myLooper());
            this.mRatingType = 0;
            this.mVolumeType = 1;
            this.mLocalStream = 3;
            if (Build.VERSION.SDK_INT >= 14) {
                this.mRccObj = MediaSessionCompatApi14.createRemoteControlClient(mbr);
            } else {
                this.mRccObj = null;
            }
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(final Callback callback, Handler handler) {
            if (callback != this.mCallback) {
                if (callback == null || Build.VERSION.SDK_INT < 18) {
                    if (Build.VERSION.SDK_INT >= 18) {
                        MediaSessionCompatApi18.setOnPlaybackPositionUpdateListener(this.mRccObj, null);
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        MediaSessionCompatApi19.setOnMetadataUpdateListener(this.mRccObj, null);
                    }
                } else {
                    if (handler == null) {
                        new Handler();
                    }
                    MediaSessionCompatApi14.Callback cb14 = new MediaSessionCompatApi14.Callback() {
                        /* class android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImplBase.C01352 */

                        @Override // android.support.p007v4.media.session.MediaSessionCompatApi14.Callback
                        public void onStop() {
                            callback.onStop();
                        }

                        @Override // android.support.p007v4.media.session.MediaSessionCompatApi14.Callback
                        public void onSkipToPrevious() {
                            callback.onSkipToPrevious();
                        }

                        @Override // android.support.p007v4.media.session.MediaSessionCompatApi14.Callback
                        public void onSkipToNext() {
                            callback.onSkipToNext();
                        }

                        @Override // android.support.p007v4.media.session.MediaSessionCompatApi14.Callback
                        public void onSetRating(Object ratingObj) {
                            callback.onSetRating(RatingCompat.fromRating(ratingObj));
                        }

                        @Override // android.support.p007v4.media.session.MediaSessionCompatApi14.Callback
                        public void onSeekTo(long pos) {
                            callback.onSeekTo(pos);
                        }

                        @Override // android.support.p007v4.media.session.MediaSessionCompatApi14.Callback
                        public void onRewind() {
                            callback.onRewind();
                        }

                        @Override // android.support.p007v4.media.session.MediaSessionCompatApi14.Callback
                        public void onPlay() {
                            callback.onPlay();
                        }

                        @Override // android.support.p007v4.media.session.MediaSessionCompatApi14.Callback
                        public void onPause() {
                            callback.onPause();
                        }

                        @Override // android.support.p007v4.media.session.MediaSessionCompatApi14.Callback
                        public boolean onMediaButtonEvent(Intent mediaButtonIntent) {
                            return callback.onMediaButtonEvent(mediaButtonIntent);
                        }

                        @Override // android.support.p007v4.media.session.MediaSessionCompatApi14.Callback
                        public void onFastForward() {
                            callback.onFastForward();
                        }

                        @Override // android.support.p007v4.media.session.MediaSessionCompatApi14.Callback
                        public void onCommand(String command, Bundle extras, ResultReceiver cb) {
                            callback.onCommand(command, extras, cb);
                        }
                    };
                    if (Build.VERSION.SDK_INT >= 18) {
                        MediaSessionCompatApi18.setOnPlaybackPositionUpdateListener(this.mRccObj, MediaSessionCompatApi18.createPlaybackPositionUpdateListener(cb14));
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        MediaSessionCompatApi19.setOnMetadataUpdateListener(this.mRccObj, MediaSessionCompatApi19.createMetadataUpdateListener(cb14));
                    }
                }
                this.mCallback = callback;
            }
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setFlags(int flags) {
            synchronized (this.mLock) {
                this.mFlags = flags;
            }
            update();
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToLocal(int stream) {
            if (this.mVolumeProvider != null) {
                this.mVolumeProvider.setCallback(null);
            }
            this.mVolumeType = 1;
            sendVolumeInfoChanged(new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, 2, this.mAudioManager.getStreamMaxVolume(this.mLocalStream), this.mAudioManager.getStreamVolume(this.mLocalStream)));
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToRemote(VolumeProviderCompat volumeProvider) {
            if (volumeProvider == null) {
                throw new IllegalArgumentException("volumeProvider may not be null");
            }
            if (this.mVolumeProvider != null) {
                this.mVolumeProvider.setCallback(null);
            }
            this.mVolumeType = 2;
            this.mVolumeProvider = volumeProvider;
            sendVolumeInfoChanged(new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, this.mVolumeProvider.getVolumeControl(), this.mVolumeProvider.getMaxVolume(), this.mVolumeProvider.getCurrentVolume()));
            volumeProvider.setCallback(this.mVolumeCallback);
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setActive(boolean active) {
            if (active != this.mIsActive) {
                this.mIsActive = active;
                if (update()) {
                    setMetadata(this.mMetadata);
                    setPlaybackState(this.mState);
                }
            }
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public boolean isActive() {
            return this.mIsActive;
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void sendSessionEvent(String event, Bundle extras) {
            sendEvent(event, extras);
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void release() {
            this.mIsActive = false;
            this.mDestroyed = true;
            update();
            sendSessionDestroyed();
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Token getSessionToken() {
            return this.mToken;
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackState(PlaybackStateCompat state) {
            synchronized (this.mLock) {
                this.mState = state;
            }
            sendState(state);
            if (this.mIsActive) {
                if (state != null) {
                    if (Build.VERSION.SDK_INT >= 18) {
                        MediaSessionCompatApi18.setState(this.mRccObj, state.getState(), state.getPosition(), state.getPlaybackSpeed(), state.getLastPositionUpdateTime());
                    } else if (Build.VERSION.SDK_INT >= 14) {
                        MediaSessionCompatApi14.setState(this.mRccObj, state.getState());
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        MediaSessionCompatApi19.setTransportControlFlags(this.mRccObj, state.getActions());
                    } else if (Build.VERSION.SDK_INT >= 18) {
                        MediaSessionCompatApi18.setTransportControlFlags(this.mRccObj, state.getActions());
                    } else if (Build.VERSION.SDK_INT >= 14) {
                        MediaSessionCompatApi14.setTransportControlFlags(this.mRccObj, state.getActions());
                    }
                } else if (Build.VERSION.SDK_INT >= 14) {
                    MediaSessionCompatApi14.setState(this.mRccObj, 0);
                    MediaSessionCompatApi14.setTransportControlFlags(this.mRccObj, 0);
                }
            }
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMetadata(MediaMetadataCompat metadata) {
            Bundle bundle = null;
            synchronized (this.mLock) {
                this.mMetadata = metadata;
            }
            sendMetadata(metadata);
            if (this.mIsActive) {
                if (Build.VERSION.SDK_INT >= 19) {
                    Object obj = this.mRccObj;
                    if (metadata != null) {
                        bundle = metadata.getBundle();
                    }
                    MediaSessionCompatApi19.setMetadata(obj, bundle, this.mState == null ? 0 : this.mState.getActions());
                } else if (Build.VERSION.SDK_INT >= 14) {
                    Object obj2 = this.mRccObj;
                    if (metadata != null) {
                        bundle = metadata.getBundle();
                    }
                    MediaSessionCompatApi14.setMetadata(obj2, bundle);
                }
            }
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setSessionActivity(PendingIntent pi) {
            synchronized (this.mLock) {
                this.mSessionActivity = pi;
            }
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMediaButtonReceiver(PendingIntent mbr) {
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueue(List<QueueItem> queue) {
            this.mQueue = queue;
            sendQueue(queue);
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueueTitle(CharSequence title) {
            this.mQueueTitle = title;
            sendQueueTitle(title);
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Object getMediaSession() {
            return null;
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Object getRemoteControlClient() {
            return this.mRccObj;
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRatingType(int type) {
            this.mRatingType = type;
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setExtras(Bundle extras) {
            this.mExtras = extras;
        }

        private boolean update() {
            if (this.mIsActive) {
                if (Build.VERSION.SDK_INT >= 8) {
                    if (!this.mIsMbrRegistered && (this.mFlags & 1) != 0) {
                        if (Build.VERSION.SDK_INT >= 18) {
                            MediaSessionCompatApi18.registerMediaButtonEventReceiver(this.mContext, this.mMediaButtonEventReceiver, this.mComponentName);
                        } else {
                            MediaSessionCompatApi8.registerMediaButtonEventReceiver(this.mContext, this.mComponentName);
                        }
                        this.mIsMbrRegistered = true;
                    } else if (this.mIsMbrRegistered && (this.mFlags & 1) == 0) {
                        if (Build.VERSION.SDK_INT >= 18) {
                            MediaSessionCompatApi18.unregisterMediaButtonEventReceiver(this.mContext, this.mMediaButtonEventReceiver, this.mComponentName);
                        } else {
                            MediaSessionCompatApi8.unregisterMediaButtonEventReceiver(this.mContext, this.mComponentName);
                        }
                        this.mIsMbrRegistered = false;
                    }
                }
                if (Build.VERSION.SDK_INT < 14) {
                    return false;
                }
                if (!this.mIsRccRegistered && (this.mFlags & 2) != 0) {
                    MediaSessionCompatApi14.registerRemoteControlClient(this.mContext, this.mRccObj);
                    this.mIsRccRegistered = true;
                    return true;
                } else if (!this.mIsRccRegistered || (this.mFlags & 2) != 0) {
                    return false;
                } else {
                    MediaSessionCompatApi14.setState(this.mRccObj, 0);
                    MediaSessionCompatApi14.unregisterRemoteControlClient(this.mContext, this.mRccObj);
                    this.mIsRccRegistered = false;
                    return false;
                }
            } else {
                if (this.mIsMbrRegistered) {
                    if (Build.VERSION.SDK_INT >= 18) {
                        MediaSessionCompatApi18.unregisterMediaButtonEventReceiver(this.mContext, this.mMediaButtonEventReceiver, this.mComponentName);
                    } else {
                        MediaSessionCompatApi8.unregisterMediaButtonEventReceiver(this.mContext, this.mComponentName);
                    }
                    this.mIsMbrRegistered = false;
                }
                if (!this.mIsRccRegistered) {
                    return false;
                }
                MediaSessionCompatApi14.setState(this.mRccObj, 0);
                MediaSessionCompatApi14.unregisterRemoteControlClient(this.mContext, this.mRccObj);
                this.mIsRccRegistered = false;
                return false;
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void adjustVolume(int direction, int flags) {
            if (this.mVolumeType != 2) {
                this.mAudioManager.adjustStreamVolume(this.mLocalStream, direction, flags);
            } else if (this.mVolumeProvider != null) {
                this.mVolumeProvider.onAdjustVolume(direction);
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void setVolumeTo(int value, int flags) {
            if (this.mVolumeType != 2) {
                this.mAudioManager.setStreamVolume(this.mLocalStream, value, flags);
            } else if (this.mVolumeProvider != null) {
                this.mVolumeProvider.onSetVolumeTo(value);
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private PlaybackStateCompat getStateWithUpdatedPosition() {
            PlaybackStateCompat state;
            long duration = -1;
            synchronized (this.mLock) {
                state = this.mState;
                if (this.mMetadata != null && this.mMetadata.containsKey(MediaMetadataCompat.METADATA_KEY_DURATION)) {
                    duration = this.mMetadata.getLong(MediaMetadataCompat.METADATA_KEY_DURATION);
                }
            }
            PlaybackStateCompat result = null;
            if (state != null && (state.getState() == 3 || state.getState() == 4 || state.getState() == 5)) {
                long updateTime = state.getLastPositionUpdateTime();
                long currentTime = SystemClock.elapsedRealtime();
                if (updateTime > 0) {
                    long position = ((long) (state.getPlaybackSpeed() * ((float) (currentTime - updateTime)))) + state.getPosition();
                    if (duration >= 0 && position > duration) {
                        position = duration;
                    } else if (position < 0) {
                        position = 0;
                    }
                    PlaybackStateCompat.Builder builder = new PlaybackStateCompat.Builder(state);
                    builder.setState(state.getState(), position, state.getPlaybackSpeed(), currentTime);
                    result = builder.build();
                }
            }
            return result == null ? state : result;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void sendVolumeInfoChanged(ParcelableVolumeInfo info) {
            for (int i = this.mControllerCallbacks.beginBroadcast() - 1; i >= 0; i--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(i).onVolumeInfoChanged(info);
                } catch (RemoteException e) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendSessionDestroyed() {
            for (int i = this.mControllerCallbacks.beginBroadcast() - 1; i >= 0; i--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(i).onSessionDestroyed();
                } catch (RemoteException e) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
            this.mControllerCallbacks.kill();
        }

        private void sendEvent(String event, Bundle extras) {
            for (int i = this.mControllerCallbacks.beginBroadcast() - 1; i >= 0; i--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(i).onEvent(event, extras);
                } catch (RemoteException e) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendState(PlaybackStateCompat state) {
            for (int i = this.mControllerCallbacks.beginBroadcast() - 1; i >= 0; i--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(i).onPlaybackStateChanged(state);
                } catch (RemoteException e) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendMetadata(MediaMetadataCompat metadata) {
            for (int i = this.mControllerCallbacks.beginBroadcast() - 1; i >= 0; i--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(i).onMetadataChanged(metadata);
                } catch (RemoteException e) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendQueue(List<QueueItem> queue) {
            for (int i = this.mControllerCallbacks.beginBroadcast() - 1; i >= 0; i--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(i).onQueueChanged(queue);
                } catch (RemoteException e) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendQueueTitle(CharSequence queueTitle) {
            for (int i = this.mControllerCallbacks.beginBroadcast() - 1; i >= 0; i--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(i).onQueueTitleChanged(queueTitle);
                } catch (RemoteException e) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$MediaSessionStub */
        class MediaSessionStub extends IMediaSession.Stub {
            MediaSessionStub() {
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public void sendCommand(String command, Bundle args, ResultReceiverWrapper cb) {
                MediaSessionImplBase.this.mHandler.post(15, new Command(command, args, cb.mResultReceiver));
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent mediaButton) {
                boolean handlesMediaButtons = (MediaSessionImplBase.this.mFlags & 1) != 0;
                if (handlesMediaButtons) {
                    MediaSessionImplBase.this.mHandler.post(14, mediaButton);
                }
                return handlesMediaButtons;
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback cb) {
                if (MediaSessionImplBase.this.mDestroyed) {
                    try {
                        cb.onSessionDestroyed();
                    } catch (Exception e) {
                    }
                } else {
                    MediaSessionImplBase.this.mControllerCallbacks.register(cb);
                }
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback cb) {
                MediaSessionImplBase.this.mControllerCallbacks.unregister(cb);
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public String getPackageName() {
                return MediaSessionImplBase.this.mPackageName;
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public String getTag() {
                return MediaSessionImplBase.this.mTag;
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public PendingIntent getLaunchPendingIntent() {
                PendingIntent pendingIntent;
                synchronized (MediaSessionImplBase.this.mLock) {
                    pendingIntent = MediaSessionImplBase.this.mSessionActivity;
                }
                return pendingIntent;
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public long getFlags() {
                long j;
                synchronized (MediaSessionImplBase.this.mLock) {
                    j = (long) MediaSessionImplBase.this.mFlags;
                }
                return j;
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() {
                int volumeType;
                int stream;
                int controlType;
                int max;
                int current;
                synchronized (MediaSessionImplBase.this.mLock) {
                    volumeType = MediaSessionImplBase.this.mVolumeType;
                    stream = MediaSessionImplBase.this.mLocalStream;
                    VolumeProviderCompat vp = MediaSessionImplBase.this.mVolumeProvider;
                    if (volumeType == 2) {
                        controlType = vp.getVolumeControl();
                        max = vp.getMaxVolume();
                        current = vp.getCurrentVolume();
                    } else {
                        controlType = 2;
                        max = MediaSessionImplBase.this.mAudioManager.getStreamMaxVolume(stream);
                        current = MediaSessionImplBase.this.mAudioManager.getStreamVolume(stream);
                    }
                }
                return new ParcelableVolumeInfo(volumeType, stream, controlType, max, current);
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public void adjustVolume(int direction, int flags, String packageName) {
                MediaSessionImplBase.this.adjustVolume(direction, flags);
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public void setVolumeTo(int value, int flags, String packageName) {
                MediaSessionImplBase.this.setVolumeTo(value, flags);
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public void play() throws RemoteException {
                MediaSessionImplBase.this.mHandler.post(1);
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public void playFromMediaId(String mediaId, Bundle extras) throws RemoteException {
                MediaSessionImplBase.this.mHandler.post(2, mediaId, extras);
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public void playFromSearch(String query, Bundle extras) throws RemoteException {
                MediaSessionImplBase.this.mHandler.post(3, query, extras);
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public void playFromUri(Uri uri, Bundle extras) throws RemoteException {
                MediaSessionImplBase.this.mHandler.post(18, uri, extras);
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public void skipToQueueItem(long id) {
                MediaSessionImplBase.this.mHandler.post(4, Long.valueOf(id));
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public void pause() throws RemoteException {
                MediaSessionImplBase.this.mHandler.post(5);
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public void stop() throws RemoteException {
                MediaSessionImplBase.this.mHandler.post(6);
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public void next() throws RemoteException {
                MediaSessionImplBase.this.mHandler.post(7);
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public void previous() throws RemoteException {
                MediaSessionImplBase.this.mHandler.post(8);
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public void fastForward() throws RemoteException {
                MediaSessionImplBase.this.mHandler.post(9);
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public void rewind() throws RemoteException {
                MediaSessionImplBase.this.mHandler.post(10);
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public void seekTo(long pos) throws RemoteException {
                MediaSessionImplBase.this.mHandler.post(11, Long.valueOf(pos));
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public void rate(RatingCompat rating) throws RemoteException {
                MediaSessionImplBase.this.mHandler.post(12, rating);
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public void sendCustomAction(String action, Bundle args) throws RemoteException {
                MediaSessionImplBase.this.mHandler.post(13, action, args);
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public MediaMetadataCompat getMetadata() {
                return MediaSessionImplBase.this.mMetadata;
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public PlaybackStateCompat getPlaybackState() {
                return MediaSessionImplBase.this.getStateWithUpdatedPosition();
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public List<QueueItem> getQueue() {
                List<QueueItem> list;
                synchronized (MediaSessionImplBase.this.mLock) {
                    list = MediaSessionImplBase.this.mQueue;
                }
                return list;
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public CharSequence getQueueTitle() {
                return MediaSessionImplBase.this.mQueueTitle;
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public Bundle getExtras() {
                Bundle bundle;
                synchronized (MediaSessionImplBase.this.mLock) {
                    bundle = MediaSessionImplBase.this.mExtras;
                }
                return bundle;
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public int getRatingType() {
                return MediaSessionImplBase.this.mRatingType;
            }

            @Override // android.support.p007v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() {
                return (MediaSessionImplBase.this.mFlags & 2) != 0;
            }
        }

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$Command */
        private static final class Command {
            public final String command;
            public final Bundle extras;
            public final ResultReceiver stub;

            public Command(String command2, Bundle extras2, ResultReceiver stub2) {
                this.command = command2;
                this.extras = extras2;
                this.stub = stub2;
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$MessageHandler */
        public class MessageHandler extends Handler {
            private static final int KEYCODE_MEDIA_PAUSE = 127;
            private static final int KEYCODE_MEDIA_PLAY = 126;
            private static final int MSG_ADJUST_VOLUME = 16;
            private static final int MSG_COMMAND = 15;
            private static final int MSG_CUSTOM_ACTION = 13;
            private static final int MSG_FAST_FORWARD = 9;
            private static final int MSG_MEDIA_BUTTON = 14;
            private static final int MSG_NEXT = 7;
            private static final int MSG_PAUSE = 5;
            private static final int MSG_PLAY = 1;
            private static final int MSG_PLAY_MEDIA_ID = 2;
            private static final int MSG_PLAY_SEARCH = 3;
            private static final int MSG_PLAY_URI = 18;
            private static final int MSG_PREVIOUS = 8;
            private static final int MSG_RATE = 12;
            private static final int MSG_REWIND = 10;
            private static final int MSG_SEEK_TO = 11;
            private static final int MSG_SET_VOLUME = 17;
            private static final int MSG_SKIP_TO_ITEM = 4;
            private static final int MSG_STOP = 6;

            public MessageHandler(Looper looper) {
                super(looper);
            }

            public void post(int what, Object obj, Bundle bundle) {
                Message msg = obtainMessage(what, obj);
                msg.setData(bundle);
                msg.sendToTarget();
            }

            public void post(int what, Object obj) {
                obtainMessage(what, obj).sendToTarget();
            }

            public void post(int what) {
                post(what, null);
            }

            public void post(int what, Object obj, int arg1) {
                obtainMessage(what, arg1, 0, obj).sendToTarget();
            }

            public void handleMessage(Message msg) {
                if (MediaSessionImplBase.this.mCallback != null) {
                    switch (msg.what) {
                        case 1:
                            MediaSessionImplBase.this.mCallback.onPlay();
                            return;
                        case 2:
                            MediaSessionImplBase.this.mCallback.onPlayFromMediaId((String) msg.obj, msg.getData());
                            return;
                        case 3:
                            MediaSessionImplBase.this.mCallback.onPlayFromSearch((String) msg.obj, msg.getData());
                            return;
                        case 4:
                            MediaSessionImplBase.this.mCallback.onSkipToQueueItem(((Long) msg.obj).longValue());
                            return;
                        case 5:
                            MediaSessionImplBase.this.mCallback.onPause();
                            return;
                        case 6:
                            MediaSessionImplBase.this.mCallback.onStop();
                            return;
                        case 7:
                            MediaSessionImplBase.this.mCallback.onSkipToNext();
                            return;
                        case 8:
                            MediaSessionImplBase.this.mCallback.onSkipToPrevious();
                            return;
                        case 9:
                            MediaSessionImplBase.this.mCallback.onFastForward();
                            return;
                        case 10:
                            MediaSessionImplBase.this.mCallback.onRewind();
                            return;
                        case 11:
                            MediaSessionImplBase.this.mCallback.onSeekTo(((Long) msg.obj).longValue());
                            return;
                        case 12:
                            MediaSessionImplBase.this.mCallback.onSetRating((RatingCompat) msg.obj);
                            return;
                        case 13:
                            MediaSessionImplBase.this.mCallback.onCustomAction((String) msg.obj, msg.getData());
                            return;
                        case 14:
                            KeyEvent keyEvent = (KeyEvent) msg.obj;
                            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                            intent.putExtra("android.intent.extra.KEY_EVENT", keyEvent);
                            if (!MediaSessionImplBase.this.mCallback.onMediaButtonEvent(intent)) {
                                onMediaButtonEvent(keyEvent);
                                return;
                            }
                            return;
                        case 15:
                            Command cmd = (Command) msg.obj;
                            MediaSessionImplBase.this.mCallback.onCommand(cmd.command, cmd.extras, cmd.stub);
                            return;
                        case 16:
                            MediaSessionImplBase.this.adjustVolume(((Integer) msg.obj).intValue(), 0);
                            return;
                        case 17:
                            MediaSessionImplBase.this.setVolumeTo(((Integer) msg.obj).intValue(), 0);
                            return;
                        case 18:
                            MediaSessionImplBase.this.mCallback.onPlayFromUri((Uri) msg.obj, msg.getData());
                            return;
                        default:
                            return;
                    }
                }
            }

            private void onMediaButtonEvent(KeyEvent ke) {
                boolean isPlaying;
                boolean canPlay;
                boolean canPause = true;
                if (ke != null && ke.getAction() == 0) {
                    long validActions = MediaSessionImplBase.this.mState == null ? 0 : MediaSessionImplBase.this.mState.getActions();
                    switch (ke.getKeyCode()) {
                        case 79:
                        case 85:
                            if (MediaSessionImplBase.this.mState == null || MediaSessionImplBase.this.mState.getState() != 3) {
                                isPlaying = false;
                            } else {
                                isPlaying = true;
                            }
                            if ((516 & validActions) != 0) {
                                canPlay = true;
                            } else {
                                canPlay = false;
                            }
                            if ((514 & validActions) == 0) {
                                canPause = false;
                            }
                            if (isPlaying && canPause) {
                                MediaSessionImplBase.this.mCallback.onPause();
                                return;
                            } else if (!isPlaying && canPlay) {
                                MediaSessionImplBase.this.mCallback.onPlay();
                                return;
                            } else {
                                return;
                            }
                        case 86:
                            if ((1 & validActions) != 0) {
                                MediaSessionImplBase.this.mCallback.onStop();
                                return;
                            }
                            return;
                        case 87:
                            if ((32 & validActions) != 0) {
                                MediaSessionImplBase.this.mCallback.onSkipToNext();
                                return;
                            }
                            return;
                        case 88:
                            if ((16 & validActions) != 0) {
                                MediaSessionImplBase.this.mCallback.onSkipToPrevious();
                                return;
                            }
                            return;
                        case 89:
                            if ((8 & validActions) != 0) {
                                MediaSessionImplBase.this.mCallback.onRewind();
                                return;
                            }
                            return;
                        case 90:
                            if ((64 & validActions) != 0) {
                                MediaSessionImplBase.this.mCallback.onFastForward();
                                return;
                            }
                            return;
                        case 126:
                            if ((4 & validActions) != 0) {
                                MediaSessionImplBase.this.mCallback.onPlay();
                                return;
                            }
                            return;
                        case 127:
                            if ((2 & validActions) != 0) {
                                MediaSessionImplBase.this.mCallback.onPause();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi21 */
    static class MediaSessionImplApi21 implements MediaSessionImpl {
        private PendingIntent mMediaButtonIntent;
        private final Object mSessionObj;
        private final Token mToken = new Token(MediaSessionCompatApi21.getSessionToken(this.mSessionObj));

        public MediaSessionImplApi21(Context context, String tag) {
            this.mSessionObj = MediaSessionCompatApi21.createSession(context, tag);
        }

        public MediaSessionImplApi21(Object mediaSession) {
            this.mSessionObj = MediaSessionCompatApi21.verifySession(mediaSession);
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(Callback callback, Handler handler) {
            MediaSessionCompatApi21.setCallback(this.mSessionObj, callback == null ? null : callback.mCallbackObj, handler);
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setFlags(int flags) {
            MediaSessionCompatApi21.setFlags(this.mSessionObj, flags);
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToLocal(int stream) {
            MediaSessionCompatApi21.setPlaybackToLocal(this.mSessionObj, stream);
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToRemote(VolumeProviderCompat volumeProvider) {
            MediaSessionCompatApi21.setPlaybackToRemote(this.mSessionObj, volumeProvider.getVolumeProvider());
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setActive(boolean active) {
            MediaSessionCompatApi21.setActive(this.mSessionObj, active);
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public boolean isActive() {
            return MediaSessionCompatApi21.isActive(this.mSessionObj);
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void sendSessionEvent(String event, Bundle extras) {
            MediaSessionCompatApi21.sendSessionEvent(this.mSessionObj, event, extras);
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void release() {
            MediaSessionCompatApi21.release(this.mSessionObj);
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Token getSessionToken() {
            return this.mToken;
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackState(PlaybackStateCompat state) {
            MediaSessionCompatApi21.setPlaybackState(this.mSessionObj, state == null ? null : state.getPlaybackState());
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMetadata(MediaMetadataCompat metadata) {
            MediaSessionCompatApi21.setMetadata(this.mSessionObj, metadata == null ? null : metadata.getMediaMetadata());
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setSessionActivity(PendingIntent pi) {
            MediaSessionCompatApi21.setSessionActivity(this.mSessionObj, pi);
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMediaButtonReceiver(PendingIntent mbr) {
            this.mMediaButtonIntent = mbr;
            MediaSessionCompatApi21.setMediaButtonReceiver(this.mSessionObj, mbr);
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueue(List<QueueItem> queue) {
            List<Object> queueObjs = null;
            if (queue != null) {
                queueObjs = new ArrayList<>();
                for (QueueItem item : queue) {
                    queueObjs.add(item.getQueueItem());
                }
            }
            MediaSessionCompatApi21.setQueue(this.mSessionObj, queueObjs);
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueueTitle(CharSequence title) {
            MediaSessionCompatApi21.setQueueTitle(this.mSessionObj, title);
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRatingType(int type) {
            if (Build.VERSION.SDK_INT >= 22) {
                MediaSessionCompatApi22.setRatingType(this.mSessionObj, type);
            }
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setExtras(Bundle extras) {
            MediaSessionCompatApi21.setExtras(this.mSessionObj, extras);
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Object getMediaSession() {
            return this.mSessionObj;
        }

        @Override // android.support.p007v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Object getRemoteControlClient() {
            return null;
        }
    }
}