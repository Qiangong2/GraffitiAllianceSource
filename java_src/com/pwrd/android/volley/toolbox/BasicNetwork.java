package com.pwrd.android.volley.toolbox;

import android.os.SystemClock;
import com.pwrd.android.volley.AuthFailureError;
import com.pwrd.android.volley.Cache;
import com.pwrd.android.volley.Network;
import com.pwrd.android.volley.NetworkError;
import com.pwrd.android.volley.NetworkResponse;
import com.pwrd.android.volley.NoConnectionError;
import com.pwrd.android.volley.Request;
import com.pwrd.android.volley.RetryPolicy;
import com.pwrd.android.volley.ServerError;
import com.pwrd.android.volley.TimeoutError;
import com.pwrd.android.volley.VolleyError;
import com.pwrd.android.volley.VolleyLog;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.gcloud.voice.GCloudVoiceErrno;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.cookie.DateUtils;

public class BasicNetwork implements Network {
    protected static final boolean DEBUG = VolleyLog.DEBUG;
    private static int DEFAULT_POOL_SIZE = 4096;
    private static int SLOW_REQUEST_THRESHOLD_MS = 3000;
    private static final String TAG = "BasicNetwork";
    protected final HttpStack mHttpStack;
    protected final ByteArrayPool mPool;

    public BasicNetwork(HttpStack httpStack) {
        this(httpStack, new ByteArrayPool(DEFAULT_POOL_SIZE));
    }

    public BasicNetwork(HttpStack httpStack, ByteArrayPool pool) {
        this.mHttpStack = httpStack;
        this.mPool = pool;
    }

    private boolean isLocalFile(String requestUrl) {
        return requestUrl.startsWith("file://");
    }

    @Override // com.pwrd.android.volley.Network
    public NetworkResponse performRequest(Request<?> request) throws VolleyError {
        if (isLocalFile(request.getUrl())) {
            return performFileRequest(request);
        }
        return performNetRequest(request);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x007d A[Catch:{ IOException -> 0x00b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0093 A[Catch:{ IOException -> 0x00b0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.pwrd.android.volley.NetworkResponse performFileRequest(com.pwrd.android.volley.Request<?> r13) {
        /*
        // Method dump skipped, instructions count: 189
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pwrd.android.volley.toolbox.BasicNetwork.performFileRequest(com.pwrd.android.volley.Request):com.pwrd.android.volley.NetworkResponse");
    }

    private NetworkResponse performNetRequest(Request<?> request) throws VolleyError {
        byte[] responseContents;
        long requestStart = SystemClock.elapsedRealtime();
        while (true) {
            HttpResponse httpResponse = null;
            Map<String, String> responseHeaders = new HashMap<>();
            try {
                Map<String, String> headers = new HashMap<>();
                addCacheHeaders(headers, request.getCacheEntry());
                HttpResponse httpResponse2 = this.mHttpStack.performRequest(request, headers);
                StatusLine statusLine = httpResponse2.getStatusLine();
                int statusCode = statusLine.getStatusCode();
                Map<String, String> responseHeaders2 = convertHeaders(httpResponse2.getAllHeaders());
                if (statusCode == 304) {
                    return new NetworkResponse(GCloudVoiceErrno.GCLOUD_VOICE_TVE_START, request.getCacheEntry().data, responseHeaders2, true);
                }
                if (httpResponse2.getEntity() != null) {
                    responseContents = entityToBytes(httpResponse2.getEntity());
                } else {
                    responseContents = new byte[0];
                }
                logSlowRequests(SystemClock.elapsedRealtime() - requestStart, request, responseContents, statusLine);
                if (statusCode >= 200 && statusCode <= 299) {
                    return new NetworkResponse(statusCode, responseContents, responseHeaders2, false);
                }
                throw new IOException();
            } catch (SocketTimeoutException e) {
                attemptRetryOnException("socket", request, new TimeoutError());
            } catch (ConnectTimeoutException e2) {
                attemptRetryOnException("connection", request, new TimeoutError());
            } catch (MalformedURLException e3) {
                throw new RuntimeException("Bad URL " + request.getUrl(), e3);
            } catch (IOException e4) {
                if (0 != 0) {
                    int statusCode2 = httpResponse.getStatusLine().getStatusCode();
                    VolleyLog.m4890e("Unexpected response code %d for %s", Integer.valueOf(statusCode2), request.getUrl());
                    if (0 != 0) {
                        NetworkResponse networkResponse = new NetworkResponse(statusCode2, null, responseHeaders, false);
                        if (statusCode2 == 401 || statusCode2 == 403) {
                            attemptRetryOnException("auth", request, new AuthFailureError(networkResponse));
                        } else {
                            throw new ServerError(networkResponse);
                        }
                    } else {
                        throw new NetworkError((NetworkResponse) null);
                    }
                } else {
                    throw new NoConnectionError(e4);
                }
            }
        }
    }

    private void logSlowRequests(long requestLifetime, Request<?> request, byte[] responseContents, StatusLine statusLine) {
        if (DEBUG || requestLifetime > ((long) SLOW_REQUEST_THRESHOLD_MS)) {
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(requestLifetime);
            objArr[2] = responseContents != null ? Integer.valueOf(responseContents.length) : "null";
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(request.getRetryPolicy().getCurrentRetryCount());
            VolleyLog.m4889d("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    private static void attemptRetryOnException(String logPrefix, Request<?> request, VolleyError exception) throws VolleyError {
        RetryPolicy retryPolicy = request.getRetryPolicy();
        int oldTimeout = request.getTimeoutMs();
        try {
            retryPolicy.retry(exception);
            request.addMarker(String.format("%s-retry [timeout=%s]", logPrefix, Integer.valueOf(oldTimeout)));
        } catch (VolleyError e) {
            request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", logPrefix, Integer.valueOf(oldTimeout)));
            throw e;
        }
    }

    private void addCacheHeaders(Map<String, String> headers, Cache.Entry entry) {
        if (entry != null) {
            if (entry.etag != null) {
                headers.put(COSRequestHeaderKey.IF_NONE_MATCH, entry.etag);
            }
            if (entry.serverDate > 0) {
                headers.put(COSRequestHeaderKey.IF_MODIFIED_SINCE, DateUtils.formatDate(new Date(entry.serverDate)));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void logError(String what, String url, long start) {
        VolleyLog.m4892v("HTTP ERROR(%s) %d ms to fetch %s", what, Long.valueOf(SystemClock.elapsedRealtime() - start), url);
    }

    private byte[] entityToBytes(HttpEntity entity) throws IOException, ServerError {
        PoolingByteArrayOutputStream bytes = new PoolingByteArrayOutputStream(this.mPool, (int) entity.getContentLength());
        byte[] buffer = null;
        try {
            InputStream in = entity.getContent();
            if (in == null) {
                throw new ServerError();
            }
            buffer = this.mPool.getBuf(1024);
            while (true) {
                int count = in.read(buffer);
                if (count == -1) {
                    break;
                }
                bytes.write(buffer, 0, count);
            }
            byte[] byteArray = bytes.toByteArray();
            try {
            } catch (IOException e) {
                VolleyLog.m4892v("Error occured when calling consumingContent", new Object[0]);
            }
            return byteArray;
        } finally {
            try {
                entity.consumeContent();
            } catch (IOException e2) {
                VolleyLog.m4892v("Error occured when calling consumingContent", new Object[0]);
            }
            this.mPool.returnBuf(buffer);
            bytes.close();
        }
    }

    private static Map<String, String> convertHeaders(Header[] headers) {
        Map<String, String> result = new HashMap<>();
        for (int i = 0; i < headers.length; i++) {
            result.put(headers[i].getName(), headers[i].getValue());
        }
        return result;
    }
}
