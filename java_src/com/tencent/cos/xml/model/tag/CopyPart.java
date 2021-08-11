package com.tencent.cos.xml.model.tag;

import com.tencent.qcloud.core.util.IOUtils;

public class CopyPart {
    public String eTag;
    public String lastModified;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{CopyPart:\n");
        stringBuilder.append("ETag:").append(this.eTag).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("LastModified:").append(this.lastModified).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
