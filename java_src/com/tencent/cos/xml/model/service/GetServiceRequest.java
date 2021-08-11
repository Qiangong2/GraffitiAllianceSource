package com.tencent.cos.xml.model.service;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import org.pwrd.paho.client.mqttv3.MqttTopic;

public final class GetServiceRequest extends CosXmlRequest {
    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "GET";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getHostPrefix() {
        return "service";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getPath() {
        return MqttTopic.TOPIC_LEVEL_SEPARATOR;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() {
        return null;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getHost(String appid, String region) {
        return getHostPrefix() + ".cos." + "myqcloud.com";
    }
}
