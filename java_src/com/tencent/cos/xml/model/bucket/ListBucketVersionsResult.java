package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.tag.ListBucketVersions;
import com.tencent.cos.xml.transfer.XmlParser;
import com.tencent.qcloud.core.http.HttpResponse;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public class ListBucketVersionsResult extends CosXmlResult {
    public ListBucketVersions listBucketVersions;

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public void parseResponseBody(HttpResponse response) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(response);
        this.listBucketVersions = new ListBucketVersions();
        try {
            XmlParser.parseListBucketVersions(response.byteStream(), this.listBucketVersions);
        } catch (XmlPullParserException e) {
            throw new CosXmlClientException(e.getMessage(), e);
        } catch (IOException e2) {
            throw new CosXmlClientException(e2.getMessage(), e2);
        }
    }

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public String printResult() {
        if (this.listBucketVersions != null) {
            return this.listBucketVersions.toString();
        }
        return super.printResult();
    }
}
