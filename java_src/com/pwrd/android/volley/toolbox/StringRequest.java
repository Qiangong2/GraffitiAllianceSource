package com.pwrd.android.volley.toolbox;

import com.pwrd.android.volley.NetworkResponse;
import com.pwrd.android.volley.Request;
import com.pwrd.android.volley.Response;
import java.io.UnsupportedEncodingException;

public class StringRequest extends Request<String> {
    private final Response.Listener<String> mListener;

    public StringRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.mListener = listener;
    }

    public StringRequest(String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        this(0, url, listener, errorListener);
    }

    /* access modifiers changed from: protected */
    public void deliverResponse(String response) {
        this.mListener.onResponse(response);
    }

    /* access modifiers changed from: protected */
    @Override // com.pwrd.android.volley.Request
    public Response<String> parseNetworkResponse(NetworkResponse response) {
        String parsed;
        try {
            parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        } catch (UnsupportedEncodingException e) {
            parsed = new String(response.data);
        }
        return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
    }
}
