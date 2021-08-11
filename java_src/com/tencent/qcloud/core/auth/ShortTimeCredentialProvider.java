package com.tencent.qcloud.core.auth;

import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencent.qcloud.core.common.QCloudServiceException;
import com.tencent.qcloud.core.http.HttpRequest;
import com.tencent.qcloud.core.http.HttpResult;
import com.tencent.qcloud.core.http.QCloudHttpClient;

public class ShortTimeCredentialProvider extends BasicLifecycleCredentialProvider {
    private long duration;
    protected HttpRequest<String> httpRequest;
    private String secretId;
    private String secretKey;

    @Deprecated
    public ShortTimeCredentialProvider(String secretId2, String secretKey2, long keyDuration) {
        this.secretId = secretId2;
        this.secretKey = secretKey2;
        this.duration = keyDuration;
    }

    public ShortTimeCredentialProvider(HttpRequest<String> httpRequest2) {
        this.httpRequest = httpRequest2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.qcloud.core.auth.BasicLifecycleCredentialProvider
    public QCloudLifecycleCredentials fetchNewCredentials() throws QCloudClientException {
        if (this.secretId != null && this.secretKey != null) {
            return onGetCredentialFromLocal(this.secretId, this.secretKey);
        }
        if (this.httpRequest == null) {
            return null;
        }
        try {
            return onRemoteCredentialReceived((String) ((HttpResult) QCloudHttpClient.getDefault().resolveRequest(this.httpRequest).executeNow()).content());
        } catch (QCloudServiceException e) {
            throw new QCloudClientException("get session json fails", e);
        }
    }

    /* access modifiers changed from: package-private */
    public QCloudLifecycleCredentials onGetCredentialFromLocal(String secretId2, String secretKey2) throws QCloudClientException {
        long current = System.currentTimeMillis() / 1000;
        String keyTime = current + ";" + (current + this.duration);
        return new BasicQCloudCredentials(secretId2, secretKey2SignKey(secretKey2, keyTime), keyTime);
    }

    /* access modifiers changed from: protected */
    public QCloudLifecycleCredentials onRemoteCredentialReceived(String jsonContent) throws QCloudClientException {
        return null;
    }

    private String secretKey2SignKey(String secretKey2, String keyTime) {
        byte[] hmacSha1 = Utils.hmacSha1(keyTime, secretKey2);
        if (hmacSha1 != null) {
            return new String(Utils.encodeHex(hmacSha1));
        }
        return null;
    }
}
