package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.cos.xml.common.Range;
import com.tencent.cos.xml.listener.CosXmlProgressListener;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.io.File;
import java.util.Map;
import org.pwrd.paho.client.mqttv3.MqttTopic;

public final class GetObjectRequest extends ObjectRequest {
    private CosXmlProgressListener progressListener;
    private Range range;
    private String rspCacheControl;
    private String rspContentDisposition;
    private String rspContentEncoding;
    private String rspContentLanguage;
    private String rspContentType;
    private String rspExpires;
    private String saveFileName;
    private String savePath;
    private String versionId;

    public GetObjectRequest(String bucket, String cosPath, String savePath2) {
        super(bucket, cosPath);
        this.savePath = savePath2;
    }

    public GetObjectRequest(String bucket, String cosPath, String savePath2, String saveFileName2) {
        super(bucket, cosPath);
        this.savePath = savePath2;
        this.saveFileName = saveFileName2;
    }

    public void setVersionId(String versionId2) {
        this.versionId = versionId2;
    }

    public void setRspContentType(String rspContentType2) {
        this.rspContentType = rspContentType2;
    }

    public String getRspContentType() {
        return this.rspContentType;
    }

    public void setRspContentLanguage(String rspContentLanguage2) {
        this.rspContentLanguage = rspContentLanguage2;
    }

    public String getRspContentLanguage() {
        return this.rspContentLanguage;
    }

    public void setRspExpires(String rspExpires2) {
        this.rspExpires = rspExpires2;
    }

    public String getRspExpires() {
        return this.rspExpires;
    }

    public void setRspCacheControl(String rspCacheControl2) {
        this.rspCacheControl = rspCacheControl2;
    }

    public String getRspCacheControl() {
        return this.rspCacheControl;
    }

    public void setRspContentDispositon(String rspContentDispositon) {
        this.rspContentDisposition = rspContentDispositon;
    }

    public String getRspContentDispositon() {
        return this.rspContentDisposition;
    }

    public void setRspContentEncoding(String rspContentEncoding2) {
        this.rspContentEncoding = rspContentEncoding2;
    }

    public String getRspContentEncoding() {
        return this.rspContentEncoding;
    }

    public void setRange(long start, long end) {
        if (start < 0) {
            start = 0;
        }
        Range range2 = new Range(start, end);
        addHeader("Range", range2.getRange());
        this.range = range2;
    }

    public void setRange(long start) {
        setRange(start, -1);
    }

    public Range getRange() {
        return this.range;
    }

    public void setIfModifiedSince(String ifModifiedSince) {
        if (ifModifiedSince != null) {
            addHeader(COSRequestHeaderKey.IF_MODIFIED_SINCE, ifModifiedSince);
        }
    }

    public void setIfUnmodifiedSince(String ifUnmodifiedSince) {
        if (ifUnmodifiedSince != null) {
            addHeader(COSRequestHeaderKey.IF_UNMODIFIED_SINCE, ifUnmodifiedSince);
        }
    }

    public void setIfMatch(String ifMatch) {
        if (ifMatch != null) {
            addHeader(COSRequestHeaderKey.IF_MATCH, ifMatch);
        }
    }

    public void setIfNONEMatch(String ifNONEMatch) {
        if (ifNONEMatch != null) {
            addHeader(COSRequestHeaderKey.IF_NONE_MATCH, ifNONEMatch);
        }
    }

    public void setProgressListener(CosXmlProgressListener progressListener2) {
        this.progressListener = progressListener2;
    }

    public CosXmlProgressListener getProgressListener() {
        return this.progressListener;
    }

    public void setSavePath(String savePath2) {
        this.savePath = savePath2;
    }

    public String getSavePath() {
        return this.savePath;
    }

    public String getDownloadPath() {
        String path = null;
        if (this.savePath != null) {
            if (!this.savePath.endsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
                path = this.savePath + MqttTopic.TOPIC_LEVEL_SEPARATOR;
            } else {
                path = this.savePath;
            }
            File file = new File(path);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (this.saveFileName != null) {
                return path + this.saveFileName;
            }
            if (this.cosPath != null) {
                int separator = this.cosPath.lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR);
                if (separator >= 0) {
                    path = path + this.cosPath.substring(separator + 1);
                } else {
                    path = path + this.cosPath;
                }
            }
        }
        return path;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "GET";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        if (this.versionId != null) {
            this.queryParameters.put("versionId", this.versionId);
        }
        if (this.rspContentType != null) {
            this.queryParameters.put("response-content-type=", this.rspContentType);
        }
        if (this.rspContentLanguage != null) {
            this.queryParameters.put("response-content-language", this.rspContentLanguage);
        }
        if (this.rspExpires != null) {
            this.queryParameters.put("response-expires", this.rspExpires);
        }
        if (this.rspCacheControl != null) {
            this.queryParameters.put("response-cache-control", this.rspCacheControl);
        }
        if (this.rspContentDisposition != null) {
            this.queryParameters.put("response-content-disposition", this.rspContentDisposition);
        }
        if (this.rspContentEncoding != null) {
            this.queryParameters.put("response-content-encoding", this.rspContentEncoding);
        }
        return super.getQueryString();
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() {
        return null;
    }
}
