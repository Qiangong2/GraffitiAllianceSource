package com.tencent.cos.xml.exception;

import com.tencent.qcloud.core.common.QCloudClientException;

public class CosXmlClientException extends QCloudClientException {
    private static final long serialVersionUID = 1;

    public CosXmlClientException(String message) {
        super(message);
    }

    public CosXmlClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public CosXmlClientException(Throwable cause) {
        super(cause);
    }
}
