package com.pwrd.android.volley.toolbox;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import com.pwrd.android.volley.Request;
import com.pwrd.android.volley.RequestQueue;
import com.pwrd.android.volley.Response;
import com.pwrd.android.volley.VolleyError;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ImageLoader {
    private static final HashSet<String> BAD_URLS = new HashSet<>();
    private static final String TAG = "ImageLoader";
    private int mBatchResponseDelayMs = 100;
    private final HashMap<String, BatchedImageRequest> mBatchedResponses = new HashMap<>();
    private final ImageCache mCache;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final HashMap<String, LoadFromDiskTask> mInFlightLoaders = new HashMap<>();
    private final HashMap<String, BatchedImageRequest> mInFlightRequests = new HashMap<>();
    private final RequestQueue mRequestQueue;
    private Runnable mRunnable;

    public interface ImageCache {
        void addBitmapToCache(String str, Bitmap bitmap, Bitmap.CompressFormat compressFormat);

        void addBitmapToMemCache(String str, Bitmap bitmap);

        Bitmap getBitmapFromDiskCache(String str, int i, int i2);

        Bitmap getBitmapFromMemCache(String str);

        String getCacheKey(String str);
    }

    public interface ImageListener extends Response.ErrorListener {
        void onResponse(ImageContainer imageContainer, boolean z);
    }

    public ImageLoader(RequestQueue queue, ImageCache imageCache) {
        this.mRequestQueue = queue;
        this.mCache = imageCache;
    }

    public static ImageListener getImageListener(final ImageView imageView, final int defaultImageResId, final int errorImageResId) {
        return new ImageListener() {
            /* class com.pwrd.android.volley.toolbox.ImageLoader.C12261 */

            @Override // com.pwrd.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError error) {
                if (errorImageResId != 0) {
                    imageView.setImageResource(errorImageResId);
                }
            }

            @Override // com.pwrd.android.volley.toolbox.ImageLoader.ImageListener
            public void onResponse(ImageContainer response, boolean isImmediate) {
                if (response.getBitmap() != null) {
                    imageView.setImageBitmap(response.getBitmap());
                } else if (defaultImageResId != 0) {
                    imageView.setImageResource(defaultImageResId);
                }
            }
        };
    }

    public boolean isMemCached(String requestUrl) {
        throwIfNotOnMainThread();
        return this.mCache.getBitmapFromMemCache(requestUrl) != null;
    }

    public ImageContainer get(String requestUrl, ImageListener listener) {
        return get(requestUrl, listener, 0, 0);
    }

    public ImageContainer get(String requestUrl, ImageListener imageListener, int maxWidth, int maxHeight) {
        if (TextUtils.isEmpty(requestUrl)) {
            imageListener.onErrorResponse(new VolleyError("empty_url"));
            return null;
        }
        throwIfNotOnMainThread();
        if (BAD_URLS.contains(requestUrl)) {
            imageListener.onErrorResponse(new VolleyError("bad url, tried, ignore this time"));
            return null;
        }
        String cacheKey = this.mCache.getCacheKey(requestUrl);
        Bitmap cachedBitmap = this.mCache.getBitmapFromMemCache(requestUrl);
        if (cachedBitmap != null) {
            ImageContainer container = new ImageContainer(cachedBitmap, requestUrl, null, null);
            imageListener.onResponse(container, true);
            return container;
        }
        ImageContainer imageContainer = new ImageContainer(null, requestUrl, cacheKey, imageListener);
        imageListener.onResponse(imageContainer, true);
        synchronized (this.mInFlightLoaders) {
            LoadFromDiskTask loadFromDiskTask = this.mInFlightLoaders.get(cacheKey);
            if (loadFromDiskTask == null || loadFromDiskTask.isCancelled()) {
                synchronized (this.mInFlightRequests) {
                    try {
                        BatchedImageRequest request = this.mInFlightRequests.get(cacheKey);
                        if (request != null) {
                            request.addContainer(imageContainer);
                        } else {
                            Log.d(TAG, "not existed in disk, start download, url:" + requestUrl);
                            LoadFromDiskTask loadFromDiskTask2 = new LoadFromDiskTask(this, cacheKey, requestUrl, maxWidth, maxHeight, imageContainer, null);
                            this.mInFlightLoaders.put(cacheKey, loadFromDiskTask2);
                            loadFromDiskTask2.execute(new String[0]);
                        }
                        try {
                            return imageContainer;
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
            } else {
                Log.d(TAG, "loading from disk:" + requestUrl);
                loadFromDiskTask.addContainer(imageContainer);
                return imageContainer;
            }
        }
    }

    public void clearBadRecords() {
        Log.d(TAG, "bad records cleared");
        BAD_URLS.clear();
    }

    public void setBatchedResponseDelay(int newBatchedResponseDelayMs) {
        this.mBatchResponseDelayMs = newBatchedResponseDelayMs;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onGetImageSuccess(String cacheKey, Bitmap response) {
        this.mCache.addBitmapToCache(cacheKey, response, Bitmap.CompressFormat.PNG);
        BatchedImageRequest request = this.mInFlightRequests.remove(cacheKey);
        if (request != null) {
            request.mResponseBitmap = response;
            batchResponse(cacheKey, request);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onGetImageError(String cacheKey, VolleyError error) {
        BatchedImageRequest request = this.mInFlightRequests.remove(cacheKey);
        if (request != null) {
            request.setError(error);
            batchResponse(cacheKey, request);
        }
    }

    public class ImageContainer {
        private Bitmap mBitmap;
        private final String mCacheKey;
        private ImageListener mListener;
        private final String mRequestUrl;

        public ImageContainer(Bitmap bitmap, String requestUrl, String cacheKey, ImageListener listener) {
            this.mBitmap = bitmap;
            this.mRequestUrl = requestUrl;
            this.mCacheKey = cacheKey;
            this.mListener = listener;
        }

        public void deleteListener() {
            this.mListener = null;
        }

        public void cancelRequest() {
            if (this.mListener != null) {
                synchronized (ImageLoader.this.mInFlightRequests) {
                    LoadFromDiskTask loadTask = (LoadFromDiskTask) ImageLoader.this.mInFlightLoaders.get(this.mCacheKey);
                    if (loadTask != null && loadTask.cancel(true)) {
                        ImageLoader.this.mInFlightLoaders.remove(this.mCacheKey);
                    }
                }
                synchronized (ImageLoader.this.mInFlightRequests) {
                    BatchedImageRequest request = (BatchedImageRequest) ImageLoader.this.mInFlightRequests.get(this.mCacheKey);
                    if (request == null) {
                        BatchedImageRequest request2 = (BatchedImageRequest) ImageLoader.this.mBatchedResponses.get(this.mCacheKey);
                        if (request2 != null) {
                            request2.removeContainerAndCancelIfNecessary(this);
                            if (request2.mContainers.size() == 0) {
                                ImageLoader.this.mBatchedResponses.remove(this.mCacheKey);
                            }
                        }
                    } else if (request.removeContainerAndCancelIfNecessary(this)) {
                        ImageLoader.this.mInFlightRequests.remove(this.mCacheKey);
                    }
                }
            }
        }

        public Bitmap getBitmap() {
            return this.mBitmap;
        }

        public String getRequestUrl() {
            return this.mRequestUrl;
        }
    }

    /* access modifiers changed from: private */
    public class LoadFromDiskTask extends AsyncTask<String, Void, Bitmap> {
        private String cacheKey;
        private final HashSet<ImageContainer> mContainers;
        private int maxHeight;
        private int maxWidth;
        private String requestUrl;

        private LoadFromDiskTask(String cacheKey2, String requestUrl2, int maxWidth2, int maxHeight2, ImageContainer container) {
            this.mContainers = new HashSet<>();
            this.cacheKey = cacheKey2;
            this.requestUrl = requestUrl2;
            this.maxWidth = maxWidth2;
            this.maxHeight = maxHeight2;
            this.mContainers.add(container);
        }

        /* synthetic */ LoadFromDiskTask(ImageLoader imageLoader, String str, String str2, int i, int i2, ImageContainer imageContainer, LoadFromDiskTask loadFromDiskTask) {
            this(str, str2, i, i2, imageContainer);
        }

        /* access modifiers changed from: protected */
        public Bitmap doInBackground(String... params) {
            return ImageLoader.this.mCache.getBitmapFromDiskCache(this.cacheKey, this.maxWidth, this.maxHeight);
        }

        public void addContainer(ImageContainer imageContainer) {
            this.mContainers.add(imageContainer);
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                loadedFromDisk(bitmap);
            } else {
                tryAddRequest();
            }
            synchronized (ImageLoader.this.mInFlightRequests) {
                onLoadImageFinish(this.cacheKey, bitmap);
            }
            super.onPostExecute((Object) bitmap);
        }

        private void loadedFromDisk(Bitmap bitmap) {
            Iterator<ImageContainer> it = this.mContainers.iterator();
            while (it.hasNext()) {
                ImageContainer container = it.next();
                if (container.mListener != null) {
                    container.mBitmap = bitmap;
                    Log.d(ImageLoader.TAG, "get bitmap from disk, url:" + this.requestUrl);
                    container.mListener.onResponse(container, false);
                }
            }
        }

        private void tryAddRequest() {
            synchronized (ImageLoader.this.mInFlightRequests) {
                BatchedImageRequest request = (BatchedImageRequest) ImageLoader.this.mInFlightRequests.get(this.cacheKey);
                if (request != null) {
                    Log.d(ImageLoader.TAG, "not existed in disk, downloading, url:" + this.requestUrl);
                    request.addContainers(this.mContainers);
                } else {
                    Log.d(ImageLoader.TAG, "not existed in disk, start download, url:" + this.requestUrl);
                    BatchedImageRequest request2 = (BatchedImageRequest) ImageLoader.this.mInFlightRequests.get(this.cacheKey);
                    if (request2 != null) {
                        Iterator<ImageContainer> it = this.mContainers.iterator();
                        while (it.hasNext()) {
                            request2.addContainer(it.next());
                        }
                    } else {
                        Request<?> newRequest = new ImageRequest(this.requestUrl, new Response.Listener<Bitmap>() {
                            /* class com.pwrd.android.volley.toolbox.ImageLoader.LoadFromDiskTask.C12281 */

                            public void onResponse(Bitmap response) {
                                ImageLoader.this.onGetImageSuccess(LoadFromDiskTask.this.cacheKey, response);
                            }
                        }, this.maxWidth, this.maxHeight, Bitmap.Config.RGB_565, new Response.ErrorListener() {
                            /* class com.pwrd.android.volley.toolbox.ImageLoader.LoadFromDiskTask.C12292 */

                            @Override // com.pwrd.android.volley.Response.ErrorListener
                            public void onErrorResponse(VolleyError error) {
                                ImageLoader.this.onGetImageError(LoadFromDiskTask.this.cacheKey, error);
                                ImageLoader.BAD_URLS.add(LoadFromDiskTask.this.requestUrl);
                            }
                        });
                        newRequest.setShouldCache(false);
                        ImageLoader.this.mRequestQueue.add(newRequest);
                        ImageLoader.this.mInFlightRequests.put(this.cacheKey, new BatchedImageRequest(newRequest, this.mContainers));
                    }
                }
            }
        }

        private void onLoadImageFinish(String cacheKey2, Bitmap response) {
            if (response != null) {
                ImageLoader.this.mCache.addBitmapToMemCache(cacheKey2, response);
            }
            ImageLoader.this.mInFlightLoaders.remove(cacheKey2);
        }
    }

    /* access modifiers changed from: private */
    public class BatchedImageRequest {
        private final HashSet<ImageContainer> mContainers = new HashSet<>();
        private VolleyError mError;
        private final Request<?> mRequest;
        private Bitmap mResponseBitmap;

        public BatchedImageRequest(Request<?> request, HashSet<ImageContainer> container) {
            this.mRequest = request;
            this.mContainers.addAll(container);
        }

        public void setError(VolleyError error) {
            this.mError = error;
        }

        public VolleyError getError() {
            return this.mError;
        }

        public void addContainer(ImageContainer container) {
            this.mContainers.add(container);
        }

        public boolean removeContainerAndCancelIfNecessary(ImageContainer container) {
            this.mContainers.remove(container);
            if (this.mContainers.size() != 0) {
                return false;
            }
            this.mRequest.cancel();
            return true;
        }

        public void addContainers(HashSet<ImageContainer> containers) {
            this.mContainers.addAll(containers);
        }
    }

    private void batchResponse(String cacheKey, BatchedImageRequest request) {
        this.mBatchedResponses.put(cacheKey, request);
        if (this.mRunnable == null) {
            this.mRunnable = new Runnable() {
                /* class com.pwrd.android.volley.toolbox.ImageLoader.RunnableC12272 */

                public void run() {
                    for (BatchedImageRequest bir : ImageLoader.this.mBatchedResponses.values()) {
                        Iterator it = bir.mContainers.iterator();
                        while (it.hasNext()) {
                            ImageContainer container = (ImageContainer) it.next();
                            if (container.mListener != null) {
                                if (bir.getError() == null) {
                                    container.mBitmap = bir.mResponseBitmap;
                                    container.mListener.onResponse(container, false);
                                } else {
                                    container.mListener.onErrorResponse(bir.getError());
                                }
                            }
                        }
                    }
                    ImageLoader.this.mBatchedResponses.clear();
                    ImageLoader.this.mRunnable = null;
                }
            };
            this.mHandler.postDelayed(this.mRunnable, (long) this.mBatchResponseDelayMs);
        }
    }

    private void throwIfNotOnMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
        }
    }

    private static String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes) {
            String hex = Integer.toHexString(aByte & 255);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }
}
