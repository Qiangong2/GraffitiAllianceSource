package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.CosXmlRequest;
import org.pwrd.paho.client.mqttv3.MqttTopic;

public abstract class BucketRequest extends CosXmlRequest {
    protected String bucket;

    public BucketRequest(String bucket2) {
        this.bucket = bucket2;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getPath() {
        return MqttTopic.TOPIC_LEVEL_SEPARATOR;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getHostPrefix() {
        return this.bucket;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        if (this.bucket == null) {
            throw new CosXmlClientException("bucket must not be null");
        }
    }
}
