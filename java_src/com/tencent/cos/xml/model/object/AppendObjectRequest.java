package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.CosXmlSimpleService;
import com.tencent.cos.xml.common.COSACL;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.listener.CosXmlProgressListener;
import com.tencent.cos.xml.model.tag.ACLAccount;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

public final class AppendObjectRequest extends ObjectRequest {
    private byte[] data;
    private long fileLength;
    public InputStream inputStream;
    private long position;
    private CosXmlProgressListener progressListener;
    private String srcPath;

    private AppendObjectRequest(String bucket, String cosPath) {
        super(bucket, cosPath);
        this.position = 0;
    }

    public AppendObjectRequest(String bucket, String cosPath, String srcPath2, long position2) {
        this(bucket, cosPath);
        this.srcPath = srcPath2;
        this.position = position2;
    }

    public AppendObjectRequest(String bucket, String cosPath, byte[] data2, long position2) {
        this(bucket, cosPath);
        this.data = data2;
        this.position = position2;
    }

    public AppendObjectRequest(String bucket, String cosPath, InputStream inputStream2, long position2) throws CosXmlClientException {
        this(bucket, cosPath);
        this.inputStream = inputStream2;
        this.position = position2;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "POST";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        this.queryParameters.put("append", null);
        this.queryParameters.put("position", String.valueOf(this.position));
        return this.queryParameters;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        if (this.srcPath != null) {
            return RequestBodySerializer.file(null, new File(this.srcPath));
        }
        if (this.data != null) {
            return RequestBodySerializer.bytes(null, this.data);
        }
        if (this.inputStream != null) {
            return RequestBodySerializer.stream((String) null, new File(CosXmlSimpleService.appCachePath), this.inputStream);
        }
        return null;
    }

    @Override // com.tencent.cos.xml.model.object.ObjectRequest, com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        if (this.srcPath == null && this.data == null && this.inputStream == null) {
            throw new CosXmlClientException("Data Source must not be null");
        } else if (this.srcPath != null && !new File(this.srcPath).exists()) {
            throw new CosXmlClientException("upload file does not exist");
        }
    }

    public void setPosition(long position2) {
        if (position2 < 0) {
            this.position = 0;
        }
        this.position = position2;
    }

    public long getPosition() {
        return this.position;
    }

    public void setSrcPath(String srcPath2) {
        this.srcPath = srcPath2;
    }

    public String getSrcPath() {
        return this.srcPath;
    }

    public void setData(byte[] data2) {
        this.data = data2;
    }

    public byte[] getData() {
        return this.data;
    }

    public long getFileLength() {
        if (this.srcPath != null) {
            this.fileLength = new File(this.srcPath).length();
        } else if (this.data != null) {
            this.fileLength = (long) this.data.length;
        }
        return this.fileLength;
    }

    public void setProgressListener(CosXmlProgressListener progressListener2) {
        this.progressListener = progressListener2;
    }

    public CosXmlProgressListener getProgressListener() {
        return this.progressListener;
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

    public void setContentEncodeing(String contentEncoding) {
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
}
