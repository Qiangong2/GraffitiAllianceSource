package com.tencent.cos.xml;

import android.content.Context;
import com.tencent.cos.xml.common.Range;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.listener.CosXmlResultListener;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.object.AbortMultiUploadRequest;
import com.tencent.cos.xml.model.object.AbortMultiUploadResult;
import com.tencent.cos.xml.model.object.AppendObjectRequest;
import com.tencent.cos.xml.model.object.CompleteMultiUploadRequest;
import com.tencent.cos.xml.model.object.CompleteMultiUploadResult;
import com.tencent.cos.xml.model.object.DeleteObjectRequest;
import com.tencent.cos.xml.model.object.DeleteObjectResult;
import com.tencent.cos.xml.model.object.GetObjectRequest;
import com.tencent.cos.xml.model.object.GetObjectResult;
import com.tencent.cos.xml.model.object.InitMultipartUploadRequest;
import com.tencent.cos.xml.model.object.InitMultipartUploadResult;
import com.tencent.cos.xml.model.object.ListPartsRequest;
import com.tencent.cos.xml.model.object.ListPartsResult;
import com.tencent.cos.xml.model.object.PutObjectRequest;
import com.tencent.cos.xml.model.object.PutObjectResult;
import com.tencent.cos.xml.model.object.UploadPartRequest;
import com.tencent.cos.xml.model.object.UploadPartResult;
import com.tencent.cos.xml.transfer.ResponseFileBodySerializer;
import com.tencent.cos.xml.transfer.ResponseXmlS3BodySerializer;
import com.tencent.qcloud.core.auth.QCloudCredentialProvider;
import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.common.QCloudResultListener;
import com.tencent.qcloud.core.common.QCloudServiceException;
import com.tencent.qcloud.core.http.HttpConstants;
import com.tencent.qcloud.core.http.HttpResult;
import com.tencent.qcloud.core.http.HttpTask;
import com.tencent.qcloud.core.http.QCloudHttpClient;
import com.tencent.qcloud.core.http.QCloudHttpRequest;
import com.tencent.qcloud.core.logger.QCloudLogger;

public class CosXmlSimpleService implements SimpleCosXml {
    public static String appCachePath;
    protected String appid;
    protected QCloudHttpClient client;
    protected QCloudCredentialProvider credentialProvider;
    protected String region;
    protected String scheme;
    protected String tag = "CosXml";

    public CosXmlSimpleService(Context context, CosXmlServiceConfig configuration, QCloudCredentialProvider qCloudCredentialProvider) {
        QCloudLogger.setUp(context);
        appCachePath = context.getExternalCacheDir().getPath();
        this.client = QCloudHttpClient.getDefault();
        this.client.addVerifiedHost("*.myqcloud.com");
        this.client.setDebuggable(configuration.isDebuggable());
        this.scheme = configuration.getProtocol();
        this.region = configuration.getRegion();
        this.appid = configuration.getAppid();
        this.credentialProvider = qCloudCredentialProvider;
    }

    /* access modifiers changed from: protected */
    public <T1 extends CosXmlRequest, T2 extends CosXmlResult> QCloudHttpRequest buildHttpRequest(T1 cosXmlRequest, T2 cosXmlResult) throws CosXmlClientException {
        cosXmlRequest.checkParameters();
        String host = cosXmlRequest.getHost(this.appid, this.region);
        QCloudHttpRequest.Builder<T2> httpRequestBuilder = new QCloudHttpRequest.Builder().method(cosXmlRequest.getMethod()).scheme(this.scheme).host(host).path(cosXmlRequest.getPath()).addHeader(HttpConstants.Header.HOST, host).userAgent(CosXmlServiceConfig.DEFAULT_USER_AGENT).tag((Object) this.tag).signer("CosXmlSigner", cosXmlRequest.getSignSourceProvider());
        httpRequestBuilder.query(cosXmlRequest.getQueryString());
        httpRequestBuilder.addHeaders(cosXmlRequest.getRequestHeaders());
        if (cosXmlRequest.isNeedMD5()) {
            httpRequestBuilder.contentMD5();
        }
        if (cosXmlRequest.getRequestBody() != null) {
            httpRequestBuilder.body(cosXmlRequest.getRequestBody());
        }
        if (cosXmlRequest instanceof GetObjectRequest) {
            String absolutePath = ((GetObjectRequest) cosXmlRequest).getDownloadPath();
            Range range = ((GetObjectRequest) cosXmlRequest).getRange();
            long start = 0;
            if (range != null) {
                start = range.getStart();
            }
            httpRequestBuilder.converter(new ResponseFileBodySerializer<>((GetObjectResult) cosXmlResult, absolutePath, start));
        } else {
            httpRequestBuilder.converter(new ResponseXmlS3BodySerializer<>(cosXmlResult));
        }
        return httpRequestBuilder.build();
    }

    /* access modifiers changed from: protected */
    public <T1 extends CosXmlRequest, T2 extends CosXmlResult> T2 execute(T1 cosXmlRequest, T2 cosXmlResult) throws CosXmlClientException, CosXmlServiceException {
        try {
            HttpTask<T2> httpTask = this.client.resolveRequest(buildHttpRequest(cosXmlRequest, cosXmlResult), this.credentialProvider);
            cosXmlRequest.setTask(httpTask);
            if (cosXmlRequest instanceof AppendObjectRequest) {
                httpTask.addProgressListener(((AppendObjectRequest) cosXmlRequest).getProgressListener());
            } else if (cosXmlRequest instanceof PutObjectRequest) {
                httpTask.addProgressListener(((PutObjectRequest) cosXmlRequest).getProgressListener());
            } else if (cosXmlRequest instanceof UploadPartRequest) {
                httpTask.addProgressListener(((UploadPartRequest) cosXmlRequest).getProgressListener());
            } else if (cosXmlRequest instanceof GetObjectRequest) {
                httpTask.addProgressListener(((GetObjectRequest) cosXmlRequest).getProgressListener());
            }
            return (T2) ((CosXmlResult) ((HttpResult) httpTask.executeNow()).content());
        } catch (QCloudServiceException e) {
            throw ((CosXmlServiceException) e);
        } catch (QCloudClientException e2) {
            throw new CosXmlClientException(e2);
        }
    }

    /* access modifiers changed from: protected */
    public <T1 extends CosXmlRequest, T2 extends CosXmlResult> void schedule(final T1 cosXmlRequest, T2 cosXmlResult, final CosXmlResultListener cosXmlResultListener) {
        QCloudResultListener<T2> r4 = new QCloudResultListener<HttpResult<T2>>() {
            /* class com.tencent.cos.xml.CosXmlSimpleService.C13111 */

            public void onSuccess(HttpResult<T2> result) {
                cosXmlResultListener.onSuccess(cosXmlRequest, result.content());
            }

            @Override // com.tencent.qcloud.core.common.QCloudResultListener
            public void onFailure(QCloudClientException clientException, QCloudServiceException serviceException) {
                if (clientException != null) {
                    cosXmlResultListener.onFail(cosXmlRequest, new CosXmlClientException(clientException), null);
                } else {
                    cosXmlResultListener.onFail(cosXmlRequest, null, (CosXmlServiceException) serviceException);
                }
            }
        };
        try {
            HttpTask<T2> httpTask = this.client.resolveRequest(buildHttpRequest(cosXmlRequest, cosXmlResult), this.credentialProvider);
            cosXmlRequest.setTask(httpTask);
            if (cosXmlRequest instanceof AppendObjectRequest) {
                httpTask.addProgressListener(((AppendObjectRequest) cosXmlRequest).getProgressListener());
            } else if (cosXmlRequest instanceof PutObjectRequest) {
                httpTask.addProgressListener(((PutObjectRequest) cosXmlRequest).getProgressListener());
            } else if (cosXmlRequest instanceof UploadPartRequest) {
                httpTask.addProgressListener(((UploadPartRequest) cosXmlRequest).getProgressListener());
            } else if (cosXmlRequest instanceof GetObjectRequest) {
                httpTask.addProgressListener(((GetObjectRequest) cosXmlRequest).getProgressListener());
            }
            httpTask.schedule().addResultListener(r4);
        } catch (QCloudClientException e) {
            cosXmlResultListener.onFail(cosXmlRequest, new CosXmlClientException(e), null);
        }
    }

    public String getAccessUrl(CosXmlRequest cosXmlRequest) {
        String host = cosXmlRequest.getHost(this.appid, this.region);
        return host + cosXmlRequest.getPath();
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public InitMultipartUploadResult initMultipartUpload(InitMultipartUploadRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (InitMultipartUploadResult) execute(request, new InitMultipartUploadResult());
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public void initMultipartUploadAsync(InitMultipartUploadRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new InitMultipartUploadResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public ListPartsResult listParts(ListPartsRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (ListPartsResult) execute(request, new ListPartsResult());
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public void listPartsAsync(ListPartsRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new ListPartsResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public UploadPartResult uploadPart(UploadPartRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (UploadPartResult) execute(request, new UploadPartResult());
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public void uploadPartAsync(UploadPartRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new UploadPartResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public AbortMultiUploadResult abortMultiUpload(AbortMultiUploadRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (AbortMultiUploadResult) execute(request, new AbortMultiUploadResult());
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public void abortMultiUploadAsync(AbortMultiUploadRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new AbortMultiUploadResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public CompleteMultiUploadResult completeMultiUpload(CompleteMultiUploadRequest request) throws CosXmlClientException, CosXmlServiceException {
        CompleteMultiUploadResult completeMultiUploadResult = new CompleteMultiUploadResult();
        completeMultiUploadResult.accessUrl = getAccessUrl(request);
        return (CompleteMultiUploadResult) execute(request, completeMultiUploadResult);
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public void completeMultiUploadAsync(CompleteMultiUploadRequest request, CosXmlResultListener cosXmlResultListener) {
        CompleteMultiUploadResult completeMultiUploadResult = new CompleteMultiUploadResult();
        completeMultiUploadResult.accessUrl = getAccessUrl(request);
        schedule(request, completeMultiUploadResult, cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public DeleteObjectResult deleteObject(DeleteObjectRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (DeleteObjectResult) execute(request, new DeleteObjectResult());
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public void deleteObjectAsync(DeleteObjectRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new DeleteObjectResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public GetObjectResult getObject(GetObjectRequest request) throws CosXmlClientException, CosXmlServiceException {
        return (GetObjectResult) execute(request, new GetObjectResult());
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public void getObjectAsync(GetObjectRequest request, CosXmlResultListener cosXmlResultListener) {
        schedule(request, new GetObjectResult(), cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public PutObjectResult putObject(PutObjectRequest request) throws CosXmlClientException, CosXmlServiceException {
        PutObjectResult putObjectResult = new PutObjectResult();
        putObjectResult.accessUrl = getAccessUrl(request);
        return (PutObjectResult) execute(request, putObjectResult);
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public void putObjectAsync(PutObjectRequest request, CosXmlResultListener cosXmlResultListener) {
        PutObjectResult putObjectResult = new PutObjectResult();
        putObjectResult.accessUrl = getAccessUrl(request);
        schedule(request, putObjectResult, cosXmlResultListener);
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public void cancel(CosXmlRequest cosXmlRequest) {
        if (cosXmlRequest != null && cosXmlRequest.getHttpTask() != null) {
            cosXmlRequest.getHttpTask().cancel();
        }
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public void cancelAll() {
        for (HttpTask task : this.client.getTasksByTag(this.tag)) {
            task.cancel();
        }
    }

    @Override // com.tencent.cos.xml.SimpleCosXml
    public void release() {
        cancelAll();
    }
}
