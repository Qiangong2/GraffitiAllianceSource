package com.tencent.cos.xml.model.tag;

import com.tencent.qcloud.core.util.IOUtils;
import java.util.List;

public class ListBucket {
    public List<CommonPrefixes> commonPrefixesList;
    public List<Contents> contentsList;
    public String delimiter;
    public String encodingType;
    public boolean isTruncated;
    public String marker;
    public int maxKeys;
    public String name;
    public String nextMarker;
    public String prefix;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{ListBucket:\n");
        stringBuilder.append("Name:").append(this.name).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("Encoding-Type:").append(this.encodingType).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("Prefix:").append(this.prefix).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("Marker:").append(this.marker).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("MaxKeys:").append(this.maxKeys).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("IsTruncated:").append(this.isTruncated).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("NextMarker:").append(this.nextMarker).append(IOUtils.LINE_SEPARATOR_UNIX);
        if (this.contentsList != null) {
            for (Contents contents : this.contentsList) {
                if (contents != null) {
                    stringBuilder.append(contents.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
                }
            }
        }
        if (this.commonPrefixesList != null) {
            for (CommonPrefixes commonPrefixes : this.commonPrefixesList) {
                if (commonPrefixes != null) {
                    stringBuilder.append(commonPrefixes.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
                }
            }
        }
        stringBuilder.append("Delimiter:").append(this.delimiter).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static class Contents {
        public String eTag;
        public String key;
        public String lastModified;
        public Owner owner;
        public long size;
        public String storageClass;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{Contents:\n");
            stringBuilder.append("Key:").append(this.key).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("LastModified:").append(this.lastModified).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("ETag:").append(this.eTag).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("Size:").append(this.size).append(IOUtils.LINE_SEPARATOR_UNIX);
            if (this.owner != null) {
                stringBuilder.append(this.owner.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            stringBuilder.append("StorageClass:").append(this.storageClass).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public static class CommonPrefixes {
        public String prefix;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{CommonPrefixes:\n");
            stringBuilder.append("Prefix:").append(this.prefix).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public static class Owner {

        /* renamed from: id */
        public String f3121id;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{Owner:\n");
            stringBuilder.append("Id:").append(this.f3121id).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }
}
