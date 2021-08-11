package com.tencent.cos.xml.model.tag;

import com.tencent.qcloud.core.util.IOUtils;
import java.util.List;

public class DeleteResult {
    public List<Deleted> deletedList;
    public List<Error> errorList;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{DeleteResult:\n");
        if (this.deletedList != null) {
            for (Deleted deleted : this.deletedList) {
                if (deleted != null) {
                    stringBuilder.append(deleted.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
                }
            }
        }
        if (this.errorList != null) {
            for (Error error : this.errorList) {
                if (error != null) {
                    stringBuilder.append(error.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
                }
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static class Deleted {
        public boolean deleteMarker;
        public String deleteMarkerVersionId;
        public String key;
        public String versionId;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{Deleted:\n");
            stringBuilder.append("Key:").append(this.key).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("VersionId:").append(this.versionId).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("DeleteMarker:").append(this.deleteMarker).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("DeleteMarkerVersionId:").append(this.deleteMarkerVersionId).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public static class Error {
        public String code;
        public String key;
        public String message;
        public String versionId;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{CosError:\n");
            stringBuilder.append("Key:").append(this.key).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("Code:").append(this.code).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("Message:").append(this.message).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("VersionId:").append(this.versionId).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }
}
