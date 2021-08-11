package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.qcloud.core.http.RequestBodySerializer;

public final class OptionObjectRequest extends ObjectRequest {
    private String accessControlHeaders;
    private String accessControlMethod;
    private String origin;

    public OptionObjectRequest(String bucket, String cosPath, String origin2, String accessControlMethod2) {
        super(bucket, cosPath);
        this.origin = origin2;
        this.accessControlMethod = accessControlMethod2;
        setOrigin(origin2);
        setAccessControlMethod(accessControlMethod2);
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "OPTIONS";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() {
        return null;
    }

    @Override // com.tencent.cos.xml.model.object.ObjectRequest, com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        if (this.origin == null) {
            throw new CosXmlClientException("option request origin must not be null");
        } else if (this.accessControlMethod == null) {
            throw new CosXmlClientException("option request accessControlMethod must not be null");
        }
    }

    public void setOrigin(String origin2) {
        this.origin = origin2;
        if (origin2 != null) {
            addHeader(COSRequestHeaderKey.ORIGIN, origin2);
        }
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setAccessControlMethod(String accessControlMethod2) {
        if (accessControlMethod2 != null) {
            this.accessControlMethod = accessControlMethod2.toUpperCase();
            addHeader(COSRequestHeaderKey.ACCESS_CONTROL_REQUEST_METHOD, this.accessControlMethod);
        }
    }

    public String getAccessControlMethod() {
        return this.accessControlMethod;
    }

    public void setAccessControlHeaders(String accessControlHeaders2) {
        this.accessControlHeaders = accessControlHeaders2;
        if (accessControlHeaders2 != null) {
            addHeader(COSRequestHeaderKey.ACCESS_CONTROL_REQUEST_HEADERS, accessControlHeaders2);
        }
    }

    public String getAccessControlHeaders() {
        return this.accessControlHeaders;
    }
}
