package com.tencent.qcloud.core.http;

import android.support.p007v4.media.session.PlaybackStateCompat;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;

/* access modifiers changed from: package-private */
public final class HttpLoggingInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private volatile Level level;
    private final Logger logger;

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public interface Logger {
        public static final Logger DEFAULT = new Logger() {
            /* class com.tencent.qcloud.core.http.HttpLoggingInterceptor.Logger.C13241 */

            @Override // com.tencent.qcloud.core.http.HttpLoggingInterceptor.Logger
            public void log(String message) {
                Platform.get().log(4, message, null);
            }
        };

        void log(String str);
    }

    public HttpLoggingInterceptor() {
        this(Logger.DEFAULT);
    }

    public HttpLoggingInterceptor(Logger logger2) {
        this.level = Level.NONE;
        this.logger = logger2;
    }

    public HttpLoggingInterceptor setLevel(Level level2) {
        if (level2 == null) {
            throw new NullPointerException("level == null. Use Level.NONE instead.");
        }
        this.level = level2;
        return this;
    }

    public Level getLevel() {
        return this.level;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Level level2 = this.level;
        Request request = chain.request();
        if (level2 == Level.NONE) {
            return chain.proceed(request);
        }
        boolean logBody = level2 == Level.BODY;
        boolean logHeaders = logBody || level2 == Level.HEADERS;
        RequestBody requestBody = request.body();
        boolean hasRequestBody = requestBody != null;
        Connection connection = chain.connection();
        String requestStartMessage = "--> " + request.method() + ' ' + request.url() + ' ' + (connection != null ? connection.protocol() : Protocol.HTTP_1_1);
        if (!logHeaders && hasRequestBody) {
            requestStartMessage = requestStartMessage + " (" + requestBody.contentLength() + "-byte body)";
        }
        this.logger.log(requestStartMessage);
        if (logHeaders) {
            if (hasRequestBody) {
                if (requestBody.contentType() != null) {
                    this.logger.log("Content-Type: " + requestBody.contentType());
                }
                if (requestBody.contentLength() != -1) {
                    this.logger.log("Content-Length: " + requestBody.contentLength());
                }
            }
            Headers headers = request.headers();
            int count = headers.size();
            for (int i = 0; i < count; i++) {
                String name = headers.name(i);
                if (!HttpConstants.Header.CONTENT_TYPE.equalsIgnoreCase(name) && !HttpConstants.Header.CONTENT_LENGTH.equalsIgnoreCase(name)) {
                    this.logger.log(name + ": " + headers.value(i));
                }
            }
            if (!logBody || !hasRequestBody || isContentLengthTooLarge(requestBody.contentLength())) {
                this.logger.log("--> END " + request.method());
            } else if (bodyEncoded(request.headers())) {
                this.logger.log("--> END " + request.method() + " (encoded body omitted)");
            } else {
                try {
                    Buffer buffer = new Buffer();
                    requestBody.writeTo(buffer);
                    Charset charset = UTF8;
                    MediaType contentType = requestBody.contentType();
                    if (contentType != null) {
                        charset = contentType.charset(UTF8);
                    }
                    this.logger.log("");
                    if (isPlaintext(buffer)) {
                        this.logger.log(buffer.readString(charset));
                        this.logger.log("--> END " + request.method() + " (" + requestBody.contentLength() + "-byte body)");
                    } else {
                        this.logger.log("--> END " + request.method() + " (binary " + requestBody.contentLength() + "-byte body omitted)");
                    }
                } catch (Exception e) {
                    this.logger.log("--> END " + request.method());
                }
            }
        }
        long startNs = System.nanoTime();
        try {
            Response response = chain.proceed(request);
            long tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs);
            ResponseBody responseBody = response.body();
            boolean hasResponseBody = responseBody != null;
            long contentLength = hasResponseBody ? responseBody.contentLength() : 0;
            this.logger.log("<-- " + response.code() + ' ' + response.message() + ' ' + response.request().url() + " (" + tookMs + "ms" + (!logHeaders ? ", " + (contentLength != -1 ? contentLength + "-byte" : "unknown-length") + " body" : "") + ')');
            if (!logHeaders) {
                return response;
            }
            Headers headers2 = response.headers();
            int count2 = headers2.size();
            for (int i2 = 0; i2 < count2; i2++) {
                this.logger.log(headers2.name(i2) + ": " + headers2.value(i2));
            }
            if (!logBody || !HttpHeaders.hasBody(response) || !hasResponseBody || isContentLengthTooLarge(contentLength)) {
                this.logger.log("<-- END HTTP");
                return response;
            } else if (bodyEncoded(response.headers())) {
                this.logger.log("<-- END HTTP (encoded body omitted)");
                return response;
            } else {
                try {
                    BufferedSource source = responseBody.source();
                    source.request(Long.MAX_VALUE);
                    Buffer buffer2 = source.buffer();
                    Charset charset2 = UTF8;
                    MediaType contentType2 = responseBody.contentType();
                    if (contentType2 != null) {
                        try {
                            charset2 = contentType2.charset(UTF8);
                        } catch (UnsupportedCharsetException e2) {
                            this.logger.log("");
                            this.logger.log("Couldn't decode the response body; charset is likely malformed.");
                            this.logger.log("<-- END HTTP");
                            return response;
                        }
                    }
                    if (!isPlaintext(buffer2)) {
                        this.logger.log("");
                        this.logger.log("<-- END HTTP (binary " + buffer2.size() + "-byte body omitted)");
                        return response;
                    }
                    if (contentLength != 0) {
                        this.logger.log("");
                        this.logger.log(buffer2.clone().readString(charset2));
                    }
                    this.logger.log("<-- END HTTP (" + buffer2.size() + "-byte body)");
                    return response;
                } catch (Exception e3) {
                    this.logger.log("<-- END HTTP");
                    return response;
                }
            }
        } catch (Exception e4) {
            this.logger.log("<-- HTTP FAILED: " + e4);
            throw e4;
        }
    }

    private boolean isContentLengthTooLarge(long contentLength) {
        return contentLength > PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
    }

    static boolean isPlaintext(Buffer buffer) {
        long byteCount = 64;
        try {
            Buffer prefix = new Buffer();
            if (buffer.size() < 64) {
                byteCount = buffer.size();
            }
            buffer.copyTo(prefix, 0, byteCount);
            for (int i = 0; i < 16 && !prefix.exhausted(); i++) {
                int codePoint = prefix.readUtf8CodePoint();
                if (Character.isISOControl(codePoint) && !Character.isWhitespace(codePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException e) {
            return false;
        }
    }

    private boolean bodyEncoded(Headers headers) {
        String contentEncoding = headers.get(COSRequestHeaderKey.CONTENT_ENCODING);
        return contentEncoding != null && !contentEncoding.equalsIgnoreCase("identity");
    }
}
