package com.pwrd.android.volley.toolbox;

import android.os.Handler;
import android.os.Looper;
import com.pwrd.android.volley.Cache;
import com.pwrd.android.volley.NetworkResponse;
import com.pwrd.android.volley.Request;
import com.pwrd.android.volley.Response;

public class ClearCacheRequest extends Request<Object> {
    private final Cache mCache;
    private final Runnable mCallback;

    public ClearCacheRequest(Cache cache, Runnable callback) {
        super(0, null, null);
        this.mCache = cache;
        this.mCallback = callback;
    }

    @Override // com.pwrd.android.volley.Request
    public boolean isCanceled() {
        this.mCache.clear();
        if (this.mCallback == null) {
            return true;
        }
        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(this.mCallback);
        return true;
    }

    @Override // com.pwrd.android.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.IMMEDIATE;
    }

    /* access modifiers changed from: protected */
    @Override // com.pwrd.android.volley.Request
    public Response<Object> parseNetworkResponse(NetworkResponse response) {
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // com.pwrd.android.volley.Request
    public void deliverResponse(Object response) {
    }
}
