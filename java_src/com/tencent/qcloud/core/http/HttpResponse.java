package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.common.QCloudServiceException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import okhttp3.Response;

public final class HttpResponse<T> {
    final HttpRequest<T> request;
    final Response response;

    HttpResponse(HttpRequest<T> request2, Response response2) {
        this.request = request2;
        this.response = response2;
    }

    public HttpRequest<T> request() {
        return this.request;
    }

    public int code() {
        return this.response.code();
    }

    public String message() {
        return this.response.message();
    }

    public String header(String name) {
        return this.response.header(name);
    }

    public Map<String, List<String>> headers() {
        return this.response.headers().toMultimap();
    }

    public final long contentLength() {
        if (this.response.body() == null) {
            return 0;
        }
        return this.response.body().contentLength();
    }

    public final InputStream byteStream() {
        if (this.response.body() == null) {
            return null;
        }
        return this.response.body().byteStream();
    }

    public final byte[] bytes() throws IOException {
        if (this.response.body() == null) {
            return null;
        }
        return this.response.body().bytes();
    }

    public final String string() throws IOException {
        if (this.response.body() == null) {
            return null;
        }
        return this.response.body().string();
    }

    public final boolean isSuccessful() {
        return this.response != null && this.response.isSuccessful();
    }

    public static void checkResponseSuccessful(HttpResponse response2) throws QCloudServiceException {
        if (response2 == null) {
            throw new QCloudServiceException("response is null");
        } else if (!response2.isSuccessful()) {
            QCloudServiceException exception = new QCloudServiceException(response2.message());
            exception.setStatusCode(response2.code());
            throw exception;
        }
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "http code = %d, http message = %s %nheader is %s", Integer.valueOf(code()), message(), this.response.headers().toMultimap());
    }
}
