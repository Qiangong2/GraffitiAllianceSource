package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.cos.xml.model.tag.ReplicationConfiguration;
import com.tencent.cos.xml.transfer.XmlParser;
import com.tencent.qcloud.core.http.HttpResponse;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public class GetBucketReplicationResult extends CosXmlResult {
    public ReplicationConfiguration replicationConfiguration;

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public void parseResponseBody(HttpResponse response) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(response);
        this.replicationConfiguration = new ReplicationConfiguration();
        try {
            XmlParser.parseReplicationConfiguration(response.byteStream(), this.replicationConfiguration);
        } catch (XmlPullParserException e) {
            throw new CosXmlClientException(e);
        } catch (IOException e2) {
            throw new CosXmlClientException(e2);
        }
    }

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public String printResult() {
        return this.replicationConfiguration != null ? this.replicationConfiguration.toString() : super.printResult();
    }
}
