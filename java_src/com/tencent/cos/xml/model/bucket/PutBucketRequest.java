package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.common.COSACL;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.cos.xml.model.tag.ACLAccount;
import com.tencent.qcloud.core.http.RequestBodySerializer;

public final class PutBucketRequest extends BucketRequest {
    public PutBucketRequest(String bucket) {
        super(bucket);
    }

    public void setXCOSACL(String cosacl) {
        if (cosacl != null) {
            addHeader(COSRequestHeaderKey.X_COS_ACL, cosacl);
        }
    }

    public void setXCOSACL(COSACL cosacl) {
        if (cosacl != null) {
            addHeader(COSRequestHeaderKey.X_COS_ACL, cosacl.getAcl());
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

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "PUT";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() {
        return RequestBodySerializer.bytes(null, new byte[0]);
    }
}