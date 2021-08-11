package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.common.QCloudServiceException;
import java.util.List;
import java.util.Map;

public final class HttpResult<T> {
    private final int code;
    private final T content;
    private final Map<String, List<String>> headers;
    private final String message;
    private final HttpRequest<T> request;

    HttpResult(HttpResponse<T> response, T content2) {
        this.code = response.code();
        this.message = response.message();
        this.headers = response.response.headers().toMultimap();
        this.content = content2;
        this.request = response.request;
    }

    public T content() {
        return this.content;
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public HttpRequest<T> request() {
        return this.request;
    }

    public Map<String, List<String>> headers() {
        return this.headers;
    }

    public final boolean isSuccessful() {
        return this.code >= 200 && this.code < 300;
    }

    public QCloudServiceException asException() {
        QCloudServiceException exception = new QCloudServiceException(this.message);
        exception.setStatusCode(this.code);
        return exception;
    }

    public String header(String name) {
        List<String> values = this.headers.get(name);
        if (values == null || values.size() <= 0) {
            return null;
        }
        return values.get(0);
    }
}
