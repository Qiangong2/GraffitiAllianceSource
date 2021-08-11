package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.tag.AccessControlPolicy;
import com.tencent.cos.xml.transfer.XmlParser;
import com.tencent.qcloud.core.http.HttpResponse;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class GetBucketACLResult extends CosXmlResult {
    public AccessControlPolicy accessControlPolicy;

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public void parseResponseBody(HttpResponse response) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(response);
        this.accessControlPolicy = new AccessControlPolicy();
        try {
            XmlParser.parseAccessControlPolicy(response.byteStream(), this.accessControlPolicy);
        } catch (XmlPullParserException e) {
            throw new CosXmlClientException(e);
        } catch (IOException e2) {
            throw new CosXmlClientException(e2);
        }
    }

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public String printResult() {
        return this.accessControlPolicy != null ? this.accessControlPolicy.toString() : super.printResult();
    }
}
