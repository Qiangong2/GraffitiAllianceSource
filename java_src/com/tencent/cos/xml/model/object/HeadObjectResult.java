package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.qcloud.core.http.HttpResponse;

public final class HeadObjectResult extends CosXmlResult {
    public String cosObjectType;
    public String cosStorageClass;

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public void parseResponseBody(HttpResponse response) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(response);
        this.cosObjectType = response.header("x-cos-object-type");
        this.cosStorageClass = response.header(COSRequestHeaderKey.X_COS_STORAGE_CLASS_);
    }
}
