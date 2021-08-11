package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.CORSConfiguration;
import com.tencent.cos.xml.transfer.XmlBuilder;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public final class PutBucketCORSRequest extends BucketRequest {
    private CORSConfiguration corsConfiguration = new CORSConfiguration();

    public PutBucketCORSRequest(String bucket) {
        super(bucket);
        this.corsConfiguration.corsRules = new ArrayList();
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "PUT";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        this.queryParameters.put("cors", null);
        return super.getQueryString();
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        try {
            return RequestBodySerializer.string("application/xml", XmlBuilder.buildCORSConfigurationXML(this.corsConfiguration));
        } catch (XmlPullParserException e) {
            throw new CosXmlClientException(e);
        } catch (IOException e2) {
            throw new CosXmlClientException(e2);
        }
    }

    public void addCORSRules(List<CORSConfiguration.CORSRule> corsRules) {
        if (corsRules != null) {
            this.corsConfiguration.corsRules.addAll(corsRules);
        }
    }

    public void addCORSRule(CORSConfiguration.CORSRule corsRule) {
        if (corsRule != null) {
            this.corsConfiguration.corsRules.add(corsRule);
        }
    }

    public CORSConfiguration getCorsConfiguration() {
        return this.corsConfiguration;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public boolean isNeedMD5() {
        return true;
    }
}
