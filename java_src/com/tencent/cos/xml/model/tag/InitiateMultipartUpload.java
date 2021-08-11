package com.tencent.cos.xml.model.tag;

import com.tencent.qcloud.core.util.IOUtils;

public class InitiateMultipartUpload {
    public String bucket;
    public String key;
    public String uploadId;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{InitiateMultipartUpload:\n");
        stringBuilder.append("Bucket:").append(this.bucket).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("Key:").append(this.key).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("UploadId:").append(this.uploadId).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
