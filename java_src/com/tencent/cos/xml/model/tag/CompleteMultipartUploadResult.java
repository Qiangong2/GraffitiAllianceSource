package com.tencent.cos.xml.model.tag;

import com.tencent.qcloud.core.util.IOUtils;

public class CompleteMultipartUploadResult {
    public String bucket;
    public String eTag;
    public String key;
    public String location;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{CompleteMultipartUploadResult:\n");
        stringBuilder.append("Location:").append(this.location).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("Bucket:").append(this.bucket).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("Key:").append(this.key).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("ETag:").append(this.eTag).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
