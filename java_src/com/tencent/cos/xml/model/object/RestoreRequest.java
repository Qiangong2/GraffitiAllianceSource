package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.RestoreConfigure;
import com.tencent.cos.xml.transfer.XmlBuilder;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.io.IOException;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public class RestoreRequest extends ObjectRequest {
    private RestoreConfigure restoreConfigure = new RestoreConfigure();

    public RestoreRequest(String bucket, String cosPath) {
        super(bucket, cosPath);
        this.restoreConfigure.casJobParameters = new RestoreConfigure.CASJobParameters();
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        this.queryParameters.put("restore", null);
        return this.queryParameters;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "POST";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        try {
            return RequestBodySerializer.string("application/xml", XmlBuilder.buildRestore(this.restoreConfigure));
        } catch (XmlPullParserException e) {
            throw new CosXmlClientException(e);
        } catch (IOException e2) {
            throw new CosXmlClientException(e2);
        }
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public boolean isNeedMD5() {
        return true;
    }

    public void setExpireDays(int days) {
        if (days < 0) {
            days = 0;
        }
        this.restoreConfigure.days = days;
    }

    public void setTier(RestoreConfigure.Tier tier) {
        if (tier != null) {
            this.restoreConfigure.casJobParameters.tier = tier.getTier();
        }
    }
}
