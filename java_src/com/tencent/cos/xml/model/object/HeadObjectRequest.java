package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.qcloud.core.http.RequestBodySerializer;

public final class HeadObjectRequest extends ObjectRequest {
    public HeadObjectRequest(String bucket, String cosPath) {
        super(bucket, cosPath);
    }

    public void setVersionId(String versionId) {
        if (versionId != null) {
            this.queryParameters.put("versionId", versionId);
        }
    }

    public void setIfModifiedSince(String ifModifiedSince) {
        if (ifModifiedSince != null) {
            addHeader(COSRequestHeaderKey.IF_MODIFIED_SINCE, ifModifiedSince);
        }
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "HEAD";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() {
        return null;
    }
}
