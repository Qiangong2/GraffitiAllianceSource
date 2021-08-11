package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.common.COSACL;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.cos.xml.common.COSStorageClass;
import com.tencent.cos.xml.common.MetaDataDirective;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.ACLAccount;
import com.tencent.cos.xml.utils.URLEncodeUtils;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import org.pwrd.paho.client.mqttv3.MqttTopic;

public class CopyObjectRequest extends ObjectRequest {
    private CopySourceStruct copySourceStruct;

    public CopyObjectRequest(String bucket, String cosPath, CopySourceStruct copySourceStruct2) throws CosXmlClientException {
        super(bucket, cosPath);
        this.copySourceStruct = copySourceStruct2;
        setCopySource(copySourceStruct2);
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "PUT";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        return RequestBodySerializer.bytes(null, new byte[0]);
    }

    @Override // com.tencent.cos.xml.model.object.ObjectRequest, com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        if (this.copySourceStruct == null) {
            throw new CosXmlClientException("copy source must not be null");
        }
        this.copySourceStruct.checkParameters();
    }

    public void setCosPath(String cosPath) {
        this.cosPath = cosPath;
    }

    public String getCosPath() {
        return this.cosPath;
    }

    public void setCopySource(CopySourceStruct copySource) throws CosXmlClientException {
        this.copySourceStruct = copySource;
        if (this.copySourceStruct != null) {
            addHeader(COSRequestHeaderKey.X_COS_COPY_SOURCE, this.copySourceStruct.getSource());
        }
    }

    public String getCopySource() {
        return this.copySourceStruct.toString();
    }

    public void setCopyMetaDataDirective(MetaDataDirective metaDataDirective) {
        if (metaDataDirective != null) {
            addHeader(COSRequestHeaderKey.X_COS_METADATA_DIRECTIVE, metaDataDirective.getMetaDirective());
        }
    }

    public void setCopyIfModifiedSince(String sourceIfModifiedSince) {
        if (sourceIfModifiedSince != null) {
            addHeader(COSRequestHeaderKey.X_COS_COPY_SOURCE_IF_MODIFIED_SINCE, sourceIfModifiedSince);
        }
    }

    public void setCopyIfUnmodifiedSince(String sourceIfUnmodifiedSince) {
        if (sourceIfUnmodifiedSince != null) {
            addHeader(COSRequestHeaderKey.X_COS_COPY_SOURCE_IF_UNMODIFIED_SINCE, sourceIfUnmodifiedSince);
        }
    }

    public void setCopyIfMatch(String eTag) {
        if (eTag != null) {
            addHeader(COSRequestHeaderKey.X_COS_COPY_SOURCE_IF_MATCH, eTag);
        }
    }

    public void setCopyIfNoneMatch(String eTag) {
        if (eTag != null) {
            addHeader(COSRequestHeaderKey.X_COS_COPY_SOURCE_IF_NONE_MATCH, eTag);
        }
    }

    public void setCosStorageClass(COSStorageClass cosStorageClass) {
        if (cosStorageClass != null) {
            addHeader(COSRequestHeaderKey.X_COS_STORAGE_CLASS_, cosStorageClass.getStorageClass());
        }
    }

    public void setXCOSACL(COSACL cosacl) {
        if (cosacl != null) {
            addHeader(COSRequestHeaderKey.X_COS_ACL, cosacl.getAcl());
        }
    }

    public void setXCOSACL(String cosacl) {
        if (cosacl != null) {
            addHeader(COSRequestHeaderKey.X_COS_ACL, cosacl);
        }
    }

    public void setXCOSGrantRead(ACLAccount aclAccount) {
        if (aclAccount != null) {
            addHeader(COSRequestHeaderKey.X_COS_GRANT_READ, aclAccount.getAccount());
        }
    }

    public void setXCOSGrantWrite(ACLAccount aclAccount) {
        if (aclAccount != null) {
            addHeader(COSRequestHeaderKey.X_COS_GRANT_WRITE, aclAccount.getAccount());
        }
    }

    public void setXCOSReadWrite(ACLAccount aclAccount) {
        if (aclAccount != null) {
            addHeader(COSRequestHeaderKey.X_COS_GRANT_FULL_CONTROL, aclAccount.getAccount());
        }
    }

    public void setXCOSMeta(String key, String value) {
        if (key != null && value != null) {
            addHeader(key, value);
        }
    }

    public static class CopySourceStruct {
        public String appid;
        public String bucket;
        public String cosPath;
        public String region;
        public String versionId;

        public CopySourceStruct(String appid2, String bucket2, String region2, String cosPath2) {
            this.appid = appid2;
            this.bucket = bucket2;
            this.region = region2;
            this.cosPath = cosPath2;
        }

        public CopySourceStruct(String appid2, String bucket2, String region2, String cosPath2, String versionId2) {
            this.appid = appid2;
            this.bucket = bucket2;
            this.region = region2;
            this.cosPath = cosPath2;
            this.versionId = versionId2;
        }

        public void checkParameters() throws CosXmlClientException {
            if (this.bucket == null) {
                throw new CosXmlClientException("copy source bucket must not be null");
            } else if (this.cosPath == null) {
                throw new CosXmlClientException("copy source cosPath must not be null");
            } else if (this.appid == null) {
                throw new CosXmlClientException("copy source appid must not be null");
            } else if (this.region == null) {
                throw new CosXmlClientException("copy source region must not be null");
            } else {
                this.cosPath = URLEncodeUtils.cosPathEncode(this.cosPath);
            }
        }

        public String getSource() throws CosXmlClientException {
            if (this.cosPath != null && !this.cosPath.startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
                this.cosPath = MqttTopic.TOPIC_LEVEL_SEPARATOR + this.cosPath;
            }
            this.cosPath = URLEncodeUtils.cosPathEncode(this.cosPath);
            StringBuilder copySource = new StringBuilder();
            if (this.bucket.endsWith("-" + this.appid)) {
                copySource.append(this.bucket).append(".");
            } else {
                copySource.append(this.bucket).append("-").append(this.appid).append(".");
            }
            copySource.append("cos").append(".").append(this.region).append(".").append("myqcloud.com").append(this.cosPath);
            if (this.versionId != null) {
                copySource.append("?versionId=").append(this.versionId);
            }
            return copySource.toString();
        }
    }
}
