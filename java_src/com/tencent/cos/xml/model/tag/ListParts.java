package com.tencent.cos.xml.model.tag;

import com.tencent.qcloud.core.util.IOUtils;
import java.util.List;

public class ListParts {
    public String bucket;
    public String encodingType;
    public Initiator initiator;
    public boolean isTruncated;
    public String key;
    public String maxParts;
    public String nextPartNumberMarker;
    public Owner owner;
    public String partNumberMarker;
    public List<Part> parts;
    public String storageClass;
    public String uploadId;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{ListParts:\n");
        stringBuilder.append("Bucket:").append(this.bucket).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("Encoding-Type:").append(this.encodingType).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("Key:").append(this.key).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("UploadId:").append(this.uploadId).append(IOUtils.LINE_SEPARATOR_UNIX);
        if (this.owner != null) {
            stringBuilder.append(this.owner.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        stringBuilder.append("PartNumberMarker:").append(this.partNumberMarker).append(IOUtils.LINE_SEPARATOR_UNIX);
        if (this.initiator != null) {
            stringBuilder.append(this.initiator.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        stringBuilder.append("StorageClass:").append(this.storageClass).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("NextPartNumberMarker:").append(this.nextPartNumberMarker).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("MaxParts:").append(this.maxParts).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("IsTruncated:").append(this.isTruncated).append(IOUtils.LINE_SEPARATOR_UNIX);
        if (this.parts != null) {
            for (Part part : this.parts) {
                if (part != null) {
                    stringBuilder.append(part.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
                }
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static class Owner {
        public String disPlayName;

        /* renamed from: id */
        public String f3125id;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{Owner:\n");
            stringBuilder.append("Id:").append(this.f3125id).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("DisPlayName:").append(this.disPlayName).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public static class Initiator {
        public String disPlayName;

        /* renamed from: id */
        public String f3124id;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{Initiator:\n");
            stringBuilder.append("Id:").append(this.f3124id).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("DisPlayName:").append(this.disPlayName).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public static class Part {
        public String eTag;
        public String lastModified;
        public String partNumber;
        public String size;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{Part:\n");
            stringBuilder.append("PartNumber:").append(this.partNumber).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("LastModified:").append(this.lastModified).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("ETag:").append(this.eTag).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("Size:").append(this.size).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }
}
