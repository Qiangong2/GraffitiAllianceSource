package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.tag.ListMultipartUploads;
import com.tencent.cos.xml.transfer.XmlParser;
import com.tencent.qcloud.core.http.HttpResponse;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class ListMultiUploadsResult extends CosXmlResult {
    public ListMultipartUploads listMultipartUploads;

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public void parseResponseBody(HttpResponse response) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(response);
        this.listMultipartUploads = new ListMultipartUploads();
        try {
            XmlParser.parseListMultipartUploadsResult(response.byteStream(), this.listMultipartUploads);
        } catch (XmlPullParserException e) {
            throw new CosXmlClientException(e.getMessage(), e);
        } catch (IOException e2) {
            throw new CosXmlClientException(e2.getMessage(), e2);
        }
    }

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public String printResult() {
        if (this.listMultipartUploads != null) {
            return this.listMultipartUploads.toString();
        }
        return super.printResult();
    }
}
