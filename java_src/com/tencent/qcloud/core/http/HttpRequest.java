package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.auth.QCloudSignSourceProvider;
import com.tencent.qcloud.core.auth.QCloudSigner;
import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.http.HttpConstants;
import com.tencent.qcloud.core.util.QCloudStringUtils;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.CacheControl;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.pwrd.paho.client.mqttv3.MqttTopic;

public class HttpRequest<T> {
    private final boolean calculateContentMD5;
    private final Map<String, List<String>> headers;
    private final String method;
    private final RequestBody requestBody;
    private final Request.Builder requestBuilder;
    private final ResponseBodyConverter<T> responseBodyConverter;
    private final Object tag;
    private final URL url;

    HttpRequest(Builder<T> builder) {
        this.requestBuilder = builder.requestBuilder;
        this.responseBodyConverter = builder.responseBodyConverter;
        this.headers = builder.headers;
        this.method = builder.method;
        this.calculateContentMD5 = builder.calculateContentMD5;
        if (builder.tag == null) {
            this.tag = toString();
        } else {
            this.tag = builder.tag;
        }
        this.url = builder.httpUrlBuilder.build().url();
        if (builder.requestBodySerializer != null) {
            this.requestBody = builder.requestBodySerializer.body();
        } else {
            this.requestBody = null;
        }
        this.requestBuilder.method(builder.method, this.requestBody);
    }

    public Map<String, List<String>> headers() {
        return this.headers;
    }

    public String header(String name) {
        List<String> values = this.headers.get(name);
        if (values != null) {
            return values.get(0);
        }
        return null;
    }

    public Object tag() {
        return this.tag;
    }

    /* access modifiers changed from: package-private */
    public void setOkHttpRequestTag(String tag2) {
        this.requestBuilder.tag(tag2);
    }

    public void addHeader(String name, String value) {
        List<String> values = this.headers.get(name);
        if (values == null || values.size() < 1) {
            this.requestBuilder.addHeader(name, value);
            addHeaderNameValue(this.headers, name, value);
        }
    }

    public void removeHeader(String name) {
        this.requestBuilder.removeHeader(name);
        this.headers.remove(name);
    }

    /* access modifiers changed from: package-private */
    public boolean shouldCalculateContentMD5() {
        return this.calculateContentMD5 && QCloudStringUtils.isEmpty(header(HttpConstants.Header.MD5));
    }

    public String method() {
        return this.method;
    }

    public String host() {
        return this.url.getHost();
    }

    public String contentType() {
        MediaType mediaType = this.requestBody.contentType();
        if (mediaType != null) {
            return mediaType.toString();
        }
        return null;
    }

    public long contentLength() throws IOException {
        return this.requestBody.contentLength();
    }

    public URL url() {
        return this.url;
    }

    /* access modifiers changed from: package-private */
    public ResponseBodyConverter<T> getResponseBodyConverter() {
        return this.responseBodyConverter;
    }

    /* access modifiers changed from: package-private */
    public RequestBody getRequestBody() {
        return this.requestBody;
    }

    /* access modifiers changed from: package-private */
    public Request buildRealRequest() {
        return this.requestBuilder.build();
    }

    /* access modifiers changed from: package-private */
    public QCloudSignSourceProvider getSignProvider() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public QCloudSigner getQCloudSigner() throws QCloudClientException {
        return null;
    }

    /* access modifiers changed from: private */
    public static void addHeaderNameValue(Map<String, List<String>> headers2, String name, String value) {
        List<String> values = headers2.get(name);
        if (values == null) {
            values = new ArrayList<>(2);
            headers2.put(name, values);
        }
        values.add(value.trim());
    }

    public static class Builder<T> {
        boolean calculateContentMD5;
        Map<String, List<String>> headers = new HashMap(10);
        HttpUrl.Builder httpUrlBuilder = new HttpUrl.Builder();
        boolean isCacheEnabled = true;
        String method;
        RequestBodySerializer requestBodySerializer;
        Request.Builder requestBuilder = new Request.Builder();
        ResponseBodyConverter<T> responseBodyConverter;
        Object tag;

        public Builder<T> url(URL url) {
            HttpUrl httpUrl = HttpUrl.get(url);
            if (httpUrl == null) {
                throw new IllegalArgumentException("url is not legal : " + url);
            }
            this.httpUrlBuilder = httpUrl.newBuilder();
            return this;
        }

        public Builder<T> scheme(String scheme) {
            this.httpUrlBuilder.scheme(scheme);
            return this;
        }

        public Builder<T> tag(Object tag2) {
            this.tag = tag2;
            return this;
        }

        public Builder<T> host(String host) {
            this.httpUrlBuilder.host(host);
            return this;
        }

        public Builder<T> path(String path) {
            if (path.startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
                path = path.substring(1);
            }
            if (path.length() > 0) {
                this.httpUrlBuilder.addPathSegments(path);
            }
            return this;
        }

        public Builder<T> method(String method2) {
            this.method = method2;
            return this;
        }

        public Builder<T> query(String key, String value) {
            if (key != null) {
                this.httpUrlBuilder.addQueryParameter(key, value);
            }
            return this;
        }

        public Builder<T> encodedQuery(String key, String value) {
            if (key != null) {
                this.httpUrlBuilder.addEncodedQueryParameter(key, value);
            }
            return this;
        }

        public Builder<T> query(Map<String, String> nameValues) {
            if (nameValues != null) {
                for (Map.Entry<String, String> entry : nameValues.entrySet()) {
                    String name = entry.getKey();
                    if (name != null) {
                        this.httpUrlBuilder.addQueryParameter(name, entry.getValue());
                    }
                }
            }
            return this;
        }

        public Builder<T> encodedQuery(Map<String, String> nameValues) {
            if (nameValues != null) {
                for (Map.Entry<String, String> entry : nameValues.entrySet()) {
                    String name = entry.getKey();
                    if (name != null) {
                        this.httpUrlBuilder.addEncodedQueryParameter(name, entry.getValue());
                    }
                }
            }
            return this;
        }

        public Builder<T> contentMD5() {
            this.calculateContentMD5 = true;
            return this;
        }

        public Builder<T> addHeader(String name, String value) {
            if (!(name == null || value == null)) {
                this.requestBuilder.addHeader(name, value);
                HttpRequest.addHeaderNameValue(this.headers, name, value);
            }
            return this;
        }

        public Builder<T> addHeaders(Map<String, List<String>> headers2) {
            if (headers2 != null) {
                for (Map.Entry<String, List<String>> entry : headers2.entrySet()) {
                    String name = entry.getKey();
                    for (String value : entry.getValue()) {
                        if (!(name == null || value == null)) {
                            this.requestBuilder.addHeader(name, value);
                            HttpRequest.addHeaderNameValue(headers2, name, value);
                        }
                    }
                }
            }
            return this;
        }

        public Builder<T> removeHeader(String name) {
            this.requestBuilder.removeHeader(name);
            this.headers.remove(name);
            return this;
        }

        public Builder<T> userAgent(String userAgent) {
            this.requestBuilder.addHeader(HttpConstants.Header.USER_AGENT, userAgent);
            return this;
        }

        public Builder<T> setUseCache(boolean cacheEnabled) {
            this.isCacheEnabled = cacheEnabled;
            return this;
        }

        public Builder<T> body(RequestBodySerializer bodySerializer) {
            this.requestBodySerializer = bodySerializer;
            return this;
        }

        public Builder<T> converter(ResponseBodyConverter<T> responseBodyConverter2) {
            this.responseBodyConverter = responseBodyConverter2;
            return this;
        }

        /* access modifiers changed from: protected */
        public void prepareBuild() {
            this.requestBuilder.url(this.httpUrlBuilder.build());
            if (!this.isCacheEnabled) {
                this.requestBuilder.cacheControl(CacheControl.FORCE_NETWORK);
            }
            if (this.responseBodyConverter == null) {
                this.responseBodyConverter = (ResponseBodyConverter<T>) ResponseBodyConverter.string();
            }
        }

        public HttpRequest<T> build() {
            prepareBuild();
            return new HttpRequest<>(this);
        }
    }
}
