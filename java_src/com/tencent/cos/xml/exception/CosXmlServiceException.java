package com.tencent.cos.xml.exception;

import com.tencent.qcloud.core.common.QCloudServiceException;

public class CosXmlServiceException extends QCloudServiceException {
    private static final long serialVersionUID = 1;
    private String httpMsg;

    public CosXmlServiceException(String httpMsg2) {
        super(null);
        this.httpMsg = httpMsg2;
    }

    public CosXmlServiceException(String errorMessage, Exception cause) {
        super(errorMessage, cause);
    }

    public String getHttpMessage() {
        return this.httpMsg;
    }

    @Override // com.tencent.qcloud.core.common.QCloudServiceException
    public String getMessage() {
        return getErrorMessage() + " (Service: " + getServiceName() + "; Status Code: " + getStatusCode() + "; Status Message: " + this.httpMsg + "; Error Code: " + getErrorCode() + "; Request ID: " + getRequestId() + ")";
    }
}
