package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.CosXmlRequest;
import org.pwrd.paho.client.mqttv3.MqttTopic;

public abstract class ObjectRequest extends CosXmlRequest {
    protected String bucket;
    protected String cosPath;

    public ObjectRequest(String bucket2, String cosPath2) {
        this.bucket = bucket2;
        this.cosPath = cosPath2;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getHostPrefix() {
        return this.bucket;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getPath() {
        if (this.cosPath == null || this.cosPath.startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
            return this.cosPath;
        }
        return MqttTopic.TOPIC_LEVEL_SEPARATOR + this.cosPath;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        if (this.bucket == null) {
            throw new CosXmlClientException("bucket must not be null ");
        } else if (this.cosPath == null) {
            throw new CosXmlClientException("cosPath must not be null ");
        }
    }
}
