package com.tencent.cos.xml.model.bucket;

import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.util.Map;

public class GetBucketVersioningRequest extends BucketRequest {
    public GetBucketVersioningRequest(String bucket) {
        super(bucket);
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "GET";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        this.queryParameters.put("versioning", null);
        return super.getQueryString();
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() {
        return null;
    }
}
