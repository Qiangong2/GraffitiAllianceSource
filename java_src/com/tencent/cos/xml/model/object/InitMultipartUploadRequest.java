package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.common.COSACL;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.cos.xml.model.tag.ACLAccount;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.util.Map;

public final class InitMultipartUploadRequest extends ObjectRequest {
    public InitMultipartUploadRequest(String bucket, String cosPath) {
        super(bucket, cosPath);
    }

    public void setCacheControl(String cacheControl) {
        if (cacheControl != null) {
            addHeader(COSRequestHeaderKey.CACHE_CONTROL, cacheControl);
        }
    }

    public void setContentDisposition(String contentDisposition) {
        if (contentDisposition != null) {
            addHeader(COSRequestHeaderKey.CONTENT_DISPOSITION, contentDisposition);
        }
    }

    public void setContentEncoding(String contentEncoding) {
        if (contentEncoding != null) {
            addHeader(COSRequestHeaderKey.CONTENT_ENCODING, contentEncoding);
        }
    }

    public void setExpires(String expires) {
        if (expires != null) {
            addHeader(COSRequestHeaderKey.EXPIRES, expires);
        }
    }

    public void setXCOSMeta(String key, String value) {
        if (key != null && value != null) {
            addHeader(key, value);
        }
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
        return "POST";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        this.queryParameters.put("uploads", null);
        return this.queryParameters;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() {
        return RequestBodySerializer.bytes(null, new byte[0]);
    }
}
