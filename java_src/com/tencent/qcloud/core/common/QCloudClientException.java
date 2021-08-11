package com.tencent.qcloud.core.common;

public class QCloudClientException extends Exception {
    private static final long serialVersionUID = 1;

    public QCloudClientException(String message, Throwable t) {
        super(message, t);
    }

    public QCloudClientException(String message) {
        super(message);
    }

    public QCloudClientException(Throwable throwable) {
        super(throwable);
    }

    public boolean isRetryable() {
        return true;
    }
}
