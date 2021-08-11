package com.tencent.qcloud.core.auth;

public class BasicQCloudCredentials implements QCloudLifecycleCredentials {
    private final String keyTime;
    private final String secretId;
    private final String signKey;

    public BasicQCloudCredentials(String secretId2, String signKey2, long beginTime, long expiredTime) {
        if (secretId2 == null) {
            throw new IllegalArgumentException("secretId cannot be null.");
        } else if (signKey2 == null) {
            throw new IllegalArgumentException("signKey cannot be null.");
        } else if (beginTime >= expiredTime) {
            throw new IllegalArgumentException("beginTime must be larger than expiredTime.");
        } else {
            this.secretId = secretId2;
            this.signKey = signKey2;
            this.keyTime = Utils.handleTimeAccuracy(beginTime) + ";" + Utils.handleTimeAccuracy(expiredTime);
        }
    }

    public BasicQCloudCredentials(String secretId2, String signKey2, String keyTime2) {
        if (secretId2 == null) {
            throw new IllegalArgumentException("secretId cannot be null.");
        } else if (signKey2 == null) {
            throw new IllegalArgumentException("signKey cannot be null.");
        } else if (keyTime2 == null) {
            throw new IllegalArgumentException("keyTime cannot be null.");
        } else {
            this.secretId = secretId2;
            this.signKey = signKey2;
            this.keyTime = keyTime2;
        }
    }

    @Override // com.tencent.qcloud.core.auth.QCloudLifecycleCredentials
    public String getKeyTime() {
        return this.keyTime;
    }

    @Override // com.tencent.qcloud.core.auth.QCloudLifecycleCredentials
    public String getSignKey() {
        return this.signKey;
    }

    @Override // com.tencent.qcloud.core.auth.QCloudCredentials
    public String getSecretId() {
        return this.secretId;
    }
}
