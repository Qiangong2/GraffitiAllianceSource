package com.tencent.cos.xml.model.tag;

import com.tencent.qcloud.core.util.IOUtils;
import java.util.List;

public class ListBucketVersions {
    public boolean isTruncated;
    public String keyMarker;
    public long maxKeys;
    public String name;
    public String nextKeyMarker;
    public String nextVersionIdMarker;
    public List<ObjectVersion> objectVersionList;
    public String prefix;
    public String versionIdMarker;

    public static class ObjectVersion {
        public boolean isLatest;
        public String key;
        public String lastModified;
        public Owner owner;
        public String versionId;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{ListVersionsResult:\n");
        stringBuilder.append("Name:").append(this.name).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("Prefix:").append(this.prefix).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("KeyMarker:").append(this.keyMarker).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("VersionIdMarker:").append(this.versionIdMarker).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("MaxKeys:").append(this.maxKeys).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("IsTruncated:").append(this.isTruncated).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("NextKeyMarker:").append(this.nextKeyMarker).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("NextVersionIdMarker:").append(this.nextVersionIdMarker).append(IOUtils.LINE_SEPARATOR_UNIX);
        if (this.objectVersionList != null) {
            for (ObjectVersion objectVersion : this.objectVersionList) {
                stringBuilder.append(objectVersion.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static class DeleteMarker extends ObjectVersion {
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{DeleteMarker:\n");
            stringBuilder.append("Key:").append(this.key).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("VersionId:").append(this.versionId).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("IsLatest:").append(this.isLatest).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("LastModified:").append(this.lastModified).append(IOUtils.LINE_SEPARATOR_UNIX);
            if (this.owner != null) {
                stringBuilder.append(this.owner.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public static class Owner {
        public String uid;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{Owner:\n");
            stringBuilder.append("Uid:").append(this.uid).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public static class Version extends ObjectVersion {
        public String eTag;
        public long size;
        public String storageClass;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{Version:\n");
            stringBuilder.append("Key:").append(this.key).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("VersionId:").append(this.versionId).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("IsLatest:").append(this.isLatest).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("LastModified:").append(this.lastModified).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("ETag:").append(this.eTag).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("Size:").append(this.size).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("StorageClass:").append(this.storageClass).append(IOUtils.LINE_SEPARATOR_UNIX);
            if (this.owner != null) {
                stringBuilder.append(this.owner.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }
}
