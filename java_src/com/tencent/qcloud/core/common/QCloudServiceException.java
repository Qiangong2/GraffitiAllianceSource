package com.tencent.qcloud.core.common;

public class QCloudServiceException extends Exception {
    private static final long serialVersionUID = 1;
    private String errorCode;
    private String errorMessage;
    private String requestId;
    private String serviceName;
    private int statusCode;

    public QCloudServiceException(String errorMessage2) {
        super(errorMessage2);
        this.errorMessage = errorMessage2;
    }

    public QCloudServiceException(String errorMessage2, Exception cause) {
        super(null, cause);
        this.errorMessage = errorMessage2;
    }

    public void setRequestId(String requestId2) {
        this.requestId = requestId2;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setServiceName(String serviceName2) {
        this.serviceName = serviceName2;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public void setErrorCode(String errorCode2) {
        this.errorCode = errorCode2;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setStatusCode(int statusCode2) {
        this.statusCode = statusCode2;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getMessage() {
        return getErrorMessage() + " (Service: " + getServiceName() + "; Status Code: " + getStatusCode() + "; Error Code: " + getErrorCode() + "; Request ID: " + getRequestId() + ")";
    }

    public void setErrorMessage(String errorMessage2) {
        this.errorMessage = errorMessage2;
    }
}
