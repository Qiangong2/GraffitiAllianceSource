package com.pwrd.android.volley.toolbox;

import com.pwrd.android.volley.NetworkResponse;
import com.pwrd.android.volley.Request;
import com.pwrd.android.volley.Response;
import com.pwrd.android.volley.VolleyLog;
import java.io.UnsupportedEncodingException;

public abstract class JsonRequest<T> extends Request<T> {
    private static final String PROTOCOL_CHARSET = "utf-8";
    private static final String PROTOCOL_CONTENT_TYPE = String.format("application/json; charset=%s", PROTOCOL_CHARSET);
    private final Response.Listener<T> mListener;
    private final String mRequestBody;

    /* access modifiers changed from: protected */
    @Override // com.pwrd.android.volley.Request
    public abstract Response<T> parseNetworkResponse(NetworkResponse networkResponse);

    public JsonRequest(String url, String requestBody, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        this(-1, url, requestBody, listener, errorListener);
    }

    public JsonRequest(int method, String url, String requestBody, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.mListener = listener;
        this.mRequestBody = requestBody;
    }

    /* access modifiers changed from: protected */
    @Override // com.pwrd.android.volley.Request
    public void deliverResponse(T response) {
        this.mListener.onResponse(response);
    }

    @Override // com.pwrd.android.volley.Request
    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    @Override // com.pwrd.android.volley.Request
    public byte[] getPostBody() {
        return getBody();
    }

    @Override // com.pwrd.android.volley.Request
    public String getBodyContentType() {
        return PROTOCOL_CONTENT_TYPE;
    }

    @Override // com.pwrd.android.volley.Request
    public byte[] getBody() {
        try {
            if (this.mRequestBody == null) {
                return null;
            }
            return this.mRequestBody.getBytes(PROTOCOL_CHARSET);
        } catch (UnsupportedEncodingException e) {
            VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", this.mRequestBody, PROTOCOL_CHARSET);
            return null;
        }
    }
}
