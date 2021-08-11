package com.tencent.cos.xml.model.object;

import com.tencent.qcloud.core.http.RequestBodySerializer;

public final class DeleteObjectRequest extends ObjectRequest {
    public DeleteObjectRequest(String bucket, String cosPath) {
        super(bucket, cosPath);
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "DELETE";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() {
        return null;
    }

    public void setVersionId(String versionId) {
        if (versionId != null) {
            this.queryParameters.put("versionId", versionId);
        }
    }
}
