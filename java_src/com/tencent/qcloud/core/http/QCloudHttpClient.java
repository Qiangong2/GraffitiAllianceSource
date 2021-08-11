package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.auth.QCloudCredentialProvider;
import com.tencent.qcloud.core.http.HttpConstants;
import com.tencent.qcloud.core.http.HttpLoggingInterceptor;
import com.tencent.qcloud.core.logger.QCloudLogger;
import com.tencent.qcloud.core.task.Task;
import com.tencent.qcloud.core.task.TaskManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public final class QCloudHttpClient {
    private static final QCloudHttpClient DEFAULT = new Builder().build();
    static final String HTTP_LOG_TAG = "QCloudHttp";
    private final HttpLoggingInterceptor logInterceptor;
    private HostnameVerifier mHostnameVerifier;
    private final OkHttpClient okHttpClient;
    private final TaskManager taskManager;
    private final Set<String> verifiedHost;

    public static QCloudHttpClient getDefault() {
        return DEFAULT;
    }

    public void addVerifiedHost(String hostname) {
        if (hostname != null) {
            this.verifiedHost.add(hostname);
        }
    }

    public void setDebuggable(boolean debuggable) {
        this.logInterceptor.setLevel((debuggable || QCloudLogger.isTagLoggable(HTTP_LOG_TAG)) ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
    }

    private QCloudHttpClient(Builder b) {
        this.mHostnameVerifier = new HostnameVerifier() {
            /* class com.tencent.qcloud.core.http.QCloudHttpClient.C13261 */

            public boolean verify(String hostname, SSLSession session) {
                if (QCloudHttpClient.this.verifiedHost.size() > 0) {
                    for (String host : QCloudHttpClient.this.verifiedHost) {
                        if (HttpsURLConnection.getDefaultHostnameVerifier().verify(host, session)) {
                            return true;
                        }
                    }
                }
                return HttpsURLConnection.getDefaultHostnameVerifier().verify(hostname, session);
            }
        };
        this.verifiedHost = new HashSet(5);
        this.taskManager = TaskManager.getInstance();
        OkHttpClient.Builder builder = new OkHttpClient.Builder().followRedirects(true).followSslRedirects(true).hostnameVerifier(this.mHostnameVerifier);
        builder.connectTimeout((long) b.connectionTimeout, TimeUnit.MILLISECONDS).readTimeout((long) b.socketTimeout, TimeUnit.MILLISECONDS).writeTimeout((long) b.socketTimeout, TimeUnit.MILLISECONDS);
        this.logInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            /* class com.tencent.qcloud.core.http.QCloudHttpClient.C13272 */

            @Override // com.tencent.qcloud.core.http.HttpLoggingInterceptor.Logger
            public void log(String message) {
                QCloudLogger.m4897i(QCloudHttpClient.HTTP_LOG_TAG, message, new Object[0]);
            }
        });
        this.logInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        builder.addInterceptor(this.logInterceptor);
        setDebuggable(false);
        builder.addInterceptor(new RetryAndTrafficControlInterceptor());
        this.okHttpClient = builder.build();
    }

    public List<HttpTask> getTasksByTag(String tag) {
        List<HttpTask> tasks = new ArrayList<>();
        if (tag != null) {
            for (Task task : this.taskManager.snapshot()) {
                if ((task instanceof HttpTask) && tag.equals(task.getTag())) {
                    tasks.add((HttpTask) task);
                }
            }
        }
        return tasks;
    }

    public <T> HttpTask<T> resolveRequest(HttpRequest<T> request) {
        return handleRequest(request, null);
    }

    public <T> HttpTask<T> resolveRequest(QCloudHttpRequest<T> request, QCloudCredentialProvider credentialProvider) {
        return handleRequest(request, credentialProvider);
    }

    /* access modifiers changed from: package-private */
    public Call getOkHttpCall(Request okHttpRequest) {
        return this.okHttpClient.newCall(okHttpRequest);
    }

    private <T> HttpTask<T> handleRequest(HttpRequest<T> request, QCloudCredentialProvider credentialProvider) {
        request.addHeader(HttpConstants.Header.HOST, request.host());
        return new HttpTask<>(request, credentialProvider, this);
    }

    private static final class Builder {
        int connectionTimeout = 15000;
        int socketTimeout = 30000;

        public Builder setConnectionTimeout(int connectionTimeout2) {
            if (connectionTimeout2 < 10000) {
                throw new IllegalArgumentException("connection timeout must be larger than 10 seconds.");
            }
            this.connectionTimeout = connectionTimeout2;
            return this;
        }

        public Builder setSocketTimeout(int socketTimeout2) {
            if (socketTimeout2 < 10000) {
                throw new IllegalArgumentException("socket timeout must be larger than 10 seconds.");
            }
            this.socketTimeout = socketTimeout2;
            return this;
        }

        public QCloudHttpClient build() {
            return new QCloudHttpClient(this);
        }
    }
}
