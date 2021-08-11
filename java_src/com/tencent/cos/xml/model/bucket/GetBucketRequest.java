package com.tencent.cos.xml.model.bucket;

import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.util.Map;

public final class GetBucketRequest extends BucketRequest {
    private String delimiter = null;
    private String encodingType;
    private String marker = null;
    private String maxKeys = "1000";
    private String prefix = null;

    public GetBucketRequest(String bucket) {
        super(bucket);
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "GET";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        if (this.prefix != null) {
            this.queryParameters.put("prefix", this.prefix);
        }
        if (this.delimiter != null) {
            this.queryParameters.put("delimiter", this.delimiter);
        }
        if (this.encodingType != null) {
            this.queryParameters.put("encoding-type", this.encodingType);
        }
        if (this.marker != null) {
            this.queryParameters.put("marker", this.marker);
        }
        if (this.maxKeys != null) {
            this.queryParameters.put("max-keys", this.maxKeys);
        }
        if (this.prefix != null) {
            this.queryParameters.put("prefix", this.prefix);
        }
        return super.getQueryString();
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() {
        return null;
    }

    public void setPrefix(String prefix2) {
        this.prefix = prefix2;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setDelimiter(char delimiter2) {
        this.delimiter = String.valueOf(delimiter2);
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

    public void setMarker(String marker2) {
        this.marker = marker2;
    }

    public String getMarker() {
        return this.marker;
    }

    public void setMaxKeys(long maxKeys2) {
        this.maxKeys = String.valueOf(maxKeys2);
    }

    public long getMaxKeys() {
        return Long.parseLong(this.maxKeys);
    }
}
