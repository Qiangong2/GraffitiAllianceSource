package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.qcloud.core.http.HttpResponse;
import com.tencent.qcloud.core.util.IOUtils;

public final class AppendObjectResult extends CosXmlResult {
    private String contentSHA1;
    private String nextAppendPosition;

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public void parseResponseBody(HttpResponse response) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(response);
        this.contentSHA1 = response.header("x-cos-content-sha1");
        this.nextAppendPosition = response.header("x-cos-next-append-position");
    }

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public String printResult() {
        return super.printResult() + IOUtils.LINE_SEPARATOR_UNIX + this.contentSHA1 + IOUtils.LINE_SEPARATOR_UNIX + this.nextAppendPosition + IOUtils.LINE_SEPARATOR_UNIX;
    }
}
