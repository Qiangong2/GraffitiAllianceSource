package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.util.Map;

public final class ListPartsRequest extends ObjectRequest {
    private String encodingType;
    private String maxParts;
    private String partNumberMarker;
    private String uploadId;

    public ListPartsRequest(String bucket, String cosPath, String uploadId2) {
        super(bucket, cosPath);
        this.uploadId = uploadId2;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "GET";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        if (this.uploadId != null) {
            this.queryParameters.put("uploadID", this.uploadId);
        }
        if (this.maxParts != null) {
            this.queryParameters.put("max-parts", this.maxParts);
        }
        if (this.partNumberMarker != null) {
            this.queryParameters.put("part-number-marker", this.maxParts);
        }
        if (this.encodingType != null) {
            this.queryParameters.put("Encoding-type", this.encodingType);
        }
        return this.queryParameters;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() {
        return null;
    }

    @Override // com.tencent.cos.xml.model.object.ObjectRequest, com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        if (this.uploadId == null) {
            throw new CosXmlClientException("uploadID must not be null");
        }
    }

    public void setUploadId(String uploadId2) {
        this.uploadId = uploadId2;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public void setMaxParts(int maxParts2) {
        if (maxParts2 <= 0) {
            maxParts2 = 1;
        }
        this.maxParts = String.valueOf(maxParts2);
    }

    public int getMaxParts() {
        return Integer.parseInt(this.maxParts);
    }

    public void setPartNumberMarker(int partNumberMarker2) {
        this.partNumberMarker = String.valueOf(partNumberMarker2);
    }

    public int getPartNumberMarker() {
        return Integer.parseInt(this.partNumberMarker);
    }

    public void setEncodingType(String encodingType2) {
        this.encodingType = encodingType2;
    }

    public String getEncodingType() {
        return this.encodingType;
    }
}
