package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.util.Map;

public class ListBucketVersionsRequest extends BucketRequest {
    private String delimiter;
    private String encodingType;
    private String keyMarker;
    private String maxKeys = "1000";
    private String prefix;
    private String versionIdMarker;

    public ListBucketVersionsRequest(String bucket) {
        super(bucket);
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "GET";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        return null;
    }

    public void setPrefix(String prefix2) {
        if (prefix2 != null) {
            this.prefix = prefix2;
        }
    }

    public void setKeyMarker(String keyMarker2) {
        if (keyMarker2 != null) {
            this.keyMarker = keyMarker2;
        }
    }

    public void setVersionIdMarker(String versionIdMarker2) {
        if (versionIdMarker2 != null) {
            this.versionIdMarker = versionIdMarker2;
        }
    }

    public void setDelimiter(String delimiter2) {
        this.delimiter = delimiter2;
    }

    public void setEncodingType(String encodingType2) {
        this.encodingType = encodingType2;
    }

    public void setMaxKeys(int maxKeys2) {
        this.maxKeys = String.valueOf(maxKeys2);
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        this.queryParameters.put("versions", null);
        if (this.prefix != null) {
            this.queryParameters.put("prefix", this.prefix);
        }
        if (this.keyMarker != null) {
            this.queryParameters.put("key-marker", this.keyMarker);
        }
        if (this.versionIdMarker != null) {
            this.queryParameters.put("version-id-marker", this.versionIdMarker);
        }
        if (this.delimiter != null) {
            this.queryParameters.put("delimiter", this.delimiter);
        }
        if (this.encodingType != null) {
            this.queryParameters.put("encoding-type", this.encodingType);
        }
        if (!this.maxKeys.equals("1000")) {
            this.queryParameters.put("max-keys", this.maxKeys);
        }
        return super.getQueryString();
    }
}
