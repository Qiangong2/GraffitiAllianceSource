package com.pwrd.android.volley.plus;

import android.text.TextUtils;
import com.pwrd.android.volley.AuthFailureError;
import com.pwrd.android.volley.NetworkResponse;
import com.pwrd.android.volley.Request;
import com.pwrd.android.volley.Response;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public abstract class RequestPro<T> extends Request<T> {
    private Map<String, String> params;
    private Response.Listener<T> successListener;

    public RequestPro(int method, String url, Map<String, String> params2, Response.Listener<T> successListener2, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.successListener = successListener2;
        this.params = params2;
    }

    private String mergeGetUrl() {
        String url = super.getUrl();
        if (url.endsWith("?")) {
            return String.valueOf(url) + getEncodedParameters(this.params, getParamsEncoding());
        }
        return String.valueOf(super.getUrl()) + "?" + getEncodedParameters(this.params, getParamsEncoding());
    }

    @Override // com.pwrd.android.volley.Request
    public String getUrl() {
        if (getMethod() == 0) {
            return mergeGetUrl();
        }
        return super.getUrl();
    }

    /* access modifiers changed from: protected */
    @Override // com.pwrd.android.volley.Request
    public Response<T> parseNetworkResponse(NetworkResponse response) {
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // com.pwrd.android.volley.Request
    public void deliverResponse(T response) {
        this.successListener.onResponse(response);
    }

    /* access modifiers changed from: protected */
    @Override // com.pwrd.android.volley.Request
    public Map<String, String> getParams() throws AuthFailureError {
        return this.params;
    }

    @Override // com.pwrd.android.volley.Request
    public String getCacheKey() {
        try {
            return String.valueOf(getUrl()) + "?" + getEncodedParameters(getParams(), getParamsEncoding());
        } catch (AuthFailureError authFailureError) {
            authFailureError.printStackTrace();
            return getUrl();
        }
    }

    @Override // com.pwrd.android.volley.Request
    public byte[] getBody() throws AuthFailureError {
        Map<String, String> params2 = getParams();
        if (params2 == null || params2.size() <= 0) {
            return null;
        }
        return getEncodedParameters(params2, getParamsEncoding()).getBytes();
    }

    protected static String getEncodedParameters(Map<String, String> params2, String paramsEncoding) {
        if (params2 == null || params2.isEmpty()) {
            return "";
        }
        StringBuilder encodedParams = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : params2.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                    encodedParams.append(URLEncoder.encode(entry.getKey(), paramsEncoding));
                    encodedParams.append('=');
                    encodedParams.append(URLEncoder.encode(entry.getValue(), paramsEncoding));
                    encodedParams.append('&');
                }
            }
            return encodedParams.toString();
        } catch (UnsupportedEncodingException uee) {
            throw new RuntimeException("Encoding not supported: " + paramsEncoding, uee);
        }
    }
}
