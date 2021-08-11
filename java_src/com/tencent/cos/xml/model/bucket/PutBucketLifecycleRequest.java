package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.LifecycleConfiguration;
import com.tencent.cos.xml.transfer.XmlBuilder;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public final class PutBucketLifecycleRequest extends BucketRequest {
    private LifecycleConfiguration lifecycleConfiguration = new LifecycleConfiguration();

    public PutBucketLifecycleRequest(String bucket) {
        super(bucket);
        this.lifecycleConfiguration.rules = new ArrayList();
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "PUT";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        this.queryParameters.put("lifecycle", null);
        return super.getQueryString();
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        try {
            return RequestBodySerializer.string("application/xml", XmlBuilder.buildLifecycleConfigurationXML(this.lifecycleConfiguration));
        } catch (XmlPullParserException e) {
            throw new CosXmlClientException(e);
        } catch (IOException e2) {
            throw new CosXmlClientException(e2);
        }
    }

    public void setRuleList(List<LifecycleConfiguration.Rule> ruleList) {
        if (ruleList != null) {
            this.lifecycleConfiguration.rules.addAll(ruleList);
        }
    }

    public void setRuleList(LifecycleConfiguration.Rule rule) {
        if (rule != null) {
            this.lifecycleConfiguration.rules.add(rule);
        }
    }

    public LifecycleConfiguration getLifecycleConfiguration() {
        return this.lifecycleConfiguration;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public boolean isNeedMD5() {
        return true;
    }
}
