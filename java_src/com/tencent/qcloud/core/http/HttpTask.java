package com.tencent.qcloud.core.http;

import com.tencent.qcloud.core.auth.QCloudCredentialProvider;
import com.tencent.qcloud.core.auth.QCloudCredentials;
import com.tencent.qcloud.core.auth.QCloudSigner;
import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.common.QCloudProgressListener;
import com.tencent.qcloud.core.common.QCloudServiceException;
import com.tencent.qcloud.core.http.HttpConstants;
import com.tencent.qcloud.core.task.CancelableTask;
import com.tencent.qcloud.core.task.TaskExecutors;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Call;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.Util;
import okio.Buffer;

public final class HttpTask<T> extends CancelableTask<HttpResult<T>> {
    private static AtomicInteger increments = new AtomicInteger(1);
    private final QCloudCredentialProvider credentialProvider;
    private Call httpCall;
    private final QCloudHttpClient httpClient;
    private final HttpRequest<T> httpRequest;
    private HttpResponse<T> httpResponse;
    private HttpResult<T> httpResult;
    private QCloudProgressListener mProgressListener = new QCloudProgressListener() {
        /* class com.tencent.qcloud.core.http.HttpTask.C13251 */

        @Override // com.tencent.qcloud.core.common.QCloudProgressListener
        public void onProgress(long complete, long target) {
            HttpTask.this.onProgress(complete, target);
        }
    };

    HttpTask(HttpRequest<T> httpRequest2, QCloudCredentialProvider credentialProvider2, QCloudHttpClient httpClient2) {
        super("HttpTask-" + httpRequest2.tag() + "-" + increments.getAndIncrement(), httpRequest2.tag());
        this.httpRequest = httpRequest2;
        this.httpClient = httpClient2;
        this.credentialProvider = credentialProvider2;
    }

    public HttpTask<T> schedule() {
        if (this.httpRequest.getRequestBody() instanceof ProgressBody) {
            scheduleOn(TaskExecutors.UPLOAD_EXECUTOR);
        } else if (this.httpRequest.getResponseBodyConverter() instanceof ProgressBody) {
            scheduleOn(TaskExecutors.DOWNLOAD_EXECUTOR);
        } else {
            scheduleOn(TaskExecutors.COMMAND_EXECUTOR);
        }
        return this;
    }

    public boolean isSuccessful() {
        return this.httpResult != null && this.httpResult.isSuccessful();
    }

    @Override // com.tencent.qcloud.core.task.Task
    public HttpResult<T> getResult() {
        return this.httpResult;
    }

    /* access modifiers changed from: package-private */
    public boolean isStreamingTask() {
        return (this.httpRequest.getRequestBody() instanceof ProgressBody) || (this.httpRequest.getResponseBodyConverter() instanceof ProgressBody);
    }

    /* access modifiers changed from: package-private */
    public boolean isUploadTask() {
        return this.httpRequest.getRequestBody() instanceof ProgressBody;
    }

    /* access modifiers changed from: package-private */
    public boolean isDownloadTask() {
        return this.httpRequest.getResponseBodyConverter() instanceof ProgressBody;
    }

    /* access modifiers changed from: package-private */
    public double getAverageStreamingSpeed(long networkMillsTook) {
        ProgressBody body = null;
        if (this.httpRequest.getRequestBody() instanceof ProgressBody) {
            body = (ProgressBody) this.httpRequest.getRequestBody();
        } else if (this.httpRequest.getResponseBodyConverter() instanceof ProgressBody) {
            body = (ProgressBody) this.httpRequest.getResponseBodyConverter();
        }
        if (body != null) {
            return (((double) body.getBytesTransferred()) / 1024.0d) / (((double) networkMillsTook) / 1000.0d);
        }
        return 0.0d;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.qcloud.core.task.Task
    public HttpResult<T> onCommand() throws QCloudClientException, QCloudServiceException {
        if (this.httpRequest.shouldCalculateContentMD5()) {
            calculateContentMD5();
        }
        QCloudSigner signer = this.httpRequest.getQCloudSigner();
        if (signer != null) {
            signRequest(signer, this.httpRequest);
        }
        if (this.httpRequest.getRequestBody() instanceof ProgressBody) {
            ((ProgressBody) this.httpRequest.getRequestBody()).setProgressListener(this.mProgressListener);
        }
        try {
            this.httpRequest.setOkHttpRequestTag(getIdentifier());
            this.httpCall = this.httpClient.getOkHttpCall(this.httpRequest.buildRealRequest());
            Response response = this.httpCall.execute();
            if (response != null) {
                if (this.httpResult == null) {
                    convertResponse(response);
                } else {
                    Util.closeQuietly(response.body());
                }
                return this.httpResult;
            }
            throw new QCloudServiceException("http response is null");
        } catch (IOException e) {
            if (e.getCause() instanceof QCloudClientException) {
                throw ((QCloudClientException) e.getCause());
            } else if (e.getCause() instanceof QCloudServiceException) {
                throw ((QCloudServiceException) e.getCause());
            } else {
                throw new QCloudClientException(e);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.qcloud.core.task.CancelableTask
    public boolean onCancel() {
        if (this.httpCall == null) {
            return true;
        }
        this.httpCall.cancel();
        return true;
    }

    private void signRequest(QCloudSigner signer, HttpRequest request) throws QCloudClientException {
        if (this.credentialProvider == null) {
            throw new QCloudClientException("no credentials provider");
        }
        QCloudCredentials credentials = this.credentialProvider.getCredentials();
        if (credentials == null) {
            throw new QCloudClientException("can't get credentials for provider : " + this.credentialProvider);
        } else if (request.getSignProvider() == null) {
            throw new QCloudClientException("no source to sign");
        } else {
            signer.sign((QCloudHttpRequest) request, credentials);
        }
    }

    private void calculateContentMD5() throws QCloudClientException {
        RequestBody requestBody = this.httpRequest.getRequestBody();
        if (requestBody == null) {
            throw new QCloudClientException("get md5 canceled, request body is null.");
        }
        Buffer sink = new Buffer();
        try {
            requestBody.writeTo(sink);
            this.httpRequest.addHeader(HttpConstants.Header.MD5, sink.md5().base64());
            sink.close();
        } catch (IOException e) {
            throw new QCloudClientException("calculate md5 error", e);
        }
    }

    /* access modifiers changed from: package-private */
    public void convertResponse(Response response) throws QCloudClientException, QCloudServiceException {
        try {
            this.httpResponse = new HttpResponse<>(this.httpRequest, response);
            ResponseBodyConverter<T> converter = this.httpRequest.getResponseBodyConverter();
            if (converter instanceof ProgressBody) {
                ((ProgressBody) converter).setProgressListener(this.mProgressListener);
            }
            this.httpResult = new HttpResult<>(this.httpResponse, converter.convert(this.httpResponse));
        } finally {
            Util.closeQuietly(response.body());
        }
    }
}
