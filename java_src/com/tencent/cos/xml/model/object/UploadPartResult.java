package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.qcloud.core.http.HttpResponse;

public final class UploadPartResult extends CosXmlResult {
    public String eTag;

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public void parseResponseBody(HttpResponse response) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(response);
        this.eTag = response.header("ETag");
    }

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public String printResult() {
        return this.eTag;
    }
}
