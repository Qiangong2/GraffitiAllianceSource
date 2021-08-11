package com.tencent.cos.xml.model.bucket;

import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.util.Map;

public final class ListMultiUploadsRequest extends BucketRequest {
    private String delimiter;
    private String encodingType;
    private String keyMarker;
    private String maxUploads;
    private String prefix;
    private String uploadIdMarker;

    public ListMultiUploadsRequest(String bucket) {
        super(bucket);
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "GET";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        this.queryParameters.put("uploads", null);
        if (this.delimiter != null) {
            this.queryParameters.put("delimiter", this.delimiter);
        }
        if (this.encodingType != null) {
            this.queryParameters.put("Encoding-type", this.encodingType);
        }
        if (this.prefix != null) {
            this.queryParameters.put("Prefix", this.prefix);
        }
        if (this.maxUploads != null) {
            this.queryParameters.put("max-uploads", this.maxUploads);
        }
        if (this.keyMarker != null) {
            this.queryParameters.put("key-marker", this.keyMarker);
        }
        if (this.uploadIdMarker != null) {
            this.queryParameters.put("upload-id-marker", this.uploadIdMarker);
        }
        return super.getQueryString();
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() {
        return null;
    }

    public void setDelimiter(String delimiter2) {
        this.delimiter = delimiter2;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public void setEncodingType(String encodingType2) {
        this.encodingType = encodingType2;
    }

    public String getEncodingType() {
        return this.encodingType;
    }

    public void setKeyMarker(String keyMarker2) {
        this.keyMarker = keyMarker2;
    }

    public String getKeyMarker() {
        return this.keyMarker;
    }

    public void setMaxUploads(String maxUploads2) {
        this.maxUploads = maxUploads2;
    }

    public String getMaxUploads() {
        return this.maxUploads;
    }

    public void setPrefix(String prefix2) {
        this.prefix = prefix2;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setUploadIdMarker(String uploadIdMarker2) {
        this.uploadIdMarker = uploadIdMarker2;
    }

    public String getUploadIdMarker() {
        return this.uploadIdMarker;
    }
}
