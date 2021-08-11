package com.tencent.cos.xml.model.tag;

import com.tencent.qcloud.core.util.IOUtils;

public class VersioningConfiguration {
    public String status;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{VersioningConfiguration:\n");
        stringBuilder.append("Status:").append(this.status).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
