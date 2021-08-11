package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.object.CopyObjectRequest;
import java.util.Map;

public class UploadPartCopyRequest extends CopyObjectRequest {
    private int partNumber;
    private String uploadId;

    public UploadPartCopyRequest(String bucket, String cosPath, int partNumber2, String uploadId2, CopyObjectRequest.CopySourceStruct copySourceStruct) throws CosXmlClientException {
        this(bucket, cosPath, partNumber2, uploadId2, copySourceStruct, -1, -1);
    }

    public UploadPartCopyRequest(String bucket, String cosPath, int partNumber2, String uploadId2, CopyObjectRequest.CopySourceStruct copySourceStruct, long start, long end) throws CosXmlClientException {
        super(bucket, cosPath, copySourceStruct);
        this.partNumber = -1;
        this.uploadId = null;
        this.partNumber = partNumber2;
        this.uploadId = uploadId2;
        setCopyRange(start, end);
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        this.queryParameters.put("partNumber", String.valueOf(this.partNumber));
        this.queryParameters.put("uploadId", this.uploadId);
        return super.getQueryString();
    }

    @Override // com.tencent.cos.xml.model.object.ObjectRequest, com.tencent.cos.xml.model.object.CopyObjectRequest, com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        if (this.partNumber <= 0) {
            throw new CosXmlClientException("partNumber must be >= 1");
        } else if (this.uploadId == null) {
            throw new CosXmlClientException("uploadID must not be null");
        }
    }

    public void setCopyRange(long start, long end) {
        if (start >= 0 && end >= start) {
            addHeader(COSRequestHeaderKey.X_COS_COPY_SOURCE_RANGE, "bytes=" + start + "-" + end);
        }
    }
}
