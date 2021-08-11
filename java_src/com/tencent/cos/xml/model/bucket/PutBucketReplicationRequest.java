package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.ReplicationConfiguration;
import com.tencent.cos.xml.transfer.XmlBuilder;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public class PutBucketReplicationRequest extends BucketRequest {
    private ReplicationConfiguration replicationConfiguration = new ReplicationConfiguration();

    public static class RuleStruct {
        public String appid;
        public String bucket;

        /* renamed from: id */
        public String f3115id;
        public boolean isEnable;
        public String prefix;
        public String region;
        public String storageClass;
    }

    public PutBucketReplicationRequest(String bucket) {
        super(bucket);
        this.replicationConfiguration.rules = new ArrayList();
    }

    public void setReplicationConfigurationWithRole(String ownerUin, String subUin) {
        if (ownerUin != null && subUin != null) {
            this.replicationConfiguration.role = "qcs::cam::uin/" + ownerUin + ":uin/" + subUin;
        }
    }

    public void setReplicationConfigurationWithRule(RuleStruct ruleStruct) {
        if (ruleStruct != null) {
            ReplicationConfiguration.Rule rule = new ReplicationConfiguration.Rule();
            rule.f3126id = ruleStruct.f3115id;
            rule.status = ruleStruct.isEnable ? "Enabled" : "Disabled";
            rule.prefix = ruleStruct.prefix;
            ReplicationConfiguration.Destination destination = new ReplicationConfiguration.Destination();
            destination.storageClass = ruleStruct.storageClass;
            StringBuilder bucket = new StringBuilder();
            bucket.append("qcs:id/0:cos:").append(ruleStruct.region).append(":appid/").append(ruleStruct.appid).append(":").append(ruleStruct.bucket);
            destination.bucket = bucket.toString();
            rule.destination = destination;
            this.replicationConfiguration.rules.add(rule);
        }
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "PUT";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        this.queryParameters.put("replication", null);
        return super.getQueryString();
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        try {
            return RequestBodySerializer.string("application/xml", XmlBuilder.buildReplicationConfiguration(this.replicationConfiguration));
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
}
