package com.tencent.cos.xml.model.tag;

import com.tencent.qcloud.core.util.IOUtils;
import java.util.List;

public class ReplicationConfiguration {
    public String role;
    public List<Rule> rules;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{ReplicationConfiguration:\n");
        stringBuilder.append("Role:").append(this.role).append(IOUtils.LINE_SEPARATOR_UNIX);
        if (this.rules != null) {
            for (Rule rule : this.rules) {
                if (rule != null) {
                    stringBuilder.append(rule.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
                }
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static class Rule {
        public Destination destination;

        /* renamed from: id */
        public String f3126id;
        public String prefix;
        public String status;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{Rule:\n");
            stringBuilder.append("Id:").append(this.f3126id).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("Status:").append(this.status).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("Prefix:").append(this.prefix).append(IOUtils.LINE_SEPARATOR_UNIX);
            if (this.destination != null) {
                stringBuilder.append(this.destination.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public static class Destination {
        public String bucket;
        public String storageClass;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{Destination:\n");
            stringBuilder.append("Bucket:").append(this.bucket).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("StorageClass:").append(this.storageClass).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }
}
