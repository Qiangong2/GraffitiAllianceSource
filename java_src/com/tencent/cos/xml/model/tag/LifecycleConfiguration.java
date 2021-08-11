package com.tencent.cos.xml.model.tag;

import com.tencent.qcloud.core.util.IOUtils;
import java.util.List;

public class LifecycleConfiguration {
    public List<Rule> rules;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{LifecycleConfiguration:\n");
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
        public AbortIncompleteMultiUpload abortIncompleteMultiUpload;
        public Expiration expiration;
        public Filter filter;

        /* renamed from: id */
        public String f3119id;
        public NoncurrentVersionExpiration noncurrentVersionExpiration;
        public NoncurrentVersionTransition noncurrentVersionTransition;
        public String status;
        public Transition transition;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{Rule:\n");
            stringBuilder.append("Id:").append(this.f3119id).append(IOUtils.LINE_SEPARATOR_UNIX);
            if (this.filter != null) {
                stringBuilder.append(this.filter.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            stringBuilder.append("Status:").append(this.status).append(IOUtils.LINE_SEPARATOR_UNIX);
            if (this.transition != null) {
                stringBuilder.append(this.transition.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            if (this.expiration != null) {
                stringBuilder.append(this.expiration.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            if (this.noncurrentVersionExpiration != null) {
                stringBuilder.append(this.noncurrentVersionExpiration.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            if (this.noncurrentVersionTransition != null) {
                stringBuilder.append(this.noncurrentVersionTransition.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            if (this.abortIncompleteMultiUpload != null) {
                stringBuilder.append(this.abortIncompleteMultiUpload.toString()).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public static class Filter {
        public String prefix;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{Filter:\n");
            stringBuilder.append("Prefix:").append(this.prefix).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public static class Transition {
        public String date;
        public int days;
        public String storageClass;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{Transition:\n");
            stringBuilder.append("Days:").append(this.days).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("Date:").append(this.date).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("StorageClass:").append(this.storageClass).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public static class Expiration {
        public String date;
        public int days;
        public String expiredObjectDeleteMarker;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{Expiration:\n");
            stringBuilder.append("Days:").append(this.days).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("Date:").append(this.date).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("ExpiredObjectDeleteMarker:").append(this.expiredObjectDeleteMarker).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public static class NoncurrentVersionExpiration {
        public int noncurrentDays;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{NoncurrentVersionExpiration:\n");
            stringBuilder.append("NoncurrentDays:").append(this.noncurrentDays).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public static class NoncurrentVersionTransition {
        public int noncurrentDays;
        public String storageClass;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{NoncurrentVersionTransition:\n");
            stringBuilder.append("NoncurrentDays:").append(this.noncurrentDays).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("StorageClass:").append(this.storageClass).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    public static class AbortIncompleteMultiUpload {
        public int daysAfterInitiation;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{AbortIncompleteMultiUpload:\n");
            stringBuilder.append("DaysAfterInitiation:").append(this.daysAfterInitiation).append(IOUtils.LINE_SEPARATOR_UNIX);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }
}
