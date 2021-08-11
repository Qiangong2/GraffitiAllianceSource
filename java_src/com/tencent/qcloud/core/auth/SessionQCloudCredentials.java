package com.tencent.qcloud.core.auth;

public class SessionQCloudCredentials implements QCloudLifecycleCredentials {
    private final String keyTime;
    private final String secretId;
    private final String signKey;
    private final String token;

    public SessionQCloudCredentials(String secretId2, String secretKey, String token2, long expiredTime) {
        this(secretId2, secretKey, token2, System.currentTimeMillis() / 1000, expiredTime);
    }

    public SessionQCloudCredentials(String secretId2, String secretKey, String token2, long beginTime, long expiredTime) {
        if (secretId2 == null) {
            throw new IllegalArgumentException("secretId cannot be null.");
        } else if (secretKey == null) {
            throw new IllegalArgumentException("secretKey cannot be null.");
        } else if (token2 == null) {
            throw new IllegalArgumentException("token cannot be null.");
        } else if (beginTime >= expiredTime) {
            throw new IllegalArgumentException("beginTime must be larger than expiredTime.");
        } else {
            this.secretId = secretId2;
            this.keyTime = getKeyTime(beginTime, expiredTime);
            this.signKey = getSignKey(secretKey, this.keyTime);
            this.token = token2;
        }
    }

    public SessionQCloudCredentials(String secretId2, String secretKey, String token2, String keyTime2) {
        if (secretId2 == null) {
            throw new IllegalArgumentException("secretId cannot be null.");
        } else if (secretKey == null) {
            throw new IllegalArgumentException("secretKey cannot be null.");
        } else if (token2 == null) {
            throw new IllegalArgumentException("token cannot be null.");
        } else if (keyTime2 == null) {
            throw new IllegalArgumentException("keyTime cannot be null.");
        } else {
            this.secretId = secretId2;
            this.keyTime = keyTime2;
            this.signKey = getSignKey(secretKey, keyTime2);
            this.token = token2;
        }
    }

    private String getKeyTime(long beginTime, long expiredTime) {
        return Utils.handleTimeAccuracy(beginTime) + ";" + Utils.handleTimeAccuracy(expiredTime);
    }

    private String getSignKey(String secretKey, String keyTime2) {
        byte[] hmacSha1 = Utils.hmacSha1(keyTime2, secretKey);
        if (hmacSha1 != null) {
            return new String(Utils.encodeHex(hmacSha1));
        }
        return null;
    }

    public String getToken() {
        return this.token;
    }

    @Override // com.tencent.qcloud.core.auth.QCloudLifecycleCredentials
    public String getKeyTime() {
        return this.keyTime;
    }

    @Override // com.tencent.qcloud.core.auth.QCloudCredentials
    public String getSecretId() {
        return this.secretId;
    }

    @Override // com.tencent.qcloud.core.auth.QCloudLifecycleCredentials
    public String getSignKey() {
        return this.signKey;
    }
}
