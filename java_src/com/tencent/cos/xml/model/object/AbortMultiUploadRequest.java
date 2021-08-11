package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.util.Map;

public final class AbortMultiUploadRequest extends ObjectRequest {
    private String uploadId;

    public AbortMultiUploadRequest(String bucket, String cosPath, String uploadId2) {
        super(bucket, cosPath);
        this.uploadId = uploadId2;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "DELETE";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        this.queryParameters.put("uploadID", this.uploadId);
        return this.queryParameters;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() {
        return null;
    }

    @Override // com.tencent.cos.xml.model.object.ObjectRequest, com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        if (this.uploadId == null) {
            throw new CosXmlClientException("uploadID must not be null");
        }
    }

    public void setUploadId(String uploadId2) {
        this.uploadId = uploadId2;
    }

    public String getUploadId() {
        return this.uploadId;
    }
}
