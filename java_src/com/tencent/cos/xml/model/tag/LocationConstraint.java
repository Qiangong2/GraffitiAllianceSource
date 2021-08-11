package com.tencent.cos.xml.model.tag;

import com.tencent.qcloud.core.util.IOUtils;

public class LocationConstraint {
    public String location;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{LocationConstraint:\n");
        stringBuilder.append("Location:").append(this.location).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
