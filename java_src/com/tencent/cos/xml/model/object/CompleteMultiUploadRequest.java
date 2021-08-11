package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.CompleteMultipartUpload;
import com.tencent.cos.xml.transfer.XmlSlimBuilder;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public final class CompleteMultiUploadRequest extends ObjectRequest {
    private CompleteMultipartUpload completeMultipartUpload = new CompleteMultipartUpload();
    private String uploadId;

    public CompleteMultiUploadRequest(String bucket, String cosPath, String uploadId2, Map<Integer, String> partNumberAndETag) {
        super(bucket, cosPath);
        this.uploadId = uploadId2;
        this.completeMultipartUpload.parts = new ArrayList();
        setPartNumberAndETag(partNumberAndETag);
    }

    public CompleteMultipartUpload getCompleteMultipartUpload() {
        return this.completeMultipartUpload;
    }

    public void setPartNumberAndETag(int partNumbers, String eTag) {
        CompleteMultipartUpload.Part part = new CompleteMultipartUpload.Part();
        part.partNumber = partNumbers;
        part.eTag = eTag;
        this.completeMultipartUpload.parts.add(part);
    }

    public void setPartNumberAndETag(Map<Integer, String> partNumberAndETag) {
        if (partNumberAndETag != null) {
            for (Map.Entry<Integer, String> entry : partNumberAndETag.entrySet()) {
                CompleteMultipartUpload.Part part = new CompleteMultipartUpload.Part();
                part.partNumber = entry.getKey().intValue();
                part.eTag = entry.getValue();
                this.completeMultipartUpload.parts.add(part);
            }
        }
    }

    public void setUploadId(String uploadId2) {
        this.uploadId = uploadId2;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "POST";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        this.queryParameters.put("uploadID", this.uploadId);
        return this.queryParameters;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        try {
            return RequestBodySerializer.string("application/xml", XmlSlimBuilder.buildCompleteMultipartUpload(this.completeMultipartUpload));
        } catch (IOException e) {
            throw new CosXmlClientException(e);
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException(e2);
        }
    }

    @Override // com.tencent.cos.xml.model.object.ObjectRequest, com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        if (this.uploadId == null) {
            throw new CosXmlClientException("uploadID must not be null");
        }
    }
}
