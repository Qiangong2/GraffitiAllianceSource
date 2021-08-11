package com.tencent.cos.xml.model.tag;

import com.tencent.qcloud.core.util.IOUtils;
import java.util.List;

public class ListMultipartUploads {
    public String bucket;
    public List<CommonPrefixes> commonPrefixes;
    public String delimiter;
    public String encodingType;
    public boolean isTruncated;
    public String keyMarker;
    public String maxUploads;
    public String nextKeyMarker;
    public String nextUploadIdMarker;
    public String prefix;
    public String uploadIdMarker;
    public List<Upload> uploads;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{ListMultipartUploads:\n");
        stringBuilder.append("Bucket:").append(this.bucket).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("Encoding-Type:").append(this.encodingType).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("KeyMarker:").append(this.keyMarker).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("UploadIdMarker:").append(this.uploadIdMarker).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("NextKeyMarker:").append(this.nextKeyMarker).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("NextUploadIdMarker:").append(this.nextUploadIdMarker).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("MaxUploads:").append(this.maxUploads).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("IsTruncated:").append(this.isTruncated).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("Prefix:").append(this.prefix).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("Delimiter:").append(this.delimiter).append(IOUtils.LINE_SEPARATOR_UNIX);
        if (this.uploads != null) {
            for (Upload upload : this.uploads) {
                if (upload != null) {
                    stringBuilder.append(upload.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
                }
            }
        }
        if (this.commonPrefixes != null) {
            for (CommonPrefixes commonPrefix : this.commonPrefixes) {
                if (commonPrefix != null) {
                    stringBuilder.append(commonPrefix.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
                }
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static class Upload {
        public String initiated;
        public Initiator initiator;
        public String key;
        public Owner owner;
        public String storageClass;
        public String uploadID;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{Upload:\n");
            stringBuilder.append("Key:").append(this.key).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("UploadID:").append(this.uploadID).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("StorageClass:").append(this.storageClass).append(IOUtils.LINE_SEPARATOR_UNIX);
            if (this.initiator != null) {
                stringBuilder.append(this.initiator.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            if (this.owner != null) {
                stringBuilder.append(this.owner.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            stringBuilder.append("Initiated:").append(this.initiated).append(IOUtils.LINE_SEPARATOR_UNIX);
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

    public static class Initiator {
        public String displayName;

        /* renamed from: id */
        public String f3122id;
        public String uin;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{Initiator:\n");
            stringBuilder.append("Uin:").append(this.uin).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("Id:").append(this.f3122id).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("DisplayName:").append(this.displayName).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public static class Owner {
        public String displayName;

        /* renamed from: id */
        public String f3123id;
        public String uid;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{Owner:\n");
            stringBuilder.append("Uid:").append(this.uid).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("Id:").append(this.f3123id).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("DisplayName:").append(this.displayName).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }
}
